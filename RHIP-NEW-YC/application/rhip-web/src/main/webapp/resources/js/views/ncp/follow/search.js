var ncpFollowSearch = (function() {
	$(function() {
        $("#form_search #groupClassification").multiselect({
            header : false,
            noneSelectedText : '请选择',
            selectedList : 4,
            minWidth : "auto"
        });
        $("#ncpbtnSearch").click(function(e) {
            e.preventDefault();
        	search(1,true);
        });

        search(1,true);
        $("#ncpbtnSearch").onEnter(search, {"indexPage":1,unQuickSearch:true});
        $("#ncpList").on("click", ".monitor-link,.reexam-link,.follow-link", monitorList);
        $("#ncpList").on("click",".view-link", viewlink);
        $("#health-card-search-toggle-btn").on("click", toggle);
        // 添加回车监听事件
        $('input').keypress(function(e) {
            var key = e.which;
            if (key == 13)
            {
                search(1,true);
            }
        });
	});

    /**
     * 查看管理卡信息
     */
    function viewlink(){
        viewlinkurl = "/ncp/healthManageCard/view/" + $(this).data("disid");
        /*var dialogObj = {
            id :"ncpViewManageCard",
            title:'管理卡信息',
            url :viewlinkurl,
            height : 654,
            width : 1000,
            param : {
                dialogId:"ncpViewManageCard"
            }
        };
        $.dialog(dialogObj);*/
        
        $.post(contextPath+viewlinkurl,
        		{ dialogId:"ncpViewManageCard"
			     }, 
			function(ret){
        	layui.use(['layer'], function() {
        		  var layer = layui.layer
        		  layer.open({
        			  type: 1,
        			  id:'ncpViewManageCardDialog',
        			  area: ['1000px', '654px'],
        			  title:'管理卡信息',
        			  content: ret
        		  });
        		});
        	});
    }

    function quickSearch(quicktype){debugger;
        $("#quicktype").val(quicktype);
        // indexPage = (isEmpty(indexPage)?$("#pageIndex").val():indexPage);
        var searchObj = {
            url: "/ncp/follow/list",
            insertDiv: "ncpList",
            param: {
                pageIndex: 1,
                quicktype:quicktype
            }
        };
        $("#form_search").submitFormLoadHtml(searchObj);
    }

	function search(indexPage,unQuickSearch) {debugger;
        indexPage = (isEmpty(indexPage)?$("#pageIndex").val():indexPage);
        if(unQuickSearch)
            $("#quicktype").val("");
        var qtype = $("#quicktype").val();
        var searchObj = {
            url: "/ncp/follow/list",
            insertDiv: "ncpList",
            param:
            {
                pageIndex: indexPage,
                quicktype:qtype
            }
        };
        $("#form_search").submitFormLoadHtml(searchObj);
	}

    function monitorList(event) {
        event.preventDefault();
        $("#ncpFollowPat").hide();
        $("#ncpFollowEdit").show();
        // var followupStatus = $("#followupStatus").val();
        var id = $(this).data("id");
        var type = $(this).data("type");
        var pid = $(this).data("pid");
        var loadHtmlByUrlOption = {
            url : "/ncp/follow/editFollow",
            insertDiv : "ncpFollowEdit",
            param : {
                id:id,
                type:type,
                pid:pid
            }
        };
        $.loadHtmlByUrl(loadHtmlByUrlOption);
    }

	function toggle() {
        $(this).toggleClass("ico-top");
        $(this).toggleClass("ico-bottom");
        $("#ncp-follow-search-table").toggle();
	}

	return {
        search : search,
        monitorList:monitorList,
        quickSearch:quickSearch
	}
})();
/*
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

});*/
