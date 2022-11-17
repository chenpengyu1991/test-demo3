var path = "${pageContext.request.contextPath}";
	function initFun(){
		//$('#startDate').datepicker(dataOptions);
		//$('#endDate').datepicker(dataOptions);
		  //Hidden div
		  $("#detailDiv").hide();  
		  $(".msgError").hide(); 
		  $(".msgOK").hide(); 
		  //for poll search again
		  var pollForm = "${pollForm}";
		  if(!isEmpty(pollForm)){
			  loadHtml2(path+"/poll/list","searchPollForm", "listDiv", 1);
		  }
		  
		  /**默认搜索显示第一页**/
		  search(1);
		  enterEven('search','searchPollForm','1');
	}
	
	function search(indexPage) {
		if(validateDate()){
		$("#detailDiv").hide(); 
		$(".msgError").hide(); 
		$(".msgOK").hide();
		loadHtml2(path+"/poll/list","searchPollForm", "listDiv", indexPage);
	}
	}
	
	function doAdd(){
		location.href = path+"/surveyAdmin/add";
	}
	
	function viewDetail(surveyId){
		if(!surveyId){
			return;
		}
		$("#pollMsgError").hide();
		$(".msgError").hide();
		$(".msgOK").hide();
		$("#pollSurveyId").val(surveyId);
		$("#detailDirections").html($("#"+surveyId+"_directions").val());
		$("#detailPurpose").html($("#"+surveyId+"_purpose").val());
		$("#detailTitle").html($("#"+surveyId+"_title").val());
		$("#detailSubmitTime").html($("#"+surveyId+"_submitTime").val());
		$("#detailOrgName").html($("#"+surveyId+"_orgName").val());
		$("#detailDiv").show();  
		loadCallbackSimpleHtml(path+"/poll/detail?id="+surveyId, "optionsDiv",function(){
			goDiv("optionsDiv");
		});
	}
	
	function sumitPoll(){
		if(!$("#pollSurveyId").val()){
			alert("调查表为空");
			return;
		}
		
		$.postRepeat(path + "/poll/submit" , $("#pollSubmitForm").serialize(),  function(data){
		     if("success" == data){
		    	search(1);
		    	$("#msgOK").html("调查表提交成功！");
		    	$("#msgOK").show(); 
		    	
		    }else if("fail" == data){
		    	$("#msgError").html("提交失败，请填入或者选择正确的选项！");
		    	$("#msgError").show();  
		    }else{
		    	$("#msgError").html(data);
	    		$("#msgError").show();
	    	}
			  
		});
	}
	