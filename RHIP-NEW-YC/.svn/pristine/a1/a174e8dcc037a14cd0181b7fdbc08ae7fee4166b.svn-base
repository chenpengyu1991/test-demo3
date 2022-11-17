<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<div class="repeattable">
<table class="layui-table x-admin-sm-table-list-middle">
	<thead>
	<tr>
		<th width="100px">编码</th>
		<th width="200px">名称</th>
		<th width="150px">分类</th>
		<th>描述</th>
		<th width="50px">状态</th>
		<th width="200px">操作</th>
	</tr>
	</thead>
	<c:forEach items="${dictionaryList}" var="dict" varStatus="status">
		<tr>
			<td><a href="javascript:void(0);" onclick="dictionarySearch.viewDicItems('${dict.dicCode}')">${dict.dicCode}</a></td>
			<td title="${dict.dicName}">${dict.dicName}</td>
			<td><ehr:dic items="${categoryList}" code="${dict.categoryId}" /></td>
			<td title="${dict.describe}">${dict.describe}</td>
			<td class="centertd">
				<a href="javascript:void(0);" onclick="dictionarySearch.changeStatus('${dict.dicCode}',${dict.status})">
					<c:if test="${dict.status eq -1}">作废</c:if>
					<c:if test="${dict.status eq 1}">有效</c:if>
				</a>
			</td>
			<td class="centertd">
				<%-- <a href="javascript:void(0);" onclick="dictionarySearch.editDicMate('${dict.dicCode}')">修改</a>&nbsp; --%>
				<a href="javascript:void(0);" onclick="dictionarySearch.editDicMate('${dict.dicCode}')" class="layui-btn layui-btn-xs" style="color: #FFF;font-size: 12px;" title="修改"><i class="layui-icon">&#xe642;</i>修改</a>&nbsp;
				<%-- <a href="javascript:void(0);" onclick="dictionarySearch.deleteDicMate('${dict.dicCode}')">删除</a>&nbsp; --%>
				<a href="javascript:void(0);" onclick="dictionarySearch.deleteDicMate('${dict.dicCode}')" class="layui-btn layui-btn-danger layui-btn-xs" style="color: #FFF;font-size: 12px;" title="删除"><i class="layui-icon">&#xe640;</i>删除</a>
				<!-- 
				<a href="javascript:void(0);" onclick="publishVersion('${dict.dicCode}')">发布新版本</a>
				 -->
			</td>
		</tr>
	</c:forEach>
	<tr>
		<ehr:pagination action="dictionarySearch.search" colspan="6"/>
	</tr>
</table>
<%-- <table>
	<tr>
		<ehr:pagination action="dictionarySearch.search" />
	</tr>
</table> --%>
<input type="hidden" id="indexPage" value="${indexPage}" />
</div>