var approvalLog = (function() {
	$(function() {
		searchLog(1);
	});
	/*审批日志查询*/
	function searchLog(pageIndex) {
        pageIndex = ($.isEmpty(pageIndex)?1:pageIndex);
        var idmId = $("#idmId").val();
		var searchObj = {
			url : "/idm/report/approvallist",
			insertDiv : 'logResultDiv',
//			wait:true,
			param : {
				indexPage : pageIndex,
				idmId:idmId
			},
            callback : function(data) {
                $("#pageIndex").val(pageIndex);
            }
		};
		$("#logSearchForm").submitFormLoadHtml(searchObj);
	};
	return {
		searchLog:searchLog
	};
})();