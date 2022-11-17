var hirhRiskPersonInfo = (function() {
	var validate = null;
	$(function() {
		$("#highRiskPersonInfo").click(function(){
			highRiskToggle(this,'highRiskSearch');
		});
		
		validate = $("#riskFactorsInfo").easyValidate();
		$("#searchHighRiskInfo").keypress(function(e) {
			var key = e.which;
			if (key == 13) {
				searchHighRiskInfo(1);
			}
		});
		//pageUtil.bind("factorsInfo_view",searchHighRiskInfo);
		searchHighRiskInfo(1);
		$("#searchHighRiskPersonInfo").click(function(e) {
			e.preventDefault();
			searchHighRiskInfo(1);
		});
		$("#saveRiskFactors").click(function(e) {
			e.preventDefault();
			var status = $("#pageMark").val();
			if (!$.isEmpty(status)) {
				saveIntoManage();
			} else {
				saveRiskFactors();
			}
		});
		$("#returnButton").click(function(e) {
			e.preventDefault();
			$("#list_view").show();
			$("#factorsInfo_view").hide();
		});
		$("#assessment").click(function() {
			assessment();
		});
		$("#idcard").keyup(function() {
			var idCardValue = $("#idcard").val();
			$("#idcard").attr("value", idCardValue.toUpperCase());
		});
		// 地址变化
        $("#village_address").change(displayPaAddress);
        notOperational();

		$("#overweightId").click(function() {
			clickShowText("overweightId",'overweightShow');
		});

		$("#noTrainId").click(function() {
			clickShowText("noTrainId",'trainShow');
		});
		$("#currSmokingFlagId").click(function() {
			clickShowText("currSmokingFlagId",'smokeShow');
		});
		$("#longtermDrinkingFlagId").click(function() {
			clickShowText("longtermDrinkingFlagId",'drinnkShow');
		});
		$("#foodGreasyFlagId").click(function() {
			clickShowText("foodGreasyFlagId",'foodShow');
		});
		$("#famHistoryFlagId").click(function() {
			clickShowText("famHistoryFlagId",'famHistoryShow');
		});
		clickShowText("overweightId",'overweightShow');
		clickShowText("noTrainId",'trainShow');
		clickShowText("currSmokingFlagId",'smokeShow');
		clickShowText("longtermDrinkingFlagId",'drinnkShow');
		clickShowText("foodGreasyFlagId",'foodShow');
		clickShowText("famHistoryFlagId",'famHistoryShow');
		calculateLevel();
		$("#check-submit-btn").on("click", function () {
			StartRead();
		});
	});

    function displayPaAddress() {
        var town = $("#town_address option:selected").text();
        var street = $("#street_address option:selected").text();
        var village = $("#village_address option:selected").text();
        if(!$.isEmpty($("#village_address option:selected").val())) {
            $("#text_pahouseNumber").removeAttr("reg");
            $("#text_pahouseNumber").removeClass("lose");
        }
        var result = '';
        if (town != '请选择')
            result = town;
        if (street != '请选择')
            result = result + street;
        if (village != '请选择') {
            result = result + village;
        }
        $("#text_pahouseNumber_prefix").text(result);
    }
	function StartRead()//开始读卡
	{
		if (GT2ICROCX.GetState() == 0){
			GT2ICROCX.ReadCard()
		}

		//GT2ICROCX.ReadCard() //循环读卡

		$("#idcard").val(GT2ICROCX.CardNo);
	}
	
		function checkAge() {
			var beginAge = $("#beginAge").val();
			var endAge = $("#endAge").val();
			if (beginAge && endAge && Number(beginAge) > Number(endAge)) {
				layer.alert("开始年龄不能大于结束年龄！", {icon:0,title:'提示'});
				return false;
			}
			return true;
		}
		function assessment() {
			var assessmentDialog = {
				id : "assessmentDialog",
				url : "/cdm/highrisk/assessment",
				height : 550,
				width : 750,
				title : "生活事件心理应激测试评定量表"
			};
			$.dialog(assessmentDialog);
		}
		function notOperational() {
			$("input[name='riskLevel']").attr("disabled", "disabled");
			$("input[name='lcuLevel']").attr("disabled", "disabled");
			$("input[name='cycle']").attr("disabled", "disabled");
		}
		function operational() {
			$("input[name='riskLevel']").attr("disabled", false);
			$("input[name='lcuLevel']").attr("disabled", false);
			$("input[name='cycle']").attr("disabled", false);
		}
		function selectPerson(personId) {
			var loadHtmlByUrlOption = {
				url : "/cdm/highrisk/factorsInfo",
				param : {
					indexPage : 1,
					personId : personId
				},
				insertDiv : "factorsInfo_view"
			};
			$.loadHtmlByUrl(loadHtmlByUrlOption);
			$("#list_view").hide();
			$("#factorsInfo_view").show();
		}
		function saveRiskFactors() {
			// 验证
			var result = validate.validateForm();
			if (!result) {
				return;
			}
			operational();
			$("#riskFactorsInfo").submitFormGetJson({
				url : "/cdm/highrisk/saveRiskFactors",
				insertDiv : "HighRiskInfo_view",
				callback : function(data) {
					layui.use('layer', function(){
	    				var layer = layui.layer;
	    				
	    				if ("failure" == data) {
	    					layer.alert("操作失败！", {icon:0,title:'提示'});
	    				}
	    				if ("success" == data) {
	    					layer.alert("保存成功！", {icon:0,title:'提示'}, function() {
	    						layer.closeAll();
	    						$("#list_view").show();
	    						$("#factorsInfo_view").hide();
	    						searchHighRiskInfo(1);
	    					});
	    				}
	    			});
				}
			});
			notOperational();
		}
		function saveIntoManage() {
			// 验证
			var result = validate.validateForm();
			if (!result) {
				return;
			}
			operational();
			$("#riskFactorsInfo").submitFormGetJson({
				url : "/cdm/highrisk/saveIntoManage",
				callback : function(data) {
					layui.use('layer', function(){
	    				var layer = layui.layer;
	    				
	    				if ("intoManagefailure" == data) {
	    					layer.alert("已纳入管理不能重复纳入！", {icon:0,title:'提示'});
	    				}
	    				if ("operationFails" == data) {
	    					layer.alert("操作失败！", {icon:0,title:'提示'});
	    				}
	    				if ("intoManageSuccess" == data) {
	    					var index = layer.alert("操作成功,已纳入管理！", {icon:0,title:'提示'}, function() {
	    						$("#list_view").show();
	    						$("#factorsInfo_view").hide();
	    						preventiveManage.searchpreventiveManage(1);
	    						layer.close(index);
	    					});
	    				}
	    				
	    			});
				}
			});
			notOperational();
		}
		function searchHighRiskInfo(indexPage) {
			if (!checkAge()) {
				return false;
			}
			var searchObj = {
				url : "/cdm/highrisk/searchHighRiskInfo",
				insertDiv : "HighRiskInfo_view",
				param : {
					indexPage : indexPage
				},
				callback: function() {
					/*为listDiv中a的添加click事件*/
				    initLinkClick('highRiskPersonInfoSelect',selectPerson, {personInfoList:"data-id"});
			}	
			};
			$("#searchHighRiskInfo").submitFormLoadHtml(searchObj);
		}
		function highRiskToggle(obj, tableId) {
			$(obj).toggleClass("ico-top");
			$(obj).toggleClass("ico-bottom");
			$("#" + tableId).toggle();
		}

		function loadManagePlanForm() {
			$("#riskFactorsInfo").submitFormLoadHtml({
				url : "/cdm/highrisk/addManagePlan",
				param : {},
				insertDiv : "loadManagePlan"
			});
		}
	function clickShowText(obj,textId) {
		if($("#" + obj).is(':checked')) {
			$("#"+textId).removeAttr("disabled");
			$("#"+textId + " input[type='text']").removeAttr("disabled");
			$("#"+textId + " input[type='checkbox']").attr("disabled",false);
		} else {
			$("#"+textId +" input[type='text']").attr("disabled",true);
			$("#"+textId + " input[type='checkbox']").attr("disabled",true);
			$("#"+textId).val("");
			$("#"+textId + " input[type='text']").attr("value","");
			$("#"+textId + " input[type='checkbox']").attr("checked",false);
		}
		calculateLevel();
	}
	function calculateLevel(){
		var  factorCount= $(".calculateLevel:checkbox:checked").length;
		if(factorCount<=2){
			$("input[name='riskLevel']").val(['1']);
			$("input[name='cycle']").val(['1']);
			//$("#onceAYear").attr("checked",true);
			$("#psychologicalAssessment").hide();
		}else if(factorCount>=5){
			$("input[name='riskLevel']").val(['3']);
			$("input[name='cycle']").val(['4']);
			//$("#fourTimesAYear").attr("checked",true);
			$("#psychologicalAssessment").show();
		}else{
			$("input[name='riskLevel']").val(['2']);
			$("input[name='cycle']").val(['2']);
			//$("#twiceAYear").attr("checked",true);
			$("#psychologicalAssessment").hide();
		}
	}

    function editQuestion(idcard, meNumber) {
        $.loadHtmlByUrl({
            url: '/cdm/highrisk/question',
            insertDiv: 'factorsInfo_view',
            param: {
                idcard: idcard,
                meNumber: meNumber
            },
            wait: true,
            callback: function() {
                $('#list_view').hide();
                $('#factorsInfo_view').show();
            }
        });

    }
		return {
			searchHighRiskInfo : searchHighRiskInfo,
			selectPerson : selectPerson,
			saveRiskFactors : saveRiskFactors,
			highRiskToggle : highRiskToggle,
			assessment : assessment,
			editQuestion:editQuestion,
			loadManagePlanForm : loadManagePlanForm,
            displayPaAddress: displayPaAddress
		};
	})();