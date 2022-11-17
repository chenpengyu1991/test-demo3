<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html  class="x-admin-sm">
<head>
	<meta charset="UTF-8">
	<title>基本公共卫生服务管理系统</title>
    <META HTTP-EQUIV="Pragma" CONTENT="no-cache"/>
    <META HTTP-EQUIV="Cache-Control" CONTENT="no-cache"/>
    <META HTTP-EQUIV="Expires" CONTENT="0"/>
    <meta http-equiv="X-UA-Compatible" content="IE=10; IE=9; IE=8; IE=7; IE=EDGE"/>
	<meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
    <meta http-equiv="Cache-Control" content="no-siteapp" />
    
    <link rel = "Shortcut Icon" href="${pageContext.request.contextPath}/images/favicon.ico"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/x-admin/font.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/x-admin/xadmin.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/x-admin/fontsextend.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/x-admin/fontsextend_im.css">

    <script src="${pageContext.request.contextPath}/js/layui/layui.js" charset="utf-8"></script>

    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery/jquery1.7.2.js"></script>

    <script type="text/javascript" src="${pageContext.request.contextPath}/js/x-admin/xadmin.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/x-admin/cookie.js"></script>
    <script>
        // 是否开启刷新记忆tab功能
        /* var is_remember = false; */
        var contextPath = "${pageContext.request.contextPath}";
        function viewMyInfo() {
        	/* $.post(contextPath+'/user/updateSelf',
				function(ret){
            	layui.use(['layer'], function() {
            		  var layer = layui.layer
            		  layer.open({
            			  type: 1,
            			  id:'personInfoViewDialog',
            			  area: ['450px', '365px'],
            			  title:'个人信息',
            			  content: ret
            		  });
            		});
            	}); */
        	
       		  layer.open({
       			  type: 2,
       			  id:'personInfoViewDialog',
       			  area: ['450px', '365px'],
       			  title:'个人信息',
       			  content: contextPath+'/user/updateSelf'
       		  });
        }
        
        
        function changePwd() {
        	/* $.post(contextPath+'/user/updatePassword',
				function(ret){
            	layui.use(['layer'], function() {
            		  var layer = layui.layer
            		  layer.open({
            			  type: 1,
            			  id:'changePwdDialog',
            			  area: ['350px', '275px'],
            			  title:'修改密码',
            			  content: ret
            		  });
            		});
            	});
        	 */
        	
        	 layer.open({
      			  type: 2,
      			  id:'changePwdDialog',
      			  area: ['350px', '275px'],
      			  title:'修改密码',
      			  content: contextPath+'/user/updatePassword'
      		  });
        }
        
        
        function viewNotices() {
        	// 消息红色圆点隐藏
        	$("#badgeDotId").hide();
        	layui.use(['layer'], function() {
      		  var layer = layui.layer
      		  layer.open({
      			  type: 2,
      			  id:'viewNoticeDialog',
      			  area: ['850px', '550px'],
      			  title:'消息通知',
      			  content: contextPath+'/msg/index?personal=1&'
      		  });
      		});
        	
        }
        
        
     	// 全屏切换
         function changeFullScreen() {
        	 var fullscreenElement =
                 document.fullscreenElement ||
                 document.msFullscreenElement ||
                 document.mozFullScreenElement ||
                 document.webkitFullscreenElement;
             if (fullscreenElement == null) {
                 entryFullScreen();
                 $('#FullScreen').attr('title','退出全屏');
                 $('#FullScreen').html('<i class="layui-icon layui-icon-screen-restore" style="font-size: 14px;"></i>');
             } else {
                 exitFullScreen();
                 $('#FullScreen').attr('title','全屏');
                 $('#FullScreen').html('<i class="layui-icon layui-icon-screen-full" style="font-size: 14px;"></i>');
             }
         }
         
                 
       // 进入全屏：
      function entryFullScreen() {
         var docE = document.documentElement;
         if (docE.requestFullScreen) {
             docE.requestFullScreen();
          } else if (docE.msRequestFullscreen) {
        	  docE.msRequestFullscreen();
          } else if (docE.mozRequestFullScreen) {
              docE.mozRequestFullScreen();
          } else if (docE.webkitRequestFullScreen) {
             docE.webkitRequestFullScreen();
         }
     }
        
          // 退出全屏
          function exitFullScreen() {
             var docE = document;
             if (docE.ExitFullscreen) {
                 docE.ExitFullscreen();
             } else if (docE.msExitFullscreen) {
           	  docE.msExitFullscreen();
             } else if (docE.mozCancelFullScreen) {
                 docE.mozCancelFullScreen();
             } else if (docE.webkitCancelFullScreen) {
                 docE.webkitCancelFullScreen();
             }
        }
    </script>
