<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN">
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%
	response.setHeader("PRagma", "No-cache");
	response.setHeader("Cache-Control", "no-cache");
	response.setDateHeader("Expires", 0);
%>

<html>
	<head>
		<title>永城市全民健康信息平台</title>
		<!-- <META HTTP-EQUIV="Pragma" CONTENT="no-cache"/>
		<META HTTP-EQUIV="Cache-Control" CONTENT="no-cache"/>
		<META HTTP-EQUIV="Expires" CONTENT="0"/> -->
		<meta http-equiv="X-UA-Compatible" content="IE=10; IE=9; IE=8; IE=7; IE=EDGE"/>
		<meta name="viewport" content="width=device-width, initial-scale=1"/>
		
		<link rel = "Shortcut Icon" href="${pageContext.request.contextPath}/images/favicon.ico"/>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/founderUI/skin.css"/>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/js/jquery.alerts/jquery.alerts.css"/>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/base.css"/>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/main.css"/>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bgstretcher.css" />

		<script type="text/javascript">
			var contextPath = "${pageContext.request.contextPath}";
		</script>
		<script src="${pageContext.request.contextPath}/js/jquery/jquery-1.7.2.min.js" type="text/javascript"></script>
		<script src="${pageContext.request.contextPath}/js/jquery/jquery-ui-1.11.0.custom.js" type="text/javascript"></script>
		<script src="${pageContext.request.contextPath}/js/jquery/artDialog.js" type="text/javascript"></script>
		<script src="${pageContext.request.contextPath}/js/jquery/artDialog.min.js" type="text/javascript"></script>
		<script src="${pageContext.request.contextPath}/js/jquery/artDialog.plugins.min.js" type="text/javascript"></script>

		<script src="${pageContext.request.contextPath}/js/util/jquery.founder.js" type="text/javascript"></script>
		<script src="${pageContext.request.contextPath}/js/util/jquery.founder.form.js" type="text/javascript"></script>
		<script src="${pageContext.request.contextPath}/js/util/jquery.founder.ajax.js" type="text/javascript"></script>
		<script src="${pageContext.request.contextPath}/js/util/idCard.js" type="text/javascript"></script>
		<script src="${pageContext.request.contextPath}/js/util/idCardUtil.js" type="text/javascript"></script>
		<script src="${pageContext.request.contextPath}/js/util/jquery.founder.select.js" type="text/javascript"></script>
		<script src="${pageContext.request.contextPath}/js/util/jquery.easy_validator.js" type="text/javascript"></script>
		<script src="${pageContext.request.contextPath}/js/jquery.alerts/jquery.alerts.js" type="text/javascript"></script>
		<script src="${pageContext.request.contextPath}/js/autocomplete/jquery.autocomplete.js" type="text/javascript"></script>
		<script src="${pageContext.request.contextPath}/js/jquery.alerts/jquery.alerts.js" type="text/javascript"></script>
		<script src="${pageContext.request.contextPath}/js/datepicker/WdatePicker.js" type="text/javascript"></script>
		<script src="${pageContext.request.contextPath}/js/util/base.js" type="text/javascript"></script>
		<script src="${pageContext.request.contextPath}/js/util/util.js" type="text/javascript"></script>
		<script src="${pageContext.request.contextPath}/js/util/getCNDate.js" type="text/javascript"></script>
		<script src="${pageContext.request.contextPath}/js/util/jquery.SuperSlide.2.1.1.js" type="text/javascript"></script>
		<script src="${pageContext.request.contextPath}/js/util/jquery.placeholder.min.js" type="text/javascript"></script>
		<script src="${pageContext.request.contextPath}/js/views/accountInfo/common.js" type="text/javascript"></script>
		<script src="${pageContext.request.contextPath}/js/views/layouts/baseLayoutLoad.js" type="text/javascript"></script>
				<!-- blockUI插件引入 -->
		<script src="${pageContext.request.contextPath}/js/util/blockUI.js" type="text/javascript"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/views/layouts/bgstretcher.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/views/layouts/appDownload.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/util/jquery.cookie.js"></script>
		<!--[if lt IE 9]>
		    <script src="http://cdn.bootcss.com/html5shiv/r29/html5.min.js"></script>
		    <script src="http://cdn.bootcss.com/placeholders/4.0.1/placeholders.jquery.js"></script>
			<link rel="stylesheet" href="${pageContext.request.contextPath}/css/lte-ie8.css" type="text/css" />
   		<![endif]-->
   		
		
	</head>
	<!-- <script type="text/javascript">
				$(function(){ $('input').placeholder(); });
			</script> -->
	<body>
	<!--online annoucement-->
    <div class="gg_full wrapfix">
		<div class="gg_fcon">
			<img class="topBanner" src="${pageContext.request.contextPath}/images/layout/onlineAnnouncement.jpg"/>
		</div>
    </div> 
 <script type="text/javascript">
	$('.topBanner').width("100%" );
	$('.topBanner').height($(document).height());
	/*online annoucement  */
	if($.cookie("isClose") != 'yes'){
		$('.gg_full').show();
		setTimeout(
				function(){
					$('.gg_fcon').slideUp('slow');
					 setTimeout(
					     function(){
					    	 $('#AndroidApp').fadeIn();
							 $('#iPhoneApp').fadeIn();
							}
					, 1000 ) 
				}
			, 2000 )
	    $.cookie("isClose",'yes',{ expires:1});		
    }
	else{
		setTimeout(
			     function(){
			    	 $('#AndroidApp').fadeIn();
					 $('#iPhoneApp').fadeIn();
					}
			, 1000 )
	}
</script>
	<!--appDownload  -->
		<%--<div id="AndroidApp"></div>
		<div id="iPhoneApp"></div>
		<div id="qrCode"></div>
		<div id="AndroidApp_img"></div>
		<div id="iPhoneApp_img"></div>
		<div id="qrCode_img"></div>
		<div id="gotop"></div>--%>
		<jsp:include page="topbar.jsp"/>
		<div align="center">
			<div id="containt">
			<tiles:insertAttribute name="header" />
			<tiles:insertAttribute name="content" />
			<tiles:insertAttribute name="footer" />
			</div>
		</div>
<script type="text/javascript">
    $(function() {
    /*header slideImg  */
	 $('#headerImg').bgStretcher({
         images: ['${pageContext.request.contextPath}/images/layout/1.jpg', 
                  '${pageContext.request.contextPath}/images/layout/2.jpg', 
                  '${pageContext.request.contextPath}/images/layout/3.jpg'
                  ],
         slideShowSpeed: 2000,
         imageWidth: 368,
         imageHeight: 184
     	});
	 
      });
</script>
</body>
</html>

