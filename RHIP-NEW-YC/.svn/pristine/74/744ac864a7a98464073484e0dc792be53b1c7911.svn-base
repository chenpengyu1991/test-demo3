var qtfhcsEdit = (function() {
	var hospitalId = $("#id").val();
	var ohCautionAlarmOperationType = $("#ohCautionAlarmOperationType").val();
	var type = $("#typeValue").val();
	
	$(function(){
		if(type=='1')
    		$("#name").html("警示标识名称");
		if(type=='2')
    		$("#name").html("报警仪名称");
	});
	
    function typeChange(){
    	var typeValue = $(":radio:checked").val();
    	if(typeValue=='1')
    		$("#name").html("警示标识名称");
    	if(typeValue=='2')
    		$("#name").html("报警仪名称");
    }

	function save(){
		var validate = $("#cautionAlarm_form").easyValidate();
		var result = validate.validateForm();
		if (!result) {
			return;
		}
		$("#cautionAlarm_form").submitFormLoadHtml({
			url : "/oh/radiologicalProtectionReport/radiologicalProtection/cautionAlarm/save",
			param : {
				ohCautionAlarmOperationType : ohCautionAlarmOperationType,
				hospitalId : hospitalId
			},
			callback : function(data) {
				if (data == '1') {
					layer.alert("保存成功！", {icon:0,title:'提示'}, function(){
						$.removeDialog("qtfhcsEdit");
						editRecord.fsfhqk();
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
