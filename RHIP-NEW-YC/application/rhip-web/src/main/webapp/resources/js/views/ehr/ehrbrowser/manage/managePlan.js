var brwManagePlan =(function() {
	
	$(function() {
		var id= $(".hiddenValue:first").val();
		getDmHypertensionConclusion(id);
	});
	
	function getDmHypertensionConclusion(id){
		var loadObj  ={
			url : "/ehrbrowser/management/managePlanInfo",
			param : {
				id : id
			},
			insertDiv : "planInfoTabList"
		};
		$.loadHtmlByUrl(loadObj);
	}
	
	return {
		getDmHypertensionConclusion : getDmHypertensionConclusion
	};
})();