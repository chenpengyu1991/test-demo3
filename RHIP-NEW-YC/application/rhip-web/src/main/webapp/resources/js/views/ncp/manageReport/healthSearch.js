var healthReport = (function () {
    $(function () {
        search();
        $("#report-export").on("click", function(event)
        {
            $("#manageReportListDiv").exportExcel("健康管理统计报表");
        });
        $("#manageReportSearch").on("click", function () {
            search();
        });
    });

    function search() {
        var searchObj = {
            url: "/ncp/manageReport/health/list",
            insertDiv: "manageReportListDiv"
        };
        $("#manageReportForm").submitFormLoadHtml(searchObj);
    }
    
    return {
    	 search : search
    };
})();
