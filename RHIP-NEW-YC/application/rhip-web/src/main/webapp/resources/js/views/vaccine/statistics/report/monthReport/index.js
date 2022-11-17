var monthReportIndex = (function() {
	$(function() { 

        /*狂犬病防治*/
        $("#rabiesId").click(function() {
        	statisticsCommon.changeActive('monthReportId','rabiesId');
        	loadRabiesSearch();
        });        
        loadRabiesSearch();
	});


	/*加载 狂犬病防治 查询*/
	function loadRabiesSearch() {
		var loadHtmlByUrlOption = {
			url : "/vaccine/statistics/report/monthReport/rabiesSearch",
			param : {},
			checkRepeat : true,
			insertDiv : "monthReportSearchDiv",
			errorDiv: "",
			okDiv:""
		};
		$.loadHtmlByUrl(loadHtmlByUrlOption);
	};	
	return {
	};
})();