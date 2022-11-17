package com.founder.rhip.ehr.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.founder.elb.entity.Access;
import com.founder.elb.entity.Menu;
import com.founder.elb.entity.Role;
import com.founder.elb.service.IMenuService;
import com.founder.elb.service.ISecurityService;
import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.OP;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.RequestUtil;
import com.founder.rhip.BaseController;
import com.founder.rhip.ehr.common.EHRMessageUtil;
import com.founder.rhip.ehr.common.RhipModuleName;

@Controller
@RequestMapping("/role")
public class RoleController extends BaseController {

	@Autowired
	private ISecurityService securityService;

	@Resource(name="menuService")
	private IMenuService menuService;

	@RequestMapping("/list")
	public String list(HttpServletRequest request, ModelMap model) {
		PageList<Role> list = null;
		String indexPage = request.getParameter("indexPage") == null ? "1" : request.getParameter("indexPage");
		int currentPage = Integer.valueOf(indexPage);
		Page page = super.getPage(request, currentPage);
		Criteria criteria = RequestUtil.getCriteria(request);
		criteria.add("id",OP.NOTIN, new Integer[]{9});
		list = securityService.getRoles(page, criteria);
		model.addAttribute("page", list.getPage());
		model.addAttribute("roles", list.getList());
		return "rhip.ehr.role.list";
	}

	/**
	 * 角色查询
	 */
	@RequestMapping("/search")
	public String search() {
		return "rhip.ehr.role.search";
	}

	/**
	 * 角色查询从更新过来
	 */
	@RequestMapping("/searchFromUpdate")
	public String searchFromUpdate(HttpServletRequest request,ModelMap model) {
		FlashScope.getCurrent(request).put("saveFlag", 1);
		return "redirect:/role/search";
	}

	@RequestMapping("/update/{roleId}")
	public String update(@PathVariable("roleId") String roleCode, ModelMap model) {
		if (ObjectUtil.isNotEmpty(roleCode)) {
			Role role = securityService.getRoleId(roleCode);
			String data = getTreeData(roleCode);
			model.addAttribute("role", role);
			model.addAttribute("data", data);
		}
		return "rhip.ehr.role.update";
	}

	@RequestMapping("/roleAccess")
	public String roleAccess() {
		return "rhip.ehr.role.roleAccess";
	}

	@RequestMapping("/roleAccess/roleList")
	public String roleAccessRoleList(@RequestParam(value = "description", required = false) String description,
									 @RequestParam(value = "indexPage", required = false, defaultValue = "1") Integer indexPage,
									 HttpServletRequest request, ModelMap model) {
		Page page = super.getPage(request, indexPage);
		Criteria criteria = new Criteria();
		if (ObjectUtil.isNotEmpty(description)) {
			criteria.add("description", OP.LIKE, description);
		}
		PageList<Role> list = securityService.getRoles(page, criteria);
		model.addAttribute("page", list.getPage());
		model.addAttribute("roles", list.getList());
		return "rhip.ehr.role.roleAccessRoleList";
	}


	@RequestMapping(value = "/popuMenu")
	public String popuMenu(@RequestParam(value = "type", required = true) String type,
						   @RequestParam(value = "menuId", required = true, defaultValue = "0") String menuCode,
						   HttpServletRequest request, ModelMap model) {
		Menu parentMenu = menuService.getMenu(menuCode);
		Menu menu = new Menu();
		if("add".equals(type)){//新增菜单
			menu.setFlag(1);
			menu.setStatus(1);
			if(ObjectUtil.isNotEmpty(parentMenu)){//如果选择了根节点以下菜单
				menu.setDepth(parentMenu.getDepth() + 1);//选择菜单的下级菜单
			}
			menu.setParentCode(Integer.parseInt(menuCode));
		}else{
			menu = menuService.getMenu(menuCode);
		}

		if(ObjectUtil.isNotEmpty(parentMenu)){//父菜单名称
			model.addAttribute("parentName", parentMenu.getNameZh());
		}
		model.addAttribute("type", type);
		model.addAttribute("menu", menu);
		return "rhip.ehr.role.manageMenu";
	}

