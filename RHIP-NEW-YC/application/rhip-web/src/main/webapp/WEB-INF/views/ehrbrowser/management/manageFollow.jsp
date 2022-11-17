<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/views/ehr/ehrbrowser/manage/followUp/followup.js">
</script>
<div style="float: left; width: 25%;height: 535px;overflow: auto" class="repeattable" >
	<table class="layui-table x-admin-sm-table-list-middle">
		<thead>
			<tr>
				<th>疾病</th>
				<th>随访时间</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${hypertensionList}" var="hypertension">
				<tr onclick="brwFollowup.getFollowUpDetail(${hypertension.id}, 1)" style="cursor: hand">
					<td>
						<input type="hidden" value="${hypertension.id}" class="hiddenValue"/>
						<input type="hidden" value="1" class="hiddenType"/>
						高血压
					</td>
					<td><fmt:formatDate value="${hypertension.visitDate}" pattern="yyyy/MM/dd"/></td>
				</tr>
			</c:forEach>
			<c:forEach items="${diabeticList}" var="diabetic">
				<tr onclick="brwFollowup.getFollowUpDetail(${diabetic.id}, 2)">
					<td>
						<input type="hidden" value="${diabetic.id}" class="hiddenValue"/>
						<input type="hidden" value="2" class="hiddenType"/>
						糖尿病
					</td>
					<td><fmt:formatDate value="${diabetic.visitDate}" pattern="yyyy/MM/dd"/></td>
				</tr>
			</c:forEach>
			<c:forEach items="${tumorList}" var="tumor">
				<tr onclick="brwFollowup.getFollowUpDetail(${tumor.id}, 5)">
					<td>
						<input type="hidden" value="${tumor.id}" class="hiddenValue"/>
						<input type="hidden" value="5" class="hiddenType"/>
						肿瘤
					</td>
					<td>
						<c:choose>
							<c:when test='${tumor.followupFlag eq "3"}'>
								<fmt:formatDate value="${tumor.cancelDate}" pattern="yyyy/MM/dd"/>
							</c:when>
							<c:otherwise>
								<fmt:formatDate value="${tumor.visitDate}" pattern="yyyy/MM/dd"/>
							</c:otherwise>
						</c:choose>
					</td>
				</tr>
			</c:forEach>
			<c:forEach items="${strtumList}" var="strtum">
				<tr onclick="brwFollowup.getFollowUpDetail(${strtum.id}, ${strtum.diseaseType})">
					<td>
						<input type="hidden" value="${strtum.id}" class="hiddenValue"/>
						<c:if test="${strtum.diseaseType eq 3}">
							<input type="hidden" value="3" class="hiddenType"/>
							脑卒中
						</c:if>
						<c:if test="${strtum.diseaseType eq 4}">
							<input type="hidden" value="3" class="hiddenType"/>
							冠心病
						</c:if>
					</td>
					<td><fmt:formatDate value="${strtum.visitDate}" pattern="yyyy/MM/dd"/></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
<div style="float: right; width: 74%">
	<div id="followUpInfo" style="position: relative;height: 535px;overflow: auto"></div>
</div>

<div style="clear: both"></div>