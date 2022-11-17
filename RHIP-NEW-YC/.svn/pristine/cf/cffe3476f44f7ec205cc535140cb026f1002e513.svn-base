<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

 	
	<script type="text/javascript">
		var contextPath = "${pageContext.request.contextPath}";
        var casLogoutUrl="${logoutUrl}";
        var logoutServeceUrl="${logoutServeceUrl}";
		//在查询预约详细的时候使用到，用于区分患者页面的显示
		var showBack = false;
		var isJg = "";
		var showList = "";
	</script>
	
	<link rel = "Shortcut Icon" href="${pageContext.request.contextPath}/images/favicon.ico"/>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/views/populace/populace.css"/>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/redmond/jquery-ui-1.11.0.custom.css"/>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/base/ehr.css"/>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/index/index.css"/>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/base/forms.css"/>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/base/page.css"/>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/base/pop_layout.css"/>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/multselect/jquery.multiselect.css"/>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/select/select.css"/>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/founderUI/skin.css"/>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/js/autocomplete/jquery.autocomplete.css"/>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/newbase/base.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/newbase/forms.css"/>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/newbase/layout.css"/>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/js/jquery.alerts/jquery.alerts.css"/>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/js/zTree/css/zTreeStyle/zTreeStyle.css"/>
	<link href="${pageContext.request.contextPath}/css/views/ehrbrowser/personalRecord/cover.css" type="text/css" rel="stylesheet"/>
	 <link rel="stylesheet" href="${pageContext.request.contextPath}/css/x-admin/font.css">
	 <link rel="stylesheet" href="${pageContext.request.contextPath}/css/x-admin/fontsextend_arrow.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/x-admin/xadmin.css">


	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery/jquery1.7.2.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery/jquery-ui-1.11.0.custom.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery/jquery.placeholder.1.3.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery/jquery.treeview.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery/jquery.form.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery/jquery.multiselect.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery/ajaxfileupload.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery/jquery.blockUI.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/autocomplete/jquery.autocomplete.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.alerts/jquery.alerts.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/Highcharts-2.3.3/js/highcharts.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/Highcharts-2.3.3/js/modules/exporting.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/echarts/echarts.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/zTree/js/jquery.ztree.core-3.5.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/zTree/js/jquery.ztree.excheck-3.5.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/datepicker/WdatePicker.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/util/jquery.founder.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/util/jquery.founder.form.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/util/jquery.founder.page.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/util/jquery.founder.ajax.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/util/jquery.founder.export.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/util/jquery.bgiframe.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/util/load.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/util/section.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/util/idCardUtil.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/util/jquery.founder.select.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/util/jquery.easy_validator.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/util/base.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/util/pageUtil.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/util/base.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/util/util.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/util/IC.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/util/orgUtil.js"></script>
	
	<script src="${pageContext.request.contextPath}/js/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/x-admin/xadmin.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/x-admin/cookie.js"></script>


