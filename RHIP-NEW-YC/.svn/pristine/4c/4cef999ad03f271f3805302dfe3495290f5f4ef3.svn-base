package com.founder.rhip.dm;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import org.apache.cxf.interceptor.OutFaultInterceptors;

/**
 * 慢病管理卡接口
 * 
 * @author liuk
 * 
 */
@WebService
@OutFaultInterceptors(interceptors = { "com.founder.rhip.dm.DmErrorInterceptor" })
public interface IDmDiseaseWebService {
	/**
	 * 查询待建卡信息
	 * 
	 * @param idNum 身份证
	 * @param orgCode 所在社区机构编码
	 * @return
	 */
	@WebMethod
	DmDiseaseInfoResult queryToBringIntoInfo(@WebParam(name = "idNum") String idNum, @WebParam(name = "orgCode") String orgCode);
}
