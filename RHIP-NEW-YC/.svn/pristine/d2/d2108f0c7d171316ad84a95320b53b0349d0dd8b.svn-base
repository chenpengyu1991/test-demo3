<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<div class="repeattable" style="vertical-align: top; width: 240px; margin-left: 10px; margin-top: 105px;">
	<table id="medicalList" class="layui-table x-admin-sm-table-list-small">
		<colgroup>
			<col style="min-width:100px; width: 35%;"/>
			<col style="min-width:140px; width: 65%;"/>
		</colgroup>		
		<thead>
			<tr>
                <th>体检日期</th>	
                <th>体检机构</th>				
			</tr>
		</thead>
		<tbody>
			<c:forEach var="medical" items="${medicallist}" varStatus="status">
				<tr onclick="medicalMain.addMedical(${idmId},${medical.idmId})">
					<td  class="centertd">
						<input type="hidden" id="singleTrId" value="${medical.idmId}">
						<a href="javascript:void(0)" onclick="medicalMain.addMedical(${idmId},${medical.idmId})" class="person-link-btn"><fmt:formatDate pattern="yyyy/MM/dd" value="${medical.reportDate}"/></a>&nbsp;
					</td>
					<td  class="centertd">
						<ehr:tip><ehr:org code="${medical.surveyOrg}"/></ehr:tip>
					</td>					
				</tr>
			</c:forEach>		
		</tbody>		
	</table>
	<table class="mini">
		<tr>
			<ehr:pagination-mini action="medicalMain.medicalList" />
		</tr>
	</table>	
</div>

