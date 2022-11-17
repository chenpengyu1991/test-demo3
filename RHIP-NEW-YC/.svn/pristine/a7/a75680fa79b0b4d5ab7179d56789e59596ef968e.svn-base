<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<script src="${pageContext.request.contextPath}/js/views/hsa/inspRecord/add/locationInspRecordList.js" type="text/javascript"></script>
<div class="repeattable">
	<table class="repeattable" id="hsa-inspRecord-table">
		<thead>
			<tr>
				<th>登记日期</th>
				<th>登记人</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="inspRecord" items="${inspRecordList}" varStatus="status">
				<tr data-location-id='${inspRecord.id}' style="cursor: hand" class="${status.index==0?'listtrselect':''}">
					<td><ehr:tip>
							<fmt:formatDate value="${inspRecord.inspDate}" />
						</ehr:tip></td>
					<td><a> ${inspRecord.createDoctorName}</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>