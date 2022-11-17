<%@ page language="java" contentType="text/html; charset=UTF-8"%>
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

<script type="text/javascript">
	$(window.parent.document).ready(function() {
		$(window.parent.document)[0].title = 'ELB-角色添加';
	});
	
	function saveRole() {
		var form = document.getElementById('roleFormId');
		form.action = "${pageContext.request.contextPath}/role/save";
		form.submit();
	} 
</script>

<div class="section">
	<div class="titlebar">
		<div class="title">菜单详细</div>
		<div class="toobar"></div>
	</div>
	<table>
	<form id="menuFormId" name="MenuForm" action="" method="post">	
	
	<tr>
			<td>当前菜单ID</td>
			<td>父类菜单ID</td>
			<td>层次</td>
			<td>是否为父菜单</td>
			<td>编码</td>
			<td>中文标题</td>
			<td>英文标题</td>
			<td>路径</td>
			<td>主题</td>
			<td>状态</td>
			<td>权限控制标志</td>
			
	</tr>
	<tr>
			<td>${menu.id}</td>
			<td>${menu.nameZh}</td>
			<td>${menu.depth}</td>
			<td>${menu.isParent}</td>
			<td>${menu.code}</td>
			<td>${menu.nameZh}</td>
			<td>${menu.nameEn}</td>
			<td>${menu.path}</td>
			<td>${menu.theme}</td>
			<td>${menu.status}</td>
			<td>${menu.flag}</td>
	</tr>
	</table>
	</form>
</div>