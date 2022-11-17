package com.founder.rhip.da.controller;

import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import com.founder.fasf.beans.Page;
import com.founder.fasf.util.DateUtil;
import com.founder.rhip.BaseController;

/**
 * 药品监控
 * 
 * 
 */
public abstract class DaBaseController extends BaseController {

	private static final String INDEX_PAGE_KEY = "pageIndex";// resquest中的当前页的key
	private static final String PAGE_KEY = "page";// page key

	/**
	 * 分页设置
	 * 
	 * @param request
	 * @return
	 */
	public Page buildPage(HttpServletRequest request) {
		String indexPage = request.getParameter(INDEX_PAGE_KEY);
		int currentPage = 1;
		try {
			currentPage = Integer.valueOf(indexPage);
		} catch (Exception e) {
			logger.warn("没有当前页数");
		}
		Page page = super.getPage(request, currentPage);
		request.setAttribute(PAGE_KEY, page);
		return page;
	}
	
	public static Date lastDateOfMonth(Date date){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH) + 2;
		
		String dateString = year + "/" + month + "/01 00:00:00";
		Date first = DateUtil.parseSimpleDate(dateString,"yyyy/MM/dd HH:mm:ss");
		
		Date lastDate = new Date(first.getTime() - 1);
		return lastDate;
	}
	
	public static Date firstDateOfMonth(Date date){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH) + 1;
		
		String dateString = year + "/" + month + "/01 00:00:00";
		Date first = DateUtil.parseSimpleDate(dateString,"yyyy/MM/dd HH:mm:ss");
		return first;
	}		
}
