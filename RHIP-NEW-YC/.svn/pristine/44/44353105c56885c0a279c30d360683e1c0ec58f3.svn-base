var itemSearch = (function() {
    $(function() {
        $("#itemBtnSearch").click(function() {
           search(1);
        });
        $("#itemSearch").onEnter(search, 1);
        search(1); 
    });

    function search(pageIndex) {
    	var prescribeDateBegin = $('#outpatientDrugDetailDiv').find('#prescribeDateBegin').val();
    	var prescribeDateEnd = $('#outpatientDrugDetailDiv').find('#prescribeDateEnd').val();
    	var patientType = $('#outpatientDrugDetailDiv').find('#patientType').val();
    	var hospitalCode = $('#outpatientDrugDetailDiv').find('#detailHospitalCode').val();    	
  		var totalCostSum = $('#outpatientDrugDetailDiv').find('#totalCostSum').val();
        pageIndex = ($.isEmpty(pageIndex)?1:pageIndex);
        var searchObj = {
            url : "/da/daily/outpatientDrug/itemlist",
            insertDiv : "itemResultDiv",
            param : {
                pageIndex : pageIndex,
                prescribeDateBegin:prescribeDateBegin,
                prescribeDateEnd:prescribeDateEnd,
                patientType:patientType, 
                hospitalCode:hospitalCode,
                totalCostSum:totalCostSum
            },
            callback : function(data) {
            	$("#itemPageIndex").val(pageIndex);
            }
        };
        $("#itemSearchForm").submitFormLoadHtml(searchObj);
    };	
	return {
		search:search
	};
})();



