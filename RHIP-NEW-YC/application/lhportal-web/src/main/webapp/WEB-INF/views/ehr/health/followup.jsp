<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script src="${pageContext.request.contextPath}/js/views/ehr/ehrbrowser/health/followup.js" type="text/javascript"></script>
<div style="float: left; width: 25%" class="repeattable">
	<table>
		<thead>
			<tr>
				<th>随访日期</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${whPrenatalFollowups}" var="whp">
				<tr onclick="portalBrwHealthFollowUp.getWhPrenatalFollowup(${whp.id})" >
					<td>
						<input type="hidden" value="${whp.id}" class="healthFollow" />
						<fmt:formatDate value="${whp.visitDate}"></fmt:formatDate>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
<div style="float: right; width: 74%">
	<div id="healthDetailDiv" style="position: relative;"></div>
</div>