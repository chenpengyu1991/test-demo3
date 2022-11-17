<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<jsp:include page="../../../layouts/load-js-css-resources.jsp"></jsp:include>

<script src="${pageContext.request.contextPath}/js/views/ihm/idmTarget/epidemic/index2.js" type="text/javascript"></script>


<!-- <script type="text/javascript">
	require(['views/ihm//idmTarget/epidemic/index'],function(idmEpidemicTargetIndex) {
		idmEpidemicTargetIndex.load();
		});
</script>  -->


<!-- <div  class="sectionnoborder">
    <ul id=tagsl>
	    <li class=selectTag>
	        <a id="tag1" href="javascript:void(0)">按职业</a>
	    </li>
	    <li>
	        <a id="tag2" href="javascript:void(0)">按年龄</a>
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
			           传染病职业年龄统计
			          </cite></a>
			      </span>
			</div>
	    </div>
	    
	    
<div class="layui-tab layui-tab-card" lay-filter="ihmIdmTab" style="width: 98%;margin-left: 8px;">
    <ul class="layui-tab-title">
        <li class="layui-this">按职业</li>
        <li>按年龄</li>
    </ul>
    <div class="layui-tab-content">
        <div class="layui-tab-item layui-show" id="occupationDiv"></div>
        <div class="layui-tab-item" id="ageDiv"></div>
    </div>
    
</div>

<script>
    
    layui.use('element', function () {
        var element = layui.element;
        element.on('tab(ihmIdmTab)', function (data) {
            if (data.index == 0) {
            	$("#ageDiv").html("");
            	idmEpidemicSearch.loadOccupation();
            } else if (data.index == 1) {
            	$("#occupationDiv").html("");
            	idmEpidemicSearch.loadAge();
            }
        });
    });
</script>