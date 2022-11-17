var reportIndex = (function() {
	$(function() {

		
		/*传染病管理月报表*/
		$("#tag4").on("click", function(event)
		{
			var selfObj = this;
			selectTag("tagContent4", selfObj);
			monthReportIndex();
		});	
		/*急性传染病防治报表*/
		$("#tag5").on("click", function(event)
		{
			var selfObj = this;
			selectTag("tagContent5", selfObj);
			acuteReportIndex();
		});
		//supervisorIndex();
		//selfCheckIndex();
		monthReportIndex();
	});


	
	/*加载执行情况自查首页*/
	function selfCheckIndex() {
		var length = $('#tagContent2').has('form').length;
			if (length == 0){
			var loadHtmlByUrlOption = {
				url : "/vaccine/statistics/report/selfcheck/index",
				param : null,
				checkRepeat : true,
				insertDiv : "tagContent2",
				errorDiv: "",
				okDiv:""
			};
			$.loadHtmlByUrl(loadHtmlByUrlOption);
		}
	};	

	/*加载传染病管理月报表首页*/
	function monthReportIndex() {
		var length = $('#tagContent4').has('form').length;
			if (length == 0){
			var loadHtmlByUrlOption = {
				url : "/vaccine/statistics/report/monthReport/index",
				param : null,
				checkRepeat : true,
				insertDiv : "tagContent4",
				errorDiv: "",
				okDiv:""
			};
			$.loadHtmlByUrl(loadHtmlByUrlOption);
		}
	};	
	/*加载急性传染病防治报表首页*/
	function acuteReportIndex() {
		var length = $('#tagContent5').has('form').length;
			if (length == 0){
			var loadHtmlByUrlOption = {
				url : "/vaccine/statistics/report/acuteReport/index",
				param : null,
				checkRepeat : true,
				insertDiv : "tagContent5",
				errorDiv: "",
				okDiv:""
			};
			$.loadHtmlByUrl(loadHtmlByUrlOption);
		}
	};	
	return {
	};
})();