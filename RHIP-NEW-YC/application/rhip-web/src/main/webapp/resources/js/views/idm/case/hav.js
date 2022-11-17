var havCase = (function() {
    $(function() {
        $.Placeholder.init({query:"#idCard",callback:function(element){
        	idCard.queryPerson($(element).val());
        }});
        toggleOtherSC('generalCondition.occupation','occupationOtherPart','CV020120299');
        toggleOther('otherCondition.resistenceAgue','agueIdea',1);
        toggleOther('infectionSourceRoute.familyFever','feverPlasmodium',1);
        toggleOther('epidemiologicalSurvey.aimmugen','aimmugenDtPart',1);
        toggleOther('clinicalManifestations.fever','highestTemperature',1);
        toggleOther('epidemiologicalSurvey.hepatitis','hepatitisDtPart',1);
        toggleOther('epidemiologicalSurvey.hepatitisCategory','hepatitisOther',99);
        toggleOther('epidemiologicalSurvey.hepatitisContactHistory','hepatitisContactHistoryPart',1);
        toggleOther('epidemiologicalSurvey.chHepatitisCategory','chHepatitisOther',99);
        toggleOther('infectionSourceRoute.outHistory','outHistory',1);
        toggleOther('infectionSourceRoute.strangerLive','strangerLive1',1);
        toggleOther('pastHistory.isOut','inAguePlace',2);
        toggleOther('pastHistory.isOut','outAguePlace',1);
        toggleOther('attackCondition.isOverseas','foreignAddr1',1);
        toggleOther('attackCondition.isOverseas','pathogenesisPlace1',2);
        toggleOther('attackCondition.complication','complicationName1',2);
        toggerAddress();
        initChange();
    });
	
	function initChange(){
        $("input[name='infectionSourceRoute.outHistory']").change(function(){
            toggleOtherSC('infectionSourceRoute.outHistory','abcd',1);
        });
		$("input[name='generalCondition.occupation']").change(function(){
        	toggleOtherSC('generalCondition.occupation','occupationOtherPart','CV020120299');
		});
        $("input[name='epidemiologicalSurvey.aimmugen']").change(function(){
        	toggleOther('epidemiologicalSurvey.aimmugen','aimmugenDtPart',1);
		});
        $("input[name='clinicalManifestations.fever']").change(function(){
        	toggleOther('clinicalManifestations.fever','highestTemperature',1);
		});
        $("input[name='epidemiologicalSurvey.hepatitis']").change(function(){
        	toggleOther('epidemiologicalSurvey.hepatitis','hepatitisDtPart',1);
		});
        $("input[name='epidemiologicalSurvey.hepatitisCategory']").change(function(){
        	 toggleOther('epidemiologicalSurvey.hepatitisCategory','hepatitisOther',99);
		});
        $("input[name='epidemiologicalSurvey.hepatitisContactHistory']").change(function(){
        	toggleOther('epidemiologicalSurvey.hepatitisContactHistory','hepatitisContactHistoryPart',1);
        	toggleOther('epidemiologicalSurvey.chHepatitisCategory','chHepatitisOther',99);
		});
        $("input[name='epidemiologicalSurvey.chHepatitisCategory']").change(function(){
            toggleOther('epidemiologicalSurvey.chHepatitisCategory','chHepatitisOther',99);
        });
        $("input[name='generalCondition.addrType']").change(function(){
        	toggerAddress();
		});
        //$("#addEfcList").click(popEfc);
        //$("#importEfc").click(function(){
        	//caseEdit.contactedImport('2031');
		//});
	}
    function popEfc(){
        var contactPersonDialog = {
                url : "/idm/case/hav/contacted",
                height : 250,
                width : 800,
                title : "密切接触者",
                id :"efcDialog"
            };
        $.dialog(contactPersonDialog);    	
    }
    /*隐藏、显示地址*/
    function toggerAddress(){
        var value=$('input[name="generalCondition.addrType"]:checked').val();

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
        toggleOther('generalCondition.addrType','pavillage_address','1');
        toggleOther('generalCondition.addrType','patown_address','1');
    }

    function addEfcList(){
        validate = $("#addContact").easyValidate();
        var result=validate.validateForm();
        if(!result){
            return;
        }
        var html = fillEfcRowData();
        $("#efcTable").append(html);
        caseEdit.closePopUp('efcDialog');
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
        caseEdit.closePopUp('efcDialog');
    }

    function editTr(editBtn, part){
        var url = '/idm/case';
        var id = ''
        if('efcList' == part){
            url = url + '/hav/contacted';
            id = 'efcDialog'
        }
        if('esList' == part){
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
        	  var inputValue = $(this).val();
              patientObj[$(this).attr("name")] = inputValue;
            /*if (obj.type == "text") {
                var inputValue = $(this).val();
                patientObj[$(this).attr("name")] = inputValue;
            }
            if(obj.type == "radio"){
                var sexVal = $("input[name='sex']").getValue();
                var attackVal = $("input[name='attack']").getValue();
                patientObj['sex'] = sexVal;
                patientObj['attack'] = attackVal;
            }*/
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
        html += '<td field="name" title="'+patientObj.name+'">'+patientObj.name+'</td>';
        html += '<td field="sexStr" title="'+patientObj.sexStr+'">'+patientObj.sexStr+'</td>';
        html += '<td field="sex" style="display:none;" title="'+patientObj.sex+'">'+patientObj.sex+'</td>';
        html += '<td field="age" title="'+patientObj.age+'">'+patientObj.age+'</td>';
        html += '<td field="relation" title="'+patientObj.relation+'">'+patientObj.relation+'</td>';
        html += '<td field="unitAddr" title="'+patientObj.unitAddr+'">'+patientObj.unitAddr+'</td>';
        html += '<td field="attackStr" title="'+patientObj.attackStr+'">'+patientObj.attackStr+'</td>';
        html += '<td field="attack" style="display:none;" title="'+patientObj.attack+'">'+patientObj.attack+'</td>';
        html += '<td field="attackDt" title="'+patientObj.attackDt+'">'+patientObj.attackDt+'</td>';
        html += '<td field="labExamination" title="'+patientObj.labExamination+'">'+patientObj.labExamination+'</td>';
        html += '<td class="btnsublist" field="btn">' +
            '<a href="javascript:void(0)" onclick="havCase.editTr(this, ' + '\'efcList\'' + ')">修改&nbsp;</a>' +
            '<a href="javascript:void(0)" onclick="caseEdit.removeTr(this)">删除</a>' +  '</td>';
        html += '</tr>';
        return html;
    }
    return {
        toggerAddress:toggerAddress,
        addEfcList:addEfcList,
        editEfcList:editEfcList,
        editTr:editTr,
        popEfc:popEfc
    };
})();


