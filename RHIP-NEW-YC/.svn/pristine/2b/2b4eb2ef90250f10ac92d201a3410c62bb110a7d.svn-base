var epIodineNutritionSamplingSearch = (function() {
	$(function() { 
        $("#searchForm").onEnter(search, 1);
        $("#btnSearch").click(function() {
            search(1);
        });
        search(1);

		$("#btnAdd").click(function() {
			var dialogParams = {
					id : "d1",
					url : "/ep/iodineNutrition/samplingEdit",
					height : 250,
					width : 550,
					title : "创建抽样"
			};
			$.dialog(dialogParams);
		});
	});

	function search(indexPage) {
		var searchObj = {
			url : "/ep/iodineNutrition/samplingList",
			insertDiv : "listDiv",
			param : {
				indexPage : indexPage
			}
		};
		$("#searchForm").submitFormLoadHtml(searchObj);
	};
	
	function edit(id) {
		var dialogParams = {
				id : "d1",
				url : "/ep/iodineNutrition/samplingEdit",
				height : 250,
				width : 450,
				title : "修改抽样",
				param : {
					id : id
				}
		};
		$.dialog(dialogParams);
	}
	
	function remove(id) {
		var index = layer.confirm("确认删除此抽样信息？", {icon:2, title:'确认提示'}, function() {
			var option = {
				url : "/ep/iodineNutrition/samplingDelete",
				param : {
					id : id
				},
				callback : function(result) {
					layui.use('layer', function() {
						var layer = layui.layer;
						layer.alert(result.message, {icon:0,title:'提示'});
					});
					if (result.success) {
						search($("#_indexPage").val());
					}
				}
			};
			$.getJsonByUrl(option);
			layer.close(index);
		});
	}

	return {
		search : search,
		edit : edit,
		remove : remove
	};
})();