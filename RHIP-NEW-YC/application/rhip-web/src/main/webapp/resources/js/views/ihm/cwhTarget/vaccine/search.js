var vaccineSearch = (function() {
	var validate=null;
	$(function() {
    	validate = $("#vaccineSearchForm").easyValidate();
    	$("#vaccineSearchForm").onEnter(vaccineSearch, 1);
        $("#vaccineBtnSearch").click(function() {
        	vaccineSearch(1);
        });
    });
	
    function vaccineSearch(pageIndex) {
    	var result=validate.validateForm();
    	if(!result){
    		return;
    	}    	
        pageIndex = ($.isEmpty(pageIndex)?1:pageIndex);
        var searchObj = {
            url : $("#queryPath").val(),
            insertDiv : "vaccineDiv",
            param : {
                indexPage : pageIndex
            },
            callback : function(data) {
            	$("#vaccinePageIndex").val(pageIndex);
            }
        };
        $("#vaccineSearchForm").submitFormLoadHtml(searchObj);
    };
    
    function loadDetailDialog(url, title, height, width){
		var detail = {
				url : url,
				id : "detailDialog",
				height : height,
				weight : 30,
				width : width,
				title : title
		};
		$.dialog(detail);
	};
	
	return {
		vaccineSearch:vaccineSearch,
		loadDetailDialog:loadDetailDialog
	};
})();



