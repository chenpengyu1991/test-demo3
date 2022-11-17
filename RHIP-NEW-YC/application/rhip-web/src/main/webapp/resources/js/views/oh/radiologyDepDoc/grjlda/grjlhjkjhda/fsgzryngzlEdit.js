var fsgzryngzlEdit = (function() {
	var hospitalId = $("#id").val();
	var doseId = $("#doseId").val();
	var ohWorkloadOperationType = $("#ohWorkloadOperationType").val();
	function save(){
		var validate = $("#workload_form").easyValidate();
		var result = validate.validateForm();
		if (!result) {
			return;
		}
		var option={
				url : "/oh/radiologicalProtectionReport/personalHealthRecord/workload/save",
				param : {
					ohWorkloadOperationType : ohWorkloadOperationType,
					hospitalId : hospitalId,
					doseId : doseId
				},
				callback : function(data){
					if (data == '1'){
						layer.alert("保存成功！", {icon:0,title:'提示'}, function(index) { 
							$.removeDialog("fsgzryngzlEdit");grjlhjkjhda.searchWorkload(1); 
							layer.close(index);
						});
						return;
					} else{
						layer.alert("保存失败！", {icon:0,title:'提示'});
						return;
					}
				}
		};
		$("#workload_form").submitFormLoadHtml(option);
	}
	
	function cancle(){
		$.removeDialog("fsgzryngzlEdit");
	}
	
	return {
		save : save,
		cancle : cancle
	};
})();
