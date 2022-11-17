var intoEdit = (function() {
    var validate=null;
    $(function() {
        validate = $("#baseForm").easyValidate();
        $.Placeholder.init({query:"#idCard",callback:function(element){
        	
        	validate.removeCheckElement('mhmBasicsInfo.idcard');
    		validate.addCheckElement('mhmBasicsInfo.idcard',{"idCard":["true"]});
        	if(validatePerson($(element).val())){
				queryPerson($(element).val());
			}
        }});
//        toggleOther('mhmOtherInfo.bringIntoFlag', 'mgntPart', 1);
        toggleOtherMgnt('mhmOtherInfo.bringIntoFlag', 1);
        toggleOtherSC('mhmOtherInfo.bringIntoMode', 'bringIntoModeBase', 2);
        toggleOther('mhmOtherInfo.challengedFlag', 'challenged', 1);
        toggleOther('mhmOtherInfo.effectFlag', 'ref', 1);
        toggleLocalAddress('mhmBasicsInfo.floatPopulation', 'localPart', 1);
        //toggerAddress();
        // 其它诊断单位 切换
        $("select[name='mhmBasicsInfo.hrGroup']").change(displayHrAddress);
        $("select[name='mhmBasicsInfo.paGroup']").change(displayPaAddress);
        $("#isForeignFlag").on("click", diagnosisOrganChange);
        diagnosisOrganChange();
        var idCard = $('#idCard').val();
        displayPaAddress();
        displayHrAddress();
        changeFreeFlag;
        mhmCommon.addIcd10AutoComplete("mhmIcd10CodeId");
        $("#back").on("click", function () {
            layer.confirm("确认离开？",function(index){
                layer.close(index);
                $("#managementDetailDiv").empty();
                $("#management_top_all").show();
            });
        });
    });
    function validatePerson(idcard){
		var result = true;
		if (validate.validate("mhmBasicsInfo.idcard")){
	        $.getJsonByUrl({
	            url : "/mhm/clue/validatePerson",
	            wait : true,
	            async : false,
	            callback : function(data) {
	                if(!$.isEmpty(data)){
	                    if(data.validate == 'true'){
	                    	result = false;
	                    	validate.addError('mhmBasicsInfo.idcard',"该患者已经登记");
			        		validate.addCheckElement('mhmBasicsInfo.idcard',{"compare":["idcardFlag","le","该患者已经登记 "]});
			        		$('#idcard').addClass('lose');
	                    }else{
	                    	validate.removeError('mhmBasicsInfo.idcard');
            				validate.removeCheckElement('mhmBasicsInfo.idcard');
	                    }
	                }
	            },
	            param:{idcard:idcard}
	        });	
		}
        return result;
	}
    
    function toggerAddress(){
        var value=$('input[name="mhmBasicsInfo.floatPopulation"]:checked').val();
        if('1' == value){
            changeAddress("1");
            $('#br').show();
        }else if('2' == value) {
            changeAddress("2");
            $('#br').hide();
        }
        displayPaAddress();
    }
    //提交钱验证的内容
    function customValidate(){
        var idCard = $('#idCard').val();
        if(idCard == '输入身份证获取个人信息'){
            $('#idCard').val('');
        }
    }
    /*function displayPaAddress() {
        $("select[name='mhmBasicsInfo.pastreet']").on("change villageChange", function()
        {
            var prefix = $("select[name='mhmBasicsInfo.patownShip']").find("option[value!='']:selected").text();
            prefix += $(this).find("option[value!='']:selected").text();
            $("#tempPaValue").text(prefix);
        });
    }*/
    function displayHrAddress(){

        var town = $("select[name='mhmBasicsInfo.hrtownShip'] option:selected").text();
        var street = $("select[name='mhmBasicsInfo.hrstreet'] option:selected").text();
        var village = $("select[name='mhmBasicsInfo.hrGroup'] option:selected").text();
        if(!$.isEmpty($("select[name='mhmBasicsInfo.hrGroup'] option:selected").val())) {
            $("#hrhouseNumber").removeAttr("reg");
            $("#hrhouseNumber").removeClass("lose");
        }
        var result = '';
        if (town != '请选择')
            result = town;
        if (street != '请选择')
            result = result + street;
        if (village != '请选择') {
            result = result + village;
        }
        $("#tempHrValue").text(result);
    
    }
    
    function displayPaAddress() {
    	var town = $("select[name='mhmBasicsInfo.patownShip'] option:selected").text();
        var street = $("select[name='mhmBasicsInfo.pastreet'] option:selected").text();
        var village = $("select[name='mhmBasicsInfo.paGroup'] option:selected").text();
        if(!$.isEmpty($("select[name='mhmBasicsInfo.paGroup'] option:selected").val())) {
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
        $("#tempPaValue").text(result);
    }
    /*保存*/
    function saveMgnt(){
        var bringIntoFlag = $("#bringIntoFlag").val();
        customValidate();
        var validate=null;
        validate = $("#baseForm").easyValidate();
        var result=validate.validateForm();
        if(!result){
            return;
        }
        $("#baseForm").submitFormGetJson({
            url : "/mhm/baseArchives/save",
            param : {saveFlag : bringIntoFlag},
            callback : function(data) {
                if (data.indexOf("fail") > -1) {
                	layui.use('layer', function(){
    	    			var layer = layui.layer;
    	    			layer.alert("纳入管理失败！", {icon:0,title:'提示'});
    	    		});
                }else {
					if(data.indexOf("basicInfoExists") > -1){
                    	layer.alert("患者信息已存在,不可重复新增！", {icon:0,title:'提示'});
                	}else if(data.indexOf("cancel") > -1){
						layer.alert("患者信息已注销！", {icon:0,title:'提示'});
					}else{
						layui.use('layer', function(){
    	    			var layer = layui.layer;
    	    			layer.alert("纳入管理成功！", {icon:0,title:'提示'}, function() {
    	    				layer.closeAll();
    	    				disableChangeConfirm();
    	    				//intoPatient.search();
							managementSearch.search();
    	    			});
    	    		});
                    return false;
					}
                	
                }
            },
            wait:true
        });
    }

    function saveBaseInfo(){
        var bringIntoFlag = $("#bringIntoFlag").val();
        customValidate();
        var validate=null;
        validate = $("#baseForm").easyValidate();
        var result=validate.validateForm();
        if(!result){
            return;
        }
        $("#baseForm").submitFormGetJson({
            url : "/mhm/baseArchives/saveBaseInfo",
            param : {saveFlag : bringIntoFlag},
            callback : function(data) {
                if(data.indexOf("basicInfoExists") > -1){
                    layer.alert("患者信息已存在,不可重复新增！", {icon:0,title:'提示'});
                }else if (data.indexOf("fail") > -1) {
                    layer.alert("保存失败！", {icon:0,title:'提示'});
                }else {
                    layer.alert("保存成功！", {icon:0,title:'提示'});
                    disableChangeConfirm();
                    $.removeDialog ("intoDialog");
                    //intoPatient.search();
					managementSearch.search();
                    return false;
                }
            },
            wait:true
        });
    }

    // 诊断机构切换实现
    function diagnosisOrganChange()
    {
        if ($('#isForeignFlag:visible:checked').val() == '2')
        {
            $("#foreignHospital").show();
            $("#diagnosisHospital").hide();
            $("#diagnosisHospital").val("");
        } else
        {
            $("#foreignHospital").hide();
            $("#diagnosisHospital").show();
        }
    }

    function queryPerson(idCard) {
        var bringIntoFlag =$("#bringIntoFlag").val();
        debugger
        if (validate.validate("mhmBasicsInfo.idcard")){
            $.getJsonByUrl({
                url : "/idm/report/queryPerson",
                wait : true,
                callback : function(data) {
                    if(!$.isEmpty(data)){
                        if(data.basicInfoExists && isEmpty(bringIntoFlag)){
                            layer.alert("患者信息已存在,不可重复新增！");
                        }else if(data.flag){
                            setPersonData(data);
							if(!data.manageFlag){
								layer.alert("该患者不属于本机构及下属机构管理！",function(index){	
			             		layer.closeAll();
	                			});
							}
                        }else{
                            setIcData(data.Idcard);
                        }
                    }
                },
                param:{idCard:idCard}
            });
        }
    };
    function changeAddress(type){
        if(type=="1"){
        	toggleLocalAddress('mhmBasicsInfo.floatPopulation', 'localPart', 1);
        	 $("#pavillage_address").removeAttr("disabled");
             $("#hrvillage_address").removeAttr("disabled");
             $("#pastreet_address").removeAttr("disabled");
             $("#hrStreet_address").removeAttr("disabled");
             $('#patown_address').removeAttr("disabled");
             $('#hrtown_address').removeAttr("disabled");
             $("#tempPaValue").show();
             $("#tempHrValue").show();
             $('#spanPaNumber').text("门牌号");
             $('#spanHrNumber').text("门牌号");
             $('#pahouseNumber').attr({"style":"width:180px"});
             $('#hrhouseNumber').attr({"style":"width:180px"});
        }else if(type=="2" || type=="4"){
        	$("#pavillage_address").attr("disabled", "disabled");
            $("#hrvillage_address").attr("disabled", "disabled");
            $("#pastreet_address").attr("disabled", "disabled");
            $("#hrStreet_address").attr("disabled", "disabled");
            $("#patown_address").attr("disabled", "disabled");
            $("#hrtown_address").attr("disabled", "disabled");
            $("#tempPaValue").hide();
            $("#tempHrValue").hide();
            $('#spanPaNumber').text("详细地址");
            $('#spanHrNumber').text("详细地址");
            $('#pahouseNumber').attr({'style':'width:90%'});
            $('#hrhouseNumber').attr({'style':'width:90%'});
        }
    }
    /*
     * 根据健康档案设置患者基本信息
     * */
    function setPersonData(data){
        if(!$.isEmpty(data.Name)){
            $('#baseName').val(data.Name);
        }
        if(!$.isEmpty(data.Logoff)){
            $('#logoffIdd').val(data.Logoff);
        }
        var gender;
        if($.isEmpty(data.Gender)){
            gender = IC.getGender(data.Idcard);
        }else{
            gender = data.Gender;
        }
        if(!$.isEmpty(data.PhoneNumber)){
            $('#familyPhone').val(data.PhoneNumber);
        }
        $('input[type=radio][name="mhmBasicsInfo.gender"][value=' + gender + ']').attr("checked",true);

        if(!$.isEmpty(data.UnitName)){
            $('#unitNameId').val(data.UnitName);
        }
        if(!$.isEmpty(data.Occupation)){
            $('#occupationId').val(data.Occupation);
        }
        /*if(!$.isEmpty(data.PatownShip)){//现住址
            $('#patown_address').val(data.PatownShip);
            var idd = $("#patown_address").attr("idd").replace('townId', '');
            orgUtil.getVillageOpting(idd,"",data.Pastreet);
            if(!$.isEmpty(data.Pastreet)){
                $('#pavillage_address').val(data.Pastreet);
            }
        }
        if(!$.isEmpty(data.PahouseNumber)){
            $('#pahouseNumber').val(data.PahouseNumber);
        }*/
        toggleOtherSC('mhmBasicsInfo.occupation','spanOccupationOther','CV020120299');
        if(!$.isEmpty(data.FloatPopulation) && data.FloatPopulation=="1"){
            $('input[name="mhmBasicsInfo.floatPopulation"][value="1"]').attr("checked",true);
        }else{
            $('input[name="mhmBasicsInfo.floatPopulation"][value="1"]').attr("checked",false);
        }
        toggerAddress();
        var iddStreet;
        if(data.PatownShip!=null){
            $("#patown_address").val(data.PatownShip);
            iddStreet=$("#patown_address").attr("idd").replace('townId', '');
        }
        if(!$.isEmpty(data.Nation)){
            $('#nationId').val(data.Nation);
        }
        if(!$.isEmpty(data.Education)){
            $('#educationId').val(data.Education);
        }

        debugger;
        var gbCode ="";
        var centerCode ="";
        var stationCode ="";
        if(!$.isEmpty(data.inputGbcode)){
            var tidRandom;
            $("#tid").val(data.inputGbcode);
            tidRandom=$("#tid").attr("idd").replace('townsId', '');
            gbCode = data.inputGbcode;
        }
        if(!$.isEmpty(data.inputCenterOrganCode)){
            centerCode = data.inputCenterOrganCode;
        }
        if(!$.isEmpty(data.inputOrganCode)){
            stationCode = data.inputOrganCode;
        }
        if(!$.isEmpty(gbCode) ||!$.isEmpty(centerCode) || !$.isEmpty(stationCode)){
            $("#tid").removeAttr("reg");
            $("#tid").removeClass("lose");
            $("#cid").removeAttr("reg");
            $("#cid").removeClass("lose");
            $("#sid").removeAttr("reg");
            $("#sid").removeClass("lose");
            validate.removeCheckElement('mhmOtherInfo.managementStation');
        }
        orgUtil.getTownOpting(tidRandom,false,true,centerCode,stationCode);
        orgUtil.getStreetOpting(iddStreet, data.Pastreet, '', data.PaGroup);
    }


    /*如果获取患者信息失败，根据身份证号码获取性别、出生日期*/
    function setIcData(idCard){
        var gender = IC.getGender(idCard);
        if(!$.isEmpty(gender)){
            $('#gender').val(gender);
        }
    }

    function toggleOtherMgnt(rName, eqValue){
        toggleOther('mhmOtherInfo.bringIntoFlag', 'mgntPart', 1);
        var raValue = $('input[name="' + rName + '"]:visible:checked').val();
        if (raValue == eqValue)
        {
            $("#save1").show();
            $("#save2").hide();
        }else{
            $("#save1").hide();
            $("#save2").show();
        }
    }

    function toggleLocalAddress(radioName, otherId, code)
    {
        var raValue = $('input[name="' + radioName + '"]:visible:checked').val();
        if (raValue == code)
        {
            $("#" + otherId).show();
            $("#" + otherId).find("input").each(function()
            {
                $(this).show();
            });
        } else
        {
            $("#" + otherId).hide();
        }
    }

    function changeFreeFlag(){
        var raValue = $('input[name="mhmOtherInfo.freeFlag"]:checked').val();
        if(1 == raValue){
            $("#stateEconomyId").val(1);
        }
    }

    function uploadFile(id, uploadURL, deleteURL) {

        $("#"+id).fineUploader({
            request: {
                endpoint: contextPath + uploadURL
            },
            validation: {
                allowedExtensions: ['jpeg', 'jpg', 'gif', 'png','doc','docx','xls','xlsx','ppt','pptx','txt','pdf','exe'],
                itemLimit: 1,
                sizeLimit: 5227520 // 5 MB = 5 * 1024 * 1024 bytes
            },
            retry: {
                showButton: true
            },
            deleteFile: {
                enabled: true,
                endpoint: contextPath + deleteURL
            },
            text: {
                uploadButton: "上传附件",
                waitingForResponse: "上传中",
                failedUpload: "上传失败",
                deleteFile: "删除"
            }
        });
    }

    function deleteFile(attId) {

    	layui.use('layer', function(){
    		var layer = layui.layer;
    		layer.confirm("确认删除?", {icon:2, title:'确认提示'}, function(index) {
	            $.getJsonByUrl({
	                url : "/he/upload/deleteAttachment/"+attId,
	                callback : function(data) {
	                    if (data.result) {
	                        $("#"+attId+"-div").remove();
	                    } else {
	                    	layer.alert(data.message, {icon:0,title:'提示'});
	                    }
	                }
	            });
	            layer.close(index);
	    	});
	    });		
    }

    return {
        uploadFile:uploadFile,
        deleteFile:deleteFile,
        diagnosisOrganChange:diagnosisOrganChange,
        saveMgnt:saveMgnt,
        toggleOtherMgnt:toggleOtherMgnt,
        saveBaseInfo:saveBaseInfo,
        toggleLocalAddress:toggleLocalAddress,
        changeFreeFlag:changeFreeFlag,
        displayPaAddress:displayPaAddress,
        displayHrAddress:displayHrAddress,
        toggerAddress:toggerAddress
    };
})();



