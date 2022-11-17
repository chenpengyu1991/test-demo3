<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<div class="repeattable" style="width: 260px; margin-left: 5px; margin-top: 17px;">
	<table id="followUpList" class="layui-table x-admin-sm-table-list-small">
		<colgroup>
			<col style="min-width:100px;"/>
			<col style="min-width:100px;"/>
			<col style="min-width:60px;"/>
		</colgroup>		
		<thead>
			<tr>
				<th>随访机构</th>	
                <th>随访日期</th>	
                <th>审核状态</th>			
			</tr>
		</thead>
		<tbody>
			<c:forEach var="followUp" items="${followUplist}" varStatus="status">
				<tr onclick="followUpMain.add(${followUp.eventId})">
					<td><ehr:tip><ehr:org code="${followUp.fillOrganCode}"/></ehr:tip></td>				
					<td>
						<input type="hidden" id="eventTrId" value="${followUp.eventId}">
						<%--<a href="javascript:void(0)" onclick="followUpMain.add(${followUp.eventId})" class="person-link-btn"><fmt:formatDate pattern="yyyy/MM/dd" value="${followUp.followupDt}"/></a>&nbsp;--%>
                        <fmt:formatDate pattern="yyyy/MM/dd" value="${followUp.followupDt}"/>
                    </td>
                    <td  class="centertd"><ehr:dic dicmeta="MH00055" code="${followUp.followupStatus}"/></td>
				</tr>
			</c:forEach>
		</tbody>		
	</table>
	<table class="mini">
		<tr>
			<ehr:pagination-mini action="followUpMain.followUpList" />
		</tr>
	</table>	
</div>

