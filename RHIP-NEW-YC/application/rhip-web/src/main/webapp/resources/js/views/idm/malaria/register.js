var register = (function() {
	var validate=null;
	$(function() {
		validate = $("#registerForm").easyValidate();
		var value=$('input[name="generalCondition.floatPopulation"]:checked').val();
		if($.isEmpty(value)){
			$('input[name="generalCondition.floatPopulation"][value="1"]').attr("checked",true);
		}
		value=$('input[name="labExamine.testResult"]:checked').val();
		if($.isEmpty(value)){
			$('input[name="labExamine.testResult"][value="1"]').attr("checked",true);
		}
		value=$('input[name="diagnosis.tentativeDiagnosis"]:checked').val();
		if($.isEmpty(value)){
			$('input[name="diagnosis.tentativeDiagnosis"][value="1"]').attr("checked",true);
		}		
		approvalStatus();
		toggerAddress();
		enableChangeConfirm();
		var type = $('#tagContent0').find('#type').val();
		/*如果是查看，则禁用页面*/
		if('view' == type){
			$("#registerForm").diabaleForm();
			$('#pathogenesisDateId').removeAttr("onfocus");
			$('#testDtId').removeAttr("onfocus");
			$('#reportDateId').removeAttr("onfocus");
			$('.required').removeClass("required");
		}else{
			$.Placeholder.init({query:"#idCard",callback:function(element){
				queryPerson($(element).val());
			}});			
		}

        displayPaAddress();
	});
	
	/* “通过”、“排除”链接状态控制
	 * 临床初诊的字典值:1、2、3、99
	 * 检验结果的字典值：1、2、3
	 * 1、临床初诊为1，检验结果为1、2时，只能选择"通过"
	 * 2、其他组合只能选择"排除"
	 * */
	function approvalStatus(){
		var diagnosis=$('input[name="diagnosis.tentativeDiagnosis"]:checked').val();
		var testResult=$('input[name="labExamine.testResult"]:checked').val();
		var regApproval = $("#regApprovalId");//“通过链接”
		var regRemove = $("#reg_remove");//“排除链接”

		if(diagnosis == '1' && (testResult == '1' || testResult == '2') && !$.isEmpty(regApproval)){
			$('#regApprovalId').show();
			$('#regApprovalId').unbind("click");
	        $("#regApprovalId").click(function() {
	        	approval(3);
	        });	
	        $('#reg_remove').hide();
        	$('#reg_remove').unbind("click");
		}else if(!$.isEmpty(regRemove)){
			$('#regApprovalId').hide();
        	$('#regApprovalId').unbind("click");
			$('#reg_remove').show();
			$('#reg_remove').unbind("click");
	        $("#reg_remove").click(function() {
	        	approval(2);
	        });        	
		}
		
	}
	/*隐藏、显示地址*/
	function toggerAddress(){
		var value=$('input[name="generalCondition.floatPopulation"]:checked').val();
		if('1' == value){
			changeAddress("1");
		}else{
			changeAddress("2");
		}
		toggleOther('generalCondition.floatPopulation','pavillage_address','1');
		toggleOther('generalCondition.floatPopulation','patown_address','1');
        displayPaAddress();
    }
	function changeAddress(type){
		if(type=="1"){
			$("#pavillage_address").removeAttr("disabled");
			$('#patown_address').removeAttr("disabled");
            $("#tempPaValue").show();
            $('#spanPaNumber').text("门牌号");
			$('#pahouseNumber').attr({"style":"width:180px"});
			$(".pa_hr_address").hide();
		}else{
			$("#pavillage_address").attr("disabled", "disabled");
			$("#patown_address").attr("disabled", "disabled");
            $("#tempPaValue").hide();
            $('#spanPaNumber').text("详细地址");
			$('#pahouseNumber').attr({'style':'width:90%'});
			$(".pa_hr_address").show();
		}
	}
	function search(){
		disableChangeConfirm();
        var pageIndex = $('#tagContent0').find('#pageIndex').val();
		$("#registerdetailDiv").empty();
		pageIndex = ($.isEmpty(pageIndex)?1:pageIndex);
		malariaIndex.searchRegister(pageIndex);
		$("#register_top_all").show();		
	}
	function returnSearch(){
        if(contentChanged){
        	msgUtil.backConfirm(function(){
				search();
			});        	
        }else{
        	search();
        }
	}
	function approval(status) {
        var idCard = $('#idCard').val();
        if(idCard == '输入身份证获取个人信息'){
            $('#idCard').val('');
        }
    	var acceptUnit = $('#acceptUnitId').val();
    	var acceptTown = $('#acceptTownId').val();
    	if(status != '2'){
			if($.isEmpty(acceptTown)){
				validate.addCheckElement('caseInformation.acceptTown',{"required":"true"});	
			}else{
				validate.removeCheckElement('caseInformation.acceptTown');
			}     	
			if($.isEmpty(acceptUnit)){
				validate.addCheckElement('caseInformation.acceptUnit',{"required":"true"});	
			}else{
				validate.removeCheckElement('caseInformation.acceptUnit');
			} 	
    	}
    	var result=validate.validateForm();
    	if(!result){
    		return;
    	}
   	
    	/*当选择户籍时,把非户籍地址中的户籍地址清空*/
    	var value=$('input[name="generalCondition.floatPopulation"]:checked').val();
    	if('1' == value){
    		$('#hrAddress').val('');
    	}
    	
    	var message ="";
    	if(status == 2){
    		message = '温馨提示：点击确定后，血检排除';
    	}else{
    		message = '温馨提示：点击确定后，血检通过';
    	}
    	var index = layer.confirm(message, {icon:1, title:'确认提示'}, function(){
			$("#specialStatusId").val(status);
			$("#registerForm").submitFormGetJson({
				url : "/idm/malaria/register/approvalRegister",
                wait : true,
				callback : function(data) {
					if (data.indexOf("fail") > -1) {
						layui.use('layer', function() {
							var layer = layui.layer;
							layer.alert("血检审核失败！", {icon:0,title:'提示'});
						});
	                }else {
	                	layui.use('layer', function() {
	                		var layer = layui.layer;
	                		layer.alert("血检审核成功！", {icon:0,title:'提示'});
	                	});
	                	search();
	                   return false;
	                }
				},
	            wait:true
			});
			layer.close(index);
		});
	};
	function viewLog(id) { 
		var dialogObj = {
				url : contextPath + "/idm/malaria/popApproval",
				param : {idmId:id,indexPage:1},
				title : "操作记录"
			};
		$.dialog(dialogObj);		
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
	function registerSubmit(){
		var idCard = $('#idCard').val();
		if(idCard == '输入身份证获取个人信息'){
			 $('#idCard').val('');
		}
    	var result=validate.validateForm();
    	if(!result){
    		return;
    	}	
    	/*当选择户籍时,把非户籍地址中的户籍地址清空*/
    	var value=$('input[name="generalCondition.floatPopulation"]:checked').val();
    	if('1' == value){
    		$('#hrAddress').val('');
    	}
    	
		$("#registerForm").submitFormGetJson({
			url : "/idm/malaria/register/saveregister",
			callback : function(data) {
				if (data.indexOf("fail") > -1) {
					layer.alert("登记失败！", {icon:0,title:'提示'});
                }else {
                	layer.alert("登记成功！", {icon:0,title:'提示'});
                	search();
                   return false;
                }
			},
            wait:true
		});    	
	}
	function queryPerson(idCard) {
        if (validate.validate("generalCondition.idcard")){
            $.getJsonByUrl({
                url : "/idm/report/queryPerson",
                wait : true,
                callback : function(data) {
                    if(!$.isEmpty(data)){
                        if(data.flag){
                            setPersonData(data);
                            idmCommon.setAge(data.Idcard);
                        }else{
                            setIcData(data.Idcard);
                            idmCommon.setAge(data.Idcard);
                        }
                    }
                },
                param:{idCard:idCard}
            });
        }
	};
	function setPersonData(data){
		$('#idCard').val(data.Idcard);
		$('#nameId').val(data.Name);
		$('#logoffId').val(data.Logoff);
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
		$('input[name="generalCondition.gender"][value="' + gender + '"]').attr("checked",true);
        $('input[name="generalCondition.floatPopulation"][value="' + data.FloatPopulation+ '"]').attr("checked",true);
        $('#phoneNumberId').val(data.PhoneNumber);
		$('#patown_address').val(data.PatownShip);
		var idd = $("#patown_address").attr("idd").replace('townId', '');
		orgUtil.getVillageOpting(idd,"",data.Pastreet);
    	if(!$.isEmpty(data.Pastreet)){
    		$('#pavillage_address').val(data.Pastreet);
    	}
        toggerAddress();
		
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

    function displayPaAddress() {
        $("select[name='generalCondition.pastreet']").on("change villageChange", function()
        {
            var prefix = $("select[name='generalCondition.patownShip']").find("option[value!='']:selected").text();
            prefix += $(this).find("option[value!='']:selected").text();
            $("#tempPaValue").text(prefix);
        });
    }

	return {
		toggerAddress:toggerAddress,
		returnSearch:returnSearch,
		registerSubmit:registerSubmit,
		approval:approval,
		viewLog:viewLog,
		approvalStatus:approvalStatus,
        displayPaAddress:displayPaAddress
	};
})();