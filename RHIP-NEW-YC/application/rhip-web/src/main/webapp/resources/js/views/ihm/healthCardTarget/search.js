var healthCardSearch = (function() {
	$(function() { 
        $("#searchForm").onEnter(search, 1);
        $("#btnSearch").click(function(e) {
            e.preventDefault();
            search(1);
        });
    });
	
	function search(indexPage) {
		var searchObj = {
			url : "/ihm/healthCard/search",
			insertDiv : "resultDiv",
			param : {
				indexPage : indexPage
			}
		};
		$("#searchForm").submitFormLoadHtml(searchObj);
	};
	
    function detail(id){
        $.post(contextPath+"/ihm/healthCard/detail", {"id":id}, function(ret){
            layer.open({
                type: 1,
                id:'dialog',
                area: ['880px', '500px'],
                title:"居民健康卡",
                content: ret
            });
        });
    };

    function history(paperType, paperNo, indexPage){
        $.post(
            contextPath+'/ihm/healthCard/history',
            {
                paperNo:paperNo,
                paperType:paperType,
                indexPage : indexPage
            },
            function(ret){
                layui.use(['layer'], function() {
                    var layer = layui.layer
                    layer.open({
                        type: 1,
                        id:'cardHistoryDialog',
                        area: ['850px', '550px'],
                        title:'居民健康卡变更历史',
                        content: ret
                    });
                });
            }
        );
    };

    function searchHistory(indexPage) {
        var paperType = $("#paperType").val();
        var paperNo = $("#paperNo").val();
        var searchObj = {
            url : "/ihm/healthCard/history",
            insertDiv : "historyDiv",
            param : {
                paperNo : paperNo,
                paperType : paperType,
                indexPage : indexPage
            }
        };
        $("#searchForm").submitFormLoadHtml(searchObj);
    };
    
	return {
		search : search,
		detail : detail,
        history : history,
        searchHistory : searchHistory
	};
})();
