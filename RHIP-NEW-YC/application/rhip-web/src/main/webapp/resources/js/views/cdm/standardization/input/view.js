var dmManageInput = (function()
{
	var validate = null;
	var target={
			"diComSmokingFlag":"#diComSmokingDailyNum",
			"diComDrinkingFlag":"#diComDrinkingdailyNum",
			diCcomCoronaryFlag:"#diCcomCoronaryDisDate,#diCcomCoronaryTreatment",
			diCcomHbpFlag:"#diCcomHbpDisDate,#diCcomHbpTreatment",
			diCcomHbcFlag:"#diCcomHbcDisDate,#diCcomHbcTreatment",
			diCcomRetyFlag:"#diCcomRetyDisDate,#diCcomRetypTreatment",
			diCcomNerveFlag:"#diCcomNerveDisDate,#diCcomNerveTreatment",
			diCcomStrokeFlag:"#diCcomStrokeDisDate,#diCcomStrokeTreatment",
			diCcomFootFlag:"#diCcomFootDisDate,#diCcomFootTreatment",
			diCcomKidneyFlag:"#diCcomKidneyDisDate,#diCcomKidneyTreatment",
			diRtInsulinFlag:"#diRtInsulinDailyCount,#diRtInsulinPerDose",
			diRtHypDrugsFlag:"#diRtHypDrugsDailyCount,#diRtHypDrugsperDose",
			diRtPhyActivityFlag:"#diRtPhyActivityWeekCount,#diRtPhyActivityTime"
	};
	$(function()
	{
		validate = $("#health-card-form").easyValidate();
		// 保存按钮
		$("#health-card-save-btn").on("click", save);
		$("#health-card-back-btn").on("click", function () {
			layer.confirm("确认离开？",function(index){
				layer.close(index);
				back();
			});
		});
		addDisSwitch();

		$("input[name='hbpSbp']").on("blur", calHbpLevel);
		$("input[name='hbpDbp']").on("blur", calHbpLevel);

		if (!$("select[name='hbpManageLevel']").val()){
			calHbpLevel();
		}

		/*$("select[multiple]").each(function()
		{
			$(this).multiselect({
				header : false,
				noneSelectedText : '请选择诊断方式',
				selectedList : 13
			});
		});*/
		initTab();
		toggleDisable(target);
		makeReadOnly();
		// 其它诊断单位 切换
		$("#hbpOtherDiagnosisOrganFlag").click(function() {
			diagnosisOrganChange("hbp");
		});
		$("#diOtherDiagnosisOrganFlag").click(function() {
			diagnosisOrganChange("di");
		});
        //民族
        var nationValue = $("input[name='personInfo.nation']:checked").val();;
        if('99' == nationValue){
            $("#cdmOtherNationDesc").show();
        }
	});
	
	function makeReadOnly(){
		var readOnly=$("#health-card-save-btn").length<1;
		if(readOnly){
			var $form=$("#health-card-form");
			$form.find("select,input").attr("disabled",true);
			$form.find(" label").removeClass("required");
		}else{
			var option={
					url:"/mdmOrganization/organationTree",
					unSelecteType:['0']
			};
			var opb = {
					url:"/mdmOrganization/organationSelect",
					feild : {
						value : "organCode",
						lable : "organName"
					}
				};
			var hbpDiagnosedOrganCode=$("#hbpDiagnosedOrganCode");
			if(hbpDiagnosedOrganCode.length>0){
				hbpDiagnosedOrganCode.selectBox(opb);
				hbpDiagnosedOrganCode.initTreeSelect(option);
			}
			
			var diDiagnosedOrganCode=$("#diDiagnosedOrganCode");
			if(diDiagnosedOrganCode.length>0){
				diDiagnosedOrganCode.selectBox(opb);
				diDiagnosedOrganCode.initTreeSelect(option);
			}
		}
	}
	
	function toggleDisable(target){
		for(var btn in target){
			$("input[name="+btn+"]").on("click",function(){
				var name=$(this).attr("name");
				if ("1" == $(this).val())
				{
					$(target[name]).attr("disabled", "disabled").each(function(){
						validate.removeError($(this).attr("name"));
					}).val("");
				} else
				{
					$(target[name]).removeAttr("disabled");
				}
			});
		}
	}
	
	function initTab(){
		var $bar=$("#tags");
		$bar.find("a").on("click",function(event){
			var $this=$(this);
			var target=$this.data("target");
			$bar.find("li.selectTag").removeClass("selectTag");
			$this.parent().addClass("selectTag");
			$("#tagContent").children().hide();
			$("#"+target).show();
		});
		$bar.find("a:first").click();
	}
	
	function queryPerson(input)
	{
		if (validate.validate("personInfo.idcard"))
		{
			$("#health-card-form").submitFormGetJson({
				url : "/cdm/reportcard/load",
				insertDiv : "report-card-main",
				callback : function(data)
				{
					setPersonData(data);
				}
			});
		}
	}

	function addDisSwitch()
	{

		$("#dis-select-box input").on("click", function(event)
		{
			var name = $(this).attr("name");
			var targetBoxId = name + "-box";
			if ($(this).prop("checked"))
			{
				$("#" + targetBoxId).show();
			} else
			{
				$("#" + targetBoxId).hide();
			}
		});

		// 人员户籍类型切换
		$("input[name='personInfo.householdType']").on("click", function()
		{
			$("#hrstreet").val("");
        	$("#hrcounty").val("");
        	$("#hrtownShip").val("");
        	$("#text_hrhouseNumber_prefix").text("");
			if ("2" == $(this).val() || "4" == $(this).val())
			{
				$("#hr-address-select").find("select").attr("disabled", "disabled").hide();
				$("#hr-address-select").addClass("hide");
				$("#text_hrhouseNumber_prefix").hide();
			} else
			{
				$("#hr-address-select").find("select").removeAttr("disabled").show();
				$("#hr-address-select").removeClass("hide");
				$("#text_hrhouseNumber_prefix").show();
			}
		});

		displayPaAddress();
		displayHrAddress();
		// 地址变化
		$("select[name='personInfo.patownShip']").on("change streetChange", function(){
        	changeHouseNumber('personInfo.patownShip',null,null,'text_pahouseNumber_prefix','text_pahouseNumber', null);
		});
		$("select[name='personInfo.pastreet']").on("change villageChange", function(){
        	changeHouseNumber('personInfo.patownShip','personInfo.pastreet',null,'text_pahouseNumber_prefix','text_pahouseNumber', null);
		});
		$("select[name='personInfo.paGroup']").on("change groupChange", function(){
			changeHouseNumber('personInfo.patownShip','personInfo.pastreet','personInfo.paGroup','text_pahouseNumber_prefix', null, 'displayPaAddress');
		});
		
		// 地址变化
		$("select[name='personInfo.hrtownShip']").on("change streetChange", function(){
			changeHouseNumber('personInfo.hrtownShip',null,null,'text_hrhouseNumber_prefix','text_hrhouseNumber', null);
		});
		$("select[name='personInfo.hrstreet']").on("change villageChange", function(){
			changeHouseNumber('personInfo.hrtownShip','personInfo.hrstreet',null,'text_hrhouseNumber_prefix','text_hrhouseNumber', null);
		});
		$("select[name='personInfo.hrGroup']").on("change groupChange", function(){
			changeHouseNumber('personInfo.hrtownShip','personInfo.hrstreet','personInfo.hrGroup','text_hrhouseNumber_prefix', null, 'displayHrAddress');
		});
	}

	function changeHouseNumber(townShip, street, group, houseNumber_prefix, houseNumber, methodName){
		var prefix = $("select[name='" + townShip + "']").find("option[value!='']:selected").text();
		if(street != null){
			prefix += " " + $("select[name='" + street + "']").find("option[value!='']:selected").text();
		}
		if(group != null){
			prefix += " " + $("select[name='" + group + "']").find("option[value!='']:selected").text();
		}
		$("#"+houseNumber_prefix).text(prefix);
		if(houseNumber != null){
			$("#" + houseNumber).attr("reg", '{"required":"true","maxlength":23}');
        	if($.isEmpty($("#" + houseNumber).val())){
        		$("#" + houseNumber).attr("class", "lose");
        	}
		}else{
			if (!$.isEmpty(methodName))
			{
				var callback = eval(methodName);
				callback();
			}
		}
	}

	function back()
	{
		$("#cdm-manage-input-box").hide();
		$("#cdm-manage-list-box").show();
	}

	
	function getUpdateDis(){
		if($("#hbp-content").is(":visible")){
			return {hbpFlag:'2'} ;
		}
		if($("#di-content").is(":visible")){
			return {diFlag:'2'} ;
		}
		if($("#coronary-content").is(":visible")){
			return {coronaryFlag:'2'} ;
		}
		if($("#stroke-content").is(":visible")){
			return {strokeFlag:'2'} ;
		}
		if($("#tumor-content").is(":visible")){
			return {tumorFlag:'2'} ;
		}
	}
	
	function save(event)
	{

		var hbpDiagnosedOrganCode  =$("input[name='hbpDiagnosedOrganCode']").val();
		if(!hbpDiagnosedOrganCode){
			$("#hbpDiagnosedOrganCode").val("");
		}

		var diDiagnosedOrganCode  =$("input[name='diDiagnosedOrganCode']").val();
		if(!diDiagnosedOrganCode){
			$("#diDiagnosedOrganCode").val("");
		}

		// 验证
		validate = $("#health-card-form").easyValidate();
		var result = validate.validateForm();
		if (!result)
		{
			// msgUtil.alert("请根据提示正确输入！");
			return;
		}
		// add by Kevin Ro 2019=03-01 附件上传控制
		var hbpHaveAttemp = $("#hbpHaveAttemp>div").length; // 已上传的高血压附件
		var diHaveAttemp = $("#diHaveAttemp>div").length; // 已上传的糖尿病附件
		var hbpHaveAttempHid = $("#hbpHaveAttempHid").val(); // 当值为2的时候为选中了高血压
		var diHaveAttempHid = $("#diHaveAttempHid").val(); // 当值为2的时候为选中了高血压
		/**if(hbpHaveAttempHid == 2) { // 高血压
			if(hbpHaveAttemp == 0 && $("#cdmCardHbpFile ul li").length < 1) {
				layui.use('layer', function(){
        			var layer = layui.layer;
        			layer.alert("请上传高血压附件");
        		});
                return;
			}
		}
		if(diHaveAttempHid == 2) { // 糖尿病
            if(diHaveAttemp == 0 && $("#cdmCardDiFile ul li").length < 1) {
            	layui.use('layer', function(){
        			var layer = layui.layer;
        			layer.alert("请上传糖尿病附件");
        		});
                return;
            }
		}**/
		var param=getUpdateDis();
		if(null==param){
			layui.use('layer', function(){
    			var layer = layui.layer;
    			layer.alert("保存失败！", {icon:0,title:'提示'});
    		});
			/*msgUtil.alert("保存失败");*/
			return;
		}
		// 保存
		$("#health-card-form").submitFormGetJson({
			url : "/cdm/standardization/save",
			param : param,
			wait:true,
			callback : function(data)
			{
				
				layui.use('layer', function(){
	    			var layer = layui.layer;
	    			if (data == "success")
	    			{
	    				var index = layer.alert("保存成功！", {icon:0,title:'提示'}, function()
	    					{
	    					layer.close(index);
	    					back();
	    					search(1);
	    					});
	    			} else
	    			{
	    				layer.alert("保存失败！", {icon:0,title:'提示'});
	    			}
	    			
	    		});
				
				

			}
		});
	}
	
	function search(indexPage) {
        if ((!checkAge())||(!checkSelectedDisType())) {
            return;
        }
        var searchObj = {
            url: "/cdm/standardization/healthCardList",
            insertDiv: "diseaseInfo",
            param: {
                pageIndex: indexPage
            }
        };
        $("#form_search").submitFormLoadHtml(searchObj);
    }
	
	function checkAge() {
        var startAge = $("#startAge").val();
        if (!isNumber(startAge)) {
            $("#startAge").val("");
            layui.use('layer', function(){
    			var layer = layui.layer;
    			layer.alert("请输入正确的年龄段！", {icon:0,title:'提示'});
    		});
            /*msgUtil.alert("请输入正确的年龄段");*/
            return false;
        }
        var endAge = $("#endAge").val();
        if (!isNumber(endAge)) {
            $("#endAge").val("");
            layui.use('layer', function(){
    			var layer = layui.layer;
    			layer.alert("请输入正确的年龄段！", {icon:0,title:'提示'});
    		});
           /* msgUtil.alert("请输入正确的年龄段");*/
            return false;
        }
        if (startAge && endAge && Number(startAge) > Number(endAge)) {
        	layui.use('layer', function(){
    			var layer = layui.layer;
    			layer.alert("开始年龄不能大于结束年龄！", {icon:0,title:'提示'});
    		});
            /*msgUtil.alert("开始年龄不能大于结束年龄");*/
            return false;
        }
        return true;
    }
	 function isNumber(val) {
	        if (val) {
	            return val.match(/(\d+)|(^(\d+.\d+)$)/);
	        }
	        return true;
	    }

    function checkSelectedDisType() {
        var $form = $("#form_search");
        var isManagedFlag = $form.find("input[name='isManagedFlag']:checked").val();
        var managedDateStart = $form.find("input[name='managedDateStart']").val();
        var managedDateEnd = $form.find("input[name='managedDateEnd']").val();

        if (isManagedFlag || managedDateEnd || managedDateStart) {
            var selectedDisType = $form.find("#disTypeSelect").val();
            if (selectedDisType) {
                if ($.isArray(selectedDisType) && selectedDisType.length > 1) {
                	layui.use('layer', function(){
            			var layer = layui.layer;
            			layer.alert("查询管理状态和纳入管理时间时只能选择一种患病类型！", {icon:0,title:'提示'});
            		});
                    /*msgUtil.alert("查询管理状态和纳入管理时间时只能选择一种患病类型");*/
                    return false;
                }
            } else {
            	layui.use('layer', function(){
        			var layer = layui.layer;
        			layer.alert("查询管理状态和纳入管理时间时需要选择一种患病类型！", {icon:0,title:'提示'});
        		});
                /*msgUtil.alert("查询管理状态和纳入管理时间时需要选择一种患病类型");*/
                return false;
            }
        }
        return true;
    }

    function displayPaAddress() {
        var town = $("#pacounty option:selected").text();
        var street = $("#patownShip option:selected").text();
        var village = $("#pastreet option:selected").text();
        if(!$.isEmpty($("#pastreet option:selected").val())) {
            $("#text_pahouseNumber").removeAttr("reg");
            $("#text_pahouseNumber").removeClass("lose");
        }else{
        	$("#text_pahouseNumber").attr("reg", '{"required":"true","maxlength":23}');
        	if($.isEmpty($("#text_pahouseNumber").val())){
        		$("#text_pahouseNumber").attr("class", "lose");
        	}
        }
    }
    
    function displayHrAddress() {
        var town = $("#hrcounty option:selected").text();
        var street = $("#hrtownShip option:selected").text();
        var village = $("#hrstreet option:selected").text();
        if(!$.isEmpty($("#hrstreet option:selected").val())) {
            $("#text_hrhouseNumber").removeAttr("reg");
            $("#text_hrhouseNumber").removeClass("lose");
        }else {
        	$("#text_hrhouseNumber").attr("reg", '{"required":"true","maxlength":23}');
        	if($.isEmpty($("#text_hrhouseNumber").val())){
        		$("#text_hrhouseNumber").attr("class", "lose");
        	}
        }
    }
    
	function calHbpLevel()
	{
		var value = calHbpLevelValue();
		$("select[name='hbpManageLevel']").val(value);
	}

	function calHbpLevelValue()
	{
		debugger;
		var sbp = $("input[name='hbpSbp']").val();
		var dbp = $("input[name='hbpDbp']").val();
		var level = 0;
		if (sbp){
			if (sbp >= 180){
				level = 3;
				return level;
			} else if (sbp >= 160){
				level = 2;
			} else if (sbp >= 140){
				level = 1;
			}
		}

		if (dbp){
			if (dbp >= 110){
				level = 3;
				return level;
			} else if (dbp >= 100){
				level = 2;
				return level;
			} else if (level < 2 && dbp >= 90){
				level = 1;
				return level;
			}
		}
		return level;
	}
	// 诊断机构切换实现
	function diagnosisOrganChange(spanName) {
        if($('input[name="' + spanName + 'OtherDiagnosisOrganFlag"]:visible:checked').val() == '2'){
            $("#" + spanName + "DiagnosedSpanId").hide();
            $("#" + spanName + "DiagnosedNameSpanId").show();
            $("#" + spanName + "FileAddTrId").show();
            $("#" + spanName + "FileViewTrId").show();
        } else {
            $("#" + spanName + "DiagnosedSpanId").show();
            $("#" + spanName + "DiagnosedNameSpanId").hide();
            $("#" + spanName + "FileAddTrId").hide();
            $("#" + spanName + "FileViewTrId").hide();
        }
	}

})();