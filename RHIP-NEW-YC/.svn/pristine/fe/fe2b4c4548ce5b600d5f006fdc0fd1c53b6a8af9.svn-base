var scDcEdit = (function() {
	var validate=null;
	$(function() { 
		queryInfection();
		validate = $("#scDcForm").easyValidate();
	});
	function queryInfection() {
		var infectionType = $('#infectiousTypeId').val();
		var infectiousCode = $('#infectiousCodeOldId').val();
		$("#infectiousId option").remove();  
		$("#infectiousId").append('<option value="">' + "请选择" + '</option>');
		if($.isEmpty(infectionType)){
			return;
		}
		$.getJsonByUrl({
			url : "/idm/statistics/report/selfcheck/queryInfection",
			callback : function(data) {
				$.each(data,function(key,values){
					$("#infectiousId").append('<option value="'+ key +'">' + values + '</option>');
				});
				if(!$.isEmpty(infectiousCode)){
					$('#infectiousId').val(infectiousCode);
				}
			},
			param : {type:infectionType},
			wait:true
		});
	};
	/*添加传染病报告记录*/
	function save(type){
		var result = checkInfectious(type);
		if(!result){
			validate.addError('infectiousCode',"该传染病本月已经填报，不允许重复！");
			return;
		}
        result=validate.validateForm();
        if(!result){
            return;
        }
		var html = fillData();
        if('edit' == type){
            var rowIndex = $('#rowIndex').val();
            html = html.replace("</tr>", "");
            html = html.replace("<tr>", "");
            $("#scDcTable tr").eq(rowIndex).html(html);
        }else{
            $("#scDcTable").append(html);
        }        
        contentChanged = true;
	    idmCommon.closePopUp('infectiousDialog');		
	}
	
	function fillData(){
        var scDcObj = idmCommon.getPopObj('scDcChildTable');
        scDcObj['infectiousName']=$("#infectiousId").find("option:selected").text();
        scDcObj['infectiousCode'] = $("#infectiousId").val();
        var scDcShowFields = ['infectiousName', 'shouldNum', 'missNum'];
        var scDcHideFields = ['id','infectiousCode'];
        var scDcShowValues = [scDcObj.infectiousName,scDcObj.shouldNum,scDcObj.missNum];
        var scDcHideValues = [scDcObj.id,scDcObj.infectiousCode];
        var editMethod = "selfFillDcEdit.popupInfectious(this,'edit')";
        return idmCommon.generateTrHtml(scDcShowFields, scDcHideFields, scDcShowValues, scDcHideValues, editMethod);
	}
	
    function checkInfectious(type){
    	var result = true;
    	var infectiousCode = $("#infectiousId").val();//当前选中的传染病编码
    	var infectiousOldCode = $("#infectiousCodeOldId").val();
    	/*
    	 * 1、如果infectiousOldCode为空：新增传染病
    	 * 2、如果infectiousCode != infectiousOldCode,修改传染病
    	 * 3、infectiousCode == infectiousOldCode,修改传染病，没有改变值不用验证
    	 * */
    	if($.isEmpty(infectiousOldCode) || (infectiousCode != infectiousOldCode)){
	        $("#scDcTable tr").each(function(trindex,tritem){
	            if(trindex > 0){
	                $(tritem).find("td").each(function(tdindex,tditem){
	                	var field = $(this).attr("field");
	                	var inputValue = $(tditem).text();
	                    inputValue = inputValue.replace(/\t/g,'');//制表符替换
	                    inputValue = inputValue.replace(/\n/g,'');//换行替换  
	                	if(field != 'infectiousCode'){
	                		return true;
	                	}else if (inputValue == infectiousCode){
	                		result = false;
	                		return false;
	                	}
	                });
	            }
	        });    		
    	}
        return result;
    }
 	return {
 		checkInfectious:checkInfectious,
 		queryInfection:queryInfection,
 		save:save
	};
})();