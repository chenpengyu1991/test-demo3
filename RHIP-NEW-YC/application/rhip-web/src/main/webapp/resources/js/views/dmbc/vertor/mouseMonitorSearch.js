var mouseMonitorSearch = (function() {
	$(function() { 
        /*鼠密度查询*/
        $("#mouseBtnSearch").click(function() {
            search(1);
        });
        $("#initAdd").click(function() {
            initAdd();
        });

        search(1);
        $("#mouseSearchForm").onEnter(search, 1);
		$("#reportBtn").click(function() {
			var param = {type: "mouse"};
			baseLayoutLoad.pushMainContent("/dmbc/vertor/reportSearch", param);
		});
	});

	function search(indexPage) { 
		var searchObj = {
			url : "/dmbc/vertor/mouseMonitor/list",
			insertDiv : "resultDiv",
			param : {
				indexPage : indexPage
			}
		};
		$("#mouseSearchForm").submitFormLoadHtml(searchObj);
	};
	
	function initAdd(){
		$("#mainSearchDiv").hide();
		var option = {
				url : "/dmbc/vertor/initMouseMonitorAdd",
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
	$("#mouseBtnSearch").hover( 
		function () { 
		$(this).removeClass("search_btn").addClass("search_btn_h"); 
		}, 
		function () { 
		$(this).removeClass("search_btn_h").addClass("search_btn"); 
		} 
	); 

});
