var prescriptionInit = (function(){

	$(function() {
		/*健康指导*/
		$("#jkzd, #jkzd1").click(function() {
			window.location.href = contextPath+ "/health/prescriptionMh/list?indexPage=1";
		});
		initLinkClick('prescriptionDetail',prescriptionDetail, {id:"data-id"});
	});


	function prescriptionDetail(id) {
		window.location.href = contextPath + "/health/prescriptionMh/detail/" + id;
	}
})();