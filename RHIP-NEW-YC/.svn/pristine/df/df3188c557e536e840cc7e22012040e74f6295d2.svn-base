<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@ page import="com.founder.rhip.idm.common.LeprosyStatus" %>
<c:set var="SUSPECTED" value="<%=LeprosyStatus.SUSPECTED.getValue()%>" />
<c:set var="CASE" value="<%=LeprosyStatus.CASE.getValue()%>"/>

<%@ page import="com.founder.rhip.ehr.common.RoleType" %>
<c:set var="JKXAK" value="<%=RoleType.JKXAK.getValue()%>"/>
<c:set var="SJYYFBK" value="<%=RoleType.SJYYFBK.getValue()%>"/>
<c:set var="SQZX" value="<%=RoleType.SQZX.getValue()%>"/>

<div class="repeattable">
	<input type="hidden" id="currentPageCase" value="${page.currentPage }"/>
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
				<th>报卡状态</th>
				<th>上报人</th>
				<th>上报单位</th>
				<th>上报日期</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="caseLeprosy" items="${cases}" varStatus="status">
				<tr>
					<td><ehr:tip>${caseLeprosy.leprosyQueryDto.name}</ehr:tip></td>
					<td class="centertd"><ehr:tip><ehr:dic code="${caseLeprosy.leprosyQueryDto.gender}" dicmeta="GBT226112003"/></ehr:tip></td>
					<td class="centertd"><ehr:tip><fmt:formatDate pattern="yyyy/MM/dd" value="${caseLeprosy.leprosyQueryDto.birthday}"/></ehr:tip></td>
					<td>
						<ehr:tip>${caseLeprosy.leprosyQueryDto.paAddress}</ehr:tip>
					</td>
					<td class="centertd"><ehr:tip><ehr:dic code="${caseLeprosy.leprosyQueryDto.reviewResult}" dicmeta="IDM00231"/></ehr:tip></td>
					<td><ehr:tip><ehr:user userCode="${caseLeprosy.leprosyQueryDto.modifyRespondents}"/></ehr:tip></td>
					<td><ehr:tip><ehr:org code="${caseLeprosy.leprosyQueryDto.modifySurveyOrg}"/></ehr:tip></td>
					<td class="centertd"><ehr:tip><fmt:formatDate pattern="yyyy/MM/dd" value="${caseLeprosy.leprosyQueryDto.modifySurveyDate}"/></ehr:tip></td>
					<td class="centertd">
						<c:choose>
							<c:when test="${caseLeprosy.specialStatus == SUSPECTED && caseLeprosy.logoff != 1}">
								<a href="javascript:void(0)" onclick="leprosyCommon.add('${caseLeprosy.leprosyQueryDto.singleId}',${CASE},'1','Case')" class="person-link-btn">新建</a>&nbsp;
								<label class="loadclass">查看&nbsp;</label>
							</c:when>
							<c:when test="${caseLeprosy.specialStatus == SUSPECTED && caseLeprosy.logoff == 1}">
								<label class="loadclass">新建&nbsp;</label>
								<label class="loadclass">查看&nbsp;</label>
							</c:when>
							<c:when test="${caseLeprosy.logoff == 1}">
								<label class="loadclass">修改&nbsp;</label>
								<a href="javascript:void(0)" onclick="leprosyCommon.add('${caseLeprosy.leprosyQueryDto.singleId}',${CASE},'3','Case')" class="person-link-btn">查看</a>&nbsp;
							</c:when>
							<c:otherwise>
								<a href="javascript:void(0)" onclick="leprosyCommon.add('${caseLeprosy.leprosyQueryDto.singleId}',${CASE},'2','Case')" class="person-link-btn">修改</a>&nbsp;
								<a href="javascript:void(0)" onclick="leprosyCommon.add('${caseLeprosy.leprosyQueryDto.singleId}',${CASE},'3','Case')" class="person-link-btn">查看</a>&nbsp;
							</c:otherwise>
						</c:choose>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<table>
		<tr>
			<ehr:pagination action="caseLeprosy.search" colspan="9" />
		</tr>
	</table>
</div>