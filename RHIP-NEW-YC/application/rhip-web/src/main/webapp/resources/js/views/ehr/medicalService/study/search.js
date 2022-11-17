var studySearch=(function(){
	
	var url = contextPath+"/study/result";
	
	$(function() {
		//切换时间段
		$(".study-search-btn").bind("click",function(){
			searchInner(1);
		});
		searchInner(1);
	});
	
	//显示
	jQuery("#study-result-content").on("click", ".study-link-btn",function(event){
		event.preventDefault(); 
		
		var dialogObj = {
				url :  $(this).attr("href"),
				title : "检查报告单"
			};
		jQuery.dialog(dialogObj);
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

