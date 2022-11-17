package com.founder.rhip.portal.service;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Order;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.ehr.dto.ExamReportDTO;
import com.founder.rhip.ehr.entity.basic.PersonInfo;
import com.founder.rhip.ehr.entity.clinic.*;
import com.founder.rhip.ehr.repository.basic.IPersonInfoDao;
import com.founder.rhip.ehr.repository.clinic.IDrugUsageDao;
import com.founder.rhip.ehr.repository.clinic.IExamineDetailDao;
import com.founder.rhip.ehr.repository.clinic.IPatientbedStatusDao;
import com.founder.rhip.ehr.repository.clinic.IStudyEventDao;
import com.founder.rhip.ehr.service.IExamService;
import com.founder.rhip.ehr.service.IHealthExaminationService;
import com.founder.rhip.ehr.service.IInpatientDataService;
import com.founder.rhip.ehr.service.ta.IOutpatientInfoService;
import com.founder.rhip.mdm.entity.Department;
import com.founder.rhip.portal.dto.*;
import com.founder.rhip.portal.service.util.ValidateUtil;
import com.founder.rhip.portal.service.util.XmlWebserviceForUtil;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by f on 2016/12/6.
 */
@Service("msService")
public class MSServiceImpl implements IMSService {
    private static String FAIL = "0";
    private static String SUCCESS = "1";


    @Resource(name = "personInfoDao")
    private IPersonInfoDao personInfoDao;

    @Resource
    private IOutpatientInfoService outpatientInfoService;

    @Resource
    private IInpatientDataService inpatientDataService;

    @Resource
    private IHealthExaminationService healthExaminationService;

    @Resource
    private IExamService examService;

    @Autowired
    private IExamineDetailDao examineDetailDao;

    @Autowired
    private IStudyEventDao studyEventDao;

    @Autowired
    private IDrugUsageDao drugUsageDao;

    @Autowired
    private IPatientbedStatusDao patientbedStatusDao;

    @Override
    public String searchOutpatientInfo(QueryReserve queryReserve) {

        if (StringUtil.isNullOrEmpty(queryReserve.getEhrId())) {
            //验证身份证号是否为空
            if (StringUtil.isNullOrEmpty(queryReserve.getIdcard())) {
                return XmlWebserviceForUtil.returnResult(FAIL, "查不出该患者的体检信息！");
            }
            GetOutpatientInfoResponse getOutpatientInfoResponse = new GetOutpatientInfoResponse();
            try {
                //SQL语句拼接，查找对应BI_PERSON_INFO表中的ID
                Criteria criteriaPer = new Criteria();
                criteriaPer.add("idcard", queryReserve.getIdcard());
                PersonInfo personInfo = personInfoDao.get(criteriaPer);
                //判断是否可以根据身份证号在personinfo表中查出id
                if (StringUtil.isNullOrEmpty(String.valueOf(personInfo.getId()))) {
                    return XmlWebserviceForUtil.returnResult(FAIL, "查不出患者信息！");
                }
                Long Id = personInfo.getId();
                String personId = String.valueOf(Id);
                List<Map<String, Object>> outpatientInfoAllLists = outpatientInfoService.getPatientAllInfoList(personId);

                //将集合outpatientInfoAllLists里的数据copy到集合outpatientInfoReponseLists中。
                List<OutpatientInfoReponse> outpatientInfoReponseLists = new ArrayList<OutpatientInfoReponse>();
                for (Map<String, Object> patientMap : outpatientInfoAllLists) {
                    OutpatientInfoReponse outpatientInfoReponse = new OutpatientInfoReponse();
                    //判断发病日期是否为空，如果为空将就诊日期赋值
                    if (ObjectUtil.isNullOrEmpty(patientMap.get("PATHOGENESIS_DATE"))) {
                        patientMap.put("PATHOGENESIS_DATE", patientMap.get("CLINIC_DATE"));
                    }
                    BeanUtils.populate(outpatientInfoReponse, patientMap);
                    outpatientInfoReponseLists.add(outpatientInfoReponse);
                }
                ;
                //判断是否能够查询到体检信息。
                if (ObjectUtil.isNullOrEmpty(outpatientInfoReponseLists)) {
                    getOutpatientInfoResponse.setRtnCode(FAIL);
                    getOutpatientInfoResponse.setRtnMessage("没有该患者的体检信息");
                } else {
                    getOutpatientInfoResponse = new GetOutpatientInfoResponse();
                    getOutpatientInfoResponse.setRtnCode(SUCCESS);
                    getOutpatientInfoResponse.setRtnMessage("查询成功");
                    getOutpatientInfoResponse.setOutpatientInfoReponseLists(outpatientInfoReponseLists);
                }
            } catch (Exception e) {
                e.printStackTrace();
                /*logger.error(e);*/
            }
            return XmlWebserviceForUtil.getString(getOutpatientInfoResponse, GetOutpatientInfoResponse.class);
        } else {
            GetOutpatientInfoResponse getOutpatientInfoResponse = new GetOutpatientInfoResponse();
            try {
                String EhrId = queryReserve.getEhrId();
                Map<String, Object> outPatientInfo = outpatientInfoService.getOutPatientInfo(EhrId);
                OutpatientInfoReponse outpatientInfoReponse = new OutpatientInfoReponse();
                BeanUtils.populate(outpatientInfoReponse, outPatientInfo);
                if (ObjectUtil.isNullOrEmpty(outpatientInfoReponse)) {
                    getOutpatientInfoResponse.setRtnCode(FAIL);
                    getOutpatientInfoResponse.setRtnMessage("没有该患者的体检信息");
                } else {
                    getOutpatientInfoResponse = new GetOutpatientInfoResponse();
                    getOutpatientInfoResponse.setRtnCode(SUCCESS);
                    getOutpatientInfoResponse.setRtnMessage("查询成功");
                    getOutpatientInfoResponse.setOutpatientInfoReponse(outpatientInfoReponse);
                }
            } catch (Exception e) {
                e.printStackTrace();
                /*logger.error(e);*/
            }
            return XmlWebserviceForUtil.getString(getOutpatientInfoResponse, GetOutpatientInfoResponse.class);
        }
    }

