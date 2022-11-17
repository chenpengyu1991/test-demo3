var fgrestdrugreg = (function() {
	var validate=null;
	$(function() {
		validate = $("#restSdForm").easyValidate();
		enableChangeConfirm();
		$("#addRecord").click(function() {
			addRecord();
        });
		toggleOther('listFg.drugObject','spanDrugObjectId','2');
		toggleOther('listFg.noObjectResult','spannoObjectResultId','99');
		toggleOther('listFg.noWholeResult','spannoWholeResultId','99');
        displayPaAddress();
        switchLink();
	});
	
	function search(){
		disableChangeConfirm();
		$("#standard_detailDiv").empty();
		standardSearch.searchStandard();
		$("#standard_top_all").show();		
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

	function fillData(){
		
		var ageDoseStr1="";
		var ageDoseStr2="";
		var ageDoseStr3="";
		var ageDoseStr4="";
		var ageDoseStr5="";
		var ageDoseStr6="";
		var ageDose = $("input[name='ageDose']:checked").val(); 
		if(ageDose == '1'){
			ageDoseStr1 = "√";
		}else if(ageDose == '2'){
			ageDoseStr2 = "√";
		}else if(ageDose == '3'){
			ageDoseStr3 = "√";
		}else if(ageDose == '4'){
			ageDoseStr4 = "√";
		}else if(ageDose == '5'){
			ageDoseStr5 = "√";
		}else if(ageDose == '6'){
			ageDoseStr6 = "√";
		}
		
	    var sdObj = idmCommon.getPopObj('restSdChildTable');
	    sdObj['ageDoseStr1'] = ageDoseStr1;
	    sdObj['ageDoseStr2'] = ageDoseStr2;
	    sdObj['ageDoseStr3'] = ageDoseStr3;
	    sdObj['ageDoseStr4'] = ageDoseStr4;
	    sdObj['ageDoseStr5'] = ageDoseStr5;
	    sdObj['ageDoseStr6'] = ageDoseStr6;

        var sdShowFields = ['drugDt', 'drugName', 'ageDoseStr1', 'ageDoseStr2', 'ageDoseStr3', 'ageDoseStr4', 'ageDoseStr5', 'ageDoseStr6','patientName'];
        var sdHideFields = ['ageDose'];
        var sdShowValues = [sdObj.drugDt, sdObj.drugName, sdObj.ageDoseStr1, sdObj.ageDoseStr2, sdObj.ageDoseStr3, sdObj.ageDoseStr4, sdObj.ageDoseStr5, sdObj.ageDoseStr6,''];
        var sdHideValues = [sdObj.ageDose];
        var editMethod = "fgrestdrugreg.popupRecord(this,'edit')";
        return generateTrHtml(sdShowFields, sdHideFields, sdShowValues, sdHideValues, editMethod);
	}
	   /**
    *
    * @param showFields 显示的字段
    * @param hideFields 隐藏的字段
    * @param showValues 显示字段的值
    * @param hideValues 隐藏字段的值
    * @param editMethod 修改的方法
    * @returns {string} 新增的一条子表记录的html
    */

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
           '<a href="javascript:void(0)" onclick="fgrestdrugreg.removeTr(this)">删除</a>' +
           '</td>';
       html += '</tr>';
       return html;
   }	
	function saveRecord(type){
		validate = $("#restSdForm").easyValidate();
		var result=validate.validateForm();
		if(!result){
			return;
		}		
	    var html = fillData();
	    if('edit' == type){
	        var rowNum = $('#rowNum').val();
	        html = html.replace("</tr>", "");
	        html = html.replace("<tr>", "");
	        $("#sdTable tr").eq(rowNum).html(html);
	    }else{
	        $("#sdTable").append(html);
	    }
	    switchLink();
	    idmCommon.closePopUp('fgRestSdDialog');		
	}
    function popupRecord(btn, type){
        var url = "/idm/malaria/standard/addFgDrugRecord";
        var title = "修改服药记录";

        if("edit" == type){
            var extendDiv = btn.parentNode.parentNode;
            var rowNum = extendDiv.rowIndex;;
            var trData = {};
            $(extendDiv).find("td").each(function(tdindex,tditem){
                var inputValue = $(tditem).text();
                if('' != inputValue){
                    trData[$(this).attr("field")] = inputValue;
                }
            });
            var trDataStr =  "[" + util.Obj2str(trData) + "]";
            param = {trData:trDataStr, rowNum:rowNum, type:'edit'};
        }
        var fgRestSdDialog = {
            url : url,
            height : 350,
            width : 800,
            title : title,
            id :"fgRestSdDialog",
            param:param
        };
        $.dialog(fgRestSdDialog);
    }
	/*重点人群督导服药登记提交方法*/
    function drugregSubmit(){
        validate = $("#drugregForm").easyValidate();
        var result=validate.validateForm();
        if(!result){
            return;
        }
        $("#listSdJson").val(util.Obj2str(getTableData()));
		$("#drugregForm").submitFormGetJson({
			url : '/idm/malaria/standard/fgDrugRecordSave',
            wait : true,
            callback : function(data) {
                if (data.indexOf("fail") > -1) {
                    layer.alert("登记表保存失败！", {icon:0,title:'提示'});
                }else {
                    layer.alert("登记表保存成功！", {icon:0,title:'提示'});
                    search();
                    return false;
                }
            },
            wait:true
		});        
    } 
    function getTableData(){
        var tableData = [];
        $("#sdTable tr").each(function(trindex,tritem){
            if(trindex > 1){
                var trData = {};
                $(tritem).find("td").each(function(tdindex,tditem){
                    var inputValue = $(tditem).text();
                    inputValue = inputValue.replace(/\t/g,'');//制表符替换
                    inputValue = inputValue.replace(/\n/g,'');//换行替换                    
                    if('' != inputValue && "undefined" != inputValue && undefined != inputValue){
                        trData[$(this).attr("field")] = inputValue;
                    }
                });
                tableData.push(trData);
            }
        });
        return tableData;

    }  
    /*
     * 督导服药只能新增8次
     * */
    function switchLink(){
    	var result = true;
		var drugNum = $("#sdTable").find("tr").length;//药品数量
		if(drugNum < 10){
			$('#addRecord').removeAttr("disabled");
			$('#addRecord').unbind("click");
	        $("#addRecord").click(function() {
	        	addRecord();
	        });	
		}else{
			$('#addRecord').attr("disabled","disabled");
        	$('#addRecord').unbind("click");
        	result = false;
		}  
		return result;
    }  
    function addRecord(){
        var fgRestSdDialog = {
                url : "/idm/malaria/standard/addFgDrugRecord",
                height : 350,
                width : 800,
                title : "新增服药记录" ,
                id :"fgRestSdDialog"
            };
            $.dialog(fgRestSdDialog);    	
    }
    //表删除一行
    function removeTr(rmBtn){
    	var index = layer.confirm("你确定要删除此条数据吗？", {icon:2, title:'确认提示'}, function(){
            var extendDiv = rmBtn.parentNode.parentNode;
            $(extendDiv).remove();
            switchLink();
            layer.close(index);
        });
    }   
    function choosePatient(){
        var chooseDialog = {
                url : "/idm/malaria/standard/choosePatient",
                height : 550,
                width : 800,
                title : "选择患者" ,
                id :"chooseDialog"
            };
            $.dialog(chooseDialog);     	
    }
    function getPatient(){
    	var idmId = $('#patientIdmId').val();
        //选择了患者，这次的人群信息如下：
        if(!$.isEmpty(idmId)){
                $.getJsonByUrl({
                url : '/idm/malaria/standard/getPatientInfo',
                param : {
                    idmId : idmId
                },
                wait : true,
                callback : function(data,status) {
                    if(!$.isEmpty(data)){
                        setPatient(data);
                    }
                },
                wait:true
            });
        }
    }
    
    function setPatient(data){
    	$('#patientNameId').val(data.generalCondition.name);
    	$('#patientIdcardId').val(data.generalCondition.idcard);
    	var value=$('input[name="listFg.restObject"]:checked').val();
    	if(value == '1'){
    		var generalCondition = data.generalCondition;
    		if(!$.isEmpty(generalCondition)){
        		$('#fgNameId').val(data.generalCondition.name);
        		$('#parentsName').val(data.generalCondition.parentsName);
        		$('input[name="listFg.gender"][value="' + data.generalCondition.gender +'"]').attr("checked",true);
        		$('#age').val(data.generalCondition.age);
        		$('#patown_address').val(data.generalCondition.patownShip);
        		var idd = $("#patown_address").attr("idd").replace('townId', '');
        		orgUtil.getVillageOpting(idd,"",data.Pastreet);
        		if(!$.isEmpty(data.Pastreet)){
        			$('#pavillage_address').val(data.generalCondition.Pastreet);
        		}
        		$('#pahomeNumber').val(data.generalCondition.pahouseNumber);
        		$('#phoneNumberId').val(data.generalCondition.phoneNumber);
    		}
    		var clinicalManifestations = data.clinicalManifestations;
    		if(!$.isEmpty(clinicalManifestations)){
    			$('#weight').val(data.clinicalManifestations.weight);
    		}
    		var otherCondition = data.otherCondition;
    		if(!$.isEmpty(otherCondition)){
    	   		$('#dutyDoctorId').val(data.otherCondition.supervisorUser);
        		$('input[name="listFg.drugNorm"][value="' + data.otherCondition.drugNorm +'"]').attr("checked",true);
    		} 
    		var caseInformation = data.caseInformation;
    		if(!$.isEmpty(caseInformation)){
            	$('#acceptTownId').val(caseInformation.acceptTown);
            	$('#acceptUnitId').val(caseInformation.acceptUnit);
    		}    		
    	}else{
            //如果不是疟史则不带回患者的信息
            $('#fgNameId').val("");
            $('#parentsName').val("");
            $('input[name="listFg.gender"][value="1"]').attr("checked",false);
            $('input[name="listFg.gender"][value="2"]').attr("checked",false);
            $('#age').val("");
            $('#weight').val("");
            $('#pahomeNumber').val("");
            $('#phoneNumberId').val("");
            $('#dutyDoctorId').val("");
            $('input[name="listFg.drugNorm"]').attr("checked",false);
    		var caseInformation = data.caseInformation;
    		if(!$.isEmpty(caseInformation)){
            	$('#acceptTownId').val(caseInformation.acceptTown);
            	$('#acceptUnitId').val(caseInformation.acceptUnit);
    		}            
        }

    }
    function exportFg(id){
        if(contentChanged){
        	msgUtil.backConfirm(function(){
        		drugregSave(id);  
			});        	
        }else{
    		$("#standard_detailDiv").hide();
    		$.loadHtmlByUrl({
    			url : "/idm/malaria/standard/exportFg",
    			insertDiv :"standard_printDiv",
                wait : true,
    			param : {id:id}
    		});
    		$("#standard_printDiv").show();	           	
        }  	
	
    }
	/*	导出前先保存
	 * 重点人群督导服药登记保存方法
	 * */
    function drugregSave(id){
        validate = $("#drugregForm").easyValidate();
        var result=validate.validateForm();
        if(!result){
            return;
        }
        $("#listSdJson").val(util.Obj2str(getTableData()));
		$("#drugregForm").submitFormGetJson({
			url : '/idm/malaria/standard/fgDrugRecordSave',
            wait : true,
            callback : function(data) {
                if (data.indexOf("fail") > -1) {
                    layer.alert("登记表保存失败！", {icon:0,title:'提示'});
                }else {
            		$("#standard_detailDiv").hide();
            		$.loadHtmlByUrl({
            			url : "/idm/malaria/standard/exportFg",
            			insertDiv :"standard_printDiv",
                        wait : true,
            			param : {id:id}
            		});
            		$("#standard_printDiv").show();	
                    return false;
                }
            },
            wait:true
		});        
    }     
    function returnExport(){
    	$("#standard_printDiv").hide();
    	$("#standard_detailDiv").show();
    } 
    function printFg(){
    	$("#printPage").jqprint();
    }

    function displayPaAddress() {
        $("select[name='listFg.pastreet']").on("change villageChange", function()
        {
            var prefix = $("select[name='listFg.patownShip']").find("option[value!='']:selected").text();
            prefix += $(this).find("option[value!='']:selected").text();
            $("#tempPaValue").text(prefix);
        });
    }

	return {
		returnSearch:returnSearch,
		saveRecord:saveRecord,
		popupRecord:popupRecord,
		drugregSubmit:drugregSubmit,
		switchLink:switchLink,
		removeTr:removeTr,
		choosePatient:choosePatient,
		getPatient:getPatient,
		exportFg:exportFg,
		returnExport:returnExport,
		printFg:printFg,
        displayPaAddress:displayPaAddress
	};
})();