package com.founder.rhip.ehr.tld;

import com.founder.fasf.beans.Page;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;

import javax.servlet.ServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class PaginationMiniTag extends TagSupport {

	private static final long serialVersionUID = 1036436064098505455L;
	// attribute
	private String action;
	private String param1;
	private String param2;
	private String param3;
	private String colspan;
	private String page = "page";
	private Boolean hidePageSize = false;

	public int doEndTag() throws JspException {
		return super.doEndTag();
	}

	public int doStartTag() throws JspException {
		try {
			ServletRequest request = pageContext.getRequest();
			String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + pageContext.getServletContext().getContextPath();

			if (ObjectUtil.isNotEmpty(request.getAttribute(page))) {
				
				Page pg = (Page) request.getAttribute(page);
				
				pageContext.setAttribute("currentPage", pg, 3); // 设置session属性用于控制当前页位置
				
				StringBuilder sb = new StringBuilder("<td class=\"paginationMini\"");
				if (StringUtil.isNotEmpty(colspan)) {
					sb.append(" colspan=\"" + colspan + "\"");
				}
				String params = "";
				if (StringUtil.isNotEmpty(param1)) {
					params += "'" + param1 + "',";
				}
				if (StringUtil.isNotEmpty(param2)) {
					params += "'" + param2 + "',";
				}
				if (StringUtil.isNotEmpty(param3)) {
					params += "'" + param3 + "',";
				}
				sb.append(">\r\n");
				if (pg.getTotalPages() == 0) {
					pg.setCurrentPage(1);
				}
				sb.append("<p class=\"left\">\r\n");
				sb.append(pg.getCurrentPage() + "/共" + pg.getTotalPages() + "页&nbsp;共" + pg.getTotalRows() + "条");
				sb.append("</p>\r\n");
				sb.append("<p class=\"right\">");
				if (pg.getTotalPages() < 2 || pg.getCurrentPage() == 1) {
					/*sb.append("<a href=\"javascript:void(0);\" style=\"cursor:default;\"><img src=\"" + basePath + "/images/btn/newpage_011.gif\" width='16' height='16'/></a> &nbsp;");*/
					sb.append("<a href=\"javascript:void(0);\" style=\"cursor:default;\"><i style='font-size:12px;color:#4a4a4a;' class='layui-icon'>&#xe65a;</i></a> &nbsp;");
				} else {
					/*sb.append("<a href=\"javascript:" + action + "(" + params + "1)\"><img src=\"" + basePath + "/images/btn/newpage_01.gif\" width='16' height='16'/></a> &nbsp;");*/
					sb.append("<a href=\"javascript:" + action + "(" + params + "1)\"><i style='font-size:12px;' class='layui-icon'>&#xe65a;</i></a> &nbsp;");
				}
				
				if (pg.getTotalPages() < 2 || pg.getCurrentPage() == 1) {
					/*sb.append("<a href=\"javascript:void(0);\" style=\"cursor:default;\"><img src=\"" + basePath + "/images/btn/newpage_022.gif\"/></a>&nbsp;<font>" + pg.getCurrentPage() + "</font>&nbsp;");*/
					sb.append("<a href=\"javascript:void(0);\" style=\"cursor:default;\"><i style='font-size:12px;color:#4a4a4a;' class='layui-icon'>&#xe603;</i></a>&nbsp;&nbsp;<font>" + pg.getCurrentPage() + "</font>&nbsp;&nbsp;");
				} else {
					/*sb.append("<a href=\"javascript:" + action + "(" + params + pg.getPreviousPage() + ")\"><img src=\"" + basePath + "/images/btn/newpage_02.gif\"/></a>&nbsp;<font>" + pg.getCurrentPage() + "</font>&nbsp;");*/
					sb.append("<a href=\"javascript:" + action + "(" + params + pg.getPreviousPage() + ")\"><i style='font-size:12px;' class='layui-icon'>&#xe603;</i></a>&nbsp;&nbsp;<font>" + pg.getCurrentPage() + "</font>&nbsp;&nbsp;");
				}
				
				if (pg.getTotalPages() < 2 || pg.getTotalPages() == pg.getCurrentPage()) {
					/*sb.append("<a href=\"javascript:void(0);\" style=\"cursor:default;\"><img src=\"" + basePath + "/images/btn/newpage_033.gif\"/></a> &nbsp;");*/
					sb.append("<a href=\"javascript:void(0);\" style=\"cursor:default;\"><i style='font-size:12px;color:#4a4a4a;' class='layui-icon'>&#xe602;</i></a> &nbsp;&nbsp;");
				} else {
					/*sb.append("<a href=\"javascript:" + action + "(" + params + pg.getNextPage() + ")\"><img src=\"" + basePath + "/images/btn/newpage_03.gif\"/></a> &nbsp;");*/
					sb.append("<a href=\"javascript:" + action + "(" + params + pg.getNextPage() + ")\"><i style='font-size:12px;' class='layui-icon'>&#xe602;</i></a> &nbsp;&nbsp;");
				}
				
				if (pg.getTotalPages() < 2 || pg.getTotalPages() == pg.getCurrentPage()) {
					/*sb.append("<a href=\"javascript:void(0);\" style=\"cursor:default;\"><img src=\"" + basePath + "/images/btn/newpage_044.gif\"/></a> &nbsp;");*/
					sb.append("<a href=\"javascript:void(0);\" style=\"cursor:default;\"><i style='font-size:12px;color:#4a4a4a;' class='layui-icon'>&#xe65b;</i></a> &nbsp;");
				} else {
					/*sb.append("<a href=\"javascript:" + action + "(" + params + pg.getTotalPages() + ")\"><img src=\"" + basePath + "/images/btn/newpage_04.gif\"/></a> &nbsp;");*/
					sb.append("<a href=\"javascript:" + action + "(" + params + pg.getTotalPages() + ")\"><i style='font-size:12px;' class='layui-icon'>&#xe65b;</i></a> &nbsp;");
				}
				
				sb.append(this.getPageSelect(request,pg));
				
				sb.append("</p>");
				if ("page".equals(page)) {
					sb.append("<input type=\"hidden\" id=\"currentPage\" value=\"" + pg.getCurrentPage() + "\"/>");
				} else {
					sb.append("<input type=\"hidden\" id=\"" + page + "\" value=\"" + pg.getCurrentPage() + "\"/>");
				}
				sb.append("<input type=\"hidden\" id=\"totalRec_" + page + "\" value=\"" + pg.getTotalRows() + "\"/>");
				
				sb.append("</td>");
				JspWriter jw = pageContext.getOut();
				jw.write(sb.toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SKIP_BODY;
	}

	private String getPageSelect(ServletRequest request,Page pg){
		if(this.hidePageSize){
			return "";
		}
		StringBuilder sb = new StringBuilder("<select onchange=\"");
		sb.append("baseLayoutLoad.changePageSize(this,'" + pg.getUrl() + "','" + this.action + "')\">");
		sb.append(selectOption(pg.getPageSize(),10));
		sb.append(selectOption(pg.getPageSize(),15));
		sb.append(selectOption(pg.getPageSize(),20));
		sb.append(selectOption(pg.getPageSize(),30));
		sb.append("</select>/页");
		return sb.toString();
	}
	
	private String selectOption(Integer pageSize,Integer optionSize){
		if(pageSize.equals(optionSize)){
			return "<option selected>"+optionSize+"</option>";
		}
		return "<option>"+optionSize+"</option>";
	}
	
	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getColspan() {
		return colspan;
	}

	public void setColspan(String colspan) {
		this.colspan = colspan;
	}

	public String getParam1() {
		return param1;
	}

	public void setParam1(String param1) {
		this.param1 = param1;
	}

	public String getParam2() {
		return param2;
	}

	public void setParam2(String param2) {
		this.param2 = param2;
	}

	public String getParam3() {
		return param3;
	}

	public void setParam3(String param3) {
		this.param3 = param3;
	}

	public String getPage() {
		return page;
	}

	public void setPage(String page) {
		this.page = page;
	}

	public Boolean getHidePageSize() {
		return hidePageSize;
	}

	public void setHidePageSize(Boolean hidePageSize) {
		this.hidePageSize = hidePageSize;
	}

}
