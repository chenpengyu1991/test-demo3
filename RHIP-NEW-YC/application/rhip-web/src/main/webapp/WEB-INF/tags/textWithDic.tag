<%@tag pageEncoding="UTF-8"%>
<%@ attribute name="value" type="java.lang.String" required="false"%>
<%@ attribute name="dicmeta" type="java.lang.String" required="false"%>
<%@ attribute name="code" type="java.lang.String" required="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/ehr-tag" prefix="ehr"%>
<%if(null!=value &&value.trim().length()>0){
	out.print(value);
}else if(null!=code&&null!=dicmeta){
	%>
	<ehr:dic dicmeta="<%=dicmeta %>" code="<%=code %>"></ehr:dic>
	<%
}%>