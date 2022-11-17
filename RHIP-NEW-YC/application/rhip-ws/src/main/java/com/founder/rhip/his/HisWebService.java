package com.founder.rhip.his;

import java.util.List;
import java.util.Properties;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import com.founder.fasf.beans.Criteria;
import com.founder.rhip.ehr.dto.HisPersonTypeDto;
import com.founder.rhip.ehr.entity.basic.PersonInfo;
import com.founder.rhip.ehr.service.personal.IPersonalRecordService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.BaseWebService;
import com.founder.rhip.ehr.common.PropertiesUtils;
import com.founder.rhip.ehr.dto.HisWebServiceDto;
import com.founder.rhip.ehr.service.IPastHistoryAnalyzeService;
import com.founder.rhip.ehr.service.IStudyService;
import com.founder.rhip.portal.service.util.XmlWebserviceForUtil;

@Service("hisWebService")
@WebService(serviceName="hisWebService")
public class HisWebService extends BaseWebService implements IHisWebService {

	private static String folder;
	
	private static String error = "请求数据格式不正确";
	
	@Autowired
	private IStudyService studyService;
	
	@Autowired
	private IPastHistoryAnalyzeService pastHistoryAnalyzeService;

	@Autowired
	private IPersonalRecordService personService;
	
	static {
		Properties properties = PropertiesUtils.initProperties("setting");
		if (ObjectUtil.isNotEmpty(properties)) {
			folder = properties.getProperty("his.data.folder");
		}
	}
	
	@Override
	@WebMethod
	public String isStudy30days(@WebParam(name = "requestXml") String requestXml) {
		try {
			XmlWebserviceForUtil.saveDataFile(requestXml,"isStudy30days",folder);
			HisWebServiceDto hisWebServiceDto = XmlWebserviceForUtil.parseDataXml(requestXml,HisWebServiceDto.class);
			return studyService.isStudy30days(hisWebServiceDto);
		} catch (Exception e) {
			e.printStackTrace();
			return XmlWebserviceForUtil.returnError(error);
		} 
	}

	@Override
	@WebMethod
	public String getAnalyse(@WebParam(name = "requestXml") String requestXml) {
		try {
			XmlWebserviceForUtil.saveDataFile(requestXml,"getAnalyse",folder);
			HisWebServiceDto hisWebServiceDto = XmlWebserviceForUtil.parseDataXml(requestXml,HisWebServiceDto.class);
			return pastHistoryAnalyzeService.getAnalyse(hisWebServiceDto);
		} catch (Exception e) {
			e.printStackTrace();
			String errorString =  XmlWebserviceForUtil.returnError(error);
			return errorString;
		}
	}

	/**
	 * @Title: searchPersonType
	 * @Description: 查询体检人员体检类型信息接口
	 * @param @param requestXml
	 * @param @return
	 * @return String
	 * @throws
	 */
	@Override
	@WebMethod
	public String searchPersonType(String requestXml) {
		XmlWebserviceForUtil.saveDataFile(requestXml,"searchPersonType",folder);
		String rsStr ="";
		try {
			HisPersonTypeDto searchDto = XmlWebserviceForUtil.parseDataXml(requestXml,HisPersonTypeDto.class);
			Long id =  searchDto.getId();
			String idcard = searchDto.getIdcard();
			if(id==null&& StringUtils.isEmpty(idcard)){
				String errorString =  XmlWebserviceForUtil.returnResult("1","身份证号和ID不能都为空!");
				return errorString;
			}
			if(StringUtils.isNotEmpty(idcard)&&idcard.length()!=18){
				String errorString =  XmlWebserviceForUtil.returnResult("2","身份证号必须为18位!");
				return errorString;
			}
			Criteria criteria = new Criteria();
			if(id!=null)
				criteria.add("ID",id.toString());
			if(StringUtils.isNotEmpty(idcard))
				criteria.add("idcard",idcard);
			List<PersonInfo> list = personService.getPersonRecordList(criteria);
			if(list==null||list.isEmpty()){
				String errorString =  XmlWebserviceForUtil.returnResult("3","查无此人!");
				return errorString;
			}
			else if(list.size()>1){
				String errorString =  XmlWebserviceForUtil.returnResult("4","该身份证号【"+idcard+"】有"+list.size()+"条重复数据，请联系平台维护人员!");
				return errorString;
			}
			PersonInfo personInfo = list.get(0);
			HisPersonTypeDto result = new HisPersonTypeDto();
			result.setId(personInfo.getId());
			result.setIdcard(personInfo.getIdcard());
			result.setName(personInfo.getName());
			result.setRemarks(personInfo.getRemarks());
			String rsXml = XmlWebserviceForUtil.getString(result,HisPersonTypeDto.class);
			rsStr = XmlWebserviceForUtil.returnResult("0",rsXml);

		} catch (Exception e) {
			e.printStackTrace();
			String errorString =  XmlWebserviceForUtil.returnResult("5",error);
			return errorString;
		}
		return rsStr;
	}


}
