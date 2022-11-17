var verifySearch = (function() {
	$(function() {
		
		// tab切换
		$("#tag1").on("click", function(event) {
			selectTag("tagContent0", this);
		});
		$("#tag2").on("click", function(event) {
			selectTag("tagContent1", this);
		});
		
		$("#personInfoQuery").click(function() {
			recordsPerform(1);
		});
		$("#personInfoTempQuery").click(function(){
			recordsPerformUpdate(1);
		});
		$("#form_search").onEnter(function() {
			recordsPerform(1);
		});
		$("#form_update").onEnter(function() {
			recordsPerformUpdate(1);
		});
		$("#verifyCheck").click(function(){
			$('#checkInfo').show();
			$('#updateInfo').hide();
			recordsPerform(1);
		});
		$("#verifyUpdate").click(function(){
			$('#checkInfo').hide();
			$('#updateInfo').show();
			recordsPerformUpdate(1);
		});
   		recordsPerform(1);
   		recordsPerformUpdate(1);
   		$("#filingFlagSelect").bind("change",function(){
   			if($(this).val()==1){
   				$("#addressDiv").hide();
   			}else if($(this).val()==5){
   				$("#addressDiv").show();
   			}
   		});
	});
	
	function toggle(obj,tableId) {
		$(obj).toggleClass("ico-top");
		$(obj).toggleClass("ico-bottom");
		$("#" + tableId).toggle();
	};
	function recordsPerform(indexPage) {
		var searchObj = {
			url : "/personRecord/verify/list",
			insertDiv : "personInfoList",
			param : {
				indexPage : indexPage
			}
		};
		$("#form_search").submitFormLoadHtml(searchObj);
	}
	function recordsPerformUpdate(indexPage) {
		var searchObj = {
			url : "/personRecord/verify/personInfoTemplist",
			insertDiv : "personInfoTempList",
			param : {
				indexPage : indexPage
			}
		};
		$("#form_update").submitFormLoadHtml(searchObj);
	}
	return {
		search : recordsPerform,
		toggle : toggle,
		personInfoTempSearch:recordsPerformUpdate
	};
})();