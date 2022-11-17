<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/ehr-tag" prefix="ehr"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<jsp:include page="../../../layouts/load-js-css-resources.jsp"></jsp:include>

<script type="text/javascript" src="${pageContext.request.contextPath}/js/views/cdm/report/workStatistics/main.js"></script>
<ehr:authorize ifAnyGranted="0107,01,0307,0207">
	<c:set var="access01" value="${true}"></c:set>
</ehr:authorize>
<ehr:authorize ifAnyGranted="0407">
	<c:set var="access02" value="${true}"></c:set>
</ehr:authorize>
<div class="section">
	<%-- <ul id="tags">
		<c:if test="${access01 ==true }">
			<li class=selectTag><a href="javascript:void(0)" data-target="tagContent0"  id="cdm-work-statistics-cdMonthResult-btn">慢病月报</a></li>
			<li><a href="javascript:void(0)" data-target="tagContent1" id="cdm-work-statistics-cdQuarterlyResult-btn">慢病季报</a></li>
			<li><a href="javascript:void(0)" data-target="tagContent2"  id="cdm-work-statistics-tuMonthResult-btn">肿瘤月报</a></li>
			<li><a href="javascript:void(0)" data-target="tagContent3"  id="cdm-work-statistics-tuQuarterlyResult-btn">肿瘤季报</a></li>
			<li><a href="javascript:void(0)" data-target="tagContent4"  id="cdm-work-statistics-tumorPathologyResult-btn">病理统计</a></li>
		</c:if>
		<c:if test="${access02==true }">
			<li class=selectTag><a href="javascript:void(0)" data-target="tagContent0"  id="cdm-work-statistics-cdMonthResult-btn">慢病月报</a></li>
			<li><a href="javascript:void(0)" data-target="tagContent2"  id="cdm-work-statistics-tuMonthResult-btn">肿瘤月报</a></li>
			<li><a href="javascript:void(0)" data-target="tagContent5"  id="cdm-work-statistics-manageAndFollowupResult-btn">纳入与随访</a></li>
		</c:if>
	</ul>
	<div id="tagContent">
		<c:if test="${access01 ==true }">
			<div id="tagContent0" class="selectTag tab-content" >
				<jsp:include page="cdMonthSeason/main.jsp"></jsp:include>
			</div>
			<div id="tagContent1" class="tab-content" style="display: none;">
				<jsp:include page="cdSeason/main.jsp"></jsp:include>
			</div>
			<div id="tagContent2" class="tab-content"  style="display: none;">
				<jsp:include page="tumorMonth/main.jsp"></jsp:include>
			</div>
			<div id="tagContent3"  class="tab-content" style="display: none;">
				<jsp:include page="tumorSeason/main.jsp"></jsp:include>
			</div>
			<div id="tagContent4" class="tab-content"  style="display: none;">
				<jsp:include page="tumorPathologySearch.jsp"></jsp:include>
			</div>
		</c:if>
		<c:if test="${access02==true }">
			<div id="tagContent0" class="selectTag tab-content" >
				<jsp:include page="cdMonthSeason/main.jsp"></jsp:include>
			</div>
			<div id="tagContent2" class="tab-content"  style="display: none;">
				<jsp:include page="tumorMonth/main.jsp"></jsp:include>
			</div>
			<div id="tagContent5" class="tab-content"  style="display: none;">
				<jsp:include page="manageAndFollowupSearch.jsp"></jsp:include>
			</div>
		</c:if>
	</div> --%>
	
	
	<div class="layui-tab layui-tab-brief" lay-filter="cdmWorkStatisticsTab">
	   <ul class="layui-tab-title">
		<c:if test="${access01 ==true }">
	    <li class="layui-this">慢病月报</li>
	    <li>慢病季报</li>
	    <li>肿瘤月报</li>
	    <li>肿瘤季报</li>
	    <li>病理统计</li>
		</c:if>
		<c:if test="${access02==true }">
		<li class="layui-this">慢病月报</li>
	    <li>肿瘤月报</li>
	    <li>纳入与随访</li>
		</c:if>
	 </ul>
	<div class="layui-tab-content">
			<c:if test="${access01 ==true }">
				<input type="hidden"  id="access01" value="${access01}"/>
		       <div class="layui-tab-item layui-show" id="cdMonthSeasonTabContent">
			  	  <jsp:include page="cdMonthSeason/main.jsp"></jsp:include>
		       </div>
	   		  <div class="layui-tab-item">
	   		  	<jsp:include page="cdSeason/main.jsp"></jsp:include>
	          </div>
	          <div class="layui-tab-item">
	   		  	<jsp:include page="tumorMonth/main.jsp"></jsp:include>
	          </div>
	          <div class="layui-tab-item">
	   		  	<jsp:include page="tumorSeason/main.jsp"></jsp:include>
	          </div>
	          <div class="layui-tab-item">
	   		  	<jsp:include page="tumorPathologySearch.jsp"></jsp:include>
	          </div>
			</c:if>
			<c:if test="${access02==true }">
			  <input type="hidden"  id="access02" value="${access02}"/>
			  <div class="layui-tab-item layui-show">
			  	  <jsp:include page="cdMonthSeason/main.jsp"></jsp:include>
		       </div>
	   		  <div class="layui-tab-item">
	   		  	<jsp:include page="tumorMonth/main.jsp"></jsp:include>
	          </div>
	          <div class="layui-tab-item">
	   		  	<jsp:include page="manageAndFollowupSearch.jsp"></jsp:include>
	          </div>
		     </c:if>
	 </div>
  </div>
  
</div>

<script type="text/javascript">
//注意：选项卡 依赖 element 模块，否则无法进行功能性操作
layui.use('element', function() {
  var element = layui.element;
  element.on('tab(cdmWorkStatisticsTab)', function(data) {
	  if ($("#access01").val() == 'true') {
	      if (data.index == 0) {
	    	  
	    	  cdmWorkStatistics.cdMsReport();
	      } else if(data.index == 1) {
	    	  cdmWorkStatistics.cdSeasonReport();
	      } else if(data.index == 2) {
	    	  cdmWorkStatistics.tumorMsReport();
	      } else if(data.index == 3) {
	    	  cdmWorkStatistics.tumorSeasonReport();
	      } else if(data.index == 4) {
	    	  cdmWorkStatistics.getTumorPathologyResult();
	      }  
	  } else if ($("#access02").val() == 'true') {
		  if (data.index == 0) {
		  	  cdmWorkStatistics.cdMsReport();
	      } else if(data.index == 1) {
	    	  cdmWorkStatistics.tumorMsReport();
	      } else if(data.index == 2) {
	    	  cdmWorkStatistics.getManageAndFollowup();
	      }
	  }
  });
  
  
});
</script>

