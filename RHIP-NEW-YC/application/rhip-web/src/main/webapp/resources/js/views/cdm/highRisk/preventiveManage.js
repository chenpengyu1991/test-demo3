var preventiveManage = (function() {
		$(function() {
			pageUtil.bind("preventiveManage_list",searchpreventiveManage);
			searchpreventiveManage(1);
			$("#searchPreventiveInfo").keypress(function(e) {
				var key = e.which;
				if (key == 13) {
					searchpreventiveManage(1);
				}
			});
			$("#returnButton").click(function(e) {
				e.preventDefault();
				$("#list_view").show();
				$("#factorsInfo_view").hide();
			});
			$("#searchPotentialPerson").click(function(e) {
				e.preventDefault();
				searchpreventiveManage(1);
			});
			$("#searchPotentialAndPerson").click(function() {
				insertPreventvie(1);
			});
			$("#idcard").keyup(function() {
				var idCardValue = $("#idcard").val();
				$("#idcard").attr("value", idCardValue.toUpperCase());
			});
			$("#preventiveManage").click(function(){
				toggle(this,'reportSearch');
			});
			$("#check-submit-btn").on("click", function () {
				StartRead();
			});
		});

		function StartRead()//开始读卡
		{
			if (GT2ICROCX.GetState() == 0){
				GT2ICROCX.ReadCard()
			}

			//GT2ICROCX.ReadCard() //循环读卡

			$("#idcard").val(GT2ICROCX.CardNo);
		}

	function checkAge() {
		var beginAge = $("#beginAge").val();
		var endAge = $("#endAge").val();
		if (beginAge && endAge && Number(beginAge) > Number(endAge)) {
			layer.alert("开始年龄不能大于结束年龄！", {icon:0,title:'提示'});
			return false;
		}
		return true;
	}
	function searchpreventiveManage(indexPage) {
		if (!checkAge()) {
			return false;
		}
		var searchObj = {
			url : "/cdm/highrisk/preventiveManage",
			insertDiv : "preventiveManage_list",
			param : {
				indexPage : indexPage
			},
		    callback: function() {
		      initLinkClick('preventiveManageSelect',selectPreventivePersonInfo, {personInfoList:"data-id"});
			  initLinkClick('preventiveManageInto',intoManage, {personInfoList:"data-id"});
		}	
		};
		$("#searchPreventiveInfo").submitFormLoadHtml(searchObj);
	}
	function loadManageCard(personId) {
		var loadHtmlByUrlOption = {
			url : "/cdm/highrisk/intoManage",
			param : {
				indexPage : 1,
				personId : personId
			},
			insertDiv : "factorsInfo_view"
		};
		$.loadHtmlByUrl(loadHtmlByUrlOption);
		$("#list_view").hide();
		$("#factorsInfo_view").show();
	}
	function selectPreventivePersonInfo(personId) {
		var loadHtmlByUrlOption = {
			url : "/cdm/highrisk/preventionOfManageInfo",
			param : {
				indexPage : 1,
				personId : personId
			},
			insertDiv : "factorsInfo_view"
		};
		$.loadHtmlByUrl(loadHtmlByUrlOption);
		$("#list_view").hide();
		$("#factorsInfo_view").show();
	}
	function intoManage(personId) {
		$("#searchPreventiveInfo").submitFormGetJson({
			url : "/cdm/highrisk/intoManagementCheck",
			param : {
				indexPage : 1,
				personId : personId
			},
			insertDiv : "preventiveManage_list",
			callback : function(data) {
				layui.use('layer', function(){
    				var layer = layui.layer;
    				
    				if ("operationFails" == data) {
    					layer.alert("操作失败！", {icon:0,title:'提示'});
    				}
    				if ("intoManageAgain" == data) {
    					var index = layer.confirm("该患者已结束管理，是否重新管理？", {icon:1, title:'确认提示'}, function() {
    						loadManageCard(personId);
    						layer.close(index);
    					});
    				}
    				if ("alreadyIntoManage" == data) {
    					layer.alert("已纳入管理不能重复纳入！", {icon:0,title:'提示'});
    				}
    				if ("intoManageCard" == data) {
    					loadManageCard(personId);
    				}
    			});
			}
		});
	}
	// 给测试用
	function insertPreventvie() {
		var searchObj = {
			url : "/cdm/highrisk/preventive",
			insertDiv : "preventiveManage_list"
		};
		$("#searchPotentialAndPerson").submitFormGetJson(searchObj);
	}

	function toggle(obj, tableId) {
		$(obj).toggleClass("ico-top");
		$(obj).toggleClass("ico-bottom");
		$("#" + tableId).toggle();
	}
	return {
		load : load,
		insertPreventvie : insertPreventvie,
		searchpreventiveManage : searchpreventiveManage,
		intoManage : intoManage,
		toggle : toggle,
		selectPreventivePersonInfo : selectPreventivePersonInfo
	};
})();