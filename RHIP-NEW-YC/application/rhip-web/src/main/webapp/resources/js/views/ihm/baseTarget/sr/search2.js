var srSearch = (function() {
	$(function() {
		pageUtil.bind("listDiv",search);
		$("#searchForm").onEnter(search, 1);
		$("#searchBtn").click(function(e) {
			e.preventDefault();
			search(1);
		});
		search(1);
		$("#addBtn").click(function(e) {
			e.preventDefault();
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
			url : "/ihm/sr/list",
			insertDiv : "listDiv",
			param : {
                pageIndex : pageIndex,
                idCard : $("#idCardForSr").val(),
                type : $("#onlyViewForSr").val()
			},
            callback : function(data) {
                $("#top_all").show();
                $("#pageIndex").val(pageIndex);
                $("a[id^='sr']").each(function(){
					  $(this).click(function() {
						  loadDetailDialog($(this).attr('data-id'));
					  });
					});
            }
		};
		$("#searchForm").submitFormLoadHtml(searchOption);
	};


	function loadDetailDialog(id){
		/*var detail = {
				url : "/ihm/sr/view",
				id : "detailDialog",
				height : 600,
				weight : 30,
				width : 800,
				title : "科研著作查看",
				param : {id:id}
		};
		$.dialog(detail);*/
		
		$.post(contextPath+"/ihm/sr/view",{id:id}, function(ret){
			layer.open({
				  type: 1,
				  id:'detailDialog',
				  area: ['850px', '650px'],
				  title:"科研著作查看",
				  content: ret
			  });
        	});
	};
	
	function view(id) {
        $("#top_all").hide();
        $.loadHtmlByUrl({
            url : "/ihm/sr/view",
            insertDiv :"detailDiv",
            param : {id:id}
        });
        $("#detailDiv").show();
	};	
	return {
		search : search,
        view : view,
        loadDetailDialog:loadDetailDialog
	};
})();