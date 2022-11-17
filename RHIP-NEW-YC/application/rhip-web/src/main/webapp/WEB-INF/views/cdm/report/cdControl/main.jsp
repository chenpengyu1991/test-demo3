<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/ehr-tag" prefix="ehr"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<jsp:include page="../../../layouts/load-js-css-resources.jsp"></jsp:include>

<script src="${pageContext.request.contextPath}/js/views/cdm/report/cdControl/main.js" type="text/javascript"></script>

<div class="section">
	<%-- <ul id="tags">
		<li class="selectTag"><a href="javascript:void(0)" id="cdm-hbp-manage-month-report-btn">高血压管理月报表</a></li>
		<li class=selectTag><a href="javascript:void(0)" id="cdm-prophylaxis-mouth-report-btn">慢病防治月报</a></li>
		<li><a href="javascript:void(0)" id="cdm-filter-quarter-report-btn">慢性病筛查季报表</a></li>
	</ul>
	<div id="tagContent">
		<div id="tagContent0" class="selectTag">
			<jsp:include page="hbpManageMonthReport/search.jsp"></jsp:include>
		</div>
		<div id="tagContent1" style="display: none;">
			<div class="repeattable">开发中...</div>
		</div>
		<div id="tagContent2" style="display: none;">
			<div class="repeattable">开发中...</div>
		</div>
	</div> --%>
	
	<div class="layui-tab layui-tab-brief" lay-filter="cdmControlTab">
	   <ul class="layui-tab-title">
	    <li class="layui-this">高血压管理月报表</li>
	 </ul>
	<div class="layui-tab-content">
		       <div class="layui-tab-item layui-show" >
			  	  <jsp:include page="hbpManageMonthReport/search.jsp"></jsp:include>
		       </div>
	 </div>
  </div>
  
</div>

<script type="text/javascript">
//注意：选项卡 依赖 element 模块，否则无法进行功能性操作
layui.use('element', function() {
  var element = layui.element;
  element.on('tab(cdmControlTab)', function(data) {
	      if (data.index == 0) {
	    	  
	    	  cdControl_main.getHbpManageMonthReport();
	      }   
  });
  
  
});
</script>
</div>
