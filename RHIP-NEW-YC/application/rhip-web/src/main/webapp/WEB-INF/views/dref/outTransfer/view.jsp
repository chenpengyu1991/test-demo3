<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script src="${pageContext.request.contextPath}/js/views/dref/outTransfer/edit.js" type="text/javascript"></script>
<div class="toolbar">
    <a href="javascript:void(0)" id="back" onclick="outTransferEdit.back()"><b class="fanhui">返回</b></a>
    <c:if test="${outTransfer.patientType == '03'||outTransfer.patientType == '02'}">
        <c:if test="${outTransfer.centerAudit == 1}">
            <a href="javascript:void(0)" onclick="outTransferEdit.print2()"><b class="dayin">打印</b></a>
        </c:if>
    </c:if>
    <c:if test="${outTransfer.patientType == '01'||outTransfer.patientType == '07'}">
        <c:if test="${outTransfer.medicalDeptAudit == 1}">
            <a href="javascript:void(0)" onclick="outTransferEdit.print2()"><b class="dayin">打印</b></a>
        </c:if>
    </c:if>
</div>
<form class="postcontent">
	<div class="postdiv">
		<fieldset style="margin-top: 10px;">
            <i class="popno">市居民转诊、转院审批表（存根）</i>
			<table class="posttable">
				<colgroup>
                    <col style="width: 20%"/>
                    <col style="width: 25%"/>
                    <col style="width: 15%"/>
                    <col />
				</colgroup>
				<tbody>
                <input type="hidden" id="id" name="id" value="${outTransfer.id}">
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
                    <td>${outTransfer.director}</td>
                </tr>
				</tbody>
			</table>
		</fieldset>
	</div>

    <div style=" border:1px dashed #334455; margin-bottom: 20px;margin-top: 20px;"></div>

    <div class="postdiv">
        <fieldset>
            <i class="popno" >市居民转诊、转院审批表</i>
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
                    <td><ehr:org code="${outTransfer.fromOrganCode}"></ehr:org></td>
                    <th>编号</th>
                    <td>${outTransfer.serialNumber}</td>
                </tr>
                <tr>
                    <th>姓名</th>
                    <td>${outTransfer.name}</td>
                    <th>性别</th>
                    <td>
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
                        <c:if test="${outTransfer.toOrganCode != 699999}">
                            <ehr:dic dicmeta="OT00002" code="${outTransfer.inToOrganCode}" ></ehr:dic>
                        </c:if>
                        <c:if test="${outTransfer.toOrganCode == 699999}">${outTransfer.inToOrganCode}</c:if>
                    </td>
                    <th>诊治医生</th>
                    <td>${outTransfer.doctor}</td>
                </tr>
                <tr>
                    <th>科室</th>
                    <td>${outTransfer.fromOfficeName}</td>
                    <th>科主任</th>
                    <td>${outTransfer.director}</td>
                </tr>
                <tr>
                    <th>转出日期</th>
                    <td><fmt:formatDate value="${outTransfer.transferDt}" pattern="yyyy/MM/dd"></fmt:formatDate></td>
                </tr>
                <tr>
                    <th>病情摘要<br/>(转诊、院理由)</th>
                    <td colspan="3"><textarea cols="30" rows="5" style="width: 90%" readonly="true">${outTransfer.summary}</textarea></td>
                </tr>
                <tr>
                    <th>医院（医务科）意见</th>
                    <td>
                        <ehr:dic-radio name="medicalDeptAudit" dicmeta="OT00001" value="${outTransfer.medicalDeptAudit}" disabled="true"></ehr:dic-radio>

                    </td>
                </tr>
                <tr>
                    <th></th>
                    <td colspan="3">
                        <textarea name="medicalDeptOpinion" cols="30" rows="3" style="width: 90%" readonly="true">${outTransfer.medicalDeptOpinion}</textarea>
                    </td>
                </tr>
                <tr>
                    <td colspan="3"></td>
                    <td><span style="padding-left: 100px;">经办人：<ehr:user userCode="${outTransfer.medicalDeptUserCode}"></ehr:user></span>
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
                        <textarea id="centerOpinion" name="centerOpinion" cols="30" rows="3" readonly="true" style="width: 90%">${outTransfer.centerOpinion}</textarea>
                    </td>
                </tr>
                <tr>
                    <td colspan="3"></td>
                    <td><span style="padding-left: 100px;">经办人：
                        <span id="centerUserId" >${outTransfer.centerUser}</span>
                    </span></td>
                </tr>
                <tr>
                    <td colspan="3"></td>
                    <td>
                        <span style="padding-left: 100px;">日期：
                            <span id="centerDtId" ><fmt:formatDate value="${outTransfer.centerDt}" pattern="yyyy/MM/dd"></fmt:formatDate></span>
                        </span>
                    </td>
                </tr>
                </tbody>
            </table>
        </fieldset>
    </div>
</form>