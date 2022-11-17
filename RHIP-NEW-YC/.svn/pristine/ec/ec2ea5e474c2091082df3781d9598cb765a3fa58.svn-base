var occPatientAdd = (function() {
	var validateEmpInfo=null;
	var validateComInfo=null;
	$(function() {
		validateEmpInfo=$("#employeeInfoForm").easyValidate();
		validateComInfo = $("#companyInfoForm").easyValidate();
		// tab切换
		/*职业病病人信息*/
		layui.use('element', function(){
			var element = layui.element;
			//一些事件监听
			element.on('tab(ohOccPatientTab)', function(data){
				if (data.index == 0) {/*劳动者信息*/
					tabInfoLoad("/oh/occPatient/initEmployeeModify","tagContent0");
				} else if(data.index == 1) {/*用人单位信息*/
					tabInfoLoad("/oh/occPatient/initCompanyModify","tagContent1");
				}
			});
		});

		initDocType();

		//根据身份证获取信息
		$.Placeholder.init({query:"#idCard",callback:function(element){
			queryPerson($(element).val());
		}});
	});

	
	/*tab信息页面载入*/
	function tabInfoLoad(url,tagId) {
		var employeeId=$('#employeeId').val();
		if(employeeId==''&& tagId!='tagContent0'){
			layui.use('layer', function() {
				var layer = layui.layer;
				var index = layer.confirm('请先保存劳动者信息!', {icon:1, title:'确认提示'}, function(index){
					$("#employee_info_btn").click();
					layer.close(index);
				});
			});
		}
		if(tagId=='tagContent0'){
			$("#docType").on("change", function(event)
					{	
		    			initDocType();	
					});
		}
			url=url+"/"+employeeId;
		var length = $('#'+tagId).has('form').length;
		if (length == 0){
			//参数
			var loadHtmlByUrlOption = {
				url : url,
				param : {
					indexPage : 1,
					type:$("#type").val()
				},
				insertDiv : tagId
			};
			$.loadHtmlByUrl(loadHtmlByUrlOption);
		}
	};
	
	/*保存职业病病人信息*/
	function saveEmployeeInfo() {
		var rs =validateEmpInfo.validateForm();
		if(!rs)
			return;
		var employeeId=$('#employeeId').val();
			//参数
			var saveObj = {
				url : "/oh/occPatient/saveEmployeeInfo",
				insertDiv : "tagContent0",
				param : {
					employeeId : employeeId,
					type:$("#type").val()
				}
			};
			$("#employeeInfoForm").submitFormLoadHtml(saveObj);
	};

	/*保存职业病单位信息*/
	function saveCompanyInfo() {
		var rs =validateComInfo.validateForm();
		if(!rs)
			return;
		var employeeId=$('#employeeId').val();
		//参数
		var saveObj = {
			url : "/oh/occPatient/saveCompanyInfo",
			insertDiv : "tagContent1",
			param : {
				employeeId : employeeId,
				type:$("#companyOptType").val()
			}
		};
		$("#companyInfoForm").submitFormLoadHtml(saveObj);
	};

	function initDocType()
	{	var chkVal = $("input[name='docType'][type='radio']:checked").val();
		if(chkVal== undefined){
			$("input[name=docType][value=1]").attr("checked",true);//
			chkVal=1;
		}
		if(chkVal==1){
			$(".unpneumoconiosis").hide();
			$(".pneumoconiosis").show();
		}else if(chkVal==2){
			$(".pneumoconiosis").hide();
			$(".unpneumoconiosis").show();
		}


	}

	function initAutoSel(){
		var options = {
				url : contextPath + "/oh/occPatient/autoComSel",
				feild:{
					value:"companyName",
					lable:"companyName"
				}
//				,
//				param :{
//					hospitalCode:hospitalCode
//				}
				,submitEdit:true,
				selectFun:function(data){
					//alert($(data).attr("hospitalCode"));
					if($(data).attr("orgCode")!='null')
						$("#orgCode").val($(data).attr("orgCode"));
					if($(data).attr("addr")!='null')
						$("#addr").val($(data).attr("addr"));
					if($(data).attr("economicType")!='null')
						$("#economicType").val($(data).attr("economicType"));
					if($(data).attr("industryType")!='null')
						$("#industryType").val($(data).attr("industryType"));
					if($(data).attr("legalRepr")!='null')
						$("#legalRepr").val($(data).attr("legalRepr"));
					if($(data).attr("contactsName")!='null')
						$("#contactsName").val($(data).attr("contactsName"));
					if($(data).attr("phone")!='null')
						$("#phone").val($(data).attr("phone"));
					
				}
			};
			$("#companyName").selectBox(options);

	}
	function returnSearch(){
		debugger;
		if(contentChanged){
			layui.use('layer', function() {
				var layer = layui.layer;
				var index = layer.confirm('确认离开？', {icon:1, title:'确认提示'}, function(index) {
					var pageIndex = $("#pageIndex").val();
					occPatientSearch.search(1);
					$("#mainSearchDiv").show();
					$("#operationDiv").empty();
					disableChangeConfirm();
					layer.close(index);
					return;
				});
			});
		}else{
			var pageIndex = $("#pageIndex").val();
			occPatientSearch.search(1);
			$("#mainSearchDiv").show();
			$("#operationDiv").empty();
			disableChangeConfirm();
		}
    }
	
	/*隐藏、显示地址*/
	function toggerAddress(){
		var value=$('input[name="householdType"]:checked').val();
		if('1' == value){
			changeAddress("1");
//            $('#br').show();
        }else{
			changeAddress("2");
//            $('#br').hide();
        }
		toggleOther('householdType','pavillage_address','1');
		toggleOther('householdType','patown_address','1');
        //displayPaAddress();
	}
	
	function changeAddress(type){
		if(type=="1"){
			$("#pavillage_address").removeAttr("disabled");
			$('#patown_address').removeAttr("disabled");
            //$("#tempPaValue").show();
            $('#spanPaNumber').text("门牌号");
			$('#pahouseNumber').attr({"style":"width:100px"});
		}else{
			$("#pavillage_address").attr("disabled", "disabled");
			$("#patown_address").attr("disabled", "disabled");
            //$("#tempPaValue").hide();
            $('#spanPaNumber').text("详细地址");
			$('#pahouseNumber').attr({'style':'width:70%'});
		}
	}
	
	function displayPaAddress() {

        $("select[name='pastreet']").on("change villageChange", function()
        {
            var prefix = $("select[name='patownShip']").find("option[value!='']:selected").text();
            prefix += $(this).find("option[value!='']:selected").text();
            $("#tempPaValue").text(prefix);
        });
	}
	
	function queryPerson(idCard) {
        if (validateEmpInfo.validate("idcard")){
            $.getJsonByUrl({
                url : "/idm/report/queryPerson",
                wait : true,
                callback : function(data) {
                    if(!$.isEmpty(data)){
                        if(data.flag){
                            setPersonData(data);
                            //setAge(data.Idcard);
                        }else{
                            setIcData(data.Idcard);
                            //setAge(data.Idcard);
                        }
                    }
                },
                param:{idCard:idCard}
            });
        }
	};
	
	function setPersonData(data){
		$('#idCard').val(data.Idcard);
		$('#employeeInfoForm #name').val(data.Name);
		if($.isEmpty(data.Birthday)){
			var birthday = IC.getBirthday(data.Idcard);
			$('#birthdate').val(birthday);
		}else{
			$('#birthdate').val(data.Birthday);
		}
		var gender;
		if($.isEmpty(data.Gender)){
			gender = IC.getGender(data.Idcard);
		}else{
			gender = data.Gender;
		}
		$('input[name=gender][value=' + gender + ']').attr("checked",true);
//		$('#unitNameId').val(data.UnitName);
//		$('#phoneNumberId').val(data.PhoneNumber);
//		$('#Occupation').val(data.Occupation);
//		toggleOtherSC('occupation','spanOccupationOther','CV020120299');
        if(data.FloatPopulation=="1"){
            $("input[name=householdType][value='1']").attr("checked",true);
        }else{
            $("input[name=householdType][value='2']").attr("checked",true);
        }
        toggerAddress();
		var iddStreet ;
		if(data.PatownShip!=null){
			$("#patown_address").val(data.PatownShip);
			iddStreet=$("#patown_address").attr("idd").replace('townId', '');
		}

		orgUtil.getStreetOpting(iddStreet, data.Pastreet, '', data.paGroup);
		$('#pahouseNumber').val(data.PahouseNumber);
	};
	
	/*如果获取患者信息失败，根据身份证号码获取性别、出生日期*/
	function setIcData(idCard){
		var gender = IC.getGender(idCard);
		if(!$.isEmpty(gender)){
			//$('#gender').val(gender);
			$('input[name=gender][value=' + gender + ']').attr("checked",true);
		}
		var birthday = IC.getBirthday(idCard);
		if(!$.isEmpty(birthday)){
			$('#birthdate').val(birthday);
		}

	}
	
	return {
		returnSearch:returnSearch,
		saveEmployeeInfo:saveEmployeeInfo,
		saveCompanyInfo:saveCompanyInfo,
		initAutoSel:initAutoSel,
		toggerAddress:toggerAddress,
		displayPaAddress:displayPaAddress,
		queryPerson : queryPerson
	};
})();

$(document).ready(function () { 
	//按钮样式切换 
//	$("#enterpriseBtnSearch").hover( 
//		function () { 
//		$(this).removeClass("search_btn").addClass("search_btn_h"); 
//		}, 
//		function () { 
//		$(this).removeClass("search_btn_h").addClass("search_btn"); 
//		} 
//	); 

});
