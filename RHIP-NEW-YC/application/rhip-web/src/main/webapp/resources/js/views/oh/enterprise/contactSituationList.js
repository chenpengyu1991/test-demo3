var contactSituationList = (function() {
	$(function() { 

	});

	function search(indexPage) { 
		var searchObj = {
			url : "/oh/enterpriseDoc/contactSituation/"+$('#enterpriseId').val(),
			insertDiv : "tagContent3",
			param : {
				indexPage : indexPage,
				type:$("#type").val()
			}
		};
		$.loadHtmlByUrl(searchObj);
	};
	
	function initAdd(){
		$.post(contextPath+"/oh/enterpriseDoc/initAddViewContactSituation/"+$("#enterpriseId").val(),
			function(ret){
				layui.use(['layer'], function() {
					var layer = layui.layer
					layer.open({
						type: 1,
						id:'d1',
						area: ['550px', '430px'],
						title:"创建危害因素接触",
						content: ret
					});
				});
			});
	}
	
	function initEdit(id){
		$.post(contextPath+"/oh/enterpriseDoc/initAddViewContactSituation/"+$("#enterpriseId").val(),
			{ id:id
			},
			function(ret){
				layui.use(['layer'], function() {
					var layer = layui.layer
					layer.open({
						type: 1,
						id:'d1',
						area: ['550px', '430px'],
						title:"修改危害因素接触",
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
			url : "/oh/enterpriseDoc/delContactSituation",
			callback:function(data){
				layer.alert(data.message, {icon:0,title:'提示'});
				if (data.result) {
					$("#contact_situation_btn").click();
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

