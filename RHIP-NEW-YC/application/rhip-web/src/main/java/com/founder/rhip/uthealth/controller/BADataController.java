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
 * 获取身体指数数据
 */
@Controller
@RequestMapping("/ba")
public class BADataController extends BaseController {

    /**
     * 查询页面
     * @param model
     * @param request
     * @return
     */
    @RequestMapping("/search")
    public String search(ModelMap model, HttpServletRequest request) {
        return "rhip.health.home.ba.search";
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
        String s2 = HttpClientUtil.sendPost(preUrl + "/h_users/searchBA", this.getParam(request, keyword, startTime, endTime, indexPage));
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
                map.put("fat", ja.getString("fat"));
                map.put("bmi", ja.getString("bmi"));
                map.put("bmr", ja.getString("bmr"));
                map.put("bodyWater", ja.getString("bodyWater"));
                map.put("checkDate", ja.getString("checkDate"));
                map.put("create_at", ja.getString("create_at"));
                results.add(map);
            }
        }
        model.addAttribute("page", getPageInfo(httpResponse));
        model.addAttribute("results", results);
        return "rhip.health.home.ba.list";
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
