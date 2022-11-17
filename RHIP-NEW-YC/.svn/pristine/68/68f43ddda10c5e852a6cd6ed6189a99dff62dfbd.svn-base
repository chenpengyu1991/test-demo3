<%@page import="com.founder.rhip.ehr.common.EHRConstants"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<c:set var="dataTypeIsAdd" value="<%=EHRConstants.LOCATION_DATA_TYPE_ADD%>" />
<c:set var="dataStatusIsNormal" value="<%=EHRConstants.LOCATION_DATA_STATUS_NORMAL%>" />
<table class="layui-table x-admin-sm-table-list-small">
	<colgroup>
		<col style="width: 40px;" />
        <col style="width: 18%" />
		<col style="width: 47%" />

		<col style="width: 18%" />

        <col style="width: 100px" />
        <col style="width: 100px" />
		<col style="width: 60px" />
		<col style="width: 60px" />
	</colgroup>
	<thead>
		<tr>
			<th style="text-align: center;">选择</th>
            <th style="text-align: center;">法人/负责人</th>
			<th style="text-align: center;">巡查地点或单位</th>

			<th style="text-align: center;">联系电话</th>

            <th style="text-align: center;" >卫生专业</th>
			<th style="text-align: center;">许可到期日期</th>
			<th style="text-align: center;">巡查次数</th>
			<th>指导次数</th>
		</tr>
	</thead>
	<tbody class="tbody">
		<c:forEach var="locationInfo" items="${locationInfoList}">
			<tr>
				<td><input type="radio" class="inspection-location-select-radio" data-type="${locationInfo.healthProfessional}" name="locationId" value="${locationInfo.id}"></td>

				<td><ehr:tip trim="true">
						<c:choose>
							<c:when test="${not empty locationInfo.legal}">${locationInfo.legal}</c:when>
							<c:otherwise>${locationInfo.personInCharge}</c:otherwise>
						</c:choose>
					</ehr:tip></td>
                <td><ehr:tip>${locationInfo.unitName}</ehr:tip></td>
				<td><ehr:tip>${locationInfo.contactPhone}</ehr:tip></td>
                <td><ehr:tip><ehr:dic  dicmeta="HSA00006" code="${locationInfo.healthProfessional}" /></ehr:tip></td>

                <td><ehr:tip>
						<fmt:formatDate value="${locationInfo.dueDate}" pattern="yyyy/MM/dd" />
					</ehr:tip></td>
				<td><ehr:tip>${locationInfo.inspCount}</ehr:tip></td>
				<td><ehr:tip>${locationInfo.guideCount}</ehr:tip></td>
			</tr>
		</c:forEach>
	</tbody>
</table>
<ehr:paging action="hsaInspectinoAdd.searchLocation" />