var brwManage = (function(){
	$(function(){
		$(".manageSelect").on("click",function(){
			var url = "/ehrbrowser/management/" + $(this).attr("id");
			var loadHtmlByUrlOption = {
				url : url,
				param : {
					personId : $("#ehrbrowser_person_id_input").val()
				},
				insertDiv : "diseaseManageDiv"
			};
			$.loadHtmlByUrl(loadHtmlByUrlOption);
		});
	});
})();