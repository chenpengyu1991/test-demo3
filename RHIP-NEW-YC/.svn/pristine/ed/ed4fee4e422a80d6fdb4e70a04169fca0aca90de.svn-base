var drugReportPop=(function(){
	$(function(){
		//查看处方报告单
		$("#exam-result-content").on("click",".report-link-btn",function(event){
		//	alert(1);
			event.preventDefault();
			var $this=$(this);
			var dialogObj = {
					url :  $this.attr("href"),
					title : "处方",
					width : 500
					};
			$.dialog(dialogObj);
			return false;
		});
	})
})();

