/**
 * 慢病随访
 */
var brwDmFollowupEdit = (function()
{
	var DM_FOLLOWUP_TYPE_NORMAL = "2";
	var DM_FOLLOWUP_TYPE_STANDARD_ONE = "3";
	var DM_FOLLOWUP_TYPE_STANDARD_OTHER = "4";
	var personId = $("#dm-followup-personid").val();
	var diseaseId = $("#dm-followup-diseaseid").val();

	// 脑卒中随访类型 常规 ,规范化(2种)
	var strokeFollowType = $("#dm-followup-stroke-followup-type").val();

	// 冠心病随访类型 常规 ,规范化(2种)
	var coronaryFollowType = $("#dm-followup-coronary-followup-type").val();

	// form与与其应的保存方法
	var formSaveMapping = {
//		"dm-followup-hbp-from" : saveHbp,
		"dm-followup-di-from" : saveDi,
		"dm-followup-tumor-first-from" : saveTumorFirst,
		"dm-followup-tumor-from" : saveTumor,
		"dm-followup-last-from" : saveTumorLast,
		"dm-followup-stroke-normal-from" : saveStrokeNormal,
		"dm-followup-stroke-standard-from" : saveStrokeStandard,
		"dm-followup-stroke-standard-other-from" : saveStrokeStandardOther,
		"dm-followup-coronary-normal-from" : saveCoronaryNormal,
		"dm-followup-coronary-standard-from" : saveCoronaryStandard,
		"dm-followup-coronary-standard--otherfrom" : saveCoronaryStandardOther
	};

	// form的验证器缓存
	var validatorMapping = {};

	// 疾病类型tab切换,默认的操作
	var loadMapping = {
		"tagContent0" : loadHbp,
		"tagContent1" : loadDi,
		"tagContent2" : loadTumor,
		"tagContent3" : loadStroke,
		"tagContent4" : loadCoronary
	};

	$(function()
	{
//		$("#followup-save-btn").on("click", save);// 保存
//		$("#followup-back-btn").on("click", back);// 返回
		// 点击计划的操作
		$("#dm-followup-plan-hbp-list").on("click", ".plan-tr", vewHbp);
		$("#dm-followup-plan-di-list").on("click", ".plan-tr", viewDi);
		$("#dm-followup-plan-tumor-list").on("click", ".plan-tr", viewTumorByPlan);
		$("#dm-followup-plan-stroke-list").on("click", ".plan-tr", viewStroke);
		$("#dm-followup-plan-coronary-list").on("click", ".plan-tr", viewCoronary);
		// 初始化标签
		initTab(load);
		initMulTab("dm-followup-tumor-tab", "dm-followup-tumor-tabcontent", changTumorTab);
		// 年份变化重新加载计划
		$("#dm-followup-plan-hbp-form").on("onDatePickerChanged", loadHbp);
		$("#dm-followup-plan-di-form").on("onDatePickerChanged", loadDi);
		$("#dm-followup-plan-stroke-form").on("onDatePickerChanged", loadStroke);
		$("#dm-followup-plan-tumor-form").on("onDatePickerChanged", loadTumorPlan);
		$("#dm-followup-plan-coronary-form").on("onDatePickerChanged", loadCoronary);

	});

	// ============高血压====//

	// 随访标签的默认执行方法,切换到高血压标签时,默认调用此方法
	function loadHbp()
	{
		$("#dm-followup-plan-hbp-form").submitFormLoadHtml({
			url : '/cdm/standardization/followup/plan',
			param : {
				personId : personId,
				disType : 1
			},
			callback : function()
			{
				changPlanStypeAndLoadToFollowup("dm-followup-plan-hbp-list");
			},
			insertDiv : "dm-followup-plan-hbp-list"
		});
	}

	// 点击计划后查看随访记录
	function vewHbp()
	{
		var plan = getPalnInfo(this);
		view("hbp", plan);
	}

//	// 保存随访记录
//	function saveHbp(currentFormId)
//	{
//		doSave("hbp", currentFormId, loadHbp);
//	}

	// ============糖尿病====//

	function loadDi()
	{
		$("#dm-followup-plan-di-form").submitFormLoadHtml({
			url : '/cdm/standardization/followup/plan',
			param : {
				personId : personId,
				disType : 2
			},
			callback : function()
			{
				changPlanStypeAndLoadToFollowup("dm-followup-plan-di-list");
			},
			insertDiv : "dm-followup-plan-di-list"
		});
	}

	function viewDi()
	{
		var plan = getPalnInfo(this);
		view("di", plan);
	}

	function saveDi(currentFormId)
	{
		doSave("di", currentFormId, loadDi);
	}

	// ============肿瘤====//
	// 默认选中的
	function loadTumor()
	{
		// viewTumor("1");
		// 执行 默认选中的标签的回调方法
		$("#dm-followup-tumor-tab").find(".active a").click();
	}

	// 切换肿瘤内部标签
	function changTumorTab(target)
	{
		emptyForm();
		if (target == "con_tumor_1")
		{
			viewTumor("1");
		} else if (target == "con_tumor_3")
		{
			viewTumor("3");
		} else if (target == "con_tumor_2")
		{
			loadTumorPlan();
		}
	}

	// 点击计划查看对应的随访记录
	function viewTumorByPlan()
	{
		var plan = getPalnInfo(this);
		view("tumor", plan, {
			followupFlag : "2"
		});
	}

	// 肿瘤的随访计划
	function loadTumorPlan()
	{
		$("#dm-followup-plan-tumor-form").submitFormLoadHtml({
			url : '/cdm/standardization/followup/plan',
			param : {
				personId : personId,
				disType : 5
			},
			callback : function()
			{
				changPlanStypeAndLoadToFollowup("dm-followup-plan-tumor-list");
			},
			insertDiv : "dm-followup-plan-tumor-list"
		});
	}

	//没有使用view方法,所以view方法callback方法需要处理
	function viewTumor(flag)
	{
		switch (flag) {
			case "1":
				// 显示首次随访
				$.loadHtmlByUrl({
					url : '/cdm/standardization/followup/view/tumor',
					param : {
						personId : personId,
						followupFlag : "1"
					},
					callback : function(data)
					{
						validatorMapping = {};
						var formid=getSelectedFormId();
						getValidator(formid);
					},
					insertDiv : "tumorFirstFollowupDiv"
				});
				break;
			case "2":

				break;
			case "3":
				// 显示首次随访
				$.loadHtmlByUrl({
					url : '/cdm/standardization/followup/view/tumor',
					param : {
						personId : personId,
						followupFlag : "3"
					},
					callback : function(data)
					{
						validatorMapping = {};
						var formid=getSelectedFormId();
						getValidator(formid);
					},
					insertDiv : "tumorLastFollowupDiv"
				});
				break;
		}

	}

	function saveTumorFirst(currentFormId)
	{
		doSave("tumor", currentFormId, loadTumor, {
			followupFlag : "1"
		});
	}
	function saveTumor(currentFormId)
	{
		doSave("tumor", currentFormId, loadTumor, {
			followupFlag : "2"
		});
	}
	function saveTumorLast(currentFormId)
	{
		doSave("tumor", currentFormId, loadTumor, {
			followupFlag : "3"
		});
	}

	// ========脑卒中=========//

	function viewStroke()
	{
		var plan = getPalnInfo(this);
		var followupFlag = plan.followupFlag;
		//
		if (!followupFlag)
		{
			followupFlag = strokeFollowType;
		}
		view("stroke", plan, {
			followupFlag : followupFlag,
			diseaseType : "3"
		});
	}

	function saveStrokeNormal(currentFormId)
	{
		doSave("stroke", currentFormId, loadStroke, {
			followupFlag : "2"
		});
	}
	function saveStrokeStandard(currentFormId)
	{
		doSave("stroke", currentFormId, loadStroke, {
			followupFlag : "3"
		});
	}
	function saveStrokeStandardOther(currentFormId)
	{
		doSave("stroke", currentFormId, loadStroke, {
			followupFlag : "4"
		});
	}

	function loadStroke()
	{
		$("#dm-followup-plan-stroke-form").submitFormLoadHtml({
			url : '/cdm/standardization/followup/plan/stroke',
			param : {
				personId : personId,
				disType : 3,
				followupFlag : strokeFollowType
			},
			callback : function()
			{
				changPlanStypeAndLoadToFollowup("dm-followup-plan-stroke-list");
			},
			insertDiv : "dm-followup-plan-stroke-list"
		});
	}

	// ========冠心病=========//

	function viewCoronary()
	{
		var plan = getPalnInfo(this);
		var followupFlag = plan.followupFlag;
		//
		if (!followupFlag)
		{
			followupFlag = coronaryFollowType;
		}
		view("stroke", plan, {
			followupFlag : followupFlag,
			diseaseType : "4"
		}, "coronaryFollowupInputDiv");
	}

	function saveCoronaryNormal(currentFormId)
	{
		doSave("stroke", currentFormId, loadCoronary, {
			followupFlag : "2"
		});
	}
	function saveCoronaryStandard(currentFormId)
	{
		doSave("stroke", currentFormId, loadCoronary, {
			followupFlag : "3"
		});
	}
	function saveCoronaryStandardOther(currentFormId)
	{
		doSave("stroke", currentFormId, loadCoronary, {
			followupFlag : "4"
		});
	}

	function loadCoronary()
	{
		$("#dm-followup-plan-coronary-form").submitFormLoadHtml({
			url : '/cdm/standardization/followup/plan/stroke',
			param : {
				personId : personId,
				disType : 4,
				followupFlag : coronaryFollowType
			},
			callback : function()
			{
				changPlanStypeAndLoadToFollowup("dm-followup-plan-coronary-list");
			},
			insertDiv : "dm-followup-plan-coronary-list"
		});
	}

	// ============公用方法====//

	function saveOther()
	{
		layer.alert("功能开发中...", {icon:0,title:'提示'});
	}
	// 获取选中的计划信息
	function getPalnInfo(selected)
	{
		var $this = $(selected);
		var followupId = $this.find(".followup-id").val();
		var planId = $this.find(".plan-id").val();
		var followupFlag = $this.find(".followup-flag").val();
		return {
			followupId : followupId,
			planId : planId,
			followupFlag : followupFlag
		};
	}

	// 加载页面load方法
	function load(target)
	{
		var func;
		if (target)
		{
			func = loadMapping[target];
		} else
		{
			layer.alert("请刷新页面重新操作！", {icon:0,title:'提示'});
			return;
		}
		if (!func)
		{
			layer.alert("请重新打开页面！", {icon:0,title:'提示'});
			return;
		}
		emptyForm();
		func();
	}

	// 查看随访记录公用方法
	// url : '/cdm/standardization/followup/view/' + name,
	// name表示病的类型,如hbp,对应到后台url
	function view(name, plan, param, insertDiv)
	{
		var p = {
			personId : personId,
			followupId : plan.followupId,
			planId : plan.planId
		};
		if (param)
		{
			$.extend(p, param);
		}
		if (!insertDiv)
		{
			insertDiv = name + "FollowupInputDiv";
		}
		$.loadHtmlByUrl({
			url : '/cdm/standardization/followup/view/' + name,
			param : p,
			insertDiv : insertDiv,
			callback : function(data)
			{
				validatorMapping = {};
				var formid=getSelectedFormId();
				getValidator(formid);
			}

		});
	}

	// 保存随访记录
	function save()
	{
		var currentFormId = getSelectedFormId();
		var func;
		if (currentFormId)
		{
			func = formSaveMapping[currentFormId];
		} else
		{
			layer.alert("请选择随访计划后保存！", {icon:0,title:'提示'});
			return;
		}
		if (!func)
		{
			layer.alert("保存方法错误！", {icon:0,title:'提示'});
			return;
		}
		var validate = getValidator(currentFormId);
		var result = validate.validateForm();
		if (!result)
		{
			// layer.alert("数据验证失败");
			return;
		}
		func(currentFormId);
	}

	// 获取验证器,每次刷新前均缓存
	function getValidator(currentFormId)
	{
		var v = validatorMapping[currentFormId];
		if (!v)
		{
			// alert(v);
			v = $("#" + currentFormId).easyValidate();
//			var func=validateOtherInputFactorty(currentFormId);
//			v.addExtension("checkother",func);
			validatorMapping[currentFormId] = v;
		}

		return v;
	}

	// 执行保存随访记录
	// url : '/cdm/standardization/followup/save/' + name,
	// name同上
	function doSave(name, currentFormId, callback, param)
	{
		var p = {
			personId : personId
		};
		if (param)
		{
			$.extend(p, param);
		}
		$("#" + currentFormId).submitFormGetJson({
			url : '/cdm/standardization/followup/save/' + name,
			param : p,
			callback : function(data)
			{
				layer.alert("保存成功！", {icon:0,title:'提示'});
				callback();
			}
		});
	}

	// 获取当前操作的form的id
	function getSelectedFormId()
	{
		var currentForm = $("#tagContent").find("form.dm-followup-from").not(":hidden");
		if (currentForm.length < 1)
		{
			return null;
		}
		return currentForm.attr("id");
	}

	// 修改计划的样式,
	// 点击第一条没有随访的记录
	// 如果全部随访,则单击最后一条
	function changPlanStypeAndLoadToFollowup(formid)
	{
		var $form = $("#" + formid);
		$("tr.to-follow-tr").css("color", "#ed1941");
		$("tr.followed-tr").css("color", "#1d953f");
		var $first = $form.find("tr.to-follow-tr:first");
		if ($first.length > 0)
		{
			$first.click();
		} else
		{
			$form.find("tr.followed-tr:last").click();
		}
	}

	function initTab(callback)
	{
		var $bar = $("#tags");
		$bar.find("a").on("click", function(event)
		{
			var $this = $(this);
			var target = $this.data("target");
			$bar.find("li.selectTag").removeClass("selectTag");
			$this.parent().addClass("selectTag");
			$("#tagContent").children().hide();
			$("#" + target).show();
			callback(target);
		});
		$bar.find("a:first").click();
	}

	function initMulTab(tab, content, callback)
	{
		var $bar = $("#" + tab);
		$bar.find("a.tabbtn").on("click", function(event)
		{
			var $this = $(this);
			var target = $this.data("target");
			$bar.find("span.active").removeClass("active");
			$this.parent().addClass("active");
			$("#" + content).children().hide();
			$("#" + target).show();
			callback(target);
		});
		// $bar.find("a:first").click();
	}

//	function back()
//	{
//		$("#cdm-manage-input-box").hide();
//		$("#cdm-manage-list-box").show();
//	}
	
	function emptyForm(){
		for(var form in formSaveMapping){
			$("#"+form).empty();
		}
	}

	function validateOtherInputFactorty(fromid)
	{
		return function()
		{
			var $form = $("#" + fromid);
			var $other = $form.find("input[name='curSymptom']:last");
			if ($other.prop("checked"))
			{
				if ($form.find("input[name='otherSymptom']").val())
				{
					return true;
				} else
				{
					return false;
				}
			}
			return true;
		};
	}

})();