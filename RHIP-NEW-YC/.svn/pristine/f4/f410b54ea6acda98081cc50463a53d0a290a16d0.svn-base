package com.founder.rhip.portal.tld;

import javax.servlet.ServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import com.founder.fasf.beans.Page;
import com.founder.fasf.util.StringUtil;

public class PagingTag extends TagSupport {

	private static final long serialVersionUID = 1036436064098505455L;
	// attribute
	private String action;
	private String param1;
	private String param2;
	private String param3;
	private String page = "page";

	public int doEndTag() throws JspException {
		return super.doEndTag();
	}

	public int doStartTag() throws JspException {
		try {
			ServletRequest request = pageContext.getRequest();
			String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + pageContext.getServletContext().getContextPath();

			Page pg = (Page) request.getAttribute(page);

			pageContext.setAttribute("currentPage", pg, 3); // 设置session属性用于控制当前页位置

			StringBuilder sb = new StringBuilder("<div class=\"pagination\"");
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
			sb.append("第" + pg.getCurrentPage() + "页/共" + pg.getTotalPages() + "页 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;共" + pg.getTotalRows() + "条记录");
			sb.append("</p>\r\n");
			sb.append("<p class=\"right\">");
			if (pg.getTotalPages() < 2 || pg.getCurrentPage() == 1) {
				sb.append("<a href=\"javascript:void(0);\" style=\"cursor:default;\"><img src=\"" + basePath + "/images/btn/page_011.gif\"/></a> &nbsp;");
			} else {
				sb.append("<a href=\"javascript:" + action + "(" + params + "1)\"><img src=\"" + basePath + "/images/btn/page_01.gif\"/></a> &nbsp;");
			}

			if (pg.getTotalPages() < 2 || pg.getCurrentPage() == 1) {
				sb.append("<a href=\"javascript:void(0);\" style=\"cursor:default;\"><img src=\"" + basePath + "/images/btn/page_022.gif\"/></a>&nbsp;&nbsp;<font>" + pg.getCurrentPage() + "</font>&nbsp;&nbsp;");
			} else {
				sb.append("<a href=\"javascript:" + action + "(" + params + pg.getPreviousPage() + ")\"><img src=\"" + basePath + "/images/btn/page_02.gif\"/></a>&nbsp;&nbsp;<font>" + pg.getCurrentPage() + "</font>&nbsp;&nbsp;");
			}

			if (pg.getTotalPages() < 2 || pg.getTotalPages() == pg.getCurrentPage()) {
				sb.append("<a href=\"javascript:void(0);\" style=\"cursor:default;\"><img src=\"" + basePath + "/images/btn/page_033.gif\"/></a> &nbsp;");
			} else {
				sb.append("<a href=\"javascript:" + action + "(" + params + pg.getNextPage() + ")\"><img src=\"" + basePath + "/images/btn/page_03.gif\"/></a> &nbsp;");
			}

			if (pg.getTotalPages() < 2 || pg.getTotalPages() == pg.getCurrentPage()) {
				sb.append("<a href=\"javascript:void(0);\" style=\"cursor:default;\"><img src=\"" + basePath + "/images/btn/page_044.gif\"/></a> &nbsp;");
			} else {
				sb.append("<a href=\"javascript:" + action + "(" + params + pg.getTotalPages() + ")\"><img src=\"" + basePath + "/images/btn/page_04.gif\"/></a> &nbsp;");
			}

			sb.append("</p>");
			if ("page".equals(page)) {
				sb.append("<input type=\"hidden\" id=\"currentPage\" value=\"" + pg.getCurrentPage() + "\"/>");
			} else {
				sb.append("<input type=\"hidden\" id=\"" + page + "\" value=\"" + pg.getCurrentPage() + "\"/>");
			}
			sb.append("<input type=\"hidden\" id=\"totalRec_" + page + "\" value=\"" + pg.getTotalRows() + "\"/>");

			sb.append("</div>");
			JspWriter jw = pageContext.getOut();
			jw.write(sb.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SKIP_BODY;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
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

}
