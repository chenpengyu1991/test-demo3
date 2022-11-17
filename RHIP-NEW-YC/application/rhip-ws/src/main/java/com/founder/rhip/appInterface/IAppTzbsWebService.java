package com.founder.rhip.appInterface;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 * Created by admin on 2016/12/13.
 */
@WebService
public interface IAppTzbsWebService {

    @WebMethod
    TzbsResultData tzbsDataProcess(@WebParam(name = "requestXml") String requestXml);

   /* @WebMethod
    TzpgResultDate  zwpgDataProcess(@WebParam(name = "requestXml") String requestXml);*/
}
