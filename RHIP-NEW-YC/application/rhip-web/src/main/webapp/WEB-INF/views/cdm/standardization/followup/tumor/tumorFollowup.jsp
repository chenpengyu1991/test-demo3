<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<div class="repeattable">
<fieldset class="layui-elem-field">
	<legend>随访列表</legend>
	<table id="hypertensionTable">
		<colgroup>
			<col style="min-width: 80px;width:30%" />
			<col style="min-width: 70px;width:30%" />
			<col style="min-width: 90px;width:40%" />
		</colgroup>
		<thead> 
			<tr>
					<th>随访时间</th>
					<th>随访方式</th> 
					<th>下次随访时间</th>
<!-- 					<th style="width:150px;">上报机构</th> -->
<!-- 					<th style="width:60px;">上报时间</th> -->
<!-- 					<th style="width:60px;">报卡状态</th> -->
			</tr>
		</thead>
		<tbody class="tbody">
			<c:forEach var="tumorFollowup" items="${tumorFollowupList}">
				<tr class="tumorFollowupList">
					<td><fmt:formatDate value='${tumorFollowup.visitDate}' pattern='yyyy/MM/dd'/><input type="hidden" value="${tumorFollowup.id}" name="id"/></td>
					<td>${tumorFollowup.visitWayCode}</td>
					<td><fmt:formatDate value='${tumorFollowup.nextVisitDate}' pattern='yyyy/MM/dd'/></td>
				</tr>
			</c:forEach>
		</tbody>
<%-- 		<ehr:pagination action="followupInput.search" colspan="3"/> --%>
	</table>
</fieldset>
</div>