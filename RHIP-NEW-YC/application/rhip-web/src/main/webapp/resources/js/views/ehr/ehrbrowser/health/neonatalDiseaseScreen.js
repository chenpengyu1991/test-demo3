var brwHealthNeonatalDisease = (function(){
	$(function(){
		getNeonatalDiseaseScreen($(".neonatalDiseaseScreen:first").val());
	});
	
	function getNeonatalDiseaseScreen(id){
		var loadByUrl = {
			url : "/ehrbrowser/health/neonatalDiseaseScreenDetail",
			insertDiv : "neonatalDiseaseDiv",
			param : {
				id : id
			}
		};
		$.loadHtmlByUrl(loadByUrl);
	}
	
	return {
		getNeonatalDiseaseScreen : getNeonatalDiseaseScreen
	};
})();