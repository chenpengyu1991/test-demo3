var portalBrwHealthFollowUp = (function(){
	$(function(){
		getWhPrenatalFollowup($(".healthFollow:first").val());
	});
	
	function getWhPrenatalFollowup(id){
		var loadByUrl = {
			url : "/health/followupDetail",
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