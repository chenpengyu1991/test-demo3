<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/base/page.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/js/views/ehr/ehrbrowser/manage/followUp/followup.js"></script>
<div  class="rightnav">
	<table>
		<tr>
	     	<td class="crumbs"><div id="location" parentMenu="disease-management" childMenu="manageFollow">当前位置:&gt;&gt;疾病管理&gt;&gt;保健计划</div>
		</td>
	 	</tr>
	</table>
	<div class="table-basic">
		<table>
			<thead>
				<tr>
					<th>疾病</th>
					<th>随访时间</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="hypertension" items="${hypertensionList}" >
					<tr onclick="portalBrwFollowup.getFollowUpDetail(${hypertension.id}, 1)">
						<td>
							<input type="hidden" value="${hypertension.id}" class="hiddenId"/>
							<input type="hidden" value="1" class="hiddenType"/>
							高血压
						</td>
						<td><fmt:formatDate value="${hypertension.visitDate}" pattern="yyyy/MM/dd"/></td>
					</tr>
				</c:forEach>
				<c:forEach items="${diabeticList}" var="diabetic">
					<tr onclick="portalBrwFollowup.getFollowUpDetail(${diabetic.id}, 2)">
						<td>
							<input type="hidden" value="${diabetic.id}" class="hiddenValue"/>
							<input type="hidden" value="2" class="hiddenType"/>
							糖尿病
						</td>
						<td><fmt:formatDate value="${diabetic.visitDate}" pattern="yyyy/MM/dd"/></td>
					</tr>
				</c:forEach>
				<c:forEach var="tumor"  items="${tumorList}">
					<tr onclick="portalBrwFollowup.getFollowUpDetail(${tumor.id}, 5)">
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
				<c:forEach var="strtum" items="${strtumList}">
					<tr onclick="portalBrwFollowup.getFollowUpDetail(${strtum.id}, ${strtum.diseaseType})">
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
	<div>
		<div id="followUpInfo"></div>
	</div>
</div>