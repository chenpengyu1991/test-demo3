package com.founder.rhip.mhm.service;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.OP;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.NumberUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.ehr.entity.clinic.EHRHealthEvent;
import com.founder.rhip.ehr.entity.management.mhm.*;
import com.founder.rhip.ehr.repository.clinic.IEHRHealthEventDao;
import com.founder.rhip.ehr.repository.clinic.IOutpatientInfoDao;
import com.founder.rhip.ehr.repository.management.mhm.*;
import com.founder.rhip.ehr.service.personal.IPlatformService;
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
@Service("outPatientSyncService")
@TaskBean(description = "精神卫生门诊信息同步")
public class OutPatientSyncService implements Task {

    @Autowired
    IPlatformService platformService;
    @Autowired
    private IEHRHealthEventDao ehrHealthEventDao;

    @Autowired
    private IOutpatientInfoDao outpatientInfoDao;

    @Autowired
    private IMhmBasicsInfoDao mhmBasicsInfoDao;

    @Autowired
    private IMhmStatusInfoDao mhmStatusInfoDao;

    @Autowired
    private IMhmEventInfoDao mhmEventInfoDao;

    @Autowired
    private IMhmOutpatientRecordDao mhmOutpatientRecordDao;

    @Autowired
    private IMhmDiagnosisDao mhmDiagnosisDao;

    Logger loggger = LoggerFactory.getLogger(this.getClass());

    public void run(Map<String, Object> data){
        Criteria criteria = new Criteria();
        DateUtil.getCriteriaByDateRange(criteria, "UPDATE_DATE", new Date(), new Date());
//        criteria.add("I.EHR_ID", "S.EHR_ID");
        criteria.add("DISEASE_CODE", OP.FLIKE, "F");//精神卫生
        criteria.add("EHR_TYPE",  OP.EQ, "1");//精神卫生(门诊记录)

        List<EHRHealthEvent> ehrHealthEvents = ehrHealthEventDao.getList(criteria);
        for(EHRHealthEvent ehrHealthEvent : ehrHealthEvents){
            MhmStatusInfo mhmStatusInfo = new MhmStatusInfo();
            Long personId = ehrHealthEvent.getPersonId();
            mhmStatusInfo = mhmStatusInfoDao.get(new Criteria("PERSON_ID", personId));
            Long statusId = -1L;
            if(ObjectUtil.isNotEmpty(mhmStatusInfo)){
                statusId = mhmStatusInfo.getId();
            }else {
                mhmStatusInfo = new MhmStatusInfo();
                mhmStatusInfo.setPersonId(personId);
                mhmStatusInfo.setPatientResource("2"); //门诊
                mhmStatusInfo.setStatus(MhmStatus.VERIFY_CHECK.getValue());//复核确诊
                mhmStatusInfo.setIsDelete(0);
                mhmStatusInfo.setLogoff(0);
                statusId = mhmStatusInfoDao.generatedKey(mhmStatusInfo, "id", null).longValue();
            }

            MhmEventInfo mhmEventInfo = new MhmEventInfo();
            mhmEventInfo.setStatusId(statusId);
            mhmEventInfo.setEventType(MhmEvents.I_OUTPATIENT.getValue());
            mhmEventInfo.setIsDelete(0);
            Long eventId = mhmEventInfoDao.generatedKey(mhmEventInfo, "id", null).longValue();

            MhmBasicsInfo mhmBasicsInfo = new MhmBasicsInfo();
            mhmBasicsInfo.setEventId(eventId);
            mhmBasicsInfo.setName(ehrHealthEvent.getName());
            mhmBasicsInfo.setGender(ehrHealthEvent.getGender());
            if(StringUtil.isNotEmpty(ehrHealthEvent.getAge())){
                mhmBasicsInfo.setAge(Integer.parseInt(NumberUtil.extractNumber(ehrHealthEvent.getAge())));
            }
            mhmBasicsInfoDao.insert(mhmBasicsInfo);

            MhmDiagnosis mhmDiagnosis = new MhmDiagnosis();
            mhmDiagnosis.setEventId(eventId);
            mhmDiagnosis.setDiagnosisContent(ehrHealthEvent.getDiseaseCode());
            mhmDiagnosisDao.insert(mhmDiagnosis);

            MhmOutpatientRecord outpatientRecord = new MhmOutpatientRecord();
            outpatientRecord.setEventId(eventId);
            outpatientRecord.setOutpatientDt(ehrHealthEvent.getClinicDate());
            outpatientRecord.setOutpatientOrgan(ehrHealthEvent.getClinicOrganName());
            outpatientRecord.setOutpatientNo(ehrHealthEvent.getEhrId());
            outpatientRecord.setDiagnosisResult(ehrHealthEvent.getDiseaseName());
            outpatientRecord.setDiagnosisDoctor(ehrHealthEvent.getUpdateName());
            outpatientRecord.setStatusId(statusId);
            mhmOutpatientRecordDao.insert(outpatientRecord);
        }
    }
}
