var brwManage = (function(){
	$(function(){
		$(".manageSelect").on("click",function(){
			$(".manageSelect").parent().removeClass("active");
			$(this).parent().addClass("active");
			var url = "/ehrbrowser/management/" + $(this).attr("id");
			var loadHtmlByUrlOption = {
				url : url,
				param : {
					personId : $("#ehrbrowser_person_id_input").val()
				},
				insertDiv : "content"
			};
			$.loadHtmlByUrl(loadHtmlByUrlOption);
		});
	});
})();