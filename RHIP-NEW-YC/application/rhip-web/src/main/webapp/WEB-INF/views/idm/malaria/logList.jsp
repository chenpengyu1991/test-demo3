<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page import="com.founder.rhip.idm.common.ReportStatus" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<div class="repeattable">
	<table>
		<colgroup>
			<col style="width:200px;"/>
			<col style="width:100px;"/>
			<col style="width:100px;"/>
			<col style="width:100px;"/>
			<col style="width:200px;"/>							
		</colgroup>	
		<thead>
			<tr>
				<th>机构名称</th>
				<th>操作人姓名</th>
				<th>审批时间</th>
				<th>状态</th>
				<th>备注</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="approval" items="${ApprovalInfo.list}" varStatus="status">
				<tr>
					<td><ehr:tip><ehr:user userCode="${approval.userId}"/></ehr:tip></td>
					<td><ehr:tip>${approval.userName}</ehr:tip></td>
					<td><ehr:tip><fmt:formatDate value="${approval.approvalDate}" pattern="yyyy/MM/dd HH:mm" /></ehr:tip></td>
					<td><ehr:tip><ehr:dic dicmeta="IDM00259"  code="${approval.status}"/></ehr:tip></td>
					<td><ehr:tip>${approval.comments}</ehr:tip></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<table>
		<tr>
			<ehr:pagination action="malariaLog.searchLog"/>
		</tr>
	</table>
</div>