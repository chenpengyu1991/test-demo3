<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="repeattable">
<c:if test="${not empty traumaHistory}">
    <h3 class="page-header">动物咬伤情况</h3>
    <table>
        <colgroup>
            <col style="width:15%"/>
            <col style="width:35%"/>
            <col style="width:15%"/>
            <col style="width:35%"/>
        </colgroup>
        <tr>
            <th >咬伤日期</th>
            <td><fmt:formatDate value="${traumaHistory.opsDate}" pattern='yyyy/MM/dd HH'/>时</td>
            <th >就诊日期</th>
            <td><fmt:formatDate value="${traumaHistory.treatmentTime}" pattern='yyyy/MM/dd HH'/>时</td>
        </tr>
    </table>
    <table>
        <thead>
        <th class="bg-teal-active text-center">分级</th>
        <th class="bg-teal-active text-center">接触方式</th>
        <th class="bg-teal-active text-center">暴露程度</th>
        <th class="bg-teal-active text-center">医师建议</th>
        </thead>
        <tbody>
        <c:if test="${traumaHistory.biteLevel eq '1'}" >
            <tr>
                <td>
                    <b style="font-size: 16px;">√</b>&nbsp;&nbsp;I级
                </td>
                <td>符合以下情况之一者：<br/>1、接触或喂养动物；<br/>2、完好的皮肤被舔。</td>
                <td class="text-center">无</td>
                <td>确认接触方式可靠则不需处置。</td>
            </tr>
        </c:if>
        <c:if test="${traumaHistory.biteLevel eq '2'}" >
            <tr>
                <td><b style="font-size: 16px;">√</b>&nbsp;&nbsp;II级
                </td>
                <td>符合以下情况之一者：<br/>1、裸露的皮肤被轻咬；<br/>2、无出血的轻微抓伤或擦伤。</td>
                <td class="text-center">轻度</td>
                <td>1、处理伤口；<br/>2、接种人狂犬病疫苗。</td>
            </tr>
        </c:if>
        <c:if test="${traumaHistory.biteLevel eq '3'}" >
            <tr>
                <td>
                    <b style="font-size: 16px;">√</b>&nbsp;&nbsp;III级</td>
                <td>符合以下情况之一者：<br/>1、单处或多处贯穿性皮肤咬伤或抓伤；<br/>2、破损皮肤被舔；<br/>3、开放性伤口或粘膜被污染。</td>
                <td class="text-center">重度</td>
                <td>1、处理伤口；<br/>2、接种人狂犬病疫苗。<br/>3、注射狂犬病人免疫球蛋白。	</td>
            </tr>
        </c:if>
        </tbody>
    </table>
</c:if>

<h3 class="page-header">${situation}</h3>
<table>
    <colgroup >
        <col style="width:11%"/>
        <col style="width:22%"/>
        <col style="width:11%"/>
        <col style="width:22%"/>
        <col style="width:11%"/>
        <col style="width:22%"/>
    <colgroup>
    <tbody>
    <tr>
        <th >接种次数</th>
        <td>
            <c:choose>
                <c:when test="${vaccinationInfo.inoculationTimes eq '1'}">第一次接种</c:when>
                <c:when test="${vaccinationInfo.inoculationTimes eq '2'}">第二次接种</c:when>
                <c:when test="${vaccinationInfo.inoculationTimes eq '3'}">第三次接种</c:when>
                <c:when test="${vaccinationInfo.inoculationTimes eq '4'}">第四次接种</c:when>
                <c:when test="${vaccinationInfo.inoculationTimes eq '5'}">第五次接种</c:when>
            </c:choose>
        </td>
        <th >接种日期</th>
        <td><fmt:formatDate value="${vaccinationInfo.vaccinationDate}" pattern='yyyy/MM/dd'/></td>
        <th >剂量</th>
        <td>${vaccinationInfo.vaccineMeasurement} &nbsp;剂</td>
    </tr>
    <tr>
        <th >生产厂家</th>
        <td>${vaccinationInfo.vaccineFactory}</td>
        <th >疫苗批号</th>
        <td>${vaccinationInfo.vaccineLotNumber}</td>
        <th >接种人</th>
        <td>${vaccinationInfo.vaccinationDoctorName}</td>
    </tr>
    </tbody>
</table>
</div>