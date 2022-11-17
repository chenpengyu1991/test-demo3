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
    	var beginDt = $('#pharmacyReturnDetailDiv').find('#beginDt').val();
    	var endDt = $('#pharmacyReturnDetailDiv').find('#endDt').val();
    	var batchNo = $('#pharmacyReturnDetailDiv').find('#batchNo').val();
        pageIndex = ($.isEmpty(pageIndex)?$("#detailPageIndex").val():pageIndex);
        var searchObj = {
            url : "/da/drug/pharmacyReturn/detail/list",
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



