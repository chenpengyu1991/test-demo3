var epIodineNutritionMonitorList = (function() {
	$(function() { 
		var selectSamplings = $("select[name='samplingId'] option");
		$("span[name='monitor_sampling']").each(function() {
			var samplingId = $(this).attr("samplingId");
			var option = selectSamplings.filter("[value='" + samplingId +"']");
			$(this).text(option.text());
		});
	});

	return {
		
	};
})();