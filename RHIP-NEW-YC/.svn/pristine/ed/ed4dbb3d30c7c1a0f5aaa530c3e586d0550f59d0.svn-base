<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr" %>
<jsp:include page="../../layouts/load-js-css-resources.jsp"></jsp:include>

<script src="${pageContext.request.contextPath}/js/views/ihm/ihmCommon.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/views/ihm/daTarget/index2.js" type="text/javascript"></script>
<%-- <script src="${pageContext.request.contextPath}/js/views/ihm/daTarget/index.js" type="text/javascript"></script> --%>
<!-- <script type="text/javascript">
	 require(['views/ihm/daTarget/index'],function(index){
		 index.load();
	 });
</script> -->

<div class="toolbar">
	    	<div class="x-nav">
			      <span class="layui-breadcrumb">
			        <a href="javascript:void(0)">综合管理</a>
			        <a href="javascript:void(0)">药品监控</a>
			        <a>
			          <cite>
			           基本药物管理
			          </cite></a>
			      </span>
			</div>
	    </div>
	    
<!-- <div  class="sectionnoborder">
    <ul id=tagsl>
	    <li class=selectTag>
	        <a id="tag1" href="javascript:void(0)">出入库</a>
	    </li>
	    <li>
	        <a id="tag2" href="javascript:void(0)">库存</a>
	    </li>
	</ul>
	<div id="tagContent" style="width: 99.5%">
	   	<div id=tagContent1 class="selectTag"></div>
	</div>
</div> -->

<div class="layui-tab layui-tab-card" lay-filter="medicineStorageTab" style="width: 98%;margin-left: 8px;">
    <ul class="layui-tab-title">
        <li class="layui-this">出入库</li>
        <li>库存</li>
    </ul>
    <div class="layui-tab-content">
        <div class="layui-tab-item layui-show" id="changeDiv"></div>
        <div class="layui-tab-item" id="storageDiv"></div>
    </div>
    
</div>

<script>
    
    layui.use('element', function () {
        var element = layui.element;
        element.on('tab(medicineStorageTab)', function (data) {
            if (data.index == 0) {
            	$("#storageDiv").html("");
            	ihmDaTarget.loadChange();
            } else if (data.index == 1) {
            	$("#changeDiv").html("");
            	ihmDaTarget.loadStorage();
            }
        });
    });
</script>