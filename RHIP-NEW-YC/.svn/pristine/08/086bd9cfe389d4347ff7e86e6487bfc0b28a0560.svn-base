
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
		var obj ={
				url:"/pageSet/currentPageSize",
				param:{
					pageUrl:pageUrl,
					pageSize:$(selectObj).val()
				},
				callback:function(data){
					if(data == 1){
						var callback = eval(action);
						callback(1);
					}
				}
			};
			$.getJsonByUrl(obj);
		}
};