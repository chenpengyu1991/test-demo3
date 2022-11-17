var epIodineNutritionKnowledgeSearch = (function() {
	$(function() { 
		var now = new Date();
		$("#samplingTime").val(now.pattern("yyyy"));
        $("#searchForm").onEnter(search, 1);
        $("#btnSearch").click(function() {
            search(1);
        });
        search(1);

		$("#btnAdd").click(function() {
			var dialogParams = {
					id : "d1",
					url : "/ep/iodineNutrition/knowledge/edit",
					height : 300,
					width : 800,
					title : "新建问卷调查"
			};
			$.dialog(dialogParams);
		});
	});

	function search(indexPage) {
		/*
		var beginDate = $("#beginDate").val();
		var endDate = $("#endDate").val();
		if ((!$.isEmpty(beginDate) && $.isEmpty(endDate))
				|| ($.isEmpty(beginDate) && !$.isEmpty(endDate))) {
			layer.alert("封闭日期范围输入不完整");
			return;
		}
		if (!$.isEmpty(beginDate) && !$.isEmpty(endDate)) {
			if (beginDate > endDate) {
				layer.alert("调查日期范围开始日期不能大于截止日期！");
				return;
			}
		}
		*/
		var searchObj = {
			url : "/ep/iodineNutrition/knowledge/list",
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
				url : "/ep/iodineNutrition/knowledge/edit",
				height : 260,
				width : 800,
				title : "修改问卷调查",
				param : {
					id : id
				}
		};
		$.dialog(dialogParams);
	}
	
	function remove(id) {
		var index = layer.confirm("确认删除此问卷调查信息？", {icon:2, title:'确认提示'}, function() {
			var option = {
				url : "/ep/iodineNutrition/knowledge/delete",
				param : {
					id : id
				},
				callback : function(result) {
					layui.use('layer', function() {
						var layer = layui.layer;
						layer.alert("result.message", {icon:0,title:'提示'});
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