/**
 * Created with IntelliJ IDEA.
 * User: zheng_dandan
 * Date: 13-6-14
 * Time: 下午1:13
 * To change this template use File | Settings | File Templates.
 */

var stopDetialH = (function() {
    function Stop(doctorName,doctorSn,deptSn,deptName,hospitalCode) {
        var dUrl = "/portal/stop/stopDetailSearch";
        var stopDetails = {
            url : dUrl,
            id : "stopDialog",
            height : 300,
            width : 800,
            param : {
                doctorName : doctorName ,
                doctorSn :  doctorSn ,
                deptSn :  deptSn ,
                deptName : deptName,
                hospitalCode : hospitalCode
            },
            title : "停诊",
            close : null
        };
        $.dialog(stopDetails);
    }

    function cancelStop(id) {
        var dUrl = "/portal/stop/cancelStop";
        var option = {
            url : dUrl,
            param : {
                cancelId: id
            },
            callback :function(data){
                if(data == "ok"){
                    layer.alert("取消停诊成功！", {icon:0,title:'提示'});
                    stopSearch.search(1);
                    return;
                }else if(data == "fail"){
                    layer.alert("取消停诊失败！", {icon:0,title:'提示'});
                }
            }
        };
        $.getJsonByUrl(option);
    }

    function viewStop(indexPage,doctorName,doctorSn,deptSn,deptName,hospitalCode) {
        var dUrl = "/portal/stop/viewStop";
        var viewStopDetails = {
            url : dUrl,
            id : "viewStopDialog",
            height : 500,
            width : 600,
            param : {
                indexPage : indexPage,
                doctorName : doctorName ,
                doctorSn :  doctorSn ,
                deptSn :  deptSn ,
                deptName : deptName,
                hospitalCode : hospitalCode
            },
            title : "该医生的停诊记录",
            close : null
        };
        $.dialog(viewStopDetails);
    }

    function closeDialog() {
        $.removeDialog("stopDialog");
    }

    return {
        Stop :  Stop ,
        cancelStop : cancelStop,
        viewStop : viewStop,
        closeDialog : closeDialog
    };
})();
