<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<script src="${pageContext.request.contextPath}/js/views/portal/reserve/schedule.js" type="text/javascript"></script>
<div class="section" id="mainSearchDiv" style="margin-left: 30px;width: 840px;">
<form method="post" id="scheduleSearch" >
	<div class="searchbox" >
		<table>
			<colgroup>
				<col style="width: 10%;" />
				<col style="width: 13%;" />
				<col style="width: 10%;" />
				<col style="width: 13%;" />
				<col style="width: 10%;" />
				<col style="width: 13%;" />
			</colgroup>
			<tbody>
				<tr>
					<td class="coltext">医院:</td>
					<td class="colinput">
						<input type="hidden" name="hospital" id="schSelect" value="${currentLoginInfo.organization.organCode}"></input>
						${currentLoginInfo.organization.organName}
					</td>
					<td class="coltext">科室:</td>
					<td class="colinput">
						<tag:autoSelect name="clinic" id="sclinic"></tag:autoSelect>
					</td>
					<td>
						<input type="text" style="display: none;" />
						<input id="reserveScheduleBtn" class="search_btn" type="button" value="查询" style="float: left" />
					</td>
				</tr>
			</tbody>
		</table>
	</div>
</form>
</div>
<div id="scheduleDiv" >
</div>


