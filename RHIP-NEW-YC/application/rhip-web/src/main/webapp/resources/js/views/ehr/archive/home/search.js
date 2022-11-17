var archiveSearch = (function() {
	$(function() {
		search(1);
		$("#archiveQueryForm").onEnter(search, 1);
	});

	function search(indexPage) {
		var searchObj = {
			url : contextPath + "/ehr/archive/home/list",
			insertDiv : "patientListDiv",
			param : {
				indexPage : indexPage
			}
		};
		$("#archiveQueryForm").formPost(searchObj);
	}
	;

	return {
		search : search
	};
})();