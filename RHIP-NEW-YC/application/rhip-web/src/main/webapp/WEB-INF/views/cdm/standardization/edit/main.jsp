<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<script src="${pageContext.request.contextPath}/js/views/cdm/standardization/input/save.js" type="text/javascript"></script>
<div class="toolbar">
	<a href="javascript:void(0)" id="health-card-back-btn"><b class="fanhui">返回</b></a>
	<a href="javascript:void(0);" id="health-card-save-btn"><b class="tijiao" >提交</b></a>
</div>
<div id="health-card-main">
	<form id="health-card-form">
	<input type="hidden" id="disPersonId"   name="personId"  value="${diseaseInfo.personInfo.id}" > 
	<input type="hidden" id="disid"   name="id" value="${diseaseInfo.id}" > 
		<div class="postcontent">
			<i class="popno">慢病管理</i>
			<div class="postdiv">
				<div id="person-info"><jsp:include page="../input/personInfo.jsp"></jsp:include>
				</div>
				<div id="dis-select-box">
					<fieldset>
						<legend>慢病</legend>
						<input type="checkbox" value="2" name="hbpFlag" ${diseaseInfo.hbpFlag eq '2' ?'checked=true':''}><label>高血压 </label> 
						<input type="checkbox" value="2" name="diFlag" ${diseaseInfo.diFlag eq '2' ?'checked=true':''} >糖尿病
						<input type="checkbox" value="2" name="coronaryFlag" ${diseaseInfo.coronaryFlag eq '2' ?'checked=true':''}>冠心病 
						<input type="checkbox" value="2" name="strokeFlag" ${diseaseInfo.strokeFlag eq '2' ?'checked=true':''} >脑卒中 
						<input type="checkbox" value="2" name="tumorFlag" ${diseaseInfo.tumorFlag eq '2' ?'checked=true':''}>肿瘤
					</fieldset>
				</div>
				<div id="dis-info">
					<div id="hbpFlag-box" class="${diseaseInfo.hbpFlag eq '2'?'show':'hide'}">
						<jsp:include page="../input/hbp.jsp"></jsp:include>
					</div>
					<div id="diFlag-box" class="${diseaseInfo.diFlag eq '2'?'show':'hide'}">
						<jsp:include page="../input/di.jsp"></jsp:include>
					</div>
					<div id="coronaryFlag-box" class="${diseaseInfo.coronaryFlag eq '2'?'show':'hide'}">
						<jsp:include page="../input/coronary.jsp"></jsp:include>
					</div>
					<div id="strokeFlag-box" class="${diseaseInfo.strokeFlag eq '2'?'show':'hide'}">
						<jsp:include page="../input/stroke.jsp"></jsp:include>
					</div>
					<div id="tumorFlag-box" class="${diseaseInfo.tumorFlag eq '2'?'show':'hide'}">
						<jsp:include page="../input/tumor.jsp"></jsp:include>
					</div>
				</div>
				<div id="phyexam-info"></div>
				<div id="input-info"></div>
			</div>
		</div>
	</form>
</div>
