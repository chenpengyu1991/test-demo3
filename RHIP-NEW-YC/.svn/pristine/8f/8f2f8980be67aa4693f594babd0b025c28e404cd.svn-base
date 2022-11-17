<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<jsp:include page="../../../layouts/load-js-css-resources.jsp"></jsp:include>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/views/cdm/report/cdmManageAnalysis/list.js"></script>
<div  class="sectionnoborder" style="margin-top: 10px;">
    <%-- <ul id=tags>
	    <li class=selectTag>
	        <a id="tag1" href="javascript:void(0)">高血压</a>
	    </li>
	    <li>
	        <a id="tag2" href="javascript:void(0)">糖尿病</a>
	    </li>

	</ul>
	<div id="tagContent">
	   	<div id=tagContent1 class="selectTag" style="height:600px;"></div>
	 	<div id="tagContent2" style='height:600px;display:none' ></div>
	</div> --%>
	
	<div class="layui-tab layui-tab-brief" lay-filter="cdmStatisticsTab">
	   <ul class="layui-tab-title">
	    <li class="layui-this">高血压</li>
	    <li>糖尿病</li>
	   </ul>
	<div class="layui-tab-content">
		  <div class="layui-tab-item layui-show" id="tagContent1">
	      </div>
   		  <div class="layui-tab-item" id="tagContent2">
          </div>
	 </div>
  </div>
    <input type="hidden" id="tag">
</div>

<script type="text/javascript">
//注意：选项卡 依赖 element 模块，否则无法进行功能性操作
layui.use('element', function() {
  var element = layui.element;
  element.on('tab(cdmStatisticsTab)', function(data) {
      if (data.index == 0) {
    	  $("#tagContent1").html("");
    	  $("#tagContent2").html("");
    	  listCdmManageAnalysis.searchHbp();
      } else if(data.index == 1) {
    	  $("#tagContent1").html("");
    	  $("#tagContent2").html("");
    	  listCdmManageAnalysis.searchDi();
      } 
  });
  
  
});
</script>
