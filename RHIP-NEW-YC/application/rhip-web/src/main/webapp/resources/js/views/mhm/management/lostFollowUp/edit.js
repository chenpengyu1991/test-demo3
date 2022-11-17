var lostFollowUpEdit = (function() {
	var validate = null;
	$(function() { 
		validate = $("#lostFollowUpForm").easyValidate();
        $("#lfReturn").click(function(e) {
 			e.preventDefault();
        	mhmCommon.returnSearch(managementSearch.search);
        });
        $("#lfSave").click(function(e) {
            e.preventDefault();
        	save();
        });        
		toggleLostReason();
		toggleHospitalCourse();
        toggleOtherSC('mhmFollowup.dieReason','spanFrDieReason','6');
        var age = $('#lfAge').val();
        var idcard = $('#lfIdCard').val();
        if($.isEmpty(age) && !$.isEmpty(idcard)){
	        var idCardBirthDay = IC.getBirthday(idcard);
	        var age = mhmCommon.getAge(idCardBirthDay);
	        $('#lfAge').val(age);
        }
		$('#lostfollowupDt').on("onDatePickerChanged",function(){
			var statusId = $("#lostFollowUpForm").find('#statusId').val();
            validateFollowupDt(this.value,statusId);
        });	        
    });
	/*
	 * 失访原因
	 * */
	function toggleLostReason(){
		toggleOtherSC('mhmFollowup.loseReason','spanLfLostReasonId','6');
		var lostReason = $('#lfLostReason').val();
		$('#lostFollowUpHead').find("[id^='deathId']").each(function(){
			if(lostReason == '1'){
				$(this).show();
				toggleOtherSC('mhmFollowup.dieReason','spanLfLostReasonId','6');
			}else{
				$(this).hide();
			}
		});	
	}
    /*
     * 保存失访信息
     * */
    function save(){
        var result=validate.validateForm();
        if(!result){
            return;
        }
        $("#lostFollowUpForm").submitFormGetJson({
            url : "/mhm/lostfollowup/save",
            callback : function(data) {
                if (data.indexOf("fail") > -1) {
                    layer.alert("保存失败！", {icon:0,title:'提示'});
                }else {
                    layer.alert("保存成功！", {icon:0,title:'提示'});
                    disableChangeConfirm();
                    loadLostFollowUp();
                    //刷新随访记录
                    //followUpMain.followUpList();
                    return false;
                }
            },
            wait:true
        });    	
    }
	/*加载失访信息页面*/
	function loadLostFollowUp() {
    	var statusId = $('#statusId').val();		
		//参数
		var loadHtmlByUrlOption = {
			url : "/mhm/lostfollowup/edit",
	        param : {statusId:statusId},
			checkRepeat : true,
			insertDiv : "tagContent4",
			errorDiv: "",
			okDiv:""
		};
		$.loadHtmlByUrl(loadHtmlByUrlOption);
	};
	function toggleHospitalCourse(){
		var type = $('#lfhospitalCourse').val();
		if(type == '0' || $.isEmpty(type)){
			toggleOtherSC('mhmFollowup.hospitalCourse','spanLfHospitalCourse','1');
		}else if(type == '1'){
			toggleOtherSC('mhmFollowup.hospitalCourse','spanLfHospitalCourse','1');
		}else if(type == '2'){
			toggleOtherSC('mhmFollowup.hospitalCourse','spanLfHospitalCourse','2');
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
 	return {
 		toggleLostReason:toggleLostReason,
 		toggleHospitalCourse:toggleHospitalCourse
	};
})();