    @Override
    public String searchInpatientInfo(QueryReserve queryReserve) {

        if (StringUtil.isNullOrEmpty(queryReserve.getEhrId())) {
            //判断身份证号是否为空
            if (StringUtil.isNullOrEmpty(queryReserve.getIdcard())) {
                return XmlWebserviceForUtil.returnResult(FAIL, "查不出该患者的体检信息！");
            }
            GetOutpatientInfoResponse getOutpatientInfoResponse = new GetOutpatientInfoResponse();
            try {//SQL语句拼接，查找对应BI_PERSON_INFO表中的ID
                Criteria criteriaPer = new Criteria();
                criteriaPer.add("idcard", queryReserve.getIdcard());
                PersonInfo personInfo = personInfoDao.get(criteriaPer);
                //判断是否可以根据身份证号在personinfo表中查出id
                if (StringUtil.isNullOrEmpty(String.valueOf(personInfo.getId()))) {
                    return XmlWebserviceForUtil.returnResult(FAIL, "查不出患者信息！");
                }
                Long Id = personInfo.getId();
                String personId = String.valueOf(Id);
                //通过Id对应personId查找对应的MS_INPATIENT_INFO表中相关的数据。
                Criteria criteriaInp = new Criteria();
                criteriaInp.add("personId", personId);
                List<InpatientInfo> inpatientInfoList = inpatientDataService.getinpatientInfoList(criteriaInp);
                //将集合inpatientInfoList中的数据拷贝到inpatientInfoResponseList中。
                List<InpatientInfoResponse> inpatientInfoResponseList = new ArrayList<InpatientInfoResponse>();
                for (InpatientInfo inpatient : inpatientInfoList) {
                    InpatientInfoResponse inpatientInfoResponse = new InpatientInfoResponse();
                    org.springframework.beans.BeanUtils.copyProperties(inpatient, inpatientInfoResponse);
                    inpatientInfoResponseList.add(inpatientInfoResponse);
                }
                if (ObjectUtil.isNullOrEmpty(inpatientInfoResponseList)) {
                    getOutpatientInfoResponse.setRtnCode(FAIL);
                    getOutpatientInfoResponse.setRtnMessage("没有该患者的体检信息");
                } else {
                    getOutpatientInfoResponse = new GetOutpatientInfoResponse();
                    getOutpatientInfoResponse.setRtnCode(SUCCESS);
                    getOutpatientInfoResponse.setRtnMessage("查询成功");
                    getOutpatientInfoResponse.setInpatientInfoResponsesList(inpatientInfoResponseList);
                }
            } catch (Exception e) {
                e.printStackTrace();
                /*logger.error(e);*/
            }
            return XmlWebserviceForUtil.getString(getOutpatientInfoResponse, GetOutpatientInfoResponse.class);
        } else {
            GetOutpatientInfoResponse getOutpatientInfoResponse = new GetOutpatientInfoResponse();
            Criteria criteria = new Criteria();
            criteria.add("ehrId", queryReserve.getEhrId());
            InpatientInfo inpatientInfo = inpatientDataService.getInpatientInfo(criteria);
            InpatientInfoResponse inpatientInfoResponse = new InpatientInfoResponse();
            org.springframework.beans.BeanUtils.copyProperties(inpatientInfo, inpatientInfoResponse);
            if (ObjectUtil.isNullOrEmpty(inpatientInfoResponse)) {
                getOutpatientInfoResponse.setRtnCode(FAIL);
                getOutpatientInfoResponse.setRtnMessage("没有该患者的体检信息");
            } else {
                getOutpatientInfoResponse = new GetOutpatientInfoResponse();
                getOutpatientInfoResponse.setRtnCode(SUCCESS);
                getOutpatientInfoResponse.setRtnMessage("查询成功");
                getOutpatientInfoResponse.setInpatientInfoResponse(inpatientInfoResponse);

            }
            return XmlWebserviceForUtil.getString(getOutpatientInfoResponse, GetOutpatientInfoResponse.class);
        }
    }