</head>
<body>
    <!-- 顶部开始 -->
    <div class="container">
        <div class="logo"><a href="">公共卫生信息系统</a></div>
        <div class="left_open">
            <i title="展开左侧栏" class="iconfont">&#xe699;</i>
        </div>
        <ul class="layui-nav left fast-add" lay-filter="">
         <!--  <li class="layui-nav-item">
            <a href="javascript:;">+新增</a>
            <dl class="layui-nav-child"> 二级菜单
              <dd><a onclick="x_admin_show('资讯','https://www.baidu.com')"><i class="iconfont">&#xe6a2;</i>资讯</a></dd>
              <dd><a onclick="x_admin_show('图片','https://www.baidu.com')"><i class="iconfont">&#xe6a8;</i>图片</a></dd>
               <dd><a onclick="x_admin_show('用户 最大化','https://www.baidu.com','','',true)"><i class="iconfont">&#xe6b8;</i>用户最大化</a></dd>
               <dd><a onclick="x_admin_add_to_tab('在tab打开','https://www.baidu.com',true)"><i class="iconfont">&#xe6b8;</i>在tab打开</a></dd>
            </dl>
          </li> -->
        </ul>
        <ul class="layui-nav right" lay-filter="">
          <li class="layui-nav-item">
          	<a onclick="viewNotices()" title="消息通知"><i class="layui-icon layui-icon-notice" style="font-size: 14px;"></i><span class="layui-badge-dot" id="badgeDotId"></span></a>
          </li>
          <li class="layui-nav-item">
          	<a onclick="changeFullScreen()" id="FullScreen" title="全屏"><i class="layui-icon layui-icon-screen-full" style="font-size: 14px;"></i></a>
          </li>
          <li class="layui-nav-item">
            <a href="javascript:;">${currentLoginInfo.organization.organName}&nbsp;${currentUser.name}</a>
            <dl class="layui-nav-child"> <!-- 二级菜单 -->
              <dd><a onclick="viewMyInfo()">个人信息</a></dd>
              <dd><a onclick="changePwd()">修改密码</a></dd>
                <c:if test="${currentUser.userName ne 'admin' and multiOrg}">
	              <dd><a href="${pageContext.request.contextPath}/access/chooseOrg" id="changeAccountId">切换帐号</a></dd>
                </c:if>
              <dd><a href="${pageContext.request.contextPath}/access/logout" id="logoutId">退出</a></dd>
            </dl>
          </li>
          <!-- <li class="layui-nav-item to-index"><a href="/">前台首页</a></li> -->
        </ul>
        
    </div>
    <!-- 顶部结束 -->
    <!-- 中部开始 -->
     <!-- 左侧菜单开始 -->
    <div class="left-nav">
      <div id="side-nav">
        <ul id="nav">
            <c:forEach var="menuForm" items="${menus}">

                <c:if test="${not empty menuForm.childMenuForms}">
                <li>
                    <a href="javascript:;">
                        <i style="font-size: 14px;" <c:if test="${menuForm.menu.flag eq 2}">class="layui-icon"</c:if> <c:if test="${menuForm.menu.flag eq 1}">class="icon iconfont"</c:if>>${menuForm.menu.menuClass}</i>
                        <cite style="font-size: 14px;font-weight: bolder;font-family: Microsoft YaHei;">${menuForm.menu.nameZh}</cite>
                        <i class="iconfont nav_right">&#xe697;</i>
                    </a>
                    <ul class="sub-menu">
                    <c:forEach var="childMenuForm" items="${menuForm.childMenuForms}">
                        <c:if test="${not empty childMenuForm.childMenuForms}">
                        <li>
                            <a href="javascript:;">
								<i <c:if test="${childMenuForm.menu.flag eq 2}">class="layui-icon"</c:if> <c:if test="${childMenuForm.menu.flag eq 1}">class="icon iconfont"</c:if> style="font-size: 14px;">${childMenuForm.menu.menuClass}</i>
                                <cite style="font-size: 14px;font-weight: bolder;font-family: Microsoft YaHei;">${childMenuForm.menu.nameZh}</cite>
                                <i class="iconfont nav_right">&#xe697;</i>
                            </a>
                             <ul class="sub-menu">
                                <c:forEach var="childChildMenuForm" items="${childMenuForm.childMenuForms}">
                                    <li date-refresh="1">
                                        <a _href="${pageContext.request.contextPath}${childChildMenuForm.menu.path}" title="${childChildMenuForm.menu.nameZh}" >
                                            <i class="iconfont">&#xe6a7;</i>
                                            <cite style="font-size: 14px;font-family: Microsoft YaHei;">${childChildMenuForm.menu.nameZh}</cite>
                                        </a>
                                    </li >
                                </c:forEach>
                             </ul>
                        </li>
                       </c:if>
                        <c:if test="${empty childMenuForm.childMenuForms}">
                        <li date-refresh="1">
                            <a _href="${pageContext.request.contextPath}${childMenuForm.menu.path}" >
                                <i class="iconfont">&#xe6a7;</i>
                                <cite style="font-size: 14px;font-family: Microsoft YaHei;">${childMenuForm.menu.nameZh}</cite>
                            </a>
                        </li>
                        </c:if>
                    </c:forEach>
                    </ul>
                </li>
                </c:if>
                <c:if test="${empty menuForm.childMenuForms}">
                <li>
                    <a _href="${pageContext.request.contextPath}${menuForm.menu.path}">
                        <i class="iconfont">&#xe697;</i>
                        <cite>${menuForm.menu.nameZh}</cite>
                        <i class="iconfont nav_right">&#xe697;</i>
                    </a>
                </li>
                </c:if>
            </c:forEach>

        </ul>
      </div>
    </div>
    <!-- <div class="x-slide_left"></div> -->
    <!-- 左侧菜单结束 -->
    <!-- 右侧主体开始 -->
    <div class="page-content">
        <div class="layui-tab tab" lay-filter="xbs_tab" lay-allowclose="false">
          <ul class="layui-tab-title">
            <li class="home"><i class="layui-icon">&#xe68e;</i>我的桌面</li>
          </ul>
          <div class="layui-unselect layui-form-select layui-form-selected" id="tab_right">
                <dl>
                    <dd data-type="this">关闭当前</dd>
                    <dd data-type="other">关闭其它</dd>
                    <dd data-type="all">关闭全部</dd>
                </dl>
          </div>
          <div class="layui-tab-content">
            <div class="layui-tab-item layui-show">
                <iframe src='${pageContext.request.contextPath}/home/load' frameborder="0" scrolling="yes" class="x-iframe"></iframe>
            </div>
          </div>
          <div id="tab_show"></div>
        </div>
    </div>
    <div class="page-content-bg"></div>
    <!-- 右侧主体结束 -->
    <!-- 中部结束 -->
    <!-- 底部开始 -->
    <c:if test="${saas ne 1}">
    <div class="xadmin-index">
	    <div class="footer">
	        <div class="copyright">版权所有：北大医疗信息技术有限公司 &nbsp;&nbsp;&nbsp;&nbsp;版本信息：V3.0.20210617</div>
	    </div>
    </div>
    </c:if>
    <!-- 底部结束 -->
</body>
</html>