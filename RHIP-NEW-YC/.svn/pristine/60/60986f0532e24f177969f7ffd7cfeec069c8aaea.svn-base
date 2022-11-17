package com.founder.rhip.referral;

import java.util.*;

import javax.annotation.Resource;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import com.founder.rhip.portal.service.util.HttpClientUtil;
import net.sf.json.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.BaseWebService;
import com.founder.rhip.ehr.common.IDCardUtil;
import com.founder.rhip.ehr.common.PropertiesUtils;
import com.founder.rhip.ehr.entity.clinic.ReferralInfo;
import com.founder.rhip.ehr.service.IDualReferralService;
import com.founder.rhip.mdm.app.IOrganizationApp;
import com.founder.rhip.portal.dto.GetDualReferralResultResponse;
import com.founder.rhip.portal.dto.GetReferralInfoResponse;
import com.founder.rhip.portal.service.util.ValidateUtil;
import com.founder.rhip.portal.service.util.XmlWebserviceForUtil;

@Service("referralWebService")
@WebService(serviceName = "referralWebService")
public class ReferralWebService extends BaseWebService implements IReferralWebService {

    private static String folder;
    private static String APPURL;
    private final static String FORMAT_ERROR = "请求数据格式不正确";
    private final static String EMPTY_ERROR = "请求参数不能为空!";
    private final static String FAIL = "0";
    private final static String SUCCESS = "1";
    private final static String ACCEPT = "accept";
    private final static String REFUSE = "refuse";
    protected static Logger logger = Logger.getLogger(ReferralWebService.class);

    @Resource
    private IDualReferralService dualReferralService;

    @Resource(name = "organizationApp")
    private IOrganizationApp organizationApp;

    static {
        Properties properties = PropertiesUtils.initProperties("setting");
        if (ObjectUtil.isNotEmpty(properties)) {
            folder = properties.getProperty("referral.data.folder");
            APPURL = properties.getProperty("referral.app.href");
        }
    }

    @Override
    @WebMethod
    public String dualReferral(@WebParam(name = "requestXml") String requestXml) {
        ReferralInfo referralInfo;
        try {
            XmlWebserviceForUtil.saveDataFile(requestXml, "dualReferral", folder);
            referralInfo = XmlWebserviceForUtil.parseDataXml(requestXml, ReferralInfo.class);
        } catch (Exception e) {
            e.printStackTrace();
            return XmlWebserviceForUtil.returnResult(FAIL, FORMAT_ERROR);
        }
        if (referralInfo == null)
            return XmlWebserviceForUtil.returnResult(FAIL, EMPTY_ERROR);
        String validateString = ValidateUtil.doValidate(referralInfo, "name", "idCard", "destDeptCode", "destDeptName", "referralDoctorName",
                "referralHospitalCode", "referralHospitalName", "dualReferralType", "referralDate");
        if (ObjectUtil.isNotEmpty(validateString)) {
            return XmlWebserviceForUtil.returnResult(FAIL, validateString);
        }
        initReferralInfo(referralInfo);
        int i = dualReferralService.save(referralInfo);
        if (i > 0) {
            GetDualReferralResultResponse getDualReferralResultResponse = new GetDualReferralResultResponse();
            getDualReferralResultResponse.setRtnCode(SUCCESS);
            getDualReferralResultResponse.setRtnMessage("转诊成功");
            getDualReferralResultResponse.setReferralCode(referralInfo.getReferralCode());
            return XmlWebserviceForUtil.getString(getDualReferralResultResponse, GetDualReferralResultResponse.class);
        } else
            return XmlWebserviceForUtil.returnResult(FAIL, "转诊失败");
    }

    /***
     * 初始化ReferralInfo
     * @param referralInfo
     */
    private void initReferralInfo(ReferralInfo referralInfo) {
        if ("2".equals(referralInfo.getDualReferralType())) {
            referralInfo.setDiagnosis(referralInfo.getPrimaryDiagnosis());
            referralInfo.setCheckResult(referralInfo.getReferralReason());
            referralInfo.setTreatment(referralInfo.getTreatment());
            referralInfo.setPrimaryDiagnosis(StringUtils.EMPTY);
            referralInfo.setReferralReason(StringUtils.EMPTY);
            referralInfo.setTreatment(StringUtils.EMPTY);
        }
        referralInfo.setReferralCode(getReferralCode());//生成18位转诊唯一码
        referralInfo.setGender(IDCardUtil.getGenderByIdCard(referralInfo.getIdCard()));
        referralInfo.setBirthday(IDCardUtil.getBirthDateByIdCard(referralInfo.getIdCard()));
        referralInfo.setIsDelete(0);//0:未删除 1:已删除
        referralInfo.setUpdateTime(new Date());
        referralInfo.setReferralSource(1);// 1: APP  2:平台  3:医院
        referralInfo.setReferralStatus(0);// 0:未接收  1:已接受  2:拒绝接收
        referralInfo.setIntegratedData(0);
        referralInfo.setUpdateOrgan("01008610-0");//暂定为银川市卫生和计划生育委员会
        referralInfo.setUpdatePerson("App");
    }

