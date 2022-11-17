 cdmplanInfoTabMain = (function() {
	$(function() {
		initTab(main);
		//高血压新增
	   $("#cdm-plan-list-hbp-add-btn").click(function() {
	        inputHbpAdd();
	    });
	   //糖尿病新增
	   $("#cdm-plan-list-di-add-btn").click(function() {
	        inputDiAdd();
	    });
	   //高血压返回事件
	   $("#cdm-planInfo-list-hbp-back-btn").click(function() {
		   back();
	    });
	   //糖尿病返回事件
	   $("#cdm-planInfo-list-di-back-btn").click(function() {
		   back();
	    });
	});
	

	
	//返回事件
	function back(){
		cdmManagePlanlist.search(1);
		$("#cdm-manage-input-box").hide();
		$("#cdm-manage-list-box").show();
	}
	function main(target) {
		if (target == "hbpPlan-content") {
			search("cdm-plan-list-hbp-form", "cdm-plan-list-hbp-result", 1);
		} else {
			search("cdm-plan-list-di-form", "cdm-plan-list-di-result", 2);
		}
	}

	function search(formId, ResultId, type) {
		var searchObj = {
			url : "/cdm/standardization/healthPlan/singlePlanList",
			insertDiv : ResultId,
			param : {
				type : type,
				indexPage : 1,
				personId:$("#cdmPlanHiddenPersonId").val(),
			}
		};
		$("#" + formId).submitFormLoadHtml(searchObj);
	}

	function initTab(callback) {
		var $bar = $("#tags");
		$bar.find("a").on("click", function(event) {
			var $this = $(this);
			var target = $this.data("target");
			type = $this.data("type");
			$bar.find("li.selectTag").removeClass("selectTag");
			$this.parent().addClass("selectTag");
			$("#tagContent").children().hide();
			$("#" + target).show();
			callback(target);
		});
		$bar.find("a:first").click();
	}
	 //新增高血压
	function inputHbpAdd(){
		var searchObj = {
				url : "/cdm/standardization/inputHbpPlanForm",
				insertDiv : "cdm-plan-input-hbp",
				param : {
					personId : $("#cdmPlanHiddenPersonId").val()
				}
			};
			$. loadHtmlByUrl(searchObj);
			$("#cdm-plan-list-hbp-box").hide();
			$("#cdm-plan-input-hbp").show();
	}
	
	 //新增糖尿病
	function inputDiAdd(){
		var searchObj = {
				url : "/cdm/standardization/inputDiPlanForm",
				insertDiv : "cdm-plan-input-di",
				param : {
					personId : $("#cdmPlanHiddenPersonId").val()
				}
			};
			$. loadHtmlByUrl(searchObj);
			$("#cdm-plan-list-di-box").hide();
			$("#cdm-plan-input-di").show();
	}
	 
	// 刷新主界面
	function searchMain(type) {
		if(type==1){
			var searchObj = {
				url : "/cdm/standardization/healthPlan/singlePlanList",
				insertDiv : "cdm-plan-list-hbp-result",
				param:{
					personId:$("#cdmPlanHiddenPersonId").val(),
					type:type
				}
			};
			$.loadHtmlByUrl(searchObj);
			$("#cdm-plan-input-hbp").hide();
			$("#cdm-plan-list-hbp-box").show();
		}else if(type==2){
			var searchObj = {
					url : "/cdm/standardization/healthPlan/singlePlanList", 
					insertDiv : "cdm-plan-list-di-result",
					param:{
						personId:$("#cdmPlanHiddenPersonId").val(),
						type:type
					}
				};
			$.loadHtmlByUrl(searchObj);
			$("#cdm-plan-input-di").hide();
			$("#cdm-plan-list-di-box").show();
		}
	}
	return {
		initTab:initTab,
		searchMain:searchMain
	};

})();