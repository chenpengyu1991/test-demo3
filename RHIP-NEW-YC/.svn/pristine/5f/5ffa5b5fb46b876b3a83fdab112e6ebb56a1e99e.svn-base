package com.founder.rhip.idm.controller;

import com.founder.fasf.util.StringUtil;
import com.founder.rhip.BaseController;
import com.founder.rhip.ehr.entity.control.idm.notifiabledisease.*;
import net.sf.ezmorph.object.DateMorpher;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.util.JSONUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 个案处置管理
 */
@Controller
@RequestMapping("/idm/case/hiwhpai")
public class HiwhpaiController extends BaseController {

    /**
     * 就诊情况
     * @param trData
     * @param type
     * @param rowIndex
     * @param model
     * @return
     * @throws InstantiationException
     * @throws IllegalAccessException
     */
    @RequestMapping("/popupAc")
    public String addAc(String trData, String type, String rowIndex, ModelMap model) throws InstantiationException, IllegalAccessException {
        if (StringUtil.isNotEmpty(trData)) {
        	List<ListAc> idmListAcList = (List<ListAc>) json2Obj(trData, ListAc.class);
            model.put("idmListAc", idmListAcList.get(0));
            model.put("rowIndex", rowIndex);
        }
        if (StringUtil.isNotEmpty(type) && "edit".equals(type)) {
            model.put("type", type);
        } else {
            model.put("type", "add");
        }
        return "rhip.idm.case.hiwhpai.ac";
    }


    /**
     * 就诊情况
     * @param trData
     * @param type
     * @param rowIndex
     * @param model
     * @return
     * @throws InstantiationException
     * @throws IllegalAccessException
     */
    @RequestMapping("/popupEfc")
    public String addEfc(String trData, String type, String rowIndex, ModelMap model) throws InstantiationException, IllegalAccessException {
        if (StringUtil.isNotEmpty(trData)) {
            List<ListEfc> idmListEfcList = (List<ListEfc>) json2Obj(trData, ListEfc.class);
            model.put("idmListEfc", idmListEfcList.get(0));
            model.put("rowIndex", rowIndex);
        }
        if (StringUtil.isNotEmpty(type) && "edit".equals(type)) {
            model.put("type", type);
        } else {
            model.put("type", "add");
        }
        return "rhip.idm.case.hiwhpai.efc";
    }

    /**
     * 病例居住环境及暴露情况
     * @param trData
     * @param type
     * @param rowIndex
     * @param model
     * @return
     * @throws InstantiationException
     * @throws IllegalAccessException
     */
    @RequestMapping("/popupEh")
    public String addEh(String trData, String type, String rowIndex, ModelMap model, String seq) throws InstantiationException, IllegalAccessException {
        if (StringUtil.isNotEmpty(trData)) {
            List<ListEh> idmListEhList = (List<ListEh>) json2Obj(trData, ListEh.class);
            model.put("idmListEh", idmListEhList.get(0));
            model.put("rowIndex", rowIndex);
        }
        if (StringUtil.isNotEmpty(type) && "edit".equals(type)) {
            model.put("type", type);
        } else {
            model.put("type", "add");
        }
        String url = "";
        switch (seq){
            case "1" : {
                url = "rhip.idm.case.hiwhpai.eh1";
                break;
            }
            case "2" : {
                url = "rhip.idm.case.hiwhpai.eh2";
                break;
            }
            case "3" : {
                url = "rhip.idm.case.hiwhpai.eh3";
                break;
            }
            case "4" : {
                url = "rhip.idm.case.hiwhpai.eh4";
                break;
            }
            case "5" : {
                url = "rhip.idm.case.hiwhpai.eh5";
                break;
            }
            case "6" : {
                url = "rhip.idm.case.hiwhpai.eh6";
                break;
            }
            case "7" : {
                url = "rhip.idm.case.hiwhpai.eh7";
                break;
            }
        }
        return url;
    }

    /**
     * 卫生条件
     * @param trData
     * @param type
     * @param rowIndex
     * @param model
     * @return
     * @throws InstantiationException
     * @throws IllegalAccessException
     */
    @RequestMapping("/popupHc")
    public String addHc(String trData, String type, String rowIndex, ModelMap model, String seq) throws InstantiationException, IllegalAccessException {
        if (StringUtil.isNotEmpty(trData)) {
            List<ListHc> idmListHcList = (List<ListHc>) json2Obj(trData, ListHc.class);
            model.put("idmListHc", idmListHcList.get(0));
            model.put("rowIndex", rowIndex);
        }
        if (StringUtil.isNotEmpty(type) && "edit".equals(type)) {
            model.put("type", type);
        } else {
            model.put("type", "add");
        }
        String url = "";
        switch (seq){
            case "1" : {
                url = "rhip.idm.case.hiwhpai.hc1";
                break;
            }
            case "2" : {
                url = "rhip.idm.case.hiwhpai.hc2";
                break;
            }
            case "3" : {
                url = "rhip.idm.case.hiwhpai.hc3";
                break;
            }
            case "4" : {
                url = "rhip.idm.case.hiwhpai.hc4";
                break;
            }
        }
        return url;
    }

    /**
     * 实验室检查
     * @param trData
     * @param type
     * @param rowIndex
     * @param model
     * @return
     * @throws InstantiationException
     * @throws IllegalAccessException
     */
    @RequestMapping("/popupLe")
    public String addLe(String trData, String type, String rowIndex, ModelMap model, String seq) throws InstantiationException, IllegalAccessException {
        if (StringUtil.isNotEmpty(trData)) {
            List<ListLe> idmListLeList = (List<ListLe>) json2Obj(trData, ListLe.class);
            model.put("idmListLe", idmListLeList.get(0));
            model.put("rowIndex", rowIndex);
        }
        if (StringUtil.isNotEmpty(type) && "edit".equals(type)) {
            model.put("type", type);
        } else {
            model.put("type", "add");
        }
        String url = "";
        switch (seq){
            case "1" : {
                url = "rhip.idm.case.hiwhpai.le1";
                break;
            }
            case "2" : {
                url = "rhip.idm.case.hiwhpai.le2";
                break;
            }
            case "3" : {
                url = "rhip.idm.case.hiwhpai.le3";
                break;
            }
            case "4" : {
                url = "rhip.idm.case.hiwhpai.le4";
                break;
            }
        }
        return url;
    }

    /**
     *json数组转成List
     * @param jsonArrayStr
     * @param clazz
     * @return
     */
    private static List<?> json2Obj(String jsonArrayStr, Class clazz) throws IllegalAccessException, InstantiationException {
        JsonConfig jsonConfig = new JsonConfig();
        jsonConfig.registerJsonValueProcessor(Date.class, new DateJsonValueProcessor("yyyy/MM/dd"));
        JSONArray jsonObjects = JSONArray.fromObject(jsonArrayStr, jsonConfig);
        String[] dateFormats = new String[]{"yyyy/MM/dd"};
        JSONUtils.getMorpherRegistry().registerMorpher(new DateMorpher(dateFormats));
        List resultList = new ArrayList();
        for (int i = 0; i < jsonObjects.size(); i++) {
            JSONObject jsonObj = (JSONObject) jsonObjects.get(i);
            Object obj = JSONObject.toBean(jsonObj, clazz);
            resultList.add(obj);
        }
        return resultList;
    }
}