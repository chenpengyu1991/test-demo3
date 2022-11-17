
var mumpsCase = (function() {
	$(function() {
		toggleOther('generalCondition.floatPopulation','spanHrhouseNumber',1);
		toggleOther('clinicalManifestations.fever','divFever',1);
		toggleOther('labExamine.routineBlood','divRoutineBloodDate',2);
		toggleOther('clinicalManifestations.isMassReceding','spanMassAsideDate',1);
		toggleOther('clinicalManifestations.isComplications','spanComplications',1);
		toggleOther('epidemiologicalSurvey.contactPatients','divPatientsAddr',1);
		toggleOther('otherCondition.outcomeCode','divDeathTime',4);
        toggleOther('clinicalManifestations.fever','feverPart1',1);
        toggleOther('epidemiologicalSurvey.sxAcceptVaccine','sxAcceptLastDate',1)
        toggleOther('epidemiologicalSurvey.sxVisitPlace','sxPlaceOther',99);
        toggleOther('epidemiologicalSurvey.sxQuerantinePlace','sxQuerantinePlaceOther',99);
        toggleOther('epidemiologicalSurvey.sxQuerantine','sxQuerantine',1);
        toggleOther('epidemiologicalSurvey.sxFamilySameCase','pertussisContactList1',1);
        toggleOther('epidemiologicalSurvey.sxBeforeTouch','sxTouchTripe',1);
	});
    function popEs(){
        var contactPatientDialog = {
            url : "/idm/case/mumps/contact",
            height : 250,
            width : 800,
            title : "患者接触史" ,
            id :"esDialog"
        };
        $.dialog(contactPatientDialog);
    }
    function popEfc(){
        var contactPersonDialog = {
            url : "/idm/case/mumps/contacted",
            height : 250,
            width : 800,
            title : "密切接触者",
            id :"efcDialog"
        };
        $.dialog(contactPersonDialog);
    }
    function addEsList(){
        validate = $("#addContact").easyValidate();
        var result=validate.validateForm();
        if(!result){
            return;
        }

        var html = fillEsRowData();
        $("#esTable").append(html);
        caseEdit.closePopUp('esDialog');
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

    function editEsList(){
        validate = $("#addContact").easyValidate();
        var result=validate.validateForm();
        if(!result){
            return;
        }
        var rowIndex = $('#rowIndex').val();
        var html = fillEsRowData();
        html = html.replace("</tr>", "");
        html = html.replace("<tr>", "");
        $("#esTable tr").eq(rowIndex).html(html);
        caseEdit.closePopUp('esDialog');
    }

    function editTr(editBtn, part){
        var url = '/idm/case';
        var id = '';
        var title = '';
        if('efcList' == part){
            url = url + '/mumps/contacted';
            id = 'efcDialog';
            title = '密切接触者';
        }if('esList' == part){
            url = url + '/mumps/contact';
            id = 'esDialog';
            title = '患者接触史';
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
//        url : "/idm/case/hfmd/contacted",
            url : url,
            height : 250,
            width : 800,
            title : title,
            id :id,
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
        });

        var contactType=$("input[name='contactType']:radio:checked").val();
        if(contactType == '1'){
            patientObj.contactTypeStr = '同住';
        }else if(contactType == '2'){
            patientObj.contactTypeStr = '陪护';
        }else if(contactType == '3'){
            patientObj.contactTypeStr = '同校';
        }else if(contactType == '4'){
            patientObj.contactFormStr = '同班级';
        }else if(contactType == '99'){
            patientObj.contactTypeStr = '其他';
        }else {
            patientObj.contactTypeStr = '';
        }
        patientObj['contactType'] = contactType;

        var sex=$("input[name='sex']:radio:checked").val();
        if(sex == '1'){
            patientObj.sexStr = '男';
        }else if(sex == '2'){
            patientObj.sexStr = '女';
        }else{
            patientObj.sexStr = '';
        }
        patientObj['sex'] = sex;
    }

    function fillEfcRowData(){
        var patientObj = {};
        getPatientValue(patientObj, 'popEfcTable');



        var efcTable = $("#efcTable");
        var html = '<tr>';
        html += '<td field="name" title="'+patientObj.name+'">'+patientObj.name+'</td>';
        html += '<td field="sexStr" title="'+patientObj.sexStr+'">'+patientObj.sexStr+'</td>';
        html += '<td field="sex" style="display:none;" title="'+patientObj.sex+'">'+patientObj.sex+'</td>';
        html += '<td field="age" title="'+patientObj.age+'">'+patientObj.age+'</td>';
        html += '<td field="relation" title="'+patientObj.relation+'">'+patientObj.relation+'</td>';
        html += '<td field="contactTypeStr" title="'+patientObj.contactTypeStr+'">'+patientObj.contactTypeStr+'</td>';
        html += '<td field="contactType" style="display:none;">'+patientObj.contactType+'</td>';
        html += '<td field="contactBeginDt" style="display:none;" >'+patientObj.contactBeginDt+'</td>';
        html += '<td field="contactEndDt" style="display:none;" >'+patientObj.contactEndDt+'</td>';
        html += '<td field="contactDtStr" title="'+patientObj.contactBeginDt+'-'+patientObj.contactEndDt+'">'+patientObj.contactBeginDt+'-'+patientObj.contactEndDt+'</td>';
        html += '<td field="medicalObservationResults" title="'+patientObj.medicalObservationResults+'">'+patientObj.medicalObservationResults+'</td>';
        html += '<td class="btnsublist" field="btn">' +
            '<a href="javascript:void(0)" onclick="mumpsCase.editTr(this, ' + '\'efcList\'' + ')">修改</a>&nbsp;' +
            '<a href="javascript:void(0)" onclick="caseEdit.removeTr(this)">删除</a>' +
            '</td>';
        html += '</tr>';
        return html;
    }

    function fillEsRowData(){
        var patientObj = {};
        getPatientValue(patientObj, 'popEsTable');

        if(patientObj.sex == '1'){
            patientObj.sexStr = '男';
        }else if(patientObj.sex == '2'){
            patientObj.sexStr = '女';
        }else{
            patientObj.sexStr = '';
        }

        var esTable = $("#esTable");
        var html = '<tr>';
        html += '<td field="name" title="'+patientObj.name+'">'+patientObj.name+'</td>';
        html += '<td field="sexStr" title="'+patientObj.sexStr+'">'+patientObj.sexStr+'</td>';
        html += '<td field="sex" style="display:none;" title="'+patientObj.sex+'">'+patientObj.sex+'</td>';
        html += '<td field="age" title="'+patientObj.age+'">'+patientObj.age+'</td>';
        html += '<td field="relation" title="'+patientObj.relation+'">'+patientObj.relation+'</td>';
        html += '<td field="attackCondition" title="'+patientObj.attackCondition+'">'+patientObj.attackCondition+'</td>';
        html += '<td class="btnsublist" field="btn">' +
            '<a href="javascript:void(0)" onclick="mumpsCase.editTr(this, ' + '\'esList\'' + ')">修改</a>&nbsp;' +
            '<a href="javascript:void(0)" onclick="caseEdit.removeTr(this)">删除</a>' +
            '</td>';
        html += '</tr>';
        return html;
    }

    return {
        addEsList : addEsList,
        editEsList:editEsList,
        addEfcList:addEfcList,
        editEfcList:editEfcList,
        editTr:editTr,
        popEs:popEs,
        popEfc:popEfc
    };


})();

