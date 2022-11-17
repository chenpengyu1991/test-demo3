var occPatientReportList = (function() {

	function view(employeeId) {
		//参数
		$("#mainSearchDiv").hide();
		var option = {
			url : "/oh/occPatient/viewReport/"+employeeId,
			insertDiv : "operationDiv",
			param :{
				operatorType:'view'
			}
		};
		$.loadHtmlByUrl(option);
	};
	

	return {
		view:view
	};
})();

