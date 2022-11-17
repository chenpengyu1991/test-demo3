<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/views/ehr/ehrbrowser/manage/view.js"></script>

<div class="layui-tab layui-tab-card" lay-filter="cdmManageTab" id="basic_content_div" >
  <ul class="layui-tab-title">
  <c:if test="${brwDiseaseInfo.hbpFlag eq '2'}">
    <li class="layui-this">高血压</li>
  </c:if>
  <c:if test="${brwDiseaseInfo.diFlag eq '2'}">
    <li <c:if test="${brwDiseaseInfo.tumorFlag ne '2' && brwDiseaseInfo.strokeFlag ne '2' && brwDiseaseInfo.coronaryFlag ne '2' && brwDiseaseInfo.hbpFlag ne '2'}">class="layui-this"</c:if> >糖尿病</li>
   </c:if>
     <c:if test="${brwDiseaseInfo.coronaryFlag eq '2'}">
    <li <c:if test="${brwDiseaseInfo.tumorFlag ne '2' && brwDiseaseInfo.strokeFlag ne '2' && brwDiseaseInfo.diFlag ne '2' && brwDiseaseInfo.hbpFlag ne '2'}">class="layui-this"</c:if> >冠心病</li>
   </c:if>
     <c:if test="${brwDiseaseInfo.strokeFlag eq '2'}">
    <li <c:if test="${brwDiseaseInfo.tumorFlag ne '2' && brwDiseaseInfo.coronaryFlag ne '2' && brwDiseaseInfo.diFlag ne '2' && brwDiseaseInfo.hbpFlag ne '2'}">class="layui-this"</c:if> >脑卒中</li>
   </c:if>
     <c:if test="${brwDiseaseInfo.tumorFlag eq '2'}">
    <li <c:if test="${brwDiseaseInfo.strokeFlag ne '2' && brwDiseaseInfo.coronaryFlag ne '2' && brwDiseaseInfo.diFlag ne '2' && brwDiseaseInfo.hbpFlag ne '2'}">class="layui-this"</c:if> >肿瘤</li>
   </c:if>
  </ul>
  <div class="layui-tab-content">
    <div class="layui-tab-item layui-show" id="hbp-content" ><jsp:include page="view/hbp.jsp"></jsp:include></div>
    <div <c:if test="${brwDiseaseInfo.hbpFlag ne '2'}">class="layui-tab-item layui-show"</c:if> <c:if test="${brwDiseaseInfo.hbpFlag eq '2'}">class="layui-tab-item"</c:if>  id="di-content" ><jsp:include page="view/di.jsp"></jsp:include></div>
    <div <c:if test="${brwDiseaseInfo.diFlag ne '2'}">class="layui-tab-item layui-show"</c:if> <c:if test="${brwDiseaseInfo.diFlag eq '2'}">class="layui-tab-item"</c:if> id="coronary-content" ><jsp:include page="view/coronary.jsp"></jsp:include></div>
    <div <c:if test="${brwDiseaseInfo.coronaryFlag ne '2'}">class="layui-tab-item layui-show"</c:if> <c:if test="${brwDiseaseInfo.coronaryFlag eq '2'}">class="layui-tab-item"</c:if> id="stroke-content" ><jsp:include page="view/stroke.jsp"></jsp:include></div>
    <div <c:if test="${brwDiseaseInfo.strokeFlag ne '2'}">class="layui-tab-item layui-show"</c:if> <c:if test="${brwDiseaseInfo.strokeFlag eq '2'}">class="layui-tab-item"</c:if> id="tumor-content" ><jsp:include page="view/tumor.jsp"></jsp:include>
				<c:if test="${fn:length(brwDiseaseInfo.tumorReports)<1}">
					<jsp:include page="view/tumor-input.jsp"></jsp:include>
				</c:if></div>
  </div>
</div>

<script>
//注意：选项卡 依赖 element 模块，否则无法进行功能性操作
layui.use('element', function(){
  var element = layui.element;
//一些事件监听
  element.on('tab(cdmManageTab)', function(data){
 
  });
});
</script>

<%-- <div id="con">
	<ul id="tags" name="tags">
		<c:if test="${brwDiseaseInfo.hbpFlag eq '2'}">
			<li ><a data-target="hbp-content"  >高血压</a></li>
		</c:if>
		<c:if test="${brwDiseaseInfo.diFlag eq '2'}">
			<li ><a data-target="di-content" >糖尿病</a></li>
		</c:if>
		<c:if test="${brwDiseaseInfo.coronaryFlag eq '2'}">
			<li ><a data-target="coronary-content" >冠心病</a></li>
		</c:if>
		<c:if test="${brwDiseaseInfo.strokeFlag eq '2'}">
			<li ><a data-target="stroke-content" >脑卒中</a></li>
		</c:if>
		<c:if test="${brwDiseaseInfo.tumorFlag eq '2'}">
			<li ><a data-target="tumor-content" >肿瘤</a></li>
		</c:if>
	</ul>
	<div id="targetContent">
		<c:if test="${brwDiseaseInfo.hbpFlag eq '2'}">
			<div id="hbp-content">
				<jsp:include page="view/hbp.jsp"></jsp:include>
			</div>
		</c:if>
		<c:if test="${brwDiseaseInfo.diFlag eq '2'}">
			<div id="di-content">
				<jsp:include page="view/di.jsp"></jsp:include>
			</div>
		</c:if>
		<c:if test="${brwDiseaseInfo.coronaryFlag eq '2'}">
			<div id="coronary-content">
				<jsp:include page="view/coronary.jsp"></jsp:include>
			</div>
		</c:if>
		<c:if test="${brwDiseaseInfo.strokeFlag eq '2'}">
			<div id="stroke-content">
				<jsp:include page="view/stroke.jsp"></jsp:include>
			</div>
		</c:if>
		<c:if test="${brwDiseaseInfo.tumorFlag eq '2'}">
			<div id="tumor-content">
				<jsp:include page="view/tumor.jsp"></jsp:include>
				<c:if test="${fn:length(brwDiseaseInfo.tumorReports)<1}">
					<jsp:include page="view/tumor-input.jsp"></jsp:include>
				</c:if>
			</div>
		</c:if>
	</div>
</div> --%>