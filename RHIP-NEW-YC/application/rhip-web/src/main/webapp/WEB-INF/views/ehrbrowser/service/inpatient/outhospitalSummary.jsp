<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/ehr-tag" prefix="ehr"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>

<div id="printPage" class="postcontentprint">
    <c:set var="outhospitalSummary" value="${outhospitalSummaryDto.outhospitalSummary}" scope="request"></c:set>
    <c:set var="surgeryInfos" value="${outhospitalSummaryDto.surgeryInfos}" scope="request"></c:set>

    <i class="popno">
        出 院 记 录
    </i>

    <div class="postdiv">
        <table class="printposttable">
            <colgroup>
                <col style="width: 25%;">
                <col style="width: 25%;">
                <col style="width: 25%;">
                <col style="width: 25%;">
            </colgroup>
            <tbody>
            <tr>
                <td>科别：<c:out value="${outhospitalSummary.departmentName }"></c:out></td>
                <td>病区：<c:out value="${outhospitalSummary.sickAreaName }"></c:out></td>
                <td>床号：<c:out value="${outhospitalSummary.sickbedNo }"></c:out></td>
                <td>住院号：<c:out value="${outhospitalSummary.admissionNo }"></c:out></td>
            </tr>
            </tbody>
        </table>
        <table class="printposttable">
            <c:set value="${fn:length(surgeryInfos) }" var="surSize"></c:set>
            <colgroup>
                <col style="width: 20%;">
                <col style="width: 20%;">
                <col style="width: 20%;">
                <col style="width: 20%;">
                <col style="width: 20%;">
            </colgroup>
            <tr>
                <td style="border: 1px solid #000;">姓名：<c:out value="${outhospitalSummary.name }"></c:out></td>
                <td style="border: 1px solid #000;">性别：<ehr:dic dicmeta="GBT226112003" code="${outhospitalSummary.gender }" /></td>
                <td style="border: 1px solid #000;">年龄：<c:out value="${outhospitalSummary.age }"></c:out></td>
                <td style="border: 1px solid #000;">婚姻：<ehr:dic dicmeta="GBT226122003" code="${outhospitalSummary.marriage}" /></td>
                <td style="border: 1px solid #000;">职业：<tags:textWithDic value="${outhospitalSummary.occupationName}" dicmeta="GBT6565" code="${outhospitalSummary.occupation}" /></td>
            </tr>
            <tr>
                <td colspan="3" style="border: 1px solid #000;">
                    <div style="min-height: 60px;">入院诊断：
                    <c:forEach items="${outhospitalSummaryDto.inHosDiseaseDiagnosisInfos }" var="disease" varStatus="status">
                    ${status.index+1}.<c:out value="${disease.diagnosisDesc }"></c:out>
                    </c:forEach>
                    </div>
                </td>
                <td colspan="2" style="vertical-align: top; border: 1px solid #000;">入院日期：<fmt:formatDate pattern="yyyy/MM/dd HH:mm:ss" value="${outhospitalSummary.inhosDate }" /></td>
            </tr>
            <tr>
                <td colspan="5" style="border: 1px solid #000;">
                    <div class="repeattable" style="margin-top: 10px;">
                        <table>
                            <thead>
                            <tr>
                                <th class="centerth">手术名称</th>
                                <th class="centerth">手术日期</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach begin="0" items="${surgeryInfos}" var="surgeryInfo">
                                <tr>
                                    <td>${surgeryInfo.opertationName }</td>
                                    <td><fmt:formatDate value="${surgeryInfo.opertationDate }" pattern="yyyy/MM/dd" /></td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </td>
            <tr>
                <td colspan="3"  style="border: 1px solid #000;">
                    <div style="min-height: 60px;">出院诊断：
                    <c:forEach items="${outhospitalSummaryDto.outHosDiseaseDiagnosisInfos }" var="disease" varStatus="status">
                    ${status.index+1}.<c:out value="${disease.diagnosisDesc }"></c:out>
                    </c:forEach>
                    </div>
                </td>
                <td colspan="2" style="vertical-align: top; border: 1px solid #000;">出院日期：<fmt:formatDate pattern="yyyy/MM/dd" value="${outhospitalSummary.outhosDate}" /></td>
            </tr>
            <tr>
                <td colspan="5" style="vertical-align: top; border: 1px solid #000;">
                    <div style="min-height: 60px;"><b>入院时情况：</b><c:out value="${outhospitalSummary.inhosState }"></c:out></div>
                </td>
            </tr>
            <tr>
                <td colspan="5" style="vertical-align: top; border: 1px solid #000;">
                    <div style="min-height: 60px;"><b>住院经过：</b><c:out value="${outhospitalSummary.treatmentProcessDesc }"></c:out></div>
                </td>
            </tr>
            <tr>
                <td colspan="5" style="vertical-align: top; border: 1px solid #000;">
                    <div style="min-height: 60px;"><b>出院情况：</b><c:out value="${outhospitalSummary.outhosState}"></c:out></div>
                </td>
            </tr>
            <tr>
                <td colspan="5" style="vertical-align: top; border: 1px solid #000;">
                    <div style="min-height: 60px;"><b>出院医嘱：</b><c:out value="${outhospitalSummary.outhosAdvice}"></c:out></div>
                </td>
                <%--<td colspan="2" style="border: 1px solid #000;"></td>--%>
            </tr>
            <%--<tr>--%>
                <%--<td colspan="2" style="border: 1px solid #000;"></td>--%>
            <%--</tr>--%>
        </table>
        <table class="printposttable">
            <colgroup>
                <col style="width: 50%;">
                <col style="width: 50%; text-align: right;">
            </colgroup>
            <tbody>
            <tr>
                <td>主治医师：<span><c:out value="${outhospitalSummary.attendingDoctorSignature }"></c:out></span></td>
                <td>医师:<span><c:out value="${outhospitalSummary.doctorSignature}"></c:out></span></td>
            </tr>
            </tbody>
        </table>
    </div>
