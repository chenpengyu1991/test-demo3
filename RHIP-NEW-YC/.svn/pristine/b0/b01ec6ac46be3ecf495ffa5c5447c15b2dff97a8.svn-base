<%--
  Created by IntelliJ IDEA.
  User: wang_zhou
  Date: 2015/6/17
  Time: 14:49
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html;charset=UTF-8"%>
<%@page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/ehr-tag" prefix="ehr"%>
<jsp:include page="../../layouts/load-js-css-resources.jsp"></jsp:include>

<%--<script src="${pageContext.request.contextPath}/js/views/ehr/recordHome/healthManagement/archiveManagement.js" type="text/javascript"></script>--%>
<script src="${pageContext.request.contextPath}/js/Highcharts-2.3.3/js/highcharts.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/Highcharts-2.3.3/js/modules/exporting.js" type="text/javascript"></script>
<%--<script src="${pageContext.request.contextPath}/js/views/ehr/recordHome/healthManagement/homePage.js" type="text/javascript"></script>--%>
<script src="${pageContext.request.contextPath}/js/views/ihm/doubleVis/searchChart.js" type="text/javascript"></script>

<div class="toolbar">
    	<div class="x-nav">
		      <span class="layui-breadcrumb">
		        <a href="javascript:void(0)">综合管理</a>
		        <a href="javascript:void(0)">基础资源</a>
		        <a>
		          <cite>
		          双向转诊统计
		          </cite></a>
		      </span>
		</div>
    </div>
    
<div class="main_PS" style="width: 99%;margin-top: 8px;">
    <div id="mainContent" style="width:99%;">
        <div id="inquiry" style="height:98%;width: 98%" >
            <b >
                <a class="view" onclick="doubleVis.viewDualReferralDetail()" href="javascript:void(0);">查看详细</a>
                <i class="fxk" style="padding:0;float:right;font-weight:normal;color:#4a4a4a;">
                        <span>
                            <label><input type="radio" style="margin-top:6px;" name="RadioGroup5" value="2" id="RadioGroup5_" checked/>
                                &nbsp;<i style="margin-top:0px;">当月</i></label>
                        </span>
                        <span>
                            <label><input type="radio" style="margin-top:6px;" name="RadioGroup5" value="3" id="RadioGroup5_"/>
                                &nbsp;<i style="margin-top:0px;">当年</i></label>
                        </span>
                        <span>
                            <label><input type="radio" style="margin-top:6px;" name="RadioGroup5" id="RadioGroup5_"/>
                                &nbsp;<i style="margin-top:0px;">累积</i></label>
                        </span>
                </i>
            </b>
            <div id="doubleVisOutChart" style="width: 800px;float:left"></div>
            <br>
            <div id="doubleVisInChart" style="width: 800px;float: left"></div>
        </div>
        <!-- 这个用于清除浮动的元素应当紧跟 #mainContent div 之后，以便强制 #container div 包含所有的子浮动 --><%--<br class="clearfloat" />--%>
    </div>
    <div id="dualReferralList"></div>
</div>
