var acuteReportIndex = (function() {
	$(function() { 
        /*按月汇总*/
        $("#acuteMonthId").click(function() {
        	statisticsCommon.changeActive('acuteReportId','acuteMonthId');
        	loadAcuteMonthSearch();
        });
        /*按年汇总*/
        $("#acuteYearId").click(function() {
        	statisticsCommon.changeActive('acuteReportId','acuteYearId');
        	loadAcuteYearSearch();
        });
        loadAcuteMonthSearch();
	});
	/*加载 按月汇总 查询*/
	function loadAcuteMonthSearch() {
		var loadHtmlByUrlOption = {
			url : "/vaccine/statistics/report/acuteReport/monthSearch",
			param : {},
			checkRepeat : true,
			insertDiv : "acuteReportSearchDiv",
			errorDiv: "",
			okDiv:""
		};
		$.loadHtmlByUrl(loadHtmlByUrlOption);
	};	
	/*加载 按年汇总 查询*/
	function loadAcuteYearSearch() {
		var loadHtmlByUrlOption = {
			url : "/vaccine/statistics/report/acuteReport/yearSearch",
			param : {},
			checkRepeat : true,
			insertDiv : "acuteReportSearchDiv",
			errorDiv: "",
			okDiv:""
		};
		$.loadHtmlByUrl(loadHtmlByUrlOption);
	};
	return {
	};
})();