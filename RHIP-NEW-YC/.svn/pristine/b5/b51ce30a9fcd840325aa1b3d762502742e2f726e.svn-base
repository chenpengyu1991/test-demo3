<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<div class="repeattable">
	<table class="layui-table x-admin-sm-table-list-small">
		<colgroup>
			<col style="width:150px;"/>
			<col style="width:100px;"/>
			<col style="width:100px;"/>
			<col style="width:100px;"/>
			<col style="width:150px;"/>						
		</colgroup>	
		<thead>
			<tr>
				<th>机构名称</th>
				<th>操作人姓名</th>
				<th>审批时间</th>
				<th>状态</th>
				<th >备注</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="approval" items="${approvalInfo.list}" varStatus="status">
				<tr>
					<td><ehr:tip>${approval.organName}</ehr:tip></td>
					<td><ehr:tip>${approval.userName}</ehr:tip></td>
					<td><fmt:formatDate value="${approval.approvalDate}" pattern="yyyy/MM/dd HH:mm" /></td>
					<td><ehr:dic dicmeta="MH00048" code="${approval.status}"/></td>
					<td>${approval.comments}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<table>
		<tr>
			<ehr:pagination action="approval.search" colspan="5" />
		</tr>
	</table>
</div>