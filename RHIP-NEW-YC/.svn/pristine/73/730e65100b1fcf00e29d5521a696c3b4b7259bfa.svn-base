var drugPrice = (function() {
	$(function() {
		search(1);
	});
	/*药品修改日志查询*/
	function search(pageIndex) {
        pageIndex = ($.isEmpty(pageIndex)?1:pageIndex);
        var drugId = $("#drugId").val();
		var searchObj = {
			url : "/mhm/drug/drugPriceList",
			insertDiv : 'drugPriceResultDiv',
			param : {
				pageIndex : pageIndex,
				drugId:drugId
			},
			wait:true,
            callback : function(data) {
                $("#pageIndex").val(pageIndex);
            }
		};
		$("#drugPriceSearchForm").submitFormLoadHtml(searchObj);
	};
	return {
		search:search
	};
})();