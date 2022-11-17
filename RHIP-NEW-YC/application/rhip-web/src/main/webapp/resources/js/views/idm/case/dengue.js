var dengueCase = (function() {
    $(function() {
        toggleOther('attackCondition.dengueInhosDiagnosis','dengueInhosDiagnosisOther',99);
        toggleOther('attackCondition.dengueOutDiagnosis','dengueOutDiagnosisOther',99);
        toggleOther('otherCondition.outcomeCode','deathTime',4);
        toggleOther('otherCondition.outcomeCode','diseaseRecord',1);
        
        toggleOther('clinicalManifestations.skinBleType','skinBleTypeOth',99);
        toggleOther('clinicalManifestations.rash','rashPart',1);
        toggleOther('epidemicFocusClose.isSimSymptFamily','isSimSymptFamilyPart',1);
        toggleOtherSC('hygienicCondition.containerType','containerOther',99);
        toggleOther('hygienicCondition.equipment','equipmentOther',99);
        toggleOther('hygienicCondition.equipment','equipmentOther',99);
        toggleOtherSC('generalCondition.occupation','studentsDiv','CV020120203');
        
        toggleOther('pastHistory.jeVaccineFlg','jeVaccinationDiv',1);
        caseEdit.toggerAddress();
    });

    function addEfcList(){
        validate = $("#addContact").easyValidate();
        var result=validate.validateForm();
        if(!result){
            return;
        }
        var html = fillEfcRowData();
        $("#efcTable").append(html);
        closePopUp('efcDialog');
    }

    function editEfcList(){
        validate = $("#addContact").easyValidate();
        var result=validate.validateForm();
        if(!result){
            return;
        }
        var rowIndex = $('#rowIndex').val();
        var html = fillEfcRowData();
        html = html.replace("</tr>", "");
        html = html.replace("<tr>", "");
        $("#efcTable tr").eq(rowIndex).html(html);
        closePopUp('efcDialog');
    }

    function editTr(editBtn, part){
        var url = '/idm/case';
        var id = ''
        if('efcList' == part){
            url = url + '/hav/contacted';
            id = 'efcDialog'
        }if('esList' == part){
            url = url + '/hav/contact';
            id = 'esDialog';
        }
        var extendDiv = editBtn.parentNode.parentNode;
        var rowIndex = extendDiv.rowIndex;
        var trData = {};
        $(extendDiv).find("td").each(function(tdindex,tditem){
            var inputValue = $(tditem).text()
            if('' != inputValue){
                trData[$(this).attr("field")] = inputValue;
            }
            if($(this).attr("field") == 'contactDtStr'){
                if(inputValue.length >10 ){
                    trData['contactBeginDt'] = inputValue.substr(0,10);
                }
                if(inputValue.length >14 ){
                    trData['contactEndDt'] = inputValue.substr(11,21);
                }
            }
        });
        var trDataStr =  "[" + util.Obj2str(trData) + "]";
        var efcDialog = {
            url : url,
            height : 250,
            width : 800,
            title : "密切接触者",
            id :id,
            param:{trData:trDataStr, rowIndex:rowIndex, type:'edit'}
        };
        $.dialog(efcDialog);
    }

    function getPatientValue(patientObj, tableId){
        $("#" + tableId).find("input").each(function(index, obj) {
            if (obj.type == "text") {
                var inputValue = $(this).val();
                patientObj[$(this).attr("name")] = inputValue;
            }
            if(obj.type == "radio"){
                var sexVal = $("input[name='sex']").getValue();
                var attackVal = $("input[name='attack']").getValue();
                patientObj['sex'] = sexVal;
                patientObj['attack'] = attackVal;
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
        if(patientObj.attack == '1'){
            patientObj.attackStr = '是';
        }else if(patientObj.attack == '2'){
            patientObj.attackStr = '否';
        }else{
            patientObj.attackStr = '';
        }

        var efcTable = $("#efcTable");
        var html = '<tr>';
        html += '<td field="name">'+patientObj.name+'</td>';
        html += '<td field="sexStr">'+patientObj.sexStr+'</td>';
        html += '<td field="sex" style="display:none;">'+patientObj.sex+'</td>';
        html += '<td field="age">'+patientObj.age+'</td>';
        html += '<td field="relation">'+patientObj.relation+'</td>';
        html += '<td field="unitAddr">'+patientObj.unitAddr+'</td>';
        html += '<td field="attackStr">'+patientObj.attackStr+'</td>';
        html += '<td field="attack" style="display:none;">'+patientObj.attack+'</td>';
        html += '<td field="attackDt">'+patientObj.attackDt+'</td>';
        html += '<td field="labExamination">'+patientObj.labExamination+'</td>';
        html += '<td class="btnsublist" field="btn">' +
            '<a href="javascript:void(0)" onclick="dengueCase.editTr(this, ' + '\'efcList\'' + ')">修改&nbsp;</a>' +
            '<a href="javascript:void(0)" onclick="caseEdit.removeTr(this)">删除</a>' +  '</td>';
        html += '</tr>';
        return html;
    }
    

    return {
        addEfcList:addEfcList,
        editEfcList:editEfcList,
        editTr:editTr
    };
})();



