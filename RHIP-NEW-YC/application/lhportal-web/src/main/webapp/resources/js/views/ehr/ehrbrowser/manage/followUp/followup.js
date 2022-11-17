var portalBrwFollowup = (function(){
	$(function(){
		getFollowUpDetail($(".hiddenId:first").val(), $(".hiddenType:first").val());
	});
	
	function getFollowUpDetail(id, type){
		var loadByUrlOption = {
				url : "/CDmanage/followUpDetail",
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