	/**
	 * 保存菜单信息
	 * @param menu
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/saveMenu")
	public String saveMenu(Menu menu,HttpServletRequest request,ModelMap model){
		int result = 0;
		if(ObjectUtil.isNotEmpty(menu)){
			if(ObjectUtil.isNullOrEmpty(menu.getCode())){
				result = menuService.addMenu(menu);
			}else {
				result = menuService.updateMenu(menu,new String[]{"nameZh","path","isParent","menuNo"});
			}
		}
		return EHRMessageUtil.returnMsg(model, result>0 ? "success" : "fail");
	}

	@RequestMapping("/deleteMenu")
	public String deleteMenu(@RequestParam(value = "menuId", required = true, defaultValue = "0") String menuCode
			,HttpServletRequest request,ModelMap model){
		int result = 0;
		if(ObjectUtil.isNotEmpty(menuCode)){
			result = menuService.deleteMenu(new String[]{menuCode});
		}
		return EHRMessageUtil.returnMsg(model, result>0 ? "success" : "fail");
	}

	@RequestMapping(value = "/roleAccess/getAccesses")
	@ResponseBody
	public List<MenuAccessNode> roleAccessGetAccesses() {
		List<Access> accesses = securityService.getAccess();
		Map<String, Menu> menusMap = securityService.getAllMenuMap();
		Map<Integer, Menu> enabledMenusMap = new HashMap<>(accesses.size());
		Map<Integer, Access> enabledAccessMap = new HashMap<>(accesses.size());
		List<Menu> menus = new ArrayList<>(accesses.size());
		//计算可以使用的资源和权限
		for (Access access : accesses) {
			Integer resId = access.getSrcId();
			if (null != resId) {
				Menu menu = menusMap.get(resId.toString());
				if (null != menu) {
					enabledMenusMap.put(resId, menu);
					enabledAccessMap.put(resId, access);
					menus.add(menu);
				}
			}
		}
		List<MenuAccessNode> result = new ArrayList<>(menus.size() + 1);
		MenuAccessNode rootNode = new MenuAccessNode(null,null);
		result.add(rootNode);
		//计算节点,并过滤父节点不存在的节点
		for (Menu menu : menus) {
			String menuCode = menu.getCode();
			Integer parentId = menu.getParentCode();
			if (null != parentId && 0 != parentId && !enabledMenusMap.containsKey(parentId)) {
				continue;
			}
			if (null == parentId) {
				menu.setParentCode(0);
			}
			MenuAccessNode node = new MenuAccessNode(menu, enabledAccessMap.get(Integer.parseInt(menuCode)));
			result.add(node);
		}
		return result;
	}

	public static class MenuAccessNode {
		public String accessCode;
		public String menuCode;
		public Integer parentCode;
		public Integer menuNo;
		public String label;

		public MenuAccessNode(Menu menu, Access access) {
			if(ObjectUtil.isNullOrEmpty(menu)){
				label = "菜单";
				menuCode = "0";
				accessCode = "0";
				parentCode = -1;
				menuNo = -1;
			}else {
				label = menu.getNameZh();
				accessCode = access.getAccessCode();
				menuCode = menu.getCode();
				parentCode = menu.getParentCode();
				menuNo = menu.getMenuNo();
			}
		}
	}

	@RequestMapping(value = "/roleAccess/getAccessByRole")
	@ResponseBody
	public List<Access> roleAccessGetAccessByRole(@RequestParam("roleCode") String roleCode) {
		List<Access> accesses = securityService.getAccess(roleCode);
		return accesses;
	}

	@RequestMapping(value = "/roleAccess/saveAccess")
	@ResponseBody
	public boolean roleAccessSaveAccess(@RequestParam("roleCode") String roleCode, @RequestParam("accessCodes") String accessCodes, HttpServletRequest request) {
		boolean result = true;
		if (ObjectUtil.isNotEmpty(accessCodes)) {
			try {
				String[] codes = accessCodes.split(",");
				Set<String> idStringSet = new HashSet<>(codes.length);
				for (String code : codes) {
					idStringSet.add(code);
				}
				securityService.saveRole(roleCode, idStringSet.toArray(new String[idStringSet.size()]));
				createOperationLog(request, RhipModuleName.MDM, "权限管理", OperationName.UPDATE);
				result = true;
			} catch (Exception ex) {
				logger.error("权限保存失败", ex);
				result = false;
			}
		}
		return result;
	}

	@RequestMapping("/delete/{roleIds}")
	public String delete(@PathVariable("roleIds") String userIds) {
		// 删除的id值
		return "role/list";
	}

	/*
	 * 角色权限新建
	 */
	@RequestMapping("/save")
	public String save(Role role, String menuCodes,ModelMap model,
					   HttpServletRequest request) {
		List<String> errlist = new ArrayList<String>();
		if(!ObjectUtil.isNotEmpty(role.getName())){
			errlist.add("请输入角色名！");
		}
		if(!ObjectUtil.isNotEmpty(menuCodes)){
			errlist.add("请选择角色对应的权限！");
		}
		if(ObjectUtil.isNotEmpty(errlist)){
			String msg = "";
			for(String error:errlist){
				msg += "<br/>" + error;
			}
			return EHRMessageUtil.returnMsg(model, msg);
		}

		if (ObjectUtil.isNotEmpty(role) && ObjectUtil.isNotEmpty(menuCodes)) {
			role.setAccesses(menuCodes);
			if (ObjectUtil.isNullOrEmpty(role.getId())) {
				securityService.createRole(role);
			} else {
				securityService.updateRole(role);
			}
		}
		return EHRMessageUtil.returnMsg(model, "1");
	}

