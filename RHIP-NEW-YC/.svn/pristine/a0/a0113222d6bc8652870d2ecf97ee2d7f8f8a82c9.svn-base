package com.founder.rhip.portal.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.OP;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.service.AbstractService;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.common.EHRConstants;
import com.founder.rhip.ehr.common.ReserveStauts;
import com.founder.rhip.ehr.entity.portal.ReserveRegister;
import com.founder.rhip.ehr.entity.portal.StopDoctor;
import com.founder.rhip.ehr.repository.portal.IHospitalInfoDao;
import com.founder.rhip.ehr.repository.portal.IReserveRegisterDao;
import com.founder.rhip.ehr.repository.portal.IStopDoctorInfoDao;
import com.founder.rhip.scheduling.core.Task;
import com.founder.rhip.scheduling.core.TaskBean;

/**
 * Created with IntelliJ IDEA. User: zheng_dandan Date: 13-6-19 Time: 上午11:03 To
 * change this template use File | Settings | File Templates.
 */

@Service("stopDoctorService")
@TaskBean(description = "处理医生停诊过期", cron = "0 0 23 * * ?")
public class StopDoctorServiceImpl extends AbstractService implements IStopDoctorService, Task {

	@Autowired
	private IStopDoctorInfoDao stopDoctorInfoDao;

	@Autowired
	private IHospitalInfoDao hospitalInfoDao;

	@Resource(name = "reserveService")
	private IReserveService reserveService;

	@Autowired
	private IReserveRegisterDao reserveRegisterDao;

	@Override
	public PageList<StopDoctor> getList(Page page, Criteria criteria) {
		return stopDoctorInfoDao.getList(page, criteria);
	}

	@Override
	public PageList<ReserveRegister> getUnReserveRegister(StopDoctor stopDoctor, Page page) {
		Criteria criteria = new Criteria();
		criteria.add("DOCTOR_SN", stopDoctor.getDoctorSn());
		criteria.add("DEPT_SN", stopDoctor.getDeptSn());
		criteria.add("HOSPITAL_CODE", stopDoctor.getHospitalCode());
		DateUtil.getCriteriaByDateRange(criteria, "REQUEST_DATE", stopDoctor.getStartDate(), stopDoctor.getEndDate());
		criteria.add("RESERVER_STAUTS", ReserveStauts.SWDZ.getStauts());
		PageList<ReserveRegister> reserveRegisters = reserveService.getReserveRegister(criteria, page);
		return reserveRegisters;
	}

	private List<ReserveRegister> getStopDoctorReserveRegister(StopDoctor stopDoctor) {
		Criteria criteria = new Criteria();
		criteria.add("DOCTOR_SN", stopDoctor.getDoctorSn());
		criteria.add("DEPT_SN", stopDoctor.getDeptSn());
		criteria.add("HOSPITAL_CODE", stopDoctor.getHospitalCode());
		DateUtil.getCriteriaByDateRange(criteria, "REQUEST_DATE", stopDoctor.getStartDate(), stopDoctor.getEndDate());
		criteria.add("RESERVER_STAUTS", ReserveStauts.SWDZ.getStauts());
		List<ReserveRegister> reserveRegisters = reserveService.getReserveRegisters(criteria);
		return reserveRegisters;
	}

	@Override
	public String processUnResReg(StopDoctor stopDoctor, String type) {
		List<ReserveRegister> reserveRegisters = getStopDoctorReserveRegister(stopDoctor);

		/**
		 * 第一次点停诊时，如过有已预约该医生的患者，则返回
		 * */
		if ("1".equals(type)) {
			if (ObjectUtil.isNotEmpty(reserveRegisters)) {
				return EHRConstants.STOP_HAVE;
			}
		}

		if (ObjectUtil.isNotEmpty(reserveRegisters)) {
			for (int i = 0; i < reserveRegisters.size(); i++) {
				ReserveRegister rt = reserveRegisters.get(i);
				String reserveStauts = rt.getReserverStauts();
				if (!reserveStauts.equals("05")) {
					rt.setReserverStauts("05");
					reserveRegisterDao.update(rt);
				}
			}
		}

		StopDoctor sD = new StopDoctor();
		sD.setDoctorSn(stopDoctor.getDoctorSn());
		sD.setDeptSn(stopDoctor.getDeptSn());
		sD.setHospitalCode(stopDoctor.getHospitalCode());
		sD.setStartDate(stopDoctor.getStartDate());
		sD.setEndDate(stopDoctor.getEndDate());
		sD.setStopingStatus("1"); // 停诊状态 0表示未停诊 1表示停诊"

		List<StopDoctor> list = getStopList(stopDoctor);
		if (ObjectUtil.isNotEmpty(list)) {
			return EHRConstants.STOP_REPEAT;
		}
		stopDoctorInfoDao.insert(sD);

		return EHRConstants.STOP_OK;
	}

	@Override
	public List<StopDoctor> getStopList(StopDoctor stopDoctor) {
		Criteria criteria = new Criteria("hospitalCode", stopDoctor.getHospitalCode());
		criteria.add("deptSn", stopDoctor.getDeptSn());
		criteria.add("doctorSn", stopDoctor.getDoctorSn());
		criteria.add("stopingStatus", "1");
		List<StopDoctor> lstopDoctor = getStopDoctorDetails(criteria);
		return lstopDoctor;
	}

	@Override
	public StopDoctor getStopDoctor(Criteria criteria) {
		return stopDoctorInfoDao.get(criteria);
	}

	@Override
	public String cancelStop(Long cancelId) {
		StopDoctor stopDoctor = stopDoctorInfoDao.get(cancelId);
		if (ObjectUtil.isNullOrEmpty(stopDoctor)) {
			return EHRConstants.CANCEL_FAIL;
		}
		stopDoctor.setStopingStatus("0"); // 停诊状态 0表示未停诊 1表示停诊"
		stopDoctorInfoDao.update(stopDoctor);
		return EHRConstants.CANCEL_OK;
	}

	@Override
	public List<StopDoctor> getStopDoctorDetails(Criteria criteria) {
		List<StopDoctor> results = new ArrayList<StopDoctor>();
		results = stopDoctorInfoDao.getList(criteria);
		return results;
	}

	@Override
	// @Scheduled(cron = "0 0 23 * * ?")
	public void processOverdue() {
		Criteria criteria = new Criteria();
		criteria.add("STOPING_STATUS", OP.NE, "2");
		List<StopDoctor> sds = stopDoctorInfoDao.getList(criteria); // 需要修改，添加不早于当时查询条件
		for (StopDoctor stopDoctor : sds) {
			Date eda = stopDoctor.getEndDate();
			if (eda.equals(new Date()) || eda.before(new Date())) {
				stopDoctor.setStopingStatus("2");
				stopDoctorInfoDao.update(stopDoctor);
			}
		}
	}

	@Override
	public void run(Map<String, Object> data) {
		processOverdue();
	}
}
