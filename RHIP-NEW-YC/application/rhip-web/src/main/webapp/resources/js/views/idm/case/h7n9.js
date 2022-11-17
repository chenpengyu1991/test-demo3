
var hnCase = (function() {
	$(function() {

		toggleOther('pastHistory.lungs','lungsCkDiv',1);
		toggleOtherCK('pastHistory.lungsCk','lungsCkOtherDiv',9);
		toggleOther('pastHistory.cardiovascular','cardiovascularCkDiv',1);
		toggleOtherCK('pastHistory.cardiovascularCk','cardiovascularCkOtherDiv',8);
		toggleOther('pastHistory.metabolize','metabolizeCkDiv',1);
		toggleOtherCK('pastHistory.metabolizeCk','metabolizeCkOtherDiv',99);
		toggleOther('pastHistory.nephropathy','nephropathyCkDiv',1);
		toggleOtherCK('pastHistory.nephropathyCk','nephropathyCkOtherDiv',5); 
		toggleOther('pastHistory.nephropathyCk','medicationHistoryDiv',1);
		toggleOther('pastHistory.liver','liverCkDiv',1);
		toggleOtherCK('pastHistory.liverCk','liverCkOtherDiv',4);
		toggleOther('pastHistory.rheumatism','rheumatismCkDiv',1);
		toggleOtherCK('pastHistory.rheumatismCk','rheumatismCkOtherDiv',5);
		toggleOther('pastHistory.blood','bloodCkDiv',1);
		toggleOtherCK('pastHistory.bloodCk','bloodCkOtherDiv',3);
		toggleOther('pastHistory.cancer','cancerCkDiv',1);
		toggleOther('pastHistory.hiv','hivCkDiv',1);
		toggleOther('pastHistory.nerve','nerveCkDiv',1);
		toggleOtherCK('pastHistory.nerveCk','nerveCkOtherDiv',5);
		toggleOther('pastHistory.pregnant','pregnantWeekDiv',1);
		toggleOther('pastHistory.smoke','smokeDayDiv',1);
		toggleOther('pastHistory.smoke','smokeAllTimeDiv',2);
		toggleOther('pastHistory.smokeQuit','influenzaVaccineDiv',1);
		toggleOther('pastHistory.alcohol','alcoholDayDiv',1);
		toggleOther('pastHistory.alcohol','alcoholAllTimeDiv',2);
		toggleOther('pastHistory.alcoholQuit','alcoholQuitYearDiv',1);
		toggleOther('exposureHistory.birdOccupation','birdSpeciesOcDiv',1);
		toggleOtherCK('exposureHistory.birdSpeciesOc','birdSpeciesOtherOcDiv',6);
		toggleOtherCK('exposureHistory.contactWayOc','contactWayOtherOcDiv',8);
		toggleOther('exposureHistory.contactBi','contactHealthBiDiv',1);
		toggleOther('exposureHistory.contactHealthBi','contactFreHealthBiDiv',1);
		toggleOther('exposureHistory.contactFreHealthBi','contactDayHealthBiDiv',1);
		toggleOther('exposureHistory.contactDayHealthBi','birdSpeciesHealthBiDiv',1);
		toggleOnes('exposureHistory.protectHealthBi','protectWayHealthBiDiv','1,2');
		toggleOtherCK('exposureHistory.protectWayHealthBi','contactWayOtherHealthBiDiv',7);
		toggleOther('exposureHistory.contactDeathBi','contactFreDeathBiDiv',1);
		toggleOther('exposureHistory.contactFreDeathBi','contactDayDeathBiDiv',1);
		toggleOther('exposureHistory.contactDayDeathBi','birdSpeciesDeathBiDiv',1);
		toggleOtherCK('exposureHistory.protectWayDeathBi','protectWayOtherDeathBiDiv',7);
		toggleOther('exposureHistory.toBreedEn','contactFreBreedEnDiv',1);
		toggleOther('exposureHistory.contactFreBreedEn','contactDayBreedEnDiv',1);
		toggleOther('exposureHistory.contactDayBreedEn','birdSpeciesBreedEnDiv',1);
		toggleOther('exposureHistory.toMarketEn','contactFreMarketEnDiv',1);
		toggleOther('exposureHistory.contactFreMarketEn','contactDayMarketEnDiv',1);
		toggleOther('exposureHistory.contactDayMarketEn','passagewayMarketEnDiv',1);
		toggleOther('exposureHistory.contactCa','contactFreCaDiv',1);
		toggleOther('exposureHistory.contactFreCa','contactDayCaDiv',1);
		toggleOther('exposureHistory.contactDayCa','contactWayCaDiv',1);
		toggleOther('exposureHistory.protectCa','protectWayCaDiv',1);
		toggleOther('exposureHistory.contactFe','contactFreFeDiv',1);
		toggleOther('exposureHistory.contactFreFe','contactDayFeDiv',1);
		toggleOther('exposureHistory.contactDayFe','contactWayFeDiv',1);
		toggleOther('exposureHistory.protectFe','protectWayFeDiv',1);
		toggleOther('otherCondition.travel','addressDiv',1);
        toggleOnes('exposureHistory.protectDeathBi','protectWayDeathBiDiv','1,2');
        
        toggleOther('exposureHistory.contactDayHealthBi','tableFirstIndexesDiv',2);
        toggleOther('exposureHistory.contactDayDeathBi','tableFirstIndexesDiv2',2);
        
        toggleOtherCK('exposureHistory.birdSpecies','birdSpeciesOtherDiv',6);
        toggleOtherCK('protectWay','protectWayOtherDiv',7);
        toggleOtherCK('contactWay','contactWayOtherDiv',13);
        toggleOtherCK('exposureHistory.contactWayCa','diagnosisCaDiv',6);
        toggleOtherCK('exposureHistory.contactWayFe','diagnosisFeDiv',6);

        caseEdit.toggerAddress();
	});

	function popEh(tableNo){
        var contactPatientDialog = {
                url : "/idm/case/h7n9/exposure",
                param : {
                	tableNo : tableNo
                },
                height : 350,
                width : 800,
                title : "暴露信息" ,
                id :"eh"+tableNo+"Dialog"
            };
        $.dialog(contactPatientDialog);		
	}
	
    function addEhList(tableNo){
        validate = $("#add"+tableNo+"Form").easyValidate();
        var result=validate.validateForm();
        if(!result){
            return;
        }

        var html = fillEhRowData(tableNo);
        $("#eh"+tableNo+"Table").append(html);
        caseEdit.closePopUp('eh'+tableNo +'Dialog');
    }

    function editEhList(tableNo){
        validate = $("#addEh" +tableNo+"Form").easyValidate();
        var result=validate.validateForm();
        if(!result){
            return;
        }
        var rowIndex = $('#rowIndex').val();
        var html = fillEhRowData(tableNo);
        html = html.replace("</tr>", "");
        html = html.replace("<tr>", "");
        $("#eh"+ tableNo + "Table"  +" tr").eq(rowIndex).html(html);
        caseEdit.closePopUp('eh'+tableNo+'Dialog');
    }

    function editTr(editBtn, part, tableNo){
        var url = '/idm/case';
        var id = ''
    
        url = url + '/h7n9/exposure';
        id = 'eh'+tableNo + 'Dialog';
       
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
                    trData['exposureBeginDt'] = inputValue.substr(0,10);
                }
                if(inputValue.length >14 ){
                    trData['exposureEndDt'] = inputValue.substr(11,21);
                }
            }
        });
        var trDataStr =  "[" + util.Obj2str(trData) + "]";
        var efcDialog = {
//        url : "/idm/case/hfmd/contacted",
            url : url,
            height : 250,
            width : 800,
            title : "暴露信息",
            id :id,
            param:{trData:trDataStr, rowIndex:rowIndex, type:'edit', tableNo:tableNo}
        };
        $.dialog(efcDialog);
    }

    function getPatientValue(patientObj, tableId){
    
		//日期
    	var attackDt=$('#attackDt').val();
		patientObj['attackDt'] = attackDt;		
	
		//接触禽的状态
		var birdState=$('#birdState').val();
		if(birdState == '1'){
            patientObj.birdStateStr = '外表健康的禽类';
        }else if(patientObj.birdState == '2'){
            patientObj.birdStateStr = '病、死禽';
        }else{
            patientObj.birdStateStr = '';
        }
		patientObj['birdState'] = birdState;

		//接触禽的种类
		var birdSpeciesStr = "";
		var birdSpecies = "";
		var birdSpeciesOther = "";
		$("input[name='birdSpecies']:checkbox:checked").each(function(){ 
			birdSpecies += $(this).val() + ","; 
			if($(this).val() == '1'){
				birdSpeciesStr += "鸡 ";
			}else if($(this).val() == '2'){
				birdSpeciesStr += "鸭 ";
			}else if($(this).val() == '3'){
				birdSpeciesStr += "鹅 ";
			}else if($(this).val() == '4'){
				birdSpeciesStr +=  "鸽子 ";
			}else if($(this).val() == '5'){
				birdSpeciesStr += "野禽 ";
			}else if($(this).val() == '6'){
				birdSpeciesStr +=  $.trim($('#birdSpeciesOther').val());
				birdSpeciesOther =  $.trim($('#birdSpeciesOther').val());
			}
		});
		patientObj['birdSpeciesStr'] = birdSpeciesStr;
		patientObj['birdSpecies'] = birdSpecies;
		patientObj['birdSpeciesOther'] = birdSpeciesOther;
		//接触方式
		var contactWayStr = "";
		var contactWay = "";
		$("input[name='contactWay']:checkbox:checked").each(function(){ 
			contactWay += $(this).val() + ","; 
			if($(this).val() == '1'){
				contactWayStr += "饲养 ";
			}else if($(this).val() == '2'){
				contactWayStr += "触摸、投食 ";
			}else if($(this).val() == '3'){
				contactWayStr += "清洁圈舍 ";
			}else if($(this).val() == '4'){
				contactWayStr +=  "运输 ";
			}else if($(this).val() == '5'){
				contactWayStr += "销售活禽 ";
			}else if($(this).val() == '6'){
				contactWayStr += "购买活禽 ";
			}else if($(this).val() == '7'){
				contactWayStr += "宰杀 ";
			}else if($(this).val() == '8'){
				contactWayStr +=  "捕杀 ";
			}else if($(this).val() == '9'){
				contactWayStr += "清理活禽摊档 ";
			}else if($(this).val() == '10'){
				contactWayStr += "销售生鲜禽肉 ";
			}else if($(this).val() == '11'){
				contactWayStr += "洗切生鲜禽肉 ";
			}else if($(this).val() == '12'){
				contactWayStr +=  "未熟透食用  ";
			}else if($(this).val() == '13'){
				contactWayStr +=  $.trim($('#contactWayOther').val());
				patientObj['contactWayOther'] =  $.trim($('#contactWayOther').val());
			}
		});
		
		patientObj['contactWayStr'] = contactWayStr;
		patientObj['contactWay'] = contactWay;
		
		
		//手部受伤情况
		var handStateStr = "";
		var handState = "";
		$("input[name='handState']:checkbox:checked").each(function(){ 
			handState += $(this).val() + ","; 
			if($(this).val() == '1'){
				handStateStr += "无伤口 ";
			}else if($(this).val() == '2'){
				handStateStr += "未愈合旧伤口 ";
			}else if($(this).val() == '3'){
				handStateStr += "接触过程造成新伤口 ";
			}
		});
		patientObj['handStateStr'] = handStateStr;
		patientObj['handState'] = handState;
		
		
		//接触禽类时采取防护措施
		var protectWayStr = "";
		var protectWay = "";
		$("input[name='protectWay']:checkbox:checked").each(function(){ 
			protectWay += $(this).val() + ","; 
			if($(this).val() == '1'){
				protectWayStr += "戴口罩 ";
			}else if($(this).val() == '2'){
				protectWayStr += "戴手套 ";
			}else if($(this).val() == '3'){
				protectWayStr += "戴面罩 ";
			}else if($(this).val() == '4'){
				protectWayStr += "穿防护服 ";
			}else if($(this).val() == '5'){
				protectWayStr += "护目镜 ";
			}else if($(this).val() == '6'){
				protectWayStr += "接触后立即洗手 ";
			}else if($(this).val() == '8'){
				protectWayStr += "帽子 ";
			}else if($(this).val() == '9'){
				protectWayStr += "大褂 ";
			}else if($(this).val() == '7'){
				protectWayStr += $.trim($('#protectWayOther').val()) +"&nbsp;";
				patientObj['protectWayOther'] = $.trim($('#protectWayOther').val());
			}
		});
		patientObj['protectWayStr'] = protectWayStr;
		patientObj['protectWay'] = protectWay;
		
		//访问时此场所有无禽类病死现象
		var birdDeath=$("input[name='birdDeath']:radio:checked").val();
		if(birdDeath == '1'){
            patientObj.birdDeathStr = '是';
        }else if(birdDeath == '2'){
            patientObj.birdDeathStr = '否';
        }else if(birdDeath == '4'){
            patientObj.birdDeathStr = '不详';
        }else{
            patientObj.birdDeathStr = '';
        }
		patientObj['birdDeath'] = birdDeath;
		//是否到过养殖场所中饲养禽类的房间或车间
		var workshop=$("input[name='workshop']:radio:checked").val();
		if(workshop == '1'){
            patientObj.workshopStr = '是';
        }else if(workshop == 2){
            patientObj.workshopStr = '否';
        }else if(workshop == '4'){
            patientObj.workshopStr = '不详';
        }else{
            patientObj.workshopStr = '';
        }
		patientObj['workshop'] = workshop;
		//是否直接接触过养殖场所内的禽类
		var contactBird=$("input[name='contactBird']:radio:checked").val();
		if(contactBird == '1'){
            patientObj.contactBirdStr = '是';
        }else if(contactBird == '2'){
            patientObj.contactBirdStr = '否';
        }else if(contactBird == '4'){
            patientObj.contactBirdStr = '不详';
        }else{
            patientObj.contactBirdStr = '';
        }
		patientObj['contactBird'] = contactBird;
		
		//表3 是否到过活禽摊位 
		var toMarket=$("input[name='toMarket']:radio:checked").val();
		if(toMarket == '1'){
            patientObj.toMarketStr = '是';
        }else if(toMarket == '2'){
            patientObj.toMarketStr = '否';
        }else if(toMarket == '4'){
            patientObj.toMarketStr = '不详';
        }else{
            patientObj.toMarketStr = '';
        }
		patientObj['toMarket'] = toMarket;
		//表3 
		var passageway=$("input[name='passageway']:radio:checked").val();
		if(passageway == '1'){
            patientObj.passagewayStr = '是';
        }else if(passageway == '2'){
            patientObj.passagewayStr = '否';
        }else if(passageway == '4'){
            patientObj.passagewayStr = '不详';
        }else{
            patientObj.passagewayStr = '';
        }
		patientObj['passageway'] = passageway;
		//表3 
		var nearMarket=$("input[name='nearMarket']:radio:checked").val();
		if(nearMarket == '1'){
            patientObj.nearMarketStr = '是';
        }else if(nearMarket == '2'){
            patientObj.nearMarketStr = '否';
        }else if(nearMarket == '4'){
            patientObj.nearMarketStr = '不详';
        }else{
            patientObj.nearMarketStr = '';
        }
		patientObj['nearMarket'] = nearMarket;
		//表3 
		var contactMarket=$("input[name='contactMarket']:radio:checked").val();
		if(contactMarket == '1'){
            patientObj.contactMarketStr = '是';
        }else if(contactMarket == '2'){
            patientObj.contactMarketStr = '否';
        }else if(contactMarket == '4'){
            patientObj.contactMarketStr = '不详';
        }else{
            patientObj.contactMarketStr = '';
        }
		patientObj['contactMarket'] = contactMarket;
		
		
		//表3 
		var patientType=$("input[name='patientType']:radio:checked").val();
		if(patientType == '1'){
            patientObj.patientTypeStr = 'H7N9禽流感疑似或确诊病例';
        }else if(patientType == '2'){
            patientObj.patientTypeStr = '发热病人';
        }else{
            patientObj.patientTypeStr = '';
        }
		patientObj['patientType'] = patientType;
		
		$("#" + tableId).find("input").each(function(index,obj) {
			
            if (obj.type == 'text') {
                var inputValue = $(this).val();
                patientObj[$(this).attr("name")] = inputValue;
            }

            /*if(obj.type == "radio" && $(this).attr("checked")){
                var name =  $(this).attr("name");
                patientObj[name] = $(this).val();        
                patientObj[name+ "Str"] = $(this).attr("data-label");
	            if(""==$(this).val()){
	            	patientObj[name+ "Str"] = "";
	            }
            }*/
           
        });
    }

    
    function fillEhRowData(tableNo){
        var patientObj = {};
        getPatientValue(patientObj, 'popEh' + tableNo + 'Table');
        var ehTable = $("#eh" + tableNo +"Table");
        var html = '<tr>';
        if(tableNo == '1'){
        	 html += '<td field="attackDt" title="'+patientObj.attackDt+'">'+patientObj.attackDt+'</td>';
             html += '<td field="birdState" style="display:none;">'+patientObj.birdState+'</td>';
             html += '<td field="birdStateStr" title="'+patientObj.birdStateStr+'">'+patientObj.birdStateStr+'</td>';
             html += '<td field="birdSpeciesOther" style="display:none;">'+patientObj.birdSpeciesOther+'</td>';
             html += '<td field="birdSpecies" style="display:none;">'+patientObj.birdSpecies+'</td>';
             html += '<td field="birdSpeciesStr"  title="'+patientObj.birdSpeciesStr+'">'+patientObj.birdSpeciesStr+'</td>';    
             html += '<td field="contactWayStr" title="'+patientObj.contactWayStr+'">'+patientObj.contactWayStr+'</td>'; 
             html += '<td field="contactWay" style="display:none;">'+patientObj.contactWay+'</td>';  
             html += '<td field="contactWayOther" style="display:none;">'+patientObj.contactWayOther+'</td>';  
             html += '<td field="handStateStr" title="'+patientObj.handStateStr+'">'+patientObj.handStateStr+'</td>';  
             html += '<td field="handState" style="display:none;">'+patientObj.handState+'</td>'; 
             html += '<td field="protectWayStr" title="'+patientObj.protectWayStr+'">'+patientObj.protectWayStr+'</td>'; 
             html += '<td field="protectWay" style="display:none;">'+patientObj.protectWay+'</td>'; 
             html += '<td field="protectWayOther" style="display:none;">'+patientObj.protectWayOther+'</td>'; 
             html += '<td field="comments" style="display:none;">'+'1'+'</td>';
             html += '<td class="btnsublist" field="btn">' +
                 '<a href="javascript:void(0)" onclick="hnCase.editTr(this, ' + '\'ehList\',' + '\'1\''+ ')">修改</a>&nbsp;' +
                 '<a href="javascript:void(0)" onclick="caseEdit.removeTr(this)">删除</a>' +
                 '</td>';
        }else if(tableNo == '2'){
        	 html += '<td field="attackDt" title="'+patientObj.attackDt+'">'+patientObj.attackDt+'</td>';
        	 html += '<td field="birdSpeciesOther" style="display:none;">'+patientObj.birdSpeciesOther+'</td>';
             html += '<td field="birdSpecies" style="display:none;">'+patientObj.birdSpecies+'</td>';
             html += '<td field="birdSpeciesStr"  title="'+patientObj.birdSpeciesStr+'">'+patientObj.birdSpeciesStr+'</td>';    
             html += '<td field="birdDeathStr" title="'+patientObj.birdDeathStr+'">'+patientObj.birdDeathStr+'</td>';
             html += '<td field="birdDeath" style="display:none;">'+patientObj.birdDeath+'</td>';  
             html += '<td field="workshopStr" title="'+patientObj.workshopStr+'">'+patientObj.workshopStr+'</td>'; 
             html += '<td field="workshop" style="display:none;">'+patientObj.workshop+'</td>';     
             html += '<td field="contactBirdStr" title="'+patientObj.contactBirdStr+'">'+patientObj.contactBirdStr+'</td>';
             html += '<td field="contactBird" style="display:none;">'+patientObj.contactBird+'</td>';
             html += '<td field="comments" style="display:none;">'+'2'+'</td>';
             html += '<td class="btnsublist" field="btn">' +
                 '<a href="javascript:void(0)" onclick="hnCase.editTr(this, ' + '\'ehList\','  + '\'2\''+ ')">修改</a>&nbsp;' +
                 '<a href="javascript:void(0)" onclick="caseEdit.removeTr(this)">删除</a>' +
                 '</td>';
        }else if(tableNo == '3'){
        	 html += '<td field="attackDt" title="'+patientObj.attackDt+'">'+patientObj.attackDt+'</td>';
             html += '<td field="toMarketStr"  title="'+patientObj.toMarketStr+'">'+patientObj.toMarketStr+'</td>';    
             html += '<td field="toMarket"  style="display:none;">'+patientObj.toMarket+'</td>';    
             html += '<td field="passagewayStr" title="'+patientObj.passagewayStr+'">'+patientObj.passagewayStr+'</td>';  
             html += '<td field="passageway" style="display:none;">'+patientObj.passageway+'</td>';  
             html += '<td field="nearMarketStr" title="'+patientObj.nearMarketStr+'">'+patientObj.nearMarketStr+'</td>';     
             html += '<td field="nearMarket" style="display:none;">'+patientObj.nearMarket+'</td>'; 
             html += '<td field="contactMarketStr" title="'+patientObj.contactMarketStr+'">'+patientObj.contactMarketStr+'</td>';
             html += '<td field="contactMarket" style="display:none;">'+patientObj.contactMarket+'</td>';
             html += '<td field="visitNum" title="'+patientObj.visitNum+'">'+patientObj.visitNum+'</td>'; 
             html += '<td field="comments" style="display:none;">'+'3'+'</td>';
             html += '<td class="btnsublist" field="btn">' +
                 '<a href="javascript:void(0)" onclick="hnCase.editTr(this, ' + '\'ehList\','  + '\'3\''+ ')">修改</a>&nbsp;' +
                 '<a href="javascript:void(0)" onclick="caseEdit.removeTr(this)">删除</a>' +
                 '</td>';
        }else if(tableNo == '4'){
        	 html += '<td field="attackDt" title="'+patientObj.attackDt+'">'+patientObj.attackDt+'</td>';
             html += '<td field="patientTypeStr"  title="'+patientObj.patientTypeStr+'">'+patientObj.patientTypeStr+'</td>';    
             html += '<td field="patientType"  style="display:none;">'+patientObj.patientType+'</td>'; 
             html += '<td field="contactWayStr" title="'+patientObj.contactWayStr+'">'+patientObj.contactWayStr+'</td>'; 
             html += '<td field="contactWayOther" style="display:none;">'+patientObj.contactWayOther+'</td>';  
             html += '<td field="contactWay" style="display:none;">'+patientObj.contactWay+'</td>'; 
             html += '<td field="protectWayStr" title="'+patientObj.protectWayStr+'">'+patientObj.protectWayStr+'</td>';  
             html += '<td field="protectWay" style="display:none;">'+patientObj.protectWay+'</td>';
             html += '<td field="contactTime" title="'+patientObj.contactTime+'">'+patientObj.contactTime+'</td>';  
             html += '<td field="comments" style="display:none;">'+'4'+'</td>';
             html += '<td class="btnsublist" field="btn">' +
                 '<a href="javascript:void(0)" onclick="hnCase.editTr(this, ' + '\'ehList\','  + '\'4\''+ ')">修改</a>&nbsp;' +
                 '<a href="javascript:void(0)" onclick="caseEdit.removeTr(this)">删除</a>' +
                 '</td>';
        }
        html += '</tr>';     
        return html;
    }
       
    /*
     * 选择其他时，显示其他输入框 radioName：radio的name otherId:DivId,其他输入框等放在Div中
     * code:当当前选中的radio的值与是code包含的任意值时显示otherId
     */
    function toggleOnes(radioName, otherId, code)
    {
    	var raValue = $('input[name="' + radioName + '"]:visible:checked').val();
    	if (code.indexOf(raValue) != -1)
    	{
    		$("#" + otherId).show();
    		$("#" + otherId).find("input").each(function()
    		{
    			$(this).show();
    		});
    	} else
    	{
    		$("#" + otherId).hide();
    		$("#" + otherId).find("input[type=text]").each(function()
    		{
    			$(this).val('');
    		});
    		$("#" + otherId).find("input[type=radio]").each(function()
    		{
    			$(this).attr("checked", false);
    		});
    		$("#" + otherId).find("input[type=checkbox]").each(function()
    		{
    			$(this).attr("checked", false);
    		});
    		$("#" + otherId).find("select").each(function()
    		{
    			$(this).val('');
    		});
    	}	
    }
  
    return {
		
        addEhList : addEhList,
        editEhList:editEhList,
        editTr:editTr,
        popEh:popEh,
        toggleOnes:toggleOnes
    };
})();




