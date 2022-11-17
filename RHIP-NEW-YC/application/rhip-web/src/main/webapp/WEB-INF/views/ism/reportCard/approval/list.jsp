<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page import="com.founder.rhip.idm.common.ReportStatus" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<div class="repeattable">
	<table>
		<colgroup>
			<col style="width:100px;"/>
			<col style="width:100px;"/>
			<col style="width:100px;"/>
			<col style="width:150px;"/>						
		</colgroup>	
		<thead>
			<tr>
				<th width="8%">操作人姓名</th>
				<th width="6%">审批时间</th>
				<th width="6%">状态</th>
				<th width="8%">备注</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="approval" items="${appDetailsList}">
				<tr>
					<td><ehr:user userCode='${approval.userId}'></ehr:user></td>
					<td><fmt:formatDate value="${approval.approvalDate}" pattern="yyyy/MM/dd" /></td>
					<td><ehr:dic dicmeta="DMD00005" code="${approval.status}"/></td>
					<td>${approval.comments}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>