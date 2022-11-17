var approval = (function() {
	$(function() {
		search(1);
	});
	/*审批日志查询*/
	function search(pageIndex) {
        pageIndex = ($.isEmpty(pageIndex)?1:pageIndex);
        var statusId = $("#statusId").val();
		var searchObj = {
			url : "/mhm/clue/approvallist",
			insertDiv : 'approvalResultDiv',
			param : {
				pageIndex : pageIndex,
				statusId:statusId
			},
			wait:true,
            callback : function(data) {
                $("#pageIndex").val(pageIndex);
            }
		};
		$("#approvalSearchForm").submitFormLoadHtml(searchObj);
	};
	return {
		search:search
	};
})();