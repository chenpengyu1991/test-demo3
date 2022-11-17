var setSearch = (function() {
	$(function() {
		search(1);
		//分页绑定函数
		pageUtil.bind("set_records",search);
		$("#set_search_btn").click(function() {
			search(1);
		});

		$("#set_form_search").onEnter(function() {
			search(1);
		});
	});

	function search(indexPage) {
		$("#set_form_search").submitFormLoadHtml({
			url : "/portalSet/list",
			param : {
				indexPage : indexPage
			},
			insertDiv : "set_records"
		});
	}

	function add(code) {
		$.dialog({
			id:"setDialog",
			url : "/portalSet/add",
			title : "门户配置",
			width : 600,
			height : 250,
			param : {
				code : code
			}
		});
	}
	function save() {
		var validate = $("#portal_set_form").easyValidate();
		var result = validate.validateForm();
        if (!result) {
            return;
        }
		$("#portal_set_form").submitFormGetJson({
			url:"/portalSet/save",
			callback:function(data){
				if(data == "1"){
					layer.alert("保存成功！", {icon:0,title:'提示'});
					search(1);
					$.removeDialog("setDialog");
				}else if(data == "0"){
					layer.alert("保存失败！", {icon:0,title:'提示'});
				}else{
					layer.alert(data, {icon:0,title:'提示'});
				}
			}
		});
	}

	function deleteSet(id){
		layui.use('layer', function(){
			var layer = layui.layer;
			layer.confirm('确定要删除吗', {icon:2, title:'确认提示'}, function(index){
				$.getJsonByUrl({
					url:"/portalSet/delete",
					param:{
						setId:id
					},
					callback:function(data){
						if(data>0){
							layer.alert("删除成功！", {icon:0,title:'提示'});
							search(1);
						}else{
							layer.alert("删除失败！", {icon:0,title:'提示'});
						}
					}
				});
				layer.close(index);
			});
		});
	}
	
	return {
		search : search,
		add : add,
		save : save,
		deleteSet:deleteSet
	};
})();
