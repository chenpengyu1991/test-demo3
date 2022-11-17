package com.founder.rhip.idm.controller.filariasis;

import com.founder.fasf.beans.*;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.BaseController;
import com.founder.rhip.ehr.common.*;
import com.founder.rhip.ehr.entity.basic.User;
import com.founder.rhip.ehr.entity.control.idm.notifiabledisease.GeneralCondition;
import com.founder.rhip.ehr.entity.control.idm.notifiabledisease.IdmStatusInfo;
import com.founder.rhip.ehr.entity.control.idm.special.ListFr;
import com.founder.rhip.ehr.entity.control.idm.special.ListLc;
import com.founder.rhip.ehr.entity.control.idm.special.ListSc;
import com.founder.rhip.idm.common.IdmType;
import com.founder.rhip.idm.common.SpecialEvents;
import com.founder.rhip.idm.controller.DateJsonValueProcessor;
import com.founder.rhip.idm.controller.form.FilariasisQueryForm;
import com.founder.rhip.idm.controller.form.FilariasisReportForm;
import com.founder.rhip.idm.service.IFilariasisService;
import com.founder.rhip.mdm.app.IDictionaryApp;
import com.founder.rhip.mdm.entity.DicItem;
import com.founder.rhip.mdm.entity.Organization;
import net.sf.ezmorph.object.DateMorpher;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.util.JSONUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/idm/filariasis/standard")
public class FilStandardController extends BaseController {

    @Resource(name = "filariasisService")
    private IFilariasisService filariasisService;

    @Resource(name = "dictionaryApp")
    private IDictionaryApp dictionaryApp;

    private Logger log = LoggerFactory.getLogger(this.getClass());

