var surveyEdit = (function() {
	var validate = null;
	$(function() { 
		validate = $("#surveyForm").easyValidate();
		toggleOtherSC('generalCondition.occupation','spanOccupationOther','CV020120299');
		toggleOther('generalCondition.hrType','spanHrType','2');
		toggleOther('generalCondition.loseJob','divLoseJob','2');
		toggleOther('pastHistory.etiology','spanEtiologyId','1');
		toggleOther('pastHistory.spleen','spanSpleenId','1');
		toggleOtherSC('pastHistory.ascites','spanAscitesId','1');
		toggleOther('pastHistory.alimentaryCanal','spanAlimentaryCanalId','1');
		toggleOther('pastHistory.hepaticComa','spanHepaticComaId','1');
		toggleOther('pastHistory.cldFlg','spanCldFlgId','1');		
		toggerOutCome();
		enableChangeConfirm();
        idmCommon.displayPaAddress();
        idmCommon.toggerAddress();
        schCommon.diabaleForm('surveyMain');
        var idCard = $('#surveyidCard').val();
        if($.isEmpty(idCard)){
	        $.Placeholder.init({query:"#surveyidCard",callback:function(element){
				queryPerson($(element).val());
			}});
        }        
	});

	function toggerOutCome(){
		var raValue = $("select[name=\'otherCondition.outcomeCode\']:visible").find("option:selected").val();
		if (raValue == "1")//痊愈
		{
			$("#trCureDate").show();
		}else{
			$("#trCureDate").hide();
			$("#trCureDate").find("input[type=text]").each(function()
			{
				$(this).val('');
			});
		}
		if (raValue == "4")//死亡
		{
			$("#trDeathTime").show();
		}else{
			$("#trDeathTime").hide();
			$("#trDeathTime").find("input[type=text]").each(function()
			{
				$(this).val('');
			});
		}		
	}
	function queryPerson(idCard) {
        if (validate.validate("generalCondition.idcard")){
            $.getJsonByUrl({
                url : "/idm/report/queryPerson",
                wait : true,
                callback : function(data) {
                    if(!$.isEmpty(data)){
                        if(data.flag){
                            setPersonData(data);
                        }else{
                            setIcData(data.Idcard);
                        }
                    }
                },
                param:{idCard:idCard}
            });
        }
	};	
	/*
	 * 查询健康档案后设置患者信息
	 * */
	function setPersonData(data){
		 /*从健康档案获取人员信息时，判断注销状态。modify yjf 20131010*/
		$('#logoff').val(data.Logoff);
		if(!$.isEmpty(data.Name)){
			$('#patientName').val(data.Name);
		}
		if(!$.isEmpty(data.Birthday)){
			var birthday = IC.getBirthday(data.Idcard);
			$('#surveyBirthday').val(birthday);
		}else{
			$('#surveyBirthday').val(data.Birthday);
		}
		var gender;
		if($.isEmpty(data.Gender)){
			gender = IC.getGender(data.Idcard);
		}else{
			gender = data.Gender;
		}
		$('input[type=radio][name="generalCondition.gender"][value=' + gender + ']').attr("checked",true);

		if(!$.isEmpty(data.PhoneNumber)){
			$('#phoneNumberId').val(data.PhoneNumber);
		}
		if(!$.isEmpty(data.Occupation)){
			$('#surveryOccupation').val(data.Occupation);
		}
		toggleOtherSC('generalCondition.occupation','spanOccupationOther','CV020120299');
        if(!$.isEmpty(data.FloatPopulation) && data.FloatPopulation=="1"){
            $('input[name="generalCondition.floatPopulation"][value="1"]').attr("checked",true);
        }else{
            $('input[name="generalCondition.floatPopulation"][value="1"]').attr("checked",false);
        }
        idmCommon.toggerAddress();
        if(!$.isEmpty(data.PatownShip)){//现住址
        	$('#patown_address').val(data.PatownShip);
        	$("#patown_address").multiselect('refresh');
    		var idd = $("#patown_address").attr("idd").replace('townId', '');
    		orgUtil.getVillageOpting(idd,"",data.Pastreet);
            if(!$.isEmpty(data.Pastreet)){
    			$('#pavillage_address').val(data.Pastreet);
    		}        	
        }
        if(!$.isEmpty(data.PahouseNumber)){
        	$('#pahouseNumber').val(data.PahouseNumber);
        }
        if(!$.isEmpty(data.Education)){
        	$('#surveryEducation').val(data.Education);
        }
	}
	/*如果获取患者信息失败，根据身份证号码获取性别、出生日期*/
	function setIcData(idCard){
		var gender = IC.getGender(idCard);
		if(!$.isEmpty(gender)){
			$('input[type=radio][name="generalCondition.gender"][value=' + gender + ']').attr("checked",true);
		}
		var birthday = IC.getBirthday(idCard);
		if(!$.isEmpty(birthday)){
			$('#surveyBirthday').val(birthday);
		}

	}	
 	return {
 		toggerOutCome:toggerOutCome
	};
})();