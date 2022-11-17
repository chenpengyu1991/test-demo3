<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script src="${pageContext.request.contextPath}/js/views/ehr/ehrbrowser/manage/managePlan.js" type="text/javascript"></script>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div style="float: left; width: 25%;height: 535px;overflow: auto" class="repeattable">
	<table>
		<thead>
			<tr>
				<th>疾病</th>
				<th>年份</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${dmHypertensionConclusions}" var="dm">
				<tr onclick="brwManagePlan.getDmHypertensionConclusion(${dm.id})">
					<td>
						<input type="hidden" value="${dm.id}" class="hiddenValue"/>
						<c:if test="${dm.diseaseType eq 1}">高血压</c:if>
						<c:if test="${dm.diseaseType eq 2}">糖尿病</c:if>
					</td>
					<td><c:out value="${dm.conclusionsOfYear}"></c:out></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
<div style="float: right; width: 74%">
	<div id="planInfoTabList" style="position: relative;height: 535px;overflow: auto"></div>
</div>