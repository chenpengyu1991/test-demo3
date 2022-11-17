var portalBrwManage = (function(){
	$(function(){
		$(".manageSelect").on("click",function(){
			var url = "/health/" + $(this).attr("id");
			var loadHtmlByUrlOption = {
				url : url,
				param : {
					personId : $("#ehrbrowser_person_id_input").val()
				},
				insertDiv : "healthContentDiv"
			};
			$.loadHtmlByUrl(loadHtmlByUrlOption);
		});
	});
})();