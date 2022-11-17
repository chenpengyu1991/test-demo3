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
		<!-- 
		<th width="50px">版本</th>
		 -->
		<th width="200px">描述</th>
		<th>操作</th>
	</tr>
	</thead>
	<c:forEach items="${dictionaryList}" var="dict" varStatus="status">
		<tr>
			<td>${dict.dicCode}</td>
			<td>${dict.dicName}</td>
			<td class="centertd">
				<c:forEach items="${categoryList}" var="category">
					<c:if test="${dict.categoryId eq category.itemCode}">
						${category.itemName}
					</c:if>
				</c:forEach>
			</td>
			<!-- 
			<td>${dict.version}</td>
			 -->
			<td>${dict.describe}</td>
			<td class="centertd">
				<%-- <a href="javascript:void(0);" onclick="downloadSearch.downLoadCurrent('${dict.dicCode}')">下载最新版</a>&nbsp; --%>
				<a href="javascript:void(0);" onclick="downloadSearch.downLoadCurrent('${dict.dicCode}')" title="下载最新版" class="layui-btn layui-btn-normal layui-btn-xs" style="color: #FFF;font-size: 12px;"><i class="layui-icon">&#xe601;</i>下载</a>&nbsp;&nbsp;
				<%-- <a href="javascript:void(0);" onclick="downloadSearch.viewImport('${dict.dicCode}')">导入字典</a> --%>
				<a href="javascript:void(0);" onclick="downloadSearch.viewImport('${dict.dicCode}')" title="导入字典" class="layui-btn layui-btn-xs" style="color: #FFF;font-size: 12px;"><i class="layui-icon">&#xe67d;</i>导入</a>
			</td>
		</tr>
	</c:forEach>
	<tr>
		<ehr:pagination action="downloadSearch.search" colspan="5"/>
	</tr>
</table>
<%-- <table>
	<tr>
		<ehr:pagination action="downloadSearch.search" />
	</tr>
</table> --%>
<input type="hidden" id="indexPage" value="${indexPage}" />
</div>