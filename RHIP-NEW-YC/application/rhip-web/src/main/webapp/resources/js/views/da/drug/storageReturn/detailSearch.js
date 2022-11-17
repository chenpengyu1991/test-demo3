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
    	var beginDt = $('#storageReturnDetailDiv').find('#beginDt').val();
    	var endDt = $('#storageReturnDetailDiv').find('#endDt').val();
    	var batchNo = $('#storageReturnDetailDiv').find('#batchNo').val();
        pageIndex = ($.isEmpty(pageIndex)?$("#detailPageIndex").val():pageIndex);
        var searchObj = {
            url : "/da/drug/storageReturn/detail/list",
            insertDiv : "detailResultDiv",
            param : {
                pageIndex : pageIndex,
                beginDt:beginDt,
                endDt:endDt,
                batchNo:batchNo
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



