var progressSearch = (function() {
	$(function() { 
            /*体检进度查询*/
            $("#progressBtnSearch").onEnter(search, 1);
            $("#progressBtnSearch").click(function() {
                search(1);
            });
            search(1);
	});

	function search(pageIndex) { 
		pageIndex = ($.isEmpty(pageIndex)?1:pageIndex);
		var searchObj = {
			url : "/hm/studentExam/progress/list",
			insertDiv : "progressResultDiv",
			param : {
				indexPage : pageIndex
			},
            callback : function(data) {
            	$("#pageIndex").val(pageIndex);
            }
		};
		$("#progressSearchForm").submitFormLoadHtml(searchObj);
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
	$("#progressBtnSearch").hover( 
	function () { 
	$(this).removeClass("search_btn").addClass("search_btn_h"); 
	}, 
	function () { 
	$(this).removeClass("search_btn_h").addClass("search_btn"); 
	} 
	); 

	});