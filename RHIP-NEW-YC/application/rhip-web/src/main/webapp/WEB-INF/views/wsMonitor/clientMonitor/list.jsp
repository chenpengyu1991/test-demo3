<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<div class="repeattable">
	<table id="serviceTable">
		<colgroup>
	        <col style="min-width:200px;width: 40%;"/>
			<col style="min-width:150px;width: 20%;"/>
	        <col style="min-width:80px;width: 20%;"/>
	        <col style="min-width:120px;width: 20%;"/>
		</colgroup>
		<thead>
			<tr>
				<th>机构名称</th>
                <th>IP地址</th>
				<th>禁用标志</th>
				<th>访问次数</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="wsClientInfo" items="${wsClientInfos}" varStatus="status">
				<tr>
					<td><ehr:tip><ehr:org code="${wsClientInfo.orgCode}"/></ehr:tip></td>
					<td><ehr:tip>${wsClientInfo.userIp}</ehr:tip></td>
					<td class="centertd"><ehr:dic dicmeta="FS990020" code="${wsClientInfo.isOff}" /></td>
					<td>${wsClientInfo.accessCount}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<table>
		<tr>
			<ehr:pagination action="clientMonitorSearch.search" />
		</tr>
	</table>
</div>