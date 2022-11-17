var brwHealthPreFollowUp = (function(){
	$(function(){
		getPreFollowUpDetail($(".prenatalFollowup:first").val());
	});
	
	function getPreFollowUpDetail(id){
		var loadByUrl = {
			url : "/womenHealthCare/prenatalFollowup",
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