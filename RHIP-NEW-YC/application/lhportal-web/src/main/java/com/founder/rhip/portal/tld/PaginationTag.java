package com.founder.rhip.portal.tld;

import javax.servlet.ServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import com.founder.fasf.beans.Page;
import com.founder.fasf.util.StringUtil;

public class PaginationTag extends TagSupport {

	private static final long serialVersionUID = 1036436064098505455L;
	// attribute
	private String action;
	private String param1;
	private String param2;
	private String param3;
	private String colspan;
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

			StringBuilder sb = new StringBuilder("<div class=\"pagination-x pull-right\">");
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
			if (pg.getTotalPages() == 0) {
				pg.setCurrentPage(1);
			}
			sb.append("<span class=\"pagers\">");
			sb.append("<ul class=\"pagination-x-list\">");
			sb.append("<li>");
				if (pg.getTotalPages() < 2 || pg.getCurrentPage() == 1) {
					sb.append("<a href=\"javascript:void(0);\" class=\"end-off\">首页</a>&nbsp;&nbsp;");
				} else {
					sb.append("<a class=\"pointer-hand\" href=\"javascript:" + action + "(" + params + "1)\">首页</a>&nbsp;&nbsp;");
				}
			sb.append("</li>");
			sb.append("<li>");
				if (pg.getTotalPages() < 2 || pg.getCurrentPage() == 1) {
					sb.append("<a href=\"javascript:void(0);\" class=\"prev-off\">上一页</a>&nbsp;&nbsp;");
				} else {
					sb.append("<a class=\"prev-on pointer-hand\" href=\"javascript:" + action + "(" + params + pg.getPreviousPage() + ")\">上一页</a>&nbsp;&nbsp;");
				}
			sb.append("</li>");
			
			int index = 0;//当前页数
			int array = 0;//循环数
			if (pg.getCurrentPage() > 0 && pg.getCurrentPage() < 6) {
				index = 1;
				array = 5;
			} else if (pg.getCurrentPage() >= 5){
				index = pg.getCurrentPage() -1;
				array = pg.getCurrentPage() + 1;
			} else if ((pg.getCurrentPage() + 4) > pg.getTotalPages()) {
				index = pg.getTotalPages() - 4;
				array = pg.getTotalPages();
			}
				
			if (array > pg.getTotalPages())
				array = pg.getTotalPages();
			
			if (pg.getCurrentPage() > 5) {
				sb.append("<li><a class=\"pointer-hand\" href=\"javascript:" + action + "(" + params + "1)\">1</a>&nbsp;&nbsp;</li>");
				sb.append("<li><a class=\"pointer-hand\" href=\"javascript:" + action + "(" + params + "2)\">2</a>&nbsp;&nbsp;</li>");
				sb.append("<li><a class=\"ellipsis\" href=\"javascript:void(0)\">...</a></li>");
			}
			
				for (int i = index; i <= array; i++) {
					sb.append("<li>");
					if (pg.getCurrentPage() == i) {
						sb.append("<a href=\"javascript:void(0);\" class=\"currentpage\">"+i+"</a>&nbsp;&nbsp;");
					} else {
						sb.append("<a class=\"pointer-hand\" href=\"javascript:" + action + "(" + params + i + ")\">"+i+"</a>&nbsp;&nbsp;");
					}
					sb.append("</li>");
				}
				
				if ((pg.getCurrentPage() + 1) < pg.getTotalPages() && pg.getTotalPages() > 5) {
					sb.append("<li><a class=\"ellipsis\" href=\"javascript:void(0)\">...</a></li>");
					sb.append("<li><a href=\"javascript:" + action + "(" + params + pg.getTotalPages() + ")\" class=\"pointer-hand\">"+pg.getTotalPages()+"</a>&nbsp;&nbsp;</li>");
				}
				sb.append("<li>");
				if (pg.getTotalPages() < 2 || pg.getTotalPages() == pg.getCurrentPage()) {
					sb.append("<a href=\"javascript:void(0);\" class=\"next-off\">下一页</a> &nbsp;");
				} else {
					sb.append("<a class=\"next-on pointer-hand\" href=\"javascript:" + action + "(" + params + pg.getNextPage() + ")\">下一页</a> &nbsp;");
				}
				
			sb.append("</li>");
			sb.append("<li>");
				if (pg.getTotalPages() < 2 || pg.getTotalPages() == pg.getCurrentPage()) {
					sb.append("<a href=\"javascript:void(0);\" class=\"end-off\">尾页</a>&nbsp;&nbsp;");
				} else {
					sb.append("<a class=\"pointer-hand\" href=\"javascript:" + action + "(" + params + pg.getTotalPages() + ")\">尾页</a>&nbsp;&nbsp;");
				}
			sb.append("</li>");
			sb.append("</ul>");
			sb.append("</span>");
			sb.append("</div>");
				if ("page".equals(page)) {
					sb.append("<input type=\"hidden\" id=\"currentPage\" value=\"" + pg.getCurrentPage() + "\"/>");
				} else {
					sb.append("<input type=\"hidden\" id=\"" + page + "\" value=\"" + pg.getCurrentPage() + "\"/>");
				}
			sb.append("<input type=\"hidden\" id=\"totalRec_" + page + "\" value=\"" + pg.getTotalRows() + "\"/>");

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

}
