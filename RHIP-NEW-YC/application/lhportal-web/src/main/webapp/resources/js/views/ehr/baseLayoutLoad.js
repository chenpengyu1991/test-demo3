
var baseLayoutLoad = (function() {
	
	$(function() {
		loadJsFun();
	});

	function loadJsFun(){
		var jsUrls = new Array();
		jsUrls.push(contextPath + "/js/jquery/jquery.treeview.js");
		jsUrls.push(contextPath + "/js/jquery/jquery-ui-1.8.21.custom.min.js");
		jsUrls.push(contextPath + "/js/jquery/jquery.form.js");
		jsUrls.push(contextPath + "/js/jquery/jquery.cookie.js");		
		jsUrls.push(contextPath + "/js/multiselect/jquery.multiselect.js");
		jsUrls.push(contextPath + "/js/util/base.js");
		jsUrls.push(contextPath + "/js/util/ajax.js");
		jsUrls.push(contextPath + "/js/datepicker/WdatePicker.js");
		jsUrls.push(contextPath + "/js/util/util.js");
		jsUrls.push(contextPath + "/js/util/jquery.founder.js");
		jsUrls.push(contextPath + "/js/util/jquery.founder.form.js");
		jsUrls.push(contextPath + "/js/util/jquery.founder.ajax.js");
		jsUrls.push(contextPath + "/js/util/jquery.bgiframe.js");
		jsUrls.push(contextPath + "/js/util/section.js");
		jsUrls.push(contextPath + "/js/util/idCardUtil.js");
		jsUrls.push(contextPath + "/js/util/jquery.easy_validator.js");
		//add for mdm
		jsUrls.push(contextPath + "/js/util/jquery.founder.page.js");
		jsUrls.push(contextPath + "/js/autocomplete/jquery.autocomplete.js");
		jsUrls.push(contextPath + "/js/jquery/ajaxfileupload.js");
		jsUrls.push(contextPath + "/js/util/jquery.placeholder.1.3.js");
		jsUrls.push(contextPath + "/js/jquery.alerts/jquery.alerts.js");
		jsUrls.push(contextPath + "/js/ueditor/editor_config.js");
		jsUrls.push(contextPath + "/js/ueditor/editor_all_min.js");
		//CSS修改到baselayot.jsp中直接引用
		
		load.pageLoad({
			jsUrls : jsUrls,
			callBack : init1
		});
	}
	
	function init1() {
		initHome();
	}
	

	function initHome() {
		$.loadHtmlByUrl({
			url : "/userSpace/ehr/" + urlType,
			insertDiv:"can"
		});
		
		$("#can").resize(function(){
			
		});
	}
	
	function resize(){
		setTimeout(function(){
			parent.changeHeight(document.body.scrollHeight);
		},500);
	}
	
	// 处理键盘事件 禁止后退键（Backspace）密码或单行、多行文本框除外
	function forbidBackSpace(e) {
		var ev = e || window.event; // 获取event对象
		var obj = ev.target || ev.srcElement; // 获取事件源
		var t = obj.type || obj.getAttribute('type'); // 获取事件源类型
		// 获取作为判断条件的事件类型
		var vReadOnly = obj.readOnly;
		var vDisabled = obj.disabled;
		// 处理undefined值情况
		vReadOnly = (vReadOnly == undefined) ? false : vReadOnly;
		vDisabled = (vDisabled == undefined) ? true : vDisabled;
		// 当敲Backspace键时，事件源类型为密码或单行、多行文本的，
		// 并且readOnly属性为true或disabled属性为true的，则退格键失效
		var flag1 = ev.keyCode == 8
				&& (t == "password" || t == "text" || t == "textarea")
				&& (vReadOnly == true || vDisabled == true);
		// 当敲Backspace键时，事件源类型非密码或单行、多行文本的，则退格键失效
		var flag2 = ev.keyCode == 8 && t != "password" && t != "text"
				&& t != "textarea";
		// 判断
		if (flag2 || flag1)
			return false;
	}
	// 禁止后退键 作用于Firefox、Opera
	document.onkeypress = forbidBackSpace;
	// 禁止后退键 作用于IE、Chrome
	document.onkeydown = forbidBackSpace;

	function loadMenuContent(url) {
		//goTop();
		loadMainContent(url);
	}
	
	var hiddenUrl = "";

	function reflash(){
		if(hiddenUrl != ""){
			loadMenuContent(hiddenUrl);
		}else{
			window.location.reload();
		}
	}
	
	var contentViews = new Array();
	
	function loadMainContent(url,param) {
		hiddenUrl = url;
		$("#RightContent").empty();
		contentViews = new Array();
		pushMainContent(url,param);
	}

	function pushMainContent(url, param) {
		var contentIndex = contentViews.length;
		var viewObj = contentViews[contentIndex];
		var divId = "";
		if (viewObj && (viewObj.url == url)) {
			divId = viewObj.divId;
		} else {
			if (contentIndex > 0) {
				baseLayoutLoad.showHideDiv("mainCotent_" + (contentIndex - 1));
			}
			
			divId = "mainCotent_" + contentIndex;
			var newDiv = $("<div/>");
			newDiv.attr("id", divId);
			$("#RightContent").append(newDiv);
			contentViews[contentIndex] = {url:url, divId:divId};
		}
		//alert(divId);
		var loadObj = {
			url : url,
			insertDiv : divId,
			param : param
		};
		
		$.urlPost(loadObj);
	};

	function popMainContent() {
		var viewObj = contentViews.pop();
		$("#" + viewObj.divId).remove();
		
		if (contentViews.length > 0) {
			baseLayoutLoad.showHideDiv("mainCotent_" + (contentViews.length-1));
		}
	};
	
	function loadDivContent(url,loadDiv) {
		hiddenUrl = url;
		
		var loadObj = {
			url : url,
			insertDiv : loadDiv
		};
		$.urlPost(loadObj);
	}

	function showHideDiv(divId){
		var divShow = $("#"+divId).css("display");
		if(divShow == "none"){
			$("#"+divId).css("display","block");
		}else{
			$("#"+divId).css("display","none");
		}
	}
	
	var leftShow = true;
	
	function switchSysBar() {
		if(leftShow){
			$("#LeftMenu").hide();
			$("#SwitchBar").offset({left:0});
			$("#Main").offset({left:5});
			leftShow = false;
		}else{
			$("#LeftMenu").show();
			$("#SwitchBar").offset({left:200});
			$("#Main").offset({left:205});
			leftShow = true;
		}
	}

	
	return {
		loadMenuContent : loadMenuContent,
		pushMainContent : pushMainContent,
		popMainContent : popMainContent,
		loadDivContent:loadDivContent,
		loadMainContent : loadMainContent,
		showHideDiv:showHideDiv,
		reflash :reflash,
		switchSysBar:switchSysBar,
		resize:resize
	};
})();