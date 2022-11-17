var mcSearch = (function() {
	var url="/hm/mc/healthRecordList";
	$(function() { 
            /*统计查询*/
            $("#statisticsBtnSearch").click(function() {
                search(1);
            });
            search(1);
            $("#statisticsBtnSearch").onEnter(search, 1);
            document.onkeydown = function (e) { 
            	var theEvent = window.event || e; 
            	var code = theEvent.keyCode || theEvent.which; 
            	if (code == 13) { 
            		search(1); 
            	}
            };   
            
            $("#context").change(selContextChanged);
            //util.checkBoxAll("reportChk","reportChkRef");
	});

	function search(indexPage) { 
		var searchObj = {
			url : url,
			insertDiv : "resultDiv",
			param : {
				indexPage : indexPage
			}
		};
		$("#statisticsSearchForm").submitFormLoadHtml(searchObj);
	};
	
	function selContextChanged(){
		 if($("#context").val()=='T001'){
		 	url="/hm/mc/healthRecordList";
		 }
		 else if($("#context").val()=='T002'){
			 url="/hm/mc/healthEduList";
		 }else if($("#context").val()=='T003'){
			 url="/hm/mc/vaccinateList";
		 }else if($("#context").val()=='T004'){
			 url="/hm/mc/childHealthList";
		 }else if($("#context").val()=='T005'){
			 url="/hm/mc/pregnantWomanList";
		 }else if($("#context").val()=='T006'){
			 url="/hm/mc/elderlyHealthList";
		 }else if($("#context").val()=='T007'){
			 url="/hm/mc/hypertensionHealthList";
		 }
		 else if($("#context").val()=='T008'){
			 url="/hm/mc/diabetesHealthList";
		 }else if($("#context").val()=='T009'){
			 url="/hm/mc/mentalIllnessList";
		 }else if($("#context").val()=='T010'){
			 url="/hm/mc/infectiousDiseasesList";
		 }else if($("#context").val()=='T011'){
			 url="/hm/mc/healthSupervisionList";
		 }
			 
	}

	function toggle(obj,tableId) {
		$(obj).toggleClass("ico-top");
		$(obj).toggleClass("ico-bottom");
		$("#" + tableId).toggle();
	};

	return {
        search : search,
      //  add:add,
       // caseAdd:caseAdd,
       // caseEdit:caseEdit,
      //  print:print,
       // edit:edit,
        toggle:toggle
	};
})();

$(document).ready(function () { 
	//按钮样式切换 
	$("#statisticsBtnSearch").hover( 
		function () { 
		$(this).removeClass("search_btn").addClass("search_btn_h"); 
		}, 
		function () { 
		$(this).removeClass("search_btn_h").addClass("search_btn"); 
		} 
	); 

});
