var clueEdit = (function() {
	var validate=null;
    $(function() {
    	validate = $("#clueForm").easyValidate();
        init();
        toggerAddress();
        enableChangeConfirm();
        mhmCommon.addIcd10AutoComplete("mhmIcd10CodeId");
        //切换地址小组事件
        $("#pavillage_address").change(displayPaAddress);
    });

    function init(){
        toggleOtherSC('mhmBasicsInfo.occupation','spanOccupationOther','CV020120299');
        toggleOther('mhmDiagnosis.diagnosisResult','spanDiagnosisResult','2');
        toggleOther('mhmDiagnosis.reCheck','spanReCheck','2');        
        if($.isEmpty($('input:radio[name="mhmBasicsInfo.floatPopulation"]:checked').val()))
        {
            $('input[name="mhmBasicsInfo.floatPopulation"]:eq(0)').attr("checked",'checked');
        }
        var addType = $('#addType').val();
		/*如果是查看，则禁用页面*/
		if('view' == addType){
			$("#clueForm").diabaleForm();
			$('.required').removeClass("required");
			$('#popuClues').hide();
		}else{
			var idCard = $('#idcard').val();
	        if($.isEmpty(idCard)){
		        $.Placeholder.init({query:"#idcard",callback:function(element){
            		validate.removeCheckElement('mhmBasicsInfo.idcard');
            		validate.addCheckElement('mhmBasicsInfo.idcard',{"idCard":["true"]});
		        	if(validatePerson($(element).val())){
						queryPerson($(element).val());
					}
				}});
	        }			
		}
    }
    function displayPaAddress() {
        var town = $("select[name='mhmBasicsInfo.patownShip'] option:selected").text();
        var street = $("select[name='mhmBasicsInfo.pastreet'] option:selected").text();
        var village = $("select[name='mhmBasicsInfo.paGroup'] option:selected").text();
        if(!$.isEmpty($("select[name='mhmBasicsInfo.paGroup'] option:selected").val())) {
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
    function clueSubmit(){
		var idCard = $('#idcard').val();
		if(idCard == '输入身份证获取个人信息'){
			 $('#idcard').val('');
		}    	
		if(!validatePerson(idCard)){
			return;
		}
    	var result=validate.validateForm();
    	if(!result){
    		return;
    	}    	
        $("#clueForm").submitFormGetJson({
			url : "/mhm/clue/save",
            wait : true,
			callback : function(data) {
				if (data.indexOf("fail") > -1) {
					layer.alert("上报失败！", {icon:0,title:'提示'});
                }else{
                    layer.alert("上报成功！", {icon:0,title:'提示'});
                    $.loadHtmlByUrl({
                        url:"/mhm/clue/add",
                        insertDiv:"mainCotent_0"
                    })
                    contentChanged = false;
                    return false;
                }
			}
		});    	
    }
	function approval(status) {
		var idCard = $('#idcard').val();
		if(idCard == '输入身份证获取个人信息'){
			 $('#idcard').val('');
		}
        //非上报的时候不用判断
//		if(!validatePerson(idCard)){
//			return;
//		}
    	var result=validate.validateForm();
    	if(!result){
    		return;
    	}
    	var message ="";
    	if(status == 5){
    		message = '温馨提示：点击确定后，审核不通过';
    	}else{
    		message = '温馨提示：点击确定后，审核通过';
    	}
		/*msgUtil.confirm(message,function(){
	    	if(status == 5){
	    		$("#clueStatus").val(status);
	    	}
			$("#clueForm").submitFormGetJson({
				url : "/mhm/clue/approval",
				wait:true,
				callback : function(data) {
					if (data.indexOf("fail") > -1) {
                        var str = "线索登记审核失败！";
                        if(status == 2){
                            str = "线索登记诊断失败！";
                        }else if(status == 3){
                            str = "线索登记复核失败！";
                        }
						layer.alert(str);
	                }else {
                        var str = "线索登记审核成功！";
                        if(status == 2){
                            str = "线索登记诊断成功！";
                        }else if(status == 3){
                            str = "线索登记复核成功！";
                        }
	                	layer.alert(str);
                        clueSearch.returnSearch();
	                   return false;
	                }
				}			
			});
		});*/
		
		layui.use('layer', function(){
			var layer = layui.layer;
			var index = layer.confirm(message, {icon:1, title:'确认提示'}, function(){
				if(status == 5){
		    		$("#clueStatus").val(status);
		    	}
				$("#clueForm").submitFormGetJson({
					url : "/mhm/clue/approval",
					wait:true,
					callback : function(data) {
						if (data.indexOf("fail") > -1) {
	                        var str = "线索登记审核失败！";
	                        if(status == 2){
	                            str = "线索登记诊断失败！";
	                        }else if(status == 3){
	                            str = "线索登记复核失败！";
	                        }
	                        layer.alert(str, {icon:0,title:'提示'});
		                }else {
	                        var str = "线索登记审核成功！";
	                        if(status == 2){
	                            str = "线索登记诊断成功！";
	                        }else if(status == 3){
	                            str = "线索登记复核成功！";
	                        }
	                        layer.alert(str, {icon:0,title:'提示'}, function() {
	                        	layer.closeAll();
	                        	clueSearch.returnSearch();
	                        });
		                   return false;
		                }
					}			
				});
			});
		});
	};    
    function showClues(){
        /*var url = contextPath + "/mhm/clue/showClues";
        var title = "精神疾病线索调查问卷";

        var cluesDialog = {
            url : url,
            height : 570,
            width : 710,
            title : title,
            id :"cluesDialog",
            param : {
                checkIds : $("#expressionId").val()
            }
        };
        $.dialog(cluesDialog);*/
        
        $.post(contextPath+'/mhm/clue/showClues',
        		{ checkIds : $("#expressionId").val()
			     }, 
			function(ret){
        	layui.use(['layer'], function() {
        		  var layer = layui.layer
        		  layer.open({
        			  type: 1,
        			  id:'cluesDialog',
        			  area: ['710px', '570px'],
        			  title:'精神疾病线索调查问卷',
        			  content: ret
        		  });
        		});
        	});
    }

    function saveClues(){
        var ids ="";
        var names = "";
        $('input[name="check"]:checked').each(function(){
            ids += $(this).val() + ',';
            names += $(this).nextAll('input').eq(0).val() + '<br>';
        });
        ids = ids.substring(0, ids.lastIndexOf(','));
        names = names.substring(0, names.lastIndexOf('<br>'));
        $("#expressionId").val(ids);
        $("#cluesDetail").html(names);
        /*mhmCommon.closePopUp('cluesDialog');*/
        mhmCommon.closeLayUiDialog();
    }
    function returnSearch(){
		layer.confirm("确认离开？",function(index){
			layer.close(index);
			disableChangeConfirm();
			search();
			$("#clueDetailDiv").empty();
			$("#top_all").show();
		});
    }
    function search() {
        var pageIndex = $("#pageIndex").val();
        pageIndex = ($.isEmpty(pageIndex)?1:pageIndex);
        var searchObj = {
            url : "/mhm/clue/list",
            insertDiv : "clueResultDiv",
            wait:true,
            param : {
                pageIndex : pageIndex
            },
            callback : function(data) {
            	$("#pageIndex").val(pageIndex);
            }
        };
        $("#clueSearchForm").submitFormLoadHtml(searchObj);
    };   
	function popuApproval(statusId) { 
		/*var dialogObj = {
				url : contextPath + "/mhm/clue/popuApproval",
				param : {statusId:statusId,pageIndex:1},
				title : "操作记录"
			};
		$.dialog(dialogObj);*/	
		
		$.post(contextPath+"/mhm/clue/popuApproval",
				{statusId:statusId,pageIndex:1},
				function(ret){
		    	layui.use(['layer'], function() {
		    		  var layer = layui.layer
		    		  layer.open({
		    			  type: 1,
		    			  id:'mhmOperateRecordDialog',
		    			  area: ['800px', '400px'],
		    			  title:"操作记录",
		    			  content: ret
		    		  });
		    		});
		    	});
	};    
    /*隐藏、显示地址*/
    function toggerAddress(){
        var value=$('input[name="mhmBasicsInfo.floatPopulation"]:checked').val();
        if('1' == value){
            changeAddress("1");
            $('#br').show();
        }else{
            changeAddress("2");
            $('#br').hide();
        }
        toggleOther('mhmBasicsInfo.floatPopulation','pavillage_address','1');
        toggleOther('mhmBasicsInfo.floatPopulation','patown_address','1');
        displayPaAddress();
    }

    function changeAddress(type){
        if(type=="1"){
        	$("#pastreet_address").show();
        	$("#pastreet_address").removeAttr("disabled");
            $("#pavillage_address").removeAttr("disabled");
            $('#patown_address').removeAttr("disabled");
            $("#tempPaValue").show();
            $('#spanPaNumber').text("门牌号");
            $('#pahouseNumber').attr({"style":"width:180px"});
        }else{
        	$("#pastreet_address").hide();
        	$("#pastreet_address").attr("disabled", "disabled");
            $("#pavillage_address").attr("disabled", "disabled");
            $("#patown_address").attr("disabled", "disabled");
            $("#tempPaValue").hide();
            $('#spanPaNumber').text("详细地址");
            $('#pahouseNumber').attr({'style':'width:90%'});
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

	function queryPerson(idCard) {
		if (validate.validate("mhmBasicsInfo.idcard")){
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
	};
	/*
	 * 根据健康档案设置患者基本信息
	 * */
	function setPersonData(data){
		if(!$.isEmpty(data.Name)){
			$('#clueName').val(data.Name);
		}
        if(!$.isEmpty(data.Logoff)){
            $('#logoffId').val(data.Logoff);
        }
		var gender;
		if($.isEmpty(data.Gender)){
			gender = IC.getGender(data.Idcard);
		}else{
			gender = data.Gender;
		}
		if($.isEmpty(data.Birthday)){
			var birthday = IC.getBirthday(data.Idcard);
			$('#birthdate').val(birthday);
		}else{
			$('#birthdate').val(data.Birthday);
		}
		if(!$.isEmpty(data.PhoneNumber)){
			$('#familyPhone').val(data.PhoneNumber);
		}		
		$('input[type=radio][name="mhmBasicsInfo.gender"][value=' + gender + ']').attr("checked",true);
		
		if(!$.isEmpty(data.UnitName)){
			$('#unitNameId').val(data.UnitName);
		}
		if(!$.isEmpty(data.Occupation)){
			$('#Occupation').val(data.Occupation);
		}
		toggleOtherSC('mhmBasicsInfo.occupation','spanOccupationOther','CV020120299');
        if(!$.isEmpty(data.FloatPopulation) && data.FloatPopulation=="1"){
            $('input[name="mhmBasicsInfo.floatPopulation"][value="1"]').attr("checked",true);
        }else{
            $('input[name="mhmBasicsInfo.floatPopulation"][value="1"]').attr("checked",false);
        }
        toggerAddress();
       /* if(!$.isEmpty(data.PatownShip)){//现住址
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
        var iddStreet;
        if(data.PatownShip!=null){
            $("#patown_address").val(data.PatownShip);
            iddStreet=$("#patown_address").attr("idd").replace('townId', '');
        }
        $('#pahouseNumber').val(data.PahouseNumber);
        orgUtil.getStreetOpting(iddStreet, data.Pastreet, '', data.PaGroup);
        
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
    function setAge(idNo){
    	if (!$.isEmpty(idNo)){
	        var idCardBirthDay = IC.getBirthday(idNo);
	        var age = getAge(idCardBirthDay);
	        $("#age").val(age);
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
			layer.alert('date parse error', {icon:0,title:'提示'});
		}
	}	
	
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
	return {
        returnSearch:returnSearch,
        showClues:showClues,
        displayPaAddress:displayPaAddress,
        toggerAddress:toggerAddress,
        saveClues:saveClues,
        search:search,
        clueSubmit:clueSubmit,
        approval:approval,
        popuApproval:popuApproval
	};
})();