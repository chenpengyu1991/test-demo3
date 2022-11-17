var clinicalPathwaySearch = (function() {
	$(function() {
        search(1);
		$("#clinicalPathwayBtnSearch").click(function(e) {
	        e.preventDefault();	
			search(1);
	        	
	    });        
        $("#clinicalPathwaySearch").onEnter(search, 1);
    });
	function search(pageIndex) {
        pageIndex = ($.isEmpty(pageIndex)?1:pageIndex);
		var searchObj = {
			url : "/ihm/medical/clinicalPathway/list",
			insertDiv : 'resultDiv',
			param : {
                indexPage : pageIndex
			},
//			wait:true,
            callback : function(data) {
            	$("#pageIndex").val(pageIndex);
            }
		};
		$("#clinicalPathwaySearchForm").submitFormLoadHtml(searchObj);
	};

	return {
        search:search
	};
})();