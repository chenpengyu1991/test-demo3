var machineMonitorSearch = (function() {
    $(function() {
        $("#machineMonitorQuery").click(function() {
            recordsPerform(1);
        });
        $("#form_search").onEnter(function() {
            recordsPerform(1);
        });
        recordsPerform(1);

        $("#searchMachineMonitorId").click(function() {
            searchReportRecord(1);
        });
        $("#machineMonitorForm").onEnter(function() {
            searchReportRecord(1);
        });
        searchReportRecord(1);
    });

    function toggle(obj,tableId) {
        $(obj).toggleClass("ico-top");
        $(obj).toggleClass("ico-bottom");
        $("#" + tableId).toggle();
    };


    function recordsPerform(indexPage) {
        var createBegin = new Date($("#beginTime").val());
        var createEnd = new Date($("#endTime").val());

        if (createBegin > createEnd) {
        	layer.alert("开始时间不能大于结束时间！", {icon:0,title:'提示'});
        } else {
            var searchObj = {
                url : "/machine/monitor/list",
                insertDiv : "machineMonitorList",
                param : {
                    indexPage : indexPage
                }
            };
            $("#form_search").submitFormLoadHtml(searchObj);
        }
    }

    /**
     * 查询硬件監控信息
     */
    function searchReportRecord(indexPage){

        indexPage = ($.isEmpty(indexPage)?$("#pageIndex").val():indexPage);
        var searchObj = {
            url : "/machine/monitor/list",
            insertDiv : "machineMonitorList",
            param : {
                indexPage : indexPage
            },
//            wait:true,
            callback : function(data) {
                $("#pageIndex").val(indexPage);
            }
        };
        $("#machineMonitorForm").submitFormLoadHtml(searchObj);
    }

    function detailReportRecord(id){
        $("#top_all").hide();
        $.loadHtmlByUrl({
            url : "/system/log/report/detail",
            insertDiv :"machineMonitorListDiv",
            param : {id:id}
        });
        $("#machineMonitorListDiv").show();
    }

    function returnSearch(){
        $("#machineMonitorListDiv").empty();
        $("#top_all").show();
        searchReportRecord(1);
    };

    function changeType(){
        var statusDiv = document.getElementById("statusDiv");
        var dmdStatus = document.getElementById("dmdStatus");
        var idmStatus = document.getElementById("idmStatus");

        if($("#type").val()==1 || $("#type").val()==3){
            statusDiv.style.visibility = "visible";
            dmdStatus.style.display = "block";
            idmStatus.style.display = "none";
        }else if($("#type").val()==2){
            statusDiv.style.visibility = "visible";
            dmdStatus.style.display = "none";
            idmStatus.style.display = "block";
        }else{
            statusDiv.style.visibility = "hidden";
            dmdStatus.style.display = "none";
            idmStatus.style.display = "none";
        }
    }

    /**
     * 补卡
     * reportRecordId：报卡记录ID
     * reportType==1:慢病补卡
     * reportType==2:传染病
     */
    function reSubmit(reportRecordId,reportType){
        var url;
        if(reportType == '1'){//慢病
            url ="/cdm/reportcard/rereport";
        }else if(reportType == '2'){//传染病
            url = "/idm/report/resubmit";
        }

        $("#top_all").hide();
        $.loadHtmlByUrl({
            url : url,
            insertDiv :"machineMonitorListDiv",
            param : {reportRecordId:reportRecordId},
            wait : true
        });
        $("#machineMonitorListDiv").show();
    }

    /**
     * 弹出报卡删除原因页面
     * @param reportRecordId
     */
    function deleteReportRecordDialog(reportRecordId) {
        var dialogObj = {
            id :"deleteContentDialog",
            width:"600",
            height:"180",
            url : contextPath + "/system/log/report/popDeleteReportRecord",
            param : {reportRecordId:reportRecordId},
            title : "填写删除原因"
        };
        $.dialog(dialogObj);
    };
    return {
        search : recordsPerform,
        searchReportRecord : searchReportRecord,
        changeType : changeType,
        detailReportRecord : detailReportRecord,
        returnSearch : returnSearch,
        toggle : toggle,
        reSubmit:reSubmit,
        deleteReportRecordDialog:deleteReportRecordDialog
//		empty:empty,
//		add : add
    };
})();