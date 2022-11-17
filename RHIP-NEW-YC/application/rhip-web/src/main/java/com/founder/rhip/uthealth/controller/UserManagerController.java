package com.founder.rhip.uthealth.controller;

import com.founder.fasf.beans.PageList;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.BaseController;
import com.founder.rhip.ehr.common.PropertiesUtils;
import com.founder.rhip.ehr.common.RoleType;
import com.founder.rhip.uthealth.controller.util.HttpClientUtil;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.*;


@Controller
@RequestMapping("/uthealth/user")
public class UserManagerController  extends BaseController {

    protected static Logger logger = Logger.getLogger(UserManagerController.class.getName());
    /**
     * 用户查询接口
     */
    public static final String REQUEST_USERS_URL = "/h_users/search";
    /**
     * 获取血压数据接口
     */
    public static final String REQUEST_BP_URL = "/h_users/searchBP";
    /**
     * 获取血糖数据接口
     */
    public static final String REQUEST_BG_URL = "/h_users/searchBG";
    /**
     * 获取血氧心率体温数据接口
     */
    public static final String REQUEST_OHT_URL = "/h_users/searchOHT";
    /**
     * 获取水分和油分数据接口
     */
    public static final String REQUEST_WO_URL = "/h_users/searchWO";
    /**
     * 获取呼吸率数据接口
     */
    public static final String REQUEST_BF_URL = "/h_users/searchBF";
    /**
     * 获取心电数据接口
     */
    public static final String REQUEST_ECG_URL = "/h_users/searchECG";
    public static final String RESPONSE_SUCCESS_CODE = "200";

    private static Properties properties =  PropertiesUtils.initProperties("common-web");
    private static String UTHEALTH_URL = "href.uthealth";

    /** EChart legend */
    protected static final String LEGEND_JSON = "legendJSON";
    /** EChart series */
    protected static final String SERIES_JSON = "seriesJSON";
    /** EChart xAxis */
    protected static final String XAXIS_JSON = "xAxisJSON";

    /**
     * 用户查询
     */
    @RequestMapping(value = "/search")
    public String userSearch(HttpServletRequest request, Model model) {
        return "rhip.health.home.user.search";
    }
    /**
     * 查询用户信息
     * @param keyword
     * @param model
     * @return
     */
    @RequestMapping(value = "/list")
    public String userList(HttpServletRequest request, String keyword, Model model) {
        String pageIndex = request.getParameter("pageIndex");
        int currentPage = Integer.valueOf(pageIndex);
        PageList<Map<String, Object>> plist = getUserList(request,currentPage,keyword);
        model.addAttribute("userList", plist.getList());
        model.addAttribute("page", plist.getPage());

        return "rhip.health.home.user.list";
    }

    /**
     * 用户数据分析
     */
    @RequestMapping(value = "/detail")
    public String userDetail(Model model,String userId) {
        model.addAttribute("userId", userId);
        return "rhip.health.home.user.userDetail";
    }

