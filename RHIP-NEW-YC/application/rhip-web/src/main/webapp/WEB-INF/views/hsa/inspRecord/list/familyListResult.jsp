<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<table>
	<colgroup>
		<col width="10%" />
		<col width="30%" />
		<col width="20%" />
		<col width="30%" />
		<col width="100px;" />
	</colgroup>
	<thead>
		<tr>
			<th>户主</th>
			<th>家庭地址</th>
			<th>巡查日期</th>
			<th>巡查机构</th>
			<th>操作</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="record" items="${inspectionRecords}" varStatus="status">
			<tr>
				<td><ehr:tip>${record.householderName}</ehr:tip></td>
				<td><ehr:tip>${record.address}</ehr:tip></td>
				<td><ehr:tip><fmt:formatDate value="${record.inspDate}" pattern="yyyy/MM/dd" /></ehr:tip></td>
				<td><ehr:tip><ehr:org code="${record.createOrganCode}"></ehr:org> </ehr:tip></td>
				<td><a href='javascript:;' data-record-id='${record.id}' class='add-link'>修改</a></td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="5">
				<ehr:paging action="hsaFamilyList.search" />
			</td>
		</tr>
	</tbody>
</table>
<%-- <ehr:paging action="hsaFamilyList.search" /> --%>