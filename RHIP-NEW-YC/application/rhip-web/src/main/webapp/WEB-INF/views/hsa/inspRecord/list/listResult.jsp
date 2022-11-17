<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<table>
	<colgroup>
		<col style="width: 23%" />
		<col style="width: 20%" />
		<col style="width: 15%" />
		<col style="width: 7%" />
		<col style="width: 7%" />
		<col style="width: 8%" />
	</colgroup>
	<thead>
		<tr>
			<th style="width: 40px;">发现的主要问题</th>
			<th style="width: 35px;">巡查日期</th>
			<th style="width: 30px;">巡查人</th>
			<th style="width: 15px;">是否巡查指导</th>
			<th style="width: 15px;">是否报告登记</th>
			<th style="width: 20px;">操作</th>
		</tr>
	</thead>
	<tbody class="tbody">
	<c:forEach var="inspectionRecord" items="${inspectionRecordList}">
		<tr>
			<td><ehr:tip>${inspectionRecord.findMainPro}</ehr:tip> </td>
			<td><ehr:tip><fmt:formatDate value="${inspectionRecord.inspDate}" pattern="yyyy/MM/dd" /> </ehr:tip></td>
			<td><ehr:tip>${inspectionRecord.inspPersonName}</ehr:tip></td>
           	<td><ehr:tip><ehr:dic dicmeta="FS10246" code="${inspectionRecord.isGuide}"/></ehr:tip></td>
        	<td><ehr:tip><ehr:dic dicmeta="FS10246" code="${inspectionRecord.isReport}"/></ehr:tip></td>
			<td><a title="点击进行查看" class="hsa-listdatagrid-view-link"
					href="javascript:void(0)" data-locationid="${inspectionRecord.locationId}" data-id="${inspectionRecord.id}">查看</a> 
			<c:if test="${inspectionRecord.status==1}">
				<ehr:authorize ifAnyGranted="28">	
					<a title="点击进行确认" class="hsa-listdatagrid-confirm-link"
							href="javascript:void(0)" data-locationid="${inspectionRecord.locationId}" data-id="${inspectionRecord.id}">确认</a>
				</ehr:authorize>
			</c:if>
			</td>
		</tr>
	</c:forEach>
	<tr>
			<td colspan="6">
				<ehr:paging action="hsaLocationList.search" />
			</td>
		</tr>
</tbody>
</table>
<%-- <ehr:paging action="hsaInspRecordList.search" /> --%>