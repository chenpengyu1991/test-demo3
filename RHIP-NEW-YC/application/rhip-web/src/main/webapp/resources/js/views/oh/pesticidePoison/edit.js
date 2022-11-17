var editRecord = (function() {
	var validate = null;
	var oldPersonIdCard = null;
	var operationType = $("#operationType").val();
	$(function() {
		validate = $("#edit_form").easyValidate();
		var checkFlag = $("#checkFlag").val();
		if(checkFlag=='1'){
			$("#diagnosisOrg").hide();
		}else
			$("#otherOrg").hide();
		$("#otherFlag").bind('click',function(){
			if($("#otherFlag").attr("checked")){
				$("#diagnosisOrg").hide();
				$("#otherOrg").show();
			}else{
				$("#otherOrg").hide();
				$("#diagnosisOrg").show();
			}
			
		});
//		subSelect();
		if (operationType == '1') {
			$(".radioGroup").attr("disabled", "disabled");
			$("#pastreet").attr("disabled", "disabled");
			$("#patownShip").attr("disabled", "disabled");
			$("#education").attr("disabled", "disabled");
			$("#drugTypes").attr("disabled", "disabled");
			$("#poisonType").attr("disabled", "disabled");
			$("#poisonReason").attr("disabled", "disabled");
			$("#poisonLevel").attr("disabled", "disabled");
			$("#outcome").attr("disabled", "disabled");
			$("#diagnosisOrg").attr("disabled", "disabled");
			$("#otherFlag").attr("disabled", "disabled");
			$("#gender").attr("disabled", "disabled");
			$("#poisonReasonCode").attr("disabled", "disabled");
			$("#poisonReasonSubcode").attr("disabled", "disabled");
		} else {
			$.Placeholder.init({
				query : "#idcard",
				callback : queryPerson
			});
		}
		$("#outcome").bind('change',function(){
			initDeathDate();
		});
		initDeathDate();
	});

	function initDeathDate(){
		if($("#outcome").val()=='4'){
			$("#deathDate").removeAttr("disabled");
			$(".deathDate").show();
		}else{
			$("#deathDate").val("");
			$("#deathDate").attr("disabled",true);
			$(".deathDate").hide();
		}
	}
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
		$("#education").val(data.education);
		$("#patownShip").val(data.patownShip);
		$("#age").val(getAge(idcard));
		var patownShipIdd = $('#patownShip').attr("idd");
		if (patownShipIdd)
			orgUtil.getVillageOpting(patownShipIdd.replace("townId", ""), "pastreet", data.pastreet);
	}
	
	/*如果获取患者信息失败，根据身份证号码获取性别、年龄*/
	function setIcData(idcard){
		var gender = IC.getGender(idcard);
		if(!$.isEmpty(gender)){
			$('#gender').val(gender);
		}
		$("#age").val(getAge(idcard));
	}
	
	//根据身份证号获取年龄
	function getAge(idcard){
		var bornYear = idcard.substring(6,10);
		var currentYear = new Date().getFullYear();
		var age = parseInt(currentYear)-parseInt(bornYear);
		return age;
	}
	
	function subSelect(){
		var poisonReasonCode = $("#poisonReasonCode").val();
		var poisonReasonSubcode = $("#poisonReasonSubcode").val();
		var option = {
				url : "/oh/poisonReport/subSelect",
				param : {
					poisonReasonCode : poisonReasonCode,
					poisonReasonSubcode : poisonReasonSubcode
				},
				callback : function(data){
					$("#poisonReasonSubcode").remove();
					$("#poisonReasonDiv").append(data);
					if(operationType=='1')
						$("#poisonReasonSubcode").attr("disabled", "disabled");
				}
		};
		$.getJsonByUrl(option);
	}

	// 保存记录
	function save() {
		var result = validate.validateForm();
		if (!result) {
			return;
		}

		$("#edit_form").submitFormLoadHtml({
			url : "/oh/poisonReport/save",
			callback : function(data) {
				if (data == '1') {
					layer.alert("保存成功！", {icon:0,title:'提示'}, function(index) {
						$.removeDialog("editDialog");
						recordsPerform(1);
						layer.closeAll();
					});
					return;
				} else if(data == '-2'){
					layer.alert("卡片序列号已经存在,保存失败！", {icon:0,title:'提示'});
				}else {
					layer.alert("保存失败！", {icon:0,title:'提示'}, function(index) {
						$.removeDialog("editDialog");
						recordsPerform(1);
						layer.closeAll();
					});
					return;
				}
			}
		});
	}

	// 取消
	function cancle() {
		$.removeDialog("editDialog");
	}

	function recordsPerform(indexPage) {
		var createBegin = new Date($("#startDate").val());
		var createEnd = new Date($("#endDate").val());

		if (createBegin > createEnd) {
			layer.alert("开始时间不能大于结束时间！", {icon:0,title:'提示'});
		} else {
			var searchObj = {
				url : "/oh/poisonReport/records",
				insertDiv : "info_records",
				param : {
					indexPage : indexPage
				}
			};
			$("#form_search").submitFormLoadHtml(searchObj);
		}
	}
	
	//审核
	function checkRecord(id){
		layer.confirm("确认审核？", {icon:1, title:'确认提示'}, function(index){
			var option = {
				url : "/oh/poisonReport/check",
			    param : {
			    	id : id,
			    	verifyState : "1"
			    },
			    callback : function(data){
			    	if(data=='1'){
			    		layer.alert("审核成功！", {icon:0,title:'提示'});
			    		$.removeDialog("editDialog");
			    		recordsPerform(1);
						layer.closeAll();
			    		return;
			    	}else{
			    		layer.alert("审核失败！", {icon:0,title:'提示'});
						layer.closeAll();
			    		return;
			    	}
			    }
			};
			$.getJsonByUrl(option);
			layer.close(index);
		});
	}
	
	//审核退回
	function unCheckRecord(id){
		layer.confirm("确认退回？", {icon:1, title:'确认提示'}, function(index){
			if($("#verifyState").val()=='2'){
				layer.alert("该记录已被退回！", {icon:0,title:'提示'});
				return;
			}
			var option = {
				url : "/oh/poisonReport/check",
			    param : {
			    	id : id,
			    	verifyState : "2"
			    },
			    callback : function(data){
			    	if(data=='1'){
			    		layer.alert("退回成功！", {icon:0,title:'提示'});
			    		$.removeDialog("editDialog");
			    		recordsPerform(1);
						layer.closeAll();
			    		return;
			    	}else{
			    		layer.alert("退回失败！", {icon:0,title:'提示'});
						layer.closeAll();
			    		return;
			    	}
			    }
			};
			$.getJsonByUrl(option);
			layer.close(index);
		});
	}
	

	return {
		save : save,
		cancle : cancle,
		checkRecord:checkRecord,
		unCheckRecord:unCheckRecord,
		subSelect : subSelect
	};
})();
