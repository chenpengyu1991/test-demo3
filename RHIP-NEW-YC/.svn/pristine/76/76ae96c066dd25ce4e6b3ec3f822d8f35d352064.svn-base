
var dysenteryCase = (function() {
	var validate=null;
	$(function() {
        $.Placeholder.init({query:"#idCard",callback:function(element){
            idCard.queryPerson($(element).val());
        }});

		 $("#addDisinfect").click(function() {
			 var disinfectDialog = {
                 url : "/idm/case/dysentery/disinfect",
                 height : 250,
                 width : 800,
                 title : "消毒情况" ,
                 id :"disinfectDialog"
             };
             $.dialog(disinfectDialog);
         });
		 $("#addExamine").click(function() {
			 var leDialog = {
                 url : "/idm/case/dysentery/le",
                 height : 250,
                 width : 800,
                 title : "检验结果" ,
                 id :"leDialog"
             };
             $.dialog(leDialog);
         });
		 /*职业-其他*/
		 toggleOtherSC('generalCondition.occupation','occupationOtherPart','CV020120299');
		 /*出院时病原携带情况*/
		 toggleOther('attackCondition.carrierFlg','spanGermicultureResult','1');
		 /*发热*/
		 toggleOther('clinicalManifestations.fever','spanFever','1');
		 /*腹泻*/
		 toggleOther('clinicalManifestations.diarrhea','spanDiarrhea','1');
		 /* 既往一年内痢疾史*/
		 toggleOther('epidemiologicalSurvey.dysentery','spanDysentery','1');
		 /*病前一周内可疑饮食史*/
		 toggleDiet('epidemiologicalSurvey.doubtfulDiet','1');
		 /*病前一周内与确诊痢疾病人接触史*/
		 toggleHistory('epidemiologicalSurvey.dysenteryContactHistory','1');
		 toggleOther('clinicalManifestations.stoolProperty','stoolProperty',99);
		 toggleOther('beforeDiseaseDiet.dinnerInfectedFlag','dinnerInfectedFlag','1');
		 toggleOther('epidemicFocusClose.isExcretaDisi','isExcretaDisi','2');
		 toggleOther('beforeDiseaseDiet.drinkingHistory','waterType',1)
		 caseEdit.toggerAddress();
	});

	function popEfc(){
        var contactDialog = {
                url : "/idm/case/dysentery/dycontact",
                height : 250,
                width : 800,
                title : "密切接触者" ,
                id :"contactDialog"
            };
         $.dialog(contactDialog);		
	}
	function saveContact(){
		validate = $("#contact").easyValidate();
		var result=validate.validateForm();
		if(!result){
			return;
		}
		addContact();
	}
	
	function saveDisinfect(){
		validate = $("#disinfect").easyValidate();
		var result=validate.validateForm();
		if(!result){
			return;
		}
		addDisninfect();
	}
	function saveLe(){
		validate = $("#le").easyValidate();
		var result=validate.validateForm();
		if(!result){
			return;
		}
		addLe();
	}
	

	function modifyContact(){
		validate = $("#contact").easyValidate();
		var result=validate.validateForm();
		if(!result){
			return;
		}
		editContact();
	}
	
	function modifyDisinfect(){
		validate = $("#disinfect").easyValidate();
		var result=validate.validateForm();
		if(!result){
			return;
		}
		editDisninfect();
	}
	function modifyLe(){
		validate = $("#le").easyValidate();
		var result=validate.validateForm();
		if(!result){
			return;
		}
		editLe();
	}
	

	/*添加密切接触者*/
	function addContact(){
		var html = fillConData();
	    $("#efcTable").append(html);      
	    caseEdit.closePopUp('contactDialog');
	}
	
	/*修改密切接触者*/
	function editContact(){
		var html = fillConData();
		var rowIndex = $('#rowNum').val();
	    html = html.replace("</tr>", "");
	    html = html.replace('<tr>', "");
	    $("#efcTable tr").eq(rowIndex).html(html);		
	    caseEdit.closePopUp('contactDialog');		
	}
	
	function fillConData(){
		var name=$('#contactsName').val();
		var sex=$('#contactSex').val();
		var sexName=$("#contactSex").find("option:selected").text();
		sexName = sex==''?'':sexName;
		var age=$('#contactAge').val();
		var relation=$('#contactRelation').val();
		var relationName=$("#contactRelation").find("option:selected").text();
		relationName = relation==''?'':relationName;
		//接触方式
		var contactTypeStr = "";
		var contactType = "";
		$("input[name='contactType']:checkbox:checked").each(function(){ 
			contactType += $(this).val() + ","; 
			if($(this).val() == '1'){
				contactTypeStr += "同吃 ";
			}else if($(this).val() == '2'){
				contactTypeStr += "同住 ";
			}else if($(this).val() == '7'){
				contactTypeStr += "陪护 ";
			}else if($(this).val() == '99'){
				contactTypeStr += "其他 ";	
			}
		});

		var attackDt="";
		var attackCondition=$('input[name="contactAttackCondition"]:checked').val();
		var attackConditionName="";
		if(attackCondition == '1'){
			attackDt=$('#contactAttackDt').val();
			attackConditionName = "有";
		}else{
			attackConditionName = "无";
		}
		var unitAddr=$('#contactUnitAddr').val();
		var labExamination=$('#contactLabExamination').val();
	    var html = '<tr>';
        html += '<td field="name" title="'+ name + '">'+name+'</td>';
        html += '<td field="sexStr" title="'+sexName+'">'+sexName +'</td>';
        html += '<td field="sex" style="display:none;" title="'+sex+'">'+sex+'</td>';
        html += '<td field="age" title="'+age+'">'+age+'</td>';
        html += '<td field="relationStr" title="'+ relationName + '">'+relationName+'</td>';
        html += '<td field="relation" style="display:none;" title="'+relation+'">'+relation+'</td>';
        html += '<td field="unitAddr" title="' + unitAddr + '">'+unitAddr+'</td>';
        html += '<td field="contactTypeStr" title="'+ contactTypeStr + '">'+contactTypeStr+'</td>';
        html += '<td field="contactType" style="display:none;" title="'+contactType+'">'+contactType+'</td>';
        html += '<td field="attackStr" title="' + attackConditionName + '">'+attackConditionName +'</td>';
        html += '<td field="attack" style="display:none;">'+attackCondition+'</td>';
        html += '<td field="attackDt" title="'+ attackDt + '">'+attackDt+'</td>';
        html += '<td field="labExamination" title="'+ labExamination + '">'+labExamination+'</td>';
        html += '<td class="btnsublist" field="btn"><a href="javascript:void(0)" onclick="dysenteryCase.editConTr(this)">修改</a>';
        html += ' <a href="javascript:void(0)" onclick="caseEdit.removeTr(this)">删除</a></td>';
        html += '</tr>';
        return html;
	}
	/*添加消毒情况*/
	function addDisninfect(){
		var html = fillDisData();
	    $("#disinfectTable").append(html);        
	    caseEdit.closePopUp('disinfectDialog');
	}
	/*添加消毒情况*/
	function addLe(){
		var html = fillLeData();
	    $("#leTable").append(html);        
	    caseEdit.closePopUp('leDialog');
	}
	
	
	/*修改消毒情况*/
	function editDisninfect(){
		var rowIndex = $('#rowNum').val();
		var html = fillDisData();
	    html = html.replace("</tr>", "");
	    html = html.replace('<tr>', "");
	    $("#disinfectTable tr").eq(rowIndex).html(html);		
	    caseEdit.closePopUp('disinfectDialog');		
	}
	/*修改检验结果*/
	function editLe(){
		var rowIndex = $('#rowNum').val();
		var html = fillLeData();
	    html = html.replace("</tr>", "");
	    html = html.replace('<tr>', "");
	    $("#leTable tr").eq(rowIndex).html(html);		
	    caseEdit.closePopUp('leDialog');		
	}
	function fillDisData(rowIndex){
		var disObjectId=$('#disObject').val();
		var disObjectName=$("#disObject").find("option:selected").text();
		disObjectName = disObjectId==''?'':disObjectName;
		var drugConcentration=$('#disninfectDrugCon').val();
		var sterilizeDrug=$('#disninfectSterDrug').val();
		var drugNum=$('#disninfectDrugNum').val();
		var sterilizeType=$('#disninfectSterType').val();
		var attackDt=$('#disninfectAttackDt').val();
	    var html = '<tr>';
        html += '<td field="objectStr" title="'+disObjectName+'">'+disObjectName + '</td>';
        html +='<td field="object" style="display:none;" title="'+disObjectId+'">'+disObjectId+'</td>';
        html += '<td field="sterilizeDrug" title="' + sterilizeDrug + '">'+sterilizeDrug + '</td>';
        html += '<td field="drugConcentration" title="'+ drugConcentration + '">'+drugConcentration+'</td>';
        html += '<td field="drugNum" title="' + drugNum + '">'+drugNum +'</td>';
        html += '<td field="attackDt" title="'+ attackDt + '">'+attackDt+'</td>';
        html += '<td field="sterilizeType" title="' + sterilizeType + '">'+sterilizeType+'</td>';
        html += '<td class="btnsublist" field="btn"><a href="javascript:void(0)" onclick="dysenteryCase.editDisTr(this)">修改</a>';
        html +=' <a href="javascript:void(0)" onclick="caseEdit.removeTr(this)">删除</a></td>';
        html += '</tr>';
        return html;
	}
	function fillLeData(rowIndex){

		var sonnei=$('#sonnei').val();
		var redBloodCell=$('#redBloodCell').val();
		var whiteBloodCell=$('#whiteBloodCell').val();
		var shigella=$('#shigella').val();
		var freund=$('#freund').val();
		var powell=$('#powell').val();
		var leDt=$('#leDt').val();
	    var html = '<tr>';
        html += '<td field="leDt" title="'+leDt+'">'+leDt + '</td>';
        html += '<td field="redBloodCell" title="' + redBloodCell + '">'+redBloodCell + '</td>';
        html += '<td field="whiteBloodCell" title="'+ whiteBloodCell + '">'+whiteBloodCell+'</td>';
        html += '<td field="shigella" title="' + shigella + '">'+shigella +'</td>';
        html += '<td field="freund" title="'+ freund + '">'+freund+'</td>';
        html += '<td field="powell" title="'+ powell + '">'+powell+'</td>';
        html += '<td field="sonnei" title="' + sonnei + '">'+sonnei+'</td>';
        html += '<td class="btnsublist" field="btn"><a href="javascript:void(0)" onclick="dysenteryCase.editLeTr(this)">修改</a>';
        html +=' <a href="javascript:void(0)" onclick="caseEdit.removeTr(this)">删除</a></td>';
        html += '</tr>';
        return html;
	}
	function editDisTr(editLink){
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
        disinfectDialog = {
                url : "/idm/case/dysentery/disinfect",
                height : 250,
                width : 800,
                title : "消毒情况" ,
                id :"disinfectDialog",
                param:{trData:trDataStr,type:'edit',rowNum:rowNum}                
            };
        $.dialog(disinfectDialog);
		
	}
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
                url : "/idm/case/dysentery/dycontact",
                height : 250,
                width : 800,
                title : "患者接触史" ,
                id :"contactDialog",
                param:{trData:trDataStr,type:'edit',rowNum:rowNum}                
            };
        $.dialog(contactDialog);
		
	}
	function editLeTr(editLink){
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
		leDialog = {
                url : "/idm/case/dysentery/le",
                height : 250,
                width : 800,
                title : "检验结果" ,
                id :"leDialog",
                param:{trData:trDataStr,type:'edit',rowNum:rowNum}                
            };
        $.dialog(leDialog);
		
	}
	/*隐藏、显示病前一周内可疑饮食史*/
	function toggleDiet(radioName,code){
		toggleOther(radioName,'trDiet1',code);
		toggleOther(radioName,'trDiet2',code);
	}
	/*隐藏、显示病前一周内与确诊痢疾病人接触史*/
	function toggleHistory(radioName,code){
		toggleOther(radioName,'trHistory1',code);
		toggleOther(radioName,'trHistory2',code);
		toggleOther(radioName,'trHistory3',code);
	}
	return {
		saveContact : saveContact,
		saveDisinfect:saveDisinfect,
		saveLe:saveLe,
		modifyContact:modifyContact,
		modifyDisinfect:modifyDisinfect,
		modifyLe:modifyLe,
		editDisTr:editDisTr,
		editConTr:editConTr,
		editLeTr:editLeTr,
		toggleDiet:toggleDiet,
		toggleHistory:toggleHistory,
		popEfc:popEfc
	};
})();

