<%@page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/views/info/interaction.css"/>
<script src="${pageContext.request.contextPath}/js/views/survey/add.js" type="text/javascript"></script>

<!-- 调查问卷 -->
<div class="navRight">
	<div class="location">
	  	当前位置：<a id="dcwj" class="space">调查问卷</a>
	</div>
	<div id="title" class="detailTitle">
		${survey.title }
	</div>
	<div class="publishTime">
		<span>发布者：<ehr:user-org userCode="${survey.userCode}"/></span>
		<span>发稿时间：<fmt:formatDate value="${survey.submitTime}" pattern="yyyy/MM/dd"/></span>
	</div>
	<c:if test="${not empty survey.purpose }">
		<div class="purpose" style="border-bottom:1px dashed #bebede">
			<div class="lab">调查目的：</div>
			<div class="con">${survey.purpose }</div>
		</div>
	</c:if>

	<form id="pollOption">
	<input type="hidden" id="surveyId" name="surveyId" value="${survey.id }">
	<input type="hidden" id="optionListJson" name="optionListJson">
	<div class="detailContent1" >
		<table id="surveyOptions" style="width:720px">
			<c:forEach items="${surveyItemList}" var="itemRecord" varStatus="status">
				<tr>
					<input type="hidden" id="${itemRecord.id}" value="${itemRecord.id}"/>
			   		<td><strong><span class="red">*</span> ${itemRecord.orderNum }、${itemRecord.description }</strong><c:if test="${itemRecord.labelTypeCode eq 'checkbox'}"><strong>（可多选）</strong></c:if></td>
				</tr>
				<tr>
					<td>
				      	<c:forEach items="${surveyOptionLists}" var="optionRecord">
			            	<c:if test="${itemRecord.id == optionRecord.itemId }">
								<c:choose>
									<c:when test="${itemRecord.labelTypeCode eq 'text'}">
										<div><input id="${optionRecord.id }" class="border-bottom width600" itemId="${optionRecord.itemId }" type="${itemRecord.labelTypeCode }" name="${itemRecord.labelTypeCode }${itemRecord.id}" value="${optionRecord.value }" reg='{"required":"true","maxlength":"1024"}'/></div>
									</c:when>
									<c:otherwise>
										<div><input ${optionRecord.isDefault == '2' ? 'checked="checked"' : ''} id="${optionRecord.id }" itemId="${optionRecord.itemId }" type="${itemRecord.labelTypeCode }" name="${itemRecord.labelTypeCode }${itemRecord.id}" value="${optionRecord.value }" reg='{"required":"true"}'/>
							      		<label for="${optionRecord.id }">${optionRecord.item }</label></div>
									</c:otherwise>
								</c:choose>
			            	</c:if>
						</c:forEach>
					</td>
				</tr>
				<tr style="height:10px"></tr>
			</c:forEach>
		</table>
	</div>
	<c:if test="${not empty survey.directions }">
		<div class="directions">
			<div class="lab">调查说明：</div>
			<div class="con">${survey.directions }</div>
		</div>
	</c:if>

	</form>
		<input id="submitSurvey" type="button" value="提交" class="margin-top10 margin-bottom20 search_btn"/>
		<input id="clearSurvey" type="button" value="清空" class="margin-top10 margin-bottom20 search_btn"/>
</div>

