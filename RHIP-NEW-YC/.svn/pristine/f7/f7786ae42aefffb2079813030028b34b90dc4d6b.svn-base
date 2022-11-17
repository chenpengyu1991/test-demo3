var healthEventSearch=(function(){
	
	var url = contextPath+"/healthevent/result";
	
	$(function(){
		$(".healthevent-search-btn").bind("click",function(){
			search(1);
		});
		
		//临床图表
		$("#healthevent-result-content").on("click", ".inhos_chart_btn",function(event){
			event.preventDefault();
			ehrbrowserServiceIndex.openDrugInpatientChart($(this),null);
		});
		//处方
		$("#healthevent-result-content").on("click", ".drug_report_btn",function(event){
			event.preventDefault();
			ehrbrowserServiceIndex.openDrugReport($(this),null);
		});

        //门诊摘要
        $("#healthevent-result-content").on("click", ".outpatient_report_btn",function(event){
            event.preventDefault();
            ehrbrowserServiceIndex.openOutpatientReport($(this),null);
        });

		// 慢病体检
		$("#healthevent-result-content").on("click", ".cd_exam_btn", function(event) {
			event.preventDefault();
			ehrbrowserServiceIndex.openCdExam($(this), null);
		});
		
		// 学生体检
		$("#healthevent-result-content").on("click", ".student_exam_btn", function(event) {
			event.preventDefault();
			ehrbrowserServiceIndex.openStudentExam($(this), null);
		});
		// 其它类型体检
		$("#healthevent-result-content").on("click", ".other_exam_btn", function(event) {
			event.preventDefault();
			ehrbrowserServiceIndex.openOtherExam($(this), null);
		});
		
		search(1);
	});
	
	function search(indexPage) {
		var searchObj = {
				url : url,
				insertDiv : "healthevent-result-content",
				param : {
					pageIndex : indexPage
				}
			};
		$("#healthevent-search-from").formPost(searchObj);
	}
	return {
		search : search
	};
})();
