<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>

<div class="postcontent" style="padding-top: 150px; font-size: 11px;">
    <div style="font-size: 20px;text-align: center;height: 35px;">
        <b>预约单</b>
    </div>
    <div>
        <table style="margin: 0 20px; width: 95%;">
            <tr>
                <td colspan="2">
                    <br/>
                    <div style="background-color: #F8F8F8; padding: 5px;">
                        <span style="color: #FC5907">友情提醒：</span>
                        <span>
                            请持此预约单于
                            <b><fmt:formatDate value="${reserveRegister.requestDate}" pattern="yyyy年MM月dd日"/>
                            <c:if test="${reserveRegister.ampm eq 'a'}">上午 </c:if>
							<c:if test="${reserveRegister.ampm eq 'p'}">下午 </c:if>
                            ${reserveRegister.takeNoTimeStart}~${reserveRegister.takeNoTimeEnd}到医院取号！</b>
                        </span>
                    </div>
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <div style="height: 10px;">&nbsp;</div>
                </td>
            </tr>
            <tr>
                <td style="width: 80px; vertical-align: top; color: #2B73AD;">
                    患者信息
                </td>
                <td>
                    <table>
                        <colgroup>
                            <col style="width: 160px;">
                            <col style="width: 35%;">
                            <col style="width: 160px;">
                            <col style="width: 35%;">
                        </colgroup>
                        <tr>
                            <th style="border-bottom: 1px solid #C5C5C5; border-right: 0; text-align: left;">
                                <img src="${pageContext.request.contextPath}/images/reserve/iconarrow.png"><b>身份证号：</b>
                            </th>
                            <td style="border-bottom: 1px solid #C5C5C5">${reserveRegister.idcard}</td>
                            <th style="border-bottom: 1px solid #C5C5C5; border-right: 0; text-align: left;">
                                <img src="${pageContext.request.contextPath}/images/reserve/iconarrow.png"><b>姓名：</b>
                            </th>
                            <td style="border-bottom: 1px solid #C5C5C5">${reserveRegister.name}</td>
                        </tr>
                        <tr>
                            <th style="border-bottom: 1px solid #C5C5C5; border-right: 0; text-align: left;">
                                <img src="${pageContext.request.contextPath}/images/reserve/iconarrow.png"><b>出生日期：</b>
                            </th>
                            <td style="border-bottom: 1px solid #C5C5C5">
                                <fmt:formatDate value="${reserveRegister.birthday}" pattern="yyyy年MM月dd日"/>
                            </td>
                            <th style="border-bottom: 1px solid #C5C5C5; border-right: 0; text-align: left;">
                                <img src="${pageContext.request.contextPath}/images/reserve/iconarrow.png"><b>性别：</b>
                            </th>
                            <td style="border-bottom: 1px solid #C5C5C5">
                                <ehr:dic code="${reserveRegister.gender}" dicmeta="GBT226112003"/>
                            </td>
                        </tr>
                    </table>
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <div style="height: 10px;">&nbsp;</div>
                </td>
            </tr>
            <tr>
                <td style="width: 80px; vertical-align: top; color: #2B73AD;">
                    号源信息
                </td>
                <td>
                    <table>
                        <colgroup>
                            <col style="width: 160px;">
                            <col style="width: 35%;">
                            <col style="width: 160px;">
                            <col style="width: 35%;">
                        </colgroup>
                        <tr>
                            <th style="border-bottom: 1px solid #C5C5C5; border-right: 0; text-align: left;">
                                <img src="${pageContext.request.contextPath}/images/reserve/iconarrow.png"><b>医院：</b>
                            </th>
                            <td style="border-bottom: 1px solid #C5C5C5">
                                ${reserveRegister.hospitalName}
                            </td>
                            <th style="border-bottom: 1px solid #C5C5C5; border-right: 0; text-align: left;">
                                <img src="${pageContext.request.contextPath}/images/reserve/iconarrow.png"><b>科室：</b>
                            </th>
                            <td style="border-bottom: 1px solid #C5C5C5">
                                ${reserveRegister.deptName}
                            </td>
                        </tr>
                        <tr>
                            <th style="border-bottom: 1px solid #C5C5C5; border-right: 0; text-align: left;">
                                <img src="${pageContext.request.contextPath}/images/reserve/iconarrow.png"><b>医生：</b>
                            </th>
                            <td style="border-bottom: 1px solid #C5C5C5">
                                ${reserveRegister.doctorName}
                            </td>
                            <th style="border-bottom: 1px solid #C5C5C5; border-right: 0; text-align: left;">
                                <img src="${pageContext.request.contextPath}/images/reserve/iconarrow.png"><b>号别：</b>
                            </th>
                            <td style="border-bottom: 1px solid #C5C5C5">
                                <c:if test="${reserveRegister.clinicType == '01'}">
                                    普通号
                                </c:if>
                                <c:if test="${reserveRegister.clinicType == '02'}">
                                    专家号
                                </c:if>
                            </td>
                        </tr>
                        <tr>
                            <th style="border-bottom: 1px solid #C5C5C5; border-right: 0; text-align: left;">
                                <img src="${pageContext.request.contextPath}/images/reserve/iconarrow.png"><b>挂号费用：</b>
                            </th>
                            <td style="border-bottom: 1px solid #C5C5C5">
                                ${reserveRegister.registerFee} 元
                            </td>
                            <th style="border-bottom: 1px solid #C5C5C5; border-right: 0; text-align: left;">
                                <img src="${pageContext.request.contextPath}/images/reserve/iconarrow.png"><b>预约日期：</b>
                            </th>
                            <td style="border-bottom: 1px solid #C5C5C5">
                                <fmt:formatDate value="${reserveRegister.requestDate }" pattern="yyyy年MM月dd日"/>
								<c:if test="${reserveRegister.ampm eq 'a'}">上午 </c:if>
								<c:if test="${reserveRegister.ampm eq 'p'}">下午 </c:if>
								${reserveRegister.timeIntervalStart}~${reserveRegister.timeIntervalEnd}
                            </td>
                        </tr>
                    </table>
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <div style="height: 10px;">&nbsp;</div>
                </td>
            </tr>
            <%--<tr>--%>
                <%--<td colspan="2">--%>
                    <%--<div style="border-top:1px solid black; margin-top: 10px; margin-bottom: 10px;"></div>--%>
                <%--</td>--%>
            <%--</tr>--%>
            <tr>
                <td style="width: 80px; color: #2B73AD;">
                    <div style="margin-bottom: 10px;">操作信息</div>
                </td>
                <td>
                    <table style="margin-bottom: 10px;">
                        <colgroup>
                            <col style="width: 160px;">
                            <col style="width: 35%;">
                            <col style="width: 160px;">
                            <col style="width: 35%;">
                        </colgroup>
                        <tr>
                            <th style="border-bottom: 1px solid #C5C5C5; border-right: 0; text-align: left;">
                                <img src="${pageContext.request.contextPath}/images/reserve/iconarrow.png"><b>预约者：</b>
                            </th>
                            <td style="border-bottom: 1px solid #C5C5C5">
                                ${reserveRegister.submitUserName}
                            </td>
                            <th style="border-bottom: 1px solid #C5C5C5; border-right: 0; text-align: left;">
                                <img src="${pageContext.request.contextPath}/images/reserve/iconarrow.png"><b>操作时间：</b>
                            </th>
                            <td style="border-bottom: 1px solid #C5C5C5">
                                <fmt:formatDate value="${reserveRegister.submitDate}" pattern="yyyy/MM/dd日 HH:mm"/>
                            </td>
                        </tr>
                    </table>
                </td>
            </tr>
        </table>
    </div>
</div>
