package com.founder.rhip.portal.controller;

import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.BaseController;
import com.founder.rhip.ehr.common.EHRMessageUtil;
import com.founder.rhip.ehr.entity.portal.InfromBook;
import com.founder.rhip.portal.service.IInfromBookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Date;


/**
 * 告知书管理
 */
@Controller
@RequestMapping(value = "/infromBook")
public class InfromBookController extends BaseController {

	@Resource(name = "lhinfromBookService")
	private IInfromBookService infromBookService;

	/**
	 * 查看编辑页面
	 *
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/search")
	public String edit(HttpServletRequest request, ModelMap model) {
		InfromBook infromBook = new InfromBook();
		infromBook = infromBookService.getInfromBook();
		model.addAttribute("infromBook", infromBook);

		return "portal.lhportal.edit";
	}
	/**
	 * 保存页面
	 *
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/save")
	public String save(HttpServletRequest request,ModelMap model, @Valid InfromBook infromBook) {
		infromBookService.save(infromBook);
		if(ObjectUtil.isNotEmpty(infromBook.getId())) {
			infromBook.setUpdateTime(new Date());
			infromBook.setUpdateUser(getCurrentUser(request).getId());
		}
		infromBook.setCreateTime(new Date());
		infromBook.setCreateUser(getCurrentUser(request).getId());
		return EHRMessageUtil.returnMsg(model, "success");
	}
}
