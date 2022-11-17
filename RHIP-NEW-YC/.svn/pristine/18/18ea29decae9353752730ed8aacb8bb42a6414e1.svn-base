<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/ehr-tag" prefix="ehr"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script src="${pageContext.request.contextPath}/js/views/ehr/ehrbrowser/service/healthEvent/search.js" type="text/javascript"></script>
	<div class="section">
		<div class="searchbox" >
			<form id="healthevent-search-from" action="<c:url value="/healthevent/index"  />">
			
					<label><input class="healthevent-search-btn" type="radio" value="-1" name="ehrType" checked="checked"/>全部</label>
					<label><input class="healthevent-search-btn" name="ehrType" value="2" type="radio" />住院</label>
					<label><input class="healthevent-search-btn" name="ehrType" value="1" type="radio" />门诊</label>
					<label><input class="healthevent-search-btn" name="ehrType" value="3" type="radio" />体检</label>
			
				<div style="float: right">
					<label><input class="healthevent-search-btn" type="radio" value="1" name="timeType" checked="checked"/>最近三个月</label>
					<label><input class="healthevent-search-btn" name="timeType" value="2" type="radio" />最近一年</label>
					<label><input class="healthevent-search-btn" name="timeType" value="3" type="radio" />全部</label>
				</div>
				<input type="hidden" name="personId" readonly="readonly" value="${personId}">
			</form>
		</div>
		<div id="healthevent-result-content">
		</div>
	</div>
