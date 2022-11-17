var vaccineDetialH = (function() {
	function loadVaccineDetailsHtml(ehrId,type) {
		var dUrl = displayUrl(type);
		var vaccineDetails = {
			url : dUrl,
			id : "displayDialog",
			height : 500,
			width : 900,
			param : {
				ehrId : ehrId
			},
			title : "浏览个人预防接种信息",
			close : null
		};
		$.dialog(vaccineDetails);
	}

	function doVaccine(ehrId,type,operate){
		var title = "查看个人预防接种信息";
		if(operate==2) {
            title = "个人疫苗注射";
		}
	    var uUrl = opUrl(type,"injectVaccine");
	    if (ehrId) {
	        /*var vaccineDetails = {
	            url : uUrl,
	            id : "displayDialog",
	            height : 600,
	            width : 900,
	            param : {
	                ehrId : ehrId,
                    operate: operate
	            },
	            title : title
	        };
	        $.dialog(vaccineDetails);*/
	    	
	    	$.post(contextPath + uUrl,
	    			{ ehrId : ehrId,
                      operate: operate
	    			}, 
	    			function(ret){
	    				layui.use(['layer'], function() {
	    					var layer = layui.layer
	    					layer.open({
	    						type: 1,
	    						id:'displayDialog',
	    						area: ['900px', '600px'],
	    						title:title,
	    						content: ret
	    					});
	    				});
	    			});
	    	
	    }
	    
	    
	}
	
	function displayUrl(type){
		if(type == "1"){
			return "/ph/rabies/details";
		}else if(type == "2"){
            return "/ph/hepatitis/details";
        }else if(type == "3"){
            return "/ph/influenza/details";
        }else if(type == "4"){
           return "/ph/pneumonia/details";
        }
	}

        //获取打印URL
    function printUrl(type){
        if(type == "1"){
            return "/ph/rabies/printDetails";
        }else if(type == "2"){
            return "/ph/hepatitis/printDetails";
        }else if(type == "3"){
            return "/ph/influenza/printDetails";
        }else if(type == "4"){
            return "/ph/pneumonia/printDetails";
        }
    }

    function deleteVaccine(ehrId,type){
        if (ehrId) {
            /*msgUtil.confirm("确认删除?",function() {
                var dUrl = opUrl(type,"delete");
                $.getJsonByUrl({
                    url : dUrl,
                    param : {
                        ehrId : ehrId
                    },
                    callback : function(data) {
                    	if(data == "1"){
                    		msgUtil.alert("删除成功");
                    		callback: mainPageH.search(1);
                    		return ;
                    	}
                    	msgUtil.alert("删除失败");
                    }
                });
            });*/
            
            
            layui.use('layer', function(){
				var layer = layui.layer;
				layer.confirm('确认删除？', {icon:2, title:'确认提示'}, function(){
	                var dUrl = opUrl(type,"delete");
	                $.getJsonByUrl({
	                    url : dUrl,
	                    param : {
	                        ehrId : ehrId
	                    },
	                    callback : function(data) {
	                    	if(data == "1"){
	                    		layer.alert("删除成功！", {icon:0,title:'提示'}, function() {
	                    			layer.closeAll();
	                    			callback: mainPageH.search(1);
	                    		});
	                    		return ;
	                    	}
	                    	layer.alert("删除失败！", {icon:0,title:'提示'});
	                    }
	                });
	            });
			});
        }
    }

    //获取删除或修改的URL
    function opUrl(type,op) {
        if (type == "1") {
            return "/ph/rabies/" + op;
        }else if(type == "2"){
            return "/ph/hepatitis/" + op;
        }else if(type == "3"){
            return "/ph/influenza/" + op;
        }else if(type == "4"){
            return "/ph/pneumonia/" + op;
        }
    }

    function modifyVaccine(ehrId,type) {
	    var uUrl = opUrl(type,"update");
	    if (ehrId) {
	       /* var vaccineDetails = {
	            url : uUrl,
	            id : "addDialog",
	            height : 650,
	            width : 950,
	            param : {
	                ehrId : ehrId
	            },
	            title : "修改个人预防接种信息"
	        };
	        $.dialog(vaccineDetails);*/
	        
	    	/*$.post(contextPath + uUrl,
	    			{ ehrId : ehrId,
	    			}, 
	    			function(ret){
	    				layui.use(['layer'], function() {
	    					var layer = layui.layer
	    					layer.open({
	    						type: 1,
	    						id:'modifyDialog',
	    						area: ['950px', '650px'],
	    						title:"修改个人预防接种信息",
	    						content: ret
	    					});
	    				});
	    			});*/
			$("#vaccineDivIdDetail").show();
			$("#vaccineDivIdSearch").hide();
			var loadHtmlByUrlOption = {
				url: uUrl,
				insertDiv: "vaccineDivIdDetail",
				param: {
					ehrId : ehrId
				}
			};
			$.loadHtmlByUrl(loadHtmlByUrlOption);
	        
	    }
	    
    };

    function VaccinePrint(ehrId,type,flag) {
    	var dUrl = contextPath + printUrl(type);
        dUrl+="?ehrId="+ehrId;
    	//狂犬病
    	if(type == '1'){
    		//flag:2/3/4,7表示加强针
    		if(!isEmpty(flag) &&(flag == '2' || flag == '3' || flag == '4' || flag == '6' || flag == '7')){
    			updatePrintFlag(ehrId,1);
    			dUrl+="&vacciantionFlag=1";
				window.open(dUrl,'newwindow', 'height=500, width=900, top=10px, left=20px, scrollbars=yes, resizable=yes,location=no, status=no');
//    			var message = '温馨提示：打印加强针请点击【确定】。打印非加强针可点击【取消】。';
//    			msgUtil.confirmAll(message,function() {
//    				updatePrintFlag(ehrId,1);
//    				dUrl+="&vacciantionFlag=1";
//    				window.open(dUrl,'newwindow', 'height=500, width=900, top=10px, left=20px, scrollbars=yes, resizable=no,location=no, status=no');
//    			},function(){
//    				updatePrintFlag(ehrId,2);
//     				dUrl+="&vacciantionFlag=0";
//     				window.open(dUrl,'newwindow', 'height=500, width=900, top=10px, left=20px, scrollbars=yes, resizable=no,location=no, status=no');
//    			}
//    			);
    		}else{
    			window.open(dUrl,'newwindow', 'height=500, width=900, top=10px, left=20px, scrollbars=yes, resizable=no,location=no, status=no');
    		}
    	}else{
    		window.open(dUrl,'newwindow', 'height=500, width=900, top=10px, left=20px, scrollbars=yes, resizable=no,location=no, status=no');
    	}
//        dUrl+="?flag=" + vacciantionFlag;
//        var vaccineDetails = {
//            url : dUrl,
//            id : "printDialog",
//            height : 500,
//            width : 900,
//            param : {
//                ehrId : ehrId
//            },
//            title : "打印浏览",
//            close : null
//        };
//        $.dialog(vaccineDetails);
//        window.open(dUrl,'newwindow', 'height=500, width=900, top=10px, left=20px, scrollbars=yes, resizable=no,location=no, status=no');
    }

    /**
     * 更新打印标志
     */
    function updatePrintFlag(ehrId,printFlag){
            $.getJsonByUrl({
                url : "/ph/rabies/updatePrintFlag",
                param : {
                    ehrId : ehrId,
                    printFlag:printFlag
                }
            });
    }
	function closeDialog() {
		$.removeDialog("displayDialog");
	}

	return {
		closeDialog : closeDialog,
		loadVaccineDetailsHtml:loadVaccineDetailsHtml,
        deleteVaccine : deleteVaccine,
        modifyVaccine : modifyVaccine,
        doVaccine : doVaccine,
        VaccinePrint :  VaccinePrint
    };
})();