<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<link href="${pageContext.request.contextPath}/resources/css/global.css"
	rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/resources/css/forms.css"
	rel="stylesheet" type="text/css" />
<link
	href="${pageContext.request.contextPath}/resources/css/control.css"
	rel="stylesheet" type="text/css" />
<script
	src="${pageContext.request.contextPath}/resources/js/jquery/jquery-1.7.js"
	type="text/javascript"></script>
<script
	src="${pageContext.request.contextPath}/resources/js/common.js"
	type="text/javascript"></script>
		
<script type="text/javascript">
	$(window.parent.document).ready(function() {
		$(window.parent.document)[0].title = 'ELB-菜单管理';
	});

	function delMenu() {
		if(!confirm("确认删除?"))return false;
		var menuIds = "";
		$(".chk_selectone:checked").each(function(){
			
			menuIds+=$(this).val()+",";
			
		});
		
		var path = "${pageContext.request.contextPath}/menu/delete/"+menuIds;
		window.location.href=path;
	}
	
	function detail(id) {
		var path = "${pageContext.request.contextPath}/menu/detail/"+id;
		window.location.href=path;
	}
	
	function createMenu() {
		var path = "${pageContext.request.contextPath}/menu/add";
		window.location.href=path;
		
	}
	
</script>

<div class="section">
	<div class="titlebar">
		<div class="title">菜单管理</div>
		
	</div>
	<form id="menuFormId" name="menuForm" action="" method="post">
		<table class="listTable">
			<tr>
				<th style="width:20px"><input type="checkbox" name="checkAll" class="chk_selectall"/></th>
				<th style="width:50px">编号</th>
				<th style="width:200px">菜单名</th>
				<th style="width:200px">状态</th>
				 
			</tr>
			<c:forEach var="menu" items="${menus}" varStatus="status">
				<tr>
					<td><input type="checkbox" name="check" class="chk_selectone" value="${menu.id}"/></td>
					<th><a href="javascript:;" onclick="javascript:detail(${menu.id })">${menu.id}</a></th>
					<td>${menu.nameZh}</td>
					<td>${menu.status}</td>  
				</tr>
			</c:forEach>
		</table>
	</form>
		
		<input type="button" value="新增" onclick="createMenu()" />
		<input type="button" value="删除" onclick="delMenu()" />
		
</div>
