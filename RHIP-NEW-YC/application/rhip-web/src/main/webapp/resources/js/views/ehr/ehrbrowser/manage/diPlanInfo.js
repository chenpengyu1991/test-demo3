var brwDiPlanInfo = (function() {
	$(function() {
//		 var validate = $("#diPlanForm").easyValidate();
//		 brwPlanInfoTab.setDiValidate(validate);
		 $("#diYear").val(new Date().getFullYear());
		 $("#createDiDate").val(new Date().pattern("yyyy/MM/dd"));
		 if($("input[name='manageLevel']:checked").length<1){
			  $("input[name='manageLevel']").val(["1"]);
	       }
		 $("#personDiName").val($("#hiddenPersonName").val());
	});
})();