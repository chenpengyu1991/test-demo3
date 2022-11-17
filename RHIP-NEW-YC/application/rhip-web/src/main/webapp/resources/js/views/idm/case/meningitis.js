var meningitisCase = (function() {
    $(function() {
        $.Placeholder.init({query:"#idCard",callback:function(element){
            idCard.queryPerson($(element).val());
        }});
        toggleOther('epidemiologicalSurvey.meningitis','meningitisPart',1);
        toggleOther('clinicalManifestations.isolationPlace','isolationPlaceOth',99);
        toggleOther('labExamine.routineBlood','routineBloodPart',1);
        toggleOther('labExamine.csfCheck','csfCheckPart',1);
        toggleOther('labExamine.labDiagnosis','labDiagnosisPart',1);
        toggleOther('labExamine.sensitivityResult','sensitiveDrugs',1);
        toggleOther('otherCondition.outcomeCode','deathTime',4);
        toggleOther('epidemiologicalSurvey.contactHistory','contactWay',1);
        caseEdit.toggerAddress();
    });

    /*隐藏、显示地址*/
    function toggerAddress(){
        var value=$('input[name="generalCondition.patientAttribute"]:checked').val();
        if('1' == value){
            $("#pavillage_address").removeAttr("disabled");
            $("#hrvillage_address").removeAttr("disabled");
            $('#patown_address').removeAttr("disabled");
            $('#hrtown_address').removeAttr("disabled");
            $('#spanPaNumber').text("门牌号");
            $('#spanHrNumber').text("门牌号");
            $('#pahouseNumber').attr({"style":"width:180px"});
            $('#hrhouseNumber').attr({"style":"width:180px"});
        }else{
            $("#pavillage_address").attr("disabled", "disabled");
            $("#hrvillage_address").attr("disabled", "disabled");
            $("#patown_address").attr("disabled", "disabled");
            $("#hrtown_address").attr("disabled", "disabled");
            $('#spanPaNumber').text("详细地址");
            $('#spanHrNumber').text("详细地址");
            $('#pahouseNumber').attr({'style':'width:90%'});
            $('#hrhouseNumber').attr({'style':'width:90%'});
        }
        toggleOther('generalCondition.patientAttribute','pavillage_address','1');
        toggleOther('generalCondition.patientAttribute','patown_address','1');
    }

    function initPopEs(){
        var contactPatientDialog = {
            url : "/idm/case/meningitis/initPopEs",
            height : 180,
            width : 800,
            title : "患者接触史" ,
            id :"esDialog"
        };
        $.dialog(contactPatientDialog);
    }

    function initPopEfc(){
        var contactPersonDialog = {
            url : "/idm/case/meningitis/initPopEfc",
            height : 250,
            width : 800,
            title : "密切接触者" ,
            id :"efcDialog"
        };
        $.dialog(contactPersonDialog);
    }

    function addEsList(){
        validate = $("#addEsForm").easyValidate();
        var result=validate.validateForm();
        if(!result){
            return;
        }
        var html = fillEsRowData();
        $("#esTable").append(html);
        caseEdit.closePopUp('esDialog');
    }

    function editEsList(){
        validate = $("#addEsForm").easyValidate();
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

    function addEfcList(){
        validate = $("#addEfcForm").easyValidate();
        var result=validate.validateForm();
        if(!result){
            return;
        }
        var html = fillEfcRowData();
        $("#efcTable").append(html);
        caseEdit.closePopUp('efcDialog');
    }

    function editEfcList(){
        validate = $("#addEfcForm").easyValidate();
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
        var html = '<tr>';
        html += '<td field="name" title="'+patientObj.name+'">'+patientObj.name+'</td>';
        html += '<td field="sexStr" title="'+patientObj.sexStr+'">'+patientObj.sexStr+'</td>';
        html += '<td field="sex" style="display:none;" title="'+patientObj.sex+'">'+patientObj.sex+'</td>';
        html += '<td field="age" title="'+patientObj.age+'">'+patientObj.age+'</td>';
        html += '<td field="relation" title="'+patientObj.relation+'">'+patientObj.relation+'</td>';
        html += '<td field="attackCondition" title="'+patientObj.attackCondition+'">'+patientObj.attackCondition+'</td>';
        html += '<td class="btnsublist" field="btn">' +
            '<a href="javascript:void(0)" onclick="meningitisCase.editTr(this, ' + '\'esList\'' + ')">修改</a>&nbsp;' +
            '<a href="javascript:void(0)" onclick="caseEdit.removeTr(this)">删除</a>' +
            '</td>';
        html += '</tr>';
        return html;
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
        if(patientObj.contactType == '1'){
            patientObj.contactTypeStr = '同一家庭';
        }else if(patientObj.contactType == '2'){
            patientObj.contactTypeStr = '邻居来往';
        }else if(patientObj.contactType == '4'){
            patientObj.contactTypeStr = '同工作';
        }else{
            patientObj.contactTypeStr = '';
        }

        var html = '<tr>';
        html += '<td field="name" title="'+patientObj.name+'">'+patientObj.name+'</td>';
        html += '<td field="sexStr" title="'+patientObj.sexStr+'">'+patientObj.sexStr+'</td>';
        html += '<td field="age" title="'+patientObj.age+'">'+patientObj.age+'</td>';
        html += '<td field="profession" title="'+patientObj.profession+'">'+patientObj.profession+'</td>';
        html += '<td field="unitAddr" title="'+patientObj.unitAddr+'">'+patientObj.unitAddr+'</td>';
        html += '<td field="contactTypeStr" title="'+patientObj.contactTypeStr+'">'+patientObj.contactTypeStr+'</td>';
        html += '<td field="vaccineHistory" title="'+patientObj.vaccineHistory+'">'+patientObj.vaccineHistory+'</td>';
        html += '<td field="comments" title="'+patientObj.comments+'">'+patientObj.comments+'</td>';
        html += '<td field="sex" style="display:none;" title="'+patientObj.sex+'">'+patientObj.sex+'</td>';
        html += '<td field="contactType" style="display:none;" title="'+patientObj.contactType+'">'+patientObj.contactType+'</td>';
        html += '<td class="btnsublist" field="btn">' +
            '<a href="javascript:void(0)" onclick="meningitisCase.editTr(this, ' + '\'efcList\'' + ')">修改</a>&nbsp;' +
            '<a href="javascript:void(0)" onclick="caseEdit.removeTr(this)">删除</a>' +
            '</td>';
        html += '</tr>';
        return html;
    }

    function editTr(editBtn, part){
        var url = '/idm/case';
        var id = '';
        var title = '';
        var height = ''
        if('efcList' == part){
            url = url + '/meningitis/initPopEfc';
            id = 'efcDialog';
            title = '密切接触史';
            height = 250;
        }if('esList' == part){
            url = url + '/meningitis/initPopEs';
            id = 'esDialog';
            title = '患者接触史';
            height = 180;
        }
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
        var meningitisDialog = {
            url : url,
            height : height,
            width : 800,
            title : title,
            id :id,
            param:{trData:trDataStr, rowIndex:rowIndex, type:'edit'}
        };
        $.dialog(meningitisDialog);
    }

    function getPatientValue(patientObj, tableId){
        $("#" + tableId).find("input").each(function(ind, obj) {
        	 var inputValue = $(this).val();
             patientObj[$(this).attr("name")] = inputValue;
           /* if (obj.type == "text") {
                var inputValue = $(this).val();
                patientObj[$(this).attr("name")] = inputValue;
            }
            if(obj.type == "radio"){
                var sexVal = $("input[name='sex']").getValue();
                patientObj['sex'] = sexVal;
                var contactTypeVal = $("input[name='contactType']").getValue();
                patientObj['contactType'] = contactTypeVal;
            }*/
        });
    }

    return {
        toggerAddress:toggerAddress,
        addEsList : addEsList,
        editEsList:editEsList,
        addEfcList:addEfcList,
        editEfcList:editEfcList,
        editTr:editTr,
        initPopEs:initPopEs,
        initPopEfc:initPopEfc
    };
})();