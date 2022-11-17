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
    	var beginDt = $('#consumableOutDetailDiv').find('#beginDt').val();
    	var endDt = $('#consumableOutDetailDiv').find('#endDt').val();
    	var batchNo = $('#consumableOutDetailDiv').find('#batchNo').val();
        pageIndex = ($.isEmpty(pageIndex)?$("#detailPageIndex").val():pageIndex);
        var searchObj = {
            url : "/da/consumable/out/detail/list",
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



