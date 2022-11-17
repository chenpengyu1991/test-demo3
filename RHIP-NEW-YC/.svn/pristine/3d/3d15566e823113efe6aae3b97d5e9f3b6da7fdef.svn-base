<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/WEB-INF/tld/elb-tag.tld" prefix="elb"%>
<%@ include file="../layouts/base.jsp"%>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<script src="${pageContext.request.contextPath}/resources/js/user.js"type="text/javascript"></script>
</head>
<body>
	<div class="section">
		<div class="header">
			<div class="title">用户管理 — 查询</div>
			<a class="pucker" href="#"></a><a href="#" onclick="searchUser(1)">查询</a>
		</div>
		<div class="content">
			<table class="formtable">
				<colgroup span="2" width="25%"><col width="40" /><col /></colgroup>
				<colgroup span="2" width="25%"><col width="40" /><col /></colgroup>
				<colgroup span="2" width="25%"><col width="65" /><col /></colgroup>
				<colgroup span="2" width="25%"><col width="65" /><col /></colgroup>
				<tr>
					<th>姓名:</th>
					<td><input type="text" id="sName" name="name" value="${user.name}" /></td>
					<th>性别:</th>
					<td><select id="gender" name="gender"><option value="">请选择</option><option value="1" <c:if test="${user.gender==1}"> selected="selected" </c:if>> 男</option><option value="0"<c:if test="${user.gender==0}"> selected="selected" </c:if>>女</option></select></td>
					<th>固定电话:</th>
					<td><input type="text" id="sTelephone" name="telephone" value="${user.telephone}" /></td>
					<th>电子邮箱:</th>				
					<td><input type="text" id="sEmail" name="email" value="${user.email}" /></td>
				</tr>
				<tr>	
					<th>用户:</th>
					<td><input type="text" id="sUserName" name="userName" value="${user.userName}" /></td>
					<th>状态:</th>
					<td><select id="status" name="status"><option value="">请选择</option><option value="1"<c:if test="${user.status==1}"> selected="selected" </c:if>>启用</option><option value="0"<c:if test="${user.status==0}"> selected="selected" </c:if>>禁用</option></select></td>
					<th>手机号码:</th>
					<td><input type="text" id="sMobile" name="mobile" value="${user.mobile}" /></td>
					<th>联系地址:</th>
					<td><input type="text" id="sHomeAddress" name="homeAddress" value="${user.homeAddress}" /></td>	
				</tr>				
			</table>
		</div>
	</div>

	<div class="section">
		<div class="header">
			<div class="title">用户管理 — 列表</div>
			<a class="pucker" href="#"></a>
			<a href="#" onclick="statusChange(0)">禁用</a>
			<a href="#" onclick="statusChange(1)">启用</a>
			<a href="#" onclick="delUser()">删除</a>
			<a href="#" onclick="addUser()">新增</a>
			<a href="#" onclick="roleSet()">权限</a>
		</div>
		<div class="content">
			<form id="userFormId" name="userForm" action="" method="post">
				<table class="repeattable">
					<thead>
						<tr>
							<th style="width: 20px"><input type="checkbox" name="checkAll" class="chk_selectall" /></th>
							<th style="width: 30px">编号</th>
							<th style="width: 100px">用户名</th>
							<th style="width: 150px">姓名</th>
							<th style="width: 70px">性别</th>
							<th style="width: 150px">Email</th>
							<th style="width: 120px">固定电话</th>
							<th style="width: 120px">手机</th>
							<th>地址</th>
							<th style="width: 70px">状态</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${collection}" var="varName">
							<tr>
								<th><input type="checkbox" name="check" class="chk_selectone" value="${varName.id}" /></th>
								<th>${varName.id}</th>
								<td><a href="javascript:viewDetail(${varName.id})">${varName.userName}</a></td>
								<td>${varName.name}</td>
								<td>${varName.gender==1?'男':'女'}</td>
								<td>${varName.email}</td>
								<td>${varName.telephone}</td>
								<td>${varName.mobile}</td>
								<td>${varName.homeAddress}</td>
								<td>${varName.status==1?'启用':'禁用'}</td>
							</tr>
						</c:forEach>
						<tr>
							
						</tr>
					</tbody>
				</table>
				<elb:pager action="searchUser" />
			</form>
		</div>
	</div>
</body>
</html>