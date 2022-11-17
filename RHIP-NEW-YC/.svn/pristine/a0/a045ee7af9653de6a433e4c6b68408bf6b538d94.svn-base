var findPassword = (function() {
	var checkAccountNameFlag=false;
	
	$(function() {
		checkTypeChange();
		if($('#msgcontent').val()!='')
			$('#msgdiv').show();
		/*------------------event---------------------- */
		$("#accountName").bind('blur',function(){
			checkAccountName($(this));
		}).bind('keydown',function(event){
			if(event.keyCode==13){
				checkAccountName($(this));
			}
		});
		
		$("#getCheckCodeByPhone").bind('click',function(){
            $("#td_phone_0").hide();
            $("#td_phone_1").show();
            $("#getCheckCodeByPhoneSend").text("发送中...");
            $("#getCheckCodeByPhoneSend").addClass("gbt-off").removeClass("gbt-orange");
			sendPhoneCheckCode();
			//倒计时短信禁用
			count=60;
			countdown = setInterval(show_timeSendPhone, 1000);
		});
		
		$("#getCheckCodeByEmail").bind('click',function(){
            $("#td_email_0").hide();
            $("#getCheckCodeByEmailSend").text("发送中...");
            $("#getCheckCodeByEmailSend").addClass("gbt-off").removeClass("gbt-orange");
            $("#td_email_1").show();
            sendEmailCheckCode();
			//倒计时短信禁用
			count=60;
			countdown = setInterval(show_timeSendEmail, 1000);
		});
	
	});
	/*------------------function---------------------- */
	function show_timeSendPhone(){ 
		$("#getCheckCodeByPhoneSend").text(count + " 秒后重发");
         if (count == 0) {
             $("#td_phone_1").hide();
        	 $("#getCheckCodeByPhone").text("重发");
             $("#td_phone_0").show();
             clearInterval(countdown);
         }
         count--;
	}
	function show_timeSendEmail(){ 
		$("#getCheckCodeByEmailSend").text(count + " 秒后重发");
         if (count == 0) {
             $("#td_email_1").hide();
             $("#getCheckCodeByEmail").text("重发");
             $("#td_email_0").show();
             clearInterval(countdown);
         }
         count--;
	}
	//发送验证码至手机
	function sendPhoneCheckCode(){
		$.getJsonByUrl({
			url : contextPath+"/regedit/checkCodeSendPhone",
			param : {
                accountName : $("#accountName").val(),
				realName : $("#realName").val(),
				telephone:$("#telephone_input").val()
			},
			callback : function(model) {
				if(model.rs){
					$("#code").val(model.code);
				}else{
					msgUtil.alert("短信发送失败");
				}
			}
		});
	}
	
	//发送验证码至email
	function sendEmailCheckCode(){
		$.getJsonByUrl({
			url : contextPath+"/regedit/checkCodeSendEmail",
			param : {
				accountName : $("#accountName").val(),
				email:$("#email_input").val()
			},
			callback : function(model) {
				if(model.rs){
					$("#code").val(model.code);
				}else{
					msgUtil.alert("邮件发送失败");
				}
			}
		});
	}
	//判断是否为空
	function isEmpty(str){
		if(null==str||""==str){
			return true;
		}
		return false;
	}
	function checkAccountName(obj){
		var value=obj.val();
		if(isEmpty(value)){
			$("#accountNameSpan").css("color","red").html("用户名不能为空!");
			return false;
		}
		$("#accountNameSpan").text("");
		return true;
		/*else{
			$.getJsonByUrl({
				url : contextPath+"/regedit/checkEmail",
				param : {
					accountName : $("#accountName").val()
				},
				callback : function(model) {
					if(model.success){
//						$("#accountNameSpan").css("color","green").html("√");//("请核对邮箱"+model.email);
//						$("#email").html(model.email);
						$("#accountNameSpan").html("");
						return true;
					}else{
						$("#accountNameSpan").css("color","red").html(model.msg);
						return false;
					}
				}
			});
		}*/
	}
	
	function checkCode(){
		if(isEmpty($("#checkCode").val())){
			$("#checkCodeSpan").css("color","red").text("验证码不能为空!");
			return false;
		}else{
			$("#checkCodeSpan").text("");
			return true;
		}
	}
	function commit(){
		if(!checkAccountNameFlag){
			msgUtil.alert("请输入正确的邮箱或用户名!");
			return;
		}
		$("#findPwdBt").val("提交中...");
		$("#findPwdBt").attr("disabled",true);
		$.getJsonByUrl({
			url : contextPath+"/regedit/commitFindPwd",
			param : {
				accountName : $("#accountName").val(),
				checkCode:$("#checkCode").val()
			},
			callback : function(model) {
				if(model.success){
					if(confirm(model.msg)){
						window.open(model.emailUrl);
					}else{
						window.location.href=contextPath+"/home/infoIndex";
					}
				}else{
					msgUtil.alert(model.msg);
					refresh($("#imageValidator"));
				}
//				$("#findPwdBt").val("提交");
				$("#findPwdBt").attr("disabled",false);
			}
		});
	}
	
	//找回密码步骤1
	function findPwdStep1(){
		//如果没有check提示，执行检查
		var accountRs=checkAccountName($('#accountName'));
		var codeRs=checkCode();
		if(!accountRs|!codeRs){
			return;
		}
		$("#findPwdBt").val("提交中...");
		$("#findPwdBt").attr("disabled",true);
		var subBut=$("#accountInfoForm");
		subBut.attr("action", contextPath+"/regedit/commitFindPwdStep1");
		subBut.submit();
	}
	
	function checkPhoneCode(){
		var phoneCode=$("#checkCodes").val();
		if(isEmpty(phoneCode)){
			$("#checkCodeSpan").css("color","red").text("验证码不能为空!");
			return false;
		}
		if(phoneCode.length!=6){
			$("#checkCodeSpan").css("color","red").text("请输入6位验证码!");
//			return false;
		}
			$("#checkCodeSpan").text("");
			return true;
	}
	//找回密码步骤2
	function findPwdStep2(){
		if(!checkPhoneCode())
			return;
		$("#findPwdBt").val("提交中...");
		$("#findPwdBt").attr("disabled",true);
		var subBut=$("#accountInfoForm");
		subBut.attr("action", contextPath+"/regedit/commitFindPwdStep2");
		subBut.submit();
	}
	
	function checkPassword(){
		var password=$("#password").val();
		var comfirm_password=$("#comfirm_password").val();
		if(isEmpty(password)){
			$("#passwordSpan").css("color","red").text("不能为空!");
			return false;
		}
		if(password.length<6||password.length>16){
			$("#passwordSpan").css("color","red").text("请输入6-16位数字及字符组成的密码!");
			return false;
		}
		if(isEmpty(comfirm_password)){
			$("#comfirm_passwordSpan").css("color","red").text("不能为空!");
			return false;
		}
		if(comfirm_password!=password){
			$("#comfirm_passwordSpan").css("color","red").text("必须和新密码一致!");
			return false;
		}
		return true;
	}
	//设置密码步骤3
	function findPwdStep3(){
		if(!checkPassword()){
			return;
		}
		$("#findPwdBt").val("提交中...");
		$("#findPwdBt").attr("disabled",true);
		var subBut=$("#accountInfoForm");
		subBut.attr("action", contextPath+"/regedit/commitFindPwdStep3");
		subBut.submit();
	}
	function checkTypeChange(){
		var typeVal=$("#checkType").val();
		if(typeVal=='1'){
			$("#tr_phone").show();
			$("#tr_email").hide();
		}
		if(typeVal=='2'){
			$("#tr_email").show();
			$("#tr_phone").hide();
		}
	}
	function returnStepOne(){
		var subBut=$("#accountInfoForm");
		subBut.attr("action", contextPath+"/accountInfo/toFindPwd");
		subBut.submit();
    };
	function back(){
		window.location.href=contextPath+"/home/infoIndex";
	}
	function refresh(obj) {
		$(obj).attr("src",contextPath+"/jsp/imageValidator.jsp?"+ Math.random());
	}
	return {
		back : back,
		commit:commit,
		findPwdStep1:findPwdStep1,
		findPwdStep2:findPwdStep2,
		findPwdStep3:findPwdStep3,
		returnStepOne:returnStepOne,
		checkTypeChange:checkTypeChange,
		refresh:refresh
	};
})();