    /**
     * 进入规范管理首页
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/index")
    public String index(HttpServletRequest request, ModelMap model) {
        return "rhip.idm.filariasis.standard.index";
    }


    /**
     * 查询随访、督导检查
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/standardList")
    public String getCaseList(FilariasisQueryForm form, int pageIndex, String scFlag1, HttpServletRequest request, ModelMap model) {
        String url = "rhip.idm.filariasis.standard.list";
        if("1".equals(scFlag1)){
            url = "rhip.idm.filariasis.standard.scList";
        }
        Page page = super.getPage(request,  pageIndex);
        Criteria criteria = new Criteria();
        Criteria ca = form.getCriteria(criteria);
        if (!hasRole(RoleType.JKSCB, request)){
//            ca.add("I.SURVEY_ORG", getCurrentOrg(request).getOrganCode());
            ca.add("S.CURRENT_UNIT", getCurrentOrg(request).getOrganCode());
        }
        List<String> events = new ArrayList<String>();
//        events.add(SpecialEvents.F_REG.getValue());
        events.add(SpecialEvents.F_CASE.getValue());
        ca.add("E.EVENT_ID", OP.IN, events);
        ca.add("S.IDM_TYPE", IdmType.FILARIASIS.getValue());
        PageList<IdmStatusInfo> plist = filariasisService.findFilRegList(ca, page, true);
        model.addAttribute("statusInfo", plist.getList());
        model.addAttribute("page", plist.getPage());
        return url;
    }


    /**
     * 随访初始化
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/initFollowUp")
    public String initFollowUp(Long singleId, String lymphedema, String chyluria, String logoff, HttpServletRequest request, ModelMap model) {
        String url = "rhip.idm.filariasis.standard.followup";

        Criteria ca = new Criteria("idmId", singleId);
        Page page = super.getPage(request, 1 , "/idm/filariasis/standard/searchFollowUpList");
        Order od = new Order("VISIT_DT",false);//正序
        PageList<ListFr> plist = filariasisService.findFrList(ca, page, od);

        Long userId = getCurrentUser(request).getId();
        ListFr listFr = new ListFr();
        listFr.setVisitById(userId.toString());
        listFr.setVisitDt(new Date());

        GeneralCondition generalCondition = filariasisService.findGenInfo(ca);

        listFr.setName(generalCondition.getName());
        listFr.setGender(generalCondition.getGender());
        listFr.setPhoneNumber(generalCondition.getPhoneNumber());
        listFr.setPatownShip(generalCondition.getPatownShip());
        listFr.setPastreet(generalCondition.getPastreet());
        listFr.setPahouseNumber(generalCondition.getPahouseNumber());
        listFr.setAge(generalCondition.getAge());

        model.addAttribute("listFr", listFr);
        model.addAttribute("singleId", singleId);
        model.addAttribute("lymphedema", lymphedema);
        model.addAttribute("chyluria", chyluria);
        model.addAttribute("frList", plist.getList());
        model.addAttribute("page", plist.getPage());
        model.addAttribute("logoff", logoff);

        return url;
    }

    /**
     * 随访列表
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/searchFollowUpList")
    public String searchFollowUpList(Long singleId, int pageIndex, HttpServletRequest request, ModelMap model) {
        String url = "rhip.idm.filariasis.standard.followupList";

        Criteria ca = new Criteria("idmId", singleId);
        Page page = super.getPage(request,  pageIndex);
        Order od = new Order("VISIT_DT",false);//正序
        PageList<ListFr> plist = filariasisService.findFrList(ca, page, od);

        model.addAttribute("frList", plist.getList());
        model.addAttribute("page", plist.getPage());

        return url;
    }

    /**
     * 获取随访明细
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/initFollowUpDetail")
    public String initFollowUpDetail(Long id, String lymphedema, String chyluria, HttpServletRequest request, ModelMap model) {
        Criteria ca = new Criteria("id", id);
        ListFr listFr = filariasisService.findFollowUp(ca);

        model.addAttribute("lymphedema", request.getParameter("lymphedema"));
        model.addAttribute("chyluria", chyluria);
        model.put("listFr", listFr);
        model.put("total", request.getParameter("lymphedema")+chyluria);
        model.put("singleId", listFr.getIdmId());

        return "rhip.idm.filariasis.standard.followupDetail";
    }

    /**
     * 保存随访
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/saveFollowUp")
    public String saveFollowUp(ListFr listFr, String type, HttpServletRequest request, ModelMap model) throws InstantiationException, IllegalAccessException {
        boolean result = false;
        String listLcJson = listFr.getListLcJson();
        if(StringUtil.isNotEmpty(listLcJson)){
            List<ListLc> idmListLcList = (List<ListLc>) json2Obj(listLcJson, listFr.getIdmId(), ListLc.class);
            listFr.setListLcs(idmListLcList);
        }
        if(ObjectUtil.isNotEmpty(listFr)){
            Organization org = getCurrentOrg(request);
            User user = getCurrentUser(request);

            //存地址
            listFr.setPaAddress(dictionaryApp.queryDicItemName("FS990001", listFr.getPatownShip()) + dictionaryApp.queryDicItemName("FS990001", listFr.getPastreet()) + listFr.getPahouseNumber());

            //添加
            if("add".equals(type)){
                result = filariasisService.addFr(listFr);
                createOperationLog(request, RhipModuleName.IDM, "丝虫病专项-随访", OperationName.ADD);
            }else if("edit".equals(type)){
                result = filariasisService.updateFr(listFr);
                createOperationLog(request, RhipModuleName.IDM, "丝虫病专项-随访", OperationName.UPDATE);
            }
        }
        return EHRMessageUtil.returnMsg(model, result ? "success" : "fail");
    }

    @RequestMapping("/popupLc")
    public String popupLc(String trData, String total, String type, String rowIndex, ModelMap model) throws InstantiationException, IllegalAccessException {
        if (StringUtil.isNotEmpty(trData)) {
            List<ListLc> idmListLcList = (List<ListLc>) json2Obj(trData, -1L, ListLc.class);
            model.put("idmListLc", idmListLcList.get(0));
            model.put("rowIndex", rowIndex);
            model.put("recommendType", idmListLcList.get(0).getRecommendType());
        }
        if (StringUtil.isNotEmpty(type) && "edit".equals(type)) {
            model.put("type", type);
        } else {
            model.put("type", "add");
        }
        model.put("total", total);
        return "rhip.idm.filariasis.standard.listLc";
    }

    /**
     * 保存督导检查
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/saveSc")
    public String saveSc(ListSc listSc, String type, HttpServletRequest request, ModelMap model) throws InstantiationException, IllegalAccessException {
        boolean result = false;
        if(ObjectUtil.isNotEmpty(listSc)){
            Organization org = getCurrentOrg(request);
            User user = getCurrentUser(request);
            //添加
            if("add".equals(type)){
                result = filariasisService.addSc(listSc);
                createOperationLog(request, RhipModuleName.IDM, "丝虫病专项-督导检查", OperationName.ADD);
            }else if("edit".equals(type)){
                result = filariasisService.updateSc(listSc);
                createOperationLog(request, RhipModuleName.IDM, "丝虫病专项-督导检查", OperationName.UPDATE);
            }
        }
        return EHRMessageUtil.returnMsg(model, result ? "success" : "fail");
    }



    /**
     * 督导检查初始化
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/initListSc")
    public String initListSc(Long singleId, String logoff, HttpServletRequest request, ModelMap model) {
        String url = "rhip.idm.filariasis.standard.sc";

        Criteria ca = new Criteria("idmId", singleId);
        Page page = super.getPage(request,  1, "/idm/filariasis/standard/searchScList");
        Order od = new Order("SUPERVISOR_DT",false);//正序
        PageList<ListSc> plist = filariasisService.findScList(ca, page, od);

        Long userId = getCurrentUser(request).getId();
        ListSc listSc = new ListSc();
        listSc.setCheckUser(userId.toString());
        listSc.setSupervisorDt(new Date());

        GeneralCondition generalCondition = filariasisService.findGenInfo(ca);

        listSc.setName(generalCondition.getName());
        listSc.setGender(generalCondition.getGender());
        listSc.setPhoneNumber(generalCondition.getPhoneNumber());
        listSc.setPatownShip(generalCondition.getPatownShip());
        listSc.setPastreet(generalCondition.getPastreet());
        listSc.setPahouseNumber(generalCondition.getPahouseNumber());
        listSc.setAge(generalCondition.getAge());

        model.addAttribute("listSc", listSc);
        model.addAttribute("singleId", singleId);
        model.addAttribute("scList", plist.getList());
        model.addAttribute("page", plist.getPage());
        model.addAttribute("logoff", logoff);

        return url;
    }

    /**
     * 督导检查列表
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/searchScList")
    public String searchScList(Long singleId, int pageIndex, HttpServletRequest request, ModelMap model) {
        String url = "rhip.idm.filariasis.standard.sc.listSc";

        Criteria ca = new Criteria("idmId", singleId);
        Page page = super.getPage(request,  pageIndex);
        Order od = new Order("SUPERVISOR_DT",false);//正序
        PageList<ListSc> plist = filariasisService.findScList(ca, page, od);

        model.addAttribute("scList", plist.getList());
        model.addAttribute("page", plist.getPage());
        return url;
    }

    /**
     * 获取督导检查明细
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/initScDetail")
    public String initScDetail(Long id, HttpServletRequest request, ModelMap model) {
        Criteria ca = new Criteria("id", id);
        ListSc listSc = filariasisService.findSc(ca);

        model.put("listSc", listSc);
        model.put("singleId", listSc.getIdmId());

        return "rhip.idm.filariasis.standard.sc.scDetail";
    }

    /**
     *json数组转成List
     * @param jsonArrayStr
     * @param clazz
     * @return
     */
    private static List<?> json2Obj(String jsonArrayStr, Long idmId, Class clazz) throws IllegalAccessException, InstantiationException {
        JsonConfig jsonConfig = new JsonConfig();
        jsonConfig.registerJsonValueProcessor(Date.class, new DateJsonValueProcessor("yyyy/MM/dd"));
        JSONArray jsonObjects = JSONArray.fromObject(jsonArrayStr, jsonConfig);
        String[] dateFormats = new String[]{"yyyy/MM/dd"};
        JSONUtils.getMorpherRegistry().registerMorpher(new DateMorpher(dateFormats));
        List resultList = new ArrayList();
        for (int i = 0; i < jsonObjects.size(); i++) {
            JSONObject jsonObj = (JSONObject) jsonObjects.get(i);
            ListLc listLc = (ListLc) JSONObject.toBean(jsonObj, clazz);
            if(StringUtil.isNotEmpty(listLc.getRecommendType())){
                listLc.setIdmId(idmId);
                resultList.add(listLc);
            }
        }
        return resultList;
    }

