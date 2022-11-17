var fskwzbzqkEdit = (function() {
	var hospitalId = $("#id").val();
	
	$(function(){
		healthEducationUpload.uploadFile("layoutUrl","/he/upload/uploadFile/ohfskbzt","/he/upload/deleteFile/ohfskbzt");
		healthEducationUpload.uploadFile("localtionUrl","/he/upload/uploadFile/ohfskwzt","/he/upload/deleteFile/ohfskwzt");
	});
	
	function save(){
		var validate = $("#radiologicalPostion_form").easyValidate();
		var result = validate.validateForm();
		if (!result) {
			return;
		}
		$("#radiologicalPostion_form").submitFormLoadHtml({
			url : "/oh/radiologicalProtectionReport/radiologicalProtection/radiologicalPostion/save",
			param : {
				hospitalId : hospitalId
			},
			callback : function(data) {
				if (data == '1') {
					layer.alert("保存成功！", {icon:0,title:'提示'}, function(){
						$.removeDialog("fskwzbzqkEdit");
						editRecord.fsfhqk();
						layer.closeAll();
					});
					return;
				} else if(data == '-2'){
					layer.alert("位置图和布置图只能各上传一个附件！", {icon:0,title:'提示'});
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
