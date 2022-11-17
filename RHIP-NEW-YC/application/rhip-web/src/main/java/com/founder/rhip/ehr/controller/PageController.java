package com.founder.rhip.ehr.controller;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.founder.rhip.BaseController;
import com.founder.rhip.ehr.dto.UrlPages;


/**
 * @author ljy
 * 设置Url和PageSize的Map
 */
@Controller
@RequestMapping("/pageSet")
public class PageController extends BaseController{
	
	@RequestMapping("/currentPageSize")
	public @ResponseBody String currentPageSize(String pageUrl,Integer pageSize,HttpServletRequest request){
		Object o = request.getSession().getAttribute("urlPages");
		UrlPages urlPages;
		
		if(o == null){
			urlPages = new UrlPages();
			HashMap<String,Integer> map = new HashMap<String,Integer>();
			urlPages.setUrlPgaeMap(map);
			request.getSession().setAttribute("urlPages", urlPages);
		}else{
			urlPages = (UrlPages)o;
		}
		urlPages.setPageSize(pageUrl, pageSize);
		return "1";
	}
}



