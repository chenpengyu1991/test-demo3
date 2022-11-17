var grjlhjkjhda = (function() {
	var hospitalId = $("#id").val();
	var doseId = $("#doseId").val();
	var operationType = $("#operationType").val();
	
	$(function(){
		performDoseDetectionRecords(1);
		performWorkloadRecords(1);
		if(operationType=='1'){
			$("#grjljcjgAdd").hide();
		    $("#fsgzrygzlAdd").hide();
		}
	});
	
	//加载个人计量检测结果表
	function performDoseDetectionRecords(indexPage){
		var option = {
				url : "/oh/radiologicalProtectionReport/personalHealthRecord/doseDetection",
				insertDiv : "doseDetectionList",
				param : {
					hospitalId : hospitalId,
					doseId : doseId,
					indexPage : indexPage
				}
		};
		$.loadHtmlByUrl(option);
	}
	
	//加载放射工作人员年工作量表
	function performWorkloadRecords(indexPage){
		var option = {
				url : "/oh/radiologicalProtectionReport/personalHealthRecord/workload",
				insertDiv : "workloadList",
				param : {
					hospitalId : hospitalId,
					doseId : doseId,
					indexPage : indexPage
				}
		};
		$.loadHtmlByUrl(option);
	}
	
	//添加个人计量检测结果
	function addDoseDetectionRecord(){
		var option = {
				url : "/oh/radiologicalProtectionReport/personalHealthRecord/doseDetection/edit",
				id : "grjljcjgEdit",
				height : 300,
				width : 400,
				param : {
					ohPersonalDoseOperationType : '3'
				},
				title : "添加个人剂量检测结果"
		};
		$.dialog(option);
	}
	
	//删除个人计量检测结果
	function deleteDoseDetectionRecord(id){
		var option = {
				url : "/oh/radiologicalProtectionReport/personalHealthRecord/doseDetection/delete",
				param : {
					id : id
				},
				callback : function(data){
					if(data=='1'){
						layer.alert("删除成功！", {icon:0,title:'提示'}, function(index) { 
							performDoseDetectionRecords(1); 
							layer.close(index);
						});
						return;
					}else{
						layer.alert("删除失败！", {icon:0,title:'提示'});
						return;
					}
				}
		};
		$.loadHtmlByUrl(option);
	}
	//添加放射工作人员年工作量
	function addWorkloadRecord(){
		var option = {
				url : "/oh/radiologicalProtectionReport/personalHealthRecord/workload/edit",
				id : "fsgzryngzlEdit",
				height : 400,
				width : 500,
				param : {
					ohPersonalDoseOperationType : '3'
				},
				title : "添加放射工作人员工作量"
		};
		$.dialog(option);
	}
	
	//删除放射工作人员年工作量
	function deleteWorkloadRecord(id){
		var option = {
				url : "/oh/radiologicalProtectionReport/personalHealthRecord/workload/delete",
				param : {
					id : id
				},
				callback : function(data){
					if(data=='1'){
						layer.alert("删除成功！", {icon:0,title:'提示'}, function(index) { 
							performWorkloadRecords(1); 
							layer.close(index);
						});
						return;
					}else{
						layer.alert("删除失败！", {icon:0,title:'提示'});
						return;
					}
				}
		};
		$.loadHtmlByUrl(option);
	}
	
	function back(){
		$("#grjlhjkjhda").empty();
		$("#selectionDiv").show();
	}
	
	
	return {
		addDoseDetectionRecord:addDoseDetectionRecord,
		deleteDoseDetectionRecord:deleteDoseDetectionRecord,
		addWorkloadRecord:addWorkloadRecord,
		deleteWorkloadRecord:deleteWorkloadRecord,
		searchDoseDetection:performDoseDetectionRecords,
		searchWorkload:performWorkloadRecords,
		back : back
	};
})();
