<%@page import="com.founder.rhip.ehr.common.EHRConstants"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<c:set var ="dataTypeIsAdd" value="<%=EHRConstants.LOCATION_DATA_TYPE_ADD%>" />
<c:set var ="dataStatusIsNormal"  value="<%=EHRConstants.LOCATION_DATA_STATUS_NORMAL%>" />
<table class="layui-table x-admin-sm-table-list-middle">
	<colgroup>
		<col style="width: 20%" />
		<col style="width: 10%" />
		<col style="width: 10%" />

		<col style="width: 10%" />
        <col style="width: 10%" />
		<col style="width: 10%" />
		<col style="width: 10%" />
		<col style="width: 20%" />
	</colgroup>
	<thead>
		<tr>
			<th >单位名称</th>
			<th>法人/负责人</th>
			<th >联系电话</th>

            <th >卫生专业</th>
			<th >许可到期日期</th>
			<th >巡查次数</th>
			<th >指导次数</th>
			<th >操作</th>
		</tr>
	</thead>
	<tbody class="tbody">
		<c:forEach var="locationInfo" items="${locationInfoList}">
			<tr>
				<td>
					<ehr:tip>${locationInfo.unitName}</ehr:tip>
				</td>
				<td class="centertd"><ehr:tip trim="true">
					<c:choose>
						<c:when test="${not empty locationInfo.legal}">${locationInfo.legal}</c:when>
						<c:otherwise>${locationInfo.personInCharge}</c:otherwise>
					</c:choose>
				</ehr:tip></td>
				<td class="centertd"><ehr:tip>${locationInfo.contactPhone}</ehr:tip></td>
                <td><ehr:tip><ehr:dic  dicmeta="HSA00006" code="${locationInfo.healthProfessional}" /></ehr:tip></td>
				<td class="centertd"><ehr:tip><fmt:formatDate value="${locationInfo.dueDate}" pattern="yyyy/MM/dd"/></ehr:tip></td>
				<td class="righttd"><ehr:tip>${locationInfo.inspCount}</ehr:tip></td>
				<td class="righttd"><ehr:tip>${locationInfo.guideCount}</ehr:tip></td>
				<td class="centertd">
					<%-- <a title="点击进行查看 ${locationInfo.unitName}" class="view-link" href="javascript:void(0)" data-id="${locationInfo.id}">查看
					</a> --%>
					<a  title="点击进行查看 ${locationInfo.unitName}" class="view-link layui-btn layui-btn-normal layui-btn-xs" href="javascript:void(0)" data-id="${locationInfo.id}" style="color: #FFF;font-size: 12px;"><i class="layui-icon">&#xe615;</i>查看</a>&nbsp;
				<c:if test="${locationInfo.dataType==dataTypeIsAdd and locationInfo.status==dataStatusIsNormal }">
						<%-- <a title="点击进行修改" class="modify-link" href="javascript:void(0)" data-id="${locationInfo.id}">修改</a> --%>
						<a title="点击进行修改" class="modify-link layui-btn layui-btn-xs" href="javascript:void(0)" data-id="${locationInfo.id}" style="color: #FFF;font-size: 12px;"><i class="layui-icon">&#xe642;</i>修改</a>&nbsp;
						<%-- <a title="点击进行注销" class="cancel-link" href="javascript:void(0)" data-id="${locationInfo.id}">注销</a> --%>
						<a title="点击进行注销" class="cancel-link layui-btn layui-btn-danger layui-btn-xs" href="javascript:void(0)" data-id="${locationInfo.id}" style="color: #FFF;font-size: 12px;"><i class="layui-icon">&#x1006;</i>注销</a>&nbsp;
				</c:if>
				</td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="9">
				<ehr:paging action="hsaLocationList.search" />
			</td>
		</tr>
	</tbody>
</table>
<%-- <ehr:paging action="hsaLocationList.search" /> --%>