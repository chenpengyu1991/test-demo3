<%@tag import="java.util.Date"%>
<%@tag import="java.text.SimpleDateFormat"%>
<%@tag pageEncoding="UTF-8"%>
<%@ attribute name="name" type="java.lang.String" required="true"%>
<%@ attribute name="id" type="java.lang.String" required="false"%>
<%@ attribute name="value" type="java.lang.String" required="false"%>
<%@ attribute name="cssClass" type="java.lang.String" required="false"%>
<%@ attribute name="style" type="java.lang.String" required="false"%>
<%@ attribute name="reg" type="java.lang.String" required="false"%>
<%@ attribute name="disabled" type="java.lang.Boolean" required="false"%>
<%
	
%>
<input type="text" oncut="upCaseIdcard(this)" onchange="upCaseIdcard(this)" onpropertychange="upCaseIdcard(this)" oninput="upCaseIdcard(this)"
	<%if (null != name) {%> name="<%=name%>" <%}%>
	<%if (null != id) {%> id="<%=id%>" <%}%>
	<%if (null != cssClass) {%> class="<%=cssClass%>" <%}%> 
	<%if (null != value) {%> value="<%=value%>" <%}%> 
	<%if (null != style) {%> style="<%=style%>" <%}%>
	<%if (null != reg) {%> reg="<%=reg.replaceAll("\"", "'")%>" <%}%>
	<%if (null != disabled && disabled) {%> disabled="disabled" <%}%> />
	
	
