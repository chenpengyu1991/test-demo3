var followUpPlanSearch = (function() {
	$(function() {
		//var id = $("#followupId").val();
		//if(!$.isEmpty(id)){
		//	followUpPlanResult(1);
		//}
		//changPlanStypeAndLoadToFollowup();
	});
	function followUpPlanResult(indexPage) {
		var searchObj = {
			url : "/cdm/highrisk/loadFollowUpPlanResult",
			insertDiv : "followUpPlanResult",
			param : {
				indexPage : indexPage
				//id:id
			}
		};
		$("#followUpPlanForm").submitFormLoadHtml(searchObj);
	}
	function changPlanStypeAndLoadToFollowup(){
		var $form = $("#followUpPlanForm");
		$("tr.toBeBuild").css("color", "#ed1941");
		$("tr.hasBeenBuild").css("color", "#1d953f");
		var $first = $form.find("tr.toBeBuild:first");
		if ($first.length > 0){
			$first.click();
		} else{
			$form.find("tr.hasBeenBuild:last").click();
		}
	}
	function dependonYearSearch(year) {
		var searchObj = {
				url : "/cdm/highrisk/loadFollowUpPlan",
				insertDiv : "followUpPlanSearch",
				param : {			
					indexPage : 1
				},
				callback:changPlanStypeAndLoadToFollowup
			};
		$("#followUpPlanForm").submitFormLoadHtml(searchObj);
	}
	function changPlanStypeAndLoadToFollowup(){
		var $form = $("#followUpPlanForm");
		$("tr.toBeBuild").css("color", "#ed1941");
		$("tr.hasBeenBuild").css("color", "#1d953f");
		var $first = $form.find("tr.toBeBuild:first");
		if ($first.length > 0){
			$first.click();
		} else{
			$form.find("tr.hasBeenBuild:last").click();
		}
	}
	return {
		//load:load,
		dependonYearSearch:dependonYearSearch
//		followUpPlanResult:followUpPlanResult,
//		changPlanStypeAndLoadToFollowup:changPlanStypeAndLoadToFollowup
	};
})();