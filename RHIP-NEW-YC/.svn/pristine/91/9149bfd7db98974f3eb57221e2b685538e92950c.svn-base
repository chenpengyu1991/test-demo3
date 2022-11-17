var prescriptionSearch = (function() {
    $(function() {
        $("#detailBtnSearch").click(function() {
           search(1);
        });
        $("#detailBtnSearch").onEnter(search, 1);
        search(1); 
    });

    function search(pageIndex) {
        pageIndex = (isEmpty(pageIndex)?$("#pageIndex").val():pageIndex);
        var searchObj = {
            url : "/ihm/prescription/detail/list",
            insertDiv : "prescriptionListDiv",
            param : {
                pageIndex : pageIndex
            },
            callback : function(data) {
            	$("#pageIndex").val(pageIndex);
            }
        };
        $("#prescriptionSearchForm").submitFormLoadHtml(searchObj);
    };

    /**
     * 查看处方
     * @param ehrId
     * @param personId
     */
    function prescriptionDetail(ehrId,personId,recordNumber){
        var dialog = {
            url : "/ihm/emr/prescriptionDetail",
            height : 500,
            width : 650,
            title : "处方",
            param : {"ehrId":ehrId,"personId":personId,"recordNumber":recordNumber}
        };
        $.dialog(dialog);
    };

    function returnCost(){
        $("#prescriptionDetailDiv").empty();
        $("#top_all").show();
    }
	return {
		search:search,
        returnCost:returnCost,
        prescriptionDetail:prescriptionDetail
	};
})();



