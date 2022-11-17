
package com.founder.elb.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.founder.elb.entity.Access;
import com.founder.elb.entity.User;
import com.founder.elb.service.IMenuService;
import com.founder.elb.service.ISecurityService;
import com.founder.fasf.util.ObjectUtil;

@Controller
@RequestMapping("/access")
public class LoginController {

	@Autowired
	private ISecurityService securityService;

	@Autowired
	private IMenuService menuService;

	@RequestMapping("/index")
	public String index() throws Exception {
		return "login/login";
	}

	@RequestMapping("/login")
	public String login(User user, HttpServletRequest request, ModelMap model) {
		User currentUser = securityService.login(user.getUserName(), user.getPassword());
		if (ObjectUtil.isNotEmpty(currentUser)) {
			request.getSession().setAttribute("currentUser", currentUser);
			List<Access> accesslist = securityService.getAccezz(currentUser.getId(), 2);
			String menuHTML = menuService.getMenus(accesslist);
			//request.getSession().setAttribute("menus", menuHTML);
			// getRoleAccess(request, currentUser.getId());
			model.addAttribute("menus", menuHTML);
			return "layouts/baseLayout";
		} else {
			model.addAttribute("message", "请输入正确的用户名或者密码！");
			return "login/login";
		}
	}

	@RequestMapping("/logout")
	public String logout(HttpServletRequest request) throws Exception {
		request.getSession().invalidate();
		return "login/login";
	}

	@RequestMapping("/home")
	public String home() throws Exception {
		return "layouts/homepage";
	}
}
/*
 * private void getRoleAccess(HttpServletRequest request, Long userId) {
 * List<Menu> menus = new ArrayList<Menu>(); Map<Integer, Menu> menuMap =
 * securityService.getMenuMap(); List<Access> accesslst =
 * securityService.getAccess(userId, null); for (Access access : accesslst) { if
 * (access.getAccessLevel() == 2) { menus.add(menuMap.get(access.getSrcId())); }
 * } List<MenuForm> menuForms = getSortedMenuForm(menus);
 * request.getSession().setAttribute("menus", menuForms); }
 * 
 * private List<MenuForm> getSortedMenuForm(List<Menu> menus) { List<Menu>
 * menuKey = getMenuKey(menus); List<MenuForm> menuFormList = new
 * ArrayList<MenuForm>(); for (Menu menuOne : menuKey) { MenuForm menuForm = new
 * MenuForm(); menuForm.setMenu(menuOne);
 * menuForm.setChildMenuForms(getChildByMenuForms(menus, menuOne));
 * menuFormList.add(menuForm); } return menuFormList; }
 * 
 * private List<MenuForm> getChildByMenuForms(List<Menu> menus, Menu menu) {
 * List<MenuForm> menuFormList = new ArrayList<MenuForm>(); if (null == menus ||
 * menus.isEmpty() || null == menu) return menuFormList; for (Menu menuOne :
 * menus) { if (null == menuOne) continue; if (menuOne.getParentId() ==
 * menu.getId()) { MenuForm menuForm = new MenuForm();
 * menuForm.setMenu(menuOne);
 * menuForm.setChildMenuForms(getThreeLevelChildByMenuForms(menus, menuOne));
 * menuFormList.add(menuForm); } } return menuFormList; }
 * 
 * private List<MenuForm> getThreeLevelChildByMenuForms(List<Menu> menus, Menu
 * menu) { List<MenuForm> menuFormList = new ArrayList<MenuForm>(); if (null ==
 * menus || menus.isEmpty() || null == menu) return menuFormList; for (Menu
 * menuOne : menus) { if (null == menuOne) continue; if (menuOne.getParentId()
 * == menu.getId()) { MenuForm menuForm = new MenuForm();
 * menuForm.setMenu(menuOne); menuForm.setChildMenuForms(new
 * ArrayList<MenuForm>()); menuFormList.add(menuForm); } } return menuFormList;
 * }
 * 
 * private List<Menu> getMenuKey(List<Menu> menu) { List<Menu> menuKey = new
 * ArrayList<Menu>(); if (null == menu || menu.isEmpty()) return menuKey; for
 * (Menu menuOne : menu) { if (null == menuOne) continue; if (0 ==
 * menuOne.getParentId()) { menuKey.add(menuOne); } } return menuKey; }
 */