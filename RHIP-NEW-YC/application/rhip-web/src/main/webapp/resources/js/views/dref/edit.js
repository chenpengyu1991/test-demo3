var dualReferralEdit = (function() {
	var validate = $("#editForm").easyValidate();
	$(function() {
		if ($("#message").val() != '' && $("#message").val() != null) {
			layer.alert($("#message").val(), {icon:0,title:'提示'});
		}
		enableChangeConfirm();
		initOrganTree("referralHospital", getDeptList);
		$("#back").click(back);
		$("#save").click(saveReferralInfo);
		$("#saveByexplore").click(saveReferralInfo);
		$("#print1").click(function(){
			print1('');
		});
		$("#fastreet").on("change villageChange", addressPrefix);
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
		codeToName();
		var referralHospitalCode = $("input[name='referralHospitalCode'][ref='referralHospital']").val();
		if (referralHospitalCode == $("#editForm #destDeptCode").val()) {
			layer.alert("转入医院不能与转出医院相同，请重新选择。", {icon:0,title:'提示'});
			return;
		}
        if(referralHospitalCode==""){
        	layer.alert("转入医院请选择提供的医院，请重新选择。", {icon:0,title:'提示'});
            return;
        }
		if (validate.validateForm()) {
			var option = {
				url : "/dref/save",
				param : {
					from : $("#from").val()
				},
				callback : (function(result) {
					layer.alert(result.message, {icon:0,title:'提示'}, function(index) {
						if (result.success && !result.explore) {
							back();
						} else {
							location.href= contextPath + "/referral/explorer";
						}
						layer.close(index);
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
		disableChangeConfirm();
		baseLayoutLoad.popMainContent();
		dualReferralSearch.search();
	}

	return {
		addressPrefix : addressPrefix,
		back : back
	}
})();