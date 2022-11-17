var dmbcChildcareInstMonitorInfoEdit = (function() {
	var validate = $("#infoEditForm").easyValidate();
	$(function() {
            $("#btnSave").click(function() {
            	save();
            });
	});
	
	function save() {
		var result = validate.validateForm();
		if (!result) {
			return;
		}
		var option = {
				url : "/dmbc/childcareInst/monitorSave",
				callback : function(result) {
					layer.alert(result.message, {icon:0,title:'提示'});
					if (result.success) {
						$.removeDialog("d1");
						dmbcChildcareInstMonitorSearch.search($("#_indexPage").val());
					}
				}
		};
		$("#infoEditForm").submitFormGetJson(option);
	}
	
	return {
        
	};
})();
