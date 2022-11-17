var hsaReportRecordList = (function() {

	var currentPage=1;
	
	var appProcessor = {
		receive : receive,
		deal : deal,
		visit : visit,
	};

	$(function() {

		$("#hsa-report-record-search-form").keypress(function(e) {
			var key = e.which;
			if (key == 13)
			{
				search(1);
			}
		});

		$("#hsa-inspRecord-locationList-search_btn").click(function(e) {
			e.preventDefault();
			search(1);
		});

		$("#hsa-report-record-add-btn").click(function(e) {
			e.preventDefault();
			add();
		});

		$("#hsa-report-record-list-result-content").on("click", ".view-link", function(event) {
			event.preventDefault();
			showInput();
			var loadHtmlByUrlOption = {
				url : "/hsa/inspRecord/viewReportRecord",
				insertDiv : "hsa-report-record-input-content",
				param : {
					id : $(this).attr("data-id")
				}
			};
			$.loadHtmlByUrl(loadHtmlByUrlOption);
		});

		$("#hsa-report-record-list-result-content").on("click", ".modify-link", function(event) {
			event.preventDefault();
			showInput();
			var loadHtmlByUrlOption = {
				url : "/hsa/inspRecord/editReportRecord",
				insertDiv : "hsa-report-record-input-content",
				param : {
					id : $(this).attr("data-id")
				}
			};
			$.loadHtmlByUrl(loadHtmlByUrlOption);
		});

		$("#hsa-report-record-list-result-content").on("click", ".app-link", function(e) {
			e.preventDefault();
			var id = $(this).attr("data-id");
			var type = $(this).data("type");
			if (id && type)
			{
				var func = appProcessor[type];
				if (func)
				{
					func(id);
				}
			}
		});

		search(1);
	});

	function receive(id) {
		/*layer.confirm("确认接收？", function(index) {
			var loadHtmlByUrlOption = {
				url : "/hsa/inspRecord/receiveReportRecord",
				param : {
					id : id
				},
				callback : function(data) {
					if (data == true)
					{
						layer.confirm("接收成功!填写处理意见?", function(index) {
							deal(id);
							layer.close(index);
						});
						search(currentPage);
					} else
					{
						layer.alert("接收失败！");
					}
				}
			};
			$.loadHtmlByUrl(loadHtmlByUrlOption);
			layer.close(index);
		});*/
		
		layui.use('layer', function() {
			var layer = layui.layer;
			layer.confirm('确认接收？', {icon:1, title:'确认提示'}, function(){
				var loadHtmlByUrlOption = {
						url : "/hsa/inspRecord/receiveReportRecord",
						param : {
							id : id
						},
						callback : function(data) {
							if (data == true)
							{
								layer.confirm("接收成功!填写处理意见?", {icon:1, title:'确认提示'}, function() {
									layer.closeAll();
									deal(id);
								});
								search(currentPage);
							} else
							{
								layer.alert("接收失败！", {icon:0,title:'提示'});
							}
						}
					};
					$.loadHtmlByUrl(loadHtmlByUrlOption);
			});
		});
	}

	function deal(id) {

		var param = {
			id : id
		};

		/*var dialogObj = {
			url : "/hsa/inspRecord/showDealReportRecord",
			title : "处理",
			id : "hsa-report-record-app-dialog",
			param : param
		};
		$.dialog(dialogObj);*/

		 $.post(contextPath+'/hsa/inspRecord/showDealReportRecord',
				 param, 
				function(ret){
         	layui.use(['layer'], function() {
         		  var layer = layui.layer
         		  layer.open({
         			  type: 1,
         			  id:'show-hsa-deal-report-dialog',
         			  area: ['600px', '450px'],
         			  title:'处理',
         			  content: ret
         		  });
         		});
         	});
	}
	function visit(id) {
		var param = {
			id : id
		};

		/*var dialogObj = {
			url : "/hsa/inspRecord/showVisitReportRecord",
			title : "回访",
			id : "hsa-report-record-app-dialog",
			param : param
		};
		$.dialog(dialogObj);*/

		 $.post(contextPath+'/hsa/inspRecord/showVisitReportRecord',
				 param, 
				function(ret){
         	layui.use(['layer'], function() {
         		  var layer = layui.layer
         		  layer.open({
         			  type: 1,
         			  id:'show-hsa-visit-report-dialog',
         			  area: ['600px', '450px'],
         			  title:'回访',
         			  content: ret
         		  });
         		});
         	});
	}

	function add() {
		showInput();
		var loadHtmlByUrlOption = {
			url : "/hsa/inspRecord/addReportRecord",
			insertDiv : "hsa-report-record-input-content",
			param : {}
		};
		$.loadHtmlByUrl(loadHtmlByUrlOption);
	}

	function checkDate() {
		var startDate = $("#hsa-startDate").val();
		var endDate = $("#hsa-endDate").val();
		if (startDate && endDate && startDate > endDate)
		{
			layui.use('layer', function(){
    			var layer = layui.layer;
    			layer.alert("开始时间不能大于结束时间！", {icon:0,title:'提示'});
    		});
			return false;
		}
		return true;
	}

	function back() {
		$("#hsa-report-record-content").show();
		$("#hsa-report-record-input-content").hide();
	}

	function showInput() {
		$("#hsa-report-record-content").hide();
		$("#hsa-report-record-input-content").show();
	}

	
	function search(indexPage) {

		currentPage=indexPage;
		
		if (!HsaCommon.checkFromToDate("#hsa-report-record-search-startDiscoveryDate", "#hsa-report-record-search-endDiscoveryDate"))
		{
			return;
		}
		if (!HsaCommon.checkFromToDate("#hsa-report-record-search-startCreateDate", "#hsa-report-record-search-endCreateDate"))
		{
			return;
		}

		var searchObj = {
			url : "/hsa/inspRecord/reportRecordListResult",
			insertDiv : "hsa-report-record-list-result-content",
			param : {
				indexPage : indexPage,
			}
		};
		$("#hsa-report-record-search-form").submitFormLoadHtml(searchObj);
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