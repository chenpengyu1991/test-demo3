var malariaCaseEdit = (function() {
    var validate=null;
    $(function() {
        validate = $("#caseForm").easyValidate();

        toggleOther('attackCondition.pathogenesisPlaceSelect','outPlace',1);
        toggleOther('attackCondition.pathogenesisPlaceSelect','inPlace',2);
        toggleOtherSC('attackCondition.firstVisitUnit','firstVisitUnitOther',99);
        toggleOtherSC('attackCondition.thisDiagnosisType','thisDiagnosisTypeOther',9);
        toggleOther('clinicalManifestations.isComplications','complications',1);
        toggleOtherSC('pastHistory.agueDrug','agueDrugOther',99);
        toggleOther('pastHistory.isForeign','attackOut',1);
        toggleOther('pastHistory.isForeign','attackIn',2);
        toggleOther('infectionSourceRoute.outHistory','outHistoryPart',1);
        toggleOther('infectionSourceRoute.stranger','strangerPart',1);
        toggleOther('infectionSourceRoute.familyFever','feverPlasmodium',1);
        idmCommon.toggerAddress();
//        searchCase();
        var type = $('#tagContent1').find('#type').val();
        /*如果是查看，则禁用页面*/
        if('view' == type){
            $("#caseForm").diabaleForm();
            $('#pathogenesisDateId').removeAttr("onfocus");
            $('#firstVisitDateId').removeAttr("onfocus");
            $('#plasmodiumDtId').removeAttr("onfocus");
            $('#lastDt').removeAttr("onfocus");
            $('#lastTreatDt').removeAttr("onfocus");
            $('#modifySurveyDateId').removeAttr("onfocus");
        }
//        $("#caseSearchForm").onEnter(searchCase, 1);
        idmCommon.displayPaAddress();
        idmCommon.displayHrAddress();
		malariaIndex.diabaleForm('caseForm');
    });

    function caseSubmit(type) {
        var result=validate.validateForm();
        if(!result){
            return;
        }
        var urlStr = '';
        if(type == 1){
            urlStr = '/idm/malaria/case/save';
        }else{
            urlStr = '/idm/malaria/case/edit';
        }
        //时间类型,格式转成"yyyy/MM/dd"
        var lastDt =  $('#lastDt').val();
        if(undefined != lastDt && lastDt != '' && lastDt.length == 7){
            var lastDtYMD = lastDt + '/01';
            $('#lastDt').val(lastDtYMD);
        }
        var lastTreatDt =  $('#lastTreatDt').val();
        if(undefined != lastTreatDt && lastTreatDt != '' && lastTreatDt.length == 7){
            var lastTreatDtYMD = lastTreatDt + '/01';
            $('#lastTreatDt').val(lastTreatDtYMD);
        }

        $("#caseForm").submitFormGetJson({
            url : urlStr,
            wait : true,
            callback : function(data) {
                if (data.indexOf("fail") > -1) {
                    layer.alert("个案保存失败！", {icon:0,title:'提示'});
                }else {
                    layer.alert("个案保存成功！", {icon:0,title:'提示'});
                    malariaCase.search();
                    return false;
                }
            }
        });
    };


    function caseDownLoad(){
//        location.href = contextPath + "/idm/malaria/case/downMalariaCaseExcel";
        location.href = contextPath + "/idm/malaria/case/downMalariaCaseExcel?" + $('#caseSearchForm').formSerialize();

    }

    return {
        caseSubmit:caseSubmit,
        caseDownLoad:caseDownLoad
    };
})();