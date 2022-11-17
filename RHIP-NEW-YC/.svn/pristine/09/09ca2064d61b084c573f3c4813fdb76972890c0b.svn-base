<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tag" %>

<%@ page import="com.founder.rhip.portal.common.SurveyStatus" %>

<c:set var="SAVE" value="<%=SurveyStatus.SAVE.getValue()%>"/>
<c:set var="START" value="<%=SurveyStatus.START.getValue()%>"/>
<c:set var="ENDS" value="<%=SurveyStatus.ENDS.getValue()%>"/>

<script type="text/javascript">
	 require(['views/portal/survey/add'],function(surveyAdd){
		 surveyAdd.load();
	 });
</script>

<div class="toolbar">
    <a id="returnContact"><b class="fanhui">返回</b></a>
</div>

<form id="surveyFormId">
	<input type="hidden" name="id" value="${survey.id}" id="surveyId"/>
	<input type="hidden" name="status" value="${survey.status == '' ? SAVE : survey.status}" id="surveyStatusIdd"/>
	<input type="hidden" id="typeId" name="type" value="${type}">
	<input type="hidden" name="submitTime" value="<fmt:formatDate value='${survey.submitTime}' pattern='yyyy/MM/dd'/>" />
	<input type="hidden" name="orgCode" value="${survey.orgCode}"/>
	<input type="hidden" name="userCode" value="${survey.userCode}"/>
	<input type="hidden" name="count" value="${survey.count}"/>
	<div class="postcontent">
		<i class="popno">调查表信息</i>
		<div class="postdiv">
			<table class="posttable">
				<colgroup>
					<col style="width: 20%" />
					<col style="width: 80%" />
				</colgroup>
           		<tr>
					<th align="right"><label class="required">标题：</label></th>
                    <td>
                        <input type="text" id="title" name="title" value="${survey.title}" reg='{"required":"true","maxlength":"100"}' style="width: 36%"/>
                    </td>
				</tr>
				<tr>
					<th style="width: 17%"><label class="required">调查日期范围：</label></th>
					<td>
						<tag:dateInput id="startDateSurId" nullToToday="true" name="startDate" onlyfuture="true" pattern="yyyy/MM/dd"
									   reg='{"required":"true","compare":["endDateSurId","le","开始日期不能大于结束日期"]}' date="${survey.startDate}" style="width: 15%"/>

					----<tag:dateInput id="endDateSurId" nullToToday="true" name="endDate" onlyfuture="true" pattern="yyyy/MM/dd"
								   reg='{"required":"true","compare":["startDateSurId","ge","结束日期不能小于开始日期"]}' date="${survey.endDate}" style="width: 15%"/>
					</td>
				</tr>
				<tr>
					<th align="right">调查目的</th>
					<td>
						<textarea style="width:470px; height:50px;" rows="10" cols="40" id="purpose" name="purpose">${survey.purpose}</textarea>
					</td>
				<tr>
					<th >说明</th>
					<td>
						<textarea style="width:470px; height:50px;" rows="10" cols="40" id="directions" name="directions">${survey.directions}</textarea>
					</td>
				</tr>
				<tr>
					<td colspan="2" style="text-align:center">
						<input type="button" id="nextContact" value="下一步" class="search_btn" />
					 </td>
				</tr>
			</table>
		</div>
	</div>
</form>
