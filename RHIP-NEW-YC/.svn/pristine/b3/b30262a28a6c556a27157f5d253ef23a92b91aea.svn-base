var addFilariasis = (function() {
    var validate=null;
	$(function() {
        initAdress();
        idmCommon.displayPaAddress();

    });

    function initAdress() {
        $("select[name='generalCondition.paGroup']").change(idmCommon.displayPaAddress);
        //地址三级不是必输项
        $("select[name='generalCondition.paGroup']").removeAttr("reg");
    }

    function returnSearch(){
        // if(contentChanged){
            layui.use('layer', function () {
                var layer = layui.layer;
                var index = layer.confirm('确认离开？', {icon:1, title:'确认提示'}, function (index) {
                    layer.close(index);
                    filRegSearch.searchRegister();
                    $("#register_top_all").show();
                    $("#registerDetailDiv").empty();
                    disableChangeConfirm();
                    return;
                });
            });
        // }else{
        //     filRegSearch.searchRegister();
        //     $("#register_top_all").show();
        //     $("#registerDetailDiv").empty();
        //     disableChangeConfirm();
        // }

    }

    function registerSubmit(type){
        disableChangeConfirm();
        var message = '';
        if('edit' == type){
            message = '修改';
        }
        if('add' == type){
            message = '保存';
        }
        var type = $("#type").val();
        validate = $("#registerForm").easyValidate();
        var result=validate.validateForm();
        if(!result){
            return;
        }
        $("#registerForm").submitFormGetJson({
            url : "/idm/filariasis/reg/saveRegister",
            wait : true,
            param : {
                type : type
            },
            callback : function(data) {
                if (data.indexOf("fail") > -1) {
                    layer.alert("登记"+message+"失败！", {icon:0,title:'提示'});
                }else {
					layui.use('layer', function(){
						    			var layer = layui.layer;
						    			var index = layer.alert("登记"+message+"成功！", {icon:0,title:'提示'}, function() {
						    				filRegSearch.searchRegister();
						 					$("#register_top_all").show();
                    						$("#registerDetailDiv").empty();
											layer.close(index);
						    			});
						    		});	
                    
                    return false;
                }
            },
            wait:true
        });
    }

    return {
        returnSearch:returnSearch,
        registerSubmit:registerSubmit
    };

})();
