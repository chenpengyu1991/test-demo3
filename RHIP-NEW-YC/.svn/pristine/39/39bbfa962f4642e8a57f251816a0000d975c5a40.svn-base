var tbCommon = (function() {
	var validate;
    function downLoad(){
        location.href = contextPath + "/idm/tb/treatment/downLoad"+"?" + $('#transfertreatSearchForm').formSerialize();
    }

    function downLoadRegister(){
        location.href = contextPath + "/idm/tb/confirmed/register/downLoad"+"?" + $('#registerSearchForm').formSerialize();
    }

	function downLoadRecommendation(){
		location.href = contextPath + "/idm/tb/confirmed/recommendation/downLoad"+"?" + $('#recommendationSearchForm').formSerialize();
	}

	function add(singleId, specialStatus,type,tbType) { 
		$("#top_all" + tbType).hide();
		var pageIndex = $("#currentPage" + tbType).val();
		$.loadHtmlByUrl({
			url : "/idm/tb/treatment/init",
			insertDiv :"detailDiv" + tbType,
//            wait : true,
			param : {
				singleId: singleId,
				specialStatus: specialStatus, 
				type: type,
				pageIndex: pageIndex
			},
            callback:function(){
			    //查看
			    if('3' == type){
                    $("#tbFormRecommendation").diabaleForm();
                    $("#tbFormRegister").diabaleForm();
                    $("#tbFormTransfertreat").diabaleForm();
                    $("#tbForm").diabaleForm();
                    $("#tbFormDcmr").diabaleForm();
                    $("#tbFormTreatment").diabaleForm();
                }
            }
		});
		$("#detailDiv" + tbType).show();
	}
	
	function toggle(obj,tableId) {
		$(obj).toggleClass("ico-top");
		$(obj).toggleClass("ico-bottom");
		$("#" + tableId).toggle();
	}
	
	function queryPerson(idCard, validate) {
        if (validate.validate("generalCondition.idcard")){
            $.getJsonByUrl({
                url : "/idm/report/queryPerson",
                wait : true,
                callback : function(data) {
                    if(!$.isEmpty(data)){
                        if(data.flag){
                            setPersonData(data);
                            setAge(data.Idcard);
                        }else{
                            setIcData(data.Idcard);
                            setAge(data.Idcard);
                        }
                    }
                },
                param:{idCard:idCard}
            });
        }
	}

    function setAge(idNo){
        var idCardBirthDay = IC.getBirthday(idNo);
        var lastedAge = getAge(idCardBirthDay);
        $("#age").val(lastedAge);
        $("input[name=ageUnit]:eq(0)").attr("checked",'checked');
        $("input[name=\'generalCondition.ageUnit\']:eq(0)").attr("checked",'checked');
    }

    /*解析日期字符串*/
    function parseDate(str){

        if(str.match(/^\d{4}[\/\/\s+]\d{1,2}[\/\/\s+]\d{1,2}$/)){
            return new Date(str.replace(/[\-\/\s+]/i,'/'));
        }else if(str.match(/^\d{8}$/)){
            return new Date(str.substring(0,4)+'/'+str.substring(4,6)+'/'+str.substring(6));
        }else{
            layer.alert('date parse error', {icon:0,title:'提示'});
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
            layer.alert("输入错误！", {icon:0,title:'提示'});
            age="";
        }else{
            if(thisMonth-brithm < 0){
                age = thisYear-brithy-1;
            } else if (thisMonth-brithm == 0){
                if(thisDay-brithd>=0){
                    age = thisYear-brithy;
                } else {
                    age = thisYear-brithy-1;
                }
            } else {
                age = thisYear-brithy;
            }
        }
        return age;
    }

    /**
     * 根据身份证获取信息
     */
	function setPersonData(data){
		$("input[name='generalCondition.idcard']").val(data.Idcard);
		$("input[name='generalCondition.name']").val(data.Name);
		if($.isEmpty(data.Birthday)){
			var birthday = IC.getBirthday(data.Idcard);
			$("input[name='generalCondition.birthday']").val(birthday);
		}else{
			$("input[name='generalCondition.birthday']").val(data.Birthday);
		}
		var gender;
		if($.isEmpty(data.Gender)){
			gender = IC.getGender(data.Idcard);
		}else{
			gender = data.Gender;
		}
		/*$('input[@type=radio][name=generalCondition.gender][value=' + gender + ']').attr("checked",true);*/
		$("input[name='generalCondition.gender'][value='" + gender + "']").attr("checked",true); 
		$("input[name='generalCondition.floatPopulation'][value='" + data.FloatPopulation+ "']").attr("checked",true); 
		$("input[name='generalCondition.unitName']").val(data.UnitName);
		$("input[name='generalCondition.phoneNumber']").val(data.PhoneNumber);
		// $("select[name='generalCondition.nation']").val(data.Nation);
        $("input[name='generalCondition.nation'][value='" + data.Nation + "']").attr("checked",true);
        $("#cdmOtherNationDesc").val(data.otherNationDesc);
		$("select[name='generalCondition.occupation']").val(data.Occupation);
		toggleOtherSC('generalCondition.occupation','spanOccupationOther','CV020120299');
		if(data.Nation == "99"){
            $("#cdmOtherNationDesc").show();
        }
        if (data.FloatPopulation == "2" || data.FloatPopulation == "4") {
        	$("#hr-address-select").find("select").attr("disabled", "disabled").hide();
            $("#tempHrValue").hide();
        }
        
        var iddStreet2 ;
        var iddStreet;

        if(data.HrtownShip!=null){
            $("#hrtown_address").val(data.HrtownShip);
            iddStreet2 = $("#hrtown_address").attr("idd").replace('townId', '');
        }
        if(data.PatownShip!=null){
            $("#patown_address").val(data.PatownShip);
            iddStreet=$("#patown_address").attr("idd").replace('townId', '');
        }

        orgUtil.getStreetOpting(iddStreet, data.Pastreet, 'idmCommon.displayPaAddress', data.PaGroup);
        setTimeout(function () {
            orgUtil.getStreetOpting(iddStreet2, data.Hrstreet, 'idmCommon.displayHrAddress', data.HrGroup);
        }, 500);
        $("#tempHrValue").text(data.HrAddressDetail);
        $("#tempPaValue").text(data.PaAddressDetail);

        $('#pahouseNumber').val(data.PahouseNumber);
        $('#hrhouseNumber').val(data.HrhouseNumber);
        $("input[name='logoff']").val(data.Logoff);
	}
	
    function changeAddress(type){
        if(type=="1"){
            $("#hrvillage_address").removeAttr("disabled");
            $("#hrStreet_address").removeAttr("disabled");
            $('#hrtown_address').removeAttr("disabled");
            $("#tempHrValue").show();
            $('#spanHrNumber').text("门牌号");
            $('#hrhouseNumber').attr({"style":"width:180px"});
        }else{
            $("#hrvillage_address").attr("disabled", "disabled");
            $("#hrStreet_address").attr("disabled", "disabled");
            $("#hrtown_address").attr("disabled", "disabled");
            $("#tempHrValue").hide();
            $('#spanHrNumber').text("详细地址");
            $('#hrhouseNumber').attr({'style':'width:50%'});
        }
    }
	
	
	
	/*如果获取患者信息失败，根据身份证号码获取性别、出生日期*/
	function setIcData(idCard){
		var gender = IC.getGender(idCard);
		if(!$.isEmpty(gender)){
			$('#gender').val(gender);
		}
		var birthday = IC.getBirthday(idCard);
		if(!$.isEmpty(birthday)){
			$('#birthday').val(birthday);
		}
	}

	function deleteTb(singleId,idmId,methodName) {
		var search = eval(methodName);
		
		layui.use('layer', function(){
			var layer = layui.layer;
			layer.confirm("你确定要删除此条数据吗？", {icon:2, title:'确认提示'}, function(index){
				$.getJsonByUrl({
					 url : contextPath+"/idm/tb/confirmed/delete",
	                 wait : true,
					 callback:function(data){
						 if(data.indexOf('success') > -1) {
							 layer.alert("删除成功！", {icon:0,title:'提示'});
							 search(1);
						 } else {
							 layer.alert("删除失败！", {icon:0,title:'提示'});
						 }
					 },
					 param:{
						 singleId:singleId,
						 idmId: idmId
						 }
				});
				layer.close(index);
			});
		});		
	}
	
	function tbSubmit(type, specialStatus, methodName, formName) {
        var idCard = $('#idCard').val();
        if(idCard == '输入身份证获取个人信息'){
            $('#idCard').val('');
        }
        // 验证
        validate = $("#" + formName).easyValidate();
        var result = validate.validateForm();
        if (!result){
            return;
        }
        
    	if((specialStatus == '4' || specialStatus == '5') && $("#stopReasonDt").val() !='') {
    		layui.use('layer', function(){
    			var layer = layui.layer;
    			layer.confirm("停止治疗日期为" + $("#stopReasonDt").val() +",您确认此患者要停止治疗吗?", {icon:1, title:'确认提示'}, function(index){
	    			submit(type, specialStatus, methodName,formName);
	    			layer.close(index);
	    		});
	    	});		
    	} else {
    		submit(type, specialStatus, methodName,formName);
    	}
	};
	
	/**
	 * 与后台交互保存数据
	 */
	function submit(type, specialStatus, methodName,formName) {
		var searchTemp = eval(methodName);
		
		$("#" + formName).submitFormGetJson({
			url : '/idm/tb/treatment/save',
            wait : true,
            callback : function(data) {
                if (data.indexOf("fail") > -1) {
                    layer.alert(getMessage(specialStatus) + "保存失败！", {icon:0,title:'提示'});
                }else {
                    layer.alert(getMessage(specialStatus) + "保存成功！", {icon:0,title:'提示'});
                    if(type == '1') {
                    	searchTemp(1);
                    } else {
                    	searchTemp();
                    }
                    return false;
                }
            },
            param : {
            	type:type
            }
		});
	}
	function getMessage(specialStatus) {
		if(specialStatus=='1') {
			return '推荐单';
		} else if(specialStatus=='2') {
			return '筛查登记';
		} else if(specialStatus=='3') {
			return '转诊';
		} else if(specialStatus=='4') {
			return '专用病历';
		} else if(specialStatus=='5') {
			return '治疗管理卡';
		} else if(specialStatus=='11') {
			return '诊断';
		}
		
	}
	function returnSearch(methodName){
		var searchTemp = eval(methodName);
		// if(contentChanged){
			layui.use('layer', function(){
			var layer = layui.layer;
			var index = layer.confirm("确认离开？", {icon:1, title:'确认提示'}, function() {
				layer.close(index);
				searchTemp();
			});
			});
			/*msgUtil.backConfirm(function(){
				searchTemp();
			});*/
		// }else{
		// 	searchTemp();
		// }
	}

	return {
        add: add,
        deleteTb: deleteTb,
        toggle:toggle,
        tbSubmit : tbSubmit,
        queryPerson: queryPerson,
		returnSearch:returnSearch,
        downLoad:downLoad,
        downLoadRegister:downLoadRegister,
		downLoadRecommendation:downLoadRecommendation
	};
})();
