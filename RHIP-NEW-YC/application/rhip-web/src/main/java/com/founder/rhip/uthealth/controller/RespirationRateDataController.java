package com.founder.rhip.uthealth.controller;

import com.founder.fasf.beans.PageList;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.BaseController;
import com.founder.rhip.ehr.common.PropertiesUtils;
import com.founder.rhip.uthealth.controller.util.HttpClientUtil;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.*;

/**
 * Created by bagen on 16/11/16.
 */
@Controller
@RequestMapping("/uthealth/respirationRate")
public class RespirationRateDataController extends BaseController {

    public static final String REQUEST_USERS_URL = "/h_users/searchBF";
    public static final String RESPONSE_SUCCESS_CODE = "200";

    private static Properties properties =  PropertiesUtils.initProperties("common-web");
    private static String UTHEALTH_URL = "href.uthealth";

    /**
     * 查询页面
     * @param model
     * @param request
     * @return
     */
    @RequestMapping("/search")
    public String search(ModelMap model, HttpServletRequest request) {
        return "rhip.health.home.rr.search";
    }

    /**
     * 查询列表
     * @param model
     * @param request
     * @param keyword 用户编码
     * @param startTime 开始时间
     * @param endTime 结束时间
     * @return
     */
    @RequestMapping(value = "/list")
    public String goToList(ModelMap model, HttpServletRequest request,String keyword, String startTime, String endTime) {
        String pageIndex = request.getParameter("pageIndex");
        int currentPage = Integer.valueOf(pageIndex);
        String orgCode = getOrgMapping(request);
        Map<String,Object> reqMap = new HashMap<>();
        if (StringUtil.isNotEmpty(keyword)){
            reqMap.put("keyword",keyword);
        }
        if (StringUtil.isNotEmpty(startTime)){
            reqMap.put("startTime",startTime);
        }
        if (StringUtil.isNotEmpty(endTime)){
            reqMap.put("endTime",endTime);
        }
        if(StringUtil.isNotEmpty(orgCode)){
            reqMap.put("orgCode",orgCode);
        }
        PageList<Map<String, Object>> plist = getBPList(currentPage,reqMap);
        model.addAttribute("userList", plist.getList());
        model.addAttribute("page", plist.getPage());
        return "rhip.health.home.rr.list";
    }

    /**
     * 获取数据
     * @param pageIndex
     * @param reqMap
     * @return
     */
    private PageList<Map<String, Object>> getBPList(int pageIndex, Map<String, Object> reqMap){
        PageList<Map<String, Object>> pageList = new PageList<>();
        String baseUrl = properties.getProperty(UTHEALTH_URL);
        // 发送POST请求
        String ret = HttpClientUtil.sendPost(baseUrl + REQUEST_USERS_URL,getRequestParam(pageIndex,reqMap));
        JSONObject httpResponse = JSONObject.fromObject(ret);
        logger.debug(httpResponse);
        List<Map<String,Object>> userList = new ArrayList<>();
        if(ObjectUtil.isNotEmpty(httpResponse)){
            JSONObject userData = httpResponse.getJSONObject("data");
            JSONArray items = userData.getJSONArray("items");
            for (int i = 0; i < items.size(); i++) {
                JSONObject userObj = (JSONObject)items.get(i);
                Map<String,Object> userMap = new HashMap<>();
                if(ObjectUtil.isNotEmpty(userObj)){
                    userMap.put("userName",userObj.getString("userName"));//用户名称
                    userMap.put("userId",userObj.getString("userId"));//用户编码
                    BigDecimal breathFreq = BigDecimal.ZERO;
                    if(StringUtil.isNotEmpty((String) userObj.getString("breathFreq"))) {
                        breathFreq = new BigDecimal((String) userObj.getString("breathFreq"));
                    }
                    userMap.put("breathFreq",breathFreq.setScale(2,BigDecimal.ROUND_HALF_UP));
                    userMap.put("breathFreqLevelName",userObj.getString("breathFreqLevelName"));

                    String checkDate = userObj.getString("check_at");
                    if(checkDate.length() >19){
                        checkDate = checkDate.substring(0,10)+" "+checkDate.substring(11,19);
                    }
                    userMap.put("checkDate",checkDate);//测量时间
                    userMap.put("create_at",userObj.getString("create_at"));//入库时间
                }
                userList.add(userMap);
            }
        }
        pageList.setList(userList);
        pageList.setPage(getPageInfo(httpResponse));
        return pageList;
    }

    /**
     * 组装参数
     * @param pageIndex
     * @param reqMap
     * @return
     */
    private String getRequestParam(int pageIndex,Map<String, Object> reqMap){
        StringBuffer result = new StringBuffer("limit=10");
        for(String key : reqMap.keySet()){
            result.append("&"+key+"="+reqMap.get(key));
        }
        if(ObjectUtil.isNotEmpty(pageIndex)){
            result.append("&page=" + pageIndex);
        }
        return result.toString();
    }
}
