var managePlanForm = (function() {
		$(function() {
			addManagePlanForm(1);
			$("#saveManagePlan").click(function(e) {
				e.preventDefault();
				saveManagePlanInfo();
			});
			$("#add").click(function(e) {
				e.preventDefault();
				addManagePlanForm(1);
			});
			$("#del").click(function(e) {
				e.preventDefault();
				managePlanDelete();
			});
			$("#returnButton").click(function(e) {
				e.preventDefault();
				$("#list_view").show();
				$("#ManagePlan_view").hide();
				$("#followUpPlan_view").hide();
			});
		});
	function managePlanDelete() {
		var planId = $("#id").val();
		if ($.isEmpty(planId)) {
			layui.use('layer', function(){
    			var layer = layui.layer;
    			layer.alert("请先选择要删除的计划！", {icon:0,title:'提示'});
    		});
			return false;
		}
		$("#managePlanForm").submitFormGetJson({
			url : "/cdm/highrisk/removeManagePlan",
			param : {
				id : planId
			},
			callback : function(data) {
				layui.use('layer', function(){
	    			var layer = layui.layer;
	    			if ("failure" == data) {
	    				layer.alert("该管理计划存在随访,不能删除,请先删除随访计划！", {icon:0,title:'提示'});
	    			}
	    			if ("success" == data) {
	    				var index = layer.alert("删除成功！", {icon:0,title:'提示'}, function() {
	    					layer.close(index);
	    					addManagePlanForm(1);
	    				});
	    			}
	    		});
			}
		});

	}
	function addManagePlanForm(indexPage) {
		var searchObj = {
			url : "/cdm/highrisk/managePlanForm",
			insertDiv : "managePlanInfoForm",
			param : {
				indexPage : indexPage
			}	
		
		};
		$("#managePlanForm").submitFormLoadHtml(searchObj);
	}
	function saveManagePlanInfo() {
		var validate = $("#managePlanForm").easyValidate();
		// 验证
		var result = validate.validateForm();
		if (!result) {
			return;
		}
		$("#managePlanForm").submitFormGetJson({
			url : "/cdm/highrisk/saveManagePlan",
			param : {},
			callback : function(data) {
				layui.use('layer', function(){
        			var layer = layui.layer;
        			
        			if ("failure" == data) {
        				layer.alert("该年度该计划已存在！", {icon:0,title:'提示'});
        			}
        			if ("notExistRiskLevel" == data) {
        				var index = layer.alert("请先选择该患者危险等级！", {icon:0,title:'提示'}, function() {
        					layer.close(index);
        					addManagePlanForm(1);
        				});
        			}
        			if ("chanageSuccess" == data) {
        				var index = layer.alert("修改成功！", {icon:0,title:'提示'}, function() {
        					layer.close(index);
        					addManagePlanForm(1);
        				});
        			}
        			if ("alreadyBuildFollowup" == data) {
        				layer.alert("该计划已建立随访记录,随访日期不可修改！", {icon:0,title:'提示'});
        			}
        			if ("followupRecordUnfinished" == data) {
        				layer.alert("随访记录未完成,请先制定未完成的随访！", {icon:0,title:'提示'});
        			}
        			if ("errorFollowupDate" == data) {
        				layer.alert("随访日期不能小于去年最后一次随访日期！", {icon:0,title:'提示'});
        			}
        			if ("buildFollowup" == data) {
        				var index = layer.alert("该年度管理计划已完成！", {icon:0,title:'提示'}, function() {
        					layer.close(index);
        					addManagePlanForm(1);
        				});
        			}
        			searchManagePlanInfo(1);
        		});
			}
		});
	}
	function selectManagePlan(id, year) {
		var loadHtmlByUrlOption = {
			url : "/cdm/highrisk/managePlanResult",
			param : {
				indexPage : 1,
				id : id,
				year : year
			},
			insertDiv : "managePlanResult"
		};
		$.loadHtmlByUrl(loadHtmlByUrlOption);
	}
	function loadFollowUp() {
		$("#managePlanForm").submitFormLoadHtml({
			url : "/cdm/highrisk/addFollowUp",
			param : {},
			insertDiv : "loadFollowUp"
		});
	}
	function searchManagePlanInfo(indexPage) {
		var searchObj = {
			url : "/cdm/highrisk/searchManagePlanInfo",
			insertDiv : "managePlanPersonInfo_view",
			param : {
				indexPage : indexPage
			}
		};
		$("#searchMangeInfo").submitFormLoadHtml(searchObj);
	}
	return {
		load : load ,
		addManagePlanForm : addManagePlanForm,
		saveManagePlanInfo : saveManagePlanInfo,
		selectManagePlan : selectManagePlan,
		loadFollowUp : loadFollowUp,
		managePlanDelete : managePlanDelete
	};
})();