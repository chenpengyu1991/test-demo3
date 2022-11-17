var financeSearch = (function() {
	$(function() {
		$("#searchForm").onEnter(search, 1);
		$("#searchBtn").click(function(e) {
			e.preventDefault();
			search();
		});
		search();
		$("#addBtn").click(function(e) {
			e.preventDefault();
            initAdd();
		});

	});

	function search() {
		 var validate = $("#searchForm").easyValidate();
	        if (!validate.validateForm()) {
	            return;
	        }
        $("#detailDiv").hide();
        var url = $("#searchUrl").val();
        
		var searchOption = {
			url : url,
			insertDiv : "listDiv",
            callback : function(data) {
                $("#top_all").show();
            }
		}
		$("#searchForm").submitFormLoadHtml(searchOption);
	}

    function initAdd(){
        var type = $("#type").val();
        $("#top_all").hide();
        var pageIndex = $("#currentPage").val();
        $.loadHtmlByUrl({
            url : "/finance/initAdd" + type,
            insertDiv :"detailDiv"
        });
        $("#detailDiv").show();
    };

	function del(id) {
		var index = layer.confirm("是否删除该记录？", {icon:2, title:'确认提示'}, function() {
			var option = {
				url : "/sr/delete",
				param : {
					id : id
				},
				callback : (function(result) {
					layui.use('layer', function() {
						var layer = layui.layer;
						layer.alert(result.message, {icon:0,title:'提示'});
					});
					if (result.success) {
						search();
					}
				})
			};
			$.getJsonByUrl(option);
			layer.close(index);
		});
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
        initAdd : initAdd,
		del : del,
        edit : edit
	}
})();