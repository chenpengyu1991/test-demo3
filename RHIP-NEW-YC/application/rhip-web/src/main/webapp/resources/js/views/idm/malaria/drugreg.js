var drugreg = (function() {
	var validate=null;
	$(function() {
		validate = $("#drugregForm").easyValidate();
		enableChangeConfirm();
		var value=$('input[name="generalCondition.floatPopulation"]:checked').val();
        if($.isEmpty(value)){
			$('input[name="generalCondition.floatPopulation"][value="1"]').attr("checked",true);
		}
		toggerAddress();
		$("#addRecord").click(function() {
            var sdDialog = {
                url : "/idm/malaria/standard/addDrugRecord",
                height : 350,
                width : 800,
                title : "新增服药记录" ,
                id :"sdDialog"
            };
            $.dialog(sdDialog);
        });
        idmCommon.displayPaAddress();
        malariaIndex.diabaleForm('drugregForm');
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
            $('#br').show();
            $('#spanPaNumber').text("门牌号");
			$('#pahouseNumber').attr({"style":"width:180px"});
		}else{
			$("#pavillage_address").attr("disabled", "disabled");
			$("#patown_address").attr("disabled", "disabled");
            $("#tempPaValue").hide();
            $('#br').hide();
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
	/*服药登记提交方法*/
    function drugregSubmit(){
        validate = $("#drugregForm").easyValidate();
        var result=validate.validateForm();
        if(!result){
            return;
        }
        var listSd = getTableData('sdTable');
        $("#listSdJson").val(util.Obj2str(listSd));
		$("#drugregForm").submitFormGetJson({
			url : '/idm/malaria/standard/drugRecordSave',
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
	/*修改服药记录*/
	function editTr(editLink){
		var trData = [];
		var extendDiv = editLink.parentNode.parentNode;
	    var rowNum = extendDiv.rowIndex;
	    var item = $(extendDiv).attr("item");
	    var rowIndex = 0;
	    $('#sdTable tr:not(:first)').each(function(){
	    	var currentItem = $(this).attr("item");
	    	if(currentItem != item){
	    		return true;
	    	}
	    	trData[rowIndex] = {};
	    	$(this).find("td").each(function(tdindex,tditem){
		    	var inputValue = $(tditem).text();
                inputValue = inputValue.replace(/\t/g,'');//制表符替换
                inputValue = inputValue.replace(/\n/g,'');//换行替换		    	
		        if('' != inputValue){
		        	trData[rowIndex][$(this).attr("field")] = inputValue;
		        }
	        });
	    	rowIndex ++;
	    });
	    var trDataStr =  "[";
	    for(var i = 0; i < trData.length; i++) {
	    	trDataStr += util.Obj2str(trData[i]);
	    	if(i < trData.length -1 ){
	    		trDataStr += ",";
	    	}else{
	    		trDataStr += "]";
	    	}
    	} 
		trDataStr = trDataStr.replace(/[\t]/g, ""); 
		var sdDialog = {
                url : "/idm/malaria/standard/addDrugRecord",
                height :350,
                width : 800,
                title : "修改服药记录",
                id :"sdDialog",
                param:{trData:trDataStr,type:'edit',rowNum:rowNum,item:item}                
            };
        $.dialog(sdDialog);
	}
    function removeTr(rmBtn){
    	var index = layer.confirm("你确定要删除此条数据吗？", {icon:2, title:'确认提示'}, function(){
            var extendDiv = rmBtn.parentNode.parentNode;
            var item = $(extendDiv).attr('item');
    		$(extendDiv).nextAll().each(function(){
    			var currentItem = $(this).attr('item');
    			if(currentItem == item){
    				 $(this).remove();
    			}else{
    				return false;
    			}
    		});
            $(extendDiv).remove();
            layer.close(index);
        });
    }	
    function getTableData(tableId){
        var tableData = [];
        $("#"+tableId+" tr").each(function(trindex,tritem){
            if(trindex > 0){
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
    function exportDrugreg(idmId){
		$("#standard_detailDiv").hide();
		$.loadHtmlByUrl({
			url : "/idm/malaria/standard/exportDrugreg",
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
		drugregSubmit:drugregSubmit,
		editTr:editTr,
		removeTr:removeTr,
		exportDrugreg:exportDrugreg,
		returnExport:returnExport,
		printDrugreg:printDrugreg
	};
})();