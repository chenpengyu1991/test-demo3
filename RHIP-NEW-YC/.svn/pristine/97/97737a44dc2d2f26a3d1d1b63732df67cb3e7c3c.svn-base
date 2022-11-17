<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<script src="${pageContext.request.contextPath}/js/views/dmbc/medicalInst/infectMonitorList.js" type="text/javascript"/>
<div class="repeattable">
	<table>
		<colgroup>
			<col style="width: 20%;"/>
			<col style="width: 20%;"/>
			<col style="width: 20%;"/>
			<col style="width: 20%;"/>
			<col style="width: 20%;"/>
		</colgroup>
		<thead>
		<tr>
			<th>机构名称</th>
			<th>抽查病例数</th>
			<th>合计</th>
			<th>监测日期</th>
			<th>操作</th>
		</tr>
		</thead>
		<tbody>
		<c:forEach var="infectMonitor" items="${infectMonitorList}" varStatus="status">
			<tr>
				<td title="<ehr:org code="${infectMonitor.orgName}"/>"><ehr:org code="${infectMonitor.orgName}"/></td>
				<td>${infectMonitor.spotCheckNum}</td>
				<td>${infectMonitor.total}</td>
				<td><fmt:formatDate value="${infectMonitor.monitorDate}" pattern="yyyy/MM/dd"/></td>
				<td style="text-align:center">
					<a href="#this" onclick="infectMonitorList.viewOrEdit('${infectMonitor.id}','view')">查看</a>
					<ehr:authorize ifAnyGranted="02,03">
						<a href="#this" onclick="infectMonitorList.viewOrEdit('${infectMonitor.id}','edit')">修改</a>
						<a href="#this" onclick="infectMonitorList.del(this, '${infectMonitor.id}')">删除</a>
					</ehr:authorize>
				</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<table>
		<tr>
			<ehr:pagination action="infectMonitorSearch.search" />
		</tr>
	</table>
</div>
<div><input type="hidden" id="indexPage" value="${indexPage}"/></div>