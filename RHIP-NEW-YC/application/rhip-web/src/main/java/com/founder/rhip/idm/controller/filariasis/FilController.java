package com.founder.rhip.idm.controller.filariasis;

import com.founder.fasf.beans.Criteria;
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
@RequestMapping(value = "/idm/filariasis")
public class FilController extends BaseController {

    @Resource(name = "filariasisService")
    private IFilariasisService filariasisService;

    @Resource(name = "dictionaryApp")
    private IDictionaryApp dictionaryApp;

    private Logger log = LoggerFactory.getLogger(this.getClass());

	/**
	 * 进入丝虫病首页
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/index")
	public String index(HttpServletRequest request, ModelMap model) {
		model.put("pageIndex", 1);
		return "rhip.idm.filariasis.index";
	}

    /**
     * 进入丝虫病监测登记查询画面
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/register/search")
    public String registerSearch(HttpServletRequest request, ModelMap model) {
        return "rhip.idm.filariasis.register.search";
    }

    /**
     * 查询监测登记
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/reg/registerList")
    public String registerList(FilariasisQueryForm form, int pageIndex, HttpServletRequest request, ModelMap model) {
        String url = "rhip.idm.filariasis.register.list";
        Page page = super.getPage(request,  pageIndex);

        List<String> events = new ArrayList<String>();
        events.add(SpecialEvents.F_REG.getValue());

        Criteria criteria = new Criteria();
        Criteria ca = form.getRegCriteria(criteria);
        if (hasRole(RoleType.ZXSCB, request)){
            ca.add("I.SURVEY_ORG", getCurrentOrg(request).getOrganCode());
        }
        ca.add("E.EVENT_ID", events).add("S.IDM_TYPE", IdmType.FILARIASIS.getValue());
        PageList<IdmStatusInfo> plist = filariasisService.findFilRegList(ca, page, false);
        model.addAttribute("regList", plist.getList());
        model.addAttribute("page", plist.getPage());
        return url;
    }

    /**
     * 添加监测登记初始化
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/reg/initAddRegister")
    public String initAddRegister(Long singleId, String type, HttpServletRequest request, ModelMap model) {
        String url = "rhip.idm.filariasis.register.add";
        Organization org = getCurrentOrg(request);
        String userCode = getCurrentUser(request).getUserCode();
        FilariasisDto filariasisDto = new FilariasisDto();
        CaseInformation caseInformation = new CaseInformation();
        if("add".equals(type)){
            caseInformation.setSurveyDate(new Date());
            caseInformation.setSurveyOrg(org.getOrganCode());
            caseInformation.setRespondents(userCode);
            filariasisDto.setCaseInformation(caseInformation);
        }
        if("edit".equals(type)){
            filariasisDto = filariasisService.getRegister(singleId);
        }

        model.put("filariasisDto", filariasisDto);
        model.put("type", type);
        return url;
    }


    /**
     * 保存监测登记
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/reg/saveRegister")
    public String saveRegister(FilariasisDto filariasisDto, String type, HttpServletRequest request, ModelMap model) {
        boolean result = false;
        if(ObjectUtil.isNotEmpty(filariasisDto)){
            Organization org = getCurrentOrg(request);
            User user = getCurrentUser(request);

            //存地址
            filariasisDto.getGeneralCondition().setPaAddress(dictionaryApp.queryDicItemName("FS990001", filariasisDto.getGeneralCondition().getPatownShip()) + dictionaryApp.queryDicItemName("FS990001", filariasisDto.getGeneralCondition().getPastreet()) + filariasisDto.getGeneralCondition().getPahouseNumber());

            //添加
            if("add".equals(type)){
                result = filariasisService.addRegister(filariasisDto);
                createOperationLog(request, RhipModuleName.IDM, "丝虫病专项-监测登记", OperationName.ADD);
            }else if("edit".equals(type)){
                result = filariasisService.updateRegister(filariasisDto);
                createOperationLog(request, RhipModuleName.IDM, "丝虫病专项-监测登记", OperationName.UPDATE);
            }
        }
        return EHRMessageUtil.returnMsg(model, result ? "success" : "fail");
    }

}
