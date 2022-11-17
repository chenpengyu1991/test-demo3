<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<script src="${pageContext.request.contextPath}/js/views/he/active/detail.js" type="text/javascript"></script>
<div class="postcontent">
	<div class="postdiv">
		<table class="posttable">
			<colgroup>
				<col style="width: 15%;" />
				<col style="width: 35%;" />
				<col style="width: 15%;" />
				<col style="width: 35%;" />
			</colgroup>
			<tr>
				<th>${healthEducationActive.systemType eq '1' ?'培训':'活动'}类别</th>
				<td><c:if test="${healthEducationActive.activeType eq '99'}">${healthEducationActive.otherActiveType}</c:if>
					<c:if test="${healthEducationActive.activeType ne '99'}">
						<ehr:dic dicmeta="HE00001" code="${healthEducationActive.activeType}"></ehr:dic>
					</c:if></td>
				<th>活动时间</th>
				<td><fmt:formatDate value="${healthEducationActive.activeTime}" pattern="yyyy/MM/dd" /></td>
			</tr>
			<tr>
				<th>活动地点</th>
				<td>${healthEducationActive.activePlace}</td>
				<th>活动主题</th>
				<td>${healthEducationActive.activeTheme}</td>
			</tr>
			<tr>
				<th>出动${healthEducationActive.systemType eq '1' ?'':'医务'}人员数</th>
				<td>${healthEducationActive.medicalPersonQuantity}</td>
				<th>组织者</th>
				<td>${healthEducationActive.organizer}</td>
			</tr>
			<tr>
				<c:choose>
					<c:when test="${healthEducationActive.systemType eq '1'}">
						<th>专业类别</th>
						<td><ehr:dic dicmeta="HSA00009" code="${healthEducationActive.industryType}"></ehr:dic></td>
					</c:when>
					<c:otherwise>
						<th>接受健康教育人员类别</th>
						<td>
							<c:if test="${healthEducationActive.educationPersonType ne '99'}">
								<ehr:dic dicmeta="HE00002" code="${healthEducationActive.educationPersonType}"></ehr:dic>
							</c:if>
							<c:if test="${fn:contains(healthEducationActive.educationPersonType,'99')}">${healthEducationActive.otherPersonType}</c:if>
						</td>
					</c:otherwise>
				</c:choose>
				<th>接受健康教育人员人数</th>
				<td>${healthEducationActive.educationPersonQuantity}</td>
			</tr>
			<tr>
				<th>发放健康教育资料种类</th>
				<td>
					<c:if test="${healthResourceRecord.materialType eq '99'}"><ehr:tip>${healthResourceRecord.otherMaterialType}</ehr:tip></c:if>
					<c:if test="${healthResourceRecord.materialType ne '99'}"><ehr:tip> <ehr:dic dicmeta="HE00003" code="${healthResourceRecord.materialType}" ></ehr:dic></ehr:tip></c:if>
				</td>
				<th>发放健康教育资料数量</th>
				<td>${healthResourceRecord.issueQuantity}</td>
			</tr>
			<c:if test="${empty healthEducationActive.systemType}">
				<tr>
					<th>业务分类</th>
					<td>
					<c:if test="${healthEducationActive.businessType eq '99'}"><ehr:tip>${healthEducationActive.otherBusinessType}</ehr:tip></c:if>
					<c:if test="${healthEducationActive.businessType ne '99'}"><ehr:tip> <ehr:dic dicmeta="HE00005" code="${healthEducationActive.businessType}" ></ehr:dic></ehr:tip></c:if>
					</td>
				</tr>
			</c:if>
			<tr>
				<th>活动主要内容</th>
				<td colspan="3">${healthEducationActive.activeDetail}</td>
			</tr>
			<tr>
				<th>工作计划</th>
				<td colspan="3">${healthEducationActive.workPlan}</td>
			</tr>
			<tr>
				<th>活动总体评价</th>
				<td colspan="3">${healthEducationActive.activeTotalEval}</td>
			</tr>
			<tr>
				<th>附件</th>
				<td colspan="3">
					<div style="width: 690px;">
						<c:forEach items="${attches}" var="attche" >
							<div style="width: 180px;float: left;margin-top: 5px;margin-left:5px;margin-right:10px;text-align: center;" id="${attche.id}-div">
								<c:if test="${attche.imageFlag eq true}">
									<a target="blank" href="${pageContext.request.contextPath}/he/upload/showAsImage/${attche.id}"><img alt="点击查看大图" title="点击查看大图"
																																			   src="${pageContext.request.contextPath}/he/upload/showSmallImage/${attche.id}"
									/>${attche.originalFileName}</a>
								</c:if>
								<c:if test="${attche.imageFlag eq false}">
									<a target="blank"  href="${pageContext.request.contextPath}/he/upload/download/${attche.id}" onclick="javascript:void(0)">${attche.originalFileName}</a>
								</c:if>
									<%--<a href="javascript:void(0);" onclick="healthEducationUpload.deleteFile('${attche.id}')">删除</a>--%>
							</div>
						</c:forEach>
					</div>
				</td>
			</tr>
		</table>
	</div>
</div>