/**
 * Copyright (c) 2010-2020 Founder International Co., Ltd. All Rights Reserved.
 * 
 * This software is the confidential and proprietary information of Founder. You
 * shall not disclose such Confidential Information and shall use it only in
 * accordance with the terms of the agreements you entered into with Founder.
 */

package com.founder.elb.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.founder.elb.common.ElbConstants;
import com.founder.elb.common.MessageUtils;
import com.founder.elb.entity.Role;
import com.founder.elb.entity.User;
import com.founder.elb.service.ISecurityService;
import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.ObjectUtil;

/**
 * 用户管理
 */
@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private ISecurityService securityService;

	/**
	 * 进入首页
	 */
	@RequestMapping("/index")
	public String index() {
		String result = "user.index";
		// TODO
		return result;
	}

	/**
	 * 进入登陆界面;登陆
	 */
	@RequestMapping("/login")
	public String login(User user) {
		String result = null;
		if (user == null) {
			result = "user.login";
			// TODO
		} else {
			result = "redirect:user/index";
			// TODO
		}
		return result;
	}

	/**
	 * 进入注册界面;注册
	 */
	@RequestMapping("/reg")
	public String reg(User user) {
		String result = null;
		if (user == null) {
			result = "user.reg";
			// TODO
		} else {
			result = "redirect:user/index";
			// TODO
		}
		return result;
	}

	/**
	 * 进入忘记密码界面;忘记密码
	 */
	@RequestMapping("/getpass")
	public String getpass(User user) {
		String result = null;
		if (user == null) {
			result = "user.getpass";
			// TODO
		} else {
			result = "redirect:user/index";
			// TODO
		}
		return result;
	}
	
	
	/**
	 * 用户名check
	 */
	@RequestMapping("/check")
	public void check(String userName,HttpServletResponse response) {
		User user;
		user=securityService.getUser(userName);
		if(ObjectUtil.isNotEmpty(user)){
		
			MessageUtils.outputJSONResult("用户名已存在", response);
			
		}
		
	}
	
	/**
	 * 进入用户创建界面
	 */
	@RequestMapping("/add")
	public String add(ModelMap model) {
		model.addAttribute("roles", securityService.getRoles());
		model.addAttribute("columnSize",ElbConstants.Role_Column);
		
		return "/user/add";
	}

	/**
	 * 进入用户基本信息修改界面
	 */
	@RequestMapping("/userUpdate")
	public String userUpdate(HttpSession session,ModelMap model) {
		
		Object obj = session.getAttribute("currentUser");		
		if (ObjectUtil.isNotEmpty(obj)) {
			model.addAttribute("user", (User)obj);			
		}
		return "/user/userUpdate";
	}
	
	/**
	 * 修改用户基本信息/不包括角色信息
	 */
	@RequestMapping("/updateUser")
	public String updateUser(ModelMap model,User user,String birth) {
		int result=0;
		user.setBirthDate(DateUtil.parseSimpleDate(birth, "yyyy/MM/dd"));  //进行日期转换
		result=securityService.updateUser(user);
		if(result>0){
			model.addAttribute("currentUser",user);
		}
		return "/user/userUpdate";
	
	}
	
	/**
	 * 创建用户(+角色)/更新用户(+角色)
	 */
	@RequestMapping("/save")
	public String save(ModelMap model, User user, String roleIds,String birth) {
		Integer[] roleId = convertToInteger(roleIds);
		user.setBirthDate(DateUtil.parseSimpleDate(birth, "yyyy/MM/dd"));  //进行日期转换
		
		if (ObjectUtil.isNotEmpty(user.getId())) {// 判断用户id不为空执行更新操作
			securityService.updateUser(user, roleId);
			
		} else { // 判断用户id为空执行新增操作
			String pwd = "123456"; 
			user.setPassword(pwd);
			securityService.createUser(user, roleId);
		}
		return "redirect:/user/list";
	}

	/**
	 * 用户查询
	 */
	@RequestMapping("/searchUser")
	public String searchUser(HttpSession session,ModelMap model, Criteria criteria, User user, HttpServletRequest request) {		
		session.setAttribute("searchItem", user); //设置检索属性		
		PageList<User> list = null;
		String indexPage = request.getParameter("indexPage");
		int currentPage = Integer.valueOf(indexPage);
		Page page = new Page(10, currentPage);
		list = securityService.getUsers(page, criteria, user); // 自定义service方法
		model.addAttribute("page", list.getPage());
		model.addAttribute("collection", list.getList());
		model.addAttribute("user",user);		
		return "/user/list";
	}

	/**
	 * 用户状态变更
	 */
	@RequestMapping("/status")
	public String statusChange(String userIds, Integer status) {
		
		securityService.changeStatus(status, convertToLong(userIds));
		
		return "redirect:/user/list";
	}

	/**
	 * 修改用户密码
	 */
	@RequestMapping("/changepwd")
	public String changepwd() { 
		return "/user/changepwd";
	}

	/**
	 * 修改用户密码
	 */
	@RequestMapping("/updatepwd/{newpwd}")
	public String updatepwd(HttpSession session, ModelMap model, User user, @PathVariable("newpwd") String newPassword) {		
		int result = 0;
		Object obj = session.getAttribute("currentUser");		
		if (ObjectUtil.isNotEmpty(user)&&ObjectUtil.isNotEmpty(obj)) {
			String userName = ((User) obj).getUserName();
			String oldPassword = user.getPassword();			
			model.addAttribute("userName", userName);			
			result = securityService.changePassword(userName, oldPassword, newPassword);
		}
		model.addAttribute("message", result > 0 ? "修改成功" : "旧密码不对，修改失败");
		return "/user/changepwd";
	}

	/**
	 * 进入用户查询界面;查询;修改
	 */
	@RequestMapping("/list")
	public String goToList(ModelMap model, Criteria criteria, HttpServletRequest request) {
		
		PageList<User> list = null;
		Page p = (Page)request.getSession().getAttribute("currentPage");
			int pageIndex=p!=null?p.getCurrentPage():1;
		User user = (User)request.getSession().getAttribute("searchItem");
		
		Page page = new Page(10, pageIndex);
		
		if(ObjectUtil.isNotEmpty(user)){
			list = securityService.getUsers(page, criteria, user); // 自定义service方法
		}else{
			list = securityService.getUsers(page, criteria);
		}
		
		model.addAttribute("page", list.getPage());
		model.addAttribute("collection", list.getList());
		model.addAttribute("user",user);
		return "/user/list";
	}

	/**
	 * 进入用户修改页面
	 */
	@RequestMapping("/update")
	public String update(long userId,ModelMap model) {
		List<Role> roles = new ArrayList<Role>();
		List<Role> usedRoles = new ArrayList<Role>();
		User user = new User();
		
		user = securityService.getUser(userId); // 用户信息
		roles = securityService.getRoles(); // 所有角色
		usedRoles = securityService.getRoles(userId); // 已使用角色
		
		model.addAttribute("columnSize",ElbConstants.Role_Column);
		model.addAttribute("user", user);
		model.addAttribute("roles", roles);
		model.addAttribute("usedRoles", usedRoles);
		
		return "/user/update";
	}

	/**
	 * 查看
	 */
	@RequestMapping("/detail")
	public String detail(User user) {
		String result = "user.detail";
		// TODO
		return result;
	}

	/**
	 * 批量删除用户
	 */
	@RequestMapping("/delete")
	public String deleteUser(String userIds) {
		
		securityService.deleteUser(convertToLong(userIds));
		
		return "redirect:/user/list";
	}

	/**
	 * 进入统一角色设定画面
	 */
	@RequestMapping("/goToRoleSet/{userIds}")
	public String goToRoleSet(ModelMap model, @PathVariable("userIds") String userIds) {
		List<User> list = new ArrayList<User>();
		List<Role> roles = securityService.getRoles();
		list = securityService.getUsers(convertToLong(userIds));
		
		model.addAttribute("columnSize",ElbConstants.Role_Column);
		model.addAttribute("roles", roles);
		model.addAttribute("collection", list);
		model.addAttribute("userIds", userIds);
		
		return "user/roleSet";
	}

	/**
	 * 统一角色设定(操作)
	 */
	@RequestMapping("/roleSet")
	public String roleSet(String roleIds, String userIds) {
		
		Long[] userId = convertToLong(userIds);
		Integer[] roleId = convertToInteger(roleIds);
		
		securityService.updateUserRole(userId, roleId);
		return "redirect:/user/list";
	}

	/**
	 * 禁用
	 */
	@RequestMapping("/forbidden")
	public String forbidden() {
		String result = "redirect:user/list";
		// TODO
		return result;
	}

	/**
	 * 进入导入界面；导入
	 */
	@RequestMapping("/import")
	public String importFile(File file) {
		String result = null;
		if (file == null) {
			result = "user.import";
			// TODO
		} else {
			result = "redirect:user/list";
			// TODO
		}
		return result;
	}

	/**
	 * 导出
	 */
	@RequestMapping("/export")
	public String exportFile() {
		String result = "user.export";
		return result;
	}

	public static Long[] convertToLong(String id) { // 工具类Long
		if (ObjectUtil.isNullOrEmpty(id)) {
			Long[] ids = null;
			return ids;
		} else {
			String[] sample = id.split(",");
			Long[] ids = new Long[sample.length];
			for (int i = 0; i < sample.length; i++) {
				ids[i] = Long.parseLong(sample[i]);
			}
			return ids;
		}
	}

	public static Integer[] convertToInteger(String id) { // 工具类Integer
		if (ObjectUtil.isNullOrEmpty(id)) {
			Integer[] ids = null;
			return ids;
		} else {
			String[] sample = id.split(",");
			Integer[] ids = new Integer[sample.length];
			for (int i = 0; i < sample.length; i++) {
				ids[i] = Integer.parseInt(sample[i]);
			}
			return ids;
		}
	}
}