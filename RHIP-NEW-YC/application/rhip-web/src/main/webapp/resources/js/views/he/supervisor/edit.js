var healthEducationSupervisorEdit = (function() {
	$(function() {
		var validate = $("#healthEducationSupervisorForm").easyValidate();
		$("#healthEducationSupervisorSaveButton").click(function() {
			if (validate.validateForm()) {
				$("#healthEducationSupervisorForm").submitFormGetJson({
					url : "/he/supervisor/save",
					callback : submitCallback
				});
			}
		});
	});

	function editHealthEducationSupervisor(id) {
		/*编辑健康督查信息*/
		var dialogParams = {
				id : "healthEducationSupervisor",
				url : "/he/supervisor/edit/"+id,
				height : 370,
				width : 800,
				title : "修改健康督查信息"
		};
		$.dialog(dialogParams);
	}

	function deleteHealthEducationSupervisor(id) {
		if (!id) {
			return;
		}
		
		var index = layer.confirm("确认删除?", {icon:2, title:'确认提示'}, function() {
			$.getJsonByUrl({
				url : "/he/supervisor/delete/"+id,
				callback : function(data) {
					if (data.result) {
						healthEducationSupervisorSearch.search(1);
					} else {
						layui.use('layer', function() {
							var layer = layui.layer;
							layer.alert("删除失败！", {icon:0,title:'提示'});
						});
					}
				}
			});
			layer.close(index);
		});
	}

	function submitCallback(data) {
		if (data.result) {
			layer.alert(data.message, {icon:0,title:'提示'}, function(index) {
				$.removeDialog("healthEducationSupervisor");
				healthEducationSupervisorSearch.search(1);
				layer.close(index);
			});
		} else {
			layer.alert(data.message, {icon:0,title:'提示'});
		}
	}
	
	return {
		editHealthEducationSupervisor : editHealthEducationSupervisor,
		deleteHealthEducationSupervisor : deleteHealthEducationSupervisor
	};
})();
