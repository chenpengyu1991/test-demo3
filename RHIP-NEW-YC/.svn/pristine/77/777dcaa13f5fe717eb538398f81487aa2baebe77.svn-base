<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<div class="repeattable">
	<table id="serviceTable">
		<colgroup>
	        <col style="min-width:100px;width: 20%;"/>
			<col style="min-width:150px;width: 40%;"/>
	        <col style="min-width:80px;width: 20%;"/>
	        <col style="min-width:120px;width: 20%;"/>
	        <col style="min-width:80px;width: 20%;"/>
	        <col style="min-width:120px;width: 20%;"/>
	        <col style="min-width:100px;width: 20%;"/>
		</colgroup>
		<thead>
			<tr>
			    <th>活动类型</th>
				<th>活动主题</th>
                <th>活动时间</th>
                <th>迁出机构</th>
				<th>迁入机构</th>
				<th>操作者</th>
				<th>迁移时间</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="activityLog" items="${activityLogList}" varStatus="status">
				<tr>
				    <td style="text-align:center"><ehr:tip> <ehr:dic dicmeta="HE00001" code="${activityLog.activityType}" ></ehr:dic></ehr:tip></td>
				    <td>${activityLog.activityName}</td>
				    <td>
				    <fmt:formatDate value='${activityLog.activityTime}' pattern='yyyy/MM/dd'/>
				    </td>
					<td><ehr:tip><ehr:org code="${activityLog.inputOrganCode}"/></ehr:tip></td>
                    <td><ehr:tip><ehr:org code="${activityLog.currentOrganCode}"/></ehr:tip></td>
                    <td style="text-align:center">${activityLog.operator}</td>
                    <td style="text-align:center">
                    <fmt:formatDate value='${activityLog.recordChangeTime}' pattern='yyyy/MM/dd'/>
                    </td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<table>
		<tr>
			<ehr:pagination action="orgtransferLogSearch.search" />
		</tr>
	</table>
</div>