var pxqkEdit = (function() {
	var hospitalId = $("#id").val();
	var ohTrainingOperationType = $("#ohTrainingOperationType").val();
	var validate = null;
	$(function(){
		validate = $("#training_form").easyValidate();
	});
	function save(){
		var result = validate.validateForm();
		if (!result) {
			return;
		}
		$("#training_form").submitFormLoadHtml({
			url : "/oh/radiologicalProtectionReport/training/save",
			param : {
				ohTrainingOperationType : ohTrainingOperationType,
				hospitalId : hospitalId
			},
			callback : function(data) {
				if (data == '1') {
					layer.alert("保存成功！", {icon:0,title:'提示'}, function(){
						$.removeDialog("pxqkEdit");
						editRecord.pxqk(1);
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