    /**
     * 获取血压图形数据
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/userBP")
    public Map<String, Object> userBP(HttpServletRequest request,String userId) {
        Map<String, Object> resultMap = new HashMap<String, Object>(0);
        List<Map<String,Object>> series = new ArrayList<>();
        List<Map<String,Object>>  seriesData = getUserDetail(REQUEST_BP_URL,userId,"checkDate",new String[]{"sbp","dbp"});
        Map<String,String> targetMap = new HashMap<>();
        targetMap.put("sbp","高压");
        targetMap.put("dbp","低压");
        List<String> legends =  getLineData(seriesData,series,targetMap);
        resultMap.put(LEGEND_JSON,legends);
        resultMap.put(SERIES_JSON,series);
        List<String> xAxis = new ArrayList<String>(0);
        for(Map<String,Object> map:seriesData){
            xAxis.add(map.get("checkDate").toString());
        }
        resultMap.put(XAXIS_JSON, xAxis);
        resultMap.put("unit", "");
        logger.debug(convertToJSON(resultMap));
        return resultMap;
    }

    /**
     * 获取血糖图形数据
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/userBG")
    public Map<String, Object> userBG(HttpServletRequest request,String userId) {
        Map<String, Object> resultMap = new HashMap<String, Object>(0);
        List<Map<String,Object>> series = new ArrayList<>();
        List<Map<String,Object>>  seriesData = getUserDetail(REQUEST_BG_URL,userId,"checkDate",new String[]{"bloodSugar"});
        Map<String,String> targetMap = new HashMap<>();
        targetMap.put("bloodSugar","血糖");
        List<String> legends =  getLineData(seriesData,series,targetMap);
        resultMap.put(LEGEND_JSON,legends);
        resultMap.put(SERIES_JSON,series);
        List<String> xAxis = new ArrayList<String>(0);
        for(Map<String,Object> map:seriesData){
            xAxis.add(map.get("checkDate").toString());
        }
        resultMap.put(XAXIS_JSON, xAxis);
        resultMap.put("unit", "");
        logger.debug(convertToJSON(resultMap));
        return resultMap;
    }

    /**
     * 获取血氧心率体温图形数据
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/userOHT")
    public Map<String, Object> userOHT(HttpServletRequest request,String userId) {
        Map<String, Object> resultMap = new HashMap<String, Object>(0);
        List<Map<String,Object>> series = new ArrayList<>();
        List<Map<String,Object>>  seriesData = getUserDetail(REQUEST_OHT_URL,userId,"checkDate",new String[]{"oxygen","heartRate","bodyTemperature"});
        Map<String,String> targetMap = new HashMap<>();
        targetMap.put("oxygen","血氧");
        targetMap.put("heartRate","心率");
        targetMap.put("bodyTemperature","体温");
        List<String> legends =  getLineData(seriesData,series,targetMap);
        resultMap.put(LEGEND_JSON,legends);
        resultMap.put(SERIES_JSON,series);
        List<String> xAxis = new ArrayList<String>(0);
        for(Map<String,Object> map:seriesData){
            xAxis.add(map.get("checkDate").toString());
        }
        resultMap.put(XAXIS_JSON, xAxis);
        resultMap.put("unit", "");
        logger.debug(convertToJSON(resultMap));
        return resultMap;
    }

    /**
     * 获取水分和油分图形数据
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/userWO")
    public Map<String, Object> userWO(HttpServletRequest request,String userId) {
        Map<String, Object> resultMap = new HashMap<String, Object>(0);
        List<Map<String,Object>> series = new ArrayList<>();
        List<Map<String,Object>>  seriesData = getUserDetail(REQUEST_WO_URL,userId,"checkDate",new String[]{"waterPercent","oilPercent"});
        Map<String,String> targetMap = new HashMap<>();
        targetMap.put("waterPercent","水份");
        targetMap.put("oilPercent","油份");
        List<String> legends =  getLineData(seriesData,series,targetMap);
        resultMap.put(LEGEND_JSON,legends);
        resultMap.put(SERIES_JSON,series);
        List<String> xAxis = new ArrayList<String>(0);
        for(Map<String,Object> map:seriesData){
            xAxis.add(map.get("checkDate").toString());
        }
        resultMap.put(XAXIS_JSON, xAxis);
        resultMap.put("unit", "");
        logger.debug(convertToJSON(resultMap));
        return resultMap;
    }

    /**
     * 获取呼吸率图形数据
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/userBF")
    public Map<String, Object> userBF(HttpServletRequest request,String userId) {
        Map<String, Object> resultMap = new HashMap<String, Object>(0);
        List<Map<String,Object>> series = new ArrayList<>();
        List<Map<String,Object>>  seriesData = getUserDetail(REQUEST_BF_URL,userId,"checkDate",new String[]{"breathFreq"});
        Map<String,String> targetMap = new HashMap<>();
        targetMap.put("breathFreq","呼吸率");
        List<String> legends =  getLineData(seriesData,series,targetMap);
        resultMap.put(LEGEND_JSON,legends);
        resultMap.put(SERIES_JSON,series);
        List<String> xAxis = new ArrayList<String>(0);
        for(Map<String,Object> map:seriesData){
            xAxis.add(map.get("checkDate").toString());
        }
        resultMap.put(XAXIS_JSON, xAxis);
        resultMap.put("unit", "");
        logger.debug(convertToJSON(resultMap));
        return resultMap;
    }

    /**
     * 获取心电图形数据
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/userECG")
    public Map<String, Object> userECG(HttpServletRequest request,String userId) {
        Map<String, Object> resultMap = new HashMap<String, Object>(0);
        List<Map<String,Object>> series = new ArrayList<>();
        List<Map<String,Object>>  seriesData = getUserDetail(REQUEST_ECG_URL,userId,"beginDate",new String[]{"leakCount","stopCount","fastCount","slowCount"});
        Map<String,String> targetMap = new HashMap<>();
        targetMap.put("leakCount","漏搏数");
        targetMap.put("stopCount","停搏数");
        targetMap.put("fastCount","快搏数");
        targetMap.put("slowCount","慢搏数");
        List<String> legends =  getLineData(seriesData,series,targetMap);
        resultMap.put(LEGEND_JSON,legends);
        resultMap.put(SERIES_JSON,series);
        List<String> xAxis = new ArrayList<String>(0);
        for(Map<String,Object> map:seriesData){
            xAxis.add(map.get("beginDate").toString());
        }
        resultMap.put(XAXIS_JSON, xAxis);
        resultMap.put("unit", "");
        logger.debug(convertToJSON(resultMap));
        return resultMap;
    }

    /**
     * 获取接口数据（图像展示用）
     * @param userId
     * @param targets
     * @return
     */
    private List<Map<String,Object>> getUserDetail(String url,String userId,String dateFiledName, String... targets){
        List<Map<String,Object>> result = new ArrayList<>();
        String baseUrl = properties.getProperty(UTHEALTH_URL);
        // 发送POST请求
        String ret = HttpClientUtil.sendPost(baseUrl + url,"keyword=" + userId);
        JSONObject httpResponse = JSONObject.fromObject(ret);
        logger.debug(convertToJSON(httpResponse));
        if(ObjectUtil.isNotEmpty(httpResponse)) {
            String returnCode = httpResponse.getString("code");
            if(!RESPONSE_SUCCESS_CODE.equals(returnCode)){
                String msg = httpResponse.getString("msg");
                logger.error(msg);
            }else {
                JSONObject userData = httpResponse.getJSONObject("data");
                JSONArray items = userData.getJSONArray("items");
                for (int i = 0; i < items.size(); i++) {
                    JSONObject userObj = (JSONObject) items.get(i);
                    Map<String, Object> userMap = new HashMap<>();
                    String checkDateStr = userObj.getString(dateFiledName);
                    if (StringUtil.isNotEmpty(checkDateStr)) {
                        Date checkDate = DateUtil.parseSimpleDate(checkDateStr, "yyyy-MM-dd HH:mm:ss");
                        SimpleDateFormat sdf = new SimpleDateFormat("h:mm a", Locale.ENGLISH);
                        userMap.put(dateFiledName, sdf.format(checkDate));
                    } else {
                        continue;
                    }
                    for (String target : targets) {
                        String targetValue = userObj.getString(target);
                        userMap.put(target, StringUtil.isNullOrEmpty(targetValue) ? "0" : targetValue);
                    }
                    result.add(userMap);
                }
            }
        }
        //排序
        try {
            listSort(result, dateFiledName);
        }catch (Exception e){
            logger.error(e.getMessage());
        }
        return result;
    }

