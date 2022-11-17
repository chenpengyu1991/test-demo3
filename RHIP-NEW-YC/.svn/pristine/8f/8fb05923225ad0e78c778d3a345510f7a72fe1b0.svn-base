var addFamily = (function() {
	var validate = null;
	$(function() {
		validate = $("#familyRecordForm").easyValidate();
		document.body.onkeydown = function(event) {
			var eve = document.all ? window.event : event;
			if (eve.keyCode == 13)
				return false;
		};

		personIndex();
		
		$("#village_address").change(displayValue);

        $("#water").data("validate",true);
        $("#hastoilet").data("validate",true);

		$("#water").multiselect({
			header : false,
			noneSelectedText : '选择自来水类型',
			selectedList : 6
		});



		$("#hastoilet").multiselect({
			header : false,
			noneSelectedText : '选择家庭户厕类型',
			selectedList : 6
		});

		$("#saveButtonId").click(function(e) {
			e.preventDefault();
			var result = validate.validateForm();
			if (!result) {
				layui.use('layer', function(){
	    			var layer = layui.layer;
	    			layer.alert("请根据提示填写完整！", {icon:0,title:'提示'});
	    		});
				return;
			}

			$("#memberForm input[chkRef='memberCheck']").each(function() {
				$(this).attr("checked", "checked");
			});
			
			var water = $("#water").val() ? $("#water").val() + "" : "";
			var hastoilet = $("#hastoilet").val() ? $("#hastoilet").val() + "" : "";

			$("#memberForm").submitFormGetJson({
				url : "/family/save",
				insertDiv : "memberDiv",
				param : {
						indexPage : 1,
						water : water,
						hastoilet : hastoilet,
						orgName : $("#orgName").val(),
						accountNumber : $("#accountNumber").val(),
						patownShip : $("#town_address").val(),
                    	pastreet : $("#street_address").val(),
						paGroup : $("#village_address").val(),
						// pacounty : $("#town_address").val(),
						pahouseNumber : $("#pahouseNumber").val(),
						id : $("#familyUpdateId").val(),
						inputDateString : $("#familyInputDate").val(),
						inputOrganCode : $("#familyInputOrganCode").val(),
						inputOrganName : $("#familyInputOrganName").val(),
						inputName : $("#familyInputName").val(),
						inputIdcard : $("#familyInputIdcard").val(),
						status : $("#familyStatus").val()
					},
				callback : function(data) {
					layui.use('layer', function(){
		    			var layer = layui.layer;
		    			
		    			if (data.indexOf("accountNotOnly") > -1) {
		    				layer.alert("保存失败，户口号重复！", {icon:0,title:'提示'});
		    			} else if (data.indexOf("familyNotOnly") > -1) {
		    				layer.alert("保存失败，选择人员已存在家庭档案！", {icon:0,title:'提示'});
		    			} else if (data.indexOf("noFamilyMember") > -1) {
		    				layer.alert("保存失败，请选择家庭成员！", {icon:0,title:'提示'});
		    			} else if (data.indexOf("multipleFamilyHeadOrMate") > -1) {
		    				layer.alert("保存失败，户主或者配偶不唯一！", {icon:0,title:'提示'});
		    			} else if(data.indexOf("noFamilyHeadError") > -1){
		    				layer.alert("保存失败，户主不能为空！", {icon:0,title:'提示'});
		    			}else {
		    				if(familySearch.refresh){
		    					familySearch.saveClick();
		    					familySearch.refresh();
		    				}
		    				layer.alert("保存成功！", {icon:0,title:'提示'}, function () {
		    					layer.closeAll();
		    				});
		    				/*$.removeDialog("familyUpdateDialog");
		    				$.removeDialog("familyDialog");*/
		    				return false;
		    			}
		    		});
				}
			});
		});

        // 现地址变化
        $("select[name='FamilyRecordDTO.familyInfo.patownShip']").on("change streetChange", function(){
            changeHouseNumber('FamilyRecordDTO.familyInfo.patownShip',null,null,'tempPaValue', 'orgPaName','pahouseNumber', null);
        });
        $("select[name='FamilyRecordDTO.familyInfo.pastreet']").on("change villageChange", function(){
            changeHouseNumber('FamilyRecordDTO.familyInfo.patownShip','FamilyRecordDTO.familyInfo.pastreet',null,'tempValue', 'orgName','pahouseNumber', null);
        });

        $("select[name='FamilyRecordDTO.familyInfo.paGroup']").on("change groupChange", function(){
            changeHouseNumber('FamilyRecordDTO.familyInfo.patownShip','FamilyRecordDTO.familyInfo.pastreet','FamilyRecordDTO.familyInfo.paGroup','tempValue', 'orgName', null, 'displayValue');
        });
	});
	
//	function searchSQ(indexPage) {
//		var searchObj = {
//			url : "/family/list/sq",
//			insertDiv : "familyResultDiv",
//			param : {
//				indexPage : indexPage
//			}
//		};
//		$("#searchSQFamilyRecord").submitFormLoadHtml(searchObj);
//	}
//	function searchOther(indexPage) {
//		var searchObj = {
//			url : "/family/list/other",
//			insertDiv : "familyResultDiv",
//			param : {
//				indexPage : indexPage
//			}
//		};
//		$("#searchOtherFamilyRecord").submitFormLoadHtml(searchObj);
//	}
	function personIndex() {
		$.loadHtmlByUrl({
			url : contextPath + "/family/person/index",
			insertDiv : "memberDiv",
			param : null
		});
	}

	function displayValue() {
    var town = $("#town_address option:selected").text();
    var street = $("#street_address option:selected").text();
    var village = $("#village_address option:selected").text();
    if(!$.isEmpty($("#village_address option:selected").val())) {
      $("#pahouseNumber").removeAttr("reg");
      $("#pahouseNumber").removeClass("lose");
    }
    var result = '';
    if (town != '请选择')
      result = town;
    if (street != '请选择')
      result = result + street;
    if (village != '请选择') {
      result = result + village;
    }
    $("#tempValue").text(result);
    $("#orgName").val(result);
	}

    function changeHouseNumber(townShip, street, group, tempValue, orgName, houseNumber, methodName){
        var prefix = $("select[name='" + townShip + "']").find("option[value!='']:selected").text();
        if(street != null){
            prefix += " " + $("select[name='" + street + "']").find("option[value!='']:selected").text();
        }
        if(group != null){
            prefix += " " + $("select[name='" + group + "']").find("option[value!='']:selected").text();
        }
        $("#"+tempValue).text(prefix);
        $("#"+orgName).text(prefix);
        if(houseNumber != null){
            $("#" + houseNumber).attr("reg", '{"required":"true","maxlength":32}');
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
	return {
        displayValue:displayValue
	};
})();