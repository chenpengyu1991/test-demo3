<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/ehr-tag" prefix="ehr" %>

<script type="text/javascript">
function no() {
	window.location.href="${pageContext.request.contextPath}/access/no";
}
function left() {
	window.location.href="${pageContext.request.contextPath}/access/left";
}
</script>

<div id="infoDiv">
	right
</div>