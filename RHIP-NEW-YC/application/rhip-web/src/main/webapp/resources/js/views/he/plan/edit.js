var healthEducationActiveEdit = (function() {
	$(function() {
		
		var validate = $("#heWorkPlanForm").easyValidate();
		$("#heWorkPlanSaveButton").click(function(e) {
			e.preventDefault();
			if (validate.validateForm()) {
                $("#heWorkPlanForm").submitFormGetJson({
					url : "/he/work/plan/save",
					callback : submitCallback
				});
			}
		});
	});


	function submitCallback(data) {
		/*if (data.result) {
			msgUtil.alert(data.message, function() {
				$.removeDialog("healthEducationActive");
                heWorkPlanSearch.search(1);
			});
		} else {
			msgUtil.alert(data.message);
		}*/
		
		layui.use('layer', function(){
			var layer = layui.layer;
			if (data.result) {
				var index = layer.alert(data.message, {icon:0,title:'提示'}, function() {
					layer.closeAll();
					heWorkPlanSearch.search(1);
				});
			} else {
				layer.alert(data.message, {icon:0,title:'提示'});
			}
			
		});
	}
})();
