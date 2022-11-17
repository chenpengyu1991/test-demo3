<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%-- <script src="${pageContext.request.contextPath}/js/views/ihm/baseTarget/hr/index.js" type="text/javascript"></script> --%>
<!-- <script type="text/javascript">
	 require(['views/ihm/baseTarget/hr/index'],function(index){
		 index.load();
	 });
</script> -->
<script src="${pageContext.request.contextPath}/js/views/ihm/baseTarget/hr/index2.js" type="text/javascript"></script>

<b class="jiandang">人力资源<a href="javascript:void(0)" style="margin-top: 3px;" class="view" id = "staffReturn"><button style="background-color: #C0C0C0;" class="btn-gray layui-btn layui-btn-xs button"><i class="layui-icon">&#xe65c;</i>返回</button></a></b>
<!-- <div  class="sectionnoborder">
    <ul id=tagsl>
	    <li class=selectTag>
	        <a id="tag1" href="javascript:void(0)">卫生人员</a>
	    </li>
	    <li>
	        <a id="tag2" href="javascript:void(0)">千人统计</a>
	    </li>
        <li>
            <a id="tag3" href="javascript:void(0)">执业职称</a>
        </li>
	</ul>
	<div id="tagContent" style="width: 99.5%">
	   	<div id=tagContent1 class="selectTag"></div>
	</div>
</div> -->

<div class="layui-tab layui-tab-card" lay-filter="hrTab" style="width: 98%;margin-left: 8px;">
    <ul class="layui-tab-title">
        <li class="layui-this">卫生人员</li>
        <li>千人统计</li>
        <li>执业职称</li>
    </ul>
    <div class="layui-tab-content">
        <div class="layui-tab-item layui-show" id="healthWorkerDiv"></div>
        <div class="layui-tab-item" id="personStatisticsDiv"></div>
        <div class="layui-tab-item" id="practiceDiv"></div>
    </div>
    
</div>

<script>
    
    layui.use('element', function () {
        var element = layui.element;
        element.on('tab(hrTab)', function (data) {
            if (data.index == 0) {
            	$("#personStatisticsDiv").html("");
            	$("#practiceDiv").html("");
            	hrIndex.loadHealth();
            } else if (data.index == 1) {
            	$("#healthWorkerDiv").html("");
            	$("#practiceDiv").html("");
            	hrIndex.loadHealthThousand();
            } else if (data.index == 2) {
            	$("#healthWorkerDiv").html("");
            	$("#personStatisticsDiv").html("");
            	hrIndex.loadPractice();
            }
        });
    });
</script>