package com.founder.rhip.appInterface;

import java.util.List;

import javax.annotation.Resource;
import javax.jws.WebParam;
import javax.jws.WebService;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.BaseWebService;
import com.founder.rhip.ech.service.IEchManageService;
import com.founder.rhip.ehr.entity.basic.PersonInfo;
import com.founder.rhip.ehr.entity.basic.PhysicalExamRecord;
import com.founder.rhip.ehr.entity.ech.EchIdentification;
import com.founder.rhip.ehr.entity.ech.EchIdentificationOption;
import com.founder.rhip.ehr.entity.wsMonitor.WsOperationLog;
import com.founder.rhip.ehr.repository.clinic.IElderlyPhyExaminationDao;
import com.founder.rhip.ehr.repository.statistics.IPhysicalExamRecordDao;
import com.founder.rhip.ehr.service.personal.IPersonalRecordManagmentService;
import com.founder.rhip.ehr.service.util.XmlWebserviceForUtil;
import com.founder.rhip.hm.service.IPersonInfoService;
import com.founder.rhip.hm.service.IPhysiqueExaminationService;

/**
 * Created by admin on 2016/12/13.
 */
@Service("appTzbsWebService")
@WebService(serviceName="AppTzbsWebService")
public class AppTzbsWebService extends BaseWebService implements IAppTzbsWebService {

    private static String folder;

    private static String error = "请求数据格式不正确";
/*
    @Resource
    private IPhysicalExamRecordService physicalExamRecordService;
*/
    @Resource(name = "echManageService")
    private IEchManageService echManageService;

    @Resource(name ="personInfoService")
    private IPersonInfoService personInfoService;

    @Resource(name = "personalRecordManagmentService")
    private IPersonalRecordManagmentService personalRecordManagmentService;

    @Resource(name = "elderlyPhyExaminationDao")
    private IElderlyPhyExaminationDao elderlyPhyExaminationDao;

    @Resource(name = "physicalExamRecordDao")
    private IPhysicalExamRecordDao physicalExamRecordDao;

    @Resource
    private IPhysiqueExaminationService physiqueExaminationService;

    Logger log = Logger.getLogger(AppTzbsWebService.class);

