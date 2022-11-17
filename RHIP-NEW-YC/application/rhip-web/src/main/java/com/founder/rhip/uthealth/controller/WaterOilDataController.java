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
 * 水分油分数据管理
 * Created by haiyingjiang on 16/11/16.
 */
@Controller
@RequestMapping("/waterOil")
public class WaterOilDataController  extends BaseController {

    public static Map<String, String> waterLevelMap = new HashMap<String, String>();
    public static Map<String, String> oilLevelMap = new HashMap<String, String>();
    public static Map<String, String> bodyPartMap = new HashMap<String, String>();

    private void init() {
//        水份值范围：——0：干燥 1：正常 2：湿润
        waterLevelMap.put("0", "干燥");
        waterLevelMap.put("1", "正常");
        waterLevelMap.put("2", "湿润");
//        油份值范围：——1：湿润性皮肤 2：一般性皮肤 3：偏油性皮肤
        oilLevelMap.put("1", "湿润性皮肤");
        oilLevelMap.put("2", "一般性皮肤");
        oilLevelMap.put("3", "偏油性皮肤");
//        1——额头 2——眼部 3——脸颊 4——手心 5——手背 6——手腕
        bodyPartMap.put("1", "额头");
        bodyPartMap.put("2", "眼部");
        bodyPartMap.put("3", "脸颊");
        bodyPartMap.put("4", "手心");
        bodyPartMap.put("5", "手背");
        bodyPartMap.put("6", "手腕");

    }

    /**
     * 查询页面
     * @param model
     * @param request
     * @return
     */
    @RequestMapping("/search")
    public String search(ModelMap model, HttpServletRequest request) {
        init();
        return "rhip.health.home.wo.search";
    }

    /**
     * 查询列表
     * @param model
     * @param request
     * @param keyword 用户身份证号
     * @param startTime 开始时间
     * @param endTime 结束时间
     * @param indexPage 第几页（默认第一页） 
     * @return
     */
    @RequestMapping(value = "/list")
    public String goToList(ModelMap model, HttpServletRequest request, String keyword, String startTime, String endTime, int indexPage) {
        String preUrl = WebProperties.getMsg("href.uthealth");
        // 发送POST请求
        String s2 = HttpClientUtil.sendPost(preUrl + "/h_users/searchWO", this.getParam(request, keyword, startTime, endTime, indexPage));
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
                map.put("waterPercent", ja.getString("waterPercent"));
                map.put("oilPercent", ja.getString("oilPercent"));
                map.put("checkDate", ja.getString("checkDate"));
                map.put("waterLevel", waterLevelMap.get(ja.getString("waterLevel")));
                map.put("oilLevel", oilLevelMap.get(ja.getString("oilLevel")));
                map.put("bodyPart", bodyPartMap.get(ja.getString("bodyPart")));
                map.put("create_at", ja.getString("create_at"));
                results.add(map);
            }
        }
        model.addAttribute("page", getPageInfo(httpResponse));
        model.addAttribute("results", results);
        return "rhip.health.home.wo.list";
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
