<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<jsp:include page="../../layouts/load-js-css-resources.jsp"></jsp:include>

<script src="${pageContext.request.contextPath}/js/views/ihm/hmTarget/index.js" type="text/javascript"></script>
<!-- <div  class="sectionnoborder">
    <ul id=tagsl>
	    <li class=selectTag>
	        <a id="tag1" href="javascript:void(0)">体检分析</a>
	    </li>
	    <li>
	        <a id="tag2" href="javascript:void(0)">健康管理</a>
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
			        <a href="javascript:void(0)">疾病控制</a>
			        <a>
			          <cite>
			           老年人健康分析
			          </cite></a>
			      </span>
			</div>
	    </div>
	    
<div class="layui-tab layui-tab-card" lay-filter="elderHealthTab" style="width: 98%;margin-left: 8px;">
    <ul class="layui-tab-title">
        <li class="layui-this">体检分析</li>
        <li>健康管理</li>
    </ul>
    <div class="layui-tab-content">
        <div class="layui-tab-item layui-show" id="physicalExamDiv"></div>
        <div class="layui-tab-item" id="healthManageDiv"></div>
    </div>
    
</div>

<script>
    
    layui.use('element', function () {
        var element = layui.element;
        element.on('tab(elderHealthTab)', function (data) {
            if (data.index == 0) {
            	$("#healthManageDiv").html("");
            	idmEpidemicTargetIndex.loadTarget();
            } else if (data.index == 1) {
            	$("#physicalExamDiv").html("");
            	idmEpidemicTargetIndex.loadRate();
            }
        });
    });
</script>