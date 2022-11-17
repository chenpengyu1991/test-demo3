var chemicalsUsedList = (function() {
	$(function() { 

	});

	function search(indexPage) { 
		var searchObj = {
			url : "/oh/enterpriseDoc/chemicalsUsed/"+$('#enterpriseId').val(),
			insertDiv : "tagContent2",
			param : {
				indexPage : indexPage,
				type:$("#type").val()
			}
		};
		$.loadHtmlByUrl(searchObj);
	};
	
	function initAdd(){
		$.post(contextPath+"/oh/enterpriseDoc/initAddViewChemicalsUsed/"+$("#enterpriseId").val(),
			function(ret){
				layui.use(['layer'], function() {
					var layer = layui.layer
					layer.open({
						type: 1,
						id:'d1',
						area: ['550px', '320px'],
						title:"创建使用化学物质",
						content: ret
					});
				});
			});
	}
	
	function initEdit(id){
		$.post(contextPath+"/oh/enterpriseDoc/initAddViewChemicalsUsed/"+$("#enterpriseId").val(),
			{ id:id
			},
			function(ret){
				layui.use(['layer'], function() {
					var layer = layui.layer
					layer.open({
						type: 1,
						id:'d1',
						area: ['550px', '320px'],
						title:"修改使用化学物质",
						content: ret
					});
				});
			});
	}
	
	function del(id){
		layui.use('layer', function() {
			var layer = layui.layer;
			var index = layer.confirm('确认删除?', {icon:2, title:'确认提示'}, function(){
				deleteDo(id);
			});
		});
	}
	
	function deleteDo(id){
		$.getJsonByUrl({
			url : "/oh/enterpriseDoc/delChemicalsUsed",
			callback:function(data){
				layer.alert(data.message, {icon:0,title:'提示'});
				if (data.result) {
					$("#chemicals_used_btn").click();
				}
			},
			param:{
				id:id
			}
		});
	}
	
	return {
		search:search,
		initAdd:initAdd,
		initEdit:initEdit,
		del:del
	};
})();

