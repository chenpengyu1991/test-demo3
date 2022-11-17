var heCopyEdit = (function() {
	$(function() {
		var validate = $("#heCopyForm").easyValidate();
		$("#heCopySaveButton").click(function() {
			if (validate.validateForm()) {
				$("#heCopyForm").submitFormGetJson({
					url : "/he/copy/save",
					callback : submitCallback
				});
			}
		});
		$("#heCopyBackButton").click(function(){
			$.removeDialog("heCopy");
		});
	});

	function submitCallback(data) {
		if (data.result) {
			layer.alert(data.message, {icon:0,title:'提示'}, function(index) {
				layer.closeAll();
				heCopySearch.search(1);
			});
		} else {
			layer.alert(data.message, {icon:0,title:'提示'});
		}
	}
	
	return {
	};
})();
