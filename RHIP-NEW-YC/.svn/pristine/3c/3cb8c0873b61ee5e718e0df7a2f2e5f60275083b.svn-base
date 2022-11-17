define(function() {

	function load() {
		$(function () {
			$("#montiorSearch").click(function () {
				search(1);
			});
			$("#montiorSearch").onEnter(search, 1);
			search(1);

			var logResultDiv = $("#logResultDiv");
			logResultDiv.on("click", ".view-link", logDetail);
		});
	}
	function search(indexPage) {
		indexPage = ($.isEmpty(indexPage)?1:indexPage);
		var searchObj = {
			url : "/wsMonitor/log/list",
			insertDiv : "logResultDiv",
			param : {
				indexPage : indexPage
			},
			callback: function(data) {
				$("#pageIndex").val(indexPage);
			}
		};
		$("#logSearchForm").submitFormLoadHtml(searchObj);
	};
	function logDetail(){
		var id = $(this).attr("data-id");
		$("#top_all").hide();
		$.loadHtmlByUrl({
			url : "/wsMonitor/log/view",
			insertDiv :"detailDiv",
			param : {id:id}
		});
		$("#detailDiv").show();
	}

	//注释代码移动到view.js
	//function returnSearch(){
	//	$("#detailDiv").empty();
	//	$("#top_all").show();
	//	searchReportRecord(1);
	//};

	//function toggleMessage(obj,divId1,divId2){
	//	$(obj).toggleClass("ico-top");
	//	$(obj).toggleClass("ico-bottom");
	//	$("#" + divId1).toggle();
	//	$("#" + divId2).toggle();
	//	if($(obj).hasClass('ico-top')){
	//		$(obj).text('收起');
	//	}else{
	//		$(obj).text('查看详细');
	//	}
    //
	//}

	function toggle(obj,tableId) {
		$(obj).toggleClass("ico-top");
		$(obj).toggleClass("ico-bottom");
		$("#" + tableId).toggle();
	};
	return {
		load : load,
        search : search,
		logDetail:logDetail,
		//returnSearch:returnSearch,
		//toggleMessage:toggleMessage,
		toggle:toggle
	};
});

$(document).ready(function () { 
	//按钮样式切换 
	$("#montiorSearch").hover(
		function () { 
		$(this).removeClass("search_btn").addClass("search_btn_h"); 
		}, 
		function () { 
		$(this).removeClass("search_btn_h").addClass("search_btn"); 
		} 
	); 

});
