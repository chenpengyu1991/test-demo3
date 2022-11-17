<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<script src="${pageContext.request.contextPath}/js/views/dmbc/vertor/flyMonitorList.js" type="text/javascript"></script>
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
				<th>气温</th>
				<th>风级</th>	
				<th>操作</th>			
			</tr>
		</thead>
		<tbody>
			<c:forEach var="flyMonitor" items="${flyMonitorList.list}" varStatus="status">
				<tr>
					<td title="<fmt:formatDate value="${flyMonitor.monitorDate}" pattern="yyyy/MM/dd" />">
						<fmt:formatDate value="${flyMonitor.monitorDate}" pattern="yyyy/MM/dd" />
					</td>
					<td title='<ehr:dic dicmeta="FS990001" code="${flyMonitor.townShip}"/>' class="centertd">
						<ehr:dic dicmeta="FS990001" code="${flyMonitor.townShip}"/>
					</td>
					<td title="${flyMonitor.temp}">
						${flyMonitor.temp}
					</td>
					<td title="${flyMonitor.windScale}">${flyMonitor.windScale}</td>
					<td style="text-align:center">
					    <a href="#this" onclick="flyMonitorList.viewOrEdit('${flyMonitor.id}','view')">查看</a>
					    <a href="#this" onclick="flyMonitorList.viewOrEdit('${flyMonitor.id}','edit')">修改</a>
					    <a href="#this" onclick="flyMonitorList.del('${flyMonitor.id}')">删除</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<table>
		<tr>
			<ehr:pagination action="flyMonitorSearch.search" />
		</tr>
	</table>
</div>