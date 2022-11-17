var outpatientReportPop=(function(){
	$(function(){
		//门诊
		$(".outpatient-link-btn").click(function(event){
			event.preventDefault();
			var $this=$(this);
			var dialogObj = {
					url :  $this.attr("href"),
					title : "门诊",
					width : 500,
					param : {
						ehrId : $("#ehrId").attr("value"),
						personId : $("#personId").attr("value")
					}
					};
			$.dialog(dialogObj);
			return false;
		});
	})
})();