var occPatientList = (function() {
	$(function() { 
		util.checkBoxAll("all","employeeInfoIds");
	});

	/*进入修改职业病病人信息页面*/
	function modify(employeeId) {
			//参数
			$("#mainSearchDiv").hide();
			var option = {
					url : "/oh/occPatient/initEmployeeModify/"+employeeId,
					insertDiv : "operationDiv"
			};
			$.loadHtmlByUrl(option);
	};
	
	/*进入查看职业病病人信息页面*/
	function view(employeeId) {
			//参数
			$("#mainSearchDiv").hide();
			var option = {
					url : "/oh/occPatient/initEmployeeModify/"+employeeId,
					insertDiv : "operationDiv",
					param :{
						operatorType:'view'
					}
			};
			$.loadHtmlByUrl(option);
	};
	
	function del(id){
		if (!id) {
			return;
		}
		layer.confirm('确认删除?', {icon:2, title:'确认提示'}, function(index){
			deleteDo(id);
			layer.close(index);
		});
	}
	
	function deleteDo(id){
		$.getJsonByUrl({
			url : "/oh/occPatient/delEmployee",
			callback:function(data){
				layer.alert(data.message, {icon:0,title:'提示'});
				if (data.result) {
					occPatientSearch.search($("#currentPage").val());
				}
			},
			param:{
				id:id
			}
		});
	}
	
	return {
		modify:modify,
		view:view,
		del:del
	};
})();