    @Override
    public String getPhysiqueExaList(QueryReserve queryReserve) {
        //验证身份证号是否为空
        if (StringUtil.isNullOrEmpty(queryReserve.getIdcard())) {
            return XmlWebserviceForUtil.returnResult(FAIL, "患者身份证号不能为空！");
        }
        //查询用户表获得personId
        Criteria criteriaPer = new Criteria("idcard", queryReserve.getIdcard());
        PersonInfo personInfo = personInfoDao.get(criteriaPer);
        GetHealthExamsListResponse getHealthExamsListResponse = new GetHealthExamsListResponse();
        //查询的用户没有记录
        if (ObjectUtil.isNullOrEmpty(personInfo)) {
            getHealthExamsListResponse.setRtnCode(FAIL);
            getHealthExamsListResponse.setRtnMessage("没有该患者的体检信息");
            return XmlWebserviceForUtil.getString(getHealthExamsListResponse, GetHealthExamsListResponse.class);
        }
        Long Id = personInfo.getId();
        String personId = String.valueOf(Id);
        //根据personId查询体检表
        Criteria criteria = new Criteria("personId", personId);
        Order order = new Order("EXAMINATION_DATE DESC NULLS LAST,ID ");
        //查询返回结果集
        List<HealthExamination> HealthExaminations = healthExaminationService.getHealthExamsList(criteria, order);
        //返回参数结果集
        List<HealthExam> healthExamList = new ArrayList<HealthExam>();
        for (HealthExamination healthExamination : HealthExaminations) {
            HealthExam healthExam = new HealthExam();
            org.springframework.beans.BeanUtils.copyProperties(healthExamination, healthExam);
            healthExamList.add(healthExam);
        }
        //判断是否能够查询到体检信息。
        if (ObjectUtil.isNullOrEmpty(healthExamList)) {
            getHealthExamsListResponse.setRtnCode(FAIL);
            getHealthExamsListResponse.setRtnMessage("没有该患者的体检信息");
        } else {
            getHealthExamsListResponse.setRtnCode(SUCCESS);
            getHealthExamsListResponse.setRtnMessage("查询成功");
            getHealthExamsListResponse.setHealthExam(healthExamList);
        }
        return XmlWebserviceForUtil.getString(getHealthExamsListResponse, GetHealthExamsListResponse.class);
    }

