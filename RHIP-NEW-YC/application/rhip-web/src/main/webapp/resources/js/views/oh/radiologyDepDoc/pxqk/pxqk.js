var pxqk = (function() {
	var operationType = $("#operationType").val();
	$(function(){
		if(operationType=='1'){
			$("#pxqkAdd").hide();
			$(".pxqkModify").hide();
			$(".pxqkDelete").hide();
		}
	});	
	function addRecord(){
		$.post(contextPath+"/oh/radiologicalProtectionReport/training/edit",
			{
				ohTrainingOperationType : '3'
			},
			function(ret){
				layui.use(['layer'], function() {
					var layer = layui.layer
					layer.open({
						type: 1,
						id:'pxqkEdit',
						area: ['600px', '260px'],
						title:"添加培训情况",
						content: ret
					});
				});
			});
	}
	
	function deleteRecord(id){
		layui.use('layer', function() {
			var layer = layui.layer;
			var index = layer.confirm('确认删除?', {icon:2, title:'确认提示'}, function(){
				$.getJsonByUrl({
					url : "/oh/radiologicalProtectionReport/training/delete",
					callback:function(data){
						if (data == '1'){
							layer.alert("删除成功！", {icon:0,title:'提示'}, function() {
								editRecord.pxqk(1);
								layer.closeAll();
							});
						} else{
							layer.alert("删除失败！", {icon:0,title:'提示'});
							layer.closeAll();
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
	
	function updateRecord(ohTrainingId){
		$.post(contextPath+"/oh/radiologicalProtectionReport/training/edit",
			{
				ohTrainingId : ohTrainingId,
				ohTrainingOperationType : '2'
			},
			function(ret){
				layui.use(['layer'], function() {
					var layer = layui.layer
					layer.open({
						type: 1,
						id:'pxqkEdit',
						area: ['600px', '260px'],
						title:"修改培训情况",
						content: ret
					});
				});
			});
	}
	
	return {
		addRecord:addRecord,
		deleteRecord:deleteRecord,
		updateRecord:updateRecord
	};
})();
