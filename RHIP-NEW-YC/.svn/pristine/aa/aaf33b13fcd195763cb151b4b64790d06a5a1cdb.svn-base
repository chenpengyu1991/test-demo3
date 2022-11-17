<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/ehr-tag" prefix="ehr"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<script src="${pageContext.request.contextPath}/js/views/ehr/ehrbrowser/service/drug/search.js" type="text/javascript"></script>


<div>
	<div class="sm_bg" style="width: 97%;margin-left: 3px;">

		<form id="drug-search-from" action="<c:url value="/exam/index"  />">
			<div align="right">
			<label><input class="drug-search-btn" type="radio" value="1" name="timeType" checked="checked" />最近三个月</label>
			<label><input class="drug-search-btn" name="timeType" value="2" type="radio" />最近一年</label>
			<label><input name="timeType" value="3" type="radio" class="drug-search-btn" />全部</label>
			</div>
			<input type="hidden" name="personId" readonly="readonly" value="${personId}">
			
		</form>
	</div>

	<div id="drug-result-content" class="contentbox"  style="width: 99%;margin-left: 1px;border: none;"></div>

</div>
