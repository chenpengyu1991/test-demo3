var outTransferEdit = (function() {
	var validate = $("#editForm").easyValidate();
	$(function() {
		enableChangeConfirm();
		$("#saveAndPrint1").click(saveOutTransfer);
        toggleOtherSC('outTransfer.toOrganCode','toOrganOtherId',699999);
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

	function saveOutTransfer() {
        var validate = $("#editForm").easyValidate();
		if (validate.validateForm()) {
			var option = {
				url : "/outTransfer/save",
				callback : (function(result) {
					layer.alert(result.message, {icon:0,title:'提示'});
					if (result.success) {
                        $("#saveAndPrint1").hide();
                        $("#print1").show();
                        layer.alert("保存成功！", {icon:0,title:'提示'});
                        $("#print1Id").val(result.id);
                        print1(result.id);
					}
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
        var url = contextPath + "/outTransfer/print1?id=" + id;
        util.printPage(url);


//        $("#addDiv").hide();
//        if($.isEmpty(id)){
//            id = $("#print1Id").val();
//        }
//        $("#saveAndPrint1").hide();
//        $("#print1").show();
//        var searchObj = {
//            url : "/outTransfer/print1",
//            insertDiv : "addDiv",
//            param : {
//                id : id
//            },
//            wait:true,
//            callback : function(data) {
//                $("#addDiv").printArea();
//            }
//        };
//        $("#searchForm").submitFormLoadHtml(searchObj);

    }

    function print2(){
        var id = $("#id").val();

        var url = contextPath + "/outTransfer/print2?id=" + id;
        util.printPage(url);


//        var searchObj = {
//            url : "/outTransfer/print2",
//            insertDiv : "detailDiv",
//            param : {
//                id : id
//            },
//            wait:true,
//            callback : function(data){
//                $("#printDiv").printArea();
//            }
//        };
//        $("#searchForm").submitFormLoadHtml(searchObj);
    }

    function editOutTransfer() {
        var id = $("#id").val();
        var validate = $("#editForm").easyValidate();
        if (validate.validateForm()) {
            $("input[name=centerAudit]").attr("disabled",false);
            var option = {
                url : "/outTransfer/edit",
                callback : (function(result) {
//                    $("#printDiv").printArea();
                	layer.alert(result.message, {icon:0,title:'提示'});
                    if (result.success) {
                    	layer.alert(result.message, {icon:0,title:'提示'});
                    }
                    disableChangeConfirm();
                    outTransferSearch.initEdit(id);
                }),
                wait : true
            };
            $("#editForm").submitFormGetJson(option);
        }
    }

    function editAndPrint(patientType) {
        var validate = $("#editForm").easyValidate();
        var medicalDeptAudit = $("input[name=medicalDeptAudit]:checked").val();
        if (validate.validateForm()) {
            $("input[name=centerAudit]").attr("disabled",false);
            var option = {
                url : "/outTransfer/edit",
                callback : (function(result) {

                	layer.alert(result.message, {icon:0,title:'提示'});
                    if (result.success) {
                    	layer.alert("保存成功！", {icon:0,title:'提示'});
                    }
                    if(('01' == patientType || '07' == patientType) && medicalDeptAudit == 1){
                        print2(result.id);
                    }else{
                        back();
                    }
                }),
                wait : true
            };
            $("#editForm").submitFormGetJson(option);
        }
    }

    function back() {
        disableChangeConfirm();
        outTransferSearch.search();
        $("#searchDiv").show();
        $("#detailDiv").empty();

    }

    //传染病(AB) 精神病(F) 皮肤病(L) 心血管内科疾病(i)
//    function approve(outOrg, icdCode, inOrg){
//        var type = getIcdType(icdCode);
//        //常熟市第一人民医院   办理除精神病、传染病以外的疾病转院
////        if("300001" == outOrg){
//        if("46714063-X" == outOrg){
//           if(type != 'AB' && type != 'F'){
//               return true;
//           }
//        }
//        //常熟市第二人民医院（总院和城中分院） 办理除精神病、传染病以外的疾病转院
////        if("300002" == outOrg || "300101" == outOrg){
//        if("46714062-1" == outOrg || "46714062-11" == outOrg){
//            if(type != 'AB' && type != 'F'){
//                return true;
//            }
//        }
//        //常熟市第二人民医院传染病分院    办理传染病疾病转院
////        if("300102" == outOrg){
//        if("320002991" == outOrg){
//            if(type == 'AB'){
//                return true;
//            }
//        }
//        //常熟市中医院  办理除精神病、传染病以外的疾病转院
////        if("300004" == outOrg){
//        if("46714078-7" == outOrg || "46714078-71" == outOrg){
//            if(type != 'AB' && type != 'F'){
//                return true;
//            }
//        }
//        //常熟市第三人民医院   办理精神病转院  -->苏州广济医院
////        if("300003" == outOrg){
//        if("46714117-3" == outOrg){
//            if(type == 'F' && inOrg == '600125'){
//                return true;
//            }
//        }
//        //常熟市第五人民医院  办理皮肤科、心血管内科疾病转院
////        if("200026" == outOrg || "200039" == outOrg){
//        if("46714077-9" == outOrg || "46714077-91" == outOrg){
//            if(type == 'L' || type == 'I'){
//                return true;
//            }
//        }
//        return false;
//    }
//
//    function getIcdType(icdCode){
//        var icdChar1 = icdCode.substring(0,1);
//        //传染病
//        if('A' == icdChar1 || 'B' == icdChar1){
//             return 'AB';
//        }
//        //精神病
//        if('F' == icdChar1){
//            return 'F';
//        }
//        //皮肤病
//        if('L' == icdChar1){
//            return 'L';
//        }
//        //心血管内科疾病
//        if('I' == icdChar1){
//            return 'I';
//        }
//    }

//    function centerApprove(outOrg, icdCode, inOrg){
//        var medResult = $('input[name=medicalDeptAudit]:checked').val();
//        if(medResult == 1){
//            var result = approve(outOrg, icdCode, inOrg);
//            if(result == true){
//                $("input[name = centerAudit]:eq(0)").attr("checked",'checked');
//                $("#centerOpinion").val("通过");
//                $("#centerUserId").show()
//                $("#centerDtId").show()
//            }else{
//                $("input[name = centerAudit]:eq(1)").attr("checked",'checked');
//                $("#centerOpinion").val("不通过");
//                $("#centerUserId").show()
//                $("#centerDtId").show()
//            }
//        }else{
//            $("input[name = centerAudit]:eq(0)").removeAttr("checked");
//            $("input[name = centerAudit]:eq(1)").removeAttr("checked");
//            $("#centerOpinion").val("");
//            $("#centerUserId").hide()
//            $("#centerDtId").hide()
//        }
//
//
//    }

    function centerApprove(outOrg, icdCode, inOrg){
        var patientType = $("#patientType").val();
        var medicalDeptUserCode =  $("#medicalDeptUserCodeId").val();
        var medicalDeptOpinion =  $("#medicalDeptOpinionId").val();
        if(patientType != '03'){
            return;
        }
        var option = {
            url : "/outTransfer/centerApprove",
            param : {
                id: $("#id").val(),
                medicalDeptUserCode:medicalDeptUserCode,
                medicalDeptOpinion:medicalDeptOpinion
            },
            callback : function(personInfo) {
                setPersonData(personInfo);
            },
            wait : true
        };
        $.getJsonByUrl(option);
    }

    function changMedicalDeptAudit(){
        var medResult = $('input[name=medicalDeptAudit]:checked').val();
        if(medResult == 1){
            $("#medicalDeptOpinionId").text("同意转诊。医疗费用报销按照规定办理。");
        }else{
            $("#medicalDeptOpinionId").text("");
        }
    }

    function approveDisplay(result){
        if(result == true){
                $("input[name = centerAudit]:eq(0)").attr("checked",'checked');
                $("#centerOpinion").val("通过");
                $("#centerUserId").show()
                $("#centerDtId").show()
            }else{
                $("input[name = centerAudit]:eq(1)").attr("checked",'checked');
                $("#centerOpinion").val("不通过");
                $("#centerUserId").show()
                $("#centerDtId").show()
            }
        }

	return {
        saveOutTransfer:saveOutTransfer,
        editOutTransfer:editOutTransfer,
        back:back,
        centerApprove:centerApprove,
        print:print,
        editAndPrint:editAndPrint,
        print1:print1,
        print2:print2,
        changMedicalDeptAudit:changMedicalDeptAudit
	}
})();