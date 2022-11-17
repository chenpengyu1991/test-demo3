<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="../layouts/load-js-css-resources.jsp"></jsp:include>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>健康档案浏览器</title>
    <META HTTP-EQUIV="Pragma" CONTENT="no-cache"></META>
    <META HTTP-EQUIV="Cache-Control" CONTENT="no-cache"></META>
    <META HTTP-EQUIV="Expires" CONTENT="0"></META>
    <meta http-equiv="X-UA-Compatible" content="IE=10; IE=9; IE=8; IE=7; IE=EDGE"></meta>
    
<script type="text/javascript">
$(function(){
    $.ajaxSetup ({
      cache: false
    });
   try {
  	 $.loadHtmlByUrl({
			url : "/ehrbrowser/healthExplore",
			insertDiv : "healthBrwDiv"
		});
   } catch (e) {
   }
  
  try {
      if(null!=healthBrwLayout && $.isFunction(healthBrwLayout.getHtml)){
          healthBrwLayout.getHtml();
      }
  } catch (e) {
  }
 
})
</script>
    <%-- <script type="text/javascript">
        var contextPath = "${pageContext.request.contextPath}";
    </script>

    <link rel = "Shortcut Icon" href="${pageContext.request.contextPath}/images/favicon.ico"></link>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/views/populace/populace.css"></link>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/redmond/jquery-ui-1.8.21.custom.css"></link>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/redmond/jquery-ui-1.11.0.custom.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/base/ehr.css"></link>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/base/forms.css"></link>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/base/page.css"></link>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/base/pop_layout.css"></link>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/multselect/jquery.multiselect.css"></link>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/select/select.css"></link>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/founderUI/skin.css"></link>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/js/autocomplete/jquery.autocomplete.css"></link>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/newbase/base.css"></link>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/newbase/forms.css"></link>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/newbase/layout.css"></link>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/js/jquery.alerts/jquery.alerts.css"></link>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/js/fineuploader/fineuploader-3.4.1.css"></link>
    <link href="${pageContext.request.contextPath}/css/views/ehrbrowser/personalRecord/cover.css" type="text/css" rel="stylesheet"></link>

   <script data-main="${pageContext.request.contextPath}/js/util/main_health_brw" src="${pageContext.request.contextPath}/js/require/require.js"></script>
   
   <link rel="stylesheet" href="${pageContext.request.contextPath}/css/x-admin/font.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/x-admin/xadmin.css">
    <script src="${pageContext.request.contextPath}/js/layui/layui.js" charset="utf-8"></script> --%>
  
<%-- 市民卡控件
<object id="CsSmkActive" classid="clsid:AE451137-38F8-4240-A9F9-6D8E182D9C16" codebase="${pageContext.request.contextPath}/activex/csSmk.cab#version=1,0,0,1" style="width:0;height:0;display:none;">
    </object>--%>

 
</head>
<body>
	<div id="healthBrwDiv" style="width: 100%;height: 100%;"></div>
</body>
</html>