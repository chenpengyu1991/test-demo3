var macHealthChildHealthExaminationThree = (function(){
	$(function(){
        getChildHealthExaminationThree($(".childHealthExaminationThree:first").val());
	});
	
	function getChildHealthExaminationThree(id){
		var loadByUrl = {
			url : "/ehrbrowser/health/childHealthExaminationThree",
			insertDiv : "childHealthExaminationThreeDiv",
			param : {
				id : id
			}
		};
		$.loadHtmlByUrl(loadByUrl);
	}
	
	return {
        getChildHealthExaminationThree : getChildHealthExaminationThree
	};
})();