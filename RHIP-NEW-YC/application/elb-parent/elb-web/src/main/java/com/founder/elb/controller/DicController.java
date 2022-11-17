
package com.founder.elb.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONSerializer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.founder.elb.common.ElbConstants;
import com.founder.elb.common.MessageUtils;
import com.founder.elb.entity.CvDicmeta;
import com.founder.elb.entity.Domain;
import com.founder.elb.entity.Role;
import com.founder.elb.service.IDictionaryService;
import com.founder.elb.service.ISecurityService;
import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.RequestUtil;

@Controller
@RequestMapping("/dic")
public class DicController {

	@Autowired
	private ISecurityService securityService;

	@Autowired
	private IDictionaryService dictionaryService;

	@RequestMapping("/list")
	public String search(HttpServletRequest request, ModelMap model) {
		List<Domain> domains = dictionaryService.getDomains();
		model.addAttribute("domains", domains);
		List<Role> roles = null;
		roles = securityService.getRoles();
		model.addAttribute("roles", roles);
		return "dic/list";
	}

	
	@RequestMapping(value = "/changedomain")
	public void getSecondWorkTypes(Integer domainId, HttpServletResponse response) {
		Criteria c = new Criteria("domainId", domainId); 
		List<CvDicmeta> list = dictionaryService.getCvDicmetas(c);
		String reslult = JSONSerializer.toJSON(list).toString();
		MessageUtils.outputJSONResult(reslult, response);
	}
	
	
	
	/**
	 * 查询
	 */
	@RequestMapping(value="/search")
	public String list(HttpServletRequest request, ModelMap model,String code) {		
		Page page = new Page(ElbConstants.PAGE_SIZE, 1); 
		PageList<Map<String,Object>> dictionaries=dictionaryService.getDictionaries(page, code);
		model.addAttribute("dictionaries", dictionaries.getList());
		model.addAttribute("page", dictionaries.getPage());
		return "dic/list";
	}
	
	
	
	
	
	@RequestMapping("/add")
	public String index() {
		String result = "role/add";
		return result;
	}

	@RequestMapping(value = "/detail/{id}", method = RequestMethod.GET)
	public String detail(@PathVariable("id") String id, ModelMap model) {
		if (ObjectUtil.isNotEmpty(id)) {
			Integer roleId = Integer.valueOf(id);
			Role role = securityService.getRole(roleId);
			model.addAttribute("role", role);
		}
		return "role/detail";
	}

	@RequestMapping("/delete")
	public String delete() {
		// 删除的id值
		/*
		 * roleIds securityService.deleteRole(roleIds);
		 */
		return "role/list";
	}

	@RequestMapping("/save")
	public String save(Role role, ModelMap model) {
		int result = 0;
		if (ObjectUtil.isNotEmpty(role)) {
			result = ObjectUtil.isNotEmpty(role.getId()) ? securityService.updateRole(role) : securityService.createRole(role);
		}
		model.addAttribute("saveFlag", result > 0 ? "success" : "fail");
		return "role/list";
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
	@RequestMapping(value = "/getRolesAccess", method = RequestMethod.GET)
	public String getRolesAccess(ModelMap model) {
		List<Role> roleList = securityService.getRoles();
		if (roleList == null || roleList.size() == 0) {
			return "common/404";
		}
		Integer roleId = roleList.get(0).getId();
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
		model.addAttribute("data", data);
		model.addAttribute("id", roleId);
		model.addAttribute("roleList", roleList);
		String result = "/role/setAccess";
		return result;
	}

	@RequestMapping(value = "/getRolesAccess/{id}", method = RequestMethod.GET)
	public String getRolesAccess(@PathVariable("id") String id, ModelMap model) {
		List<Role> roleList = securityService.getRoles();
		if (roleList == null || roleList.size() == 0) {
			return "common/404";
		}
		Integer roleId = Integer.parseInt(id);
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
	@SuppressWarnings("rawtypes")
	private String setMapToJason(Map map) {
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
}