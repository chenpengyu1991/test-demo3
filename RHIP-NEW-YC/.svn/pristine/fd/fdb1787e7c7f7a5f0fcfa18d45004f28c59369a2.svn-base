var notReportSuspected = (function() {
	$(function() {
		searchNotReportLeprosy(1);
        $("#reportBtnSearch").click(function() {
        	searchNotReportLeprosy(1);
        });
        
        $("#suspectedSearchNotForm").onEnter(searchNotReportLeprosy, 1);
	});
	
	
	function searchNotReportLeprosy(indexPage) {
		var searchObjT = {
				url : "/idm/leprosy/notReport/list",
				insertDiv : "listDivNot",
//                wait : true,
				param : {
					indexPage : indexPage
				}
			};
		$("#suspectedSearchNotForm").submitFormLoadHtml(searchObjT);
	}
	
	function initAddSuspected(reportId, statusId) {
		$("#top_allSuspected").hide();
		var pageIndex = $("#currentPageSuspected").val();
		$.loadHtmlByUrl({
			url : "/idm/leprosy/notReport/add",
			insertDiv :"detailDivSuspected",
            wait : true,
			param : {
				reportId: reportId,
				pageIndex: pageIndex,
				statusId: statusId
			}
			
		});
		$.removeDialog("notReportDia");
		$("#detailDivSuspected").show();
	}
	
	return {
        searchNotReportLeprosy: searchNotReportLeprosy,
        initAddSuspected: initAddSuspected
	};
	
})();

$(document).ready(function () { 
	//按钮样式切换 
	$("#reportBtnSearch").hover( 
		function () { 
		$(this).removeClass("search_btn").addClass("search_btn_h"); 
		}, 
		function () { 
		$(this).removeClass("search_btn_h").addClass("search_btn"); 
		} 
	); 

});