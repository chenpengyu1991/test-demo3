var referralEdit = (function() {
	var validate = $("#editForm").easyValidate();
	$(function() {
		if ($("#message").val() != '' && $("#message").val() != null) {
			layer.alert($("#message").val(), {icon:0,title:'提示'});
		}
		initOrganTree("referralHospital", getDeptList);
		$("#saveBtn").click(function(e) {
			e.preventDefault();
			saveReferralInfo()
			});

		$("#backBtn").click(function(e) {
			e.preventDefault();
			layer.confirm("确认离开？",function(index){
				layer.close(index);
				backToReferralTab();
			});
		});


		/*$("#fastreet").on("change villageChange", addressPrefix);
		*/
		// 现地址变化
		$("select[name='fatownShip']").on("change streetChange", function(){
			changeHouseNumber('fatownShip',null,null,'tempPaValue', 'orgFaName','text_fahouseNumber', null);
			$("#tempPaValuePaTownShipId").text($(this).find("option[value!='']:selected").text());
		});
		$("select[name='fastreet']").on("change villageChange", function(){
			changeHouseNumber('fatownShip','fastreet',null,'tempPaValue', 'orgFaName','text_fahouseNumber', null);
			$("#tempPaValuePastreetId").text($(this).find("option[value!='']:selected").text());
		});
		$("select[name='faGroup']").on("change groupChange", function(){
			changeHouseNumber('fatownShip','fastreet','faGroup','tempPaValue', 'orgFaName', null, 'displayFaAddress');
		});
		$.Placeholder.init({query: "#idCard", callback: function() {
			if (!validate.validate("idCard")) {
				return
			}
			var option = {
				url : "/dref/getPersonInfo",
				param : {
					idCard: $("#idCard").val()
				},
				callback : function(personInfo) {
					setPersonData(personInfo);
				},
				wait : true
			};
			$.getJsonByUrl(option);
		}});
	});
	
	function backToReferralTab() {
		$.loadHtmlByUrl({
			url : contextPath + "/personRecord/referralList",
			insertDiv :"referral_info",
		});
	}

	function addressPrefix() {
		var town = $("#fatownShip option:selected").text();
		var village = $("#fastreet option:selected").text();
		var prefix = "";
		if (town != "请选择") {
			prefix = town;
		}
		if (village != "请选择") {
			prefix += village;
		}
		$("#addressPrefix").text(prefix);
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
	
	
	 function displayFaAddress() {
	        var town = $("#town_address option:selected").text();
	        var street = $("#street_address option:selected").text();
	        var village = $("#village_address option:selected").text();
	        if(!$.isEmpty($("#village_address option:selected").val())) {
	            $("#text_fahouseNumber").removeAttr("reg");
	            $("#text_fahouseNumber").removeClass("lose");
	        }else{
	        	$("#text_fahouseNumber").attr("reg", '{"required":"true","maxlength":23}');
	        	if($.isEmpty($("#text_fahouseNumber").val())){
	        		$("#text_fahouseNumber").attr("class", "lose");
	        	}
	        }
	    }

	function setPersonData(personInfo) {
		if (personInfo == null) {
			return;
		}
		$("#personId").val(personInfo.id);
		$("#healthFileNo").val(personInfo.healthFileNo);
		$("#name").val(personInfo.name);
		$("#editForm input[name='gender']").val([personInfo.gender]);
		$("#birthday").val(personInfo.birthdayStr);
		$("#patientPhone").val(personInfo.phoneNumber);
		$("#editForm select[name='fatownShip']").val(personInfo.patownShip);
		var fatownShipIdd = $("#editForm select[name='fatownShip']").attr("idd");
		if (fatownShipIdd) {
			orgUtil.getVillageOpting(fatownShipIdd.replace("townId", ""), "fastreet", personInfo.pastreet);
		}
		$("#fahouseNumber").val(personInfo.pahouseNumber);
	}

	function getDeptList() {
		var organCode = $("input[name='referralHospitalCode'][ref='referralHospital']").val();
		orgUtil.getDeptOption(organCode, "referralDeptCode");
	}

	function saveReferralInfo() {
		/*codeToName();
		var referralHospitalCode = $("input[name='referralHospitalCode'][ref='referralHospital']").val();
		if (referralHospitalCode == $("#editForm #destDeptCode").val()) {
			layer.alert("转入医院不能与转出医院相同，请重新选择。");
			return;
		}
        if(referralHospitalCode==""){
            layer.alert("转入医院请选择提供的医院，请重新选择。");
            return;
        }*/
        
		var referralHospitalName = $("#referralHospitalName").val();
        if (referralHospitalName == $("#editForm #destDeptName").val()) {
        	layer.alert("转入医院不能与转出医院相同，请重新填写。", {icon:0,title:'提示'});
			return;
		}	
        if(!$.isEmpty($("#village_address option:selected").val())) {
            $("#text_fahouseNumber").removeAttr("reg");
            $("#text_fahouseNumber").removeClass("lose");
        }
        validate = $("#editForm").easyValidate();
		if (validate.validateForm()) {
			var option = {
				url : "/ehrbrowser/basic/saveReferralInfo",
				param : {
					from : $("#from").val()
				},
				callback : (function(result) {
					layer.alert(result.message, {icon:0,title:'提示'}, function(index) {
						if (result.success && !result.explore) {
							$("#referral_info_li").children(":first").html("&#xe605;");// 打勾样式已完成
							backToReferralTab();
						} else {
							location.href= contextPath + "/referral/explorer";
						}
						layer.close(index);
						layer.close(index-1);
					});
					
				}),
				wait : true
			};
			$("#editForm").submitFormGetJson(option);
		}
	}

	function print1(id){
        if($.isEmpty(id)){
            id = $("#print1Id").val();
        }
        var url = contextPath + "/dref/print1?id=" + id;
        util.printPage(url);
    }
	
	function codeToName() {
		$("#referralHospitalName").val($("#referralHospital").val());
		var destRoomName = $("#destRoomCode option:selected").text()
		if (destRoomName != "请选择") {
			$("#destRoomName").val(destRoomName);
		}
		var referralDeptName = $("#referralDeptCode option:selected").text();
		if (referralDeptName != "请选择") {
			$("#referralDeptName").val(referralDeptName);
		}
	}

	function initOrganTree(selectId, callbackFun) {
		var treeOpt = {
			url: "/mdmOrganization/organationTree",
			unSelecteType:['0'],
			param : {
				organType : "A100,B100,B200,R2"
			},
			selectFun : callbackFun
		};
		var opb = {
			url: "/mdmOrganization/organationSelect",
			feild: {
				value: "organCode",
				lable: "organName"
			},
			param : {
				organType : "A100,B100,B200,R2"
			},
			selectFun : callbackFun
		};
		var organTree = $("#" + selectId);
		if (organTree.length > 0) {
			organTree.selectBox(opb);
			organTree.initTreeSelect(treeOpt);
		}
	}
	
	function back() {
		$.removeDialog("referralInfoDialog");
		referralSearch.search(1);
	}

	return {
		displayFaAddress : displayFaAddress,
		addressPrefix : addressPrefix,
		back : back,
		backToReferralTab:backToReferralTab
	}
})();