</div>

<%--<div class="report_box">--%>
	<%--<c:set var="outhospitalSummary" value="${outhospitalSummaryDto.outhospitalSummary}" scope="request"></c:set>--%>
	<%--<c:set var="surgeryInfos" value="${outhospitalSummaryDto.surgeryInfos}" scope="request"></c:set>--%>

	<%--<div align="center">--%>
		<%--<h1>--%>
			<%--<c:out value="${outhospitalSummary.hospitalName }"></c:out>--%>
		<%--</h1>--%>
	<%--</div>--%>
	<%--<div align="center">出 院 记 录</div>--%>
	<%--<table class="layout_table">--%>
		<%--<tr>--%>
			<%--<td>科别</td>--%>
			<%--<td><c:out value="${outhospitalSummary.departmentName }"></c:out></td>--%>
			<%--<td>病区</td>--%>
			<%--<td colspan="3"><c:out value="${outhospitalSummary.sickAreaName }"></c:out></td>--%>
			<%--<td>床号</td>--%>
			<%--<td><c:out value="${outhospitalSummary.sickbedNo }"></c:out></td>--%>
			<%--<td>住院号</td>--%>
			<%--<td colspan="3"><c:out value="${outhospitalSummary.admissionNo }"></c:out></td>--%>
		<%--</tr>--%>
		<%--<tr>--%>
			<%--<td>姓名</td>--%>
			<%--<td><c:out value="${outhospitalSummary.name }"></c:out></td>--%>
			<%--<td>性别</td>--%>
			<%--<td><ehr:dic dicmeta="GBT226112003" code="${outhospitalSummary.gender }" /></td>--%>
			<%--<td>年龄</td>--%>
			<%--<td><c:out value="${outhospitalSummary.age }"></c:out></td>--%>
			<%--<td>婚姻</td>--%>
			<%--<td><ehr:dic dicmeta="GBT226122003" code="${outhospitalSummary.marriage}" /></td>--%>
			<%--<td>职业</td>--%>
			<%--<td><tags:textWithDic value="${outhospitalSummary.occupationName}" dicmeta="GBT6565A1" code="${outhospitalSummary.occupation}" /></td>--%>

		<%--</tr>--%>
	<%--</table>--%>
	<%--<table class="formtable">--%>
		<%--<tr>--%>
			<%--<td style="width: 15%">入院诊断</td>--%>
			<%--<td style="width: 55%"><c:forEach items="${outhospitalSummaryDto.inHosDiseaseDiagnosisInfos }" var="disease" varStatus="status">--%>
				<%--${status.index+1}.<c:out value="${disease.diagnosisDesc }"></c:out>--%>
				<%--</c:forEach></td>--%>
			<%--<td style="width: 15%">入院日期</td>--%>
			<%--<td style="width: 15%"><fmt:formatDate pattern="yyyy/MM/dd" value="${outhospitalSummary.inhosDate }" /></td>--%>
		<%--</tr>--%>

		<%--<c:set value="${fn:length(surgeryInfos) }" var="surSize"></c:set>--%>
		<%----%>
		<%--<tr>--%>
			<%--<td rowspan="${surSize }">手术名称</td>--%>
			<%--<td>${surgeryInfos[0].opertationName }</td>--%>
			<%--<td rowspan="${surSize }">手术日期</td>--%>
			<%--<td><fmt:formatDate value="${surgeryInfos[0].opertationDate }" pattern="yyyy/MM/dd" /></td>--%>
		<%--</tr>--%>


		<%--<c:forEach begin="1" items="${surgeryInfos}" var="surgeryInfo">--%>
			<%--<tr>--%>
				<%--<td>${surgeryInfo.opertationName }</td>--%>
				<%--<td><fmt:formatDate value="${surgeryInfo.opertationDate }" pattern="yyyy/MM/dd" /></td>--%>
			<%--</tr>--%>
		<%--</c:forEach>--%>

		<%--<tr>--%>
			<%--<td>出院诊断</td>--%>
			<%--<td style="height: 40px"><c:forEach items="${outhospitalSummaryDto.outHosDiseaseDiagnosisInfos }" var="disease" varStatus="status">--%>
						<%--${status.index+1}.<c:out value="${disease.diagnosisDesc }"></c:out>--%>
				<%--</c:forEach></td>--%>
			<%--<td>出院日期</td>--%>
			<%--<td><fmt:formatDate pattern="yyyy/MM/dd" value="${outhospitalSummary.outhosDate}" /></td>--%>
		<%--</tr>--%>
		<%--<tr>--%>
			<%--<td>入院时情况</td>--%>
			<%--<td colspan="3" style="height: 80px"><c:out value="${outhospitalSummary.inhosState }"></c:out></td>--%>
		<%--</tr>--%>
		<%--<tr>--%>
			<%--<td>住院经过</td>--%>
			<%--<td colspan="3" style="height: 80px"><c:out value="${outhospitalSummary.treatmentProcessDesc }"></c:out></td>--%>
		<%--</tr>--%>


		<%--<tr>--%>
			<%--<td>出院情况</td>--%>
			<%--<td colspan="3" style="height: 80px"><c:out value="${outhospitalSummary.outhosState}"></c:out></td>--%>
		<%--</tr>--%>
		<%--<tr>--%>
			<%--<td>出院医嘱</td>--%>
			<%--<td colspan="3" style="height: 80px" ><c:out value="${outhospitalSummary.outhosAdvice}"></c:out></td>--%>
		<%--</tr>--%>
	<%--</table>--%>

	<%--<div>--%>
		<%--<div style="float: right; width: 100px;">--%>
			<%--主治医师:<span><c:out value="${outhospitalSummary.attendingDoctorSignature }"></c:out></span>--%>
		<%--</div>--%>
		<%--<div style="float: right; width: 100px;">--%>
			<%--医师:<span><c:out value="${outhospitalSummary.doctorSignature}"></c:out></span>--%>
		<%--</div>--%>
	<%--</div>--%>


<%--</div>--%>