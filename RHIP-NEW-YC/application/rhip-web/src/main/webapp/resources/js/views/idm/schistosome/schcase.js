var schcase = (function() {
	var validate=null;
	$(function() {
		validate = $("#caseForm").easyValidate();
		$.Placeholder.init({query:"#idCard",callback:function(element){
			queryPerson($(element).val());
		}});				

		enableChangeConfirm();
		toggleOtherCK('clinicalManifestations.otherSelect','clinicalOtherId',1);
		toggleHistory();
        idmCommon.displayPaAddress();
        idmCommon.displayHrAddress();
        idmCommon.initAdress();
        idmCommon.toggerAddress();
        schCommon.diabaleForm('caseForm');
        
        $("#addCaseReturn").click(function(e) {
        	e.preventDefault();
        	returnSearch();
        });
        
        $("#addCaseSubmit").click(function(e) {
        	e.preventDefault();
        	caseSubmit();
        });
        
        $("#addCaseOperateLog").click(function(e) {
        	e.preventDefault();
        	viewLog($("#idmId").val());
        });
	});
	
	function search(){
		disableChangeConfirm();
        var pageIndex = $("#pageIndex").val();
		$("#casedetailDiv").empty();
		pageIndex = ($.isEmpty(pageIndex)?1:pageIndex);
		schCasesSearch.search(pageIndex);
		$("#case_top_all").show();		
	}
	function returnSearch(){
        /*if(contentChanged){
        	msgUtil.backConfirm(function(){
				search();
			});        	
        }else{
        	search();
        }*/
        
        // if(contentChanged){
        	layer.confirm("确认离开？", {icon:1, title:'确认提示'}, function(index){
        		layer.close(index);
				search();
			});        	
        // }else{
        // 	search();
        // }
	}
	function caseSubmit(){
		var idCard = $('#idCard').val();
		if(idCard == '输入身份证获取个人信息'){
			 $('#idCard').val('');
		}
    	var result=validate.validateForm();
    	if(!result){
    		return;
    	}
		$("#caseForm").submitFormGetJson({
			url : "/idm/schistosome/case/save",
			callback : function(data) {
				if (data.indexOf("fail") > -1) {
					layer.alert("个案保存失败！", {icon:0,title:'提示'});
                }else {
                	layer.alert("个案保存成功！", {icon:0,title:'提示'});
                	search();
                   return false;
                }
			},
            wait:true
		});    	
	}	
	function viewLog(id) { 
		/*var dialogObj = {
				url : contextPath + "/idm/schistosome/approval",
				param : {idmId:id},
				title : "操作记录"
			};
		$.dialog(dialogObj);*/	
		
		$.post(contextPath+"/idm/schistosome/approval",
				{
			     idmId:id
				},
				function(ret){
	        		  layer.open({
	        			  type: 1,
	        			  id:'viewAreaOrganizationDialog',
	        			  area: ['955px', '475px'],
	        			  title:"操作记录",
	        			  content: ret
	        		  });
	        	});
	};
	
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
			if(thisMonth-brithm<0){
				age = thisYear-brithy-1;
		    }
			else{
		         if(thisDay-brithd>=0){
		        	 age = thisYear-brithy;
		         }
		         else{age = thisYear-brithy-1;}
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
			layer.alert('date parse error', {icon:0,title:'提示'});
		}
	}

	function queryPerson(idCard) {
		$.getJsonByUrl({
			url : "/idm/report/queryPerson",
			callback : function(data) {
				if(!$.isEmpty(data)){
					if(data.flag){
						setPersonData(data);
					}else{
						setIcData(data.Idcard);
					}
				}
			},
			param:{idCard:idCard},
			wait:true
		});
	};
	function setPersonData(data){
		/*从健康档案获取人员信息时，判断注销状态。modify yjf 20131010*/
		$('#logoff').val(data.Logoff);
		/*从健康档案获取人员信息时，判断注销状态。modify yjf 20131010*/
		$('#idCard').val(data.Idcard);
		$('#nameId').val(data.Name);
		var age;
		if($.isEmpty(data.Birthday)){
			var birthday = IC.getBirthday(data.Idcard);
			age = getAge(birthday);
		}else{
			age = getAge(data.Birthday);
		}
		$('#age').val(age);
		var gender;
		if($.isEmpty(data.Gender)){
			gender = IC.getGender(data.Idcard);
		}else{
			gender = data.Gender;
		}
		$('input[name="generalCondition.floatPopulation"][value="' + data.FloatPopulation + '"]').attr("checked",true);
		$('input[name="generalCondition.gender"][value="' + gender + '"]').attr("checked",true);
		
        idmCommon.toggerAddress();
		$('#hrtown_address').val(data.HrtownShip);
		var idd = $("#hrtown_address").attr("idd").replace('townId', '');
		orgUtil.getVillageOpting(idd,"",data.Hrstreet);
		if($.isEmpty(data.Hrstreet)){
			$('#hrvillage_address').val(data.Hrstreet);
		}
		$('#hrhouseNumber').val(data.HrhouseNumber);
		
		$('#patown_address').val(data.PatownShip);
		var idd = $("#patown_address").attr("idd").replace('townId', '');
		orgUtil.getVillageOpting(idd,"",data.Pastreet);
		if($.isEmpty(data.Pastreet)){
			$('#pavillage_address').val(data.Pastreet);
		}
		$('#pahouseNumber').val(data.PahouseNumber);
	};

	/*如果获取患者信息失败，根据身份证号码获取性别、出生日期*/
	function setIcData(idCard){
		var age;
		var birthday = IC.getBirthday(idCard);
		if(!$.isEmpty(birthday)){
			age = getAge(birthday);
			$('#age').val(age);		
			var gender = IC.getGender(idCard);
			if(!$.isEmpty(gender)){
				$('input[name="generalCondition.gender"][value="' + gender + '"]').attr("checked",true);
			}
		}
	}
	function toggleHistory(){
		toggleOther('pastHistory.previousHistory','trPreviousHistory1',1);
		toggleOther('pastHistory.previousHistory','trPreviousHistory2',1);
		toggleOther('pastHistory.previousHistory','trPreviousHistory3',1);
		toggleOther('pastHistory.previousHistory','trPreviousHistory4',1);
	}
	return {
		returnSearch:returnSearch,
		caseSubmit:caseSubmit,
		viewLog:viewLog,
		toggleHistory:toggleHistory
	};
})();