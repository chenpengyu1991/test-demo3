package com.founder.rhip.portal.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.founder.fasf.beans.Criteria;
import com.founder.rhip.ehr.entity.basic.PersonInfo;
import com.founder.rhip.ehr.entity.child.BirthCertificate;
import com.founder.rhip.ehr.entity.women.PrenatalFollowup;
import com.founder.rhip.ehr.service.IBrwHealthService;
import com.founder.rhip.ehr.service.personal.IPersonalRecordService;

@Controller
@RequestMapping(value = "/health")
public class HealthController extends BaseController{
	
	@Resource
	private IBrwHealthService brwHealthService;
	
	@Resource
	private IPersonalRecordService personalRecordService;
	
	
	
	@RequestMapping("/followup")
	public String followup(HttpServletRequest request, ModelMap model){
		Long personId = getPersonId(request);
		if(personId == null){
			return "lhportal.ehr.brwNoRecord";
		}
		Criteria criteria = new Criteria();
		criteria.add("personId", personId);
		List<PrenatalFollowup> whPrenatalFollowups = brwHealthService.getWhPrenatalFollowupList(criteria);
		if(null == whPrenatalFollowups || whPrenatalFollowups.size() == 0){
			return "lhportal.ehr.brwNoRecord";
		}
		model.addAttribute("whPrenatalFollowups", whPrenatalFollowups);
		return "portal.ehr.healthfollowupList";
	}
	
	@RequestMapping("/followupDetail")
	public String followupDetail(String id, ModelMap model){
		Criteria criteria = new Criteria();
		criteria.add("id", id);
		PrenatalFollowup whPrenatalFollowup = brwHealthService.getWhPrenatalFollowup(criteria);
		model.addAttribute("whPrenatalFollowup", whPrenatalFollowup);
		return "portal.ehr.healthfollowupDetail";
	}
	
	@RequestMapping("/newBorn")
	public String newBorn(HttpServletRequest request, ModelMap model){
		Long personId = getPersonId(request);
		
		if(null == personId){
			return "lhportal.ehr.brwNoRecord";
		}
		
		Criteria criteria = new Criteria();
		criteria.add("id", personId);
		PersonInfo personInfo = personalRecordService.getPersonRecord(criteria);
		if(null == personInfo){
			return "lhportal.ehr.brwNoRecord";
		}
		criteria = new Criteria("motherIdcard", personInfo.getIdcard());
		List<BirthCertificate> chBirthCertificates = brwHealthService.getChBirthCertificateList(criteria);
		if(null == chBirthCertificates || chBirthCertificates.size() == 0){
			return "lhportal.ehr.brwNoRecord";
		}
		model.addAttribute("chBirthCertificates", chBirthCertificates);
		return "portal.ehr.newBornList";
	}
	
	@RequestMapping("/newBornDetail")
	public String newBornDetail(String id, ModelMap model){
		Criteria criteria = new Criteria();
		criteria.add("id", id);
		BirthCertificate chBirthCertificate = brwHealthService.getChBirthCertificate(criteria);
		model.addAttribute("chBirthCertificate", chBirthCertificate);
		return "portal.ehr.newBornDetail";
	}
}

