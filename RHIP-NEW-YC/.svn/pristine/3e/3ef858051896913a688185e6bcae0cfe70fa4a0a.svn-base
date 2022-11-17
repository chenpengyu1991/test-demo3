var schCommon = (function() {
	/*
	 * 查看血吸虫病人流程是否终止
	 * */
	function checkEndProcedure(){
		var result = false;
		var specialStatus = $('#specialStatusId').val();
		if(specialStatus == '6'){
			result = true;
		}
		return result;
	}
    function changeBtStatus(type){
    	if(type=='add'){
    		$("#add").hide();
            $("#update").hide();
            $("#delete").hide();
            $("#save").show();
    	}else{
    		$("#add").show();
            $("#update").show();
            $("#delete").show();
            $("#save").hide();
    	}
    }
	/**
	 * 根据人员注销状态，禁用表单
	 * logoff:0 正常，logoff:1 注销
	 */
	function diabaleForm(formId){
		var logoff = $('#' + formId).find('#logoff').val();
		if('1' == logoff){
			idmCommon.diabaleForm(formId);
		}
	}    
	return {
		checkEndProcedure:checkEndProcedure,
		changeBtStatus:changeBtStatus,
		diabaleForm:diabaleForm
	};
})();



