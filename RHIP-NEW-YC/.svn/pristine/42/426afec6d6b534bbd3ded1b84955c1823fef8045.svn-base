var assignment = (function() {
	$("#save").click(function() {
		var id = $("#id").val();
		var validate = $("#assignForm").easyValidate();
		if (validate.validateForm()) {
			$("#assignForm").submitFormGetJson({
				url : "/idm/case/saveAssign",
				param : {
					id : id,
					type : '0'
				},
				callback : submitCallback
			});
		}
	});
	function submitCallback(data) {
		var indexPage = $("#currentPage").val();
		if (data.result) {
			layer.alert(data.message, {icon:0,title:'提示'}, function(index) {
				$.removeDialog("assignDiv");
				caseSearch.search(indexPage);
				layer.close(index);
				layer.closeAll();
			});
		} else {
			layer.alert(data.message, {icon:0,title:'提示'});
		}
		/*layer.closeAll();*/
	}
})();