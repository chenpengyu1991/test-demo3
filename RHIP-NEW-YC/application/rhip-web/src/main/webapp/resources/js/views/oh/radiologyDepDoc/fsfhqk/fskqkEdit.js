var fskqkEdit = (function() {
	var hospitalId = $("#id").val();
	var ohMachineRoomOperationType = $("#ohMachineRoomOperationType").val();
	var type = $("#typeValue").val();
	
	$(function(){
		if(type=='1')
    		$("#name").html("机房名称");
    	else
    		$("#name").html("其他场所名称");
	});
	
    function typeChange(){
    	var typeValue = $(":radio:checked").val();
    	if(typeValue=='1')
    		$("#name").html("机房名称");
    	else
    		$("#name").html("其他场所名称");
    }

	
	function save(){
		var validate = $("#machineRoom_form").easyValidate();
		var result = validate.validateForm();
		if (!result) {
			return;
		}
		$("#machineRoom_form").submitFormLoadHtml({
			url : "/oh/radiologicalProtectionReport/radiologicalProtection/machineRoom/save",
			param : {
				ohMachineRoomOperationType : ohMachineRoomOperationType,
				hospitalId : hospitalId
			},
			callback : function(data) {
				if (data == '1') {
					layer.alert("保存成功！", {icon:0,title:'提示'}, function(){
						$.removeDialog("fskqkEdit");
						editRecord.fsfhqk(1);
						layer.closeAll();
					});
					return;
				} else {
					layer.alert("保存失败！", {icon:0,title:'提示'});
					layer.closeAll();
					return;
				}
			}
		});
	}
	
	function cancle(){
		layer.closeAll();
	}
	
	
	return {
		typeChange : typeChange,
		save : save,
		cancle : cancle
	};
})();
