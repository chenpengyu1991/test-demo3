
var pageUtil = {
    eventType: "pageBtnClickEvent",
    bind: function (parentId, func, type) {

        var select="#"+parentId;
        if (type) {
            $(select).on(this.eventType, type, function (event, param) {
                func(param);
            });
        } else {
            $(select).on(this.eventType, function (event, param) {
                func(param);
            });
        }

    },
    trigger: function (link, param) {
        var $link = $(link);
        $link.trigger(this.eventType, [ param]);
    },
    
    /**
     * 修改requirejs版本用到的分页中触发的函数
     */
    changePageSizeRequire: function changePageSizeRequire(selectObj,pageUrl){
    	var $selectObj = $(selectObj);
		var obj ={
				url:"/pageSet/currentPageSize",
				param:{
					pageUrl:pageUrl,
					pageSize:$selectObj.val()
				},
				callback:function(data){
					if(data == 1){
						$selectObj.trigger("pageBtnClickEvent", [1]);
					}
				}
			};
			$.getJsonByUrl(obj);
		},
	/**
	 * 普通分页标签中 改变一页显示多少条触发的函数
	 * @param selectObj
	 * @param pageUrl
	 * @param action
	 */    
    changePageSize: function changePageSize(selectObj,pageUrl,action){
		debugger;
		var obj ={
				url:"/pageSet/currentPageSize",
				param:{
					pageUrl:pageUrl,
					pageSize:$(selectObj).val()
				},
				callback:function(data){
					if(data == 1){
						var callb = eval(action);
						if (!$.isEmpty(callb)) {
							callb(1);
	                    }
					}
				}
			};
			$.getJsonByUrl(obj);
		},
			
		gotoPage : function gotoPage(obj, action, totalPages) {
				var pageNo = $(obj).prev("input").val();
//			 	var pageNo = $("#gotoPageNo").val();
		        if (!$.isEmpty(pageNo)) {
		        	if(pageNo > totalPages){
				 		pageNo = totalPages;
				 	}
		        	if(pageNo < 1){
				 		pageNo = 1;
				 	}
		        	if(! /^\d+$/.test(pageNo)){           
//		                msgUtil.alert("请输入有效页码！");
		                layui.use('layer', function() {
		           			var layer = layui.layer;
		           			layer.alert("请输入有效页码！", {icon:0,title:'提示'});
		              	});
		                return;
		            }
		        	
		            var callback = eval(action);
		            callback(pageNo);
		        }
	    },
		
		jumpPage : function jumpPage(obj, totalPages) {
			var pageNo = $(obj).prev("input").val();
	        if (!$.isEmpty(pageNo)) {
	        	if(pageNo > totalPages){
			 		pageNo = totalPages;
			 	}
	        	if(pageNo < 1){
			 		pageNo = 1;
			 	}
	        	if(! /^\d+$/.test(pageNo)){           
	                layui.use('layer', function() {
	           			var layer = layui.layer;
	           			layer.alert("请输入有效页码！", {icon:0,title:'提示'});
	              	});
	                return;
	            }
	        	pageUtil.trigger(obj, pageNo);
	        }
    }
};