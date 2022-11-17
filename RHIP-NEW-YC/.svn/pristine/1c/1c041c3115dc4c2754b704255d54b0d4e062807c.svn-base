package com.founder.rhip.ph.service.oh;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Order;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.beans.Parameters;
import com.founder.fasf.service.AbstractService;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.entity.control.oh.OhCautionAlarm;
import com.founder.rhip.ehr.entity.control.oh.OhDoseDetection;
import com.founder.rhip.ehr.entity.control.oh.OhHospitalInfo;
import com.founder.rhip.ehr.entity.control.oh.OhMachineRoom;
import com.founder.rhip.ehr.entity.control.oh.OhPersonalDose;
import com.founder.rhip.ehr.entity.control.oh.OhProtectiveEquipment;
import com.founder.rhip.ehr.entity.control.oh.OhRadiologicalApparatus;
import com.founder.rhip.ehr.entity.control.oh.OhRadiologicalPostion;
import com.founder.rhip.ehr.entity.control.oh.OhTraining;
import com.founder.rhip.ehr.entity.control.oh.OhWorkload;
import com.founder.rhip.ehr.repository.oh.IOhCautionAlarmDao;
import com.founder.rhip.ehr.repository.oh.IOhDoseDetectionDao;
import com.founder.rhip.ehr.repository.oh.IOhHospitalInfoDao;
import com.founder.rhip.ehr.repository.oh.IOhMachineRoomDao;
import com.founder.rhip.ehr.repository.oh.IOhPersonalDoseDao;
import com.founder.rhip.ehr.repository.oh.IOhProtectiveEquipmentDao;
import com.founder.rhip.ehr.repository.oh.IOhRadiologicalApparatusDao;
import com.founder.rhip.ehr.repository.oh.IOhRadiologicalPostionDao;
import com.founder.rhip.ehr.repository.oh.IOhTrainingDao;
import com.founder.rhip.ehr.repository.oh.IOhWorkloadDao;

