var brwManageIndex = (function(){
	$(function(){
		var loadByUrl = {
			url : "/ehrbrowser/management/manageIndex",
			insertDiv : "diseaseManageDiv",
			param : {
				personId : $("#ehrbrowser_person_id_input").val()
			}
		};
		$.loadHtmlByUrl(loadByUrl);
	});
})();