var brwHealtmotherhoodPeriodFollowup = (function(){
	$(function(){
		getMotherhoodPeriodFollowup($(".motherhoodPeriodFollowup:first").val());
	});
	
	function getMotherhoodPeriodFollowup(id){
		var loadByUrl = {
			url : "/womenHealthCare/motherhoodPeriodFollowupDetail",
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