<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/views/ehrbrowser/basic/basic.css" />

<div style="background-color: white; height: 520px;float:right;">
    <br/>
    <ul>
        <li style="text-align: center; font-size: 25px;">高危产妇随访</li>
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
                <td><c:out value="${whYcfbjGwsf.name}"></c:out></td>
                <th width="15%">出生日期</th>
                <td><fmt:formatDate value="${whYcfbjGwsf.birthday}" pattern="yyyy/MM/dd" /></td>
            </tr>
            <tr>
                <th width="15%">健康档案编号</th>
                <td><c:out value="${whYcfbjGwsf.healthFileNo}"></c:out></td>
                <th width="15%">高危登记编号</th>
                <td><c:out value="${whYcfbjGwsf.recordNumber}"></c:out></td>
            </tr>
            <tr>
                <th>身份证件号</th>
                <td>${whYcfbjGwsf.idcard}</td>
                <th>年龄</th>
                <!--年龄单位代码表-->
                <td>${whYcfbjGwsf.age}${whYcfbjGwsf.ageUnitName}</td>
            </tr>
            <tr>
                <th>随访方式</th>
                <td colspan="3">
                    <c:choose>
                        <%--随访方式代码表(行标-CV06.00.207)--%>
                        <c:when test="${whYcfbjGwsf.followupWay eq '9'}">${whYcfbjGwsf.followupWayDesc}</c:when>
                        <c:otherwise>${whYcfbjGwsf.followupWayName}</c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <c:if test="${whYcfbjGwsf.followupWay eq '9'}">
                <tr>
                    <th>随访方式其他详述</th>
                    <td colspan="3">${whYcfbjGwsf.followupWayDesc}</td>
                </tr>
            </c:if>
            <tr>
                <th width="15%">高危随访日期</th>
                <td><fmt:formatDate value="${whYcfbjGwsf.followupDate}" pattern="yyyy/MM/dd" /></td>
                <th width="15%">当前孕周</th>
                <td><c:out value="${whYcfbjGwsf.deliveryWeek}"></c:out>周</td>
            </tr>
            <tr>
                <c:choose>
                    <c:when test="${whYcfbjGwsf.curSymptom eq '99'}">
                       <th>主要症状名称</th>
                        <td colspan="3">${whYcfbjGwsf.curSymptomName}</td>
                    </c:when>
                    <c:otherwise>
                        <th>
                            主要症状其他详述
                        </th>
                        <td colspan="3">
                                ${whYcfbjGwsf.curSymptomDesc}
                        </td>
                    </c:otherwise>
                </c:choose>
            </tr>
			<tr>
                <th>主要体征</th>
                <td colspan="3">${whYcfbjGwsf.signsDesc}</td>
            </tr>
            <tr>
                <th>辅助检查</th>
                <td colspan="3">${whYcfbjGwsf.aeResult}</td>
            </tr>
            <tr>
                <th>处理意见</th>
                <td colspan="3">${whYcfbjGwsf.dealAdvice}</td>
            </tr>
            <tr>
                <c:choose>
                    <c:when test="${whYcfbjGwsf.riskFactorCode eq '99'}">
                        <th>
                            孕产期其他高危因素
                        </th>
                        <td colspan="3">
                                ${whYcfbjGwsf.riskFactorDesc}
                        </td>
                    </c:when>
                    <c:otherwise>
                        <th>
                            孕产期高危因素名称
                        </th>
                        <td colspan="3">
                            ${whYcfbjGwsf.riskFactorName}
                        </td>
                    </c:otherwise>
                </c:choose>
            </tr>
            <tr>
                <th width="15%">高危评定名称</th>
                <td colspan="3"><c:out value="${whYcfbjGwsf.riskLevelName}"></c:out></td>
            </tr>
            <tr>
                <th width="15%">高危评分</th>
                <td><c:out value="${whYcfbjGwsf.riskScoreValue}"></c:out>分</td>
                <th width="15%">治疗结果名称</th>
                <td><c:out value="${whYcfbjGwsf.treatmentResultsName}"></c:out></td>
            </tr>

            <%--死亡判断SFPD1否,2是,9不详--%>
            <tr>
                <th>是否死亡</th>
                <c:choose>
                    <c:when test="${whYcfbjGwsf.deathMark eq '1'}">
                        <td colspan="3">${whYcfbjGwsf.deathMarkName}</td>
                    </c:when>
                    <c:when test="${whYcfbjGwsf.deathMark eq '2'}">
                        <td>${whYcfbjGwsf.deathMarkName}</td>
                        <th>死亡时间</th>
                        <td><fmt:formatDate value="${whYcfbjGwsf.deathTime}" pattern="yyyy/MM/dd HH:mm" /></td>
                    </c:when>
                    <c:otherwise>
                        <td colspan="3">${whYcfbjGwsf.deathMarkName}</td>
                    </c:otherwise>
                </c:choose>
            </tr>
            <tr>
                <c:if test="${whYcfbjGwsf.deathMark eq '2'}">
                    <th>死亡原因</th>
                    <td colspan="3">${whYcfbjGwsf.deathReason}</td>
                </c:if>
            </tr>
            <tr>
                <th width="15%">随访医生姓名</th>
                <td><c:out value="${whYcfbjGwsf.visitDoctorName}"></c:out></td>
                <th>下次随访日期</th>
                <td><fmt:formatDate value="${whYcfbjGwsf.nextVisitDate}" pattern="yyyy/MM/dd " /></td>
            </tr>
            <tr>
                <th width="15%">随访机构名称</th>
                <td colspan="3">${whYcfbjGwsf.visitOrgName}</td>
            </tr>
            <tr>
                <th>备注</th>
                <td colspan="3">${whYcfbjGwsf.remarks}</td>
            </tr>
            <tr>
                <th>登记时间(系统)</th>
                <td><fmt:formatDate value="${whYcfbjGwsf.regTime}" pattern="yyyy/MM/dd" /></td>
                <th>登记人员</th>
                <td>${whYcfbjGwsf.regDoctorName}</td>
            </tr>
            <tr>
                <th>登记机构名称</th>
                <td colspan="3">${whYcfbjGwsf.regHospitalName}</td>
            </tr>
            <tr>
                <th>就诊机构名称</th>
                <td colspan="3">${whYcfbjGwsf.clinicOrganName}</td>
            </tr>
        </table>
    </div>
</div>