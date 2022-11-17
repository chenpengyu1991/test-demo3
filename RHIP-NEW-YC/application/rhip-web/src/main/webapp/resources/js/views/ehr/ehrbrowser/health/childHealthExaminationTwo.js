var macHealthChildHealthExaminationTwo = (function(){
	$(function(){
        getChildHealthExaminationTwo($(".childHealthExaminationTwo:first").val());
	});
	
	function getChildHealthExaminationTwo(id){
		var loadByUrl = {
			url : "/ehrbrowser/health/childHealthExaminationTwo",
			insertDiv : "childHealthExaminationTwoDiv",
			param : {
				id : id
			}
		};
		$.loadHtmlByUrl(loadByUrl);
	}
	
	return {
        getChildHealthExaminationTwo : getChildHealthExaminationTwo
	};
})();