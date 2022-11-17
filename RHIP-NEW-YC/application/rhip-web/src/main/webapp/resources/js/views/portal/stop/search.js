var stopSearch = (function() {

    $(function() {
    	//分页绑定函数
		pageUtil.bind("stopDoctor_records",recordsPerform);
        recordsPerform(1);
        $("#per_search_btn").click(function() {
            recordsPerform(1);
        });

        $("#form_search").onEnter(function() {
            recordsPerform(1);
        });
    });

    function recordsPerform(indexPage) {
        var searchObj = {
            url : "/portal/stop/records",
            insertDiv : "stopDoctor_records",
            param : {
                indexPage : indexPage
            }
        };
        $("#form_search").submitFormLoadHtml(searchObj);
    }

    function toggle(obj, tableId) {
        $(obj).toggleClass("ico-top");
        $(obj).toggleClass("ico-bottom");
        $("#" + tableId).toggle();
    }

    return {
        search : recordsPerform,
        toggle : toggle
    };
})();
