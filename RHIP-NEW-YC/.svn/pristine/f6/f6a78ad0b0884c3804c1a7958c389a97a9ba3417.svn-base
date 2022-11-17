<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<div class="repeattable" style="vertical-align: top; width: 300px; margin-left: 10px; margin-top: 70px;">
	<table id="reexamineList" class="layui-table x-admin-sm-table-list-small">
		<colgroup>
			<col style="min-width:100px; width: 50%;"/>
			<col style="min-width:100px; width: 50%;"/>
		</colgroup>		
		<thead>
			<tr>
				<th>复查人</th>
                <th>复查日期</th>				
			</tr>
		</thead>
		<tbody>
			<c:forEach var="reexamine" items="${reexaminelist}" varStatus="status">
				<tr onclick="reexamineMain.addReexamine(${idmId},${reexamine.idmId})" >
					<td>
						<input type="hidden" id="singleTrId" value="${reexamine.idmId}">
						<ehr:tip><ehr:user userCode="${reexamine.respondents}"/></ehr:tip>
					</td>
					<td>
						<a href="javascript:void(0)" onclick="reexamineMain.addReexamine(${idmId},${reexamine.idmId})" class="person-link-btn"><fmt:formatDate pattern="yyyy/MM/dd" value="${reexamine.surveyDate}"/></a>&nbsp;
					</td>
				</tr>
			</c:forEach>	
			<tr class="mini">
			<ehr:pagination-mini action="reexamineMain.reexamineList" colspan="2" />
			</tr>	
		</tbody>		
	</table>
	<%-- <table class="mini">
		<tr>
			<ehr:pagination-mini action="reexamineMain.reexamineList" />
		</tr>
	</table> --%>	
</div>

