var drugAdd = (function() {
	var validate = null;
    $(function() {
    	validate = $("#drugAddForm").easyValidate();
        init();
    });

    function init(){
        $("#saveDrugAdd").click(function(e) {
        	e.preventDefault();
        	saveDrugUse();
        });  
        $("#modifyDrugAdd").click(function(e) {
        	e.preventDefault();
        	saveDrugUse();
        });  
        $("#cancelDrugAdd").click(function(e) {
           /*mhmCommon.closePopUp('drugUseDialog');*/
        	e.preventDefault();
           mhmCommon.closeLayUiDialog();
        });        
        $('#useCount').change(function(){
			changePrice();
        });
        $('#useCount').keyup(function(){
			changePrice();
        });        
        var drugUseId = $('#drugUseId').val();
        if(!$.isEmpty(drugUseId)){
        	$("#drugAddForm").diabaleForm();
        	$("#drugAddForm").find('input[id][name!=useCount]').each(function(){
        		$(this).css({ background: "#F0F0F0" });
        	});
        	$('.required').removeClass("required");
        	$('#useCount').removeAttr('readonly');
        	$('#lbUseCount').addClass("required");
        }else{        
			mhmCommon.initDrugSelectBox('drugSelectBox',selectFun);
        }
    }
	function changePrice(){
		var useCount = $('#useCount').val();
		var currentUnitOrice = $('#currentUnitOriceHidden').val();
		if(validate.validate("useCount") && (!$.isEmpty(currentUnitOrice))){
			var currentPrice = currentUnitOrice*useCount;
			currentPrice = (Math.round(currentPrice*100)/100);  
			$('#currentPrice').text(currentPrice);
			$('#currentPriceHidden').val(currentPrice);
		}		
	}
	function selectFun(data){
		var drugId = $(data).attr("id");
        $.getJsonByUrl({
            url : "/mhm/drug/queryDrug",
            wait : true,
            callback : function(data) {
                if(!$.isEmpty(data)){
                    if(data.flag){
                        setData(data);
                    } else {
                    	layui.use('layer', function() {
    	        			var layer = layui.layer;
    	        			layer.alert("获取药品信息失败！", {icon:0,title:'提示'});
    	        		});
                    }
                }
            },
            param:{drugId:drugId}
        });		
	}
	/**
	 * 保存服药记录
	 */
	function saveDrugUse(){
		validate = $("#drugAddForm").easyValidate();
		var drugPriceId = $("#drugAddForm input[name='drugId']").val();
		var currentUnitOrice = $("#drugAddForm input[name='currentUnitOrice']").val();
		if($.isEmpty(drugPriceId) || $.isEmpty(currentUnitOrice) ){
			validate.addError('drugId_name',"请选择药品！");
			return;
		}
        var result=validate.validateForm();
        if(!result){
            return;
        }
        $("#drugAddForm").submitFormGetJson({
			url : "/mhm/useDrug/saveDrugUse",
            wait : true,
			callback : function(data) {
				if (data.indexOf("fail") > -1) {
					layui.use('layer', function() {
	        			var layer = layui.layer;
	        			layer.alert("发药登记保存失败！", {icon:0,title:'提示'});
	        		});
                }else{
                	layui.use('layer', function() {
	        			var layer = layui.layer;
	        			layer.alert("发药登记保存成功！", {icon:0,title:'提示'}, function() {
	        				layer.closeAll();
	        				drugUseSearch.searchDrugList();
	        			});
	        		});
                    return false;
                }
			}
		});  		
//	    mhmCommon.closePopUp('drugUseDialog');	
	    mhmCommon.closeLayUiDialog();
	}	
	function setData(data){
		$('#hDrugName').val(data.drugName);
		$('#drugUnit').text(data.drugUnit);
		$('#unitMeasure').text(data.unitMeasure);
		$('#currentUnitOrice').text(data.unitPrice);
		$('#currentUnitOriceHidden').val(data.unitPrice);
		$('#freeType').val(data.isFree);	
	}
	return {

	};
})();



