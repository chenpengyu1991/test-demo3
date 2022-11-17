<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<link href="${pageContext.request.contextPath}/resources/css/global.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/resources/css/forms.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/resources/css/control.css" rel="stylesheet" type="text/css" />

<script src="${pageContext.request.contextPath}/resources/js/jquery/jquery-1.7.js" type="text/javascript"></script>


<script type="text/javascript">
	$(window.parent.document).ready(function() {
		$(window.parent.document)[0].title = '修改密码';

	});
	function changePwd() {
		var newpwd = $("#newPassword").val();
		var confirmpwd = $("#confirmPwd").val();
		if (newpwd != confirmpwd) {
			alert("两次密码不统一");
			return;
		}
		var form = document.getElementById('userFormId');
		form.action = "${pageContext.request.contextPath}/user/updatepwd/"
				+ newpwd;
		form.submit();
	}
</script>


<div class="section">
	<div class="titlebar">
		<div class="title">新增用户</div>
		<div class="toobar">
			<img src="${pageContext.request.contextPath}/resources/images/btn/back.png" /><span onclick="javascript:history.go(-1);">返回</span>
		</div>
	</div>
	<form id="userFormId" name="userForm" action="" method="post">
		<table class="formTable">
			<tr>
				<th style="width: 100px">旧密码</th>
				<td><input type="text" id="password" name="password" /></td>
			</tr>
			<tr>
				<th style="width: 100px">新密码</th>
				<td><input type="text" id="newPassword" name="newPassword" /></td>
			</tr>
			<tr>
				<th style="width: 100px">确认密码</th>
				<td><input type="text" id="confirmPwd" name="confirmPwd" /></td>
			</tr>
			<tr>
				<td colspan="2" style="text-align: center">
					<button onclick="changePwd()">提交</button>
				</td>
			</tr>
		</table>
		${message}
	</form>
</div>
