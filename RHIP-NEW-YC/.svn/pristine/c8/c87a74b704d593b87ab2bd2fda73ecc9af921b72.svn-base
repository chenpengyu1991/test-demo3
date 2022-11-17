var firstantenatalvisitList = (function(){
	$(function(){
        getFirstantenatalvisitList($(".WhYcfbjDycsf:first").val());
	});
	
	function getFirstantenatalvisitList(id){
		var loadByUrl = {
			url : "/ehrbrowser/health/firstantenatalvisitDetail",
			insertDiv : "WhYcfbjDycsfDiv",
			param : {
				id : id
			}
		};
		$.loadHtmlByUrl(loadByUrl);
	}
	
	return {
        getFirstantenatalvisitList : getFirstantenatalvisitList
	};
})();