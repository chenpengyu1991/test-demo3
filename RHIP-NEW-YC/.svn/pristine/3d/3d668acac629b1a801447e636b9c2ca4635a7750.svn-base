var loadingSource = "<span><img src='" + contextPath + "/images/loading.gif' style='vertical-align:top;'/></span>";

String.prototype.connect = function(value, connector) {
	if (value == null || value == "") {
		return this;
	}
	if (this == "") {
		return value;
	}
	if (connector == null || connector == "") {
		connector = "";
	}
	return this + connector + value;
};


Date.prototype.pattern=function(fmt) {     
    var o = {     
    "M+" : this.getMonth()+1, //月份     
    "d+" : this.getDate(), //日     
    "h+" : this.getHours()%12 == 0 ? 12 : this.getHours()%12, //小时     
    "H+" : this.getHours(), //小时     
    "m+" : this.getMinutes(), //分     
    "s+" : this.getSeconds(), //秒     
    "q+" : Math.floor((this.getMonth()+3)/3), //季度     
    "S" : this.getMilliseconds() //毫秒     
    };     
    var week = {     
    "0" : "/u65e5",     
    "1" : "/u4e00",     
    "2" : "/u4e8c",     
    "3" : "/u4e09",     
    "4" : "/u56db",     
    "5" : "/u4e94",     
    "6" : "/u516d"    
    };     
    if(/(y+)/.test(fmt)){     
        fmt=fmt.replace(RegExp.$1, (this.getFullYear()+"").substr(4 - RegExp.$1.length));     
    }     
    if(/(E+)/.test(fmt)){     
        fmt=fmt.replace(RegExp.$1, ((RegExp.$1.length>1) ? (RegExp.$1.length>2 ? "/u661f/u671f" : "/u5468") : "")+week[this.getDay()+""]);     
    }     
    for(var k in o){     
        if(new RegExp("("+ k +")").test(fmt)){     
            fmt = fmt.replace(RegExp.$1, (RegExp.$1.length==1) ? (o[k]) : (("00"+ o[k]).substr((""+ o[k]).length)));     
        }     
    }     
    return fmt;     
};

var message = {
	enterErrorMsg:"请先暂存基本信息"
};


