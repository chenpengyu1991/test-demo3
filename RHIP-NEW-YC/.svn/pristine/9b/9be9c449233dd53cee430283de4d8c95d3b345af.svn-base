package com.founder.rhip.portal.controller;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.OP;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.ehr.common.EHRConstants;
import com.founder.rhip.ehr.common.RhipModuleName;
import com.founder.rhip.ehr.entity.portal.HospitalInfo;
import com.founder.rhip.ehr.entity.portal.Interaction;
import com.founder.rhip.portal.common.Constants;
import com.founder.rhip.portal.common.InteractionStatus;
import com.founder.rhip.portal.common.OperationName;
import com.founder.rhip.portal.service.IHospitalInfoService;
import com.founder.rhip.portal.service.IInteractionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping(value = "/interactionShow")
public class InteractionController extends BaseController {

    @Resource(name = "interactionService")
    private IInteractionService interactionService;

    @Resource(name = "lhhospitalInfoService")
    private IHospitalInfoService hospitalInfoService;

    /**
     * 互动管理首页
     *
     * @param request
     * @param model
     * @param indexPage
     * @param eventType
     * @return
     */
    @RequestMapping(value = "/index")
    public String search(HttpServletRequest request, ModelMap model, Integer indexPage, String eventType) {
        model.addAttribute("accountInfo", request.getSession().getAttribute(Constants.ACCOUNT_INFO));
        if (StringUtil.isNotEmpty(eventType)) {//判断互动管理的类型（咨询、建议、投诉）
            model.addAttribute("eventType", eventType);
        }
        Criteria criteria = new Criteria();
        criteria.add("is_delete", 0);
        List<HospitalInfo> hospitalInfo = hospitalInfoService.get(criteria);//显示咨询机构
        model.addAttribute("hospitalInfo", hospitalInfo);
        model.addAttribute("operation", "interactionInfoClick");
        return "lhportal.interaction.index";
    }

    /**
     * 互动管理列表
     *
     * @param request
     * @param model
     * @param indexPage
     * @param interaction
     * @return
     */
    @RequestMapping(value = "/list")
    public String list(HttpServletRequest request, ModelMap model, Integer indexPage, Interaction interaction) {
        Page page = new Page(EHRConstants.PAGE_SIZE, indexPage);

        if (StringUtil.isNotEmpty(interaction.getEventType())) {//判断互动管理的类型（咨询、建议、投诉）
            model.addAttribute("eventType", interaction.getEventType());
        }

        PageList<Interaction> interactionPageList = interactionService.getList(page, this.getCriteria(interaction));
        model.addAttribute("interactionList", interactionPageList.getList());

        model.addAttribute("page", interactionPageList.getPage());
        return "lhportal.interaction.list";
    }

    /**
     * 获取在线咨询列表
     *
     * @param interaction
     * @return
     */
    private Criteria getCriteria(Interaction interaction) {
        Criteria criteria = new Criteria();
        if (!ObjectUtil.isNullOrEmpty(interaction) && ObjectUtil.isNotEmpty(interaction.getTitle())) {
            criteria.add("title", OP.LIKE, interaction.getTitle());
        }
        if (!ObjectUtil.isNullOrEmpty(interaction) && ObjectUtil.isNotEmpty(interaction.getStatus())) {
            if (ObjectUtil.equals(interaction.getStatus(), InteractionStatus.REPLY.getValue()) ||
                    ObjectUtil.equals(interaction.getStatus(), InteractionStatus.RETURN.getValue())) {
                criteria.add("status", interaction.getStatus());
            } else {
                criteria.add("status", OP.IN, new String[]{InteractionStatus.ACCEPT.getValue(), InteractionStatus.ASSIGN.getValue(),
                        InteractionStatus.NEW.getValue()});
            }
        }
        if (!ObjectUtil.isNullOrEmpty(interaction) && StringUtil.isNotEmpty(interaction.getEventType())) {//判断互动管理的类型（咨询、建议、投诉）
            criteria.add("eventType", interaction.getEventType());//增加类型的分类查询
        }
        criteria.add("is_delete", 0);
        return criteria;
    }

    @RequestMapping(value = "/save")
    @ResponseBody
    public ModelMap add(HttpServletRequest request, Interaction interaction) {
        ModelMap model = new ModelMap();
        if (null != interaction) {
            interaction.setStatus(InteractionStatus.NEW.getValue());//新增
            interaction.setUnitCode(interaction.getOrgCode());
            interaction.setInsertDate(new Date());
            interactionService.insert(interaction);
            model.addAttribute("success", true);
            model.addAttribute("msg", "提交成功！");
            return model;
        }
        model.addAttribute("success", false);
        model.addAttribute("msg", "提交失败！");
        createOperationLog(request, RhipModuleName.LHPORTAL, "save", OperationName.INTERACTION);
        return model;
    }
}
