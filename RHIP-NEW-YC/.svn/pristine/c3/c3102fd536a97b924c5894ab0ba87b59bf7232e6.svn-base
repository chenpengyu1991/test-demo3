<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/ehr-tag" prefix="ehr"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%> 
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script src="${pageContext.request.contextPath}/js/views/ehr/statistics/orgMain.js" type="text/javascript"></script>

<ul id="tags">
	<li class=selectTag><a id="star_statistics_btn" href="javascript:void(0)">星级统计</a></li>
	<li><a id="record_statistics_btn" href="javascript:void(0)">档案统计</a></li>
</ul>

<div id="tagContent">
	<div id="tagContent0" class="selectTag" style="display: none; height: 600px;">
		<jsp:include page="starSearchForm.jsp"></jsp:include>
		<div id="star_statistics_con">
			<jsp:include page="star.jsp"></jsp:include>
		</div>
	</div>
	<div id="tagContent1" style="height: 600px;">
	<jsp:include page="recordSearchForm.jsp"></jsp:include>
		<div id="record_statistics_con"></div>
	</div>
</div>