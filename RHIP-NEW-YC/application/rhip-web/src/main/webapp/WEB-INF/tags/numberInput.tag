<%@tag pageEncoding="UTF-8"%>
<%@ attribute name="name" type="java.lang.String" required="true"%>
<%@ attribute name="id" type="java.lang.String" required="false"%>
<%@ attribute name="cssClass" type="java.lang.String" required="false"%>
<%@ attribute name="maxlength" type="java.lang.String" required="false"%>
<%@ attribute name="value" type="java.lang.String" required="false"%>
<%@ attribute name="point" type="java.lang.String" required="false"%>
<%@ attribute name="style" type="java.lang.String" required="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ attribute name="reg" type="java.lang.String" required="false"%>
<%@ attribute name="disabled" type="java.lang.Boolean" required="false"%>
<%@ attribute name="placeholder" type="java.lang.String" required="false"%>
<%@ attribute name="showlen" type="java.lang.String" required="false"%>
<%@ attribute name="onkeyup" type="java.lang.String" required="false"%>

<%--  point,允许输入小数点   --%>
<%
	String onkeypress = "var keyCode = window.event ? event.keyCode:event.which; return keyCode>=48&&keyCode<=57||keyCode==8;";
	String onpaste = "return !clipboardData.getData('text').match(/\\D/);";
	if (null != point && point.trim().length() > 0) {
		onkeypress = "var keyCode = window.event ? event.keyCode:event.which;return keyCode>=48&&keyCode<=57||keyCode==8||(\'\'!=this.value&&!this.value.match(/\\D/)&&(keyCode==46&&!event.shiftKey));";
		onpaste = "return clipboardData.getData('text').match(/^\\d+(\\.\\d+)?$/) != null;";
	}
	if (null == style || style.trim().length() < 1) {
		style = "ime-mode:Disabled";
	} else {
		if (style.trim().endsWith(";")) {
			style = style + "ime-mode:Disabled";
		} else {
			style = style + ";ime-mode:Disabled";
		}
	}
%>
<input type="text"
	   <%if (null != name) {%>name="<%=name%>"<%}%>
		<%if (null != id) {%> id="<%=id%>"<%}%>
		<%if (null != cssClass) {%> class="<%=cssClass%>" <%}%>
		<%if (null != value && !"".equals(value)) { // modified by Kevin Ro 2017-3-28
			if(showlen != null && showlen.equals("1")) {
				if(value.indexOf(".") == -1) { // 为整数的时候
					value = value.concat(".0");
				}
			}
		%>
	   value="<%=value%>"
		<%}%>
	   <%if (null != maxlength) {%>maxlength="<%=maxlength%>" <%}%>
	   <%if (null != style) {%>style="<%=style%>" <%}%>
	   <%if (null != reg) {%>reg="<%=reg.replaceAll("\"", "'")%>"  <%}%>
	   <%if (null != disabled && disabled) {%>disabled="disabled"  <%}%>
	   <%if (null != placeholder) {%>placeholder="<%=placeholder%>" <%}%>
	   onkeypress="<%=onkeypress%>"
	   onpaste="<%=onpaste%>"
	   onkeyup="<%=onkeyup%>"
	   ondragenter="return false"
/>