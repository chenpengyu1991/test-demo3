var brwHealthFrailInfantsFile = (function(){
	$(function(){
        getFrailInfantsFile($(".frailInfantsFile:first").val());
	});
	
	function getFrailInfantsFile(id){
		var loadByUrl = {
			url : "/ehrbrowser/health/frailInfantsFile",
			insertDiv : "frailInfantsFileDiv",
			param : {
				id : id
			}
		};
		$.loadHtmlByUrl(loadByUrl);
	}
	
	return {
        getFrailInfantsFile : getFrailInfantsFile
	};
})();