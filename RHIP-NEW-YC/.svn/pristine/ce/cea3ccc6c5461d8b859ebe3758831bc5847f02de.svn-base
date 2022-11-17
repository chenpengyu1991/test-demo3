var bornDefectList = (function(){
	$(function(){
		getBornDefectList($(".birthDefectMonitor:first").val());
	});
	
	function getBornDefectList(id){
		var loadByUrl = {
			url : "/ehrbrowser/health/bornDefectDetail",
			insertDiv : "birthDefectMonitorDiv",
			param : {
				id : id
			}
		};
		$.loadHtmlByUrl(loadByUrl);
	}
	
	return {
		getBornDefectList : getBornDefectList
	};
})();