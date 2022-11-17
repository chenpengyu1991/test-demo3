var brwHealthFollowUp = (function(){
	$(function(){
		getWhPrenatalFollowup($(".healthFollow:first").val());
	});
	
	function getWhPrenatalFollowup(id){
		var loadByUrl = {
			url : "/ehrbrowser/health/followupDetail",
			insertDiv : "healthDetailDiv",
			param : {
				id : id
			}
		};
		$.loadHtmlByUrl(loadByUrl);
	}
	
	return {
		getWhPrenatalFollowup : getWhPrenatalFollowup
	};
})();