package com.founder.elb.tld;

import javax.servlet.ServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import com.founder.fasf.beans.Page;
import com.founder.fasf.util.StringUtil;

public class PaginationTag extends TagSupport {
	
	private static final long serialVersionUID = 3489810169706315342L;
	// attribute
	private String action;
	private String colspan;
	
	public int doEndTag() throws JspException {
		return super.doEndTag();
	}

	public int doStartTag() throws JspException {
		try {
			ServletRequest request = pageContext.getRequest();
			String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + pageContext.getServletContext().getContextPath();
			
			Page page = (Page) request.getAttribute("page");
			
			pageContext.setAttribute("currentPage", page, 3); //设置session属性用于控制当前页位置
			
			StringBuilder sb = new StringBuilder("<td class=\"pagination\"");
			if(StringUtil.isNotEmpty(colspan)){
				sb.append(" colspan=\""+colspan+"\"");
			}
			sb.append(">\r\n");
			sb.append("\t<p class=\"left\">共"+page.getTotalRows()+"条记录！</p>\r\n");
			sb.append("\t<p class=\"right\">第"+page.getCurrentPage()+"页/共"+page.getTotalPages()+"页 &nbsp;\r\n");
			sb.append("\t\t<a href=\"javascript:"+action+"(1);\"><img src=\""+basePath+"/resources/images/btn/page_01.gif\"/>首页</a> &nbsp;\r\n");
			sb.append("\t\t<a href=\"javascript:"+action+"("+page.getPreviousPage()+")\"><img src=\""+basePath+"/resources/images/btn/page_02.gif\"/>上一页</a> &nbsp;&nbsp;"+page.getCurrentPage()+"&nbsp;&nbsp;\r\n");
			sb.append("\t\t<a href=\"javascript:"+action+"("+page.getNextPage()+")\">下一页<img src=\""+basePath+"/resources/images/btn/page_03.gif\"/></a> &nbsp;\r\n");
			sb.append("\t\t<a href=\"javascript:"+action+"("+page.getTotalPages()+")\">尾页<img src=\""+basePath+"/resources/images/btn/page_04.gif\"/></a> &nbsp;\r\n");
			sb.append("\t</p>");
			sb.append("</td>");
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

}
