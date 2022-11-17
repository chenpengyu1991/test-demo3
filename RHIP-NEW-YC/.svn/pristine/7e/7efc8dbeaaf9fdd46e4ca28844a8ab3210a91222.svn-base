define(function() {
	function load() {
	    $(function() {
	    	validate = $("#equipmentSearchForm").easyValidate();
	        $("#equipmentBtnSearch").click(function() {
	           search(1);
	        });
	    });
	}

    function search(pageIndex) {
		var result=validate.validateForm();
    	if(!result){
    		return;
    	}    	
        pageIndex = ($.isEmpty(pageIndex)?1:pageIndex);
        var searchObj = {
            url : "/ihm/equipment/query",
            insertDiv : "equipmentDiv",
            param : {
                indexPage : pageIndex
            },
            callback : function(data) {
            	$("#equipmentPageIndex").val(pageIndex);
            }
        };
        $("#equipmentSearchForm").submitFormLoadHtml(searchObj);
    };	
    
	return {
		load:load,
		search:search
	};
});



