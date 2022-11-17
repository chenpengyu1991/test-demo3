
var typhusCase = (function() {
	$(function() {
        $.Placeholder.init({query:"#idCard",callback:function(element){
            idCard.queryPerson($(element).val());
        }});
        toggleOther('epidemiologicalSurvey.contactHistory','contactHistoryFromAdd',1);
        toggleOther('epidemiologicalSurvey.homeContactPatients','homeContactPatientsForAdd',1);
        toggleOther('epidemiologicalSurvey.typhus','typhusForAdd',1);
        toggleOther('epidemiologicalSurvey.outHistory','outHistoryForAdd',1);
        toggleOther('epidemiologicalSurvey.inoculateHistory','inoculateHistoryForAdd',1);
        toggleOtherSC('generalCondition.occupation','occupationOtherPart','CV020120299');
        caseEdit.toggerAddress();
	});
	function popEfc(){
        var contactPersonDialog = {
                url : "/idm/case/typhusFever/contacted",
                height : 250,
                width : 800,
                title : "密切接触者",
                id :"efcDialog"
            };
            $.dialog(contactPersonDialog);		
	}
    function addEfcList(){
        validate = $("#addContacted").easyValidate();
        var result=validate.validateForm();
        if(!result){
            return;
        }
        var html = fillEfcRowData();
        $("#efcTable").append(html);
        caseEdit.closePopUp('efcDialog');
    }

    function editEfcList(){
        validate = $("#addContacted").easyValidate();
        var result=validate.validateForm();
        if(!result){
            return;
        }

        var rowIndex = $('#rowIndex').val();
        var html = fillEfcRowData();
        html = html.replace("</tr>", "");
        html = html.replace("<tr>", "");
        $("#efcTable tr").eq(rowIndex).html(html);
        caseEdit.closePopUp('efcDialog');
    }

    function editTr(editBtn, part){
    	
        var extendDiv = editBtn.parentNode.parentNode;
        var rowIndex = extendDiv.rowIndex;
        var trData = {};
        $(extendDiv).find("td").each(function(tdindex,tditem){
            var inputValue = $(tditem).text()
            if('' != inputValue){
                trData[$(this).attr("field")] = inputValue;
            }
        });
        var trDataStr =  "[" + util.Obj2str(trData) + "]";
        var efcDialog = {
            url : '/idm/case/typhusFever/contacted',
            height : 250,
            width : 800,
            title : "密切接触者",
            id :'efcDialog',
            param:{trData:trDataStr, rowIndex:rowIndex, type:'edit'}
        };
        $.dialog(efcDialog);
    }

    function getPatientValue(patientObj, tableId){
        $("#" + tableId).find("input").each(function(ind, obj) {
            if (obj.type == "text") {
                var inputValue = $(this).val();
                patientObj[$(this).attr("name")] = inputValue;
            }
            if(obj.type == "radio"){
                var sexVal = $("input[name='sex']").getValue();
                patientObj['sex'] = sexVal;
            }
        });

    }

    function fillEfcRowData(){
        var patientObj = {};
        getPatientValue(patientObj, 'popEfcTable');

        if(patientObj.sex == '1'){
            patientObj.sexStr = '男';
        }else if(patientObj.sex == '2'){
            patientObj.sexStr = '女';
        }else{
            patientObj.sexStr = '';
        }

        var html = '<tr>';
        html += '<td field="name" title="'+patientObj.name+'">'+patientObj.name+'</td>';
        html += '<td field="sexStr" title="'+patientObj.sexStr+'">'+patientObj.sexStr+'</td>';
        html += '<td field="sex" style="display:none;" title="'+patientObj.sex+'">'+patientObj.sex+'</td>';
        html += '<td field="age" title="'+patientObj.age+'">'+patientObj.age+'</td>';
        html += '<td field="unitAddr" title="'+patientObj.unitAddr+'">'+patientObj.unitAddr+'</td>';
        html += '<td field="vaccineDt" title="'+patientObj.vaccineDt+'">'+patientObj.vaccineDt+'</td>';
        html += '<td field="delousingDt" title="'+patientObj.delousingDt+'">'+patientObj.delousingDt+'</td>';
        html += '<td field="contactType" title="'+patientObj.contactType+'">'+patientObj.contactType+'</td>';
        html += '<td class="btnsublist" field="btn">' +
            '<a href="javascript:void(0)" onclick="typhusCase.editTr(this, ' + '\'efcList\'' + ')">修改</a>&nbsp;' +
            '<a href="javascript:void(0)" onclick="caseEdit.removeTr(this)">删除</a>' +
            '</td>';
        html += '</tr>';
        return html;
    }

    return {
        addEfcList:addEfcList,
        editEfcList:editEfcList,
        editTr:editTr,
        popEfc:popEfc
    };
})();




