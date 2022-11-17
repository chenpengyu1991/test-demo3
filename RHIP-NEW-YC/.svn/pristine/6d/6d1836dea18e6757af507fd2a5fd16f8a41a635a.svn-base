var epIodineNutritionMonitorInfoEdit = (function() {
	var validate = $("#infoEditForm").easyValidate();
	$(function() {
		enableChangeConfirm();
		$("#back").click(function() {
			baseLayoutLoad.popMainContent();
			epIodineNutritionMonitorSearch.search($("#_indexPage").val());
			disableChangeConfirm();
		});
		$("#save").click(function() {
			var result = validate.validateForm();
			if (!result) {
				//layer.alert("请根据提示正确填写");
				return;
			}
			var option = {
				url : "/ep/iodineNutrition/monitor/save",
				callback : function(result) {
					layer.alert(result.message, {icon:0,title:'提示'});
					if (result.success) {
						disableChangeConfirm();
						var id = $("input[name='id']").val();
						if (id.length > 0) {
							baseLayoutLoad.popMainContent();
							epIodineNutritionMonitorSearch.search($("#_indexPage").val());
						} else {
							var param = {
									crowd : $("input[name='crowd']").val(),
									investigator : $("input[name='investigator']").val(),
									investigateUnit : $("input[name='investigateUnit']").val(),
									investigateTime : $("input[name='investigateTime']").val()
								};
								baseLayoutLoad.refreshMainContent("/ep/iodineNutrition/monitor/edit", param);
						}
					}
				}
			};
			$("#infoEditForm").submitFormGetJson(option);
		});
	    $("select[name='samplingId']").change(function(){
	    	changeTown($(this).val());
	    });
	    $("input").blur(function(){
	    	computerResult();
	    });
	});
	
	function changeTown(id) {
		var option = {
				url : "/ep/iodineNutrition/monitor/changeSimpling",
				callback : changeTownCallback,
				param : {
					samplingId : id
				}
		};
		$.getJsonByUrl(option);
	}
	
	function changeTownCallback(data) {
		if (data.success) {
			/*var select = $("select[name='gbCode']");
			select.val(data.townCode);
			var patownShipIdd = select.attr("idd");
			if (patownShipIdd) {
				orgUtil.getVillageOpting(patownShipIdd.replace("townId", ""), "pastreet");
			}*/
			 var iddStreet;
		        if(data.townCode!=null){
		            $("#patown_address").val(data.PatownShip);
		            iddStreet=$("#patown_address").attr("idd").replace('townId', '');
		        }
		        orgUtil.getStreetOpting(iddStreet, data.Pastreet, '', data.PaGroup);
			
			$("input[name='schoolName']").val(data.schoolName);
		}
	}
	
	function computerResult() {
		//var familyMembers = getNumberValue("familyMembers");
		var threeDaysDiningPt = getNumberValue("zeroDaySupperPt")
			+ getNumberValue("firstBreakfirstPt")
			+ getNumberValue("firstLunchPt")
			+ getNumberValue("firstSupperPt")
			+ getNumberValue("secondBreakfirstPt")
			+ getNumberValue("secondLunchPt")
			+ getNumberValue("secondSupperPt")
			+ getNumberValue("thirdBreakfirstPt")
			+ getNumberValue("thirdLunchPt")
			+ getNumberValue("thirdSupperPt")
			+ getNumberValue("fourthBreakfirstPt");
		$("input[name='threeDaysDiningPtSalt']").val(threeDaysDiningPt);
		
		if (threeDaysDiningPt > 0) {
			var averageSaltIntake = (getNumberValue("saltcellarWeightBefore") - getNumberValue("saltcellarWeightAfter")) / threeDaysDiningPt * 3;
			$("input[name='averageSaltIntake']").val(averageSaltIntake.toFixed(2));
			var averageSoyIntake = (getNumberValue("soyWeightBefore") - getNumberValue("soyWeightAfter")) / threeDaysDiningPt * 3;
			$("input[name='averageSoyIntake']").val(averageSoyIntake.toFixed(2));
		}

	}
	
	function getNumberValue(name) {
		var inputValue = $("input[name='" + name  + "']").val();
		if ($.isEmpty(inputValue)) {
			return 0;
		}
		return parseFloat(inputValue);
	}
	
	
	return {
		
	};
})();