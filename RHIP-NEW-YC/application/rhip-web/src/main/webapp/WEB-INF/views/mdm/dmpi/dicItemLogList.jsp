<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<script type="text/javascript">
$(function() {
		$("td[name='operateTime']").each(function() {
			$(this).html(util.formatOperateTime($(this).html()));
		});
});
</script>
<div class="repeattable" style="width: 98%;margin-left: 5px;">
<table class="layui-table x-admin-sm-table-list-small">
	<thead>
	<tr>
		<th width="150px">操作时间</th>
		<th width="100px">操作者</th>
		<th width="100px">操作类型</th>
		<th width="120px">项目编码</th>
		<th width="140px">项目名称</th>
		<th width="50px">状态</th>
	</tr>
	</thead>
	<c:forEach items="${logList}" var="item" varStatus="status">
		<tr>
			<td name='operateTime'>${item.operateTime}</td>
			<td>${item.operator}</td>
			<td>${item.operateType}</td>
			<td>${item.itemCode}</td>
			<td>${item.itemName}</td>
			<td>
				<c:if test="${item.status eq -1}">作废</c:if>
				<c:if test="${item.status eq 1}">有效</c:if>
			</td>
		</tr>
	</c:forEach>
</table>
<table>
	<tr>
		<ehr:pagination action="dicItemSearch.searchLog" />
	</tr>
</table>
<input type="hidden" id="itemId_log" value="${itemId}" />
</div>