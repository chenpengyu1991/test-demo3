<%@ page import="com.founder.rhip.ehr.common.RoleType" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:set var="SJYYYWK" value="<%=RoleType.SJYYYWK.getValue()%>"/>
<c:set var="HGZX" value="<%=RoleType.HGZX.getValue()%>"/>
<div class="repeattable">
	<table>
		<colgroup>
            <col style="width: 8%"/>
			<col style="width: 15%"/>
			<col style="width: 10%"/>
			<col style="width: 15%"/>
			<col style="width: 15%"/>
			<col />
			<col style="width: 10%"/>
		</colgroup>
		<thead>
		<tr>
			<th>编号</th>
			<th>姓名</th>
			<th>性别</th>
			<th>病人类型</th>
			<th>初步诊断</th>
			<th>医疗机构名称</th>
			<th>操作</th>
		</tr>
		</thead>
		<tbody>
		<c:forEach var="outTransfer" items="${outTransferList}" varStatus="status">
			<tr>
				<td>${status.index+1}</td>
				<td>${outTransfer.name}</td>
				<td>
                    <%--<ehr:dic dicmeta="GBT226112003" code="${outTransfer.gender}"/>--%>
                    <c:choose>
                        <c:when test="${outTransfer.gender == 0}">未知的性别</c:when>
                        <c:when test="${outTransfer.gender == 1}">男</c:when>
                        <c:when test="${outTransfer.gender == 2}">女</c:when>
                        <c:when test="${outTransfer.gender == 9}">未说明的性别</c:when>
                    </c:choose>
                </td>
				<td><ehr:tip><ehr:dic dicmeta="CV0710003" code="${outTransfer.patientType}"></ehr:dic></ehr:tip></td>
				<td><ehr:tip>${outTransfer.icdName}(${outTransfer.icdCode})</ehr:tip></td>
				<td><ehr:tip><ehr:org code="${outTransfer.fromOrganCode}"></ehr:org></ehr:tip></td>
				<td style="text-align: center;padding-left: 0px;">
                    <ehr:authorize ifAnyGranted="${SJYYYWK}">
                        <c:if test="${empty outTransfer.medicalDeptAudit}">
                            <a href="javascript:void(0)" onclick="outTransferSearch.initEdit(${outTransfer.id})">审批</a>
                        </c:if>
                        <c:if test="${!empty outTransfer.medicalDeptAudit}">
                            <a href="javascript:void(0)" onclick="outTransferSearch.view(${outTransfer.id})">查看</a>
                        </c:if>
                    </ehr:authorize>
                    <ehr:authorize ifAnyGranted="${HGZX}">
                        <a href="javascript:void(0)" onclick="outTransferSearch.view(${outTransfer.id})">查看</a>
                    </ehr:authorize>
				</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<table>
		<tr>
			<ehr:pagination action="outTransferSearch.search"/>
		</tr>
	</table>
</div>
<div><input type="hidden" id="indexPage" value="${indexPage}"/></div>