var basic = (function() {	
	   //告知书倒计时关闭
		function coutdown(time) {
		    $("#countDown").text(time + "秒后自动关闭");
		    time--;
		    setTimeout(function() {
		        coutdown(time)
		    },
		    1000)
		}
	    $(function() {  
	    	if($("#informBook_isRead").val()!="1"&&$("#informBook_isOpen").val()=="1"){
	    		ds.dialog.tips( "<div id='ibContents' class='ib-contents'></div>"+ "<div id='countDown' class='count-down'></div>",$("#informBook_time").val(),true,true);
	        	$("#ibContents").append($("#informBook_contents").html());
	        	coutdown($("#informBook_time").val()); 
	        	var height = Math.max(document.documentElement.clientHeight, document.body.offsetHeight);
	        	$(".ds_dialog_content").css({  height: height*0.5 + 'px', overflow: 'scroll'});
	    	}	   	
	    });
function toSave(){
	var checkFlag = true;
	
	if (!checkEmail())
		checkFlag = false;
	
	if (!checkTelphone())
		checkFlag = false;
	if(checkFlag) {
		$("#basicInfoForm").submitFormGetJson({
			url : '/userSpace/ehr/basic/toSave',
			callback : function(modelMap){
				if(modelMap.success){
	//				if(confirm("恭喜,修改成功,已经提交到后台等待审核中....")){
					msgUtil.alert("保存成功!",function(){window.location.href = contextPath+"/userSpace/ehr/basic";});
					$('#save_btn').hide();$('#edit_btn').show();
				}
			}
		});
	}
}
function checkEmail() {
	//验证邮箱 地址
    var emailValue = $("#email").val();
	var flag = true;
	if(isEmpty(emailValue)) {
        $("#emailSpan").css("color", "red").html("邮箱地址不能为空!");
        flag = false;       
    } else {
    	var myreg = /^([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/;
		if (!myreg.test(emailValue)) {
			$("#emailSpan").css("color", "red").html("请输入有效的E_mail！");
			flag = false;
		}
	}
	return flag;
}

function checkTelphone() {
	//验证电话号码
	var teleValue = $("#telephone").val();
	var flag = true;
    if (isEmpty(teleValue)) {
        $("#telephoneSpan").css("color", "red").html("手机号码不能为空!");
        flag = false;
    } else {
        var mobile = /^0?(13[0-9]|15[0-9]|18[0-9]|14[57])[0-9]{8}$/;
        var phone = /(^(\d{2,4}[-_－—]?)?\d{3,8}([-_－—]?\d{3,8})?([-_－—]?\d{1,7})?$)|(^0?1[35]\d{9}$)/;
        if (!mobile.test(teleValue)) {
            $("#telephoneSpan").css("color", "red").html("请输入正确的手机号码!");
            flag = false;
        }
    }
    return flag;	
}
function toEdit() {
	$('#basicInfoShow').hide();$('#basicInfoEdit').show();$('#save_btn').show();$('#edit_btn').hide();
}
    return {
    	toSave:toSave,
    	toEdit:toEdit
    };
})();