    /**
     * 慢性丝虫病患者统计表
     * list显示表
     */
    @RequestMapping("/chReportList")
    public String searchChList(HttpServletRequest request, ModelMap model, FilariasisReportForm form) {
       /* Criteria criteria = CriteriaOrganizer.initCriteriaCondition(request.getParameterMap());*/
        Criteria ca = new Criteria();
        Criteria criteria = form.getChCriteria(ca);
        Organization org = getCurrentOrg(request);
        criteria.add("orgCode",org.getOrganCode().toString());
        List<Map<String, Object>> list = filariasisService.findChreport(criteria);
        List<Map<String, Object>> list2 = filariasisService.findChreportCount(criteria);
        if (list.isEmpty()){
            list=null;
        }
        model.addAttribute("list",list);
        model.addAttribute("list2",list2);

        return "rhip.idm.filariasis.reapot.chlist";
    }


    /**
     *
     * 下载慢性丝虫病患者统计表
     */

    @RequestMapping("/downLoadChReport")
    @ResponseBody
    public void downTransferExcel(HttpServletRequest request, ModelMap model,HttpServletResponse response,FilariasisReportForm form) throws Exception {
        DicItem rootDicItem = dictionaryApp.queryDicItem("FS990001", EHRConstants.FS990001_ROOT);
        try {
            ExcelUtils excel = new ExcelUtils(getExcelPath("../views/idm/template/chReport.xls"));
            //Criteria criteria = CriteriaOrganizer.initCriteriaCondition(request.getParameterMap());
            Criteria ca = new Criteria();
            Criteria criteria = form.getChCriteria(ca);
            Organization org = getCurrentOrg(request);
            criteria.add("orgCode",org.getOrganCode().toString());
            List<Map<String, Object>> lists = filariasisService.findChreport(criteria);
            List<Map<String, Object>> lists2 = filariasisService.findChreportCount(criteria);
            int totalRows = 7;
            int beginRowIndex = 7;
            int line = 0;
            excel.shiftRows(line + beginRowIndex, totalRows + line,lists.size());
            for (Map<String, Object> list : lists) {
                List<Object> objects = getChExcelValues(list, line + 1);
                excel.writeLineWithFormat(objects,line + beginRowIndex);
                line++;
            }
            excel.shiftRows(line + beginRowIndex, totalRows + line,lists2.size());
            for (Map<String, Object> list : lists2) {
                List<Object> objects = getChExcelValues2(list, line + 1);
                excel.writeLineWithFormat(objects,line + beginRowIndex);
                line++;
            }
            excel.shiftRows(beginRowIndex, totalRows + line, -1);//删除多余行
            excel.shiftRows(beginRowIndex + line, totalRows + line, -1);//删除多余行
            setExcelContent(response, rootDicItem.getItemName() + "慢性丝虫病患者统计表.xls");
            excel.save(response.getOutputStream());

            lists.clear();
//			transferList = null;*/
        } catch (Exception e) {
            log.error("下载《"+ rootDicItem.getItemName() + "慢性丝虫病患者统计表》出错", e);
            throw e;
        }
    }

