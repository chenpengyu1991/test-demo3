var caseLeprosy = (function() {
	$(function() {
		
		idmCommon.toggerAddress();
		idmCommon.displayPaAddress();
		
		search(1);
        $("#caseBtnSearch").click(function() {
            search(1);
        });
        
        $("#caseSearchForm").onEnter(search, 1);
	});
	
	function search(indexPage) { 
		var searchObj = {
				url : "/idm/leprosy/case/list",
				insertDiv : "listDivCase",
//                wait : true,
				param : {
					indexPage : indexPage
				}
			};
		$("#caseSearchForm").submitFormLoadHtml(searchObj);
	};
	
	function searchTemp(pageIndex){
		if($.isEmpty(pageIndex)) {
			 pageIndex = $("#pageIndex").val();
		}
		disableChangeConfirm();
		$("#detailDivCase").empty();
		pageIndex = ($.isEmpty(pageIndex)?1:pageIndex);
		search(pageIndex);
		$("#top_allCase").show();		
	}	
	
	function isShow(){
		var infectionSource = $("input[name='epidemicFocusClose.infectionSource']:checked").val();
		if(infectionSource == '1') {
			$("#jianei").show();
			$("#jiawai").hide();
		} else if(infectionSource == '2') {
			$("#jianei").hide();
			$("#jiawai").show();
		} else {
			$("#jianei").hide();
			$("#jiawai").hide();
		}
	}
	function isShowFungus() {
		var fungusCondition = $("input[name='labExamine.fungusCondition']:checked").val();
		if(fungusCondition == '1') {
			$("#bi").show();
			$("#unCheckResult").hide();
			$("input[name='labExamine.unCheckResult']").val('');
		}else if (fungusCondition == '3') {
			$("#bi").hide();
			$("#unCheckResult").show();
			$("input[name='labExamine.bi']").val('');
		} else {
			$("#bi").hide();
			$("#unCheckResult").hide();
			$("input[name='labExamine.unCheckResult']").val('');
			$("input[name='labExamine.bi']").val('');
		}
	}
	return {
        search: search,
        searchTemp : searchTemp,
        isShowFungus:isShowFungus,
        isShow: isShow
	};
	
})();

$(document).ready(function () { 
	//按钮样式切换 
	$("#caseBtnSearch").hover( 
		function () { 
		$(this).removeClass("search_btn").addClass("search_btn_h"); 
		}, 
		function () { 
		$(this).removeClass("search_btn_h").addClass("search_btn"); 
		} 
	); 

});