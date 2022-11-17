<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>

<div class="repeattable">
	<table>
		<colgroup>
			<col style="width: 100px;" />
			<col style="width: 100px;" />
			<col style="width: 100px;" />
			<col style="width: 100px;" />
			<col style="width: 100px;" />
			<col style="width: 100px;"/>
		</colgroup>
		<thead>
			<tr>
				<th>机构名称</th>
				<th>处方标题</th>
				<th>处方名称</th>
				<th>创建时间</th>
				<th>是否发布</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="prescription" items="${healthPrescriptions}">
				<tr>
					<td>
						<c:choose>
							<c:when test="${prescription.orgCode eq '_999'}">
								<ehr:tip>健康教育所</ehr:tip>
							</c:when>
							<c:otherwise>
								<ehr:org code="${prescription.orgCode}"/>
							</c:otherwise>
						</c:choose>
					</td>
					<td>${prescription.title}</td>
					<td>${prescription.name}</td>
					<td style="text-align: center;"><fmt:formatDate value="${prescription.createTime}" pattern="yyyy-MM-dd"/></td>
					<td><ehr:dic code="${prescription.status}" dicmeta="LH00007"/></td>
					<td style="text-align: center;">
						<c:if test="${currentOrgCode eq prescription.orgCode}">
							<c:choose>
								<c:when test="${prescription.status==1}">
									<a href="#this"
									   onclick="healthEducationPrescriptionSearch.unpublish(${prescription.id})">撤销</a>
								</c:when>
								<c:otherwise>
									<a href="#this"
									   onclick="healthEducationPrescriptionSearch.publish(${prescription.id})">发布</a>
								</c:otherwise>
							</c:choose>
						</c:if>
						<a href="javascript:void(0);" onclick="healthEducationPrescriptionSearch.viewHealthEducationPrescription(${prescription.id},'1')">查看</a>
						<c:if test="${currentOrgCode eq prescription.orgCode}">
							<c:if test="${createrOrg eq prescription.orgCode  || createrOrg eq '_999'}">
								<a href="javascript:void(0);"
								   onclick="healthEducationPrescriptionSearch.editHealthEducationPrescription(${prescription.id}, '2')">修改</a>
								<a href="javascript:void(0);"
								   onclick="healthEducationPrescriptionSearch.deleteHealthEducationPrescription(${prescription.id})">删除</a>
							</c:if>
						</c:if>

					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<table>
		<tr>
			<ehr:pagination action="healthEducationPrescriptionSearch.search" />
		</tr>
	</table>
</div>