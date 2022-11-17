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
	<input type="hidden" id="currentPageContact" value="${page.currentPage }"/>
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
			<col style="min-width:120px;width:120px;"/>
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
			<c:forEach var="contact" items="${contacts}" varStatus="status">
				<tr>
					<td><ehr:tip>${contact.leprosyQueryDto.name}</ehr:tip></td>
					<td class="centertd"><ehr:tip><ehr:dic code="${contact.leprosyQueryDto.gender}" dicmeta="GBT226112003"/></ehr:tip></td>
					<td class="centertd"><ehr:tip><fmt:formatDate pattern="yyyy/MM/dd" value="${contact.leprosyQueryDto.birthday}"/></ehr:tip></td>
					<td>
						<ehr:tip>${contact.leprosyQueryDto.paAddress}</ehr:tip>
					</td>
					<td class="centertd"><ehr:tip><ehr:dic code="${contact.leprosyQueryDto.reviewResult}" dicmeta="IDM00231"/></ehr:tip></td>
					<td><ehr:tip><ehr:user userCode="${contact.leprosyQueryDto.modifyRespondents}"/></ehr:tip></td>
					<td><ehr:tip><ehr:org code="${contact.leprosyQueryDto.modifySurveyOrg}"/></ehr:tip></td>
					<td class="centertd"><ehr:tip><fmt:formatDate pattern="yyyy/MM/dd" value="${contact.leprosyQueryDto.modifySurveyDate}"/></ehr:tip></td>
					<td class="centertd">
						<a href="javascript:void(0)" onclick="contact.initCcs('${contact.leprosyQueryDto.singleId}','${contact.logoff}')"class="person-link-btn">密切接触者</a>&nbsp;
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<table>
		<tr>
			<ehr:pagination action="contact.search" colspan="9" />
		</tr>
	</table>
</div>