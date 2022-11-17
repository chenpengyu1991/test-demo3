var varicellaCase = (function() {
	$(function() {
		toggleOther('clinicalManifestations.fever','temperature','1');
		toggleOther('labExamine.serumSpecimenF','serumSpecimenDtF','1');
		toggleOther('labExamine.serumSpecimenF','serumSpecimenDtS','1');
		toggleOther('labExamine.etiologySpecimens','stoolCollecttimeOne','1');
		toggleOther('epidemiologicalSurvey.contactHistory','divContactHistory','1');
		toggleOther('epidemiologicalSurvey.inoculateHistory','diphtheritisVaccineF','2');
		toggleOther('epidemiologicalSurvey.inoculateHistory','diphtheritisVaccineS','2');
		toggleOther('epidemicFocusClose.isPatientIsolation','isPatientIsolationDiv',1);
		caseEdit.toggerAddress();
		$("input[name='generalCondition.floatPopulation']").change(function(){
			caseEdit.toggerAddress();
		});
	});
	
	function popEs(){
        var contactPatientDialog = {
                url : "/idm/case/varicella/contact",
                height : 250,
                width : 800,
                title : "患者接触史" ,
                id :"esDialog"
            };
        $.dialog(contactPatientDialog);		
	}
	function popEfc(){
        var contactPersonDialog = {
                url : "/idm/case/varicella/contacted",
                height : 300,
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
            url = url + '/varicella/contacted';
            id = 'efcDialog';
            title = '密切接触者';
        }if('esList' == part){
            url = url + '/varicella/contact';
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
		 alert(patientObj.attackCondition);
		 /*密切接触者：是否患过水痘，是否接种过水痘疫苗 */
		 if('popEfcTable' == tableId){
			 var vaccineHistory=$("input[name='vaccineHistory']:radio:checked").val();
			 if(vaccineHistory == '1'){
		            patientObj.vaccineHistoryStr = '是';
		        }else if(sex == '2'){
		            patientObj.vaccineHistoryStr = '否';
		        }else{
		            patientObj.vaccineHistoryStr = '';
		        }
			 patientObj['vaccineHistory'] = vaccineHistory;
			 
			 var attackCondition=$("input[name='attackCondition']:radio:checked").val();
			 if(attackCondition == '1'){
		            patientObj.attackConditionStr = '是';
		        }else if(sex == '2'){
		            patientObj.attackConditionStr = '否';
		        }else{
		            patientObj.attackConditionStr = '';
		        }
			 patientObj['attackCondition'] = attackCondition;
		 }
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
        html += '<td field="attackConditionStr" title="'+ patientObj.attackConditionStr + '">'+ patientObj.attackConditionStr + '</td>';
        html += '<td field="attackCondition" style="display:none;">'+patientObj.attackCondition +'</td>';
        html += '<td field="vaccineHistoryStr title="'+ patientObj.vaccineHistoryStr+'">'+ patientObj.vaccineHistoryStr + '</td>';
        html += '<td field="vaccineHistory" style="display:none;">'+patientObj.vaccineHistory+'</td>';
        html += '<td field="relation" title="'+patientObj.relation+'">'+patientObj.relation+'</td>';  
        html += '<td field="contactTypeStr" title="'+patientObj.contactTypeStr+'">'+patientObj.contactTypeStr+'</td>';
        html += '<td field="contactType" style="display:none;">'+patientObj.contactType+'</td>';
        html += '<td field="contactBeginDt" style="display:none;" >'+patientObj.contactBeginDt+'</td>';
        html += '<td field="contactEndDt" style="display:none;" >'+patientObj.contactEndDt+'</td>';
        html += '<td field="contactDtStr" title="'+patientObj.contactBeginDt+'-'+patientObj.contactEndDt+'">'+patientObj.contactBeginDt+'-'+patientObj.contactEndDt+'</td>';
        html += '<td field="medicalObservationResults" title="'+patientObj.medicalObservationResults+'">'+patientObj.medicalObservationResults+'</td>';
        html += '<td class="btnsublist" field="btn">' +
            '<a href="javascript:void(0)" onclick="varicellaCase.editTr(this, ' + '\'efcList\'' + ')">修改</a>&nbsp;' +
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
            '<a href="javascript:void(0)" onclick="varicellaCase.editTr(this, ' + '\'esList\'' + ')">修改</a>&nbsp;' +
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




