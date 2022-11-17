<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr" %>


<div class="repeattable" style="width:100%;overflow:auto;height:440px;">
    <table id="healthVaccinationTable" class="layui-table x-admin-sm-table-list-middle">
        <colgroup>
            <col style="width: 60px;"/>
            <col style="width: 120px;"/>
            <col style="width: 40px;"/>
            <col style="width: 40px;"/>
            <col style="width: 55px;"/>
            <col style="width: 40px;"/>
            <col style="width: 40px;"/>
            <col style="width: 55px;"/>
            <col style="width: 40px;"/>
            <col style="width: 40px;"/>
            <col style="width: 55px;"/>
            <col style="width: 40px;"/>
            <col style="width: 40px;"/>
            <col style="width: 55px;"/>
            <col style="width: 40px;"/>
            <col style="width: 40px;"/>
            <col style="width: 55px;"/>
            <col style="width: 40px;"/>
            <col style="width: 40px;"/>
            <col style="width: 55px;"/>
            <col style="width: 40px;"/>
            <col style="width: 40px;"/>
            <col style="width: 55px;"/>
            <col style="width: 40px;"/>
            <col style="width: 40px;"/>
            <col style="width: 55px;"/>
            <col style="width: 40px;"/>
            <col style="width: 40px;"/>
            <col style="width: 55px;"/>
            <col style="width: 40px;"/>
            <col style="width: 40px;"/>
            <col style="width: 55px;"/>
            <col style="width: 40px;"/>
            <col style="width: 40px;"/>
            <col style="width: 55px;"/>
        </colgroup>
        <thead>
        <tr>
            <th rowspan="2">区县</th>
            <th rowspan="2">机构</th>
            <th colspan="3">预防接种证</th>
            <th colspan="3">乙肝疫苗</th>
            <th colspan="3">卡介苗</th>
            <th colspan="3">脊灰疫苗</th>
            <th colspan="3">百白破疫苗</th>
            <th colspan="3">含麻疹成分疫苗</th>
            <th colspan="3">流脑疫苗</th>
            <th colspan="3">乙脑疫苗</th>
            <th colspan="3">甲肝疫苗</th>
            <th colspan="3">白破疫苗</th>
            <th colspan="3">A+C群流脑疫苗</th>
        </tr>
        <tr>
            <th>辖区内应建立人数</th>
            <th>辖区内已建立人数</th>
            <th>建证率</th>
            <th>辖区内应接种人数</th>
            <th>辖区内实际接种人数</th>
            <th>接种率</th>
            <th>辖区内应接种人数</th>
            <th>辖区内实际接种人数</th>
            <th>接种率</th>
            <th>辖区内应接种人数</th>
            <th>辖区内实际接种人数</th>
            <th>接种率</th>
            <th>辖区内应接种人数</th>
            <th>辖区内实际接种人数</th>
            <th>接种率</th>
            <th>辖区内应接种人数</th>
            <th>辖区内实际接种人数</th>
            <th>接种率</th>
            <th>辖区内应接种人数</th>
            <th>辖区内实际接种人数</th>
            <th>接种率</th>
            <th>辖区内应接种人数</th>
            <th>辖区内实际接种人数</th>
            <th>接种率</th>
            <th>辖区内应接种人数</th>
            <th>辖区内实际接种人数</th>
            <th>接种率</th>
            <th>辖区内应接种人数</th>
            <th>辖区内实际接种人数</th>
            <th>接种率</th>
            <th>辖区内应接种人数</th>
            <th>辖区内实际接种人数</th>
            <th>接种率</th>
        </tr>
        </thead>
        <tbody id="displayBody">
        <c:forEach var="report" items="${reports}">
            <tr>
                <td>
                    <ehr:tip><ehr:dic code="${report.gbCode}" dicmeta="FS990001"/></ehr:tip>
                </td>
                <td>
                    <ehr:tip><ehr:org code="${report.orgCode}"/></ehr:tip>
                </td>
                <!-- 预防接种证 -->
                <td title="${report.certificateShouldNum}">${report.certificateShouldNum}</td>
                <td title="${report.certificateHasNum}">${report.certificateHasNum}</td>
                <td title="<fmt:formatNumber value="${report.certificateShouldNum==0?0:(report.certificateHasNum/report.certificateShouldNum)*100}" pattern="#,##0.0"/>%">
                    <fmt:formatNumber
                            value="${report.certificateShouldNum==0?0:(report.certificateHasNum/report.certificateShouldNum)*100}"
                            pattern="#,##0.0"/>%
                </td>

                <!-- 乙肝疫苗 -->
                <td title="${report.hepatitisShouldNum}">${report.hepatitisShouldNum}</td>
                <td title="${report.hepatitisHasNum}">${report.hepatitisHasNum}</td>
                <td title="<fmt:formatNumber value="${report.hepatitisShouldNum==0?0:(report.hepatitisHasNum/report.hepatitisShouldNum)*100}" pattern="#,##0.0"/>%">
                    <fmt:formatNumber
                            value="${report.hepatitisShouldNum==0?0:(report.hepatitisHasNum/report.hepatitisShouldNum)*100}"
                            pattern="#,##0.0"/>%
                </td>

                <!-- 卡介苗 -->
                <td title="${report.bcgShouldNum}">${report.bcgShouldNum}</td>
                <td title="${report.bcgHasNum}">${report.bcgHasNum}</td>
                <td title="<fmt:formatNumber value="${report.bcgShouldNum==0?0:(report.bcgHasNum/report.bcgShouldNum)*100}" pattern="#,##0.0"/>%">
                    <fmt:formatNumber value="${report.bcgShouldNum==0?0:(report.bcgHasNum/report.bcgShouldNum)*100}"
                                      pattern="#,##0.0"/>%
                </td>

                <!-- 脊灰疫苗 -->
                <td title="${report.polioShouldNum}">${report.polioShouldNum}</td>
                <td title="${report.polioHasNum}">${report.polioHasNum}</td>
                <td title="<fmt:formatNumber value="${report.polioShouldNum==0?0:(report.polioHasNum/report.polioShouldNum)*100}" pattern="#,##0.0"/>%">
                    <fmt:formatNumber
                            value="${report.polioShouldNum==0?0:(report.polioHasNum/report.polioShouldNum)*100}"
                            pattern="#,##0.0"/>%
                </td>

                <!-- 百白破疫苗 -->
                <td title="${report.dptShouldNum}">${report.dptShouldNum}</td>
                <td title="${report.dptHasNum}">${report.dptHasNum}</td>
                <td title="<fmt:formatNumber value="${report.dptShouldNum==0?0:(report.dptHasNum/report.dptShouldNum)*100}" pattern="#,##0.0"/>%">
                    <fmt:formatNumber value="${report.dptShouldNum==0?0:(report.dptHasNum/report.dptShouldNum)*100}"
                                      pattern="#,##0.0"/>%
                </td>

                <!-- 含麻疹成分疫苗 -->
                <td title="${report.measlesconstitShouldNum}">${report.measlesconstitShouldNum}</td>
                <td title="${report.measlesconstitHasNum}">${report.measlesconstitHasNum}</td>
                <td title="<fmt:formatNumber value="${report.measlesconstitShouldNum==0?0:(report.measlesconstitHasNum/report.measlesconstitShouldNum)*100}" pattern="#,##0.0"/>%">
                    <fmt:formatNumber
                            value="${report.measlesconstitShouldNum==0?0:(report.measlesconstitHasNum/report.measlesconstitShouldNum)*100}"
                            pattern="#,##0.0"/>%
                </td>

                <!--流脑疫苗  -->
                <td title="${report.ameningococcalShouldNum}">${report.ameningococcalShouldNum}</td>
                <td title="${report.ameningococcalHasNum}">${report.ameningococcalHasNum}</td>
                <td title="<fmt:formatNumber value="${report.ameningococcalShouldNum==0?0:(report.ameningococcalHasNum/report.ameningococcalShouldNum)*100}" pattern="#,##0.0"/>%">
                    <fmt:formatNumber
                            value="${report.ameningococcalShouldNum==0?0:(report.ameningococcalHasNum/report.ameningococcalShouldNum)*100}"
                            pattern="#,##0.0"/>%
                </td>

                <!-- 乙脑疫苗 -->
                <td title="${report.encephalitisShouldNum}">${report.encephalitisShouldNum}</td>
                <td title="${report.encephalitisHasNum}">${report.encephalitisHasNum}</td>
                <td title="<fmt:formatNumber value="${report.encephalitisShouldNum==0?0:(report.encephalitisHasNum/report.encephalitisShouldNum)*100}" pattern="#,##0.0"/>%">
                    <fmt:formatNumber
                            value="${report.encephalitisShouldNum==0?0:(report.encephalitisHasNum/report.encephalitisShouldNum)*100}"
                            pattern="#,##0.0"/>%
                </td>

                <!-- 甲肝疫苗 -->
                <td title="${report.havShouldNum}">${report.havShouldNum}</td>
                <td title="${report.havHasNum}">${report.havHasNum}</td>
                <td title="<fmt:formatNumber value="${report.havShouldNum==0?0:(report.havHasNum/report.havShouldNum)*100}" pattern="#,##0.0"/>%">
                    <fmt:formatNumber value="${report.havShouldNum==0?0:(report.havHasNum/report.havShouldNum)*100}"
                                      pattern="#,##0.0"/>%
                </td>

                <!-- 白破疫苗 -->
                <td title="${report.whiteVaccineShouldNum}">${report.whiteVaccineShouldNum}</td>
                <td title="${report.whiteVaccineHasNum}">${report.whiteVaccineHasNum}</td>
                <td title="<fmt:formatNumber value="${report.whiteVaccineShouldNum==0?0:(report.whiteVaccineHasNum/report.whiteVaccineShouldNum)*100}" pattern="#,##0.0"/>%">
                    <fmt:formatNumber
                            value="${report.whiteVaccineShouldNum==0?0:(report.whiteVaccineHasNum/report.whiteVaccineShouldNum)*100}"
                            pattern="#,##0.0"/>%
                </td>

                <!-- A+C群流脑疫苗 -->
                <td title="${report.acmeningococcalShouldNum}">${report.acmeningococcalShouldNum}</td>
                <td title="${report.havHasNum}">${report.acmeningococcalHasNum}</td>
                <td title="<fmt:formatNumber value="${report.acmeningococcalShouldNum==0?0:(report.acmeningococcalHasNum/report.acmeningococcalShouldNum)*100}" pattern="#,##0.0"/>%">
                    <fmt:formatNumber
                            value="${report.acmeningococcalShouldNum==0?0:(report.acmeningococcalHasNum/report.acmeningococcalShouldNum)*100}"
                            pattern="#,##0.0"/>%
                </td>
            </tr>
        </c:forEach>
        <c:if test="${vaccinationServiceDto!=null}">
            <tr>
                <td colspan="2"><strong>合计</strong></td>
                <!-- 预防接种证 -->
                <td title="${vaccinationServiceDto.certificateShouldNum}">${vaccinationServiceDto.certificateShouldNum}</td>
                <td title="${vaccinationServiceDto.certificateHasNum}">${vaccinationServiceDto.certificateHasNum}</td>
                <td title="<fmt:formatNumber value="${vaccinationServiceDto.certificateShouldNum==0?0:(vaccinationServiceDto.certificateHasNum/vaccinationServiceDto.certificateShouldNum)*100}" pattern="#,##0.0"/>%">
                    <fmt:formatNumber
                            value="${vaccinationServiceDto.certificateShouldNum==0?0:(vaccinationServiceDto.certificateHasNum/vaccinationServiceDto.certificateShouldNum)*100}"
                            pattern="#,##0.0"/>%
                </td>

                <!--乙肝疫苗  -->
                <td title="${vaccinationServiceDto.hepatitisShouldNum}">${vaccinationServiceDto.hepatitisShouldNum}</td>
                <td title="${vaccinationServiceDto.hepatitisHasNum}">${vaccinationServiceDto.hepatitisHasNum}</td>
                <td title="<fmt:formatNumber value="${vaccinationServiceDto.hepatitisShouldNum==0?0:(vaccinationServiceDto.hepatitisHasNum/vaccinationServiceDto.hepatitisShouldNum)*100}" pattern="#,##0.0"/>%">
                    <fmt:formatNumber
                            value="${vaccinationServiceDto.hepatitisShouldNum==0?0:(vaccinationServiceDto.hepatitisHasNum/vaccinationServiceDto.hepatitisShouldNum)*100}"
                            pattern="#,##0.0"/>%
                </td>

                <!-- 卡介苗 -->
                <td title="${vaccinationServiceDto.bcgShouldNum}">${vaccinationServiceDto.bcgShouldNum}</td>
                <td title="${vaccinationServiceDto.bcgHasNum}">${vaccinationServiceDto.bcgHasNum}</td>
                <td title="<fmt:formatNumber value="${vaccinationServiceDto.bcgShouldNum==0?0:(vaccinationServiceDto.bcgHasNum/vaccinationServiceDto.bcgShouldNum)*100}" pattern="#,##0.0"/>%">
                    <fmt:formatNumber
                            value="${vaccinationServiceDto.bcgShouldNum==0?0:(vaccinationServiceDto.bcgHasNum/vaccinationServiceDto.bcgShouldNum)*100}"
                            pattern="#,##0.0"/>%
                </td>

                <!-- 脊灰疫苗 -->
                <td title="${vaccinationServiceDto.polioShouldNum}">${vaccinationServiceDto.polioShouldNum}</td>
                <td title="${vaccinationServiceDto.polioHasNum}">${vaccinationServiceDto.polioHasNum}</td>
                <td title="<fmt:formatNumber value="${vaccinationServiceDto.polioShouldNum==0?0:(vaccinationServiceDto.polioHasNum/vaccinationServiceDto.polioShouldNum)*100}" pattern="#,##0.0"/>%">
                    <fmt:formatNumber
                            value="${vaccinationServiceDto.polioShouldNum==0?0:(vaccinationServiceDto.polioHasNum/vaccinationServiceDto.polioShouldNum)*100}"
                            pattern="#,##0.0"/>%
                </td>

                <!-- 百白破疫苗 -->
                <td title="${vaccinationServiceDto.dptShouldNum}">${vaccinationServiceDto.dptShouldNum}</td>
                <td title="${vaccinationServiceDto.dptHasNum}">${vaccinationServiceDto.dptHasNum}</td>
                <td title="<fmt:formatNumber value="${vaccinationServiceDto.dptShouldNum==0?0:(vaccinationServiceDto.dptHasNum/vaccinationServiceDto.dptShouldNum)*100}" pattern="#,##0.0"/>%">
                    <fmt:formatNumber
                            value="${vaccinationServiceDto.dptShouldNum==0?0:(vaccinationServiceDto.dptHasNum/vaccinationServiceDto.dptShouldNum)*100}"
                            pattern="#,##0.0"/>%
                </td>

                <!-- 含麻疹成分疫苗 -->
                <td title="${vaccinationServiceDto.measlesconstitShouldNum}">${vaccinationServiceDto.measlesconstitShouldNum}</td>
                <td title="${vaccinationServiceDto.measlesconstitHasNum}">${vaccinationServiceDto.measlesconstitHasNum}</td>
                <td title="<fmt:formatNumber value="${vaccinationServiceDto.measlesconstitShouldNum==0?0:(vaccinationServiceDto.measlesconstitHasNum/vaccinationServiceDto.measlesconstitShouldNum)*100}" pattern="#,##0.0"/>%">
                    <fmt:formatNumber
                            value="${vaccinationServiceDto.measlesconstitShouldNum==0?0:(vaccinationServiceDto.measlesconstitHasNum/vaccinationServiceDto.measlesconstitShouldNum)*100}"
                            pattern="#,##0.0"/>%
                </td>

                <!--流脑疫苗  -->
                <td title="${vaccinationServiceDto.ameningococcalShouldNum}">${vaccinationServiceDto.ameningococcalShouldNum}</td>
                <td title="${vaccinationServiceDto.ameningococcalHasNum}">${vaccinationServiceDto.ameningococcalHasNum}</td>
                <td title="<fmt:formatNumber value="${vaccinationServiceDto.ameningococcalShouldNum==0?0:(vaccinationServiceDto.ameningococcalHasNum/vaccinationServiceDto.ameningococcalShouldNum)*100}" pattern="#,##0.0"/>%">
                    <fmt:formatNumber
                            value="${vaccinationServiceDto.ameningococcalShouldNum==0?0:(vaccinationServiceDto.ameningococcalHasNum/vaccinationServiceDto.ameningococcalShouldNum)*100}"
                            pattern="#,##0.0"/>%
                </td>

                <!-- 乙脑疫苗 -->
                <td title="${vaccinationServiceDto.encephalitisShouldNum}">${vaccinationServiceDto.encephalitisShouldNum}</td>
                <td title="${vaccinationServiceDto.encephalitisHasNum}">${vaccinationServiceDto.encephalitisHasNum}</td>
                <td title="<fmt:formatNumber value="${vaccinationServiceDto.encephalitisShouldNum==0?0:(vaccinationServiceDto.encephalitisHasNum/vaccinationServiceDto.encephalitisShouldNum)*100}" pattern="#,##0.0"/>%">
                    <fmt:formatNumber
                            value="${vaccinationServiceDto.encephalitisShouldNum==0?0:(vaccinationServiceDto.encephalitisHasNum/vaccinationServiceDto.encephalitisShouldNum)*100}"
                            pattern="#,##0.0"/>%
                </td>

                <!-- 甲肝疫苗 -->
                <td title="${vaccinationServiceDto.havShouldNum}">${vaccinationServiceDto.havShouldNum}</td>
                <td title="${vaccinationServiceDto.havHasNum}">${vaccinationServiceDto.havHasNum}</td>
                <td title="<fmt:formatNumber value="${vaccinationServiceDto.havShouldNum==0?0:(vaccinationServiceDto.havHasNum/vaccinationServiceDto.havShouldNum)*100}" pattern="#,##0.0"/>%">
                    <fmt:formatNumber
                            value="${vaccinationServiceDto.havShouldNum==0?0:(vaccinationServiceDto.havHasNum/vaccinationServiceDto.havShouldNum)*100}"
                            pattern="#,##0.0"/>%
                </td>

                <!-- 白破疫苗 -->
                <td title="${vaccinationServiceDto.whiteVaccineShouldNum}">${vaccinationServiceDto.whiteVaccineShouldNum}</td>
                <td title="${vaccinationServiceDto.whiteVaccineHasNum}">${vaccinationServiceDto.whiteVaccineHasNum}</td>
                <td title="<fmt:formatNumber value="${vaccinationServiceDto.whiteVaccineShouldNum==0?0:(vaccinationServiceDto.whiteVaccineHasNum/vaccinationServiceDto.whiteVaccineShouldNum)*100}" pattern="#,##0.0"/>%">
                    <fmt:formatNumber
                            value="${vaccinationServiceDto.whiteVaccineShouldNum==0?0:(vaccinationServiceDto.whiteVaccineHasNum/vaccinationServiceDto.whiteVaccineShouldNum)*100}"
                            pattern="#,##0.0"/>%
                </td>

                <!-- A+C群流脑疫苗 -->
                <td title="${vaccinationServiceDto.acmeningococcalShouldNum}">${vaccinationServiceDto.acmeningococcalShouldNum}</td>
                <td title="${vaccinationServiceDto.havHasNum}">${vaccinationServiceDto.acmeningococcalHasNum}</td>
                <td title="<fmt:formatNumber value="${vaccinationServiceDto.acmeningococcalShouldNum==0?0:(vaccinationServiceDto.acmeningococcalHasNum/vaccinationServiceDto.acmeningococcalShouldNum)*100}" pattern="#,##0.0"/>%">
                    <fmt:formatNumber
                            value="${vaccinationServiceDto.acmeningococcalShouldNum==0?0:(vaccinationServiceDto.acmeningococcalHasNum/vaccinationServiceDto.acmeningococcalShouldNum)*100}"
                            pattern="#,##0.0"/>%
                </td>
            </tr>
        </c:if>
        </tbody>

        <tbody id="editBody" style="display: none">
        <c:forEach items="${reportList}" var="report" varStatus="status">
            <tr>
                <td>
                    <ehr:tip><ehr:dic code="${report.gbCode}" dicmeta="FS990001"/></ehr:tip>
                </td>
                <td title=<ehr:org code="${report.orgCode}"></ehr:org>>
                    <input type="hidden" name="VaccinationServiceDto.VaccinationServiceList[${status.index }].id"
                           value="${report.id }">
                    <input type="hidden" name="VaccinationServiceDto.VaccinationServiceList[${status.index }].orgCode"
                           value="${report.orgCode }">
                    <input type="hidden" name="VaccinationServiceDto.VaccinationServiceList[${status.index }].year"
                           value="${report.year }">
                    <input type="hidden" name="VaccinationServiceDto.VaccinationServiceList[${status.index }].orgName"
                           readonly="readonly" value="${report.orgName }"/>
                    <ehr:tip><ehr:org code="${report.orgCode}"/></ehr:tip>
                </td>
                <!-- 预防接种证 -->
                <td>
                    <input type="text" id="certificateShouldNum_id"
                           name="VaccinationServiceDto.VaccinationServiceList[${status.index }].certificateShouldNum"
                           size="3" value="${report.certificateShouldNum}" maxlength="9"
                           onkeypress="return event.keyCode>=48&&event.keyCode<=57||event.keyCode==8;"
                           onpaste="return !clipboardData.getData('text').match(/\D/);" style="ime-mode: Disabled"
                           ondragenter="return false"/>
                </td>
                <td>
                    <input type="text" id="certificateHasNum_id"
                           name="VaccinationServiceDto.VaccinationServiceList[${status.index }].certificateHasNum"
                           size="3" value="${report.certificateHasNum}" maxlength="9"
                           onkeypress="return event.keyCode>=48&&event.keyCode<=57||event.keyCode==8;"
                           onpaste="return !clipboardData.getData('text').match(/\D/);" style="ime-mode: Disabled"
                           ondragenter="return false"/>
                </td>
                <td>
                    <span id="certificatePercent"><fmt:formatNumber
                            value="${report.certificateHasNum==0?0:(report.certificateHasNum/report.certificateShouldNum)*100}"
                            pattern="#,##0.0"/>% </span>
                </td>

                <!--乙肝疫苗  -->
                <td>
                    <input type="text" id="hepatitisShouldNum_id"
                           name="VaccinationServiceDto.VaccinationServiceList[${status.index }].hepatitisShouldNum"
                           size="3" value="${report.hepatitisShouldNum }" maxlength="9"
                           onkeypress="return event.keyCode>=48&&event.keyCode<=57||event.keyCode==8;"
                           onpaste="return !clipboardData.getData('text').match(/\D/);" style="ime-mode: Disabled"
                           ondragenter="return false"/>
                </td>
                <td>
                    <input type="text" id="hepatitisHasNum_id"
                           name="VaccinationServiceDto.VaccinationServiceList[${status.index }].hepatitisHasNum"
                           size="3" value="${report.hepatitisHasNum }" maxlength="9"
                           onkeypress="return event.keyCode>=48&&event.keyCode<=57||event.keyCode==8;"
                           onpaste="return !clipboardData.getData('text').match(/\D/);" style="ime-mode: Disabled"
                           ondragenter="return false"/>
                </td>
                <td>
                    <span id="hepatitisPercent"><fmt:formatNumber
                            value="${report.hepatitisShouldNum==0?0:(report.hepatitisHasNum/report.hepatitisShouldNum)*100}"
                            pattern="#,##0.0"/>%</span>
                </td>

                <!-- 卡介苗 -->
                <td>
                    <input type="text" id="bcgShouldNum_id"
                           name="VaccinationServiceDto.VaccinationServiceList[${status.index }].bcgShouldNum" size="3"
                           value="${report.bcgShouldNum }" maxlength="9"
                           onkeypress="return event.keyCode>=48&&event.keyCode<=57||event.keyCode==8;"
                           onpaste="return !clipboardData.getData('text').match(/\D/);" style="ime-mode: Disabled"
                           ondragenter="return false"/>
                </td>
                <td>
                    <input type="text" id="bcgHasNum_id"
                           name="VaccinationServiceDto.VaccinationServiceList[${status.index }].bcgHasNum" size="3"
                           value="${report.bcgHasNum }" maxlength="9"
                           onkeypress="return event.keyCode>=48&&event.keyCode<=57||event.keyCode==8;"
                           onpaste="return !clipboardData.getData('text').match(/\D/);" style="ime-mode: Disabled"
                           ondragenter="return false"/>
                </td>
                <td>
                    <span id="bcgPercent"><fmt:formatNumber
                            value="${report.bcgShouldNum==0?0:(report.bcgHasNum/report.bcgShouldNum)*100}"
                            pattern="#,##0.0"/>% </span>
                </td>

                <!-- 脊灰疫苗 -->
                <td>
                    <input type="text" id="polioShouldNum_id"
                           name="VaccinationServiceDto.VaccinationServiceList[${status.index }].polioShouldNum" size="3"
                           value="${report.polioShouldNum }" maxlength="9"
                           onkeypress="return event.keyCode>=48&&event.keyCode<=57||event.keyCode==8;"
                           onpaste="return !clipboardData.getData('text').match(/\D/);" style="ime-mode: Disabled"
                           ondragenter="return false"/>
                </td>
                <td>
                    <input type="text" id="polioHasNum_id"
                           name="VaccinationServiceDto.VaccinationServiceList[${status.index }].polioHasNum" size="3"
                           value="${report.polioHasNum }" maxlength="9"
                           onkeypress="return event.keyCode>=48&&event.keyCode<=57||event.keyCode==8;"
                           onpaste="return !clipboardData.getData('text').match(/\D/);" style="ime-mode: Disabled"
                           ondragenter="return false"/>
                </td>
                <td>
                    <span id="polioPercent"><fmt:formatNumber
                            value="${report.polioShouldNum==0?0:(report.polioHasNum/report.polioShouldNum)*100}"
                            pattern="#,##0.0"/>%</span>
                </td>

                <!-- 百白破疫苗 -->
                <td>
                    <input type="text" id="dptShouldNum_id"
                           name="VaccinationServiceDto.VaccinationServiceList[${status.index }].dptShouldNum" size="3"
                           value="${report.dptShouldNum }" maxlength="9"
                           onkeypress="return event.keyCode>=48&&event.keyCode<=57||event.keyCode==8;"
                           onpaste="return !clipboardData.getData('text').match(/\D/);" style="ime-mode: Disabled"
                           ondragenter="return false"/>
                </td>
                <td>
                    <input type="text" id="dptHasNum_id"
                           name="VaccinationServiceDto.VaccinationServiceList[${status.index }].dptHasNum" size="3"
                           value="${report.dptHasNum}" maxlength="9"
                           onkeypress="return event.keyCode>=48&&event.keyCode<=57||event.keyCode==8;"
                           onpaste="return !clipboardData.getData('text').match(/\D/);" style="ime-mode: Disabled"
                           ondragenter="return false"/>
                </td>
                <td>
                    <span id="dptPercent"><fmt:formatNumber
                            value="${report.dptShouldNum==0?0:(report.dptHasNum/report.dptShouldNum)*100}"
                            pattern="#,##0.0"/>%</span>
                </td>

                <!-- 含麻疹成分疫苗 -->
                <td>
                    <input type="text" id="measlesconstitShouldNum_id"
                           name="VaccinationServiceDto.VaccinationServiceList[${status.index }].measlesconstitShouldNum"
                           size="3" value="${report.measlesconstitShouldNum }" maxlength="9"
                           onkeypress="return event.keyCode>=48&&event.keyCode<=57||event.keyCode==8;"
                           onpaste="return !clipboardData.getData('text').match(/\D/);" style="ime-mode: Disabled"
                           ondragenter="return false"/>
                </td>
                <td>
                    <input type="text" id="measlesconstitHasNum_id"
                           name="VaccinationServiceDto.VaccinationServiceList[${status.index }].measlesconstitHasNum"
                           size="3" value="${report.measlesconstitHasNum }" maxlength="9"
                           onkeypress="return event.keyCode>=48&&event.keyCode<=57||event.keyCode==8;"
                           onpaste="return !clipboardData.getData('text').match(/\D/);" style="ime-mode: Disabled"
                           ondragenter="return false"/>
                </td>
                <td>
                    <span id="measlesconstitPercent"><fmt:formatNumber
                            value="${report.measlesconstitShouldNum==0?0:(report.measlesconstitHasNum/report.measlesconstitShouldNum)*100}"
                            pattern="#,##0.0"/>%</span>
                </td>

                <!--流脑疫苗  -->
                <td>
                    <input type="text" id="ameningococcalShouldNum_id"
                           name="VaccinationServiceDto.VaccinationServiceList[${status.index }].ameningococcalShouldNum"
                           size="3" value="${report.ameningococcalShouldNum }" maxlength="9"
                           onkeypress="return event.keyCode>=48&&event.keyCode<=57||event.keyCode==8;"
                           onpaste="return !clipboardData.getData('text').match(/\D/);" style="ime-mode: Disabled"
                           ondragenter="return false"/>
                </td>
                <td>
                    <input type="text" id="ameningococcalHasNum_id"
                           name="VaccinationServiceDto.VaccinationServiceList[${status.index }].ameningococcalHasNum"
                           size="3" value="${report.ameningococcalHasNum }" maxlength="9"
                           onkeypress="return event.keyCode>=48&&event.keyCode<=57||event.keyCode==8;"
                           onpaste="return !clipboardData.getData('text').match(/\D/);" style="ime-mode: Disabled"
                           ondragenter="return false"/>
                </td>
                <td>
                    <span id="ameningococcalPercent"><fmt:formatNumber
                            value="${report.ameningococcalShouldNum==0?0:(report.ameningococcalHasNum/report.ameningococcalShouldNum)*100}"
                            pattern="#,##0.0"/>%</span>
                </td>

                <!-- 乙脑疫苗 -->
                <td>
                    <input type="text" id="encephalitisShouldNum_id"
                           name="VaccinationServiceDto.VaccinationServiceList[${status.index }].encephalitisShouldNum"
                           size="3" value="${report.encephalitisShouldNum }" maxlength="9"
                           onkeypress="return event.keyCode>=48&&event.keyCode<=57||event.keyCode==8;"
                           onpaste="return !clipboardData.getData('text').match(/\D/);" style="ime-mode: Disabled"
                           ondragenter="return false"/>
                </td>
                <td>
                    <input type="text" id="encephalitisHasNum_id"
                           name="VaccinationServiceDto.VaccinationServiceList[${status.index }].encephalitisHasNum"
                           size="3" value="${report.encephalitisHasNum }" maxlength="9"
                           onkeypress="return event.keyCode>=48&&event.keyCode<=57||event.keyCode==8;"
                           onpaste="return !clipboardData.getData('text').match(/\D/);" style="ime-mode: Disabled"
                           ondragenter="return false"/>
                </td>
                <td>
                    <span id="encephalitisPercent"><fmt:formatNumber
                            value="${report.encephalitisShouldNum==0?0:(report.encephalitisHasNum/report.encephalitisShouldNum)*100}"
                            pattern="#,##0.0"/>% </span>
                </td>

                <!-- 甲肝疫苗 -->
                <td>
                    <input type="text" id="havShouldNum_id"
                           name="VaccinationServiceDto.VaccinationServiceList[${status.index }].havShouldNum" size="3"
                           value="${report.havShouldNum }" maxlength="9"
                           onkeypress="return event.keyCode>=48&&event.keyCode<=57||event.keyCode==8;"
                           onpaste="return !clipboardData.getData('text').match(/\D/);" style="ime-mode: Disabled"
                           ondragenter="return false"/>
                </td>
                <td>
                    <input type="text" id="havHasNum_id"
                           name="VaccinationServiceDto.VaccinationServiceList[${status.index }].havHasNum" size="3"
                           value="${report.havHasNum }" maxlength="9"
                           onkeypress="return event.keyCode>=48&&event.keyCode<=57||event.keyCode==8;"
                           onpaste="return !clipboardData.getData('text').match(/\D/);" style="ime-mode: Disabled"
                           ondragenter="return false"/>
                </td>
                <td>
                    <span id="havPercent"><fmt:formatNumber
                            value="${report.havShouldNum==0?0:(report.havHasNum/report.havShouldNum)*100}"
                            pattern="#,##0.0"/>%</span>
                </td>

                <!-- 白破疫苗 -->
                <td>
                    <input type="text" id="whiteShouldNum_id"
                           name="VaccinationServiceDto.VaccinationServiceList[${status.index }].whiteVaccineShouldNum"
                           size="3" value="${report.whiteVaccineShouldNum }" maxlength="9"
                           onkeypress="return event.keyCode>=48&&event.keyCode<=57||event.keyCode==8;"
                           onpaste="return !clipboardData.getData('text').match(/\D/);" style="ime-mode: Disabled"
                           ondragenter="return false"/>
                </td>
                <td>
                    <input type="text" id="whiteHasNum_id"
                           name="VaccinationServiceDto.VaccinationServiceList[${status.index }].whiteVaccineHasNum"
                           size="3" value="${report.whiteVaccineHasNum }" maxlength="9"
                           onkeypress="return event.keyCode>=48&&event.keyCode<=57||event.keyCode==8;"
                           onpaste="return !clipboardData.getData('text').match(/\D/);" style="ime-mode: Disabled"
                           ondragenter="return false"/>
                </td>
                <td>
                    <span id="whitePercent"><fmt:formatNumber
                            value="${report.whiteVaccineShouldNum==0?0:(report.whiteVaccineHasNum/report.whiteVaccineShouldNum)*100}"
                            pattern="#,##0.0"/>%</span>
                </td>

                <!-- A+C群流脑疫苗 -->
                <td>
                    <input type="text" id="acmeningococcalShouldNum_id"
                           name="VaccinationServiceDto.VaccinationServiceList[${status.index }].acmeningococcalShouldNum"
                           size="3" value="${report.acmeningococcalShouldNum }" maxlength="9"
                           onkeypress="return event.keyCode>=48&&event.keyCode<=57||event.keyCode==8;"
                           onpaste="return !clipboardData.getData('text').match(/\D/);" style="ime-mode: Disabled"
                           ondragenter="return false"/>
                </td>
                <td>
                    <input type="text" id="acmeningococcalHasNum_id"
                           name="VaccinationServiceDto.VaccinationServiceList[${status.index }].acmeningococcalHasNum"
                           size="3" value="${report.acmeningococcalHasNum }" maxlength="9"
                           onkeypress="return event.keyCode>=48&&event.keyCode<=57||event.keyCode==8;"
                           onpaste="return !clipboardData.getData('text').match(/\D/);" style="ime-mode: Disabled"
                           ondragenter="return false"/>
                </td>
                <td>
                    <span id="acmeningococcalPercent"><fmt:formatNumber
                            value="${report.acmeningococcalShouldNum==0?0:(report.acmeningococcalHasNum/report.acmeningococcalShouldNum)*100}"
                            pattern="#,##0.0"/>% </span>
                </td>

            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>