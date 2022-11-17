var suspected = (function() {
	$(function() {
		
		idmCommon.toggerAddress();
		idmCommon.displayPaAddress();
		idmCommon.displayHrAddress();
        toggleOtherSC('generalCondition.occupation','spanOccupationOther','CV020120299');

		search(1);
        $("#suspectedBtnSearch").click(function() {
            search(1);
        });
        $("#suspectedSearchForm").onEnter(search, 1);
        getNotCount();
	});
	
	function getNotCount() {
		$.getJsonByUrl({
			 url : "/idm/leprosy/count",
//             wait : true,
			 callback:function(data){
				 document.getElementById("notCount").innerText = data;
			 }
		});
	}
	function search(indexPage) { 
		var searchObj = {
				url : "/idm/leprosy/suspected/list",
				insertDiv : "listDivSuspected",
//                wait : true,
				param : {
					indexPage : indexPage
				}
			};
			$("#suspectedSearchForm").submitFormLoadHtml(searchObj);
	};
	
	function loadNotReportLeprosy() {
		var dialogObj = {
			url : "/idm/leprosy/initNotReport",
		    title : "待填麻风疑似报卡患者",
		    id: "notReportDia"
		};

		$.dialog(dialogObj);
	}
	
	function searchTemp(pageIndex){
		if($.isEmpty(pageIndex)) {
			 pageIndex = $("#pageIndex").val();
		}
		disableChangeConfirm();
		$("#detailDivSuspected").empty();
		pageIndex = ($.isEmpty(pageIndex)?1:pageIndex);
		search(pageIndex);
		$("#top_allSuspected").show();		
	}	
	
	return {
        search: search,
        searchTemp : searchTemp,
        loadNotReportLeprosy: loadNotReportLeprosy,
        getNotCount: getNotCount
	};
	
})();

$(document).ready(function () { 
	//按钮样式切换 
	$("#suspectedBtnSearch").hover( 
		function () { 
		$(this).removeClass("search_btn").addClass("search_btn_h"); 
		}, 
		function () { 
		$(this).removeClass("search_btn_h").addClass("search_btn"); 
		} 
	); 

});