var infectMonitorSearch = (function() {
	$(function() {
		search(1);
		$("#initAdd").click(function() {
			infectMonitorList.viewOrEdit("", "edit");
		});
		$("#searchBtn").click(function() {
			search(1);
		});
		$("#infectMonitorSearchForm").onEnter(search, 1);
	});

	function search(indexPage) {
		if (indexPage == null) {
			indexPage = $("#indexPage").val();
		}
		var option = {
			url : "/dmbc/medicalInst/infectMonitor/list",
			insertDiv : "resultDiv",
			param : { indexPage : indexPage }
		};
		$("#infectMonitorSearchForm").submitFormLoadHtml(option);
	}

	return {
		search : search
	}
})();