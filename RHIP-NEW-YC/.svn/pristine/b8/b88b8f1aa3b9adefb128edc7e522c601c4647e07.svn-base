var hsaInspectinoAdd = (function() {
	var validate = null;
	var guideMapping = {
		"1|1" : "#hsa-guide-food",
		"2|2" : "#hsa-guide-plocation",
		"3|3" : "#hsa-guide-water",
		"5|3" : "#hsa-guide-schoolWater",
		"5|5" : "#hsa-guide-school",
		"6|6" : "#hsa-guide-id",
		"7|7" : "#hsa-guide-im",
		"8|8" : "#hsa-guide-jh",
		"9|9" : "#hsa-guide-sy",
		"10|10" : "#hsa-guide-ylwj"
	};
	$(function() {
		validate = $("#hsa-input-form").easyValidate();
		healthEducationUpload.uploadOrganizationLinkFile("linkInspFile","/he/upload/uploadFile/inspectionRecord","/he/upload/deleteFile/inspectionRecord");
		healthEducationUpload.uploadOrganizationLinkFile("linkHsoFile","/he/upload/uploadFile/healthSupervisionOpinion","/he/upload/deleteFile/healthSupervisionOpinion");
		// 保存记录界面
		$("#hsa-location-inspiron-save-btn").click(function(e) {
			e.preventDefault();
			save();
		});
		$("#hsa-location-inspiron-out-update-btn").click(function(e) {
			e.preventDefault();
			update(function() {
				back();
			});
		});

		$("#hsa-location-inspiron-out-save-btn").click(function(e) {
			e.preventDefault();
			save(function() {
				back();
			});
		});

		$("#hsa-location-inspiron-in-save-btn").click(function(e) {
			e.preventDefault();
			save(function() {
				locationInspRecordList.refreshList();
				hsaLocationInspListView.add();
			});
		});

		$("#hsa-location-inspiron-back-btn").click(function(e) {
			e.preventDefault();
			layer.confirm("确认离开？",function(index){
				layer.close(index);
				back();
			});
		});

		//新增食源性疾病报卡
		$("#addReportCard").click(function(e) {
			e.preventDefault();
			addReportCard();
		});

		$("input[name='isGuide']").click(openGuideContent);
		$("input[name='isReport']").click(openReportContent);

		// 点击巡查指导checkbox事件
		initGuideContentSelece();

		$("#townCodeId", "#hsa-record-input-add").attr("disabled", true);
		if ($("#has-insprecord-flag").val() == "view") {
			$("#hsa-record-input-add").find("input[type='checkbox']").attr("disabled", true);
			$("#hsa-record-input-add").find("input[type='radio']").attr("disabled", true);
			$("#hsa-record-input-add").find("input[type='text']").attr("disabled", true);
			$(".disabledInfoContent").attr("disabled", "disabled");
			$("#hsa-guide-type", "#hsa-record-input-add").attr("disabled", true);
		}
		validate.addExtension("cuValidate", customValidate);// 方法名,方法

		$("#hsa-inspection-location-select-btn").click(
					searchLocation
				);

        $("#hsa-input-form").find("input,select").each(function(){
            $(this).onEnter(doSearchLocation,1);
        });

		HsaCommon.initSelect("#hsa-inspection-location-healthProfessional", "#hsa-inspection-location-mainBusinessCode", "/hsa/inspRecord/getMfCode");

		setInspDate();

		initLocationSel();

		initGuideToMainProbleam();
	});

	function back() {
		$("#hsa-record-input-add").hide();
		$("#hsa-record-list-box").show();
		hsaInspRecordList.search(1);
	}

	//新增报卡
	function addReportCard() {
		$.loadHtmlByUrl({
			url : "/fdm/reportCard/initAddReport",
			insertDiv :"hsa-record-reportCard-add",
			param : {addFrom:"rcxc"}
		});
		$("#hsa-record-reportCard-add").show();
		$("#hsa-record-input-add").hide();
	}

	function initGuideContentSelece() {
		var key = "";
		for (key in guideMapping) {
			if (guideMapping.hasOwnProperty(key)) {
				var id = guideMapping[key];
				$("input[type='checkbox']", id).on("click", {
					parent : id
				}, setGuideContentSelect);
			}
		}
	}

	function setGuideContentSelect(event) {
		var patentId = event.data.parent;
		if (!patentId) {
			return;
		}
		var $this = $(this);
		var $parent = $(patentId);
		var target = $this.data("target");
		var target1 = $this.data("target1");
		var target2 = $this.data("target2");
		var target3 = $this.data("target3");
		var target4 = $this.data("target4");
		if ($this.prop("checked")) {
			$parent.find("#" + target).show();
			$parent.find("#" + target1).show();
		} else {
			$parent.find("#" + target).hide().find("input[type='radio']").val([ '5' ]);
			$parent.find("#" + target1).hide().find("input[type='radio']").val([ '5' ]);
		}

		if (target2 && target3) {
			if ($this.prop("checked")) {
				$parent.find("#" + target2).prop("readonly", false);
				$parent.find("#" + target3).prop("readonly", false);
			} else {
				$parent.find("#" + target2).val("");
				$parent.find("#" + target3).val("");
				$parent.find("#" + target2).prop("readonly", true);
				$parent.find("#" + target3).prop("readonly", true);
			}
		}

		if (target4) {
			if ($this.prop("checked")) {
				$parent.find("#" + target4).prop("readonly", false);
			} else {
				$parent.find("#" + target4).prop("readonly", true);
				$parent.find("#" + target4).val("");
			}
		}
	}

	function openGuideContent() {
		var val = $(this).val();
		if (val == 1) {
			$("#hsa-guide-content").show();
		} else {
			$("#hsa-guide-content").hide();
		}
	}

	function selectGuideTable(locationType, inspType) {
		var type = locationType + "|" + inspType;
		var key = "";
		for (key in guideMapping) {
			if (type == key) {
				$(guideMapping[key]).show().find("input,select,textarea").prop("disabled", false);
			} else {
				$(guideMapping[key]).hide().find("input,select,textarea").prop("disabled", true);
			}
		}
		cleanMainProbleamAndReport();
	}

	function openReportContent() {
		var val = $(this).val();
		if (val == 1) {
			$("#hsa-report-record-content").show();
		} else {
			$("#hsa-report-record-content").hide();
			// $("#discoveryDate").attr("value", "");
			$("#infoTypeCode").attr("value", "");
			$("#infoContent").attr("value", "");
		}
	}

	function save(callbackFunction) {
		if (checkLocation()) {
			doSave(callbackFunction);
		}

	}

	function update(callbackFunction) {
		doSave(callbackFunction);
	}

	function doSave(callbackFunction) {

		var result = validate.validateForm();
		if (!result) {
			return;
		}

		$("#hsa-input-form").submitFormGetJson({
			url : "/hsa/inspRecord/save",
			callback : function(data) {
				if ("success" == data) {
					layer.alert("保存成功！", {icon:0,title:'提示'});
					if (callbackFunction) {
						callbackFunction();
					}
				} else {
					layer.alert("保存失败！", {icon:0,title:'提示'});
				}

			}
		});
	}

	function customValidate(name, $input) {
		var value = $input.filter(":checked").val();
		if (value != 5) {
			return true;
		} else {
			return false;
		}
	}

	// ================地点=====================//

	function checkLocation() {
		var $form = $("#hsa-input-form");
		var selectedLocation = $form.find("input[name='locationId']:checked");
		if (selectedLocation.length > 0) {
			return true;
		}
		if ("7" == $("#hsa-inspection-location-healthProfessional").val()) {
			if ($form.find("input[name='locationInfo.unitName']").val()) {
				return true;
			} else {
				layui.use('layer', function(){
	    			var layer = layui.layer;
	    			layer.alert("请填写名称！", {icon:0,title:'提示'});
	    		});
				return false;
			}
		}
		
		layui.use('layer', function(){
			var layer = layui.layer;
			layer.alert("请选择地点！", {icon:0,title:'提示'});
		});
	}

	function searchLocation(e) {
		e.preventDefault();
		doSearchLocation(1);
	}
	// 查询列表
	function doSearchLocation(indexPage) {

		var $form = $("#hsa-input-form");

		var param = {
			indexPage : indexPage
		};

		param.healthProfessional = $form.find("select[name='locationInfo.healthProfessional']").val() || "";
		param.mainBusinessCode = $form.find("select[name='locationInfo.mainBusinessCode']").val() || "";
		var unitName = $form.find("input[name='locationInfo.unitName']").val() || "";
		param.unitName = $.trim(unitName);
		param.personInCharge = $form.find("input[name='locationInfo.personInCharge']").val() || "";

		var searchObj = {
			url : "/hsa/inspRecord/locationSelectResult",
			insertDiv : "hsa-inspection-location-select-list-content",
			param : param
		};

		$.loadHtmlByUrl(searchObj);
	}

	function setInspDate() {
		var $form = $("#hsa-input-form");
		var $inspDate = $form.find("input[name='inspDate']");
		var $reportDiscoveryDate = $form.find("input[name='reportRecord.discoveryDate']");
		 var $reportRecordCreateDate =
		 $form.find("input[name='reportRecord.createDate']");
		// $reportRecordCreateDate.undelegate();
		$inspDate.on("blur onDatePickerChanged", function() {
			var value = $(this).val();
//			if (value) {
//				var c=new Date();
//				var s=new Date(value);
//				if(s.getMonth()==c.getMonth()){
					$reportDiscoveryDate.val(value);
					 $reportRecordCreateDate.val(value);
//				}else{
//					msgUtil.alert("请选择当月日期");
//					$inspDate.val("");
//				}
//			}
		});
	}

	var locationType = "";

	function initLocationSel() {
		var $form = $("#hsa-input-form");
		$("#hsa-inspection-location-select-list-content").on("click", ".inspection-location-select-radio", locationSelChanged);
		$form.find("select[name='locationInfo.healthProfessional']").change(locationHealthProfessionalSelectChanged);
		$form.find("input[name='inspHealthProfessional']").click(healthProfessionalSelectChanged);
	}

	function healthProfessionalSelectChanged(event) {
		var $this = $(this);
		var val = $this.val();
		var $form = $("#hsa-input-form");
		locationType = $form.find("select[name='locationInfo.healthProfessional']").val();
		selectGuideTable(locationType, val);
		setIllegaFlag(val);
	}

	function locationHealthProfessionalSelectChanged(event) {
		var $form = $("#hsa-input-form");
		var $healthProfessional = $form.find("input[name='inspHealthProfessional']");
		var $selectedLocation = $form.find("input[name='locationId']:checked");
		var $this = $(this);
		var val = $this.val();
		locationType = val;
		$selectedLocation.prop("checked", false);
		$healthProfessional.prop("checked", false).prop("disabled", false);
		if(val == '9'){
			$("#addReportCard").show();
		}else{
			$("#addReportCard").hide();
		}
		setHealthProfessional(val);
	}

	function locationSelChanged(event) {
		var $this = $(this);
		var type = $this.data("type");
		if (type) {
			locationType = type;
			setHealthProfessional(type);
		}
	}

	function getHealthProfessional() {
		var $form = $("#hsa-input-form");
		var $healthProfessional = $form.find("input[name='inspHealthProfessional']");
		return $healthProfessional.val();
	}

	function setHealthProfessional(selectedValue) {
		var $form = $("#hsa-input-form");
		var $healthProfessional = $form.find("input[name='inspHealthProfessional']");
		$healthProfessional.each(function() {
			var $this = $(this);
			var val = $this.val();
			if (val == selectedValue) {

				$this.prop("checked", true).prop("disabled", false);
				selectGuideTable(locationType, val);
			} else {
				$this.prop("checked", false);
				if (selectedValue == "5" && val == 3) {
					$this.prop("disabled", false);
				} else {
					$this.prop("disabled", true);
				}
			}
		});
        $healthProfessional.trigger("validatorEvent");
		setIllegaFlag(selectedValue);
	}

	function setIllegaFlag(selectedValue) {
		var $form = $("#hsa-input-form");
		var $illegalFlag = $form.find("input[name='reportRecord.illegalFlag']");
		$illegalFlag.each(function() {
			var $this = $(this);
			var val = $this.val();
			if (selectedValue == '5') {
				if (val == '2') {
					$this.prop("checked", true).prop("disabled", false);
				} else {
					$this.prop("disabled", true);
				}
			} else if (selectedValue == '7') {
				if (val == '1') {
					$this.prop("checked", true).prop("disabled", false);
				} else {
					$this.prop("disabled", true);
				}
			} else {
				$this.prop("checked", false).prop("disabled", false);
			}
		});
	}

	// 指导记录转主要问题
	function initGuideToMainProbleam() {
		var key = "";
		for (key in guideMapping) {
			if (guideMapping.hasOwnProperty(key)) {
				var id = guideMapping[key];
				$("input[type='checkbox'],input[type='radio']", id).on("click", {
					parent : id
				}, setMainProbleamLis);
				$("input[type='text']", id).on("blur", {
					parent : id
				}, setMainProbleamWithTextInput);
			}
		}

	}

	// var dd="";var ins=$("#hsa-guide-food
	// input[value='2']");ins.each(function(){var
	// message=$(this).parentsUntil("tr").prev().find("label").text();var
	// na=$(this).attr("name");dd+=("'"+na+"|2'"+":'"+message+"',")});console.log(dd)

	var message = {
		'inspGuideRecord.cyxkz' : '无餐饮服务许可证;',
		'inspGuideRecord.bcb' : '没有亮证经营;',
		'inspGuideRecord.bfhin' : '没有建立食品安全管理组织网络、卫生制度等;',
		'inspGuideRecord.fblfbr' : '没有建立食品采购查验和索证索票制度，食品原辅料采购记录;',
		'inspGuideRecord.osnu' : '经营超过保质期、无标签、或使用非食品原料生产食品等;',
		'inspGuideRecord.ict' : '内外环境不整洁有序,有杂物堆放,垃圾桶没有密闭加盖;',
		'inspGuideRecord.lpau' : '没有设凉菜间,没有消毒水池、空调、紫外线灯;',
		'inspGuideRecord.lhs' : '没有设食品原料仓库/区域,没有货架;',
		'inspGuideRecord.lcd' : '没有设餐具消毒间（场所），清洗、消毒设施（水池）;',
		'inspGuideRecord.acf' : '没有有生、熟冰箱，生、熟食品没分开存放;',
		'inspGuideRecord.wfcf' : '没有配备除“四害”防治设施、没开展除“四害”活动;',
		'inspGuideRecord.wbgz' : '卫生防病管理组织',
		'inspGuideRecord.erp' : '没有疫情报告专（兼）职人员',
		'inspGuideRecord.pep' : '没有突发公共卫生应急预案',
		'inspGuideRecord.idms' : '没有传染病管理制度',
		'inspGuideRecord.mcr' : '没有晨检制度及晨检记录',
		'inspGuideRecord.scr' : '没有因病缺勤病因追查与登记制度',
		'inspGuideRecord.pvi' : '没有小学新生入学接种证查验',
		'inspGuideRecord.shr' : '没有学生健康档案',
		'inspGuideRecord.ktc' : '没有开展传染病防治知识培训并做好记录',
		'inspGuideRecord.iro' : '疫情信息没有按规定上报',
		'inspGuideRecord.hygienicLicense' : '没有卫生许可证',
		'inspGuideRecord.wpdd' : '没有建立卫生管理组织网络、卫生制度和有关岗位制度',
		'inspGuideRecord.whpm' : '没有建立化妆品、一次性卫生用品采购索证制度，有索证登记',
		'inspGuideRecord.hpc' : '没有专用消毒间（场所）',
		'inspGuideRecord.uwp' : '没有足够容量清洗消毒保洁设施',
		'inspGuideRecord.rc' : '供顾客使用的公共用品、用具没有做到一客一换一消毒',
		'inspGuideRecord.swt' : '空调等通风设施运转、保养、维修、洗消等工作状态不好',
		'inspGuideRecord.hms' : '没有卫生管理制度',
		'inspGuideRecord.hmp' : '没有卫生管理人员',
		'inspGuideRecord.hcandhk' : '没有供、管水从业人员健康合格证明和卫生知识培训合格证明',
		'inspGuideRecord.wt' : '没有天有水质检测记录 / 检测报告',
		'inspGuideRecord.wdd' : '水质净化消毒设施不正常运转/ 饮水机不消毒',
		'inspGuideRecord.wpsw' : '没有水源卫生防护措施 / 贮存仓库',
		'inspGuideRecord.ud' : '使用的涉水产品、消毒剂没有卫生许可批件',
		'inspGuideRecord.rcwt' : '没有定期清洗消毒和水质检验（仅限二次供水单位填写）',
		'inspGuideRecord.sdw' : '二次供水水箱饮用水不专用（仅限二次供水单位填写）',
		'inspGuideRecord.ssp' : '二次供水水箱周围存在污染（仅限二次供水单位填写）',
		'inspGuideRecord.dosp' : '饮用水水质感官性状检测有异味: ',
		'inspGuideRecord.dostv' : '饮用水水质感官性状检测有肉眼可见物: ',
	};

	var choose = {
		'inspGuideRecord.cyxkz' : '2',
		'inspGuideRecord.bcb' : '2',
		'inspGuideRecord.bfhin' : '2',
		'inspGuideRecord.fblfbr' : '2',
		'inspGuideRecord.osnu' : '1',
		'inspGuideRecord.ict' : '2',
		'inspGuideRecord.lpau' : '2',
		'inspGuideRecord.lhs' : '2',
		'inspGuideRecord.lcd' : '2',
		'inspGuideRecord.acf' : '2',
		'inspGuideRecord.wfcf' : '2',
		'inspGuideRecord.wbgz' : '2',
		'inspGuideRecord.erp' : '2',
		'inspGuideRecord.pep' : '2',
		'inspGuideRecord.idms' : '2',
		'inspGuideRecord.mcr' : '2',
		'inspGuideRecord.scr' : '2',
		'inspGuideRecord.pvi' : '2',
		'inspGuideRecord.shr' : '2',
		'inspGuideRecord.ktc' : '2',
		'inspGuideRecord.iro' : '2',
		'inspGuideRecord.hygienicLicense' : '2',
		'inspGuideRecord.bcb' : '2',
		'inspGuideRecord.wpdd' : '2',
		'inspGuideRecord.whpm' : '2',
		'inspGuideRecord.hpc' : '2',
		'inspGuideRecord.uwp' : '2',
		'inspGuideRecord.rc' : '2',
		'inspGuideRecord.swt' : '2',
		'inspGuideRecord.wfcf' : '2',
		'inspGuideRecord.hms' : '2',
		'inspGuideRecord.hmp' : '2',
		'inspGuideRecord.hcandhk' : '2',
		'inspGuideRecord.wt' : '2',
		'inspGuideRecord.wdd' : '2',
		'inspGuideRecord.wpsw' : '2',
		'inspGuideRecord.ud' : '2',
		'inspGuideRecord.rcwt' : '2',
		'inspGuideRecord.sdw' : '2',
		'inspGuideRecord.ssp' : '2',
		'inspGuideRecord.dosp' : '1',
		'inspGuideRecord.dostv' : '1',
	};

	function cleanMainProbleamAndReport() {
		$("#findMainPro").val("");
		$("#infoContent").val("");
	}

	function setMainProbleamLis(event) {
		var $this = $(this);
		var patentId = event.data.parent;
		var type = $this.attr("type");
		var name = "";
		if (type == "radio") {
			name = $this.attr("name");
			if (name) {
				setMainProbleam(patentId, name);
			}
		} else if (type == "checkbox") {
			if ($this.prop("checked")) {
				return;
			}
			var $parentTd = $this.parentsUntil("tr");
			// 选择是否
			name = $parentTd.next().next().find("input[type='radio']:first").attr("name");
			if (name) {
				setMainProbleam(patentId, name);
				return;
			}
			// 输入
			name = $parentTd.next().find("input[type='text']:first").attr("name");
			if (name) {
				cleanMainProbleamWithoutRadio(patentId, $this, name);
				return;
			}
			// 水质
			setMainProbleam(patentId, "inspGuideRecord.dosp");
			setMainProbleam(patentId, "inspGuideRecord.dostv");
		}

	}

	var praRex = /从业人员.+?等.+?名无健康合格证明和卫生知识培训合格证明;/;

	var otherRex = /其他:.+?;/;

	function cleanMainProbleamWithoutRadio(patentId, $checkbox, name) {
		var rex = null;
		if (name) {
			if (name == "inspGuideRecord.praNames" || name == "inspGuideRecord.praCount") {
				rex = praRex;
			} else if (name = "inspGuideRecord.ohter") {
				rex = otherRex;
			}
			if (rex) {
				var prob = $("#findMainPro").val() || "";
				prob = prob.replace(rex, "");
				setMainProbleamAndReport(prob);
			}
		}
	}

	function setMainProbleamWithTextInput(event) {
		var $this = $(this);
		var name = $this.attr("name");
		var patentId = event.data.parent;
		var prob = $("#findMainPro").val() || "";
		var rex = null;
		var message = null;
		if (name == "inspGuideRecord.praNames" || name == "inspGuideRecord.praCount") {
			var $praNames = $("input[name='inspGuideRecord.praNames']", patentId).val();
			var $praCount = $("input[name='inspGuideRecord.praCount']", patentId).val();
			if ($praNames && $praCount) {
				message = "从业人员" + $praNames + "等" + $praCount + "名无健康合格证明和卫生知识培训合格证明;";
				rex = praRex;
			}
		} else if (name = "inspGuideRecord.ohter") {
			var otherValue = $this.val();
			if (otherValue) {
				message = "其他:" + otherValue + ";";
				rex = otherRex;
			}
		}
		if (message && rex) {
			if (-1 != prob.search(rex)) {
				prob = prob.replace(rex, message);
			} else {
				prob += message;
			}
		} else {
			prob = prob.replace(rex, "");
		}

		setMainProbleamAndReport(prob);
	}

	function setMainProbleamAndReport(prob) {
		var old = $("#findMainPro").val();
		if (old != prob) {
			$("#findMainPro").val(prob);
			$("#infoContent").val(prob);
		}
	}

	function setMainProbleam(parent, name) {
		var $this = $(parent + " input[name='" + name + "']:checked");
		var value = $this.val();
		var prob = $("#findMainPro").val() || "";
		var c = choose[name];
		var tip = message[name] || "";
		if (c) {
			if (name == "inspGuideRecord.hmp") {
				// TODO
				if (value == '4') {
					prob = prob.replace("没有卫生管理人员", "");
					prob = replaceOrAppendStr(prob, "卫生管理人员不全");
				} else if (value == '2') {
					prob = prob.replace("卫生管理人员不全", "");
					prob = replaceOrAppendStr(prob, "没有卫生管理人员");
				} else {
					prob = prob.replace("没有卫生管理人员", "");
					prob = prob.replace("卫生管理人员不全", "");
				}
			} else if (c == value) {
				prob = replaceOrAppendStr(prob, tip);
			} else {
				prob = prob.replace(tip, "");
			}
		}
		setMainProbleamAndReport(prob);
	}

	function replaceOrAppendStr(old, some) {
		if (!old) {
			old = "";
		}
		old = $.trim(old);
		if (old) {
			var index = old.indexOf(some);
			if (index != -1) {
				return old;
			}
			return old + " " + some;
		}
		return some;
	}

	return {
		searchLocation : doSearchLocation
	};

})();