<%@ page language="java" contentType="text/html; charset=UTF-8"%> 
<%@ taglib uri="/WEB-INF/tld/elb-tag.tld" prefix="elb"%>  

<%@ include file="../layouts/base.jsp"%>
<script src="${pageContext.request.contextPath}/resources/js/role.js" type="text/javascript"></script>
 
<div class="section">
	<div class="titlebar">
		<div class="title">角色管理</div>
		<div class="toobar">
			<span onclick="goToAdd()"><img src="${pageContext.request.contextPath}/resources/images/btn/add.png" />新增</span>
		</div>
	</div>
	<form id="roleFormId" name="roleForm" action="" method="post">
		<table class="repeattable">
			<thead>
				<tr>
					<th colspan="2"><img src="${pageContext.request.contextPath}/resources/images/btn/search.png" onclick="search(1)" class="pointer" /></th>
					<th><input type="text" id="sName" name="name" /></th>
					<th><input type="text" id="sDescription" name="description" /></th>
				</tr>
				<tr>
					<th style="width: 20px"><input type="checkbox" name="checkAll" class="chk_selectall" /></th>
					<th style="width: 30px">编号</th>
					<th style="width: 200px">角色</th>
					<th>描述</th>
				</tr>
			</thead>
			<tbody> 
				<c:forEach var="role" items="${roles}" varStatus="status">
					<tr>
						<th><input type="checkbox" name="check" class="chk_selectone" value="${role.id}" /></th>
						<th>${role.id }</th>
						<td><a href="javascript:;" onclick="javascript:detail(${role.id })">${role.name}</a></td>
						<td>${role.description}</td>
					</tr>
				</c:forEach> 
			</tbody> 
		</table>
		<elb:pager action="search"/>
	</form>
</div>
