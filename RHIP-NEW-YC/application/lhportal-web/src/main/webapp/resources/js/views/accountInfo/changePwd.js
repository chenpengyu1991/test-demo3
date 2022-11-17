var changePwd = (function(){
	var checkFlags = [ false, false, false ];

	$(function() {
		$("#password").change(function() {checkPassword($("#password"));});
		$("#newPassword").change(function() {ckeckNewPassword($("#newPassword"));});
		$("#newPasswordAgain").change(function() {ckeckNewPasswordAgain($("#newPasswordAgain"));});
		$("#changePwd").click(function() {doChangePwd();});
		$("#clear").click(clear);
		$("#toLogin").click(function() {window.location.href = contextPath+ "/accountInfo/toLogin";});
	});

	function doChangePwd() {
		
		var password =$("#password").val();
		var newPassword =$("#newPassword").val();
		var newPasswordAgain =$("#newPasswordAgain").val();
		if (isEmpty(password)) {
			$("#passwordSpan").css("color", "red").html("密码不能为空!");
			$("#password").focus();
			return;
		} else if (isEmpty(newPassword)) {
			$("#newPasswordSpan").css("color", "red").html("密码不能为空!");
			$("#newPassword").focus();
			return;
		} else if (isEmpty(newPasswordAgain)) {
			$("#newPasswordAgainSpan").css("color", "red").html("密码不能为空!");
			$("#newPasswordAgain").focus();
			return;
		}
		for ( var i = 0; i < checkFlags.length; i++) {
			if (!checkFlags[i]) {
				/*$("#messageSpan").css("color", "red").html("请完善信息!");*/
				return;
			}
		}
		$("#loading").show();
		$.getJsonByUrl({
			url : contextPath + "/accountInfo/changePwd",
			param : {
				"password" : password,
				"newPassword" : newPassword,
				"newPasswordAgain" : newPasswordAgain
			},
			callback : function(model) {
				$("#loading").hide();
				if (model.success) {
					$("#messageSpan").css("color", "red").html(model.msg);
					$("#changePwd").css("display","none");
					$("#clear").css("display","none");
					$("#toLogin").css("display","block");
					/*msgUtil.alert(model.msg,function(){window.location.href = contextPath+ "/accountInfo/toLogin";});*/
				} else {
					$("#messageSpan").css("color", "red").html(model.msg);
				}
			}
		});
	}

	// 判断是否为空
	function isEmpty(str) {
		if (null == str || "" == str) {
			return true;
		}
		return false;
	}
	function checkPassword(obj) {
		var value = $(obj).val();
		if (isEmpty(value)) {
			$("#passwordSpan").css("color", "red").html("密码不能为空!");
			checkFlags[0] = false;
			$(obj).focus();
		} else if (!isEmpty(value)) {
			$.getJsonByUrl({
				url : contextPath + "/accountInfo/checkPassword",
				param : {
					"password" : $("#password").val(),
				},
				callback : function(model) {
					if (model.fail) {
						$("#passwordSpan").css("color", "red").html(model.msg);
						checkFlags[0] = false;
						$(obj).focus();
					} else {
						$("#passwordSpan").empty();
						checkFlags[0] = true;
					}
				}
			});
		}
	}
	function ckeckNewPassword(obj) {
		var value = $(obj).val();
		if (isEmpty(value)) {
			$("#newPasswordSpan").css("color", "red").html("密码不能为空!");
			checkFlags[1] = false;
		} else if (value.length < 8 || value.length > 30) {
			$("#newPasswordSpan").css("color", "red").html(
					"必须由8~30位的英文字母、数字和字符组成，字母区分大小写");
			checkFlags[1] = false;
			$(obj).focus();
		}else if (!value.match(/^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{8,30}$/)) {
			$("#newPasswordSpan").css("color", "red").html(
				"密码必须存在英文字母和数字！");
			checkFlags[1] = false;
			$(obj).focus();
		} else {
			$("#newPasswordSpan").css("color", "red").html("");
			checkFlags[1] = true;
		}
	}
	function ckeckNewPasswordAgain(obj) {
		var value = $(obj).val();
		if (value != $("#newPassword").val()) {
			$("#newPasswordAgainSpan").css("color", "red").html("两次输入密码不一致!");
			checkFlags[2] = false;
		} else {
			$("#newPasswordAgainSpan").css("color", "red").html("");
			checkFlags[2] = true;
		}
	}
	function clear(){
		$(":password").each(function(){
			$(this).val("");
		});
	}

})();