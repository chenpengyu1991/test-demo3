<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script data-main="${pageContext.request.contextPath}/js/util/main_report_otf" src="${pageContext.request.contextPath}/js/require/require.js"></script>

<style>
    .posttable th, .posttable td {
        height: 21px;
        line-height: 21px;
        padding: 0 5px;
        table-layout: fixed;
    }
</style>
<form id="editForm" class="postcontent">
	<div class="postdiv" id="addDiv" style="padding-top: 150px;">
        <i class="popno" style="height: auto">市居民转诊、转院院内流转单</i>
		<fieldset>
			<table class="posttable">
				<colgroup>
					<col style="width: 20%"/>
					<col style="width: 25%"/>
					<col style="width: 15%"/>
					<col />
				</colgroup>
				<tbody>
                <tr>
                    <th>医疗机构名称</th>
                    <td>
                        <ehr:org code="${outTransfer.fromOrganCode}"></ehr:org>
                        <input type="hidden" id="print1Id" value="${outTransfer.id}">
                    </td>
                    <th>编号</th>
                    <td>
                        ${outTransfer.serialNumber}
                    </td>
                </tr>
                <tr>
                    <th>姓名</th>
                    <td>${outTransfer.name}
                    </td>
                    <th>性别</th>
                    <td>
                        <c:choose>
                            <c:when test="${outTransfer.gender == 0}">未知的性别</c:when>
                            <c:when test="${outTransfer.gender == 1}">男</c:when>
                            <c:when test="${outTransfer.gender == 2}">女</c:when>
                            <c:when test="${outTransfer.gender == 9}">未说明的性别</c:when>
                        </c:choose>
                    </td>
                </tr>
				<tr>
                    <th>出生日期</th>
                    <td><fmt:formatDate value="${outTransfer.birthdate}" pattern="yyyy/MM/dd"></fmt:formatDate>
                    <tag:dateInput name="birthdate" date="${outTransfer.birthdate}" style="display:none;" />
                    </td>
                    <th>门诊/住院号</th>
					<td>
                        ${outTransfer.outNo}
				</tr>
				<tr>
					<th>保险编号</th>
					<td>${outTransfer.insuranceNo}
                    </td>
                    <th>身份证号</th>
                    <td>
                        ${outTransfer.idcard}
				</tr>
				<tr>
					<th>初步诊断</th>
					<td>
                        ${outTransfer.icdName}(${outTransfer.icdCode})
                    </td>
                    <th>病人类型</th>
                    <td><ehr:dic code="${outTransfer.patientType}" dicmeta="CV0710003"></ehr:dic></td>
                </tr>
                <tr>
                    <th>转何地、何院</th>
                    <td colspan="3">
                        <c:if test="${outTransfer.toOrganCode != 699999}"><ehr:dic dicmeta="OT00002" code="${outTransfer.toOrganCode}" ></ehr:dic></c:if>
                        <%--<c:if test="${outTransfer.toOrganCode == 699999}">${outTransfer.toOrganOther}</c:if>--%>
                    </td>
                </tr>
                <tr>
                    <th>诊治医生</th>
                    <td>
                        ${outTransfer.doctor}</td>
                    <th>科室</th>
                    <td>${outTransfer.fromOfficeName}</td>
                </tr>
                <tr>

                    <th>科主任</th>
                    <td>${outTransfer.director}</td>
                    <th>转出日期</th>
                    <td>
                        <fmt:formatDate value="${outTransfer.transferDt}" pattern="yyyy/MM/dd"></fmt:formatDate>
                    </td>
                </tr>
                <tr>
                    <th>病情摘要<br/>(转诊、院理由)</th>
                    <td colspan="3" style="word-break: break-all; word-wrap:break-word;">
                        <div style="height: 80px;">${outTransfer.summary}</div>
                    </td>
                </tr>
                <tr>
                    <th style="border-right: none"></th>
                    <td colspan="3">备注：转诊病人应在转诊当日、急诊病人在七个工作日内持本流转单到医务科（医保办）完成转诊登记审批，逾期无效。</td>
                </tr>
                <tr>
                    <td colspan="4" style="text-align: right">医务科（医保办）电话：<input type="text" style="width: 150px; "></td>
                </tr>
				</tbody>
			</table>
		</fieldset>
	</div>
</form>