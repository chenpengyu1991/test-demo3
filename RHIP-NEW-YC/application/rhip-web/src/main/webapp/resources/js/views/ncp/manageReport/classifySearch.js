var classifyReport = (function () {
    $(function () {
        search();
        $("#report-export").on("click", function(event)
        {
            $("#manageReportListDiv").exportExcel("病例分类统计报表");
        });
        $("#manageReportSearch").on("click", function () {
            search();
        });
    });

    function search() {
        var searchObj = {
            url: "/ncp/manageReport/classify/list",
            insertDiv: "manageReportListDiv"
        };
        $("#manageReportForm").submitFormLoadHtml(searchObj);
    }
    
    return {
    	 search : search
    };
})();
