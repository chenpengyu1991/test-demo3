var listRecord = (function() {
	// 查看
	function viewRecord(id) {
		var option = {
			url : "/oh/radiologicalProtectionReport/edit",
			insertDiv : "record_edit",
			param : {
				id : id,
				operationType : '1'
			},
		};
		$("#mainSearchDiv").hide();
		$.loadHtmlByUrl(option);
	}
	
	// 删除
	function deleteRecord(id) {
		layui.use('layer', function() {
			var layer = layui.layer;
			var index = layer.confirm('确认删除?', {icon:2, title:'确认提示'}, function(){
				$.getJsonByUrl({
					url : "/oh/radiologicalProtectionReport/hospitalInfo/delete",
					callback:function(data){
						if (data == '1') {
							layer.alert("删除成功！", {icon:0,title:'提示'});
							mainPage.search(1);
							return;
						} else {
							layer.alert("删除失败！", {icon:0,title:'提示'});
							return;
						}
					},
					param:{
						id:id
					}
				});
			});
		});
	}
	
	// 修改
	function updateRecord(id) {
		var option = {
			url : "/oh/radiologicalProtectionReport/edit",
			insertDiv : "record_edit",
			param : {
				id : id,
				operationType : '2'
			},
		};
		$("#mainSearchDiv").hide();
		$.loadHtmlByUrl(option);
	}
	
	// 审核
	function check(id) {
		var option = {
			url : "/oh/radiologicalProtectionReport/edit",
			insertDiv : "record_edit",
			param : {
				id : id,
				operationType : '4'
			},
		};
		$("#mainSearchDiv").hide();
		$.loadHtmlByUrl(option);
	}

	return {
		viewRecord : viewRecord,
		deleteRecord : deleteRecord,
		updateRecord : updateRecord,
		check : check,
	};
})();
