var hmFissureSealantQuerySearch = (function() {
	$(function() { 
        $("#searchForm").onEnter(search, 1);
        $("#btnQuerySearch").click(function() {
            search(1);
        });
        search(1);
        $("#btnImport").click(function() {
        	showImport();
        });
        $("#btnReport").click(function() {
        	baseLayoutLoad.pushMainContent("/hm/fissureSealant/reportSearch");
        });
	});
	
	function showImport() {
		var dialogParams = {
				id : "d1",
				url : "/hm/fissureSealant/showImport",
				param : {},
				height : 350,
				width : 550,
				title : "导入"
		};
		$.dialog(dialogParams);
	}

	function search(indexPage) {
		var searchObj = {
			url : "/hm/fissureSealant/list",
			insertDiv : "listDiv",
			param : {
				indexPage : indexPage
			}
		};
		$("#searchForm").submitFormLoadHtml(searchObj);
	}
	
	function edit(id) {
		var dialogParams = {
				id : "d1",
				url : "/hm/fissureSealant/edit",
				param : {
					id : id
				},
				height : 350,
				width : 550,
				title : "编辑"
		};
		$.dialog(dialogParams);
	}
	
	function view(id) {
		var dialogParams = {
				id : "d1",
				url : "/hm/fissureSealant/view",
				param : {
					id : id
				},
				height : 350,
				width : 550,
				title : "查看"
		};
		$.dialog(dialogParams);
	}
	
	function remove(id) {
		var index = layer.confirm("确认删除该学生窝沟数据？", {icon:2, title:'确认提示'}, function() {
			var option = {
				url : "/hm/fissureSealant/delete",
				param : {
					id : id
				},
				callback : function(result) {
					var layer = layui.layer;
					if (result != 0) {
						var index = layer.alert("删除成功！", {icon:0,title:'提示'}, function() {
							search(1)
							layer.close(index);
						});
					} else {
						layer.alert("删除失败！", {icon:0,title:'提示'});
					}
				}
			};
			$.getJsonByUrl(option);
			layer.close(index);
		});
	}
	
	function printFs(id) {
		var url = contextPath + "/hm/fissureSealant/print?id=" + id;
		util.printPage(url);
	}

	return {
		search : search,
		edit : edit,
		view : view,
		printFs : printFs,
		remove : remove
	};
})();