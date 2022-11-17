<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@ page import="com.founder.rhip.idm.common.LeprosyStatus" %>
<c:set var="SUSPECTED" value="<%=LeprosyStatus.SUSPECTED.getValue()%>" />
<c:set var="CASE" value="<%=LeprosyStatus.CASE.getValue()%>" />

<div class="repeattable">
	<input type="hidden" id="currentPageFollowup" value="${page.currentPage }"/>
	<table>
		<colgroup>
			<col style="width:15%;"/>
			<col style="width:5%;"/>
	        <col style="width:10%;"/>
	        <col style="width:15%;"/>
			<col style="width:15%;"/>
			<col style="width:10%;"/>		
			<col style="width:15%;"/>	
			<col style="width:10%;"/>	
			<col style=" min-width:120px;width:120px;"/>
		</colgroup>	
		<thead>
			<tr>
				<th>患者姓名</th>
				<th>患者性别</th>
				<th>出生日期</th>
				<th>现住址</th>
				<th>报卡状态</th>
				<th>上报人</th>
				<th>上报单位</th>
				<th>上报日期</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="followup" items="${followups}" varStatus="status">
				<tr>
					<td><ehr:tip>${followup.leprosyQueryDto.name}</ehr:tip></td>
					<td class="centertd"><ehr:tip><ehr:dic code="${followup.leprosyQueryDto.gender}" dicmeta="GBT226112003"/></ehr:tip></td>
					<td class="centertd"><ehr:tip><fmt:formatDate pattern="yyyy/MM/dd" value="${followup.leprosyQueryDto.birthday}"/></ehr:tip></td>
					<td>
						<ehr:tip>${followup.leprosyQueryDto.paAddress}</ehr:tip>
					</td>
					<td class="centertd">
						<c:choose>
								<c:when test="${followup.leprosyQueryDto.reviewResult == null}">
									未诊断
								</c:when>
								<c:otherwise>
									<ehr:dic code="${followup.leprosyQueryDto.reviewResult}" dicmeta="IDM00231"/> 
								</c:otherwise>
							</c:choose>
					</td>
					<td><ehr:tip><ehr:user userCode="${followup.leprosyQueryDto.modifyRespondents}"/></ehr:tip></td>
					<td><ehr:tip><ehr:org code="${followup.leprosyQueryDto.modifySurveyOrg}"/></ehr:tip></td>
					<td class="centertd"><ehr:tip><fmt:formatDate pattern="yyyy/MM/dd" value="${followup.leprosyQueryDto.modifySurveyDate}"/></ehr:tip></td>
					<td class="centertd">
						<c:choose>
							<c:when test="${followup.specialStatus == SUSPECTED || followup.specialStatus == CASE}">
								<a href="javascript:void(0)" onclick="followup.initFrs('${followup.leprosyQueryDto.singleId}','${followup.logoff}')" class="person-link-btn">随访观察</a>&nbsp;
							</c:when>
						</c:choose>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<table>
		<tr>
			<ehr:pagination action="followup.search" colspan="9" />
		</tr>
	</table>
</div>