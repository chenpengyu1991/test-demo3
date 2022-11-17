<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<script src="${pageContext.request.contextPath}/js/views/dmbc/vertor/mouseMonitorList.js" type="text/javascript"></script>
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
				<th>布夹环境</th>
				<th>布夹地点</th>	
				<th>操作</th>			
			</tr>
		</thead>
		<tbody>
			<c:forEach var="mouseMonitor" items="${mouseMonitorList.list}" varStatus="status">
				<tr>
					<td title="<fmt:formatDate value="${mouseMonitor.monitorDate}" pattern="yyyy/MM/dd" />">
						<fmt:formatDate value="${mouseMonitor.monitorDate}" pattern="yyyy/MM/dd" />
					</td>
					<td title='<ehr:dic dicmeta="FS990001" code="${mouseMonitor.townShip}"/>' class="centertd">
						<ehr:dic dicmeta="FS990001" code="${mouseMonitor.townShip}"/>
					</td>
					<td title="<ehr:dic dicmeta="DMBC00001"  code="${mouseMonitor.environment}" />">
						<ehr:dic dicmeta="DMBC00001"  code="${mouseMonitor.environment}" />
					</td>
					<td title="${mouseMonitor.place}">${mouseMonitor.place}</td>
					<td style="text-align:center">
					    <a href="#this" onclick="mouseMonitorList.viewOrEdit('${mouseMonitor.id}','view')">查看</a>
					    <a href="#this" onclick="mouseMonitorList.viewOrEdit('${mouseMonitor.id}','edit')">修改</a>
					    <a href="#this" onclick="mouseMonitorList.del('${mouseMonitor.id}')">删除</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<table>
		<tr>
			<ehr:pagination action="mouseMonitorSearch.search" />
		</tr>
	</table>
</div>