    /**
     * 生成转诊EXCEL一行数据
     *
     * @param
     * @return
     */
    private List<Object> getChExcelValues(Map<String, Object> list, int lineNumber) {
        List<Object> line = new ArrayList<Object>();
        line.add(dictionaryApp.queryDicItemName("FS990001", list.get("TOWN").toString()));
        line.add(list.get("t1"));
        line.add(list.get("t2"));
        line.add(list.get("t3"));
        line.add(list.get("t4"));
        line.add(list.get("t5"));
        line.add(list.get("s1"));
        line.add(list.get("s2"));
        line.add(list.get("s3"));
        line.add(list.get("s4"));
        line.add(list.get("s5"));


        return line;
    }

    private List<Object> getChExcelValues2(Map<String, Object> list, int lineNumber) {
        List<Object> line = new ArrayList<Object>();
        line.add("合计");
        line.add(list.get("t1"));
        line.add(list.get("t2"));
        line.add(list.get("t3"));
        line.add(list.get("t4"));
        line.add(list.get("t5"));
        line.add(list.get("s1"));
        line.add(list.get("s2"));
        line.add(list.get("s3"));
        line.add(list.get("s4"));
        line.add(list.get("s5"));


        return line;
    }



    /**
     * 丝虫病病原学监测汇总表
     * list显示表
     */
    @RequestMapping("/phReportList")
    public String searchPhList(HttpServletRequest request, ModelMap model, FilariasisReportForm form) {
        Criteria ca = new Criteria();
        Criteria criteria = form.getChCriteria(ca);
        Organization org = getCurrentOrg(request);
        criteria.add("orgCode",org.getOrganCode().toString());

        List<Map<String, Object>> list = filariasisService.findPhreport(criteria);
        List<Map<String, Object>> list1 = filariasisService.findPhreportCount(criteria);
        if (list.isEmpty()){
            list=null;
        }
        model.addAttribute("list",list);
        model.addAttribute("list1",list1);
        return "rhip.idm.filariasis.reapot.phlist";
    }