    @Override
    public TzbsResultData tzbsDataProcess(@WebParam(name = "requestXml") String requestXml){

        String response = "";
        WsOperationLog wsOperationLog = new WsOperationLog();
        //操作日志
  /*      String returnMesg = this.getStartMessage(wsOperationLog, "AppTzbsWebService", "tzbsDataProcess", requestXml);
        if(StringUtil.isNotEmpty(returnMesg)) {
            return returnMesg;
        }*/
        try {
            XmlWebserviceForUtil.saveDataFile(requestXml,"tzbsDataProcess",folder);
            TzbsData tzbsData = XmlWebserviceForUtil.parseDataXml(requestXml,TzbsData.class);
            String idCardNo = tzbsData.getIdCardNo();
            List<EchIdentificationOption> options = tzbsData.getOptions();
            if(idCardNo==null){
                response = XmlWebserviceForUtil.returnError("身份证号不能为空!");
                TzbsResultData tzbsResultData = new TzbsResultData();
                tzbsResultData.setResponse("2");
                tzbsResultData.setStr("身份证号不能为空!");
                return tzbsResultData;
            }
            if(idCardNo.length()!=18){
                response = XmlWebserviceForUtil.returnError("身份证号位数(18位)不正确");
                TzbsResultData tzbsResultData = new TzbsResultData();
                tzbsResultData.setResponse("2");
                tzbsResultData.setStr("身份证号位数(18位)不正确");
                return tzbsResultData;
            }
            //判断是否已建健康档案
            if(null!=idCardNo&&idCardNo.length()==18){
                PersonInfo person= personInfoService.getPersonInfoId(new Criteria("IDCARD",idCardNo));
                if(ObjectUtil.isNullOrEmpty(person)){
                    TzbsResultData tzbsResultData = new TzbsResultData();
                    tzbsResultData.setResponse("2");
                    tzbsResultData.setStr("该身份证暂时无建档信息！");
                    return  tzbsResultData;
                }else{
                    //判断是否存在老年人名单里
                    PhysicalExamRecord physicalExamRecord=physicalExamRecordDao.get(new Criteria("IDCARD",idCardNo));
                    if(ObjectUtil.isNullOrEmpty(physicalExamRecord)){
                        TzbsResultData tzbsResultData = new TzbsResultData();
                        tzbsResultData.setResponse("2");
                        tzbsResultData.setStr("该身份证信息不属于老年人名单！");
                        return  tzbsResultData;
                    }
                }
            }

            //判断得分数量是否正确。
            if(options==null|options.size()!=33){
                response = XmlWebserviceForUtil.returnError("健康管理服务记录表答题数量不匹配（33个）!");
                TzbsResultData tzbsResultData = new TzbsResultData();
                tzbsResultData.setResponse("2");
                tzbsResultData.setStr("健康管理服务记录表答题数量不匹配（33个）!");
                return tzbsResultData;
            }
            for(EchIdentificationOption option:options){
                Integer score = option.getScore();
                if(score<=0||score>5){
                    response = XmlWebserviceForUtil.returnError("健康管理服务记录表答题("+option.getOptionNo()+")结果不在范围内（答题结果请填1-5分）!");
                    TzbsResultData tzbsResultData = new TzbsResultData();
                    tzbsResultData.setResponse("2");
                    tzbsResultData.setStr("健康管理服务记录表答题("+option.getOptionNo()+")结果不在范围内（答题结果请填1-5分）!");
                    return tzbsResultData;
                }
            }

            EchIdentification identification = null;
                identification=new EchIdentification();
                identification.setName(tzbsData.getName());
                identification.setIdcard(idCardNo);
                identification.setIdentificationOptions(options);
                identification.calTcm();//计算体质分；
                TzbsResultData tzbsResultData = new TzbsResultData();
                tzbsResultData.setResponse("1");
                tzbsResultData.setStr("接口调用成功!");
                tzbsResultData.setEchIdentification(identification);
                return tzbsResultData;

        } catch (Exception e) {
            e.printStackTrace();
            response = XmlWebserviceForUtil.returnError(e.getMessage());
            TzbsResultData tzbsResultData = new TzbsResultData();
            tzbsResultData.setResponse("2");
            tzbsResultData.setStr("数据异常");
            tzbsResultData.setResult(response);
            return tzbsResultData;

        } finally {
            this.setEndMessage(wsOperationLog, response);

        }

    }

