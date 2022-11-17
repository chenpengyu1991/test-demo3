var drugEdit = (function() {
	var validate=null;
    $(function() {
    	validate = $("#drugEditForm").easyValidate();
    	enableChangeConfirm();
        init();
    });

    function init(){
        $("#returnSearch").click(function(e) {
            e.preventDefault();
        	mhmCommon.returnSearch('drugSearch.returnSearch');
        });
        $("#saveDrug").click(function(e) {
        	e.preventDefault();
        	saveDrug();
        });
        $("#popuHistory").click(function(e) {
        	e.preventDefault();
        	popuDrugPrice();
        });
        $('#unitMeasure').change(function(){
        	buildSpecial();
        });
        $('#drugUnit').change(function(){
        	buildSpecial();
        });
        $('#amount').change(function(){
        	buildSpecial();
        	calDrugPrice();
        });   
        $('#unitPrice').change(function(){
        	calDrugPrice();
        }); 
        
        var drugId = $('#drugId').val();
        if(!$.isEmpty(drugId)){
        	$("#drugEditForm").diabaleForm();
        	$("#drugEditForm").find('input[id][name!=unitPrice][name!=drugPrice]').each(function(){
        		$(this).css({ background: "#F0F0F0" });
        	});
        	$('.required').removeClass("required");
        	$('#unitPrice').removeAttr('readonly');
        	$('#unitPrice').addClass("required");
        	$('#drugPrice').removeAttr('readonly');
        	$('#drugPrice').addClass("required");
        }
        
    }
    function saveDrug(){
    	var result=validate.validateForm();
    	if(!result){
    		return;
    	}    	
        $("#drugEditForm").submitFormGetJson({
			url : "/mhm/drug/save",
            wait : true,
			callback : function(data) {
				
				if (data.indexOf("fail") > -1) {
					layui.use('layer', function(){
		    			var layer = layui.layer;
		    			layer.alert("保存失败！", {icon:0,title:'提示'});
		    		});
                }else{
                	layui.use('layer', function(){
		    			var layer = layui.layer;
		    			layer.alert("保存成功！", {icon:0,title:'提示'}, function() {
		    				layer.closeAll();
		    				drugSearch.returnSearch();
		    			});
		    		});
                    return false;
                }
			}
		});    	
    }  
    /**
     * 根据单位剂量、单位、每盒数量生成规格
     */
    function buildSpecial(){
    	var unitMeasure = $('#unitMeasure').val();
    	var drugUnit = $('#drugUnit').val();
    	var amount = $('#amount').val();
    	if(!$.isEmpty(unitMeasure) && !$.isEmpty(drugUnit) && !$.isEmpty(amount)){
    		$('#specificationsLabel').text(unitMeasure + drugUnit + '*' + amount);
    		$('#drugSpecifications').val(unitMeasure + drugUnit + '*' + amount);
    	}
    }
     /**
     * 根据根据药品单价/每盒数量，计算总价格
     */
    function calDrugPrice(){
    	var drugPrice = 0;
    	var unitPrice = $('#unitPrice').val();
    	var amount = $('#amount').val();
    	if (validate.validate("unitPrice") && validate.validate("amount")){
    		if(amount!="0"){   
				rs=unitPrice*amount;   
				drugPrice = (Math.round(rs*100)/100);   
			}
    		$('#drugPrice').val(drugPrice);
    	}
    }
	function popuDrugPrice() { 
		var drugId = $('#drugId').val();
		/*var dialogObj = {
				url : contextPath + "/mhm/drug/popuDrugPrice",
	            height : 500,
	            width : 600,				
				param : {drugId:drugId,pageIndex:1},
				title : "操作记录"
			};
		$.dialog(dialogObj);*/	
		
		$.post(contextPath+'/mhm/drug/popuDrugPrice',
        		{ drugId:drugId,pageIndex:1
			     }, 
			function(ret){
        	layui.use(['layer'], function() {
        		  var layer = layui.layer
        		  layer.open({
        			  type: 1,
        			  id:'mhmDrugPriceDialog',
        			  area: ['600px', '500px'],
        			  title:'操作记录',
        			  content: ret
        		  });
        		});
        	});
	};        
	return {
	};
})();



