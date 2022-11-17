<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<script src="${pageContext.request.contextPath}/js/views/dmbc/vertor/flyMonitorList.js" type="text/javascript"></script>
<div class="repeattable">
	<table>
		<colgroup>
	        <col style="width:60px;"/>
			<col style="width:60px;"/>		
			<col style="width:60px;"/>
			<col style="width:60px;"/>	
		</colgroup>	
		<thead>
			<tr>
				<th>机构名称</th>
				<th>机构类型</th>
				<th>监测时间</th>
				<th>操作</th>		
			</tr>
		</thead>
		<tbody>
			<c:forEach var="monitor" items="${monitorList}" varStatus="status">
				<tr>
					<td title="${monitor.orgName}">${monitor.orgName}</td>
					<td title='<ehr:dic dicmeta="DMBC00009" code="${monitor.orgType}"/>' class="centertd">
						<ehr:dic dicmeta="DMBC00009" code="${monitor.orgType}"/>
					</td>
					<td title="<fmt:formatDate value="${monitor.monitorDate}" pattern="yyyy/MM/dd" />">
						<fmt:formatDate value="${monitor.monitorDate}" pattern="yyyy/MM/dd" />
					</td>
					<td style="text-align:center">
					    <a href="javascript:void(0)" onclick="dmbcChildcareInstMonitorSearch.view('${monitor.id}','view')">查看</a>
					    <a href="javascript:void(0)" onclick="dmbcChildcareInstMonitorSearch.edit('${monitor.id}','edit')">修改</a>
					    <a href="javascript:void(0)" onclick="dmbcChildcareInstMonitorSearch.remove('${monitor.id}')">删除</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<table>
		<tr>
			<ehr:pagination action="dmbcChildcareInstMonitorSearch.search" />
		</tr>
	</table>
	<input type="hidden" id="_indexPage" value="${indexPage}" />
</div>