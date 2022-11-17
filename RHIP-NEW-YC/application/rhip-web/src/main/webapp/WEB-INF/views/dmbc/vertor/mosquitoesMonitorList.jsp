<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<script src="${pageContext.request.contextPath}/js/views/dmbc/vertor/mosquitoesMonitorList.js" type="text/javascript"></script>
<div class="repeattable">
	<table>
		<colgroup>
			<col style="min-width:60px;width: 20%;"/>
	        <col style="min-width:120px;width: 20%;"/>
			<col style="min-width:40px;width: 20%;"/>
	      <%--   <col style="min-width:100px;width: 20%;"/>	 --%>
	        <col style="min-width:100px;width: 20%;"/>			
		</colgroup>	
		<thead>
			<tr>
				<th>监测时间</th>
				<th>监测乡镇</th>
				<th>环境类型</th>
				<!-- <th>布夹地点</th>	 -->
				<th>操作</th>			
			</tr>
		</thead>
		<tbody>
			<c:forEach var="mosquitoesMonitor" items="${mosquitoesMonitorList.list}" varStatus="status">
				<tr>
					<td title="<fmt:formatDate value="${mosquitoesMonitor.monitorDate}" pattern="yyyy/MM/dd" />">
						<fmt:formatDate value="${mosquitoesMonitor.monitorDate}" pattern="yyyy/MM/dd" />
					</td>
					<td title='<ehr:dic dicmeta="FS990001" code="${mosquitoesMonitor.townShip}"/>' class="centertd">
						<ehr:dic dicmeta="FS990001" code="${mosquitoesMonitor.townShip}"/>
					</td>
					<td title="<ehr:dic dicmeta="DMBC00012"  code="${mosquitoesMonitor.environment}" />">
						<ehr:dic dicmeta="DMBC00012"  code="${mosquitoesMonitor.environment}" />
					</td>
					<%-- <td title="${mosquitoesMonitor.place}">${mosquitoesMonitor.place}</td> --%>
					<td style="text-align:center">
					    <a href="#this" onclick="mosquitoesMonitorList.viewOrEdit('${mosquitoesMonitor.id}','view')">查看</a>
					    <a href="#this" onclick="mosquitoesMonitorList.viewOrEdit('${mosquitoesMonitor.id}','edit')">修改</a>
					    <a href="#this" onclick="mosquitoesMonitorList.del('${mosquitoesMonitor.id}')">删除</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<table>
		<tr>
			<ehr:pagination action="mosquitoesMonitorSearch.search" />
		</tr>
	</table>
</div>