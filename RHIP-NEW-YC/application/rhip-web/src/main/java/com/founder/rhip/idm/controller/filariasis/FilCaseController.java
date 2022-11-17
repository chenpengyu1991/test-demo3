package com.founder.rhip.idm.controller.filariasis;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.OP;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.BaseController;
import com.founder.rhip.ehr.common.EHRMessageUtil;
import com.founder.rhip.ehr.common.RhipModuleName;
import com.founder.rhip.ehr.common.RoleType;
import com.founder.rhip.ehr.entity.basic.User;
import com.founder.rhip.ehr.entity.control.idm.notifiabledisease.CaseInformation;
import com.founder.rhip.ehr.entity.control.idm.notifiabledisease.IdmStatusInfo;
import com.founder.rhip.idm.common.IdmType;
import com.founder.rhip.idm.common.SpecialEvents;
import com.founder.rhip.idm.controller.form.FilariasisQueryForm;
import com.founder.rhip.idm.dto.FilariasisDto;
import com.founder.rhip.idm.service.IFilariasisService;
import com.founder.rhip.mdm.app.IDictionaryApp;
import com.founder.rhip.mdm.entity.Organization;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping(value = "/idm/filariasis/case")
public class FilCaseController extends BaseController {

    @Resource(name = "filariasisService")
    private IFilariasisService filariasisService;

    @Resource(name = "dictionaryApp")
    private IDictionaryApp dictionaryApp;

    private Logger log = LoggerFactory.getLogger(this.getClass());

    /**
     * 进入个案调查查询画面
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/search")
    public String caseSearch(HttpServletRequest request, ModelMap model) {
        return "rhip.idm.filariasis.case.search";
    }


    /**
     * 查询个案
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/caseList")
    public String getCaseList(FilariasisQueryForm form, int pageIndex, HttpServletRequest request, ModelMap model) {
        String url = "rhip.idm.filariasis.case.list";
        Page page = super.getPage(request,  pageIndex);
        Criteria criteria = new Criteria();
        Criteria ca = form.getCriteria(criteria);
        List<String> events = new ArrayList<String>();
        events.add(SpecialEvents.F_REG.getValue());
        events.add(SpecialEvents.F_CASE.getValue());
        ca.add("E.EVENT_ID", OP.IN, events);
        ca.add("S.IDM_TYPE", IdmType.FILARIASIS.getValue());
        if (!hasRole(RoleType.JKSCB, request)){
//            ca.add("I.SURVEY_ORG", getCurrentOrg(request).getOrganCode());
            ca.add("S.CURRENT_UNIT", getCurrentOrg(request).getOrganCode());
        }
        PageList<IdmStatusInfo> plist = filariasisService.findFilRegList(ca, page, false);
        model.addAttribute("statusInfo", plist.getList());
        model.addAttribute("page", plist.getPage());
        return url;
    }


    /**
     * 添加个案初始化
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/initCaseDetail")
    public String initCaseDetail(Long singleId, Long idmId, String logoff, String type, HttpServletRequest request, ModelMap model) {
        String url = "rhip.idm.filariasis.case.detail";
        String staffCode = getCurrentUser(request).getStaffCode();
        FilariasisDto filariasisDto = new FilariasisDto();
        if("add".equals(type)){
            filariasisDto = filariasisService.getRegister(singleId);
            CaseInformation caseInformation = filariasisDto.getCaseInformation();
            caseInformation.setModifyRespondents(staffCode);
            caseInformation.setModifySurveyDate(new Date());
            filariasisDto.setCaseInformation(caseInformation);
        }
        if("edit".equals(type)){
            filariasisDto = filariasisService.getCase(singleId);
        }
        model.put("filDto", filariasisDto);
        model.put("type", type);
        model.put("singleId", singleId);
        model.put("idmId", idmId);
        model.put("logoff", logoff);
        return url;
    }

    /**
     * 保存监测登记
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/saveCase")
    public String saveCase(FilariasisDto filariasisDto, Long idmId, Long singleId, String type, HttpServletRequest request, ModelMap model) {
        boolean result = false;
        if(ObjectUtil.isNotEmpty(filariasisDto)){
            Organization org = getCurrentOrg(request);
            User user = getCurrentUser(request);

            CaseInformation caseInformation = filariasisDto.getCaseInformation();
            if(!ObjectUtil.isNotEmpty(caseInformation)){
                caseInformation = new CaseInformation();
            }
            caseInformation.setModifySurveyOrg(org.getOrganCode());
//            caseInformation.setSurveyOrg(org.getOrganCode());
            filariasisDto.setCaseInformation(caseInformation);

            //存地址
            filariasisDto.getGeneralCondition().setPaAddress(dictionaryApp.queryDicItemName("FS990001", filariasisDto.getGeneralCondition().getPatownShip()) + dictionaryApp.queryDicItemName("FS990001", filariasisDto.getGeneralCondition().getPastreet()) + filariasisDto.getGeneralCondition().getPahouseNumber());

            //添加
            if("add".equals(type)){
                result = filariasisService.addCase(filariasisDto, idmId);
                createOperationLog(request, RhipModuleName.IDM, "丝虫病专项-个案", OperationName.ADD);
            }else if("edit".equals(type)){
                result = filariasisService.updateCase(filariasisDto, singleId);
                createOperationLog(request, RhipModuleName.IDM, "丝虫病专项-个案", OperationName.UPDATE);
            }
        }
        return EHRMessageUtil.returnMsg(model, result ? "success" : "fail");
    }
}
