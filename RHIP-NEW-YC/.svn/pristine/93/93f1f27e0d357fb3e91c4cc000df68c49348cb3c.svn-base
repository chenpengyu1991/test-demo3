package com.founder.rhip.ehr.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.OP;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.BaseController;
import com.founder.rhip.ehr.common.RoleType;
import com.founder.rhip.ehr.entity.basic.Question;
import com.founder.rhip.ehr.service.basic.IQuestionService;

/** 
* @ClassName: QuestionController 
* @Description: 系统答疑的controller
* @author LJY
* @date 2013-8-2 上午10:05:15 
*  
*/
@Controller
@RequestMapping("/question")
public class QuestionController extends BaseController {

	@Autowired
	private IQuestionService questionService;
	
	
	@RequestMapping("/search")
	public String search(HttpServletRequest request, ModelMap model,Boolean fromHome){
		model.addAttribute("fromHome", fromHome);
		return "rhip.ehr.question.search";
	}
	
	@RequestMapping("/list")
	public String list(HttpServletRequest request, ModelMap model,QuestionSearch questionSearch,Integer indexPage){
		Criteria criteria = questionSearch.getCriteria();
		//BUG0133518
		/*if(!super.hasRole(RoleType.ADMIN, request)){
			criteria.add("submitor", super.getCurrentUser(request).getId());
		}*/
		
		Page page = super.getPage(request, indexPage);
		
		PageList<Question> list = questionService.getQuestionPageList(page, criteria);
		model.addAttribute("questions", list.getList());
		model.addAttribute("page", list.getPage());
		model.addAttribute("submitor", getCurrentUser(request).getId());
		return "rhip.ehr.question.list";
	}
	
	@RequestMapping("/add")
	public String add(HttpServletRequest request, ModelMap model,Integer questionId,Boolean fromHome){
		if(ObjectUtil.isNotEmpty(questionId) && questionId != 0){
			Criteria criteria = new Criteria("id",questionId);
			Question question = questionService.getQuestion(criteria);
			model.addAttribute("question", question);
		}
		model.addAttribute("fromHome", fromHome);
		return "rhip.ehr.question.add";
	}
	
	@RequestMapping("/save")
	@ResponseBody
	public String save(HttpServletRequest request, ModelMap model,Question question){
		Long questionId = question.getId();
		
		if(questionId!= null && questionId != 0){
			return questionService.update(question).toString();
		}
		question.setSubmitor(super.getCurrentUser(request).getId());
		question.setSubmitTime(new Date());
		return questionService.save(question).toString();
	}
	
	@RequestMapping("/view")
	public String view(Integer questionId, ModelMap model){
		Criteria criteria = new Criteria("id",questionId);
		Question question = questionService.getQuestion(criteria);
		model.addAttribute("question", question);
		return "rhip.ehr.question.view";
	}
	
	@RequestMapping("/answer")
	public String answer(Integer questionId, ModelMap model,Boolean fromHome){
		Criteria criteria = new Criteria("id",questionId);
		Question question = questionService.getQuestion(criteria);
		model.addAttribute("question", question);
		model.addAttribute("fromHome", fromHome);
		return "rhip.ehr.question.answer";
	}
	
	@RequestMapping("/answerSave")
	@ResponseBody
	public String answerSave(HttpServletRequest request, ModelMap model,Question question){
		question.setAnswer(super.getCurrentUser(request).getId());
		question.setAnswerTime(new Date());
		return questionService.answer(question).toString();
	}
	
	@RequestMapping("/delete")
	@ResponseBody
	public String delete(Integer questionId){
		return questionService.delete(questionId).toString();
	}
}


class QuestionSearch{
	String keyWord;
	String keyWordType;
	Date submitDateFrom;
	Date submitDateTo;
	Integer answerStuts;
	
	public Criteria getCriteria(){
		Criteria criteria = new Criteria();
		
		if(ObjectUtil.isNotEmpty(keyWord)){
			criteria.add("keyWord",OP.LIKE, keyWord);
		}
		if(ObjectUtil.isNotEmpty(keyWordType)){
			criteria.add("keyWordType",keyWordType);
		}
		DateUtil.getCriteriaByDateRange(criteria,"submitTime",submitDateFrom,submitDateTo);
		
		if(ObjectUtil.isNullOrEmpty(answerStuts)){
			return criteria;
		}
		
		if(answerStuts == 1){
			criteria.add("answer", OP.IS, " NOT NULL");
		}else{
			criteria.add("answer", OP.IS, " NULL");
		}
		
		return criteria;
	}
	
	public String getKeyWordType() {
		return keyWordType;
	}

	public void setKeyWordType(String keyWordType) {
		this.keyWordType = keyWordType;
	}

	public String getKeyWord() {
		return keyWord;
	}

	public void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
	}

	public Date getSubmitDateFrom() {
		return submitDateFrom;
	}

	public void setSubmitDateFrom(Date submitDateFrom) {
		this.submitDateFrom = submitDateFrom;
	}

	public Date getSubmitDateTo() {
		return submitDateTo;
	}

	public void setSubmitDateTo(Date submitDateTo) {
		this.submitDateTo = submitDateTo;
	}

	public Integer getAnswerStuts() {
		return answerStuts;
	}

	public void setAnswerStuts(Integer answerStuts) {
		this.answerStuts = answerStuts;
	}
	
}