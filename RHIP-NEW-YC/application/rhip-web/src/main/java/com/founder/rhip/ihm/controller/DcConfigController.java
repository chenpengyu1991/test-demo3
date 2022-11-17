package com.founder.rhip.ihm.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.OP;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.BaseController;
import com.founder.rhip.ehr.cache.DictionaryCache;
import com.founder.rhip.ehr.common.EHRMessageUtil;
import com.founder.rhip.ehr.entity.clinic.AiHiDrugCatalog;
import com.founder.rhip.ehr.entity.dcConfig.DcParam;
import com.founder.rhip.ehr.service.IAiHiDrugCatalogService;
import com.founder.rhip.ehr.service.check.IDcConfigService;
import com.founder.rhip.sr.controller.form.SrQueryForm;

import net.sf.json.JSONSerializer;

/**
 * 重复验证参数设置
 * @author Cary
 *
 */
@Controller
@RequestMapping("/dcConfig")
public class DcConfigController extends BaseController {

    @Autowired
    private IDcConfigService dcConfigService;
    
    @Resource(name = "aiHiDrugCatalogService")
    private IAiHiDrugCatalogService aiHiDrugCatalogService;

    /**
     * 药品json数据缓存key
     */
    private static final String DRUG_JSON_KEY = "drugJsonKey";

    /**
     * 重复检查参数配置
     * @return
     */
    @RequestMapping("/check/inspect/index")
    public String index(HttpServletRequest request, Model model) {
        return "rhip.conifg.check.inspect.search";
    }

    @RequestMapping("/check/inspect/list")
    public String getDcList(HttpServletRequest request, SrQueryForm form, ModelMap modelMap, int pageIndex) {
        Page page = super.getPage(request, pageIndex);
        Criteria criteria = new Criteria();
        criteria.add("type", 1);
        String queryCode = form.getQueryCode();
        if(StringUtil.isNotEmpty(queryCode)){
            criteria.add("ITEM_CODE", queryCode);
        }
        PageList<DcParam> pList = dcConfigService.getDcParamList(page, criteria);
        modelMap.addAttribute("resultList", pList.getList());
        modelMap.addAttribute("page", page);
        modelMap.addAttribute("pageIndex", pageIndex);
        return "rhip.conifg.check.inspect.list";
    };

    @RequestMapping("/check/inspect/add")
    public String add(HttpServletRequest request,Long id,  ModelMap modelMap) {
        if(ObjectUtil.isNotEmpty(id)){
            DcParam dcParam = dcConfigService.getDcParam(new Criteria("id", id));
            int itemValue = Integer.valueOf(dcParam.getItemValue()==null?"0":dcParam.getItemValue());
            dcParam.setDays(itemValue / 24);
            dcParam.setMinutes(itemValue % 24);
            modelMap.addAttribute("dcParam", dcParam);
        }
        return "rhip.conifg.check.inspect.add";
    }

    @RequestMapping("/check/inspect/delete")
    public String delete(HttpServletRequest request,Long id,  ModelMap modelMap) {
        boolean result = false;
        if(ObjectUtil.isNotEmpty(id)){
            dcConfigService.delete(new Criteria("id", id));
        }
        result = true;
        return EHRMessageUtil.returnMsg(modelMap, result ? "success" : "fail");
    }

    @RequestMapping("/check/inspect/save")
    public String inspectSave(HttpServletRequest request,DcParam dcParam, ModelMap model) throws InstantiationException, IllegalAccessException {
        boolean result = false;
        dcParam.setItemValue(String.valueOf(dcParam.getDays() * 24 + dcParam.getMinutes()));
        dcParam.setType("1");
        dcConfigService.saveDcParam(dcParam);
        result = true;
        return EHRMessageUtil.returnMsg(model, result ? "success" : "fail");
    }

    /**
     * 重复检验参数配置
     * @return
     */
    @RequestMapping("/check/exam/index")
    public String examIndex(HttpServletRequest request, Model model) {
        return "rhip.conifg.check.exam.search";
    }

    @RequestMapping("/check/exam/list")
    public String getDcExamList(HttpServletRequest request, SrQueryForm form, ModelMap modelMap, int pageIndex) {
        Page page = super.getPage(request, pageIndex);
        Criteria criteria = new Criteria();
        criteria.add("type", 2);
        String queryCode = form.getQueryCode();
        if(StringUtil.isNotEmpty(queryCode)){
            criteria.add("ITEM_code",  queryCode);
        }
        PageList<DcParam> pList = dcConfigService.getDcParamList(page, criteria);
        modelMap.addAttribute("resultList", pList.getList());
        modelMap.addAttribute("page", page);
        modelMap.addAttribute("pageIndex", pageIndex);
        return "rhip.conifg.check.exam.list";
    };

    @RequestMapping("/check/exam/add")
    public String addExam(HttpServletRequest request,Long id,  ModelMap modelMap) {
        if(ObjectUtil.isNotEmpty(id)){
            DcParam dcParam = dcConfigService.getDcParam(new Criteria("id", id));
            int itemValue = Integer.valueOf(dcParam.getItemValue()==null?"0":dcParam.getItemValue());
            dcParam.setDays(itemValue / 24);
            dcParam.setMinutes(itemValue % 24);
            modelMap.addAttribute("dcParam", dcParam);
        }
        return "rhip.conifg.check.exam.add";
    }

