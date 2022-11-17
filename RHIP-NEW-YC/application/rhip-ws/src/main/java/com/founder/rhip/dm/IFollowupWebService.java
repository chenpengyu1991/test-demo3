package com.founder.rhip.dm;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import org.apache.cxf.interceptor.OutFaultInterceptors;

/**
 * 随访提醒接口
 * @author liuk
 *
 */
@WebService
@OutFaultInterceptors(interceptors = { "com.founder.rhip.dm.DmErrorInterceptor" })
public interface IFollowupWebService {
	/**
	 * 查询是否有提醒
	 * @param idNum 身份证
	 * @param name 姓名
	 * @return
	 */
	@WebMethod
	FollowupInfoResult queryFollowupInfo(@WebParam(name = "idNum") String idNum, @WebParam(name = "name") String name);
}