    /**
     * 组装ECHART数据
     * @param seriesData 元数据
     * @param series 目标数据
     * @param targetMap 指标MAP
     * @return
     */
    private List<String> getLineData(List<Map<String,Object>>  seriesData,List<Map<String,Object>>  series, Map<String,String> targetMap){
        List<String> legends =  new ArrayList<>();
        List<String> seriesDatas;
        Iterator<Map.Entry<String,String>> entries = targetMap.entrySet().iterator();
        while (entries.hasNext()) {
            seriesDatas = new ArrayList<>();
            Map.Entry<String,String> entry = entries.next();
            //值中文名
            legends.add(entry.getValue());
            for(Map<String,Object> map:seriesData){
                seriesDatas.add(map.get(entry.getKey()).toString());
            }
            Map<String,Object> seriesMap = addSeries(entry.getValue(),"line",seriesDatas);
            series.add(seriesMap);
        }
        return legends;
    }

    protected Map<String,Object> addSeries(String name,String type,List<String> seriesDataList){
        Map<String,Object> seriesMap = new HashMap<>();
        seriesMap.put("name",name);
        seriesMap.put("type",type);
        seriesMap.put("data",seriesDataList.toArray(new String[seriesDataList.size()]));
        return seriesMap;
    }

    /**
     * 获取数据
     * @param pageIndex
     * @param keyword
     * @return
     */
    private PageList<Map<String, Object>> getUserList(HttpServletRequest request,int pageIndex,String keyword){
        PageList<Map<String, Object>> pageList = new PageList<>();
        String baseUrl = properties.getProperty(UTHEALTH_URL);
        // 发送POST请求
        String ret = HttpClientUtil.sendPost(baseUrl + REQUEST_USERS_URL,getRequestParam(request,pageIndex,keyword));
        JSONObject httpResponse = JSONObject.fromObject(ret);
        logger.debug(httpResponse);
        List<Map<String,Object>> userList = new ArrayList<>();
        if(ObjectUtil.isNotEmpty(httpResponse)){
            String returnCode = httpResponse.getString("code");
            if(!RESPONSE_SUCCESS_CODE.equals(returnCode)){
                String msg = httpResponse.getString("msg");
                logger.error(msg);
            }else {
                JSONObject userData = httpResponse.getJSONObject("data");
                JSONArray items = userData.getJSONArray("items");
                for (int i = 0; i < items.size(); i++) {
                    JSONObject userObj = (JSONObject) items.get(i);
                    Map<String, Object> userMap = new HashMap<>();
                    if (ObjectUtil.isNotEmpty(userObj)) {
                        userMap.put("userName", userObj.getString("userName"));//用户名称
                        String sex =  userObj.getString("sex");
                        userMap.put("sex", "1".equals(sex)?"女":"男");//用户性别
                        userMap.put("idCardNo", userObj.getString("idCardNo"));//用户身份证号
                        userMap.put("userId", userObj.getString("userId"));//用户编码
                        userMap.put("height", userObj.getString("height"));//用户身高
                        userMap.put("weight", userObj.getString("weight"));//用户体重
                        userMap.put("create_at", userObj.getString("create_at"));//入库时间
                    }
                    userList.add(userMap);
                }
            }
        }
        pageList.setList(userList);
        pageList.setPage(getPageInfo(httpResponse));
        return pageList;
    }


