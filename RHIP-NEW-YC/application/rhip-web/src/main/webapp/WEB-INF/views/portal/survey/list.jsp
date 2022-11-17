<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ page import="com.founder.rhip.portal.common.SurveyStatus" %>

<c:set var="SAVE" value="<%=SurveyStatus.SAVE.getValue()%>"/>
<c:set var="START" value="<%=SurveyStatus.START.getValue()%>"/>
<c:set var="ENDS" value="<%=SurveyStatus.ENDS.getValue()%>"/>

<div class="repeattable">
	<input type="hidden" id="currentPage" value="${page.currentPage }"/>
    <table id="survey_table">
        <colgroup>
            <col style="width: 10%"/>
            <col style="width: 20%"/>
            <col style="width: 30%"/>
			<col style="width: 10%"/>
			<col style="width: 10%"/>
            <col style="width: 20%"/>
        </colgroup>
        <thead>
			<tr>
				<th>创建日期</th>
				<th>标题</th>
				<th>调查目的</th>
				<th>审核状态</th>
				<th>参与人数</th>
         		<th>操作</th>
			</tr>
		</thead>
		<tbody class="tbody">
			<c:forEach items="${surveies}" var="surveyOne">
					<tr>
						<td style="text-align:center"><fmt:formatDate value="${surveyOne.submitTime}" pattern="yyyy/MM/dd"/></td>
						<td title="${surveyOne.title}">${surveyOne.title}</td>
						<td title="${surveyOne.purpose}">
							${surveyOne.purpose}
						</td>
						<td style="text-align:center">
							<ehr:tip><ehr:dic dicmeta="LH00008" code="${surveyOne.status}"></ehr:dic></ehr:tip>
						</td>
						<td title="${surveyOne.count}" style="text-align:center">
								${surveyOne.count}
						</td>
						<td style="text-align: center;" >
							<a href="#this" id="viewDetail${surveyOne.id}" data-surveyId="${surveyOne.id}">查看</a>
							<c:choose>
								<c:when test="${surveyOne.status ==  START}">
									<ehr:authorize ifAnyGranted="01">
										<a href="#this" id="modifySurvey${surveyOne.id}" data-surveyId="${surveyOne.id}">修改</a>
										<a href="#this" id="updateSurvey${surveyOne.id}" data-surveyId="${surveyOne.id}" data-status='${ENDS}'>结束调查</a>
									</ehr:authorize>
								</c:when>
								<c:when test="${surveyOne.status ==  SAVE}">
									<a href="#this" id="modifySurvey${surveyOne.id}" data-surveyId="${surveyOne.id}">修改</a>
									<ehr:authorize ifAnyGranted="01">
										<a href="#this" id="updateSurvey${surveyOne.id}" data-surveyId="${surveyOne.id}" data-status='${START}'>审核通过</a>
									</ehr:authorize>
								</c:when>
							</c:choose> 
						</td>
					</tr>
				</c:forEach>
				<!-- 分页加上后，样式有问题 -->				
		</tbody> 
	</table>
	<ehr:paging />
</div>
