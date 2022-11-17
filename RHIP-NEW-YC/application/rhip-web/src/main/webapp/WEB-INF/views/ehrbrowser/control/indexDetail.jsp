<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>

<input type="hidden" id="popPrintId" value="${popPrintId}"/>
<c:if test="${popPrintId!=1}">
    <div class="toolbar">
        <a href="javascript:void(0)" id="popPrintId1" onclick="javascript:brwControl.indexReturn()"><b class="fanhui">返回</b></a>
        <a href="javascript:void(0)" id="popPrintId2"
           onclick="javascript:reportPrint.approvalDialog(${reportDto.report.idmId})"><b class="jilu">操作记录</b></a>
        <c:choose>
            <c:when test="${printFlag==2}">
                <a href="javascript:void(0)" id="popPrintId3"
                   onclick="javascript:reportPrint.print(${reportDto.report.id})"><b class="dayin">打印</b></a>
            </c:when>
        </c:choose>
    </div>
</c:if>

<div class="postcontent contentfixed32">
<i class="popno">
    中华人民共和国传染病报告卡
</i>

<div class="postdiv">
<table class="posttable">
    <tbody>
    <tr>
        <td style="width: 50%; text-align: left;">
            卡片编号：${reportDto.report.recordNumber}
        </td>
        <td style="width: 50%; text-align: right;">
            报卡类别：<ehr:dic dicmeta="IDM00001" code="${reportDto.report.reportCardTypeCode}"/>
        </td>
    </tr>
    </tbody>
</table>
<fieldset>
    <table class="posttable">
        <colgroup>
            <col style="min-width: 80px; width: 20%;"/>
            <col style="min-width: 150px; width: 30%;"/>
            <col style="min-width: 80px; width: 25%;"/>
            <col style="min-width: 150px; width: 25%;"/>
        </colgroup>
        <tr>
            <c:choose>
                <c:when test="${not empty reportDto.report.parentsName}">
                    <th>患者姓名</th>
                    <td>${reportDto.report.name}</td>
                    <th>患儿家长姓名</th>
                    <td>${reportDto.report.parentsName}</td>
                </c:when>
                <c:otherwise>
                    <th>患者姓名</th>
                    <td>${reportDto.report.name}</td>
                    <th>患儿家长姓名</th>
                </c:otherwise>
            </c:choose>
        </tr>
        <tr>
            <th>身份证号</th>
            <td>${reportDto.report.idcard}</td>
            <th>性别</th>
            <td>
                <ehr:dic dicmeta="GBT226112003" code="${reportDto.report.gender}"/>
            </td>
        </tr>
        <tr>
            <th>出生日期</th>
            <td colspan="3">
                <c:choose>
                    <c:when test="${not empty reportDto.report.birthday}">
                        <fmt:formatDate value="${reportDto.report.birthday}" pattern="yyyy/MM/dd"/>
                    </c:when>
                    <c:when test="${not empty reportDto.report.age}">
                        <span>（如出生日期不详，实足年龄:</span>
                        ${reportDto.report.age}
                        <span>年龄单位:</span>
                        <ehr:dic dicmeta="IDM00003" code="${reportDto.report.ageUnit}"/>
                        <span>）</span>
                    </c:when>
                </c:choose>
            </td>
        </tr>
        <tr>
            <th>工作单位</th>
            <td>${reportDto.report.unitName}</td>
            <th>联系电话</th>
            <td>${reportDto.report.phoneNumber}</td>
        </tr>
        <tr>
            <th>病人属于</th>
            <td>
                <ehr:dic dicmeta="CV0201104" code="${reportDto.report.infectedpersonBelong}"/>
            </td>
        </tr>
        <tr>
            <th>现住址</th>
            <td colspan="3">
                <ehr:dic code="${reportDto.report.patownShip}" dicmeta="FS990001"/><%--&nbsp&nbsp--%><ehr:dic code="${reportDto.report.pastreet}" dicmeta="FS990001"/><%--&nbsp&nbsp--%>
                ${reportDto.report.pahouseNumber}&nbsp（门牌号）
            </td>
        </tr>
        <tr>
            <th>患者职业</th>
            <td>
                <ehr:dic dicmeta="GBT6565" code="${reportDto.report.occupation}"/>
                <span>&nbsp&nbsp</span>${reportDto.report.occupationOther}
            </td>
        </tr>
        <tr>
            <th>病例分类(1)</th>
            <td>
                <ehr:dic dicmeta="CV0501002" code="${reportDto.report.caseCategory}"/>
            </td>
        </tr>
        <c:if test="${reportDto.report.infectiousCode =='225' || reportDto.report.infectiousCode =='2032'}">
            <tr>
                <th>病例分类(2)</th>
                <td>
                    <ehr:dic dicmeta="FS10062" code="${reportDto.report.caseCategoryFlag}"/>
                    <span>(乙型肝炎、血吸虫病填写)</span>
                </td>
            </tr>
        </c:if>
        <tr>
            <th>发病日期</th>
            <td>
                <fmt:formatDate value="${reportDto.report.pathogenesisDate}" pattern="yyyy/MM/dd"/>
            </td>
        </tr>
        <tr>
            <th>诊断日期</th>
            <td>
                <fmt:formatDate value="${reportDto.report.diagnosisDate}" pattern="yyyy/MM/dd HH:mm:ss"/>
            </td>
        </tr>
        <tr>
            <th>死亡日期</th>
            <td>
                <fmt:formatDate value="${reportDto.report.deathDate}" pattern="yyyy/MM/dd"/>
            </td>
        </tr>
        </tbody>
    </table>
