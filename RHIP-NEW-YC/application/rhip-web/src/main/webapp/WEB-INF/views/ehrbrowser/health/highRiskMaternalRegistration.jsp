<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/views/ehrbrowser/basic/basic.css" />

<div style="background-color: white; height: 515px;">
    <br/>
    <ul>
        <li style="text-align: center; font-size: 25px;">高危产妇登记</li>
    </ul>
    <div class="table-basic" style="overflow: inherit">
        <table class="layui-table x-admin-sm-table-list-small">
            <colgroup>
                <col style="width: 17%;"/>
                <col style="width: 33%;"/>
                <col style="width: 17%;"/>
                <col style="width: 33%;"/>
            </colgroup>
            <tr>
                <th width="15%">姓名</th>
                <td><c:out value="${whYcfbjGwdj.name}"></c:out></td>
                <th width="15%">出生日期</th>
                <td><fmt:formatDate value="${whYcfbjGwdj.birthday}" pattern="yyyy/MM/dd" /></td>
            </tr>
            <tr>
                <th width="15%">年龄</th>
                <td>${whYcfbjGwdj.age}岁</td>
                <th width="15%">孕产妇编号</th>
                <td><c:out value="${whYcfbjGwdj.recordNumber}"></c:out></td>
            </tr>
            <tr>
                <th width="15%">身份证件类别名称</th>
                <td><c:out value="${whYcfbjGwdj.idcardTypeName}"></c:out></td>
                <th width="15%">健康档案编号</th>
                <td><c:out value="${whYcfbjGwdj.healthFileNo}"></c:out></td>
            </tr>
            <tr>
                <th width="15%">身份证件号</th>
                <td><c:out value="${whYcfbjGwdj.idcard}"></c:out></td>
                <th width="15%">联系电话</th>
                <td><c:out value="${whYcfbjGwdj.phone}"></c:out></td>
            </tr>
            <tr>
                <th width="15%">职业</th>
                <td><c:out value="${whYcfbjGwdj.occupation}"></c:out></td>
                <th width="15%">孕次</th>
                <td><c:out value="${whYcfbjGwdj.gravidityTimes}"></c:out></td>
            </tr>
            <tr>
                <th width="15%">产次</th>
                <td><c:out value="${whYcfbjGwdj.productionTimes}"></c:out></td>
                <th width="15%">末次月经日期</th>
                <td><fmt:formatDate value="${whYcfbjGwdj.lastMenstrualDate}" pattern="yyyy/MM/dd" /></td>
            </tr>
            <tr>
                <th>户口地址</th>
                <td colspan="3">${whYcfbjGwdj.hrAddress}</td>
            </tr>
            <tr>
                <th>居住地址</th>
                <td colspan="3">${whYcfbjGwdj.paAddress}</td>
            </tr>
            <tr>
                <th width="15%">丈夫姓名</th>
                <td><c:out value="${whYcfbjGwdj.husbandName}"></c:out></td>
                <th width="15%">丈夫电话</th>
                <td><c:out value="${whYcfbjGwdj.husbandPhone}"></c:out></td>
            </tr>
            <tr>
                <th width="15%">预产期</th>
                <td><fmt:formatDate value="${whYcfbjGwdj.estimatedDueDates}" pattern="yyyy/MM/dd" /></td>
                <th width="15%">发现日期</th>
                <td><fmt:formatDate value="${whYcfbjGwdj.discoveryDate}" pattern="yyyy/MM/dd HH:mm" /></td>
            </tr>
            <tr>
                <th width="15%">当前孕周</th>
                <td><c:out value="${whYcfbjGwdj.gestationalWeeks}"></c:out>周</td>
                <th width="15%">孕产期高危因素名称</th>
                <td><c:out value="${whYcfbjGwdj.riskFactorName}"></c:out></td>
            </tr>
            <tr>
                <th width="15%">高危评定代码名称</th>
                <td><c:out value="${whYcfbjGwdj.riskLevelName}"></c:out></td>
                <th width="15%">高危评分</th>
                <td><c:out value="${whYcfbjGwdj.riskScoreValue}"></c:out>分</td>
            </tr>
            <tr>
                <th width="15%">住院时间</th>
                <td><fmt:formatDate value="${whYcfbjGwdj.inHospitalDt}" pattern="yyyy/MM/dd" /></td>
                <th width="15%">出院时间</th>
                <td><fmt:formatDate value="${whYcfbjGwdj.outHospitalDt}" pattern="yyyy/MM/dd" /></td>
            </tr>
            <tr>
                <th width="15%">治疗结果名称</th>
                <td><c:out value="${whYcfbjGwdj.treatmentResultsName}"></c:out></td>
                <th width="15%">分娩方式</th>
                <td><c:out value="${whYcfbjGwdj.deliveryWay}"></c:out></td>
            </tr>
            <tr>
                <th>分娩地点</th>
                <td colspan="3">${whYcfbjGwdj.deliveryPlace}</td>
            </tr>
            <%--是否转诊 1，否  2，是--%>
            <tr>
                <%--是/否判断--%>
                <th>是否转诊</th>
                <c:if test='${whYcfbjGwdj.referralFlag ne "2"}'>
                    <td colspan="3">否</td>
                </c:if>
                <c:if test='${whYcfbjGwdj.referralFlag eq "2"}'>
                    <td colspan="3">是</td>
                </c:if>
            </tr>
            <tr>
                <c:if test='${whYcfbjGwdj.referralFlag eq "2"}'>
                    <th>转诊原因</th>
                    <td colspan="3">${whYcfbjGwdj.referralReason}</td>
                </c:if>
            </tr>
            <c:if test='${whYcfbjGwdj.referralFlag eq "2"}'>
                <tr>
                    <th>转诊机构名称</th>
                    <td colspan="3">${whYcfbjGwdj.referralHospitalName}</td>
                </tr>
                <tr>
                    <th>转诊机构科室名称</th>
                    <td colspan="3">${whYcfbjGwdj.referralDeptName}</td>
                </tr>
            </c:if>
            <tr>
                <th width="15%">报告人姓名</th>
                <td><c:out value="${whYcfbjGwdj.reporter}"></c:out></td>
                <th width="15%">报告日期</th>
                <td><fmt:formatDate value="${whYcfbjGwdj.reportDate}" pattern="yyyy/MM/dd" /></td>
            </tr>
            <tr>
                <th>报告单位名称</th>
                <td colspan="3">${whYcfbjGwdj.reporterHospitalName}</td>
            </tr>
            <tr>
                <th width="15%">建档机构名称</th>
                <td colspan="3"><c:out value="${whYcfbjGwdj.inputOrgName}"></c:out></td>
            </tr>
            <tr>
                <th width="15%">建档人姓名</th>
                <td><c:out value="${whYcfbjGwdj.inputDoctorName}"></c:out></td>
                <th width="15%">建档人联系电话</th>
                <td><c:out value="${whYcfbjGwdj.inputDoctorPhone}"></c:out></td>
            </tr>
            <tr>
                <th>管档机构名称</th>
                <td colspan="3">${whYcfbjGwdj.manageOrgName}</td>
            </tr>
            <tr>
                <th width="15%">建档日期</th>
                <td><fmt:formatDate value="${whYcfbjGwdj.inputDate}" pattern="yyyy/MM/dd" /></td>
                <th width="15%">最后修改时间</th>
                <td><fmt:formatDate value="${whYcfbjGwdj.lastModifyTime}" pattern="yyyy/MM/dd" /></td>
            </tr>
<%--            <tr>
                <th width="15%">最后修改人员代码</th>
                <td><c:out value="${whYcfbjGwdj.zhxgrydm}"></c:out></td>
                <th width="15%">最后修改机构代码</th>
                <td><c:out value="${whYcfbjGwdj.zhxgjgDm}"></c:out></td>
            </tr>--%>
            <tr>
                <th>最后修改人员姓名</th>
                <td colspan="3">${whYcfbjGwdj.lastModifyDoctorName}</td>
            </tr>
            <tr>
                <th>最后修改机构名称</th>
                <td colspan="3">${whYcfbjGwdj.lastModifyOrgName}</td>
            </tr>
            <tr>
<%--                <th width="15%">就诊机构代码</th>
                <td><c:out value="${whYcfbjGwdj.clinicOrganCode}"></c:out></td>--%>
                <th width="15%">系统上传时间</th>
                <td colspan="3"><fmt:formatDate value="${whYcfbjGwdj.uploadTime}" pattern="yyyy/MM/dd" /></td>
            </tr>
            <tr>
                <th>就诊机构名称</th>
                <td colspan="3">${whYcfbjGwdj.clinicOrganName}</td>
            </tr>
        </table>
    </div>
</div>