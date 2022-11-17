<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<div class="repeattable" style="width: 260px; margin-left: 5px; margin-top: 10px;">
	<table id="healthCheckList" class="layui-table x-admin-sm-table-list-small">
		<colgroup>
			<col style="min-width:100px;width: 100px;"/>
            <col style="min-width:160px;"/>
        </colgroup>
		<thead>
			<tr>
                <th>体检时间</th>
                <th>检查机构</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="healthCheck" items="${plist}" varStatus="status">
				<tr onclick="healthCheckMain.add(${statusId}, ${healthCheck.id})">
					<td style="text-align: center">
						<ehr:tip><fmt:formatDate pattern="yyyy/MM/dd" value="${healthCheck.physicalDt}"/></ehr:tip>
					</td>
                    <td style="text-align: center">
                        <ehr:tip>${healthCheck.examinationOrganCode}</ehr:tip>
                    </td>
				</tr>
			</c:forEach>
		</tbody>		
	</table>
	<table class="mini">
		<tr>
			<ehr:pagination-mini action="healthCheckMain.healthCheckList" />
		</tr>
	</table>	
</div>

