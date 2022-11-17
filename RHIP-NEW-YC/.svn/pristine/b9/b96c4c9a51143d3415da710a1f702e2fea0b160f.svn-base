/*var findPassword = (function(){*/
	var checkAccountNameFlag=false;

	$(function() {
		$("#accountName").change(function() {checkAccountName($(this));});
		$("#findPwdBt").click(commit);
		$("#back").click(back);
	});

	//判断是否为空
	function isEmpty(str) {
		if (null==str||""==str) {
			return true;
		}
		return false;
	}
	function checkEmail() {
		var value= $("#accountName").val();
		if (isEmpty(value)) {
			$("#accountNameSpan").css("color","red").html("邮箱或用户名不能为空!");
			return false;
		} else {
			$.getJsonByUrl({
				url : contextPath+"/accountInfo/checkEmail",
				param : {
					accountName : value
				},
				callback : function(model) {
					if(model.success) {
						$("#accountNameSpan").css("color","red").html("请核对邮箱"+model.email);
						checkAccountNameFlag=true;
					} else {
						$("#accountNameSpan").css("color","red").html(model.msg);
						checkAccountNameFlag=false;
					}
				}
			});
		}
	}
	function commit() {
		if (!checkAccountNameFlag) {
			$("#accountNameSpan").css("color","red").html("请输入正确的邮箱或用户名!");
			return;
		}
		$("#findPwdBt").val("请稍候...");
		$("#findPwdBt").attr("disabled",true);
		$.getJsonByUrl({
			url : contextPath+"/accountInfo/findPwd",
			param : {
				accountName : $("#accountName").val(),
				checkCode:$("#checkCode").val()
			},
			callback : function(model) {
				if (model.success) {
					if (confirm(model.msg)) {
						window.open(model.emailUrl);
						window.location.href=contextPath+"/accountInfo/toLogin";
					} else {
						window.location.href=contextPath+"/home/infoIndex";
					}
				} else {
					$("#checkCodeSpan").css("color","red").html(model.msg);
					refresh($("#imageValidator"));
				}
				$("#findPwdBt").val("提交");
				$("#findPwdBt").attr("disabled",false);
			}
		});
	}
	function back() {
		window.location.href=contextPath+"/home/infoIndex";
	}
	function refresh(obj) {
		$(obj).attr("src",contextPath+"/jsp/imageValidator.jsp?"+ Math.random());
	}

/*})();*/