</fieldset>
<fieldset class="topfield">
    <table class="posttable">
        <colgroup>
            <col style="min-width: 80px; width: 20%;"/>
            <col style="min-width: 150px; width: 30%;"/>
            <col style="min-width: 80px; width: 25%;"/>
            <col style="min-width: 150px; width: 25%;"/>
        </colgroup>
        <tbody>
        <tr>
            <th>传染病名称</th>
            <td>
                <%--<ehr:dic dicmeta="FS10063" code="${report.infectiousType}"/>--%>
                ${reportDto.report.infectiousName}
            </td>
            <td></td>
            <td></td>
        </tr>


        <%--<tbody id="311detail">--%>
        <c:if test="${reportDto.report.infectiousCode eq '311'}">
            <tr>
                <th>实验室结果</th>
                <td><ehr:dic dicmeta="IDM00346" code="${reportDto.reportDesc.checkResult}"/></td>
                <th>重症患者</th>
                <td><ehr:dic dicmeta="PH00001" code="${reportDto.reportDesc.severeCase}"/></td>
            </tr>
        </c:if>
        <%--</tbody>--%>
        <%--<tbody id="2032detail" style="display: none">--%>
        <c:if test="${reportDto.report.infectiousCode eq '2032'}">
            <tr>
                <th>HBsAg阳性时间</th>
                <td><ehr:dic dicmeta="IDM00343" code="${reportDto.reportDesc.hbsagPositiveDt}"/></td>
                <th>首次出现乙肝症状和体征时间</th>
                <td><fmt:formatDate value="${reportDto.reportDesc.hbvSignDt}" pattern="yyyy/MM"></fmt:formatDate></td>
            </tr>
            <tr>
                <th>本次ALT</th>
                <td>${reportDto.reportDesc.alt} U/L</td>
                <th>抗-HBc IgM 1:1000监测结果</th>
                <td><ehr:dic dicmeta="CV0300404" code="${reportDto.reportDesc.hbcCheckResult}"/></td>
            </tr>
            <tr>
                <th>肝穿检测结果</th>
                <td><ehr:dic dicmeta="IDM00344" code="${reportDto.reportDesc.punctureCheckResult}"/></td>
                <th>恢复期血清HBsAg阴性，抗HBs阳性</th>
                <td><ehr:dic dicmeta="PH00001" code="${reportDto.reportDesc.hbsToPositive}"/></td>
            </tr>
        </c:if>
        <%--</tbody>--%>
        <%--<tbody id="206detail" style="display: none">--%>
        <c:if test="${reportDto.report.infectiousCode eq '206'}">
            <tr>
                <th>病例分类(根据病情)</th>
                <td><ehr:dic dicmeta="IDM00342" code="${reportDto.reportDesc.conditionWay}"/></td>
                <th>是否住院</th>
                <td><ehr:dic dicmeta="PH00001" code="${reportDto.reportDesc.inHospital}"/></td>
            </tr>
            <tr>
                <th>住院日期</th>
                <td><fmt:formatDate value="${reportDto.reportDesc.inHospitalDt}" pattern="yyyy/MM/dd"></fmt:formatDate></td>
                <th>住院日期</th>
                <td><fmt:formatDate value="${reportDto.reportDesc.outHospitalDt}" pattern="yyyy/MM/dd"></fmt:formatDate></td>
            </tr>
            <tr>
                <th>是否治愈</th>
                <td><ehr:dic dicmeta="PH00001" code="${reportDto.reportDesc.cure}"/></td>
                <th>是否境外输入</th>
                <td><ehr:dic dicmeta="PH00001" code="${reportDto.reportDesc.overseas}"/></td>
            </tr>
            <%--</tbody>--%>
        </c:if>
        <%--<tbody id="222223detail" style="display: none">--%>
        <c:if test="${fn:contains('222,2231,2232,2233,2234,2235,202',reportDto.report.infectiousCode)}">
            <tr>
                <th>婚姻状况</th>
                <td><ehr:dic dicmeta="IDM00345" code="${reportDto.report.marriage}"/></td>
                <th>民族</th>
                <td><ehr:dic dicmeta="GBT3304" code="${reportDto.report.nation}"/></td>
            </tr>
            <tr>
                <th>文化程度</th>
                <td>
                    <ehr:dic dicmeta="GBT46582006" code="${reportDto.report.education}" />
                </td>
                <td></td>
                <td></td>
            </tr>
            <tr>
                <th>户籍</th>
                <td colspan="3">
                    <ehr:dic code="${reportDto.report.hrtownShip}" dicmeta="FS990001"/><ehr:dic code="${reportDto.report.hrstreet}" dicmeta="FS990001"/>
                        ${reportDto.report.hrhouseNumber}
                </td>
            </tr>
            <tr>
                <th>接触史</th>
                <td colspan="3"><ehr:dic dicmeta="IDM00338" code="${reportDto.reportDesc.contactHistory}"/></td>
            </tr>
            <tr>
                <th>性病史</th>
                <td><ehr:dic dicmeta="PH00002" code="${reportDto.reportDesc.vdHistory}"/></td>
                <th>最可能感染途径</th>
                <td><ehr:dic dicmeta="IDM00339" code="${reportDto.reportDesc.infectionWay}"/></td>
            </tr>
            <tr>
                <th>样本来源</th>
                <td><ehr:dic dicmeta="IDM00340" code="${reportDto.reportDesc.sampleSource}"/></td>
                <th>实验室检测结论</th>
                <td><ehr:dic dicmeta="IDM00341" code="${reportDto.reportDesc.checkConclusion}"/></td>
            </tr>
            <tr>
                <th>确认（替代策略）检测阳性日期</th>
                <td><fmt:formatDate value="${reportDto.reportDesc.checkPositiveDt}" pattern="yyyy/MM/dd"></fmt:formatDate></td>
                <th>确认（替代策略）检测单位</th>
                <td>${reportDto.reportDesc.checkPositiveUnit}</td>
            </tr>
        </c:if>
        <%--</tbody>--%>
        <c:if test="${reportDto.report.infectiousCode eq '202'}">
            <tr>
                <th>艾滋病确诊日期</th>
                <td><fmt:formatDate value="${reportDto.reportDesc.hivDiagnoseDt}" pattern="yyyy/MM/dd"></fmt:formatDate></td>
            </tr>
        </c:if>

        <c:if test="${reportDto.report.infectiousCode eq '99999'}">
            <tr>
                <th>其他法定管理以及<br>重点监测传染病</th>
                <td colspan="3">${reportDto.report.otherInfectiousName}</td>
            </tr>
        </c:if>
        </tbody>
    </table>
