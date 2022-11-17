var brwControl = (function(){
	$(function(){
		$(".controlSelect").on("click",function(){
			$(".controlSelect").parent().removeClass("active");
			$(this).parent().addClass("active");
			var url = "/ehrbrowser/control/" + $(this).attr("id");
			var loadHtmlByUrlOption = {
				url : url,
				param : {
					personId : $("#ehrbrowser_person_id_input").val()
				},
				insertDiv : "diseaseControlDiv"
			};
			$.loadHtmlByUrl(loadHtmlByUrlOption);
		});
	});


	function detail(id) {
		$("#diseaseControlDiv").hide();
		$.loadHtmlByUrl({
			url : '/ehrbrowser/control/controlIndex/'+ id  ,
			insertDiv :"detailDiv"
		});
		$("#detailDiv").show();
	};

	function indexReturn() {
		search("controlIndex");
	}

	return{
		search:search,
		detail:detail,
		indexReturn:indexReturn
	}
})();