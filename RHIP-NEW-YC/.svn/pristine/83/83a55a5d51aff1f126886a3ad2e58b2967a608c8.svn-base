/*var changePerInfo = (function(){*/
	var checkFlags = [ false, false];

	$(function() {
		$("#updatePerInfo").click(function() {
			$('input[name=telephone]').removeAttr("disabled");
			$('input[name=email]').removeAttr("disabled");
			$("#updatePerInfo").hide();
			$("#savePerInfo").show();
		});
		$("#savePerInfo").click(function() {savePerInfo();});
		
	});

	function savePerInfo() {
		var telephone =$("#telephone").val();
		var email =$("#email").val();
		checkTelephones();
		checkExistEmail();
		for ( var i = 0; i < checkFlags.length; i++) {
			if (!checkFlags[i]) {
				return;
			}
		}
		$("#loading").show();
		$.getJsonByUrl({
			url : contextPath + "/accountInfo/changePerInfo",
			param : {
				"telephone" : telephone,
				"email" : email,
			},
			callback : function(model) {
				$("#loading").hide();
				if (model.success) {
					$('input[name=telephone]').attr("disabled","disabled");
					$('input[name=email]').attr("disabled","disabled");
					$("#updatePerInfo").show();
					$("#savePerInfo").hide();
					msgUtil.alert(model.msg,function(){window.location.href = contextPath+ "/home/infoIndex";});
				} else {
					$("#messageSpan").css("color", "red").html(model.msg);
				}
			}
		});
	}


	//检验邮箱
	function checkExistEmail() {
		var value = $("#email").val();
		if(value!=""){
			var myreg = /^([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/;
			if (!myreg.test(value)) {
				$("#emailSpan").css("color", "red").html("请输入有效的E_mail！");
				checkFlags[1] = false;
			} else {
				checkFlags[1] = true;
			}
		} else {
			checkFlags[1] = true;
		}
	}
	
	//检验手机号码
	function checkTelephones() {
		var value = $("#telephone").val();
		if (isEmpty(value)) {
			$("#telephoneSpan").css("color", "red").html("手机号码不能为空!");
			checkFlags[0] = false;
		} else {
			var mobile = /^0?(13[0-9]|15[0-9]|18[0-9]|14[57])[0-9]{8}$/;
			if (!mobile.test(value)) {
				$("#telephoneSpan").css("color", "red").html("请输入正确的手机号码！");
				checkFlags[0] = false;
			} else {
				checkFlags[0] = true;
			}
		}
		
		if (checkFlags[0]) {
			$.getJsonByUrl({
				async : false,
				url : contextPath + "/accountInfo/checkPhoneNo",
				param : {
					telephone : value
				},
				callback : function(model) {
					if (model.success) {
						$("#telephoneSpan").css("color", "green") .html("OK!");
						checkFlags[0] = true;
					} else {
						$("#telephoneSpan").css("color", "red").html(model.msg);
						checkFlags[0] = false;
					}
				}
			});
		}
	}
	
	// 判断是否为空
	function isEmpty(str) {
		if (null == str || "" == str) {
			return true;
		}
		return false;
	}

/*})();*/