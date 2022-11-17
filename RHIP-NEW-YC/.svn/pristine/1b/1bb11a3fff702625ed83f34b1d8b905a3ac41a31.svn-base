var itemSearch = (function() {
    $(function() {
        $("#itemBtnSearch").click(function() {
           search(1);
        });
        $("#itemBtnSearch").onEnter(search, 1);
        search(1); 
    });

    function search(pageIndex) {
    	var prescribeDateBegin = $('#inpatientDrugDetailDiv').find('#prescribeDateBegin').val();
    	var prescribeDateEnd = $('#inpatientDrugDetailDiv').find('#prescribeDateEnd').val();
    	var patientType = $('#inpatientDrugDetailDiv').find('#patientType').val();
    	var hospitalCode = $('#inpatientDrugDetailDiv').find('#detailHospitalCode').val();    	
  		var totalCostSum = $('#inpatientDrugDetailDiv').find('#totalCostSum').val();
        pageIndex = ($.isEmpty(pageIndex)?1:pageIndex);
        var searchObj = {
            url : "/da/daily/inpatientDrug/itemlist",
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



