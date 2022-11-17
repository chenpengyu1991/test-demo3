var detailReportPop=(function(){
	
	$(function() {
		$("#summary_exam_btn").on("click", function(event){
			selectTag("tagContent0",this);
		});
		$("#summary_study_btn").on("click", function(event){
			selectTag("tagContent1",this);
		});
		//检验报告单
		$(".summary_exam_report_btn").on("click",function(event){
			event.preventDefault();
			openExamReport($(this),null);
		});
		ehrbrowserServiceIndex.initCollspse("exam-collapse-box");
		ehrbrowserServiceIndex.initCollspse("drugUsage-collapse-box");
	});
	
	//检验报告单
	function openExamReport($this,param){
		ehrbrowserServiceIndex.openExamReport($this,param);
	}
	
	
	$(function(){
		//处方信息
		$("#drugUsage-collapse-box").on("click",".drug_detail_btn",function(event){
			event.preventDefault();
			ehrbrowserServiceIndex.openReportByA($(this),{
				ehrId : $("#drugUsage_ehrId").val(),
				personId : $("#drugUsage_personId").val()
			},500,400);
		});
	});
	
})();