var weakChildrenList = (function(){
	$(function(){
        getWeakChildrenDetail($(".child:first").val());
	});
	
	function getWeakChildrenDetail(id){
		var loadByUrl = {
			url : "/ehrbrowser/health/weakChildrenDetail",
			insertDiv : "weakChildrenDetailDiv",
			param : {
				id : id
			}
		};
		$.loadHtmlByUrl(loadByUrl);
	}
	
	return {
        getWeakChildrenDetail : getWeakChildrenDetail
	};
})();