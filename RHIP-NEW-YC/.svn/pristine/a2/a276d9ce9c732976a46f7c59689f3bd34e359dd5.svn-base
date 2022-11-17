var studySearch=(function(){
	
	var url = contextPath+"/study/result";
	
	$(function() {
		//切换时间段
		$(".study-search-btn").bind("click",function(){
			searchInner(1);
		});
		searchInner(1);
	});
	


	function searchInner(indexPage) {
		var searchObj = {
				url : url,
				insertDiv : "study-result-content",
				param : {
					pageIndex : indexPage
				}
			};
		$("#study-search-from").formPost(searchObj);
	}
	return {
		search : searchInner
	};
})();

