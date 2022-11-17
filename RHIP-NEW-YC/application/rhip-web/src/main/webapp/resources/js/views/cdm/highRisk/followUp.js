var followUp = (function() {
		$(function() {
			//pageUtil.bind("followUpPlan_view",searchFollowUpPersonInfo);
			searchFollowUpPersonInfo(1);
			$("#searchFollowUpPlanInfo").keypress(function(e) {
				var key = e.which;
				if (key == 13) {
					searchFollowUpPersonInfo(1);
				}
			});
			$("#followUpPersonInfo").click(function(e) {
				e.preventDefault();
				searchFollowUpPersonInfo(1);
			});
			$("#addFollowUp").click(function(e) {
				e.preventDefault();
				addFollowUp();
			});
			$("#idcard").keyup(function(e) {
				e.preventDefault();
				var idCardValue = $("#idcard").val();
				$("#idcard").attr("value", idCardValue.toUpperCase());
			});
			$("#followUpPlanInfo").click(function(e){
				e.preventDefault();
				toggle(this,'reportSearch');
			});
			$("#followUpclickPersonInfo").click(function(e){
				e.preventDefault();
				clickPersonInfo(["data-id"]);
			});
			$("#check-submit-btn").on("click", function (e) {
				e.preventDefault();
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
	function addFollowUp() {
		var personInfoId = $("#personInfoId").val();
		if ($.isEmpty(personInfoId)) {
			layer.alert("请选择要建随访计划的人员！", {icon:0,title:'提示'});
			return false;
		}
		var loadHtmlByUrlOption = {
			url : "/cdm/highrisk/addFollowUp",
			param : {
				indexPage : 1,
				personId : personInfoId
			},
			insertDiv : "followUpPlan_view"
		};
		$.loadHtmlByUrl(loadHtmlByUrlOption);
		$("#list_view").hide();
		$("#followUpPlan_view").show();
	}
	function selectPerson(personId) {
		if (!$.isEmpty(personId)) {
			$("#personInfoId").val(personId);
		}
	}
	function clickPersonInfo(personId) {
		var loadHtmlByUrlOption = {
			url : "/cdm/highrisk/addFollowUp",
			param : {
				indexPage : 1,
				personId : personId
			},
			insertDiv : "followUpPlan_view"
		};
		$.loadHtmlByUrl(loadHtmlByUrlOption);
		$("#list_view").hide();
		$("#followUpPlan_view").show();
	}
	function searchFollowUpPersonInfo(indexPage) {
		if (!checkAge()) {
			return false;
		}
		var searchObj = {
			url : "/cdm/highrisk/searchFollowUpPerson",
			insertDiv : "followUpPlanPersonInfo_view",
			param : {
				indexPage : indexPage
			},
		    callback: function() {
		    	  initLinkClick('followUpSelectPerson',selectPerson,{personInfoList:"data-id"});
		    	  
		    	  initLinkClick('followUpPlanInfoClick',clickPersonInfo,{personInfoList:"data-id"});
		     }
		};
		$("#searchFollowUpPlanInfo").submitFormLoadHtml(searchObj);
	}
	function toggle(obj, tableId) {
		$(obj).toggleClass("ico-top");
		$(obj).toggleClass("ico-bottom");
		$("#" + tableId).toggle();
	}
	return {
		load : load,
		searchFollowUpPersonInfo : searchFollowUpPersonInfo,
		selectPerson : selectPerson,
		toggle : toggle,
		clickPersonInfo : clickPersonInfo,
		addFollowUp : addFollowUp
	};
})();