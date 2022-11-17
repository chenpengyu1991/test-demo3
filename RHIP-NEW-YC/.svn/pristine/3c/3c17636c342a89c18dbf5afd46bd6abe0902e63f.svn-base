var detailSearch = (function() {
    $(function() {
        $("#drugBtnSearch").click(function() {
           search(1);
        });
        $("#drugDetailSearch").onEnter(search, 1);
        search(1); 
    });

    function search(pageIndex) {
    	var prescribeDateBegin = $('#outpatientDrugDetailDiv').find('#prescribeDateBegin').val();
    	var prescribeDateEnd = $('#outpatientDrugDetailDiv').find('#prescribeDateEnd').val();
    	var patientType = $('#outpatientDrugDetailDiv').find('#patientType').val();
    	var hospitalCode = $('#outpatientDrugDetailDiv').find('#detailHospitalCode').val();    	
  		var detailType = $('#outpatientDrugDetailDiv').find('#detailType').val();
  		var drugCostSum = $('#outpatientDrugDetailDiv').find('#drugCostSum').val();
        pageIndex = ($.isEmpty(pageIndex)?1:pageIndex);
        var searchObj = {
            url : "/da/daily/outpatientDrug/druglist",
            insertDiv : "drugResultDiv",
            param : {
                pageIndex : pageIndex,
                prescribeDateBegin:prescribeDateBegin,
                prescribeDateEnd:prescribeDateEnd,
                patientType:patientType, 
                hospitalCode:hospitalCode,
                detailType:detailType,
                drugCostSum:drugCostSum
            },
            callback : function(data) {
            	$("#drugPageIndex").val(pageIndex);
            }
        };
        $("#drugSearchForm").submitFormLoadHtml(searchObj);
    };	
	return {
		search:search
	};
})();



