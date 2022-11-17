var conditionList = (function() {
	$(function() { 

	});

	function search(indexPage) { 
		var loadHtmlOption = {
				url : "/oh/enterpriseDoc/condition/"+$('#enterpriseId').val(),
				param : {
					indexPage : indexPage,
					type:$("#type").val()
				},
				insertDiv :"tagContent1"
			};
		$.loadHtmlByUrl(loadHtmlOption);
	};
	
	function initAdd(){
		$.post(contextPath+"/oh/enterpriseDoc/initAddViewCondition/"+$("#enterpriseId").val(),
			function(ret){
				layui.use(['layer'], function() {
					var layer = layui.layer
					layer.open({
						type: 1,
						id:'d1',
						area: ['500px', '410px'],
						title:"创建职业卫生情况",
						content: ret
					});
				});
			});
	}
	
	function initEdit(id){
		$.post(contextPath+"/oh/enterpriseDoc/initAddViewCondition/"+$("#enterpriseId").val(),
			{ id:id
			},
			function(ret){
				layui.use(['layer'], function() {
					var layer = layui.layer
					layer.open({
						type: 1,
						id:'d1',
						area: ['500px', '410px'],
						title:"修改职业卫生情况",
						content: ret
					});
				});
			});
	}
	
	function del(id){
		layui.use('layer', function() {
			var layer = layui.layer;
			var index = layer.confirm('确认删除?', {icon:2, title:'确认提示'}, function(){
				layer.close(index);
				deleteDo(id);
			});
		});
	}
	
	function deleteDo(id){
		$.getJsonByUrl({
			url : "/oh/enterpriseDoc/delCondition",
			callback:function(data){
				layer.alert(data.message, {icon:0,title:'提示'});
				if (data.result) {
					$("#condition_btn").click();
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

