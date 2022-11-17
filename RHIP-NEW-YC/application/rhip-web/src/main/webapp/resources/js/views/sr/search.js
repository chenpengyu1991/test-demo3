var srSearch = (function() {
	$(function() {
		$("#searchForm").onEnter(search, 1);
		$("#searchBtn").click(function() {
			search(1);
		});
		search(1);
		$("#addBtn").click(function() {
			initSrEdit();
		});

	});

	function search(pageIndex) {
        $("#detailDiv").hide();
		if (pageIndex == null) {
            pageIndex = $("#pageIndex").val();
		}
        var belongOrgan = '';
        var belongStation = $("#sStation").val();
        var belongCenter = $("#sCenter").val();
        var belongTown = $("#sTown").val();
        if (!$.isEmpty(belongStation)) {
            belongOrgan = belongStation;
        } else if (!$.isEmpty(belongCenter)) {
            belongOrgan = belongCenter;
        } else {
            belongOrgan = belongTown;
        }
        $("#belongOrg").val(belongOrgan);
		var searchOption = {
			url : "/sr/list",
			insertDiv : "listDiv",
			param : {
                pageIndex : pageIndex,
                idCard : $("#idCardForSr").val(),
                type : $("#onlyViewForSr").val()
			},
            callback : function(data) {
                $("#top_all").show();
                $("#pageIndex").val(pageIndex);
            }
		}
		$("#searchForm").submitFormLoadHtml(searchOption);
	}

    function initSrEdit(id){
        $("#top_all").hide();
        var pageIndex = $("#currentPage").val();
        $.loadHtmlByUrl({
            url : "/sr/initSrEdit",
            insertDiv :"detailDiv",
            param : {id:id}
        });
        $("#detailDiv").show();
    };

	function del(id) {
		layui.use('layer', function(){
        	var layer = layui.layer;
        	layer.confirm('是否删除该记录？', {icon:2, title:'确认提示'}, function(index){
        		var option = {
    				url : "/sr/delete",
    				param : {
    					id : id
    				},
    				callback : (function(result) {
    					layer.alert(result.message, {icon:0,title:'提示'});
    					if (result.success) {
    						search();
    					}
    				})
    			};
    			$.getJsonByUrl(option);
        		layer.close(index);
        	});
        });
	}

	function view(id) {
        $("#top_all").hide();
        var pageIndex = $("#currentPage").val();
        $.loadHtmlByUrl({
            url : "/sr/view",
            insertDiv :"detailDiv",
            param : {id:id}
        });
        $("#detailDiv").show();
	}

    function edit(id) {
        $("#top_all").hide();
        var pageIndex = $("#currentPage").val();
        $.loadHtmlByUrl({
            url : "/sr/initSrEdit",
            insertDiv :"detailDiv",
            param : {id:id}
        });
        $("#detailDiv").show();
    }

	return {
		search : search,
        initSrEdit : initSrEdit,
		del : del,
        view : view,
        edit : edit
	}
})();