<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<%@ include file="../layouts/base.jsp"%>
<script type="text/javascript">
	var arry = "<%=request.getAttribute("data")%>";
	var manager = null;
	var data = eval("(" + arry + ")");
</script>
<script src="${pageContext.request.contextPath}/resources/js/role.js" type="text/javascript"></script>

<div class="section">
	<div class="titlebar">
		<div class="title">角色管理</div>
		<div class="toobar">
			<img src="${pageContext.request.contextPath}/resources/images/btn/back.png" /><span onclick="javascript:history.go(-1);">返回</span>
		</div>
	</div>
	<form id="roleFormId" name="roleForm" action="" method="post">
		<table class="formtable">
			<tr>
				<th style="width: 100px">角色名称</th>
				<td style="width: 30%"><input type="text" id="nameId" name="name" value="${role.name}" /></td>
				<th style="width: 100px">是否可用</th>
				<td><input type="radio" name="status" value="1" checked="checked" style="width: 20px;" />是 <input type="radio" name="status" value="0" style="width: 20px;" />否</td>
			</tr>
			<tr>
				<th>角色描述</th>
				<td colspan="3"><textarea rows="5" id="descriptionId" name="description">${role.description}</textarea></td>
			</tr>
			<tr>
				<th style="vertical-align: top; text-align: left;">权限设置</th>
				<td style="vertical-align: top; text-align: left;" colspan="3"><input type="button" style="width: 50px;" value="折叠" onclick='collapseAll()' /> <input type="button" style="width: 50px;" value="展开" onclick='expandAll()' />
					<ul id="tree1">
					</ul></td>
			</tr>
		</table>
		<div align="center">
			<input type="button" id="saveButtonId" name="save" value="保存" onclick="saveRole()" class="button" /> <input type="hidden" id="id" name="id" value="${role.id}" />
		</div>
	</form>
</div>
