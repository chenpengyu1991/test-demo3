var brwHealthNeonatalFamily = (function(){
	$(function(){
		getNeonatalFamilyVisit($(".neonatalFamilyVisit:first").val());
	});
	
	function getNeonatalFamilyVisit(id){
		var loadByUrl = {
			url : "/womenHealthCare/neonatalFamilyVisitDetail",
			insertDiv : "neonatalFamilyDiv",
			param : {
				id : id
			}
		};
		$.loadHtmlByUrl(loadByUrl);
	}
	
	return {
		getNeonatalFamilyVisit : getNeonatalFamilyVisit
	};
})();