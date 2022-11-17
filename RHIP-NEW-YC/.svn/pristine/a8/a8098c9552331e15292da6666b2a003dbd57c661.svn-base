var medication = (function() {
    $(function() {
        medicationSearch(1); 
    });
    function medicationSearch(pageIndex) {
    	var prescribeDateBegin = $('#physicianDrugDetailDiv').find('#prescribeDateBegin').val();
    	var prescribeDateEnd = $('#physicianDrugDetailDiv').find('#prescribeDateEnd').val();
    	var patientType = $('#physicianDrugDetailDiv').find('#patientType').val();
    	var hospitalCode = $('#physicianDrugDetailDiv').find('#hospitalCode').val();
    	var drugCode = $('#physicianDrugDetailDiv').find('#drugCode').val();
        pageIndex = ($.isEmpty(pageIndex)?1:pageIndex);
        var searchObj = {
            url : "/da/daily/physicianDrug/medicationlist",
            insertDiv : "medicationResultDiv",
            param : {
                pageIndex : pageIndex,
                hospitalCode:hospitalCode,
                drugCode:drugCode,
                patientType:patientType,
                prescribeDateBegin:prescribeDateBegin,
                prescribeDateEnd:prescribeDateEnd
            },
            callback : function(data) {
            	$("#medicationPageIndex").val(pageIndex);
            }
        };
        $("#medicationSearchForm").submitFormLoadHtml(searchObj);
    };	
   
	return {
		medicationSearch:medicationSearch
	};
})();



