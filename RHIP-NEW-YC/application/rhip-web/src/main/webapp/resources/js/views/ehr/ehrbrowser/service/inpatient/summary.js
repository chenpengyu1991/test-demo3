var inpatientSummaryPop = (function() {
	$(function() {
		$("#summary_exam_btn").on("click", function(event){
			selectTag("tagContent0",this);
		});
		$("#summary_study_btn").on("click", function(event){
			selectTag("tagContent1",this);
		});
		$(".summary_exam_report_btn").on("click", function(event){
			event.preventDefault();
			ehrbrowserServiceIndex.openExamReport($(this),null);
		});
		ehrbrowserServiceIndex.initCollspse("exam-collapse-box");
	});

	return {};
})();

