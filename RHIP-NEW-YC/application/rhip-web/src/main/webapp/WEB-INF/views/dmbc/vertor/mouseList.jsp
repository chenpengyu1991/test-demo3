<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<script src="${pageContext.request.contextPath}/js/views/dmbc/vertor/mouseList.js" type="text/javascript"></script>
<div class="repeattable" style="${displayList}">
	<table>
		<colgroup>
			<col style="min-width:50px;width: 5%;"/>
	        <col style="min-width:120px;width: 15%;"/>
			<col style="min-width:40px;width: 15%;"/>
	        <col style="min-width:60px;width: 7%;"/>	
	        <col style="min-width:60px;width: 5%;"/>	
	        <col style="min-width:100px;width: 10%;"/>	
	        <col style="min-width:100px;width: 10%;"/>
	        <col style="min-width:100px;width: 17%;"/>	
	        <col style="min-width:100px;width: 16%;"/>			
		</colgroup>	
		<thead>
			<tr>
				<th style="text-align: center">序号</th>
				<th style="text-align: center">鼠种</th>
				<th style="text-align: center">捕鼠地点</th>
				<th style="text-align: center">室内/室外</th>	
				<th style="text-align: center">性别</th>	
				<th style="text-align: center">体重(g)</th>	
				<th style="text-align: center">头体长(mm)</th>
				<th style="text-align: center">备注</th>
				<c:if test="${type == 'edit'}"><th style="text-align: center">操作</th>	</c:if>			
			</tr>
		</thead>
		<tbody>
			<c:forEach var="mouse" items="${mouseList.list}" varStatus="status">
				<tr>
					<td title="${mouse.num}" align="center">
						${mouse.num}
					</td>
					<td title='<ehr:dic dicmeta="DMBC00002" code="${mouse.mouseSpecies}"/>' class="centertd">
						<ehr:dic dicmeta="DMBC00002" code="${mouse.mouseSpecies}"/>
					</td>
					<td title="${mouse.site}">
						${mouse.site}
					</td>
					<td title="<ehr:dic dicmeta="FS10015" code="${mouse.environment}"/>">
						<ehr:dic dicmeta="FS10015" code="${mouse.environment}"/>
					</td>
					<td title="<ehr:dic dicmeta="DMBC00010" code="${mouse.gender}"/>">
						<ehr:dic dicmeta="DMBC00010" code="${mouse.gender}"/>
					</td>
					<td title="${mouse.weight}">${mouse.weight}</td>
					<td title="${mouse.bodyLength}">${mouse.bodyLength}</td>
					<td title="${mouse.remarks}">${mouse.remarks}</td>
					<c:if test="${type == 'edit'}">
					<td style="text-align:center">
					    <a href="#this" onclick="mouseMonitorAdd.initMouseEdit('${mouse.id}')">修改</a>
					    <a href="#this" onclick="mouseMonitorAdd.del('${mouse.id}')">删除</a>
					</td>
					</c:if>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<table>
		<tr>
			<ehr:pagination action="mouseList.search" />
		</tr>
	</table>
</div>