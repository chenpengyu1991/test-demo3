    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/ehr-tag" prefix="ehr"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script src="${pageContext.request.contextPath}/js/views/ehr/ehrbrowser/service/study/search.js" type="text/javascript"></script>
	
		<div class="sm_bg contentDialog" style="width: 97%;margin-left: 3px;">
			<form id="study-search-from" action="<c:url value="/study/index"  />">
				<div align="right" >
					<label><input class="study-search-btn" type="radio" value="1" name="timeType" checked="checked"/>最近三个月</label>
					<label><input class="study-search-btn" name="timeType" value="2" type="radio" />最近一年</label>
					<label><input class="study-search-btn" name="timeType" value="3" type="radio" />全部</label>
				</div>
				<input type="hidden" name="personId" readonly="readonly" value="${personId}">
			</form>
		</div>
		<div id="study-result-content" style="width: 99.5%;margin-left: 1px;">
		</div>
		
