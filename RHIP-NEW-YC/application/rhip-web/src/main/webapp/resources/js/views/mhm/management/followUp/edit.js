var followUpEdit = (function() {
	var validate = null;
	$(function() {
		validate = $("#followUpForm").easyValidate();
        toggleOtherCK('mhmFollowup.symptom','divSymptom','99')
        toggleOtherCK('mhmFollowup.drugAdverseReaction','divDrugAdverseReaction','2');
        toggleOtherCK('mhmFollowup.referrals','divReferralsReason','1')
        toggleOtherCK('mhmFollowup.completedReferral','divReferralsToOrgan','1')
        toggleOtherSC('mhmFollowup.uncureReason','divUncureReason','99');
        toggleOtherCK('mhmFollowup.recoveryMeasures','divRecoveryMeasures','99');
		toggleWay();
		toggleLostReason();
		toggleFHospitalCourse();
		toggleHospitalCourse();
		toggleOtherSC('mhmFollowup.dieReason','divDieReason','6');
		toggleOtherSC('mhmFollowup.dieReason','divDieReasonPathogeny','1');
		/*toggleOther('mhmFollowup.isCheck','spanIsCheck','1');
		toggleOtherCK('mhmFollowup.checkType','spanCheckType','A99');		*/
		toggleOther('mhmFollowup.isCheck','spanCheckType','1');
		enableChangeConfirm();
        $("#popupMedication").click(function() {
           popupMedication(null,'add');
        });		
		$('#followupDt').on("onDatePickerChanged",function(){
			var statusId = $("#followUpForm").find('#statusId').val();
            validateFollowupDt(this.value,statusId);
            nextFollowupDt(this.value);//根据病情分类，更新下次随访日期
        });	
        //病情分类改变时，更新下次随访日期
		$('#followupType').on("change",function(){
			var followupDt = $("#followupDt").val();
			if(validate.validate("mhmFollowup.followupDt")){
            	nextFollowupDt(followupDt);
			}
        });
		
		$('#dieReason').on("change",function(){
			 if($(this).val()=='1'){
				 $("#divDieReasonPathogeny").show();
			}else{
				$("#divDieReasonPathogeny").find("input[type=radio]").each(function(){
					$(this).attr("checked", false);
				});
				$("#divDieReasonPathogeny").hide();
				
			}
			
		});
		
		//onchange=""
	});
	/*
	 * 随访方式,如果“未访到”，则加载失访信息，隐藏部分基本信息
	 * */
	function toggleWay(){
		var followupType = $('input[name="mhmFollowup.type"]:visible:checked').val();
		$('#followUpForm').find("[id^='followUpId']").each(function(){
			if(followupType == '2'){
				$(this).hide();
				$('#lostFollowUp').show();
			}else{
				$(this).show();
				$("#lostFollowUp").find("input[type=text]").each(function()
				{
					$(this).val('');
				});
				$("#lostFollowUp").find("input[type=radio]").each(function()
				{
					$(this).attr("checked", false);
				});
				$("#lostFollowUp").find("select").each(function()
				{
					$(this).val('');
				});				
				$('#lostFollowUp').hide();
			}
		});	
	}
	/*
	 * 失访原因
	 * */
	function toggleLostReason(){
		toggleOtherSC('mhmFollowup.loseReason','divLoseReason','6');
		var lostReason = $('#loseReason').val();
		$('#lostFollowUp').find("[id^='deathId']").each(function(){
			if(lostReason == '1'){
				$(this).show();
				toggleOtherSC('mhmFollowup.dieReason','divLoseReason','6');
			}else{
				$(this).hide();
			}
		});	
	}
	/*
	 * 弹出用药记录子画面
	 * */
	function popupMedication(btn,type){
        var param = '';
        if("edit" == type){
            var extendDiv = btn.parentNode.parentNode;
            var rowIndex = extendDiv.rowIndex;
            var trData = {};
            $(extendDiv).find("td").each(function(tdindex,tditem){
                var inputValue = $(tditem).text();
                inputValue = inputValue.replace(/\t/g,'');//制表符替换
                inputValue = inputValue.replace(/\n/g,'');//换行替换                
                if('' != inputValue){
                    trData[$(this).attr("field")] = inputValue;
                }
            });
            var trDataStr =  "[" + util.Obj2str(trData) + "]";
            param = {trData:trDataStr, rowIndex:rowIndex, type:'edit'};
        }
	    var medicationDialog = {
	            url : "/mhm/followUp/popupMedication",
	            height : 650,
	            width : 800,
	            title : "新增用药情况" ,
	            id :"medicationDialog",
            	param:param	            
	        };
		$.dialog(medicationDialog);		
	}
	function toggleFHospitalCourse(){
		var type = $('#hospitalCourseLost').val();
		if(type == '0' || $.isEmpty(type)){
			toggleOtherSC('flHospitalCourse','spanFHospitalCourse','1');
		}else if(type == '1'){
			toggleOtherSC('flHospitalCourse','spanFHospitalCourse','1');
		}else if(type == '2'){
			toggleOtherSC('flHospitalCourse','spanFHospitalCourse','2');
		}			
	}	
	function toggleHospitalCourse(){
		var type = $('#hospitalCourse').val();
		if(type == '0' || $.isEmpty(type)){
			toggleOtherSC('hospitalCourse','spanHospitalCourse','1');
		}else if(type == '1'){
			toggleOtherSC('hospitalCourse','spanHospitalCourse','1');
		}else if(type == '2'){
			toggleOtherSC('hospitalCourse','spanHospitalCourse','2');
		}			
	}	
	/**
	 * 验证随访日期
	 * 必须在建档日期之后
	 */
	function validateFollowupDt(followupDt,statusId){
		if (!$.isEmpty(followupDt)){
            $.getJsonByUrl({
                url : "/mhm/followUp/validateFollowupDt",
                wait : true,
                async : false,
                callback : function(data) {
					if(data.indexOf("success") > -1) {
                		validate.removeError('mhmFollowup.followupDt');
            			validate.removeCheckElement('mhmFollowup.followupDt');
                	}else if (data.indexOf("fail") > -1) {
                   		validate.addError('mhmFollowup.followupDt',"无法获取建档日期");
			        	validate.addCheckElement('mhmFollowup.followupDt',{"compare":["followupDtFlag","le","无法获取建档日期 "]});
                	}else if (!$.isEmpty(data)) {
                   		validate.addError('mhmFollowup.followupDt',"随访日期必须在建档日期之后,建档日期：" + data);
			        	validate.addCheckElement('mhmFollowup.followupDt',{"compare":["followupDtFlag","le","随访日期必须在建档日期之后,建档日期：" + data]});
                	}
                },
                param:{statusId:statusId,followupDt:followupDt}
            });
		}
	}   
	/**
	 * 生成下次随访日期
	 * 根据病情分类
	 * 病情不稳定，加14天
	 * 病情基本稳定、稳定，加3个月
	 */
	function nextFollowupDt(followupDt){
		if (!$.isEmpty(followupDt)){
			var followupType = $("select[name=\'mhmFollowup.followupType\']:visible").find("option:selected").val();
            $.getJsonByUrl({
                url : "/mhm/followUp/nextFollowupDt",
                wait : true,
                async : false,
                callback : function(data) {
					if(!$.isEmpty(data)) {
						$('#nextFollowupDt').val(data);
                	}
                },
                param:{followupType:followupType,followupDt:followupDt}
            });
		}
	}	
 	return {
 		toggleWay:toggleWay,
 		toggleLostReason:toggleLostReason,
 		popupMedication:popupMedication,
 		toggleFHospitalCourse:toggleFHospitalCourse,
 		toggleHospitalCourse:toggleHospitalCourse
	};
})();