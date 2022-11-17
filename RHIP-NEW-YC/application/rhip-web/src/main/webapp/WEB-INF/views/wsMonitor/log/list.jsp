<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<div class="repeattable">
	<table id="serviceTable">
		<colgroup>
	        <col style="min-width:120px;width: 15%;"/>
			<col style="min-width:120px;width: 15%;"/>
	        <col style="min-width:120px;width: 15%;"/>
	        <col style="min-width:120px;width: 15%;"/>
			<col style="min-width:60px;width: 10%;"/>
			<col style="min-width:80px;width: 10%;"/>
			<col style="min-width:80px;width: 10%;"/>
			<col style="min-width:80px;width: 10%;"/>
		</colgroup>
		<thead>
			<tr>
				<th>机构名称</th>
                <th>IP地址</th>
				<th>接口名称</th>
				<th>接口方法</th>
				<th>成功标志</th>
				<th>请求开始时间</th>
				<th>请求结束时间</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="logInfo" items="${logInfos}" varStatus="status">
				<tr>
					<td><ehr:tip><ehr:org code="${logInfo.orgCode}"/></ehr:tip></td>
					<td><ehr:tip>${logInfo.userIp}</ehr:tip></td>
					<td class="centertd"><ehr:tip>${logInfo.webServiceName}</ehr:tip></td>
					<td class="centertd"><ehr:tip>${logInfo.wsMethodName}</ehr:tip></td>
					<td class="centertd"><ehr:dic dicmeta="FS990021" code="${logInfo.isSuccess}" /></td>
					<td class="centertd"><ehr:tip><fmt:formatDate pattern="yyyy/MM/dd" value="${logInfo.startTime}"/></ehr:tip></td>
					<td class="centertd"><ehr:tip><fmt:formatDate pattern="yyyy/MM/dd" value="${logInfo.endTime}"/></ehr:tip></td>
					<td>
						<a href="javascript:void(0);" class="view-link" data-id="${logInfo.id}">查看</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<table>
		<tr>
			<ehr:pagination action="logSearch.search" />
		</tr>
	</table>
</div>