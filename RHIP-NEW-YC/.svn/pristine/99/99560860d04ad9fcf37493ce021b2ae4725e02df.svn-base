<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:forEach var="susOccDisInfoList" items="${inspRecord.susOccDisInfoList}" varStatus="status">
	 	<tr id="${status.index}">
	 		<td title="${susOccDisInfoList.name}" dataName="name" dataValue="${susOccDisInfoList.name}">${susOccDisInfoList.name}</td>
	 		<td title="${susOccDisInfoList.age}" dataName="age" dataValue="${susOccDisInfoList.age}">${susOccDisInfoList.age}</td>
	 		<td title="<ehr:dic dicmeta="GBT226112003" code = "${susOccDisInfoList.gender}"/>" dataName="gender" dataValue="${susOccDisInfoList.gender}"><ehr:dic dicmeta="GBT226112003" code = "${susOccDisInfoList.gender}"/></td>
	 		<td title="${susOccDisInfoList.idcard}" dataName="idcard" dataValue="${susOccDisInfoList.idcard}">${susOccDisInfoList.idcard}</td>
	 		<td title="${susOccDisInfoList.workUnit}" dataName="workUnit" dataValue="${susOccDisInfoList.workUnit}">${susOccDisInfoList.workUnit}</td>
	 		<td title="<ehr:dic dicmeta="GBT6565" code="${susOccDisInfoList.occupation}"/>" dataName="occupation" dataValue="${susOccDisInfoList.occupation}"><ehr:dic dicmeta="GBT6565" code="${susOccDisInfoList.occupation}"/></td>
	 		<td title="${susOccDisInfoList.susOccDiseaseName}" dataName="susOccDiseaseName" dataValue="${susOccDisInfoList.susOccDiseaseName}">${susOccDisInfoList.susOccDiseaseName}</td>
	 		<td title="${susOccDisInfoList.unitPhoneNumber}" dataName="unitPhoneNumber" dataValue="${susOccDisInfoList.unitPhoneNumber}">${susOccDisInfoList.unitPhoneNumber}</td>
	 		<td title="${susOccDisInfoList.phoneNumber}" dataName="phoneNumber" dataValue="${susOccDisInfoList.phoneNumber}">${susOccDisInfoList.phoneNumber}</td>
	 		<td title="${susOccDisInfoList.recipientUnit}" dataName="recipientUnit" dataValue="${susOccDisInfoList.recipientUnit}">${susOccDisInfoList.recipientUnit}</td>
	 		<td title="${susOccDisInfoList.recipientName}" dataName="recipientName" dataValue="${susOccDisInfoList.recipientName}">${susOccDisInfoList.recipientName}</td>
	 		<td title="${susOccDisInfoList.recipientPhone}" dataName="recipientPhone" dataValue="${susOccDisInfoList.recipientPhone}">${susOccDisInfoList.recipientPhone}</td>
	 		<td title="${susOccDisInfoList.id}" class='hide' dataName='id' dataValue="${susOccDisInfoList.id}">${susOccDisInfoList.id}</td>
	 		<c:if test="${flag !='view'}"><td title='修改 删除'><a  href='javascript:void(0)' class='edit-link' >修改 </a><a href='javascript:void(0)' class='delete-link' > 删除</a></td></c:if>
	 	</tr>
 </c:forEach>