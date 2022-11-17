var statistics = (function() {
	$(function() {
		search(1);
		 $("#statisticsBtn").click(function() {
	            search(1);
	        });
        $("#statisticsSearchForm").onEnter(search, 1);
	});

	function search(pageIndex) {
        var url = '/idm/leprosy/statistics/cc/list';
        if($.isEmpty(document.getElementById('contactStatisticsPage').innerHTML)){
        	url = "/idm/leprosy/statistics/fr/list";
        }
        if($.isEmpty(document.getElementById('followupStatisticsPage').innerHTML)){
        	 url = "/idm/leprosy/statistics/cc/list";
        }
		var searchObj = {
				url : url,
				insertDiv : "resultListDivPage",
//                wait : true,
				param : {
                    pageIndex : pageIndex
				},
            callback: function(){sameTag = 1;}
			};
			$("#statisticsSearchForm").submitFormLoadHtml(searchObj);
	};

    function downLoad(){
        var url = '/downCcExcel';
        if($.isEmpty(document.getElementById('contactStatisticsPage').innerHTML)){
        	url = "/downFrExcel";
        }
        if($.isEmpty(document.getElementById('followupStatisticsPage').innerHTML)){
        	 url = "/downCcExcel";
        }
        location.href = contextPath + "/idm/leprosy/statistics"+url+"?" + $('#statisticsSearchForm').formSerialize();
    }
	
	return {
        search : search,
        selectTag : selectTag,
        downLoad : downLoad
	};
})();
