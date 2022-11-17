var fillEdit = (function() {
	var validate=null;
	$(function() { 
		 validate = $("#fillSupervisorForm").easyValidate();
		 enableChangeConfirm();
		 var type = $('#tagContent1').find('#type').val();
        if('view' == type){
            $("#fillSupervisorForm").diabaleForm();
            $('#reportMonthId').removeAttr("onfocus");
            $('#reportDateId').removeAttr("onfocus");
            $('.required').removeClass("required");
        }
        
        $('#reportMonthId').on("onDatePickerChanged",function(){
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
    	var type = $('#tagContent1').find('#type').val();
        disableChangeConfirm();
        if('add' == type){
        	$('#spanFillId').removeClass("active");
        	$('#spanListId').attr("class", "active"); 
        	reportIndex.loadFillSearch();
        }else{
            $("#filldetailDiv").empty();   
            fillSearch.searchFill();
            $("#fillTopAll").show();
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
    	formatDate();
		$("#fillSupervisorForm").submitFormGetJson({
			url : "/idm/statistics/report/supervisor/saveFill",
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
        var reportMonth =  $('#reportMonthId').val();
        if(!$.isEmpty(reportMonth)){
        	reportMonth = reportMonth + '/01';
            $('#reportMonthId').val(reportMonth);
        } 
    }
    /*
     * 检测该月份是否已经填报
     * */
    function existFill(){
    	 var reportMonth =  $('#reportMonthId').val();
    	 var reportMonthOld = $('#reportMonthOldId').val();
    	 if(reportMonth == reportMonthOld){
    		 return;
    	 }
    	 var reportUnitCode = $('#reportUnitCodeId').val();
         if(!$.isEmpty(reportMonth) && !$.isEmpty(reportUnitCode)){
         	reportMonth = reportMonth + '/01';
    		$.getJsonByUrl({
    			url : "/idm/statistics/report/supervisor/queryFill",
    			callback : function(data) {
    				checkReportMonth(data.count);
    			},
    			param : {reportMonth:reportMonth,reportUnitCode:reportUnitCode}
    		}); 
         }     	
    }
    
    function checkReportMonth(count){
        $('#reportMonthFlag').val(count);
    	if(count > 0){
			validate.addError('reportMonth',"该月份已经填报，不允许重复");
            validate.addCheckElement('reportMonth',{"compare":["reportMonthFlag","le","该月份已经填报，不允许重复"]});
		}else{
			validate.removeError('reportMonth');
            validate.removeCheckElement('reportMonth');
        }
    }
 	return {
 		returnSearch:returnSearch,
 		fillSubmit:fillSubmit,
 		existFill:existFill
	};
})();