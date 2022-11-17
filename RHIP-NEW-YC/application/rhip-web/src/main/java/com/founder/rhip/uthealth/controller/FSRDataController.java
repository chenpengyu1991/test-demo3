package com.founder.rhip.uthealth.controller;

import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.BaseController;
import com.founder.rhip.ehr.common.WebProperties;
import com.founder.rhip.uthealth.controller.util.HttpClientUtil;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by haiyingjiang on 16/11/16.
 * 获取血氧/心率/体温数据
 */
@Controller
@RequestMapping("/fsr")
public class FSRDataController extends BaseController {

    public static Map<String, String> testTypeMap = new HashMap<String, String>();
    public static Map<String, Map<String, String>> levelMap = new HashMap<String, Map<String, String>>();

    private void init() {
//      fatigue——精神疲劳 sentiment——情绪指数  resistance——抵抗力
        testTypeMap.put("fatigue", "精神疲劳");
        testTypeMap.put("sentiment", "情绪指数");
        testTypeMap.put("resistance", "抵抗力");
//      fatigue-1：正常 2：轻度 3：中度 4：重度  sentiment-1：正常 2：紧张 3：焦虑 4：抑郁  resistance-1：好 2：正常 3：下降 4：严重下降
        Map<String, String> fatigueMap = new HashMap<String, String>();
        fatigueMap.put("1", "正常");
        fatigueMap.put("2", "轻度");
        fatigueMap.put("3", "中度");
        fatigueMap.put("4", "重度");
        levelMap.put("fatigue", fatigueMap);
        Map<String, String> sentimentMap = new HashMap<String, String>();
        sentimentMap.put("1", "正常");
        sentimentMap.put("2", "紧张");
        sentimentMap.put("3", "焦虑");
        sentimentMap.put("4", "抑郁");
        levelMap.put("sentiment", sentimentMap);
        Map<String, String> resistanceMap = new HashMap<String, String>();
        resistanceMap.put("1", "好");
        resistanceMap.put("2", "正常");
        resistanceMap.put("3", "下降");
        resistanceMap.put("4", "严重下降");
        levelMap.put("resistance", resistanceMap);
    }
    /**
     * 查询页面
     * @param model
     * @param request
     * @return
     */
    @RequestMapping("/search")
    public String search(ModelMap model, HttpServletRequest request) {
        this.init();
        return "rhip.health.home.fsr.search";
    }

    /**
     * 查询列表
     * @param model
     * @param request
     * @param startTime 开始时间
     * @param endTime 结束时间
     * @param indexPage 第几页（默认第一页） 
     * @return
     */
    @RequestMapping(value = "/list")
    public String goToList(ModelMap model, HttpServletRequest request,String keyword,  String startTime, String endTime, int indexPage) {
        String preUrl = WebProperties.getMsg("href.uthealth");
        // 发送POST请求
        String s2 = HttpClientUtil.sendPost(preUrl + "/h_users/searchFSR", this.getParam(request, keyword,  startTime, endTime, indexPage));
        JSONObject httpResponse = JSONObject.fromObject(s2);
        List<Map<String, Object>> results = new ArrayList<Map<String, Object>>();
        if(ObjectUtil.isNotEmpty(httpResponse) && (int)httpResponse.get("code") == 200) {
            JSONObject woData = (JSONObject) httpResponse.get("data");
            JSONArray itemsJsonArr = JSONArray.fromObject(woData.get("items"));
            for (int i = 0; i < itemsJsonArr.size(); i++) {
                JSONObject ja = (JSONObject) itemsJsonArr.get(i);
                Map<String, Object> map = new HashMap<String, Object>();
                map.put("userName", ja.getString("userName"));
                map.put("userId", ja.getString("userId"));
                map.put("testType", testTypeMap.get(ja.getString("testType")));
                Map<String, String> levelMapRe = levelMap.get(ja.getString("testType"));
                map.put("level", levelMapRe.get(ja.getString("level")));
                map.put("checkDate", ja.getString("checkDate"));
                map.put("create_at", ja.getString("create_at"));
                results.add(map);
            }
        }
        model.addAttribute("page", getPageInfo(httpResponse));
        model.addAttribute("results", results);
        return "rhip.health.home.fsr.list";
    }

    private String getParam(HttpServletRequest request, String keyword, String startTime, String endTime, int pageIndex) {
        String param = "limit=10";

        if(ObjectUtil.isNotEmpty(keyword)) {
            param += "&keyword=" + keyword;
        }

        if(ObjectUtil.isNotEmpty(startTime)) {
            param += "&startTime=" + startTime;
        }
        if(ObjectUtil.isNotEmpty(endTime)) {
            param += "&endTime=" + endTime;
        }
        if(ObjectUtil.isNotEmpty(pageIndex)){
            param += "&page=" + pageIndex;
        }
        String orgCode = getOrgMapping(request);
        if(ObjectUtil.isNotEmpty(orgCode)){
            param +="&orgCode=" + orgCode;
        }
       return param;
    }

}
