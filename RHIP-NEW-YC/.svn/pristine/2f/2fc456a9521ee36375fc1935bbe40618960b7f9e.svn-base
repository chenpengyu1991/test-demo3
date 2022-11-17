package com.founder.rhip.ws.ehr;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.OP;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.BaseWebService;
import com.founder.rhip.ehr.common.EHRConstants;
import com.founder.rhip.ehr.entity.basic.PersonInfo;
import com.founder.rhip.ehr.service.IHealthEventService;
import com.founder.rhip.ehr.service.personal.IPersonalRecordService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.jws.WebService;

@Service("personInfoWebService")
@WebService(serviceName = "personInfoService")
public class PersonInfoWebService extends BaseWebService implements IPersonInfoWebService {

	private Logger log = LoggerFactory.getLogger(getClass());
	
	private static final int EHR_STATUS_NO = -1;
	private static final int EHR_STATUS_NO_READY = 0;
	private static final int EHR_STATUS_OK = 1;
	private static final int EHR_STATUS_LOGOUT = 2;
	
	private static final int EHR_STAR_0 = 0;
	private static final int EHR_STAR_1 = 1;
	private static final int EHR_STAR_2 = 2;
	private static final int EHR_STAR_3 = 3;
	
	@Autowired
	private IPersonalRecordService personalRecordService;
	
	
	@Autowired
	private IHealthEventService healthEventService;

	@Override
	public String getPersonalStatus(String idcardString) {
		
		log.error(idcardString);
		try{
//			if (ObjectUtil.isNullOrEmpty(idcardString)) {
//				return returnErrString("请求数据不正确");
//			}
//
//			idcardString = idcardString.replaceAll(" ", "");
//			int beginIndex = idcardString.indexOf("<idNo>") + 6;
//			int endIndex = idcardString.indexOf("</idNo>");
//
//			if (beginIndex < 0 || endIndex < 0) {
//				return returnErrString("请求数据不正确");
//			}

//			String idCard = idcardString.substring(beginIndex, endIndex);
			
			String idCard = idcardString;
			
			if (ObjectUtil.isNullOrEmpty(idCard)) {
				return returnErrString("请求数据不正确");
			}

			Criteria criteria = new Criteria("idcard", idCard).add("filingFlag", OP.NE, EHRConstants.UN_CREATE);
			PersonInfo person = personalRecordService.getPersonRecord(criteria);
			
			if(ObjectUtil.isNullOrEmpty(person)){
				return returnOKString(EHR_STATUS_NO,EHR_STAR_0);
			}
			
			if(person.getFilingFlag().equals("0")){
				return returnOKString(EHR_STATUS_NO,EHR_STAR_0);
			}
			
			if(person.getFilingFlag().equals("9")){
				return returnOKString(EHR_STATUS_LOGOUT,EHR_STAR_0);
			}
			
			int star = person.getStar();
			
			return returnOKString(getStatus(person.getId()),star);
			
		}catch(Exception e){
			e.printStackTrace();
			log.error(e.toString());
			return returnErrString("接口异常");
		}
	}

	private String returnErrString(String errorString) {
		System.out.println("==========" + errorString);
		return "ERROR|" + errorString;
	}

	private String returnOKString(int okType, int star) {
		String msg = "OK|" + okType + "|" + star;
		System.out.println("==========" +msg);
		return msg;
	}

	private int getStatus(Long personId){
		Criteria criteria = new Criteria("personId", personId);
		int k = healthEventService.checkPersonRecordStatus(criteria);
		if(k != 7 && k != 0){
			return EHR_STATUS_NO_READY;
		}
		return EHR_STATUS_OK;
	}
}
