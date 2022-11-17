var offPersonRecord = (function(){
	var validate = $("#offForm").easyValidate();
	$(function(){
        $("#off_button").click(function(e) {
        	e.preventDefault();
        	var result=validate.validateForm();
        	if(!result){
        		return;
        	}
            $("#offForm").submitFormGetJson({
                url : "/family/cancel", 
                callback:function(data){  
                	layui.use('layer', function(){
    	    			var layer = layui.layer;
    	    			layer.alert(data.remsg, function () {
    	    				layer.closeAll();
    	    			});
    	    		});
                	/*layer.alert(data.remsg);*/ 
                	var val="已建档"; 
                	switch (data.restatus) { 
	                    case "1":
	                    	val="审核中";
	                    	$("#status"+$("#familyId").val()).val("1");
	                    	$("#pIndex"+$("#familyId").val()).empty();
	                		$("#pIndex"+$("#familyId").val()).append(val);
	                		familySearch.searchSQ(1);
	                    	break;
	                    case "2":
	                    	val="已注销";
	                    	$("#status"+$("#familyId").val()).val("2");
	                    	$("#pIndex"+$("#familyId").val()).empty();
	                		$("#pIndex"+$("#familyId").val()).append(val);
	                		familySearch.searchSQ(1);
	                    	break;
	                    case "3": 
	                    	val="已退回";  
	                    	$("#status"+$("#familyId").val()).val("3");
	                    	$("#pIndex"+$("#familyId").val()).empty();
	                		$("#pIndex"+$("#familyId").val()).append(val);
	                    	$("#tr"+$("#familyId").val()).removeClass("disable");
	                    	$("#div"+$("#familyId").val()).removeClass("disable");
	                    	familySearch.searchOther(1);
	                    	break;
                	} 
//                	$("#tdStatus"+$("#familyId").val()).text(val);
                	if(data.restatus==1||data.restatus==2)
                	{ 
                		$("#tr"+$("#familyId").val()).addClass("disable");
                    	$("#div"+$("#familyId").val()).addClass("disable");
                    	
                	} 
                	if(data.restatus!=0)
            		{
                		$.removeDialog("cancelFmilyDialog"); 
            		}
                }
            });
        });
	});
	
})();