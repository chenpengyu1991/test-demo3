var sickbedUseStateSearch = (function() {
	$(function() {
        search(1);
		$("#sickbedUseStateBtnSearch").click(function(e) {
			e.preventDefault();
	        search(1);
	    });          
        $("#sickbedUseStateSearch").onEnter(search, 1);
    });
	function search(pageIndex) {
        pageIndex = ($.isEmpty(pageIndex)?1:pageIndex);
		var searchObj = {
			url : "/ihm/medical/sickbedUseState/list",
			insertDiv : 'resultDiv',
			param : {
                indexPage : pageIndex
			},
//			wait:true,
            callback : function(data) {
            	$("#pageIndex").val(pageIndex);
            }
		};
		$("#sickbedUseStateSearchForm").submitFormLoadHtml(searchObj);
	};

	return {
        search:search
	};
})();