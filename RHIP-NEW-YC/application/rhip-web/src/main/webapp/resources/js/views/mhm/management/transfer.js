var transfer = (function() {
	var validate=null;
	$(function() { 
		validate = $("#transferForm").easyValidate();
		transferType();//迁出、纳入
	});
	
	function transferType(){
		debugger;
		var type = $('#typeId').val();
		if(type == '2'){
			$('#transferNameId').text('迁出社区');
			$('#transferBtn').val('纳入');
		}
	}
	/*
	 * 迁移
	 * */
	function save(){
    	var result=validate.validateForm();
    	if(!result){
    		return;
    	}
		$("#transferForm").submitFormGetJson({
			url : "/mhm/management/transfer",
			param : {},
			callback : function(data) {
				if (data.indexOf("fail") > -1) {
					layer.alert("迁出失败！", {icon:0,title:'提示'});
                }else {
                	var type = $('#typeId').val();
//                	mhmCommon.closePopUp('transferDialog');
                	mhmCommon.closeLayUiDialog();
//                	msgUtil.alert(type=='2'?"纳入成功":"迁出成功，等待对方社区纳入！");
                	layui.use('layer', function(){
            			var layer = layui.layer;
            			layer.alert(type=='2'?"纳入成功":"迁出成功，等待对方社区纳入！", {icon:0,title:'提示'});
            		});
                   return false;
                }
			},
            wait:true
		});
  	
	}
	return {
		save:save
	};
})();