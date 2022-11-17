<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ page import="com.founder.rhip.ehr.common.RoleType" %>
<c:set var="JKFYK" value="<%=RoleType.JKFYK.getValue()%>"/>
<c:set var="ZXCRB" value="<%=RoleType.ZXCRB.getValue()%>"/>
<c:set var="YYCRB" value="<%=RoleType.YYCRB.getValue()%>"/>
<c:set var="ZCRB" value="<%=RoleType.ZCRB.getValue()%>"/>

<div class="repeattable">
	<table>
		<colgroup>
			<col style="min-width:60px;width: 5%;"/>
	        <col style="min-width:120px;width: 14%;"/>
			<col style="min-width:40px;width: 4%;"/>
	        <col style="min-width:100px;width: 14%;"/>
			<%--<col style="min-width:50px;width: 6%;"/>--%>
			<col style="min-width:80px;width: 10%;"/>
			<col style="min-width:80px;width: 12%;"/>
			<col style="min-width:80px;width: 12%;"/>
			<col style="min-width:60px;width: 7%;"/>
            <col style="min-width:60px;width: 7%;"/>
            <ehr:authorize ifAnyGranted="${ZXCRB},${JKFYK},${YYCRB},${ZCRB}">
				<col style="min-width:80px;width: 10%;width:80px;"/>
            </ehr:authorize>
		</colgroup>	
		<thead>
			<tr>
				<th>姓名</th>
				<th>身份证号</th>
				<th>性别</th>
				<th>传染病名称</th>
				<%--<th>分类</th>--%>
				<th>上报日期</th>
				<th>上报单位</th>
				<th>填写单位</th>
				<th>作废</th>
                <th>状态</th>
                <ehr:authorize ifAnyGranted="${ZXCRB},${JKFYK},${YYCRB},${ZCRB}">
				<%--<c:if test='${ROLE==ZXCRB|| ROLE==JKFYK || ROLE==YYCRB}'>--%>
					<th>操作</th>
				<%--</c:if>	--%>
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
                            <c:when test="${report.validCaseStatus=='0'}">
                                	已作废&nbsp;
                            </c:when>
                         </c:choose>
                    </td>
                    <td class="centertd">
                        <c:choose>
                            <c:when test="${report.caseStatus==1}">
                                未填写&nbsp;
                            </c:when>
                            <c:when test="${report.caseStatus==2}">
                               待审核&nbsp;
                            </c:when>
                            <c:when test="${report.caseStatus==3}">
                                已审核&nbsp;
                            </c:when>
                             <c:when test="${report.caseStatus==4}">
                                已退回&nbsp;
                            </c:when> 
                        </c:choose>
                    </td>
                    <ehr:authorize ifAnyGranted="${ZXCRB},${JKFYK},${YYCRB},${ZCRB}">
						<td class="centertd">
							 
	                         <c:if test="${report.caseStatus!=1}">
	                               <a href="javascript:void(0)" onclick="repeatSearch.caseIndex(${report.id},${report.idmId},'${report.infectiousCode}','${report.name}',3, '${report.logoff}',1)" class="person-link-btn">
			                          	处置查看
			                       </a>&nbsp;
	                        </c:if>
	                        <c:if test="${report.validCaseStatus!='0'}">
	                               	<a href="javascript:void(0)" onclick="repeatSearch.invalid(${report.idmId})" class="person-link-btn">
			                           	个案作废
			                        </a>
	                        </c:if>
						</td>
					</ehr:authorize>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<table>
		<tr>
			<ehr:pagination action="repeatSearch.search" />
		</tr>
	</table>
</div>