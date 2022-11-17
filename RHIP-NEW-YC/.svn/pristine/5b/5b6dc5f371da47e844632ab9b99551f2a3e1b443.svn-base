(function($) {
	var defaultlOption = {
		currentPage : 0,
		totalPages : 0,
		totalRows : 0,
		pageSize : 10,
		cssClass : "pagination mdm_page",
		contextPath : "contextPath",
		callback : function(pageIndex){}
	};

	$.fn.pagination = function(options) {
		var settings = $.getOption(defaultlOption, options);
		var _this = $(this);
		_this.empty();
		_this.attr("class", settings.cssClass);
		_this.append('<p class="left">第'+settings.currentPage+'页/共'+settings.totalPages+'页 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;共'+settings.totalRows+'条记录</p>');
		var p = $('<p class="right" />');
		_this.append(p);
		if (settings.currentPage <= 1) {
			p.append(initNoLinkButton(settings.contextPath, "page_011.gif"));
			p.append("&nbsp;");
			p.append(initNoLinkButton(settings.contextPath, "page_022.gif"));
		} else {
			p.append(initLinkButton(settings.contextPath, "page_01.gif", 1));
			p.append("&nbsp;");
			p.append(initLinkButton(settings.contextPath, "page_02.gif", settings.currentPage - 1));
		}
		p.append("&nbsp;&nbsp;");
		p.append('<font id="pagination_pageIndex">'+settings.currentPage+'</font>');
		p.append("&nbsp;&nbsp;");
		if (settings.currentPage >= settings.totalPages) {
			p.append(initNoLinkButton(settings.contextPath, "page_033.gif"));
			p.append("&nbsp;");
			p.append(initNoLinkButton(settings.contextPath, "page_044.gif"));
		} else {
			p.append(initLinkButton(settings.contextPath, "page_03.gif", settings.currentPage + 1));
			p.append("&nbsp;");
			p.append(initLinkButton(settings.contextPath, "page_04.gif", settings.totalPages));
		}
		p.append("&nbsp;");
		
		function initLinkButton(contextPath, img, pageIndex){
			var btn =  $('<a href="javascript:void(0);"><img src="'+contextPath+'/images/btn/'+img+'"></a>');
			btn.click(function(){
				settings.callback(pageIndex);
			});
			return btn;
		}
		
		function initNoLinkButton(contextPath, img){
			return '<a href="javascript:void(0);" style="cursor:default;"><img src="'+contextPath+'/images/btn/'+img+'"></a>';
		};
	};
	
	$.getOption = function(paramOption, options) {
		var object = $.extend(true, {}, paramOption);
		var settings = $.extend(true, object, options || {});
		return settings;
	};
	
})(jQuery);