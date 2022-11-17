<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<div class="repeattable">
<table class="layui-table x-admin-sm-table-list-middle">
	<thead>
	<tr>
		<th width="25%">项目编码</th>
		<th width="25%">项目名称</th>
		<th width="25%">状态</th>
		<th>操作</th>
	</tr>
	</thead>
	<c:forEach items="${dicItemList}" var="item" varStatus="status">
		<tr>
			<td>${item.itemCode}</td>
			<td title="${item.itemName}">${item.itemName}</td>
			<td>
				<a href="javascript:void(0);" onclick="dicItemSearch.changeItemStatus(this, '${item.itemId}',${item.status})">
					<c:if test="${item.status eq -1}">作废</c:if>
					<c:if test="${item.status eq 1}">有效</c:if>
				</a>
			</td>
			<td>
				<%-- <a href="javascript:void(0);" onclick="dicItemSearch.editDicItem('${item.itemId}')">修改</a>&nbsp; --%>
				<a href="javascript:void(0);" onclick="dicItemSearch.editDicItem('${item.itemId}')" title="修改"><i class="layui-icon" style="color: #009688;">&#xe642;</i></a>&nbsp;&nbsp;
				<%-- <a href="javascript:void(0);" onclick="dicItemSearch.deleteDicItem('${item.itemId}')">删除</a>&nbsp; --%>
				<a href="javascript:void(0);" onclick="dicItemSearch.deleteDicItem('${item.itemId}')" title="删除"><i class="layui-icon" style="color: #FF5722;">&#xe640;</i></a>&nbsp;&nbsp;
				<%-- <a href="javascript:void(0);" onclick="dicItemSearch.showDicItemLogs('${item.itemId}')">变化跟踪</a> --%>
				<a href="javascript:void(0);" onclick="dicItemSearch.showDicItemLogs('${item.itemId}')" title="变化跟踪"><i class="layui-icon" style="color: #1E9FFF;">&#xe60e;</i></a>
			</td>
		</tr>
	</c:forEach>
</table>
<table>
	<tr>
		<ehr:pagination action="dicItemSearch.itemSearch" />
	</tr>
</table>
<input type="hidden" id="items_indexPage" value="${indexPage}" />
</div>