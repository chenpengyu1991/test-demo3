var adminOrgIndex = (function() {
    $(function() {
        var currentYear = $('#currentYear').val();
        $("#tag").val("tag" + currentYear);
        $("[id^='taga']").on("click", function(event)
        {
        	clearContent();//加载之前先清理tabs中的内容，解决冲突问题
            var year = $(this).data('year');
            var tabContentId = $(this).attr("tab-content-id");
            /*selectTag("tagContent1", this);*/
            yearIndex(year, tabContentId);
        });
        ///*前1年*/
        //$("#tag2").on("click", function(event)
        //{
        //   $("#tag").val("tag2");
        //   var selfObj = this;
        //   selectTag("tagContent2", selfObj);
        //   preYearIndex();
        //});
        var tabContentId = $(".layui-this").children(":first").attr("tab-content-id");
        yearIndex(currentYear, tabContentId);
    });

    /*加载当前年*/
    function yearIndex(year, tabContentId) {
    	debugger;
        //参数
        var loadHtmlByUrlOption = {
            url : "/administrative/tabIndex",
            param : {selectYear:year},
            checkRepeat : true,
            insertDiv : tabContentId
        };
        $.loadHtmlByUrl(loadHtmlByUrlOption);
    };
    ///*加载前1年*/
    //function preYearIndex() {
    //   $("#tagContent1").empty();
    //	var length = $('#tagContent2').has('form').length;
    //	if (length == 0){
    //		//参数
    //		var loadHtmlByUrlOption = {
    //			url : "/administrative/tabIndex",
    //			param : null,
    //			checkRepeat : true,
    //			insertDiv : "tagContent2"
    //		};
    //		$.loadHtmlByUrl(loadHtmlByUrlOption);
    //	}
    //};
    function toggle(obj,tableId) {
        $(obj).toggleClass("ico-top");
        $(obj).toggleClass("ico-bottom");
        $("#" + tableId).toggle();
    };
    
    function clearContent() {
    	$("div[id^='tagContent-']").each(function() {
    		$(this).html("");
    		/*var divId = $(this).attr("id");
    		alert(divId);
    		$("#"+divId).html("");*/
    	})
    }
    
    return {
        toggle:toggle,
        yearIndex:yearIndex
    };
})();