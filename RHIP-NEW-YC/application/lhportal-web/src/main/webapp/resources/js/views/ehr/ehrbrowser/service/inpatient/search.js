var inpatientSearch=(function(){
	
	var url = contextPath+"/inpatient/result";
	
	$(function() {		
		//时间段切换		
		$(".inpatient-search-btn").click(function(){
			searchInner(1);
		});
		
		//查看临床图表
		$(".chart-link-btn").click(function(event){
			event.preventDefault(); 
			var $this=$(this);
			var dialogObj = {
					url :  $this.attr("href"),
					title : "临床图表"
					};
			$.dialog(dialogObj);
			event.preventDefault(); 
			return false;
		});
		searchInner(1);
	});

	function searchInner(indexPage) {
		var searchObj = {
				url : url,
				insertDiv : "inpatient-result-content",
				param : {
					indexPage : indexPage
				}
			};
		$("#inpatient-search-from").formPost(searchObj);
	}
	return {
		search : searchInner
	};
})();

