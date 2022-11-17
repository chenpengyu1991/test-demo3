<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<div class="repeattable">
<table class="layui-table x-admin-sm-table-list-middle">
	<thead>
	<tr>
		<th width="60px">机构名称</th>
		<th width="60px">科室编码</th>
		<th width="60px">科室名称</th>
		<th width="30px">电话</th>
		<th width="60px">操作</th>
	</tr>
	</thead>
	<c:forEach items="${deptList}" var="dept" varStatus="status">
		<tr>
			<td><ehr:org code="${dept.organCode}" /></td>
			<td>${dept.deptCode}</td>
			<td title="${dept.deptName}">${dept.deptName}</td>
			<td class="centertd">${dept.tel}</td>
			<td class="centertd">
				<%-- <a href="javascript:void(0);" onclick="departmentSearch.edit('${dept.deptId}')">修改</a>&nbsp; --%>
				<a href="javascript:void(0);" onclick="departmentSearch.edit('${dept.deptId}')" title="修改"><i class="layui-icon">&#xe642;</i></a>&nbsp;
				<%-- <a href="javascript:void(0);" onclick="departmentSearch.remove('${dept.deptId}')">删除</a>&nbsp; --%>
				<a href="javascript:void(0);" onclick="departmentSearch.remove('${dept.deptId}')" title="删除"><i class="layui-icon">&#xe640;</i></a>&nbsp;
				<%-- <a href="javascript:void(0);" onclick="departmentSearch.showLogs('${dept.deptId}')">变化跟踪</a> --%>
				<a href="javascript:void(0);" onclick="departmentSearch.showLogs('${dept.deptId}')" title="变化跟踪"><i class="layui-icon">&#xe60e;</i></a>
			</td>
		</tr>
	</c:forEach>
	<tr>
		<ehr:pagination action="departmentSearch.search" colspan="5"/>
	</tr>
</table>
<%-- <table>
	<tr>
		<ehr:pagination action="departmentSearch.search" />
	</tr>
</table> --%>
<input type="hidden" id="indexPage" value="${indexPage}" />
</div>