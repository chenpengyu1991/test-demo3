var summarySelfSearch = (function() {
	$(function() { 	
        $("#summarySelfBtnSearch").click(function() {
        	searchSummary();
        });	
        $("#selfcheckExport").click(function() {
        	$("#selfchecktable").exportExcel("《传染病防治法》执行情况自查报表");
        });	        
       	$("#selfSummaryUnitCodeId option[value='']").remove();//删除‘请选择’，统计时，必须选择一个单位
        searchSummary();
        $("#summarySelfSearchForm").onEnter(searchSummary, 1);
	});
	/*传染病管理及督导画面查询*/
	function searchSummary() {
		var searchObj = {
			url : "/idm/statistics/report/selfcheck/summaryList",
			insertDiv : 'summarySelfResultDiv',
			param : {}
		};
		$("#summarySelfSearchForm").submitFormLoadHtml(searchObj);
	};
	

	return {
		searchSummary:searchSummary
	};
})();