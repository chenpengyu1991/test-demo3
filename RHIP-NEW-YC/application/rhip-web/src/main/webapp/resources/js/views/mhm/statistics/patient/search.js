var mhmPatientSearch = (function() {

	var validate=null;
	$(function() {
		validate = $("#patientSearchForm").easyValidate();
        $("#patientBtnSearch").click(function(e) {
        	e.preventDefault();
        	searchPatient();
        });	
        $("#patientExport").click(function(e) {
        	e.preventDefault();
        	downloadPatient();
        });

        $("#patientSearchForm").onEnter(searchPatient, 1);
        searchPatient();
	});

	/*查询*/
	function searchPatient(pageIndex) {
        pageIndex = ($.isEmpty(pageIndex)?1:pageIndex);
		var result=validate.validateForm();
    	if(!result){
    		return;
    	}
		var searchObj = {
			url : "/mhm/statistics/patient/list",
			insertDiv : 'patientResultDiv',
			param : {pageIndex:pageIndex},
            callback : function(data) {
                $("#pageIndex").val(pageIndex);
            }
		};
		$("#patientSearchForm").submitFormLoadHtml(searchObj);
	};

    function downloadPatient(){
        var params = $('#patientSearchForm').formSerialize();
        params = decodeURIComponent(params,true);
        location.href = contextPath + "/mhm/statistics/downPatientExcel?" + params;
    }

	return {
        searchPatient:searchPatient
	};
})();