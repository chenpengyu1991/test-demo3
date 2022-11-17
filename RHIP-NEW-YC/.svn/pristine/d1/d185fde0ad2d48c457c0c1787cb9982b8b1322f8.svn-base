
var choleraCase = (function() {
	$(function() {
		 $("#addActiveList").click(function() {
             var activeDialog = {
                 url : "/idm/case/cholera/active",
                 height : 250,
                 width : 800,
                 title : "病人发病前五天和发病后的主要活动情况" ,
                 id :"activeDialog"
             };
             $.dialog(activeDialog);
         });
         $("#addBddList").click(function() {
             var dietDialog = {
                 url : "/idm/case/cholera/diet",
                 height : 250,
                 width : 800,
                 title : "病前5天食谱" ,
                 id :"dietDialog"
             };
             $.dialog(dietDialog);
         });
        toggleOther('infectionSourceRoute.strangerBackFood','strangerFoodName1',1);
        toggleOther('otherCondition.inpatientFlg','inpatientFlgTd',1);
        toggleOtherSC('generalCondition.occupation','occupationPart','CV020120299');
        toggleOther('infectionSourceRoute.sameDisease','sameDiseaseForAdd',1);
        toggleOther('infectionSourceRoute.outHistory','outHistoryForAdd',1);;
        toggleOther('infectionSourceRoute.outBackFood','outBackFoodForAdd',1);
        toggleOther('infectionSourceRoute.contactSimilerPatient','contactSimilerPatientForAdd',1);
        toggleOther('infectionSourceRoute.stranger','strangerForAdd',1);
        toggleOther('epidemiologicalSurvey.outHistory','outHistoryTd',1);
        toggleOther('epidemicFocusClose.isPatientIsolation','isPatientIsolationDiv',1);
        toggleOther('beforeDiseaseDiet.drinkingHistory','drinkingHistoryForAdd',1);
        toggleOther('beforeDiseaseDiet.dinnerHistory','dinnerHistoryForAdd',1);
        toggleOther('beforeDiseaseDiet.touchPosiWater','touchPosiWaterForAdd',1);
        toggleOther('clinicalManifestations.diarrhea','diarrheaForAdd',1);
        toggleOther('clinicalManifestations.vomit','vomitForAdd',1);
        toggleOther('otherCondition.outhosBasis','outhosBasis',99);
        toggleOther('clinicalManifestations.fever','feverPart',1);
        toggleOther('infectionSourceRoute.outBackFood','outBackFoodName','1');
        toggleOther('clinicalManifestations.fxFounder','fxFounder','99');
        toggleOther('beforeDiseaseDiet.coldFood','coldFoodName',1);
        toggleOther('beforeDiseaseDiet.cookedFoodColdEat','cookedFoodName',1);
        toggleOther('beforeDiseaseDiet.suspiciousFood','susSalesPlaces','1');
        toggleOther('beforeDiseaseDiet.outsideDiningHistory','eatPlace',1);
        toggleOther('beforeDiseaseDiet.meals','mealPNum',1);
        caseEdit.toggerAddress();
	});

    function addActiveList(){
        validate = $("#addActive").easyValidate();
        var result=validate.validateForm();
        if(!result){
            return;
        }

        var html = fillActiveRowData();
        $("#efcTable").append(html);
        caseEdit.closePopUp('activeDialog');
    }

    function addBddList(){
        validate = $("#addBdd").easyValidate();
        var result=validate.validateForm();
        if(!result){
            return;
        }

        var html = fillBddRowData();
        $("#bddTable").append(html);
        caseEdit.closePopUp('dietDialog');
    }
    
    function editActiveList(){
        validate = $("#addActive").easyValidate();
        var result=validate.validateForm();
        if(!result){
            return;
        }
        var rowIndex = $('#rowIndex').val();
        var html = fillActiveRowData();
        html = html.replace("</tr>", "");
        html = html.replace("<tr>", "");
        $("#efcTable tr").eq(rowIndex).html(html);
        caseEdit.closePopUp('activeDialog');
    }
    
    function editBddList(){
        validate = $("#addBdd").easyValidate();
        var result=validate.validateForm();
        if(!result){
            return;
        }
        var rowIndex = $('#rowIndex').val();
        var html = fillBddRowData();
        html = html.replace("</tr>", "");
        html = html.replace("<tr>", "");
        $("#bddTable tr").eq(rowIndex).html(html);
        caseEdit.closePopUp('dietDialog');
    }
    
    function editTr(editBtn, part){
        var url = '/idm/case';
        var id = '';
        var title = '病人发病前五天和发病后的主要活动情况';
        
        if('efcList' == part){
            url = url + '/cholera/active';
            id = 'activeDialog';
        } else {
        	url = url + '/cholera/diet';
            id = 'dietDialog';
            title = '病前5天食谱';
        }
        var extendDiv = editBtn.parentNode.parentNode;
        var rowIndex = extendDiv.rowIndex;
        var trData = {};
        $(extendDiv).find("td").each(function(tdindex,tditem){
            var inputValue = $(tditem).text();
            if('' != inputValue){
                trData[$(this).attr("field")] = inputValue;
            }
        });
        var trDataStr =  "[" + util.Obj2str(trData) + "]";
        var efcDialog = {
            url : url,
            height : 250,
            width : 800,
            title : title,
            id :id,
            param:{trData:trDataStr, rowIndex:rowIndex, type:'edit'}
        };
        $.dialog(efcDialog);
    }

    function getActiveValue(patientObj, tableId){
        $("#" + tableId).find("input").each(function(ind, obj) {
            if (obj.type == "text") {
                var inputValue = $(this).val();
                patientObj[$(this).attr("id")] = inputValue;
            }
        });

    }

    function fillActiveRowData(){
        var activeObj = {};
        getActiveValue(activeObj, 'popActiveTable');

        var html = '<tr>';
        html += '<td field="activityDt" title="'+activeObj.activityDt+'">'+activeObj.activityDt+'</td>';
        html += '<td field="activityAddr" title="'+activeObj.activityAddr+'">'+activeObj.activityAddr+'</td>';
        html += '<td field="dungAddr" title="'+activeObj.dungAddr+'">'+activeObj.dungAddr+'</td>';
        html += '<td field="vomitAddr" title="'+activeObj.vomitAddr+'">'+activeObj.vomitAddr+'</td>';
        html += '<td field="vehiclePollute" title="'+activeObj.vehiclePollute+'">'+activeObj.vehiclePollute+'</td>';
        html += '<td class="btnsublist" field="btn"> <a href="javascript:void(0)" onclick="choleraCase.editTr(this, ' + '\'efcList\'' + ')">修改</a>' +
            ' <a href="javascript:void(0)"  onclick="caseEdit.removeTr(this)">删除</a></td>';
        html += '</tr>';
        return html;
    }

    function fillBddRowData(){
        var bddObj = {};
        getActiveValue(bddObj, 'popBddTable');

        var html = '<tr>';
        html += '<td field="dietDate" title="'+bddObj.dietDate+'">'+bddObj.dietDate+'</td>';
        html += '<td field="mealNum" title="'+bddObj.mealNum+'">'+bddObj.mealNum+'</td>';
        html += '<td field="addr" title="'+bddObj.addr+'">'+bddObj.addr+'</td>';
        html += '<td field="foodName" title="'+bddObj.foodName+'">'+bddObj.foodName+'</td>';
        html += '<td field="mealPeople" title="'+bddObj.mealPeople+'">'+bddObj.mealPeople+'</td>';
        html += '<td class="btnsublist" field="btn"> <a href="javascript:void(0)" onclick="choleraCase.editTr(this, ' + '\'bddList\'' + ')">修改</a>' +
            ' <a href="javascript:void(0)"  onclick="caseEdit.removeTr(this)">删除</a></td>';
        html += '</tr>';
        return html;
    }
    
    return {
        addActiveList : addActiveList,
        editActiveList:editActiveList,
        addBddList:addBddList,
        editBddList:editBddList,
        editTr:editTr
    };
})();




