var macHealthFollowUp = (function(){
	$(function(){
        getInterviewDetail($(".postnatalInterview:first").val());
	});

	function getInterviewDetail(id){
		var loadByUrl = {
			url : "/ehrbrowser/health/postnatalInterview",
			insertDiv : "postnatalInterviewDiv",
			param : {
				id : id
			}
		};
		$.loadHtmlByUrl(loadByUrl);
	}
	
	return {
		getInterviewDetail : getInterviewDetail
	};
})();