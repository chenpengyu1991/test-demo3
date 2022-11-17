var caseEdit = (function() {
	var validate=null;
	$(function() {

        $("#detailDiv .toolbar").addClass("toolbarfixed0");

        validate = $("#caseForm").easyValidate();
        validate.addExtension("phoneVali",phoneVali);
		/*$.Placeholder.init({query:"#idCard",callback:function(element){
			queryPerson($(element).val());
		}});*/
		queryInfection();
        $("#infectiousType1").change(function(){
        	queryInfection();
        });
        enableChangeConfirm();
	});
	
    /**
	 * 联系电话，3个电话至少填写一个
     * @returns {boolean}
     */
    function phoneVali(){
        var inputs=$(".phoneVali");
        var inputValue = "";
        inputs.each(function(){
            inputValue += $(this).val();
        });
        if(inputValue != ""){
            $(".phoneVali").removeClass("lose");
            return true;
        }else {
            $(".phoneVali").addClass("lose");
            return false;
        }
    }
    
	function caseSubmit(type,infectiousCode) {
		
		var id = $("#idCard").val();
        if(!$.isEmpty(id) && id=="输入身份证获取个人信息"){
        	$("#idCard").val("");
        }
		//checkAge();
		if($("#reportDiseasesId").val() == 'h1n1') {
			checkAges();
		}
        var idmId = $("#idmId").val();
    	var result=validate.validateForm();
    	if(!result){
    		return;
    	}
        var urlStr = '';
        if(type == 1){
            urlStr = '/idm/case/save';
        }else if(type == 4){
        	urlStr = '/idm/case/back';
        }else{
            urlStr = '/idm/case/edit';
        }

        //时间类型,格式转成"yyyy/MM/dd"
        formatDate();

        var efcTableData = getTableData('efcTable', idmId);
        var esTableData = getTableData('esTable', idmId);       
        var disTableData = getTableData('disinfectTable',idmId);
        var leTableData = getTableData('leTable', idmId);
        var bddTableData = getTableData('bddTable', idmId);
        var acTableData = getTableData('acTable', idmId);
        var esActivityTable = getTableData('activityTable', idmId);
        var esAnimalTable = getTableData('animalTable', idmId);
        var esLeaveTable = getTableData('leaveTable', idmId);
        var esContactTable = getTableData('contactTable', idmId);
        var efcFamilyTable = getTableData('familyTable', idmId);
        var efcWorkOrgTable = getTableData('workOrgTable', idmId);
        //伤寒、副伤寒个案调查表中三个字表位于同一个实体中
        if($("#reportDiseasesId").val() == 'typhia') {//
        	$("#leList").val(util.Obj2str(getTablesData('cultureTable', 'grubersTable', 'cellTable', idmId)));
		}else if($("#reportDiseasesId").val() == 'hiwhpai'){
            //禽流感4个子表存在实验室检查中
            var leTableIds = ['le1Table', 'le2Table', 'le3Table', 'le4Table'];
            var leFlags = ["1","2","3","4"];
            $("#leList").val(util.Obj2str(getTablesData2('leTable', leTableIds, leFlags, idmId)));
        } else {
			$("#leList").val(util.Obj2str(leTableData));
		}

        //$("#esList").val(util.Obj2str(esTableData));
        //$("#efcList").val(util.Obj2str(efcTableData));
        $("#esList").val(util.Obj2str(getTablesData2('esTable', [], [], idmId)));
        $("#efcList").val(util.Obj2str(getTablesData2('efcTable', [], [], idmId))); 
        $("#disinfectList").val(util.Obj2str(disTableData));//细菌性和阿米巴性，消毒情况
        $("#bddList").val(util.Obj2str(bddTableData));
        /*发病情况*/
        $("#acList").val(util.Obj2str(acTableData));
        /*发病前一周内逐日活动情况*/
        $("#esActivityList").val(util.Obj2str(esActivityTable));
        /*发病前两周内接触动物*/
        $("#esAnimalList").val(util.Obj2str(esAnimalTable));        
        /*发病后至隔离治疗前逐日活动情况*/
        $("#esLeaveList").val(util.Obj2str(esLeaveTable));
        /*发病前2周内是否接触过非典病人或/和疑似非典患者*/
        $("#esContactList").val(util.Obj2str(esContactTable));
        /*家庭、亲友*/
        $("#efcFamilyList").val(util.Obj2str(efcFamilyTable));
        /*工作单位或主要活动场所联系人*/
        $("#efcWorkOrgList").val(util.Obj2str(efcWorkOrgTable));        

        //禽流感4个子表存在卫生条件中
        var hcTableIds = ['hc1Table', 'hc2Table', 'hc3Table', 'hc4Table'];
        var hcFlags = ["1","2","3","4"];
        $("#hcList").val(util.Obj2str(getTablesData2('hcTable', hcTableIds, hcFlags, idmId)));
        //禽流感7个子表存在暴露史中
        var tableIds = ['eh1Table', 'eh2Table', 'eh3Table', 'eh4Table', 'eh5Table', 'eh6Table', 'eh7Table'];
        var flags = ["1","2","3","4","5","6","7"];
        $("#ehList").val(util.Obj2str(getTablesData2('ehTable', tableIds, flags, idmId)));
        $("#caseForm").submitFormGetJson({
			url : urlStr,
			param : {infectiousCode:infectiousCode},
            callback : function(data) {
                if (data.indexOf("fail") > -1) {
                	if(type==3){
                		layer.alert("个案审核失败！", {icon:0,title:'提示'});
                	}else if(type==4){
                		layer.alert("个案退回失败！", {icon:0,title:'提示'});
                	}else{
                		layer.alert("个案保存失败！", {icon:0,title:'提示'});
                	}
                    return false;
                }else {
                	if(type==3){
                		layer.alert("个案审核成功！", {icon:0,title:'提示'});

                	}else if(type==4){
                		layer.alert("个案已退回！", {icon:0,title:'提示'});
                	}else{
                		layer.alert("个案保存成功！", {icon:0,title:'提示'});
                	}
                    contentChanged = false;
                    search();
                    return true;
                }
            },
            wait:true
		});
	};

    function formatDate(){
        var vdDate =  $('#vdDate').val();
        if(undefined != vdDate && vdDate != '' && vdDate.length == 7){
            var vdDateYMD = vdDate + '/01';
            $('#vdDate').val(vdDateYMD);
        }
        //pastHistory.spouseVdDate
        var spouseVdDate =  $('#spouseVdDate').val();
        if(undefined != spouseVdDate && spouseVdDate != '' && spouseVdDate.length == 7){
            var spouseVdDateYMD = spouseVdDate + '/01';
            $('#spouseVdDate').val(spouseVdDateYMD);
        }
        //epidemiologicalSurvey.aimmugenDtF 甲肝疫苗接种时间
        var aimmugenDtF =  $('#aimmugenDtF').val();
        if(undefined != aimmugenDtF && aimmugenDtF != '' && aimmugenDtF.length == 4){
            var aimmugenDtFYMD = aimmugenDtF + '/01/01';
            $('#aimmugenDtF').val(aimmugenDtFYMD);
        }
        //epidemiologicalSurvey.aimmugenDtS
        var aimmugenDtS =  $('#aimmugenDtS').val();
        if(undefined != aimmugenDtS && aimmugenDtS != '' && aimmugenDtS.length == 4){
            var aimmugenDtSYMD = aimmugenDtS + '/01/01';
            $('#aimmugenDtS').val(aimmugenDtSYMD);
        }
        if(undefined != aimmugenDtF && aimmugenDtF != '' && aimmugenDtF.length == 7){
            var aimmugenDtFYMD = aimmugenDtF + '/01';
            $('#aimmugenDtF').val(aimmugenDtFYMD);
        }
        //epidemiologicalSurvey.aimmugenDtS
        var aimmugenDtS =  $('#aimmugenDtS').val();
        if(undefined != aimmugenDtS && aimmugenDtS != '' && aimmugenDtS.length == 7){
            var aimmugenDtSYMD = aimmugenDtS + '/01';
            $('#aimmugenDtS').val(aimmugenDtSYMD);
        }
        var mvLastInoculateDt =  $('#mvLastInoculateDt').val();
        if(undefined != mvLastInoculateDt && mvLastInoculateDt != '' && mvLastInoculateDt.length == 7){
            var mvLastInoculateDtYMD = mvLastInoculateDt + '/01';
            $('#mvLastInoculateDt').val(mvLastInoculateDtYMD);
        }
        //labExamine.reportTime
        var reportTime =  $('#reportTime').val();
        if(undefined !=reportTime && reportTime !='' && reportTime.length == 13){
            var length = reportTime.length;
            var reportHour = reportTime.substring(length-2,length);
            $('#reportHour').val(reportHour);
        }

        //beforeDiseaseDiet.eatTime
        var eatTime =  $('#eatTime').val();
        if(undefined !=eatTime && eatTime !='' && eatTime.length == 13){
            var length = eatTime.length;
            var eatTimeHour = eatTime.substring(length-2,length);
            $('#eatTimeHour').val(eatTimeHour);
        }

        //attackCondition.confirmationDate 确诊日期
        var confirmationDate =  $('#confirmationDate').val();
        if(undefined !=confirmationDate && confirmationDate !='' && confirmationDate.length == 13){
            var length = confirmationDate.length;
            var confirmationHour = confirmationDate.substring(length-2,length);
            $('#confirmationHour').val(confirmationHour);
        }
        //attackCondition.pathogenesisDate 发病日期
        var pathogenesisDate =  $('#pathogenesisDate').val();
        if(undefined !=pathogenesisDate && pathogenesisDate !='' && pathogenesisDate.length == 13){
            var length = pathogenesisDate.length;
            var pathogenesisHour = pathogenesisDate.substring(length-2,length);
            $('#pathogenesisHour').val(pathogenesisHour);
        }
       //attackCondition.firstVisitDate 首诊时间
        var firstVisitDate =  $('#firstVisitDate').val();
        if(undefined !=firstVisitDate && firstVisitDate !='' && firstVisitDate.length == 13){
            var length = firstVisitDate.length;
            var firstVisitHour = firstVisitDate.substring(length-2,length);
            $('#firstVisitHour').val(firstVisitHour);
        }
        //exposureHistory.operationDt
        var operationDt =  $('#operationDt').val();
        if(undefined != operationDt && operationDt != '' && operationDt.length == 7){
            var operationDtYMD = operationDt + '/01';
            $('#operationDt').val(operationDtYMD);
        }
        //caseInformation.discoveryDate
        var discoveryDate =  $('#discoveryDate').val();
        if(undefined != discoveryDate && discoveryDate != '' && discoveryDate.length == 16){
            var discoveryDateHM = discoveryDate.substr(11,16);
            $('#discoveryDateHM').val(discoveryDateHM);
        }

        //caseInformation.directReportDate
        var directReportDate =  $('#directReportDate').val();
        if(undefined != directReportDate && directReportDate != '' && directReportDate.length == 16){
            var directReportDateHM = directReportDate.substr(11,16);
            $('#directReportDateHM').val(directReportDateHM);
        }

        //caseInformation.reportDate
        var reportDate =  $('#reportDate').val();
        if(undefined != reportDate && reportDate != '' && reportDate.length == 13){
            var length = reportDate.length;
            var reportDateHM = reportDate.substring(length-2,length);
            $('#reportDateHM').val(reportDateHM);
        }
        //infectionSourceRoute.contactSimilerPatientDt 接触时间
        queryDateHour('contactSimilerPatient_Dt', 'contactSimilerPatientHour');
        
        //epidemicFocusClose.diseaseReportDate 县级疾病预防控制中心接到报告时间
        queryDateHour('diseaseReportDate', 'diseaseReportHour');
        //epidemicFocusClose.diseaseSceneDate 县级疾病预防控制中心到达现场时间
        queryDateHour('diseaseSceneDate', 'diseaseSceneHour');
        //epidemicFocusClose.removeDate 解除时间
        queryDateHour('removeDate', 'removeHour');
        //epidemicFocusClose.termSterTime 终末消毒时间
        queryDateHour('termSterTime', 'termSterHour');
        
        //beforeDiseaseDiet.dinnerDate 同餐日期
        queryDateHour('dinnerDate', 'dinnerHour');
        
        //labExamine.stoolCollecttimeFive 病人粪检情况 第五次时间
        queryDateHour('stoolCollecttimeFive', 'stoolCollectHourFive');
        //labExamine.stoolCollecttimeFour 病人粪检情况 第四次时间
        queryDateHour('stoolCollecttimeFour', 'stoolCollectHourFour');
        //labExamine.stoolCollecttimeFour 病人粪检情况 第三次时间
        queryDateHour('stoolCollecttimeThree', 'stoolCollectHourThree');
        //labExamine.stoolCollecttimeFour 病人粪检情况 第三次时间
        queryDateHour('stoolCollecttimeTwo', 'stoolCollectHourTwo');
        //labExamine.stoolCollecttimeFour 病人粪检情况 第三次时间
        queryDateHour('stoolCollecttimeOne', 'stoolCollectHourOne');
        
        //exposureHistory.exposureDt 暴露日期
        queryDateHour('exposureDt', 'exposureHour');
        //exposureHistory.handlingTime 处理时间
        queryDateHour('handlingTime', 'handlingHour');
        //exposureHistory.rabiesVaccinationDtF 首针时间
        queryDateHour('rabiesVaccinationDtF', 'rabiesVaccinationHourF');
        
        //epidemiologicalSurvey.hepatitisBVaccineDtF
        var hepatitisBVaccineDtF =  $('#hepatitisBVaccineDtF').val();
        if(undefined != hepatitisBVaccineDtF && hepatitisBVaccineDtF != '' && hepatitisBVaccineDtF.length == 7){
        	 var hepatitisBVaccineDtFYMD = hepatitisBVaccineDtF + '/01';
             $('#hepatitisBVaccineDtF').val(hepatitisBVaccineDtFYMD);
        }
        //epidemiologicalSurvey.hepatitisBVaccineDtS
        var hepatitisBVaccineDtS =  $('#hepatitisBVaccineDtS').val();
        if(undefined != hepatitisBVaccineDtS && hepatitisBVaccineDtS != '' && hepatitisBVaccineDtS.length == 7){
            var hepatitisBVaccineDtSYMD = hepatitisBVaccineDtS + '/01';
            $('#hepatitisBVaccineDtS').val(hepatitisBVaccineDtSYMD);
        }
        //epidemiologicalSurvey.hepatitisBVaccineDtT
        var hepatitisBVaccineDtT =  $('#hepatitisBVaccineDtT').val();
        if(undefined != hepatitisBVaccineDtT && hepatitisBVaccineDtT != '' && hepatitisBVaccineDtT.length == 7){
            var hepatitisBVaccineDtTYMD = hepatitisBVaccineDtT + '/01';
            $('#hepatitisBVaccineDtT').val(hepatitisBVaccineDtTYMD);
        }
        //exposureHistory.operationDt
        var operationDt =  $('#operationDt').val();
        if(undefined != operationDt && operationDt != '' && operationDt.length == 7){
            var operationDtYMD = operationDt + '/01';
            $('#operationDt').val(operationDtYMD);
        }
        //exposureHistory.receptionBloodEndDt
        var receptionBloodEndDt =  $('#receptionBloodEndDt').val();
        if(undefined != receptionBloodEndDt && receptionBloodEndDt != '' && receptionBloodEndDt.length == 7){
            var receptionBloodEndDtYMD = receptionBloodEndDt + '/01';
            $('#receptionBloodEndDt').val(receptionBloodEndDtYMD);
        }
        //exposureHistory.toothDt
        var toothDt =  $('#toothDt').val();
        if(undefined != toothDt && toothDt != '' && toothDt.length == 7){
            var toothDtYMD = toothDt + '/01';
            $('#toothDt').val(toothDtYMD);
        }
        //exposureHistory.acupunctureDate
        var acupunctureDate =  $('#acupunctureDate').val();
        if(undefined != acupunctureDate && acupunctureDate != '' && acupunctureDate.length == 7){
            var acupunctureDateYMD = acupunctureDate + '/01';
            $('#acupunctureDate').val(acupunctureDateYMD);
        }  
        
        
    }
    /*如果输入年龄，则必须选择年龄单位*/
    function queryDateHour(dateId, hourId){
    	var dateVal =  $('#' + dateId).val();
        if(undefined != dateVal && dateVal != '' && dateVal.length == 13){
        	var length = dateVal.length;
            var hourVal = dateVal.substring(length-2,length);
            $('#' + hourId).val(hourVal);
        }
    }
    
	/*如果输入年龄，则必须选择年龄单位*/
	function checkAge(){
		var age = $('#age').val();
		var ageUnit= $('#ageUnit').val();
		if(!$.isEmpty(age) && $.isEmpty(ageUnit)){
			validate.addCheckElement('generalCondition.ageUnit',{"required":"true"});	
		}else{
			validate.removeCheckElement('generalCondition.ageUnit');
		}
	}
	
	function queryPerson(idCard) {
        if (validate.validate("generalCondition.idcard")){
             $.getJsonByUrl({
                url : "/idm/report/queryPerson",
                wait:true,
                callback : function(data) {
                    if(!$.isEmpty(data)){
                        $('#idCard').val(data.Idcard);
                        $('#name').val(data.Name);
                        $('#gender').val(data.Gender);
                        $('#birthday').val(data.Birthday);
                        $('#unitName').val(data.UnitName);
                        $('#unitPhone').val(data.UnitPhone);
                        $('#Occupation').val(data.Occupation);
                        $('#town_address').val(data.PatownShip);
                        var idd = $("#town_address").attr("idd").replace('townId', '');
                        orgUtil.getVillageOpting(idd,"",data.Pastreet);
                        if(!$.isEmpty(data.Pastreet)){
                        	$('#village_address').val(data.Pastreet);
                        }
                        $('#PahouseNumber').val(data.PahouseNumber);
                    }
                },
                param : {
                    idCard : idCard
                }
            });
        }
	};
	function queryInfection() {
		var infectionType = $('#infectiousType1').val();
		var infectiousCode = $('#infectiousCodeHidden').val();

		if($.isEmpty(infectionType)){
			return;
		}
		$("#infectiousCode option").remove();  
		$.getJsonByUrl({
			url : "/idm/set/queryInfection",
			wait:true,
			callback : function(data) {
				$.each(data,function(key,values){
					$("#infectiousCode").append('<option value="'+ key +'">' + values + '</option>');
				});
				if(!$.isEmpty(infectiousCode)){
					$('#infectiousCode').val(infectiousCode);
				}
			},
			param : {
				type : infectionType
			}
		});
	};
	function getInfectionsName(){
		var name = $('#infectiousCode option:selected').text();
		$('#infectiousName').val(name);
	};
	function returnSearch(){
		// if(contentChanged){
			/*msgUtil.backConfirm(function(){
				search();
			});*/
			
			layui.use('layer', function(){
				var layer = layui.layer;
				 var index = layer.confirm('确认离开？', {icon:1, title:'确认提示'}, function(index){
					layer.close(index);
					search();
				});
			});
		// }else{
		// 	search();
		// }
	};
	function search(){
		disableChangeConfirm();
//        var pageIndex = $("#pageIndex").val();
        var pageIndex = $("#pageIndexI").val();
		$("#detailDiv").empty();
		pageIndex = ($.isEmpty(pageIndex)?1:pageIndex);
		searchDetail(pageIndex);
		$("#top_all").show();
        $("#detailDiv").removeClass("toolbarfixed");
    }

    function searchDetail(indexPage) {
        if($.isEmpty(indexPage)){
            indexPage = $("#pageIndexI").val();
        }
        var tab = $("#tab").val();
        var searchObj = {
            url : "/idm/case/caseList/"+tab,
            insertDiv : "caseResultDiv",
//			wait:true,
            param : {
                indexPage : indexPage
//                tab : tab
            },
            callback: function() {
                /*为listDiv中a的添加click事件*/
                initLinkClick('caseAddId',caseIndex, {id:"data-id",idmId:"data-idmid",infectiousCode:"data-infectiouscode",name:"data-name",type:"1",logoff:"data-logoff"});
                initLinkClick('caseModifyId',caseIndex, {id:"data-id",idmId:"data-idmid",infectiousCode:"data-infectiouscode",name:"data-name",type:"2",logoff:"data-logoff"});
                initLinkClick('caseViewId',caseIndex, {id:"data-id",idmId:"data-idmid",infectiousCode:"data-infectiouscode",name:"data-name",type:"3",logoff:"data-logoff"});
            }
        };
        $("#detailDiv").hide();
        $("#top_all").show();
        $("#reportSearchForm").submitFormLoadHtml(searchObj);
    };

    function caseIndex(id,idmId,infectiousCode,name,type,logoff){
        $("#top_all").hide();
        var pageIndex = $("#currentPage").val();
        $.loadHtmlByUrl({
            url : "/idm/case/caseIndex",
            insertDiv :"detailDiv",
            param : {id:id, idmId:idmId, infectiousCode:infectiousCode, pageIndex:pageIndex,name:name,type:type,logoff:logoff}
        });
        $("#detailDiv").show();

    };

    function getTableData(tableId, idmId){
        var tableData = [];
        $("#"+tableId+" tr").each(function(trindex,tritem){
            if(trindex > 0){
                var trData = {};
                $(tritem).find("td").each(function(tdindex,tditem){
                    trData['idmId'] = idmId;
                    var inputValue = $(tditem).text();
                    if('' != inputValue && "undefined" != inputValue && undefined != inputValue){
                        trData[$(this).attr("field")] = inputValue;
                    }
                    if($(this).attr("field") == 'contactDtStr'){
                        if(inputValue.length >10 ){
                            trData['contactBeginDt'] = inputValue.substr(0,10);
                        }
                        if(inputValue.length >14 ){
                            trData['contactEndDt'] = inputValue.substr(11,21);
                        }
                    }
                });
                tableData.push(trData);
            }
        });
        return tableData;

    }
    
    function getTablesData(table1Id, table2Id, table3Id, idmId){
        var tableData = [];
        tableData = getArrayDataForTable(table1Id, tableData, idmId);
        tableData = getArrayDataForTable(table2Id, tableData, idmId);
        tableData = getArrayDataForTable(table3Id, tableData, idmId);
        return tableData;
    }
    
    function getArrayDataForTable(tableId, tableData, idmId){
    	 $("#"+tableId+" tr").each(function(trindex,tritem){
             if(trindex > 0){
                 var trData = {};
                 $(tritem).find("td").each(function(tdindex,tditem){
                	  trData['idmId'] = idmId;
                     var inputValue = $(tditem).text();
                     if('' != inputValue){
                         trData[$(this).attr("field")] = inputValue;
                     }
                     if($(this).attr("field") == 'contactDtStr'){
                         if(inputValue.length >10 ){
                             trData['contactBeginDt'] = inputValue.substr(0,10);
                         }
                         if(inputValue.length >14 ){
                             trData['contactEndDt'] = inputValue.substr(11,21);
                         }
                     }
                 });
                 tableData.push(trData);
             }
         });
    	 return tableData;
    }

    function getTablesData2(singleId, tableIds, flags, idmId){
        var tableData = [];
        tableData = getArrayDataForTable2(singleId, tableData, 0, idmId);
        for(var i=0; i<tableIds.length; i++ ){
            tableData = getArrayDataForTable2(tableIds[i], tableData,flags[i], idmId);
        }
        return tableData;
    }

    function getArrayDataForTable2(tableId, tableData,flag, idmId){
        $("#"+tableId+" tr").each(function(trindex,tritem){
            if(trindex > 0){
                var trData = {};
                $(tritem).find("td").each(function(tdindex,tditem){
                    trData['idmId'] = idmId;
                    var inputValue = $(tditem).text();
                    if('' != inputValue && "undefined" !=inputValue && undefined !=inputValue ){
                        trData[$(this).attr("field")] = inputValue;
                    }
                    if($(this).attr("field") == 'contactDtStr'){
                        if(inputValue.length >10 ){
                            trData['contactBeginDt'] = inputValue.substr(0,10);
                        }
                        if(inputValue.length >14 ){
                            trData['contactEndDt'] = inputValue.substr(11,21);
                        }
                    }
                    trData['flag'] = flag;
                });
                tableData.push(trData);
            }
        });
        return tableData;
    }

	/**
	 * 1、输入年龄时，必须选择年龄单位
	 * 2、出生日期、年龄二选一
	 * 3、如果年龄小于14岁，必须输入家长姓名
	 */
	function checkAges(){
		var birthday = $('#birthday').val();
		var birthdayType = $('input:radio[name="generalCondition.birthdateType"]:checked').val();
		var age = $('#age').val();
		/*设置必填项，出生日期、年龄必选一项*/
		if($.isEmpty(age)){
			validate.removeCheckElement('generalCondition.ageUnit',{"required":"true"});
			/*如果年龄为空，则出生日期必填*/
			if($.isEmpty(birthday)){
				validate.addCheckElement('generalCondition.birthday',{"required":"true"});
				validate.addCheckElement('generalCondition.birthdateType',{"required":"true"});
			} else if (!$.isEmpty(birthday) && $.isEmpty(birthdayType)){
				validate.addCheckElement('generalCondition.birthdateType',{"required":"true"});
			} else {
				validate.removeCheckElement('generalCondition.birthday');
				validate.removeCheckElement('generalCondition.birthdateType');
			}
		}else{
			/*如果年龄不为空，则年龄单位必填*/
			validate.addCheckElement('generalCondition.ageUnit',{"required":"true"});
			validate.removeCheckElement('generalCondition.birthday');
			validate.removeCheckElement('generalCondition.birthdateType');
		}
		/* 计算年龄，判断家长姓名是否必填
		 * 出生日期、年龄，出生日期优先级高
		*/
		var birthday = $('#birthday').val();
		/*出生日期或年龄是否为空标志*/
		var ageEmpty = true;
		if(!$.isEmpty(birthday)){
			/*根据出生日期计算年龄*/
			age = reportEdit.getAge(birthday);
			ageEmpty = false;
		}else if(!$.isEmpty(age)){
			ageEmpty = false;
			/*根据年龄单位计算年龄*/
			var ageUnit = $('input:radio[name="generalCondition.ageUnit"]:checked').val();
			if(!$.isEmpty(ageUnit)){
				
				age = reportEdit.getAgeByUnit(ageUnit);
			}
		}
		if (!ageEmpty && age < 14){ 	
			validate.addCheckElement('generalCondition.parentsName',{"required":"true"});
		}else{
			validate.removeCheckElement('generalCondition.parentsName');
		}
	}
	
	//个案字表删除一行
    function removeTr(rmBtn){
    	var index = layer.confirm("你确定要删除此条数据吗？", {icon:2, title:'确认提示'}, function(){
    		var extendDiv = rmBtn.parentNode.parentNode;
	        $(extendDiv).remove();
	        layer.close(index);
		});
    }
    
    function closePopUp(dialogId){
        $.removeDialog (dialogId);
    }
    //户籍的显示隐藏
    function showHrPlace() {
    	if ("2" == $("input[name='generalCondition.hrPlace']:checked").val()){
			$("#hr-address-select").find("select").attr("disabled", "disabled");
			$("#hr-address-select").hide();
			$("#hrhouseNumber").removeAttr("style");
			$("#hrhouseNumber").val("");
		} else{
			$("#hr-address-select").find("select").removeAttr("disabled");
			$("#hrhouseNumber").attr("style","width: 20%");
			$("#hr-address-select").show();
			$("#hrhouseNumber").val("");
		}
    }

    function generateTrHtml(showFields, hideFields, showValues, hideValues, editMethod){
        var html = '<tr>';
        for(var i=0; i<showFields.length; i++){
            html += '<td field="' + showFields[i] + '" title="'+showValues[i]+'">'+showValues[i] +'</td>';
        }
        for(var i=0; i<hideFields.length; i++){
            html += '<td field="' + hideFields[i] + '" style="display: none">' + hideValues[i] + '</td>';
        }
        html += '<td class="btnsublist" field="btn">' +
            '<a href="javascript:void(0)" onclick=' + '\"'+ editMethod + '\"' + '>修改</a>&nbsp;' +
            '<a href="javascript:void(0)" onclick="caseEdit.removeTr(this)">删除</a>' +
            '</td>';
        html += '</tr>';
        return html;
    }

    function getPopObj(tableId){
        var popObj = {};
        $("#" + tableId).find("input").each(function(index, obj) {
            if (obj.type == "text" || obj.type == "hidden") {
                var inputValue = $(this).val();
                popObj[$(this).attr("name")] = inputValue;
            }
            if(obj.type == "radio"){
                if($(this).is(":checked")){
                    var name = $(this).attr("name");
                    popObj[$(this).attr("name")] = $(this).val();
                }
            }
        });
        return popObj;
    }
	/*隐藏、显示地址*/
	function toggerAddress(){
		/*是否流动人口*/
		var value=$('input[name="generalCondition.floatPopulation"]:checked').val();
		if(typeof $('input[name="generalCondition.patientAttribute"]:checked').val()!='undefined'){
			if($.isEmpty(value)){
				/*病人属于*/
				value=$('input[name="generalCondition.patientAttribute"]:checked').val();
				if('1' == value){
					changeAddress("1");
				}else{
					changeAddress("2");
				}
				toggleOther('generalCondition.patientAttribute','pavillage_address','1');
				toggleOther('generalCondition.patientAttribute','pastreet_address','1');
	            toggleOther('generalCondition.patientAttribute','patown_address','1');
	            toggleOther('generalCondition.patientAttribute','hrvillage_address','1');
	            toggleOther('generalCondition.patientAttribute','hrtreet_address','1');
	            toggleOther('generalCondition.patientAttribute','hrtown_address','1');
			}else{
				if('1' == value){
					changeAddress("1");
				}else{
					changeAddress("2");
				}
				toggleOther('generalCondition.floatPopulation','pavillage_address','1');
				toggleOther('generalCondition.floatPopulation','pastreet_address','1');
	            toggleOther('generalCondition.floatPopulation','patown_address','1');
	            toggleOther('generalCondition.floatPopulation','hrvillage_address','1');
	            toggleOther('generalCondition.floatPopulation','hrstreet_address','1');
	            toggleOther('generalCondition.floatPopulation','hrtown_address','1');
			}
		}
	}   
	function changeAddress(type){
		if(type=="1"){
			$("#pavillage_address").removeAttr("disabled");
			$("#hrvillage_address").removeAttr("disabled");
			$('#patown_address').removeAttr("disabled");
			$('#hrtown_address').removeAttr("disabled");
            $('#pastreet_address').removeAttr("disabled");
            $('#hrstreet_address').removeAttr("disabled");

            $('#spanPaNumber').text("门牌号");
			$('#spanHrNumber').text("门牌号");
			$('#pahouseNumber').attr({"style":"width:180px"});
			$('#hrhouseNumber').attr({"style":"width:180px"});
		}else{
			$("#pavillage_address").attr("disabled", "disabled");
			$("#hrvillage_address").attr("disabled", "disabled");
			$("#patown_address").attr("disabled", "disabled");
			$("#hrtown_address").attr("disabled", "disabled");
            $("#pastreet_address").attr("disabled", "disabled");
            $("#hrstreet_address").attr("disabled", "disabled");
            $('#spanPaNumber').text("详细地址");
			$('#spanHrNumber').text("详细地址");
			$('#pahouseNumber').attr({'style':'width:90%'});
			$('#hrhouseNumber').attr({'style':'width:90%'});			
		}
	}
	function contactedImport(infectiousCode){
		var dialogParams = {
				id : "d1",
				url : "/idm/case/import/showContactedImport",
				param : {infectiousCode:infectiousCode},
				height : 200,
				width : 750,
				title : "数据导入"
		};
		$.dialog(dialogParams);		
	}
	return {
		caseSubmit : caseSubmit,
		queryPerson : queryPerson,
		queryInfection:queryInfection,
		getInfectionsName:getInfectionsName,
		removeTr:removeTr,
		closePopUp:closePopUp,
		showHrPlace:showHrPlace,
		returnSearch:returnSearch,
        generateTrHtml:generateTrHtml,
        getPopObj:getPopObj,
        toggerAddress:toggerAddress,
        contactedImport:contactedImport,
        phoneVali:phoneVali
	};
})();



