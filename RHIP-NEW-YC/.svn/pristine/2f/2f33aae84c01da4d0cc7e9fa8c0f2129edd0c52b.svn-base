var infectMonitorList = (function() {
	$(function() {
	});

	function viewOrEdit(id, operation) {
		var param = {
			id : id,
			operation : operation
		}
		baseLayoutLoad.pushMainContent("/dmbc/medicalInst/infectMonitor/edit", param);
	}

	function del(obj, id) {
		var index = layer.confirm("是否删除该记录？", {icon:2, title:'确认提示'}, function() {
			var option = {
				url : "/dmbc/medicalInst/infectMonitor/delete",
				param : {
					id : id
				},
				callback : (function(result) {
					layui.use('layer', function() {
						var layer = layui.layer;
						layer.alert(result.message, {icon:0,title:'提示'});
					});
					if (result.success) {
						infectMonitorSearch.search();
					}
				})
			};
			$(obj).html(loadingSource);
			$.getJsonByUrl(option);

			layer.close(index);
		});
	}

	return {
		viewOrEdit : viewOrEdit,
		del : del
	}
})();