	/**
	 * 初期化方法
	 *
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String getRolesAccess(ModelMap model) {
		List<Role> roleList = securityService.getRoles();
		if (roleList == null || roleList.size() == 0) {
			return "common/404";
		}
		String roleCode = "0";
		String data = getTreeData(roleCode);
		model.addAttribute("data", data);
		model.addAttribute("id", roleCode);
		model.addAttribute("roleList", roleList);
		return "rhip.ehr.role.add";
	}

	@RequestMapping(value = "/getRolesAccess/{id}", method = RequestMethod.GET)
	public String getRolesAccess(@PathVariable("id") String id, ModelMap model) {
		List<Role> roleList = securityService.getRoles();
		if (roleList == null || roleList.size() == 0) {
			return "common/404";
		}
		String roleCode = id;
		String data = getTreeData(roleCode);
		model.addAttribute("data", data);
		model.addAttribute("id", roleCode);
		model.addAttribute("roleList", roleList);
		String result = "/role/setAccess";
		return result;
	}

	@RequestMapping(value = "/setRolesAccess/{id}/{accesses}", method = RequestMethod.GET)
	public String setRolesAccess(@PathVariable("id") String id, @PathVariable("accesses") String accesses, ModelMap model) {
		int result = 0;
		Role role = new Role();
		role.setId(Integer.parseInt(id));
		role.setAccesses(accesses);
		result = securityService.setRoleAccess(role);
		if (result < 0) {
			return "common/404";
		}
		return getRolesAccess(id, model);
	}

	/**
	 * 取得某一层菜单内容
	 *
	 * @param
	 * @param depth
	 * @param parentId
	 * @return List<Map<String, Object>>
	 */
	private List<Map<String, Object>> getDepthMenu(List<Map<String, Object>> list, String depth, String parentId) {
		List<Map<String, Object>> rtnList = new ArrayList<Map<String, Object>>();
		for (Map<String, Object> map : list) {
			if (depth.equals(map.get("DEPTH").toString()) && parentId.equals(map.get("PARENTID").toString())) {
				rtnList.add(map);
			}
		}
		return rtnList;
	}

	/**
	 * 组装单个菜单项目
	 *
	 * @param
	 * @param
	 * @param
	 * @return List<Map<String, Object>>
	 */
	private String setMapToJason(Map<?, ?> map) {
		String content = "{code:" + map.get("CODE").toString() + ",pid:" + map.get("PARENTID").toString() + ",text:'" + map.get("NAMEZH").toString() + "'";
		if (ObjectUtil.isNotEmpty(map.get("ROLEID"))) {
			content += ",ischecked:true";
		}
		if ("0".equals(map.get("ISPARENT").toString())) {
			content = content + "},";
		} else {
			content = content + ", children: [";
		}
		return content;
	}

	/*
	 * 工具类:获取权限树data信息
	 */
	public String getTreeData(String roleCode) {
		List<Map<String, Object>> list = securityService.getMenuTree(roleCode);
		String rootParentId = "0";
		String rootDepth = "1";
		String data = "[";
		String tmpStr = "";
		String content = "";
		List<Map<String, Object>> list1 = this.getDepthMenu(list, rootDepth, rootParentId);
		for (Map<String, Object> map : list1) {
			content = this.setMapToJason(map);
			tmpStr = tmpStr + content;
			content = "";
			if ("1".equals(map.get("ISPARENT").toString())) {
				List<Map<String, Object>> list2 = this.getDepthMenu(list, "2", map.get("CODE").toString());
				if(ObjectUtil.isNullOrEmpty(list2)){
					tmpStr = tmpStr.substring(0, tmpStr.length() - 13);
					tmpStr = tmpStr+"},";
				}else{

					for (Map<String, Object> map2 : list2) {
						content = this.setMapToJason(map2);
						tmpStr = tmpStr + content;
						content = "";
						if ("1".equals(map2.get("ISPARENT").toString())) {
							List<Map<String, Object>> list3 = this.getDepthMenu(list, "3", map2.get("CODE").toString());

							if(ObjectUtil.isNullOrEmpty(list3)){
								tmpStr = tmpStr.substring(0, tmpStr.length() - 13);
								tmpStr = tmpStr+"},";
							}else{
								for (Map<String, Object> map3 : list3) {
									content = this.setMapToJason(map3);
									tmpStr = tmpStr + content;
									content = "";
								}

								tmpStr = tmpStr.substring(0, tmpStr.length() - 1);
								tmpStr = tmpStr + "]},";
							}
						}//end list3 else
					}

					tmpStr = tmpStr.substring(0, tmpStr.length() - 1);
					tmpStr = tmpStr + "]},";
				}//end list2 else
			}
		}
		tmpStr = tmpStr.substring(0, tmpStr.length() - 1);
		tmpStr = tmpStr + "]";
		data = data + tmpStr;
		return data;
	}
}
