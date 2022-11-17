var outpatientReport=(function(){

	//门诊
	jQuery("#outpatient_report_btn").on("click", function(event){
		event.preventDefault(); 
		/*var dialogObj = {
				url :  "/outpatient/detailReport/"+$('#drugReport').find("#personId").attr("value")+"/"+$("#ehrId").attr("value"),
				title : "门诊",
				height : 550,
				param : {
					ehrId : $("#ehrId").attr("value"),
					personId : $('#drugReport').find("#personId").attr("value")
				}
			};
		jQuery.dialog(dialogObj);*/
		
		 $.post(contextPath+"/outpatient/detailReport/"+$('#drugReport').find("#personId").attr("value")+"/"+$("#ehrId").attr("value"),
	        		{ 
			 		ehrId : $("#ehrId").attr("value"),
			 		personId : $('#drugReport').find("#personId").attr("value")
				     }, 
				function(ret){
         		  layer.open({
         			  type: 1,
         			  id:'outpatientViewDialog',
         			  area: ['1000px', '590px'],
         			  title:'门诊',
         			  content: ret
         		  });
         	});
	});

})();

