<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<%@ page import="com.founder.rhip.ehr.common.RoleType" %>
<c:set var="ADMIN" value="<%=RoleType.ADMIN.getValue()%>"/>
<c:set var="JKMBK" value="<%=RoleType.JKMBK.getValue()%>"/>
<c:set var="ZXMB" value="<%=RoleType.ZXMB.getValue()%>"/>
<c:set var="ZMB" value="<%=RoleType.ZMB.getValue()%>"/>

<script
	src="${pageContext.request.contextPath}/js/views/cdm/standardization/healthPlan/planSingleInfoList.js"
	type="text/javascript"></script>
<table id="plansingleList">
	<colgroup>
		<col style="width: 18%;" />
		<col style="width: 18%" />
		<col style="width: 18%" />
		<col style="width: 18%" />
		<col style="width: 10%" />
	</colgroup>
	<thead>
		<tr>
			<th style="width: 60px;">计划年度</th>
			<th style="width: 60px;">创建时间</th>
			<th style="width: 60px;">创建医生</th>
			<th style="width: 60px;">创建机构</th>
			<th style="width: 40px;">操作</th>
		</tr>
	</thead>
	<tbody class="tbody">
		<c:forEach var="dmPlanInfo" items="${singlePlanList}">
			<tr>
				<td>${dmPlanInfo.conclusionsOfYear}</td>
				<td><ehr:tip>
						<fmt:formatDate value="${dmPlanInfo.createDate}"
							pattern="yyyy/MM/dd" />
					</ehr:tip></td>
				<td><ehr:tip>
						<c:choose>
							<c:when test="${dmPlanInfo.createDoctorName eq null}">
								<ehr:user userCode='${dmPlanInfo.createDoctorCode}'></ehr:user>
							</c:when>
							<c:otherwise>
								${dmPlanInfo.createDoctorName}
							</c:otherwise>
						</c:choose>
					</ehr:tip></td>
				<td><ehr:tip><ehr:org code="${dmPlanInfo.createOrganCode}"/></ehr:tip></td>
				<td><a title="点击进行保健计划查看" class="cdm-plan-view-link"
					href="javascript:void(0)" data-id="${dmPlanInfo.id}">查看</a>
					<ehr:authorize
						ifAnyGranted="${ZXMB},${ZMB}">
						<a title="点击进行保健计划修改" class="cdm-plan-modify-link"
							href="javascript:void(0)" data-id="${dmPlanInfo.id}">修改</a>
						<a title="点击进行保健计划删除" class="cdm-plan-delete-link"
							href="javascript:void(0)" data-id="${dmPlanInfo.id}" data-personid="${dmPlanInfo.personId}">删除</a>
					</ehr:authorize></td>
			</tr>
		</c:forEach>
	</tbody>
</table>


