var brwPlanYear =(function() {
	function selectPlanFollowup(personId,planYear) {
	   	var loadHtmlByUrlOption = {
				url : "/ehrbrowser/management/managePlanFollowupList",
				param : {
					personId : personId,
					planYear : planYear
				},
				insertDiv : "planFollowupList"
		};
	   	var loadHtmlByUrl = {
				url : "/ehrbrowser/management/searchPlanInfo",
				param : {
					personId : personId,
					planYear:planYear
				},
				insertDiv : "planInfoTabList"
		};
		$. loadHtmlByUrl(loadHtmlByUrlOption);
		$. loadHtmlByUrl(loadHtmlByUrl);
	}
	return {
		selectPlanFollowup:selectPlanFollowup
	};
})();