
var hfmdCase = (function() {
	$(function() {
        toggleOther('attackCondition.admissionFlg','admissionFlgTb',1);
        toggleOther('attackCondition.prognosis','prognosisOther',99);
        toggleOther('attackCondition.sequelae','sequelaeName',1);
        toggleOther('clinicalManifestations.fever','highestTemperature',1);
        toggleOther('clinicalManifestations.rash','rashParts',1);
        toggleOtherCK('clinicalManifestations.respiratory','otherRespiratory',99);
        toggleOtherCK('clinicalManifestations.digestiveSystem','otherDigestiveSystem',99);
        toggleOther('labExamine.hemogram','hemogramPart',1);
        toggleOther('labExamine.xrayTestResult','xrayTestExpression',1);
        toggleOther('clinicalManifestations.compl','complDescription',1);
        toggleOther('clinicalManifestations.isComplications','complications',1);
        toggleOther('beforeDiseaseDiet.goHfmDisease','goHfmDiseasePart',1);
        toggleOther('beforeDiseaseDiet.outsideDiningHistory','outsideDiningHistoryPart',1);
        toggleOther('epidemiologicalSurvey.contactHistory','contactHistoryPart',1);
        toggleOtherSC('generalCondition.occupation','occupationPart','CV020120299');
        caseEdit.toggerAddress();
	});

	function popEs(){
        var contactPatientDialog = {
                url : "/idm/case/hfmd/contact",
                height : 250,
                width : 800,
                title : "患者接触史" ,
                id :"esDialog"
            };
        $.dialog(contactPatientDialog);		
	}
	function popEfc(){
        var contactPersonDialog = {
                url : "/idm/case/hfmd/contacted",
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
        var id = ''
        if('efcList' == part){
            url = url + '/hfmd/contacted';
            id = 'efcDialog'
        }if('esList' == part){
            url = url + '/hfmd/contact';
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
//        url : "/idm/case/hfmd/contacted",
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
        $("#" + tableId).find("input").each(function(ind, obj) {
            if (obj.type == "text") {
                var inputValue = $(this).val();
                patientObj[$(this).attr("name")] = inputValue;
            }
            if(obj.type == "radio"){
                var inhospitalVal = $("input[name='inhospital']:radio:checked").val();
                var sexVal = $("input[name='sex']:radio:checked").val();
                var attackVal = $("input[name='attack']:radio:checked").val();
                patientObj['inhospital'] = inhospitalVal;
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
        if(patientObj.inhospital == '1'){
            patientObj.inhospitalStr = '是';
        }else if(patientObj.inhospital == '2'){
            patientObj.inhospitalStr = '否';
        }else{
            patientObj.inhospitalStr = '';
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
        html += '<td field="name" title="'+patientObj.name+'">'+patientObj.name+'</td>';
        html += '<td field="sexStr" title="'+patientObj.sexStr+'">'+patientObj.sexStr+'</td>';
        html += '<td field="sex" style="display:none;" title="'+patientObj.sex+'">'+patientObj.sex+'</td>';
        html += '<td field="age" title="'+patientObj.age+'">'+patientObj.age+'</td>';
        html += '<td field="relation" title="'+patientObj.relation+'">'+patientObj.relation+'</td>';
        html += '<td field="attackStr" title="'+patientObj.attackStr+'">'+patientObj.attackStr+'</td>';
        html += '<td field="attack" style="display:none;" title="'+patientObj.attack+'">'+patientObj.attack+'</td>';
        html += '<td field="attackDt" title="'+patientObj.attackDt+'">'+patientObj.attackDt+'</td>';
        html += '<td field="contactBeginDt" style="display:none;" >'+patientObj.contactBeginDt+'</td>';
        html += '<td field="contactEndDt" style="display:none;" >'+patientObj.contactEndDt+'</td>';
        html += '<td field="contactDtStr" title="'+patientObj.contactBeginDt+'-'+patientObj.contactEndDt+'">'+patientObj.contactBeginDt+'-'+patientObj.contactEndDt+'</td>';
        html += '<td field="inhospitalStr" title="'+patientObj.inhospitalStr+'">'+patientObj.inhospitalStr+'</td>';
        html += '<td field="inhospital" style="display:none;" title="'+patientObj.inhospital+'">'+patientObj.inhospital+'</td>';
        html += '<td field="clinicalDiagnosis" title="'+patientObj.clinicalDiagnosis+'">'+patientObj.clinicalDiagnosis+'</td>';
        html += '<td class="btnsublist" field="btn">' +
            '<a href="javascript:void(0)" onclick="hfmdCase.editTr(this, ' + '\'efcList\'' + ')">修改</a>&nbsp;' +
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
        if(patientObj.inhospital == '1'){
            patientObj.inhospitalStr = '是';
        }else if(patientObj.inhospital == '2'){
            patientObj.inhospitalStr = '否';
        }else{
            patientObj.inhospitalStr = '';
        }

        var esTable = $("#esTable");
        var html = '<tr>';
        html += '<td field="name" title="'+patientObj.name+'">'+patientObj.name+'</td>';
        html += '<td field="sexStr" title="'+patientObj.sexStr+'">'+patientObj.sexStr+'</td>';
        html += '<td field="sex" style="display:none;" title="'+patientObj.sex+'">'+patientObj.sex+'</td>';
        html += '<td field="age" title="'+patientObj.age+'">'+patientObj.age+'</td>';
        html += '<td field="relation" title="'+patientObj.relation+'">'+patientObj.relation+'</td>';
        html += '<td field="attackDt" title="'+patientObj.attackDt+'">'+patientObj.attackDt+'</td>';
        html += '<td field="clinicalDiagnosis" title="'+patientObj.clinicalDiagnosis+'">'+patientObj.clinicalDiagnosis+'</td>';
        html += '<td field="contactBeginDt" style="display:none;" >'+patientObj.contactBeginDt+'</td>';
        html += '<td field="contactEndDt" style="display:none;" >'+patientObj.contactEndDt+'</td>';
        html += '<td field="contactDtStr" title="'+patientObj.contactBeginDt+'-'+patientObj.contactEndDt+'">'+patientObj.contactBeginDt+'-'+patientObj.contactEndDt+'</td>';
        html += '<td field="inhospitalStr" title="'+patientObj.inhospitalStr+'">'+patientObj.inhospitalStr+'</td>';
        html += '<td field="inhospital" style="display:none;" title="'+patientObj.inhospital+'">'+patientObj.inhospital+'</td>';
        html += '<td field="comments" title="'+patientObj.comments+'">'+patientObj.comments+'</td>';
        html += '<td class="btnsublist" field="btn">' +
            '<a href="javascript:void(0)" onclick="hfmdCase.editTr(this, ' + '\'esList\'' + ')">修改</a>&nbsp;' +
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




