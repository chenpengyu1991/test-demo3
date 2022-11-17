var infectEmergencies = (function () {
    var validate = null;
    $(function () {
        $("#infectEmergenciesListDivExport").on("click", function(event) {
            $("#infectEmergenciesListDiv").exportExcel("传染病及突发公共卫生事件报告和处理统计报表");
        });
        showModify();
        //点击修改按钮，显示取消、保存按钮
        $("#modifyInfectEmer").on("click", function () {
            var countType = $('input:radio[name="countType"]:checked').val();
            if(countType == '1'){
                layer.alert("请选择季度！", {icon:0,title:'提示'});
                return;
            }
            $("#noModifyTbody").hide();
            $("#modifyTbody").show();
            showCancel();
        });
        //点击取消按钮，显示修改按钮
        $("#cancel").on("click", function () {
            $("#modifyTbody").hide();
            $("#noModifyTbody").show();
            showModify();
        });
        search();
        $("#save").click(function () {
            // 保存修改的内容：
            saveModifyInfo();
        });
        $("#infectEmergenciesSearch").on("click", function () {
            search();
        });
        $("#reportQuarter").on("change",function () {
            var quarter = $('#reportQuarter option:selected').val();
            search();
        });
        $("#mhmReprtQuarterId").on("click",function () {
            search();
        });
    });

    function search() {
        var searchObj = {
            url: "/infectEmergencies/list",
            insertDiv: "infectEmergenciesListDiv"
        };
        $("#infectEmergenciesForm").submitFormLoadHtml(searchObj);
    }

    //显示修改按钮，隐藏取消、保存按钮
    function showModify() {
        $("#cancelInfectEmer").hide();
        $("#modifyInfectEmer").show();
    }

    //显示取消、保存按钮，隐藏修改按钮
    function showCancel() {
        $("#modifyInfectEmer").hide();
        $("#cancelInfectEmer").show();
    }

    //保存
    function saveModifyInfo() {
        /*validate = $("#infectEmergenciesForm").easyValidate();
        var result=validate.validateForm();
        if(!result){
            layer.alert("报告季度必须填写!");
            return;
        }*/
        var countType = $('input:radio[name="countType"]:checked').val();
        if(countType == '1'){
            layer.alert("请选择季度！", {icon:0,title:'提示'});
            return;
        }

        var quarter = $('#reportQuarter option:selected').val();
        var year = $("#reportYearId").val();
        $("#infectEmerListForm").submitFormLoadHtml({
            url: contextPath + "/infectEmergencies/save",
            param:{
                quarter:quarter,
                year:year
            },
            callback:function () {
                layer.alert("修改成功！", {icon:0,title:'提示'});
                showModify();
                $("#modifyTbody").hide();
                $("#noModifyTbody").show();
                search();

            }
        });
    }
    //查询框
    function changeReportType(){
        var countType = $('input:radio[name="countType"]:checked').val();
        if(countType == '1'){//按年
            $('#reportYearId').show();
            $('#reportQuarter').hide();
        }else if(countType == '2'){//按季度
            $('#reportYearId').show();
            $('#reportQuarter').show();
        }
    }
    return {
        changeReportType:changeReportType
    };
})();
