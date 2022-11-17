<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page import="com.founder.rhip.idm.common.TbStatus" %>
<c:set var="DIAGNOSIS" value="<%=TbStatus.DIAGNOSIS.getValue()%>"/>

<div class="repeattable">
	<input type="hidden" id="currentPageDiagnosis" value="${page.currentPage }"/>
	<table class="layui-table x-admin-sm-table-list-middle">
		<colgroup>
			<col style="width:15%;"/>
	        <col style="width:5%;"/>
	        <col style="width:15%;"/>
	        <col style="width:10%;"/>
	        <col style="width:40%;"/>
			<col style="min-width:120px;width:15%;"/>
		</colgroup>	
		<thead>
			<tr>
				<th>姓名</th>
				<th>性别</th>
				<th>身份证</th>
				<th>转诊时间</th>
                <th>转诊原因</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="diagnosis" items="${diagnosiss}" varStatus="status">
				<tr <c:if test="${diagnosis.logoff == 1}">class="offedperson"</c:if>>
					<td><ehr:tip>${diagnosis.tbDto.name}</ehr:tip></td>
					<td class="centertd"><ehr:tip><ehr:dic code="${diagnosis.tbDto.gender}" dicmeta="GBT226112003"/></ehr:tip></td>
					<td>
						<ehr:ehrBrwLink idCard="${diagnosis.tbDto.idcard}"><ehr:tip>${diagnosis.tbDto.idcard}</ehr:tip></ehr:ehrBrwLink>
                    </td>
					<td><ehr:tip><fmt:formatDate value="${diagnosis.tbDto.transferTreatmentDt}" pattern="yyyy/MM/dd"/></ehr:tip></td>
                    <td><ehr:tip><ehr:dic code="${diagnosis.tbDto.diagnosisReason}" dicmeta="IDM00218"/></ehr:tip></td>
                    <td class="centertd">
						<c:choose>
							<c:when test="${diagnosis.placeStatus == '4' || diagnosis.placeStatus == null}">
                                <a href="javascript:void(0)" onclick="diagnosis.updatePlaceStatus('${diagnosis.id}','${diagnosis.tbDto.singleId}')" class="person-link-btn layui-btn layui-btn-xs" style="color: #FFF;" title="到位" ><i class="layui-icon">&#xe60e;</i>到位</a>&nbsp;
                                <a href="javascript:void(0)" onclick="tbCommon.add('${diagnosis.tbDto.singleId}',${DIAGNOSIS},'2','Diagnosis')" class="person-link-btn layui-btn layui-btn-warm layui-btn-xs" style="color: #FFF;" title="诊断" ><i class="layui-icon">&#xe6b2;</i>诊断</a>&nbsp;
                            </c:when>
							<c:when test="${diagnosis.placeStatus == '5' && diagnosis.tbDto.diagnosisType == null}">
								<a class="loadclass layui-btn layui-btn-xs layui-btn-disabled" title="到位"><i class="layui-icon">&#xe60e;</i>到位</a>&nbsp;
                                <a href="javascript:void(0)" onclick="tbCommon.add('${diagnosis.tbDto.singleId}',${DIAGNOSIS},'2','Diagnosis')" class="person-link-btn layui-btn layui-btn-warm layui-btn-xs" style="color: #FFF;" title="诊断" ><i class="layui-icon">&#xe6b2;</i>诊断</a>&nbsp;
							</c:when>
							<c:otherwise>
								<a class="loadclass layui-btn layui-btn-xs layui-btn-disabled" title="到位"><i class="layui-icon">&#xe60e;</i>到位</a>&nbsp;
								<a href="javascript:void(0)" onclick="tbCommon.add('${diagnosis.tbDto.singleId}',${DIAGNOSIS},'3','Diagnosis')" class="person-link-btn layui-btn layui-btn-normal layui-btn-xs" style="color: #FFF;" title="查看" ><i class="layui-icon">&#xe615;</i>查看</a>&nbsp;
                            </c:otherwise>
						</c:choose>
					</td>
				</tr>
			</c:forEach>
			<tr>
				<ehr:pagination action="diagnosis.search" colspan="6" />
			</tr>
		</tbody>
	</table>
</div>