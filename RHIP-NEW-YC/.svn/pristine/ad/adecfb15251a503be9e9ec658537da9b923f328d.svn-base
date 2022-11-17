var listCdmManageAnalysis =(function()
{
	$(function() {

        /*高血压*/
        $("#tag1").on("click", function(event)
        {
            $("#tag").val("tag1");
            var selfObj = this;
            selectTag("tagContent1", selfObj);
            searchHbp();
        });
        /*糖尿病*/
        $("#tag2").on("click", function(event)
        {
            $("#tag").val("tag2");
            var selfObj = this;
            selectTag("tagContent2", selfObj);
            searchDi();
        });
        if($("#tag").val()!="tag2"){
            searchHbp();
        }

	 //添加回车监听事件
	 $('input').keypress(function (e) {
	     var key = e.which;
	     if (key == 13) {
	    	 search();
	     }
	 });
	    $("#search_btn").click(function(e) {
	    	e.preventDefault();
	        search();
	    });
	    
	    $("#cdm-manageanalysis-export").on("click", function(event) {
	    	event.preventDefault();
	    	$("#statistics_record_table").exportExcel();
	    });
	});
	
	 //查询列表
	function search() {
        var tag = $("#tag").val();
        var urlSub = tag == 'tag1'?'hbp':'di';
		var searchObj = {
			url : "/statistics/searchManageAnalysis/" + urlSub,
			insertDiv : "cdmManageAnalysisResultDiv"
		};
		$("#cdmManageAnalysisForm").submitFormLoadHtml(searchObj);
	}

    /*加载高血压*/
    function searchHbp() {
        $("#tag").val("tag1");
        $("#tagContent2").empty();
        var length = $('#tagContent1').has('form').length;
        if (length == 0){
            //参数
            var loadHtmlByUrlOption = {
                url : "/statistics/searchHbp",
                param : null,
                checkRepeat : true,
                insertDiv : "tagContent1"
            };
            $.loadHtmlByUrl(loadHtmlByUrlOption);
        }
    };

    /*加载糖尿病*/
    function searchDi() {
        $("#tag").val("tag2");
        $("#tagContent1").empty();
        var length = $('#tagContent2').has('form').length;
        if (length == 0){
            //参数
            var loadHtmlByUrlOption = {
                url : "/statistics/searchDi",
                param : null,
                checkRepeat : true,
                insertDiv : "tagContent2"
            };
            $.loadHtmlByUrl(loadHtmlByUrlOption);
        }
    };
	
	function toggle(obj,tableId) {
		$(obj).toggleClass("ico-top");
		$(obj).toggleClass("ico-bottom");
		$("#" + tableId).toggle();
	}
	
	return {
		search : search,
        searchDi : searchDi,
        searchHbp : searchHbp,
		toggle : toggle
	};
})();