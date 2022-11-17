var planCdm =(function()
{
	$(function() {
		searchPlanList($("#hiddenPersonId").val());
		//返回事件
		$("#health-back-btn").click(function(){
			cdmManagePlanlist.search(1);
			$("#cdm-manage-input-box").hide();
			$("#cdm-manage-list-box").show();
		});
	});
	
	//根据personId查询年度列表
	function searchPlanList(personId) {
		var searchObj = {
			url : "/cdm/standardization/inputPlanList",
			insertDiv : "planYearList",
			param : {
				personId : personId
			},
			callback : function(){
				loadInfoAndFollowupcallback();
				var tr= $("#cdmHealthPlanList a.healthplan-link:last");
				if(tr.length>0)
					tr.click();
				else
					searchPlanInfoTab($("#hiddenPersonId").val());
	    	}  
		};
		$.loadHtmlByUrl(searchObj);
	}
	
	//根据personId查询保健计划表单信息
	function searchPlanInfoTab(personId) {
		var searchObj = {
			url : "/cdm/standardization/inputPlanInfoTab",
			insertDiv : "planInfoTabList",
			param : {
				personId : personId
			}
		};
		$. loadHtmlByUrl(searchObj);
	}
	
	function loadInfoAndFollowupcallback(){
		 $("#cdmHealthPlanList").on("click", ".healthplan-link",function(event){
				event.preventDefault();
				var loadHtmlByUrlOption = {
						url : "/cdm/standardization/inputPlanFollowupList",
						param : {
							personId : $(this).data("personid"),
							planYear:$(this).data("planyear")
						},
						insertDiv : "planFollowupList"
				};
			   	var loadHtmlByUrl = {
						url : "/cdm/standardization/searchPlanInfo",
						param : {
							personId : $(this).data("personid"),
							planYear:$(this).data("planyear")
						},
						insertDiv : "planInfoTabList"
				};
				$. loadHtmlByUrl(loadHtmlByUrlOption);
				$. loadHtmlByUrl(loadHtmlByUrl);
			});
	}
	return {
		searchPlanInfoTab:searchPlanInfoTab
	};
})();