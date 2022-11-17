<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<script src="${pageContext.request.contextPath}/js/views/cdm/standardization/input/add.js" type="text/javascript"></script>
<script>
    function returnPersonRecord(){
        $("#beforeSaveDiv").show();
        $("#mbglk").hide();
    }
</script>
<div id="toolbar" class="toolbar" style="margin-top: 10px;">
	<a href="${personRecordFlag==1?'javascript:returnPersonRecord();':'javascript:void(0);'}" id="health-card-back-btn"><button class="btn-gray layui-btn layui-btn-sm button"><i class="layui-icon">&#xe65c;</i>返回</button></a>
	<a href="javascript:void(0)" id="health-card-save-btn"><button class="layui-btn layui-btn-sm button"><i class="layui-icon">&#xe605;</i>提交</button></a>
</div>
<div id="health-card-main" class=${"1" eq personRecordFlag ?"":'contentfixed32'}>
	<form id="health-card-form">
	<input type="hidden" id="dis-personid"   name="personId"  value="${diseaseInfo.personInfo.id}" > 
	<input type="hidden" id="disid"   name="id" value="${diseaseInfo.id}" > 
		<div class="postcontent">
			<i class="popno">慢病管理</i>
			<div class="postdiv">
				<div id="person-info"><jsp:include page="../input/personInfo.jsp"></jsp:include>
				</div>
				<div id="dis-select-box">
					<fieldset class="layui-elem-field">
						<legend>慢病</legend>
						<input type="checkbox" value="2" name="hbpFlag" ${diseaseInfo.hbpFlag eq '2' ?'checked=true':''} ${hbpFlag eq '2' ?'disabled':''}><label>高血压 </label>
						<input type="checkbox" value="2" name="diFlag" ${diseaseInfo.diFlag eq '2' ?'checked=true':''} ${diFlag eq '2' ?'disabled':''}>糖尿病
						<input type="checkbox" value="2" name="coronaryFlag" ${diseaseInfo.coronaryFlag eq '2' ?'checked=true':''} ${coronaryFlag eq '2' ?'disabled':''}>冠心病
						<input type="checkbox" value="2" name="strokeFlag" ${diseaseInfo.strokeFlag eq '2' ?'checked=true':''} ${strokeFlag eq '2' ?'disabled':''} >脑卒中
						<input type="checkbox" value="2" name="tumorFlag" ${diseaseInfo.tumorFlag eq '2' ?'checked=true':''} ${tumorFlag eq '2' ?'disabled':''}>肿瘤
						<span style="color: #999;font-style: italic;">(不可选择项为已经管理的疾病)</span>
					</fieldset>
				</div>
				<div id="dis-info">
					<c:set var="isHealth" scope="request" value="${true}" ></c:set>
					<div id="hbpFlag-box" class="${diseaseInfo.hbpFlag eq '2'?'show':'hide'}">
						<fieldset class="layui-elem-field">
							<legend>高血压信息 <span style="color:red;">(注：疾病信息录入后不可修改)</span></legend>
							<jsp:include page="../input/hbp.jsp"></jsp:include>
						</fieldset>
					</div>
					<div id="diFlag-box" class="${diseaseInfo.diFlag eq '2'?'show':'hide'}">
						<fieldset class="layui-elem-field">
							<legend>糖尿病信息 <span style="color:red;">(注：疾病信息录入后不可修改)</span></legend>
							<jsp:include page="../input/di.jsp"></jsp:include>
						</fieldset>
					</div>
					<div id="coronaryFlag-box" class="${diseaseInfo.coronaryFlag eq '2'?'show':'hide'}">
						<fieldset class="layui-elem-field">
							<legend>冠心病信息 <span style="color:red;">(注：疾病信息录入后不可修改)</span></legend>
							<jsp:include page="../input/coronary.jsp"></jsp:include>
						</fieldset>
					</div>
					<div id="strokeFlag-box" class="${diseaseInfo.strokeFlag eq '2'?'show':'hide'}">
						<fieldset class="layui-elem-field">
						<legend>脑卒中信息 <span style="color:red;">(注：疾病信息录入后不可修改)</span></legend>
								<jsp:include page="../input/stroke.jsp"></jsp:include>
						</fieldset>
					</div>
					<div id="tumorFlag-box" class="${diseaseInfo.tumorFlag eq '2'?'show':'hide'}">
						<fieldset class="layui-elem-field">
							<legend>肿瘤信息 <span style="color:red;">(注：疾病信息录入后不可修改)</span></legend>
                            <jsp:include page="../input/tumor-flag.jsp"></jsp:include>
							<jsp:include page="../input/tumor-input.jsp"></jsp:include>
						</fieldset>
					</div>
				</div>
				<div id="phyexam-info"></div>
				<div id="input-info"></div>
                <div style="height: 20px;" />
			</div>
		</div>
	</form>
</div>
