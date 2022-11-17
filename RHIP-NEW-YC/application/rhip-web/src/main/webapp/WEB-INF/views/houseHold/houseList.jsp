<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr" %>
<script src="${pageContext.request.contextPath}/js/views/ehr/person/houseHoldList.js" type="text/javascript"></script>
<div class="housesearch">
    <%@include file="houseDataList_search.jsp" %>
    <div id="houseDataList"></div>
</div>
