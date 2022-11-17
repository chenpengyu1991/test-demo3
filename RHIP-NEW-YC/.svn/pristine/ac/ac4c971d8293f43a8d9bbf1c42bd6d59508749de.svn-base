package com.founder.rhip.ehr.controller.external;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.util.Base64Util;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.BaseController;
import com.founder.rhip.cdm.service.IHealthPalnService;
import com.founder.rhip.cdm.service.IStandardizationService;
import com.founder.rhip.ehr.entity.basic.PersonInfo;
import com.founder.rhip.ehr.entity.clinic.ElderlyPhyExamination;
import com.founder.rhip.ehr.service.IHealthEventService;
import com.founder.rhip.ehr.service.basic.IEhrSecurityService;
import com.founder.rhip.ehr.service.personal.IPersonalRecordManagmentService;
import com.founder.rhip.ehr.service.personal.IPersonalRecordService;
import com.founder.rhip.ehr.service.personal.IPlatformService;
import com.founder.rhip.hm.service.IPhysicalExamRecordService;
import com.founder.rhip.idm.service.IReportService;
import com.founder.rhip.mdm.app.IDictionaryApp;
import com.founder.rhip.mdm.app.IOrganizationApp;
import com.founder.rhip.mdm.service.IStaffService;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 基层医疗接口
 */
@Controller
@RequestMapping("/physicalExamExternal")
public class PhysicalExamExternalController extends BaseController {

  private static Logger logger = Logger.getLogger(PhysicalExamExternalController.class);

  private IHealthPalnService healthPalnService;

  @Resource(name = "physicalExamRecordService")
  private IPhysicalExamRecordService physicalExamRecordService;

  @Resource(name = "personalRecordService")
  private IPersonalRecordService personalRecordService;


  /**
   * 增加老年人指导和评估
   */
  @RequestMapping("/evaluationAndGuide")
  public String addPersonRecordIni(HttpServletRequest request, HttpServletResponse response,
      ModelMap model, String queryString) {
    String url = "rhip.ehr.hm.evaluation.init";

    Map<String, Object[]> paramMap = new HashMap<String, Object[]>();
    paramMap = decryptByCharset(queryString, paramMap);
    if (ObjectUtil.isNullOrEmpty(paramMap)) {//参数为空或参数格式错误
      model.addAttribute("errorStr", "参数为空或参数格式错误!");
      return url;
    }
    String idCard = getFieldValue(paramMap, "idCard");
    String examYear = getFieldValue(paramMap, "examYear");
    if (StringUtil.isNullOrEmpty(idCard)) {
      model.addAttribute("errorStr", "身份证不能为空!");
      return url;
    }
    int result = physicalExamRecordService
        .hasPhysicalExam(new Criteria("idcard", idCard), examYear);
    switch (result) {
      case 0:
        model.addAttribute("errorStr", "外部评估指导只针对65岁以上的建档老人!");
        break;
      case 2:
        model.addAttribute("errorStr", "该老年人本年度已经做过评估和指导!");
        break;
      case 1:
        Criteria criteria = new Criteria();
        criteria.add("IDCARD", idCard);
        PersonInfo personInfo = personalRecordService.getPersonRecord(criteria);
        model.addAttribute("personInfo", personInfo);
        break;
      default:
        break;
    }
    return url;

  }

  @RequestMapping(value = "/saveEvaluation")
  @ResponseBody
  public Object saveEvaluation(ElderlyPhyExamination elderlyPhyExamination, HttpServletRequest request,HttpServletResponse response){
    Boolean result = false;
    if(ObjectUtil.isNullOrEmpty(elderlyPhyExamination)){
       result = false;
    }else{
      int res =  physicalExamRecordService.saveEvaluation(elderlyPhyExamination);
      if(1 == res){
        result = true;
      }
    }
    return result;
  }


  /**
   * 将参数字符串转换为map
   */
  private Map<String, Object[]> convertQueryToReport(String query) {
    Map<String, Object[]> map = new HashMap<String, Object[]>();
    String params[] = query.split("&");
    for (String param : params) {
      if (param.indexOf("=") > 0) {
        String keyValues[] = param.split("=");
        if (keyValues.length == 2) {
          String value = keyValues[1];
          value = value == null ? "" : value.trim();
          map.put(keyValues[0], new Object[]{value});
        } else if (keyValues.length == 1) {
          map.put(keyValues[0], new Object[]{""});
        }
      }
    }
    return map;
  }

  /**
   * map中获取String值 ,null则返回""
   */
  private String getFieldValue(Map<String, Object[]> map, String key) {
    if (!map.containsKey(key)) {
      return "";
    }
    return map.get(key)[0].toString();
  }


  private Map<String, Object[]> decryptByCharset(String queryString, Map<String, Object[]> map) {
    String parameters = "";
    if (ObjectUtil.isNullOrEmpty(queryString)) {
      //没有参数或者参数错误
      return null;
    }
    //先用UTF-8解析看有没有编码参数
    parameters = Base64Util.decrypt(queryString, "UTF-8");
    if (parameters.indexOf("=") == -1) {
      //没有参数或者参数解析失败
      return null;
    }

    if (ObjectUtil.isNotEmpty(parameters)) {
      try {
        map = convertQueryToReport(parameters);
      } catch (Exception e) {
        //参数解析失败
        return null;
      }
    }

    //以下判断按照什么编码原则解析参数
    String charsetName = "";
    charsetName = getFieldValue(map, "charsetName");
    //没有编码参数默认是GB2312
    if (ObjectUtil.isNullOrEmpty(charsetName)) {
      // 默认中文编码是GB2312
      parameters = Base64Util.decrypt(queryString, "GB2312");
    } else if (!charsetName.equalsIgnoreCase("UTF-8")) {//有编码参数但是不是UTF-8
      parameters = Base64Util.decrypt(queryString, charsetName);
    }
    //以下按照什么编码原则分拆参数
    try {
      if (ObjectUtil.isNotEmpty(parameters) && ObjectUtil.isNullOrEmpty(charsetName)) {
        map = convertQueryToReport(parameters);
      } else if (ObjectUtil.isNotEmpty(parameters) && !charsetName.equalsIgnoreCase("UTF-8")) {
        map = convertQueryToReport(parameters);
      }
    } catch (Exception e) {
      //参数解析失败
      return null;
    }
    return map;
  }
}