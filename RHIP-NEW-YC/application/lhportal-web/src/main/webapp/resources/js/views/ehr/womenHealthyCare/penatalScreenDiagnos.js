var penatalScreenDiagnos = (function(){
	$(function(){
		getPrenatalScreenDiagnosis($(".prenatalScreenDiagnosis:first").val());
	});
	
	function getPrenatalScreenDiagnosis(id){
		var loadByUrl = {
			url : "/womenHealthCare/prenatalScreenDiagnosis",
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