    /**
     * 组装参数
     * @param pageIndex
     * @param keyword
     * @return
     */
    private String getRequestParam(HttpServletRequest request,int pageIndex,String keyword){
        String result = "limit=10";
        if(StringUtil.isNotEmpty(keyword)){
            result += "&keyword=" + keyword;
        }
        if(ObjectUtil.isNotEmpty(pageIndex)){
            result += "&page=" + pageIndex;
        }
        if(!hasRole(RoleType.ADMIN,request)) {
            result += "&orgCode=" + getOrgMapping(request);
        }
        return result;
    }

    /**
     * 转换对象为JSON数据格式字符串
     *
     * @param o
     * @return JSON数据格式字符串
     */
    protected String convertToJSON(Object o) {
        return JSONArray.fromObject(o).toString();
    }

    /**
     * 根据map中的key排序
     * @param resultList
     * @throws Exception
     */
    public void listSort(List<Map<String,Object>> resultList, final String dateFiledName) throws Exception{
        Collections.sort(resultList,new Comparator<Map<String,Object>>() {
            public int compare(Map<String, Object> o1,Map<String, Object> o2) {
                String s1 = (String) o1.get(dateFiledName);
                String s2 = (String) o2.get(dateFiledName);
                return s1.compareTo(s2);
            }
        });
    }

}
