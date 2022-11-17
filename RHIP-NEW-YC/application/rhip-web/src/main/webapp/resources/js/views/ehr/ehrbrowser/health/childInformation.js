var chEtbjJdDetail = (function(){
	$(function(){
        getChildDetail($(".child:first").val());
	});
	
	function getChildDetail(id){
		var loadByUrl = {
			url : "/ehrbrowser/health/childrenInformationRegistrationCard",
			insertDiv : "childrenInformationRegistrationCardDiv",
			param : {
				id : id
			}
		};
		$.loadHtmlByUrl(loadByUrl);
	}
	
	return {
        getChildDetail : getChildDetail
	};
})();