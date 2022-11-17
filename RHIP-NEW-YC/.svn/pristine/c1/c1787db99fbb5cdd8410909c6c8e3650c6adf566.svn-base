var diPlanInfo = (function() {
	var validate=null;
	$(function() {
		 validate = $("#diPlanForm").easyValidate();
		 //$("#diYear").val(new Date().getFullYear());
		 if($("input[name='manageLevel']:checked").length<1){
			  $("input[name='manageLevel']").val(["1"]);
	       }
		 $("#personDiName").val($("#hiddenPersonName").val());
		 //糖尿病保存事件
		   $("#cdm-plan-list-di-save-btn").click(function() {
			   result=validate.validateForm();
			   if(result==true){
				   saveDiPlan();
			   }
		    });
			 //糖尿病返回事件
		   $("#cdm-plan-list-di-back-btn").click(function() {
			   back();
		    });
	});
	// 保存糖尿病保健计划
	function saveDiPlan() {
		$("#diPlanForm").submitFormGetJson({
			url : "/cdm/standardization/insertPlanInfo",
			callback : function(data) {
				if ("success" == data) {
					layer.alert("保存成功！", {icon:0,title:'提示'}, function(index) {
						refresh();
						layer.close(index);
					});
				}else if ("before" == data||"after"==data) {
					layer.alert("只能建立当年度保健计划！", {icon:0,title:'提示'});
                } else if ("less" == data) {
                	layer.alert("当前时间为上一年保健计划范围内！", {icon:0,title:'提示'});
                }else if ("repeat" == data) {
                	layer.alert("该年度保健计划已经存在！", {icon:0,title:'提示'});
				} else if("havaFollowup" == data){
					layer.alert("该年度已经存在随访记录不得修改保健计划！", {icon:0,title:'提示'});
				} else if ("yearModify" == data) {
					layer.alert("不可以修改保健计划年度！", {icon:0,title:'提示'});
                }else {
                	layer.alert("保存失败！", {icon:0,title:'提示'});
				}
			}
		});
	}
	
	function refresh(){
		cdmplanInfoTabMain.searchMain(2);
	}
//	
//	function refreshAdd(){
//		var searchObj={
//				url : "/cdm/standardization/inputDiPlanForm",
//				insertDiv:"cdm-plan-input-di",
//				param:{
//					id:$("#cdmPlanHiddenId").val()
//				}
//		};
//		$.loadHtmlByUrl(searchObj);
//	}
	//返回事件
	function back(){
		debugger;
		$("#cdm-plan-input-di").hide();
		$("#cdm-plan-list-di-box").show();
	}
	return {
		refresh:refresh
	};
})();