    /**
     * 丝虫病病原学监测汇总表
     * list显示表
     */
    @RequestMapping("/reportIndex")
    public String reportIndex(HttpServletRequest request, ModelMap model, FilariasisReportForm form) {
        return "rhip.idm.filariasis.reapot.index";
    }

    /**
     *
     * 丝虫病病原学监测汇总表
     */

    @RequestMapping("/downLoadPhReport")
    @ResponseBody
    public void downPhExcel(HttpServletRequest request, ModelMap model,HttpServletResponse response,FilariasisReportForm form) throws Exception {
        DicItem rootDicItem = dictionaryApp.queryDicItem("FS990001", EHRConstants.FS990001_ROOT);
        try {
            ExcelUtils excel = new ExcelUtils(getExcelPath("../views/idm/template/phReport.xls"));
            Criteria ca = new Criteria();
            Criteria criteria = form.getChCriteria(ca);
            Organization org = getCurrentOrg(request);
            criteria.add("orgCode",org.getOrganCode().toString());
            List<Map<String, Object>> lists = filariasisService.findPhreport(criteria);
            List<Map<String, Object>> lists2 = filariasisService.findPhreportCount(criteria);
            int totalRows = 7;
            int beginRowIndex = 5;
            int line = 0;
            excel.shiftRows(line + beginRowIndex, totalRows + line,lists.size());
            for (Map<String, Object> list : lists) {
                List<Object> objects = getPhExcelValues(list, line + 1);
                excel.writeLineWithFormat(objects,line + beginRowIndex);
                line++;
            }
            excel.shiftRows(line + beginRowIndex, totalRows + line,lists2.size());
            for (Map<String, Object> list : lists2) {
                List<Object> objects = getPhExcelValues2(list, line + 1);
                excel.writeLineWithFormat(objects,line + beginRowIndex);
                line++;
            }
            excel.shiftRows(beginRowIndex, totalRows + line, -1);//删除多余行
            excel.shiftRows(beginRowIndex + line, totalRows + line, -1);//删除多余行
            setExcelContent(response, rootDicItem.getItemName() + "丝虫病病原学监测汇总表.xls");
            excel.save(response.getOutputStream());

            lists.clear();
//			transferList = null;*/
        } catch (Exception e) {
            log.error("下载《" + rootDicItem.getItemName() + "丝虫病病原学监测汇总表》出错", e);
            throw e;
        }
    }

    /**
     * 生成转诊EXCEL一行数据
     *
     * @param
     * @return
     */
    private List<Object> getPhExcelValues(Map<String, Object> list, int lineNumber) {
        List<Object> line = new ArrayList<Object>();
        line.add(list.get("ORGAN_NAME"));
        line.add("血检");
        line.add(list.get("cn1"));
        line.add(list.get("cn2"));
        line.add(list.get("cn3"));
        return line;
    }
    private List<Object> getPhExcelValues2(Map<String, Object> list, int lineNumber) {
        List<Object> line = new ArrayList<Object>();
        line.add("合计");
        line.add("");
        line.add(list.get("cn1"));
        line.add(list.get("cn2"));
        line.add(list.get("cn3"));
        return line;
    }

}
