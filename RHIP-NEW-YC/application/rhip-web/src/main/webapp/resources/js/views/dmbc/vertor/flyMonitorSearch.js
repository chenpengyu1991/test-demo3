var flyMonitorSearch = (function() {
	$(function() { 
        /*苍蝇监测查询*/
        $("#flyBtnSearch").click(function() {
            search(1);
        });
        $("#initAdd").click(function() {
            initAdd();
        });

        search(1);
        $("#flySearchForm").onEnter(search, 1);
		$("#reportBtn").click(function() {
			var param = {type: "fly"};
			baseLayoutLoad.pushMainContent("/dmbc/vertor/reportSearch", param);
		});
	});

	function search(indexPage) { 
		var searchObj = {
			url : "/dmbc/vertor/flyMonitor/list",
			insertDiv : "resultDiv",
			param : {
				indexPage : indexPage
			}
		};
		$("#flySearchForm").submitFormLoadHtml(searchObj);
	};
	
	function initAdd(){
		$("#mainSearchDiv").hide();
		var option = {
				url : "/dmbc/vertor/initFlyMonitorAdd",
				insertDiv : "operationDiv"//,
//				param :{
//					operatorType:'3'
//				}
		};
		$.loadHtmlByUrl(option);
	}

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
	$("#flyBtnSearch").hover( 
		function () { 
		$(this).removeClass("search_btn").addClass("search_btn_h"); 
		}, 
		function () { 
		$(this).removeClass("search_btn_h").addClass("search_btn"); 
		} 
	); 

});
