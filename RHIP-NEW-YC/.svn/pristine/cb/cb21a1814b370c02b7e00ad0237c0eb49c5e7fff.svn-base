var epidemicFocus = (function() {
    var validate=null;
    $(function() {
        validate = $("#epidemicFocusForm").easyValidate();
        enableChangeConfirm();
//        searchCase(1);
        idmCommon.displayPaAddress();
        malariaIndex.diabaleForm("epidemicFocusForm");
    });

    function submitEpidemicFocus() {
    	validate = $("#epidemicFocusForm").easyValidate();    	
        var result=validate.validateForm();
        if(!result){
            return;
        }

        $("#listEddJson").val(util.Obj2str(idmCommon.getTablesData('eddTable', [], [], '')));

        $("#epidemicFocusForm").submitFormGetJson({
            url : '/idm/malaria/standard/saveEpidemicFocus',
            wait : true,
            callback : function(data) {
                if (data.indexOf("fail") > -1) {
                    layer.alert("疫点处理保存失败！", {icon:0,title:'提示'});
                }else {
                    layer.alert("疫点处理保存成功！", {icon:0,title:'提示'});
                    standardSearch.search();
                    return false;
                }
            }
        });
    };

    function searchCase(pageIndex){
        var searchObj = {
            url : "/idm/malaria/case/list",
            insertDiv : "caseResultDiv",
            param : {
                indexPage : pageIndex
            },
            wait : true,
            callback : function(data) {
            	$('#tagContent1').find('#pageIndex').val(pageIndex);
            }
        };
        $("#caseSearchForm").submitFormLoadHtml(searchObj);
    }

    function initEdit(singleId){
        $("#top_all2").hide();
        $.loadHtmlByUrl({
            url : "/idm/malaria/standard/initEditEpidemicPlace",
            insertDiv :"detailDiv2",
            wait : true,
            param : {singleId:singleId}
        });
        $("#detailDiv2").show();
    }

    function search(){
        disableChangeConfirm();
        var pageIndex = $("#pageIndex").val();
        $("#detailDiv2").empty();
        pageIndex = ($.isEmpty(pageIndex)?1:pageIndex);
        searchCase(pageIndex);
        $("#top_all2").show();
    }

    function returnSearch(){
        if(contentChanged){
            msgUtil.backConfirm(function(){
                search();
            });
        }else{
            search();
        }
    };

    function popupEdd(btn, type){
        var recordNum = $("#eddTable").find("tr").length;
        if("edit" != type && recordNum >= 6){
            layer.alert("疫点监测最多保存4条信息！", {icon:0,title:'提示'});
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
        var eddDialog = {
            url : "/idm/malaria/standard/popupEdd",
            height : 280,
            width : 800,
            title : "疫点处理监测",
            id :"eddDialog",
            param:param
        };
        $.dialog(eddDialog);
    }

    function saveEddData(type){
        validate = $("#addEddForm").easyValidate();
        var result=validate.validateForm();
        if(!result){
            return;
        }
        var html = fillEddRowData();
        if('edit' == type){
            var rowIndex = $('#rowIndex').val();
            html = html.replace("</tr>", "");
            html = html.replace("<tr>", "");
            $("#eddTable tr").eq(rowIndex).html(html);
        }else{
            $("#eddTable").append(html);
        }
        idmCommon.closePopUp('eddDialog');
    }

    function fillEddRowData(){
        var eddObj = idmCommon.getPopObj('popEddTable');
        var eddShowFields = ['checkDt', 'feverNum', 'feverLocal', 'feverForeign', 'agueNum', 'agueLocal', 'agueForeign', 'bloodNum', 'bloodPositiveNum', 'ifatNum', 'ifatPositiveNum', 'ifatProportionNum', 'disposeCondition', 'checkUser'];
        var eddHideFields = [];
        var eddShowValues = [eddObj.checkDt, eddObj.feverNum, eddObj.feverLocal, eddObj.feverForeign, eddObj.agueNum, eddObj.agueLocal, eddObj.agueForeign, eddObj.bloodNum, eddObj.bloodPositiveNum, eddObj.ifatNum, eddObj.ifatPositiveNum, eddObj.ifatProportionNum, eddObj.disposeCondition, eddObj.checkUser];
        var eddHideValues = [];
        var editMethod = "epidemicFocus.popupEdd(this, 'edit')";
        return idmCommon.generateTrHtml(eddShowFields, eddHideFields, eddShowValues, eddHideValues, editMethod);
    }

    return {
        submitEpidemicFocus:submitEpidemicFocus,
        initEdit:initEdit,
        returnSearch:returnSearch,
        popupEdd:popupEdd,
        saveEddData:saveEddData
    };
})();