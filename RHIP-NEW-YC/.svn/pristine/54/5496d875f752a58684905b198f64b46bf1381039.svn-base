package com.founder.rhip.ms;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 * Created by f on 2016/11/7.
 */
@WebService
public interface IMSWebService {
    @WebMethod
    public String searchOutpatientInfo(@WebParam(name = "requestXml") String requestXml);

    @WebMethod
    public String searchInpatientInfo(@WebParam(name = "requestXml") String requestXml);

    /**
     * 查询体检数据列表
     * @param requestXml 请求参数
     * @return  返回参数
     */
    @WebMethod
    public String getPhysiqueExaList(@WebParam(name="requestXml")String requestXml);

    /**
     * 查询体检数据明细
     * @param requestXml 请求参数
     * @return  返回参数
     */
    @WebMethod
    public String getPhysiqueExaDetail(@WebParam(name="requestXml")String requestXml);

    /**
     * 查询检验列表
     * @param requestXml
     * @return
     */
    @WebMethod
    public String getExam(@WebParam(name = "requestXml") String requestXml);

    /**
     * 查询检验详情
     * @param requestXml
     * @return
     */
    @WebMethod
    public String getExamDetail(@WebParam(name = "requestXml") String requestXml);

    /**
     * 查询检查列表
     * @param requestXml
     * @return
     */
    @WebMethod
    public String getStudy(@WebParam(name = "requestXml") String requestXml);

    /**
     * 查询检查详情
     * @param requestXml
     * @return
     */
    @WebMethod
    public String getStudyDetail(@WebParam(name = "requestXml") String requestXml);

    /**
     * 查询用药信息
     * @param requestXml
     * @return
     */
    @WebMethod
    public String getDrug(@WebParam(name = "requestXml") String requestXml);

    /**
     * 查询床位情况
     * @param requestXml
     * @return
     */
    @WebMethod
    public String getPatientbed(@WebParam(name = "requestXml") String requestXml);
}
