package com.founder.rhip.referral;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService
public interface IReferralWebService {

	/***
	 * 新增医疗结构转诊
	 * @param requestXml
	 * @return
	 */
	@WebMethod
	public String dualReferral(@WebParam(name = "requestXml") String  requestXml);
	
	/***
	 * 查询机构转诊信息(医院方)
	 * @param requestXml
	 * @return
	 */
	@WebMethod
	public String searchReferralHospInfo(@WebParam(name= "requestXml") String  requestXml);

	/***
     * 查询机构转诊信息(社区服务站方)
     * @param requestXml
     * @return
     */
    public String searchReferralCommInfo(@WebParam(name= "requestXml") String  requestXml);
    
    /***
     * 更新患者转诊状态
     * @param requestXml
     * @return respose
     */
    @WebMethod
    public String receivePatient(@WebParam(name= "requestXml") String  requestXml);
    
}
