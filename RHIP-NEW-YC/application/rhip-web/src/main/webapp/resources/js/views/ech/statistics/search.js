var echStatisticsSearch = (function() {
	var validate = null;
	$(function() {
		validate = $("#searchForm").easyValidate();
		$("#btnSearch").click(function(e) {
			e.preventDefault();
			statisticsSearch();
		});
		$("#searchForm").onEnter(statisticsSearch);
	    $("#echStatisticsExport").on("click", function(event) {
	    	event.preventDefault();
	    	$("#echStatisticsTable").exportExcel("老年人中医药健康管理报表统计");
	    });		
		statisticsSearch();
	});

	function statisticsSearch() {
		var result = validate.validateForm();
    	if(!result){
    		return;
    	} 		
		var searchObj = {
			url : "/ech/statistics/list",
			insertDiv : "resultDiv"
		};
		$("#searchForm").submitFormLoadHtml(searchObj);
	}
    function search(){
        disableChangeConfirm();
        $("#detailDiv").empty();
        statisticsSearch();
        $("#top_all").show();
    }
	
	return {
		statisticsSearch : statisticsSearch
	}
})();