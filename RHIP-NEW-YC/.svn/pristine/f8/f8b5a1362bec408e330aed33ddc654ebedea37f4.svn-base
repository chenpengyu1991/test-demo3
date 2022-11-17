var occPatientReportAdd = (function() {
	var validate=null;
	$(function() {
		addIcd10AutoComplete();
		validate=$("#report-input-form").easyValidate();
		/*职业病病人单位信息*/
		$("#reportSave").on("click", function(event) {
            event.preventDefault();//防止整个页面刷新
            reportSave();
		});
		idCardAutoComplete();
	});

	function search(indexPage) {
		var searchObj = {
			url : "/oh/occPatient/employeeInfolist",
			insertDiv : "resultDiv",
			param : {
				indexPage : indexPage
			}
		};
		$("#occPatientSearchForm").submitFormLoadHtml(searchObj);
	};

	function reportSave() {
		var result = validate.validateForm();
		if (!result) {
			return;
		}
		$("#report-input-form").submitFormGetJson({
			url: "/oh/occPatient/reportSave",
			callback: function (data) {
				//msgUtil.alert("报卡上报成功！");
				//returnSearch();
				if (data.indexOf("fail") > -1) {
					layer.alert("报卡上报失败！", {icon:0,title:'提示'});
				} else {
					layer.alert("报卡上报成功！", {icon:0,title:'提示'}, function(index){
						returnSearch();
						layer.close(index);
						return false;
			             
	                });
				}

			}
		});
	}

	function returnSearch(){
        if(contentChanged){
            msgUtil.backConfirm(function(){
                var pageIndex = $("#pageIndex").val();
				occPatientReportSearch.search(1);
                $("#mainSearchDiv").show();
                $("#operationDiv").empty();
                disableChangeConfirm();
            });
        }else{
            var pageIndex = $("#pageIndex").val();
			occPatientReportSearch.search(1);
            $("#mainSearchDiv").show();
            $("#operationDiv").empty();
            disableChangeConfirm();
        }
    }

	function addIcd10AutoComplete() {
		$.getJsonByUrl({
			url : "/oh/occPatient/complete/odDisease",
			param : {
				inputValue : "C"
			},
			callback : function(data) {
				var hbpDiagnosedOrganCode = $("#underlyingDeathCode");
				if (hbpDiagnosedOrganCode.length > 0)
				{
					hbpDiagnosedOrganCode.autocomplete(data, {
						minChars : 0,
						width : 250,
						max : 100,
						autoFill : false,
						matchContains : true,
						formatItem : function(row, i, max) {
							return row.diseaseName + "[" + row.icd10main + "]";
						},
						formatMatch : function(row, i, max) {
							return row.diseaseName + " " + row.icd10main;
						},
						formatResult : function(row) {
							return row.icd10main;
						}
					}).result(function(event, data, formatted){
						$("input[name='tumorType']").val(data.diseaseName);
					});
				}
			}
		});
	}

	function idCardAutoComplete(){
		var idCard = $('#idCard').val();
		//如果身份证号码不为空，再修改身份证后不再从健康档案从新获取患者信息，但是需要验证）
		if(isEmpty(idCard)){
			$.Placeholder.init({query:"#idCard",callback:function(element){
				//reportCheck();
				queryPerson($(element).val());
			}});
		}
		//else{
		//	$('#idCard').on("change",function(){
		//		reportCheck();
		//	});
		//}
	}

	function queryPerson(idCard) {
		if (validate.validate("idCard")){
			$.getJsonByUrl({
				url : "/idm/report/queryPerson",
				wait : true,
				callback : function(data) {
					if(!isEmpty(data))
							setPersonData(data);
					else
							setIcData(data.Idcard);
					
				},
				param:{idCard:idCard}
			});
		}
	};

	/*如果获取患者信息失败，根据身份证号码获取性别、出生日期*/
	function setIcData(idCard) {
		var gender = IC.getGender(idCard);
		if (!isEmpty(gender)) {
			$('#gender').val(gender);
		}
		var birthday = IC.getBirthday(idCard);
		if (!isEmpty(birthday)) {
			$('#birthday').val(birthday);
		}
	}

	
		
	function setPersonData(data){
		if(!isEmpty(data.Name)){
			$('#nameStr').val(data.Name);
		}
		$('#idCard').val(data.Idcard);
		if(!isEmpty(data.Birthday)){
			var birthday = IC.getBirthday(data.Idcard);
			$('#birthday').val(birthday);
		}else{
			$('#birthday').val(data.Birthday);
		}
		var gender = data.Gender;
		$('input[@type=radio][name="gender"][value=' + gender + ']').attr("checked",true);
		if(!isEmpty(data.UnitName)){
			$('#unitNameId').val(data.UnitName);
		}
		if(!isEmpty(data.PhoneNumber)){
			$('#phoneNumberId').val(data.PhoneNumber);
		}
		var iddStreet ;
		if(!isEmpty(data.PatownShip)){//现住址
			$('#patown_address').val(data.PatownShip);
			//$("#patown_address").multiselect('refresh');
			/*var idd = $("#patown_address").attr("idd").replace('townId', '');
			orgUtil.getVillageOpting(idd,"",data.Pastreet);
			if(!isEmpty(data.Pastreet)){
				$('#pavillage_address').val(data.Pastreet);
			}*/
			iddStreet=$("#patown_address").attr("idd").replace('townId', '');
			orgUtil.getStreetOpting(iddStreet, data.Pastreet, '', data.paGroup);
		}
		if(!isEmpty(data.PahouseNumber)){
			$('#pahouseNumber').val(data.PahouseNumber);
		}
		/*if(!isEmpty(data.HrtownShip)){//户籍地址
			$('#hrtown_address').val(data.HrtownShip);
			var idd = $("#hrtown_address").attr("idd").replace('townId', '');
			orgUtil.getVillageOpting(idd,"",data.Hrstreet);
			if(!isEmpty(data.Hrstreet)){
				$('#hrvillage_address').val(data.Hrstreet);
			}
		}
		if(!isEmpty(data.HrhouseNumber)){
			$('#hrhouseNumber').val(data.HrhouseNumber);
		}*/
		//if(!isEmpty(data.Nation)){
		//	$('#nationId').val(data.Nation);
		//}
		if(!isEmpty(data.Education)){
			$('#educationId').val(data.Education);
		}
	}

	return {
		returnSearch:returnSearch,
		reportSave:reportSave
	};
})();
