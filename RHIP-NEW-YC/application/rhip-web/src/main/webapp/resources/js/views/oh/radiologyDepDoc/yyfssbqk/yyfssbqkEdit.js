var yyfssbqkEdit = (function() {
	var hospitalId = $("#id").val();
	var ohRadiologicalApparatusOperationType = $("#ohRadiologicalApparatusOperationType").val();
	
	function save(){
		var validate = $("#radiologicalApparatus_form").easyValidate();
		var result = validate.validateForm();
		if (!result) {
			return;
		}
		var productionDate = new Date($("#productionDate").val());
		var activeDate = new Date($("#activeDate").val());
		if(activeDate<productionDate){
			layui.alert("启用时间不能早于出厂时间!");
			return;
		}
		$("#radiologicalApparatus_form").submitFormLoadHtml({
			url : "/oh/radiologicalProtectionReport/radiologicalApparatus/save",
			param : {
				ohRadiologicalApparatusOperationType : ohRadiologicalApparatusOperationType,
				hospitalId : hospitalId
			},
			callback : function(data) {
				if (data == '1') {
					layer.alert("保存成功！", {icon:0,title:'提示'}, function(){
						$.removeDialog("yyfssbqkEdit");
						editRecord.yyfssbqk(1);
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
