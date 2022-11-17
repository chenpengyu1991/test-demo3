package com.founder.rhip.ehr.tld;

import javax.servlet.ServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import com.founder.fasf.beans.Page;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;

public class PagingTag extends TagSupport {

	private static final long serialVersionUID = 1036436064098505455L;
	// attribute
	private String action = "";
	/*当一个div中有多个table需要进行分页时 用type来区分*/
	private String type;
	private String param1;
	private String param2;
	private String param3;
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
				
				StringBuilder sb = new StringBuilder("<div class=\"pagination mdm_page\"");
				String params = "";
				
				if(StringUtil.isNullOrEmpty(action)){
					params="this, ";
					action="pageUtil.trigger";
				} else if ("pageUtil.trigger".equals(action) && StringUtil.isNullOrEmpty(params)) {
					params="this, ";
				} else{
					if (StringUtil.isNotEmpty(param1)) {
						params += "'" + param1 + "',";
					}
					if (StringUtil.isNotEmpty(param2)) {
						params += "'" + param2 + "',";
					}
					if (StringUtil.isNotEmpty(param3)) {
						params += "'" + param3 + "',";
					}
				}
				
				sb.append(">\r\n");
				if (pg.getTotalPages() == 0) {
					pg.setCurrentPage(1);
				}
				sb.append("<p class=\"left\">\r\n");
				sb.append("第" + pg.getCurrentPage() + "页/共" + pg.getTotalPages() + "页 &nbsp;&nbsp;&nbsp;共" + pg.getTotalRows() + "条记录");
				sb.append("</p>\r\n");
				sb.append("<p class=\"right\">");
				this.appendA(sb);
				if (pg.getTotalPages() < 2 || pg.getCurrentPage() == 1) {
					/*sb.append("href=\"javascript:void(0);\" style=\"cursor:default;\"><img src=\"" + basePath + "/images/btn/page_011.gif\"/></a> &nbsp;");*/
					sb.append("<a href=\"javascript:void(0);\" style=\"cursor:default;\"><i style='font-size:12px;color:#4a4a4a;' class='layui-icon'>&#xe65a;首页</i></a> &nbsp;");
				} else {
					/*sb.append("href=\"javascript:void(0);\" onclick=\"" + action + "(" + params + "1)\"><img src=\"" + basePath + "/images/btn/page_01.gif\"/></a> &nbsp;");*/
					sb.append("<a href=\"javascript:" + action + "(" + params + "1)\"><i style='font-size:12px;' class='layui-icon'>&#xe65a;首页</i></a> &nbsp;");
				}
				this.appendA(sb);
				if (pg.getTotalPages() < 2 || pg.getCurrentPage() == 1) {
					/*sb.append("href=\"javascript:void(0);\" style=\"cursor:default;\"><img src=\"" + basePath + "/images/btn/page_022.gif\"/></a>&nbsp;&nbsp;<font>" + pg.getCurrentPage() + "</font>&nbsp;&nbsp;");*/
					sb.append("<a href=\"javascript:void(0);\" style=\"cursor:default;\"><i style='font-size:12px;color:#4a4a4a;' class='layui-icon'>&#xe603;上一页</i></a>&nbsp;&nbsp;<font>" + pg.getCurrentPage() + "</font>&nbsp;&nbsp;");
				} else {
					/*sb.append("href=\"javascript:void(0);\" onclick=\"" + action + "(" + params + pg.getPreviousPage() + ")\"><img src=\"" + basePath + "/images/btn/page_02.gif\"/></a>&nbsp;&nbsp;<font>" + pg.getCurrentPage() + "</font>&nbsp;&nbsp;");*/
					sb.append("<a href=\"javascript:" + action + "(" + params + pg.getPreviousPage() + ")\"><i style='font-size:12px;' class='layui-icon'>&#xe603;上一页</i></a>&nbsp;&nbsp;<font>" + pg.getCurrentPage() + "</font>&nbsp;&nbsp;");
				}
				this.appendA(sb);
				if (pg.getTotalPages() < 2 || pg.getTotalPages() == pg.getCurrentPage()) {
					/*sb.append("href=\"javascript:void(0);\" style=\"cursor:default;\"><img src=\"" + basePath + "/images/btn/page_033.gif\"/></a> &nbsp;");*/
					sb.append("<a href=\"javascript:void(0);\" style=\"cursor:default;\"><i style='font-size:12px;color:#4a4a4a;' class='layui-icon'>&#xe602;下一页</i></a> &nbsp;&nbsp;");
				} else {
					/*sb.append("href=\"javascript:void(0);\" onclick=\"" + action + "(" + params + pg.getNextPage() + ")\"><img src=\"" + basePath + "/images/btn/page_03.gif\"/></a> &nbsp;");*/
					sb.append("<a href=\"javascript:" + action + "(" + params + pg.getNextPage() + ")\"><i style='font-size:12px;' class='layui-icon'>&#xe602;下一页</i></a> &nbsp;&nbsp;");
				}
				this.appendA(sb);
				if (pg.getTotalPages() < 2 || pg.getTotalPages() == pg.getCurrentPage()) {
					/*sb.append("href=\"javascript:void(0);\" style=\"cursor:default;\"><img src=\"" + basePath + "/images/btn/page_044.gif\"/></a> &nbsp;");*/
					sb.append("<a href=\"javascript:void(0);\" style=\"cursor:default;\"><i style='font-size:12px;color:#4a4a4a;' class='layui-icon'>&#xe65b;尾页</i></a> &nbsp;");
				} else {
					/*sb.append("href=\"javascript:void(0);\"  onclick=\"" + action + "(" + params + pg.getTotalPages() + ")\"><img src=\"" + basePath + "/images/btn/page_04.gif\"/></a> &nbsp;");*/
					sb.append("<a href=\"javascript:" + action + "(" + params + pg.getTotalPages() + ")\"><i style='font-size:12px;' class='layui-icon'>&#xe65b;尾页</i></a> &nbsp;");
				}
				
