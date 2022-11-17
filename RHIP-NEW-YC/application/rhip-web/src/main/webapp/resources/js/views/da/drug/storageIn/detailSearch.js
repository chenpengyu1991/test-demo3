var detailSearch = (function() {
    $(function() {
        $("#detailBtnSearch").click(function(e) {
           e.preventDefault();
           search(1);
        });
        $("#detailBtnSearch").onEnter(search, 1);
        search(1); 
    });

    function search(pageIndex) {
    	var beginDt = $('#detailSearch').find('#beginDt').val();
    	var endDt = $('#detailSearch').find('#endDt').val();
    	var batchNo = $('#detailSearch').find('#batchNo').val();
		var orgCode = $('#detailSearch').find('#orgCode').val();
		var medicareCode = $('#detailSearch').find('#medicareCode').val();
        pageIndex = ($.isEmpty(pageIndex)?$("#detailPageIndex").val():pageIndex);
        var searchObj = {
            url : "/da/drug/storageIn/detail/list",
            insertDiv : "detailResultDiv",
            param : {
                pageIndex : pageIndex,
                beginDt:beginDt,
                endDt:endDt,
                batchNo:batchNo,
                orgCode:orgCode,
                medicareCode:medicareCode
            },
            callback : function(data) {
            	$("#detailPageIndex").val(pageIndex);
            }
        };
        $("#detailSearchForm").submitFormLoadHtml(searchObj);
    };	
	return {
		search:search
	};
})();



