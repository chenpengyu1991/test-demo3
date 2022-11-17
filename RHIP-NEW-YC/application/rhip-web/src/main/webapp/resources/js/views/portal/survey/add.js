define(['../survey/search'],function(surveySearch){
	
	function load() {
		initPoll();
		/*$(function() {*/
		$("#returnContact").click(returnSearch);
		$("#nextContact").click(doNext);
		/*});*/
	}

	function initPoll() {
		var size = $('#size').val();
		for(var i = 1; i <= size; i++) {
			var cc = $.trim($('#count'+i).text());
			if(cc == '') {
				$('#count'+i).text("0");
				$('#percent'+i).html("<div class=\"bar\">" +
						"<div class=\"precent\" style=\"width:0%; display: block;\">" +
						"<img width=\"149\" height=\"12\" src=\"${pageContext.request.contextPath}/images/poll_bar2.png\"></div>" +
						"</div><div style=\"float:left; margin-left:3px\">0%</div><div style=\"clear:both;\"></div>");
			}
		}
	}
	
	function doNext() {
		var result=$($("#surveyFormId")).easyValidate().validateForm();
    	if(!result){
    		return;
    	}
    	$("#surveyFormId").submitFormGetJson({
			url : contextPath + '/survey/save',
            wait : true,
            callback : function(data) {
                if (data == "fail") {
                	layer.alert("保存失败！", {icon:0,title:'提示'});
                } else {
					addItem(data);
				}
            }
		});
	}

	function addItem(surveyId) {
		$("#top_allSurvey").hide();
		$.loadHtmlByUrl({
			url : "/survey/item/add",
			insertDiv :"nextDetailDivSurvey",
			param : {
				surveyId : surveyId,
				type: $("#typeId").val(),
				surveyStatus: $("#surveyStatusIdd").val()
			}
		});
		$("#detailDivSurvey").hide();
		$("#nextDetailDivSurvey").show();
	}
	function returnSearch(){
		if(contentChanged){
			msgUtil.backConfirm(function(){
				$("#detailDivSurvey").empty();
		        $("#top_allSurvey").show();
		        surveySearch.searchSurvey(1);
			});
		}else{
			$("#detailDivSurvey").empty();
	        $("#top_allSurvey").show();
	        surveySearch.searchSurvey(1);			
		}
	}

	function checkDate(){
		var startDate=$("#startDate").val();
		var endDate=$("#endDate").val();
		if(startDate && endDate && new Date(startDate) > new Date(endDate)){
			layer.alert("开始时间不能大于结束时间！", {icon:0,title:'提示'});
			return false;
		}
		return true;
	}

	return {
		load: load
	};
});
