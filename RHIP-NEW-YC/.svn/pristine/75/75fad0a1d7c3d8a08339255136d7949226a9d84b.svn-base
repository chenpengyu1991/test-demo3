<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<script src="${pageContext.request.contextPath}/js/views/dmbc/vertor/roachMonitorList.js" type="text/javascript"></script>
<div class="repeattable">
	<table>
		<colgroup>
			<col style="min-width:60px;width: 20%;"/>
	        <col style="min-width:120px;width: 20%;"/>
			<col style="min-width:40px;width: 20%;"/>
	        <col style="min-width:100px;width: 20%;"/>	
	        <col style="min-width:100px;width: 20%;"/>			
		</colgroup>	
		<thead>
			<tr>
				<th>监测时间</th>
				<th>监测乡镇</th>
				<th>环境类型</th>
				<th>单位名称</th>	
				<th>操作</th>			
			</tr>
		</thead>
		<tbody>
			<c:forEach var="roachMonitor" items="${roachMonitorList.list}" varStatus="status">
				<tr>
					<td title="<fmt:formatDate value="${roachMonitor.monitorDate}" pattern="yyyy/MM/dd" />">
						<fmt:formatDate value="${roachMonitor.monitorDate}" pattern="yyyy/MM/dd" />
					</td>
					<td title='<ehr:dic dicmeta="FS990001" code="${roachMonitor.townShip}"/>' class="centertd">
						<ehr:dic dicmeta="FS990001" code="${roachMonitor.townShip}"/>
					</td>
					<td title="<ehr:dic dicmeta="DMBC00007" code="${roachMonitor.environment}"/>">
						<ehr:dic dicmeta="DMBC00007" code="${roachMonitor.environment}"/>
					</td>
					<td title="${roachMonitor.orgName}">${roachMonitor.orgName}</td>
					<td style="text-align:center">
					    <a href="#this" onclick="roachMonitorList.viewOrEdit('${roachMonitor.id}','view')">查看</a>
					    <a href="#this" onclick="roachMonitorList.viewOrEdit('${roachMonitor.id}','edit')">修改</a>
					    <a href="#this" onclick="roachMonitorList.del('${roachMonitor.id}')">删除</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<table>
		<tr>
			<ehr:pagination action="roachMonitorSearch.search" />
		</tr>
	</table>
</div>