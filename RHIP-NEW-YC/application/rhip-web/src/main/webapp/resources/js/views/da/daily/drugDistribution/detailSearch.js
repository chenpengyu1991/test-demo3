var disDetailSearch = (function() {
	var validate=null;
    $(function() {
    	validate = $("#detailSearchForm").easyValidate();
        $("#detailBtnSearch").click(function(e) {
            e.preventDefault();
           search(1);
        });
        $("#detailBtnSearch").onEnter(search, 1);
        search(1); 
    });
    function search(pageIndex) {
		var result=validate.validateForm();
    	if(!result){
    		return;
    	}    	
        pageIndex = ($.isEmpty(pageIndex)?1:pageIndex);
        var organCode = $('#organCode').val();
    	var medicareCode = $('#medicareCode').val();
    	var beginDt = $('#beginDt').val();
    	var endDt = $('#endDt').val();
    	var type = $('#type').val();
    	
        var searchObj = {
            url : "/da/daily/drugDistribution/detailList",
            insertDiv : "detailResultDiv",
            param : {
                pageIndex : pageIndex,
                hospitalCode : organCode,
                medicareCode : medicareCode,
                beginDt : beginDt,
                endDt : endDt,
                type : type
            },
            callback : function(data) {
            	$("#itemPageIndex").val(pageIndex);
            }
        };
        $("#detailSearchForm").submitFormLoadHtml(searchObj);
    };
	return {
		search:search
	};
})();



