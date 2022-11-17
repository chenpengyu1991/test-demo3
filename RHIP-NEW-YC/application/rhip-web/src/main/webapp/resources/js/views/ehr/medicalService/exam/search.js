var examSearch=(function(){
	
	var url = contextPath+"/exam/result";
	
	$(function(){
		
		//时间段切换		
		$(".exam-search-btn").click(function(){
			searchInner(1);
		});
		
		//查看检验报告单
		$("#exam-result-content").on("click",".report-link-btn",function(event){
		//	alert(1);
			event.preventDefault(); 
			var $this=$(this);
			var dialogObj = {
					url :  $this.attr("href"),
					title : "检验报告单"
					};
			$.dialog(dialogObj);
			return false;
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

