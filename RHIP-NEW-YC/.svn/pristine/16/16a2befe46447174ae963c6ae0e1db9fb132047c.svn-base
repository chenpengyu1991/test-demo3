var reportIndex = (function() {
	$(function() {

		/*传染病管理及督导*/
		$("#tag1").on("click", function(event)
		{	
			var selfObj = this;
			selectTag("tagContent1", selfObj);
			supervisorIndex();
		});
		/*执行情况自查*/
		$("#tag2").on("click", function(event)
		{
			var selfObj = this;
			selectTag("tagContent2", selfObj);
			selfCheckIndex();
		});
		/*手足口病采样登记*/
		$("#tag3").on("click", function(event)
		{
			var selfObj = this;
			selectTag("tagContent3", selfObj);
			takeSampleIndex();
		});		
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
		selfCheckIndex();
	});

	/*加载传染病管理及督导首页*/
	function supervisorIndex() {
		var length = $('#tagContent1').has('form').length;
			if (length == 0){
			var loadHtmlByUrlOption = {
				url : "/idm/statistics/report/supervisor/index",
				param : null,
				checkRepeat : true,
				insertDiv : "tagContent1",
				errorDiv: "",
				okDiv:""
			};
			$.loadHtmlByUrl(loadHtmlByUrlOption);
		}
	};
	
	/*加载执行情况自查首页*/
	function selfCheckIndex() {
		var length = $('#tagContent2').has('form').length;
			if (length == 0){
			var loadHtmlByUrlOption = {
				url : "/idm/statistics/report/selfcheck/index",
				param : null,
				checkRepeat : true,
				insertDiv : "tagContent2",
				errorDiv: "",
				okDiv:""
			};
			$.loadHtmlByUrl(loadHtmlByUrlOption);
		}
	};	
	/*加载传染病管理及督导首页*/
	function takeSampleIndex() {
		var length = $('#tagContent3').has('form').length;
			if (length == 0){
			var loadHtmlByUrlOption = {
				url : "/idm/statistics/report/takeSample/index",
				param : null,
				checkRepeat : true,
				insertDiv : "tagContent3",
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
				url : "/idm/statistics/report/monthReport/index",
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
				url : "/idm/statistics/report/acuteReport/index",
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