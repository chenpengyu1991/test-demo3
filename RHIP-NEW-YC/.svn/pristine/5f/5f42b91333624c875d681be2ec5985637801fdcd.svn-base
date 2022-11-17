var healthEducationActiveSearch = (function() {
	var title = "健康教育活动";
	
	$(function() {
		var isADMIN = $("#isADMIN").val();
		if(isADMIN =="01"){
			$("select[name='gbcode']").append("<option title='健康教育所' value='_999'>健康教育所</option>");
		}

		/* 健康教育活动查询 */
		$("#healthEducationActiveSearchForm").onEnter(search, 1);
		$("#healthEducationActiveBtnSearch").click(function(e) {
			e.preventDefault();
			search(1);
		});
		search(1);

		var $healthEducationActiveResultDiv = $("#healthEducationActiveResultDiv");
		$healthEducationActiveResultDiv.on("click", ".view-link", viewHealthEducationActive);
		$healthEducationActiveResultDiv.on("click", ".edit-link", editHealthEducationActive);
		$healthEducationActiveResultDiv.on("click", ".delete-link", deleteHealthEducationActive);
		/* 添加健康教育活动 */
		$("#activeAdd").click(add);

		// 按钮样式切换
		/*$("#healthEducationActiveBtnSearch").hover(function() {
			$(this).removeClass("search_btn").addClass("search_btn_h");
		}, function() {
			$(this).removeClass("search_btn_h").addClass("search_btn");
		});*/

	
		var systemType = $("#healthEducationActiveSearchForm").find("input[name='systemType']").val();
		if ("1" == systemType)
		{
			title = "宣传培训";
		}

	});

	function add() {
		$("#heActiveSearchDivId").hide();
		$("#heActiveDetailDivId").show();
		/*var dialogParams = {
			id : "healthEducationActive",
			url : "/he/active/add",
			height : 500,
			width : 950,
			title : "添加" + title
		};
		var systemType = $("#healthEducationActiveSearchForm").find("input[name='systemType']").val();
		if (systemType)
		{
			dialogParams.param = {
				systemType : systemType
			};
		}
		$.dialog(dialogParams);*/
		var systemType = $("#healthEducationActiveSearchForm").find("input[name='systemType']").val();
		/*$.post(contextPath+"/he/active/add",
			{ systemType : systemType },
				function(ret){
		    	layui.use(['layer'], function() {
		    		  var layer = layui.layer
		    		  layer.open({
		    			  type: 1,
		    			  id:'addHealthEducationActiveDialog',
		    			  area: ['950px', '550px'],
		    			  title:"添加" + title,
		    			  content: ret
		    		  });
		    		});
		    	});*/

		var loadHtmlByUrlOption = {
			url: "/he/active/add",
			insertDiv: "heActiveDetailDivId",
			param: {
				systemType : systemType
			}
		};
		$.loadHtmlByUrl(loadHtmlByUrlOption);
	}

	function setSystemType($a, dialogParams) {
		var systemType = $a.attr("data-system-type");
		if (systemType)
		{
			dialogParams.systemType = systemType;
		}
	}

	function viewHealthEducationActive() {
		var id = $(this).attr("data-id");
		if (!id)
		{
			return;
		}
		/*var param = {};
		var dialogParams = {
			id : "healthEducationActive",
			url : "/he/active/detail/" + id,
			height : 500,
			param : param,
			width : 950,
			title : "查看" + title
		};
		setSystemType($(this), dialogParams);
		$.dialog(dialogParams);*/
		
		$.post(contextPath+"/he/active/detail/" + id,
			function(ret){
	    	layui.use(['layer'], function() {
	    		  var layer = layui.layer
	    		  layer.open({
	    			  type: 1,
	    			  id:'healthEducationActiveDialog',
	    			  area: ['950px', '500px'],
	    			  title:"查看" + title,
	    			  content: ret
	    		  });
	    		});
	    	});
	}

	function editHealthEducationActive() {
		$("#heActiveSearchDivId").hide();
		$("#heActiveDetailDivId").show();
		var id = $(this).attr("data-id");
		if (!id)
		{
			return;
		}

		/*var param = {
			id : id
		};
		 编辑健康教育活动 
		var dialogParams = {
			id : "healthEducationActive",
			url : "/he/active/edit",
			param : param,
			height : 500,
			width : 990,
			title : "编辑" + title
		};

		$.dialog(dialogParams);*/
		
		/*$.post(contextPath+"/he/active/edit",
				{id : id},
				function(ret){
		    	layui.use(['layer'], function() {
		    		  var layer = layui.layer
		    		  layer.open({
		    			  type: 1,
		    			  id:'editHealthEducationActiveDialog',
		    			  area: ['950px', '500px'],
		    			  title:"编辑" + title,
		    			  content: ret
		    		  });
		    		});
		    	});*/
		var loadHtmlByUrlOption = {
			url: "/he/active/edit",
			insertDiv: "heActiveDetailDivId",
			param: {
				id : id
			}
		};
		$.loadHtmlByUrl(loadHtmlByUrlOption);
	}

	function deleteHealthEducationActive() {
		var id = $(this).attr("data-id");
		if (!id)
		{
			return;
		}

		layui.use('layer', function(){
			var layer = layui.layer;
			var index = layer.confirm('确认删除?', {icon:2, title:'确认提示'}, function(){
				$.getJsonByUrl({
					url : contextPath + "/he/active/delete/" + id,
					callback : function(data) {
						if (data.result) {
							layer.close(index);
							healthEducationActiveSearch.search(1);
						} else {
							layer.alert("删除失败！", {icon:0,title:'提示'});
						}
					}
				});
			});
		});
		
		/*layer.confirm("确认删除?", function(index) {
			$.getJsonByUrl({
				url : "/he/active/delete/" + id,
				callback : function(data) {
					if (data.result)
					{
						healthEducationActiveSearch.search(1);
					} else
					{
						msgUtil.alert("删除失败！");
					}
				}
			});
			layer.close(index);
		});*/
	}

	function search(indexPage) {
		var createBeginTime = new Date($("#createBeginTime").val());
		var createEndTime = new Date($("#createEndTime").val());

		if (createBeginTime > createEndTime)
		{
			layui.use('layer', function(){
    			var layer = layui.layer;
    			layer.alert("开始时间不能大于结束时间！", {icon:0,title:'提示'});
    		});
			/*msgUtil.alert("开始时间不能大于结束时间");*/
			return;
		}
		var searchObj = {
			url : "/he/active/list",
			insertDiv : "healthEducationActiveResultDiv",
			param : {
				indexPage : indexPage
			}
		};
		$("#healthEducationActiveSearchForm").submitFormLoadHtml(searchObj);
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
