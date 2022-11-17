var selfFillNeonateEdit = (function() {
	var validate=null;
	$(function() { 
		 validate = $("#selfFillForm").easyValidate();
		 enableChangeConfirm();
		 var type = $('#tagContent2').find('#type').val();
        if('view' == type){
            $("#selfFillForm").diabaleForm();
            $('#tagContent2').find('#reportMonthSelfId').removeAttr("onfocus");
            $('#tagContent2').find('#reportDateId').removeAttr("onfocus");
            $('.required').removeClass("required");
        }
        $('#reportMonthSelfId').on("onDatePickerChanged",function(){
        	existFill();
        });
	});

	function returnSearch(){
        if(contentChanged){
        	msgUtil.backConfirm(function(){
				search();
			});        	
        }else{
        	search();
        }
	}
    function search(){
        disableChangeConfirm();
        var type = $('#tagContent2').find('#type').val();
        if('add' == type){
        	$("#selfcheck_top_all").show();
        	$('#spanSelfFill2Id').removeClass("active");
        	$('#spanSelfListId').attr("class", "active"); 
        	$("#selfcheck_detailDiv").hide();
        	reportSelfCheckIndex.loadFillSearch();
        }else{
            $("#fillSelfdetailDiv").empty();
            selfFillSearch.search();
            $("#fillSelfTopAll").show();
        }         
    }
     /*
     * 提交保存
     * */
    function fillSubmit(){
    	var result=validate.validateForm();
    	if(!result){
    		return;
    	} 
		$("#selfFillForm").submitFormGetJson({
			url : "/idm/statistics/report/selfcheck/saveFill",
			param : {type:'2'},
            callback : function(data) {
                if (data.indexOf("fail") > -1) {
                    layer.alert("保存失败！", {icon:0,title:'提示'});
                }else {
                    layer.alert("保存成功！", {icon:0,title:'提示'});
                    search();
                    return false;
                }
            },
            wait:true
		});    	
    }
    function formatDate(){
        var reportMonth =  $('#tagContent2').find('#reportMonthId').val();
        if(!$.isEmpty(reportMonth)){
        	reportMonth = reportMonth + '/01';
        	$('#tagContent2').find('#reportMonthId').val(reportMonth);
        } 
    }
    /*
     * 检测该月份是否已经填报
     * */
    function existFill(){
    	 var reportMonth =  $('#reportMonthSelfId').val();
    	 var reportMonthOld = $('#tagContent2').find('#reportMonthOldId').val();
    	 if(reportMonth == reportMonthOld){
    		 return;
    	 }
    	 var reportUnitCode = $('#tagContent2').find('#reportUnitCodeId').val();
         if(!$.isEmpty(reportMonth) && !$.isEmpty(reportUnitCode)){
         	reportMonth = reportMonth + '/01';
    		$.getJsonByUrl({
    			url : "/idm/statistics/report/selfcheck/queryFill",
    			callback : function(data) {
    				checkReportMonth(data.count);
    			},
    			param : {reportMonth:reportMonth,
    				reportUnitCode:reportUnitCode,
    				type:'2'}
    		}); 
         }     	
    }
    
    function checkReportMonth(count){
    	$('#reportMonthSelfFlag').val(count);
        if(count > 0){
			validate.addError('reportMonthSelf',"该月份已经填报，不允许重复");
            validate.addCheckElement('reportMonthSelf',{"compare":["reportMonthSelfFlag","le","该月份已经填报，不允许重复"]})
        }else{
			validate.removeError('reportMonthSelf');
            validate.removeCheckElement('reportMonthSelf');
        }
    }
 	return {
 		returnSearch:returnSearch,
 		fillSubmit:fillSubmit,
 		existFill:existFill
	};
})();