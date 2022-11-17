package com.founder.rhip.yitiji;

import com.founder.rhip.ehr.entity.basic.FingerInfo;
import com.founder.rhip.mdm.entity.Person;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.List;

/**
 *
 *
 * Created by f on 2018/8/9.
 */
@WebService
public interface IYiTiJiWebService {
    /**
     * @api {POST} /yiTiJiWebService?wsdl 根据身份证号获取指纹
     * @apiName 获取指纹模板
     * @apiVersion 1.0.1
     * @apiGroup queryFingerInfo
     *
     * @apiParam {String} idCard 身份证号
     *
     * @apiParamExample xml格式请求
     *  <soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:yit="http://yitiji.rhip.founder.com/">
     *  <soapenv:Header/>
     *  <soapenv:Body>
     *  <yit:queryFingerInfo>
     *  <idCard>320520194506203653</idCard></yit:queryFingerInfo>
     *  </soapenv:Body>
     *  </soapenv:Envelope>
     * @apiSuccess {String} data 返回数据
     *
     * @apiSuccessExample {yaml} 查询成功返回
     *  <soap:Envelope xmlns:soap="http://schemas.xmlsoap.org/soap/envelope/">
     *  <soap:Body>
     *  <ns2:queryFingerInfoResponse xmlns:ns2="http://yitiji.rhip.founder.com/">
     *  <return>
     *  <code>1</code>
     *  <fingerTmp>Q9TUzIxAAAETFAECAUHCc7QAAAET</fingerTmp>
     *  <message>查询成功!</message>
     *  </return>
     *  </ns2:queryFingerInfoResponse>
     *  </soap:Body>
     *  </soap:Envelope>
     * @apiSuccessExample {yaml} 查询不到指纹
     *  <soap:Envelope xmlns:soap="http://schemas.xmlsoap.org/soap/envelope/">
     *  <soap:Body>
     *  <ns2:queryFingerInfoResponse xmlns:ns2="http://yitiji.rhip.founder.com/">
     *  <return>
     *  <code>0</code>
     *  <message>查询不到指纹信息!</message>
     *  </return>
     *  </ns2:queryFingerInfoResponse>
     *  </soap:Body>
     *  </soap:Envelope>
     * @apiSuccessExample {xml} 用户不存在
     *  <soap:Envelope xmlns:soap="http://schemas.xmlsoap.org/soap/envelope/">
     *  <soap:Body>
     *  <ns2:queryFingerInfoResponse xmlns:ns2="http://yitiji.rhip.founder.com/">
     *  <return>
     *  <code>2</code>
     *  <message>用户不存在!</message>
     *  </return>
     *  </ns2:queryFingerInfoResponse>
     *  </soap:Body>
     *  </soap:Envelope>
     *
     **/
    @WebMethod
    public FingerInfoRs queryFingerInfo(
            @WebParam(name = "idCard")String idCard);
}

