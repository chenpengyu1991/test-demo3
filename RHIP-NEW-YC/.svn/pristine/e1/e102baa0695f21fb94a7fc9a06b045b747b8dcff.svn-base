var brwHealthFollowUp = (function(){
	$(function(){
		getFollowUpDetail($(".postnatalFollowup:first").val());
	});
	
	function getFollowUpDetail(id){
		var loadByUrl = {
			url : "/womenHealthCare/postnatalFollowup",
			insertDiv : "postnatalFollowupDiv",
			param : {
				id : id
			}
		};
		$.loadHtmlByUrl(loadByUrl);
	}
	
	return {
		getFollowUpDetail : getFollowUpDetail
	};
})();