var hmManageReport=(function() {
	var validate = $("#phyExamForm").easyValidate();

	function updateGuide(examId, examRecordId, ehrId) {
		var result = validate.validateForm();
		if (!result) {
			layer.alert("请根据提示正确填写！", {icon:0,title:'提示'});
			return;
		}
		var description = "";
		for (var i = 0; i < 4; i++) {
			var des = $("#anomalyDesc" + i).val();
			if (des != "") {
				description += des + ";";
			}
		}
		if (description != "") {
			description = description.substring(0, description.length - 1);
		}
		var params = {
			url : "/hm/manage/healthGuide",
			param : {
				anomalyDesc : description,
				examId : examId,
				examRecordId : examRecordId,
				ehrId : ehrId
			},
			callback : afterUpdate
		};
		$("#phyExamForm").submitFormGetJson(params);
	}

	function updateAssessment(examId, examRecordId) {
		var validate = $("#phyExamForm").easyValidate();
		var result = validate.validateForm();
		if (!result) {
			layer.alert("请根据提示正确填写！", {icon:0,title:'提示'});
			return;
		}
		var params = {
			url : "/hm/manage/selfAssessment",
			param : {
				examId : examId,
				examRecordId : examRecordId
			},
			callback : afterUpdate
		};
		$("#phyExamForm").submitFormGetJson(params);
	}

	function afterUpdate(result) {
		if (result == 1) {
			layer.alert("提交成功！", {icon:0,title:'提示'});
			$.removeDialog("physicalExamReportDialog");
			hmManageSearch.search(1);
		} else if (result == 0) {
			layer.alert("请填写对应的内容！", {icon:0,title:'提示'});
			return;
		} else {
			layer.alert("提交失败！", {icon:0,title:'提示'});
		}
	}

	function calculateAssessment() {
		var score = toNumber($(":checked[name='eatingAssessment']").val()) + toNumber($(":checked[name='cleaningAssessment']").val())
					+ toNumber($(":checked[name='clothingAssessment']").val()) + toNumber($(":checked[name='defecationAssessment']").val())
					+ toNumber($(":checked[name='exerciseAssessment']").val());
		if (score >= 0 && score <= 3) {
			$(":radio[name='lifeAbilitySelfAssessment'][value='1']").attr("checked", "checked");
		} else if (score >= 4 && score <= 8) {
			$(":radio[name='lifeAbilitySelfAssessment'][value='2']").attr("checked", "checked");
		} else if (score >= 9 && score <= 18) {
			$(":radio[name='lifeAbilitySelfAssessment'][value='3']").attr("checked", "checked");
		} else {
			$(":radio[name='lifeAbilitySelfAssessment'][value='4']").attr("checked", "checked");
		}
	}

	function toNumber(num) {
		var n = parseInt(num);
		if (isNaN(n)) {
			return 0;
		} else {
			return n;
		}
	}

	return {
		updateGuide : updateGuide,
		updateAssessment : updateAssessment,
		calculateAssessment : calculateAssessment
	};
})();