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
<div class="repeattable" style="width: 98.5%;margin-left: 3px;">
<table class="layui-table x-admin-sm-table-list-small">
	<thead>
	<tr>
		<th width="150px">操作时间</th>
		<th width="100px">操作者</th>
		<th width="100px">操作类型</th>
		<th width="100px">科室编码</th>
		<th width="100px">科室名称</th>
		<th >电话</th>
	</tr>
	</thead>
	<c:forEach items="${logList}" var="dept" varStatus="status">
		<tr>
			<td name="operateTime" >${dept.operateTime}</td>
			<td>${dept.operator}</td>
			<td>${dept.operateType}</td>
			<td>${dept.deptCode}</td>
			<td>${dept.deptName}</td>
			<td>${dept.tel}</td>
		</tr>
	</c:forEach>
</table>
<table>
	<tr>
		<ehr:pagination action="departmentSearch.searchLog" />
	</tr>
</table>
<input type="hidden" id="deptId_log" value="${deptId}" />
</div>