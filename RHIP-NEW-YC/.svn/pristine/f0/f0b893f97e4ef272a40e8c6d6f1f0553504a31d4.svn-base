(function($) {
	var requestCahce = new Array;
	
	//参数
	var loadHtmlByUrlOption = {
		url : "",
		param : null,
		checkRepeat : true,
		insertDiv : "",
		//成功或失败时显示消息的DIV
		errorDiv: "msgError",
		okDiv:"msgOK",
		wait:false
	};

	$.loadHtmlByUrl = function(options) {
		var settings = $.getOption(loadHtmlByUrlOption, options);
		settings.retType = "html";
		$.urlPost(settings);
	};

	var getJsonByUrlOption = {
		url : "",
		param : null,
		checkRepeat : true,
		callback : null,
		errorDiv: "msgError",
		okDiv:"msgOK",
		wait:false
	};

	$.getJsonByUrl = function(options) {
		var settings = $.getOption(getJsonByUrlOption, options);
		settings.retType = "json";
		$.urlPost(settings);
	};

	//
	var submitFormLoadHtmlOption = {
		url : "",
		param : null,
		//返回数据插入的Div的ID
		insertDiv : "",
		errorDiv: "msgError",
		okDiv:"msgOK",
		wait:false
	};
	
	$.fn.submitFormLoadHtml = function(options) {
		var settings = $.getOption(submitFormLoadHtmlOption, options);
		settings.retType = "html";
		$(this).formPost(settings);
	};

	var submitFormGetJsonOption = {
		url : "",
		param : null,
		insertDiv : "",
		//返回数据调用函数
		callback : null,
		errorDiv: "msgError",
		okDiv:"msgOK",
		wait:false
	};
	
	$.fn.submitFormGetJson = function(options) {
		var settings = $.getOption(submitFormGetJsonOption, options);
		settings.retType = "json";
		$(this).formPost(settings);
	};

	//使用form进行提交时传递的参数
	var formOption = {
		url : "",
		param : null,
		callback : null,
		//返回的数据类型，默认为html
		retType : "html",
		//返回数据插入的Div的ID
		insertDiv : "",
		//进行验证时的表达式
		validate : null,
		errorDiv: "msgError",
		okDiv:"msgOK",
		//验证失败调用的方法
		fail : null,
		wait:false
	};

	$.fn.formPost = function(options) {
		this.fromTrim();
		var settings = $.getOption(formOption, options);
		settings.param = getPostData(this);
		$.urlPost(settings);
		
		///获取表单数据
		function getPostData(form) {
			var postData = $(form).serializeObject();
			for (prop in settings.param) {
				postData[prop] = settings.param[prop];
			}
			return postData;
		}
	};

	//不使用form进行提交时传递的参数
	var urlOption = {
		url : "",
		callback : null,
		retType : "html",
		insertDiv : "",
		param : null,
		async : true,
		checkRepeat:true,
		errorDiv: "msgError",
		okDiv:"msgOK",
		wait:false
	};

	$.urlPost = function(options) {
		var settings = $.getOption(urlOption, options);
		if (settings.checkRepeat && !checkCahce(settings.url)) {
			return;
		}
		var ajaxParam = {
			type : 'POST',
			url : getUrl(settings),
			data : settings.param,
			success : callback,
			async : settings.async,
			complete : complete,
			error: function(XMLHttpRequest, textStatus, errorThrown){
				if(XMLHttpRequest.status != '403'){
					errorHandler(XMLHttpRequest.responseText);
				}
			},
			dataType : "html"
		};
		hiddenDiv();
		insertDivHtml(loadingSource);
		
		if(settings.wait){
			$.blockUI({ 
	            centerY: 0, 
	            css: { top: '10px', left: '', right: '10px'} ,
	            overlayCSS:  {
					backgroundColor:'#fff'
				}
	        }); 
		}
		
		$.ajax(ajaxParam);
		function complete(xhr, ts) {
			if(settings.wait){
				$.unblockUI();
			}
			
			if(xhr.status == "500"){
				if(!$.isEmpty(settings.callBack)){
					settings.callback(-1);
				}
			}
			if (xhr.status == "403") {
				//window.location.reload();
				//return true;
                //由项目全局处理,禁止自动刷新,造成浏览器无限循环加载问题 liu.k 2014年4月23日 14:52:03
			}
			popCahce(settings.url);
		}

		//处理出错信息
		function errorHandler(text){
			if($.isEmpty(text)){
				return;
			}
//			if(text.indexOf("JAVA:") >= 0){
//				msgUtil.alert(text);
//				return;
//			}
			layui.use('layer', function() {
       			var layer = layui.layer;
       			layer.alert("系统数据异常！", {icon:0,title:'提示'});
          	});
//			msgUtil.alert("系统数据异常！");
		}
		
		function callback(data, textStatus, jqXHR) {
			data = getJsonData(data);
			if($.isEmpty(data)){
				successFun(data);
				return;
			}
			validateMsgHandler(data);
		}
		
		///处理带验证的返回
		function validateMsgHandler(data){
			if(data.status == "1"){
				showMsg(data.msg,settings.okDiv);
			}else if(data.status == "0"){
				showMsg(data.msg,settings.errorDiv);
			}else{
				successFun(data);
			}
		}
		
		///jquery，ajax中的Json转换有BUG加此方法
		function getJsonData(data){
			var jsonData = data;
			try{
				jsonData = $.parseJSON(data);
			}catch(e){
				
			}
			return jsonData;
		}

		function successFun(data){
			insertDivHtml(data);
			var callBack = settings.callback;
			if (!$.isEmpty(callBack)) {
				callBack(data);
			}
		}
		
		///显示提示信息
		function showMsg(error,divId){
			if($.isEmpty(error)){
				return;
			}
			var errorDiv = "#" + divId;
			$(errorDiv).html("");
			var errArr = error.toString().split("\n");
			var elen = errArr.length;
			for(var i = 0 ; i < elen ; i++){
				$(errorDiv).append(errArr[i]);
				if(i < elen - 1){
					$(errorDiv).append("<br/>");
				}
			}
			$(errorDiv).show();
		}
		//隐藏errorDiv
		//加载Html
		function insertDivHtml(data) {
			var retType = settings.retType;
			var insertDiv = settings.insertDiv;
			if (!$.isEmpty(insertDiv) && retType == "html") {
				oldHtml = $("#" + insertDiv).html();
				$("#" + insertDiv).html(data);
				$.trAddClass();
			}
		}
		
		function hiddenDiv(){
			var errorDiv = "#" + settings.errorDiv;
			var okDiv = "#" + settings.okDiv;
			$(errorDiv).hide();
			$(okDiv).hide();
		}
	};
	

	//dialog参数
	var dialogOption = {
		url : "",
		param : null,
		title : "健康档案",
		height : 450,
		width : 850,
		close : null,
		move : true,
		showClose : true
	};
	
	$.removeDialog = function(dialogId) {
		$("#overlay" + dialogId).remove();
		$("#" + dialogId).remove();
		hiddenDialog();
	};
	
	function hiddenDialog(){
		var hasDialog = true;
		$("body").has(".doverlay").each(function(){
			hasDialog = false;
		});
		if(hasDialog){
			IE6Select(true);
		}
	}
	
	//showFlag设置显示还是隐藏
	//true为显示，false
	//目前系统不兼容ie6
	function IE6Select(showFlag){
		/*if ( !$.browser.msie ){
			return ; 
		}
		if( $.browser.version != '6.0'){
			return ;
		}
		if(showFlag){
			$("select").show();
		}else{
			$("select").hide();
		}*/
	}
	
	$.dialog = function(option){
		var settings = $.getOption(dialogOption, option);
		var dialogId = getDialogId();
		var maxZIndex = $.maxZIndex();
		var overlayZIndex = maxZIndex + 1;
		var divZIndex = overlayZIndex + 1;
		var doverlayId = "overlay" + dialogId;
		var contentId = "content" + dialogId;
		
		showModal();
		showDiv();
		setPosition();
		loadUrl();
		dialogMove();
		
		var dragging = false;
		var iX, iY;
		
		$("#" + dialogId).focus();
		
		//处理移动
		function dialogMove(){
			if(!settings.move){
				return false;
			}
			var titleId = "#title" + dialogId;
			$(titleId).mousedown(function(e){
				dragging = true;
				iX = e.clientX - $("#"+dialogId).offset().left;
				iY = e.clientY - $("#"+dialogId).offset().top;
				this.setCapture && this.setCapture();
				$(document).mousemove(moveFun);
				return false;
			});
			$(titleId).mouseup(function(e){
				dragging = false;
				//修复chrome下报js异常的问题
				var $target = $(titleId)[0];
				if($.isFunction($target.releaseCapture))
                    $target.releaseCapture();
				e.cancelBubble = true;
				$(document).unbind("mousemove",moveFun);
			});
			
			function moveFun(e){
				if (dragging) {
				   var e1 = e || window.event;
				   var oX = e1.clientX - iX;
				   var oY = e1.clientY - iY;
				   if(oY<0){
					   oY = 0;
				   }
				   if(oX<0){
					   oX = 0;
				   }
				   var maxTop = window.screen.availHeight - settings.height;
				   if(oY > maxTop){
					   oY = maxTop;
				   }
				   var maxLeft = window.screen.availWidth - settings.width;
				   if(oX > maxLeft){
					   oX = maxLeft;
				   }
				   $("#"+dialogId).css({"left":oX + "px", "top":oY + "px"});
				   return false;
			   }
			}
		}
		
		function getDialogId(){
			if($.isEmpty(settings.id)){
				return "dialog" + parseInt(Math.random()*10000000);
			}
			return settings.id;
		}
		
		function showDiv(){
			IE6Select(false);
			$("body").append(getDivHtml());
			$("#" + dialogId).width(settings.width);
			$("#" + dialogId).height(settings.height);
			//$("#title"+ dialogId).width(settings.width - 50);
			//$("#left"+ dialogId).width(10);
			
			if(!settings.showClose){
				$("#close" + dialogId).hide();
			}
			
			$("#close" + dialogId).click(function(){
				closeFunction();
			});
			
			$("#close" + dialogId).mouseover(function(){
				$(this).removeClass("close1").addClass("close2");
			});
			
			$("#close" + dialogId).mouseout(function(){
				$(this).removeClass("close2").addClass("close1");
			});
		}
		
		function setPosition(){
			var dialogDiv = $("#" + dialogId);
			var divLeft = ($(window).width() - $(dialogDiv).width())/2;
			var divTop = ($(window).height() - $(dialogDiv).height())/2;
			if(divTop < 0){
				divTop = 0;
			}
			divTop += $(document).scrollTop();
			divLeft += $(document).scrollLeft();
			$(dialogDiv).show();
			$(dialogDiv).css("left",divLeft);
			$(dialogDiv).css("top",divTop);
		}
		
		function closeFunction(){
			$("#overlay" + dialogId).remove();
			$("#" + dialogId).remove();
			if(!$.isEmpty(settings.close)){
				settings.close();
			}
			hiddenDialog();
		}
		
		function loadUrl(){
			if($.isEmpty(settings.url)){
				return;
			}
			var urlPostOption = {
				url : settings.url,
				retType : "html",
				insertDiv : "content" + dialogId,
				param : settings.param,
				checkRepeat: false,
				callback:function(){//0153599: 【健康档案】健康档案第一页，第二页无法下拉
                    // $("#" + contentId).height(settings.height - 43);
                    //0161778: 【精神障碍患者管理】新增线索登记-精神疾病线索调查问卷样式
					if(contentId=="contentcluesDialog" ){
                        $("#" + contentId).height(settings.height - 43);
					}
				}
			};
			$.urlPost(urlPostOption);
		}
		
		function showModal(){
			//$("html").css("overflow-x","hidden");
			$("body").append("<div id='" + doverlayId + "' class='doverlay' style='width:100%;height:100%;z-index:" + overlayZIndex + "'></div>");
			setSize();
			$(window).resize(function(){
				setSize();
			});
			function setSize(){
				$("#" + doverlayId).width($(document).width());
				$("#" + doverlayId).height($(document).height());
			}
		}
		
		function getDivHtml(){
			var divHtml = '<div id="' + dialogId + '" class="dialog" style="z-index:' + divZIndex + '">';
			divHtml += '<div class="dialogtitle">';
			divHtml += '<i id="title' + dialogId + '">' + settings.title + '</i>';
			divHtml += '<s id="close' + dialogId + '" onclick="javascript:void(0)">&nbsp;</s>';
			divHtml += '</div>';
			divHtml += '<div id="' + contentId + '" class="contentDiv" ></div>';
			divHtml += '</div>';
			return divHtml;
		}
	};
	
	$.maxZIndex = function(){
		var maxZ = Math.max.apply(null, $.map($('body > *'), function(e, n) {
			if ($(e).attr("class") == 'dialog'){
				var zindex = parseInt($(e).css('z-index'));
				if(zindex < 1 || zindex == '-Infinity' || zindex == 1970000 || zindex == 99999){//日期控件的Zindex
					zindex = 1;
				}
				return zindex;
			}
		}));
		if(maxZ < 0 || maxZ == '-Infinity'){
			maxZ = 100;
		}
		return maxZ;
	};
	
	$.getOption = function(paramOption, options) {
		var object = $.extend(true, {}, paramOption);
		var settings = $.extend(true, object, options || {});
		return settings;
	};

	function getUrl(settings) {
		var url = settings.url;
		if ($.isEmpty(url)) {
			return "";
		}
		url = url.connect("date=" + new Date().getMilliseconds(), "?");
		if(contextPath != null && contextPath != undefined){
			var k = url.substring(0,contextPath.length);
			if(k != contextPath){
				url = contextPath + url;
			}
		}
		return url;
	}

	function checkCahce(url) {
		for ( var i = 0; i < requestCahce.length; i++) {
			var ca = requestCahce[i];
			if (ca == url) {
				return false;
			}
		}
		requestCahce.push(url);
		return true;
	}

	function popCahce(url) {
		var cahceArray = new Array;
		for ( var i = 0; i < requestCahce.length; i++) {
			var ca = requestCahce[i];
			if (ca != url) {
				cahceArray.push(ca);
			}
		}
		requestCahce = cahceArray;
	}
})(jQuery);