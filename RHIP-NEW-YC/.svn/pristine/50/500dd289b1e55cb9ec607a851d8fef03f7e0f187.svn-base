<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>

<div id="tumorPrintFollowUp" style="display: none">
	<h3 align="center">肿瘤患者随访服务记录表</h3>
	<span style="float:left;margin-top: 5px;"><b>姓名:</b>${personInfo.name}</span>
	<span style="float:right;margin-top: 5px"><b>身份证号:</b>${personInfo.idcard}</span>
	<table border="1" width="100%" style="border-collapse: collapse;border-spacing:0; ">
		<colgroup>
			<col style="width: 50%;" />
			<col style="width: 50%;" />
		</colgroup>
		<tr>
			<th>随访日期</th>
			<td><fmt:formatDate value="${tumor.visitDate}" pattern="yyyy年MM月dd日"/></td>
		</tr>
		<tr>
			<th>随访方式</th>
			<td>
				<ehr:dic dicmeta="DMD00026" code="${tumor.visitWayCode}" />
			</td>
		</tr>
		<tr>
			<th>是否失访</th>
			<td><ehr:dic dicmeta="FS10246" code="${tumor.lossVisit}" /></td>
		</tr>
		<tr id="tumor-lossVisit" ${tumor.lossVisit !='1'?'style="display:none"':'' }>
			<th>失访原因</th>
			<td>
				<c:forEach items="${fn:split(tumor.lossVisitReason, ',')}" var="lossReason" varStatus="varStatus">
					<c:choose>
						<c:when test="${lossReason eq '7'}">
							${tumor.lossVisitReasonDesc}
						</c:when>
						<c:otherwise>
							<ehr:dic code="${lossReason}" dicmeta="CDM00004"/>
						</c:otherwise>
					</c:choose>
					<c:if test="${!varStatus.last}">,</c:if>
				</c:forEach>
			</td>
		</tr>
		<tr>
			<th>具体随访地址</th>
			<td>
				<c:choose>
					<c:when test="${tumor.followupPlace eq '3'}">
						<ehr:dic code="${tumor.fltownShip}" dicmeta="FS990001"/>
						<ehr:dic code="${tumor.flstreet}" dicmeta="FS990001"/>
						<ehr:dic code="${tumor.flGroup}" dicmeta="FS990001"/>
						${tumor.flhouseNumber}
					</c:when>
					<c:otherwise>
						<ehr:dic dicmeta="CDM00005" code="${tumor.followupPlace}"></ehr:dic>
					</c:otherwise>
				</c:choose>
			</td>
		</tr>
		<tr>
			<th>是否治疗</th>

			<td><ehr:dic dicmeta="DMD00048" code="${tumor.cure }"></ehr:dic></td>
		</tr>
		<tr id="tumor-cure" ${tumor.cure !='1'?'style="display:none"':'' }>
			<th>治疗方式</th>
			<td>
				<ehr:dic dicmeta="DMD00047" code="${tumor.cureProject}"></ehr:dic>
			</td>
		</tr>
		<tr>
			<th>是否死亡</th>
			<td><ehr:dic dicmeta="FS10246" code="${tumor.death }"></ehr:dic></td>
		</tr>
		<tr id="tumor-deathDate" ${tumor.death !='1'?'style="display:none"':'' }>
			<th>死亡日期</th>
			<td><fmt:formatDate value="${tumor.deathDate}" pattern="yyyy年MM月dd日"/></td>
		</tr>
		<tr id="tumor-deathForTumor" ${tumor.death !='1'?'style="display:none"':'' }>
			<th>是否死于肿瘤</th>
			<td><ehr:dic dicmeta="FS10246" code="${tumor.deathForTumor }" /></td>
		</tr>
		<tr id="tumor-deathReason" ${tumor.death !='1'?'style="display:none"':'' }>
			<th>根本死因</th>
			<td>${tumor.deathReason}</td>
		<tr id="tumor-deathPlace" ${tumor.death !='1'?'style="display:none"':'' }>
			<th>死亡地点</th>
			<td>
				<ehr:dic dicmeta="DMD00052" code="${tumor.deathPlaceCode }"/>
				<span style="display:${tumor.deathPlaceCode !='4'?'none':'inline' }" id="death-place">
					<u>${tumor.deathPlace }</u>
                        </span>
			</td>
		</tr>
		<tr>
			<th>是否撤销随访</th>
			<td><ehr:dic dicmeta="FS10246" code="${tumor.cancel }"></ehr:dic></td>
		</tr>
		<tr id="tumor-cancelDate" ${tumor.cancel !='1'?'style="display:none"':'' }>
			<th>撤销随访日期</th>
			<td><fmt:formatDate value="${tumor.cancelDate}" pattern="yyyy年MM月dd日"/></td>
		</tr>
		<tr id="tumor-cancelRea" ${tumor.cancel !='1'?'style="display:none"':'' }>
			<th>撤销随访原因</th>
			<td><ehr:dic dicmeta="CDM00006" code="${tumor.cancelReason }" /></td>
		</tr>

		<c:set var="input" value="${tumor}" scope="request"></c:set>
			<tr>
				<th>调查日期</th>
				<td>
					<fmt:formatDate value="${input.createDate}" pattern="yyyy年MM月dd日"/>
				</td>
			</tr>
			<tr>
				<th>调查医师签名</th>
				<td><c:choose>
					<c:when test="${empty input.createDoctorCode}">
					${input.createDoctorName}
					</c:when>
					<c:otherwise>
					<ehr:user userCode='${input.createDoctorCode}' />
					</c:otherwise>
					</c:choose>
				</td>
			</tr>
			<tr>
				<th>调查单位</th>
				<td><ehr:org code="${input.createOrganCode}"></ehr:org></td>
			</tr>
			<tr>
				<th>核查医师签名</th>
				<td>
					<c:choose>
					<c:when test="${empty input.createDoctorCode}">
						${input.createDoctorName}
					</c:when>
					<c:otherwise>
						<ehr:user userCode='${input.createDoctorCode}'/>
					</c:otherwise>
					</c:choose>
				</td>
			</tr>
	</table>
</div>