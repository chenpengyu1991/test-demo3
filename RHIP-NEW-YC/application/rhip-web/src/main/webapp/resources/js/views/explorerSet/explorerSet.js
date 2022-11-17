define(function(){
	function init() {
		$(function(){
			
        $("#btnExplorerSetSave").click(function() {
        	saveExplorerSet();
        });
        
        $("input:checkbox[id^='typeInputAll']").each(function() {
        	var idValue = $(this).attr("id");
        	util.checkBoxAll(idValue,idValue.replace("All",""));
        });
       
		});
	}
	
	function saveExplorerSet() {
		var destSet = "";
		var msg = "";
		$("input:checkbox[id^='typeInputAll']").each(function() {
			var docTypeValue = $(this).val();
			setRet += docTypeValue + ":";
        	var idValue = $(this).attr("id");
        	var docTypeDesc = $(this).attr("alt");
        	var name = idValue.replace("All","");
        	var setRet = "";
        	$("input:checkbox[name='"+name+"']:checked").each(function() {
				setRet += $(this).val() + ",";
			});
			if ($.isEmpty(setRet)) {
				msg += docTypeDesc+"配置不可以为空！\r\n";
			}
			destSet += docTypeValue + ":" + setRet + "~";
        });
		if (!$.isEmpty(msg)) {
			layer.alert(msg, {icon:0,title:'提示'});
			return;
		}
		$.getJsonByUrl({
    	url : contextPath + "/explorerSet/save",
        callback:function(data){
        	layer.alert(data, {icon:0,title:'提示'});
		},
    	param:{
    		setRet:destSet
    	}
     });
	}

    return{
    	init: init
    };
});