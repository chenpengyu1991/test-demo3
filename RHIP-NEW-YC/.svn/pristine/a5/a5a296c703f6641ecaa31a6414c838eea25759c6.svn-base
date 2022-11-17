<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<div class="repeattable">
	<table id="serviceTable">
		<colgroup>
	        <col style="min-width:80px;width: 20%;"/>
			<col style="min-width:150px;width: 20%;"/>
	        <col style="min-width:80px;width: 20%;"/>
	        <col style="min-width:120px;width: 20%;"/>
	        <col style="min-width:80px;width: 20%;"/>
	        <col style="min-width:120px;width: 20%;"/>
		</colgroup>
		<thead>
			<tr>
			    <th>姓名</th>
				<th>身份证号码</th>
                <th>迁出机构</th>
				<th>迁入机构</th>
				<th>操作者</th>
				<th>迁移时间</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="ehrlog" items="${ehrLogList}" varStatus="status">
				<tr>
				    <td style="text-align:center">${ehrlog.name}</td>
				    <td style="text-align:center"><ehr:tip>${ehrlog.idcard}</ehr:tip></td>
					<td><ehr:tip><ehr:org code="${ehrlog.inputOrganCode}"/></ehr:tip></td>
                    <td><ehr:tip><ehr:org code="${ehrlog.currentOrganCode}"/></ehr:tip></td>
                    <td style="text-align:center">${ehrlog.operator}</td>
                    <td style="text-align:center">
                    <fmt:formatDate value='${ehrlog.recordChangeTime}' pattern='yyyy/MM/dd'/>
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