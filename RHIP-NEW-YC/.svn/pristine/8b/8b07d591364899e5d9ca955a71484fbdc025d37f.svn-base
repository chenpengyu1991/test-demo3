var prescriptionIndex = (function() {
	$(function() {/*
		$("#tag1").on("click", function(event)
		{
			selectTagl("tagContent1", this);
			prescriptionCost();
		});
		$("#tag2").on("click", function(event)
		{
			selectTagl("tagContent1", this);
			unusualSearch();
		});
	*/
		prescriptionCost();
		
	});
	/*处方费用*/
	function prescriptionCost() {
		//参数
		var loadHtmlByUrlOption = {
			url : "/ihm/prescription/prescriptionCost/index",
			param : {},
			checkRepeat : true,
			insertDiv : "prescriptionCostDiv"
		};
		$.loadHtmlByUrl(loadHtmlByUrlOption);
	};


	function unusualSearch() {
		//参数
		var loadHtmlByUrlOption = {
			url : "/da/daily/unusual/search",
			param : {},
			checkRepeat : true,
			insertDiv : "prescriptionMonitorDiv"
		};
		$.loadHtmlByUrl(loadHtmlByUrlOption);
	}
	function toggle(obj,tableId) {
		$(obj).toggleClass("ico-top");
		$(obj).toggleClass("ico-bottom");
		$("#" + tableId).toggle();
	};	
	return {
		prescriptionCost : prescriptionCost,
		unusualSearch : unusualSearch,
		toggle:toggle
	};
})();