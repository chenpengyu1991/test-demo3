var schregister = (function() {
	var validate=null;
	$(function() {
		debugger;
        initAdress();
        var flag = $('#flag').val();
        if ('Local' == flag){
			idmCommon.displayPaAddress();
		}
		enableChangeConfirm();
		var type = $("#type").val();
		/*如果是查看，则禁用页面*/
		if('view' == type){
			$("#registerForm").diabaleForm();
			$('#ihaDtId').removeAttr("onfocus");
			$('#ddiaDtId').removeAttr("onfocus");
			$('#coptDtId').removeAttr("onfocus");
			$('#stoolDtId').removeAttr("onfocus");
			$('.required').removeClass("required");
		}else{
			$.Placeholder.init({query:"#idCard",callback:function(element){
				queryPerson($(element).val());
			}});			
		}
	});

    $("#sub").click(function(e) {
       e.preventDefault();
    	var num = $("input[name='labExamine.ddia']:checked").val();
        if(num==1){
            // approval(12);
			var aaa= $("#aaa").val();
            approval(aaa);
		}else{
            approval(num);
		}

    });
	function search(){
		disableChangeConfirm();
        var pageIndex = $("#pageIndex").val();
		$("#registerdetailDiv").empty();
		pageIndex = ($.isEmpty(pageIndex)?1:pageIndex);
		registerSearch.search(pageIndex);
		$("#register_top_all").show();		
	}
	function returnSearch(){
        // if(contentChanged){
			layui.use('layer', function() {
	    			var layer = layui.layer;
	    			var index = layer.confirm('确认离开?', {icon:1, title:'确认提示'}, function(){
	    				layer.close(index);
	    				search();
					});
	    			
	    		});
	
        	/*msgUtil.backConfirm(function(){
				search();
			}); */       	
        // }else{
        // 	search();
        // }
	}
	function registerSubmit(){
		var idCard = $('#idCard').val();
		if(idCard == '输入身份证获取个人信息'){
			 $('#idCard').val('');
		}
        if(!$.isEmpty($("#village_address option:selected").val())) {
            $("#text_pahouseNumber").removeAttr("reg");
            $("#text_pahouseNumber").removeClass("lose");
        }
        validate = $("#registerForm").easyValidate();
        var result=validate.validateForm();
    	if(!result){
    		return;
    	}
    	var flag = $('#flag').val();
    	if(flag == 'Local'){
    		$('#floatPopultationId').val(1);
    	}else{
    		$('#floatPopultationId').val(2);
    	}
    	
		$("#registerForm").submitFormGetJson({
			url : "/idm/schistosome/register/save",
			callback : function(data) {
				layui.use('layer', function(){
        			var layer = layui.layer;
        			if (data.indexOf("fail") > -1) {
        				layer.alert("登记失败！", {icon:0,title:'提示'});
        			}else {
        				var index = layer.alert("登记成功！", {icon:0,title:'提示'}, function() {
        					layer.close(index);
        					search();
        				});
        				return false;
        			}
        		});
			},
            wait:true
		});    	
	}	
	function approval(status) {
		var idCard = $('#idCard').val();
		if(idCard == '输入身份证获取个人信息'){
			 $('#idCard').val('');
		}
        if(!$.isEmpty($("#village_address option:selected").val())) {
            $("#text_pahouseNumber").removeAttr("reg");
            $("#text_pahouseNumber").removeClass("lose");
        }
        validate = $("#registerForm").easyValidate();
        var result=validate.validateForm();
    	if(!result){
    		return;
    	}
    	var message ="";
    	if(status == 2){
    		message = '温馨提示：点击确定后，监测登记排除';
    	}else{
    		message = '温馨提示：点击确定后，监测登记通过';
    	}
    	
    	layui.use('layer', function(){
			var layer = layui.layer;
			var index = layer.confirm(message, {icon:1, title:'确认提示'}, function() {
				$("#specialStatusId").val(status);
				$("#registerForm").submitFormGetJson({
					url : "/idm/schistosome/register/approval",
					callback : function(data) {
							if (data.indexOf("fail") > -1) {
								layer.close(index);
								layer.alert("监测登记审核失败！", {icon:0,title:'提示'});
							} else {
								layer.alert("监测登记审核成功！", {icon:0,title:'提示'}, function() {
								layer.closeAll();
								search();
								});
								return false;
							}
					},
					wait:true
				});
				
			});
		});
    	
	};
	function viewLog(id) { 
		/*var dialogObj = {
				url : contextPath + "/idm/schistosome/approval",
				param : {idmId:id,indexPage:1},
				title : "操作记录"
			};
		$.dialog(dialogObj);*/
		
		$.post(contextPath + "/idm/schistosome/approval",{idmId:id,indexPage:1}, function(ret){
			layui.use(['layer'], function() {
        		  var layer = layui.layer
        		  layer.open({
        			  type: 1,
        			  id:'schistosomeViewLogDialog',
        			  area: ['950px', '500px'],
        			  title:"操作记录",
        			  content: ret
        		  });
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
        validate = $("#registerForm").easyValidate();
        if (validate.validate("generalCondition.idcard")){
            $.getJsonByUrl({
                url : "/idm/report/queryPerson",
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
                wait:true,
                param:{idCard:idCard}
            });
        }
	};
	function setPersonData(data){
		/*从健康档案获取人员信息时，判断注销状态。modify yjf 20131010*/
		$('#logoff').val(data.Logoff);
		/*从健康档案获取人员信息时，判断注销状态。modify yjf 20131010*/		
		var flag = $('#flag').val();
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
		$('input[name="generalCondition.gender"][value="' + gender + '"]').attr("checked",true);
		if('Local' == flag){
            if(data.PatownShip!=null){
                var iddStreet;
                $("#patown_address").val(data.PatownShip);
                iddStreet=$("#patown_address").attr("idd").replace('townId', '');
                orgUtil.getStreetOpting(iddStreet, data.Pastreet, '', data.PaGroup);
                setTimeout(function () {
                    idmCommon.displayPaAddress();
                }, 500);
            }
			$('#text_pahouseNumber').val(data.PahouseNumber);
		}else{
			$('#hrAddress').val(data.HrAddress);
		}


	};

    function initAdress() {
        $("select[name='generalCondition.paGroup']").change(idmCommon.displayPaAddress);
        //地址三级不是必输项
        $("select[name='generalCondition.paGroup']").removeAttr("reg");
    }

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
	return {
		returnSearch:returnSearch,
		registerSubmit:registerSubmit,
		approval:approval,
		viewLog:viewLog
	};
})();