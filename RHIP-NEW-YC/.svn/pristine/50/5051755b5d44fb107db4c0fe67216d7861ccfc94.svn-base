var staffSearch1 = (function() {
	function atStart() {
		//search(1);
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
        var html = $("#html").val();
        $("#selectedStaffTable").html(html);
	}
	function getOrgCode() {
		
		var organCode = $("#searchStation").val();
		if ($.isEmpty(organCode)) {
			organCode = $("#searchCenter").val();
		}
		return organCode;
	}

	function search(indexPage) {
		if($.isEmpty($("#searchOrganCode").val())) {
			layer.alert("请选择机构！", {icon:0,title:'提示'});
			return;
		}
		var searchObj = {
			url : "/sr/staffList",
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
