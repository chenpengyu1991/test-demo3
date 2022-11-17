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
		$(window.parent.document)[0].title = 'IDS-创建菜单';
	});

	function saveMenu() {
		var form = document.getElementById('menuFormId');
		form.action = "${pageContext.request.contextPath}/menu/save";
		form.submit();
	}
	
	
</script>

<div class="section">
	<div class="titlebar">
		<div class="title"></div>
		<div class="toobar"></div>
	</div>
	
	<form id="menuFormId" name="menuForm" action="" method="post">
		<table class="formtable">
			<tr>
				<th style="width: 100px">PARENT_CODE</th>
				<td><input type="text" id="parentCode" name="parentId" />
				</td>
				<th style="width: 100px">DEPTH</th>				
				<td><input type="text" id="depth" name="depth" />
				</td>
				<th style="width: 100px">IS_PARENT</th>				
				<td><input type="text" id="isParent" name="isParent" />
				</td>
			</tr>
			
			<tr>
				<th style="width: 100px">CODE</th>				
				<td><input type="text" id="code" name="code" />
				</td>
				<th style="width: 100px">NAME_ZH</th>				
				<td><input type="text" id="nameZh" name="nameZh" />
				</td>
				<th style="width: 100px">NAME_EN</th>				
				<td><input type="text" id="nameEn" name="nameEn" />
				</td>
			</tr>
			
			<tr>
				<th style="width: 100px">PATH</th>				
				<td><input type="text" id="path" name="path" />
				</td>
				<th style="width: 100px">STATUS</th>				
				<td><input type="text" id="status" name="status" />
				</td>
				<th style="width: 100px">FLAG</th>				
				<td><input type="text" id="flag" name="flag" />
				</td>
			</tr>
			
		</table>
		<input type="button" id="saveButtonId" name="save" value="保存"	onclick="saveMenu()" class="button" />
		
	</form>
	${message}

</div>
