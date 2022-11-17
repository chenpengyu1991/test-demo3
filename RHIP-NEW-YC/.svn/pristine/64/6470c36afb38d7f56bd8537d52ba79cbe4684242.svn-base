<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<% 
response.setHeader("PRagma","No-cache"); 
response.setHeader("Cache-Control","no-cache"); 
response.setDateHeader("Expires", 0);
%> 
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>北大医信区域卫生信息平台</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/base/layout.css"/>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/base/page.css"/>
<link href="${pageContext.request.contextPath}/css/base/base.css" type="text/css"  rel="stylesheet" />
<link rel = "Shortcut Icon" href="${pageContext.request.contextPath}/images/favicon.ico"/>

<script src="${pageContext.request.contextPath}/js/jquery/jquery1.7.2.js" type="text/javascript"></script>	 
<script src="${pageContext.request.contextPath}/js/jquery/jquery-ui-1.8.18.custom.min.js" type="text/javascript"></script>	
<script type="text/javascript">
var path = "${pageContext.request.contextPath}";

function logout(){
    var url = "${pageContext.request.contextPath}/access/logout";
    window.location.href = url;
}

function MM_swapImgRestore() { //v3.0
  var i,x,a=document.MM_sr; for(i=0;a&&i<a.length&&(x=a[i])&&x.oSrc;i++) x.src=x.oSrc;
}
function MM_preloadImages() { //v3.0
  var d=document; if(d.images){ if(!d.MM_p) d.MM_p=new Array();
    var i,j=d.MM_p.length,a=MM_preloadImages.arguments; for(i=0; i<a.length; i++)
    if (a[i].indexOf("#")!=0){ d.MM_p[j]=new Image; d.MM_p[j++].src=a[i];}}
}

function MM_findObj(n, d) { //v4.01
  var p,i,x;  if(!d) d=document; if((p=n.indexOf("?"))>0&&parent.frames.length) {
    d=parent.frames[n.substring(p+1)].document; n=n.substring(0,p);}
  if(!(x=d[n])&&d.all) x=d.all[n]; for (i=0;!x&&i<d.forms.length;i++) x=d.forms[i][n];
  for(i=0;!x&&d.layers&&i<d.layers.length;i++) x=MM_findObj(n,d.layers[i].document);
  if(!x && d.getElementById) x=d.getElementById(n); return x;
}

function MM_swapImage() { //v3.0
  var i,j=0,x,a=MM_swapImage.arguments; document.MM_sr=new Array; for(i=0;i<(a.length-2);i+=3)
   if ((x=MM_findObj(a[i]))!=null){document.MM_sr[j++]=x; if(!x.oSrc) x.oSrc=x.src; x.src=a[i+2];}
}
//-->
</script>
</head>

<body class="twoColFixRtHdr" onload="MM_preloadImages('${pageContext.request.contextPath}/images/portal_modify.gif','${pageContext.request.contextPath}/images/portal_out.gif')">

<div id="container">
<div id="header2">
		<div id="banner2" style="position:relative;">
        <span class="portaltop"></span>
        <span class="portalrighttop"><i></i><b>欢迎您，${currentUser.name}</b></span>
        <span class="portalrightbottom"><%-- <a href="#" onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('modify','','${pageContext.request.contextPath}/images/portal_modify.gif',1)"><img src="${pageContext.request.contextPath}/images/portal_modify_a.gif" name="modify" width="75" height="20" border="0" id="modify" /></a>&nbsp;&nbsp; --%><a href="#" onclick="logout();" onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('out','','${pageContext.request.contextPath}/images/portal_out.gif',1)"><img src="${pageContext.request.contextPath}/images/portal_out_a.gif" name="out" width="90" height="28" border="0" id="out" /></a>
        </span>        
</div>
<!-- end #header -->
<!-- 这个用于清除浮动的元素应当紧跟 #mainContent div 之后，以便强制 #container div 包含所有的子浮动 -->
<br class="clearfloat" />
    <div class="portal">
        <ul class="portalmao1">
            <li class="mao"><img src="${pageContext.request.contextPath}/images/portal_mao1.png"/></li>
            <li class="no1"><a href="${pageContext.request.contextPath}/home/index" target="_blank"><img src="${pageContext.request.contextPath}/images/banner/portal_ico_01.gif"/></a></li>
            <li><a href="#"><img src="${pageContext.request.contextPath}/images/banner/portal_ico_02.gif"/></a></li>
            <li><a href="#"><img src="${pageContext.request.contextPath}/images/banner/portal_ico_03.gif"/></a></li>
            <li><a href="${pageContext.request.contextPath}/vaccinehome/index" target="_blank"><img src="${pageContext.request.contextPath}/images/banner/portal_ico_04.gif"/></a></li>
            <li><a href="#"><img src="${pageContext.request.contextPath}/images/banner/portal_ico_05.gif"/></a></li>
            <li><a href="#"><img src="${pageContext.request.contextPath}/images/banner/portal_ico_06.gif"/></a></li>
            <li><a href="#"><img src="${pageContext.request.contextPath}/images/banner/portal_ico_07.gif"/></a></li>
            <li><a href="#"><img src="${pageContext.request.contextPath}/images/banner/portal_ico_08.gif"/></a></li>
            <li><a href="#"><img src="${pageContext.request.contextPath}/images/banner/portal_ico_09.gif"/></a></li>
            <li><a href="#"><img src="${pageContext.request.contextPath}/images/banner/portal_ico_10.gif"/></a></li>
            <li><a href="#"><img src="${pageContext.request.contextPath}/images/banner/portal_ico_11.gif"/></a></li>
        </ul>
        <br class="clearfloat" /> 
        <ul class="portalmao1">
            <li class="mao"><img src="${pageContext.request.contextPath}/images/portal_mao2.png"/></li>
            <li class="no1"><a href="#"><img src="${pageContext.request.contextPath}/images/banner/portal_ico_12.gif"/></a></li>
            <li><a href="#"><img src="${pageContext.request.contextPath}/images/banner/portal_ico_13.gif"/></a></li>
          <!-- <li><a href="#"><img src="${pageContext.request.contextPath}/images/banner/portal_ico_14.gif"/></a></li> -->  
            <li><a href="#"><img src="${pageContext.request.contextPath}/images/banner/portal_ico_15.gif"/></a></li>
            <li><a href="#"><img src="${pageContext.request.contextPath}/images/banner/portal_ico_16.gif"/></a></li>
        </ul>
       <br class="clearfloat" /> 
        <ul class="portalmao1">
            <li class="mao"><img src="${pageContext.request.contextPath}/images/portal_mao3.png"/></li>
            <li class="no1"><a href="#"><img src="${pageContext.request.contextPath}/images/banner/portal_ico_17.gif"/></a></li>
            <li><a href="#"><img src="${pageContext.request.contextPath}/images/banner/portal_ico_18.gif"/></a></li>
            <li><a href="#"><img src="${pageContext.request.contextPath}/images/banner/portal_ico_19.gif"/></a></li>
            <li><a href="#"><img src="${pageContext.request.contextPath}/images/banner/portal_ico_20.gif"/></a></li>
            <li><a href="#"><img src="${pageContext.request.contextPath}/images/banner/portal_ico_21.gif"/></a></li>
        </ul>
    </div> 
</div>

</div>
</body>
</html>
