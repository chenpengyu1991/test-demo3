var prescription = (function() {
    $(function() {
        drugUsageSearch(1); 
    });
    function drugUsageSearch(pageIndex) {
    	var recordNumber = $('#recordNumber').val();
    	var ehrId = $('#ehrId').val();
        pageIndex = ($.isEmpty(pageIndex)?1:pageIndex);
        var searchObj = {
            url : "/da/daily/unusual/drugusagelist",
            insertDiv : "drugUsageResultDiv",
            param : {
                pageIndex : pageIndex,
                recordNumber:recordNumber,
                ehrId:ehrId
            },
            callback : function(data) {
            	$("#drugUsagePageIndex").val(pageIndex);
            }
        };
        $("#drugUsageSearchForm").submitFormLoadHtml(searchObj);
    };	
   
	return {
		drugUsageSearch:drugUsageSearch
	};
})();



