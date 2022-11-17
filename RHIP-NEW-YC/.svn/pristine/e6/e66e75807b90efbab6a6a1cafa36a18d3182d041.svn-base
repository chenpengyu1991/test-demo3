var brwFollowup = (function(){
	$(function(){
		getFollowUpDetail($(".hiddenValue:first").val(), $(".hiddenType:first").val());
	});
	
	function getFollowUpDetail(id, type){
		var loadByUrlOption = {
				url : "/ehrbrowser/management/followUpDetail",
				param : {
					id : id,
					type : type
				},
				insertDiv : "followUpInfo"
			};
			$.loadHtmlByUrl(loadByUrlOption);
	}
	
	return {
		getFollowUpDetail : getFollowUpDetail
	};
	
})();