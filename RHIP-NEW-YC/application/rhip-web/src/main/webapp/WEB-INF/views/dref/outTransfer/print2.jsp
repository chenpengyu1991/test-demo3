<%@ page import="com.founder.rhip.ehr.common.RoleType" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<style>
    .posttable th, .posttable td {
        height: 21px;
        line-height: 21px;
        padding: 0 5px;
        table-layout: fixed;
    }
</style>
<div id="printDiv">
<form id="editForm" class="postcontent">
    <div class="postdiv">
		<fieldset>
            <i class="popno" style="height: auto">市居民转诊、转院审批表（存根）</i>
            <input type="hidden" id="id" value="${outTransfer.id}">
			<table class="posttable" style="line-height: 20px">
				<colgroup>
                    <col style="width: 16%"/>
                    <col style="width: 24%"/>
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
            <table class="posttable" style="line-height: 20px">
                <colgroup>
                    <col style="width: 16%"/>
                    <col style="width: 24%"/>
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
                    <td colspan="3">
                        <c:if test="${outTransfer.toOrganCode != 699999}"><ehr:dic dicmeta="OT00002" code="${outTransfer.toOrganCode}" ></ehr:dic></c:if>
                        <c:if test="${outTransfer.toOrganCode == 699999}">${outTransfer.toOrganCode}</c:if>
                    </td>
                </tr>
                <tr>
                    <th>诊治医生</th>
                    <td>${outTransfer.doctor}</td>
                    <th>科室</th>
                    <td>${outTransfer.fromOfficeName}</td>
                </tr>
                <tr>
                    <th>科主任</th>
                    <td>${outTransfer.director}</td>
                    <th>转出日期</th>
                    <td><fmt:formatDate value="${outTransfer.transferDt}" pattern="yyyy/MM/dd"></fmt:formatDate></td>
                </tr>
                <tr>
                    <th>病情摘要<br/>(转诊、院理由)</th>
                    <%--<td colspan="3"><textarea cols="30" rows="5" style="width: 90%" readonly="true">${outTransfer.summary}</textarea></td>--%>
                    <td colspan="3" style="word-break: break-all; word-wrap:break-word;">
                        <div style="height: 80px;">${outTransfer.summary}</div>
                    </td>
                </tr>
                <tr>
                    <td colspan="4">医院（医务科）意见：</td>
                <tr>
                <tr>
                    <th></th>
                    <%--<td colspan="3">--%>
                        <%--<textarea cols="30" rows="1" style="width: 90%"><c:if test="${outTransfer.medicalDeptAudit == 1}">通过</c:if><c:if test="${outTransfer.medicalDeptAudit == 2}">不通过</c:if></textarea>--%>
                    <%--</td>--%>
                    <td colspan="3" style="word-break: break-all; word-wrap:break-word;">
                        <div style="height: 25px;">${outTransfer.medicalDeptOpinion}</div>
                    </td>
                </tr>
                <tr>
                    <td colspan="2">经办人签名(盖章)：</td>
                    <%--<td>--%>
                        <%--&lt;%&ndash;<span><ehr:user userCode="${outTransfer.medicalDeptUserCode}"></ehr:user></span>&ndash;%&gt;--%>
                    <%--</td>--%>
                    <td>医保办(盖章)：</td>
                    <td style="text-align: center"><span>日期：<fmt:formatDate value="${outTransfer.medicalDeptDt}" pattern="yyyy/MM/dd"></fmt:formatDate></span></td>
                </tr>
                <tr>
                    <td colspan="4">医保（城保、居民医保）部门审批意见：</td>
                </tr>
                <tr>
                    <th></th>
                    <%--<td colspan="3">--%>
                        <%--<textarea rows="1" style="width: 90%"><c:if test="${outTransfer.centerAudit == 1}">同意转诊。医疗费用报销按相关规定执行</c:if><c:if test="${outTransfer.centerAudit == 2}">${outTransfer.centerOpinion}</c:if></textarea>--%>
                    <%--</td>--%>
                    <td colspan="3" style="word-break: break-all; word-wrap:break-word;">
                        <div style="height: 25px;"><c:if test="${outTransfer.centerAudit == 1}">同意转诊。医疗费用报销按相关规定执行</c:if><c:if test="${outTransfer.centerAudit == 2}">${outTransfer.centerOpinion}</c:if></div>
                    </td>
                </tr>
                <tr>
                    <td colspan="2">经办人：<span id="centerUserId">${outTransfer.centerUser}</span></td>
                    <td></td>
                    <td style="text-align: center">
                        <span>日期： <fmt:formatDate value="${outTransfer.centerDt}" pattern="yyyy/MM/dd"></fmt:formatDate> </span>
                    </td>
                </tr>
                </tbody>
            </table>
        </fieldset>
    </div>
    <table>
        <tr>
            <td colspan="4" style="font-size: 10px;">
                1．参保人员转外就医应在转诊当日到医院医务科（医保办）办理登记，自动审批，并打印转诊单后方可到市外指定医院诊治，不需再到市医保（城保、居民医保）部门办理审批手续。若急诊、危重患者因情况紧急，为争取时间需立即转往市外指定医院抢救的，应在转出之日起七个工作日内到转诊医院医务科（医保办）完成转诊登记审批。<br>
                2．市外指定医院只限院本部，不包括分院、协作医院(病房)、联合医院(病房)等形式的医院。<br>
                3．转外就医手续当次有效，再次转诊必须重新办理。特殊情况下，患者为完成一个治疗方案需分次间隔治疗的，一个治疗疗程可只办理一次转诊手续。<br>
                4．咨询电话：52701397
            </td>
        </tr>
    </table>
</form>
</div>