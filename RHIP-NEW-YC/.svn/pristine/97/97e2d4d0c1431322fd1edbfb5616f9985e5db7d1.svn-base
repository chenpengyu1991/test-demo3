var heWorkPlanSearch = (function() {
	var title = "年度工作计划";
	
	$(function() {
		$("#heWorkPlanSearchForm").onEnter(search, 1);
		$("#healthEducationActiveBtnSearch").click(function(e) {
			e.preventDefault();
			search(1);
		});
		search(1);

		var $healthEducationActiveResultDiv = $("#healthEducationActiveResultDiv");
		$healthEducationActiveResultDiv.on("click", ".view-link", viewHealthEducationActive);
		$healthEducationActiveResultDiv.on("click", ".edit-link", editHealthEducationActive);
		$healthEducationActiveResultDiv.on("click", ".delete-link", deleteHealthEducationActive);
		/* 添加年度工作计划 */
		$("#activeAdd").click(add);

		// 按钮样式切换
		/*$("#healthEducationActiveBtnSearch").hover(function() {
			$(this).removeClass("search_btn").addClass("search_btn_h");
		}, function() {
			$(this).removeClass("search_btn_h").addClass("search_btn");
		});*/
	});

	function add() {
		/*var dialogParams = {
			id : "healthEducationActive",
			url : "/he/work/plan/add",
			height : 400,
			width : 800,
			title : "添加" + title
		};
		$.dialog(dialogParams);*/
		
		$.post(contextPath+"/he/work/plan/add",
				function(ret){
		    	layui.use(['layer'], function() {
		    		  var layer = layui.layer
		    		  layer.open({
		    			  type: 1,
		    			  id:'addHealthEducationActiveDialog',
		    			  area: ['900px', '400px'],
		    			  title:"添加年度工作计划",
		    			  content: ret
		    		  });
		    		});
		    	});
	}

	function viewHealthEducationActive() {
		var id = $(this).attr("data-id");
		if (!id) {
			return;
		}
		/*var param = {id: id};
		var dialogParams = {
			id : "healthEducationActive",
			url : "/he/work/plan/detail",
            height : 400,
            width : 800,
			param : param,
			title : "查看" + title
		};
		$.dialog(dialogParams);*/
		
		$.post(contextPath+"/he/work/plan/detail",
				{id: id},
				function(ret){
		    	layui.use(['layer'], function() {
		    		  var layer = layui.layer
		    		  layer.open({
		    			  type: 1,
		    			  id:'viewHealthEducationActiveDialog',
		    			  area: ['800px', '400px'],
		    			  title:"查看年度工作计划",
		    			  content: ret
		    		  });
		    		});
		    	});
	}

	function editHealthEducationActive() {
		var id = $(this).attr("data-id");
		if (!id) {
			return;
		}

	/*	var param = {
			id : id
		};
		 编辑年度工作计划 
		var dialogParams = {
			id : "healthEducationActive",
			url : "/he/work/plan/edit",
			param : param,
            height : 400,
            width : 800,
			title : "编辑" + title
		};

		$.dialog(dialogParams);*/
		
		$.post(contextPath+"/he/work/plan/edit",
				{id: id},
				function(ret){
		    	layui.use(['layer'], function() {
		    		  var layer = layui.layer
		    		  layer.open({
		    			  type: 1,
		    			  id:'editHealthEducationActiveDialog',
		    			  area: ['900px', '400px'],
		    			  title:"编辑年度工作计划",
		    			  content: ret
		    		  });
		    		});
		    	});
	}

	function deleteHealthEducationActive() {
		var id = $(this).attr("data-id");
		if (!id) {
			return;
		}

		/*layer.confirm("确认删除?", function(index) {
			$.getJsonByUrl({
				url : "/he/work/plan/delete/" + id,
				callback : function(data) {
					if (data.result)
					{
						search(1);
					} else
					{
						msgUtil.alert("删除失败！");
					}
				}
			});
			layer.close(index);
		});*/
		
		layui.use('layer', function() {
			var layer = layui.layer;
			var index = layer.confirm('确认删除?', {icon:2, title:'确认提示'}, function() {
				$.getJsonByUrl({
					url : contextPath + "/he/work/plan/delete/" + id,
					callback : function(data) {
						if (data.result) {
							layer.close(index);
							search(1);
						} else {
							layer.alert("删除失败！", {icon:0,title:'提示'});
						}
					}
				});
			});
		});
	}

	function search(indexPage) {
		var createBeginTime = new Date($("#createBeginTime").val());
		var createEndTime = new Date($("#createEndTime").val());

		if (createBeginTime > createEndTime)
		{
			layui.use('layer', function() {
				var layer = layui.layer;
				layer.alert("开始时间不能大于结束时间！", {icon:0,title:'提示'});
				
				
			});
			return;
		}
		var searchObj = {
			url : "/he/work/plan/list",
			insertDiv : "healthEducationActiveResultDiv",
			param : {
				indexPage : indexPage
			}
		};
		$("#heWorkPlanSearchForm").submitFormLoadHtml(searchObj);
	}

	function toggle(obj, tableId) {
		$(obj).toggleClass("ico-top");
		$(obj).toggleClass("ico-bottom");
		$("#" + tableId).toggle();
	}
	return {
		search : search,
		toggle : toggle
	};
})();
