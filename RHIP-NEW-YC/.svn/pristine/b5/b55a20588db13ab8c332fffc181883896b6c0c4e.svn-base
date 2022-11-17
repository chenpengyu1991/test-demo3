var followUpConclusionSearch = (function() {
		$(function() {
			//分页绑定函数
			pageUtil.bind("listDiv",followUpConclusionResult);
			followUpConclusionResult(1);
			var id = $("#conclusionId").val();
			if (!$.isEmpty(id)) {
				$("#year").attr("disabled", true);
			}
		});
	function followUpConclusionResult(indexPage) {
		var searchObj = {
			url : "/cdm/highrisk/loadFollowUpConclusionResult",
			insertDiv : "followUpConclusionResult",
			param : {
				indexPage : indexPage
			}
		};
		$("#followUpConclusionForm").submitFormLoadHtml(searchObj);
	}
	return {
		load:load,
		followUpConclusionResult : followUpConclusionResult
	};
})();