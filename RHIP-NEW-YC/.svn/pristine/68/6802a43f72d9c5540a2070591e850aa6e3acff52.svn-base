var epIodineNutritionMonitorSearch = (function() {
	$(function() { 
		var now = new Date();
		$("#samplingTime").val(now.pattern("yyyy"));
        $("#searchForm").onEnter(search, 1);
        $("#btnSearch").click(function() {
            search(1);
        });
        search(1);

        /**
         * 点击按钮弹出菜单
         */
		$("#btnAdd").click(function(e) {
            $("#menubox").show();
            $(document).on("click", clickSomeWhereListener);
		});
   
		/**点击其他地方隐藏菜单
		 * 
		 */
		function clickSomeWhereListener(e) {
			if (e.target.id != "btnAdd") {
        		$("#menubox").hide();
        		$(document).off("click", clickSomeWhereListener);
        	}
		}
        
        /**
         * 点击菜单项执行对应操作
         */
        $("#menubox li a").click(function(e){
        	var type = $(this).data("type");
        	var params =  {
        			crowd : type
			};
        	baseLayoutLoad.pushMainContent("/ep/iodineNutrition/monitor/edit", params);
        });
	});

	function search(indexPage) {
		/*
		var beginDate = $("#beginDate").val();
		var endDate = $("#endDate").val();
		if ((!$.isEmpty(beginDate) && $.isEmpty(endDate))
				|| ($.isEmpty(beginDate) && !$.isEmpty(endDate))) {
			layer.alert("调查日期范围输入不完整！");
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
			url : "/ep/iodineNutrition/monitor/list",
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
		baseLayoutLoad.pushMainContent("/ep/iodineNutrition/monitor/edit", param);
	}
	
	function view(id) {
		var param = {
			id : id
		};
		baseLayoutLoad.pushMainContent("/ep/iodineNutrition/monitor/view", param);
	}
	
	function remove(id) {
		var index = layer.confirm("确认删除此监测记录？", {icon:2, title:'确认提示'}, function() {
			var option = {
				url : "/ep/iodineNutrition/monitor/delete",
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