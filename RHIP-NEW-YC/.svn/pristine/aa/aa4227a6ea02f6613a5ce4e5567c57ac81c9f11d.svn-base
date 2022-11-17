package com.founder.rhip.mhm.service;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.OP;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.entity.clinic.InpatientInfo;
import com.founder.rhip.ehr.entity.management.mhm.*;
import com.founder.rhip.ehr.repository.clinic.IInpatientInfoDao;
import com.founder.rhip.ehr.repository.management.mhm.*;
import com.founder.rhip.ehr.service.personal.IPlatformService;
import com.founder.rhip.mdm.app.IOrganizationApp;
import com.founder.rhip.mhm.common.MhmEvents;
import com.founder.rhip.mhm.common.MhmStatus;
import com.founder.rhip.scheduling.core.Task;
import com.founder.rhip.scheduling.core.TaskBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: chen_haibing
 * Date: 12/4/13
 * Time: 3:01 PM
 * To change this template use File | Settings | File Templates.
 */
@Service("inPatientSyncService")
@TaskBean(description = "精神卫生出院信息同步")
public class InPatientSyncService implements Task {

    @Autowired
    IPlatformService platformService;
    @Autowired
    private IOrganizationApp organizationApp;

    @Autowired
    private IInpatientInfoDao inpatientInfoDao;

    @Autowired
    private IMhmStatusInfoDao mhmStatusInfoDao;

    @Autowired
    private IMhmEventInfoDao mhmEventInfoDao;

    @Autowired
    private IMhmBasicsInfoDao mhmBasicsInfoDao;

    @Autowired
    private IMhmPathHistoryDao mhmPathHistoryDao;

    @Autowired
    private IMhmInhospitalDao mhmInhospitalDao;

    @Autowired
    private IMhmDiagnosisDao mhmDiagnosisDao;

    Logger loggger = LoggerFactory.getLogger(this.getClass());

    public void run(Map<String, Object> data){
        Criteria criteria = new Criteria();
        DateUtil.getCriteriaByDateRange(criteria, "I.UPDATE_DATE", new Date(), new Date());
//        criteria.add("I.EHR_ID", "S.EHR_ID");
        criteria.add("S.ICD_CODE", OP.FLIKE, "F");//精神卫生住院

        List<InpatientInfo> inpatientInfos = inpatientInfoDao.getFList(criteria);
        for(InpatientInfo inpatientInfo : inpatientInfos){
            MhmStatusInfo mhmStatusInfo = new MhmStatusInfo();
            Long personId = inpatientInfo.getPersonId();
            mhmStatusInfo = mhmStatusInfoDao.get(new Criteria("PERSON_ID", personId));
            Long statusId = -1L;
            if(ObjectUtil.isNotEmpty(mhmStatusInfo)){
                statusId = mhmStatusInfo.getId();
            }else {
                mhmStatusInfo = new MhmStatusInfo();
                mhmStatusInfo.setPersonId(personId);
                mhmStatusInfo.setPatientResource("1"); //出院
                mhmStatusInfo.setStatus(MhmStatus.VERIFY_CHECK.getValue());//复核确诊
                mhmStatusInfo.setIsDelete(0);
                mhmStatusInfo.setLogoff(0);
                statusId = mhmStatusInfoDao.generatedKey(mhmStatusInfo, "id", null).longValue();
            }

            MhmEventInfo mhmEventInfo = new MhmEventInfo();
            mhmEventInfo.setStatusId(statusId);
            mhmEventInfo.setEventType(MhmEvents.I_DISCHARGED.getValue());
            mhmEventInfo.setIsDelete(0);
            Long eventId = mhmEventInfoDao.generatedKey(mhmEventInfo, "id", null).longValue();

            MhmBasicsInfo basicsInfo = new MhmBasicsInfo();
            basicsInfo.setEventId(eventId);
            basicsInfo.setName(inpatientInfo.getName());
            basicsInfo.setGender(inpatientInfo.getGender());
            basicsInfo.setBirthdate(inpatientInfo.getBirthday());
            basicsInfo.setMarriage(inpatientInfo.getMarriage());
            basicsInfo.setPatientResource("1"); //出院
            mhmBasicsInfoDao.insert(basicsInfo);

            MhmPathHistory pathHistory = new MhmPathHistory();
            pathHistory.setEventId(eventId);
            pathHistory.setFirstDiseaseDate(inpatientInfo.getPathogenesisDate());   //发病日期时间
            mhmPathHistoryDao.insert(pathHistory);

            MhmInhospital mhmInhospital = new MhmInhospital();
            mhmInhospital.setEventId(eventId);
            mhmInhospital.setInhospitalDate(inpatientInfo.getInhosDate());  //入院日期时间
            mhmInhospital.setInpatientRecordNo(inpatientInfo.getAdmissionNo());//住院号
            mhmInhospital.setInpatientEffect(inpatientInfo.getTreatmentResultsCode());//治疗结果代码
            mhmInhospital.setTreatingPhysician(inpatientInfo.getAttendingPhysicianNo());//主治医师工号
            mhmInhospital.setDischargeDate(inpatientInfo.getOutHospitalDate());//出院日期
            mhmInhospitalDao.insert(mhmInhospital);

            MhmDiagnosis mhmDiagnosis = new MhmDiagnosis();
            mhmDiagnosis.setEventId(eventId);
            mhmDiagnosis.setDiagnosisContent(inpatientInfo.getIcdCode());
            mhmDiagnosisDao.insert(mhmDiagnosis);
        }
    }
}
