var drugUseSearch = (function() {
    $(function() {
        init();
    });
    function init(){
        $("#drugUseBtnSearch").click(function(e) {
        	e.preventDefault();
        	searchDrugUse(1);
        });
        $("#drugUseSearch").onEnter(searchDrugUse, 1);
        searchDrugUse(1);
    }
	function searchDrugUse(pageIndex) {
        pageIndex = ($.isEmpty(pageIndex)?$("#pageIndex").val():pageIndex);
		var searchObj = {
			url : "/mhm/useDrug/drugUselist",
			insertDiv : 'drugUseResultDiv',
			param : {
                pageIndex : pageIndex
			},
//			wait:true,
            callback : function(data) {
            	$("#pageIndex").val(pageIndex);
            }
		};
		$("#drugUseSearchForm").submitFormLoadHtml(searchObj);
	};

	return {
		searchDrugUse:searchDrugUse
	};
})();



