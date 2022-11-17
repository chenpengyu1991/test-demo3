var mosquitoesMonitorSearch = (function() {
	$(function() { 
            /*成蚊监测查询*/
            $("#mosquitoesBtnSearch").click(function() {
                search(1);
            });
            $("#initAdd").click(function() {
            	initAdd();
            });
            
            search(1);
            $("#mosquitoesSearchForm").onEnter(search, 1);
            $("#reportBtn").click(function() {
	            var param = {type: "mosquitoes"};
	            baseLayoutLoad.pushMainContent("/dmbc/vertor/reportSearch", param);
            });
	});

	function search(indexPage) { 
		var searchObj = {
			url : "/dmbc/vertor/mosquitoesMonitor/list",
			insertDiv : "resultDiv",
			param : {
				indexPage : indexPage
			}
		};
		$("#mosquitoesSearchForm").submitFormLoadHtml(searchObj);
	};
	
	function initAdd(){
		$("#mainSearchDiv").hide();
		var option = {
				url : "/dmbc/vertor/initMosquitoesMonitorAdd",
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
	$("#mosquitoesBtnSearch").hover( 
		function () { 
		$(this).removeClass("search_btn").addClass("search_btn_h"); 
		}, 
		function () { 
		$(this).removeClass("search_btn_h").addClass("search_btn"); 
		} 
	); 

});
