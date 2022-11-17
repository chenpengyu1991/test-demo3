package com.founder.rhip.fds.service;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.founder.fasf.beans.ConvertingWrapDynaBean;
import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Order;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.ehr.entity.basic.PersonInfo;
import com.founder.rhip.ehr.entity.basic.User;
import com.founder.rhip.ehr.entity.management.DmHypertensionFollowup;
import com.founder.rhip.ehr.repository.basic.IPersonInfoDao;
import com.founder.rhip.fds.common.FDSConstants;
import com.founder.rhip.fds.entity.Doctor;
import com.founder.rhip.fds.entity.ServiceRecord;
import com.founder.rhip.fds.entity.Sign;
import com.founder.rhip.fds.entity.SignServicePackage;
import com.founder.rhip.fds.repository.IDoctorDao;
import com.founder.rhip.fds.repository.IServiceRecordDao;
import com.founder.rhip.fds.repository.ISignDao;
import com.founder.rhip.fds.repository.ISignServiceItemDao;
import com.founder.rhip.fds.repository.ISignServicePackageDao;


@Service("serviceRecordService")
public class ServiceRecordServiceImpl implements ServiceRecordService {
    protected Logger logger = LoggerFactory.getLogger(getClass());

    @Resource(name = "serviceRecordDao")
    private IServiceRecordDao serviceRecordDao;

    @Resource(name = "signServiceItemDao")
    private ISignServiceItemDao signServiceItemDao;
    
    @Resource(name = "personInfoDao")
    private IPersonInfoDao personInfoDao;
    
    @Resource(name = "signDao")
    private ISignDao signDao;
    
    @Resource(name = "doctorDao")
    private IDoctorDao doctorDao;
    
    @Resource(name = "signServicePackageDao")
    private ISignServicePackageDao signServicePackageDao;

    @Override
    public int addServiceRecord(ServiceRecord serviceRecord, String currentUser) {
        Date currentDate = new Date();
        serviceRecord.setCreateUser(currentUser);
        serviceRecord.setCreateDate(currentDate);
        serviceRecord.setUpdateUser(currentUser);
        serviceRecord.setUpdateDate(currentDate);
        serviceRecord.setValid(FDSConstants.VALID_1.toString());
        serviceRecord.setId(serviceRecordDao.getSequenceNextVal("SEQ_SERVICE_RECORD", Long.class));
        //服务项目的基本信息
        int cnt = serviceRecordDao.insert(serviceRecord);

        //每增加一条服务记录， 给签约的服务项目计数一次；
        if(StringUtil.isNotEmpty(serviceRecord.getServicePackageCode())) {
            signServiceItemDao.countActualTimes(serviceRecord.getSignId(),serviceRecord.getServicePackageCode(),serviceRecord.getServiceItemCode());
        }

        return cnt;
    }

    @Override
    public ServiceRecord getServiceRecord(Criteria criteria) {
        return serviceRecordDao.get(criteria);
    }

    @Override
    public PageList<ServiceRecord> getList(Criteria criteria, Page page, Order order) {
        return serviceRecordDao.getPageList(page,criteria,order);
    }

