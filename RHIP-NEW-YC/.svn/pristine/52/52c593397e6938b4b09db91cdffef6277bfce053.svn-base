/**
 * 慢病随访
 */
//即使修改了,也不用了
var edit_require = (function() {

		var DM_FOLLOWUP_TYPE_NORMAL = "2";
		var DM_FOLLOWUP_TYPE_STANDARD_ONE = "3";
		var DM_FOLLOWUP_TYPE_STANDARD_OTHER = "4";
		var personId = $("#dm-followup-personid").val();
		var diseaseId = $("#dm-followup-diseaseid").val();
		// 慢病类型
		var DM_HBP_TYPE = "1";
		var DM_DI_TYPE = "2";
		var DM_STROKE_TYPE = "3";
		var DM_CORONARY_TYPE = "4";
		var DM_TUMOR_TYPE = "5";
	
		var saveErrorMessage = {
			"100" : "保存失败",
			"200" : "保存失败",
			"300" : "保存失败",
			"400" : "保存失败",
			"500" : "保存失败",
			"501" : "请先填写首次随访",
			"502" : "保存失败"
		};
	
		// 脑卒中随访类型 常规 ,规范化(2种)
		var strokeFollowType = $("#dm-followup-stroke-followup-type").val();
	
		// 冠心病随访类型 常规 ,规范化(2种)
		var coronaryFollowType = $("#dm-followup-coronary-followup-type").val();
	
		// form与与其应的保存方法
		var formSaveMapping = {
			"dm-followup-hbp-from" : saveHbp,
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
	
		// form与与其应的初始化方法
		var formInitMapping = {
			"dm-followup-hbp-from" : initHBPForm,
			"dm-followup-di-from" : initDIForm,
			"dm-followup-tumor-first-from" : initTumorForm,
			"dm-followup-tumor-from" : initTumorForm,
			"dm-followup-last-from" : null,
			"dm-followup-stroke-normal-from" : initStrokeForm,
			"dm-followup-stroke-standard-from" : initStrokeForm,
			"dm-followup-stroke-standard-other-from" : initStrokeForm,
			"dm-followup-coronary-normal-from" : initStrokeForm,
			"dm-followup-coronary-standard-from" : initStrokeForm,
			"dm-followup-coronary-standard--otherfrom" : initStrokeForm
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
		
		$(function () {
			
		$("#followup-save-btn").on("click", save);// 保存
		$("#followup-back-btn").on("click", back);// 返回
		// 点击计划的操作
		$("#dm-followup-plan-hbp-list").on("click", ".deal-plan", vewHbp);
		$("#dm-followup-plan-di-list").on("click", ".deal-plan", viewDi);
		$("#dm-followup-plan-tumor-list").on("click", ".deal-plan", viewTumorByPlan);
		$("#dm-followup-plan-stroke-list").on("click", ".deal-plan", viewStroke);
		$("#dm-followup-plan-coronary-list").on("click", ".deal-plan", viewCoronary);
		// 初始化标签
		initTab(load1);

		// 年份变化重新加载计划
        $("#dm-followup-plan-hbp-form").on("onDatePickerChanged", function () {
            if (chceckPlanYear($("#dm-followup-plan-hbp-form"))) {
                emptyForm();
                loadHbp();
            }
        });
        $("#dm-followup-plan-di-form").on("onDatePickerChanged", function () {
            if (chceckPlanYear($("#dm-followup-plan-di-form"))) {
                emptyForm();
                loadDi();
            }
        });
        $("#dm-followup-plan-stroke-form").on("onDatePickerChanged", function () {
            if (chceckPlanYear($("#dm-followup-plan-stroke-form"))) {
                emptyForm();
                loadStroke();
            }
        });
        $("#dm-followup-plan-tumor-form").on("onDatePickerChanged", function () {
            if (chceckPlanYear($("#dm-followup-plan-tumor-form"))) {
                emptyForm();
                loadTumorPlan();
            }
        });
        $("#dm-followup-plan-coronary-form").on("onDatePickerChanged", function () {
            if (chceckPlanYear($("#dm-followup-plan-coronary-form"))) {
                emptyForm();
                loadCoronary();
            }
        });
		// 新增历史随访记录
		$("#dm-followup-hbp-add-history-data").click(function() {
			addHistoryData(DM_HBP_TYPE, "hbp");
		});
		$("#dm-followup-di-add-history-data").click(function() {
			addHistoryData(DM_DI_TYPE, "di");
		});
		$("#dm-followup-coronary-add-history-data").click(function() {
			addHistoryData(DM_CORONARY_TYPE, "coronary");
		});
		$("#dm-followup-stroke-add-history-data").click(function() {
			addHistoryData(DM_STROKE_TYPE, "stroke");
		});
		$("#dm-followup-tumor-add-history-data").click(function() {
			addHistoryData(DM_TUMOR_TYPE, "tumor");
		});
	
		});
		function chceckPlanYear($form){
        var start=$form.find("input[name='planYearStart']").val();
        var end=$form.find("input[name='planYearEnd']").val();
        if(start&&end){
            if(parseInt(start)>parseInt(end)){
            	layer.alert("开始年份不能大于结束年份！", {icon:0,title:'提示'})
                return false;
            }
        }
        return true;
    }

	// ============高血压====//
	// 新增历史随访记录
	function addHistoryData(disType, cdmType) {
		var personId = $("#dm-followup-personid").val();
		var planYear = $("#dm-followup-" + cdmType + "-plan-year").val();
		$("#").submitFormGetJson({
			url : '/cdm/standardization/followup/addHbpHistoryData',
			param : {
				personId : personId,
				planYear : planYear,
				disType : disType
			},
			callback : function(data) {
				if (data == "success")
				{
					switch (disType) {
						case DM_HBP_TYPE:
							loadHbp();
							break;
						case DM_DI_TYPE:
							loadDi();
							break;
						case DM_STROKE_TYPE:
							loadStroke();
							break;
						case DM_CORONARY_TYPE:
							loadCoronary();
							break;
						case DM_TUMOR_TYPE:
							loadTumor();
							break;
					}
				} else if (data == "existUnfinishedPlan")
				{
					layer.alert("存在未完成随访的计划！", {icon:0,title:'提示'});
				} else
				{
					layer.alert("新增随访计划失败！", {icon:0,title:'提示'});
				}
			}
		});
	}

	// 随访标签的默认执行方法,切换到高血压标签时,默认调用此方法
	function loadHbp() {
		$("#dm-followup-plan-hbp-form").submitFormLoadHtml({
			url : '/cdm/standardization/followup/plan',
			param : {
				personId : personId,
				disType : 1
			},
			callback : function() {
				changPlanStypeAndLoadToFollowup("dm-followup-plan-hbp-list");
			},
			insertDiv : "dm-followup-plan-hbp-list"
		});
	}

	// 点击计划后查看随访记录
	function vewHbp() {
		var plan = getPalnInfo(this);
		view("hbp", plan);
	}

	// 保存随访记录
	function saveHbp(currentFormId) {
		doSave("hbp", currentFormId, loadHbp);
	}

	function initHBPForm(formid) {
		// debugger;
		var $form = $("#" + formid);
		$form.find("input[name='curSymptom']").click(function() {
			inputOtherCurSymptom(formid);
		});
		inputOtherCurSymptom(formid);

		$form.find("#height").blur(function() {
			calBMI(formid);
		});
		$form.find("#bodyWeight").blur(function() {
			calBMI(formid);
		});
		$form.find("#nextFollowupBodyWeight").blur(function() {
			calBMI(formid);
		});
		var target = {
			referralHbpFlag : "#referralHbpSpan",
			referralDiFlag : "#referralDiSpan",
			medicateHbpFlag : "#medicateHbpSpan",
			medicateDiFlag : "#medicateDiSpan"
		};
		toggleDisable(target, "1");

		toggleDisable({
			curSymptomFlag : "#hbp-followup-curSymptomFlag"
		}, "2");

		addDrugAutoComplete("hbp","input[name='drugNameFirst'],input[name='drugNameSecond'],input[name='drugNameThird']");

	}

	function calBMI(formid) {
		var $form = $("#" + formid);
		var height = $form.find("#height").val();
		var bodyWeight = $form.find("#bodyWeight").val();
		var bmi = caculateBMI(height, bodyWeight);
		var nextFollowupBodyWeight = $form.find("#nextFollowupBodyWeight").val();
		var nextFollowupBmi = caculateBMI(height, nextFollowupBodyWeight);
		$form.find("#indexOfBodyCharacteristics").val(bmi);
		$form.find("#nextFollowupBmi").val(nextFollowupBmi);
	}

	function inputOtherCurSymptom(formid) {
		var $form = $("#" + formid);
		var selected = $form.find("input[name='curSymptom']:checked");
		var has = false;
		for ( var i = 0, size = selected.length; i < size; i++)
		{
			if ($(selected[i]).val() == "10")
			{
				has = true;
				break;
			}
		}
		if (has)
		{
			$form.find("input[name='otherSymptom']").show();
		} else
		{
			$form.find("input[name='otherSymptom']").hide().val("");
		}
	}

	// ============糖尿病====//

	function loadDi() {
		$("#dm-followup-plan-di-form").submitFormLoadHtml({
			url : '/cdm/standardization/followup/plan',
			param : {
				personId : personId,
				disType : 2
			},
			callback : function() {
				changPlanStypeAndLoadToFollowup("dm-followup-plan-di-list");
			},
			insertDiv : "dm-followup-plan-di-list"
		});
	}

	function viewDi() {
		var plan = getPalnInfo(this);
		view("di", plan);
	}

	function saveDi(currentFormId) {
		doSave("di", currentFormId, loadDi);
	}

	function initDIForm(formid) {
		// debugger;
		var $form = $("#" + formid);
		$form.find("input[name='curSymptom']").click(function() {
			inputOtherCurSymptom(formid);
		});
		inputOtherCurSymptom(formid);

		$form.find("#height").blur(function() {
			calBMI(formid);
		});
		$form.find("#bodyWeight").blur(function() {
			calBMI(formid);
		});
		$form.find("#nextFollowupBodyWeight").blur(function() {
			calBMI(formid);
		});
		var target = {
			referralHbpFlag : "#referralHbpSpan",
			referralDiFlag : "#referralDiSpan",
			medicateHbpFlag : "#medicateHbpSpan",
			medicateDiFlag : "#medicateDiSpan",
			insulinFlag : "#insulinSpan"
		};
		toggleDisable(target, "1");

		toggleDisable({
			curSymptomFlag : "#di-followup-curSymptomFlag"
		}, "2");
		
		addDrugAutoComplete("di","input[name='drugNameFirst'],input[name='drugNameSecond'],input[name='drugNameThird']");

	}

	// ============肿瘤====//
	// 默认选中的

	var initTumor = false;

	function loadTumor() {
		// viewTumor("1");
		// 执行 默认选中的标签的回调方法
		// alert($("#dm-followup-tumor-tab").find(".active a").length);
		// 在此执行初始化,解决异步问题

		if (!initTumor)
		{
			initMulTab("dm-followup-tumor-tab", "dm-followup-tumor-tabcontent", changTumorTab);
		}
		initTumor = true;
		$("#dm-followup-tumor-tab").find(".active a").click();
	}

	// 切换肿瘤内部标签
	function changTumorTab(target) {
		// alert(target);
		emptyForm();
		if (target == "con_tumor_1")
		{
			viewTumor("1"); // 首次随访
		} else if (target == "con_tumor_3")
		{
			viewTumor("3"); // 死亡随访
		} else if (target == "con_tumor_2")
		{
			loadTumorPlan(); // 正常下,显示计划列表
		}
	}

	// 点击计划查看对应的随访记录
	function viewTumorByPlan() {
		var plan = getPalnInfo(this);
		view("tumor", plan, {
			followupFlag : "2"
		});
	}

	// 肿瘤的随访计划
	function loadTumorPlan() {
		$("#dm-followup-plan-tumor-form").submitFormLoadHtml({
			url : '/cdm/standardization/followup/plan',
			param : {
				personId : personId,
				disType : 5
			},
			callback : function() {
				changPlanStypeAndLoadToFollowup("dm-followup-plan-tumor-list");
			},
			insertDiv : "dm-followup-plan-tumor-list"
		});
	}

	// 没有使用view方法,所以view方法callback方法需要处理
	function viewTumor(flag) {
		switch (flag) {
			case "1":

				view("tumor", null, {
					followupFlag : "1"
				}, "tumorFirstFollowupDiv");

				// 显示首次随访
				// $.loadHtmlByUrl({
				// url : '/cdm/standardization/followup/view/tumor',
				// param : {
				// personId : personId,
				// followupFlag : "1"
				// },
				// callback : function(data)
				// {
				// validatorMapping = {};
				// var formid = getSelectedFormId();
				// getValidator(formid);
				// },
				// insertDiv : "tumorFirstFollowupDiv"
				// });
				break;
			case "2":

				break;
			case "3":
				view("tumor", null, {
					followupFlag : "3"
				}, "tumorLastFollowupDiv");
				// // 显示首次随访
				// $.loadHtmlByUrl({
				// url : '/cdm/standardization/followup/view/tumor',
				// param : {
				// personId : personId,
				// followupFlag : "3"
				// },
				// callback : function(data)
				// {
				// validatorMapping = {};
				// var formid = getSelectedFormId();
				// getValidator(formid);
				// },
				// insertDiv : "tumorLastFollowupDiv"
				// });
				// break;
		}

	}

	function saveTumorFirst(currentFormId) {
		doSave("tumor", currentFormId, loadTumor, {
			followupFlag : "1"
		});
	}

	function saveTumor(currentFormId) {
		doSave("tumor", currentFormId, loadTumor, {
			followupFlag : "2"
		});
	}

	function saveTumorLast(currentFormId) {
		doSave("tumor", currentFormId, loadTumor, {
			followupFlag : "3"
		});
	}

	function initTumorForm(formid) {
		var target = {
			metastasis : "#metastasisPart",
			theriomaHistoryFlag : "#theriomaHistoryDetail",
			recur : "#recurTimeSpan"

		};
		toggleDisable(target, "2");

		var target2 = {
			cure : "#tumor-cure"
		};
		toggleDisable(target2, "1");

	}

	var target = {
		referralHbpFlag : "#referralHbpSpan"
	};
	toggleDisable(target, "1");
	function toggleDisable(target, show) {

		for ( var btn in target)
		{
			$("input[name=" + btn + "]").on("click", function() {
				var name = $(this).attr("name");
				if (show == $(this).val())
				{
					$(target[name]).show().find("input,select,textarea").prop("disabled",false);
				} else
				{
					$(target[name]).hide().find("input,select,textarea").prop("disabled",true).val([ "" ]);
				}
			});
		}
	}

	// ========脑卒中=========//

	function viewStroke() {
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

	function saveStrokeNormal(currentFormId) {
		doSave("stroke", currentFormId, loadStroke, {
			followupFlag : "2"
		});
	}

	function saveStrokeStandard(currentFormId) {
		doSave("stroke", currentFormId, loadStroke, {
			followupFlag : "3"
		});
	}

	function saveStrokeStandardOther(currentFormId) {
		doSave("stroke", currentFormId, loadStroke, {
			followupFlag : "4"
		});
	}

	function loadStroke() {
		$("#dm-followup-plan-stroke-form").submitFormLoadHtml({
			url : '/cdm/standardization/followup/plan/stroke',
			param : {
				personId : personId,
				disType : 3,
				followupFlag : strokeFollowType
			},
			callback : function() {
				changPlanStypeAndLoadToFollowup("dm-followup-plan-stroke-list");
			},
			insertDiv : "dm-followup-plan-stroke-list"
		});
	}

	function initStrokeForm(formid) {
		var target = {
			bpExamFlag : "#bpExamSbpDbpSpan",
			bloodGlucoseFalg : "#bloodGlucoseSpan"
		};
		toggleDisable(target, "1");
		toggleDrugs("bpDrugFlag");
		toggleDrugs("bgDrugFlag");
		toggleDrugs("bfDrugFlag");
	}

	function toggleDrugs(btn) {
		$("input[name=" + btn + "]").on("click", function() {
			var name = $(this).attr("name");
			var value = $(this).val();
			if (value == "1")
			{
				$("#" + name + "Span1").show();
				$("#" + name + "Span2").hide();
				$("#" + name + "Span2 input").val([ "" ]);
			} else if (value == "2")
			{
				$("#" + name + "Span1").hide();
				$("#" + name + "Span1 input").val("");
				$("#" + name + "Span2").show();
			} else
			{
				$("#" + name + "Span1").hide();
				$("#" + name + "Span2").hide();
				$("#" + name + "Span1 input").val("");
				$("#" + name + "Span2 input").val([ "" ]);
			}
		});
	}

	// ========冠心病=========//

	function viewCoronary() {
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

	function saveCoronaryNormal(currentFormId) {
		doSave("stroke", currentFormId, loadCoronary, {
			followupFlag : "2"
		});
	}

	function saveCoronaryStandard(currentFormId) {
		doSave("stroke", currentFormId, loadCoronary, {
			followupFlag : "3"
		});
	}

	function saveCoronaryStandardOther(currentFormId) {
		doSave("stroke", currentFormId, loadCoronary, {
			followupFlag : "4"
		});
	}

	function loadCoronary() {
		$("#dm-followup-plan-coronary-form").submitFormLoadHtml({
			url : '/cdm/standardization/followup/plan/stroke',
			param : {
				personId : personId,
				disType : 4,
				followupFlag : coronaryFollowType
			},
			callback : function() {
				changPlanStypeAndLoadToFollowup("dm-followup-plan-coronary-list");
			},
			insertDiv : "dm-followup-plan-coronary-list"
		});
	}

	// ============公用方法====//

	function saveOther() {
		layer.alert("功能开发中...", {icon:0,title:'提示'});
	}

	// 获取选中的计划信息
	function getPalnInfo(selected) {
		var $this = $(selected);
		var followupId = $this.data("followupid");
		var planId = $this.data("planid");
		var followupFlag = $this.data("followupflag");
		return {
			followupId : followupId,
			planId : planId,
			followupFlag : followupFlag
		};
	}

	function getPalnInfo2(selected) {
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
	function load1(target) {
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
	function view(name, plan, param, insertDiv) {
		var p = {
			personId : personId
		};
		if (plan)
		{
			p.followupId = plan.followupId;
			p.planId = plan.planId;
		}

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
			callback : function(data) {
				validatorMapping = {};
				var formid = getSelectedFormId();
				callbackAfterLoad(formid);
			}

		});
	}

	// from 加载后回调
	function callbackAfterLoad(formid) {
		// 验证初始化
		getValidator(formid);
		// 页面显示操作
		var func = formInitMapping[formid];
		if (func)
		{
			func(formid);
		}

	}

	// 保存随访记录
	function save() {
		var currentFormId = getSelectedFormId();
		var func;
		if (currentFormId)
		{
			func = formSaveMapping[currentFormId];
		} else
		{
			layer.alert("请填写后保存！", {icon:0,title:'提示'});
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
			// msgUtil.alert("数据验证失败");
			return;
		}
		func(currentFormId);
	}

	// 获取验证器,每次刷新前均缓存
	function getValidator(currentFormId) {
		var v = validatorMapping[currentFormId];
		if (!v)
		{
			// alert(v);
			v = $("#" + currentFormId).easyValidate();
			// var func=validateOtherInputFactorty(currentFormId);
			// v.addExtension("checkother",func);
			validatorMapping[currentFormId] = v;
		}

		return v;
	}

	// 执行保存随访记录
	// url : '/cdm/standardization/followup/save/' + name,
	// name同上
	function doSave(name, currentFormId, callback, param) {
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
            wait:true,
			callback : function(data) {
				if (data && isArray(data))
				{
					var tip = "";
					var temp = "";
					var size = data.length;
					for ( var i = 0; i < size; i++)
					{
						temp = saveErrorMessage[data[i]];
						if (temp)
						{
							tip += temp + "!<br >";
						}
					}

					if (size < 1)
					{
						layer.alert("保存成功！", {icon:0,title:'提示'});
						callback();
					} else
					{
						layer.alert(tip, {icon:0,title:'提示'});
					}
				} else if ("failure" == data)
				{
					layer.alert("新增随访日期不能大于或等于已存在随访计划的最小日期！", {icon:0,title:'提示'});
				} else if (true == data)
				{
					layer.alert("保存成功！", {icon:0,title:'提示'});
					callback();
				} else
				{
					layer.alert("保存失败！", {icon:0,title:'提示'});
				}
			}
		});
	}

	function isArray(obj) {
		return Object.prototype.toString.call(obj) === '[object Array]';
	}

	// 获取当前操作的form的id
	function getSelectedFormId() {
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
	function changPlanStypeAndLoadToFollowup(formid) {
		var $form = $("#" + formid);
		$("tr.to-follow-tr").css("color", "#ed1941");
		$("tr.followed-tr").css("color", "#1d953f");
		var $first = $form.find("tr.to-follow-tr:first span.deal-plan ");
		var $addFirst = $form.find("tr.add-plan:first span.deal-plan ");
		if ($addFirst.length > 0)
		{
			$addFirst.click();
		} else
		{
			if ($first.length > 0)
			{
				$first.click();
			} else
			{
				$form.find("tr.followed-tr:last span.deal-plan").click();
			}
		}
	}

	function initTab(callback) {
		var $bar = $("#tags");
		$bar.find("a").on("click", function(event) {
			var $this = $(this);
			var target = $this.data("target");
			$bar.find("li.selectTag").removeClass("selectTag");
			$this.parent().addClass("selectTag");
			$("#tagContent").find(".tab-content").hide();
			$("#" + target).show();
			callback(target);
		});
		$bar.find("a:first").click();
	}

	function initMulTab(tab, content, callback) {
		var $bar = $("#" + tab);
		$bar.find("a.tabbtn").on("click", function(event) {
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

	function back() {
		$("#cdm-manage-input-box").hide();
		$("#cdm-manage-list-box").show();
	}

	function emptyForm() {
		// for ( var form in formSaveMapping)
		// {
		// $("#" + form).empty();
		// }
		$("#dm-followup-main").find(".dm-followup-from-content").empty();
	}

	function validateOtherInputFactorty(fromid) {
		return function() {
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

	// 根据身高、体重计算BMI值
	function caculateBMI(height, weight) {
		var bmi = null;
		if (height && weight)
		{
			height = height * 0.01;
			bmi = (weight / (height * height)).toFixed(1);
		}
		return bmi;
	}

	function addDrugAutoComplete(type,query) {
		$.getJsonByUrl({
			url : "/cdm/standardization/followup/drug/"+type,
			param : {
			
			},
			callback : function(data) {
				var $drugInput = $(query);
				$drugInput.autocomplete(data, {
					minChars : 0,
					width : 250,
					max : 100,
					autoFill : false,
					matchContains : true,
					formatItem : function(row, i, max) {
						return row.itemName;
					},
					formatMatch : function(row, i, max) {
						return row.itemName + row.pyCode;
					},
					formatResult : function(row) {
						return row.itemName;
					}
				});
			}
		});
	}
})();
