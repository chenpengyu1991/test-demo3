var distribution = (function() {
	var validate=null;
	$(function() { 
		validate = $("#distributionForm").easyValidate();

	});

	/*
	 * 分配单位
	 * */
	function save(){
		var ids = $('#ids').val();
    	var acceptUnit = $('#acceptUnitId').val();
    	var acceptTown = $('#acceptTownId').val();
		if($.isEmpty(acceptTown)){
			validate.addCheckElement('acceptTown',{"required":"true"});	
		}else{
			validate.removeCheckElement('acceptTown');
		}     	
		if($.isEmpty(acceptUnit)){
			validate.addCheckElement('acceptUnit',{"required":"true"});	
		}else{
			validate.removeCheckElement('acceptUnit');
		} 		
    	var result=validate.validateForm();
    	if(!result){
    		return;
    	}
		$("#distributionForm").submitFormGetJson({
			url : "/idm/malaria/register/distribution",
			param : {ids:ids,acceptTown:acceptTown,acceptUnit:acceptUnit},
            wait : true,
			callback : function(data) {
				if (data.indexOf("fail") > -1) {
					layer.alert("分配失败！", {icon:0,title:'提示'});
                }else {
                	idmCommon.closePopUp('disDialog');
                	layer.alert("分配成功！", {icon:0,title:'提示'});
                	malariaIndex.searchRegister();
                   return false;
                }
			},
            wait:true
		});
  	
	}
	return {
		save:save
	};
})();