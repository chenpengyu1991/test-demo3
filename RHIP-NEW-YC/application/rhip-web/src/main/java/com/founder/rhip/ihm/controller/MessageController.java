package com.founder.rhip.ihm.controller;

import com.founder.fasf.beans.*;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.BaseController;
import com.founder.rhip.ehr.common.EHRMessageUtil;
import com.founder.rhip.ehr.entity.basic.User;
import com.founder.rhip.ehr.entity.message.MessageSent;
import com.founder.rhip.ehr.entity.message.ReceivedInfo;
import com.founder.rhip.ehr.entity.sr.SrScientificResearch;
import com.founder.rhip.ihm.service.IMessageService;
import com.founder.rhip.sr.controller.form.SrQueryForm;
import com.founder.rhip.sr.service.ISrService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping(value = "/msg")
public class MessageController extends BaseController {

    @Resource(name = "messageService")
    private IMessageService messageService;

    @RequestMapping("/index")
    public String search(String personal, ModelMap modelMap) {
        modelMap.addAttribute("personal", personal);
        return "rhip.ehr.message.index";
    }

    @RequestMapping("/sentList")
    public String list(HttpServletRequest request, ModelMap modelMap, int pageIndex, SrQueryForm form, String personal) {
        PageList<MessageSent> plist = new PageList<>();
        Page page = super.getPage(request, pageIndex);
        Criteria criteria = form.toCriteria();
        if("1".equals(personal)){//只能看自己的 未读的
            User user = getCurrentUser(request);
            Criteria ca1 = new Criteria("RECIPIENT", user.getId());
            PageList<ReceivedInfo> msgs = messageService.getPersonMsgs(ca1, page);
            modelMap.addAttribute("messages", msgs.getList());
            modelMap.addAttribute("personal", "1");
        }else{
            plist = messageService.getSentMessages(page, criteria);
            modelMap.addAttribute("messages", plist.getList());
        }
        modelMap.addAttribute("page", page);
        modelMap.addAttribute("pageIndex", pageIndex);
        return "rhip.ehr.message.list";
    }


    @RequestMapping("/initAdd")
     public String initAdd(HttpServletRequest request, ModelMap model, MessageSent messageSent){
        return "rhip.ehr.message.add";
    }

    /**
     * 查看，如果查看对象为接受者是跟新接受状态
     * @param id
     * @param personal
     * @param modelMap
     * @return
     */
    @RequestMapping("/view")
    public String view(HttpServletRequest request,Long id, String personal, ModelMap modelMap){
        Long userId = getCurrentUser(request).getId();
        MessageSent message = messageService.viewMessage(new Criteria("ID", id), personal, userId);
        modelMap.addAttribute("message", message);
        return "rhip.ehr.message.view";
    }

    @RequestMapping("/add")
    public String add(HttpServletRequest request, ModelMap model, MessageSent messageSent){
        boolean result = false;
        messageSent.setCreateOrganCode(getCurrentOrg(request).getOrganCode());
        messageSent.setCreateUserCode(getCurrentUser(request).getId().toString());
        messageSent.setCreateDate(new Date());
        messageService.saveSendMessage(messageSent);
        result = true;
        return EHRMessageUtil.returnMsg(model, result ? "success" : "fail");
    }
}