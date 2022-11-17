var testItemsList = (function() {
	$(function() { 

	});

	function search(indexPage) { 
		var searchObj = {
			url : "/oh/enterpriseDoc/testItems/"+$('#enterpriseId').val(),
			insertDiv : "tagContent5",
			param : {
				indexPage : indexPage,
				type:$("#type").val()
			}
		};
		$.loadHtmlByUrl(searchObj);
	};
	
	function initAdd(){
		$.post(contextPath+"/oh/enterpriseDoc/initAddViewTestItems/"+$("#enterpriseId").val(),
			function(ret){
				layui.use(['layer'], function() {
					var layer = layui.layer
					layer.open({
						type: 1,
						id:'d1',
						area: ['550px', '430px'],
						title:"创建监测点示意图",
						content: ret
					});
				});
			});
	}
	
	function initEdit(id){
		$.post(contextPath+"/oh/enterpriseDoc/initAddViewTestItems/"+$("#enterpriseId").val(),
			{ id:id
			},
			function(ret){
				layui.use(['layer'], function() {
					var layer = layui.layer
					layer.open({
						type: 1,
						id:'d1',
						area: ['550px', '430px'],
						title:"修改监测点示意图",
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
			url : "/oh/enterpriseDoc/delTestItem",
			callback:function(data){
				layer.alert(data.message, {icon:0,title:'提示'});
				if (data.result) {
					$("#test_items_btn").click();
				}
			},
			param:{
				id:id
			}
		});
	}
	
	
	function showDiagram(id) {
		
		
		$.post(contextPath+'/dialog/showImage',
        		{id:id
			     }, 
			function(ret){
        	layui.use(['layer'], function() {
        		  var layer = layui.layer
        		  layer.open({
        			  type: 1,
        			  id:'viewDiagramDialog',
        			  area: ['900px', '480px'],
        			  title:'示意图',
        			  content: ret
        		  });
        		});
        	});
	}
	
	return {
		search:search,
		initAdd:initAdd,
		initEdit:initEdit,
		del:del,
		showDiagram:showDiagram
	};
})();

