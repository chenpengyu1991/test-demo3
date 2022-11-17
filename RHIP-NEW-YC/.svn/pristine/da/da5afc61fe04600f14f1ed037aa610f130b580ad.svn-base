<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<jsp:include page="../../../layouts/load-js-css-resources.jsp"></jsp:include>

<script src="${pageContext.request.contextPath}/js/views/ihm/medicalTarget/emr/index.js" type="text/javascript"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/views/ehrbrowser/index/main.css"/>
<div  class="sectionnoborder">
    <ul id=tagsl>
	    <li class=selectTag>
	        <a id="tag1" href="javascript:void(0)">处方查询</a>
	    </li>
	    <li>
	        <a id="tag2" href="javascript:void(0)">检查查询</a>
	    </li>
	    <li>
	        <a id="tag3" href="javascript:void(0)">检验查询</a>
	    </li>
	    <li>
	        <a id="tag4" href="javascript:void(0)">入院记录查询</a>
	    </li>
	    <li>
	        <a id="tag5" href="javascript:void(0)">出院小结查询</a>
	    </li>
	    <li>
	        <a id="tag6" href="javascript:void(0)">病案首页查询</a>
	    </li>
	</ul>
	<div id="tagContentx" style="width: 99.5%">
	   	<div id=tagContent1 class="selectTag"></div>
	</div>
</div>

<div class="layui-tab layui-tab-card" lay-filter="businessMonitorTab" style="width: 98%;margin-left: 8px;">
    <ul class="layui-tab-title">
        <li class="layui-this">处方查询</li>
        <li>检查查询</li>
        <li>检验查询</li>
        <li>入院记录查询</li>
        <li>出院小结查询</li>
        <li>病案首页查询</li>
    </ul>
    <div class="layui-tab-content">
        <div class="layui-tab-item layui-show" id="prescriptionDiv"></div>
        <div class="layui-tab-item" id="examDiv"></div>
        <div class="layui-tab-item" id="inspectionDiv"></div>
        <div class="layui-tab-item" id="inpationDiv"></div>
        <div class="layui-tab-item" id="outpationDiv"></div>
        <div class="layui-tab-item" id="medicalRecordDiv"></div>
    </div>
</div>

<script>
    
    layui.use('element', function () {
        var element = layui.element;
        element.on('tab(businessMonitorTab)', function (data) {
            if (data.index == 0) {
            	emrIndex.loadPrescriptions();
            } else if (data.index == 1) {
            	emrIndex.loadInspect();
            } else if (data.index == 2) {
            	emrIndex.loadExam();
            } else if (data.index == 3) {
            	emrIndex.loadBeHospital();
            } else if (data.index == 4) {
            	emrIndex.loadLeaveHospital();
            } else if (data.index == 5) {
            	emrIndex.loadCase();
            }
        });
    });
</script>