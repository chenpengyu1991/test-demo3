<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script data-main="${pageContext.request.contextPath}/js/util/main_report_otf" src="${pageContext.request.contextPath}/js/require/require.js"></script>

<div class="toolbar">
	<a href="javascript:void(0)" id="saveAndPrint1"><b class="baocun">保存并打印</b></a>
	<a href="javascript:void(0)" id="print1" style="display: none"><b class="baocun">打印</b></a>
</div>
<form id="editForm" class="postcontent">
	<div class="postdiv" id="addDiv">
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
                        <input type="hidden" id="print1Id">
                        <input type="hidden" name="fromOrganCode" value="${outTransfer.fromOrganCode}">
                        <input type="hidden" name="inFromOrganCode" value="${outTransfer.inFromOrganCode}">
                    </td>
                    <th>编号</th>
                    <td>
                        ${outTransfer.serialNumber}<input type="hidden" name="serialNumber" value="${outTransfer.serialNumber}">
                    </td>
                </tr>
                <tr>
                    <th>姓名</th>
                    <td>${outTransfer.name}
                        <input type="hidden" name="name" value="${outTransfer.name}"/>
                    </td>
                    <th>性别</th>
                    <td>
                        <%--<ehr:dic dicmeta="GBT226112003" code="${outTransfer.gender}"></ehr:dic>--%>
                        <c:choose>
                            <c:when test="${outTransfer.gender == 0}">未知的性别</c:when>
                            <c:when test="${outTransfer.gender == 1}">男</c:when>
                            <c:when test="${outTransfer.gender == 2}">女</c:when>
                            <c:when test="${outTransfer.gender == 9}">未说明的性别</c:when>
                        </c:choose>
                        <input type="hidden" name="gender" value="${outTransfer.gender}">
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
                        <input type="hidden" name="outNo" value="${outTransfer.outNo}"></td>
				</tr>
				<tr>
					<th>保险编号</th>
					<td>${outTransfer.insuranceNo}
                        <input type="hidden" name="insuranceNo" value="${outTransfer.insuranceNo}"/>
                    </td>
                    <th>身份证号</th>
                    <td>
                        ${outTransfer.idcard}
                        <input type="hidden" name="idcard" value="${outTransfer.idcard}"/></td>
				</tr>
				<tr>
					<th>初步诊断</th>
					<td>
                        <%--${outTransfer.diagnose}--%>
                        ${outTransfer.icdName}(${outTransfer.icdCode})
                        <input type="hidden" name="diagnose" value="${outTransfer.diagnose}">
                    </td>
                    <th>病人类型</th>
                    <td>
                        <ehr:dic code="${outTransfer.patientType}" dicmeta="CV0710003"></ehr:dic>
                        <input type="hidden" name="patientType" value="${outTransfer.patientType}">
                </tr>
                <tr>
                    <th><label class="required">转何地、何院</label></th>
                    <td colspan="3">
                        <ehr:dic-list name="toOrganCode" dicmeta="OT00002" value="${outTransfer.toOrganCode}" onchange="toggleOtherSC('toOrganCode','toOrganOtherId','699999')" reg="{'required':'true'}" width="480px;"/>
                        <span id="toOrganOtherId"><input type="text" name="toOrganOther" value="${outTransfer.toOrganOther}" style="width: 150px;"></span>
                        <label style="color: red">必须选择</label>
                    </td>
                </tr>
                <tr>
                    <th>诊治医生</th>
                    <td>
                        ${outTransfer.doctor}
                        <input type="hidden" name="doctor" value="${outTransfer.doctor}"></td>
                    <th>科室</th>
                    <td>${outTransfer.fromOfficeName}<input type="hidden" name="fromOfficeCode" value="${outTransfer.fromOfficeCode}"></td>
                </tr>
                <tr>

                    <th>科主任</th>
                    <td><input type="text" name="director" value="${outTransfer.director}" reg="{'maxlength':16}" style="width: 180px"></td>
                    <th>转出日期</th>
                    <td>
                        <fmt:formatDate value="${outTransfer.transferDt}" pattern="yyyy/MM/dd"></fmt:formatDate>
                        <tag:dateInput name="transferDt" date="${outTransfer.transferDt}" style="display:none;"/>
                    </td>
                </tr>
                <tr>
                </tr>
                <tr>
                    <th><label class="required">病情摘要(转诊、院理由)</label></th>
                    <td colspan="3"><textarea name="summary" cols="30" rows="3" reg="{'maxlength':128,'required':'true'}" style="width: 70%">${outTransfer.summary}</textarea><label style="color: red">必须填写，字数不能超过128个</label></td>
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
    <input type="hidden" name="icdCode" value="${outTransfer.icdCode}">
    <input type="hidden" name="icdName" value="${outTransfer.icdName}">
    <input type="hidden" name="createTransferUserCode" value="${outTransfer.createTransferUserCode}">
    <input type="hidden" name="createTransferUser" value="${outTransfer.createTransferUser}">
    <input type="hidden" name="fromType" value="${outTransfer.fromType}">
    <input type="hidden" name="fromOfficeCode" value="${outTransfer.fromOfficeCode}">
    <input type="hidden" name="fromOfficeName" value="${outTransfer.fromOfficeName}">
</form>