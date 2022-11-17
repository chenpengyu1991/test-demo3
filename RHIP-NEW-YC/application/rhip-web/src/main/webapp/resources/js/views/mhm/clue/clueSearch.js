var clueSearch = (function() {
    $(function() {
        $("#clueBtnSearch").click(function(e) {
        	e.preventDefault();
        	search(1);
        });
        $("#clueSearch").onEnter(search, 1);
        search(1);       
    });
    function search(pageIndex) {
        pageIndex = ($.isEmpty(pageIndex)?1:pageIndex);
        var searchObj = {
            url : "/mhm/clue/list",
            insertDiv : "clueResultDiv",
            param : {
                pageIndex : pageIndex
            },
//            wait:true,
            callback : function(data) {
            	$("#pageIndex").val(pageIndex);
            }
        };
        $("#clueSearchForm").submitFormLoadHtml(searchObj);
    };	


	function add(addType,statusId,logoff){
        var pageIndex = $("#currentPage").val();
        $("#top_all").hide();
        $.loadHtmlByUrl({
            url : "/mhm/clue/add",
            insertDiv :"clueDetailDiv",
            param : {pageIndex:pageIndex,addType:addType,statusId:statusId,logoff:logoff,notLoad:1}, // notLoad：加载css与js资源标记
            wait:true
        });
        $("#clueDetailDiv").show();
	}    
    function returnSearch(pageIndex){
        disableChangeConfirm();
        search();
        $("#clueDetailDiv").empty();
        $("#top_all").show();
    }
	return {
		add:add,
		search:search,
		returnSearch:returnSearch
	};
})();



