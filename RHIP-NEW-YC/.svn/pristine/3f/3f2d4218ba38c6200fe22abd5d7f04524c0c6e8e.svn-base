var mentalEpilepsyPatient = (function () {
    $(function () {
        showModify();
        //点击修改按钮，显示取消、保存按钮
        $("#modifyMentalEpi").on("click", function () {
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
        //点击查询按钮
        $("#mentalEpiSearch").on("click", function () {
            search();
        });
        //改变季度-更新列表
        $("#Quarter").on("change",function () {
            search();
        });
        //点击按季度按钮
        $("#QuarterType").on("click",function () {
            search();
        });
    });

    function search() {
        var searchObj = {
            url: "/mentalEpilepsyPatient/list",
            insertDiv: "mentalEpilepsyPatientListDiv"
        };
        $("#MentalEpiForm").submitFormLoadHtml(searchObj);
    }

    //显示修改按钮，隐藏取消、保存按钮
    function showModify() {
        $("#cancelMentalEpi").hide();
        $("#modifyMentalEpi").show();
    }

    //显示取消、保存按钮，隐藏修改按钮
    function showCancel() {
        $("#modifyMentalEpi").hide();
        $("#cancelMentalEpi").show();
    }

    //保存
    function saveModifyInfo() {
        var countType = $('input:radio[name="countType"]:checked').val();
        if(countType == '1'){
            layer.alert("请选择季度！", {icon:0,title:'提示'});
            return;
        }

        var quarter = $('#Quarter option:selected').val();
        var year = $("#Year").val();
        $("#mentalEpilepsyPatientForm").submitFormLoadHtml({
            url: contextPath + "/mentalEpilepsyPatient/save",
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
    function changeReportType(){
        var countType = $('input:radio[name="countType"]:checked').val();
        if(countType == '1'){//按年
            $('#Year').show();
            $('#Quarter').hide();
        }else if(countType == '2'){//按季度
            $('#Year').show();
            $('#Quarter').show();
        }
    }
    return {
        changeReportType:changeReportType
    };
})();