    @Override
    public String getPhysiqueExaDetail(GetPhyExamDetailReq getPhyExamDetailReq) {
        //判断参数是否为空
        String validRes = ValidateUtil.doValidate(getPhyExamDetailReq, "ehrId", "personId");
        if (ObjectUtil.isNotEmpty(validRes)) {
            return XmlWebserviceForUtil.returnResult(FAIL, validRes);
        }
        String ehrId = getPhyExamDetailReq.getEhrId();
        String personId = getPhyExamDetailReq.getPersonId();
        //返回的bean
        GetPhyExamDetailResp getPhyExamDetailResp = new GetPhyExamDetailResp();
        Criteria criteria = new Criteria("personId", personId).add("ehrId", ehrId);
        //  查询体检内容
        HealthExamination he = healthExaminationService.getHealthExam(criteria);
        HealthExaminationDetail healthExaminationDetail = new HealthExaminationDetail();
        org.springframework.beans.BeanUtils.copyProperties(he, healthExaminationDetail);
        getPhyExamDetailResp.setHealthExaminationDetail(healthExaminationDetail);

        // 一般观察
        List<ObservationInfo> observationInfos = healthExaminationService.getObservationInfos(criteria);
        getPhyExamDetailResp.setObservationInfos(observationInfos);

        //检验项
        List<ExamineEvent> examEventMaps = healthExaminationService.getExamEventsList(criteria);
        List<ExamEvent> examEvents = new ArrayList<ExamEvent>();
        if (ObjectUtil.isNotEmpty(examEventMaps)) {
            for (ExamineEvent map : examEventMaps) {
                ExamEvent examEvent = new ExamEvent();
                examEvent.setCheckListTitle(map.getCheckListTitle());
                examEvent.setCheckPeopleName(map.getCheckPeopleName());
                examEvent.setCheckDate(map.getCheckDate());
                Criteria detailC = new Criteria("ehrId", ehrId).add("personId", personId).add("EXAMINATION_NUMBER", map.getExaminationNumber());
                List<ExamineDetail> examDetails = healthExaminationService.getExamDetails(detailC);
                examEvent.setExamineDetails(examDetails);
                examEvents.add(examEvent);
            }
        }
        getPhyExamDetailResp.setExamineEvents(examEvents);

        //检查项
        List<StudyEvent> studyEvents = healthExaminationService.getStudyEvents(criteria);
        getPhyExamDetailResp.setStudyEvents(studyEvents);
        getPhyExamDetailResp.setRtnCode(SUCCESS);
        getPhyExamDetailResp.setRtnMessage("查询成功");
        return XmlWebserviceForUtil.getString(getPhyExamDetailResp, GetPhyExamDetailResp.class);
    }

    //获取检验列表
    @Override
    public String getExam(QueryReserve queryReserve) {
        if (StringUtil.isNullOrEmpty(queryReserve.getIdcard())) {
            return XmlWebserviceForUtil.returnResult(FAIL, "查不出该患者的检验信息！");
        }
        //通过身份证号获取personId
        Criteria criteriaPer = new Criteria();
        criteriaPer.add("idcard", queryReserve.getIdcard());
        PersonInfo personInfo = personInfoDao.get(criteriaPer);
        String personId = String.valueOf(personInfo.getId());
        //通过personId获取检验列表
        Criteria criteriaExa = new Criteria();
        criteriaExa.add("personId", personId);
        Order order = new Order("CHECK_DATE", true);
        List<ExamineEvent> examineEventList = examService.getExamList(criteriaExa, order);
        //将examineEventList里的值赋到ExamResponseList
        GetEhrResponse getEhrResponse = new GetEhrResponse();
        List<ExamResponse> ExamResponseList = new ArrayList<ExamResponse>();
        for (ExamineEvent examineEvent : examineEventList) {
            ExamResponse examResponse = new ExamResponse();
            org.springframework.beans.BeanUtils.copyProperties(examineEvent, examResponse);
            ExamResponseList.add(examResponse);
        }
        if (ObjectUtil.isNullOrEmpty(ExamResponseList)) {
            getEhrResponse.setRtnCode(FAIL);
            getEhrResponse.setRtnMessage("没有该患者的检验信息");
        } else {
            getEhrResponse.setRtnCode(SUCCESS);
            getEhrResponse.setRtnMessage("查询成功");
            getEhrResponse.setExamResponseList(ExamResponseList);
        }
        return XmlWebserviceForUtil.getString(getEhrResponse, GetEhrResponse.class);
    }

