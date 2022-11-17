<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/views/ehr/ehrbrowser/manage/view.js"></script>

<div class="rightnav">
	<table>
		<tr>
	     	<td class="crumbs"><div id="location" parentMenu="disease-management" childMenu="manageIndex">当前位置:&gt;&gt;疾病管理&gt;&gt;管理首页</div>
		</td>
	 	</tr>
	</table>
	<div id="con">
		<ul id="tags">
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
		<div id="tagContent">
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
	</div>
</div>