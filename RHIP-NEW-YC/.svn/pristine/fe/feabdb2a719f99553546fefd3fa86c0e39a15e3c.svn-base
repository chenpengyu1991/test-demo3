
var scarlatinaCase = (function() {
	var validate=null;
	$(function() {
        $.Placeholder.init({query:"#idCard",callback:function(element){
            idCard.queryPerson($(element).val());
        }});
		/*职业-其他*/
        toggleOtherSC('generalCondition.occupation','occupationOtherPart','CV020120299');
		/*出院时病原携带情况*/
		toggleOther('attackCondition.carrierFlg','spanGermicultureResult','1');
		/*发热*/
		toggleOther('clinicalManifestations.fever','trFever','1');
		/*有无外出史*/
		toggleOther('epidemiologicalSurvey.outHistory','divOutHistory','1');
		/*与病人接触史*/
		toggleOther('epidemiologicalSurvey.contactHistory','divContactHistory','1');
		/*接触方式*/
		toggleOther('epidemiologicalSurvey.contactRelation','contactRelationOtherId','99');
		toggleOther('epidemiologicalSurvey.pph','pphDiv','1');
		toggleOther('epidemiologicalSurvey.oftenPublicPlace','oftenPublicPlace','99');
		toggleOther('clinicalManifestations.rash','rashParts',1);
		caseEdit.toggerAddress();
		$("#addLabExamine").click(function() {
            var labExaDialog = {
                url : "/idm/case/scarlatina/labExamine",
                height : 250,
                width : 800,
                title : "实验室检查" ,
                id :"labExaDialog"
            };
            $.dialog(labExaDialog);
        });
	});

	function popEfc(){
        var contactDialog = {
                url : "/idm/case/scarlatina/contact",
                height : 250,
                width : 800,
                title : "密切接触者" ,
                id :"contactDialog"
            };
         $.dialog(contactDialog);		
	}
    /*隐藏、显示地址*/
//    function toggerAddress(){
//        debugger;
//        var value=$('input[name="generalCondition.patientAttribute"]:checked').val();
//
//        if('1' == value){
//            $("#pavillage_address").removeAttr("disabled");
//            $("#hrvillage_address").removeAttr("disabled");
//            $('#patown_address').removeAttr("disabled");
//            $('#hrtown_address').removeAttr("disabled");
//            $('#spanPaNumber').text("门牌号");
//            $('#spanHrNumber').text("门牌号");
//            $('#pahouseNumber').attr({"style":"width:180px"});
//            $('#hrhouseNumber').attr({"style":"width:180px"});
//        }else{
//            $("#pavillage_address").attr("disabled", "disabled");
//            $("#hrvillage_address").attr("disabled", "disabled");
//            $("#patown_address").attr("disabled", "disabled");
//            $("#hrtown_address").attr("disabled", "disabled");
//            $('#spanPaNumber').text("");
//            //$('#spanHrNumber').text("详细地址");
//            $('#pahouseNumber').attr({'style':'width:90%'});
//            $('#hrhouseNumber').attr({'style':'width:90%'});
//        }
//        toggleOther('generalCondition.patientAttribute','pavillage_address','1');
//        toggleOther('generalCondition.patientAttribute','patown_address','1');
//    }


    /**
	 * 1、输入年龄时，必须选择年龄单位
	 */
	function checkAge(){
//		debugger;
		var age = $('#age').val();
		if(!$.isEmpty(age)){
			validate.addCheckElement('ageUnit',{"required":"true"});
		}else{
			validate.removeCheckElement('ageUnit');
		}		
	};
	
	function fillConData(){
		var name=$('#nameId').val();
		var sex=$('#sexId').val();
		var sexName=$("#sexId").find("option:selected").text();
		sexName = sexName=='请选择'?'':sexName;
		var age=$('#ageId').val();
		var relation=$('#relationId').val();
		var contactType=$('#contactTypeId').val();
		var attackCondition = $('#attackConditionId').val();
		var unitAddr=$('#unitAddrId').val();
	    var html = '<tr>';
        html += '<td field="name" title="'+name+'">'+name+'</td>';
        html += '<td field="sexStr"  title="'+sexName+'">'+sexName +'</td>';
        html += '<td field="sex" style="display:none;" title="'+sex+'">'+sex+'</td>';
        html += '<td field="age" title="'+age+'">'+age+'</td>';
        html += '<td field="relation" title="' + relation +'">'+relation+'</td>';        
        html += '<td field="unitAddr" title="'+ unitAddr + '">'+unitAddr+'</td>';
        html += '<td field="contactType" title="' + contactType + '">'+contactType+'</td>';
        html += '<td field="attackCondition" title="'+ attackCondition +'">'+attackCondition+'</td>';
        html += '<td class="btnsublist" field="btn"><a href="javascript:void(0)" onclick="scarlatinaCase.editConTr(this)">修改</a>';
        html += ' <a href="javascript:void(0)" onclick="caseEdit.removeTr(this)">删除</a></td>';
        html += '</tr>';
        return html;
	}
	/*新增时，保存密切接触者*/
	function saveContact(){
		validate = $("#contact").easyValidate();
		var result=validate.validateForm();
		if(!result){
			return;
		}
		var html = fillConData();
	    $("#efcTable").append(html);      
	    caseEdit.closePopUp('contactDialog');
	}

	/*修改时弹出，密切接触者画面*/
	function editConTr(editLink){
		var trData = {};
		var extendDiv = editLink.parentNode.parentNode;
	    var rowNum = extendDiv.rowIndex;
        $(extendDiv).find("td").each(function(tdindex,tditem){
	    	var inputValue = $(tditem).text();
	        if('' != inputValue){
	        	trData[$(this).attr("field")] = inputValue;
	        }
        });
		var trDataStr =  "[" + util.Obj2str(trData) + "]";
		trDataStr = trDataStr.replace(/[\t]/g, ""); 
		contactDialog = {
                url : "/idm/case/scarlatina/contact",
                height : 250,
                width : 800,
                title : "密切接触者" ,
                id :"contactDialog",
                param:{trData:trDataStr,type:'edit',rowNum:rowNum}                
            };
        $.dialog(contactDialog);
		
	}
	/*修改后，保存密切接触者*/
	function modifyContact(){
		validate = $("#contact").easyValidate();
		var result=validate.validateForm();
		if(!result){
			return;
		}
		var rowIndex = $('#rowNum').val();
		var html = fillConData(rowIndex);
	    html = html.replace("</tr>", "");
	    html = html.replace('<tr>', "");
	    $("#efcTable tr").eq(rowIndex).html(html);		
	    caseEdit.closePopUp('contactDialog');	
	}	

	function fillLabData(){
		var other=$('#otherId').val();
		var checkFt=$('#checkFtId').val();
		var checkResult=$("#checkResultId").val();
	    var html = '<tr>';
        html += '<td field="other" title="' + other + '">'+other+'</td>';
        html += '<td field="checkFt" title="'+checkFt+'">'+checkFt +'</td>';
        html += '<td field="checkResult" title="'+ checkResult + '">'+checkResult+'</td>';
        html += '<td class="btnsublist" field="btn"><a href="javascript:void(0)" onclick="scarlatinaCase.editLabTr(this)">修改</a>';
        html += ' <a href="javascript:void(0)" onclick="caseEdit.removeTr(this)">删除</a></td>';
        html += '</tr>';
        return html;
	}
	
	/*新增时，保存实验室检查*/
	function saveLabExamine(){
		validate = $("#labExamine").easyValidate();
		var result=validate.validateForm();
		if(!result){
			return;
		}
		var html = fillLabData();
	    $("#leTable").append(html);      
	    caseEdit.closePopUp('labExaDialog');
	}

	/*修改时弹出，实验室检查画面*/
	function editLabTr(editLink){
		var trData = {};
		var extendDiv = editLink.parentNode.parentNode;
	    var rowNum = extendDiv.rowIndex;
        $(extendDiv).find("td").each(function(tdindex,tditem){
	    	var inputValue = $(tditem).text();
	        if('' != inputValue){
	        	trData[$(this).attr("field")] = inputValue;
	        }
        });		
		var trDataStr =  "[" + util.Obj2str(trData) + "]";
		trDataStr = trDataStr.replace(/[\t]/g, ""); 
		labExaDialog = {
                url : "/idm/case/scarlatina/labExamine",
                height : 250,
                width : 800,
                title : "密切接触者" ,
                id :"labExaDialog",
                param:{trData:trDataStr,type:'edit',rowNum:rowNum}                
            };
        $.dialog(labExaDialog);
		
	}
	/*修改后，保存实验室检查*/
	function modifyLabExamine(){
		validate = $("#labExamine").easyValidate();
		var result=validate.validateForm();
		if(!result){
			return;
		}
		var rowIndex = $('#rowNum').val();
		var html = fillLabData(rowIndex);
	    html = html.replace("</tr>", "");
	    html = html.replace('<tr>', "");
	    $("#leTable tr").eq(rowIndex).html(html);		
	    caseEdit.closePopUp('labExaDialog');	
	}		
	return {
//        toggerAddress:toggerAddress,
		saveContact:saveContact,
		editConTr:editConTr,
		modifyContact:modifyContact,
		saveLabExamine:saveLabExamine,
		editLabTr:editLabTr,
		modifyLabExamine:modifyLabExamine,
		popEfc:popEfc
	};
})();

