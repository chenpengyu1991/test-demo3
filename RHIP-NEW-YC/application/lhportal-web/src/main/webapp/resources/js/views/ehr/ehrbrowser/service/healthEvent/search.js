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
