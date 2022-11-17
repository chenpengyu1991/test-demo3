var updateSelf = (function() {

	$(function(){
		$("#saveUserSelfButId").click(function(e) {
			e.preventDefault();
			saveUser();
		});
		$("#savePasButId").click(function(e){
			e.preventDefault();
			savePassword();
		}
		);
	});

	function saveUser(){
        validate = $("#userSelfId").easyValidate();
        var result = validate.validateForm();
        if (!result) {
            return;
        }

		$("#userSelfId").submitFormGetJson({
			url:"/user/saveSelf",
			callback:function(data){
				if(data != 1){
					layer.alert(data, {icon:0,title:'提示'});
					return;
				}
				layer.alert("修改成功！", {icon:0,title:'提示'}, function() {
					var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
					parent.layer.close(index); //再执行关闭
    			});
                /*layer.alert("修改成功");
				$.removeDialog("updateSelfDialog");*/
			}
		});
	}
	
	function savePassword(){
		validate = $("#userPasswordId").easyValidate();
		var result = validate.validateForm();
		if (!result) {
			return;
		}
		$("#userPasswordId").submitFormGetJson({
			url:"/user/savePassword",
			callback:function(data){
				if(data != 1){
    				layer.alert(data);
    				return;
    			}
				layer.alert("修改成功！需要重新登录系统才能使用！", {icon:0,title:'提示'}, function() {
					var index = parent.layer.getFrameIndex(window.name);
					parent.layer.close(index);
    				top.location.href = contextPath + "/access/logout";
    			});
				
			}
		});
	}
	return{

	}
})();

