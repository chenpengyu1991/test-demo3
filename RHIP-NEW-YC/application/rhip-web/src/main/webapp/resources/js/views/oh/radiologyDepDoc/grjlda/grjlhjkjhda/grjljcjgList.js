var grjljcjgList = (function() {
	var operationType = $("#operationType").val();
	$(function(){
		if(operationType=='1'){
			$(".grjljcjgListModify").hide();
			$(".grjljcjgListDelete").hide();
		}
	});	
	//删除个人计量检测结果
	function deleteDoseDetectionRecord(id){
		layer.confirm("确认删除?", {icon:2, title:'确认提示'}, function(index){
			var option = {
					url : "/oh/radiologicalProtectionReport/personalHealthRecord/doseDetection/delete",
					param : {
						id : id
					},
					callback : function(data){
						if(data=='1'){
							layer.alert("删除成功！", {icon:0,title:'提示'}, function(index2) { 
								grjlhjkjhda.searchDoseDetection(1); 
								layer.close(index2);
							});
							return;
						}else{
							layer.alert("删除失败！", {icon:0,title:'提示'});
							return;
						}
					}
			};
			$.loadHtmlByUrl(option);
			layer.close(index);
		});
	}
	
	//修改个人计量检测结果
	function updateDoseDetectionRecord(id){
		var option = {
				url : "/oh/radiologicalProtectionReport/personalHealthRecord/doseDetection/edit",
				id : "grjljcjgEdit",
				height : 300,
				width : 400,
				param : {
					ohDoseDetectionOperationType : '2',
					ohDoseDetectionId : id
				},
				title : "修改个人剂量检测结果"
		};
		$.dialog(option);
	}
	return {
		updateDoseDetectionRecord:updateDoseDetectionRecord,
		deleteDoseDetectionRecord:deleteDoseDetectionRecord
	};
})();
