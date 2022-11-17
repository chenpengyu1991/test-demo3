/*var regeditPage = (function(){*/
	$(function() {
		$("#toRegister").click(common.toRegister);
		$("#toFindPwd").click(common.toFindPwd);
		/*$("#btnSendCode").click(sendPhoneCheckCode);*/
		$("#nextStep").click(function() {
			insert();
		});
		$("#register").click(function() {
			registerStep2();
		});
		$("#btnToLogin").click(common.toLogin);
		$("#returnStepOne").click(returnStepOne);
		$("#btnSendCode").bind('click',function(){
			$("#accountInfoForm").submitFormGetJson({
				url : contextPath + "/accountInfo/eckCodeSendPhone",
				param : {
					realName:$("#realName").val(),
					telephone:$("#checkTelephone").val()
				},
				callback : function(model) {
					if(model.rs){
					}else{
						msgUtil.alert("短信发送失败");
					}
				}
			});
			//倒计时短信禁用
			count=60;
			countdown = setInterval(show_timeSendPhone, 1000);
		});
		
	});
	
	function show_timeSendPhone(){	
		$("#td_code_0").hide();
		$("#td_code_1").show();
		$("#sendingBtn").text(count + " 秒后重发");
         if (count == 0) {
        	 $("#td_code_1").hide();
     		 $("#td_code_0").show();
     		 $("#btnSendCode").text("重新发送");
             clearInterval(countdown);
         }
         count--;
	}
	
	//检验用户名
	function checkAccountName() {
		var value = $("#accountName").val();
		var flag = true;
		if (isEmpty(value)) {
			$("#accountNameSpan").css("color", "red").html("用户名不能为空!");
			flag =  false;
		} else if (value.length < 4 || value.length > 20) {
			$("#accountNameSpan").css("color", "red").html("用户名长度在4-20位字符之间!");
			flag =  false;
		}
		
		if (flag) {
			$.getJsonByUrl({
				async : false,
				url : contextPath + "/accountInfo/checkAccountName",
				param : {
					accountName : value
				},
				callback : function(model) {
					if (model.success) {
						$("#accountNameSpan").css("color", "green") .html("OK!");
						flag =  true;
					} else {
						$("#accountNameSpan").css("color", "red").html(model.msg);
						flag =  false;
					}
				}
			});
		}
		return flag;
	}
	
	//检验密码
	function checkPassword() {
		var value = $("#password").val();
		if (isEmpty(value)) {
			$("#passwordSpan").css("color", "red").html("密码不能为空!");
			return false;
		} else if (value.length < 8 || value.length > 30) {
			$("#passwordSpan").css("color", "red").html("必须由8~30位的英文字母、数字和字符组成，字母区分大小写");
			return false;
		} else if (!value.match(/^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{8,30}$/)) {
			$("#passwordSpan").css("color", "red").html("密码必须存在英文字母和数字！");
			return false;
		} else {
			$("#passwordSpan").css("color", "green").html("OK!");
			return true;
		}
	}
	
	//检验二次密码
	function ckeckSurepass() {
		var value = $("#surepass").val();
		if (isEmpty(value)) {
			$("#surepassSpan").css("color", "red").html("确认密码不能为空!");
			return false;
		} else if (value != $("#password").val()) {
			$("#surepassSpan").css("color", "red").html("两次输入密码不一致!");
			return false;
		} else {
			$("#surepassSpan").css("color", "green").html("OK!");
			return true;
		}
	}
	
	//检验真实姓名
	function checkRealName() {
		var value = $("#realName").val();
		if (isEmpty(value)) {
			$("#realNameSpan").css("color", "red").html("真实姓名不能为空!");
			return false;
		} else {
			$("#realNameSpan").css("color", "green").html("OK!");
			return true;
		}
	}
	
	//检验身份证
	function checkCardNo() {
		var value = $("#cardNo").val();
		var flag = true;
		var checkFlag = new clsIDCard(value);
		if (isEmpty(value)) {
			$("#cardNoSpan").css("color", "red").html("身份证不能为空!");
			flag = false;
		} else {
			if (!checkFlag.IsValid()) {
				$("#cardNoSpan").css("color", "red").html("输入的身份证号无效！");
				flag = false;
			}
		}
		
		if (flag) {
			$.getJsonByUrl({
				async : false,
				url : contextPath + "/accountInfo/checkCardNo",
				param : {
					cardNo : value
				},
				callback : function(model) {
					if (model.success) {
						$("#cardNoSpan").css("color", "green") .html("OK!");
						flag =  true;
					} else {
						$("#cardNoSpan").css("color", "red").html(model.msg);
						flag =  false;
					}
				}
			});
		}
		return flag;
	}
	
	//检验邮箱
	function checkExistEmail() {
		var value = $("#email").val();
		var flag = true;
		if(value!=""){
			var myreg = /^([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/;
			if (!myreg.test(value)) {
				$("#emailSpan").css("color", "red").html("请输入有效的E_mail！");
				flag = false;
			}
			if (flag) {
				$.getJsonByUrl({
					async : false,
					url : contextPath + "/accountInfo/checkExistEmail",
					param : {
						email : value
					},
					callback : function(model) {
						if (model.success) {
							$("#emailSpan").css("color", "green") .html("OK!");
							flag =  true;
						} else {
							$("#emailSpan").css("color", "red").html(model.msg);
							flag =  false;
						}
					}
				});
			}
		} else {
			$("#emailSpan").css("color", "green") .html("OK!");
			flag = true;
		}
		return flag;
	}
	
	//检验手机号码
	function checkTelephones() {
		var value = $("#telephone").val();
		var flag = true;
		if (isEmpty(value)) {
			$("#telephoneSpan").css("color", "red").html("手机号码不能为空!");
			flag = false;
		} else {
			var mobile = /^0?(13[0-9]|15[0-9]|18[0-9]|14[57])[0-9]{8}$/;
			if (!mobile.test(value)) {
				$("#telephoneSpan").css("color", "red").html("请输入正确的手机号码！");
				flag = false;
			}
		}
		
		if (flag) {
			$.getJsonByUrl({
				async : false,
				url : contextPath + "/accountInfo/checkPhoneNo",
				param : {
					telephone : value
				},
				callback : function(model) {
					if (model.success) {
						$("#telephoneSpan").css("color", "green") .html("OK!");
						flag = true;
					} else {
						$("#telephoneSpan").css("color", "red").html(model.msg);
						flag = false;
					}
				}
			});
		}
		return flag;
	}
	
	//检验验证码
	function validateCode() {
		var value = $("#checkCode").val();
		var flag = true;
		if (isEmpty(value)) {
			$("#checkCodeSpan").css("color", "red").html("验证码不能为空!");
			flag = false;
		}
		
		if (flag) {
			$.getJsonByUrl({
				async : false,
				url : contextPath + "/accountInfo/checkCode",
				param : {
					checkCode : value
				},
				callback : function(model) {
					if (model.success) {
						$("#checkCodeSpan").css("color", "green") .html("OK!");
						flag = true;
					} else {
						$("#checkCodeSpan").css("color", "red").html(model.msg);
						flag = false;
					}
				}
			});
		}
		return flag;
	}
	
	function refresh(obj) {
		$(obj).attr("src",contextPath+"/jsp/imageValidator.jsp?"+ Math.random());
	}
	
	// 判断是否为空
	function isEmpty(str) {
		if (null == str || "" == str) {
			return true;
		}
		return false;
	}
	
	function insert() {
		var checkFlag = true;

		if(!checkAccountName())
			checkFlag = false;
		
		if (!checkCardNo())
			checkFlag = false;

		if (!checkExistEmail())
			checkFlag = false;

		if (!checkTelephones())
			checkFlag = false;

		if (!checkPassword())
			checkFlag = false;

		if (!ckeckSurepass())
			checkFlag = false;

		if (!checkRealName())
			checkFlag = false;
		
		if (!validateCode())
			checkFlag = false;
		
		if(checkFlag){
			registerStep1();
		}
	}
	
	function registerStep1() {
		if(checkAccountName() && checkPassword() && ckeckSurepass() && checkRealName()
			&& checkCardNo() && checkExistEmail() && checkTelephones() && validateCode()) {
			$("#loading").show();
			$("#nextStep").attr("disabled", "true");
			$("#nextStep").val("请稍后！");
			$("#accountInfoForm").submitFormGetJson({
				url : contextPath + "/accountInfo/registerStep1",
				callback : function(model) {
					$("#loading").hide();
					if (model.success) {
						$("#step1").css("display","none");
						$("#step2").css("display","block");
						$("#step3").css("display","none");
						$("#checkTelephone").css("color", "red").val(model.telephone);
					}
				}
			});
			
		}
		
	}

	function registerStep2() {
		$("#loading").show();
		$("#accountInfoForm").submitFormGetJson({
			url : contextPath + "/accountInfo/registerStep2",
			callback : function(model) {
				$("#loading").hide();
				if (model.success) {
					$("#step1").css("display","none");
					$("#step2").css("display","none");
					$("#step3").css("display","block");
				} else {
					$("#registerCodeSpan").css("color", "red").html(model.msg);
				}
			}
		});
	}
	
	function returnStepOne() {
		$("#step1").css("display","block");
		$("#nextStep").removeAttr("disabled");
		$("#step2").css("display","none");
		$("#step3").css("display","none");
	}

	function returnStepTwo() {
		$("#step1").css("display","block");
		$("#step2").css("display","block");
		$("#step3").css("display","none");
	}
	//发送验证码到手机
	function sendPhoneCheckCode(){
		$("#accountInfoForm").submitFormGetJson({
			url : contextPath + "/accountInfo/eckCodeSendPhone",
			param : {
				telephone:$("#checkTelephone").val()
			},
			callback : function(model) {
				if(model.rs){
					msgUtil.alert("短信发送成功");
				}else{
					msgUtil.alert("短信发送失败");
				}
			}
		});
	}
	
	
/*})();*/
	/*

//注册timer处理函数
function SetRegisterRemainTime() {
   if (curCount == 0) {                
       window.clearInterval(InterValObj);//停止计时器
       $("#btnSendCode").removeAttr("disabled");//启用按钮
       $("#btnSendCode").val("重新发送验证码");
   }
   else {
       curCount--;
       $("#btnSendCode").val("请在" + curCount + "秒内输入验证码");
   }
}

//倒计时timer处理函数
function SetToLoginRemainTime() {
   if (count == 0) {                
       window.clearInterval(InterValObj);//停止计时器            
       window.location.href = contextPath+ "/accountInfo/toLogin";
   }
   else {
   	count--;
       $("#btnToLoginCode").val(+ count + "秒后自动跳转到登录页面！");
   }
}
function sendMessage() {
    $("#accountInfoForm").submitFormGetJson({
			url : contextPath + "/accountInfo/eckCodeSendPhone",
			callback : function(model) {
				if (model.success) {
					 $("#btnSendCode").attr("disabled", "true");
				     $("#btnSendCode").val("请在" + curCount + "秒内输入验证码");
				     InterValObj = window.setInterval(SetRegisterRemainTime, 1000); //启动计时器，1秒执行一次
				}
			}
		});
}*/
