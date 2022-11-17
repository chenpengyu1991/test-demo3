var statisticsMain= (function() {
	$(function() {
		//
		$("#star_statistics_btn").on("click", function(event){
			selectTag("tagContent0",this);
		});
		//
		$("#record_statistics_btn").on("click", function(event){
			selectTag("tagContent1",this);
			if (!$("#record_statistics_btn").hasClass("loaded")) {
				getOrgRecordResult();
			}
		});
		//条件切换
		$("#time_range_con").on("click","input",function(event){
			$(".time_range_targets").hide();
			var idVal=$(this).attr("id");
			var targetIdVal=idVal.replace("_btn","_target");
			$("#"+targetIdVal).show();
		});
		//执行搜索
		$("#star_statistics_search_btn").on("click",function(event){
			 $("#star_statistics_from").submitFormLoadHtml({
				 url : contextPath+"/star/statistics/sqzx/result",
		         insertDiv:"star_statistics_con"
			 });
		});
		
		$("#record_statistics_search_btn").on("click", function(event) {
			getOrgRecordResult();
		});
	});
	
	function getOrgRecordResult() {
		$("#record_statistics_from").submitFormLoadHtml({
			url : contextPath + "/record/orgstatistics/result",
			insertDiv : "record_statistics_con"
		});
		$("#record_statistics_btn").addClass("loaded");
	}
})();