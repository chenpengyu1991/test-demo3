var portalBrwHealthNewBorn = (function(){
	$(function(){
		getChBirthCertificate($(".healthNewBorn:first").val());
	});
	
	function getChBirthCertificate(id){
		var loadByUrl = {
			url : "/health/newBornDetail",
			insertDiv : "newBornDetailDiv",
			param : {
				id : id
			}
		};
		$.loadHtmlByUrl(loadByUrl);
	}
	
	return {
		getChBirthCertificate : getChBirthCertificate
	};
})();