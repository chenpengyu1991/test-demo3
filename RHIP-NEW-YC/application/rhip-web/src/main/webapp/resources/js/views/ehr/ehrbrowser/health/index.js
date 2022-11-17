var brwHealthIndex = (function(){
	$(function(){
		alert(13);
		var loadByUrl = {
			url : "/ehrbrowser/health/newBornDetail",
			insertDiv : "healthContentDiv",
			param : {
				personId : $("#ehrbrowser_person_id_input").val()
			}
		};
		$.loadHtmlByUrl(loadByUrl);
	});
})();