    @Override
    public String searchReferralHospInfo(String requestXml) {
        ReferralInfo referralInfo;
        try {
            XmlWebserviceForUtil.saveDataFile(requestXml, "searchReferralHospInfo", folder);
            referralInfo = XmlWebserviceForUtil.parseDataXml(requestXml, ReferralInfo.class);
        } catch (Exception e) {
            e.printStackTrace();
            return XmlWebserviceForUtil.returnResult(FAIL, FORMAT_ERROR);
        }
        if (StringUtil.isNullOrEmpty(referralInfo.getReferralHospitalCode())) {
            return XmlWebserviceForUtil.returnResult(FAIL, "机构编码不能为空！");
        }
        Map<String, String> organizations = organizationApp.queryAllOrganizationMap();
        if (!organizations.containsKey(StringUtils.trimToEmpty(referralInfo.getReferralHospitalCode()))) {
            return XmlWebserviceForUtil.returnResult(FAIL, "机构编码无效！");
        }
        if (StringUtil.isNullOrEmpty(referralInfo.getIdCard())) {
            return XmlWebserviceForUtil.returnResult(FAIL, "患者身份证号不能为空！");
        }
        Criteria criteria = new Criteria("referralHospitalCode", StringUtils.trimToEmpty(referralInfo.getReferralHospitalCode()));
        criteria.add("idCard", StringUtils.trimToEmpty(referralInfo.getIdCard()));
        criteria.add("dualReferralType", "1");//（转出类型）医院接收
        criteria.add("isDelete", 0);
        if (StringUtil.isNotEmpty(referralInfo.getReferralCode())) {//转诊唯一码可为空
            criteria.add("referralCode", StringUtils.trimToEmpty(referralInfo.getReferralCode()));
        }
        GetReferralInfoResponse getReferralInfoResponse;
        List<ReferralInfo> referralLists = dualReferralService.getList(criteria);
        if (ObjectUtil.isNullOrEmpty(referralLists)) {
            getReferralInfoResponse = new GetReferralInfoResponse();
            getReferralInfoResponse.setRtnCode(FAIL);
            getReferralInfoResponse.setRtnMessage("没有该患者的转诊记录");
        } else {
            getReferralInfoResponse = new GetReferralInfoResponse();
            getReferralInfoResponse.setRtnCode(SUCCESS);
            getReferralInfoResponse.setRtnMessage("查询成功");
            getReferralInfoResponse.setReferralInfo(referralLists);
        }
        return XmlWebserviceForUtil.getString(getReferralInfoResponse, GetReferralInfoResponse.class);
    }

    @Override
	public String searchReferralCommInfo(String requestXml) {
		ReferralInfo referralInfo;
        try {
            XmlWebserviceForUtil.saveDataFile(requestXml, "searchReferralCommInfo", folder);
            referralInfo = XmlWebserviceForUtil.parseDataXml(requestXml, ReferralInfo.class);
        } catch (Exception e) {
            e.printStackTrace();
            return XmlWebserviceForUtil.returnResult(FAIL, FORMAT_ERROR);
        }
        if (StringUtil.isNullOrEmpty(referralInfo.getReferralHospitalCode())) {
            return XmlWebserviceForUtil.returnResult(FAIL, "机构编码不能为空！");
        }
        Map<String, String> organizations = organizationApp.queryAllOrganizationMap();
        if (!organizations.containsKey(StringUtils.trimToEmpty(referralInfo.getReferralHospitalCode()))) {
            return XmlWebserviceForUtil.returnResult(FAIL, "机构编码无效！");
        }
        Criteria criteria = new Criteria("referralHospitalCode", StringUtils.trimToEmpty(referralInfo.getReferralHospitalCode()));
        criteria.add("dualReferralType", "2");//（回转类型）社区服务站接收
        criteria.add("isDelete", 0);
        if(StringUtil.isNotEmpty(referralInfo.getIdCard())) {//患者身份证号可为空
        	criteria.add("idCard", StringUtils.trimToEmpty(referralInfo.getIdCard()));
        }
        if (StringUtil.isNotEmpty(referralInfo.getReferralCode())) {//转诊唯一码可为空
            criteria.add("referralCode", StringUtils.trimToEmpty(referralInfo.getReferralCode()));
        }
        GetReferralInfoResponse getReferralInfoResponse;
        List<ReferralInfo> referralLists = dualReferralService.getList(criteria);
        if (ObjectUtil.isNullOrEmpty(referralLists)) {
            getReferralInfoResponse = new GetReferralInfoResponse();
            getReferralInfoResponse.setRtnCode(FAIL);
            getReferralInfoResponse.setRtnMessage("没有该患者的转诊记录");
        } else {
            getReferralInfoResponse = new GetReferralInfoResponse();
            getReferralInfoResponse.setRtnCode(SUCCESS);
            getReferralInfoResponse.setRtnMessage("查询成功");
            getReferralInfoResponse.setReferralInfo(referralLists);
        }
        return XmlWebserviceForUtil.getString(getReferralInfoResponse, GetReferralInfoResponse.class);
	}
    
