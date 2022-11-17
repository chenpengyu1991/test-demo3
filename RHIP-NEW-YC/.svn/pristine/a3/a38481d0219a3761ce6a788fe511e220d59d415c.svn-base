var outpatientReport=(function(){

	//门诊
	jQuery("#outpatient_report_btn").on("click", function(event){
		event.preventDefault(); 
		
		var dialogObj = {
				url :  "/outpatient/detailReport",
				title : "门诊",
				height : 500,
				param : {
					ehrId : $("#ehrId").attr("value"),
					personId : $("#personId").attr("value")
				}
			};
		jQuery.dialog(dialogObj);
	});

})();

