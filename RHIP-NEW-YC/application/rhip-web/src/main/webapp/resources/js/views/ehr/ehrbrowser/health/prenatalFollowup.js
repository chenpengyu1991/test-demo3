var brwHealthPreFollowUp = (function(){
	$(function(){
		getPreFollowUpDetail($(".prenatalFollowup:first").val());
	});
	
	function getPreFollowUpDetail(id){
		var loadByUrl = {
			url : "/ehrbrowser/health/prenatalFollowupFirst",
			insertDiv : "prenatalFollowupDiv",
			param : {
				id : id
			}
		};
		$.loadHtmlByUrl(loadByUrl);
	}
	
	return {
		getPreFollowUpDetail : getPreFollowUpDetail
	};
})();