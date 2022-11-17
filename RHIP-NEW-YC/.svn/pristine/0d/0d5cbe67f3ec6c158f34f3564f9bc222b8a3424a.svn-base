var accountLogin = (function(){
	$(function () {
		$("#toLogin").click(function() {common.toLogin();});
		$("#login").click(function() {login();});
		$("#toRegister").click(function() {common.toRegister();});
		$("#toFindPwd").click(function() {common.toFindPwd();});
		
		$(".loginArea .select_showbox").click(function() {$(".select_option").show();})
        $("body").bind("click",function(evt){
			if(evt.target!=$('.select_showbox').get(0)) {
			$('.select_option').hide();
			}
		}); 
        $(".select_option li").click(function() {
        	$("#accountName").attr("value","");
        	$("#telephone").attr("value","");
        	$(".select_showbox span").text($(this).text());
        	$(".select_option li").removeClass("selected");
        	$(this).addClass("selected");
        	$(".select_option").hide();
        	
        	if ("telephone" == $(this).attr("val")) {
        		$("#telephone").show();
        		$("#accountName").hide();
        	} else {
        		$("#accountName").show();
        		$("#telephone").hide();
        	}
        });
	});

	function login() {
		$("#accountSpan").css("color", "red").html('');
		/*common.toBlockUI();*/
		$("#loading").show();
		$.getJsonByUrl({
			url : contextPath + "/accountInfo/login",
			param : {
				accountName : $("#accountName").val(),
				telephone : $("#telephone").val(),
				password:$("#password").val(),
				checkCode:$("#checkCode").val()
			},
			callback : function(model) {
				/*common.toUnBlockUI();*/
				$("#loading").hide();
				if(model.success){
					if(model.url == null){
						window.location.href = contextPath + "/home/infoIndex";
					} else  if(model.url ==  contextPath + "/userSpace/hotExpert/scheduleList"){ //热门专家从首页直接跳转到list页面时
						window.location.href =  contextPath + "/userSpace/hotExpert/search";
					} else  if(model.url == contextPath + "/accountInfo/toLogin"){  //登录页面直接跳转到首页
						window.location.href = contextPath + "/home/infoIndex";
					} else {
						window.location.href =  model.url;
					}
				}else{
					$("#accountSpan").css("color", "red").html(model.msg);
					refresh($("#imageValidator"));
				}
			}
		});
	}
	
	function refresh() {
		$("#imageValidator").attr("src",contextPath+"/jsp/imageValidator.jsp?code="+Math.random());
	}
})();