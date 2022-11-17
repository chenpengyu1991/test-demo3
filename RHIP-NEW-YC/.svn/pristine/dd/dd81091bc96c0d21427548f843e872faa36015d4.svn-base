var manageReport = (function () {
    $(function () {
        search();
        $("#report-export").on("click", function(event)
        {
            $("#manageReportListDiv").exportExcel("绩效考核统计报表");
        });
        $("#manageReportSearch").on("click", function () {
            search();
        });
        $('#selectMethod').on("change",function(){
            var selectMethod = $("#selectMethod").val();
            if ("1" == selectMethod){
                $("#manageDoctorTr").show();
            }else{
                $("#manageDoctorTr").hide();
                $("#manageDoctor").val("");
            }
        });
    });

    function search() {
        if (!checkDate()){
            return;
        }
        var searchObj = {
            url: "/ncp/manageReport/list",
            insertDiv: "manageReportListDiv"
        };
        $("#manageReportForm").submitFormLoadHtml(searchObj);
    }

    function checkDate(){
        var starttime = $('#serviceBeginDate').val();
        var endtime = $('#serviceEndDate').val();
        var start = new Date(starttime.replace("-", "/").replace("-", "/"));
        var end = new Date(endtime.replace("-", "/").replace("-", "/"));
        if(end < start){
        	layer.alert("开始时间不能大于结束时间！", {icon:0,title:'提示'});
            return false;
        }
        return true;

    }
    
    return {
    	 search : search
    };
})();
