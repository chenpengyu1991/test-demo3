var healthEventSearch=(function(){
	
	var url = contextPath+"/healthevent/result";
	
	$(function(){
		$(".healthevent-search-btn").bind("click",function(){
			search(1);
		});
		$("#healthevent-result-content").on("click",".detail-link-btn",function(event){
			
			event.preventDefault(); 
			var $this=$(this);
			var dialogObj = {
					url :  $this.attr("href"),
					title :$this.text(),
					};
			$.dialog(dialogObj);
			return false;
		});
		search(1);
	});
	
	function search(indexPage) {
		var searchObj = {
				url : url,
				insertDiv : "healthevent-result-content",
				param : {
					indexPage : indexPage
				}
			};
		$("#healthevent-search-from").formPost(searchObj);
	}
	return {
		search : search
	};
})();
