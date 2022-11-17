package com.founder.rhip.his;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService
public interface IHisWebService {
	
	/** 
	* @Title: isStudy30days 
	* @Description: 患者在最近的三十天是否做过同样检查 1：是 0：否
	* @param @param requestXml
	* @param @return
	* @return String
	* @throws 
	*/
	@WebMethod
	public String isStudy30days(@WebParam(name = "requestXml") String  requestXml);
	
	
	/** 
	* @Title: getAnalyse 
	* @Description: 查询患者过敏信息信息接口
	* @param @param requestXml
	* @param @return
	* @return String
	* @throws 
	*/
	@WebMethod
	public String getAnalyse(@WebParam(name = "requestXml") String  requestXml);

	/**
	 * @Title: searchPersonType
	 * @Description: 查询体检人员体检类型信息接口
	 * @param @param requestXml
	 * @param @return
	 * @return String
	 * @throws
	 */
	@WebMethod
	public String searchPersonType(@WebParam(name = "requestXml") String  requestXml);

}
