<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<div class="repeattable">
	<input type="hidden" id="currentPage" value="${page.currentPage }"/>
    <table id="person_outDoctor_table">
        <colgroup>
            <col style="width: 10%"/>
            <col style="width: 13%"/>
            <col style="width: 15%"/>
            <col style="width: 15%"/>
            <col style="width: 10%"/>
            <col style="width: 8%"/>
			<col style="width: 8%"/>
            <col style="width: 15%"/>
        </colgroup>
        <thead>
			<tr>
				<th>姓名</th>
				<th>医生编码(工号)</th>
				<th>机构名称</th>
				<th>科室名称</th>
				<th>职称</th>
				<th>热门专家</th>
				<th>审核状态</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody class="tbody">
			<c:forEach items="${outDoctors}" var="outDoctor">
					<tr>
						<td title="${outDoctor.name}">${outDoctor.name}</td>
						<td title="${outDoctor.doctorSn}">
							${outDoctor.doctorSn}
						</td>
						<td style="text-align:center" title="${outDoctor.hospitalCode}">
							<c:forEach items="${hospitalInfos}" var="hospitalInfo">
								<c:if test="${hospitalInfo.hospitalNo eq outDoctor.hospitalCode}">${hospitalInfo.hospitalName}</c:if>
							</c:forEach>
						</select>
							<%--<ehr:org code="${outDoctor.hospitalCode}"></ehr:org>--%>
						</td>
						<td style="text-align:center">${outDoctor.deptName}</td>
						<td style="text-align:center">${outDoctor.empTitName}</td>
						<td style="text-align: center;"><ehr:dic code="${outDoctor.isHot}" dicmeta="FS10186"/></td>
						<td style="text-align: center;"><ehr:dic code="${outDoctor.status}" dicmeta="LH00008"/> </td>
						<td style="text-align: center;">
							<a href="#this" id="seeDoctor${outDoctor.id}" data-outDoctorId="${outDoctor.id}" data-see="true">查看</a>
							<c:choose>
								<c:when test="${outDoctor.status == 0 || outDoctor.status == null}">
									<a href="#this" id="modifyDoctor${outDoctor.id}" data-outDoctorId="${outDoctor.id}" data-see="false">修改</a>
								</c:when>
							</c:choose>
							<ehr:authorize ifAnyGranted="01,39">
								<c:choose>
									<c:when test="${outDoctor.status==1}">
										<a href="#this" id="publishDoctor${outDoctor.id}" data-outDoctorId="${outDoctor.id}" data-status="0">撤销</a>
									</c:when>
									<c:otherwise>
										<a href="#this" id="publishDoctor${outDoctor.id}" data-outDoctorId="${outDoctor.id}" data-status="1">审核通过</a>
									</c:otherwise>
								</c:choose>
							</ehr:authorize>
							<c:choose>
								<c:when test="${outDoctor.status==0}">
									<ehr:authorize ifAnyGranted="01,39">
										<a href="#this" id="deleteDoctor${outDoctor.id}" data-outDoctorId="${outDoctor.id}">删除</a>
									</ehr:authorize>
								</c:when>
								<c:when test="${outDoctor.status==1}">
									<ehr:authorize ifAnyGranted="01,39">
										<a href="#this" id="deleteDoctor${outDoctor.id}" data-outDoctorId="${outDoctor.id}">删除</a>
									</ehr:authorize>
								</c:when>
							</c:choose>
						</td>
					</tr>
				</c:forEach>
		</tbody> 
	</table>
	<ehr:paging />
</div>