				sb.append(this.getPageSelect(request,pg));
				if(action.equals("pageUtil.trigger")){
					sb.append("&nbsp;&nbsp;<input id=\"gotoPageNo\" type=\"number\" value=\""+pg.getCurrentPage()+"\" placeholder=\"页数\" min=\"1\" max=\""+pg.getTotalPages()+"\" step=\"1\"  class=\"x-layui-input\"  style=\"width: 40px;border-width:1px;border-color:#e5e5e5;\" >页 <a href=\"javascript:void(0)\" onclick=\"pageUtil.jumpPage(this,"+pg.getTotalPages()+")\">转到</a>");
				}else{
					sb.append("&nbsp;&nbsp;<input id=\"gotoPageNo\" type=\"number\" value=\""+pg.getCurrentPage()+"\" placeholder=\"页数\" min=\"1\" max=\""+pg.getTotalPages()+"\" step=\"1\" class=\"x-layui-input\"  style=\"width: 40px;border-width:1px;border-color:#e5e5e5;\" >页 <a href=\"javascript:void(0)\" onclick=\"pageUtil.gotoPage(this,'"+action+"',"+pg.getTotalPages()+")\">转到</a>");
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
			}
		} catch (Exception e) {
			throw new RuntimeException("分页控件错误",e);
//			e.printStackTrace();
		}
		return SKIP_BODY;
	}

	private String getPageSelect(ServletRequest request,Page pg){
		if(this.hidePageSize){
			return "";
		}
		StringBuilder sb = new StringBuilder("每页数量：<select onchange=\"");
		sb.append("pageUtil.changePageSizeRequire(this,'" + pg.getUrl() + "')\">");
		sb.append(selectOption(pg.getPageSize(),10));
		sb.append(selectOption(pg.getPageSize(),15));
		sb.append(selectOption(pg.getPageSize(),20));
		sb.append(selectOption(pg.getPageSize(),30));
		sb.append("</select>");
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	private void appendA(StringBuilder sb) {
		if(StringUtil.isNotEmpty(type)) {
			sb.append("<a class=\""+ type +"\" ");
		} else {
			sb.append("<a ");
		}
	}
}
