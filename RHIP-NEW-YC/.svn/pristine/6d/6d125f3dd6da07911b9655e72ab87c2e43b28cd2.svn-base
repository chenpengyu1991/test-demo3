<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<jsp:include page="../layouts/load-js-css-resources.jsp"></jsp:include>

<script src="${pageContext.request.contextPath}/js/views/ehr/person/list.js" type="text/javascript"></script>

<div class="section">
<%@include file="list_search.jsp" %>
<div id="list_datagrid" ></div>
<input type="hidden" id="orgCode" value="${currentLoginInfo.organization.organCode}" ></input>
</div>