   /* ---此为园区项目功能，团风没有
    * @Override
    public TzpgResultDate zwpgDataProcess(@WebParam(name = "requestXml") String requestXml){

        String response = "1";
        WsOperationLog wsOperationLog = new WsOperationLog();
        try {
            XmlWebserviceForUtil.saveDataFile(requestXml,"zwpgDataProcess",folder);
            ZwpgData zwpgData = XmlWebserviceForUtil.parseDataXml(requestXml,ZwpgData.class);
            //老年人健康状态自我评估
            String healthSelfAssessment = zwpgData.getHealthSelfAssessment();
            //老年人生活自理能力自我评估
            String lifeAbilitySelfAssessment = zwpgData.getLifeAbilitySelfAssessment();
            try {
                Integer int1 = Integer.parseInt(healthSelfAssessment);
                if(int1<1||int1>5){
                    response = XmlWebserviceForUtil.returnError("老年人健康状态自我评估值[healthSelfAssessment]不在范围内（1-5）!");
                    TzpgResultDate tzpgResultDate = new TzpgResultDate();
                    tzpgResultDate.setResponse("2");
                    tzpgResultDate.setStr("老年人健康状态自我评估值[healthSelfAssessment]不在范围内（1-5）!");
                    return tzpgResultDate;
                    return response;
                }
            } catch (NumberFormatException e) {
                response = XmlWebserviceForUtil.returnError("老年人健康状态自我评估值[healthSelfAssessment]不在范围内（1-5）!");
                TzpgResultDate tzpgResultDate = new TzpgResultDate();
                tzpgResultDate.setResponse("2");
                tzpgResultDate.setStr("老年人健康状态自我评估值[healthSelfAssessment]不在范围内（1-5）!");
                return tzpgResultDate;
//                return response;
            }
            try {
            Integer int2 = Integer.parseInt(lifeAbilitySelfAssessment);
                if(int2<1||int2>4){
                    response = XmlWebserviceForUtil.returnError("老年人生活自理能力自我评估值[lifeAbilitySelfAssessment]不在范围内（1-4）!");
                    TzpgResultDate tzpgResultDate = new TzpgResultDate();
                    tzpgResultDate.setResponse("2");
                    tzpgResultDate.setStr("老年人生活自理能力自我评估值[lifeAbilitySelfAssessment]不在范围内（1-4）!");
                    return tzpgResultDate;
//                    return response;
                }
            } catch (NumberFormatException e) {
                response = XmlWebserviceForUtil.returnError("老年人生活自理能力自我评估值[lifeAbilitySelfAssessment]不在范围内（1-4）!");
                TzpgResultDate tzpgResultDate = new TzpgResultDate();
                tzpgResultDate.setResponse("2");
                tzpgResultDate.setStr("老年人生活自理能力自我评估值[lifeAbilitySelfAssessment]不在范围内（1-4）!");
                return tzpgResultDate;
//                return response;
            }
            //老年人进餐能力自我评估
            Integer eatingAssessment = zwpgData.getEatingAssessment();
            if(eatingAssessment!=0&&eatingAssessment!=3&&eatingAssessment!=5){
                response = XmlWebserviceForUtil.returnError("老年人进餐能力自我评估值[eatingAssessment]不在范围内（0,3,5）!");
                TzpgResultDate tzpgResultDate = new TzpgResultDate();
                tzpgResultDate.setResponse("2");
                tzpgResultDate.setStr("老年人进餐能力自我评估值[eatingAssessment]不在范围内（0,3,5）!");
                return tzpgResultDate;
//                return response;
            }
            //老年人梳洗能力自我评估
            Integer cleaningAssessment = zwpgData.getCleaningAssessment();
            if(cleaningAssessment!=0&&cleaningAssessment!=1&&cleaningAssessment!=3&&cleaningAssessment!=7){
                response = XmlWebserviceForUtil.returnError("老年人梳洗能力自我评估值[cleaningAssessment]不在范围内（0,1,3,7）!");
                TzpgResultDate tzpgResultDate = new TzpgResultDate();
                tzpgResultDate.setResponse("2");
                tzpgResultDate.setStr("老年人梳洗能力自我评估值[cleaningAssessment]不在范围内（0,1,3,7）!");
                return tzpgResultDate;
//                return response;
            }
            //老年人生活穿衣能力自我评估
            Integer clothingAssessment = zwpgData.getClothingAssessment();
            if(clothingAssessment!=0&&clothingAssessment!=3&&clothingAssessment!=5){
                response = XmlWebserviceForUtil.returnError("老年人生活穿衣能力自我评估值[clothingAssessment]不在范围内（0,3,5）!");
                TzpgResultDate tzpgResultDate = new TzpgResultDate();
                tzpgResultDate.setResponse("2");
                tzpgResultDate.setStr("老年人生活穿衣能力自我评估值[clothingAssessment]不在范围内（0,3,5）!");
                return tzpgResultDate;
            }
            //老年人如厕能力自我评估
            Integer defecationAssessment = zwpgData.getDefecationAssessment();
            if(defecationAssessment!=0&&defecationAssessment!=1&&defecationAssessment!=5&&defecationAssessment!=10){
                response = XmlWebserviceForUtil.returnError("老年人如厕能力自我评估值[defecationAssessment]不在范围内（0,1,5,10）!");
                TzpgResultDate tzpgResultDate = new TzpgResultDate();
                tzpgResultDate.setResponse("2");
                tzpgResultDate.setStr("老年人如厕能力自我评估值[defecationAssessment]不在范围内（0,1,5,10）!");
                return tzpgResultDate;
            }
            //老年人活动能力自我评估
            Integer exerciseAssessment = zwpgData.getExerciseAssessment();
            if(exerciseAssessment!=0&&exerciseAssessment!=1&&exerciseAssessment!=5&&exerciseAssessment!=10){
                response = XmlWebserviceForUtil.returnError("老年人活动能力自我评估值[exerciseAssessment]不在范围内（0,1,5,10）!");
                TzpgResultDate tzpgResultDate = new TzpgResultDate();
                tzpgResultDate.setResponse("2");
                tzpgResultDate.setStr("老年人活动能力自我评估值[exerciseAssessment]不在范围内（0,1,5,10）!");
                return tzpgResultDate;
            }
            String idCardNo = zwpgData.getIdCardNo();
            PersonInfo person= personInfoService.getPersonInfoId(new Criteria("IDCARD",idCardNo));
            if(ObjectUtil.isNullOrEmpty(person)){
                TzpgResultDate tzpgResultDate = new TzpgResultDate();
                tzpgResultDate.setResponse("2");
                tzpgResultDate.setStr("该身份证暂时无建档信息！");
                return  tzpgResultDate;
            }
            if(idCardNo==null||idCardNo.length()!=18){
                response = XmlWebserviceForUtil.returnError("身份证号[idCardNo]必须为18位!");
                TzpgResultDate tzpgResultDate = new TzpgResultDate();
                tzpgResultDate.setResponse("2");
                tzpgResultDate.setStr("身份证号[idCardNo]必须为18位!");
                return tzpgResultDate;
            }
            Criteria criteria =new Criteria("IDCARD",idCardNo);
            criteria.add("EXAM_YEAR", OP.GE, DateUtil.getCurrentYear()+"-01-01 00:00:00");
            PhysicalExamRecord record = physicalExamRecordDao.get(criteria);
            if(record==null){
                response =XmlWebserviceForUtil.returnError("找不到该身份证号今年的体检记录!");
                TzpgResultDate tzpgResultDate = new TzpgResultDate();
                tzpgResultDate.setResponse("2");
                tzpgResultDate.setStr("找不到该身份证号今年的体检记录");
                return tzpgResultDate;
            }
            ElderlyPhyExamination examination;
            if(ObjectUtil.isNotEmpty(record)){
                examination = physiqueExaminationService.getPhysiqueExamination(record);
            }else{
                examination= new ElderlyPhyExamination();

            }
            //老年人健康状态自我评估
            examination.setHealthSelfAssessment(zwpgData.getHealthSelfAssessment());
            //老年人生活自理能力自我评估
            examination.setLifeAbilitySelfAssessment(zwpgData.getLifeAbilitySelfAssessment());
            //老年人进餐能力自我评估
            examination.setEatingAssessment(eatingAssessment);
            //老年人梳洗能力自我评估
            examination.setCleaningAssessment(cleaningAssessment);
            //老年人生活穿衣能力自我评估
            examination.setClothingAssessment(clothingAssessment);
            //老年人如厕能力自我评估
            examination.setDefecationAssessment(defecationAssessment);
            //老年人活动能力自我评估
            examination.setExerciseAssessment(exerciseAssessment);
            String id;
            if(ObjectUtil.isNullOrEmpty(examination.getId())) {
                examination.setPersonId(person.getId());
                examination.setGender(person.getGender());
                examination.setMarriage(person.getMarriage());
                Date birthday = person.getBirthday();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
                int startTime = Integer.parseInt(sdf.format(birthday));
                int endTime = Integer.parseInt(sdf.format(new Date()));
                int age = endTime-startTime;
                examination.setAge(String.valueOf(age));
                id = elderlyPhyExaminationDao.generatedKey(examination, "ID", null).toString();
            }else{
                id = examination.getId().toString();
            }
            String recordId;
            if(ObjectUtil.isNullOrEmpty(record)) {
                PhysicalExamRecord p =  new PhysicalExamRecord();
                record=p;
                recordId = physicalExamRecordDao.generatedKey(p,"ID",null).toString();
            }else{
                recordId = record.getId().toString();
            }
            int r = physiqueExaminationService.updateSelfAssessment(examination,Long.parseLong(id), Long.parseLong(recordId));
            if(r>0){
                //自我评估数据来源于APP接口
                //record.setTcmDataFrom(Constants.TCM_DATA_FROM_3);
                physicalExamRecordDao.update(record,"tcmDataFrom");
            }
            response = String.valueOf(r);
            log.info("老年人自我评估接口【zwpgDataProcess】调用成功！返回:"+response);
            TzpgResultDate tzpgResultDate = new TzpgResultDate();
            tzpgResultDate.setResponse("1");
            tzpgResultDate.setResult("1");
            return tzpgResultDate;
//            return response;
        } catch (Exception e) {
            e.printStackTrace();
            response = XmlWebserviceForUtil.returnError(e.getMessage());
            TzpgResultDate tzpgResultDate = new TzpgResultDate();
            tzpgResultDate.setResponse("2");
            tzpgResultDate.setStr("数据异常");
            tzpgResultDate.setStr(response);
            return tzpgResultDate;
            return response;
        } finally {
            this.setEndMessage(wsOperationLog, response);
        }
    }*/
}