@Service("radiologicalProtectionReportService")
public class RadiologicalProtectionReportServiceImpl extends AbstractService
		implements IRadiologicalProtectionReportService {

	@Resource(name = "ohHospitalInfoDao")
	private IOhHospitalInfoDao ohHospitalInfoDao;

	@Resource(name = "ohRadiologicalApparatusDao")
	private IOhRadiologicalApparatusDao ohRadiologicalApparatusDao;

	@Resource(name = "ohRadiologicalPostionDao")
	private IOhRadiologicalPostionDao ohRadiologicalPostionDao;

	@Resource(name = "ohCautionAlarmDao")
	private IOhCautionAlarmDao ohCautionAlarmDao;

	@Resource(name = "ohMachineRoomDao")
	private IOhMachineRoomDao ohMachineRoomDao;

	@Resource(name = "ohProtectiveEquipmentDao")
	private IOhProtectiveEquipmentDao ohProtectiveEquipmentDao;

	@Resource(name = "ohPersonalDoseDao")
	private IOhPersonalDoseDao ohPersonalDoseDao;

	@Resource(name = "ohDoseDetectionDao")
	private IOhDoseDetectionDao ohDoseDetectionDao;

	@Resource(name = "ohWorkloadDao")
	private IOhWorkloadDao ohWorkloadDao;

	@Resource(name = "ohTrainingDao")
	private IOhTrainingDao ohTrainingDao;

	// 医院基本情况=====================================================================
	@Override
	public PageList<OhHospitalInfo> searchOhHospitalInfoList(Page page,
			Criteria criteria) {
		criteria.add("IS_DELETE", "0");
		Order order = new Order("VERIFY_STATE",false);
		order.desc("UPDATE_TIME");
		return ohHospitalInfoDao.getPageList(page, criteria, order);
	}

	@Override
	public OhHospitalInfo searchOhHospitalInfo(Criteria criteria) {
		criteria.add("IS_DELETE", "0");
		return ohHospitalInfoDao.getList(criteria).get(0);
	}

	@Override
	public int addOhHospitalInfo(OhHospitalInfo ohHospitalInfo) {
		return ohHospitalInfoDao.insert(ohHospitalInfo);
	}

	@Override
	public int deleteOhHospitalInfo(String isDelete, Criteria criteria) {
		Parameters params = new Parameters();
		params.add("IS_DELETE", isDelete);
		return ohHospitalInfoDao.update(params, criteria);
	}

	@Override
	public int updateOhHospitalInfo(OhHospitalInfo ohHospitalInfo) {
		return ohHospitalInfoDao.update(ohHospitalInfo);
	}

	@Override
	public int checkOhHospitalInfo(String verifier, String verifyState,
			Criteria criteria) {
		Parameters params = new Parameters();
		params.add("VERIFY_DATE", new Date());
		params.add("VERIFIER", verifier);
		params.add("VERIFY_STATE", verifyState);
		return ohHospitalInfoDao.update(params, criteria);
	}

	// 医院放射设备情况=================================================================
	@Override
	public PageList<OhRadiologicalApparatus> searchOhRadiologicalApparatusList(
			Page page, Criteria criteria) {
		criteria.add("IS_DELETE", "0");
		return ohRadiologicalApparatusDao.getPageList(page, criteria);
	}

	@Override
	public OhRadiologicalApparatus searchOhRadiologicalApparatus(
			Criteria criteria) {
		criteria.add("IS_DELETE", "0");
		return ohRadiologicalApparatusDao.getList(criteria).get(0);
	}

	@Override
	public int addOhRadiologicalApparatus(
			OhRadiologicalApparatus ohRadiologicalApparatus) {
		return ohRadiologicalApparatusDao.insert(ohRadiologicalApparatus);
	}

	@Override
	public int deleteOhRadiologicalApparatus(String isDelete, Criteria criteria) {
		Parameters params = new Parameters();
		params.add("IS_DELETE", isDelete);
		return ohRadiologicalApparatusDao.update(params, criteria);
	}

	@Override
	public int updateOhRadiologicalApparatus(
			OhRadiologicalApparatus ohRadiologicalApparatus) {
		return ohRadiologicalApparatusDao.update(ohRadiologicalApparatus);
	}

	// 放射防护情况
	@Override
	public OhRadiologicalPostion searchOhRadiologicalPostion(Criteria criteria) {
		criteria.add("IS_DELETE", "0");
		List<OhRadiologicalPostion> ohRadiologicalPostionList = ohRadiologicalPostionDao
				.getList(criteria);
		if (ObjectUtil.isNotEmpty(ohRadiologicalPostionList))
			return ohRadiologicalPostionDao.getList(criteria).get(0);
		else
			return null;
	}

	@Override
	public int addOhRadiologicalPostion(
			OhRadiologicalPostion ohRadiologicalPostion) {
		return ohRadiologicalPostionDao.insert(ohRadiologicalPostion);
	}

	@Override
	public int updateOhRadiologicalPostion(
			OhRadiologicalPostion ohRadiologicalPostion) {
		return ohRadiologicalPostionDao.update(ohRadiologicalPostion);
	}

	@Override
	public PageList<OhCautionAlarm> searchOhCautionAlarmList(Page page,
			Criteria criteria) {
		criteria.add("IS_DELETE", "0");
		return ohCautionAlarmDao.getPageList(page, criteria);
	}

	@Override
	public OhCautionAlarm searchOhCautionAlarm(Criteria criteria) {
		criteria.add("IS_DELETE", "0");
		return ohCautionAlarmDao.getList(criteria).get(0);
	}

	@Override
	public int addOhCautionAlarm(OhCautionAlarm ohCautionAlarm) {
		return ohCautionAlarmDao.insert(ohCautionAlarm);
	}

	@Override
	public int deleteOhCautionAlarm(String isDelete, Criteria criteria) {
		Parameters params = new Parameters();
		params.add("IS_DELETE", isDelete);
		return ohCautionAlarmDao.update(params, criteria);
	}

	@Override
	public int updateOhCautionAlarm(OhCautionAlarm ohCautionAlarm) {
		return ohCautionAlarmDao.update(ohCautionAlarm);
	}

	@Override
	public Double getSumArea(Criteria criteria) {
		criteria.add("IS_DELETE", "0");
		return ohMachineRoomDao.getSum(criteria, "AREA", Double.class);
	}

	@Override
	public Double getMachineRoomArea(Criteria criteria) {
		criteria.add("IS_DELETE", "0");
		criteria.add("TYPE", "1");
		return ohMachineRoomDao.getSum(criteria, "AREA", Double.class);
	}

	@Override
	public Double getOtherArea(Criteria criteria) {
		criteria.add("IS_DELETE", "0");
		criteria.add("TYPE", "99");// 以前2表示其他场所
		return ohMachineRoomDao.getSum(criteria, "AREA", Double.class);
	}

	@Override
	public PageList<OhMachineRoom> searchOhMachineRoomList(Page page,
			Criteria criteria) {
		criteria.add("IS_DELETE", "0");
		return ohMachineRoomDao.getPageList(page, criteria);
	}

	@Override
	public OhMachineRoom searchOhMachineRoom(Criteria criteria) {
		return ohMachineRoomDao.getList(criteria).get(0);
	}

	@Override
	public int addOhMachineRoom(OhMachineRoom ohMachineRoom) {
		return ohMachineRoomDao.insert(ohMachineRoom);
	}

	@Override
	public int deleteOhMachineRoom(String isDelete, Criteria criteria) {
		Parameters params = new Parameters();
		params.add("IS_DELETE", isDelete);
		return ohMachineRoomDao.update(params, criteria);
	}

	@Override
	public int updateOhMachineRoom(OhMachineRoom ohMachineRoom) {
		return ohMachineRoomDao.update(ohMachineRoom);
	}

	// 个人防护用品
	@Override
	public PageList<OhProtectiveEquipment> searchOhProtectiveEquipmentList(
			Page page, Criteria criteria) {
		criteria.add("IS_DELETE", "0");
		return ohProtectiveEquipmentDao.getPageList(page, criteria);
	}

	@Override
	public OhProtectiveEquipment searchOhProtectiveEquipment(Criteria criteria) {
		criteria.add("IS_DELETE", "0");
		return ohProtectiveEquipmentDao.getList(criteria).get(0);
	}

	@Override
	public int addOhProtectiveEquipment(
			OhProtectiveEquipment ohProtectiveEquipment) {
		return ohProtectiveEquipmentDao.insert(ohProtectiveEquipment);
	}

	@Override
	public int deleteOhProtectiveEquipment(String isDelete, Criteria criteria) {
		Parameters param = new Parameters();
		param.add("IS_DELETE", isDelete);
		return ohProtectiveEquipmentDao.update(param, criteria);
	}

	@Override
	public int updateOhProtectiveEquipment(
			OhProtectiveEquipment ohProtectiveEquipment) {
		return ohProtectiveEquipmentDao.update(ohProtectiveEquipment);
	}

	// 个人剂量档案=======================================================================
	@Override
	public PageList<OhPersonalDose> searchOhPersonalDoseList(Page page,
			Criteria criteria) {
		criteria.add("IS_DELETE", "0");
		return ohPersonalDoseDao.getPageList(page, criteria);
	}

	@Override
	public OhPersonalDose searchOhPersonalDose(Criteria criteria) {
		return ohPersonalDoseDao.getList(criteria).get(0);
	}

	@Override
	public int addOhPersonalDose(OhPersonalDose ohPersonalDose) {
		return ohPersonalDoseDao.insert(ohPersonalDose);
	}

	@Override
	public int deleteOhPersonalDose(String isDelete, Criteria criteria) {
		Parameters param = new Parameters();
		param.add("IS_DELETE", isDelete);
		return ohPersonalDoseDao.update(param, criteria);
	}

	@Override
	public int updateOhPersonalDose(OhPersonalDose ohPersonalDose) {
		return ohPersonalDoseDao.update(ohPersonalDose);
	}

	@Override
	public PageList<OhDoseDetection> searchOhDoseDetectionList(Page page,
			Criteria criteria) {
		criteria.add("IS_DELETE", "0");
		return ohDoseDetectionDao.getPageList(page, criteria);
	}

	@Override
	public OhDoseDetection searchOhDoseDetection(Criteria criteria) {
		criteria.add("IS_DELETE", "0");
		return ohDoseDetectionDao.getList(criteria).get(0);
	}

	@Override
	public int addOhDoseDetection(OhDoseDetection ohDoseDetection) {
		return ohDoseDetectionDao.insert(ohDoseDetection);
	}

	@Override
	public int deleteOhDoseDetection(String isDelete, Criteria criteria) {
		Parameters param = new Parameters();
		param.add("IS_DELETE", isDelete);
		return ohDoseDetectionDao.update(param, criteria);
	}

	@Override
	public int updateOhDoseDetection(OhDoseDetection ohDoseDetection) {
		return ohDoseDetectionDao.update(ohDoseDetection);
	}

	@Override
	public PageList<OhWorkload> searchOhWorkload(Page page, Criteria criteria) {
		criteria.add("IS_DELETE", "0");
		return ohWorkloadDao.getPageList(page, criteria);
	}

	@Override
	public OhWorkload searchOhWorkload(Criteria criteria) {
		criteria.add("IS_DELETE", "0");
		return ohWorkloadDao.getList(criteria).get(0);
	}

	@Override
	public int addOhWorkload(OhWorkload ohWorkload) {
		return ohWorkloadDao.insert(ohWorkload);
	}

	@Override
	public int deleteOhWorkload(String isDelete, Criteria criteria) {
		Parameters param = new Parameters();
		param.add("IS_DELETE", isDelete);
		return ohWorkloadDao.update(param, criteria);
	}

	@Override
	public int updateOhWorkload(OhWorkload ohWorkload) {
		return ohWorkloadDao.update(ohWorkload);
	}

	@Override
	public PageList<OhTraining> searchOhTraining(Page page, Criteria criteria) {
		criteria.add("IS_DELETE", "0");
		return ohTrainingDao.getPageList(page, criteria);
	}

	@Override
	public OhTraining searchOhTraining(Criteria criteria) {
		criteria.add("IS_DELETE", "0");
		return ohTrainingDao.getList(criteria).get(0);
	}

	@Override
	public int addOhTraining(OhTraining ohTraining) {
		return ohTrainingDao.insert(ohTraining);
	}

	@Override
	public int deleteOhTraining(String isDelete, Criteria criteria) {
		Parameters param = new Parameters();
		param.add("IS_DELETE", isDelete);
		return ohTrainingDao.update(param, criteria);
	}

	@Override
	public int updateOhTraining(OhTraining ohTraining) {
		return ohTrainingDao.update(ohTraining);
	}

}
