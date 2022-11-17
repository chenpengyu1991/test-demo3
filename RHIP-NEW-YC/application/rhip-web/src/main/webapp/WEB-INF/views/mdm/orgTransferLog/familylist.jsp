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
	        <col style="min-width:80px;width: 20%;"/>
	        <col style="min-width:120px;width: 20%;"/>
		</colgroup>
		<thead>
			<tr>
			    <th>户主姓名</th>
				<th>户主身份证</th>
                <th>迁出机构</th>
				<th>迁入机构</th>
				<th>操作者</th>
				<th>迁移时间</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="familyLog" items="${familyLogList}" varStatus="status">
				<tr>
				    <td style="text-align:center">${familyLog.name}</td>
				    <td style="text-align:center"><ehr:tip>${familyLog.idcard}</ehr:tip></td>
					<td><ehr:tip><ehr:org code="${familyLog.inputOrganCode}"/></ehr:tip></td>
                    <td><ehr:tip><ehr:org code="${familyLog.currentOrganCode}"/></ehr:tip></td>
                    <td style="text-align:center">${familyLog.operator}</td>
                    <td style="text-align:center">
                    <fmt:formatDate value='${familyLog.recordChangeTime}' pattern='yyyy/MM/dd'/>
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