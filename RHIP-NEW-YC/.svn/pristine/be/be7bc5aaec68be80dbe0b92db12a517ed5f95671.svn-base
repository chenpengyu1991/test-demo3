var reportEdit = (function() {

	var validate=null;
    //控制保存按钮只点击一次，1可以点击，0不能点击
    var saveButtonFlag=1;
	$(function() {
		
		//IE8不支持indexOf
		extendIndexOf();
        toggleOther('report.deleteContent','deleteContentOtherId','99');
        $("#check-submit-btn").on("click", function () {
            StartRead();
        });

        // 保存按钮
        $("#report-input-save-btn").on("click", reportSubmitExternal);
        // 保存按钮
        $("#report-input-error-btn").on("click", diagnosisErrorExternal);
        $("#reportHelp").on("click", help);
        $("#fanhui").on("click", returnSearch);
        $("#tongguo1").on("click", function () {
        	approval(1);
        });
        $("#zuofei").on("click", function () {
        	approval(3);
        });
        $("#jilu").on("click", function () {
        	approvalDialog($("#reportIdmId").val());
        });
        $("#tongguo4").on("click", function () {
        	approval(4);
        });
        $("#tijiao").on("click", reportSubmit);

        $("#detailDiv").addClass("toolbarfixed");

        validate = $("#reportForm").easyValidate();

        if($.isEmpty($('input:radio[name="report.infectedpersonBelong"]:checked').val()))
        {
        	$('input[name="report.infectedpersonBelong"]:eq(0)').attr("checked",'checked');
        }
        if($('input:radio[name="report.otherIdcardType"]:checked').val()=="01") {
            $("#otherIdcardTypeDiv2").attr("class","hide");
        }else{
            $("#otherIdcardTypeDiv1").attr("class","hide");
        }
        toggerIdcardType();
        toggerHospitalDt();

        initAdress();
        displayPaAddress();
        displayHrAddress();
      //如果身份证号码不为空，再修改身份证后不再从健康档案从新获取患者信息，但是需要验证）
        var idCard = $('#idCard').val();
        if($.isEmpty(idCard)){
	        $.Placeholder.init({query:"#idCard",callback:function(element){
        	 	//reportCheck();
				queryPerson($(element).val());
			}});
        }else{
        	$('#idCard').on("change",function(){
        		//reportCheck();
        	});
        }
		/*职业-其他*/
		toggleOccupation('report.occupation','spanOccupationOther','CV020120299');
		
        toggerAddress();
        enableChangeConfirm();
        $('#birthday').on("blur onDatePickerChanged",function(){
            occupationCheckAge();
            setBirthdayAge();
        });
        setBirthdayAge();
        $('#age').change(function(){
            occupationCheckAge();
        });

        //if($("#reportFlag").val()=="reportOut"){
        //    $("select").not("select[multiple]").multiselect({
        //        multiple: false,
        //        header : false,
        //        noneSelectedText: "",
        //        selectedList: 1
        //    });
        //
        //    $("select").not("select[multiple]").data("validate",true);
        //}
        caseCategoryCheck($('#infectiousCodeHidden').val());//病例分类限制
        queryInfection();
        initShowControl();
        showTip($("#infectiousCodeHidden").val());
        //外部报卡，可以取消
        if($("#reportFlag").val() == 'reportOut' && $("#orgFlag").val() == '1'){
            //alert("此病种为法定传染病，点击“确定”填写报告卡。 \n如诊断错误，可按“ALT+F4”关闭该页面并修改诊断，否则按漏报处理!");
        	 alert("此病种为法定传染病，点击“确定”填写报告卡。提醒检验科和临床科室采样。");
        }
        //审核状态时，显示“作废原因”
        if(!$.isEmpty($("#hiddenReportId").val())){
            $("#deleteContentId").show();
            toggleOther('report.deleteContent','deleteContentOtherId','99');
        }else{
            $("#deleteContentId").hide();
        }
    });

    function initAdress() {
        $("select[name='report.paGroup']").change(displayPaAddress);
        $("select[name='report.hrGroup']").change(displayHrAddress);
        //地址三级不是必输项
        $("select[name='report.paGroup']").removeAttr("reg");
        $("select[name='report.hrGroup']").removeAttr("reg");
    }

    function StartRead()//开始读卡
    {
        if (GT2ICROCX.GetState() == 0){
            GT2ICROCX.ReadCard()
        }

        //GT2ICROCX.ReadCard() //循环读卡
        $("#idCard").val(GT2ICROCX.CardNo);
    }

    /**
     * 报卡时验证：选择身份证、疾病种类时验证
     * 1：乙肝只能上报一次
     * 2：同一种疾病一周内只能上报一次
     */
    function reportCheck(){
    	var result = true;
    	var idCard = $('#idCard').val();
    	var infectiousCode = $('#infectiousCode').val();
    	validate.removeCheckElement('report.idcard');
        validate.addCheckElement('report.idcard',{"idCard":["true"]});
    	if(validate.validate("report.idcard")){
			$.getJsonByUrl({
	            url : "/idm/report/reportCheck",
	            wait : true,
	            async : false,
	            callback : function(data) {
					if(data.returnFlag.indexOf("success") > -1) {
	            		validate.removeError('report.idcard');
	        			validate.removeCheckElement('report.idcard');
	            	}else if (data.returnFlag.indexOf("fail") > -1) {
	            		result = false;
	               		validate.addError('report.idcard',data.error);
			        	validate.addCheckElement('report.idcard',{"compare":["idcardFlag","le",data.error]});
	            	}
	            },
	            param:{idCard:idCard,diagnosisCode:infectiousCode}
			}); 
    	}
		  
		return result;
    }
    
    /**
     * 选择疾病时，进行一系列操作
     */
    function infectiousChange(infectiousCode){
    	getInfectionsName();
    	showControl();
    	initShowControl();
    	caseCategoryCheck(infectiousCode);
    	showTip(infectiousCode);
    	//reportCheck();//乙肝只能上报一次；乙肝只能上报一次
    }
	function help() { 
		/*var dialogObj = {
				url : contextPath + "/idm/report/help",
                height : 600,
                width : 700,				
				param : {},
				title : "《中华人民共和国传染病报告卡》填卡说明"
			};
		$.dialog(dialogObj);*/	
		$.post(contextPath+'/idm/report/help',
        		 
			function(ret){
        	layui.use(['layer'], function() {
        		  var layer = layui.layer
        		  layer.open({
        			  type: 1,
        			  id:'idmReportFillHelpDialog',
        			  area: ['700px', '600px'],
        			  title:'《中华人民共和国传染病报告卡》填卡说明',
        			  content: ret
        		  });
        		});
        	});
	};
    /*职业-其他*/
    function toggleOccupation(occupationName,otherId,occupationValue){
	   	var reportFlag = $('#reportFlag').val();
    	if(reportFlag == 'reportOut'){
    		//$("#Occupation").multiselect('refresh');
			var raValue = $("select[name=\'" + occupationName + "\']").find("option:selected").val();
			if (raValue == occupationValue)
			{
				$("#" + otherId).show();
			} else
			{
				$("#" + otherId).hide();
			}    		
    	}else{
    		toggleOtherSC('report.occupation','spanOccupationOther','CV020120299');
    	}
    	
    }
//    判断初治还是复治
    function checkFirst() {
        if($("#reportFlag").val()=="reportOut"){
            var message = '温馨提示：初诊请点击【确定】按钮添加报卡。复诊可点击【取消】按钮取消。';
            msgUtil.confirmAll(message,
                function(){
                    makeTrue();
                },
                function(){
                    //后台保存值
                    $.getJsonByUrl({
                        url : "/idm/report/saveReportRetreat",
                        param:{reportRecordId:$("#reportRecordId").val()},
                        callback:function(data){
                            //关闭当前窗口
                          closeFunction();
                        }
                    });

                }
            );
        }
    }

    function makeTrue(){
        var id = $("#idCard").val();
        if(!$.isEmpty(id) && id!="输入身份证获取个人信息"){
            queryPersonForExternal($("#idCard").val());
        }
    }

    function displayPaAddress() {
        var town = $("select[name='report.patownShip'] option:selected").text();
        var street = $("select[name='report.pastreet'] option:selected").text();
        var village = $("select[name='report.paGroup'] option:selected").text();
        if(!$.isEmpty($("select[name='report.paGroup'] option:selected").val())) {
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
        if($.isEmpty($('input:radio[name="report.infectedpersonBelong"]:checked').val())){
            $("#tempPaValue").hide();
        }
    }

    function displayHrAddress() {
        var town = $("select[name='report.hrtownShip'] option:selected").text();
        var street = $("select[name='report.hrstreet'] option:selected").text();
        var village = $("select[name='report.hrGroup'] option:selected").text();
        if(!$.isEmpty($("select[name='report.hrGroup'] option:selected").val())) {
            $("#text_hrhouseNumber").removeAttr("reg");
            $("#text_hrhouseNumber").removeClass("lose");
        }
        var result = '';
        if (town != '请选择')
            result = town;
        if (street != '请选择') {
            result = result + street;
        }
        if (village != '请选择')
            result = result + village;
        $("#tempHrValue").text(result);
        if($.isEmpty($('input:radio[name="report.infectedpersonBelong"]:checked').val())){
            $("#tempHrValue").hide();
        }
    }

	function reportSubmit() {
		customValidate();
		 /**
         * 现住址为不详，门牌号非必填项
         * 需求变更，2017-08-14
         */
		var pastreet = $("select[name='report.pastreet']").find("option[value!='']:selected").text();
		if(pastreet == '不详' ){
			validate.removeCheckElement('report.pahouseNumber');
		}else{
			validate.addCheckElement('report.pahouseNumber',{"required":"true"});
		}
    	var result=validate.validateForm();
    	if(!result){
    		return;
    	}
    	getInfectionsName();
    	var diagnosisDate =  $('#diagnosisDateId').val();
    	var length = diagnosisDate.length;
    	var diagnosisHour = diagnosisDate.substring(length-8,length);
    	$('#diagnosisHour').val(diagnosisHour);
    	
    	var deathDate =  $('#deathDateId').val();
    	var length = deathDate.length;
    	var deathHour = deathDate.substring(length-2,length);
    	$('#deathHour').val(deathHour);
    	

    	var fillDate =  $('#fillDateId').val();
    	var fillDateLength = fillDate.length;
    	var fillHour = fillDate.substring(fillDateLength-8,fillDateLength);
    	$('#fillHour').val(fillHour);
    	
        var hbvSignDt = $("#hbvSignDtID").val();
        if(hbvSignDt.length == 7){
            $('#hbvSignDtID').val(hbvSignDt+"/01");
        }

        $("#reportForm").submitFormGetJson({
			url : "/idm/report/save",
            // wait : true,
			callback : function(data) {
				if (data.indexOf("fail") > -1) {
					layer.alert("上报失败！", {icon:0,title:'提示'});
                }else if(data.indexOf("repeat2032") > -1){
                	layer.alert("该患者乙肝已上报过，不再上报！", {icon:0,title:'提示'});
                }else if(data.indexOf("repeat") > -1){
                	layer.alert("该病一周内已上报过，不再上报！", {icon:0,title:'提示'});
                }else{
                    $("#reportForm").resetForm();
                	layer.alert("上报成功！", {icon:0,title:'提示'});
                    contentChanged = false;
                    var resubmit = $('#resubmit').val();
                    if(resubmit == '1'){
                    	returnSystem();
                    }else{
	                    $.loadHtmlByUrl({
	                        url:"/idm/report/add",
	                        insertDiv:"mainCotent_0"
	                    })
                    }
                    contentChanged = false;
                    return false;
                }
			}
		});
	};

    /**
     * 诊断错误
     */
    function diagnosisErrorExternal(){
        var message = '此病种为法定传染病。\n如果诊断错误，请点击“确定”并关闭窗口，否则点击“取消”继续填写报卡！';
        layui.use('layer', function() {
            var layer = layui.layer;
            var index = layer.confirm(message, {icon:1, title:'确认提示'}, function(index) {
                layer.close(index);
                $.getJsonByUrl({
                    url: "/idm/report/diagnosisError",
                    param: {reportRecordId: $("#reportRecordId").val()},
                    callback: function (data) {
                        if (data.indexOf("fail") > -1) {
                            $("#report-result").val(-1);
                            layer.alert("诊断错误保存失败！", {icon:0,title:'提示'});
                        } else {
                            $("#report-result").val(1);
                        }
                    }
                });
            })
        });
    }

    /**
     * 外部报卡
     */
    function reportSubmitExternal() {
        if(saveButtonFlag==0){
        	layer.alert("已上报，请稍等！", {icon:0,title:'提示'});
            return;
        }
        customValidate();
        /**
         * 现住址为不详，门牌号非必填项
         * 需求变更，2017-08-14
         */
		var pastreet = $("select[name='report.pastreet']").find("option[value!='']:selected").text();
		if(pastreet == '不详'||!$.isEmpty($("#pavillage_address option:selected").val())){
			validate.removeCheckElement('report.pahouseNumber');
		}else{
			validate.addCheckElement('report.pahouseNumber',{"required":"true"});
		}
        var result=validate.validateForm();
        if(!result){
            return;
        }
        //控制保存按钮不能再点击了
        saveButtonFlag = 0;
        getInfectionsName();
        var diagnosisDate =  $('#diagnosisDateId').val();
        var length = diagnosisDate.length;
        var diagnosisHour = diagnosisDate.substring(length-8,length);
        $('#diagnosisHour').val(diagnosisHour);
        
        var deathDate =  $('#deathDateId').val();
    	var length = deathDate.length;
    	var deathHour = deathDate.substring(length-2,length);
    	$('#deathHour').val(deathHour);
        
        var fillDate =  $('#fillDateId').val();
    	var fillDateLength = fillDate.length;
    	var fillHour = fillDate.substring(fillDateLength-8,fillDateLength);
    	$('#fillHour').val(fillHour);

        var hbvSignDt = $("#hbvSignDtID").val();
        if(hbvSignDt.length == 7){
            $('#hbvSignDtID').val(hbvSignDt+"/01");
        }

        $("#reportForm").submitFormGetJson({
            url : "/idm/report/saveReportInitial",
            wait : true,
            param:{reportRecordId:$('#reportRecordId').val()},
            callback : function(data) {
                if (data.indexOf("fail") > -1) {
                    $("#report-result").val(-1);
                    layer.alert("上报失败！", {icon:0,title:'提示'});
                }else if(data.indexOf("repeat2032") > -1){
                    $("#report-result").val(1);
                    layer.alert("该患者乙肝已上报过，不再上报！", {icon:0,title:'提示'});
                }else if(data.indexOf("repeat") > -1){
                    $("#report-result").val(1);
                    layer.alert("该病一周内已上报过，不再上报！", {icon:0,title:'提示'});
                }else{
                    $("#report-result").val(1);
                    if($("#orgFlag").val() == "0"){
                    	layer.alert("上报成功，请关闭页面！", {icon:0,title:'提示'});
                    }else{
                    	layer.alert("上报成功！", {icon:0,title:'提示'});
                    }
//                    msgUtil.alert("上报成功！",function(){
//                        window.opener=null;
//                        window.close();
//                        //放在函数体里面不能实现关闭
////                        closeFuction();
//                    });
                }
            }
        });
    };

    function closeFunction(){
        window.opener=null;
        window.close();
    }

    function approval(status) {
		customValidate();
        /**
         * 作废时增加作废原因必填项验证
         * 需求变更，2014-02-08
         */
        var deleteContent = $('input:radio[name="report.deleteContent"]:checked').val();
        if(status == 3 && $.isEmpty(deleteContent)){
            validate.addCheckElement('report.deleteContent',{"required":"true"});
        }else{
            validate.removeCheckElement('report.deleteContent');
        }
        /**
         * 现住址为不详，门牌号非必填项
         * 需求变更，2017-08-14
         */
		var pastreet = $("select[name='report.pastreet']").find("option[value!='']:selected").text();
		if(pastreet == '不详' ){
			validate.removeCheckElement('report.pahouseNumber');
		}else{
			validate.addCheckElement('report.pahouseNumber',{"required":"true"});
		}
        var result=validate.validateForm();
        if(!result){
    		return;
    	}

    	var message ="";
        var btnStr = null;
        if(status == 4){
    		message = '温馨提示：点击确定后，更新报卡';
            btnStr = "确认";
        }else if(status == 3){
    		message = '温馨提示：点击确定后，报卡作废';
            btnStr = "确认";
        }else{
    		message = '温馨提示：点击确定后，审核通过';
            btnStr = "确认并打印";
        }
		/*msgUtil.confirm(message,function(){
			如果报卡已经审核通过，且角色为SQZX,可以修改报卡，且状态还是“审核通过”
			if(status == 4){
	    		$("#reportStatusId").val(1);
	    	}
	    	if(status == 3){
	    		$("#reportStatusId").val(status);
	    	}else{	
		    	getInfectionsName();
		    	var diagnosisDate =  $('#diagnosisDateId').val();
		    	var length = diagnosisDate.length;
                var diagnosisHour = diagnosisDate.substring(length-8,length);
                $('#diagnosisHour').val(diagnosisHour);
                
                var fillDate =  $('#fillDateId').val();
            	var fillDateLength = fillDate.length;
            	var fillHour = fillDate.substring(fillDateLength-8,fillDateLength);
            	$('#fillHour').val(fillHour);
            	
            	var deathDate =  $('#deathDateId').val();
            	var length = deathDate.length;
            	var deathHour = deathDate.substring(length-2,length);
            	$('#deathHour').val(deathHour);
            	
	    	}
            var hbvSignDt = $("#hbvSignDtID").val();
            if(hbvSignDt.length == 7){
                $('#hbvSignDtID').val(hbvSignDt+"/01");
            }
	    	
			$("#reportForm").submitFormGetJson({
				url : "/idm/report/approval",
				param:{updateFlag:'1'},
				wait:true,
				callback : function(data) {
					if (data.indexOf("fail") > -1) {
						if(status == 4){
							layer.alert("报卡更新失败！");
						}else{
							layer.alert("报卡操作失败！");
						}
	                }else {
	                	if(status == 4){
	                		layer.alert("报卡更新成功！");
	                	} else if(status == 3){
	                		layer.alert("报卡已作废！");
	                	}else{
	                		layer.alert("报卡审核成功！");
	                	}
                        if(status == 1){
                            finish($("#hiddenReportId").val());
                        }
                        if(status == 3 || status == 4){//如果是作废或更新报卡成功后，返回列表
                            search();
                        }
	                   return false;
	                }
				}			
			});
		},btnStr);*/
		
		layui.use('layer', function(){
			var layer = layui.layer;
			layer.confirm(message, {icon:1, title:'确认提示'}, {btn:[btnStr]},function(index) {
				/*如果报卡已经审核通过，且角色为SQZX,可以修改报卡，且状态还是“审核通过”*/
				if(status == 4){
		    		$("#reportStatusId").val(1);
		    	}
		    	if(status == 3){
		    		$("#reportStatusId").val(status);
		    	}else{	
			    	getInfectionsName();
			    	var diagnosisDate =  $('#diagnosisDateId').val();
			    	var length = diagnosisDate.length;
	                var diagnosisHour = diagnosisDate.substring(length-8,length);
	                $('#diagnosisHour').val(diagnosisHour);
	                
	                var fillDate =  $('#fillDateId').val();
	            	var fillDateLength = fillDate.length;
	            	var fillHour = fillDate.substring(fillDateLength-8,fillDateLength);
	            	$('#fillHour').val(fillHour);
	            	
	            	var deathDate =  $('#deathDateId').val();
	            	var length = deathDate.length;
	            	var deathHour = deathDate.substring(length-2,length);
	            	$('#deathHour').val(deathHour);
	            	
		    	}
	            var hbvSignDt = $("#hbvSignDtID").val();
	            if(hbvSignDt.length == 7){
	                $('#hbvSignDtID').val(hbvSignDt+"/01");
	            }
		    	
				$("#reportForm").submitFormGetJson({
					url : "/idm/report/approval",
					param:{updateFlag:'1'},
					wait:true,
					callback : function(data) {
						if (data.indexOf("fail") > -1) {
							if(status == 4){
								layer.alert("报卡更新失败！", {icon:0,title:'提示'});
							}else{
								layer.alert("报卡操作失败！", {icon:0,title:'提示'});
							}
		                }else {
		                	if(status == 4){
		                		layer.alert("报卡更新成功！", {icon:0,title:'提示'});
		                	} else if(status == 3){
		                		layer.alert("报卡已作废！", {icon:0,title:'提示'});
		                	}else{
		                		layer.alert("报卡审核成功！", {icon:0,title:'提示'});
		                	}
	                        if(status == 1){
	                            finish($("#hiddenReportId").val());
	                        }
	                        if(status == 3 || status == 4){//如果是作废或更新报卡成功后，返回列表
	                            search();
	                        }
		                   return false;
		                }
					}			
				});
			
			});
		});

        if(status == 1){
            $("#popup_ok").width("75px");
        }else{
            $("#popup_ok").width("60px");
        }

    };

    //报卡审核后的操作
    function finish(id){
        //打印
        var url = contextPath + "/idm/report/print/" + id;
        util.printPage(url);
        search();
    }

	/**
	 * 提交前验证
	 * 1、年龄
	 * 2、病例分类2
	 */
	function customValidate(){
		var idCard = $('#idCard').val();
		if(idCard == '输入身份证获取个人信息'){
			 $('#idCard').val('');
		}
		checkAge();
		checkInfection();
        occupationCheckAge();
        hfmdCheckResultCheck();
        h1n1Check();
        lmhCheck();
//        hivCheck();
	}
	
	/*乙型肝炎和血吸虫的传染病报卡，病例分类2必填*/
	function checkInfection(){
		var infectiousCode = $('#infectiousCode').val();
		if(infectiousCode =='225' || infectiousCode =='2032'  || infectiousCode =='2033' ){
			validate.addCheckElement('report.caseCategoryFlag',{"required":"true"});
		}else{
			validate.removeCheckElement('report.caseCategoryFlag');
		}
		
	}
	
	function queryPerson(idCard) {
        if (validate.validate("report.idcard")){
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

    function queryPersonForExternal(idCard) {
        if (validate.validate("report.idcard")){
            $.getJsonByUrl({
                url : "/idm/report/queryPerson",
                wait : true,
                callback : function(data) {
                    if(!$.isEmpty(data)){
                        if(data.flag){
                            setPersonDataForExternal(data);
                            setAgeForExtenal(data.Idcard);
                        }else{
                            setIcDataForExternal(data.Idcard);
                            setAgeForExtenal(data.Idcard);
                        }
                    }
                },
                param:{idCard:idCard}
            });
        }
    };

    // 组合39种疾病的下拉内容
    function queryInfection() {
        var infectiousCode = $('#infectiousCodeHidden').val();

        $("#infectiousCode").append('<option value="">' + "请选择" + '</option>');

        var option = ({
            url : "/idm/set/queryInfection",
            // wait:true,
            callback : function(data) {
                /*将KEY放入数组，数组排序后，通过遍历数组，排序输出*/
                var keyArr = [];
                $.each(data, function(key, val){
                    keyArr[keyArr.length] = key;
                });
                keyArr.sort();
                $.each(keyArr, function(i, key){
                    $("#infectiousCode").append('<option value="'+ key +'">' + data[key] + '</option>');
                });
                if(!$.isEmpty(infectiousCode)){
                    $('#infectiousCode').val(infectiousCode);
                }
                //$("#infectiousCode").multiselect('refresh');
            }
        });
        $.getJsonByUrl(option);

    };
	function getInfectionsName(){
		var name = $('#infectiousCode option:selected').text();
		$('#infectiousName').val(name);
		var code = $('#infectiousCode').val();
        $('#infectiousCodeHidden').val(code);

        /*如果选择了非乙型肝炎、血吸虫病，则重置病例分类2*/
		if (code != '2032' && code != '225'){
			$("input:radio[name=\'report.caseCategoryFlag\']").attr('checked',false);
		}
	};
	function returnSearch(){
	    myConfirm("确认离开？", search, "", "", 1);
	};
	
	function search(){
		disableChangeConfirm();
        var pageIndex = $("#pageIndex").val();
		$("#detailDiv").empty();
		pageIndex = ($.isEmpty(pageIndex)?1:pageIndex);
		if($("#resubmit").val()==1){
            userOperationLogSearch.returnSearch();
        }else{
            reportSearch.search(pageIndex);
        }
		$("#top_all").show();
        $("#detailDiv").removeClass("toolbarfixed");
    }
	function approvalDialog(id) { 
		/*var dialogObj = {
				url : contextPath + "/idm/report/popApproval",
				param : {idmId:id},
				title : "操作记录"
			};
		$.dialog(dialogObj);*/	
		$.post(contextPath+'/idm/report/popApproval',
        		{ idmId:id
			     }, 
			function(ret){
        	layui.use(['layer'], function() {
        		  var layer = layui.layer
        		  layer.open({
        			  type: 1,
        			  id:'idmReportOperateRecordDialog2',
        			  area: ['650px', '310px'],
        			  title:'操作记录',
        			  content: ret
        		  });
        		});
        	});
	};
	/*
	 * 根据健康档案设置患者基本信息
	 * */
	function setPersonData(data){
		var reportFlag = $('#reportFlag').val();
		if(reportFlag == 'reportOut'){
			setPersonDataForExternal(data);
		}else{
			setPersonDataInternal(data);
		}
	};
	
	/*
	 * 内部报卡时，查询健康档案后设置患者信息
	 * */
	function setPersonDataInternal(data){
        /*从健康档案获取人员信息时，判断注销状态。modify yjf 20131010*/
		$('#logoff').val(data.Logoff);

		if(!$.isEmpty(data.Name)){
			$('#name').val(data.Name);
		}
		
		if(!$.isEmpty(data.Birthday)){
			var birthday = IC.getBirthday(data.Idcard);
			$('#birthday').val(birthday);
		}else{
			$('#birthday').val(data.Birthday);
		}
		var gender;
		if($.isEmpty(data.Gender)){
			gender = IC.getGender(data.Idcard);
		}else{
			gender = data.Gender;
		}
		$('input[name="report.gender"][value=' + gender + ']').attr("checked",true);
		if(!$.isEmpty(data.UnitName)){
			$('#unitNameId').val(data.UnitName);
		}
		if(!$.isEmpty(data.PhoneNumber)){
			$('#phoneNumberId').val(data.PhoneNumber);
		}
		if(!$.isEmpty(data.Occupation)){
			$('#Occupation').val(data.Occupation);
		}
		toggleOtherSC('report.occupation','spanOccupationOther','CV020120299');
        if(!$.isEmpty(data.FloatPopulation) && data.FloatPopulation=="1"){
            $('input[name="report.infectedpersonBelong"][value="1"]').attr("checked",true);
        }else{
            $('input[name="report.infectedpersonBelong"][value="1"]').attr("checked",false);
        }
        toggerAddress();
        var iddStreet;
        if(data.PatownShip!=null){
            $("#patown_address").val(data.PatownShip);
            iddStreet=$("#patown_address").attr("idd").replace('townId', '');
        }
        orgUtil.getStreetOpting(iddStreet, data.Pastreet, '', data.PaGroup);
        if(!$.isEmpty(data.PahouseNumber)){
        	$('#pahouseNumber').val(data.PahouseNumber);
        }

        if(!$.isEmpty(data.Nation)){
        	$('#nationId').val(data.Nation);
        }
        if(!$.isEmpty(data.Education)){
        	$('#educationId').val(data.Education);
        }   
	}

	/*
	 * 外部报卡时，查询健康档案后设置患者信息
	 * */
    function setPersonDataForExternal(data){
        /*从健康档案获取人员信息时，判断注销状态。modify yjf 20131010*/
		$('#logoff').val(data.Logoff);

        if($.isEmpty($('#name').val()) && !$.isEmpty(data.Name)){
            $('#name').val(data.Name);
        }

        if($.isEmpty($('#birthday').val())){
            if($.isEmpty(data.Birthday)){
                var birthday = IC.getBirthday(data.Idcard);
                $('#birthday').val(birthday);
            }else{
                $('#birthday').val(data.Birthday);
            }
        }
        if($.isEmpty($('input:radio[name="report.gender"]:checked').val())){
            var gender;
            if($.isEmpty(data.Gender)){
                gender = IC.getGender(data.Idcard);
            }else{
                gender = data.Gender;
            }
            $('input[name="report.gender"][value=' + gender + ']').attr("checked",true);
        }
        if($.isEmpty($('#unitNameId').val())  && !$.isEmpty(data.UnitName)){
            $('#unitNameId').val(data.UnitName);
        }
        if($.isEmpty($('#phoneNumberId').val()) && !$.isEmpty(data.PhoneNumber)){
            $('#phoneNumberId').val(data.PhoneNumber);
        }
        if($.isEmpty($('#Occupation').val())  && !$.isEmpty(data.Occupation)){
            $('#Occupation').val(data.Occupation);
            //$("#Occupation").multiselect('refresh');
            toggleOtherSC('report.occupation','spanOccupationOther','CV020120299');
        }
        if($.isEmpty($('input:radio[name="report.infectedpersonBelong"]:checked').val())   && !$.isEmpty(data.FloatPopulation)){
            if(data.FloatPopulation=="1"){
                $('input[name="report.infectedpersonBelong"][value="1"]').attr("checked",true);
            }else{
                $('input[name="report.infectedpersonBelong"][value="1"]').attr("checked",false);
            }
            toggerAddress();
        }
        var patownShip = $('#patownShip').val();
        if(($('#patown_address').val() == patownShip) && !$.isEmpty(data.PatownShip)){
            $('#patown_address').val(data.PatownShip);
            //$("#patown_address").multiselect('refresh');
            var idd = $("#patown_address").attr("idd").replace('townId', '');
            orgUtil.getVillageOpting(idd,"pastreet",data.Pastreet,"",true);
            //orgUtil.getVillageOpting(idd,"",data.Pastreet);
            if($.isEmpty(data.Pastreet)){
                $('#pavillage_address').val(data.Pastreet);
                //$("#pavillage_address").multiselect('refresh');
            }
        }
        if($.isEmpty($('#pahouseNumber').val())  && !$.isEmpty(data.PahouseNumber)){
            $('#pahouseNumber').val(data.PahouseNumber);
        }
        
        if($.isEmpty($('#hrtown_address').val()) && !$.isEmpty(data.HrtownShip)){//户籍地址
            $('#hrtown_address').val(data.HrtownShip);
            //$("#hrtown_address").multiselect('refresh');
            var idd = $("#hrtown_address").attr("idd").replace('townId', '');
            orgUtil.getVillageOpting(idd,"pastreet",data.Pastreet,"",true);
            //orgUtil.getVillageOpting(idd,"",data.Pastreet);
    		if(!$.isEmpty(data.Hrstreet)){
    			$('#hrvillage_address').val(data.Pastreet);
    			//$("#hrvillage_address").multiselect('refresh');
    		}             
        }
        if($.isEmpty($('#hrhouseNumber').val()) && !$.isEmpty(data.HrhouseNumber)){
        	$('#hrhouseNumber').val(data.HrhouseNumber);
        }
        if($.isEmpty($('#nationId').val()) && !$.isEmpty(data.Nation)){
        	$('#nationId').val(data.Nation);
        	//$("#nationId").multiselect('refresh');
        }
        if($.isEmpty($('#educationId').val()) && !$.isEmpty(data.Education)){
        	$('#educationId').val(data.Education);
        	//$("#educationId").multiselect('refresh');
        } 
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

    function setIcDataForExternal(idCard){
        if($.isEmpty($('input:radio[name="report.gender"]:checked').val())){
        var gender = IC.getGender(idCard);
        if(!$.isEmpty(gender)){
            $('#gender').val(gender);
        }
        }
        if($.isEmpty($('#birthday').val())){
            var birthday = IC.getBirthday(idCard);
            if(!$.isEmpty(birthday)){
                $('#birthday').val(birthday);
            }
        }
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
	 * 1、输入年龄时，必须选择年龄单位
	 * 2、出生日期、年龄二选一
	 * 3、如果年龄小于14岁，必须输入家长姓名
	 */
	function checkAge(){
		var birthday = $('#birthday').val();
		var age = $('#age').val();
		/*设置必填项，出生日期、年龄必选一项*/
		if($.isEmpty(age)){
			validate.removeCheckElement('report.ageUnit');
			/*如果年龄为空，则出生日期必填*/
			if($.isEmpty(birthday)){
				validate.addCheckElement('report.birthday',{"required":"true"});
			}else{
				validate.removeCheckElement('report.birthday');
			}
		}else{
			/*如果年龄不为空，则年龄单位必填*/
			validate.addCheckElement('report.ageUnit',{"required":"true"});
			validate.removeCheckElement('report.birthday');
		}
		/* 计算年龄，判断家长姓名是否必填
		 * 出生日期、年龄，出生日期优先级高
		*/
		var birthday = $('#birthday').val();
		/*出生日期或年龄是否为空标志*/
		var ageEmpty = true;
		if(!$.isEmpty(birthday)){
			/*根据出生日期计算年龄*/
			age = getAge(birthday);
			ageEmpty = false;
		}else if(!$.isEmpty(age)){
			ageEmpty = false;
			/*根据年龄单位计算年龄*/
			var ageUnit = $('input:radio[name="report.ageUnit"]:checked').val();
			if(!$.isEmpty(ageUnit)){
				
				age = getAgeByUnit(ageUnit);
			}
		}
		if (!ageEmpty && age < 14){ 	
			validate.addCheckElement('report.parentsName',{"required":"true"});
		}else{
			validate.removeCheckElement('report.parentsName');
		}
	}
	/*根据年龄单位计算实际年龄*/
	function getAgeByUnit(ageUnit){
		var actuaAge = 0;
		var age = $('#age').val();
		if(ageUnit == 1){
			actuaAge = age;
		}else if (ageUnit == 2){
			actuaAge = div(age,12);
		}else{
			actuaAge = div(age,365);
		}
		return actuaAge;
	}
	/*用Math.floor对两数相除的结果取整*/
	function div(number1,number2){
		var num1 = Math.round(number1);
	    var num2 = Math.round(number2);
	    var result = num1/num2;
	    if(result >=0){
	    	result = Math.floor(result);
	    }else{
	    	result = Math.ceil(result);
	    }
	       return result;
	}
	/*隐藏、显示地址*/
	function toggerAddress(){
        var reportFlag = $("#reportFlag").val();
	if(typeof $('input[name="generalCondition.patientAttribute"]:checked').val()!='undefined'){
        if('reportOut' == reportFlag){
            $("input[name='report.infectedpersonBelong']").on("click", function()
            {
                if ("1" == $(this).val()){
                    changeAddress("1");
                }else{
                    changeAddress("2");
                }
            });
            toggerAddressHr();
        }else{
            $("input[name='report.infectedpersonBelong']").on("click", function()
            {
                if ("1" == $(this).val()){
                    changeAddressIn("1");
                }else{
                    changeAddressIn("2");
                }
            });
	            if($.isEmpty($('input:radio[name="report.infectedpersonBelong"]:checked').val()))
	            {
	            	changeAddressIn();
	            }
            toggleOther('report.infectedpersonBelong','pavillage_address','1');
            toggleOther('report.infectedpersonBelong','patown_address','1');
            toggleOther('report.infectedpersonBelong','pastreet_address','1');
            displayPaAddress();
            toggerAddressHrIn();
 		}
        }
    }
	function changeAddress(type){
		if(type=="1"){
            $("#pa-address-select").attr("class","");
            $("#tempPaValue").show();
            $('#spanPaNumber').text("门牌号");
			$('#pahouseNumber').attr({"style":"width:180px"});
		}else{
            $("#pa-address-select").attr("class","hide");
            $("#pa-address-select").find("select").attr("disabled", "disabled").hide();
            $("#tempPaValue").hide();
            $('#spanPaNumber').text("详细地址");
			$('#pahouseNumber').attr({'style':'width:90%'});
		}
	}

    function changeAddressIn(type){
        if(type=="1"){
            $("#pavillage_address").removeAttr("disabled");
            $("#pastreet_address").removeAttr("disabled");
            $('#patown_address').removeAttr("disabled");
            $('#br').show();
            $("#tempPaValue").show();
            $('#spanPaNumber').text("门牌号");
            $('#pahouseNumber').attr({"style":"width:180px"});
        }else{
            $("#pavillage_address").attr("disabled", "disabled");
            $("#pastreet_address").attr("disabled", "disabled");
            $("#patown_address").attr("disabled", "disabled");
            $("#tempPaValue").hide();
            $('#br').hide();
            $('#spanPaNumber').text("详细地址");
            $('#pahouseNumber').attr({'style':'width:90%'});
        }
    }

    function toggerAddressHr(){
        var value=$('input[name="report.infectedpersonBelong"]:checked').val();
        if('1' == value){
            $("#hr-address-select").attr("class","");
            $("#tempHrValue").show();
            $('#spanHrNumber').text("门牌号");
            $('#hrhouseNumber').attr({"style":"width:180px"});
        }else{
            $("#hr-address-select").attr("class","hide");
            $("#hr-address-select").find("select").attr("disabled", "disabled").hide();
            $("#tempHrValue").hide();
            $('#spanHrNumber').text("详细地址");
            $('#hrhouseNumber').attr({"style":"width:90%"});
        }
    }

    function toggerAddressHrIn(){
        var value=$('input[name="report.infectedpersonBelong"]:checked').val();
        if('1' == value){
            $("#hrvillage_address").show();
            $("#hrtown_address").show();
            $('#hrhouseNumber').attr({"style":"width:180px"});
        }else{
            $("#hrvillage_address").hide();
            $("#hrtown_address").hide();
            $('#hrhouseNumber').attr({"style":"width:90%"});
        }
    }

    function setAge(idNo){
    	if (!$.isEmpty(idNo)){
	        var idCardBirthDay = IC.getBirthday(idNo);
	        var age1 = getAge(idCardBirthDay);
	        $("#age").val(age1);
	        $("input[name=\'report.ageUnit\']:eq(0)").attr("checked",'checked');
    	}
    }
    /*
     * 根据出生日期设置年龄，单位默认为“岁”
     * */
	function setBirthdayAge(){
		var birthday = $('#birthday').val();
		if(!$.isEmpty(birthday)){
			var age = getAge(birthday);
			$('#age').val(age);
			 $("input[name=\'report.ageUnit\']:eq(0)").attr("checked",'checked');
		}
	}
    function setAgeForExtenal(idNo){
        var idCardBirthDay = IC.getBirthday(idNo);
        var age1 = getAge(idCardBirthDay);
        if($.isEmpty($("#age").val())){
            $("#age").val(age1);
        }
        if($.isEmpty($('input:radio[name="report.ageUnit"]:checked').val())){
            $("input[name=\'report.ageUnit\']:eq(0)").attr("checked",'checked');
        }
    }


    /*
     * 病例分类限制条件
     * infectiousCode：疾病编码
     * */
    function caseCategoryCheck(infectiousCode){
    	if($.isEmpty(infectiousCode)){
    		return;
    	}
    	var carrier = ['102','204','2032','2151','2152','2261','2262'];//可填报“病原携带者”疾病编码
    	var suspectedDiagnosis = ['202','2141','2142'];//不可填报“疑似诊断”疾病编码
    	var clinicalDiagnosis = ['2141','2142'];//不可填报“临床诊断”疾病编码
    	var laboratoryDiagnosis = ['2143','2144'];//不可填报“实验诊断”疾病编码
    	var caseCategory = $('input[name="report.caseCategory"]:checked').val();
    	/*
    	 * 病例分类：“病原携带者”
		 * 除了可填报的疾病，如果选择了其他疾病，禁用
		 */
    	
    	var exist = $.inArray(infectiousCode,carrier);
    	if(exist < 0){
    		if(caseCategory == '4'){
    			$('input:radio[name="report.caseCategory"]').attr('checked', false);
    		}
    		$('input:radio[name="report.caseCategory"][value="4"]').attr("disabled", true); 
    	}else{
    		$('input:radio[name="report.caseCategory"][value="4"]').attr("disabled", false); 
    	}

    	/*
    	 * 病例分类：“疑似诊断”
		 * 如果选择了'202','2141','2142'，则“疑似诊断”禁用
		 */
    	exist = $.inArray(infectiousCode,suspectedDiagnosis);
    	if(exist >= 0){
    		if(caseCategory == '1'){
    			$('input:radio[name="report.caseCategory"]').attr('checked', false);
    		}    		
    		$('input:radio[name="report.caseCategory"][value="1"]').attr("disabled", true); 
    	}else{
    		$('input:radio[name="report.caseCategory"][value="1"]').attr("disabled", false); 
    	} 
    	
    	/*
    	 * 病例分类：“临床诊断”
		 * 如果选择了'2141','2142'，则“临床诊断”禁用
		 */
    	exist = $.inArray(infectiousCode,clinicalDiagnosis);
    	if(exist >= 0){
    		if(caseCategory == '2'){
    			$('input:radio[name="report.caseCategory"]').attr('checked', false);
    		}    		
    		$('input:radio[name="report.caseCategory"][value="2"]').attr("disabled", true); 
    	}else{
    		$('input:radio[name="report.caseCategory"][value="2"]').attr("disabled", false); 
    	} 
    	
    	/*
    	 * 病例分类：“实验诊断”
		 * 如果选择了'2143','2144'，则“实验诊断”禁用
		 */
    	exist = $.inArray(infectiousCode,laboratoryDiagnosis);
    	if(exist >= 0){
    		if(caseCategory == '3'){
    			$('input:radio[name="report.caseCategory"]').attr('checked', false);
    		}    		
    		$('input:radio[name="report.caseCategory"][value="3"]').attr("disabled", true); 
    	}else{
    		$('input:radio[name="report.caseCategory"][value="3"]').attr("disabled", false); 
    	}    	
    }
    /*
     * 幼托、学生、干部、工人、民工、教师、医务人员
     * 工作单位必填
     * */
    function occupationCheck(occupationCode){
    	var occupationUnitName = ['CV020120201','CV020120203','CV020120214','CV020120209','CV020120210','CV020120204','CV020120208'];//工作单位必填的职业
    	/*工作单位必填 */    	
    	var exist = $.inArray(occupationCode,occupationUnitName);
		if (exist >= 0){ 	
			validate.addCheckElement('report.unitName',{"required":"true"});
		}else{
			validate.removeCheckElement('report.unitName');
		}
    	/*
    	 * 14周岁以上不能是幼托儿童、散居儿童
    	 * 从业人员年龄必须在14周岁（包括）以上
    	 */    	
		occupationCheckAge();
    }
    
    function occupationCheckAge(){
    	var occupationCode = $('#Occupation').val();
    	if($.isEmpty(occupationCode)){
    		return;
    	}
    	var occupationEmployee1 = ['CV020120201','CV020120202','CV020120203','CV020120299','CV020120217'];//非从业人员
    	var occupationEmployee2 = ['CV020120201','CV020120202'];//幼托儿童、散居儿童
    	/*
		 * 从业人员年龄必须在14周岁以上
		 */    	
    	var exist1 = $.inArray(occupationCode,occupationEmployee1);
    	var errorNum = 0;
    	if(exist1 < 0){
			var patientAge = calAge();
			var ageType = getAgeType();
			if (patientAge != -1 && patientAge <= 14){ 	
				if(ageType == 1){
					validate.addError('report.birthday',"从业人员年龄必须在14周岁以上");
			        validate.addCheckElement('report.birthday',{"compare":["occupationCheckAgeFlag","le","从业人员年龄必须在14周岁以上 "]});
				}else{
					validate.addError('report.age',"从业人员年龄必须在14周岁以上");
			        validate.addCheckElement('report.age',{"compare":["occupationCheckAgeFlag","le","从业人员年龄必须在14周岁以上 "]});
				}
				errorNum++;
			}
    	}else{
			validate.removeError('report.birthday');
            validate.removeCheckElement('report.birthday');
			validate.removeError('report.age');
            validate.removeCheckElement('report.age');            
		} 
    	/*
		 * 14周岁以上不能是幼托儿童、散居儿童
		 */     	
    	var exist2 = $.inArray(occupationCode,occupationEmployee2);
    	if(exist2 >= 0){
			var patientAge = calAge();
			var ageType = getAgeType();
			if (patientAge != -1 && patientAge > 14){ 	
				if(ageType == 1){
					validate.addError('report.birthday',"14周岁以上不能是幼托儿童、散居儿童");
			        validate.addCheckElement('report.birthday',{"compare":["occupationCheckAgeFlag","le","14周岁以上不能是幼托儿童、散居儿童 "]});
				}else{
					validate.addError('report.age',"14周岁以上不能是幼托儿童、散居儿童 ");
			        validate.addCheckElement('report.age',{"compare":["occupationCheckAgeFlag","le","14周岁以上不能是幼托儿童、散居儿童 "]});
				}
			}    		
    	}else if(errorNum == 0){
			validate.removeError('report.birthday');
            validate.removeCheckElement('report.birthday');
			validate.removeError('report.age');
            validate.removeCheckElement('report.age');            
		}
    }
    
    /*
     * 计算年龄，根据出生日期或年龄单位
     * */
    function calAge(){
		var patientAge = -1;
		var birthday = $('#birthday').val();
		if(!$.isEmpty(birthday)){//填写出生日期
			patientAge = getAge(birthday);
		}else if(!$.isEmpty($('#age').val())){
			/*根据年龄单位计算年龄*/
			var ageUnit = $('input:radio[name="report.ageUnit"]:checked').val();
			if(!$.isEmpty(ageUnit)){
				patientAge = getAgeByUnit(ageUnit);
			}
		}  
		return patientAge;
    }
    
    /*
     * 计算年龄方式
     * 1:填写出生日期；
     * 2：填写年龄
     * */
    function getAgeType(){
		var ageType = -1;
		if(!$.isEmpty($('#birthday').val())){
			ageType = 1;//填写出生日期
		}else if(!$.isEmpty($('#age').val())){
			var ageUnit = $('input:radio[name="report.ageUnit"]:checked').val();
			if(!$.isEmpty(ageUnit)){
				ageType = 2;
			}
		}  
		return ageType;
    }

    function showControl()
    {
        var raValue = $("select[name=\'report.infectiousCode\']:visible").find("option:selected").val();
        toggleOtherSC('report.infectiousCode','2032detail','2032');//乙肝
        toggleOtherSC('report.infectiousCode','311detail','311');//手足口
        toggleOtherSCMul('report.infectiousCode','222223detail','222,2231,2232,2233,2234,2235,202,229,318,313,312,314');
//        toggleOtherSC('report.infectiousCode','222223detail','222');//淋病
//        toggleOtherSC('report.infectiousCode','222223detail','2231');//梅毒  Ⅰ期
//        toggleOtherSC('report.infectiousCode','222223detail','2232');//梅毒  Ⅱ期
//        toggleOtherSC('report.infectiousCode','222223detail','2233');//梅毒  Ⅲ期
//        toggleOtherSC('report.infectiousCode','222223detail','2234');//梅毒  胎传
//        toggleOtherSC('report.infectiousCode','222223detail','2235');//梅毒  隐性
        toggleOtherSC('report.infectiousCode','206detail','206');//甲型H1N1流感
        toggleOtherSC('report.infectiousCode','202detail','202');//艾滋病HIV
        toggleOtherSC('report.infectiousCode','otherInfectiousName','99999'); //其他

        toggerAddressHr();
    }

    function initShowControl()
    {
        var value = $('#infectiousCodeHidden').val();
        var code = $('#infectiousCode').val();

        toggleOtherSCByValue(value,'2032detail','2032');//乙肝
        toggleOtherSCByValue(value,'311detail','311');//手足口
        toggleOtherSCByValueMul(value,'222223detail','222,2231,2232,2233,2234,2235,202,229,318,313,312,314');
//        toggleOtherSCByValue(value,'222223detail','222');//淋病
//        toggleOtherSCByValue(value,'222223detail','2231');//梅毒  Ⅰ期
//        toggleOtherSCByValue(value,'222223detail','2232');//梅毒  Ⅱ期
//        toggleOtherSCByValue(value,'222223detail','2233');//梅毒  Ⅲ期
//        toggleOtherSCByValue(value,'222223detail','2234');//梅毒  胎传
//        toggleOtherSCByValue(value,'222223detail','2235');//梅毒  隐性
        toggleOtherSCByValue(value,'206detail','206');//甲型H1N1流感
        toggleOtherSCByValue(value,'202detail','202');//艾滋病HIV
        toggleOtherSCByValue(value,'otherInfectiousName','99999'); //其他
        var arr = ['222','2231','2232','2233','2234','2235','202','229','318','313','312','314'];
        if(arr.indexOf(value)==(-1)){
            $("#222223detail").find('[re = "1"]').removeClass("required");
        }else{
            $("#222223detail").find('[re = "1"]').addClass("required");
        }
    }

    function toggleOtherSCByValue(value, otherId, code)
    {
//        var raValue = $("select[name=\'" + sCName + "\']:visible").find("option:selected").val();
        if (code == value)
        {
            $("#" + otherId).show();
        } else
        {
            $("#" + otherId).hide();
            $("#" + otherId).find("input[type=text]").each(function()
            {
                $(this).val('');
            });
            $("#" + otherId).find("input[type=radio]").each(function()
            {
                $(this).attr("checked", false);
            });
            $("#" + otherId).find("input[type=checkbox]").each(function()
            {
                $(this).attr("checked", false);
            });
            $("#" + otherId).find("select").each(function()
            {
                $(this).val('');
            });
        }
    }

    function toggleOtherSCByValueMul(value, otherId, code)
    {
//        var raValue = $("select[name=\'" + sCName + "\']:visible").find("option:selected").val();
        if (!$.isEmpty(value) && code.indexOf(value)!= -1)
        {
            $("#" + otherId).show();
        } else
        {
            $("#" + otherId).hide();
            $("#" + otherId).find("input[type=text]").each(function()
            {
                $(this).val('');
            });
            $("#" + otherId).find("input[type=radio]").each(function()
            {
                $(this).attr("checked", false);
            });
            $("#" + otherId).find("input[type=checkbox]").each(function()
            {
                $(this).attr("checked", false);
            });
            $("#" + otherId).find("select").each(function()
            {
                $(this).val('');
            });
        }
//        if(value != 202){
//            $("#222223detail .required").removeClass("required");
//        }else{
//            $("#222223detail .required").addClass("required");
//        }
    }

    function toggleOtherSCMul(sCName, otherId, code)
    {
        var raValue = $("select[name=\'" + sCName + "\']").find("option:selected").val();
        if (code.indexOf(raValue)!= -1)
        {
            $("#" + otherId).show();
        } else
        {
            $("#" + otherId).hide();
            $("#" + otherId).find("input[type=text]").each(function()
            {
                $(this).val('');
            });
            $("#" + otherId).find("input[type=radio]").each(function()
            {
                $(this).attr("checked", false);
            });
            $("#" + otherId).find("input[type=checkbox]").each(function()
            {
                $(this).attr("checked", false);
            });
            $("#" + otherId).find("select").each(function()
            {
                $(this).val('');
            });
        }
        if(raValue != '202'){
            $("#222223detail").find('[re = "1"]').removeClass("required");
        }else{
            $("#222223detail").find('[re = "1"]').addClass("required");
        }
    }

    /*手足口病：病例分类为实验室诊断时，实验室结果必填*/
    function hfmdCheckResultCheck(){
    	var infectiousCode = $("select[name=\'report.infectiousCode\']").find("option:selected").val();
        var caseCategory = $('input[name="report.caseCategory"]:checked').val();
        if(infectiousCode == '311' && caseCategory == 3){
            validate.addCheckElement('reportDesc.checkResult',{"required":"true"});
        }else{
            validate.removeCheckElement('reportDesc.checkResult');
        }
    }

    /*h1n1必填验证*/
    function h1n1Check(){
        var infectiousCode = $("select[name=\'report.infectiousCode\']").find("option:selected").val();
        if(infectiousCode == 206){
            validate.addCheckElement('reportDesc.conditionWay',{"required":"true"});
            validate.addCheckElement('reportDesc.inHospital',{"required":"true"});
            validate.addCheckElement('reportDesc.inHospitalDt',{"required":"true"});
//            validate.addCheckElement('reportDesc.outHospitalDt',{"required":"true"});
            validate.addCheckElement('reportDesc.cure',{"required":"true"});
            validate.addCheckElement('reportDesc.overseas',{"required":"true"});
        }else{
            validate.removeCheckElement('reportDesc.conditionWay',{"required":"true"});
            validate.removeCheckElement('reportDesc.inHospital',{"required":"true"});
            validate.removeCheckElement('reportDesc.inHospitalDt',{"required":"true"});
//            validate.removeCheckElement('reportDesc.outHospitalDt',{"required":"true"});
            validate.removeCheckElement('reportDesc.cure',{"required":"true"});
            validate.removeCheckElement('reportDesc.overseas',{"required":"true"});
        }
    }

    /*淋病、梅毒、艾滋病必填验证*/
    function lmhCheck(){
        var infectiousCode = $("select[name=\'report.infectiousCode\']:visible").find("option:selected").val();
        if('222,2231,2232,2233,2234,2235,202,229,318,313,312,314'.indexOf(infectiousCode)!= -1){
            validate.addCheckElement('report.marriage',{"required":"true"});
//            validate.addCheckElement('report.nation',{"required":"true"});
            validate.addCheckElement('report.education',{"required":"true"});
            validate.addCheckElement('reportDesc.contactHistory',{"required":"true"});
//            validate.addCheckElement('reportDesc.vdHistory',{"required":"true"});
            validate.addCheckElement('reportDesc.infectionWay',{"required":"true"});
            validate.addCheckElement('reportDesc.sampleSource',{"required":"true"});
//            validate.addCheckElement('reportDesc.checkConclusion',{"required":"true"});
//            validate.addCheckElement('reportDesc.checkPositiveDt',{"required":"true"});
//            validate.addCheckElement('reportDesc.checkPositiveUnit',{"required":"true"});
        }else{
            validate.removeCheckElement('report.marriage',{"required":"true"});
//            validate.removeCheckElement('report.nation',{"required":"true"});
            validate.removeCheckElement('report.education',{"required":"true"});
            validate.removeCheckElement('reportDesc.contactHistory',{"required":"true"});
//            validate.removeCheckElement('reportDesc.vdHistory',{"required":"true"});
            validate.removeCheckElement('reportDesc.infectionWay',{"required":"true"});
            validate.removeCheckElement('reportDesc.sampleSource',{"required":"true"});
//            validate.removeCheckElement('reportDesc.checkConclusion',{"required":"true"});
//            validate.removeCheckElement('reportDesc.checkPositiveDt',{"required":"true"});
//            validate.removeCheckElement('reportDesc.checkPositiveUnit',{"required":"true"});
        }
    }

    function hivCheck(){
        var infectiousCode = $("select[name=\'report.infectiousCode\']").find("option:selected").val();
        if(infectiousCode == 202){
            validate.addCheckElement('report.marriage',{"required":"true"});
            /*validate.addCheckElement('report.nation',{"required":"true"});*/
            validate.addCheckElement('report.education',{"required":"true"});
            validate.addCheckElement('reportDesc.contactHistory',{"required":"true"});
           /* validate.addCheckElement('reportDesc.vdHistory',{"required":"true"});*/
            validate.addCheckElement('reportDesc.infectionWay',{"required":"true"});
            validate.addCheckElement('reportDesc.sampleSource',{"required":"true"});
        /*    validate.addCheckElement('reportDesc.checkConclusion',{"required":"true"});
            validate.addCheckElement('reportDesc.checkPositiveDt',{"required":"true"});
            validate.addCheckElement('reportDesc.checkPositiveUnit',{"required":"true"});
            validate.addCheckElement('reportDesc.hivDiagnoseDt',{"required":"true"});*/
        }else{
            validate.removeCheckElement('report.marriage',{"required":"true"});
           /* validate.removeCheckElement('report.nation',{"required":"true"});*/
            validate.removeCheckElement('report.education',{"required":"true"});
            validate.removeCheckElement('reportDesc.contactHistory',{"required":"true"});
          /*  validate.removeCheckElement('reportDesc.vdHistory',{"required":"true"});*/
            validate.removeCheckElement('reportDesc.infectionWay',{"required":"true"});
            validate.removeCheckElement('reportDesc.sampleSource',{"required":"true"});
          /*  validate.removeCheckElement('reportDesc.checkConclusion',{"required":"true"});
            validate.removeCheckElement('reportDesc.checkPositiveDt',{"required":"true"});
            validate.removeCheckElement('reportDesc.checkPositiveUnit',{"required":"true"});
            validate.removeCheckElement('reportDesc.hivDiagnoseDt',{"required":"true"});*/
        }
    }

    function showTip(code){
        if($.isEmpty(code)){
            return;
        }
        var tipContent = '';
        if('101' == code){
            tipContent = '血清、全血、其他';
        }
        if('102' == code){
            tipContent = '粪便、肛拭、其他';
        }
        if('201' == code){
            tipContent = '血清、咽拭子、其他';
        }
        if(code.indexOf('203')!= -1){
            tipContent = '血清';
        }
        if('205' == code){
            tipContent = '血清、咽拭子';
        }
        if('206' == code){
            tipContent = '咽拭子';
        }
        if('208' == code){
            tipContent = '血清';
        }
        if('209' == code){
            tipContent = '脑脊液、其他';
        }
        if('211' == code){
            tipContent = '血清';
        }
        if(code.indexOf('212')!= -1){
            tipContent = '血清、全血、粪便、脑脊液、其他';
        }
        if(code.indexOf('213')!= -1){
            tipContent = '粪便、肛拭';
        }
        if(code.indexOf('215')!= -1){
            tipContent = '血清、全血、粪便、肛拭';
        }
        if('216' == code){
            tipContent = '血清、全血、脑脊液、其他';
        }
        if('220' == code){
            tipContent = '咽拭子、其他';
        }
        if('221' == code){
            tipContent = '血清、全血';
        }
        if('224' == code){
            tipContent = '血清、全血';
        }
        if('311' == code){
            tipContent = '咽拭子';
        }
        if(''!=tipContent){
            $("#sampleTip").html('【提示，需采集标本：' + tipContent + '】');
        }else{
            $("#sampleTip").html('');
        }
    }
    /**
     * 报卡监控补卡，返回监控列表
     */
	function returnSystem(){
		$("#reportRecordListDiv").empty();
        $("#top_all").show();
        userOperationLogSearch.searchReportRecord();
	}

	/*隐藏、显示身份证还是其他证件*/
    function toggerIdcardType(){
            $("input[name='report.otherIdcardType']").on("click", function()
            {
                if ("01" == $(this).val()){
                    $("#otherIdcardTypeDiv1").attr("class","");
                    $("#otherIdcardTypeDiv2").attr("class","hide");
                }else{
                    $("#otherIdcardTypeDiv1").attr("class","hide");
                    $("#otherIdcardTypeDiv2").attr("class","");
                }
            });
    }

    /*隐藏、显示住院日期、出院日期*/
    function toggerHospitalDt(){
            $("input[name='reportDesc.inHospital']").on("click", function()
            {
                if ("1" == $(this).val()){
                    $("#hospitalDt_id").show();
                }else{
                    $("#hospitalDt_id").hide();
                }
            });
    }
    
    //外部报卡页面中文正常,保存是中文乱码解决方案（因为jquery降版本所致）
    $.ajaxSetup({
        contentType: "application/x-www-form-urlencoded; charset=utf-8"
    });

  //IE8不支持indexOf，扩展indexOf
    function extendIndexOf(){
    	if (!Array.prototype.indexOf)
    	{
    	  Array.prototype.indexOf = function(elt /*, from*/)
    	  {
    	    var len = this.length >>> 0;

    	    var from = Number(arguments[1]) || 0;
    	    from = (from < 0)
    	         ? Math.ceil(from)
    	         : Math.floor(from);
    	    if (from < 0)
    	      from += len;

    	    for (; from < len; from++)
    	    {
    	      if (from in this &&
    	          this[from] === elt)
    	        return from;
    	    }
    	    return -1;
    	  };
    	}
    }
	return {
		reportSubmit : reportSubmit,
		queryPerson : queryPerson,
		queryInfection:queryInfection,
		getInfectionsName:getInfectionsName,
		returnSearch:returnSearch,
		approval:approval,
		getAgeByUnit:getAgeByUnit,
		getAge:getAge,
		approvalDialog:approvalDialog,
		toggerAddress:toggerAddress,
        reportSubmitExternal : reportSubmitExternal,
        diagnosisErrorExternal:diagnosisErrorExternal,
        displayPaAddress : displayPaAddress,
        displayHrAddress : displayHrAddress,
        showControl : showControl,
        initShowControl : initShowControl,
        caseCategoryCheck:caseCategoryCheck,
        occupationCheck:occupationCheck,
        occupationCheckAge:occupationCheckAge,
        toggleOccupation:toggleOccupation,
        search: search,
        showTip:showTip,
        infectiousChange:infectiousChange,
        returnSystem:returnSystem,
        toggerIdcardType:toggerIdcardType,
        toggerHospitalDt:toggerHospitalDt
	};
})();
