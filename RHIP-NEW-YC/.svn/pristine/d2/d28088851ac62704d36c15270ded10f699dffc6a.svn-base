var portalBrwHealthIndex = (function(){
	$(function(){
		$(".healthSelect").on("click",function(){
			var url = "/health/" + $(this).attr("id");
			var loadHtmlByUrlOption = {
				url : url,
				insertDiv : "healthContentDiv"
			};
			$.loadHtmlByUrl(loadHtmlByUrlOption);
		});
		
		var loadByUrl = {
			url : "/health/followup",
			insertDiv : "healthContentDiv",
			param : {
				personId : $("#ehrbrowser_person_id_input").val()
			}
		};
		$.loadHtmlByUrl(loadByUrl);
	});
})();