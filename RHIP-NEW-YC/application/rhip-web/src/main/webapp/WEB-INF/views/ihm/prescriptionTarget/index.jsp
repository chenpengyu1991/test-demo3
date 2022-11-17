<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<jsp:include page="../../layouts/load-js-css-resources.jsp"></jsp:include>

<script src="${pageContext.request.contextPath}/js/views/ihm/prescriptionTarget/index.js" type="text/javascript"></script>
<!-- <div  class="sectionnoborder">
	<ul id=tagsl>
		<li class=selectTag>
			<a id="tag1" href="javascript:void(0)">处方费用</a>
		</li>
		<li>
			<a id="tag2" href="javascript:void(0)">大处方监管</a>
		</li>
	</ul>
	<div id="tagContent" style="width: 99.5%">
		<div id=tagContent1 class="selectTag"></div>
	</div>
</div> -->

<div class="toolbar">
	    	<div class="x-nav">
			      <span class="layui-breadcrumb">
			        <a href="javascript:void(0)">综合管理</a>
			        <a>
			          <cite>
			           业务监管
			          </cite></a>
			      </span>
			</div>
	    </div>

<div class="layui-tab layui-tab-card" lay-filter="businessMonitorTab" style="width: 98%;margin-left: 8px;">
    <ul class="layui-tab-title">
        <li class="layui-this">处方费用</li>
        <li>大处方监管</li>
    </ul>
    <div class="layui-tab-content">
        <div class="layui-tab-item layui-show" id="prescriptionCostDiv"></div>
        <div class="layui-tab-item" id="prescriptionMonitorDiv"></div>
    </div>
</div>

<script>
    
    layui.use('element', function () {
        var element = layui.element;
        element.on('tab(businessMonitorTab)', function (data) {
            if (data.index == 0) {
            	$("#prescriptionMonitorDiv").html("");
            	prescriptionIndex.prescriptionCost();
            } else if (data.index == 1) {
            	$("#prescriptionCostDiv").html("");
            	prescriptionIndex.unusualSearch();
            }
        });
    });
</script>