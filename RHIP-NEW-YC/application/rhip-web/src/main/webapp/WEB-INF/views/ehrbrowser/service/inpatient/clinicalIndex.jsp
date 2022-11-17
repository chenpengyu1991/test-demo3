<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/ehr-tag" prefix="ehr"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<div id="printPage" class="postcontentprint postcontentehr" style="margin-top: 20px;height: 505px;">
    <c:set var="item" value="${inpatientMedicalRecordDto.inpatientMedicalRecord }" ></c:set>
    <c:set var="person" value="${inpatientMedicalRecordDto.personInfo }" ></c:set>
    <c:set var="disease" value="${inpatientMedicalRecordDto.diseaseDiagnosisInfoMap}" ></c:set>
    <c:set var="mjzInfoList" value="${inpatientMedicalRecordDto.mjzInfoList}" ></c:set>
    <c:set var="ops" value="${inpatientMedicalRecordDto.surgeryInfos}" ></c:set>
    <c:set var="disease02" value="${disease['2'][0]}"></c:set>
<div class="postcontent postdiv">
    <table class="printposttable" style="width: 90%;">
        <tbody>
        <tr>
            <td style="width: 65%; text-align: left;">
                医疗机构：
                <c:if test="${ not empty item.hospitalName}"><input type="text" value="${item.hospitalName}" style="width: 400px;"/></c:if>
				<c:if test="${not empty item.hospitalCode and   empty item.hospitalName}"><input type="text" value="<ehr:dic dicmeta='FS10002' code='${item.hospitalCode}'/>"/></c:if>
            </td>
            <td style="width: 35%; text-align: right;">
                (组织机构代码：
                <input type="text" value="${item.hospitalCode}" style="width: 120px;"/>)
            </td>
        </tr>
        </tbody>
    </table>
    <i class="popno">
        住院病案首页
    </i>
    <table class="printposttable" style="height:1px; border-bottom:1px solid black;">
    <tbody>
    <tr>
        <td>
            医疗付费方式：
            <ehr:dic dicmeta="CV0710003" code="${item.medicalPayWay}"/>
        </td>
    </tr>
    <tr>
        <td style="width: 35%;">
            健康卡号：<c:out value="${person.citizenCardNo}" ></c:out>
        </td>
        <td style="width: 30%; text-align: center;">
            第 <c:out value="${item.inhosCount}" ></c:out> 次住院
        </td>
        <td style="width: 35%;">
            病案号：
            <c:out value="${item.medicalRecordNo}" ></c:out>
        </td>
    </tr>
    </tbody>
    </table>
    <table class="printposttable" style="height:1px; border-bottom:1px solid black;">
        <colgroup>
            <col style="width: 20%;"/>
            <col style="width: 20%;"/>
            <col style="width: 23%;"/>
            <col style="width: 17%;"/>
            <col style="width: 20%; text-align: right;"/>
        </colgroup>
        <tbody>
        <tr>
            <td class="bold">姓名<input type="text" value="${item.name}"/></td>
            <td class="bold">性别<span class="code_box"><c:out value="${item.gender}" ></c:out></span>（1.男 2.女）</td>
            <td class="bold">出生日期<input type="text" style="width: 110px;" value="<fmt:formatDate value="${item.birthday}" pattern="yyyy/MM/dd" />"/></td>
            <td class="bold" style="width: 100px;">年龄<input type="text" value="${item.age}"/></td>
            <td class="bold">国籍<input type="text" value="<ehr:dic dicmeta="GBT26592000" code="${item.nation}" />"/></td>
        </tr>
        <tr>
            <td>（年龄不足1周岁的）</td>
            <td class="bold">年龄<input type="text" value="<c:out value="${item.monthAge}" ></c:out>"/>月</td>
            <td class="bold" colspan="2">新生儿出生体重<input type="text" style="width: 40px;" value="<c:out value="${item.neonatalBirthWeight}" ></c:out>"/>克</td>
            <td class="bold">新生儿入院体重<input type="text" style="width: 40px;" value="<c:out value="${item.neonatalinhosWeight}" ></c:out>"/>克</td>
        </tr>
        </tbody>
        <tr>
            <td class="bold" colspan="2">
                出生地
                <input type="text" value="<c:out value="${item.birthProvince}${item.birthCity}${item.birthCountry}" ></c:out>"/>
            </td>
            <td class="bold" colspan="2">籍贯
                <%--<input type="text" value="<c:choose>
                    <c:when test='${"1" == person.householdType}'>
                        <ehr:dic dicmeta="FS990001" code="${person.hrtownShip}"></ehr:dic>
                        <ehr:dic dicmeta="FS990001" code="${person.hrstreet}"></ehr:dic>
                        <c:out value="${person.hrhouseNumber}"/>
                    </c:when>
                    <c:otherwise>
                        <c:out value="${person.hrhouseNumber}"/>
                    </c:otherwise>
                </c:choose>"/>--%>
                <input type="text" value="${item.nativePlace}"/>
            </td>
            <td class="bold">民族<input type="text" value="<ehr:dic dicmeta="GBT3304" code="${item.nationCode}" />"/></td>
        </tr>
        <tr>
            <td class="bold" colspan="2">身份证号<input type="text" value="<c:out value="${item.idcard}" ></c:out>"/></td>
            <td class="bold">职业<input type="text" value="<ehr:dic dicmeta="GBT6565" code="${item.occupation}" />"/></td>
            <td class="bold" colspan="2">婚姻<input type="text" value="<ehr:dic dicmeta="GBT226122003" code="${item.marriage}"/>"/></td>
        </tr>
        <tr>
            <td class="bold" colspan="3">现住址
                <%--<input type="text" value="<c:out value="${person.paprovince}" ></c:out>
                <c:out value="${person.pacity}" ></c:out>
                <c:out value="${person.pacounty}" ></c:out>"/>--%>
                <input type="text" value="${item.paAddress}" />
            </td>
            <td class="bold">电话<input type="text" value="<c:out value="${item.phoneNumber}" ></c:out>"/></td>
            <td class="bold">邮编<input type="text" value="<c:out value="${item.postcode}" ></c:out>"/></td>
        </tr>
        <tr>
            <td class="bold" colspan="4">户口地址</th>
                <%--<input type="text" value="<c:out value="${person.hrprovince}" ></c:out>
                <c:out value="${person.hrcity}" ></c:out>
                <c:out value="${person.hrcounty}" ></c:out>"/>--%>
                <input type="text" value="${item.hrPlace}"/>
            </td>
            <td class="bold"><%-- 邮编<input type="text" value="<c:out value="${person.hrpostCode}" ></c:out>"/> --%></td>
        </tr>
        <tr>
            <td class="bold" colspan="6">工作单位及地址<input type="text" value="${item.workUnit}"/></td>
            <%-- <td class="bold" colspan="2">单位电话<input type="text" style="width: 100px;" value="<c:out value="${person.unitPhone}" ></c:out>"/></td>
            <td class="bold">邮编<input type="text" value="${person.unitPostcode}"/></td> --%>
        </tr>
        <tr>
            <td class="bold">联系人姓名<input type="text" style="width: 90px;" value="<c:out value="${item.contactName}" ></c:out>"/></td>
            <td class="bold" colspan="3">关系<input type="text" value="<ehr:dic dicmeta="GBT4761" code="${item.relation}" />"/></td>
            <!-- <td class="bold" colspan="2">地址<input type="text" value=""/></td> -->
            <td class="bold">电话<input type="text" value="<c:out value="${item.contactPhone}" ></c:out>"/></td>
        </tr>
        <tr>
            <td class="bold" colspan="5">入院途径<span class="code_box" style="width: 24px;"><c:out value="${item.inhosMethod}" ></c:out></span>（1.急诊 2.门诊 3.其它医疗机构转入 9.其它）</td>
        </tr>
        <tr>
            <td class="bold" colspan="2">入院时间<input type="text" value="<fmt:formatDate pattern="yyyy/MM/dd HH:mm:ss" value="${item.inhosDate}" ></fmt:formatDate>"/></td>
            <td class="bold">入院科别<input type="text" style="width: 110px;" value="<c:out value="${item.inhosDeptName}" ></c:out>"/></td>
            <td class="bold">病房<input type="text" value="<c:out value="${item.inhosRoomCode}" ></c:out>"/></td>
            <td class="bold">转科科别<input type="text" style="width: 93px;" value="<c:out value="${item.transitionDeptName}" ></c:out>"/></td>
        </tr>
        <tr>
            <td class="bold" colspan="2">出院时间<input type="text" value="<fmt:formatDate pattern="yyyy/MM/dd HH:mm:ss" value="${item.outHospitalDate}" ></fmt:formatDate>"/></td>
            <td class="bold">出院科别<input type="text" style="width: 110px;" value="<c:out value="${item.outhosDeptName}" ></c:out>"/></td>
            <td class="bold">病房<input type="text" value="<c:out value="${item.outhosRoom}" ></c:out>"/></td>
            <td class="bold">实际住院<%--此处计算出，且出院和住院只算一天 --%>
                <input type="text" style="width: 90px;" value="<c:out value="${inpatientMedicalRecordDto.inhosDays}" ></c:out>"/>天
            </td>
        </tr>
        <tr>
            <td class="bold" colspan="4">门（急）诊诊断
            
                <input type="text" value="<c:forEach  items="${mjzInfoList}" var="mjzInfo">
                ${mjzInfo.diagnosisDesc}</c:forEach>"/>
            </td>
            <td class="bold">疾病编码<input type="text" style="width: 93px;" value="<c:out value="${disease02.diseaseCode}"></c:out>"/></td>
        </tr>
    </table>
    <div class="repeattable" style="margin-top: 10px;">
        <table>
            <tr>
                <c:set var="disease12" value="${disease['1'][0]}"></c:set>
                <th colspan="2" style=" text-align: center;">出院诊断</th>
                <th style="text-align: center;">疾病编码</th>
                <th style="text-align: center;">入院病情</th>
            </tr>
            <tr>
                <td ><b>主要诊断:</b></td>
                <td style="width: 10%;"><c:out value="${disease12.diagnosisDesc}"></c:out></td>
                <td style="width: 10%;"><c:out value="${disease12.diseaseCode}"></c:out></td>
                <td style="width: 10%;"><c:out value="${disease12.inhosConditionName}"></c:out></td>
            </tr>
            <c:set var="diseaseList" value="${disease['2']}"></c:set>
            <c:set var="disLength" value="${fn:length(diseaseList)}"></c:set>
            <tr>
                <td rowspan="${disLength<=1?1:disLength}" style="width: 10%;"><b>其他诊断:</b></td>
                <td style="width: 10%;"><c:out value="${diseaseList[0].diagnosisDesc}"></c:out></td>
                <td style="width: 10%;"><c:out value="${diseaseList[0].diseaseCode}"></c:out></td>
                <td style="width: 10%;"><c:out value="${diseaseList[0].inhosConditionName}"></c:out></td>
            </tr>
            <c:forEach begin="1" items="${diseaseList}" var="diseaseother">
                <tr>
                    <td style="width: 10%;"><c:out value="${diseaseother.diagnosisDesc}"></c:out></td>
                    <td style="width: 10%;"><c:out value="${diseaseother.diseaseCode}"></c:out></td>
                    <td style="width: 10%;"><c:out value="${diseaseother.inhosConditionName}"></c:out></td>
                </tr>
            </c:forEach>
            <tr>
                <td style="width: 10%;" colspan="4">入院病情:1.有2.临床未确定3.情况不明4.无<br />
                </td>
            </tr>
        </table>
    </div>

    <table class="printposttable" style="height:1px; border-bottom:1px solid black;">
        <colgroup>
            <col style="width: 20%;"/>
            <col style="width: 30%;"/>
            <col style="width: 25%;"/>
            <col style="width: 25%; text-align: right;"/>
        </colgroup>
        <tbody>
        <tr>
            <td class="bold" colspan="3">损伤，中毒的外部原因<input type="text" value="<c:out value="${item.injuryPosionReason}" ></c:out>"/></td>
            <td class="bold">疾病编码<input type="text" value="<c:out value="${item.injuryDiseaseCode }"></c:out>"/></td>
        </tr>
        </tbody>
    </table>
    <table class="printposttable" style="height:1px; border-bottom:1px solid black;">
        <colgroup>
            <col style="width: 20%;"/>
            <col style="width: 30%;"/>
            <col style="width: 25%;"/>
            <col style="width: 25%; text-align: right;"/>
        </colgroup>
        <tbody>
        <tr>
            <c:set var="disease09" value="${disease['9'][0]}"></c:set>
            <td class="bold" colspan="3">病理诊断<input type="text" value="<c:out value="${disease09.diagnosisDesc}"></c:out>"/></td>
            <td class="bold">疾病编码<input type="text" value="<c:out value="${disease09.diseaseCode}"></c:out>"/></td>
        </tr>
        <tr>
            <td colspan="3"></td>
            <td class="bold">病理号&nbsp;&nbsp;&nbsp;<input type="text" value="<c:out value="${disease09.nlohmsiCode}"></c:out>"/></td>
        </tr>
        </tbody>
    </table>
    <table class="printposttable" style="height:1px; border-bottom:1px solid black;">
        <colgroup>
            <col style="width: 20%;"/>
            <col style="width: 30%;"/>
            <col style="width: 25%;"/>
            <col style="width: 25%; text-align: right;"/>
        </colgroup>
        <tbody>
        <tr>
            <td class="bold">
                药物过敏<span class="code_box">
                    <c:if test="${fn:length(inpatientMedicalRecordDto.allergyHistories) >0 }">2</c:if>
                    <c:if test="${fn:length(inpatientMedicalRecordDto.allergyHistories) <1 }">1</c:if>
                    </span>
                (1.无 2.有)
            </td>
            <td colspan="2">
                过敏药物
                <input type="text" value="<c:forEach items="${ inpatientMedicalRecordDto.allergyHistories}" var ="allergyHistorie">
                        <tag:textWithDic value="${allergyHistorie.allergensName}" dicmeta="CV0501038" code="${allergyHistorie.allergensCode}" />
                    </c:forEach>"/>
            </td>
            <td class="bold" >死亡患者尸检<span class="code_box"><c:out value="${item.inhosAutopsyFlag}" ></c:out></span>（1.是 2.否)</td>
        </tr>
        </tbody>
    </table>
    <table class="printposttable" style="height:1px; border-bottom:1px solid black;">
        <colgroup>
            <col style="width: 20%;"/>
            <col style="width: 30%;"/>
            <col style="width: 25%;"/>
            <col style="width: 25%; text-align: right;"/>
        </colgroup>
        <tbody>
        <tr>
            <td class="bold" colspan="2">血型<span class="code_box"><c:out value="${person.aboBloodType}" ></c:out></span>(1.A 2.B 3.O 4.AB 5.不详 6.未查)</td>
            <td class="bold" colspan="2">Rh<span class="code_box"><c:out value="${person.rhBloodType}" ></c:out></span>(1.阴 2.阳 3.不详 4.未查)</td>
        </tr>
        </tbody>
    </table>
    <table class="printposttable" style="height:1px; border-bottom:1px solid black;">
        <colgroup>
            <col style="width: 20%;"/>
            <col style="width: 30%;"/>
            <col style="width: 25%;"/>
            <col style="width: 25%; text-align: right;"/>
        </colgroup>
        <tbody>
        <tr>
            <td class="bold">科主任<input type="text" style="width: 100px;" value="<c:out value="${item.deptMasterSignature}" ></c:out>"/></td>
            <td class="bold">主任（副主任）医师<input type="text" style="width: 123px;" value="<c:out value="${item.directorDoctorSignature}" ></c:out>"/></td>
            <td class="bold">主治医师<input type="text" value="<c:out value="${item.attendingDoctorSignature}" ></c:out>"/></td>
            <td class="bold">住院医师<input type="text" value="<c:out value="${item.admissionDoctorSignature}" ></c:out>"/></td>
        </tr>
        <tr>
            <td class="bold">责任护士<input type="text" style="width: 87px;" value="<c:out value="${item.primaryNurseSignature}" ></c:out>"/></td>
            <td class="bold">进修医师<input type="text" value="<c:out value="${item.refresherDoctorsSignature}" ></c:out>"/></td>
            <td class="bold">实习医师<input type="text" value="<c:out value="${item.internSignature}" ></c:out>"/></td>
            <td class="bold">编码员&nbsp;&nbsp;&nbsp;<input type="text" value="<c:out value="${item.medicalRecordSignature}" ></c:out>"/></td>
        </tr>
        </tbody>
    </table>
    <table class="printposttable" style="height:1px; border-bottom:1px solid black;">
        <colgroup>
            <col style="width: 20%;"/>
            <col style="width: 30%;"/>
            <col style="width: 25%;"/>
            <col style="width: 25%; text-align: right;"/>
        </colgroup>
        <tbody>
        <tr>
            <td class="bold">病案质量<span class="code_box"><c:out value="${item.inhosMedicalQualityCode}" ></c:out></span>(1.甲 2.乙 3.丙)</td>
            <td class="bold">质控医师<input type="text" value="<c:out value="${item.qcDoctorSignature}" ></c:out>"/></td>
            <td class="bold">质控护士<input type="text" value="<c:out value="${item.qcNurseSignature}" ></c:out>"/></td>
            <td class="bold">质控日期<input type="text" value="<fmt:formatDate pattern="yyyy/MM/dd"  value="${item.qcDate}" ></fmt:formatDate>"/></td>
        </tr>
        </tbody>
    </table>
    <div class="repeattable" style="margin-top: 10px;">
        <table>
            <thead>
            <tr>
                <th style=" text-align: center;" rowspan="2">手术及操作编码</th>
                <th style=" text-align: center;"  rowspan="2">手术及操作日期</th>
                <th style=" text-align: center;"  rowspan="2" >手术级别</th>
                <th style=" text-align: center;"  rowspan="2" >手术及操作名称</th>

                <th style=" text-align: center;" colspan="3" >手术及操作医师</th>
                <th style=" text-align: center;" rowspan="2" >切口愈合等级</th>
                <th style=" text-align: center;" rowspan="2" >麻醉方式</th>
                <th style=" text-align: center;" rowspan="2" >麻醉医师</th>
            </tr>
            <tr>
                <th style=" text-align: center;">术者</th>
                <th style=" text-align: center;">Ⅰ助</th>
                <th style=" text-align: center;">Ⅱ助</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${ops}" var ="op">
                <tr>
                    <td style=" text-align: center;"><ehr:tip><c:out value="${op.opertationCode}" ></c:out></ehr:tip></td>
                    <td style=" text-align: center;"><ehr:tip><fmt:formatDate pattern="yyyy/MM/dd"  value="${op.opertationDate}" ></fmt:formatDate></ehr:tip></td>
                    <td style=" text-align: center;"><ehr:tip><c:out value="${op.operationLevelName}" ></c:out></ehr:tip></td>
                    <td style=" text-align: center;"><ehr:tip><c:out value="${op.opertationName}" ></c:out></ehr:tip></td>
                    <td style=" text-align: center;"><ehr:tip><c:out value="${op.operatorName}" ></c:out></ehr:tip></td>
                    <td style=" text-align: center;"><ehr:tip><c:out value="${op.operationAssistantOne}" ></c:out></ehr:tip></td>
                    <td style=" text-align: center;"><ehr:tip><c:out value="${op.operationAssistantTwo}" ></c:out></ehr:tip></td>
                    <td style=" text-align: center;"><ehr:tip><c:out value="${op.incisionHealingGradeName}" ></c:out></ehr:tip></td>
                    <td style=" text-align: center;"><ehr:tip><c:out value="${op.anesthesiaMethodName}" ></c:out></ehr:tip></td>
                    <td style=" text-align: center;"><ehr:tip><c:out value="${op.anesthesiaDoctorName}" ></c:out></ehr:tip></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
    <table class="printposttable" style="height:1px; border-bottom:1px solid black;">
        <colgroup>
            <col style="width: 20%;"/>
            <col style="width: 30%;"/>
            <col style="width: 25%;"/>
            <col style="width: 25%; text-align: right;"/>
        </colgroup>
        <tbody>
        <tr>
            <td class="bold" colspan="4">
                离院方式
                <span class="code_box"><c:out value="${item.outhosMethod}" ></c:out></span>（1.医嘱离院，2.医嘱转院，3.医嘱转社区卫生服务机构/乡镇卫生院，4.非医嘱离院，5.死亡，9其它）<%--字典：FS990015--%>
            </td>
        </tr>
        <tr>
            <td colspan="4">
                拟接收医疗机构代码：<input type="text" value=""/>
            </td>
        </tr>
        </tbody>
    </table>
    <table class="printposttable" style="height:1px; border-bottom:1px solid black;">
        <colgroup>
            <col style="width: 20%;"/>
            <col style="width: 30%;"/>
            <col style="width: 25%;"/>
            <col style="width: 25%; text-align: right;"/>
        </colgroup>
        <tbody>
        <tr>
            <td colspan="2">是否有出院31天内再住院计划<span class="code_box"><c:out value="${item.outhosFlag}" ></c:out></span>(1.无 2.有)</td>
            <td colspan="2">目的<input type="text" value="<c:out value="${item.outhosPurpose}" ></c:out>"/></td>
        </tr>
        </tbody>
    </table>
    <table class="printposttable" style="height:1px; border-bottom:1px solid black;">
        <colgroup>
            <col style="width: 20%;"/>
            <col style="width: 30%;"/>
            <col style="width: 25%;"/>
            <col style="width: 25%; text-align: right;"/>
        </colgroup>
        <tbody>
        <tr>
            <td colspan="2">
                颅脑损伤患者昏迷时间：&nbsp;&nbsp;入院前:
                <input type="text" style="width: 200px;" value="<fmt:formatDate pattern="yyyy/MM/dd HH:mm:ss" value="${item.befInhoSmuDate}" />"/>
            </td>
            <td colspan="2">
                入院后:
                <input type="text" style="width: 200px;" value="<fmt:formatDate pattern="yyyy/MM/dd HH:mm:ss"  value="${item.aftInhoSmuDate}" />"/>
            </td>
        </tr>
        </tbody>
    </table>
    <table class="printposttable" style="height:1px; border-bottom:1px solid black;">
        <colgroup>
            <col style="width: 15%;"/>
            <col style="width: 25%;"/>
            <col style="width: 20%;"/>
            <col style="width: 20%;"/>
            <col style="width: 20%; text-align: right;"/>
        </colgroup>
        <tbody>
        <tr>
            <td class="bold" colspan="3">住院费用（元）总费用 : <input type="text" value="<fmt:formatNumber value="${item.admissionTotalAmount}" type="currency"/>"/></td>
            <td colspan="2">
                (自付金额：
                <input type="text" value="<fmt:formatNumber value="${item.personalExpenses}"  type="currency"/>)"/>
            </td>
        </tr>
        <tr>
            <td class="bold">综合医疗服务类别 : </td>
            <td>一般医疗服务费<input type="text" style="width: 110px;" value="<fmt:formatNumber value="${item.medicalsExpense}" type="currency"/>"/></td>
            <td>一般治疗操作费<input type="text" style="width: 80px;" value="<fmt:formatNumber value="${item.treatmentExpense}" type="currency"/>"/></td>
            <td>护理费<input type="text" style="width: 120px;" value="<fmt:formatNumber value="${item.nurseExpense}" type="currency"/>"/></td>
            <td>其它费用<input type="text" style="width: 124px;" value="<fmt:formatNumber value="${item.otherMedicalsExpense}" type="currency"/>"/></td>
        </tr>
        <tr>
            <td class="bold">诊断类 : </td>
            <td>病理诊断费<input type="text" style="width: 134px;" value="<fmt:formatNumber value="${item.pathologyDiagnosisExpense}" type="currency"/>"/></td>
            <td>实验诊断费<input type="text" style="width: 104px;" value="<fmt:formatNumber value="${item.labDiagnosisExpense}" type="currency"/>"/></td>
            <td>影像诊断费<input type="text" style="width: 96px;" value="<fmt:formatNumber value="${item.imagingDiagnosisExpense}" type="currency"/>"/></td>
            <td>临床诊断项目费<input type="text" style="width: 88px;" value="<fmt:formatNumber value="${item.clinicalItemExpense}" type="currency"/>"/></td>
        </tr>
        <tr>
            <td class="bold">治疗类 : </td>
            <td>非手术治疗项目费<input type="text" style="width: 98px;" value="<fmt:formatNumber value="${item.nonSurgicalItemExpense}" type="currency"/>"/></td>
            <td>(临床物理治疗费<input type="text" style="width: 75px;" value="<fmt:formatNumber value="${item.clinicalTherapyExpense}" type="currency"/>"/>)</td>
        </tr>
        <tr>
            <td></td>
            <td>
                手术治疗费<input type="text" style="width: 135px;" value="<fmt:formatNumber value="${item.surgeryTreatmentExpense}" type="currency"/>"/>
            </td>
            <td>
                (麻醉费<input type="text" style="width: 124px;" value="<fmt:formatNumber value="${item.anesthesiaExpense}" type="currency"/>"/>
            </td>
            <td>
                手术费<input type="text" style="width: 120px;" value="<fmt:formatNumber value="${item.surgeryExpense}" type="currency"/>"/>)
            </td>

        </tr>
        <tr>
            <td class="bold">康复类 : </td>
            <td>康复费<input type="text" style="width: 160px;" value="<fmt:formatNumber value="${item.rehabilitationExpense}" type="currency"/>"/></td>
        </tr>
        <tr>
            <td class="bold">中医类 : </td>
            <td>中医治疗费<input type="text" style="width: 135px;" value="<fmt:formatNumber value="${item.cmTreatmentExpense}" type="currency"/>"/></td>
        </tr>
        <tr>
            <td class="bold">西药类 : </td>
            <td>西药费<input type="text" style="width: 160px;" value="<fmt:formatNumber value="${item.wmExpense}" type="currency"/>"/></td>
            <td>(抗菌药物费用<input type="text" style="width: 88px;" value="<fmt:formatNumber value="${item.antibacterialExpense}" type="currency"/>"/>)</td>
        </tr>
        <tr>
            <td class="bold">中药类 : </td>
            <td>中成药费<input type="text" style="width: 148px;" value="<fmt:formatNumber value="${item.proprietaryCmExpense}" type="currency"/>"/></td>
            <td>中草药费<input type="text" style="width: 120px;" value="<fmt:formatNumber value="${item.chmExpense}" type="currency"/>"/></td>
        </tr>
        <tr>
            <td class="bold">血液和血液制品类 : </td>
            <td>血费<input type="text" style="width: 172px;" value="<fmt:formatNumber value="${item.bloodExpense}" type="currency"/>"/></td>
            <td>白蛋白类制品费<input type="text" style="width: 85px;" value="<fmt:formatNumber value="${item.albuminExpense}" type="currency"/>"/></td>
            <td>球蛋白类制品费<input type="text" style="width: 75px;" value="<fmt:formatNumber value="${item.globulinExpense}" type="currency"/>"/></td>
        </tr>
        <tr>
            <td></td>
            <td>凝血因子类制品费<input type="text" style="width: 100px;" value="<fmt:formatNumber value="${item.clottingFactorExpense}" type="currency"/>"/></td>
            <td>细胞因子类制品费<input type="text" style="width: 73px;" value="<fmt:formatNumber value="${item.cytokinesExpense}" type="currency"/>"/></td>
        </tr>
        <tr>
            <td class="bold">耗材类 : </td>
            <td>检查一次性医用材料费<input type="text" style="width: 76px;" value="<fmt:formatNumber value="${item.checkDmmExpense}" type="currency"/>"/></td>
            <td colspan="2">治疗一次性医用材料费<input type="text" style="width: 70px;" value="<fmt:formatNumber value="${item.treatmentDmmExpense}" type="currency"/>"/></td>
        </tr>
        <tr>
            <td></td>
            <td>手术一次性医用材料费<input type="text" style="width: 70px;" value="<fmt:formatNumber value="${item.surgeryDmmExpense}" type="currency"/>"/></td>
        </tr>
        <tr>
            <td class="bold">其他类 : </td>
            <td>其他费<input type="text" style="width: 162px;" value="<fmt:formatNumber value="${item.otherExpense}" type="currency"/>"/></td>
        </tr>
        </tbody>
    </table>
    <%--
    <table class="printposttable" style="height:1px; border-bottom:1px solid black;">
        <colgroup>
            <col style="width: 20%;"/>
            <col style="width: 80%;"/>
        </colgroup>
        <tbody>
        <tr>
            <td class="bold" >
                主要诊断治愈好转情况:
            </td>
            <td >
                <label>1.治愈<input type="checkbox" /></label>
                <label>2.好转<input type="checkbox" /></label>
                <label>3.未愈<input type="checkbox" /></label>
                <label>4.死亡<input type="checkbox" /></label>
                <label>5.其他<input type="checkbox" /></label>
            </td>
        </tr>
        <tr>
            <td class="bold" rowspan="2" style="vertical-align: top">
                诊断符合情况:
            </td>
            <td >  1.门诊和出院<span class="code_box"></span>   2.入院和出院<span class="code_box"></span>  3.术前和术后<span class="code_box"></span>
            </td>
        </tr>
        <tr>
            <td >
                4.临床和病理<span class="code_box"></span>  5.放射和病理<span class="code_box"></span>  (0.未做 1.符合 2.不符合 .3不确定)
            </td>
        </tr>
        <tr>
            <td class="bold" >
               抢救情况:
            </td>
            <td >
                抢救<input type="text" style="width:20px;" />次
                成功<input type="text" style="width:20px;" />次
                <label>病重<input type="checkbox" /></label>
                <label>病危<input type="checkbox" /></label>
            </td>
        </tr>
        <tr>
            <td class="bold" >
                临床路径管理:
            </td>
            <td >
                <label>1.完成<input type="checkbox" /></label>
                <label>2.变异<input type="checkbox" /></label>
                <label>3.退出<input type="checkbox" /></label>
                <label>4.未入<input type="checkbox" /></label>
            </td>
        </tr>
      </tbody>
    </table>
    --%>
    <table class="printposttable">
        <colgroup>
            <col style="width: 10%;"/>
            <col style="width: 90%;"/>
        </colgroup>
        <tbody>
        <tr>
            <td style=" vertical-align: top;">说明</td>
            <td>
                <p>(一）医疗付费方式 城镇职工基本医疗保险 城镇居民基本医疗保险 新型农村合作医疗 贫苦救助 商业医疗保险 全公费 全自费 其它社会保险 其它</p>
                <p> (二）凡可由医院信息系统提供住院费用清单的，住院病案首页中可不填写“住院费用”。</p>
            </td>
        </tr>
        </tbody>
    </table>

</div>
</div>

<%--<div class="">--%>
	<%--<c:set var="item" value="${inpatientMedicalRecordDto.inpatientMedicalRecord }" ></c:set>--%>
	<%--<c:set var="person" value="${inpatientMedicalRecordDto.personInfo }" ></c:set>--%>
	<%--<c:set var="disease" value="${inpatientMedicalRecordDto.diseaseDiagnosisInfoMap}" ></c:set>--%>
	<%--<c:set var="ops" value="${inpatientMedicalRecordDto.surgeryInfos}" ></c:set>--%>
	<%--<table class="" border=1>--%>
		<%--<tbody>--%>
			<%--<tr>--%>
				<%--<td colspan="5" style="width: 10%;"><br /></td>--%>
			<%----%>
				<%--<th style="width: 10%;">医疗机构<br /></th>--%>
				<%--<td colspan="2" style="width: 10%;"><c:if test="${ not empty item.hospitalName}"><c:out value="${item.hospitalName}" ></c:out></c:if>--%>
				<%--<c:if test="${not empty item.hospitalCode and   empty item.hospitalName}"><ehr:dic dicmeta="FS10002" code="${item.hospitalCode}"></ehr:dic></c:if>--%>
				<%--</td>--%>
				<%----%>
				<%--<th style="width: 10%;">组织机构代码<br /></th>--%>
				<%--<td style="width: 10%;"><c:out value="${item.hospitalCode}" ></c:out></td>--%>
			<%--</tr>--%>
			<%--<tr>--%>
				<%--<th style="width: 10%;">医疗付费方式<br /></th>--%>
				<%--<td colspan="9" style="width: 10%;">--%>
					<%--<ehr:dic dicmeta="CV0710003" code="${item.medicalPayWay}"/>--%>
				<%--</td>--%>
			<%--</tr>--%>
			<%--<tr>--%>
				<%--<td style="width: 10%; text-align: center;" colspan="10"><strong style="font-size: 18px;">住院病案首页</strong></td>--%>
			<%--</tr>--%>
			<%--<tr>--%>
				<%--<td colspan="6"  style="width: 10%;"><br /></td>--%>
				<%--<td style="width: 10%;">第<c:out value="${item.inhosCount}" ></c:out> 次住院 </td>--%>
				<%--<th style="width: 10%;">病案号</th>--%>
				<%--<td colspan="2"  style="width: 10%;"><c:out value="${item.medicalRecordNo}" ></c:out></td>--%>
			<%--</tr>--%>
			<%--<tr>--%>
				<%--<td colspan="10" style="width: 10%;"><br /></td>--%>
			<%--</tr>--%>
			<%--<tr>--%>
				<%--<th style="width: 10%;">姓名</th>--%>
				<%--<td style="width: 10%;"><c:out value="${person.name}" ></c:out></td>--%>
				<%--<th style="width: 10%;">性别</th>--%>
				<%--<td style="width: 10%;"><span class="code_box"><c:out value="${person.gender}" ></c:out></span>(1.男 2.女)</td>--%>
				<%--<th style="width: 10%;">出生日期<br /></th>--%>
				<%--<td style="width: 10%;"> <fmt:formatDate value="${person.birthday}" pattern="yyyy/MM/dd" /><br /></td>--%>
				<%--<th style="width: 10%;">年龄</th>--%>
				<%--<td style="width: 10%;"><c:out value="${item.age}" ></c:out><br /></td>--%>
				<%--<th style="width: 10%;">国籍<br /></th>--%>
				<%--<td style="width: 10%;"><ehr:dic dicmeta="GBT26592000" code="${person.nationality}" /><br /></td>--%>
			<%--</tr>--%>
			<%--<tr>--%>
				<%--<th style="width: 10%;">年龄（不足1周岁的）</th>--%>
				<%--<td style="width: 10%;"><c:out value="${item.monthAge}" ></c:out>月</td>--%>
				<%--<th style="width: 10%;" colspan="1">新生儿出生体重</th>--%>
				<%--<td style="width: 10%;"><c:out value="${item.neonatalBirthWeight}" ></c:out>克<br />--%>
				<%--</td>--%>
				<%--<th style="width: 10%;" colspan="1">新生儿入院体重<br />--%>
				<%--</th>--%>
				<%--<td colspan="5" style="width: 10%;"><c:out value="${item.neonatalinhosWeight}" ></c:out>克<br />--%>
					<%----%>
				<%--</td>--%>
			<%--</tr>--%>
			<%--<tr>--%>
				<%--<th style="width: 10%;">出生地<br /></th>--%>
				<%--<td colspan="3" style="width: 10%;">--%>
					<%--<c:out value="${item.birthProvince}" ></c:out>--%>
					<%--<c:out value="${item.birthCity}" ></c:out>--%>
					<%--<c:out value="${item.birthCountry}" ></c:out>--%>
				<%--</td>--%>
				<%--<th style="width: 10%;">籍贯<br /></th>--%>
				<%--<td colspan="3" style="width: 10%;">--%>
				<%--<c:choose>--%>
					<%--<c:when test='${"1" == person.householdType}'>--%>
						<%--<c:out value="${person.hrprovince}"></c:out>--%>
						<%--<c:out value="${person.hrcity}"></c:out>		--%>
						<%--<c:out value="${person.hrcounty}"></c:out>									--%>
						<%--<ehr:dic dicmeta="FS990001" code="${person.hrtownShip}"></ehr:dic>--%>
						<%--<ehr:dic dicmeta="FS990001" code="${person.hrstreet}"></ehr:dic>--%>
						<%--<c:out value="${person.hrhouseNumber}"></c:out>--%>
					<%--</c:when>--%>
					<%--<c:otherwise>--%>
						<%--<c:out value="${person.hrhouseNumber}"/>--%>
					<%--</c:otherwise>	--%>
				<%--</c:choose>						--%>
				<%--</td>			--%>
				<%--<th style="width: 10%;">民族<br /></th>--%>
				<%--<td style="width: 10%;"><ehr:dic dicmeta="GBT3304" code="${person.nation}" /><br /></td>--%>
			<%--</tr>--%>
			<%--<tr>--%>
				<%--<th style="width: 10%;">身份证号</th>--%>
				<%--<td colspan="3" style="width: 10%;"><c:out value="${person.idcard}" ></c:out><br /></td>--%>
				<%--<th style="width: 10%;">职业</th>--%>
				<%--<td style="width: 10%;"><ehr:dic dicmeta="GBT6565A1" code="${person.occupation}" /><br /></td>--%>
				<%--<th style="width: 10%;">婚姻</th>--%>
				<%--<td style="width: 10%;" colspan="3"><ehr:dic dicmeta="GBT226122003" code="${person.marriage}" /></td>--%>
			<%--</tr>--%>
			<%--<tr>--%>
				<%--<th style="width: 10%;">现住址</th>--%>
				<%--<td style="width: 10%;"><c:out value="${person.paprovince}" ></c:out></td>--%>
				<%--<td style="width: 10%;"><c:out value="${person.pacity}" ></c:out><br /></td>--%>
				<%--<td style="width: 10%;"><c:out value="${person.pacounty}" ></c:out><br /></td>--%>
				<%--<th style="width: 10%;">电话</th>--%>
				<%--<td style="width: 10%;"><c:out value="${person.phoneNumber}" ></c:out><br /></td>--%>
				<%--<th  style="width: 10%;">邮编</th>--%>
				<%--<td colspan="3" style="width: 10%;"><c:out value="${person.papostCode}" ></c:out><br /></td>--%>
			<%----%>
			<%--</tr>--%>
			<%--<tr>--%>
				<%--<th style="width: 10%;">户口地址</th>--%>
				<%--<td style="width: 10%;"><c:out value="${person.hrprovince}" ></c:out><br /></td>--%>
				<%--<td style="width: 10%;"><c:out value="${person.hrcity}" ></c:out><br /></td>--%>
				<%--<td style="width: 10%;"><c:out value="${person.hrcounty}" ></c:out><br /></td>--%>
				<%--<th  style="width: 10%;">邮编</th>--%>
				<%--<td colspan="5" style="width: 10%;"><c:out value="${person.hrpostCode}" ></c:out><br /></td>--%>
			<%----%>
			<%--</tr>--%>
			<%--<tr>--%>
				<%--<th style="width: 10%;">工作单位及地址<br />--%>
				<%--</th>--%>
				<%--<td colspan="3"  style="width: 10%;"><c:out value="${person.unitName}" ></c:out><br /></td>--%>
				<%--<th style="width: 10%;">单位电话</th>--%>
				<%--<td style="width: 10%;"><c:out value="${person.unitPhone}" ></c:out><br /></td>--%>
				<%--<th style="width: 10%;">邮编</th>--%>
				<%--<td colspan="3"   style="width: 10%;"><br /></td>--%>
			<%--</tr>--%>
			<%--<tr>--%>
				<%--<th style="width: 10%;">联系人姓名</th>--%>
				<%--<td style="width: 10%;"><c:out value="${person.firstGuardian}" ></c:out><br /></td>--%>
				<%--<th style="width: 10%;">关系</th>--%>
				<%--<td style="width: 10%;"><ehr:dic dicmeta="GBT4761" code="${person.firstRelation}" /><br /></td>--%>
				<%--<th  style="width: 10%;">地址</th>--%>
				<%--<td colspan="3"  style="width: 10%;"><br /></td>--%>
				<%--<th style="width: 10%;">电话</th>--%>
				<%--<td style="width: 10%;"><c:out value="${person.guardianPhoneOne}" ></c:out></td>--%>
			<%--</tr>--%>
			<%--<tr>--%>
				<%--<th style="width: 10%;">入院途径</th>--%>
				<%--<td style="width: 10%;" colspan="9"><span class="code_box"><c:out value="${item.inhosMethod}" ></c:out></span>（1.急诊 2.门诊 3.其它医疗机构转入 9.其它）</td>--%>
			<%--</tr>--%>
			<%--<tr>--%>
				<%--<th style="width: 10%;">入院时间</th>--%>
				<%--<td style="width: 10%;"><fmt:formatDate pattern="yyyy/MM/dd HH:mm:ss" value="${item.inhosDate}" ></fmt:formatDate><br /></td>--%>
				<%--<th style="width: 10%;">入院科别</th>--%>
				<%--<td style="width: 10%;"><c:out value="${item.inhosDeptName}" ></c:out><br /></td>--%>
				<%--<th style="width: 10%;">病房</th>--%>
				<%--<td style="width: 10%;"><c:out value="${item.inhosRoomCode}" ></c:out><br /></td>--%>
				<%--<th style="width: 10%;">转科科别</th>--%>
				<%--<td style="width: 10%;"><c:out value="${item.transitionDeptName}" ></c:out><br /></td>--%>
				<%--<td style="width: 10%;"><br /></td>--%>
				<%--<td style="width: 10%;"><br /></td>--%>
			<%--</tr>--%>
			<%--<tr>--%>
				<%--<th style="width: 10%;">出院时间</th>--%>
				<%--<td style="width: 10%;"><fmt:formatDate pattern="yyyy/MM/dd HH:mm:ss" value="${item.outHospitalDate}" ></fmt:formatDate><br /></td>--%>
				<%--<th style="width: 10%;">出院科别</th>--%>
				<%--<td style="width: 10%;"><c:out value="${item.outhosDeptName}" ></c:out><br /></td>--%>
				<%--<th style="width: 10%;">病房</th>--%>
				<%--<td style="width: 10%;"><c:out value="${item.outhosRoom}" ></c:out><br /></td>--%>
				<%--<th style="width: 10%;">实际住院</th>&lt;%&ndash;此处计算出，且出院和住院只算一天 &ndash;%&gt;--%>
				<%--<td colspan="3" style="width: 10%;"><c:out value="${inpatientMedicalRecordDto.inhosDays}" ></c:out>天</td>--%>
			<%----%>
			<%--</tr>--%>
			<%--<tr>--%>
				<%--<th style="width: 10%;">门（急）诊诊断</th>--%>
				<%--<c:set var="disease02" value="${disease['02'][0]}"></c:set>--%>
				<%--<td colspan="5"  style="width: 10%;">--%>
					<%--<c:out value="${disease02.diagnosisDesc}"></c:out>--%>
				<%--</td>--%>
				<%--<th style="width: 10%;">疾病编码</th>--%>
				<%--<td colspan="3" style="width: 10%;"><c:out value="${disease02.diseaseCode}"></c:out></td>--%>
				<%----%>
			<%--</tr>--%>
			<%--<tr>--%>
				<%--<td colspan="10" style="width: 10%;">--%>
				<%--<br />--%>
					<%--<table><tr>--%>
							<%--<c:set var="disease12" value="${disease['12'][0]}"></c:set>--%>
							<%--<th colspan="2" style=" text-align: center;">出院诊断</th>--%>
							<%--<th style="text-align: center;">疾病编码</th>--%>
							<%--<th style="text-align: center;">入院病情</th>--%>
							<%--</tr>--%>
							<%--<tr>--%>
							<%--<td ><b>主要诊断:</b></td>--%>
							<%--<td style="width: 10%;"><c:out value="${disease12.diagnosisDesc}"></c:out></td>--%>
							<%--<td style="width: 10%;"><c:out value="${disease12.diseaseCode}"></c:out></td>--%>
							<%--<td style="width: 10%;"><c:out value="${disease12.inhosConditionCode}"></c:out></td>--%>
							<%--</tr>--%>
							<%--<c:set var="diseaseList" value="${disease['99']}"></c:set>--%>
							<%--<c:set var="disLength" value="${fn:length(diseaseList)}"></c:set>--%>
							<%--<tr>--%>
									<%--<td rowspan="${disLength}" style="width: 10%;"><b>其它诊断:</b></td>--%>
									<%--<td style="width: 10%;"><c:out value="${diseaseList[0].diagnosisDesc}"></c:out></td>--%>
									<%--<td style="width: 10%;"><c:out value="${diseaseList[0].diseaseCode}"></c:out></td>--%>
									<%--<td style="width: 10%;"><c:out value="${diseaseList[0].inhosConditionCode}"></c:out></td>--%>
							<%--</tr>--%>
								<%--<c:forEach begin="1" items="${diseaseList}" var="diseaseother">--%>
									<%--<tr>	--%>
											<%--<td style="width: 10%;"><c:out value="${diseaseother.diagnosisDesc}"></c:out></td>--%>
											<%--<td style="width: 10%;"><c:out value="${diseaseother.diseaseCode}"></c:out></td>--%>
											<%--<td style="width: 10%;"><c:out value="${diseaseother.inhosConditionCode}"></c:out></td>--%>
									<%--</tr>--%>
							<%--</c:forEach>--%>
							<%--<tr>--%>
							<%--<td style="width: 10%;" colspan="4">入院病情:1.有2.临床未确定3.情况不明4.无<br />--%>
							<%--</td>--%>
						<%--</tr>--%>
					<%--</table>--%>
				<%--</td>--%>
			<%--</tr>--%>
			
			<%--<tr>--%>
				<%--<th style="width: 10%;">损伤，中毒的外部原因</th>--%>
				<%--<td colspan="5" style="width: 10%;"><c:out value="${item.injuryPosionReason}" ></c:out><br /></td>--%>
			<%----%>
				<%--<th style="width: 10%;">疾病编码</th>--%>
				<%--<td colspan="3" style="width: 10%;"><c:out value="${item.injuryDiseaseCode }"></c:out><br /></td>--%>
		<%----%>
			<%--</tr>--%>
			<%--<tr>--%>
				<%--<c:set var="disease09" value="${disease['09'][0]}"></c:set>--%>
				<%--<th style="width: 10%;" rowspan="2">病理诊断</th>--%>
				<%--<td style="width: 10%;" rowspan="2" colspan="5"><c:out value="${disease09.diagnosisDesc}"></c:out><br /></td>--%>
				<%--<th style="width: 10%;">疾病编码</th>--%>
				<%--<td  colspan="3" style="width: 10%;"><c:out value="${disease09.nlohmsiCode}"></c:out><br /></td>--%>
			<%--</tr>--%>
			<%--<tr>--%>
				<%--<th style="width: 10%;">病理号</th>--%>
				<%--<td  colspan="3" style="width: 10%;"><c:out value="${disease09.diseaseCode}"></c:out><br /></td>--%>
			<%--</tr>--%>
			<%--<tr>--%>
				<%--<th style="width: 10%;">药物过敏</th>--%>
				<%----%>
				<%--<td style="width: 10%;"><span class="code_box">--%>
				<%--<c:if test="${fn:length(inpatientMedicalRecordDto.allergyHistories) >0 }">2</c:if>--%>
				<%--<c:if test="${fn:length(inpatientMedicalRecordDto.allergyHistories) <1 }">1</c:if>--%>
				<%--</span>--%>
				<%--(1.无 2.有)</td>--%>
				<%--<th style="width: 10%;">过敏药物</th>--%>
				<%--<td colspan="3" style="width: 10%;">--%>
				<%--<c:forEach items="${ inpatientMedicalRecordDto.allergyHistories}" var ="allergyHistorie">--%>
					<%--<tag:textWithDic value="${allergyHistorie.allergensName}" dicmeta="CV0501038" code="${allergyHistorie.allergensCode}" />--%>
				<%--</c:forEach>--%>
				<%--<br /></td>--%>
				<%----%>
				<%--<th style="width: 10%;">死亡患者尸检</th>--%>
				<%--<td colspan="3"  style="width: 10%;"><span class="code_box"><c:out value="${item.inhosAutopsyFlag}" ></c:out></span>（1.是 2.否)</td>--%>
			<%--</tr>--%>
			<%--<tr>--%>
				<%--<th style="width: 10%;">血型</th>--%>
				<%--<td style="width: 10%;" colspan="5"><span class="code_box"><c:out value="${person.aboBloodType}" ></c:out></span>(1.A 2.B 3.O 4.AB 5.不详 6.未查)<br />--%>
				<%--</td>--%>
				<%--<th style="width: 10%;">Rh</th>--%>
				<%--<td style="width: 10%;" colspan="3"><span class="code_box"><c:out value="${person.rhBloodType}" ></c:out></span>(1.阴 2.阳 3.不详 4.未查)<br />--%>
				<%--</td>--%>
			<%--</tr>--%>
		
			<%--<tr>--%>
				<%--<th style="width: 10%;">科主任</th>--%>
				<%--<td style="width: 10%;"><c:out value="${item.deptMasterSignature}" ></c:out><br /></td>--%>
				<%--<th style="width: 10%;">主任（副主任）医师</th>--%>
				<%--<td style="width: 10%;"><c:out value="${item.directorDoctorSignature}" ></c:out><br /></td>--%>
				<%--<th style="width: 10%;">主治医师</th>--%>
				<%--<td style="width: 10%;"><c:out value="${item.attendingDoctorSignature}" ></c:out><br /></td>--%>
				<%--<th style="width: 10%;">住院医师</th>--%>
				<%--<td style="width: 10%;"><c:out value="${item.admissionDoctorSignature}" ></c:out><br /></td>--%>
				<%--<td style="width: 10%;"><br /></td>--%>
				<%--<td style="width: 10%;"><br /></td>--%>
			<%--</tr>--%>
			<%--<tr>--%>
				<%--<th style="width: 10%;">责任护士<br />--%>
				<%--</th>--%>
				<%--<td style="width: 10%;"><c:out value="${item.primaryNurseSignature}" ></c:out><br /></td>--%>
				<%--<th style="width: 10%;">进修医师</th>--%>
				<%--<td style="width: 10%;"><c:out value="${item.refresherDoctorsSignature}" ></c:out><br /></td>--%>
				<%--<th style="width: 10%;">实习医师<br />--%>
				<%--</th>--%>
				<%--<td style="width: 10%;"><c:out value="${item.internSignature}" ></c:out><br /></td>--%>
				<%--<th style="width: 10%;">编码员</th>--%>
				<%--<td style="width: 10%;"><c:out value="${item.medicalRecordSignature}" ></c:out><br /></td>--%>
				<%--<td style="width: 10%;"><br /></td>--%>
				<%--<td style="width: 10%;"><br /></td>--%>
			<%--</tr>--%>
			<%--<tr>--%>
				<%--<th style="width: 10%;">病案质量</th>--%>
				<%--<td style="width: 10%;"><span class="code_box"><c:out value="${item.inhosMedicalRecordQualityCode}" ></c:out></span>(1.甲 2.已 3.丙)</td>--%>
				<%--<th style="width: 10%;">质控医师</th>--%>
				<%--<td style="width: 10%;"><c:out value="${item.qcDoctorSignature}" ></c:out><br /></td>--%>
				<%--<th style="width: 10%;">质控护士</th>--%>
				<%--<td style="width: 10%;"><c:out value="${item.qcNurseSignature}" ></c:out><br /></td>--%>
				<%--<th style="width: 10%;">质控日期</th>--%>
				<%--<td colspan="3" style="width: 10%;"><fmt:formatDate pattern="yyyy/MM/dd"  value="${item.qcDate}" ></fmt:formatDate><br /></td>--%>
			<%----%>
			<%--</tr>--%>
			<%--<tr>--%>
				<%--<td style="width: 10%;" colspan="10">--%>
				<%--<br />--%>
				<%--<table >--%>
					<%--<thead>--%>
					<%--<tr>--%>
					<%--<th style=" text-align: center;" rowspan="2">手术及操作编码</th>--%>
					<%--<th style=" text-align: center;"  rowspan="2">手术及操作日期</th>--%>
					<%--<th style=" text-align: center;"  rowspan="2" >手术级别</th>--%>
					<%--<th style=" text-align: center;"  rowspan="2" >手术及操作名称</th>--%>
					<%----%>
					<%--<th style=" text-align: center;" colspan="3" >手术及操作医师</th>--%>
					<%--<th style=" text-align: center;" rowspan="2" >切口愈合等级</th>--%>
					<%--<th style=" text-align: center;" rowspan="2" >麻醉方式</th>--%>
					<%--<th style=" text-align: center;" rowspan="2" >麻醉医师</th>--%>
					<%--</tr>--%>
					<%--<tr>--%>
					<%--<th style=" text-align: center;">术者</th>--%>
					<%--<th style=" text-align: center;">Ⅰ助</th>--%>
					<%--<th style=" text-align: center;">Ⅱ助</th>--%>
					<%--</tr>--%>
					<%--</thead>--%>
					<%--<tbody>--%>
						<%--<c:forEach items="${ops}" var ="op">--%>
						<%--<tr>--%>
							<%--<td style=" text-align: center;"><c:out value="${op.opertationCode}" ></c:out></td>--%>
							<%--<td style=" text-align: center;"><fmt:formatDate pattern="yyyy/MM/dd"  value="${op.opertationDate}" ></fmt:formatDate></td>--%>
							<%--<td style=" text-align: center;"><c:out value="${op.operationLevelName}" ></c:out></td>--%>
							<%--<td style=" text-align: center;"><c:out value="${op.opertationName}" ></c:out></td>--%>
							<%--<td style=" text-align: center;"><c:out value="${op.operatorName}" ></c:out></td>--%>
							<%--<td style=" text-align: center;"><c:out value="${op.operationAssistantOne}" ></c:out></td>--%>
							<%--<td style=" text-align: center;"><c:out value="${op.operationAssistantTwo}" ></c:out></td>--%>
							<%--<td style=" text-align: center;"><c:out value="${op.incisionHealingGradeName}" ></c:out></td>--%>
							<%--<td style=" text-align: center;"><c:out value="${op.anesthesiaMethodName}" ></c:out></td>--%>
							<%--<td style=" text-align: center;"><c:out value="${op.anesthesiaDoctorName}" ></c:out></td>--%>
						<%--</tr>--%>
						<%--</c:forEach>--%>
					<%--</tbody>--%>
				<%--</table>--%>
				<%----%>
				<%--<br /></td>--%>
			<%--</tr>--%>
			<%--<tr>--%>
				<%--<th rowspan="2" style="width: 10%;">离院方式</th>--%>
				<%--<td rowspan="2" style="width: 10%;" rowspan="2" colspan="8">--%>
					<%--<p><span class="code_box"><c:out value="${item.outhosMethod}" ></c:out></span>（1.医嘱离院 2.医嘱转院，拟接受医疗机构名称：</p>--%>
					<%--<p>3.医嘱转社区卫生服务机构/乡镇卫生院，拟接收医疗机构代码：4.非医嘱离院5.死亡9其它）</p>--%>
				<%--</td>--%>
			<%--</tr>--%>
			<%--<tr>--%>
				<%--<td style="width: 10%;"><br /></td>--%>
			<%--</tr>--%>
			<%--<tr>--%>
				<%--<th style="width: 10%;" colspan="3">是否有出院31天内再住院计划</th>--%>
				<%--<td style="width: 10%;"><span class="code_box"><c:out value="${item.outhosFlag}" ></c:out></span>(1.无 2.有)</td>--%>
				<%----%>
				<%--<th>目的</th>--%>
				<%--<td style="width: 10%;" colspan="5"><c:out value="${item.outhosPurpose}" ></c:out><br /></td>--%>
			<%----%>
			<%--</tr>--%>
			<%--<tr>--%>
				<%--<th style="width: 10%;" colspan="3">颅脑损伤患者昏迷时间</th>--%>
				<%--<td colspan="7" style="width: 10%;">--%>
				<%--入院前:--%>
				<%--<fmt:formatDate pattern="yyyy/MM/dd HH:mm:ss" value="${item.befInhoSmuDate}" />--%>
				<%--入院后:--%>
				<%--<fmt:formatDate pattern="yyyy/MM/dd HH:mm:ss"  value="${item.aftInhoSmuDate}" />--%>
				<%--</td>--%>
			<%--</tr>--%>
			<%--<tr>--%>
				<%--<td colspan="10" style="width: 10%;"><br /></td>--%>
			<%--</tr>--%>
			<%--<tr>--%>
			<%----%>
			<%----%>
				<%--<td colspan="10" style="width: 10%;" >住院费用（元）总费用 : <fmt:formatNumber value="${item.admissionTotalAmount}" type="currency"/>      （自付金额）--%>
				<%--<fmt:formatNumber value="${item.personalExpenses}"  type="currency"/></td>--%>
			<%--</tr>--%>
			<%--<tr>--%>
				<%--<th colspan="2" style="width: 10%;">综合医疗服务类别</th>--%>
				<%--<td style="width: 10%;">一般医疗服务费</td>--%>
				<%--<td style="width: 10%;"><fmt:formatNumber value="${item.medicalsExpense}" type="currency"/><br /></td>--%>
				<%--<td style="width: 10%;">一般治疗操作费</td>--%>
				<%--<td style="width: 10%;"><fmt:formatNumber value="${item.treatmentExpense}" type="currency"/><br /></td>--%>
				<%--<td style="width: 10%;">护理费</td>--%>
				<%--<td style="width: 10%;"><fmt:formatNumber value="${item.nurseExpense}" type="currency"/><br /></td>--%>
				<%--<td style="width: 10%;">其它费用</td>--%>
				<%--<td style="width: 10%;"><fmt:formatNumber value="${item.otherMedicalsExpense}" type="currency"/><br /></td>--%>
			<%--</tr>--%>
			<%--<tr>--%>
				<%--<th colspan="2"   style="width: 10%;">诊断类</th>--%>
				<%--<td style="width: 10%;">病理诊断费</td>--%>
				<%--<td style="width: 10%;"><fmt:formatNumber value="${item.pathologyDiagnosisExpense}" type="currency"/><br /></td>--%>
				<%--<td style="width: 10%;">实验诊断费</td>--%>
				<%--<td style="width: 10%;"><fmt:formatNumber value="${item.labDiagnosisExpense}" type="currency"/><br /></td>--%>
				<%--<td style="width: 10%;">影像诊断费</td>--%>
				<%--<td style="width: 10%;"><fmt:formatNumber value="${item.imagingDiagnosisExpense}" type="currency"/><br /></td>--%>
				<%--<td style="width: 10%;">临床诊断项目费</td>--%>
				<%--<td style="width: 10%;"><fmt:formatNumber value="${item.clinicalItemExpense}" type="currency"/><br /></td>--%>
			<%--</tr>--%>
			<%--<tr>--%>
				<%--<th rowspan="2" colspan="2"  style="width: 10%;">治疗类</th>--%>
				<%--<td style="width: 10%;" >非手术治疗项目费</td>--%>
				<%--<td style="width: 10%;"><fmt:formatNumber value="${item.nonSurgicalItemExpense}" type="currency"/></td>--%>
				<%--<td style="width: 10%;" colspan="2">临床物理治疗费<br />--%>
				<%--</td>--%>
				<%--<td style="width: 10%;"><fmt:formatNumber value="${item.clinicalTherapyExpense}" type="currency"/><br /></td>--%>
				<%--<td colspan="3" style="width: 10%;"><br /></td>--%>
			<%--</tr>--%>
			<%--<tr>--%>
			<%----%>
				<%--<td style="width: 10%;" >手术治疗费<br /></td>--%>
				<%--<td style="width: 10%;"><fmt:formatNumber value="${item.surgeryTreatmentExpense}" type="currency"/><br /></td>--%>
				<%--<td style="width: 10%;">麻醉费</td>--%>
				<%--<td style="width: 10%;"><fmt:formatNumber value="${item.anesthesiaExpense}" type="currency"/><br /></td>--%>
				<%--<td style="width: 10%;">手术费</td>--%>
				<%--<td style="width: 10%;"><fmt:formatNumber value="${item.surgeryExpense}" type="currency"/><br /></td>--%>
				<%--<td colspan="2" style="width: 10%;"><br /></td>--%>
				<%----%>
			<%--</tr>--%>
			<%--<tr>--%>
				<%--<th style="width: 10%;" colspan="2" >康复类</th>--%>
				<%--<td style="width: 10%;">康复费</td>--%>
				<%--<td style="width: 10%;"><fmt:formatNumber value="${item.rehabilitationExpense}" type="currency"/><br /></td>--%>
				<%--<td style="width: 10%;"><br /></td>--%>
				<%--<td style="width: 10%;"><br /></td>--%>
				<%--<td style="width: 10%;"><br /></td>--%>
				<%--<td style="width: 10%;"><br /></td>--%>
				<%--<td style="width: 10%;"><br /></td>--%>
				<%--<td style="width: 10%;"><br /></td>--%>
			<%--</tr>--%>
			<%--<tr>--%>
				<%--<th style="width: 10%;" colspan="2" >中医类</th>--%>
				<%--<td style="width: 10%;">中医治疗费</td>--%>
				<%--<td style="width: 10%;"><fmt:formatNumber value="${item.cmTreatmentExpense}" type="currency"/><br /></td>--%>
				<%--<td style="width: 10%;"><br /></td>--%>
				<%--<td style="width: 10%;"><br /></td>--%>
				<%--<td style="width: 10%;"><br /></td>--%>
				<%--<td style="width: 10%;"><br /></td>--%>
				<%--<td style="width: 10%;"><br /></td>--%>
				<%--<td style="width: 10%;"><br /></td>--%>
			<%--</tr>--%>
			<%--<tr>--%>
				<%--<th style="width: 10%;" colspan="2" >西药类</th>--%>
				<%--<td style="width: 10%;">西药费</td>--%>
				<%--<td style="width: 10%;"><fmt:formatNumber value="${item.wmExpense}" type="currency"/><br /></td>--%>
				<%--<td style="width: 10%;">抗菌药物费用</td>--%>
				<%--<td style="width: 10%;"><fmt:formatNumber value="${item.antibacterialExpense}" type="currency"/><br /></td>--%>
				<%--<td style="width: 10%;"><br /></td>--%>
				<%--<td style="width: 10%;"><br /></td>--%>
				<%--<td style="width: 10%;"><br /></td>--%>
				<%--<td style="width: 10%;"><br /></td>--%>
			<%--</tr>--%>
			<%--<tr>--%>
				<%--<th style="width: 10%;" colspan="2" >中药类<br />--%>
				<%--</th>--%>
				<%--<td style="width: 10%;">中成药费</td>--%>
				<%--<td style="width: 10%;"><fmt:formatNumber value="${item.proprietaryCmExpense}" type="currency"/><br /></td>--%>
				<%--<td style="width: 10%;">中草药费</td>--%>
				<%--<td style="width: 10%;"><fmt:formatNumber value="${item.chmExpense}" type="currency"/><br /></td>--%>
				<%--<td style="width: 10%;"><br /></td>--%>
				<%--<td style="width: 10%;"><br /></td>--%>
				<%--<td style="width: 10%;"><br /></td>--%>
				<%--<td style="width: 10%;"><br /></td>--%>
			<%--</tr>--%>
			<%--<tr>--%>
				<%--<th rowspan="2" style="width: 10%;" colspan="2"  >血液和血液制品类</th>--%>
				<%--<td style="width: 10%;">血费</td>--%>
				<%--<td style="width: 10%;"><fmt:formatNumber value="${item.bloodExpense}" type="currency"/><br /></td>--%>
				<%--<td style="width: 10%;">蛋白类制品费用</td>--%>
				<%--<td style="width: 10%;"><fmt:formatNumber value="${item.albuminExpense}" type="currency"/><br /></td>--%>
				<%--<td style="width: 10%;">球蛋白类制品费</td>--%>
				<%--<td style="width: 10%;"><fmt:formatNumber value="${item.globulinExpense}" type="currency"/><br /></td>--%>
				<%--<td style="width: 10%;"></td>--%>
				<%--<td style="width: 10%;"></td>--%>
			<%----%>
			<%--</tr>--%>
			<%--<tr>--%>
				<%--<td style="width: 10%;">凝血因子类制品费</td>--%>
				<%--<td style="width: 10%;"><fmt:formatNumber value="${item.clottingFactorExpense}" type="currency"/><br /></td>--%>
				<%--<td style="width: 10%;">细胞因子类制品费</td>--%>
				<%--<td style="width: 10%;"><fmt:formatNumber value="${item.cytokinesExpense}" type="currency"/><br /></td>--%>
				<%--<td style="width: 10%;"><br /></td>--%>
				<%--<td style="width: 10%;"><br /></td>--%>
				<%--<td style="width: 10%;"><br /></td>--%>
				<%--<td style="width: 10%;"><br /></td>--%>
			<%--</tr>--%>
			<%--<tr>--%>
				<%--<th style="width: 10%;" colspan="2"  >耗材类</th>--%>
				<%--<td style="width: 10%;">检查一次性医用材料费</td>--%>
				<%--<td style="width: 10%;"><fmt:formatNumber value="${item.checkDmmExpense}" type="currency"/><br /></td>--%>
				<%--<td style="width: 10%;">治疗一次性医用材料费<br />--%>
				<%--</td>--%>
				<%--<td style="width: 10%;"><fmt:formatNumber value="${item.treatmentDmmExpense}" type="currency"/><br /></td>--%>
				<%--<td style="width: 10%;">手术一次性医用材料费</td>--%>
				<%--<td style="width: 10%;"><fmt:formatNumber value="${item.surgeryDmmExpense}" type="currency"/><br /></td>--%>
				<%--<td style="width: 10%;"><br /></td>--%>
				<%--<td style="width: 10%;"><br /></td>--%>
			<%--</tr>--%>
			<%--<tr>--%>
				<%--<th style="width: 10%;" colspan="2"  >其他类</th>--%>
				<%--<td style="width: 10%;">其他费</td>--%>
				<%--<td style="width: 10%;"><fmt:formatNumber value="${item.otherExpense}" type="currency"/><br /></td>--%>
				<%--<td style="width: 10%;"><br /></td>--%>
				<%--<td style="width: 10%;"><br /></td>--%>
				<%--<td style="width: 10%;"><br /></td>--%>
				<%--<td style="width: 10%;"><br /></td>--%>
				<%--<td style="width: 10%;"><br /></td>--%>
				<%--<td style="width: 10%;"><br /></td>--%>
			<%--</tr>--%>
			<%--<tr>--%>
				<%--<td colspan="10" style="width: 10%;"><br /></td>--%>
				<%----%>
			<%--</tr>--%>
			<%--<tr>--%>
				<%--<td rowspan="2" style="width: 10%;">说明</td>--%>
				<%--<td style="width: 10%;" rowspan="2" colspan="9">--%>
					<%--<p>(一）医疗付费方式 城镇职工基本医疗保险 城镇居民基本医疗保险 新型农村合作医疗 贫苦救助 商业医疗保险 全公费 全自费 其它社会保险 其它</p>--%>
					<%--<p> (二）凡可由医院信息系统提供住院费用清单的，住院病案首页中可不填写“住院费用”。</p>--%>
				<%--</td>--%>
			<%--</tr>--%>
			<%----%>
		<%--</tbody>--%>
	<%--</table>--%>
<%--</div>--%>