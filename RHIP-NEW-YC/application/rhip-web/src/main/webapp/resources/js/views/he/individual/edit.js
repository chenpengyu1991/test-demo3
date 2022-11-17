var heIndividualEdit = (function() {
	$(function() {
		toggerAddress();
		toggleOtherCK('individualType','other1','12');
		toggleOtherCK('educationType','other2','9');
		toggleOtherCK('placeName','other3','7');
		toggleOtherCK('guidanceAdvice','other4','12');
		$("#pavillage_address").change(displayPaAddress);
		showst("riskWeightReduction","riskWeightTarget");
        showst("guideVaccination","guideVaccinationDesc");
        showst("riskOther","riskOtherDesc");
        var validate = $("#heIndividualForm").easyValidate();
        $("#idcard").on("blur", function () {
        	queryPerson($("#idcard").val(), validate);
        	
        })
        
        $.Placeholder.init({query:"#idcard",callback:function(element){
			
		}});
		$("#heIndividualSaveButton").click(function() {
			if($("input[class='risk']").is(':checked')==false){
					
				$("span[class='risklable']").css("color","red")
				return;
			}
			if($("#pavillage_address").val().length>0){
				$("#pahouseNumber").removeClass("lose");
				$("#pavillage_address").removeClass("lose");
			}else{
				if($("#pahouseNumber").val().length==0&&$("#pavillage_address").val().length==0){
					$("#pavillage_address").addClass("lose");
					$("#pahouseNumber").addClass("lose");
					return;
				}
				
			}
					
			if (validate.validateForm()) {
				$("#heIndividualForm").submitFormGetJson({
					url : "/he/individual/save",
					callback : submitCallback
				});
			}
		});
		$("#pavillage_address").change(function(){
			if($("#pavillage_address").val().length>0){
				$("#pahouseNumber").removeClass("lose");
				$("#pavillage_address").removeClass("lose");
			}else{
				if($("#pahouseNumber").val().length==0){
					$("#pahouseNumber").addClass("lose");
				}
				
			}
		});
		$("input[class='risk']").click(function(){
			if($("input[class='risk']").is(':checked')==false){
				
				$("span[class='risklable']").css("color","red")
			}else{
				$("span[class='risklable']").css("color","")
			}
			
		});
	});
	
	function showst(checkId,someId) {
        if ($("#" +checkId).attr("checked") == "checked"){
        	$("#"+someId).show();
        }
    }
	function submitCallback(data) {
		/*if (data.result) {
			msgUtil.alert(data.message, function() {
				$.removeDialog("healthEducationActive");
				heIndividualSearch.search(1);
			});
		} else {
			msgUtil.alert(data.message);
		}*/
		
		layui.use('layer', function(){
			var layer = layui.layer;
			if (data.result) {
				var index = layer.alert(data.message, {icon:0,title:'提示'}, function() {
					/*$.removeDialog("healthEducationResource");*/
					layer.closeAll();
					heIndividualSearch.search(1);
				});
			} else {
				layer.alert(data.message, {icon:0,title:'提示'});
			}
			
		});
	}
	function queryPerson(idCard, validate) {
        if (validate.validate("idcard")){
            $.getJsonByUrl({
                url : "/idm/report/queryPerson",
                wait : true,
                callback : function(data) {
                    if(!$.isEmpty(data)){
                        if(data.flag){
                            setPersonData(data);
                            setAge(data.Idcard);
                        }else{
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
		$("input[name='idcard']").val(data.Idcard);
		$("input[name='individualName']").val(data.Name);
		var gender;
		if($.isEmpty(data.Gender)){
			gender = IC.getGender(data.Idcard);
		}else{
			gender = data.Gender;
		}
		/*$('input[@type=radio][name=generalCondition.gender][value=' + gender + ']').attr("checked",true);*/
		$("select[name='gender']").children("option='" + gender+ "'").attr("selected",true); 
		$("input[name='phoneNumber']").val(data.PhoneNumber);
		toggerAddress();
        var iddStreet;
        if(data.PatownShip!=null){
            $("#patown_address").val(data.PatownShip);
            iddStreet=$("#patown_address").attr("idd").replace('townId', '');
        }
        $('#pahouseNumber').val(data.PahouseNumber);
        orgUtil.getStreetOpting(iddStreet, data.Pastreet, '', data.PaGroup);
	}
	function toggerAddress(){
            //if('1' == value){
                changeAddress("1");
              /*  toggleOther('paGroup','pavillage_address','');
                toggleOther('patownShip','patown_address','');
                toggleOther('pastreet','pastreet_address','');*/
            //}else{
                /*changeAddress("2");
                toggleOther('paGroup','pavillage_address','2');
                toggleOther('patownShip','patown_address','2');
                toggleOther('pastreet','pastreet_address','2');*/
            
        //}
        displayPaAddress();
    }
    function changeAddress(type){
        if(type=="1"){
            $("#pavillage_address").removeAttr("disabled");
            $("#pastreet_address").removeAttr("disabled");
            $('#patown_address').removeAttr("disabled");
            $("#tempPaValue").show();
            $('#spanPaNumber').text("门牌号");
            $('#pahouseNumber').attr({"style":"width:180px"});
        }else{
        	$("#pavillage_address").removeAttr("disabled");
            $("#pastreet_address").removeAttr("disabled");
            $('#patown_address').removeAttr("disabled");
            $('#spanPaNumber').text("详细地址");
            $('#pahouseNumber').attr({'style':'width:90%'});
        }
    }
    function displayPaAddress() {
        var town = $("#patown_address option:selected").text();
        var street = $("#pastreet_address option:selected").text();
        var village = $("#pavillage_address option:selected").text();
        if(!$.isEmpty($("#pavillage_address option:selected").val())) {
            $("#pahouseNumber").removeAttr("reg");
            $("#pahouseNumber").removeClass("lose");
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
	return {
		toggerAddress:toggerAddress,
		displayPaAddress:displayPaAddress
	};
})();
