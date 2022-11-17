var serviceSearch = (function() {
	var validate=null;
    $(function() {
    	validate = $("#searchForm").easyValidate();
        $("#btnSearch").click(function() {
           search(1);
        });
        $("#btnSearch").onEnter(search, 1);
    });

    function search(pageIndex) {
		var result=validate.validateForm();
    	if(!result){
    		return;
    	}    	
        pageIndex = ($.isEmpty(pageIndex)?1:pageIndex);
        var searchObj = {
            url : "/ihm/childCare/serviceList",
            insertDiv : "baseInfoDiv",
            param : {
                indexPage : pageIndex
            },
            callback : function(data) {
            	$("#changePageIndex").val(pageIndex);
            }
        };
        $("#searchForm").submitFormLoadHtml(searchObj);
    };	
	return {
		search:search
	};
})();



