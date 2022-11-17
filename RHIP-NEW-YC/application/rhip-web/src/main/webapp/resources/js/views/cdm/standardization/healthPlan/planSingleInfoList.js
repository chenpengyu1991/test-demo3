!(function() {
	$(function() {
	   //点击高血压修改事件
		 $("#cdm-plan-list-hbp-result").on("click", ".cdm-plan-modify-link",function(event){
				event.preventDefault();
				$("#cdm-plan-list-hbp-box").hide();
				$("#cdm-plan-input-hbp").show();
				var loadHtmlByUrlOption = {
						url : "/cdm/standardization/searchPlanInfo",
						param : {
							id :$(this).data("id"),
							openStatus:"modify"
						},
						insertDiv : "cdm-plan-input-hbp"
				};
				$.loadHtmlByUrl(loadHtmlByUrlOption);
			});
		 //点击糖尿病修改事件
		 $("#cdm-plan-list-di-result").on("click", ".cdm-plan-modify-link",function(event){
				event.preventDefault();
				$("#cdm-plan-list-di-box").hide();
				$("#cdm-plan-input-di").show();
				var loadHtmlByUrlOption = {
					url : "/cdm/standardization/searchPlanInfo",
					param : {
						id :$(this).data("id"),
						openStatus:"modify"
					},
					insertDiv : "cdm-plan-input-di"
				};
				$.loadHtmlByUrl(loadHtmlByUrlOption);
			});
		 
		 //点击高血压查看事件
		 $("#cdm-plan-list-hbp-result").on("click", ".cdm-plan-view-link",function(event){
				event.preventDefault();
				$("#cdm-plan-list-hbp-box").hide();
				$("#cdm-plan-input-hbp").show();
				var loadHtmlByUrlOption = {
					url : "/cdm/standardization/searchPlanInfo",
					param : {
						id :$(this).data("id"),
						openStatus:"view"
					},
					insertDiv : "cdm-plan-input-hbp"
				};
				$.loadHtmlByUrl(loadHtmlByUrlOption);
			});
		 
		 
		 //点击糖尿病查看事件
		 $("#cdm-plan-list-di-result").on("click", ".cdm-plan-view-link",function(event){
				event.preventDefault();
				$("#cdm-plan-list-di-box").hide();
				$("#cdm-plan-input-di").show();
				var loadHtmlByUrlOption = {
					url : "/cdm/standardization/searchPlanInfo",
					param : {
						id :$(this).data("id"),
						openStatus:"view"
					},
					insertDiv : "cdm-plan-input-di"
				};
				$.loadHtmlByUrl(loadHtmlByUrlOption);
			});
		 
		 //点击高血压删除事件
		 $("#cdm-plan-list-hbp-result").on("click", ".cdm-plan-delete-link",function(event){
			 	var id=$(this).data("id");
			 	var personId=$(this).data("personid");
				event.preventDefault();
				var index = layer.confirm("是否删除？", {icon:2, title:'确认提示'}, function() {
					var loadHtmlByUrlOption = {
							url : "/cdm/standardization/deletePlan",
							param : {
								id :id,
								personId:personId,
								diseaseType:1
							},
							callback : function(data){
								 var layer = layui.layer;
								 if(data=="success"){
									var index = layer.alert("删除成功！", {icon:0,title:'提示'}, function() {
										refreshHbp();
										layer.close(index);
									});
								 }else{
									 layer.alert("删除失败！", {icon:0,title:'提示'});
								 }
					    	}  
						};
						$.loadHtmlByUrl(loadHtmlByUrlOption);

					layer.close(index);
				});
			});
		 
		//点击糖尿病删除事件
		 $("#cdm-plan-list-di-result").on("click", ".cdm-plan-delete-link",function(event){
				event.preventDefault();
				var id=$(this).data("id");
			 	var personId=$(this).data("personid");
			 	var index = layer.confirm("是否删除？", {icon:2, title:'确认提示'}, function() {
			 		var loadHtmlByUrlOption = {
							url : "/cdm/standardization/deletePlan",
							param : {
								id :id,
								personId:personId,
								diseaseType:2
							},
							callback : function(data){
								var layer = layui.layer;
								 if(data=="success"){
									var index = layer.alert("删除成功！", {icon:0,title:'提示'}, function() {
										refreshDi();
										layer.close(index);
									});
								 }else{
									 layer.alert("删除失败！", {icon:0,title:'提示'});
								 }
					    	}  
						};
						$.loadHtmlByUrl(loadHtmlByUrlOption);

			 		layer.close(index);
			 	});
	 	}); 
	});

    function refreshHbp(){
        cdmplanInfoTabMain.searchMain(1);
    }
    function refreshDi(){
        cdmplanInfoTabMain.searchMain(2);
    }
	return {
	};
})();