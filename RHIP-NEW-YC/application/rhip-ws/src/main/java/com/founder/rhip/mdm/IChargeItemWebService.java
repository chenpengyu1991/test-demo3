package com.founder.rhip.mdm;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import com.founder.rhip.mdm.entity.SzdTophoschargeitem;

import java.util.List;

@WebService
public interface IChargeItemWebService {

	@WebMethod
	public String downloadMedicine(@WebParam(name = "param") String param);

	@WebMethod
	public String uploadChargeItems(@WebParam(name = "param") String param);

	@WebMethod
	public List<SzdTophoschargeitem> downloadTopHosChargeItems (
			@WebParam(name = "saasId") String saasId,
			@WebParam(name = "organizationId") String organizationId,
			@WebParam(name = "type") String type,
			@WebParam(name = "lastDownloadTime") String lastDownloadTime
			) throws Exception;

	@WebMethod
	public String isExistInBaseList(@WebParam(name = "param") String param);
}
