var tsSearch = (function() {
	$(function() { 
        search(1);
        $("#reportSearchForm").onEnter(search, 1);
	});

	function search(indexPage) {
        if($.isEmpty(indexPage)){
            indexPage = $.isEmpty($("#pageIndexI").val())?1:$("#pageIndexI").val();
        }
        $("#pageIndex").val(indexPage);
		var searchObj = {
			url : "/idm/frts/tsList",
			insertDiv : "caseResultDiv",
			param : {
				indexPage : indexPage
			}
		};
        $("#detailDiv").hide();
        $("#top_all").show();
		$("#reportSearchForm").submitFormLoadHtml(searchObj);
	};


	function toggle(obj,tableId) {
		$(obj).toggleClass("ico-top");
		$(obj).toggleClass("ico-bottom");
		$("#" + tableId).toggle();
	};

    function initTs(singleId, infectiousCode , logoff){
        $("#top_all").hide();
        $.loadHtmlByUrl({
            url : "/idm/frts/initTs",
            insertDiv :"detailDiv",
            param : {singleId:singleId,infectiousCode:infectiousCode,logoff:logoff}
        });
        $("#detailDiv").show();
    }

    function returnSearch(){
        var pageIndex = $("#pageIndex").val();
        $("#detailDiv").empty();
        pageIndex = ($.isEmpty(pageIndex)?1:pageIndex);
        if(contentChanged){
            msgUtil.backConfirm(function(){
                search(pageIndex);
            });
        }else{
            search(pageIndex);
        }
    };

	return {
        search : search,
        toggle:toggle,
        initTs:initTs,
        returnSearch:returnSearch
	};
})();

$(document).ready(function () { 
	//按钮样式切换 
	$("#reportBtnSearch").hover( 
		function () { 
		$(this).removeClass("search_btn").addClass("search_btn_h"); 
		}, 
		function () { 
		$(this).removeClass("search_btn_h").addClass("search_btn"); 
		} 
	); 
});
