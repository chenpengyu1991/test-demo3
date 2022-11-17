var ai = (function() {
    var validate=null;
    $(function() {
        validate = $("#aiForm").easyValidate();
        enableChangeConfirm();
    });

    function submitAi() {
        validate = $("#aiListForm").easyValidate();
        var result=validate.validateForm();
        if(!result){
            return;
        }
        var tbLength = $("#aiTable tr").length;
        if(tbLength == 1){
            layer.alert("请填写主动侦查记录！", {icon:0,title:'提示'});
            return;
        }
        var checkStreet = $("#checkStreet").val();
        var checkTownShip = $("#checkTownShip").val();
        var checkHouseNumber = $("#checkHouseNumber").val();
        var checkUser = $("#checkUser").val();
        var reportDt = $("#reportDt").val();

        var aiObjList = idmCommon.getTablesData('aiTable', [], [], '');

        var aiObjList2 = [];

        for(var i=0; i<aiObjList.length; i++){
            var aiObj = aiObjList[i];
            aiObj.checkStreet = checkStreet;
            aiObj.checkTownShip = checkTownShip;
            aiObj.checkHouseNumber = checkHouseNumber;
            aiObj.checkUser = checkUser;
            aiObj.reportDt = reportDt;
            aiObjList2.push(aiObj);
        }

        $("#listAiJson").val(util.Obj2str(aiObjList2));

        $("#aiListForm").submitFormGetJson({
            wait : true,
            url : '/idm/malaria/standard/saveAi',
            callback : function(data) {
                if (data.indexOf("fail") > -1) {
                    layer.alert("保存失败！", {icon:0,title:'提示'});
                }else {
                    layer.alert("保存成功！", {icon:0,title:'提示'});
//                    standardSearch.searchStandard();
                    standardSearch.search()
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

    function popupAi(btn, type){
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
        var aiDialog = {
            url : "/idm/malaria/standard/popupAi",
            height : 260,
            width : 800,
            title : "主动侦查",
            id :"aiDialog",
            param:param
        };
        $.dialog(aiDialog);
    }

    function saveAiData(type){
        validate = $("#addAiForm").easyValidate();
        var result=validate.validateForm();
        if(!result){
            return;
        }
        var html = fillAiRowData();
        if('edit' == type){
            var rowIndex = $('#rowIndex').val();
            html = html.replace("</tr>", "");
            html = html.replace("<tr>", "");
            $("#aiTable tr").eq(rowIndex).html(html);
        }else{
            $("#aiTable").append(html);
        }
        idmCommon.closePopUp('aiDialog');
    }

    function fillAiRowData(){
        var aiObj = idmCommon.getPopObj('popAiTable');
        aiObj['genderStr'] = getRadioValue('gender');
        aiObj['visitResultStr'] = $('#visitResult option:selected').text();
        aiObj['visitResult'] = $('#visitResult option:selected').val();
        aiObj['checkTypeStr'] = getRadioValue('checkType');
        aiObj['checkResultStr'] = getRadioValue('checkResult');
        var aiShowFields = ['name', 'headHouseholdName', 'genderStr', 'age', 'visitResultStr', 'checkTypeStr', 'checkResultStr', 'diagnosisResult', 'comments'];
        var aiHideFields = ['gender','visitResult','checkType','checkResult'];
        var aiShowValues = [aiObj.name, aiObj.headHouseholdName, aiObj.genderStr, aiObj.age, aiObj.visitResultStr, aiObj.checkTypeStr, aiObj.checkResultStr, aiObj.diagnosisResult, aiObj.comments];
        var aiHideValues = [aiObj.gender, aiObj.visitResult, aiObj.checkType, aiObj.checkResult];
        var editMethod = "ai.popupAi(this, 'edit')";
        return idmCommon.generateTrHtml(aiShowFields, aiHideFields, aiShowValues, aiHideValues, editMethod);
    }

    function getRadioValue(radioName){
        var val = $("input[name="+radioName+"]:checked").data("label");
        return val;
    }

    function initUpdateAi(id){
        var aiDialog = {
            url : "/idm/malaria/standard/initUpdateAi",
            height : 260,
            width : 800,
            title : "主动侦查",
            id :"aiDialog",
            param:{id:id, type:'update'}
        };
        $.dialog(aiDialog);
    }

    function updateAi(id){
        var validate = $("#addAiForm").easyValidate();
        var result=validate.validateForm();
        if(!result){
            return;
        }
        $("#addAiForm").submitFormGetJson({
            wait : true,
            url : '/idm/malaria/standard/updateAi',
            callback : function(data) {
                if (data.indexOf("fail") > -1) {
                    layer.alert("保存失败！", {icon:0,title:'提示'});
                }else {
                    layer.alert("保存成功！", {icon:0,title:'提示'});
//                    standardIndex.search();
                    idmCommon.closePopUp('aiDialog');
                    var pageIndex = $("#pageIndex").val();
                    standardSearch.searchStandard(pageIndex);
                    return false;
                }
            }
        });
    }

    function deleteAi(id){
    	var index = layer.confirm("确认删除？", {icon:2, title:'确认提示'}, function(){
            $.getJsonByUrl({
                url : "/idm/malaria/standard/deleteAi",
                param : {id:id},
                wait : true,
                callback : function(data) {
                    if (data.indexOf("fail") > -1) {
                        layui.use('layer', function() {
                        	var layer = layui.layer;
                        	layer.alert("删除失败！", {icon:0,title:'提示'});
                        });
                    }else {
                        layui.use('layer', function() {
                        	var layer = layui.layer;
                        	layer.alert("删除成功！", {icon:0,title:'提示'});
                        });
                        var pageIndex = $("#pageIndex").val();
                        standardSearch.searchStandard(pageIndex);
                        return false;
                    }
                }
            });
            layer.close(index);
        })
    }

    return {
        submitAi:submitAi,
        initEdit:initEdit,
        popupAi:popupAi,
        saveAiData:saveAiData,
        initUpdateAi:initUpdateAi,
        updateAi:updateAi,
        deleteAi:deleteAi
    };
})();