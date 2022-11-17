<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ page import="com.founder.rhip.idm.common.MalariaStatus" %>
<c:set var="VERIFY" value="<%=MalariaStatus.VERIFY.getValue()%>" />
<c:set var="WRITE" value="<%=MalariaStatus.WRITE.getValue()%>" />
<c:set var="CURE" value="<%=MalariaStatus.CURE.getValue()%>" />
<div class="repeattable">
	<table>
		<colgroup>
	        <col style="min-width:70px;width:70px;"/>
			<col style="min-width:60px;width:60px;"/>
	        <col style="min-width:50px;width:50px;"/>
			<col style="min-width:120px;width:80px;"/>
			<col style="min-width:80px;width:180px;"/>
			<col style="min-width:150px;width:180px;"/>
            <col style="min-width:80px;width:80px;"/>
		</colgroup>	
		<thead>
			<tr>
				<th>姓名</th>
				<th>性别</th>
				<th>年龄</th>
				<th>联系电话</th>
				<th>户口所在地</th>
				<th>现住址</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="caseInfo" items="${statusInfo}" varStatus="status">
				<tr <c:if test="${caseInfo.malariaQueryDto.logoff == 1}">class="offedperson"</c:if>>

					<td title="${caseInfo.malariaQueryDto.name}">
                        <a href="javascript:void(0)" onclick='javascript:malariaCase.initEdit(${caseInfo.malariaQueryDto.singleId},"view")' class="person-link-btn">
					    ${caseInfo.malariaQueryDto.name}</a>
                    </td>
					<td class="centertd" title="<ehr:dic dicmeta="GBT226112003" code="${caseInfo.malariaQueryDto.gender}" />"><ehr:dic dicmeta="GBT226112003" code="${caseInfo.malariaQueryDto.gender}" /></td>
					<td title="${caseInfo.malariaQueryDto.age}">${caseInfo.malariaQueryDto.age}</td>
					<td title="${caseInfo.malariaQueryDto.phoneNumber}">${caseInfo.malariaQueryDto.phoneNumber}</td>
					<td>
                        <ehr:tip>${caseInfo.malariaQueryDto.hrAddress}</ehr:tip>
                    </td>
					<td>
                        <ehr:tip>${caseInfo.malariaQueryDto.paAddress}</ehr:tip>
                    </td>
                    <td class="centertd">
                        <c:if test="${caseInfo.specialStatus == VERIFY}">
                            <a href="javascript:void(0)" onclick="malariaCase.initAdd(${caseInfo.malariaQueryDto.singleId},${caseInfo.malariaQueryDto.logoff})"class="person-link-btn">个案填写</a>
                        </c:if>
                        <c:if test="${caseInfo.specialStatus == WRITE || caseInfo.specialStatus == CURE}">
                            <a href="javascript:void(0)" onclick="malariaCase.initEdit(${caseInfo.malariaQueryDto.singleId},${caseInfo.malariaQueryDto.logoff})"class="person-link-btn">个案修改</a>
                        </c:if>
                    </td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<table>
		<tr>
			<ehr:pagination action="malariaCase.searchCase" />
		</tr>
	</table>
</div>