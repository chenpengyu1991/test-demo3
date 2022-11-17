package com.founder.rhip.hsa;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 * 相对管理人
 * 
 * @author liuk
 * 
 */
@WebService
public interface ILocationWebService {
	/**
	 * Import locations.
	 * 
	 * @param locationsXml
	 *            the locations xml
	 * @return the string
	 */
	@WebMethod
	String updateLocations(@WebParam(name = "requestXml") String locationsXml);

	/**
	 * Import penaltys.
	 * 
	 * @param locationsXml
	 *            the locations xml
	 * @return the string
	 */
	@WebMethod
	String updatePenaltys(@WebParam(name = "requestXml") String locationsXml);

}
