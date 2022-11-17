package com.founder.rhip.cpw;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 * 医院床位情况数据WEBSERVICE接口
 * 
 * @version 1.0, 2014-7-3
 * @author Ye jianfei
 */
@WebService
public interface ISickbedStateWebService {
	/**
	 * 医院床位情况数据管理
	 * 
	 * @param cpwXml
	 * @return
	 */
	@WebMethod
	String uploadSickbedState(@WebParam(name = "requestXml") String sickbedStateXml);
}
