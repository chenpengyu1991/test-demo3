var hmTargetSearch = (function() {
	$(function() { 
            $("#targetSearchForm").onEnter(search, 1);
            $("#targetBtnSearch").click(function() {
                search(1);
            });
            //search(1);
//            $("#beginTime").val(util.getNowDateFormate(new Date(),true));
//            $("#endTime").val(util.getNowDateFormate(new Date()));
	});

	function search(indexPage) { 
		var searchObj = {
			url : "/hm/hm/list",
			insertDiv : "targetDiv",
			param : {
				indexPage : indexPage
			}
		};
		$("#targetSearchForm").submitFormLoadHtml(searchObj);
	};
	return {
        search : search
	};
})();
