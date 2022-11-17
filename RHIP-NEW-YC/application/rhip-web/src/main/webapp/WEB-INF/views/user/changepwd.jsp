<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<script type="text/javascript">
	/* $(window.parent.document).ready(function() {
		$(window.parent.document)[0].title = '修改密码';

	}); */
	
	function initFun(){
		
	}
	
	function errmsg(msg,newmsg){
		if(msg == ""){
			return newmsg;
		}else{
			return msg + "<br/>" + newmsg;
		}
	}
	
	function changePwd() {
		$("#msgOK2").hide();
		$("#msgError2").hide();
		
		var oldpassword = $("#password").val();
		var newpwd = $("#newPassword").val();
		var confirmpwd = $("#confirmPwd").val();
		
		var flag = false;
		var errorMSg = "";
		
		if(oldpassword == ""){
			errorMSg = errmsg(errorMSg,"请输入旧密码！");
			flag = true;
		}
		
		if(newpwd == ""){
			errorMSg = errmsg(errorMSg,"请输入新密码！");
			flag = true;
		}
		
		if(confirmpwd == ""){
			errorMSg = errmsg(errorMSg,"请输入确认密码！");
			flag = true;
		}
		if (newpwd != confirmpwd) {
			errorMSg = errmsg(errorMSg,"确认密码和新密码不一致！");
			flag = true;
		}
		
		if(flag){
			$("#msgError").show();
			$("#msgError").html(errorMSg);
			$("#msgOK2").hide();
			return;
		}
		/* var form = document.getElementById('userFormId');
		form.action = "${pageContext.request.contextPath}/user/updatepwd/"
				+ newpwd;
		form.submit(); */
		postAjax("/user/updatepwd", "userFormId",
				function(){
					$("#msgError").hide();
					$("#msgOK2").show();
					$("#msgOK2").html("修改成功");
				},
				function(){
			
				},
				function(data){
					$("#msgOK2").hide();
					$("#msgError").show();
					$("#msgError").html(" "+data.error);
				});
		
	}
</script>

<%-- <c:if test="${message gt 0}">
	<div class="msgOK" id="msgOK2">
    	修改成功！
   	</div>
</c:if>
<c:if test="${message eq 0}">
	<div class="msgError" id="msgError2">
		旧密码不对，修改失败
		</div>
</c:if> --%>
<div class="msgError" id="msgError" style="display: none"></div>
<div class="msgOK" id="msgOK2" style="display: none"></div>
<div class="section">
	<div class="titlebar">
		<div class="title">修改密码</div>
		<div class="toobar">
			<img src="${pageContext.request.contextPath}/images/btn/back.png" /><span onclick="goHome()">返回</span>
		</div>
	</div>
	<form id="userFormId" name="userForm" action="" method="post">
		<table class="formtable">
			<tr>
				<th style="width: 100px"><label class="required">旧密码</label></th>
				<td><input type="password" id="password" name="password" /></td>
			</tr>
			<tr>
				<th style="width: 100px"><label class="required">新密码</label></th>
				<td><input type="password" id="newPassword" name="newPassword" /></td>
			</tr>
			<tr>
				<th style="width: 100px"><label class="required">确认密码</label></th>
				<td><input type="password" id="confirmPwd" name="confirmPwd" /></td>
			</tr>
			<tr>
				<td colspan="2" style="text-align: center">
					<!-- <button onclick="changePwd()" class="btnopr"/> -->
					<input type="button" onclick="changePwd()" class="btnopr" value="保 存">
				</td>
			</tr>
		</table>
	</form>
</div>
