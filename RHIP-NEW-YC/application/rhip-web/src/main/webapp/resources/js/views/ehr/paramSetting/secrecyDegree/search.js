var secrecyDegreeSearch = (function() {
    $(function() {
    	$("#searchForm").onEnter(search, 1);
        $("#btnSearch").click(function(e) {
            e.preventDefault();
           search(1);
        });

        $("#btnAdd").click(function(e) {
            e.preventDefault();
            initAdd();
        });

        $("#btnSearch").onEnter(search, 1);
        search(1);
    });

    function search(pageIndex) {
        $("#messageDiv").remove();
        $("#top_all").show();
        $("#detailDiv").hide();
        pageIndex = ($.isEmpty(pageIndex)?1:pageIndex);
        var personal = $("#personal").val();
        var searchObj = {
            url : '/ehrbrowser/service/secrecyDegree/list',
            insertDiv : "resultDiv",
            param : {
                pageIndex : pageIndex,
                personal : personal
            },
            callback : function(data) {
            	$("#pageIndex").val(pageIndex);
            }
        };
        $("#searchForm").submitFormLoadHtml(searchObj);
    };

    function initAdd(id) {
        $.post(contextPath+'/ehrbrowser/service/secrecyDegree/initAdd',
            { id : id},
            function(ret){
                layui.use(['layer'], function() {
                    var layer = layui.layer
                    layer.open({
                        type: 1,
                        id:'d1',
                        area: ['500px', '380px'],
                        title:'传染病保密等级设置',
                        content: ret
                    });
                });
            });
    }

    function edit(id){
        var personal = $("#personal").val();
//        var dialog = {
//            url : "/msg/view",
//            param : {id:id, personal:personal},
//            height : 380,
//            width : 750,
//            title : "消息" ,
//            id :"dialog"
//        };
//        $.dialog(dialog);
        $("#top_all").hide();
        $.loadHtmlByUrl({
            url : "/msg/view",
            param : {id:id, personal:personal},
            insertDiv :"detailDiv"
        });
        $("#detailDiv").show();
    }

    function toggle(obj, tableId) {
        $(obj).toggleClass("ico-top");
        $(obj).toggleClass("ico-bottom");
        $("#" + tableId).toggle();
    }

	return {
		search:search,
        initAdd:initAdd,
        edit:edit,
        toggle:toggle
	};
})();



