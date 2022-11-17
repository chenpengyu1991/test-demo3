<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/ehr-tag" prefix="ehr"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
	<div  class="repeattable" >
		<table class="layui-table x-admin-sm-table-list-small">
			<thead>
				<tr>
					<th>日期</th>
					<th>药名</th>
					<th>规格</th>
					<th>数量</th>
					<th>单位</th>
					<th>机构</th>
				</tr>
			</thead>
			<tbody style="text-align: left">
				<c:forEach items="${drugUsages}" var="drugUsage">
					<tr>
						<td><fmt:formatDate value="${drugUsage.startDate}" pattern="yyyy/MM/dd" /></td>
						<c:if test="${empty drugUsage.drugTradeName}">
							<td><ehr:tip value="${drugUsage.drugGenericName}"></ehr:tip></td>
						</c:if>
						<c:if test="${not empty drugUsage.drugTradeName}">
							<td><ehr:tip value="${drugUsage.drugGenericName}(${drugUsage.drugTradeName})"></ehr:tip></td>
						</c:if>
						<td><c:out value="${drugUsage.drugSpecifications}"></c:out></td>
						<td><c:out value="${drugUsage.quantity}"></c:out></td>
						<td><c:out value="${drugUsage.quantityUnit}"></c:out></td>
						<td>
                            <c:choose>
                                <c:when test="${not empty drugUsage.referralHospitalName}" >
                                    <c:out value="${drugUsage.referralHospitalName}" />
                                </c:when>
                                <c:otherwise>
                                    <ehr:org code="${drugUsage.referralHospitalCode}" />
                                </c:otherwise>
                            </c:choose>
                          </td>
					</tr>
				</c:forEach>
				<tr>
                	<ehr:pagination action="drugSearch.search" colspan="6"/>
                </tr>
            </tbody>
        </table>
    </div>
