var disinfectionMonitorSearch = (function() {
	$(function() { 
            /*消毒质量监测查询*/
            $("#disinfectionMonitorBtnSearch").click(function() {
                search(1);
            });
            $("#initAdd").click(function() {
            	initAdd();
            });
            
            search(1);
            $("#disinfectionMonitorSearchForm").onEnter(search, 1);
            
            //$("#context").change(selContextChanged);
            //util.checkBoxAll("reportChk","reportChkRef");
	});

	function search(indexPage) { 
		var searchObj = {
			url : "/dmbc/medicalInst/disinfectionMonitor/list",
			insertDiv : "resultDiv",
			param : {
				indexPage : indexPage
			}
		};
		$("#disinfectionMonitorSearchForm").submitFormLoadHtml(searchObj);
	};
	
	function initAdd(){
		$("#mainSearchDiv").hide();
		var option = {
				url : "/dmbc/medicalInst/initDisinfectionMonitorAdd",
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
	$("#disinfectionRsBtnSearch").hover( 
		function () { 
		$(this).removeClass("search_btn").addClass("search_btn_h"); 
		}, 
		function () { 
		$(this).removeClass("search_btn_h").addClass("search_btn"); 
		} 
	); 

});
