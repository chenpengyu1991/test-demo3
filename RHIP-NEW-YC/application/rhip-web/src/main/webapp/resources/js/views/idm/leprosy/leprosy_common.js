var leprosyCommon = (function() {
	$(function() {
        toggleOther('diagnosis.isLeprosy','leprosyType','1');
		idmCommon.toggerAddress();
	});
	
	function add(singleId, specialStatus,type,leprosyType) { 
		$("#top_all" + leprosyType).hide();
		var pageIndex = $("#currentPage" + leprosyType).val();
		$.loadHtmlByUrl({
			url : "/idm/leprosy/init",
//            wait : true,
			insertDiv :"detailDiv" + leprosyType,
			param : {
				singleId: singleId,
				specialStatus: specialStatus, 
				type: type,
				pageIndex: pageIndex
			}
		});
		$("#detailDiv" + leprosyType).show();
	};
	
	function toggle(obj,tableId) {
		$(obj).toggleClass("ico-top");
		$(obj).toggleClass("ico-bottom");
		$("#" + tableId).toggle();
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
	
	function deleteLeprosy(singleId,idmId,methodName) {
		var search = eval(methodName);
		var index = layer.confirm("你确定要删除此条数据吗？", {icon:2, title:'确认提示'}, function(){
			$.getJsonByUrl({
				 url : contextPath+"/idm/leprosy/delete",
                wait : true,
				 callback:function(data){
					 if(data.indexOf('success') > -1) {
						 layui.use('layer', function() {
								var layer = layui.layer;
								layer.alert("删除成功！");
							});
						 search(1);
					 } else {
						 layui.use('layer', function() {
								var layer = layui.layer;
								layer.alert("删除失败！");
							});
					 }
				 },
				 param:{
					 singleId:singleId,
					 idmId: idmId
					 }
			});
			layer.close(index);
		});
	}
	
	function leprosySubmit(type, specialStatus, methodName, formName) {
    	var result=$("#" + formName).easyValidate().validateForm();
    	if(!result){
    		return;
    	}
    	submit(type, specialStatus, methodName, formName);
	};
	
	/**
	 * 与后台交互保存数据
	 */
	function submit(type, specialStatus, methodName, formName) {
		var searchTemp = eval(methodName);
		$("#" + formName).submitFormGetJson({
			url : '/idm/leprosy/save',
            wait : true,
            callback : function(data) {
                if (data.indexOf("fail") > -1) {
                    layer.alert(getMessage(specialStatus) + "失败！");
                }else {
                    layer.alert(getMessage(specialStatus) + "成功！");
                    if(type == '1') {
                    	if(formName == "leprosyFormSuspected") {
                    		suspected.getNotCount();
                    	}
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
		var reviewResult = $("input[name='caseInformation.reviewResult']:checked").val();
		if(!$.isEmpty(reviewResult)) {
			return "审核";
		}
		if(specialStatus=='1') {
			return '报卡上报';
		} else if(specialStatus=='2') {
			return '个案登记保存';
		}
		
	}
	function returnSearch(methodName){
		var searchTemp = eval(methodName);
		if(contentChanged){
			msgUtil.backConfirm(function(){
				searchTemp();
			});
		}else{
			searchTemp();			
		}
	}
	
	/**
	 * 根据身份证获取信息
	 */
	function queryPerson(idCard) {
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
		$("input[name='generalCondition.gender'][value='" + gender + "']").attr("checked",true); 
		$("input[name='generalCondition.floatPopulation'][value='" + data.FloatPopulation+ "']").attr("checked",true); 
		$("input[name='generalCondition.unitName']").val(data.UnitName);
		$("input[name='generalCondition.phoneNumber']").val(data.PhoneNumber);
		$("select[name='generalCondition.occupation']").val(data.Occupation);
		toggleOtherSC('generalCondition.occupation','spanOccupationOther','CV020120299');
		$('#patown_address').val(data.PatownShip);
		var idd = $("#patown_address").attr("idd").replace('townId', '');
		orgUtil.getVillageOpting(idd,"",data.Pastreet);
		if(!$.isEmpty(data.Pastreet)){
			$('#pavillage_address').val(data.Pastreet);
		} 		
		$('#pahouseNumber').val(data.PahouseNumber);
	};

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
	
	return {
        add: add,
        deleteLeprosy: deleteLeprosy,
        toggle:toggle,
        leprosySubmit : leprosySubmit,
        queryPerson: queryPerson,
		returnSearch:returnSearch
	};
})();
