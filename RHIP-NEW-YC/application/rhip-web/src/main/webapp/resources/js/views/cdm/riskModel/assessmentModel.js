var assessmentModel = (function() {
	var validate = null;
	$(function() { 
		validate = $("#riskFactorsInfo").easyValidate();
	   	$("#riskFactorSubmit").click(function(e){
	   		e.preventDefault();
	   		var result = validate.validateForm();
			if (!result) {
				return;
			}
			save();
		});
	});
	function save(){
		 var systolicBloodPressure = $("#minimumSystolicBloodPressure").val()+","+$("#maximumSystolicBloodPressure").val();
		 var diastolicBloodPressure = $("#minimumDiastolicBloodPressure").val()+","+$("#maximumDiastolicBloodPressure").val();
		 var bloodSugarLevel = $("#lowestBloodSugarLevel").val()+","+$("#highestBloodSugarLevel").val();
		 var serumTotalCholesterol = $("#lowestSerumTotalCholesterol").val()+","+$("#highestSerumTotalCholesterol").val();
		 var ages=$("#beginAge").val()+","+$("#endAge").val();
		 var totaCholesterol = $("#lowestTotaCholesterol").val()+","+$("#highestTotaCholesterol").val();
		 var triglycerides = $("#lowestTriglycerides").val()+","+$("#highestTriglycerides").val();
		 $("#riskFactorsInfo").submitFormGetJson({			
         url : "/cdm/highrisk/riskFactorInfoList", 
		 param:{
			 "cfgs[14].parameterValue":systolicBloodPressure,
			 "cfgs[15].parameterValue":diastolicBloodPressure,
			 "cfgs[2].parameterValue":bloodSugarLevel,
			 "cfgs[3].parameterValue":serumTotalCholesterol,
			 "cfgs[6].parameterValue":ages,
			 "cfgs[11].parameterValue":totaCholesterol,
			 "cfgs[12].parameterValue":triglycerides
		 },
         callback : function(data){
        	 layui.use('layer', function(){
 				var layer = layui.layer;
 				
 				if("failure" == data){
 					layer.alert("保存失败！", {icon:0,title:'提示'});
 				}
 				if("success" == data){
 					layer.alert("保存成功！", {icon:0,title:'提示'});
 				}
 			});
         },
     });
	}
	return {
		save:save
	};
})();