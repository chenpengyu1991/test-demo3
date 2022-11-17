var macHealthChildHealthExaminationOne = (function(){
	$(function(){
        getChildHealthExaminationOne($(".childHealthExaminationOne:first").val());
	});
	
	function getChildHealthExaminationOne(id){
		var loadByUrl = {
			url : "/ehrbrowser/health/childHealthExaminationOne",
			insertDiv : "childHealthExaminationOneDiv",
			param : {
				id : id
			}
		};
		$.loadHtmlByUrl(loadByUrl);
	}
	
	return {
        getChildHealthExaminationOne : getChildHealthExaminationOne
	};
})();