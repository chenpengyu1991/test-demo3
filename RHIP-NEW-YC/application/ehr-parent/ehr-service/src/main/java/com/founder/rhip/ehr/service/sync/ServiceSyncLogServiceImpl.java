package com.founder.rhip.ehr.service.sync;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.annotation.Resource;

import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.processors.DefaultValueProcessor;
import net.sf.json.processors.JsonValueProcessor;
import net.sf.json.util.PropertyFilter;

import org.springframework.stereotype.Service;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.OP;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.ehr.common.EHRConstants;
import com.founder.rhip.ehr.dto.PersonalPhyExamDTO;
import com.founder.rhip.ehr.entity.basic.PersonInfo;
import com.founder.rhip.ehr.entity.basic.User;
import com.founder.rhip.ehr.entity.clinic.ServiceSyncLog;
import com.founder.rhip.ehr.entity.ech.EchIdentification;
import com.founder.rhip.ehr.entity.management.DmDiabeticFollowup;
import com.founder.rhip.ehr.entity.management.DmHypertensionFollowup;
import com.founder.rhip.ehr.repository.basic.IPersonInfoDao;
import com.founder.rhip.ehr.repository.basic.IServiceSyncLogDao;

/**
 * 公卫同步家医履约
 * @author guo.xm
 *
 */
@Service("serviceSyncLogService")
public class ServiceSyncLogServiceImpl implements IServiceSyncLogService {

	@Resource(name = "serviceSyncLogDao")
	private IServiceSyncLogDao serviceSyncLogDao;

	@Resource(name = "personInfoDao")
	private IPersonInfoDao personInfoDao;
	
	@Override
	public void insertExam(PersonalPhyExamDTO dto, User currentUser, EchIdentification iden, String jsonType , String operate) {
		JsonConfig jsonConfig = getJsonConfig();  
		PersonInfo info = dto.getPersonInfo();
		String examCode = dto.getPhysiqueExamination().getPhysicalExamCode();
		Date examDate = dto.getPhysiqueExamination().getExaminationDate();
		dto.setEchIdentification(iden);
		
		//过滤list中的null值
		if(ObjectUtil.isNotEmpty(dto.getDrugHistoryList()))
			dto.getDrugHistoryList().removeAll(Collections.singleton(null)); 
		if(ObjectUtil.isNotEmpty(dto.getFamilyBedHistoryList()))
			dto.getFamilyBedHistoryList().removeAll(Collections.singleton(null)); 
		if(ObjectUtil.isNotEmpty(dto.getHealthEvaluateAnomalyList()))
			dto.getHealthEvaluateAnomalyList().removeAll(Collections.singleton(null)); 
		if(ObjectUtil.isNotEmpty(dto.getHospitalizedHistoryList()))
			dto.getHospitalizedHistoryList().removeAll(Collections.singleton(null)); 
		if(ObjectUtil.isNotEmpty(dto.getVaccinationInfoList()))
			dto.getVaccinationInfoList().removeAll(Collections.singleton(null)); 
		
		String jsonData = JSONObject.fromObject(dto, jsonConfig).toString();
		
		//身份证号为空的体检信息不同步到家医
		if(StringUtil.isNotEmpty(info.getIdcard())){
			Criteria cri = new Criteria("personIdcard", info.getIdcard());
			//老年人体检修改时，按体检年份更新--老年人体检暂时一年一条,暂不考虑跨年修改
			if(EHRConstants.UPDATE.equals(operate)){
				Date firstDateOfYear = DateUtil.firstDateOfYear(examDate);
				Date lastDateOfYear = DateUtil.lastDateOfYear(examDate);
				DateUtil.getCriteriaByDateRange(cri, "serviceDate", firstDateOfYear, lastDateOfYear);
			}else{
				cri.add("examCode",examCode);
			}
			cri.add("jsonType", jsonType);
			ServiceSyncLog log = serviceSyncLogDao.get(cri);
			
			if(ObjectUtil.isNotEmpty(log)){
				serviceSyncLogDao.delete(new Criteria("id", log.getId()));
				log.setUpdateDate(new Date());
				log.setUpdateUser(currentUser.getUserName());
				log.setOperate(EHRConstants.UPDATE);//修改标志
			}else{
				log = new ServiceSyncLog();
				log.setCreateDate(new Date());
				log.setCreateUser(currentUser.getUserName());
				log.setUpdateDate(new Date());
				log.setUpdateUser(currentUser.getUserName());
				log.setOperate(EHRConstants.ADD);//新增标志
			}
			
			log.setName(info.getName());
			log.setPersonId(info.getId());
			log.setJsonType(jsonType);
			log.setPersonIdcard(info.getIdcard());
			log.setIsSync(0L);
			log.setJsonData(jsonData);
			log.setServiceDate(examDate);
			log.setExamCode(examCode);
			log.setRecordId(dto.getPhysiqueExamination().getRecordId());
			serviceSyncLogDao.insert(log);
		}
	}

