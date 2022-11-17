var drugUseSearch = (function() {
    $(function() {
        init();
    });
    function init(){
        $("#drugUseBtnSearch").click(function(e) {
        	e.preventDefault();
        	searchDrugUse(1);
        });
        $("#drugUseSearch").onEnter(searchDrugUse, 1);
        searchDrugUse(1);
    }
	function searchDrugUse(pageIndex) {
        pageIndex = ($.isEmpty(pageIndex)?$("#pageIndex").val():pageIndex);
		var searchObj = {
			url : "/mhm/useDrug/list",
			insertDiv : 'drugUseResultDiv',
			param : {
                pageIndex : pageIndex
			},
//			wait:true,
            callback : function(data) {
            	$("#pageIndex").val(pageIndex);
            }
		};
		$("#drugUseSearchForm").submitFormLoadHtml(searchObj);
	};
    function editDrugUse(statusId){
        $("#drugUse_top_all").hide();
        $.loadHtmlByUrl({
            url : "/mhm/useDrug/edit",
            param:{statusId:statusId},
//            wait:true,
            insertDiv :"drugUseDetailDiv",
            callback : function(data) {
            	searchDrugList();
            }            
        });
        $("#drugUseResultDiv").show();
    }
	function searchDrugList(pageIndex) {
		var statusId = $('#statusId').val();
        pageIndex = ($.isEmpty(pageIndex)?$("#drugUsePageIndex").val():pageIndex);
		var searchObj = {
			url : "/mhm/useDrug/drugList",
			insertDiv : 'drugList',
			param : {
                pageIndex : pageIndex,statusId:statusId
			},
//			wait:true,
            callback : function(data) {
            	$("#drugUsePageIndex").val(pageIndex);
            }
		};
		$("#drugListForm").submitFormLoadHtml(searchObj);
	};   
	return {
        searchDrugUse:searchDrugUse,
        editDrugUse:editDrugUse,
        searchDrugList:searchDrugList
	};
})();



