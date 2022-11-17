var grjldaEdit = (function() {
	var hospitalId = $("#id").val();
	var doseId = $("#doseId").val();
	var ohDoseDetectionOperationType = $("#ohDoseDetectionOperationType").val();
	function save(){
		var validate = $("#doseDetection_form").easyValidate();
		var result = validate.validateForm();
		if (!result) {
			return;
		}
		$("#doseDetection_form").submitFormLoadHtml({
			url : "/oh/radiologicalProtectionReport/personalHealthRecord/doseDetection/save",
			param : {
				ohDoseDetectionOperationType: ohDoseDetectionOperationType,
				hospitalId: hospitalId,
				doseId: doseId
			},
			callback : function(data) {
				if (data == '1') {
					layer.alert("保存成功！", {icon:0,title:'提示'}, function(){
						$.removeDialog("grjljcjgEdit");
						grjlhjkjhda.searchDoseDetection(1);
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
