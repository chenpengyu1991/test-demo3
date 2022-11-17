var brwHealthCheckRecord = (function(){
	$(function(){
        getHealthCheckRecordList($(".WhYcfbjChjc:first").val());
	});
	
	function getHealthCheckRecordList(id){
		var loadByUrl = {
			url : "/ehrbrowser/health/healthCheckRecordDetail",
			insertDiv : "WhYcfbjChjcDiv",
			param : {
				id : id
			}
		};
		$.loadHtmlByUrl(loadByUrl);
	}
	
	return {
        getHealthCheckRecordList : getHealthCheckRecordList
	};
})();