	@Override
	public void synchronize(DmHypertensionFollowup dmHypertensionFollowup, User user) {
		Long personId = null;
		PersonInfo personInfo = null;
		Sign sign = null;
		Doctor doctor = null;
		if (ObjectUtil.isNullOrEmpty(dmHypertensionFollowup) 
				|| ObjectUtil.isNullOrEmpty(personId = dmHypertensionFollowup.getPersonId())
				|| ObjectUtil.isNullOrEmpty(personInfo = personInfoDao.get(personId)) 
				|| personInfo.getSignFlag() != 1
				|| ObjectUtil.isNullOrEmpty(personInfo.getIdcard())
				|| ObjectUtil.isNullOrEmpty(sign = signDao.get(new Criteria("personIdcard", personInfo.getIdcard())))
				|| ObjectUtil.isNullOrEmpty(user)
				|| ObjectUtil.isNullOrEmpty(doctor = doctorDao.get(new Criteria("idCard", user.getIdentityCard())))) {
			return;
		}
		List<SignServicePackage> signServicePackageList = signServicePackageDao.getList(new Criteria("signId", sign.getId()));
		boolean flag = false;
		for (SignServicePackage signServicePackage : signServicePackageList) {
			// 高血压包
			if (StringUtils.equals(signServicePackage.getServicePackageCode(), "131200002")) {
				flag = true;
			}
		}
		//TODO:操作医生非签约团队成员是否同步？
		if (flag) {
			// 高血压包服务项目-》测量血压
			ServiceRecord serviceRecord = new ServiceRecord();
			serviceRecord.setSignId(sign.getId());
			serviceRecord.setServicePackageCode("131200002");
			serviceRecord.setServicePackageName("高血压包");
			serviceRecord.setServiceItemCode("GXY001");
			serviceRecord.setPersonId(personInfo.getId());
			serviceRecord.setPersonName(personInfo.getName());
			serviceRecord.setPersonIdcard(personInfo.getIdcard());
			serviceRecord.setDoctorId(doctor.getId());
			serviceRecord.setDoctorIdcard(doctor.getIdCard());
			serviceRecord.setDoctorName(doctor.getName());
			serviceRecord.setOrganCode(sign.getOrganCode());
			serviceRecord.setTeamCode(sign.getTeamCode());
			serviceRecord.setServiceTime(dmHypertensionFollowup.getVisitDate());
			serviceRecord.setServiceType(dmHypertensionFollowup.getVisitWayCode());
			serviceRecord.setHbpDbp(String.valueOf(dmHypertensionFollowup.getDbp()));
			serviceRecord.setHbpSbp(String.valueOf(dmHypertensionFollowup.getSbp()));
			StringBuilder conclusionBuilder = new StringBuilder();
			conclusionBuilder.append("舒张压:").append(serviceRecord.getHbpDbp()).append("收缩压:").append(serviceRecord.getHbpSbp());
			serviceRecord.setConclusion(conclusionBuilder.toString());
			serviceRecord.setValid("1"); // 1：有效 2：无效
			serviceRecord.setCreateUser(user.getUserName());
			serviceRecord.setCreateDate(new Date());
			serviceRecord.setSource(2); // 1:家医平台2:区卫平台随访
		    serviceRecord.setId(serviceRecordDao.getSequenceNextVal("SEQ_SERVICE_RECORD", Long.class));
	        serviceRecordDao.insert(serviceRecord);

	        //每增加一条服务记录， 给签约的服务项目计数一次；
            signServiceItemDao.countActualTimes(serviceRecord.getSignId(),serviceRecord.getServicePackageCode(),serviceRecord.getServiceItemCode());
		}
	}

