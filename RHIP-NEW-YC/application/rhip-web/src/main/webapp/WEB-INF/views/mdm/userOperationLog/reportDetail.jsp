<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>


<script src="${pageContext.request.contextPath}/js/views/mdm/userOperationLog/searchDetail.js" type="text/javascript"></script>

<div class="toolbar" style="margin-top: 10px;">
    <!-- <a href="javascript:void(0)" onclick="javascript:userOperationLogSearchDetail.returnSearch()"><b class="fanhui">返回</b></a> -->
    <a href="javascript:void(0)" onclick="javascript:userOperationLogSearchDetail.returnSearch()"><button class="btn-gray layui-btn layui-btn-sm button"><i class="layui-icon">&#xe65c;</i>返回</button></a>
</div>

<div class="postcontent contentfixed32">
<i class="popno">报卡内容</i>
<div class="postdiv">
<fieldset class="layui-elem-field">
    <table class="posttable">
        <colgroup>
            <col style="min-width: 80px; width: 15%;"/>
            <col style="min-width: 150px; width: 35%;"/>
            <col style="min-width: 80px; width: 15%;"/>
            <col style="min-width: 150px; width: 35%;"/>
        </colgroup>
        <tbody>
        <tr>
            <td colspan="3" style="text-align: left">
                <ehr:dic dicmeta="PH00028" code="${reportRecord.type}"/>：

                <c:if test="${reportRecord.type==1}">
                    <ehr:dic dicmeta="DMD00004" code="${reportRecord.illnessSecondCode}"/>【<ehr:dic dicmeta="DMD00064" code="${reportRecord.status}"/>】
                </c:if>
                <c:if test="${reportRecord.type==2}">
                    ${reportRecord.illnessSecondName}&nbsp;&nbsp;【<ehr:dic dicmeta="IDM00336" code="${reportRecord.status}"/>】
                </c:if>
                <c:if test="${reportRecord.isDelete==-1}">
                    【已删除】
                </c:if>
            </td>
            <td style="text-align: right;">
                中文编码规则：${reportRecord.charsetName}
            </td>
        </tr>
        <tr>
            <th>患者姓名</th>
            <td>${reportRecord.name}</td>
            <th>身份证号</th>
            <td>${reportRecord.idcard}</td>
        </tr>
        <tr>
            <th>性别</th>
            <td>
                <ehr:dic dicmeta="GBT226112003" code="${reportRecord.gender}" />
            </td>
            <th>出生日期</th>
            <td>
                <fmt:formatDate value="${reportRecord.birthday}" pattern="yyyy/MM/dd" />
            </td>
        </tr>
        <tr>
            <th>年龄</th>
            <td>${reportRecord.age}</td>
            <th>年龄单位</th>
            <td>
                <ehr:dic dicmeta="IDM00003" code="${reportRecord.ageUnit}" />
            </td>
        </tr>
        <tr>
            <th>联系电话</th>
            <td>${reportRecord.tel}</td>
            <th>手机号码</th>
            <td>${reportRecord.phoneNumber}</td>
        </tr>
        <tr>
            <th>患者工作单位</th>
            <td>${reportRecord.unitName}</td>
        </tr>
        <tr>
            <th>婚姻</th>
            <td>
                <ehr:dic dicmeta="GBT226122003" code="${reportRecord.marriage}" />
            </td>
            <th>民族</th>
            <td>
                <ehr:dic dicmeta="GBT3304" code="${reportRecord.nation}" />
            </td>
        </tr>
        <tr>
            <th>文化程度</th>
            <td>
                <ehr:dic dicmeta="GBT46582006" code="${reportRecord.education}" />
            </td>
            <th>职业</th>
            <td>
                <ehr:dic dicmeta="GBT6565" code="${reportRecord.occupation}" />
            </td>
        </tr>
        <tr>
            <th>门诊号</th>
            <td>${reportRecord.ehrNo}</td>
            <th>住院号</th>
            <td>${reportRecord.admissionNo}</td>
        </tr>
        <tr>
            <th>诊断代码</th>
            <td>${reportRecord.diagnosisCode}</td>
            <th>诊断机构</th>
            <td>
                <ehr:org code="${reportRecord.diagnosisOrganCode}" />
            </td>
        </tr>
        <tr>
            <th>报告单位</th>
            <td>
                <ehr:org code="${reportRecord.fillOrganCode}" />
            </td>
        </tr>
        <tr>
            <th>填卡医生编码</th>
            <td>${reportRecord.reportDoctorId}</td>
            <th>填卡医生</th>
            <td>${reportRecord.reportDoctorName}</td>
        </tr>
        <tr>
            <th>发病日期</th>
            <td>
                <fmt:formatDate value="${reportRecord.pathogenesisDate}" pattern="yyyy/MM/dd" />
            </td>
            <th>诊断日期</th>
            <td>
                <fmt:formatDate value="${reportRecord.diagnosisDate}" pattern="yyyy/MM/dd" />
            </td>
        </tr>
        <c:if test="${reportRecord.isDelete==-1}">
        <tr>
            <th>删除原因</th>
            <td>
            <c:if test="${reportRecord.deleteContent==99}">
                ${reportRecord.deleteContentOther}
            </c:if>
            <c:if test="${reportRecord.deleteContent!=99}">
                <ehr:dic dicmeta="IDM00379" code="${reportRecord.deleteContent}"/>
            </c:if>
            </td>
        </tr>
        </c:if>
        </tbody>
    </table>
</fieldset>

</div>
</div>