	/**
	 * 同步高血压随访到家医，只同步计划内 和 控制不满意新增的随访
	 */
	@Override
	public void insertHbp(DmHypertensionFollowup hbpFollowup, User currentUser, String planType) {
		JsonConfig jsonConfig = getJsonConfig();  
		PersonInfo info = personInfoDao.get(hbpFollowup.getPersonId());
		String examCode = hbpFollowup.getId().toString();
		String jsonData = JSONObject.fromObject(hbpFollowup, jsonConfig).toString();
		String jsonType = "";
		if(EHRConstants.CDM_FOLLOWUP_PLAN.equals(planType)){
			jsonType = EHRConstants.HBP_JSON_TYPE;
		}else if(EHRConstants.CDM_FOLLOWUP_DISCONTENT.equals(planType)){
			jsonType = EHRConstants.HBP_INTERVENE;
		}else{
			return;
		}
		
		//身份证号为空的体检信息不同步到家医
		if(StringUtil.isNotEmpty(info.getIdcard())){
			Criteria cri = new Criteria("personIdcard", info.getIdcard());
			cri.add("examCode",examCode);
			cri.add("jsonType", jsonType);
			ServiceSyncLog log = serviceSyncLogDao.get(cri);
			
			if(ObjectUtil.isNotEmpty(log)){
				serviceSyncLogDao.delete(new Criteria("id", log.getId()));
				log.setName(info.getName());
				log.setPersonId(info.getId());
				log.setIsSync(0L);
				log.setJsonData(jsonData);
				log.setServiceDate(hbpFollowup.getVisitDate());
				log.setUpdateDate(new Date());
				log.setUpdateUser(currentUser.getUserName());
				log.setOperate("U");//修改标志
				serviceSyncLogDao.insert(log);
			}else{
				log = new ServiceSyncLog();
				log.setIsSync(0L);
				log.setPersonIdcard(info.getIdcard());
				log.setName(info.getName());
				log.setPersonId(info.getId());
				log.setJsonData(jsonData);
				log.setServiceDate(hbpFollowup.getVisitDate());
				log.setJsonType(jsonType);
				log.setExamCode(examCode);
				log.setCreateDate(new Date());
				log.setCreateUser(currentUser.getUserName());
				log.setUpdateDate(new Date());
				log.setUpdateUser(currentUser.getUserName());
				log.setOperate("A");//新增标志
				serviceSyncLogDao.insert(log);
			}
		}
	}

	public void deleteExam(Long personId, String examCode, String type){
		Criteria cri = new Criteria("personId", personId);
		cri.add("examCode",examCode);
		cri.add("jsonType", type);
		ServiceSyncLog log = serviceSyncLogDao.get(cri);
		if(ObjectUtil.isNotEmpty(log)){
			log.setOperate("D");//修改标志
			log.setIsSync(0L);
			log.setUpdateDate(new Date());
			serviceSyncLogDao.update(log, "operate", "isSync");
		}
	}
	
