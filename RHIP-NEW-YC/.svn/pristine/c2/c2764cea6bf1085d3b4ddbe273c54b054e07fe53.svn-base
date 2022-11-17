<%@ page import="com.founder.rhip.ehr.common.RoleType" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script src="${pageContext.request.contextPath}/js/views/dref/outTransfer/edit.js" type="text/javascript"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery/jquery.PrintArea.js"/>
<c:set var="HGZX" value="<%=RoleType.HGZX.getValue()%>"/>
<style>
    .posttable th, .posttable td {
        height: 22px;
        line-height: 22px;
        padding: 0 5px;
        table-layout: fixed;
    }
</style>
<div class="toolbar">
    <a href="javascript:void(0)" id="back" onclick="outTransferEdit.back()"><b class="fanhui">返回</b></a>
    <ehr:authorize ifNotGranted= "${HGZX}">
        <c:if test="${outTransfer.patientType == '03' || outTransfer.patientType == '02'}">
            <c:if test="${empty outTransfer.medicalDeptAudit}">
                <a href="javascript:void(0)" onclick="outTransferEdit.editOutTransfer()"><b class="tijiao">审批</b></a>
            </c:if>
            <c:if test="${outTransfer.centerAudit == 1}">
                <a href="javascript:void(0)" onclick="outTransferEdit.print2()"><b class="dayin">打印</b></a>
            </c:if>
        </c:if>
        <c:if test="${outTransfer.patientType != '03' && outTransfer.patientType != '02'}">
            <a href="javascript:void(0)" onclick="outTransferEdit.editAndPrint(${outTransfer.patientType})"><b class="tijiao">审批</b></a>
        </c:if>

    </ehr:authorize>
