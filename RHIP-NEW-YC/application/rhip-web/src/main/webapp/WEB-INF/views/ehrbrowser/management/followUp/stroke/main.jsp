<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:if test="${strtum.diseaseType eq 3}">
	<jsp:include page="standard.jsp"></jsp:include>
</c:if>
<c:if test="${strtum.diseaseType eq 4}">
	<jsp:include page="../coronary/standard.jsp"></jsp:include>
</c:if>