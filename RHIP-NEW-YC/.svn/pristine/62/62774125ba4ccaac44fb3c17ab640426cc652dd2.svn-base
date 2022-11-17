var transferMove = (function() {
	var validate=null;
	$(function() { 
		validate = $("#transferForm").easyValidate();
        init();
	});

    /**
     * 处置状态
     */
    function init(){
        var type = $("#typeId").val();
        //1是待纳入，4是取消
        if(type==1){
            $("#moveId1").show();
            $("#moveId2").hide();
            $("#moveId3").hide();
        }
        else if(type==4){
            $("#moveId1").hide();
            $("#moveId2").hide();
            $("#moveId3").show();
        }else{
            $("#moveId1").hide();
            $("#moveId2").show();
            $("#moveId3").hide();
        }
    }

	/*
	 * 迁移
	 * */
	function save(type){
    	var result=validate.validateForm();
    	if(!result){
    		return;
    	}
        var organCode = $("select[name='mhmOtherInfo.managementStation']").find(":selected").val();
        if(type == 1 && ($.isEmpty(organCode) || organCode == $("#currentOrganCode").val())){
        	layui.use('layer', function(){
    			var layer = layui.layer;
    			layer.alert("迁往服务站不能是空或者当前机构！", {icon:0,title:'提示'});
    		});
            return;
        }
		$("#transferForm").submitFormGetJson({
			url : "/mhm/patient/move/transfer",
			param : {type: type},
			callback : function(data) {
				if (data.indexOf("fail") > -1) {
					layui.use('layer', function(){
		    			var layer = layui.layer;
		    			layer.alert("迁出失败！", {icon:0,title:'提示'});
		    		});
                }else {
//                	mhmCommon.closePopUp('transferDialog');
                	mhmCommon.closeLayUiDialog();
                	layui.use('layer', function(){
		    			var layer = layui.layer;
		    			layer.alert(type=='1'?"迁出成功":(type=='4'?"取消成功":(type=='3'?"退回成功":(type=='5'?"重新迁出成功":"迁入成功")), {icon:0,title:'提示'}), function() {
		    				layer.closeAll();
		    				patientMoveSearch.searchPatientMove();
		    			});
		    		});
//                	msgUtil.alert(type=='1'?"迁出成功":(type=='4'?"取消成功":(type=='3'?"退回成功":(type=='5'?"重新迁出成功":"迁入成功"))));
//                    patientMoveSearch.searchPatientMove();
                }
			},
            wait:true
		});
  	
	}
	return {
		save:save
	};
})();