</div>
<div id="printDiv">
<form id="editForm" class="postcontent">
    <input type="hidden" name="fromType" value="${outTransfer.fromType}"/>
    <input type="hidden" name="fromOfficeName" value="${outTransfer.fromOfficeName}"/>
    <div class="postdiv">
		<fieldset style="margin-top: 10px;">
            <i class="popno" style="height: auto">市居民转诊、转院审批表（存根）</i>
            <input type="hidden" id="id" name="id" value="${outTransfer.id}">
			<table class="posttable" style="line-height: 20px;">
				<colgroup>
                    <col style="width: 20%"/>
                    <col style="width: 25%"/>
                    <col style="width: 15%"/>
                    <col />
				</colgroup>
				<tbody>
                <tr>
                    <th>医疗机构名称</th>
                    <td><ehr:org code="${outTransfer.fromOrganCode}"></ehr:org></td>
                    <th>编号</th>
                    <td>${outTransfer.serialNumber}</td>
                </tr>
                <tr>
                    <th>姓名</th>
                    <td>${outTransfer.name}</td>
                    <th>性别</th>
                    <td>
                        <%--${outTransfer.gender == 1?"男":"女"}--%>
                        <%--<ehr:dic dicmeta="GBT226112003" code="${outTransfer.gender}"></ehr:dic>--%>
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
                    </td>
                    <th>门诊/住院号</th>
                    <td>${outTransfer.outNo}</td>
                </tr>
                <tr>
                    <th>保险编号</th>
                    <td>${outTransfer.insuranceNo}</td>
                    <th>身份证号</th>
                    <td>${outTransfer.idcard}</td>
                </tr>
                <tr>
                    <th>病人类型</th>
                    <td>
                        <ehr:dic code="${outTransfer.patientType}" dicmeta="CV0710003"></ehr:dic>
                        <input type="hidden" id="patientType" name="patientType" value="${outTransfer.patientType}">
                    </td>
                    <th>申请医师</th>
                    <td>${outTransfer.doctor}</td>
                </tr>
                <tr>
                    <th>初步诊断</th>
                    <td>${outTransfer.icdName}(${outTransfer.icdCode})</td>
                    <th>转何地、何院</th>
                    <td>
                        <c:if test="${outTransfer.toOrganCode != 699999}"><ehr:dic dicmeta="OT00002" code="${outTransfer.toOrganCode}" ></ehr:dic></c:if>
                        <c:if test="${outTransfer.toOrganCode == 699999}">${outTransfer.toOrganCode}</c:if>
                    </td>
                </tr>
                <tr>
                    <th>科室</th>
                    <td>${outTransfer.fromOfficeName}</td>
                    <th>科主任</th>
                    <td>${outTransfer.director}</td>
                </tr>
                <tr>
                    <th>批准人</th>
                    <td><ehr:user userCode="${outTransfer.medicalDeptUserCode}"></ehr:user></td>
                </tr>
				</tbody>
			</table>
		</fieldset>
	</div>

    <div style=" border:1px dashed #334455; margin-bottom: 10px;margin-top: 10px;"></div>

    <div class="postdiv">
        <fieldset>
            <i class="popno" style="height: auto">市居民转诊、转院审批表</i>
            <table class="posttable" style="line-height: 20px;">
                <colgroup>
                    <col style="width: 20%"/>
                    <col style="width: 25%"/>
                    <col style="width: 15%"/>
                    <col />
                </colgroup>
                <tbody>
                <tr>
                    <th>医疗机构名称</th>
                    <td><ehr:org code="${outTransfer.fromOrganCode}"></ehr:org></td>
                    <th>编号</th>
                    <td>${outTransfer.serialNumber}</td>
                </tr>
                <tr>
                    <th>姓名</th>
                    <td>${outTransfer.name}</td>
                    <th>性别</th>
                    <td>
                    <%--${outTransfer.gender == 1?"男":"女"}--%>
                        <%--<ehr:dic dicmeta="GBT226112003" code="${outTransfer.gender}"></ehr:dic>--%>
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
                    </td>
                    <th>门诊/住院号</th>
                    <td>${outTransfer.outNo}</td>
                </tr>
                <tr>
                    <th>保险编号</th>
                    <td>${outTransfer.insuranceNo}</td>
                    <th>身份证号</th>
                    <td>${outTransfer.idcard}</td>
                </tr>
                <tr>
                    <th>病人类型</th>
                    <td><ehr:dic code="${outTransfer.patientType}" dicmeta="CV0710003"></ehr:dic></td>
                    <th>初步诊断</th>
                    <td>${outTransfer.icdName}(${outTransfer.icdCode})</td>
                </tr>
                <tr>
                    <th>转何地、何院</th>
                    <td>
                        <c:if test="${outTransfer.toOrganCode != 699999}"><ehr:dic dicmeta="OT00002" code="${outTransfer.toOrganCode}" ></ehr:dic></c:if>
                        <c:if test="${outTransfer.toOrganCode == 699999}">${outTransfer.toOrganCode}</c:if>
                    </td>
                    <th>诊治医生</th>
                    <td>${outTransfer.doctor}</td>
                </tr>
                <tr>
                    <th>科室</th>
                    <td>${outTransfer.fromOfficeName}</td>
                    <th><label class="required">科主任</label></th>
                    <td>
                        <input type="text" name="director" value="${outTransfer.director}" reg="{'maxlength':16,'required':'true'}" style="width: 180px">
                        <label style="color: red">必须填写，字数不能超过16个</label>
                    </td>
                </tr>
                <tr>
                    <th>转出日期</th>
                    <td><fmt:formatDate value="${outTransfer.transferDt}" pattern="yyyy/MM/dd"></fmt:formatDate></td>
                </tr>
                <tr>
                    <th>病情摘要（转诊、院理由）</th>
                    <td colspan="3"><textarea cols="30" rows="3" style="width: 90%" readonly="true">${outTransfer.summary}</textarea></td>
                </tr>
                <tr>
                    <th><label class="required">医院（医务科）意见</label></th>
                    <td>
                        <ehr:dic-radio name="medicalDeptAudit" dicmeta="OT00001" value="${outTransfer.medicalDeptAudit}" reg='{"required":"true"}' onchange="outTransferEdit.changMedicalDeptAudit()"></ehr:dic-radio>
                                       <%--onchange="outTransferEdit.centerApprove('${outTransfer.fromOrganCode}','${outTransfer.icdCode}','${outTransfer.toOrganCode}')"--%>
                    </td>
                </tr>
                <tr>
                    <th><label style="color: red">必须选择并且填写意见<br/>字数不能超过128个</label></th>
                    <td colspan="3">
                        <textarea id="medicalDeptOpinionId" name="medicalDeptOpinion" cols="30" rows="3" reg="{'maxlength':128,'required':'true'}" style="width: 90%">${outTransfer.medicalDeptOpinion}</textarea>
                    </td>
                </tr>
                <tr>
                    <td colspan="3"></td>
                    <td><span style="padding-left: 100px;">经办人：<ehr:user userCode="${outTransfer.medicalDeptUserCode}"></ehr:user></span>
                        <input type="hidden" id="medicalDeptUserCodeId" name="medicalDeptUserCode" value="${outTransfer.medicalDeptUserCode}">
                    </td>
                </tr>
                <tr>
                    <td colspan="3"></td>
                    <td><span style="padding-left: 100px;">日期：<fmt:formatDate value="${outTransfer.medicalDeptDt}" pattern="yyyy/MM/dd"></fmt:formatDate></span></td>
                </tr>
                <tr>
                    <th rowspan="2">医保（城保、居民医保）部门审批意见</th>
                    <td>
                        <ehr:dic-radio name="centerAudit" dicmeta="OT00001" value="${outTransfer.centerAudit}" disabled="true"></ehr:dic-radio>
                    </td>
                </tr>
                <tr>
                    <td colspan="3">
                        <textarea id="centerOpinion" name="centerOpinion" cols="30" rows="3" reg="{'maxlength':100}" readonly="true" style="width: 90%">${outTransfer.centerOpinion}</textarea>
                    </td>
                </tr>
                <tr>
                    <td colspan="3"></td>
                    <td><span style="padding-left: 100px;">经办人：
                        <span id="centerUserId">${outTransfer.centerUser}</span>
                    </span></td>
                </tr>
                <tr>
                    <td colspan="3"></td>
                    <td>
                        <span style="padding-left: 100px;">日期：
                            <span id="centerDtId"><fmt:formatDate value="${outTransfer.centerDt}" pattern="yyyy/MM/dd"></fmt:formatDate></span>
                        </span>
                    </td>
                </tr>
                <tr>
                    <td colspan="4" style="line-height: 20px;">
                        1．参保人员转外就医应在转诊当日到医院医务科（医保办）办理登记，自动审批，并打印转诊单后方可到市外指定医院诊治，不需再到市医保（城保、居民医保）部门办理审批手续。若急诊、危重患者因情况紧急，为争取时间需立即转往市外指定医院抢救的，应在转出之日起七个工作日内到转诊医院医务科（医保办）完成转诊登记审批。<br>
                        2．市外指定医院只限院本部，不包括分院、协作医院(病房)、联合医院(病房)等形式的医院。<br>
                        3．转外就医手续当次有效，再次转诊必须重新办理。特殊情况下，患者为完成一个治疗方案需分次间隔治疗的，一个治疗疗程可只办理一次转诊手续。<br>
                        4．咨询电话：52701397
                    </td>
                </tbody>
            </table>
        </fieldset>
    </div>
</form>
</div>