</fieldset>
<fieldset class="topfield">
    <table class="posttable">
        <colgroup>
            <col style="min-width: 80px; width: 20%;"/>
            <col style="min-width: 150px; width: 30%;"/>
            <col style="min-width: 80px; width: 25%;"/>
            <col style="min-width: 150px; width: 25%;"/>
        </colgroup>
        <tbody>
        <tr>
            <th>订正病名</th>
            <td>${reportDto.report.amendName}</td>
            <th>退卡原因</th>
            <td>${reportDto.report.backCardCause}</td>
        </tr>
        <tr>
            <th>报告单位</th>
            <td>${reportDto.report.fillOrganName}</td>
            <th>联系电话</th>
            <td>${reportDto.report.fillOrganPhone}</td>
        </tr>
        <tr>
            <th>报告医生</th>
            <td>${reportDto.report.reportDoctorName}</td>
            <th>填卡日期</th>
            <td>
                <fmt:formatDate value="${reportDto.report.fillDate}" pattern="yyyy/MM/dd"/>
            </td>
        </tr>
        </tbody>
    </table>
</fieldset>
<fieldset class="topfield" id="deleteContentId">
    <table class="posttable">

        <colgroup>
            <col style="min-width: 80px; width: 20%;"/>
            <col style="min-width: 150px; width: 30%;"/>
            <col style="min-width: 80px; width: 25%;"/>
            <col style="min-width: 150px; width: 25%;"/>
        </colgroup>
        <tbody>
        <tr>
            <th>作废原因:</th>
            <td colspan="3">
                <ehr:dic-radio name="deleteContent" dicmeta="IDM00379" value="${reportDto.report.deleteContent}" onchange="toggleOther('report.deleteContent','deleteContentOtherId','99');"/>
                <span id="deleteContentOtherId" style="display: none"><input type="text" style="width: 200px;" name="report.deleteContentOther" reg="{'maxlength':200,'required':'true'}" value="${reportDto.report.deleteContentOther}" /></span>
            </td>
        </tr>
        </tbody>
    </table>
</fieldset>
<fieldset class="topfield">
    <table>
        <colgroup>
            <col style="min-width: 80px; width: 20%;"/>
            <col style="min-width: 150px; width: 30%;"/>
            <col style="min-width: 80px; width: 25%;"/>
            <col style="min-width: 150px; width: 25%;"/>
        </colgroup>
        <tr>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
        </tr>
        <tr>
            <th>备注</th>
            <td colspan="3"> ${reportDto.report.comments}</td>
        </tr>
        </tbody>
    </table>
</fieldset>
</div>
</div>