    @Override
    public String receivePatient(String requestXml) {

        ReferralInfo referralInfo;
        try {
            XmlWebserviceForUtil.saveDataFile(requestXml, "receivePatient", folder);
            referralInfo = XmlWebserviceForUtil.parseDataXml(requestXml, ReferralInfo.class);
        } catch (Exception e) {
            e.printStackTrace();
            //转换出错
            return XmlWebserviceForUtil.returnResult(FAIL, FORMAT_ERROR);
        }
        //传值为空
        if (referralInfo == null) {
            return XmlWebserviceForUtil.returnResult(FAIL, EMPTY_ERROR);
        }
        //验证请求必填项
        String validateString = ValidateUtil.doValidate(referralInfo, "referralCode", "referralStatus");
        if (ObjectUtil.isNotEmpty(validateString)) {
            return XmlWebserviceForUtil.returnResult(FAIL, validateString);
        }
        Criteria criteria = new Criteria("referralCode", StringUtils.trimToEmpty(referralInfo.getReferralCode()));
        String refStatus = StringUtils.trimToEmpty(referralInfo.getReferralStatus().toString());
        //查询转诊记录
        ReferralInfo referralInfoDB = dualReferralService.getReferralInfo(criteria);
        //转诊记录不存在抛出异常
        if (ObjectUtil.isNullOrEmpty(referralInfoDB)) {
            return XmlWebserviceForUtil.returnResult(FAIL, "转诊记录不存在！");
        }
        //返回给APP的状态
        String refResult = "";
        if ("0".equals(refStatus)) {
            //拒绝接收患者
            referralInfoDB.setReferralStatus(2);
            refResult = REFUSE;
            if (StringUtil.isNotEmpty(referralInfo.getRefuseReason())) {
                //拒绝理由
                referralInfoDB.setRefuseReason(referralInfo.getRefuseReason());
            }
        } else if ("1".equals(refStatus)) {
            refResult = ACCEPT;
            //接收患者
            referralInfoDB.setReferralStatus(1);
        } else {
            return XmlWebserviceForUtil.returnResult(FAIL, "请传入正确referralStatus（接收状态）的值");
        }
        int i = dualReferralService.save(referralInfoDB);
        if (i > 0) {
            //向APP方发送转诊状态
            sendRefStatus(referralInfo.getReferralCode(), referralInfo.getRefuseReason(), refResult);
            return XmlWebserviceForUtil.returnResult(SUCCESS, "更新患者就诊状态成功");
        } else {
        	return XmlWebserviceForUtil.returnResult(FAIL, "更新患者就诊状态失败");
        }
    }

	/***
     * 生成18位转诊唯一码
     * @return
     */
    private String getReferralCode() {
        long current = System.currentTimeMillis();
        String k  =String.valueOf(current);
        int length = 5;
        for (int i = 0; i < length; i++) {
            int temp = (int) (Math.random() * 9);
            k = k + temp;
        }
        return k;
    }

    private void sendRefStatus(String refCode, String refuseReason, String refResult){
    	StringBuilder param = new StringBuilder();
    	param.append("referralCode=").append(refCode);//转诊唯一码
    	param.append("&result=").append(refResult);//accept|refuse
    	if(REFUSE.equals(refResult)) {
    		param.append("&data=").append("拒绝原因："+refuseReason);
    	}
        //发送状态给APP
        String res = HttpClientUtil.sendPost1(APPURL,param.toString());
        JSONObject jsonResult = JSONObject.fromObject(res);
        String resCode = String.valueOf(jsonResult.get("code"));
        if(!"0".equals(resCode)) {
            logger.debug("发送app转诊状态通知失败，失败原因"+(String)jsonResult.get("message"));
        }
    }


}
