var schlog = (function() {
	$(function() {
		searchLog(1);
	});
	/*审批日志查询*/
	function searchLog(pageIndex) {
        pageIndex = ($.isEmpty(pageIndex)?1:pageIndex);
        var idmId = $("#idmId").val();
		var searchObj = {
			url : "/idm/schistosome/approvallist",
			insertDiv : 'logResultDiv',
			param : {
				indexPage : pageIndex,
				idmId:idmId
			},
//			wait:true,
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