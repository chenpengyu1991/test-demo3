var staffSearch1 = (function() {
	function atStart() {
		search(1);
		$("#searchCondition").onEnter(search, 1);
		$("#searchButton").click(function() {
			search(1);
		});
		$("#searchTown").change(function() {
			$("#searchOrganCode").val("");
		});
		
		$("#searchCenter").change(function() {
			var organCode = getOrgCode();
			$("#searchOrganCode").val(organCode);
		});
		$("#searchStation").change(function() {
			var organCode = getOrgCode();
			$("#searchOrganCode").val(organCode);
		});
	}
	function getOrgCode() {
		var organCode = $("#searchStation").val();
		if ($.isEmpty(organCode)) {
			organCode = $("#searchCenter").val();
		}
		return organCode;
	}

	function search(indexPage) {
		var searchObj = {
			url : "/ce/staffList",
			insertDiv : "resultDiv",
			param : {
				indexPage : indexPage
			}
		};
		$("#searchCondition").submitFormLoadHtml(searchObj);
	}

	return {
		atStart : atStart,
		search : search
	};
})();
