<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<script type="text/javascript">
$(function() {
		$("span[name='operateTime']").each(function() {
			$(this).html(util.formatOperateTime($(this).html()));
		});
		
});
</script>
<div class="repeattable" style="width: 98%;margin: 5px;">
<table class="layui-table x-admin-sm-table-list-small">
	<thead>
	<tr>
		<th width="80px">操作时间</th>
		<th width="50px">操作者</th>
		<th width="70px">操作类型</th>
		<th width="150px">操作详情</th>
	</tr>
	</thead>
	<c:forEach items="${logList}" var="organ" varStatus="status">
		<tr>
			<td><span name="operateTime" onclick="organizationSearch.viewlog('${organ.organId}','${organ.operateTime}')" title="点击查看详情">${organ.operateTime}</span></td>
			<td>${organ.operator}</td>
			<td>${organ.operateType}</td>
			<td>${organ.operateDetail}</td>
		</tr>
	</c:forEach>
	<tr>
		<ehr:pagination action="showLogs" colspan="4"/>
	</tr>
</table>
<%-- <table>
	<tr>
		<ehr:pagination action="organizationSearch.searchLog" />
	</tr>
</table> --%>
<input type="hidden" id="organId_log" value="${organId}" />
</div>