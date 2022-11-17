var grfhypEdit = (function() {
	var hospitalId = $("#id").val();
	var ohProtectiveEquipmentOperationType = $("#ohProtectiveEquipmentOperationType").val();
	
	function save(){
		var validate = $("#protectiveEquipment_form").easyValidate();
		var result = validate.validateForm();
		if (!result) {
			return;
		}
		$("#protectiveEquipment_form").submitFormLoadHtml({
			url : "/oh/radiologicalProtectionReport/protectiveEquipment/save",
			param : {
				ohProtectiveEquipmentOperationType : ohProtectiveEquipmentOperationType,
				hospitalId : hospitalId
			},
			callback : function(data) {
				if (data == '1') {
					layer.alert("保存成功！", {icon:0,title:'提示'}, function(){
						$.removeDialog("grfhypEdit");
						editRecord.grfhyp(1);
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
		save : save,
		cancle : cancle
	};
})();
