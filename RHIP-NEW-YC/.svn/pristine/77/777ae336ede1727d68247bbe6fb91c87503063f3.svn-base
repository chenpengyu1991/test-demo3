var sarsCase=(function(){
	var validate=null;
	$(function() {
        $.Placeholder.init({query:"#idCard",callback:function(element){
            idCard.queryPerson($(element).val());
        }});
		$("#addAc").click(function() {
            var acDialog = {
                url : "/idm/case/sars/ac",
                height : 200,
                width : 800,
                title : "发病情况" ,
                id :"acDialog"
            };
            $.dialog(acDialog);
        });	
		$("#addEsActivity").click(function() {
            var activityDialog = {
                url : "/idm/case/sars/activity",
                height : 200,
                width : 800,
                title : "发病前一周内逐日活动情况" ,
                id :"activityDialog"
            };
            $.dialog(activityDialog);
        });	
		$("#addEsAnimal").click(function() {
            var animalDialog = {
                url : "/idm/case/sars/animal",
                height : 200,
                width : 800,
                title : "发病前两周内接触动物" ,
                id :"animalDialog"
            };
            $.dialog(animalDialog);
        });	
		$("#addEsLeave").click(function() {
            var leaveDialog = {
                url : "/idm/case/sars/leave",
                height : 200,
                width : 800,
                title : "发病后至隔离治疗前逐日活动情况" ,
                id :"leaveDialog"
            };
            $.dialog(leaveDialog);
        });  
		$("#addContacts").click(function() {
            var contactDialog = {
                url : "/idm/case/sars/contact",
                height : 250,
                width : 750,
                title : "发病前2周内是否接触过非典病人/疑似非典患者" ,
                id :"contactDialog"
            };
            $.dialog(contactDialog);
        });
 
		 /*隐藏、显示职业-其他*/
		 toggleOther('generalCondition.occupation','occupationOtherPart','CV020120299');
		 /*隐藏、显示职业*/
		 toggleOccupation();
		 /*隐藏、显示入院诊断*/		 
		 toggleOther('attackCondition.inhosDiagnosis','inhosDiagnosisOtherId','99');
		 /*隐藏、显示发热*/	
		 toggleOther('clinicalManifestations.fever','divFever','1');
		 /*隐藏、显示咳嗽*/	
		 toggleOther('clinicalManifestations.cough','divCough','1');
		 /*隐藏、显示胸部Ｘ线检查:初诊*/	
		 toggleOther('labExamine.chestXrayFirstResult','chestXrayFirstOtherId','99');
		 /*隐藏、显示胸部Ｘ线检查：入院*/	
		 toggleOther('labExamine.chestXrayAdmissionResult','chestXrayAdmissionOtherId','99');
		 /*隐藏、显示发病前2周内是否接触过非典病人*/	
		 toggleOther('epidemiologicalSurvey.sarsPatient','trSarsPatientId','1');
		 /*隐藏、显示发病前两周内接触动物（罕见动物、禽类）情况*/	
		 toggleOther('epidemiologicalSurvey.sarsAnimal','trSarsAnimal','1');
		 /*隐藏、显示最后诊断*/
		 toggleLastDia();
		 /*隐藏、显示转归*/
		 toggleOutCome();
		 caseEdit.toggerAddress();
		 $("#hrvillage_address").change(displayValue);

	});
	
	function popFamily(){
	    var familyDialog = {
	            url : "/idm/case/sars/family",
	            height : 250,
	            width : 750,
	            title : "发病后至住院前密切接触者:家庭、亲友",
	            id :"familyDialog"
	        };
	    $.dialog(familyDialog);		
	}
	
	function popWorkOrg(){
        var workOrgDialog = {
                url : "/idm/case/sars/workOrg",
                height : 250,
                width : 750,
                title : "发病后至住院前密切接触者:工作单位或主要活动场所联系人",
                id :"workOrgDialog"
            };
            $.dialog(workOrgDialog);		
	}
	/*根据村选择，生成默认户籍详细地址*/
	function displayValue() {
		var town = $("#hrtown_address option:selected").text();
		var village = $("#hrvillage_address option:selected").text();
		var result = '';
		if (town != '请选择')
			result = town;
		if (village != '请选择')
			result = result + village;
		$("#hrhouseNumber").val(result);
	}
	/*隐藏、显示职业*/
	function toggleOccupation(){
//		debugger;
		var arrOccupation1 = ["CV020120220","CV020120221","CV020120222","9-31","CV020120223","CV020120299"];
		var arrOccupation2 = ["CV020120201","CV020120202","CV020120203","CV020120204","CV020120205","CV020120206","CV020120207","CV020120209","CV020120210","CV020120211","CV020120212","CV020120213","CV020120214","CV020120215","CV020120216","CV020120299"];
		var value=$('input[name="generalCondition.occupationFlag"]:checked').val();
		var oc1Select = ('1' == value);
		var oc2Select = ('2' == value);
		$('input[name="generalCondition.occupation"]').each(function(){
			if(oc1Select){
				if ($.inArray($(this).val(), arrOccupation1) != -1){
					$(this).removeAttr("disabled");
					$(this).show();
					$(this).nextAll('label').eq(0).show();
				}else{
					$(this).attr("disabled","disabled");
					$(this).nextAll('label').eq(0).hide();
					$(this).hide();
				}
			}
			if(oc2Select){
				if ($.inArray($(this).val(), arrOccupation2) != -1){
					$(this).removeAttr("disabled");
					$(this).show();
					$(this).nextAll('label').eq(0).show();
				}else{
					$(this).attr("disabled","disabled");
					$(this).hide();
					$(this).nextAll('label').eq(0).hide();;
				}
			}			
		});
        
	}

	/*隐藏、显示户籍地址*/
	function toggerHrAddress(){
		var value=$('input[name="generalCondition.floatPopulation"]:checked').val();

		if('1' == value){
			$("#hrvillage_address").removeAttr("disabled");
			$("#hrtown_address").removeAttr("disabled");
		}else{
			$("#hrvillage_address").attr("disabled", "disabled");
			$("#hrtown_address").attr("disabled", "disabled");
		}
		toggleOther('generalCondition.floatPopulation','hrvillage_address','1');
		toggleOther('generalCondition.floatPopulation','hrtown_address','1');
	}
	/*隐藏、显示最后诊断*/
	function toggleLastDia(){
		toggleOther('diagnosis.lastDiagnosis','spanLastDiagnosis','5');
		toggleOther('diagnosis.lastDiagnosis','trLastDiagnosis','5');
	}
	/*隐藏、显示转归*/
	function toggleOutCome(){
		toggleOther('otherCondition.outcomeCode','divOutCome','4');
		toggleOther('otherCondition.outcomeCode','trOutCome','4');
	}
	/*新增时，保存*/
	function save(type){
		var listName = getListName(type);
		validate = $("#" + listName + "Form" ).easyValidate();
		var result=validate.validateForm();
		if(!result){
			return;
		}
		var html = fillData(type);
	    $("#" + listName + "Table").append(html);      
	    caseEdit.closePopUp(listName + 'Dialog');
	}
	/*修改时弹出*/
	function editTr(editLink,type){
//		debugger;
		var listName = getListName(type);
		var listStr = getListStr(type);
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
		listDialog = {
                url : "/idm/case/sars/" + listName,
                height :250,
                width : 800,
                title : listStr,
                id :listName + "Dialog",
                param:{trData:trDataStr,type:'edit',rowNum:rowNum}                
            };
        $.dialog(listDialog);
	}
	/*修改后，保存*/
	function modify(type){
//		debugger;
		var listName = getListName(type);
		validate = $("#" + listName + "Form").easyValidate();
		var result=validate.validateForm();
		if(!result){
			return;
		}
		var rowIndex = $('#rowNum').val();
		var html = fillData(type);
	    html = html.replace("</tr>", "");
	    html = html.replace('<tr>', "");
	    $("#" + listName + "Table tr").eq(rowIndex).html(html);	
	    caseEdit.closePopUp(listName + 'Dialog');	
	}	

	
	function getListName(type){
		var result ="";
		if(type == 1){
			result = "activity";
		}else if(type == 2){
			result= "animal";
		}else if(type == 3){
			result = "leave";
		}else if(type == 4){
			result = "ac";
		}else if(type == 5){
			result = "contact";
		}else if(type == 6){
			result = "family";
		}else if(type == 7){
			result = "workOrg";
		}
		return result;
	}

	function getListStr(type){
		var result ="";
		if(type == 1){
			result = "发病前一周内逐日活动情况";
		}else if(type == 2){
			result= "发病前两周内接触动物";
		}else if(type == 3){
			result = "发病后至隔离治疗前逐日活动情况";
		}else if(type == 4){
			result = "就诊情况";
		}else if(type == 5){
			result = "发病前2周内是否接触过非典病人/疑似非典患者";
		}else if(type == 6){
			result = "发病后至住院前密切接触者:家庭、亲友";
		}else if(type == 7){
			result = "发病后至住院前密切接触者:工作单位或主要活动场所联系人";
		}
		return result;
	}
	
	function fillData(type){
		var html ="";
		if(type == 1){
			html = fillActData();
		}else if(type == 2){
			html= fillAnimalData();
		}else if(type == 3){
			html = fillLeaveData();
		}else if (type == 4){
			html = fillAcData();
		}else if (type == 5){
			html = fillContactData();
		}else if (type == 6){
			html = fillFamilyData();
		}else if (type == 7){
			html = fillWorkOrgData();
		}	
		return html;
	}
	function fillAcData(){
		var treatmentDt=$('#treatmentDt').val();
		var treatmentDepartments=$('#treatmentDepartments').val();
		var diagnosisName=$('#diagnosisName').val();
		var medicalWorkers=$('#medicalWorkers').val();
	    var html = '<tr>';
        html += '<td field="treatmentDt" title="'+ treatmentDt + '">'+treatmentDt+'</td>';
        html += '<td field="treatmentDepartments" title="'+ treatmentDepartments + '" >'+treatmentDepartments +'</td>';
        html += '<td field="diagnosisName" title="' + diagnosisName + '">'+diagnosisName+'</td>';
        html += '<td field="medicalWorkers" title="' + medicalWorkers +'">'+medicalWorkers+'</td>';        
        html += '<td class="btnsublist" field="btn"><a href="javascript:void(0)" onclick="sarsCase.editTr(this,4)">修改</a>';
        html += ' <a href="javascript:void(0)" onclick="caseEdit.removeTr(this)">删除</a></td>';
        html += '</tr>';
        return html;
	}
	function fillActData(){
		var activityDt=$('#activityDt').val();
		var activityContent=$('#activityContent').val();
		var activityAddr=$('#activityAddr').val();
		var contactName=$('#contactName').val();
	    var html = '<tr>';
	    html += '<td field="flag" style="display:none;">1</td>';
        html += '<td field="activityDt" title="'+ activityDt + '">'+activityDt+'</td>';
        html += '<td field="activityContent" title="'+ activityContent + '" >'+activityContent +'</td>';
        html += '<td field="activityAddr" title="' + activityAddr + '">'+activityAddr+'</td>';
        html += '<td field="contactName" title="' + contactName +'">'+contactName+'</td>';        
        html += '<td class="btnsublist" field="btn"><a href="javascript:void(0)" onclick="sarsCase.editTr(this,1)">修改</a>';
        html += ' <a href="javascript:void(0)" onclick="caseEdit.removeTr(this)">删除</a></td>';
        html += '</tr>';
        return html;
	}	
	
	function fillAnimalData(){
		var sell="";
		var slaughter="";
		var cook="";
		var eat="";
		var contactAnimalSell ="";
		var contactBeginDt=$('#contactBeginDt').val();
		var contactAnimalAddr=$('#contactAnimalAddr').val();
		var contactAnimalName=$('#contactAnimalName').val();
		var contactAnimalOther = "";

		$("input[name='contactAnimalSell']:checkbox:checked").each(function(){ 
			contactAnimalSell += $(this).val() + ","; 
			if($(this).val() == '1'){
				sell = "√";
			}else if($(this).val() == '2'){
				slaughter = "√";
			}else if($(this).val() == '3'){
				cook = "√";
			}else if($(this).val() == '4'){
				eat = "√";
			}else if($(this).val() == '99'){
				contactAnimalOther = $.trim($('#contactAnimalOther').val());
			}
		}); 
	    var html = '<tr>';
	    html += '<td field="flag" style="display:none;">2</td>';
        html += '<td field="contactBeginDt" title="'+ contactBeginDt + '">'+contactBeginDt+'</td>';
        html += '<td field="contactAnimalAddr" title="'+ contactAnimalAddr + '" >'+contactAnimalAddr +'</td>';
        html += '<td field="contactAnimalName" title="' + contactAnimalName + '">'+contactAnimalName+'</td>';
        html += '<td field="contactAnimalSell" style="display:none;">' + contactAnimalSell + '</td>';
        html += '<td field="contactAnimal" style="text-align:center;" title="'+sell+'">'+sell+'</td>';
        html += '<td field="contactAnimal" style="text-align:center;" title="'+slaughter+'">'+slaughter+'</td>';
        html += '<td field="contactAnimal" style="text-align:center;" title="'+cook+'">'+cook+'</td>';
        html += '<td field="contactAnimal" style="text-align:center;" title="'+eat+'">'+eat+'</td>';
        html += '<td field="contactAnimalOther" title="'+ contactAnimalOther + '">'+contactAnimalOther+'</td>'; 
        html += '<td class="btnsublist" field="btn"><a href="javascript:void(0)" onclick="sarsCase.editTr(this,2)">修改</a>';
        html += ' <a href="javascript:void(0)" onclick="caseEdit.removeTr(this)">删除</a></td>';
        html += '</tr>';
        return html;
	}

	function fillLeaveData(){
		var activityDt=$('#activityDt').val();
		var activityContent=$('#activityContent').val();
		var activityAddr=$('#activityAddr').val();
		var contactName=$('#contactName').val();
	    var html = '<tr>';
	    html += '<td field="flag" style="display:none;">3</td>';
        html += '<td field="activityDt" title="'+ activityDt + '">'+activityDt+'</td>';
        html += '<td field="activityContent" title="'+ activityContent + '" >'+activityContent +'</td>';
        html += '<td field="activityAddr" title="' + activityAddr + '">'+activityAddr+'</td>';
        html += '<td field="contactName" title="'+ contactName + '">'+contactName+'</td>'; 
        html += '<td class="btnsublist" field="btn"><a href="javascript:void(0)" onclick="sarsCase.editTr(this,3)">修改</a>';
        html += ' <a href="javascript:void(0)" onclick="caseEdit.removeTr(this)">删除</a></td>';
        html += '</tr>';
        return html;
	}
	function fillContactData(){
		var name=$('#name').val();
		var attackDt=$('#attackDt').val();
		var clinicalDiagnosis=$('#clinicalDiagnosis').val();
		var relation=$('#relation').val();
		var relationName=$("#relation").find("option:selected").text();
		relationName = relation==''?'':relationName;
		var condactDtLast=$('#condactDtLast').val();
		var contactType=$('#contactType').val();
		var contactTypeName=$("#contactType").find("option:selected").text();
		contactTypeName = contactType==''?'':contactTypeName;
		var contactRate=$('#contactRate').val();
		var contactRateName=$("#contactRate").find("option:selected").text();
		contactRateName = contactRate==''?'':contactRateName;
		var contactAddr=$('#contactAddr').val();
		var contactAddrName=$("#contactAddr").find("option:selected").text();
		contactAddrName = contactAddr==''?'':contactAddrName;
	    var html = '<tr>';
	    html += '<td field="flag" style="display:none;">5</td>';
	    html += '<td field="name" title="'+ name + '">'+name+'</td>';
        html += '<td field="attackDt" title="'+ attackDt + '">'+attackDt+'</td>';
        html += '<td field="clinicalDiagnosis" title="'+ clinicalDiagnosis + '" >'+clinicalDiagnosis +'</td>';
        html += '<td field="relationStr" title="'+ relationName + '">'+relationName+'</td>';
        html += '<td field="relation" style="display:none;">'+relation+'</td>'; 
        html += '<td field="condactDtLast" title="'+ condactDtLast + '">'+condactDtLast+'</td>';
        html += '<td field="contactType" style="display:none;">'+contactType+'</td>';         
        html += '<td field="contactTypeStr" title="'+ contactTypeName + '">'+contactTypeName+'</td>'; 
        html += '<td field="contactRate" style="display:none;">'+contactRate+'</td>';         
        html += '<td field="contactRateStr" title="'+ contactRateName + '">'+contactRateName+'</td>'; 
        html += '<td field="contactAddr" style="display:none;">'+contactAddr+'</td>';         
        html += '<td field="contactAddrStr" title="'+ contactAddrName + '">'+contactAddrName+'</td>';         
        html += '<td class="btnsublist" field="btn"><a href="javascript:void(0)" onclick="sarsCase.editTr(this,5)">修改</a>';
        html += ' <a href="javascript:void(0)" onclick="caseEdit.removeTr(this)">删除</a></td>';
        html += '</tr>';
        return html;
	}	
	function fillFamilyData(){
		var name=$('#familyName').val();
		var sex=$('input[name="sex"]:checked').val();
		var sexName=$('input[name="sex"]:checked').data("label");
		var age=$('#familyAge').val();
		var relation=$('#familyRelation').val();
		var contactType=$("#familyContactType").val();
		var unitAddr=$('#familyUnitAddr').val();
		var tel=$('#familyTel').val();
	    var html = '<tr>';
	    html += '<td field="flag" style="display:none;">6</td>';
	    html += '<td field="name" title="'+ name + '">'+name+'</td>';
        html += '<td field="sexStr" title="'+ sexName + '">'+sexName+'</td>';
        html += '<td field="sex" style="display:none;">'+sex+'</td>'; 	    
        html += '<td field="age" title="'+ age + '">'+age+'</td>';
        html += '<td field="relation" title="'+ relation + '" >'+relation +'</td>';
        html += '<td field="contactType" title="'+ contactType + '">'+contactType+'</td>';
        html += '<td field="unitAddr" title="'+ unitAddr + '">'+unitAddr+'</td>'; 
        html += '<td field="tel" title="'+ tel + '">'+tel+'</td>'; 
        html += '<td class="btnsublist" field="btn"><a href="javascript:void(0)" onclick="sarsCase.editTr(this,6)">修改</a>';
        html += ' <a href="javascript:void(0)" onclick="caseEdit.removeTr(this)">删除</a></td>';
        html += '</tr>';
        return html;
	}
	function fillWorkOrgData(){
		var unitAddr=$('#workOrgUnitAddr').val();
		var linkman=$('#workOrgLinkman').val();
		var tel=$('#workOrgTel').val();
		var contactName=$("#workOrgContactName").val();
	    var html = '<tr>';
	    html += '<td field="flag" style="display:none;">7</td>';
	    html += '<td field="unitAddr" title="'+ unitAddr + '">'+unitAddr+'</td>';
        html += '<td field="tel" title="'+ tel + '">'+tel+'</td>';	    
        html += '<td field="linkman" title="'+ linkman + '">'+linkman+'</td>';
        html += '<td field="contactName" title="'+ contactName + '" >'+contactName +'</td>';
        html += '<td class="btnsublist" field="btn"><a href="javascript:void(0)" onclick="sarsCase.editTr(this,7)">修改</a>';
        html += ' <a href="javascript:void(0)" onclick="caseEdit.removeTr(this)">删除</a></td>';
        html += '</tr>';
        return html;
	}	
	return{
		toggleOccupation:toggleOccupation,
		toggerHrAddress:toggerHrAddress,
		toggleLastDia:toggleLastDia,
		toggleOutCome:toggleOutCome,
		save:save,
		editTr:editTr,
		modify:modify,
		popFamily:popFamily,
		popWorkOrg:popWorkOrg
		};
})();