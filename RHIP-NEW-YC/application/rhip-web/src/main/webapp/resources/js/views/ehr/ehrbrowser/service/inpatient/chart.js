var clinicalChartPop = (function() {
	$(function() {
		$(".clichart-week-btn").on("click", function(event) {
			var $this = $(this);
			getChartData($this.attr("href"));
			event.preventDefault();
			$(".clichart-week-btn").removeClass("selectedWeek");
			$this.addClass("selectedWeek");
			return false;
		});
		//住院摘要
		$("#inpatient_summary_btn").on("click", function(event) {
			event.preventDefault();
			ehrbrowserServiceIndex.openReportByA($(this),null,800,550);
		});
		//病案首页
		$("#chichat-data-content").on("click",".chilical_chart_index_a", function(event) {
			event.preventDefault();
			ehrbrowserServiceIndex.openReportByA($(this),null,950,600);
		});
		//出院小结
		$("#chichat-data-content").on("click",".chilical_chart_summary_a", function(event) {
			event.preventDefault();
			ehrbrowserServiceIndex.openReportByA($(this),null,900,600);
		});
		//检查报告
		$("#chichat-data-content").on("click",".study_report_btn", function(event) {
			event.preventDefault();
			ehrbrowserServiceIndex.openStudyReport($(this),null);
		});
		//检验报告
		$("#chichat-data-content").on("click",".exam_report_btn", function(event) {
			event.preventDefault();
			ehrbrowserServiceIndex.openExamReport($(this),null);
		});
		
		$(".clichart-week-btn:first").click();
	});
	
	
	function getChartData(url){
		$.loadHtmlByUrl({
			url : url,
			insertDiv : "chichat-data-content"
		});
	}
	return {};
})();
