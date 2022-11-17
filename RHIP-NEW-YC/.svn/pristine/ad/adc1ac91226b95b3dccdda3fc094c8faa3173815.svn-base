var brwHealthPreFollowUpOther = (function(){
	$(function(){
		getPreFollowUpDetail($(".prenatalFollowupOther:first").val());
	});
	
	function getPreFollowUpDetail(id){
		var loadByUrl = {
			url : "/ehrbrowser/health/prenatalFollowupOther",
			insertDiv : "prenatalFollowupOtherDiv",
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