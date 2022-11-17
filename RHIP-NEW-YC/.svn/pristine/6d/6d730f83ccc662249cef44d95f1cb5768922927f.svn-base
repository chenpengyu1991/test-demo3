var roachMonitorSearch = (function() {
	$(function() { 
        /*蟑螂监测查询*/
        $("#roachBtnSearch").click(function() {
            search(1);
        });
        $("#initAdd").click(function() {
            initAdd();
        });

        search(1);
        $("#roachSearchForm").onEnter(search, 1);
		$("#reportBtn").click(function() {
			var param = {type: "roach"};
			baseLayoutLoad.pushMainContent("/dmbc/vertor/reportSearch", param);
		});
	});

	function search(indexPage) { 
		var searchObj = {
			url : "/dmbc/vertor/roachMonitor/list",
			insertDiv : "resultDiv",
			param : {
				indexPage : indexPage
			}
		};
		$("#roachSearchForm").submitFormLoadHtml(searchObj);
	};
	
	function initAdd(){
		$("#mainSearchDiv").hide();
		var option = {
				url : "/dmbc/vertor/initRoachMonitorAdd",
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
	$("#roachBtnSearch").hover( 
		function () { 
		$(this).removeClass("search_btn").addClass("search_btn_h"); 
		}, 
		function () { 
		$(this).removeClass("search_btn_h").addClass("search_btn"); 
		} 
	); 

});
