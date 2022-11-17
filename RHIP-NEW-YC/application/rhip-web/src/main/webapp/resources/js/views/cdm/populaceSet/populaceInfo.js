var populaceInfo = (function() {
	var validate = null;
	$(function() {
		validate = $("#dmPopularceInfo").easyValidate();
		loadPopulationSetResult(1);
		$("#editBody").hide();
		showModifyButton();
		$("#modifyCommunityIdSpan").on("click", function(e) {
			e.preventDefault();
			$("#displayBody").hide();
			$("#editBody").show();
			showCancelButton();
		});

		$("#cancelCommunityId").click(function(e) {
			e.preventDefault();
			$("#displayBody").show();
			$("#editBody").hide();
			showModifyButton();
		});

		$("#saveCommunityId").click(function(e) {
			e.preventDefault();
			 savePopulaceInfo();
		});
		$("#popularSetSearch").click(function(e){
			e.preventDefault();
			chooseYear();
		});
		$("#populationSetupResult").click(function(){
			toggle(this,'reportSearch');
		});
	});
	function loadPopulationSetResult(indexPage) {
		var searchObj = {
			url : "/cdm/population/populationSetupResult",
			insertDiv : "population_result",
			param : {			
				indexPage : indexPage
			}
		};
		$("#popularForm").submitFormLoadHtml(searchObj);
	}
	function chooseYear() { 
		var countYear = $("#countYear").val();
		var searchObj = {
			url : "/cdm/population/populationSetupResult",
			insertDiv : "population_result",
			param : {			
				countYear:countYear
			}
		};
		$("#popularForm").submitFormLoadHtml(searchObj);
	}
	function savePopulaceInfo(){
		 var result = validate.validateForm();
		 if (!result){
		 	return;
		 }
		 $("#dmPopularceInfo").submitFormGetJson({			
	          url : "/cdm/population/savePopulaceInfo", 
	          insertDiv : "population_result",
	          callback : function(data){
	        	  showModifyButton();
	        	  if(data == "success"){
	        		  layer.alert("保存成功！", {icon:0,title:'提示'});
	        	  }
	        	  if(data == "failure"){
	        		  layer.alert("保存失败！", {icon:0,title:'提示'});
	        	  }
	        	  var countYear = $("#countYear").val(); 
	        	  if(!$.isEmpty(countYear)){
	        		  chooseYear(countYear);
	        	  }else{
	        		  loadPopulationSetResult(1);
	        	  }
		      }     
		 });
	}
	function showCancelButton() {
		$("#modifyCommunityIdSpan").hide();
		$("#cancelCommunityIdSpan").show();
	};
	function showModifyButton() {
		$("#cancelCommunityIdSpan").hide();
		$("#modifyCommunityIdSpan").show();
	};
	function toggle(obj,tableId) {
		$(obj).toggleClass("ico-top");
		$(obj).toggleClass("ico-bottom");
		$("#" + tableId).toggle();
	}
	return {
		loadPopulationSetResult:loadPopulationSetResult,
		toggle:toggle,
		chooseYear:chooseYear
	};
})();