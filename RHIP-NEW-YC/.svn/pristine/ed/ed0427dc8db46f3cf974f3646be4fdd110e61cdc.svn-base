var examSearch=(function(){
	
	var url = contextPath+"/exam/result";
	
	$(function(){
		
		//时间段切换		
		$(".exam-search-btn").click(function(){
			searchInner(1);
		});
		
		//检验报告单
		$("#exam-result-content").on("click", ".exam_report_btn",function(event){
			event.preventDefault();
			ehrbrowserServiceIndex.openExamReport($(this),null);
		});
		
		searchInner(1);
		
	});

	function searchInner(indexPage) {
		var searchObj = {
				url : url,
				insertDiv : "exam-result-content",
				param : {
					indexPage : indexPage
				}
			};
		$("#exam-search-from").formPost(searchObj);
	}
	return {
		search : searchInner
	};
})();

