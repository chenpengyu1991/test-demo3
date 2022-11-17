var heCopySearch = (function() {
	var title = "健康教育活动";
	$(function() {
		$("select[name='gbcode']").append("<option title='健康教育所' value='_999'>健康教育所</option>");

		/* 健康教育活动查询 */
		$("#heCopySearchForm").onEnter(search, 1);
		$("#heCopyBtnSearch").click(function(e){
			e.preventDefault();
			search(1);
		});
		search(1);

		var $heCopyResultDiv = $("#heCopyResultDiv");
		$heCopyResultDiv.on("click", ".view-link", viewheCopy);
		$heCopyResultDiv.on("click", ".edit-link", editheCopy);
		$heCopyResultDiv.on("click", ".delete-link", deleteheCopy);
		/* 添加*/
		$("#heCopyAdd").click(add);

	});

	function add() {
		/*var dialogParams = {
			id : "heCopy",
			url : "/he/copy/add",
			height : 500,
			width : 950,
			title : "添加稿件"
		};
		$.dialog(dialogParams);*/
		
		$.post(contextPath+'/he/copy/add', {},
		function(ret) {
		  layer.open({
			  type: 1,
			  id:'heCopy',
			  area: ['950px', '550px'],
			  title:'添加稿件',
			  content: ret
		  });
		});
	}

	function viewheCopy() {
		var id = $(this).attr("data-id");
		if (!id)
		{
			return;
		}
		/*var param = {id:id};
		var dialogParams = {
			id : "heCopy",
			url : "/he/copy/detail",
			height : 500,
			param : param,
			width : 950,
			title : "查看稿件"
		};
		$.dialog(dialogParams);*/
		
		$.post(contextPath+'/he/copy/detail', {id:id},
			function(ret) {
			  layer.open({
				  type: 1,
				  id:'heCopy',
				  area: ['950px', '550px'],
				  title:'查看稿件',
				  content: ret
			  });
		});
	}

	function editheCopy() {
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
			id : "heCopy",
			url : "/he/copy/edit",
			param : param,
			height : 500,
			width : 990,
			title : "编辑稿件"
		};

		$.dialog(dialogParams);*/
		
		$.post(contextPath+'/he/copy/edit', {
			id:id
		},
		function(ret) {
		  layer.open({
			  type: 1,
			  id:'heCopy',
			  area: ['950px', '550px'],
			  title:'编辑稿件',
			  content: ret
		  });
		});
	}

	function deleteheCopy() {
		var id = $(this).attr("data-id");
		if (!id)
		{
			return;
		}

		layer.confirm('确认删除?', {icon:2, title:'确认提示'}, function(index){
			$.getJsonByUrl({
				url : "/he/copy/delete/" + id,
				callback : function(data) {
					if (data.result)
					{
						heCopySearch.search(1);
					} else
					{
						layer.alert("删除失败！", {icon:0,title:'提示'});
					}
				}
			});
			layer.close(index);
		});
	}

	function search(indexPage) {
		var searchObj = {
			url : "/he/copy/list",
			insertDiv : "heCopyResultDiv",
			param : {
				indexPage : indexPage
			}
		};
		$("#heCopySearchForm").submitFormLoadHtml(searchObj);
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
