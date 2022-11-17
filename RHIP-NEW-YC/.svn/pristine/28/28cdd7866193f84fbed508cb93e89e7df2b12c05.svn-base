<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@ page import="com.founder.rhip.idm.common.LeprosyStatus" %>
<c:set var="SUSPECTED" value="<%=LeprosyStatus.SUSPECTED.getValue()%>" />

<%@ page import="com.founder.rhip.ehr.common.RoleType" %>
<c:set var="JKXAK" value="<%=RoleType.JKXAK.getValue()%>"/>
<c:set var="SJYYFBK" value="<%=RoleType.SJYYFBK.getValue()%>"/>
<c:set var="SQZX" value="<%=RoleType.SQZX.getValue()%>"/>

<div class="repeattable">
	<input type="hidden" id="currentPageSuspected" value="${page.currentPage }"/>
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
			<col style="min-width:80px;width:80px;"/>
		</colgroup>	
		<thead>
			<tr>
				<th>患者姓名</th>
				<th>患者性别</th>
				<th>出生日期</th>
				<th>现住址</th>
				<th>诊断结果</th>
				<th>上报人</th>
				<th>上报单位</th>
				<th>上报日期</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="suspected" items="${suspecteds}" varStatus="status">
				<tr>
					<td><ehr:tip>${suspected.leprosyQueryDto.name}</ehr:tip></td>
					<td class="centertd"><ehr:tip><ehr:dic code="${suspected.leprosyQueryDto.gender}" dicmeta="GBT226112003"/></ehr:tip></td>
					<td class="centertd"><ehr:tip><fmt:formatDate pattern="yyyy/MM/dd" value="${suspected.leprosyQueryDto.birthday}"/></ehr:tip></td>
					<td>
						<ehr:tip>${suspected.leprosyQueryDto.paAddress}</ehr:tip>
					</td>
					<td class="centertd">
						<c:choose>
								<c:when test="${suspected.leprosyQueryDto.reviewResult == null}">
									未诊断
								</c:when>
								<c:otherwise>
									<ehr:dic code="${suspected.leprosyQueryDto.reviewResult}" dicmeta="IDM00231"/> 
								</c:otherwise>
							</c:choose>
					</td>
					<td><ehr:tip><ehr:user userCode="${suspected.leprosyQueryDto.modifyRespondents}"/></ehr:tip></td>
					<td><ehr:tip><ehr:org code="${suspected.leprosyQueryDto.modifySurveyOrg}"/></ehr:tip></td>
					<td class="centertd"><ehr:tip><fmt:formatDate pattern="yyyy/MM/dd" value="${suspected.leprosyQueryDto.modifySurveyDate}"/></ehr:tip></td>
					<ehr:authorize ifAnyGranted="${JKXAK}">
						<td class="centertd">
							<c:choose>
								<c:when test="${suspected.leprosyQueryDto.reviewResult == null}">
									<a href="javascript:void(0)" onclick="javascript:leprosyCommon.add('${suspected.leprosyQueryDto.singleId}',${SUSPECTED},'2','Suspected')" class="person-link-btn">诊断</a>&nbsp;
								</c:when>
								<c:otherwise>
									<a href="javascript:void(0)" onclick="javascript:leprosyCommon.add('${suspected.leprosyQueryDto.singleId}',${SUSPECTED},'3','Suspected')" class="person-link-btn">查看</a>&nbsp;
								</c:otherwise>
							</c:choose>
						</td>
					</ehr:authorize>
					<ehr:authorize ifAnyGranted="${SJYYFBK},${SQZX}">
						<td class="centertd">
							<a href="javascript:void(0)" onclick="javascript:leprosyCommon.add('${suspected.leprosyQueryDto.singleId}',${SUSPECTED},'3','Suspected')" class="person-link-btn">查看</a>&nbsp;
						</td>
					</ehr:authorize>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<table>
		<tr>
			<ehr:pagination action="suspected.search" colspan="9" />
		</tr>
	</table>
</div>