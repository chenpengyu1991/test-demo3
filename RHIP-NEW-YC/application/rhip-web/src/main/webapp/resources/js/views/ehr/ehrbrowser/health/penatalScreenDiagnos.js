var penatalScreenDiagnos = (function(){
	$(function(){
		getPrenatalScreenDiagnosis($(".prenatalScreenDiagnosis:first").val());
	});
	
	function getPrenatalScreenDiagnosis(id){
		var loadByUrl = {
			url : "/ehrbrowser/health/prenatalScreenDiagnosis",
			insertDiv : "penatalScreenDiagnosDiv",
			param : {
				id : id
			}
		};
		$.loadHtmlByUrl(loadByUrl);
	}
	
	return {
		getPrenatalScreenDiagnosis : getPrenatalScreenDiagnosis
	};
})();