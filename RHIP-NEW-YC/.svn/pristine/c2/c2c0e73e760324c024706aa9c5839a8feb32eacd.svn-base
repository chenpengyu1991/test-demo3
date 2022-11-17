(function($){
	var submitCahce = new Array;
	var i = 0;
	var flag = true;
    $.extend({
        postRepeat: function(url, data, callback,dataType,param,time) {
        	if (time == null) {
        		time = 10000;
        	}
        	if(dataType == null || dataType == ""){
        		dataType = 'html';
        	}
        	if(!checkCahce(url)){
        		return;
        	}
        	//if (i == 2) i = 0;
        	var urlc = url + "?date=" + new Date();
        	if(param != null & param != ""){
        		urlc = urlc + "&" + param;
        	}
            options = {
            	type: 'POST',
				url: urlc,
				data: data,
				success: function(data){
				     flag = false;
				     callback(data);
				   },
				complete:function(xhr, ts){
					if (xhr.status == "403") {
						window.location.reload();
						return true;
					} else if (flag){
						if (i >= 2) {
							i=0;
							error(url);
						} else {
							 i++;
		                   	 popCahce(url);
		                 	$.postRepeat(url,data, callback,dataType,param);
						}
					}
					popCahce(url);
				},
				dataType: dataType,
				timeout:time
            };
            return $.ajax(options);
        }
    });
    
    function error(url) {
    	$("#msgError").html("系统异常，请稍后再试！");
		$("#msgError").show();
		if(url.indexOf("/reserve/register/create/") != -1) {
			var arr=url.split("/");
			$("#"+arr[arr.length-1]+"_a").html("预约");
			cutDomId = -1;
		} else {
			$("#loading").hide();
		}
		if(url.indexOf("sysSetting/") != -1) {
			$("input[type=button]").attr('disabled',false);
		} 
		
    	popCahce(url);
    }
    function popCahce(url){
    	var cahceArray = new Array;
    	for(var i = 0;i < submitCahce.length ; i++){
    		var ca = submitCahce[i];
    		if(ca != url){
    			cahceArray.push(ca);
    		}
    	}
    	submitCahce = cahceArray;
    }
    
    function checkCahce(url){
    	for(var i = 0;i < submitCahce.length ; i++){
    		var ca = submitCahce[i];
    		if(ca == url){
    			return false;
    		}
    	}
    	submitCahce.push(url);
    	return true;
    }
})(jQuery);