    @RequestMapping("/check/exam/delete")
    public String deleteExam(HttpServletRequest request,Long id,  ModelMap modelMap) {
        boolean result = false;
        if(ObjectUtil.isNotEmpty(id)){
            dcConfigService.delete(new Criteria("id", id));
        }
        result = true;
        return EHRMessageUtil.returnMsg(modelMap, result ? "success" : "fail");
    }

    @RequestMapping("/check/exam/save")
    public String examSave(HttpServletRequest request,DcParam dcParam, ModelMap model) throws InstantiationException, IllegalAccessException {
        boolean result = false;
        dcParam.setItemValue(String.valueOf(dcParam.getDays() * 24 + dcParam.getMinutes()));
        dcParam.setType("2");
        dcConfigService.saveDcParam(dcParam);
        result = true;
        return EHRMessageUtil.returnMsg(model, result ? "success" : "fail");
    }

    /**
     * 重复用药参数配置
     * @return
     */
    @RequestMapping("/check/drug/index")
    public String drugIndex(HttpServletRequest request, Model model) {
        return "rhip.conifg.check.drug.search";
    }

    @RequestMapping("/check/drug/list")
    public String getDcDrugList(HttpServletRequest request, SrQueryForm form, ModelMap modelMap, int pageIndex) {
        Page page = super.getPage(request, pageIndex);
        Criteria criteria = new Criteria();
        criteria.add("type", 3);
        String coopInsuranceCd = form.getCoopInsuranceCd();
        String pubmediCd = form.getPubmediCd();
        String itemCode = form.getQueryCode();
        if(StringUtil.isNotEmpty(itemCode)){
        	criteria.add("itemCode", OP.LIKE, itemCode);
        }
        if(StringUtil.isNotEmpty(coopInsuranceCd)){
            criteria.add("coopInsuranceCd", OP.LIKE, coopInsuranceCd);
        }else if(StringUtil.isNotEmpty(pubmediCd)){
            criteria.add("pubmediCd", OP.LIKE, pubmediCd);
        }
        PageList<DcParam> pList = dcConfigService.getDcParamList(page, criteria);
        modelMap.addAttribute("resultList", pList.getList());
        modelMap.addAttribute("page", page);
        modelMap.addAttribute("pageIndex", pageIndex);
        return "rhip.conifg.check.drug.list";
    };

    @RequestMapping("/check/drug/add")
    public String addDrug(HttpServletRequest request,Long id,  ModelMap modelMap) {
        if(ObjectUtil.isNotEmpty(id)){
            DcParam dcParam = dcConfigService.getDcParam(new Criteria("id", id));
            int itemValue = Integer.valueOf(dcParam.getItemValue()==null?"0":dcParam.getItemValue());
            dcParam.setDays(itemValue / 24);
            dcParam.setMinutes(itemValue % 24);
            modelMap.addAttribute("dcParam", dcParam);
        }
        return "rhip.conifg.check.drug.add";
    }

    @RequestMapping("/check/drug/delete")
    public String deleteDrug(HttpServletRequest request,Long id,  ModelMap modelMap) {
        boolean result = false;
        if(ObjectUtil.isNotEmpty(id)){
            dcConfigService.delete(new Criteria("id", id));
        }
        result = true;
        return EHRMessageUtil.returnMsg(modelMap, result ? "success" : "fail");
    }

    @RequestMapping("/check/drug/save")
    public String examDrug(HttpServletRequest request,DcParam dcParam, ModelMap model) throws InstantiationException, IllegalAccessException {
        boolean result = false;
        dcParam.setItemValue(String.valueOf(dcParam.getDays() * 24 + dcParam.getMinutes()));
        dcParam.setType("3");
        dcConfigService.saveDcParam(dcParam);
        result = true;
        return EHRMessageUtil.returnMsg(model, result ? "success" : "fail");
    }
    @RequestMapping("/drug/list")
    public void drugs(HttpServletRequest request,DcParam dcParam, ModelMap model, HttpServletResponse response) throws InstantiationException, IllegalAccessException {
        String result = DictionaryCache.dicMap.get(DRUG_JSON_KEY);
        if(StringUtil.isEmpty(result)){
            try {
                List<AiHiDrugCatalog> aiHiDrugCatalogs = aiHiDrugCatalogService.getDrugs(new Criteria());
                String disJson = JSONSerializer.toJSON(aiHiDrugCatalogs).toString();
                result = disJson;
                DictionaryCache.dicMap.put(DRUG_JSON_KEY, disJson);
            } catch (Exception e) {
                logger.error("get tumor icd10 error", e);
            }
        }
        if (null != result) {
            try {
                response.getWriter().write(result.toString());
                response.getWriter().flush();
            } catch (Exception e) {
                logger.error("io error", e);
            }
        }

    }

}