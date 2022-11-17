
package com.founder.elb.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.founder.elb.entity.Role;
import com.founder.elb.service.ISecurityService;
import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.RequestUtil;

@Controller
@RequestMapping("/role")
public class RoleController {

	@Autowired
	private ISecurityService securityService;

	@RequestMapping("/list")
	public String list(ModelMap model,Criteria criteria,HttpServletRequest request) {	
		PageList<Role> list = null;
		Page page = new Page(10, 1);
		list = securityService.getRoles(page,criteria);
		model.addAttribute("page", list.getPage());
		model.addAttribute("roles", list.getList()); 
		return "role/list";
	}

	/**
	 * 角色查询
	 */
	@RequestMapping("/search")
	public String search(ModelMap model, Criteria criteria, Role role, HttpServletRequest request) {
		PageList<Role> list = null;
		String pageIndex = request.getParameter("pageIndex");
		int currentPage = Integer.valueOf(pageIndex);
		Page page = new Page(10, currentPage);
		list = securityService.getRoles(page, criteria, role);
		model.addAttribute("page", list.getPage());
		model.addAttribute("roles", list.getList());
		return "/role/list";
	}
//	
//	@RequestMapping("/add")
//	public String index() {
//		String result = "role/add";
//		return result;
//	}

	@RequestMapping("/update/{id}")
	public String update(@PathVariable("id") String id, ModelMap model) {
		if (ObjectUtil.isNotEmpty(id)) {
			Integer roleId = Integer.valueOf(id);
			
			Role role = securityService.getRole(roleId);
			String data=getTreeData(roleId);
			model.addAttribute("role", role);
			model.addAttribute("data", data);
		}
		
		return "role/update";
	}

	@RequestMapping("/delete/{roleIds}")
	public String delete(@PathVariable("roleIds") String userIds) {
		// 删除的id值
		/*
		 * roleIds securityService.deleteRole(roleIds);
		 */
		return "role/list";
	}
	
	
	/*
	 * 角色权限新建/更新
	 * 
	 * */
	@RequestMapping("/save")
	public String save(Role role, String menuIds) {
		if(ObjectUtil.isNotEmpty(role.getId())){ //roleId不为空则执行更新
			//int result=0;
			role.setAccesses(menuIds);
			//result = 
			securityService.updateRole(role);
			securityService.setRoleAccess(role);
				
		}else{ 				//roleId为空，执行新建角色权限
			int userId = 0;
			//int result = 0;
				if (ObjectUtil.isNotEmpty(role)&&ObjectUtil.isNotEmpty(menuIds)) {
					userId = securityService.createRole(role);
					role.setId(userId);
					role.setAccesses(menuIds);  //access 为 menuIds
					//result = 
					securityService.setRoleAccess(role);
				}
				if(ObjectUtil.isNullOrEmpty(menuIds)){
					userId = securityService.createRole(role);
					
				}
		}
		
		return "redirect:/role/list";
	}

	
	@SuppressWarnings("unused")
	@RequestMapping("/query")
	public String query(HttpServletRequest request) {
		Criteria criteria = RequestUtil.getCriteria(request);
		String sql = criteria.toSql(null, ":");
		return "layouts/homepage";
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
		Integer roleId = 0;
		String data = getTreeData(roleId);		
		model.addAttribute("data", data);
		model.addAttribute("id", roleId);
		model.addAttribute("roleList", roleList);
		String result = "/role/add";
		return result;
	}

	@RequestMapping(value = "/getRolesAccess/{id}", method = RequestMethod.GET)
	public String getRolesAccess(@PathVariable("id") String id, ModelMap model) {
		List<Role> roleList = securityService.getRoles();
		if (roleList == null || roleList.size() == 0) {
			return "common/404";
		}
		Integer roleId = Integer.parseInt(id);
		String data = getTreeData(roleId);
		
		model.addAttribute("data", data);
		model.addAttribute("id", roleId);
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
	 * @param model
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
	 * @param model
	 * @param depth
	 * @param parentId
	 * @return List<Map<String, Object>>
	 */
	private String setMapToJason(Map<?, ?> map) {
		String content = "";
		if (map.get("ROLEID") == null || "".equals(map.get("ROLEID").toString())) {
			content = "{id:" + map.get("ID").toString() + ",pid:" + map.get("PARENTID").toString() + ",text:'" + map.get("NAMEZH").toString() + "'";
		} else {
			content = "{id:" + map.get("ID").toString() + ",pid:" + map.get("PARENTID").toString() + ",text:'" + map.get("NAMEZH").toString() + "'" + ",ischecked:true";
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
	 * 
	 * */
	public String getTreeData(Integer roleId){
		
		List<Map<String, Object>> list = securityService.getMenuTree(roleId);
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
				List<Map<String, Object>> list2 = this.getDepthMenu(list, "2", map.get("ID").toString());
				for (Map<String, Object> map2 : list2) {
					content = this.setMapToJason(map2);
					tmpStr = tmpStr + content;
					content = "";
					if ("1".equals(map2.get("ISPARENT").toString())) {
						List<Map<String, Object>> list3 = this.getDepthMenu(list, "3", map2.get("ID").toString());
						for (Map<String, Object> map3 : list3) {
							content = this.setMapToJason(map3);
							tmpStr = tmpStr + content;
							content = "";
						}
						tmpStr = tmpStr.substring(0, tmpStr.length() - 1);
						tmpStr = tmpStr + "]},";
					}
				}
				tmpStr = tmpStr.substring(0, tmpStr.length() - 1);
				tmpStr = tmpStr + "]},";
			}
		}
		tmpStr = tmpStr.substring(0, tmpStr.length() - 1);
		tmpStr = tmpStr + "]";
		data = data + tmpStr;
		
		return data;
		
	}
	
	
	
}
