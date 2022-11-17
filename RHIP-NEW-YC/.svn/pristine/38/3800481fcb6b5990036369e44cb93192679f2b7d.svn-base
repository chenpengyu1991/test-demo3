<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ page import="com.founder.rhip.ehr.common.RoleType" %>
<c:set var="JKFYK" value="<%=RoleType.JKFYK.getValue()%>"/>
<c:set var="ZXCRB" value="<%=RoleType.ZXCRB.getValue()%>"/>
<c:set var="YYCRB" value="<%=RoleType.YYCRB.getValue()%>"/>

<div class="repeattable">
	<table>
		<colgroup>
			<col style="min-width:60px;width: 8%;"/>
	        <col style="min-width:120px;width: 16%;"/>
			<col style="min-width:40px;width: 5%;"/>
	        <col style="min-width:100px;width: 14%;"/>
			<col style="min-width:80px;width: 10%;"/>
			<col style="min-width:80px;width: 12%;"/>
			<col style="min-width:80px;width: 12%;"/>
            <col style="min-width:60px;width: 7%;"/>
            <ehr:authorize ifAnyGranted="${ZXCRB},${JKFYK},${YYCRB}">
				<col style="min-width:80px;width: 10%;width:80px;"/>
            </ehr:authorize>
		</colgroup>	
		<thead>
			<tr>
				<th>姓名</th>
				<th>身份证号</th>
				<th>性别</th>
				<th>传染病名称</th>
				<th>上报日期</th>
				<th>上报单位</th>
				<th>填写单位</th>
                <th>状态</th>
                <ehr:authorize ifAnyGranted="${ZXCRB},${JKFYK},${YYCRB}">
					<th>操作</th>
                </ehr:authorize>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="report" items="${reports.list}" varStatus="status">
                <c:if test="${'1' == report.logoff}">
                    <tr class="offedperson">
                </c:if>
                <c:if test="${'1' != report.logoff}">
                    <tr>
                </c:if>
					<td title="${report.name}">
                        <%--<a href="javascript:void(0)" onclick="caseSearch.print(${report.id})"class="person-link-btn">${report.name}</a>--%>
                        ${report.name}
                    </td>
					<td title="${report.idcard}" class="centertd"><ehr:ehrBrwLink personId="${report.personId}" idCard="${report.idcard}">${report.idcard}</ehr:ehrBrwLink></td>
					<td class="centertd"><ehr:dic dicmeta="GBT226112003" code="${report.gender}" /></td>
					<td title="${report.infectiousName}">${report.infectiousName}</td>
					<%--<td class="centertd">--%>
						<%--<ehr:dic  dicmeta="FS10063" code="${report.infectiousType}" />--%>
					<%--</td>--%>
					<td class="centertd"><fmt:formatDate value="${report.fillDate}" pattern="yyyy/MM/dd" /></td>
					<td title="${report.fillOrganName}">${report.fillOrganName}</td>
					<td title="<ehr:org code="${report.modifySurveyOrg}"/>"><ehr:org code="${report.modifySurveyOrg}"/></td>
                    <td class="centertd">
                        <c:choose>
                            <c:when test="${report.tsStatus==1}">
                                未填写&nbsp;
                            </c:when>
                            <c:when test="${report.tsStatus==2}">
                                已填写&nbsp;
                            </c:when>
                        </c:choose>
                    </td>
                <ehr:authorize ifAnyGranted="${ZXCRB},${JKFYK},${YYCRB}">
                    <td class="centertd">
                        <c:choose>
                            <c:when test="${report.tsStatus==1}">
                                <a href="javascript:void(0)" onclick="tsSearch.initTs(${report.idmId},'${report.infectiousCode}', '${report.logoff}')"
                                   class="person-link-btn">采样填写</a>
                            </c:when>
                            <c:otherwise>
                                <a href="javascript:void(0)" onclick="tsSearch.initTs(${report.idmId},'${report.infectiousCode}', '${report.logoff}')"
                                   class="person-link-btn">采样修改</a>
                            </c:otherwise>
                        </c:choose>
                    </td>
                </ehr:authorize>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<table>
		<tr>
			<ehr:pagination action="tsSearch.search" />
		</tr>
	</table>
</div>