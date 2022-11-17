package com.founder.rhip.cdm.controller.Questionnaire;

import com.founder.rhip.cdm.controller.CdmBaseController;
import com.founder.rhip.cdm.service.IQuestionnaireService;
import com.founder.rhip.ehr.entity.management.DmAnswerPeople;
import com.founder.rhip.ehr.entity.management.DmQuestion;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by admin on 2017/5/18.
 */
@Controller
@RequestMapping("/cdm/Questionnaire")
public class QuestionnaireController extends CdmBaseController {

    @Resource(name = "questionnaireService")
    private IQuestionnaireService questionnaireService;

    @RequestMapping(value = "/answer")
    public String answerSearch(HttpServletRequest request, ModelMap model) {
        List<DmQuestion> list = questionnaireService.getQuestionsList(null);
        model.addAttribute("list",list);
        return "rhip.cdm.questionnaire.answer";
    }

    @RequestMapping(value = "/save")
    @ResponseBody
    public Map<String, Object> save(DmAnswerPeople answerPeople, HttpServletRequest request) {
        Map<String, Object> map = new HashMap<>();
        boolean r = questionnaireService.saveDmAnswerPeople(answerPeople);
        map.put("result", r);
        map.put("message", r ? "操作成功!" : "操作失败!");
        return map;
    }

    @RequestMapping(value = "/result")
    public String result(HttpServletRequest request, ModelMap model) {
        Map<String, Object> rs = questionnaireService.searchResult();
        model.put("rs",rs);
        return "rhip.cdm.questionnaire.result";
    }
}
