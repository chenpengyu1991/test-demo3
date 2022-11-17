<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>

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
<input type="hidden" name="surveyId" value="${survey.id}" id="surveyId"/>
<input type="hidden" id="size" value="${surveyOptionLists.size()}"/>
	<div class="poll">
		<i>问卷调查统计</i>
		<table class="posttable">
			<colgroup>
				<col style="width: 100%" />
			</colgroup>
          		<tr>
                   <td>
                   	<label>${survey.title}</label>
                   </td>
			</tr>
			<tr>
				<td>
					<label>${survey.purpose}</label>
				</td>
			</tr>
		</table>
	</div>
	<div class="postdiv">
		<fieldset>
			<legend>详细结果</legend>
			<table class="polltable" id="surveyOptions" style="width:70%; text-align: center;">
				<tr>
					<td style="font-weight:bold;">
						<label>共 ${survey.count} 人参与调查</label>
					</td>
				</tr>
				<tr style="height:8px"></tr>
				<c:forEach items="${surveyItemList}" var="itemRecord">
					<tr>
				   		<td style="float:left">
				   			<strong style="font-size: 14px;">${itemRecord.orderNum }、${itemRecord.description }</strong>
				   			<c:choose>
				   				<c:when test="${itemRecord.labelTypeCode eq 'radio'}"><strong>[单选题]</strong></c:when>
				   				<c:when test="${itemRecord.labelTypeCode eq 'checkbox'}"><strong>[多选题]</strong></c:when>
				   				<c:otherwise><strong>[填空题]</strong></c:otherwise>
				   			</c:choose>
				   		</td>
					</tr>
					<tr>
						<td>
							<div class="repeattable" style="margin-top:5px">
								<c:choose>
									<c:when test="${itemRecord.labelTypeCode != 'text'}">
										<table>
											<colgroup>
												<col style="width:50%"/>
												<col style="width:10%"/>
												<col style="width:40%"/>
											</colgroup>
											<thead>
												<tr>
													<th>选项</th>
													<th>已选人数</th>
													<th>比例</th>
												</tr>
											</thead>
											<tbody class="tbody">
												<c:forEach items="${surveyOptionLists}" var="optionRecord" varStatus="status">
													<c:if test="${itemRecord.id == optionRecord.itemId }">
														<tr>
															<td>${optionRecord.item }</td>
															<td style="text-align:center" id="count${status.count }">
																<c:forEach items="${optionCount}" var="optionCount">
																	<c:if test="${optionCount.pollId eq optionRecord.id }">
																		${optionCount.selectNum}
																	</c:if>
																</c:forEach>
															</td>
															<td id="percent${status.count }">
																<c:forEach items="${optionSums}" var="optionSums">
																	<c:forEach items="${optionCount}" var="optionCount">
																	<c:if test="${optionCount.itemId eq optionSums.itemId 
																		&& optionCount.pollId eq optionRecord.id }">
																		<div class="bar">
																			<div class="precent" style="width:${fn:substring(optionCount.selectNum/optionSums.counts*100, 0, 4)}%; display: block;">
																				<img width="149" height="12" src="${pageContext.request.contextPath}/images/poll_bar2.png" alt="">
																			</div>
																		</div>
																		<div style="float:left; margin-left:3px">
																			${fn:substring(optionCount.selectNum/optionSums.counts*100, 0, 4)}%
																		</div>
																		<div style="clear:both;"></div>
																	</c:if>
																	</c:forEach>
																</c:forEach>
															</td>
														</tr>
											    	</c:if>
												</c:forEach>
											</tbody>
										</table>
									</c:when>
									<c:otherwise>
										<table>
											<colgroup>
												<col style="width:100%"/>
											</colgroup>
											<thead>	
												<tr>
													<th>填空内容</th>
												</tr>
											</thead>
											<tbody class="tbody">
												<c:forEach var="text" items="${pollTextLists}">
													<c:if test="${text.itemId == itemRecord.id}">
														<tr>
															<td style="white-space: normal;">${text.value}</td>
														</tr>
													</c:if>
												</c:forEach>
											</tbody>
										</table>
									</c:otherwise>
								</c:choose>
							 </div>
						 </td>
					</tr>
					<tr style="height:10px"></tr>
				</c:forEach>
			</table>
		</fieldset>
	</div>
</form>
