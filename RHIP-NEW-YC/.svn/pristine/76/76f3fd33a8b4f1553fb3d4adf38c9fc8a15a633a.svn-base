var listRecord = (function() {
	//查看
	function viewRecord(id){
		$.post(contextPath+"/oh/poisonReport/edit",
			{
				id : id,
				operationType : '1'
			},
			function(ret){
				layui.use(['layer'], function() {
					var layer = layui.layer
					layer.open({
						type: 1,
						id:'editDialog',
						area: ['900px', '490px'],
						title:"查看农药中毒报告",
						content: ret
					});
				});
			});
	}
	//修改
	function updateRecord(id){
		$.post(contextPath+"/oh/poisonReport/edit",
			{
				id : id,
				operationType : '2'
			},
			function(ret){
				layui.use(['layer'], function() {
					var layer = layui.layer
					layer.open({
						type: 1,
						id:'editDialog',
						area: ['900px', '490px'],
						title:"修改农药中毒报告",
						content: ret
					});
				});
			});
	}
	//删除
	function deleteRecord(id){
		layer.confirm("确认删除？", {icon:2, title:'确认提示'}, function(index){
			var option = {
				url : "/oh/poisonReport/delete",
			    param : {
			    	id : id
			    },
			    callback : function(data){
			    	if(data=='1'){
			    		layer.alert("删除成功！", {icon:0,title:'提示'});
			    		recordsPerform(1);
			    		return;
			    	}else{
			    		layer.alert("删除失败！", {icon:0,title:'提示'});
			    		recordsPerform(1);
			    		return;
			    	}
			    }
			};
			$.getJsonByUrl(option);
			layer.close(index);
		});
	}
	
	//审核
	function check(id){
		checking = true;
		var option = {
				url : "/oh/poisonReport/edit",
				id : "editDialog",
				height : 600,
				width : 900,
				param : {
					id : id,
					operationType : '4'
				},
				title : "审核农药中毒报卡",
			};
			$.dialog(option);
	}
	
	
	function recordsPerform(indexPage) {
		var createBegin = new Date($("#startDate").val());
		var createEnd = new Date($("#endDate").val());

		if (createBegin > createEnd) {
			layer.alert("开始时间不能大于结束时间！", {icon:0,title:'提示'});
		} else {
			var searchObj = {
				url : "/oh/poisonReport/records",
				insertDiv : "info_records",
				param : {
					indexPage : indexPage
				}
			};
			$("#form_search").submitFormLoadHtml(searchObj);
		}
	}
	
	return {
		viewRecord:viewRecord,
		updateRecord:updateRecord,
		deleteRecord:deleteRecord,
		check:check,
		search:recordsPerform
	};
})();
