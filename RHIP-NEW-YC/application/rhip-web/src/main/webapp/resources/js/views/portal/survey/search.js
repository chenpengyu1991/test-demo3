define(function(){
	function load() {
		//分页绑定函数
		pageUtil.bind("listDivSurvey",searchSurvey);
		searchSurvey(1);
		$("#searchSurveyForm").onEnter(searchSurvey, 1);
		$("#surveySearchBut").click(function() {
			searchSurvey(1);
		});
		$("#surveyAddButId").click(function() {
			add(0);
		});
		$("#surveySearchSpanId").click(function() {
			toggle(this,'surveySearchTableId');
		});

	}

	function searchSurvey(indexPage) {
		var startDate = new Date($("#startDate").val());
		var endDate = new Date($("#endDate").val());
		
		var url = "/survey/list";
		var searchObj = {
			url : url ,
			insertDiv : "listDivSurvey",
			param : {
				indexPage : indexPage
			},
			callback: function() {
				/*为listDiv中a的添加click事件*/
				initLinkClick('viewDetail',viewDetail, {surveyId:"data-surveyId"});
				initLinkClick('modifySurvey',add, {surveyId:"data-surveyId"});
				initLinkClick('updateSurvey',updateSurvey, {surveyId:"data-surveyId",surveyStatus: "data-status"});
			}
		};
		$("#searchSurveyForm").submitFormLoadHtml(searchObj);
	}
	
	function add(surveyId) { 
		$("#top_allSurvey").hide();
		$.loadHtmlByUrl({
			url : "/survey/add",
			insertDiv :"detailDivSurvey",
			param : {
				surveyId: surveyId,
				type: 'edit'
			}
		});
		$("#detailDivSurvey").show();
	};
	
	function viewDetail(surveyId){
		$("#top_allSurvey").hide();
		$.loadHtmlByUrl({
			url : "/survey/poll",
			insertDiv :"detailDivSurvey",
			param : {
				surveyId: surveyId,
				type: 'see'
			}
		});
		$("#detailDivSurvey").show();
	}
	
	function updateSurvey(surveyId, surveyStatus){
		var str = getMessage(surveyStatus)
		if (!confirm("您确认要" + str + "吗?")){
			return false;
		}

		var url = "/surveyAdmin/updateStatus";
		$.getJsonByUrl({
			url : contextPath + "/survey/updateStatus",
			callback:function(data){
				if (data == "success") {//$("#currentPage").val()
					searchSurvey($("#currentPage").val());
					layer.alert(str + "成功！", {icon:0,title:'提示'});
				} else if (data == "fail") {
					layer.alert(str + "失败！", {icon:0,title:'提示'});
				}else {
					var errors = parseJson(data);
					$("#msgError").html(errors);
					$("#msgOK").hide();
					$("#msgError").show();
				}
			},
			param:{
				surveyId: surveyId,
				surveyStatus: surveyStatus
			}
		});
	}

	function getMessage(surveyStatus){
		if(surveyStatus == '1'){
			return "通过审核";
		} else{
			return "结束调查";		}
	}
	return {
		load: load,
		searchSurvey: searchSurvey
	};
});
