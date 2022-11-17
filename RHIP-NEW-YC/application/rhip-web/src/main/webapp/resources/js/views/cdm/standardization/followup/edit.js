/**
 * 慢病随访
 */
var dmFollowupEdit = (function() {
	var DM_FOLLOWUP_TYPE_NORMAL = "2";
	var DM_FOLLOWUP_TYPE_STANDARD_ONE = "3";
	var DM_FOLLOWUP_TYPE_STANDARD_OTHER = "4";
	//var personId = $("#dm-followup-personid").val();
	//var diseaseId = $("#dm-followup-diseaseid").val();
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
        $("#yitiji").on("click", showytj);//一体机数据页面
		$("#followup-save-btn").on("click", save);// 保存
		$("#followup-print-btn").on("click", print);// 保存
		$("#followup-back-btn").on("click", function () {
			layer.confirm("确认离开？",function(index){
				layer.close(index);
				back();
			});
		});// 返回
		// 点击计划的操作
		$("#dm-followup-plan-hbp-list").on("click", ".deal-plan", vewHbp);
		$("#dm-followup-plan-di-list").on("click", ".deal-plan", viewDi);
		$("#dm-followup-plan-tumor-list").on("click", ".deal-plan", viewTumorByPlan);
		$("#dm-followup-plan-stroke-list").on("click", ".deal-plan", viewStroke);
		$("#dm-followup-plan-coronary-list").on("click", ".deal-plan", viewCoronary);
		// 初始化标签
		/*initTab(load1);*/
		initLoadContent();

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

		$("#dm-followup-plan-hbp-list").on("click", ".deletePlan", deletePlan);
		$("#dm-followup-plan-di-list").on("click", ".deletePlan", deletePlan);
		$("#dm-followup-plan-tumor-list").on("click", ".deletePlan", deletePlan);
		$("#dm-followup-plan-stroke-list").on("click", ".deletePlan", deletePlan);
		$("#dm-followup-plan-coronary-list").on("click", ".deletePlan", deletePlan);

	});

	function chceckPlanYear($form){
		var start=$form.find("input[name='planYearStart']").val();
		var end=$form.find("input[name='planYearEnd']").val();
		if(start&&end){
			if(parseInt(start)>parseInt(end)){
				layui.use('layer', function(){
        			var layer = layui.layer;
        			layer.alert("开始年份不能大于结束年份！", {icon:0,title:'提示'})
        		});
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
		var index = layer.confirm("是否要新增计划外随访？", {icon:2, title:'确认提示'}, function() {
			$("#").submitFormGetJson({
                url: '/cdm/standardization/followup/addHbpHistoryData',
                param: {
                    personId: personId,
                    planYear: planYear,
                    disType: disType
                },
                callback: function (data) {
                    if (data == "success") {
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
                    } else if (data == "existUnfinishedPlan") {
                        layui.use('layer', function() {
                        	var layer = layui.layer;
                        	layer.alert("存在未完成随访的计划！", {icon:0,title:'提示'});
                        });
                    } else {
                        layui.use('layer', function() {
                        	var layer = layui.layer;
                        	layer.alert("新增随访计划失败！", {icon:0,title:'提示'});
                        });
                    }
                }
            });
			layer.close(index);
		});
	}

	// 随访标签的默认执行方法,切换到高血压标签时,默认调用此方法
	function loadHbp() {
		var personId = $("#dm-followup-personid").val();
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
		var $form = $("#" + formid);
		$form.find("input[name='curSymptom']").click(function() {
			inputOtherCurSymptom(formid);
		});
		inputOtherCurSymptom(formid);

		$form.find("#hbpSbp").blur(function() {
			calVisitTypeBySbp(formid, $('#hbpSbp').val(), $('#hbpDbp').val());
		});
		$form.find("#hbpDbp").blur(function() {
			calVisitTypeBySbp(formid, $('#hbpSbp').val(), $('#hbpDbp').val());
		});

		$form.find("#height").blur(function() {
			calBMI(formid);
		});
		$form.find("#bodyWeight").blur(function() {
			calBMI(formid);
		});
		$form.find("#nextFollowupBodyWeight").blur(function() {
			calBMI(formid);
		});
        //高压高于140 不允许控制满意
        $form.find("input[name='sbp']").blur(function () {
            var sbp = $form.find("input[name='sbp']").val();
            var dbp = $form.find("input[name='dbp']").val();
            var age=$("#age").val();
            if(age>=65){

                if(sbp>=150 || dbp>=90) {
                    $form.find("input[name='visitType']").eq(1).attr("checked",true);
                    $form.find("input[name='visitType']").eq(0).attr("disabled", true);
                    $form.find("input[name='visitType']").eq(0).attr("checked", false);
                    $("input[name='visitType']").eq(1).click();
                }else{
                    $form.find("input[name='visitType']").eq(0).attr("disabled", false);
                    $("input[name='visitType']").eq(0).click();
                }
            }else{
                if(sbp>=140 || dbp>=90) {
                    $form.find("input[name='visitType']").eq(1).attr("checked",true);
                    $form.find("input[name='visitType']").eq(0).attr("disabled", true);
                    $form.find("input[name='visitType']").eq(0).attr("checked", false);
                    $("input[name='visitType']").eq(1).click();
                }else{
                    $form.find("input[name='visitType']").eq(0).attr("disabled", false);
                    $("input[name='visitType']").eq(0).click();
                }
            }
        });
        //低压高于90 不允许控制满意
        $form.find("input[name='dbp']").blur(function () {
            var sbp = $form.find("input[name='sbp']").val();
            var dbp = $form.find("input[name='dbp']").val();
            var age=$("#age").val();
            if(age>=65){

                if(sbp>=150 || dbp>=90) {
                    $form.find("input[name='visitType']").eq(1).attr("checked",true);
                    $form.find("input[name='visitType']").eq(0).attr("disabled", true);
                    $form.find("input[name='visitType']").eq(0).attr("checked", false);
                    $("input[name='visitType']").eq(1).click();
                }else{
                    $form.find("input[name='visitType']").eq(0).attr("disabled", false);
                    $("input[name='visitType']").eq(0).click();
                }
            }else{
                if(sbp>=140 || dbp>=90) {
                    $form.find("input[name='visitType']").eq(1).attr("checked",true);
                    $form.find("input[name='visitType']").eq(0).attr("disabled", true);
                    $form.find("input[name='visitType']").eq(0).attr("checked", false);
                    $("input[name='visitType']").eq(1).click();
                }else{
                    $form.find("input[name='visitType']").eq(0).attr("disabled", false);
                    $("input[name='visitType']").eq(0).click();
                }
            }
        });
		//placeholder在IE8下不兼容
		var arrays = new Array("bodyWeight","nextFollowupBodyWeight","dailyDailySmokeber", "smokeberTarget",
			"dailyDrink", "nextFollowupDailyDrink", "trainFrequency", "trainingMin")
		placeholderIE8(arrays);

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

		//选择了“并发症”， 需要填转诊单，不管再次随访是否满意
		/*$form.find("input[name='visitType']").change(function() {
		    debugger;
			var visitType = $(":checked[name='visitType']").val();
			if((visitType == '2' || visitType == '3') && !$.isEmpty($form.find("#reasonFollowId").val())
				|| (visitType == '4' || visitType == '5')) {
				$form.find("input[name='referralHbpFlag'][value='1']").click();
				$form.find("#referralHbpSpan").show();
				layer.alert("请填转诊单!");
			} else {
				$form.find("#referralHbpSpan").hide();
				$("input[name='referralHbpFlag'][value='2']").click();
			}
		});*/

        $form.find("input[name='visitType']").change(function() {
            // var visitType = $(":checked[name='visitType']").val();
            var visitType = $form.find(":checked[name='visitType']").val();
            var personId = $("#dm-followup-personid").val();
            var hbpVisitDate = $form.find("#hbpVisitDateId").val();
            if(visitType == '2' && !$.isEmpty(hbpVisitDate)) {
                $.getJsonByUrl({
                    url : "/cdm/standardization/followup/hbpLastVisitInfo",
                    wait : true,
                    param:{personId:personId,visitDate:hbpVisitDate},
                    callback : function(data) {
                        if('2' ==data){
                            layer.alert("请填转诊单！", {icon:0,title:'提示'});
                            $form.find("input[name='referralHbpFlag'][value='1']").click();
                            $form.find("#referralHbpSpan").show();
                        }
                    }
                });
            }else if (visitType == '3' && !$.isEmpty(hbpVisitDate)){
                $.getJsonByUrl({
                    url : "/cdm/standardization/followup/hbpLastVisitInfo",
                    wait : true,
                    param:{personId:personId,visitDate:hbpVisitDate},
                    callback : function(data) {
                        if('3' ==data){
                            layer.alert("请填转诊单！", {icon:0,title:'提示'});
                            $form.find("input[name='referralHbpFlag'][value='1']").click();
                            $form.find("#referralHbpSpan").show();
                        }
                    }
                });
            }else if(visitType == '4'){
                layer.alert("请填转诊单！", {icon:0,title:'提示'});
                $form.find("input[name='referralHbpFlag'][value='1']").click();
                $form.find("#referralHbpSpan").show();
            }else {
                $form.find("#referralHbpSpan").hide();
                $("input[name='referralHbpFlag'][value='2']").click();
            }

        });
		//若此次随访分类为控制不满意或不良反应或者有药物不良反应
		//（满足其一），需要生成两周内的随访，下次随访还是此类状况，需要开转诊单，再生成一次两周内的随访，
		//随访后此流程结束。然后再进行下一轮正常的随访。
		$form.find("input[name='sideEffects']").on("click", function() {
            var hbpVisitDate = $form.find("#hbpVisitDateId").val();
            if ('2' == $(this).val() && !$.isEmpty(hbpVisitDate)){
				var personId = $("#dm-followup-personid").val();
				 $.getJsonByUrl({
			            url : "/cdm/standardization/followup/hbpSideEffectsStatus",
			            wait : true,
			            param:{personId:personId,visitDate:hbpVisitDate},
			            callback : function(data) {
							if(!$.isEmpty(data)){
								layer.alert("请填转诊单！", {icon:0,title:'提示'});
                                $form.find("input[name='referralHbpFlag'][value='1']").click();
                                $form.find("#referralHbpSpan").show();
							}
			            }
			        });
				
				
			}else if ('1' == $(this).val()){
                $form.find("#referralHbpSpan").hide();
                $("input[name='referralHbpFlag'][value='2']").click();
            }
			
//			if ('2' == $(this).val() && !$.isEmpty($form.find("#reasonFollowId").val())) {
//				$form.find("input[name='referralHbpFlag'][value='1']").click();
//				$form.find("#referralHbpSpan").show();
//				layer.alert("请填转诊单!");
//			} else {
//				$form.find("#referralHbpSpan").hide();
//				$("input[name='referralHbpFlag'][value='2']").click();
//			}
		});
	}

	//placeholder在IE8下不兼容
	function placeholderIE8(arrays) {
		for(var i = 0, size = arrays.length; i < size; i++) {
			$.Placeholder.init({
				query: "#" + arrays[i],
				callback: null
			});
		}
	}
	//血压不理想（140/90以上，>=65岁的患者血压150/90以上）直接默认控制不满意
	function calVisitTypeBySbp(formid, sbp, dbp){
		var $form = $("#" + formid);
		var age = getAge($("input[name='personInfo.birthday']").val());
		if((age >= 65 && sbp >= 150 && dbp >=90) || (age < 65 && sbp >= 140 && dbp >=90)) {
			$form.find("input[name='visitType'][value=2]").click();
		} else {
			$form.find("input[name='visitType'][value=1]").click();
		}
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
		var personId = $("#dm-followup-personid").val();
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
		$form.find("#fpg").blur(function() {
			calVisitTypeByFpg(formid, $('#fpg').val());
		});
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

		//选择了“并发症”， 需要填转诊单，不管再次随访是否满意
		/*$form.find("input[name='visitType']").change(function() {
			var visitType = $(":checked[name='visitType']").val();
			if((visitType == '2' || visitType == '3') && !$.isEmpty($form.find("#reasonFollowId").val())
				|| (visitType == '4' || visitType == '5')) {
				layer.alert("请填转诊单!");
				$form.find("input[name='referralDiFlag'][value=1]").click();
				$form.find("#referralDiSpan").show();
			} else {
				$form.find("input[name='referralDiFlag'][value=2]").click();
				$form.find("#referralDiSpan").hide();
			}
		});*/
		//若此次随访分类为控制不满意或不良反应或者有药物不良反应
		//（满足其一），需要生成两周内的随访，下次随访还是此类状况，需要开转诊单，再生成一次两周内的随访，
		//随访后此流程结束。然后再进行下一轮正常的随访。
        $form.find("input[name='drugReaction']").on("click", function() {
            var diVisitDate = $form.find("#diVisitDateId").val();
            if ('2' == $(this).val() && !$.isEmpty(diVisitDate)) {
                var personId = $("#dm-followup-personid").val();
                $.getJsonByUrl({
                    url: "/cdm/standardization/followup/diLastVisitInfo",
                    wait: true,
                    param: {personId: personId, visitDate: diVisitDate, queryType: 'drugReaction'},
                    callback: function (data) {
                        if ('2' == data) {
                            layer.alert("请填转诊单！", {icon:0,title:'提示'});
                            $form.find("input[name='referralDiFlag'][value='1']").click();
                            $form.find("#referralDiSpan").show();
                        }
                    }
                });
            } else if ('1' == $(this).val()) {
                $form.find("#referralDiSpan").hide();
                $("input[name='referralDiFlag'][value='2']").click();
            }
        });
		/*$form.find("input[name='drugReaction']").on("click", function() {
			if ('2' == $(this).val()){
				var personId = $("#dm-followup-personid").val();
				 $.getJsonByUrl({
			            url : "/cdm/standardization/followup/diSideEffectsStatus",
			            wait : true,
			            param:{personId:personId,visitDate:visitDate},
			            callback : function(data) {
							if(!$.isEmpty(data)){
								layer.alert("请填转诊单!");
							}
			            }
			        });
				
				
			}
			if ('2' == $(this).val() && $.isEmpty($form.find("#reasonFollowId").val())) {
				$form.find("input[name='referralHbpFlag'][value='1']").click();
				$form.find("#referralHbpSpan").show();
				layer.alert("请填转诊单!");
			} else {
				$form.find("#referralHbpSpan").hide();
				$("input[name='referralHbpFlag'][value='2']").click();
			}
		});*/

        //高血压糖尿病随访规则修改
        $form.find("input[name='visitType']").change(function() {
            var visitType = $form.find(":checked[name='visitType']").val();
            var personId = $("#dm-followup-personid").val();
            var diVisitDate = $form.find("#diVisitDateId").val();
            if(visitType == '2' && !$.isEmpty(diVisitDate)) {
                $.getJsonByUrl({
                    url : "/cdm/standardization/followup/diLastVisitInfo",
                    wait : true,
                    param:{personId:personId,visitDate:diVisitDate},
                    callback : function(data) {
                        if('2' ==data){
                            layer.alert("请填转诊单！", {icon:0,title:'提示'});
                            $form.find("input[name='referralDiFlag'][value='1']").click();
                            $form.find("#referralDiSpan").show();
                        }
                    }
                });
            }else if (visitType == '3' && !$.isEmpty(diVisitDate)){
                $.getJsonByUrl({
                    url : "/cdm/standardization/followup/diLastVisitInfo",
                    wait : true,
                    param:{personId:personId,visitDate:diVisitDate},
                    callback : function(data) {
                        if('3' ==data){
                            layer.alert("请填转诊单！", {icon:0,title:'提示'});
                            $form.find("input[name='referralDiFlag'][value='1']").click();
                            $form.find("#referralDiSpan").show();
                        }
                    }
                });
            }else if(visitType == '4'){
                layer.alert("请填转诊单！", {icon:0,title:'提示'});
                $form.find("input[name='referralDiFlag'][value='1']").click();
                $form.find("#referralDiSpan").show();
            }else {
                $form.find("#referralDiSpan").hide();
                $("input[name='referralDiFlag'][value='2']").click();
            }

        });

        $("#fpg").blur(function () {
            var fgp = $("input[name='fpg']").val();
            if(parseInt(fgp)>=parseInt(7)){
                $("input[name='visitType']").eq(0).attr("disabled",true);
                $("input[name='visitType']").eq(0).removeAttr("checked");
                $("input[name='visitType']").eq(1).attr("checked","checked");
                $("input[name='visitType']").eq(1).click();
            }else{
                $("input[name='visitType']").eq(0).attr("disabled",false);
                $("input[name='visitType']").eq(1).removeAttr("checked");
                $("input[name='visitType']").eq(0).attr("checked","checked");
                $("input[name='visitType']").eq(0).click();
            }
        });
		//placeholder在IE8下不兼容
		var arrays = new Array("bodyWeight","nextFollowupBodyWeight","dailySmoke", "smokeberTarget",
			"dailyDrink", "nextFollowupDailyDrink", "trainFrequencyType", "trainingMin", "nextExerciseFrequency",
		"nextExerciseTime")
		placeholderIE8(arrays);
        toggleOther('heartRate','heartRateDiSpan',2);
    }

	//血糖不理想（空腹血糖>7.0mmol/l)直接默认控制不满意
	function calVisitTypeByFpg(formid, fpg){
		var $form = $("#" + formid);
		if(fpg > 7.0) {
			$form.find("input[name='visitType'][value=2]").click();
		} else {
			$form.find("input[name='visitType'][value=1]").click();
		}
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
			viewTumor("1"); // 首次随访-->基本信息
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
		var personId = $("#dm-followup-personid").val();
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

				view("tumorPersonInfo", null, {
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
		doSave("tumorPersonInfo", currentFormId, loadTumor, {
			followupFlag : "1",
            tumorFlag : "2"
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
			cure : "#tumor-cure",
            lossVisit : "#tumor-lossVisit",
            death : "#tumor-deathDate,#tumor-deathReason,#tumor-deathForTumor,#tumor-deathPlace",
            cancel : "#tumor-cancelDate,#tumor-cancelRea"
        };
        toggleDisable(target2, "1");

        // var target3 = {
        //     lossVisitReason : "#lossVisit-reason"
        // };
        // toggleDisable(target3, "7");
        toggleOtherCK('lossVisitReason', 'lossVisit-reason', '7');


        var target4 = {
            followupPlace : "#tumor-followupPlace"
        };
        toggleDisable(target4, "3");

        var target5 = {
            deathPlaceCode : "#death-place"
        };
        toggleDisable(target5, "4");


        if($('input[name="otherDiagnosisOrganFlag"]:visible:checked').val() == '2') {
            $("#otherDiagnosisOrganName").show();
        }else{
            $("#otherDiagnosisOrganName").hide();
        }
        // 其它诊断单位 切换
        $("#otherDiagnosisOrganFlag").click(diagnosisOrganChange);

        $('#birthday').on("blur onDatePickerChanged",function(){
            setBirthdayAge();
        });

	}

	var target = {
		referralHbpFlag : "#referralHbpSpan"
	};
	toggleDisable(target, "1");
	function toggleDisable(target, show) {

		for ( var btn in target)
		{
			//debugger;
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
		debugger;
		var personId = $("#dm-followup-personid").val();

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
			bloodGlucoseFalg : "#bloodGlucoseSpan",
			bloodFat : "#bloodFatSpan"
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
		var personId = $("#dm-followup-personid").val();
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
		var planType = $this.data("plantype");
		if (followupId != null && followupId != ''){
			$("#followup-print-btn").show();
		}else {
            $("#followup-print-btn").hide();
		}
		return {
			followupId : followupId,
			planId : planId,
			followupFlag : followupFlag,
			planType : planType,
			reasonFollowId: $this.data("reasonfollowid")

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
			layui.use('layer', function(){
    			var layer = layui.layer;
    			layer.alert("请刷新页面重新操作！", {icon:0,title:'提示'});
    		});
			return;
		}
		if (!func)
		{
			layui.use('layer', function(){
    			var layer = layui.layer;
    			layer.alert("请重新打开页面！", {icon:0,title:'提示'});
    		});
			return;
		}
		emptyForm();
		func();
	}

	// 查看随访记录公用方法
	// url : '/cdm/standardization/followup/view/' + name,
	// name表示病的类型,如hbp,对应到后台url
	function view(name, plan, param, insertDiv) {
		var personId = $("#dm-followup-personid").val();
		var planType ;
		
		var p = {
			personId : personId
		};
		if (plan)
		{	p.planType=plan.planType;
			p.followupId = plan.followupId;
			p.planId = plan.planId;
			p.reasonFollowId = plan.reasonFollowId;
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
			layui.use('layer', function(){
    			var layer = layui.layer;
    			layer.alert("请填写后保存！", {icon:0,title:'提示'});
    		});
			return;
		}
		if (!func)
		{
			layui.use('layer', function(){
    			var layer = layui.layer;
    			layer.alert("保存方法错误！", {icon:0,title:'提示'});
    		});
			return;
		}
		var validate = getValidator(currentFormId);
		if(currentFormId == 'dm-followup-di-from') {
			if(!$.isEmpty($("#fpg").val())) {
                validate.removeCheckElement('gluValue');
			}
            if(!$.isEmpty($("#gluValue").val())) {
                validate.removeCheckElement('fpg');

            }
		}
		var result = validate.validateForm();
		if (!result)
		{
			// layer.alert("数据验证失败");
			return;
		}
		func(currentFormId);
	}

	//打印随访记录
    function print() {
        var currentFormId = getSelectedFormId();
		// var target = $("#tags li.selectTag a").data('target');
		var printId = "";
		if (currentFormId == 'dm-followup-hbp-from') {
			printId = "hbpPrintFollowUp";
		}else if (currentFormId == 'dm-followup-di-from'){
            printId = "diPrintFollowUp";
		}else if (currentFormId == 'dm-followup-tumor-from'){
            printId = "tumorPrintFollowUp";
        }else if (currentFormId == 'dm-followup-stroke-standard-from'){
            printId = "strokePrintFollowUp";
        }else if (currentFormId == 'dm-followup-coronary-standard-from'){
            printId = "coronaryPrintFollowUp";
        }
        $("#"+printId).show();
        $("#"+printId).jqprint(
            {
                debug: false, //如果是true则可以显示iframe查看效果（iframe默认高和宽都很小，可以再源码中调大），默认是false
                importCSS: false, //true表示引进原来的页面的css，默认是true。（如果是true，先会找$("link[media=print]")，若没有会去找$("link")中的css文件）
                printContainer: true, //表示如果原来选择的对象必须被纳入打印（注意：设置为false可能会打破你的CSS规则）。
                operaSupport: true//表示如果插件也必须支持歌opera浏览器，在这种情况下，它提供了建立一个临时的打印选项卡。默认是true
            });
        $("#"+printId).hide();
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
		var personId = $("#dm-followup-personid").val();
		var p = {
			personId : personId,
			planType: $("#planType").val()
		};
		
		var visitType=$("input[name='visitType']:checked").val();
		var visitDate= $("#" + currentFormId).find("input[name='visitDate']").val();
		var sideEffects=$("input[name='sideEffects']:checked").val();
		var drugReaction=$("input[name='drugReaction']:checked").val();
		var referralHbpFlag=$("input[name='referralHbpFlag']:checked").val();
		var referralDiFlag=$("input[name='referralDiFlag']:checked").val();
		
		
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
						if(name=="hbp"||name=="di"){
								if (('2' == sideEffects && referralHbpFlag=='2')||('2' == drugReaction && referralDiFlag=='2')){
									 $.getJsonByUrl({
								            url : "/cdm/standardization/followup/"+name+"SideEffectsStatus",
								            wait : true,
								            param:{personId:personId,visitDate:visitDate},
								            callback : function(data) {
												if(!$.isEmpty(data)){
													layui.use('layer', function(){
										    			var layer = layui.layer;
										    			var index = layer.alert("保存成功，建议填写转诊单！", {icon:0,title:'提示'}, function() {
										    				layer.close(index);
										    				callback();
										    			});
										    		});
													/*layer.alert("保存成功，建议填写转诊单!");
													callback();*/
												}else{
													layui.use('layer', function(){
										    			var layer = layui.layer;
										    			var index = layer.alert("保存成功！", {icon:0,title:'提示'}, function() {
										    				layer.close(index);
										    				callback();
										    			});
										    		});
													/*layer.alert("保存成功");
													callback();*/
												}
								            }
								        });
								}else if(('2' == visitType && referralHbpFlag=='2')||('2' == visitType && referralDiFlag=='2')){
									$.getJsonByUrl({
							            url : "/cdm/standardization/followup/"+name+"VisitType",
							            wait : true,
							            param:{personId:personId,visitDate:visitDate},
							            callback : function(data) {
											if(!$.isEmpty(data)){
												layui.use('layer', function(){
									    			var layer = layui.layer;
									    			var index = layer.alert("保存成功，建议填写转诊单！", {icon:0,title:'提示'}, function() {
									    				layer.close(index);
									    				callback();
									    			});
									    		});
												/*layer.alert("保存成功，建议填写转诊单!");
												callback();*/
											}else{
												layui.use('layer', function(){
									    			var layer = layui.layer;
									    			var index = layer.alert("保存成功！", {icon:0,title:'提示'}, function() {
									    				layer.close(index);
									    				callback();
									    			});
									    		});
												/*layer.alert("保存成功");
												callback();*/
											}
							            }
							        });
								}else{
									layui.use('layer', function(){
						    			var layer = layui.layer;
						    			var index = layer.alert("保存成功！", {icon:0,title:'提示'}, function() {
						    				layer.close(index);
						    				callback();
						    			});
						    		});
									/*layer.alert("保存成功");
									callback();*/
									}
								}else{
									layui.use('layer', function(){
						    			var layer = layui.layer;
						    			var index = layer.alert("保存成功！", {icon:0,title:'提示'}, function() {
						    				layer.close(index);
						    				callback();
						    			});
						    		});
									/*layer.alert("保存成功");
									callback();*/
								}
						
					} else
					{
						layui.use('layer', function(){
			    			var layer = layui.layer;
			    			layer.alert(tip, {icon:0,title:'提示'});
			    		});
						/*msgUtil.alert(tip);*/
					}
				} else if ("failure" == data)
				{
					layui.use('layer', function(){
		    			var layer = layui.layer;
		    			layer.alert("新增随访日期不能大于或等于已存在随访计划的最小日期！", {icon:0,title:'提示'});
		    		});
					/*msgUtil.alert("新增随访日期不能大于或等于已存在随访计划的最小日期！");*/
				} else if (true == data)
				{

					if(name=="hbp"||name=="di"){
							if (('2' == sideEffects && referralHbpFlag=='2')||('2' == drugReaction && referralDiFlag=='2')){
								 $.getJsonByUrl({
							            url : "/cdm/standardization/followup/"+name+"SideEffectsStatus",
							            wait : true,
							            param:{personId:personId,visitDate:visitDate},
							            callback : function(data) {
											if(!$.isEmpty(data)){
												layui.use('layer', function(){
									    			var layer = layui.layer;
									    			var index = layer.alert("保存成功，建议填写转诊单！", {icon:0,title:'提示'}, function() {
									    				layer.close(index);
									    				callback();
									    			});
									    		});
												/*msgUtil.alert("保存成功，建议填写转诊单!");
												callback();*/
											}else{
												layui.use('layer', function(){
									    			var layer = layui.layer;
									    			var index = layer.alert("保存成功！", {icon:0,title:'提示'}, function() {
									    				layer.close(index);
									    				callback();
									    			});
									    		});
												/*msgUtil.alert("保存成功");*/
												callback();
											}
							            }
							        });
							}else if(('2' == visitType && referralHbpFlag=='2')||('2' == visitType && referralDiFlag=='2')){
								$.getJsonByUrl({
						            url : "/cdm/standardization/followup/"+name+"VisitType",
						            wait : true,
						            param:{personId:personId,visitDate:visitDate},
						            callback : function(data) {
										if(!$.isEmpty(data)){
											layui.use('layer', function(){
								    			var layer = layui.layer;
								    			var index = layer.alert("保存成功，建议填写转诊单！", {icon:0,title:'提示'}, function() {
								    				layer.close(index);
								    				callback();
								    			});
								    		});
											/*msgUtil.alert("保存成功，建议填写转诊单!");
											callback();*/
										}else{
											layui.use('layer', function(){
								    			var layer = layui.layer;
								    			var index = layer.alert("保存成功！", {icon:0,title:'提示'}, function() {
								    				layer.close(index);
								    				callback();
								    			});
								    		});
											/*msgUtil.alert("保存成功");
											callback();*/
										}
						            }
						        });
							}else{
								layui.use('layer', function(){
					    			var layer = layui.layer;
					    			var index = layer.alert("保存成功！", {icon:0,title:'提示'}, function() {
					    				layer.close(index);
					    				callback();
					    			});
					    		});
								/*msgUtil.alert("保存成功");
								callback();*/
							}
					}else{
						layui.use('layer', function(){
			    			var layer = layui.layer;
			    			var index = layer.alert("保存成功！", {icon:0,title:'提示'}, function() {
			    				layer.close(index);
			    				callback();
			    			});
			    		});
								/*msgUtil.alert("保存成功");
								callback();*/
					}
					
				
				} else
				{
					layui.use('layer', function(){
		    			var layer = layui.layer;
		    			layer.alert("保存失败！", {icon:0,title:'提示'});
		    		});
					/*msgUtil.alert("保存失败");*/
				}
			}
		});
	}

	function isArray(obj) {
		return Object.prototype.toString.call(obj) === '[object Array]';
	}

	// 获取当前操作的form的id
	function getSelectedFormId() {
		var currentForm = $("form.dm-followup-from").not(":hidden");
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
		if(bmi == 'NaN') return null;
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

    // 诊断机构切换实现
    function diagnosisOrganChange()
    {
        if($('input[name="otherDiagnosisOrganFlag"]:visible:checked').val() == '2'){
            $("#otherDiagnosisOrganName").show();
            $("#diagnosisOrganCode").hide();
            $("#diagnosisOrganCode").val("");
        } else {
            $("#otherDiagnosisOrganName").hide();
            $("#diagnosisOrganCode").show();
        }
    }

	$.ajaxSetup({
		contentType: "application/x-www-form-urlencoded; charset=utf-8"
	});

    /*
     * 根据出生日期设置年龄，单位默认为“岁”
     * */
    function setBirthdayAge(){
        var birthday = $('#birthday').val();
        if(!$.isEmpty(birthday)){
            var age = getAge(birthday);
            $('#age').val(age);
        }
    }

    function showytj(){
    	var idcard = $("#idcard").val();
        var name = $("#person_name").val();
        /*var option ={
            id:"ytjDialogId",
            title:"一体机检查记录",
            url:"/cdm/standardization/followup/yshare/search",
            height:400,
            width:850,
            param:{
                idcard:idcard,
                name:name,
                module:"cdm"//慢病
            }
        };
        $.dialog(option);
        $("#contentytjDialogId").css("overflow-y","hidden");*/
        
        $.post(contextPath+'/cdm/standardization/followup/yshare/search',
        		{  idcard:idcard,
		            name:name,
		            module:"cdm"//慢病
			     }, 
			function(ret){
        	layui.use(['layer'], function() {
        		  var layer = layui.layer
        		  layer.open({
        			  type: 1,
        			  id:'ytjDialogId',
        			  area: ['850px', '400px'],
        			  title:'一体机检查记录',
        			  content: ret
        		  });
        		});
        	});
	}
    
    /**
     * 页面加载初始化tab内容
     */
    function initLoadContent() {
    	/*var layId = $(".layui-this").attr("lay-id");*/
    	var layId = $("#dm-followup-main").find(".layui-this").attr("lay-id");
    	if (layId == 'hbp') {
      	  loadHbp();
        } else if(layId == 'di') {
      	  loadDi();
        }  else if(layId == 'tumor') {
      	  loadTumor();
        } else if(layId == 'stroke') {
      	  loadStroke();
        } else if(layId == 'coronary') {
      	  loadCoronary();
        }
    }

	function deletePlan() {
    	debugger
		var id = $(this).attr("data-planid");
		layui.use('layer', function(){
			var layer = layui.layer;
			layer.confirm('是否删除该计划？', {icon:2, title:'确认提示'}, function(index){
				var option = {
					url : "/cdm/standardization/followup/deletePlan",
					param : {
						id : id
					},
					callback : (function(data) {
						debugger
						console.log(data);
						if (data == "success") {
							var delIndex =layer.alert("删除成功！", {icon:0,title:'提示'},function () {
								initLoadContent();
								layer.close(delIndex);
							});

						}
					})
				};
				$.getJsonByUrl(option);
				layer.close(index);
			});
		});
	}
    
    return {loadHbp:loadHbp,
    	loadDi:loadDi,
    	loadTumor:loadTumor,
    	loadStroke:loadStroke,
    	loadCoronary:loadCoronary,
    	chceckPlanYear:chceckPlanYear,
    	emptyForm:emptyForm
    	}
})();