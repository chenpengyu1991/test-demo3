var fsgzryngzlList = (function() {
	var operationType = $("#operationType").val();
	$(function(){
		if(operationType=='1'){
			$(".fsgzryngzlListModify").hide();
			$(".fsgzryngzlListDelete").hide();
		}
	});	
	//删除放射工作人员年工作量
	function deleteWorkloadRecord(id){
		layer.confirm("确认删除?", {icon:2, title:'确认提示'}, function(index){
			var option = {
					url : "/oh/radiologicalProtectionReport/personalHealthRecord/workload/delete",
					param : {
						id : id
					},
					callback : function(data){
						if(data=='1'){
							layer.alert("删除成功！", {icon:0,title:'提示'}, function(index2) { 
								grjlhjkjhda.searchWorkload(1); 
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
	
	//修改放射工作人员年工作量
	function updateWorkloadRecord(id){
		var option = {
				url : "/oh/radiologicalProtectionReport/personalHealthRecord/workload/edit",
				id : "fsgzryngzlEdit",
				height : 400,
				width : 500,
				param : {
					ohWorkloadOperationType : '2',
					ohWorkloadId : id
				},
				title : "修改放射工作人员年工作量"
		};
		$.dialog(option);
	}
	return {
		updateWorkloadRecord:updateWorkloadRecord,
		deleteWorkloadRecord:deleteWorkloadRecord
	};
})();
