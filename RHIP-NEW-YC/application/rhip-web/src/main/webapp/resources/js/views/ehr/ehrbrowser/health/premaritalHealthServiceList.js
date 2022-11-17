var premaritalHealthServiceList = (function(){
	$(function(){
        getPremaritalHealthServiceList($(".premaritalHealthService:first").val());
	});
	
	function getPremaritalHealthServiceList(id){
		var loadByUrl = {
			url : "/ehrbrowser/health/premaritalHealthService",
			insertDiv : "premaritalHealthServiceDiv",
			param : {
				id : id
			}
		};
		$.loadHtmlByUrl(loadByUrl);
	}
	
	return {
		getPremaritalHealthServiceList : getPremaritalHealthServiceList
	};
})();