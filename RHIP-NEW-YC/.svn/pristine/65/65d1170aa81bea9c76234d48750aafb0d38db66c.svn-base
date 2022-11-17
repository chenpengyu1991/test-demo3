var grjldaEdit = (function() {
	var validate = null;
	var oldPersonIdCard = null;
	var hospitalId = $("#id").val();
	var ohPersonalDoseOperationType = $("#ohPersonalDoseOperationType").val();
	$(function(){
		validate = $("#personalDose_form").easyValidate();
		$.Placeholder.init({
			query : "#idcard",
			callback : queryPerson
		});
	});
	
	// 根据输入的身份证设置相关信息
	function queryPerson() {
		var idcard = $("#idcard").val();
		if (validate.validate("idcard") && oldPersonIdCard != idcard) {
			oldPersonIdCard = idcard;
			$.getJsonByUrl({
				url : "/cdm/reportcard/load",
				param : {
					"personInfo.idcard" : idcard.toUpperCase()
				},
				wait : true,
				callback : function(data) {
					if (data)
						setPersonData(data, idcard);
					else
						setIcData(idcard);
				}
			});
		}

	}

	// 设置人员信息
	function setPersonData(data,idcard) {
		$("#name").val(data.name);
		$("#gender").val(data.gender);
		$("#healthRecordNo").val(data.healthFileNo);
		$('#birthdate').val(data.birthdayStr);
	}
	
	/*如果获取患者信息失败，根据身份证号码获取性别、出生日期*/
	function setIcData(idCard){
		var gender = IC.getGender(idCard);
		if(!$.isEmpty(gender)){
			$('#gender').val(gender);
		}
		var birthday = IC.getBirthday(idCard);
		if(!$.isEmpty(birthday)){
			$('#birthdate').val(birthday);
		}

	}
	
	function save(){
		var result = validate.validateForm();
		if (!result) {
			return;
		}
		$("#personalDose_form").submitFormLoadHtml({
			url : "/oh/radiologicalProtectionReport/personalDose/save",
			param : {
				ohPersonalDoseOperationType : ohPersonalDoseOperationType,
				hospitalId : hospitalId
			},
			callback : function(data) {
				if (data == '1') {
					layer.alert("保存成功！", {icon:0,title:'提示'}, function(){
						$.removeDialog("grjldaEdit");
						editRecord.grjlda(1);
						layer.closeAll();
					});
					return;
				} else {
					layer.alert("保存失败！", {icon:0,title:'提示'});
					layer.closeAll();
					return;
				}
			}
		});
	}
	
	function cancle(){
		layer.closeAll();
	}
	
	return {
		save : save,
		cancle : cancle
	};
})();
