var monthReportIndex = (function() {
	$(function() { 
        /*传染病访视*/
        $("#interviewId").click(function() {
        	statisticsCommon.changeActive('monthReportId','interviewId');
        	loadInterviewSearch();
        });
        /*细菌性痢疾流调*/
        $("#dysenteryId").click(function() {
        	statisticsCommon.changeActive('monthReportId','dysenteryId');
        	loadDysenterySearch();
        });
        /*狂犬病防治*/
        $("#rabiesId").click(function() {
        	statisticsCommon.changeActive('monthReportId','rabiesId');
        	loadRabiesSearch();
        });        
        loadInterviewSearch();
	});
	/*加载 传染病访视 查询*/
	function loadInterviewSearch() {
		var loadHtmlByUrlOption = {
			url : "/idm/statistics/report/monthReport/interviewSearch",
			param : {},
			checkRepeat : true,
			insertDiv : "monthReportSearchDiv",
			errorDiv: "",
			okDiv:""
		};
		$.loadHtmlByUrl(loadHtmlByUrlOption);
	};	
	/*加载 细菌性痢疾流调 查询*/
	function loadDysenterySearch() {
		var loadHtmlByUrlOption = {
			url : "/idm/statistics/report/monthReport/dysenterySearch",
			param : {},
			checkRepeat : true,
			insertDiv : "monthReportSearchDiv",
			errorDiv: "",
			okDiv:""
		};
		$.loadHtmlByUrl(loadHtmlByUrlOption);
	};
	/*加载 狂犬病防治 查询*/
	function loadRabiesSearch() {
		var loadHtmlByUrlOption = {
			url : "/idm/statistics/report/monthReport/rabiesSearch",
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