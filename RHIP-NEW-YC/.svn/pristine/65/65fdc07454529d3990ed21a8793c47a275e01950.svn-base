//报卡上报
var ismReportCard = (function()
{
	var validate = null;
	var oldPersonIdCard = null;
	$(function()
	{
		validate = $("#ism-report-input-form").easyValidate();

		// 输入身份证自动查询相关信息
		if($("#reportFlag").val()!=2){
			$.Placeholder.init({
				query : "#ism_report_idcard",
				callback : queryPerson
			});
		}
		// 保存按钮
		$("#ism-report-input-save-btn").on("click", save);
		
		$("#occurReasonOther").hide();
		$("#occurPalceOther").hide();
		$("#occurBehaviorOther").hide();
		$("#natureOther").hide();
		$("#partOther").hide();
		$("#resultOther").hide();
		//点击出现原因输入框
		
		$("input[name='occurReasonCode']").on("change",function(){
			add("occurReasonCode","occurReasonOther","14");
		});
		$("input[name='occurPalceCode']").on("change",function(){
			add("occurPalceCode","occurPalceOther","10");
		});
		$("input[name='occurBehaviorCode']").on("change",function(){
			add("occurBehaviorCode","occurBehaviorOther","7");
		});
		$("input[name='natureCode']").on("change",function(){
			add("natureCode","natureOther","9");
		});
		$("input[name='partCode']").on("change",function(){
			add("partCode","partOther","11");
		});
		$("input[name='result']").on("change",function(){
			add("result","resultOther","4");
		});
	 if($("#reportFlag").val()=="3"){
		 add("occurReasonCode","occurReasonOther","14");
		 add("occurPalceCode","occurPalceOther","10");
		 add("occurBehaviorCode","occurBehaviorOther","7");
		 add("natureCode","natureOther","9");
		 add("partCode","partOther","11");
		 add("result","resultOther","4");
	}
	});
	function add (name,spanid,target){
		if(compareTo(target,name)){
			$("#"+spanid).show();
		}else{
			$("#"+spanid).hide();
		}
	}
	function compareTo(value,param){
		var $checked = $("input[name='" + param + "']:checked");
		for ( var i = 0, size = $checked.length; i < size; i++)
		{
			var dependValue = $($checked[i]).val();
			if (dependValue == value)
			{
				return true;
			}
		}
		return false;
	}
	

	// 根据输入的身份证设置相关信息
	function queryPerson(input)
	{
		var idCard = $("#ism_report_idcard").val();
		if (validate.validate("idcard") && oldPersonIdCard != idCard)
		{
			oldPersonIdCard = idCard;
			$.getJsonByUrl({
				url : "/ism/reportCard/load",
				param : {
					"personInfo.idcard" : idCard.toUpperCase()
				},
				wait : true,
				callback : function(data)
				{
					setPersonData(data);
				}
			});
		}

	}

	// 设置人员信息
	function setPersonData(data)
	{
		if (data)
		{
			$('#ism_report_name').val(data.name);
			$('#gender').val(data.gender);
			$('#age').val(data.age);
			$('#registration').val(data.registration);
			$('#education').val(data.education);
			$('#occupation').val(data.occupation);
			$('#ism_report_idcard').val(data.idcard);
		} else
		{
			$('#ism_report_name').val("");
			// 根据身份证计算性别
			try
			{
				$('#gender').val(IC.getGender(idcard));
			} catch (e)
			{
				$('#gender').val("");
			}
			$('#ism_report_smpiId').val("");
			$('#age').val("");
			$('#registration').val("");
			$('#education').val("");
			$('#occupation').val("");
		}
	}


	// 重新加载报卡页面
	function reload()
	{
		baseLayoutLoad.loadMenuContent(contextPath + '/ism/reportCard/report');
	}

	// 保存报卡
	function save(event)
	{
		// 清除身份证输入框的提示
		var $idcard = $("#ism_report_idcard");
		if ($idcard.val() == $idcard.attr("placeholder"))
		{
			$idcard.val("");
		}

		// 验证
		var result = validate.validateForm();
		if (!result)
		{
			return;
		}

		// 保存
		$("#ism-report-input-form").submitFormGetJson({
			url : "/ism/reportCard/save",
			param : {},
			wait : true,
			callback : function(data)
			{
				if ("success" == data)
				{
					layer.alert("上报成功！", {icon:0,title:'提示'});
					reload();
				} else if ("error" == data)
				{
					layer.alert("上报失败！", {icon:0,title:'提示'});
				} 
			}
		});
	}
	//审核操作
	function approval(i){
		// 清除身份证输入框的提示
		var $idcard = $("#ism_report_idcard");
		if ($idcard.val() == $idcard.attr("placeholder"))
		{
			$idcard.val("");
		}
		if(i==1){
			var result = validate.validateForm();
			if (!result)
			{
				return;
			}
		}
		//审核通过更新状态
		$("#ism-report-input-form").submitFormGetJson({
			url : "/ism/reportCard/updateApp",
			wait : true,
			param : {
				"operateFlag" : i,
			},
			callback : function(data)
			{
				if ("success" == data)
				{
					layer.alert("审核通过！", {icon:0,title:'提示'});
				} else if ("back" == data)
				{
					layer.alert("退回成功！", {icon:0,title:'提示'});
				} 
				back();
			}
		});
	}
	function back(event)
	{
		$("#list_view").show();
		$("#input_view").hide();
		ismReportCardList.refresh();
	}
	
	function approvalDialog(id) { 
		var dialogObj = {
				url : contextPath + "/ism/reportCard/appDetails",
				param : {id:id},
				title : "操作记录"
			};
		$.dialog(dialogObj);		
	};
	
	return {
		approval:approval,
		back:back,
		approvalDialog:approvalDialog
	};
	
})();