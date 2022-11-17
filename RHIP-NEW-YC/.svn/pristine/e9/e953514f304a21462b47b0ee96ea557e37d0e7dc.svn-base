var traceRecode = (function() {

	var date = $("#currentDate").val();
	var idmId = $("#idmId").val();

	$(function() {
		searchRecord(1);
    });

	function searchRecord(indexPage) {
		$.loadHtmlByUrl({
			url : "/idm/tb/confirmed/traceRecode/list",
			 insertDiv : "listDiv",
            wait : true,
			 param : {
					indexPage : indexPage,
					idmId : idmId
			 }
		});
		//msgUtil.alert(date+"日对此患者进行追踪！");
	}

	return {
        searchRecord: searchRecord
	};
})();
