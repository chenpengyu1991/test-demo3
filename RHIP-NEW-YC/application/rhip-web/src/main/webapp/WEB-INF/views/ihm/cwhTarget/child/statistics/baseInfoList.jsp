<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<div class="repeattable">
	<table class="layui-table x-admin-sm-table-list-middle">
		<colgroup>
			<col style="min-width:150px;width: 25%;"/>
	        <col style="min-width:80px;"/>
			<col style="min-width:80px;"/>
	        <col style="min-width:80px;"/>
	        <col style="min-width:80px;"/>
	        <col style="min-width:80px;"/>
	        <%--<col style="min-width:80px;"/>--%>
		</colgroup>
		<thead>
			<tr>
                <th>机构</th>
                <th>新生儿人数</th>
				<th>出生缺陷人数</th>
                <th>儿童登记人数</th>
				<th>新生儿随访人次数</th>
				<th>儿童体检人次数</th>
				<%--<th>儿童死亡登记数</th>--%>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="baseInfo" items="${baseInfoList}" varStatus="status">
				<tr>
                    <td class="centertd">
                        <c:choose>
                            <c:when test="${baseInfo.ORGAN_CODE=='合计'}">合计</c:when>
                            <c:otherwise>
                                <c:choose>
                                    <c:when test="${genreCode == '0'}"><ehr:dic dicmeta="FS990001" code="${baseInfo.ORGAN_CODE}"/></c:when>
                                    <c:otherwise><ehr:tip><ehr:org code="${baseInfo.ORGAN_CODE}"/></ehr:tip></c:otherwise>
                                </c:choose>
                            </c:otherwise>
                        </c:choose>
                    </td>
                    <td class="centertd"><ehr:tip>${empty baseInfo.birthCount?0:baseInfo.birthCount}</ehr:tip></td>
                    <td class="centertd"><ehr:tip>${empty baseInfo.defectCount?0:baseInfo.defectCount}</ehr:tip></td>
                    <td class="centertd"><ehr:tip>${empty baseInfo.cardCount?0:baseInfo.cardCount}</ehr:tip></td>
                    <td class="centertd"><ehr:tip>${empty baseInfo.childVisitCount?0:baseInfo.childVisitCount}</ehr:tip></td>
                    <td class="centertd"><ehr:tip>${empty baseInfo.healthExamCount?0:baseInfo.healthExamCount}</ehr:tip></td>
                    <%--<td class="centertd"><ehr:tip>${baseInfo.deathCount}</ehr:tip></td>--%>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>