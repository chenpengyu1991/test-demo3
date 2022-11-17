var pregnantwomentabList = (function(){
	$(function(){
        getPregnantwomentabList($(".WhYcfbjJd:first").val());
	});
	
	function getPregnantwomentabList(id){
		var loadByUrl = {
			url : "/ehrbrowser/health/pregnantwomentabDetail",
			insertDiv : "WhYcfbjJdDiv",
			param : {
				id : id
			}
		};
		$.loadHtmlByUrl(loadByUrl);
	}
	
	return {
        getPregnantwomentabList : getPregnantwomentabList
	};
})();