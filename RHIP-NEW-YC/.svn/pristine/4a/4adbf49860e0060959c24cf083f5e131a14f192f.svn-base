<%@page contentType="text/html;charset=UTF-8"%>
<%@page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/ehr-tag" prefix="ehr"%>
<jsp:include page="../../../layouts/load-js-css-resources.jsp"></jsp:include>

<style>
.highcharts-container tspan{font-size: 12px;}
</style>

<script src="${pageContext.request.contextPath}/js/views/ihm/ehrTarget/index.js" type="text/javascript"></script>

<div class="toolbar">
    	<div class="x-nav">
		      <span class="layui-breadcrumb">
		        <a href="javascript:void(0)">综合管理</a>
		        <a>
		          <cite>
		          人口统计
		          </cite></a>
		      </span>
		</div>
    </div>

<div class="main_PS" id="populationChart" style="width: 99%;">
	<div id="mainContent" style="width:99%;">
		<div id="inquiry" style="height:550px;width: 99%">
			<b class="jiandang">
				<%--<a id="popDis" class="view"> <b class="fenbu" id="detailSearch">查看详细</b></a>--%>
				<%--${pageContext.request.contextPath}+"/ihm/ehr/population/search"--%>
				<!-- <a class="view" onclick="populationIndexChart.viewPolulationDetail()" href="javascript:void(0);">查看详细</a> -->
				<a class="view" href="#"  onclick="populationIndexChart.viewPolulationDetail()"><i class="layui-icon">&#xe615;</i>查看详细</a>
			</b>
			<div id="chartContainer" style="height: 440px;width: 98%;padding-left: 15%;" ></div>

			<input type="hidden" id="male" value="${male}"/>
			<input type="hidden" id="female" value="${female}"/>
			<input type="hidden" id="maleList" value="${maleList}"/>
			<input type="hidden" id="femaleList" value="${femaleList}"/>
		</div>
		<!-- 这个用于清除浮动的元素应当紧跟 #mainContent div 之后，以便强制 #container div 包含所有的子浮动 --><br class="clearfloat" />
	</div>
</div>
<div id="populationDetail"></div>
