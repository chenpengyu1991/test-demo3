var statisticsByMonthJS = (function(){
	$(function(){
		searchStatistics(1);
		$("#search_btn").on("click", function(){
			searchStatistics(1);
		});
		
		$("#statisticsByMonthForm").onEnter(function(){
			searchStatistics(1);
		});
	});
	
	function searchStatistics(indexPage){
		$("#statisticsByMonthForm").submitFormLoadHtml({
            url : "/statisByMonth/result",
            insertDiv:"statisticsResultDiv",
            param:{
                indexPage: indexPage
            }
        });
	}
	
	function toggle(obj,tableId) {
		$(obj).toggleClass("ico-top");
		$(obj).toggleClass("ico-bottom");
		$("#" + tableId).toggle();
	}
	
	return {
		toggle : toggle
	};
})();