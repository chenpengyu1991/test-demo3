var studySearch=(function(){
	
	var url = contextPath+"/study/result";
	
	$(function() {
		//切换时间段
		$(".study-search-btn").bind("click",function(){
			searchInner(1);
		});
		searchInner(1);
	});
	
	//检查报告单
	$("#study-result-content").on("click", ".study_report_btn",function(event){
		event.preventDefault();
		ehrbrowserServiceIndex.openStudyReport($(this),null);
	});

	function searchInner(indexPage) {
		var searchObj = {
				url : url,
				insertDiv : "study-result-content",
				param : {
					indexPage : indexPage
				}
			};
		$("#study-search-from").formPost(searchObj);
	}
	return {
		search : searchInner
	};
})();

