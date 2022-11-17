<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<script src="${pageContext.request.contextPath}/js/views/vaccine/statistics/report/acuteReport/index.js" type="text/javascript"></script>
<div>
	<div class="thirdMenu" id="acuteReportId">
		<span class="active">
			<a id="acuteMonthId" href="javascript:void(0)" >按月汇总</a>
		</span>
        <a>|</a>
        <span>
			<a id="acuteYearId" href="javascript:void(0)">按年汇总</a>
		</span>
    </div>
    <div id="acuteReport_top_all">
		<div id="acuteReportSearchDiv"></div>
		<div id="acuteReport_ResultDiv"></div>
    </div>
    <div id="acuteReport_detailDiv" ></div>
</div>