	/**
	 * 同步糖尿病随访到家医，只同步计划内 和 控制不满意新增的随访
	 */
	@Override
	public void insertDi(DmDiabeticFollowup diFollowup, User currentUser, String planType) {
		JsonConfig jsonConfig = getJsonConfig();  
		PersonInfo info = personInfoDao.get(diFollowup.getPersonId());
		String examCode = diFollowup.getId().toString();
		String jsonData = JSONObject.fromObject(diFollowup, jsonConfig).toString();
		String jsonType = "";
		if(EHRConstants.CDM_FOLLOWUP_PLAN.equals(planType)){
			jsonType = EHRConstants.DI_JSON_TYPE;
		}else if(EHRConstants.CDM_FOLLOWUP_DISCONTENT.equals(planType)){
			jsonType = EHRConstants.DI_INTERVENE;
		}else{
			return;
		}
		
		//身份证号为空的体检信息不同步到家医
		if(StringUtil.isNotEmpty(info.getIdcard())){
			Criteria cri = new Criteria("personIdcard", info.getIdcard());
			cri.add("examCode",examCode);
			cri.add("jsonType", jsonType);
			ServiceSyncLog log = serviceSyncLogDao.get(cri);
			
			if(ObjectUtil.isNotEmpty(log)){
				serviceSyncLogDao.delete(new Criteria("id", log.getId()));
				log.setName(info.getName());
				log.setPersonId(info.getId());
				log.setIsSync(0L);
				log.setJsonData(jsonData);
				log.setServiceDate(diFollowup.getVisitDate());
				log.setUpdateDate(new Date());
				log.setUpdateUser(currentUser.getUserName());
				log.setOperate("U");//修改标志
				serviceSyncLogDao.insert(log);
			}else{
				log = new ServiceSyncLog();
				log.setIsSync(0L);
				log.setPersonIdcard(info.getIdcard());
				log.setName(info.getName());
				log.setPersonId(info.getId());
				log.setJsonData(jsonData);
				log.setServiceDate(diFollowup.getVisitDate());
				log.setJsonType(jsonType);
				log.setExamCode(examCode);
				log.setCreateDate(new Date());
				log.setCreateUser(currentUser.getUserName());
				log.setUpdateDate(new Date());
				log.setUpdateUser(currentUser.getUserName());
				log.setOperate("A");//新增标志
				serviceSyncLogDao.insert(log);
			}
		}
	}
	
	
	public static JsonConfig getJsonConfig(){
		JsonConfig jsonConfig = new JsonConfig();  
		jsonConfig.registerJsonValueProcessor(Date.class, new JsonDateValueProcessor()); 
		jsonConfig.registerDefaultValueProcessor(Integer.class, //定义Integer为null时   转为json 还是null,如果不自己定义的话，会默认返回0
                new DefaultValueProcessor(){
                    public Object getDefaultValue(Class type) {
                        return null;
                    }
        });
		jsonConfig.registerDefaultValueProcessor(BigDecimal.class, 
                new DefaultValueProcessor(){
                    public Object getDefaultValue(Class type) {
                        return null;
                    }
        });
		jsonConfig.setJsonPropertyFilter(new PropertyFilter() {
            public boolean apply(Object obj, String key, Object value) {
                if (value == null) {
                    return true;
                }
                return false;
            }
        });
		return jsonConfig;
	}

	@Override
	public List<ServiceSyncLog> getLogs(List<String> physicalExamCodes, Long personId, String type) {
		Criteria cri = new Criteria("personId", personId);
		cri.add("examCode",OP.IN, physicalExamCodes);
		if(StringUtil.isNotEmpty(type)){
			cri.add("jsonType", type);
		}
		return serviceSyncLogDao.getList(cri, "id", "jsonData");
	}
	
	@Override
	public ServiceSyncLog getLog(String examCode, Long personId, String type){
		Criteria cri = new Criteria("personId", personId);
		cri.add("examCode", examCode);
		if(StringUtil.isNotEmpty(type)){
			cri.add("jsonType", type);
		}
		return serviceSyncLogDao.get(cri, "id", "jsonData");
	}
}

class JsonDateValueProcessor implements JsonValueProcessor {  
	private String format ="yyyy-MM-dd";  
    
    public JsonDateValueProcessor() {  
        super();  
    }  
      
    public JsonDateValueProcessor(String format) {  
        super();  
        this.format = format;  
    }  
  
    @Override  
    public Object processArrayValue(Object paramObject,  
            JsonConfig paramJsonConfig) {  
        return process(paramObject);  
    }  
  
    @Override  
    public Object processObjectValue(String paramString, Object paramObject,  
            JsonConfig paramJsonConfig) {  
        return process(paramObject);  
    }  
      
    private Object process(Object value){  
        if(value instanceof Date){    
            SimpleDateFormat sdf = new SimpleDateFormat(format,Locale.CHINA);    
            return sdf.format(value);  
        }    
        return value == null ? "" : value.toString();    
    }  
}