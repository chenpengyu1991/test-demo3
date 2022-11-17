<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<div class="repeattable">
	<form id="InoculationAppointmentParamForm">
		<table style="width: 100%;float: left;">
			<thead>
				<tr>
					<th rowspan="2" style="width: 40%;">预约机构</th>
					<th  style="width: 60%;"><c:out value="${year}"/>年HPV预约接种上限人数统计情况</th>
				</tr>
				<tr>
				    <th class="zimu">HPV预约接种上限人数</th>	
				</tr>
			</thead>
			<tbody id="displayBody">
				<c:forEach items="${orgList}" var="org">
	  				<tr>
	  					<td style="text-align: left;"><c:out value="${org.organName}"/></td>
	  					<td style="text-align: center;"><c:out value="${org.countNum}"/></td>
	  				</tr>
	  			</c:forEach>
			</tbody>
			<tbody id="editBody" style="display: none;">
				<c:forEach items="${orgList}" var="org" varStatus="status">
	  				<tr>
	  					<td style="display: none;">
	  						<input type="hidden" name="InoculationAppointmentParams[${status.index}].id"          value="${org.id}">
	  						<input type="hidden" name="InoculationAppointmentParams[${status.index}].organCode"   value="${org.organCode}">
	  						<input type="hidden" name="InoculationAppointmentParams[${status.index}].countYear"   value="${org.countYear}">
	  						<input type="hidden" name="InoculationAppointmentParams[${status.index}].organName"   value="${org.organName}">
	  					</td>
	  					<td style="text-align: left;"><c:out value="${org.organName}"/></td>
	  					<td style="text-align: center;"><tag:numberInput maxlength="9" name="InoculationAppointmentParams[${status.index}].countNum"   value="${org.countNum}"/></td>
	  				</tr>
	  			</c:forEach>
			</tbody>
		</table>
	</form>
</div>

