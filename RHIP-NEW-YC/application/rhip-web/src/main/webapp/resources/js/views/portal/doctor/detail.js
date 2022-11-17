define(['../doctor/search'],function(doctorSearch) {
	function load() {
		$(function() {
			$("#returnBtn").click(returnBtn);
		});
	}
	
	function returnBtn() {
		$("#detailDivDoctor").empty();
        $("#top_allDoctor").show();
		doctorSearch.searchDoctor(1);
	}
	
	return {
		load: load
	};
});
