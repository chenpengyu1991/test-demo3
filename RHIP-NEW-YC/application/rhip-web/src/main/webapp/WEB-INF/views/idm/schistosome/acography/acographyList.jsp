<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<div class="repeattable" style="vertical-align: top; width: 300px; margin-left: 10px; margin-top: 70px;">
	<table class="layui-table x-admin-sm-table-list-middle" id="acographyList">
		<colgroup>
			<col style="min-width:100px; width: 50%;"/>
			<col style="min-width:100px; width: 50%;"/>
		</colgroup>		
		<thead>
			<tr>
				<th>治疗医生</th>
                <th>治疗日期</th>				
			</tr>
		</thead>
		<tbody>
			<c:forEach var="acograph" items="${acographlist}" varStatus="status">
				<tr onclick="acographyMain.add(${idmId},${acograph.idmId})">
					<td>
						<input type="hidden" id="singleTrId" value="${acograph.idmId}">
						<ehr:tip><ehr:user userCode="${acograph.treatmentDoctor}"/></ehr:tip>
					</td>
					<td>
						<a href="javascript:void(0)" onclick="acographyMain.add(${idmId},${acograph.idmId})" class="person-link-btn"><fmt:formatDate pattern="yyyy/MM/dd" value="${acograph.treatmentDt}"/></a>&nbsp;
					</td>
				</tr>
			</c:forEach>		
		</tbody>		
	</table>
	<table class="mini">
		<tr>
			<ehr:pagination-mini action="acographyMain.acographyList" />
		</tr>
	</table>
</div>

