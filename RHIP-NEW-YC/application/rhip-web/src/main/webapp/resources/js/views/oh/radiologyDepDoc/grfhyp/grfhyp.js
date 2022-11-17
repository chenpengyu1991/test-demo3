var grfhyp = (function() {
	var operationType = $("#operationType").val();
	$(function(){
		if(operationType=='1'){
			$("#grfhypAdd").hide();
			$(".grfhypModify").hide();
			$(".grfhypDelete").hide();
		}
	});	
	function addRecord(){
		$.post(contextPath+"/oh/radiologicalProtectionReport/protectiveEquipment/edit",
			{
				ohProtectiveEquipmentOperationType : '3'
			},
			function(ret){
				layui.use(['layer'], function() {
					var layer = layui.layer
					layer.open({
						type: 1,
						id:'grfhypEdit',
						area: ['400px', '260px'],
						title:"添加个人防护用品",
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
					url : "/oh/radiologicalProtectionReport/protectiveEquipment/delete",
					callback:function(data){
						if (data == '1'){
							layer.alert("删除成功！", {icon:0,title:'提示'}, function() {
								editRecord.grfhyp(1);
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
	
	function updateRecord(ohProtectiveEquipmentId){
		$.post(contextPath+"/oh/radiologicalProtectionReport/protectiveEquipment/edit",
			{
				ohProtectiveEquipmentId : ohProtectiveEquipmentId,
				ohProtectiveEquipmentOperationType : '2'
			},
			function(ret){
				layui.use(['layer'], function() {
					var layer = layui.layer
					layer.open({
						type: 1,
						id:'grfhypEdit',
						area: ['400px', '260px'],
						title:"修改个人防护用品",
						content: ret
					});
				});
			});
	}
	
	return {
		addRecord:addRecord,
		deleteRecord:deleteRecord,
		updateRecord:updateRecord,
		search:grfhyp
	};
})();
