var infectDetailList = (function() {
	$(function() {
		$("#addDetail").click(function() {
			editOrView("", $("#id").val(), "edit");
		});
	});

	function editOrView(id, monitorId, operation) {
		var option = {
			title : "院内感染监测详细信息",
			id : "infectDetailDialog",
			url : "/dmbc/medicalInst/infectDetail/edit",
			param : {
				id : id,
				monitorId : monitorId,
				operation : operation
			},
			width : 400,
			height : 500
		};
		$.dialog(option);
	}

	function del(obj, id, monitorId) {
		var index = layer.confirm("是否删除该记录？", {icon:2, title:'确认提示'}, function() {
			var option = {
				url : "/dmbc/medicalInst/infectDetail/delete",
				param : {
					id : id,
					monitorId : monitorId
				},
				callback : (function(result) {
					layui.use('layer', function() {
						var layer = layui.layer;
						layer.alert(result.message, {icon:0,title:'提示'});
					});
					if (result.success) {
						infectMonitorAdd.searchDetail();
					}
				})
			};
			$(obj).html(loadingSource);
			$.getJsonByUrl(option);

			layer.close(index);
		});
	}

	return {
		editOrView : editOrView,
		del : del
	}
})();