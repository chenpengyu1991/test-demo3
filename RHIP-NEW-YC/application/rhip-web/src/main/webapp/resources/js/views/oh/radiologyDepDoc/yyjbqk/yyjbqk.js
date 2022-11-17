var yyjbqk = (function() {
	var operationType = $("#operationType").val();
	$(function() {
		if (operationType == '1')
			$("#hLevel").attr('disabled', 'disabled');
		if (operationType != '1')
			initAutoSel();
	});

	// 审核
	function checkRecord(id) {
		layer.confirm("确认审核？", {icon:1, title:'确认提示'}, function(index) {
			var option = {
				url : "/oh/radiologicalProtectionReport/hospitalInfo/check",
				param : {
					id : id,
					verifyState : "1"
				},
				callback : function(data) {
					if (data == '1') {
						layer.alert("审核成功！", {icon:0,title:'提示'});
						//mainPage.search(1);
						baseLayoutLoad.loadMenuContent("/oh/radiologicalProtectionReport/index");
						return;
					} else {
						layer.alert("审核失败！", {icon:0,title:'提示'});
						return;
					}
				}
			};
			$.getJsonByUrl(option);
			layer.close(index);
		});
	}
	// 退回
	function unCheckRecord(id) {
		layer.confirm("确认退回？", {icon:1, title:'确认提示'}, function(index) {
            if($("#verifyState").val()=='2'){
            	layer.alert("该记录已被退回！", {icon:0,title:'提示'});
            	return;
			}
			var option = {
				url : "/oh/radiologicalProtectionReport/hospitalInfo/check",
				param : {
					id : id,
					verifyState : "2"
				},
				callback : function(data) {
					if (data == '1') {
						layer.alert("退回成功！", {icon:0,title:'提示'});
						baseLayoutLoad.loadMenuContent("/oh/radiologicalProtectionReport/index");
						return;
					} else {
						layer.alert("退回失败！", {icon:0,title:'提示'});
						return;
					}
				}
			};
			$.getJsonByUrl(option);
			layer.close(index);
		});
	}

	function initAutoSel() {
		var options = {
			url : contextPath + "/oh/radiologicalProtectionReport/autoComSel",
			feild : {
				value : "organName",
				lable : "organName"
			},
			submitEdit:true,
			selectFun : function(data) {
				if ($(data).attr("address") != 'null')
					$("#addr").val($(data).attr("address"));
				if ($(data).attr("gradeCode") != 'null')
					$("#hLevel").val($(data).attr("gradeCode"));
				if ($(data).attr("artificialPerson") != 'null')
					$("#legalRepr").val($(data).attr("artificialPerson"));

				if ($(data).attr("tel") != 'null')
					$("#phone").val($(data).attr("tel"));

			}
		};
		$("#hospitalName").selectBox(options);

	}
	return {
		checkRecord:checkRecord,
		unCheckRecord:unCheckRecord
	};
})();
