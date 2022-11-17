var brwHealthWomanDisCensus = (function(){
	$(function(){
		getWomanDisCensus($(".WomanDisCensus:first").val());
	});
	
	function getWomanDisCensus(id){
		var loadByUrl = {
			url : "/ehrbrowser/health/womanDiseaseCensus",
			insertDiv : "WomanDisCensusDiv",
			param : {
				id : id
			}
		};
		$.loadHtmlByUrl(loadByUrl);
	}
	
	return {
		getWomanDisCensus : getWomanDisCensus
	};
})();