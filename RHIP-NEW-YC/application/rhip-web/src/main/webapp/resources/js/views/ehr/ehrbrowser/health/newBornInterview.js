var macHealthNewBornInterview = (function(){
	$(function(){
        getNewBornInterview($(".newBornInterview:first").val());
	});
	
	function getNewBornInterview(id){
		var loadByUrl = {
			url : "/ehrbrowser/health/newBornInterview",
			insertDiv : "newBornInterviewDiv",
			param : {
				id : id
			}
		};
		$.loadHtmlByUrl(loadByUrl);
	}
	
	return {
        getNewBornInterview : getNewBornInterview
	};
})();