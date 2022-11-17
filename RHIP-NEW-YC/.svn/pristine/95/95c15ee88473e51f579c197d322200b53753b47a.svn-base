var emcSearch = (function() {
	$(function() {
        $("#quBtnSearch").click(function(e) {
            e.preventDefault();
        	search(1);
        });
       // search(1);
        $("#quBtnSearch").onEnter(search, 1);
	});

	function search(indexPage) {
        if($.isEmpty($("#personName").val()) && $.isEmpty($("#idcard").val())) {
        	layui.use('layer', function(){
    			var layer = layui.layer;
    			layer.alert("查询条件中姓名和身份证号码必须填其中一个！", {icon:0,title:'提示'});
    		});
            return;
        }
        $("#diseaseInfo").empty();
        indexPage = (isEmpty(indexPage)?$("#pageIndex").val():indexPage);
        var searchObj = {
            url: "/idm/ncp/emc/list",
            insertDiv: "diseaseInfo",
            param: {
                indexPage: indexPage
            }
        };
        $("#form_search").submitFormLoadHtml(searchObj);
	};

	function toggle(obj,tableId) {
		$(obj).toggleClass("ico-top");
		$(obj).toggleClass("ico-bottom");
		$("#" + tableId).toggle();
	};

	return {
        search : search,
        toggle:toggle
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
