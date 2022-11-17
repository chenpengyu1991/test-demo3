var baseArchives = (function() {
    var validate=null;
	$(function() {
        validate = $("#baseForm").easyValidate();
//        toggleOther('mhmOtherInfo.bringIntoFlag', 'mgntPart', 1);
        toggleOtherSC('mhmOtherInfo.bringIntoMode', 'bringIntoModeBase', 2);
        toggleOther('mhmOtherInfo.challengedFlag', 'challenged', 1);
        /*toggleOther('mhmOtherInfo.effectFlag', 'ref', 1);*/
        toggleLocalAddress('mhmBasicsInfo.floatPopulation', 'localPart', 1);
        // 其它诊断单位 切换
        $("#isForeignFlag").on("click", diagnosisOrganChange);
        diagnosisOrganChange();
        var idCard = $('#idCard').val();
        $.Placeholder.init({query:"#idCard",callback:function(element){
            queryPerson($(element).val());
        }});
        displayPaAddress();
        displayHrAddress();
        changeFreeFlag();
        mhmCommon.addIcd10AutoComplete("mhmIcd10CodeId");
	});
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
	function toggerAddress(){
        var value=$('input[name="mhmBasicsInfo.floatPopulation"]:checked').val();
        if('1' == value){
            changeAddress("1");
            $('#br').show();
        }else if('2' == value) {
            changeAddress("2");
            $('#br').hide();
        }
        /*toggleOther('mhmBasicsInfo.floatPopulation','pavillage_address','1');
        toggleOther('mhmBasicsInfo.floatPopulation','patown_address','1');*/
        mhmCommon.displayPaAddress();
    }
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

    //提交钱验证的内容
    function customValidate(){
        var idCard = $('#idCard').val();
        if(idCard == '输入身份证获取个人信息'){
            $('#idCard').val('');
        }
    }

    /*保存*/
    function save(){
        customValidate();
        var validate=null;
        validate = $("#baseForm").easyValidate();
        var result=validate.validateForm();
        if(!result){
            return;
        }
        var bringIntoFlag = $("#bringIntoFlag").val();
//        var mhmIcd10CodeTemp = $("#mhmIcd10CodeId").val();
//        if(!$.isEmpty(mhmIcd10CodeTemp)){
//            var start = mhmIcd10CodeTemp.indexOf("[");
//            var end = mhmIcd10CodeTemp.indexOf("]");
//            mhmIcd10CodeTemp = mhmIcd10CodeTemp.substring(start + 1, end);
//        }

        $("#baseForm").submitFormGetJson({
            url : "/mhm/baseArchives/save",
            param : {
                saveFlag : bringIntoFlag
//                'mhmDiagnosis.diagnosisContent' : mhmIcd10CodeTemp
            },
            callback : function(data) {
                if (data.indexOf("fail") > -1) {
                    /*msgUtil.alert("保存失败！");*/
                    layui.use('layer', function(){
            			var layer = layui.layer;
            			layer.alert("保存失败！", {icon:0,title:'提示'});
            		});
                }else {
                	layui.use('layer', function(){
            			var layer = layui.layer;
            			layer.alert("保存成功！", {icon:0,title:'提示'}, function() {
            				layer.closeAll();
            				disableChangeConfirm();
            				casePlan();
            				evaluation();
                            layer.alert("请尽快填写随访信息！", {icon:0,title:'提示'});
            			});

            		});
                    /*msgUtil.alert("保存成功！");*/
                    //重新加载个案管理计划
                    //重新加载效果评估
                    return false;
                }
            },
            wait:true
        });
    }

    /*加载个案管理计划页面*/
    function casePlan() {
        var bringIntoMode = $("select[name='mhmOtherInfo.bringIntoMode']").find("option[value!='']:selected").val();
            //参数
            var loadHtmlByUrlOption = {
                url : "/mhm/management/caseplan/main",
                param : {bringIntoMode:bringIntoMode},
                checkRepeat : true,
                insertDiv : "tagContent5",
                errorDiv: "",
                okDiv:""
            };
        $.loadHtmlByUrl(loadHtmlByUrlOption);
        
    };

    /*加载效果评估页面*/
    function evaluation() {
        var bringIntoMode = $("select[name='mhmOtherInfo.bringIntoMode']").find("option[value!='']:selected").val();
            //参数
            var loadHtmlByUrlOption = {
                url : "/mhm/management/evaluation/main",
                param : {bringIntoMode:bringIntoMode},
                checkRepeat : true,
                insertDiv : "tagContent6",
                errorDiv: "",
                okDiv:""
            };
            $.loadHtmlByUrl(loadHtmlByUrlOption);
    };

    function queryPerson(idCard) {
        if (validate.validate("mhmBasicsInfo.idcard")){
            $.getJsonByUrl({
                url : "/idm/report/queryPerson",
                wait : true,
                callback : function(data) {
                    if(!$.isEmpty(data)){
                        if(data.flag){
                            setPersonData(data);
                        }else{
                            setIcData(data.Idcard);
                        }
                    }
                },
                param:{idCard:idCard}
            });
        }
    };

    /*
     * 根据健康档案设置患者基本信息
     * */
    function setPersonData(data){/*
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
        if(!$.isEmpty(data.PatownShip)){//现住址
            $('#patown_address').val(data.PatownShip);
            var idd = $("#patown_address").attr("idd").replace('townId', '');
            orgUtil.getVillageOpting(idd,"",data.Pastreet);
            if(!$.isEmpty(data.Pastreet)){
                $('#pavillage_address').val(data.Pastreet);
            }
        }
        if(!$.isEmpty(data.PahouseNumber)){
            $('#pahouseNumber').val(data.PahouseNumber);
        }
        if(!$.isEmpty(data.Nation)){
            $('#nationId').val(data.Nation);
        }
        if(!$.isEmpty(data.Education)){
            $('#educationId').val(data.Education);
        }
    */
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
        orgUtil.getStreetOpting(iddStreet, data.Pastreet, '', data.PaGroup);
    }
    /*如果获取患者信息失败，根据身份证号码获取性别*/
    function setIcData(idCard){
        var gender = IC.getGender(idCard);
        if(!$.isEmpty(gender)){
            $('#gender').val(gender);
        }
    }

    /*根据出生日期获取年龄*/
    function getAge(strDate){
    	if($.isEmpty($.trim(strDate))){
    		return;
    	}    	
        var age;
        var aDate=new Date();
        var thisYear=aDate.getFullYear();
        var thisMonth=aDate.getMonth()+1;
        var thisDay=aDate.getDate();
        var brith=parseDate(strDate);
        brithy=brith.getFullYear();
        brithm=brith.getMonth()+1;
        brithd=brith.getDate();
        if(thisYear-brithy<0){
        	layui.use('layer', function(){
    			var layer = layui.layer;
    			layer.alert("输入错误！", {icon:0,title:'提示'});
    		});
            /*msgUtil.alert("输入错误!");*/
            age="";
        }else{
            if(thisMonth-brithm<0){
                age = thisYear-brithy-1;
            }
            else{
                if(thisDay-brithd>=0){
                    age = thisYear-brithy;
                }
                else{
                    age = thisYear-brithy-1;
                }
            }
        }
        return age;
    }
    /*解析日期字符串*/
    function parseDate(str){
        if(str.match(/^\d{4}[\/\/\s+]\d{1,2}[\/\/\s+]\d{1,2}$/)){
            return new Date(str.replace(/[\-\/\s+]/i,'/'));
        }else if(str.match(/^\d{8}$/)){
            return new Date(str.substring(0,4)+'/'+str.substring(4,6)+'/'+str.substring(6));
        }else{
        	layui.use('layer', function(){
    			var layer = layui.layer;
    			layer.alert("date parse error", {icon:0,title:'提示'});
    		});
            /*msgUtil.alert('date parse error');*/
        }
    }

    function popupPatientType(eventId, pageIndex){
        pageIndex = $.isEmpty(pageIndex)? 1:pageIndex;
       /* var patientTypeDialog = {
            url : "/mhm/baseArchives/patientType",
            height : 300,
            width : 600,
            title : "病人类型变更记录" ,
            id :"patientTypeDialog",
            param:{eventId : eventId, pageIndex : pageIndex}
        };
        $.dialog(patientTypeDialog);*/
        
        $.post(contextPath+'/mhm/baseArchives/patientType',
        		{ eventId : eventId, pageIndex : pageIndex
			     }, 
			function(ret){
        	layui.use(['layer'], function() {
        		  var layer = layui.layer
        		  layer.open({
        			  type: 1,
        			  id:'patientTypeDialog',
        			  area: ['600px', '300px'],
        			  title:'病人类型变更记录',
        			  content: ret
        		  });
        		});
        	});
    }

    function popupMgntType(eventId, pageIndex){
        pageIndex = $.isEmpty(pageIndex)? 1:pageIndex;
        /*var mgntTypeDialog = {
            url : "/mhm/baseArchives/mgntType",
            height : 300,
            width : 600,
            title : "管理变更记录" ,
            id :"mgntTypeDialog",
            param:{eventId : eventId, pageIndex : pageIndex}
        };
        $.dialog(mgntTypeDialog);*/
        
        $.post(contextPath+'/mhm/baseArchives/mgntType',
        		{ eventId : eventId, pageIndex : pageIndex
			     }, 
			function(ret){
        	layui.use(['layer'], function() {
        		  var layer = layui.layer
        		  layer.open({
        			  type: 1,
        			  id:'mgntTypeDialog',
        			  area: ['600px', '300px'],
        			  title:'管理变更记录',
        			  content: ret
        		  });
        		});
        	});
    }

    function popupEconomy(eventId, pageIndex){
        pageIndex = $.isEmpty(pageIndex)? 1:pageIndex;
        /*var economyDialog = {
            url : "/mhm/baseArchives/economyHistory",
            height : 300,
            width : 600,
            title : "经济状况变更记录" ,
            id :"economyDialog",
            param:{eventId : eventId, pageIndex : pageIndex}
        };
        $.dialog(economyDialog);*/
        
        $.post(contextPath+'/mhm/baseArchives/economyHistory',
        		{ eventId : eventId, pageIndex : pageIndex
			     }, 
			function(ret){
        	layui.use(['layer'], function() {
        		  var layer = layui.layer
        		  layer.open({
        			  type: 1,
        			  id:'economyDialog',
        			  area: ['600px', '300px'],
        			  title:'经济状况变更记录',
        			  content: ret
        		  });
        		});
        	});
    }

    function popupDrugFree(eventId, pageIndex){
        pageIndex = $.isEmpty(pageIndex)? 1:pageIndex;
        /*var drugFreeDialog = {
            url : "/mhm/baseArchives/drugFree",
            height : 300,
            width : 600,
            title : "免费服药记录" ,
            id :"drugFreeDialog",
            param:{eventId : eventId, pageIndex : pageIndex}
        };
        $.dialog(drugFreeDialog);*/
        
        $.post(contextPath+'/mhm/baseArchives/drugFree',
        		{ eventId : eventId, pageIndex : pageIndex
			     }, 
			function(ret){
        	layui.use(['layer'], function() {
        		  var layer = layui.layer
        		  layer.open({
        			  type: 1,
        			  id:'drugFreeDialog',
        			  area: ['600px', '300px'],
        			  title:'免费服药记录',
        			  content: ret
        		  });
        		});
        	});
    }

    function searchPatientType(pageIndex){
        pageIndex = ($.isEmpty(pageIndex)?1:pageIndex);
        var eventId = $("#eventIdB").val();
        var searchObj = {
            url : "/mhm/baseArchives/patientType",
            insertDiv : 'patientTypeResultDiv',
            param : {
                pageIndex : pageIndex,
                eventId:eventId
            },
//            wait:true,
            callback : function(data) {
                $("#pageIndex").val(pageIndex);
            }
        };
        $("#mgntTypeSearchForm").submitFormLoadHtml(searchObj);
    }

    function searchEconomy(pageIndex){
        pageIndex = ($.isEmpty(pageIndex)?1:pageIndex);
        var eventId = $("#eventIdB").val();
        var searchObj = {
            url : "/mhm/baseArchives/economyHistory",
            insertDiv : 'economyResultDiv',
            param : {
                pageIndex : pageIndex,
                eventId:eventId
            },
            callback : function(data) {
                $("#pageIndex").val(pageIndex);
            }
        };
        $("#economySearchForm").submitFormLoadHtml(searchObj);
    }

    function searchMgntType(pageIndex){
        pageIndex = ($.isEmpty(pageIndex)?1:pageIndex);
        var eventId = $("#eventIdB").val();
        var searchObj = {
            url : "/mhm/baseArchives/mgntType",
            insertDiv : 'mgntTypeResultDiv',
            param : {
                pageIndex : pageIndex,
                eventId:eventId
            },
//            wait:true,
            callback : function(data) {
                $("#pageIndex").val(pageIndex);
            }
        };
        $("#mgntTypeSearchForm").submitFormLoadHtml(searchObj);
    }

    function searchDrugFree(pageIndex){
        pageIndex = ($.isEmpty(pageIndex)?1:pageIndex);
        var eventId = $("#eventIdB").val();
        var searchObj = {
            url : "/mhm/baseArchives/drugFree",
            insertDiv : 'drugFreeResultDiv',
            param : {
                pageIndex : pageIndex,
                eventId:eventId
            },
//            wait:true,
            callback : function(data) {
                $("#pageIndex").val(pageIndex);
            }
        };
        $("#drugFreeSearchForm").submitFormLoadHtml(searchObj);
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

 	return {
        diagnosisOrganChange : diagnosisOrganChange,
        save : save,
        popupMgntType : popupMgntType,
        popupDrugFree : popupDrugFree,
        popupPatientType : popupPatientType,
        popupEconomy : popupEconomy,
        searchMgntType : searchMgntType,
        searchDrugFree : searchDrugFree,
        searchPatientType : searchPatientType,
        searchEconomy : searchEconomy,
        toggleLocalAddress : toggleLocalAddress,
        changeFreeFlag : changeFreeFlag,
        displayPaAddress:displayPaAddress,
        displayHrAddress:displayHrAddress,
        toggerAddress:toggerAddress
	};
})();