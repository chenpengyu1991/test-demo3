var appointmentNumSetUp = (function() {
	var validate = null;
	$(function() {
		validate = $("#InoculationAppointmentParamForm").easyValidate();
        loadInoculationAppointmentParamSetResult(1);
		$("#editBody").hide();
		showModifyButton();
		$("#modifyCommunityIdSpan").on("click", function() {
			$("#displayBody").hide();
			$("#editBody").show();
			showCancelButton();
		});

		$("#cancelCommunityId").click(function() {
			$("#displayBody").show();
			$("#editBody").hide();
			showModifyButton();
		});

		$("#saveCommunityId").click(function() {
			saveInoculationAppointmentParam();
		});
		$("#numSetSearch").click(function(){
			$("#cancelCommunityIdSpan").hide();
			$("#modifyCommunityIdSpan").show();
            loadInoculationAppointmentParamSetResult();
            
		});
	});
	function loadInoculationAppointmentParamSetResult(indexPage) {
		var searchObj = {
			url : "/inoculationAppointmentParamSet/listInoculationAppointmentParam",
			insertDiv : "appointmentNum_result",
			param : {			
				indexPage : indexPage
			}
		};
		$("#InoculationAppointmentParamSearchForm").submitFormLoadHtml(searchObj);
	}
	
	function saveInoculationAppointmentParam(){
		 var result = validate.validateForm();
		 if (!result){
		 	return;
		 }
		 $("#InoculationAppointmentParamForm").submitFormGetJson({
	          url : "/inoculationAppointmentParamSet/saveInoculationAppointmentParam",
	          insertDiv : "appointmentNum_result",
	          callback : function(data){
	        	  showModifyButton();
	        	  if(data == "success"){
	        		  layer.alert("保存成功！", {icon:0,title:'提示'});
	        	  }
	        	  if(data == "failure"){
	        		  layer.alert("保存失败！", {icon:0,title:'提示'});
	        	  }
                  loadInoculationAppointmentParamSetResult(1);
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
		toggle:toggle
	};
})();