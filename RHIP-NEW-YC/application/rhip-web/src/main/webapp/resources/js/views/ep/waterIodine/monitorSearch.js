var epWaterIodineMonitorSearch = (function() {
	$(function() { 
        $("#searchForm").onEnter(search, 1);
        $("#btnSearch").click(function() {
        	/*
	        if ($("#beginDate").val() > $("#endDate").val()) {
		        layer.alert("时间范围开始日期不能大于截止日期！");
	        } else {
		        search(1);
	        }
	        */
        	search(1);
        });
        search(1);

		$("#btnAdd").click(function(e) {
        	baseLayoutLoad.pushMainContent("/ep/waterIodine/monitor/edit");
		});
   
	});

	function search(indexPage) {
		var searchObj = {
			url : "/ep/waterIodine/monitor/list",
			insertDiv : "listDiv",
			param : {
				indexPage : indexPage
			}
		};
		$("#searchForm").submitFormLoadHtml(searchObj);
	};
	
	function edit(id) {
		var param = {
			id : id
		};
		baseLayoutLoad.pushMainContent("/ep/waterIodine/monitor/edit", param);
	}
	
	function view(id) {
		var param = {
			id : id
		};
		baseLayoutLoad.pushMainContent("/ep/waterIodine/monitor/view", param);
	}
	
	function remove(id) {
		var index = layer.confirm("确认删除此监测记录？", {icon:2, title:'确认提示'}, function() {
			var option = {
				url : "/ep/waterIodine/monitor/delete",
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
		view : view,
		remove : remove
	};
})();