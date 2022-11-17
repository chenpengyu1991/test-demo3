var heIndividualSearch = (function() {
	var title = "个体化健康教育";
	
	$(function() {
		var isADMIN = $("#isADMIN").val();
		if(isADMIN =="01"){
			$("select[name='gbcode']").append("<option title='健康教育所' value='_999'>健康教育所</option>");
		}

		/* 健康教育活动查询 */
		$("#heIndividualSearchForm").onEnter(search, 1);
		$("#heIndividualBtnSearch").click(function(e) {
			e.preventDefault();
			search(1);
		});
		search(1);

		var heIndividualResultDiv = $("#heIndividualResultDiv");
		heIndividualResultDiv.on("click", ".view-link", viewHealthEducationActive);
		heIndividualResultDiv.on("click", ".edit-link", editHealthEducationActive);
		heIndividualResultDiv.on("click", ".delete-link", deleteHealthEducationActive);
		/* 添加健康教育活动 */
		$("#individualAdd").click(add);

		// 按钮样式切换
		/*$("#heIndividualBtnSearch").hover(function() {
			$(this).removeClass("search_btn").addClass("search_btn_h");
		}, function() {
			$(this).removeClass("search_btn_h").addClass("search_btn");
		});*/


	});

	function add() {
		/*var dialogParams = {
			id : "healthEducationActive",
			url : "/he/individual/add",
			height : 500,
			width : 950,
			title : "添加" + title
		};
		$.dialog(dialogParams);*/
		
		$.post(contextPath+"/he/resource/add",
        		{ indexPage : 1
			     }, 
			function(ret){
        	layui.use(['layer'], function() {
        		  var layer = layui.layer
        		  layer.open({
        			  type: 1,
        			  id:'addIndividualHealthEducationActiveDialog',
        			  area: ['950px', '500px'],
        			  title:"添加个体化健康教育",
        			  content: ret
        		  });
        		});
        	});
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
			url : "/he/individual/detail/" + id,
			height : 500,
			param : param,
			width : 950,
			title : "查看" + title
		};
		$.dialog(dialogParams);*/
		
		$.post(contextPath+"/he/individual/detail/" + id,
			function(ret){
        	layui.use(['layer'], function() {
        		  var layer = layui.layer
        		  layer.open({
        			  type: 1,
        			  id:'viewIndividualHealthEducationActiveDialog',
        			  area: ['950px', '500px'],
        			  title:"查看个体化健康教育",
        			  content: ret
        		  });
        		});
        	});
	}

	function editHealthEducationActive() {
		var id = $(this).attr("data-id");
		if (!id)
		{
			return;
		}

		/*var param = {
			id : id
		};
		var dialogParams = {
			id : "healthEducationActive",
			url : "/he/individual/edit",
			param : param,
			height : 500,
			width : 990,
			title : "编辑" + title
		};

		$.dialog(dialogParams);*/
		
		$.post(contextPath+"/he/individual/edit",
				{id : id},
				function(ret) {
	        	layui.use(['layer'], function() {
	        		  var layer = layui.layer
	        		  layer.open({
	        			  type: 1,
	        			  id:'editIndividualHealthEducationActiveDialog',
	        			  area: ['950px', '500px'],
	        			  title:"编辑个体化健康教育",
	        			  content: ret
	        		  });
	        		});
	        	});
	}

	function deleteHealthEducationActive() {
		var id = $(this).attr("data-id");
		if (!id)
		{
			return;
		}

		/*layer.confirm("确认删除?", function(index) {
			$.getJsonByUrl({
				url : "/he/individual/delete/" + id,
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
		
		layui.use('layer', function(){
			var layer = layui.layer;
			var index = layer.confirm('确认删除?', {icon:2, title:'确认提示'}, function(){
				$.getJsonByUrl({
					url : contextPath + "/he/individual/delete/" + id,
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
			
			return;
		}
		var searchObj = {
			url : "/he/individual/list",
			insertDiv : "heIndividualResultDiv",
			param : {
				indexPage : indexPage
			}
		};
		$("#heIndividualSearchForm").submitFormLoadHtml(searchObj);
	}

	return {
		search : search
	};
})();