	@Override
	public void synchronize(ConvertingWrapDynaBean dynaBean, User user, int type) {
		if (ObjectUtil.isNullOrEmpty(dynaBean) 
				|| ObjectUtil.isNullOrEmpty(dynaBean.get("personId"))
				|| ObjectUtil.isNullOrEmpty(dynaBean.get("id"))
				|| ObjectUtil.isNullOrEmpty(user)
				|| (type != 1 && type != 2)) {
			return;
		}
		Long personId = Long.valueOf(String.valueOf(dynaBean.get("personId")));
		Long followUpId = Long.valueOf(String.valueOf(dynaBean.get("id")));
		PersonInfo personInfo = personInfoDao.get(personId);
		// 签约状态判断 1:已签约
		if (ObjectUtil.isNullOrEmpty(personInfo.getSignFlag()) || (1 != personInfo.getSignFlag())) {
			return;
		}
		Sign sign = signDao.get(new Criteria("personIdcard", personInfo.getIdcard())
				.add("rescindFlag", FDSConstants.RESCIND_FLAG_0) // 未解约
				.add("contractStatus", FDSConstants.CONTRACT_STATUS_1)); // 合约有效;
		Doctor doctor = doctorDao.get(new Criteria("idCard", user.getIdentityCard()));
		if (ObjectUtil.isNullOrEmpty(sign) || ObjectUtil.isNullOrEmpty(doctor)) {
			return;
		}
		List<SignServicePackage> signServicePackageList = signServicePackageDao.getList(new Criteria("signId", sign.getId()));
		boolean flag = false;
		if (type == 1) { // 高血压
			for (SignServicePackage signServicePackage : signServicePackageList) {
				if (StringUtils.equals(signServicePackage.getServicePackageCode(), "131200002")
						|| StringUtils.equals(signServicePackage.getServicePackageCode(), "131200003")) { // 高血压包编码、糖尿病编码
					flag = true;
				}
			}
		} else if (type == 2 ) { // 糖尿病
			for (SignServicePackage signServicePackage : signServicePackageList) {
				if (StringUtils.equals(signServicePackage.getServicePackageCode(), "131200003")) { // 糖尿病包编码
					flag = true;
				}
			}
		}
		if (flag) {
			ServiceRecord serviceRecord = new ServiceRecord();
			serviceRecord.setSignId(sign.getId());
			serviceRecord.setServicePackageCode(type == 1 ? "131200002" : "131200003");
			serviceRecord.setServicePackageName(type == 1 ? "高血压包" : "糖尿病包");
			serviceRecord.setServiceItemCode(type == 1 ? "GXY001" : "GXY002");
			serviceRecord.setPersonId(personInfo.getId());
			serviceRecord.setPersonName(personInfo.getName());
			serviceRecord.setPersonIdcard(personInfo.getIdcard());
			serviceRecord.setDoctorId(doctor.getId());
			serviceRecord.setDoctorIdcard(doctor.getIdCard());
			serviceRecord.setDoctorName(doctor.getName());
			serviceRecord.setOrganCode(sign.getOrganCode());
			serviceRecord.setTeamCode(sign.getTeamCode());
			serviceRecord.setServiceTime(ObjectUtil.isNullOrEmpty(dynaBean.get("visitDate")) ? null : (Date) dynaBean.get("visitDate"));
			serviceRecord.setServiceType(ObjectUtil.isNullOrEmpty(dynaBean.get("visitWayCode")) ? null : String.valueOf(dynaBean.get("visitWayCode")));
			StringBuilder conclusionBuilder = new StringBuilder();
			serviceRecord.setHbpDbp(ObjectUtil.isNullOrEmpty(dynaBean.get("dbp")) ? null : String.valueOf(dynaBean.get("dbp")));
			serviceRecord.setHbpSbp(ObjectUtil.isNullOrEmpty(dynaBean.get("sbp")) ? null : String.valueOf(dynaBean.get("sbp")));
			conclusionBuilder.append("舒张压:").append(serviceRecord.getHbpDbp()).append("mmHg ").append("收缩压:").append(serviceRecord.getHbpSbp()).append("mmHg ");
			if (type == 2) {
				serviceRecord.setDi(ObjectUtil.isNullOrEmpty(dynaBean.get("fpg")) ? null : String.valueOf(dynaBean.get("fpg")));
				conclusionBuilder.append("空腹血糖:").append(serviceRecord.getDi()).append("mmol/L");
			}
			serviceRecord.setConclusion(conclusionBuilder.toString());
			serviceRecord.setValid("1"); // 1：有效 2：无效
			serviceRecord.setCreateUser(user.getUserName());
			serviceRecord.setCreateDate(new Date());
			serviceRecord.setSource(2); // 1:家医平台2:区卫平台随访
			serviceRecord.setFollowUpId(followUpId); // 区域平台随访Id
		    serviceRecord.setId(serviceRecordDao.getSequenceNextVal("SEQ_SERVICE_RECORD", Long.class));
		    if (type == 1) {
		    	Criteria criteria = new Criteria("signId", sign.getId()).add("servicePackageCode", "131200002").add("serviceItemCode", "GXY001").add("followUpId", followUpId);
//		    	DateUtil.getCriteriaByDateRange(criteria, "serviceTime", serviceRecord.getServiceTime(), serviceRecord.getServiceTime());
		    	ServiceRecord sr = serviceRecordDao.get(criteria);
		    	if (ObjectUtil.isNullOrEmpty(sr)) {
		    		serviceRecordDao.insert(serviceRecord);
				} else {
					serviceRecord.setId(sr.getId());
					serviceRecord.setCreateDate(sr.getCreateDate());
					serviceRecord.setUpdateDate(new Date());
					serviceRecordDao.update(serviceRecord);
				}
			}
	        
	        if (type == 2) {
	        	Criteria criteria = new Criteria("signId", sign.getId()).add("servicePackageCode", "131200003").add("serviceItemCode", "GXY002").add("followUpId", followUpId);
//	        	DateUtil.getCriteriaByDateRange(criteria, "serviceTime", serviceRecord.getServiceTime(), serviceRecord.getServiceTime());
	        	ServiceRecord sr = serviceRecordDao.get(criteria);
	        	if (ObjectUtil.isNullOrEmpty(sr)) {
	        		serviceRecordDao.insert(serviceRecord);
	        		//每增加一条服务记录， 给签约的服务项目计数一次；
	        		signServiceItemDao.countActualTimes(serviceRecord.getSignId(),serviceRecord.getServicePackageCode(),serviceRecord.getServiceItemCode());
				} else {
					serviceRecord.setId(sr.getId());
					serviceRecord.setCreateDate(sr.getCreateDate());
					serviceRecord.setUpdateDate(new Date());
					serviceRecordDao.update(serviceRecord);
				}
			}
		}
	}


}
