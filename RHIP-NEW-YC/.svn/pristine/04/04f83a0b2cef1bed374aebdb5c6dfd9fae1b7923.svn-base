var visit = (function() {
    var validate=null;
    $(function() {
        idmCommon.toggerAddress();
        validate = $("#visitForm").easyValidate();
        enableChangeConfirm();
        idmCommon.displayPaAddress();
        idmCommon.displayHrAddress();
        malariaIndex.diabaleForm('visitForm');
    });

    function submitVisit() {
        validate = $("#visitForm").easyValidate();
        var result=validate.validateForm();
        if(!result){
            return;
        }
        $("#listFrJson").val(util.Obj2str(idmCommon.getTablesData('frTable', [], [], '')));
        $("#listSdJson").val(util.Obj2str(getSdTableData()));
        $("#visitForm").submitFormGetJson({
            url : '/idm/malaria/standard/saveVisit',
            wait : true,
            callback : function(data) {
                if (data.indexOf("fail") > -1) {
                    layer.alert("保存失败！", {icon:0,title:'提示'});
                }else {
                    layer.alert("保存成功！", {icon:0,title:'提示'});
                    standardSearch.search();
                    return false;
                }
            }
        });
    };

    function initEdit(singleId){
        $("#top_all2").hide();
        var pageIndex = $("#currentPage").val();
        $.loadHtmlByUrl({
            url : "/idm/malaria/standard/initEditEpidemicPlace",
            insertDiv :"detailDiv2",
            wait : true,
            param : {singleId:singleId, pageIndex:pageIndex}
        });
        $("#detailDiv2").show();
    }

    function popupFr(btn, type){
        var recordNum = $("#frTable").find("tr").length;
        if("edit" != type && recordNum >= 6){
            layer.alert("访视记录最多保存4条信息！", {icon:0,title:'提示'});
            return;
        }
        var param = '';
        if("edit" == type){
            var extendDiv = btn.parentNode.parentNode;
            var rowIndex = extendDiv.rowIndex;
            var trData = {};
            $(extendDiv).find("td").each(function(tdindex,tditem){
                var inputValue = $(tditem).text()
                if('' != inputValue){
                    trData[$(this).attr("field")] = inputValue;
                }
            });
            var trDataStr =  "[" + util.Obj2str(trData) + "]";
            param = {trData:trDataStr, rowIndex:rowIndex, type:'edit'};
        }
        var frDialog = {
            url : "/idm/malaria/standard/popupFr",
            height : 280,
            width : 800,
            title : "访视情况",
            id :"frDialog",
            param:param
        };
        $.dialog(frDialog);
    }

    function saveFrData(type){
        validate = $("#addFrForm").easyValidate();
        var result=validate.validateForm();
        if(!result){
            return;
        }
        var html = fillFrRowData();
        if('edit' == type){
            var rowIndex = $('#rowIndex').val();
            html = html.replace("</tr>", "");
            html = html.replace("<tr>", "");
            $("#frTable tr").eq(rowIndex).html(html);
        }else{
            $("#frTable").append(html);
        }
        idmCommon.closePopUp('frDialog');
    }

    function fillFrRowData(){
        var frObj = idmCommon.getPopObj('popFrTable');
        frObj['impressTypeStr'] = getRadioValue('impressType');
        if(frObj.impressType == 99){
            frObj.impressTypeStr = '';
        }
        var frShowFields = ['visitDt', 'feverDays', 'feverType', 'temperature', 'checkType', 'checkResult', 'impressTypeStr', 'impressOther', 'visitContent', 'checkUser'];
        var frHideFields = ['impressType'];
        var frShowValues = [frObj.visitDt, frObj.feverDays, frObj.feverType, frObj.temperature, frObj.checkType, frObj.checkResult, frObj.impressTypeStr, frObj.impressOther, frObj.visitContent, frObj.checkUser];
        var frHideValues = [frObj.impressType];
        var editMethod = "visit.popupFr(this, 'edit')";
        return idmCommon.generateTrHtml(frShowFields, frHideFields, frShowValues, frHideValues, editMethod);
    }

    function addDrug(){
        var html = '<tr><td>药物名称<input type="text" name="drugName" style="width: 120px;text-align: center" reg=\'{"maxlength":"100"}\'>，' +
            '总量（<input type="text" name="totalNum" style="width: 45px;text-align: center" reg=\'{"maxlength":"20"}\'>mg/片）' +
            '<input type="text" name="trocheNum" style="width: 45px;text-align: center" reg=\'{"maxlength":"20"}\'>片，' +
            '服法<input type="text" name="methodDetail" style="width: 160px;text-align: center" reg=\'{"maxlength":"200"}\'>' +
            '&nbsp;&nbsp;<a href="javascript:void(0)" onclick="idmCommon.removeTr(this)">删除</a></td></tr>';
        $("#sdTable").append(html);
    }

    function getRadioValue(radioName){
        var val = $("input[name="+radioName+"]:checked").data("label");
        return val;
    }

    function getSdTableData(){
        var tableData = [];
        $("#sdTable tr").each(function(trindex,tritem){
                var trData = {};
                $(tritem).find("input").each(function(){
                    var inputValue = $(this).val();
                    if('' != inputValue && "undefined" !=inputValue && undefined !=inputValue ){
                        trData[$(this).attr("name")] = inputValue;
                    }
                });
                tableData.push(trData);
        });
        return tableData;
    }

    return {
        submitVisit:submitVisit,
        initEdit:initEdit,
        popupFr:popupFr,
        saveFrData:saveFrData,
        addDrug:addDrug
    };
})();