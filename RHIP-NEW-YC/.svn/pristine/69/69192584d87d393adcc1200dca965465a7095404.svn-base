
package com.founder.elb.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.founder.elb.entity.DemoPerson;
import com.founder.elb.entity.DemoUser;
import com.founder.fasf.beans.BeanUtil;
import com.founder.fasf.beans.Criteria;
import com.founder.fasf.util.RequestUtil;

@Controller
@RequestMapping("/demo")
public class DemoController {

	@RequestMapping("/index")
	public String index() {
		String result = "demo/demoPage";
		return result;
	}

	@SuppressWarnings({ "unchecked", "unused" })
	@RequestMapping("/save")
	public String save(HttpServletRequest request, ModelMap model) {
		Map<String, Object[]> map = request.getParameterMap();
		
		//DemoUser users=RequestUtil.getModel(DemoUser.class, request);
		DemoUser user = BeanUtil.getBean(DemoUser.class, map);
		DemoPerson person = BeanUtil.getBean(DemoPerson.class, map);
		return "layouts/homepage";
	}

	@SuppressWarnings("unused")
	@RequestMapping("/query")
	public String query(HttpServletRequest request) {
		Criteria criteria = RequestUtil.getCriteria(request);
		String sql = criteria.toSql(null, ":");		
		return "layouts/homepage";
	}
}