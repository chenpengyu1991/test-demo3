var drugSearch = (function() {
    $(function() {
        $("#drugBtnSearch").click(function(e) {
           e.preventDefault();
        	search(1);
        });
        $("#drugBtnSearch").onEnter(search, 1);
        search(1); 
    });

    function search(pageIndex) {
    	var prescribeDateBegin = $('#inpatientDrugDetailDiv').find('#prescribeDateBegin').val();
    	var prescribeDateEnd = $('#inpatientDrugDetailDiv').find('#prescribeDateEnd').val();
    	var patientType = $('#inpatientDrugDetailDiv').find('#patientType').val();
    	var hospitalCode = $('#inpatientDrugDetailDiv').find('#detailHospitalCode').val();    	
  		var detailType = $('#inpatientDrugDetailDiv').find('#detailType').val();
  		var drugCostSum = $('#inpatientDrugDetailDiv').find('#drugCostSum').val();
        pageIndex = ($.isEmpty(pageIndex)?1:pageIndex);
        var searchObj = {
            url : "/da/daily/inpatientDrug/druglist",
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



