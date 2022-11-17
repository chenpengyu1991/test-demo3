var enterpriseList = (function() {
	$(function() { 
 
	});

	/*进入修改企业信息页面*/
	function modify(enterpriseId) {
			//参数
			$("#mainSearchDiv").hide();
			var option = {
					url : "/oh/enterpriseDoc/initViewModify/"+enterpriseId,
					insertDiv : "operationDiv"
			};
			$.loadHtmlByUrl(option);
	};
	
	/*进入查看企业信息页面*/
	function view(enterpriseId) {
			//参数
			$("#mainSearchDiv").hide();
			var option = {
					url : "/oh/enterpriseDoc/initViewModify/"+enterpriseId,
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
		layui.use('layer', function() {
			var layer = layui.layer;
			var index = layer.confirm('确认删除?', {icon:2, title:'确认提示'}, function(){
				deleteDo(id);
			});
		});
	}

	function deleteDo(id){
		$.getJsonByUrl({
	    	url : "/oh/enterpriseDoc/delEnterprise",
            callback:function(data){
				layer.alert(data.message, {icon:0,title:'提示'});
            	if (data.result) {
            		enterpriseSearch.search($("#currentPage").val());
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

