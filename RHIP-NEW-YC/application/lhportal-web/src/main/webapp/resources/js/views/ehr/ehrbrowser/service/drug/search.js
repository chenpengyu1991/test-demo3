var drugSearch=(function(){
	
	var url = contextPath+"/drug/result";
	
	$(function() {
		//切换时间段
		$(".drug-search-btn").bind("click",function(){
			searchInner(1);
		});
		searchInner(1);
	});

	function searchInner(indexPage) {
		var searchObj = {
				url : url,
				insertDiv : "drug-result-content",
				param : {
					indexPage : indexPage
				}
			};
		$("#drug-search-from").formPost(searchObj);
	}
	return {
		search : searchInner
	};
})();
