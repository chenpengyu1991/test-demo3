<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>

<script src="${pageContext.request.contextPath}/js/views/he/supervisor/detail.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/views/he/supervisor/edit.js" type="text/javascript"></script>

<div class="repeattable">
	<table>
		<colgroup>
			<col style="width: 250px;" />
			<col style="width: 100px;" />
			<col style="width: 100px;" />
			<col style="width: 100px;" />
			<col style="width: 100px;" />
		</colgroup>
		<thead>
			<tr>
				<th>机构名称</th>
				<th>参加人员</th>
				<th>督查对象</th>
				<th>督查时间</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="healthSupervisor" items="${healthSupervisors}">
				<tr>
					<td>
						<%--<c:if test="${empty orgCode && empty centerOrgCode && empty gbcode}">--%>
								<%--<ehr:tip><ehr:dic code="${healthSupervisor.gbcode}" dicmeta="FS990001"  /></ehr:tip>--%>
						<%--</c:if>--%>
						<%--<c:if test="${not empty orgCode || not empty centerOrgCode || not empty gbcode}">--%>
								<%--<ehr:tip><ehr:org code="${healthSupervisor.orgCode}" /></ehr:tip>--%>
						<%--</c:if>--%>
                            <%--<c:if test="${healthSupervisor.orgCode eq healthSupervisor.centerOrgCode}">--%>
                                <%--<ehr:tip><ehr:org code="${healthSupervisor.orgCode}" /></ehr:tip>--%>
                            <%--</c:if>--%>
                            <%--<c:if test="${healthSupervisor.orgCode ne healthSupervisor.centerOrgCode}">--%>
                                <%--<ehr:tip><ehr:org code="${healthSupervisor.centerOrgCode}" /></ehr:tip>--%>
                            <%--</c:if>--%>
                            <%--需求修改：不显示镇显示具体机构名称.2014-03-10--%>
                            <ehr:tip><ehr:org code="${healthSupervisor.orgCode}" /></ehr:tip>
                            <c:if test="${healthSupervisor.gbcode eq '_999'}"><ehr:tip>健康教育所</ehr:tip></c:if>
					</td>
					<td>${healthSupervisor.participants}</td>
					<td>${healthSupervisor.overseePerson}</td>
					<td style="text-align: center;"><fmt:formatDate value="${healthSupervisor.overseeTime}" pattern="yyyy-MM-dd"/></td>
					<td style="text-align: center;">
						<a href="javascript:void(0);"  onclick="healthEducationSupervisorDetail.viewHealthEducationSupervisor(${healthSupervisor.id})">查看</a>
						<c:if test="${createrOrg eq healthSupervisor.orgCode  || createrOrg eq '_999'}">
						<a href="javascript:void(0);"  onclick="healthEducationSupervisorEdit.editHealthEducationSupervisor(${healthSupervisor.id})">修改</a>
						<a href="javascript:void(0);"  onclick="healthEducationSupervisorEdit.deleteHealthEducationSupervisor(${healthSupervisor.id})">删除</a>
						</c:if>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<table>
		<tr>
			<ehr:pagination action="healthEducationSupervisorSearch.search" />
		</tr>
	</table>
</div>