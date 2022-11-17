<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<script src="${pageContext.request.contextPath}/js/views/dmbc/medicalInst/disinfectionMonitorList.js" type="text/javascript"></script>
<div class="repeattable">
	<table>
		<colgroup>
			<col style="min-width:60px;width: 20%;"/>
	        <col style="min-width:120px;width: 15%;"/>
			<col style="min-width:40px;width: 15%;"/>
			<col style="min-width:40px;width: 15%;"/>
			<col style="min-width:40px;width: 15%;"/>	
	        <col style="min-width:100px;width: 20%;"/>			
		</colgroup>	
		<thead>
			<tr>
				<th>机构名称</th>
				<th>监测日期</th>
				<th>采样总数</th>
				<th>合格总数</th>
				<th>合格率</th>	
				<th>操作</th>			
			</tr>
		</thead>
		<tbody>
			<c:forEach var="disinfectionMonitor" items="${disinfectionMonitorList.list}" varStatus="status">
				<tr>
					<td title="<ehr:org code="${disinfectionMonitor.orgName}"/>">
						<ehr:org code="${disinfectionMonitor.orgName}"/>
					</td>
					<td title="<fmt:formatDate value="${disinfectionMonitor.monitorDate}" pattern="yyyy/MM/dd" />">
						<fmt:formatDate value="${disinfectionMonitor.monitorDate}" pattern="yyyy/MM/dd" />
					</td>
					<td title="${disinfectionMonitor.total}">
						${disinfectionMonitor.total}
					</td>
					<td title="${disinfectionMonitor.aceptNum}">
						${disinfectionMonitor.aceptNum}
					</td>
					<td title="<fmt:formatNumber type="number" value="${disinfectionMonitor.aceptNum/disinfectionMonitor.total*100}" maxFractionDigits="0" />%">
						
						<fmt:formatNumber type="number" value="${disinfectionMonitor.aceptNum/disinfectionMonitor.total*100}" maxFractionDigits="0" />%
					</td>
					<td style="text-align:center">
					    <a href="#this" onclick="disinfectionMonitorList.viewOrEdit('${disinfectionMonitor.id}','view')">查看</a>
						<ehr:authorize ifAnyGranted="02,03">
							<a href="#this" onclick="disinfectionMonitorList.viewOrEdit('${disinfectionMonitor.id}','edit')">修改</a>
							<a href="#this" onclick="disinfectionMonitorList.del('${disinfectionMonitor.id}')">删除</a>
						</ehr:authorize>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<table>
		<tr>
			<ehr:pagination action="disinfectionMonitorSearch.search" />
		</tr>
	</table>
</div>