    //获取检验详情
    @Override
    public String getExamDetail(ExamResponse examResponse) {
        ExamDetailResponse examDetailResponse = new ExamDetailResponse();
        try {
            //获取检验详情
            String personId = String.valueOf(examResponse.getPersonId());
            String ehrId = examResponse.getEhrId();
            Criteria criteria = new Criteria();
            criteria.add("personId", personId);
            criteria.add("ehrId", ehrId);
            ExamReportDTO examReportDTO = examService.getExamReport(criteria);
            ExamineEvent examineEvent = examReportDTO.getExamineEvent();
            List<ExamineDetail> examineDetailslist = examReportDTO.getExamineDetails();
            examDetailResponse.setName(examineEvent.getName());
            examDetailResponse.setCheckDate(examineEvent.getCheckDate());
            examDetailResponse.setAuditName(examineEvent.getAuditName());
            examDetailResponse.setCheckListTitle(examineEvent.getCheckListTitle());
            examDetailResponse.setCheckPeopleName(examineEvent.getCheckPeopleName());
            examDetailResponse.setSampleTypeName(examineEvent.getSampleTypeName());
            examDetailResponse.setExamineDetailList(examineDetailslist);
            if (ObjectUtil.isNullOrEmpty(examDetailResponse.getExamineDetailList())) {
                examDetailResponse.setRtnCode(FAIL);
                examDetailResponse.setRtnMessage("没有该患者的检验详情");
            } else {
                examDetailResponse.setRtnCode(SUCCESS);
                examDetailResponse.setRtnMessage("查询成功");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return XmlWebserviceForUtil.getString(examDetailResponse, ExamDetailResponse.class);
    }

    //获取检查列表
    @Override
    public String getStudy(QueryReserve queryReserve) {
        if (StringUtil.isNullOrEmpty(queryReserve.getIdcard())) {
            return XmlWebserviceForUtil.returnResult(FAIL, "查不出该患者的检验信息！");
        }
        //通过身份证号获取personId
        Criteria criteriaPer = new Criteria();
        criteriaPer.add("idcard", queryReserve.getIdcard());
        PersonInfo personInfo = personInfoDao.get(criteriaPer);
        String personId = String.valueOf(personInfo.getId());
        //获取检查列表
        Criteria criteriaStu = new Criteria();
        criteriaStu.add("personId", personId);
        Order order = new Order("CHECK_DATE", true);
        List<StudyEvent> studyEventList = studyEventDao.getList(criteriaStu, order);
        List<StudyResponse> studyResponseList = new ArrayList<StudyResponse>();
        //将studyEventList中值赋到studyResponseList中
        for (StudyEvent studyEvent : studyEventList) {
            StudyResponse studyResponse = new StudyResponse();
            org.springframework.beans.BeanUtils.copyProperties(studyEvent, studyResponse);
            studyResponseList.add(studyResponse);
        }
        GetEhrResponse getEhrResponse = new GetEhrResponse();
        if (ObjectUtil.isNullOrEmpty(studyResponseList)) {
            getEhrResponse.setRtnCode(FAIL);
            getEhrResponse.setRtnMessage("查不出该患者的检查信息");
        } else {
            getEhrResponse.setRtnCode(SUCCESS);
            getEhrResponse.setRtnMessage("查询成功");
            getEhrResponse.setStudyResponseList(studyResponseList);
        }
        return XmlWebserviceForUtil.getString(getEhrResponse, GetEhrResponse.class);
    }

    //获取检查详情
    @Override
    public String getStudyDetail(StudyResponse studyResponse) {
        //获取检查详情
        String Id = String.valueOf(studyResponse.getId());
        Criteria criteriaStu = new Criteria();
        criteriaStu.add("id", Id);
        List<StudyEvent> studyEventList = studyEventDao.getList(criteriaStu);
        List<StudyDetailResponse> studyDetailResponseList = new ArrayList<StudyDetailResponse>();
        //将studyEventList值赋到studyDetailResponseList
        for (StudyEvent studyEvent : studyEventList) {
            StudyDetailResponse studyDetailResponse = new StudyDetailResponse();
            org.springframework.beans.BeanUtils.copyProperties(studyEvent, studyDetailResponse);
            studyDetailResponseList.add(studyDetailResponse);
        }
        GetEhrResponse getEhrResponse = new GetEhrResponse();
        if (ObjectUtil.isNullOrEmpty(studyDetailResponseList)) {
            getEhrResponse.setRtnCode(FAIL);
            getEhrResponse.setRtnMessage("没有该患者的检查详情");
        } else {
            getEhrResponse.setRtnCode(SUCCESS);
            getEhrResponse.setRtnMessage("查询成功");
            getEhrResponse.setStudyDetailResponseList(studyDetailResponseList);
        }
        return XmlWebserviceForUtil.getString(getEhrResponse, GetEhrResponse.class);
    }

    //获取用药信息
    @Override
    public String getDrug(QueryReserve queryReserve) {
        if (StringUtil.isNullOrEmpty(queryReserve.getIdcard())) {
            return XmlWebserviceForUtil.returnResult(FAIL, "查不出该患者的检验信息！");
        }
        //通过身份证号获取personId
        Criteria criteriaPer = new Criteria();
        criteriaPer.add("idcard", queryReserve.getIdcard());
        PersonInfo personInfo = personInfoDao.get(criteriaPer);
        String personId = String.valueOf(personInfo.getId());
        // 通过personid获取用药信息
        Criteria criteriaDru = new Criteria();
        criteriaDru.add("personId", personId);
        Order order = new Order("CLINIC_DATE", true);
        List<DrugUsage> drugUsageList = drugUsageDao.getList(criteriaDru, order);
        List<DrugResponse> drugResponseList = new ArrayList<DrugResponse>();
        for (DrugUsage drugUsage : drugUsageList) {
            DrugResponse drugResponse = new DrugResponse();
            org.springframework.beans.BeanUtils.copyProperties(drugUsage, drugResponse);
            drugResponseList.add(drugResponse);
        }
        GetEhrResponse getEhrResponse = new GetEhrResponse();
        if (ObjectUtil.isNullOrEmpty(drugResponseList)) {
            getEhrResponse.setRtnCode(FAIL);
            getEhrResponse.setRtnMessage("没有该患者的用药信息");
        } else {
            getEhrResponse.setRtnCode(SUCCESS);
            getEhrResponse.setRtnMessage("查询成功");
            getEhrResponse.setDrugResponseList(drugResponseList);
        }
        return XmlWebserviceForUtil.getString(getEhrResponse, GetEhrResponse.class);
    }

    //获取床位信息
    @Override
    public String getPatientbed(Department department) {
        if (StringUtil.isNullOrEmpty(department.getOrganCode())) {
            return XmlWebserviceForUtil.returnResult(FAIL, "查不出该医院的床位信息！");
        }
        //判断是否有科室名称
        String deptName = department.getDeptName();
        if (StringUtil.isNullOrEmpty(deptName)) {
            String hospitalCode = department.getOrganCode();
            Criteria criteria = new Criteria();
            criteria.add("hospitalCode", hospitalCode);
            List<PaitentbedStatus> paitentbedStatusList = patientbedStatusDao.getList(criteria);
            List<PatientbedStatusResponse> patientbedStatusResponseList = new ArrayList<PatientbedStatusResponse>();
            for (PaitentbedStatus paitentbedStatusSea : paitentbedStatusList) {
                PatientbedStatusResponse patientbedStatusResponse = new PatientbedStatusResponse();
                org.springframework.beans.BeanUtils.copyProperties(paitentbedStatusSea, patientbedStatusResponse);
                patientbedStatusResponseList.add(patientbedStatusResponse);
            }
            GetEhrResponse getEhrResponse = new GetEhrResponse();
            if (ObjectUtil.isNullOrEmpty(patientbedStatusResponseList)) {
                getEhrResponse.setRtnCode(FAIL);
                getEhrResponse.setRtnMessage("没有该医院床位信息");
            } else {
                getEhrResponse.setRtnCode(SUCCESS);
                getEhrResponse.setRtnMessage("查询成功");
                getEhrResponse.setPatientbedStatusResponseList(patientbedStatusResponseList);
            }
            return XmlWebserviceForUtil.getString(getEhrResponse, GetEhrResponse.class);
        }else {
            String hospitalCode = department.getOrganCode();
            Criteria criteria = new Criteria();
            criteria.add("depName", deptName);
            criteria.add("hospitalCode", hospitalCode);
            List<PaitentbedStatus> paitentbedStatusList = patientbedStatusDao.getList(criteria);
            List<PatientbedStatusResponse> patientbedStatusResponseList = new ArrayList<PatientbedStatusResponse>();
            for (PaitentbedStatus paitentbedStatusSea : paitentbedStatusList) {
                PatientbedStatusResponse patientbedStatusResponse = new PatientbedStatusResponse();
                org.springframework.beans.BeanUtils.copyProperties(paitentbedStatusSea, patientbedStatusResponse);
                patientbedStatusResponseList.add(patientbedStatusResponse);
            }
            GetEhrResponse getEhrResponse = new GetEhrResponse();
            if (ObjectUtil.isNullOrEmpty(patientbedStatusResponseList)) {
                getEhrResponse.setRtnCode(FAIL);
                getEhrResponse.setRtnMessage("没有该医院床位信息");
            } else {
                getEhrResponse.setRtnCode(SUCCESS);
                getEhrResponse.setRtnMessage("查询成功");
                getEhrResponse.setPatientbedStatusResponseList(patientbedStatusResponseList);
            }
            return XmlWebserviceForUtil.getString(getEhrResponse, GetEhrResponse.class);
        }
    }


}
