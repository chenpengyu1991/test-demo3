var grjlda = (function() {
	var hospitalId = $("#id").val();
	var operationType = $("#operationType").val();
	$(function(){
		if(operationType=='1'){
			$("#grjldaAdd").hide();
			$(".grjldaModify").hide();
			$(".grjldaDelete").hide();
		}
	});	
	function addRecord(){
		$.post(contextPath+"/oh/radiologicalProtectionReport/personalDose/edit",
			{
				ohPersonalDoseOperationType : '3'
			},
			function(ret){
				layui.use(['layer'], function() {
					var layer = layui.layer
					layer.open({
						type: 1,
						id:'grjldaEdit',
						area: ['600px', '420px'],
						title:"添加个人剂量档案",
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
					url : "/oh/radiologicalProtectionReport/personalDose/delete",
					callback:function(data){
						if (data == '1'){
							layer.alert("删除成功！", {icon:0,title:'提示'}, function() {
								editRecord.grjlda(1);
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
	
	function updateRecord(ohPersonalDoseId){
		$.post(contextPath+"/oh/radiologicalProtectionReport/personalDose/edit",
			{
				ohPersonalDoseId : ohPersonalDoseId,
				ohPersonalDoseOperationType : '2'
			},
			function(ret){
				layui.use(['layer'], function() {
					var layer = layui.layer
					layer.open({
						type: 1,
						id:'grjldaEdit',
						area: ['600px', '420px'],
						title:"修改个人剂量档案",
						content: ret
					});
				});
			});
	}
	
	function viewPersonalHealthRecord(name,doseId,doseNo){
		$("#selectionDiv").hide();
		var option = {
				url : "/oh/radiologicalProtectionReport/personalHealthRecord",
				insertDiv : "grjlhjkjhda",
				param : {
					hospitalId : hospitalId,
					name : name,
					doseId : doseId,
					doseNo :doseNo
				}
		};
		$.loadHtmlByUrl(option);
	}
	
	return {
		addRecord:addRecord,
		deleteRecord:deleteRecord,
		updateRecord:updateRecord,
		viewPersonalHealthRecord:viewPersonalHealthRecord
	};
})();
