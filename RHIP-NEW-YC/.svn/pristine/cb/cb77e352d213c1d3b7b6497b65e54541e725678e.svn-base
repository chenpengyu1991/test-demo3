var restdrugreg = (function() {
	var validate=null;
	$(function() {
		validate = $("#restSdForm").easyValidate();
		enableChangeConfirm();
		var value=$('input[name="generalCondition.floatPopulation"]:checked').val();
		if($.isEmpty(value)){
			$('input[name="generalCondition.floatPopulation"][value="1"]').attr("checked",true);
		}
		toggerAddress();
		$("#addRecord").click(function() {
			addRecord();
        });
		toggleOther('otherCondition.drugObject','spanDrugObjectId','2');
		toggleOther('otherCondition.noObjectResult','spannoObjectResultId','99');
		toggleOther('otherCondition.noWholeResult','spannoWholeResultId','99');
		switchLink();
        idmCommon.displayPaAddress();
		malariaIndex.diabaleForm('restDrugregForm');
	});
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
        idmCommon.displayPaAddress();
	}   
	function changeAddress(type){
		if(type=="1"){
			$("#pavillage_address").removeAttr("disabled");
			$('#patown_address').removeAttr("disabled");
            $("#tempPaValue").show();
            $('#spanPaNumber').text("门牌号");
			$('#pahouseNumber').attr({"style":"width:180px"});
		}else{
			$("#pavillage_address").attr("disabled", "disabled");
			$("#patown_address").attr("disabled", "disabled");
            $("#tempPaValue").hide();
            $('#spanPaNumber').text("详细地址");
			$('#pahouseNumber').attr({'style':'width:90%'});
		}
	}	
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
        var editMethod = "restdrugreg.popupRecord(this,'edit')";
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
           '<a href="javascript:void(0)" onclick="restdrugreg.removeTr(this)">删除</a>' +
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
	    contentChanged = true;
	    idmCommon.closePopUp('restSdDialog');		
	}
    function popupRecord(btn, type){
        var url = "/idm/malaria/standard/addRestDrugRecord";
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
        var restSdDialog = {
            url : url,
            height : 350,
            width : 800,
            title : title,
            id :"restSdDialog",
            param:param
        };
        $.dialog(restSdDialog);
    }
	/*休止期督导服药登记提交方法*/
    function drugregSubmit(){
        validate = $("#restDrugregForm").easyValidate();
        var result=validate.validateForm();
        if(!result){
            return;
        }
        $("#listSdJson").val(util.Obj2str(getTableData()));
		$("#restDrugregForm").submitFormGetJson({
			url : '/idm/malaria/standard/restDrugRecordSave',
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
        var restSdDialog = {
                url : "/idm/malaria/standard/addRestDrugRecord",
                height : 350,
                width : 800,
                title : "新增服药记录" ,
                id :"restSdDialog"
            };
            $.dialog(restSdDialog);    	
    }
    //表删除一行
    function removeTr(rmBtn){
    	var index = layer.confirm("你确定要删除此条数据吗？", {icon:2, title:'确认提示'}, function(){
            var extendDiv = rmBtn.parentNode.parentNode;
            $(extendDiv).remove();
            switchLink();
            contentChanged = true;
            layer.close(index);
        });
    }    
    function exportDrugreg(idmId){
		$("#standard_detailDiv").hide();
		$.loadHtmlByUrl({
			url : "/idm/malaria/standard/exportRestDrugreg",
			insertDiv :"standard_printDiv",
            wait : true,
			param : {idmId:idmId}
		});
		$("#standard_printDiv").show();	   	
    }
    function returnExport(){
    	$("#standard_printDiv").hide();
    	$("#standard_detailDiv").show();
    }
    function printDrugreg(){
    	$("#printPage").jqprint();
    }
	return {
		returnSearch:returnSearch,
		toggerAddress:toggerAddress,
		saveRecord:saveRecord,
		popupRecord:popupRecord,
		drugregSubmit:drugregSubmit,
		switchLink:switchLink,
		removeTr:removeTr,
		exportDrugreg:exportDrugreg,
		returnExport:returnExport,
		printDrugreg:printDrugreg
	};
})();