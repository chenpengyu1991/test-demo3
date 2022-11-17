var medication = (function() {
    $(function() {
        mhmCommon.initDrugSelectBox('drugSelectBox',selectFun);
    });

    /*保存用药*/
    function saveMedication(type,refTable){
        var validate = $("#medicationForm").easyValidate();
        var drugId = $("#medicationForm input[name='drugId']").val();
        if($.isEmpty(drugId)){
            validate.addError('drugId_name',"请选择正确的药品，若该药品不存在，请先去药品维护中添加！");
            return;
        }
        var result=validate.validateForm();
        if(!result){
            return;
        }
        var html = fillData(refTable);
        if('edit' == type){
            var rowIndex = $('#rowIndex').val();
            html = html.replace("</tr>", "");
            html = html.replace("<tr>", "");
            $("#"+refTable+" tr").eq(rowIndex).html(html);
        }else{
            $("#"+refTable).append(html);
        }
        contentChanged = true;
//        mhmCommon.closePopUp('medicationDialog');
        mhmCommon.closeLayUiDialog();
    }

    function fillData(refTable){
        var detailObj = mhmCommon.getPopObj('medicationDetailTable');
        var detailShowFields = ['drugName', 'drugMorning', 'drugNoon','drugEvening','unit','drugSpecial'];
        var detailHideFields = ['drugId'];
        var detailShowValues = [detailObj.drugName,detailObj.drugMorning,detailObj.drugNoon,detailObj.drugEvening,detailObj.unit,detailObj.drugSpecial];
        var detailHideValues = [detailObj.drugId];
        var editMethod = "outInfo.popupMedication(this,'edit', '"+ refTable + "')";
        return mhmCommon.generateTrHtml(detailShowFields, detailHideFields, detailShowValues, detailHideValues, editMethod);
    }

    /**
     * 选择药品后，设置相关字段
     */
    function selectFun(data){
        $('#hDrugName').val($(data).attr("drugName"));
        $('#hUnit').val($(data).attr("drugUnit"));
        $('#unit').text($(data).attr("drugUnit"));
    }

    return {
        saveMedication:saveMedication
    };
})();