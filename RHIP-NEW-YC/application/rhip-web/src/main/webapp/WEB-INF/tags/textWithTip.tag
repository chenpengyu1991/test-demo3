<%@tag import="java.io.StringWriter"%>
<%@tag pageEncoding="UTF-8"%>
<%@ attribute name="value" type="java.lang.String" required="false"%>
<%@ attribute name="length" type="java.lang.Integer" required="false"%>
<%@ attribute name="linkStyle" type="java.lang.Boolean" required="false"%>
<%
String subValue=value;
if(null!=value&&value.trim().length()>0){
	if(null!=length&&length>0){
		subValue=value.substring(0,length);
	}
	
%>
	<label  <%if(null!=linkStyle&&linkStyle){ %> style="cursor:hand"<%} %>  class="text_tip_span" title="<%=value %>"><%=subValue %>
	</label>
<%} %>
