<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/base/page.css" />
<script src="${pageContext.request.contextPath}/js/views/ehr/ehrbrowser/manage/managePlan.js" type="text/javascript"></script>
<div class="rightnav">
	<table>
		<tr>
	     	<td class="crumbs"><div id="location" parentMenu="disease-management" childMenu="managePlan">当前位置:&gt;&gt;疾病管理&gt;&gt;保健计划</div>
		</td>
	 	</tr>
	</table>
	<div class="repeattable">
		<table>
			<thead>
				<tr>
					<th>疾病</th>
					<th>年份</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${dmHypertensionConclusions}" var="dm">
					<tr onclick="portalBrwManagePlan.getDmHypertensionConclusion(${dm.id})">
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
	<div>
		<div id="planInfoTabList"></div>
	</div>
</div>