define(function(){
	$(function(){
		$("#SwitchBar").click(switchSysBar);
		$("#homeUserSpId").click(function(){
			updateUser('/user/updateSelf');
		});
		$("#homePasswordSpId").click(function(){
			updateUser('/user/updatePassword');
		});
		$("#homeMsgId").click(function(){
			updateUser('/msg/index?personal=1&');
		});
		$("#logoutId").click(logout);
		$("#logoutId").on("mouseout",MM_swapImgRestore);
		$("#logoutId").on("mouseover",function(){
			MM_swapImage('out','',contextPath + '/images/portal_out.gif',1)
		});
	});
	function init1() {
		debugger;
		initHome();
		initTree();
		initHomeReferral();
	}

	function initTree() {
		$("#browser").treeview({
			animated : "fast",
			collapsed : true,
			unique : true,
			persist : "location"
		});
	}


	function initHome() {
		try {
			var func = eval("healthBrwLayout");
			if(!$.isEmpty(func)){
				func.getHtml();
			}
		} catch (e) {
			//return "";
		}

		loadMenuContent("/home/load");
	}

	function initHomeReferral() {
		try {
			var func = eval("referralBrwLayout");
			if(!$.isEmpty(func)){
				func.getHtml();
			}
		} catch (e) {
			//return "";
		}

		loadMenuContent("/home/load");
	}
	/**
	 * 退出页面返回登陆页面
	 */
	function logout() {
		//非单点登录时候的退出
		// document.location.href=contextPath+"/access/logout";
		//单点登录时候的退出
		var serviceParam = $.param({service: logoutServeceUrl});
		var url = casLogoutUrl + "?" + serviceParam;
        $.getJsonByUrl({
            url: "/access/clearSession",
            callback: function (data) {
                window.location.href = url;
            }
        });
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

	function loadMainContent(url) {
		if(contentChanged){
			msgUtil.backConfirm(function(){
				disableChangeConfirm();
				mainContent(url);
			});
		}else{
			mainContent(url);
		}
	}

	function mainContent(url){
		hiddenUrl = url;
		$("#Main").empty();
		contentViews = new Array();
		pushMainContent(url);
	}
	function pushMainContent(url, param) {
		if(contentChanged){
			msgUtil.backConfirm(function(){
				disableChangeConfirm();
				pushContent(url, param);
			});
		}else{
			pushContent(url, param);
		}
	};
	function pushContent(url, param) {
		var contentIndex = contentViews.length;
		var viewObj = contentViews[contentIndex];
		var divId = "";
		if (viewObj && (viewObj.url == url)) {
			divId = viewObj.divId;
		} else {
			if (contentIndex > 0) {
				util.showHideDiv("mainCotent_" + (contentIndex - 1));
			}

			divId = "mainCotent_" + contentIndex;
			var newDiv = $("<div/>");
			newDiv.attr("id", divId);
			$("#Main").append(newDiv);
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
		if(contentChanged){
			msgUtil.backConfirm(function(){
				disableChangeConfirm();
				popContent();
			});
		}else{
			popContent();
		}
	};
	function popContent(){
		var viewObj = contentViews.pop();
		$("#" + viewObj.divId).remove();

		if (contentViews.length > 0) {
			util.showHideDiv("mainCotent_" + (contentViews.length-1));
		}
	}

	function refreshMainContent(url, param) {
		var contentIndex = contentViews.length - 1;
		var viewObj = contentViews[contentIndex];
		var divId = "";
		if (viewObj) {
			divId = viewObj.divId;
			var loadObj = {
					url : url,
					insertDiv : divId,
					param : param
				};
				$.urlPost(loadObj);
		}
	}

	function loadDivContent(url,loadDiv) {
		hiddenUrl = url;

		var loadObj = {
			url : url,
			insertDiv : loadDiv
		};
		$.urlPost(loadObj);
	}

	var leftShow = true;

	function switchSysBar() {
		if(leftShow){
			$("#switchPoint").addClass('open');
			$("#LeftMenu").hide();
			$("#SwitchBar").offset({left:0});
			$("#Main").offset({left:5});
			leftShow = false;
		}else{
			$("#switchPoint").removeClass('open');
			$("#LeftMenu").show();
			$("#SwitchBar").offset({left:200});
			$("#Main").offset({left:205});
			leftShow = true;
		}
	}

	function updateUser(url){
		loadMenuContent(url);
	}

	//TODO是否需要删除这个函数
	$(function(){
		$(".sidemenu a").click(function(){
			$(".sidemenu").find(".active").removeClass("active");
			$(this).parent().addClass("active");
		});
	});

	//退出系统 鼠标离开图片响应的函数
	function MM_swapImgRestore()
	{ // v3.0
		var i, x, a = document.MM_sr;
		for (i = 0; a && i < a.length && (x = a[i]) && x.oSrc; i++)
			x.src = x.oSrc;
	}

	//退出系统 鼠标在图片上响应的函数
	function MM_swapImage()
	{ // v3.0
		var i, j = 0, x, a = MM_swapImage.arguments;
		document.MM_sr = new Array;
		for (i = 0; i < (a.length - 2); i += 3)
			if ((x = MM_findObj(a[i])) != null)
			{
				document.MM_sr[j++] = x;
				if (!x.oSrc)
					x.oSrc = x.src;
				x.src = a[i + 2];
			}
	}

	function MM_findObj(n, d)
	{ // v4.01
		var p, i, x;
		if (!d)
			d = document;
		if ((p = n.indexOf("?")) > 0 && parent.frames.length)
		{
			d = parent.frames[n.substring(p + 1)].document;
			n = n.substring(0, p);
		}
		if (!(x = d[n]) && d.all)
			x = d.all[n];
		for (i = 0; !x && i < d.forms.length; i++)
			x = d.forms[i][n];
		for (i = 0; !x && d.layers && i < d.layers.length; i++)
			x = MM_findObj(n, d.layers[i].document);
		if (!x && d.getElementById)
			x = d.getElementById(n);
		return x;
	}
	window.baseLayoutLoad={};
	baseLayoutLoad.loadMenuContent=loadMenuContent;
	baseLayoutLoad.pushMainContent=pushMainContent;
	baseLayoutLoad.popMainContent=popMainContent;
	baseLayoutLoad.refreshMainContent=refreshMainContent;

	return {
		init1 : init1,
		loadMenuContent : loadMenuContent,
		pushMainContent : pushMainContent,
		popMainContent : popMainContent,
		refreshMainContent : refreshMainContent,
		loadDivContent:loadDivContent,
		loadMainContent : loadMainContent,
		reflash :reflash,
		updateUser:updateUser,
		logout: logout
	};
});