var util = (function() {
	///参数1为要全选或反选的chkBox的chkRef属性，
	//参数2为当前的checkBox的ID
	function checkBoxAll(chk,chkRef) {
		$("#" + chk).click(function (){
			var checked = $(this).attr("checked");

			if (checked != "checked") {
				checked = false;
			}

			$("input[chkRef=" + chkRef + "]").each(function() {
				$(this).attr("checked", checked);
			});
		});

		$("input[chkRef=" + chkRef + "]").each(function() {
			$(this).click(function(){
				var checked = "checked";
				$("input[chkRef=" + chkRef + "]").each(function() {
					var checked1 = $(this).attr("checked");
					if(checked1 != "checked"){
						checked = false;
					}
				});
				$("#" + chk).attr("checked", checked);
			});
		});
	}

    function clickShowText(obj,textId) {     	
        if($(obj).attr("checked") == "checked") {
            $("#"+textId).show();
           // $("#"+textId).animate({ width:"60%"}, 1000 );        
        } else {
            $("#"+textId).hide();
          //  $("#"+textId).animate({ width:"60%"}, 1000 );
            $("#"+textId).val("").attr("value","");
            $("#"+textId + " input[type='text']").attr("value","");
        }
    }

    function clickHideText(obj,textId) {
            $("#"+textId).hide();
            //  $("#"+textId).animate({ width:"60%"}, 1000 );
             $("#"+textId).attr("value","");
             $("#"+textId + " input[type='text']").attr("value","");
    }

   function clickShowTable(obj,tableId,textId) {	   	   	   
       if($(obj).attr("checked") == "checked") {   
    		   $("#"+textId).hide();   	       
    	       $("#"+textId).val("").attr("value","");
    	       $("#"+textId + " input[type='text']").attr("value","");
    	       if("ttb7" == tableId){
    	    	   $("#ttb3").hide();
        	       $("#ttb4").hide();
        	       $("#ttb5").hide();
    	       }    	       
    	       $("#"+tableId).show();
       } else {
           $("#"+tableId).hide();
           //  $("#"+textId).animate({ width:"60%"}, 1000 );
           $("#"+tableId).val("").attr("value","");
           $("#"+tableId + " input[type='text']").attr("value","");
       }
           // $("#"+textId).animate({ width:"60%"}, 1000 );
   }

   function clickHideTable(obj,tableId) {
	   $("#"+tableId).hide();
	   $("#"+tableId + " input").each(function(){
		   $(this).attr("value","");
	   });	 
	   if("ttb22" == tableId){		
		   $("#"+tableId+ " input[type='radio']").each(function(){
	    	   $(this).removeAttr("checked");
	       });
		   for(var i=1;i<=5;i++){
			   $("#dicList"+i).get(0).selectedIndex=0;
		   }	
	   }	  
       $("#"+tableId+ " input[type='checkbox']").each(function(){
           $(this).removeAttr("checked");
       });
       $("#"+tableId+" input[name=]").val();     
       
   }
   function formatOperateTime(operateTime) {
	   var ret = "";
	   if (operateTime && operateTime.length >= 8) {
		   ret += operateTime.substr(0,4);
		   ret += "/";
		   ret += operateTime.substr(4,2);
		   ret += "/";
		   ret += operateTime.substr(6,2);
		   if (operateTime.length >= 14) {
			   ret += " ";
			   ret += operateTime.substr(8,2);
			   ret += ":";
			   ret += operateTime.substr(10,2);
			   ret += ":";
			   ret += operateTime.substr(12,2);
		   }
	   } else {
		   ret = operateTime;
	   }
	   return ret;
   }
   
	function reset(formId) {
	    $("#"+formId).find("input:text").val("");
	    $("#"+formId).find("input:radio").val("");
	    $("#"+formId).find("input:checkbox").val("");
	    $("#"+formId).find("select").val("");
	}
	
	function showLog(msg) {
		if (window.console) {
			if ($.type(msg) === "object") {
				console.error("debug info: %o", dump_obj(msg));
			} else {
				console.error("debug info: %o", msg);
			}
		}
	}
	
	function dump_obj(myObject) {  
		var s = "";
		var child = null;
		for (var property in myObject) {
			child = myObject[property];
			if (child instanceof Array) {
				for (var index in child) {
					s += dump_obj(child[index]);
				}
			} else if (child instanceof Object) {
				s += dump_obj(child);
			} else {
				s += "\n " + property + ": " + child;
			}
		}
		return s;
	}
	
	function toggle(obj,tableId) {
		$(obj).toggleClass("ico-top");
		$(obj).toggleClass("ico-bottom");
		$("#" + tableId).toggle();
	}
	
	function cloneJsonObj(jsonObj) {
		var  buf;
		 if  (jsonObj  instanceof  Array) {   
	        buf = [];   
	        var  i = jsonObj.length;   
	        while  (i--) {   
	            buf[i] = cloneJsonObj(jsonObj[i]);   
	        }   
	        return  buf;   
    	} else   if  (jsonObj  instanceof  Object) {   
		        buf = {};   
		        for  ( var  k  in  jsonObj) {   
		            buf[k] = cloneJsonObj(jsonObj[k]);   
		        }   
       	 	return  buf;   
    	} else {
    		return  jsonObj; 
    	}
	}


	return {
		toggle : toggle,
		showLog : showLog,
		dump_obj : dump_obj,
		reset : reset,
		formatOperateTime : formatOperateTime,
		checkBoxAll : checkBoxAll,
        clickShowText : clickShowText,
        clickHideText : clickHideText,
        clickShowTable : clickShowTable,
        clickHideTable : clickHideTable,
        cloneJsonObj : cloneJsonObj
	};
})();