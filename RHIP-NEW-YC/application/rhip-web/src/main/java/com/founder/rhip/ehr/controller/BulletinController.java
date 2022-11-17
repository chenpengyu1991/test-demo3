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
import com.founder.rhip.ehr.entity.basic.Bulletin;
import com.founder.rhip.ehr.service.basic.IBulletinService;

/** 
* @ClassName: BulletinController 
* @Description: 公告管理的controller
* @author LJY
* @date 2013-8-2 上午10:05:50 
*  
*/
@Controller
@RequestMapping("/bulletin")
public class BulletinController extends BaseController {
	
	@Autowired
	private IBulletinService bulletinService;
	
	@RequestMapping("/search")
	public String search(HttpServletRequest request, ModelMap model,Boolean fromHome){
		model.addAttribute("fromHome", fromHome);
		return "rhip.ehr.bulletin.search";
	}
	
	@RequestMapping("/list")
	public String list(HttpServletRequest request,BulletinSearch bulletinSearch, ModelMap model,Integer indexPage){
		Criteria criteria = bulletinSearch.getCriteria();
		Page page = super.getPage(request, indexPage);
		
		PageList<Bulletin> list = bulletinService.getBulletinPageList(page, criteria);
		model.addAttribute("bulletins", list.getList());
		model.addAttribute("page", list.getPage());
		return "rhip.ehr.bulletin.list";
	}
	
	@RequestMapping("/add")
	public String add(HttpServletRequest request, ModelMap model){
		return "rhip.ehr.bulletin.add";
	}
	
	@RequestMapping("/edit")
	public String edit(HttpServletRequest request, ModelMap model,Long bulletinId){
		Bulletin bulletin = bulletinService.getBulletin(new Criteria("id",bulletinId));
		model.addAttribute("bulletin", bulletin);
		return "rhip.ehr.bulletin.add";
	}
	
	@RequestMapping("/view")
	public String view(ModelMap model,Long bulletinId){
		Bulletin bulletin = bulletinService.getBulletin(new Criteria("id",bulletinId));
		model.addAttribute("bulletin", bulletin);
		return "rhip.ehr.bulletin.view";
	}
	
	
	@RequestMapping("/delete")
	@ResponseBody
	public String delete(ModelMap model,Long bulletinId){
		return bulletinService.deleteBulletin(bulletinId).toString();
	}
	
	@RequestMapping("/save")
	@ResponseBody
	public  String save(HttpServletRequest request, ModelMap model,Bulletin bulletin){
		Long bulletinId = bulletin.getId();
		
		if(bulletinId!= null && bulletinId != 0){
			return bulletinService.updateBulletin(bulletin).toString();
		}
		Long userId = super.getCurrentUser(request).getId();
		bulletin.setSubmitTime(new Date());
		bulletin.setSubmitor(userId);
		return bulletinService.saveBulletin(bulletin).toString();
	}
}


class BulletinSearch{
	String title;
	Integer isDelete;
	Date submitDateFrom;
	Date submitDateTo;
	
	public Criteria getCriteria(){
		Criteria criteria = new Criteria();
		if(ObjectUtil.isNotEmpty(title)){
			criteria.add("title",OP.LIKE, title);
		}
		if(ObjectUtil.isNotEmpty(isDelete)){
			criteria.add("isDelete", isDelete);
		}
		
		DateUtil.getCriteriaByDateRange(criteria,"submitTime",submitDateFrom,submitDateTo);
		return criteria;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
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

	public Integer getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}
}