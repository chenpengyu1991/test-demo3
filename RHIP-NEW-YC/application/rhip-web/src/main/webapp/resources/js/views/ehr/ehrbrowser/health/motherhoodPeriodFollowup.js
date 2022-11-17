var brwHealtmotherhoodPeriodFollowup = (function(){
	$(function(){
		getMotherhoodPeriodFollowup($(".motherhoodPeriodFollowup:first").val());
	});
	
	function getMotherhoodPeriodFollowup(id){
		var loadByUrl = {
			url : "/ehrbrowser/health/motherhoodPeriodFollowupDetail",
			insertDiv : "motherhoodPeriodFollowupDiv",
			param : {
				id : id
			}
		};
		$.loadHtmlByUrl(loadByUrl);
	}
	
	return {
		getMotherhoodPeriodFollowup : getMotherhoodPeriodFollowup
	};
})();