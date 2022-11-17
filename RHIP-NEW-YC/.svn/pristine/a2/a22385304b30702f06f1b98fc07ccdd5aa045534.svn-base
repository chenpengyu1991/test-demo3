var flyMonitorList = (function() {
	$(function() { 
 
	});

	
	/*进入查看/修改苍蝇监测页面*/
	function viewOrEdit(monitorId,type, index) {
			//参数
			$("#mainSearchDiv").hide();
			var option = {
					url : "/dmbc/vertor/initFlyMonitorViewModify/"+monitorId,
					insertDiv : "operationDiv",
					param :{
						type:type,
						indexPage:index==null?1:index
					}
			};
			$.loadHtmlByUrl(option);
	}
	
	function del(id){
		var index = layer.confirm("确认删除?", {icon:2, title:'确认提示'}, function() {
			deleteDo(id);
			layer.close(index);
		});
	}
	
	function deleteDo(id){
		$.getJsonByUrl({
	    	url : "/dmbc/vertor/delFlyMonitor",
            callback:function(data){
            	layer.alert(data.message, {icon:0,title:'提示'});
            	if (data.result) {
            		flyMonitorSearch.search($("#currentPage").val());
        		}
    		},
	    	param:{
	    		id:id
	    	}
	     });
	}
	
	return {
		viewOrEdit:viewOrEdit,
		del:del
	};
})();

