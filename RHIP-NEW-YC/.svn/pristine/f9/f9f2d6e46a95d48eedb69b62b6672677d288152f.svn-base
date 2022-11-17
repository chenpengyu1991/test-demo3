var followUp_main = (function() {
	$(function() {
		// tab切换事件
		$("#followUp_btn").on("click", function(event){
			selectTag("tagContent0", this);
		});
		$("#conclusion_btn").on("click", function(event){
//	  	    var buildPlan = $("#buildPlan").val();
//	  	    if(parseInt($("#riskLevel").val())==3){
//	  		     level = parseInt($("#riskLevel").val())+1;
//	  	    }else{
//	  	 	     level = parseInt($("#riskLevel").val());
//	  	    }
//		    if(level>parseInt(buildPlan)){
//			     msgUtil.alert("该患者的管理计划或随访计划未建全！");
//		    }else{
			     selectTag("tagContent1", this); 
//		   }
		});
		$("#followUpPlanForm").on("onDatePickerChanged", function(){
			  searchFollowUpPlan(1);
		});
		searchFollowUpPlan(1);
		searchFollowUpConclusion(1);
		$("#followUpSave").click(function(){
			saveFollowUpPlan();
		});
		$("#conclusionSave").click(function(){
			saveConclusion();
		});
		$("#followUpAdd").click(function(){
			searchFollowUpPlan(1);
		});
		$("#conclusionAdd").click(function(){
			searchFollowUpConclusion(1);
		});
		$("#followUpDel").click(function(){
			followUpDelete();
		});
		$("#conclusionDel").click(function(){
			conclusionDelete();
		});
		$("#returnButton").click(function(){
			$("#list_view").show();
			$("#followUpPlan_view").hide();
			$("#ManagePlan_view").hide();
	    });
		$("#returnToList").click(function(){

			$("#list_view").show();
			$("#followUpPlan_view").hide();
			$("#ManagePlan_view").hide();
		});
		$("#followUpPlanSearch").on("click", ".deal-plan", selectFollowUpPlan);
	});
	function followUpDelete(){
		var planId=$("#followUpId").val();
		if ($.isEmpty(planId)) { 
			layer.alert("请先选择要删除的随访记录！", {icon:0,title:'提示'});
			return false;
        }
		$("#followUpPlanForm").submitFormLoadHtml({
			url : "/cdm/highrisk/removeFollowUpPlan",
			insertDiv :"followUpPlanSearch",
			param:{
                   id : planId
			}
		});
	}
	function conclusionDelete(){
		var planId = $("#conclusionId").val();
		if ($.isEmpty(planId)) { 
			layer.alert("请先选择要删除的管理评定！", {icon:0,title:'提示'});
            return false;
        }else{
        	var index = layer.confirm("该管理评价包含危险因素记录是否同时删除？", {icon:2, title:'确认提示'}, function() {
        		$("#followUpConclusionForm").submitFormLoadHtml({
    				url : "/cdm/highrisk/removeConclusionPlan",
    				insertDiv :"followUpConclusionSearch",
    				param:{
    	                   id : planId
    				}
    			});
        		layer.close(index);
        	});
        }
	}
	function searchFollowUpPlan(indexPage) { 
		var searchObj = {
				url : "/cdm/highrisk/loadFollowUpPlan",
				insertDiv : "followUpPlanSearch",
				param : {			
					indexPage : indexPage
				},
				callback:changPlanStypeAndLoadToFollowup
			};
		$("#followUpPlanForm").submitFormLoadHtml(searchObj);
	}
	
	function changPlanStypeAndLoadToFollowup(){
		var $form = $("#followUpPlanForm");
		$("tr.toBeBuild").css("color", "#ed1941");
		$("tr.hasBeenBuild").css("color", "#1d953f");
		var $first = $form.find("tr.toBeBuild:first span.deal-plan");
		if ($first.length > 0){
			$first.click();
		} else{
			$form.find("tr.hasBeenBuild:last span.deal-plan").click();
		}
	}
	function searchFollowUpConclusion(indexPage) { 
		var searchObj = {
			url : "/cdm/highrisk/loadFollowConclusion",
			insertDiv : "followUpConclusionSearch",
			param : {			
				indexPage : indexPage
			}
		};
		$("#followUpConclusionForm").submitFormLoadHtml(searchObj);
	}
	function saveFollowUpPlan(){
		 // 验证
		 var validate = $("#followUpPlanForm").easyValidate();
		 var result = validate.validateForm();
		 if (!result){
		 	return;
		 }
		 $("#followUpPlanForm").submitFormGetJson({			
	          url : "/cdm/highrisk/saveFollowUpPlan",          
	          callback : function(data){
	        	  
	        	  layui.use('layer', function(){
	        			var layer = layui.layer;
	        			
	        			if("failure" == data){
	        				var index = layer.alert("保存失败！", {icon:0,title:'提示'}, function() {
	        					layer.close(index);
	        					searchFollowUpPlan(1);
	        				});
	        			}
	        			if("success" == data){
	        				var index = layer.alert("保存成功！", {icon:0,title:'提示'}, function(){
	        					layer.close(index);
	        					searchFollowUpPlan(1);
	        				});	
	        			}
	        			if("operateFailure" == data){
	        				var index = layer.alert("保存失败，该年度管理计划尚未建立！", {icon:0,title:'提示'}, function() {
	        					layer.close(index);
	        					searchFollowUpPlan(1);
	        				});
	        			}
	        			searchFollowUpPersonInfo(1);
	        		});
		      },
	          insertDiv : "followUpPlanSearch"
		 });
	}
	function selectFollowUpPlan() {
		var id = $(this).data("planid");
		$("#followupId").val(id);
	   	var loadHtmlByUrlOption = {
				url : "/cdm/highrisk/loadFollowUpPlanResult",
				param : {
					   id:id,
					   indexPage : 1,
				},
				insertDiv : "followUpPlanResult"
		};
		$. loadHtmlByUrl(loadHtmlByUrlOption);
	}
	function saveConclusion(){
		 var validate = $("#followUpConclusionForm").easyValidate();
		 // 验证
		 var result = validate.validateForm();
		 if (!result){
		 	return;
		 }
		 $("input[name='riskLevel']").attr("disabled",false);
		 $("#followUpConclusionForm").submitFormGetJson({			
	         url : "/cdm/highrisk/saveConclusion",          
	         callback : function(data) {
	        	 layui.use('layer', function() {
     				var layer = layui.layer;
     				if(data == "buildManagePlan") {
//					layer.confirm("是否制定下一年度管理计划？",function(index){
//						loadManagePlanForm(); 
//						$("#followManageMain").remove();
//						$("#loadManagePlan").show();
//     					layer.close(index);
//					});
     					var index = layer.alert("该年度管理评定已完成！", {icon:0,title:'提示'}, function() {
     						layer.close(index);
     						searchFollowUpConclusion(1);
     					});
     				} else if(data == "success") {
     					var index = layer.alert("该患者已结束管理！", {icon:0,title:'提示'}, function(){
     						layer.close(index);
     						searchFollowUpConclusion(1);
     						$("#list_view").show();
     						$("#followUpPlan_view").hide();
     					});
     				} else if(data == "forbidBuild") {
     					layer.alert("该年度无随访记录！", {icon:0,title:'提示'});
     				} else{
     					layer.alert("该年度管理评价已存在！", {icon:0,title:'提示'});
     				}
     				
     			});
				searchFollowUpPersonInfo(1);
		    	$("input[name='riskLevel']").attr("disabled",true);
		     },
	         insertDiv : "followUpConclusionSearch"
	     });
		
	}
	function selectConclusion(id) {
	   	var loadHtmlByUrlOption = {
				url : "/cdm/highrisk/loadFollowUpConclusionResult",
				param : {
					   indexPage : 1,
                       id:id
				},
				insertDiv : "followUpConclusionResult"
		};
		$.loadHtmlByUrl(loadHtmlByUrlOption);
	}
	function loadManagePlanForm(){
		$("#followUpPlanForm").submitFormLoadHtml({
				url : "/cdm/highrisk/addManagePlan",
				param : {
				},
				insertDiv : "loadManagePlan"
		});
	}
	function searchFollowUpPersonInfo(indexPage) {
		var searchObj = {
			url : "/cdm/highrisk/searchFollowUpPerson",
			insertDiv : "followUpPlanPersonInfo_view",
			param : {			
				indexPage : indexPage
			}
		};
		$("#searchFollowUpPlanInfo").submitFormLoadHtml(searchObj);
	}
	return {
		load:load,
		searchFollowUpPlan:searchFollowUpPlan,
		searchFollowUpConclusion:searchFollowUpConclusion,
		saveFollowUpPlan:saveFollowUpPlan,
		selectFollowUpPlan:selectFollowUpPlan,
		saveConclusion:saveConclusion,
		selectConclusion:selectConclusion,
		loadManagePlanForm:loadManagePlanForm,
		followUpDelete:followUpDelete,
		conclusionDelete:conclusionDelete
	};
})();