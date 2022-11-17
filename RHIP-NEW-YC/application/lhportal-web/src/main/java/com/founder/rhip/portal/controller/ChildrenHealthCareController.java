package com.founder.rhip.portal.controller;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.entity.basic.PersonInfo;
import com.founder.rhip.ehr.entity.child.BirthCertificate;
import com.founder.rhip.ehr.entity.child.ChildHealthCard;
import com.founder.rhip.ehr.entity.child.FrailChildFollowup;
import com.founder.rhip.ehr.service.IBrwHealthService;
import com.founder.rhip.ehr.service.personal.IPersonalRecordService;
import com.founder.rhip.portal.common.Constants;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping(value = "/childrenHealthCare")
public class ChildrenHealthCareController extends BaseController {
	@Resource
	private IBrwHealthService brwHealthService;
	@Resource
	private IPersonalRecordService personalRecordService;
	/**
	 * 儿童保健卡
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/childHealthCard")
	public String getChildHealthCard(HttpServletRequest request,ModelMap model){
		if (!checkLoginStatus(request)) return "lhportal.info.login";
		Criteria criteria = new Criteria();
		PersonInfo personInfo=(PersonInfo)request.getSession().getAttribute(Constants.PERSON_INFO);
		criteria.add("personId", personInfo.getId());
		ChildHealthCard childHealthCard = brwHealthService.getChildHealthCard(criteria);
		if(ObjectUtil.isNullOrEmpty(childHealthCard)){
			return "lhportal.ehr.brwNoRecord";
		}
		model.addAttribute("childHealthCard", childHealthCard);
		return "protal.ehr.childHealthCard";
	}
	/**
	 * 体弱儿童管理随访 检查时间 列表
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/frailChildFollowupList")
	public String getFrailChildFollowups(HttpServletRequest request, ModelMap model){
		Criteria criteria = new Criteria();
		PersonInfo personInfo=(PersonInfo)request.getSession().getAttribute(Constants.PERSON_INFO);
		criteria.add("personId", personInfo.getId());
		String[] properties = {"id", "checkDate"};
		List<FrailChildFollowup> frailChildFollowups = brwHealthService.getFrailChildFollowups(criteria, properties);
		if(ObjectUtil.isNullOrEmpty(frailChildFollowups)){
			return "lhportal.ehr.brwNoRecord";
		}
		model.addAttribute("frailChildFollowups", frailChildFollowups);
		return "protal.ehr.frailChildFollowupList";
	}
	/**
	 * 出生证明详细
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("/newBornDetail/{id}")
	public String newBornDetail(@PathVariable("id") String id, HttpServletRequest request, ModelMap model){
		/*Criteria criteria = new Criteria();
		PersonInfo pi=(PersonInfo)request.getSession().getAttribute(Constants.PERSON_INFO);
		criteria.add("id", pi.getId());
		PersonInfo personInfo = personalRecordService.getPersonRecord(criteria);
		if(null == personInfo){
			return "lhportal.ehr.brwNoRecord";
		}
		criteria = new Criteria("MOTHER_IDCARD", personInfo.getIdcard());
		BirthCertificate chBirthCertificate = brwHealthService.getChBirthCertificate(criteria);*/
		if(id.equals("0")){
			return "lhportal.ehr.brwNoRecord";
		}
		Criteria criteria = new Criteria("id", id);
		BirthCertificate chBirthCertificate = brwHealthService.getChBirthCertificate(criteria);
		if(ObjectUtil.isNullOrEmpty(chBirthCertificate)){
			return "lhportal.ehr.brwNoRecord";
		}
		model.addAttribute("chBirthCertificate", chBirthCertificate);
		
		if(ObjectUtil.isNotEmpty(chBirthCertificate)){
			if(ObjectUtil.isNotEmpty(chBirthCertificate.getMotherIdcard())){
				model.addAttribute("midCard", chBirthCertificate.getMotherIdcard().toCharArray());
			}
			if(ObjectUtil.isNotEmpty(chBirthCertificate.getFaterIdcard())){
				model.addAttribute("fidCard", chBirthCertificate.getFaterIdcard().toCharArray());
			}
		}
		return "protal.ehr.newBornDetail";
	}
	/**
	 * 体弱儿童管理随访 详细
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("/frailChildFollowup")
	public String getFrailChildFollowup(String id, ModelMap model){
		Criteria criteria = new Criteria();
		criteria.add("id", id);
		FrailChildFollowup frailChildFollowup = brwHealthService.getFrailChildFollowup(criteria);
		if(ObjectUtil.isNullOrEmpty(frailChildFollowup)){
			return "lhportal.ehr.brwNoRecord";
		}
		model.addAttribute("frailChildFollowup", frailChildFollowup);
		return "protal.ehr.frailChildFollowup";
	}
//	/**
//	 * 儿童体检详细
//	 * @param examId
//	 * @param model
//	 * @return
//	 */
//	@RequestMapping("/childExamDetail")
//	public String getChildExamDetail(String examId,ModelMap model){
//		Criteria criteria = new Criteria();
//		criteria.add("id", examId);
//		ChildHealthExamination childHealthExamination = brwHealthService.getChildHealthExam(criteria);
//		model.addAttribute("childHealthExamination", childHealthExamination);
//		return "protal.ehr.childHealthExam";
//	}
}
