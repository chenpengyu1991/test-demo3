package com.founder.fasf.web;
import javax.servlet.ServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import com.founder.fasf.beans.Page;
public class PagerTag  extends TagSupport {

	private static final long serialVersionUID = 5842894524895397395L;
	// attribute
	private String action;
	
	public int doEndTag() throws JspException {
		return super.doEndTag();
	}

	public int doStartTag() throws JspException {
		try {
			ServletRequest request = pageContext.getRequest();
			Page page = (Page) request.getAttribute("page");
			if(page == null||page.getTotalPages()<1){return SKIP_BODY;	}			
			StringBuilder sb = new StringBuilder("<div class=\"pager\">\r\n<s></s>\r\n");
			if (page.getCurrentPage() == 1){
				sb.append("\t\t<a class=\"firsth\" href='javascript:void(0);'></a><a class=\"prevh\" href='javascript:void(0);'></a>");
			}else{
				sb.append("\t\t<a class=\"first\" href='javascript:"+action+"(1);'></a><a class=\"prev\" href='javascript:"+action+"("+page.getPreviousPage()+");'></a>");
			}
			sb.append("\t\t<s></s><b>第").append(page.getCurrentPage()).append("/").append(page.getTotalPages()).append("页</b><s></s>");				
			if (page.getCurrentPage() == page.getTotalPages()){
				sb.append("\t\t<a class=\"nexth\"  href='javascript:void(0);'></a><a class=\"lasth\"  href='javascript:void(0);'></a>");
			}else{
				sb.append("\t\t<a class=\"next\"  href='javascript:"+action+"("+page.getNextPage()+");'></a><a class=\"last\"  href='javascript:"+action+"(" + page.getTotalPages() + ");'></a>");
			}
//			<b>转至</b><input type="text" />
//			<a class="go" href="javascript:action()">Go</a>
			
			sb.append("<s></s><p>");//"显示:从").append(page.getStartRow()+1).append("到").append(page.getCurrentPage()*page.getPageSize());
			sb.append("总记录数:").append(page.getTotalRows()).append(", 每页条数:").append(page.getPageSize()).append("</p>");
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

}
