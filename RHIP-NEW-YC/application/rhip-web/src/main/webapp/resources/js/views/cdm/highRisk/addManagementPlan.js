var addManagementPlan = (function() {
		$(function() {
			//pageUtil.bind("ManagePlan_view",searchManagePlanInfo);
			searchManagePlanInfo(1);
			$("#searchMangeInfo").keypress(function(e) {
				var key = e.which;
				if (key == 13) {
					searchManagePlanInfo(1);
				}
			});
			$("#managePlanInfo").click(function(e) {
				e.preventDefault();
				searchManagePlanInfo(1);
			});
			$("#idcard").keyup(function() {
				var idCardValue = $("#idcard").val();
				$("#idcard").attr("value", idCardValue.toUpperCase());
			});
			$("#managementSelectPerson").click(function(){
				selectPerson(["data-id"]);
			});
			$("#managementPlan").click(function(){
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
		function searchManagePlanInfo(indexPage) {
			if (!checkAge()) {
				return false;
			}
			var searchObj = {
				url : "/cdm/highrisk/searchManagePlanInfo",
				insertDiv : "managePlanPersonInfo_view",
				param : {
					indexPage : indexPage
				},
			    callback: function() {
					/*为listDiv中a的添加click事件*/
				   // initLinkClick('managementPlanClick',clickPersonInfo, {personInfoList:"data-id"});
					
			}	
			};
			$("#searchMangeInfo").submitFormLoadHtml(searchObj);
		}
		function selectPerson(personId) {
			if (!$.isEmpty(personId)) {
				$("#personInfoId").val(personId);
			}
		}
		function clickPersonInfo(personId) {
			var loadHtmlByUrlOption = {
				url : "/cdm/highrisk/addManagePlan",
				param : {
					indexPage : 1,
					personId : personId
				},
				insertDiv : "ManagePlan_view"
			};
			$.loadHtmlByUrl(loadHtmlByUrlOption);
			$("#list_view").hide();
			$("#ManagePlan_view").show();
		}
		function toggle(obj, tableId) {
			$(obj).toggleClass("ico-top");
			$(obj).toggleClass("ico-bottom");
			$("#" + tableId).toggle();
		}
		return {
			load: load,
			searchManagePlanInfo : searchManagePlanInfo,
			selectPerson : selectPerson,
			toggle : toggle,
			clickPersonInfo : clickPersonInfo
		};
	
})();