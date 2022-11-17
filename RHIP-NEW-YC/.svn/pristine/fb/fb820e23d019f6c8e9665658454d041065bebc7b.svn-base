<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<div class="repeattable" style="width: 218px; margin-left: 5px; margin-top: 17px;">
	<table id="evaluationList"  class="layui-table x-admin-sm-table-list-small">
		<colgroup>
			<col style="min-width:150px;"/>
		</colgroup>		
		<thead>
			<tr>
                <th>评估日期</th>				
			</tr>
		</thead>
		<tbody>
			<c:forEach var="evaluation" items="${plist}" varStatus="status">
				<tr onclick="evaluationMain.add('${statusId}', '${evaluation.id}')">
					<td>
						<fmt:formatDate pattern="yyyy/MM/dd" value="${evaluation.assessDt}"/>
					</td>
				</tr>
			</c:forEach>
		</tbody>		
	</table>
	<table class="mini">
		<tr>
			<ehr:pagination-mini action="evaluationMain.evaluationList" />
		</tr>
	</table>	
</div>

