var yyfssbqk = (function() {
	
	var operationType = $("#operationType").val();
	$(function(){
		if(operationType=='1'){
			$("#yyfssbqkAdd").hide();
			$(".yyfssbqkModify").hide();
			$(".yyfssbqkDelete").hide();
		}
	});
	function addRecord(){
		$.post(contextPath+"/oh/radiologicalProtectionReport/radiologicalApparatus/edit",
			{
				ohRadiologicalApparatusOperationType : '3'
			},
			function(ret){
				layui.use(['layer'], function() {
					var layer = layui.layer
					layer.open({
						type: 1,
						id:'yyfssbqkEdit',
						area: ['600px', '420px'],
						title:"添加医院放射设备情况",
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
					url : "/oh/radiologicalProtectionReport/radiologicalApparatus/delete",
					callback:function(data){
						if (data == '1'){
							layer.alert("删除成功！", {icon:0,title:'提示'}, function() {
								editRecord.yyfssbqk(1);
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
	
	function updateRecord(ohRadiologicalApparatusId){
		$.post(contextPath+"/oh/radiologicalProtectionReport/radiologicalApparatus/edit",
			{
				ohRadiologicalApparatusId : ohRadiologicalApparatusId,
				ohRadiologicalApparatusOperationType : '2'
			},
			function(ret){
				layui.use(['layer'], function() {
					var layer = layui.layer
					layer.open({
						type: 1,
						id:'yyfssbqkEdit',
						area: ['600px', '420px'],
						title:"修改医院放射设备情况",
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
