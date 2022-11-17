<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<script src="${pageContext.request.contextPath}/js/views/idm/report/print.js" type="text/javascript"></script>

<div id="printPage" class="postcontentprint">
    <i class="popno">
        中华人民共和国传染病报告卡
    </i>

    <div class="postdiv">
        <table class="printposttable">
            <tbody>
            <tr>
                <td style="width: 50%; text-align: left;">
                    卡片编号：<input type="text" value="${reportDto.report.recordNumber}" style="width: 200px;"/>
                </td>
                <td style="width: 50%; text-align: right;">
                    报卡类别：<%--<ehr:dic dicmeta="IDM00001" code="${reportDto.report.reportCardTypeCode}"/>--%>
                    <%--<c:if test="${reportDto.report.reportCardTypeCode==1}">--%>
                        <%--<img src="${pageContext.request.contextPath}/images/1a.png">初次报告&nbsp;&nbsp;&nbsp;&nbsp;<img src="${pageContext.request.contextPath}/images/2.png"/>订正报告--%>
                    <%--</c:if>--%>
                    <%--<c:if test="${reportDto.report.reportCardTypeCode==2}">--%>
                        <%--<img src="${pageContext.request.contextPath}/images/1.png"/>初次报告&nbsp;&nbsp;&nbsp;&nbsp;<img src="${pageContext.request.contextPath}/images/2a.png"/>订正报告--%>
                    <%--</c:if>--%>
                    <ehr:dic-checkbox  name="reportCardTypeCode" dicmeta="IDM00001" value="${reportDto.report.reportCardTypeCode}" onclick="return false"/>
                </td>
            </tr>
            </tbody>
        </table>
            <table class="printposttable" style="border: 1px solid black;">
                <tr>
                    <td>
                        姓名*：<input type="text" value="${reportDto.report.name}" style="width: 180px;"/>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        （患儿家长姓名：<input type="text" value="${reportDto.report.parentsName}" style="width: 180px;"/>）
                    </td>
                </tr>
                <tr>
                    <td style="padding-left: 0px;">

                        <c:choose>
                            <c:when test="${not empty reportDto.report.idcard}">
                                ${personInfo.healthFileNoHtml}
                            </c:when>
                            <c:otherwise>
                                <s class="idcard" style="width:90%;padding-left:0px;"><span class="text">身份证号：</span>
                                    <span>&nbsp;</span><span>&nbsp;</span><span>&nbsp;</span><span>&nbsp;</span><span>&nbsp;</span><span>&nbsp;</span>
                                    <span>&nbsp;</span><span>&nbsp;</span><span>&nbsp;</span><span>&nbsp;</span><span>&nbsp;</span><span>&nbsp;</span>
                                    <span>&nbsp;</span><span>&nbsp;</span><span>&nbsp;</span><span>&nbsp;</span><span>&nbsp;</span><span>&nbsp;</span>
                                </s>
                            </c:otherwise>
                        </c:choose>

                        ${reportDto.report.idcardHtml}
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        性别*：<ehr:dic-checkbox name="gender" dicmeta="GBT226112003" value="${reportDto.report.gender}"
                                              code="1,2" onclick="return false"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        出生日期*：<input type="text"
                                     value="<fmt:formatDate value="${reportDto.report.birthday}" pattern="yyyy/MM/dd"/>"
                                     style="width: 80px;"/>
                        （如出生日期不详，实足年龄：<input type="text" value="${reportDto.report.age}" style="width: 40px;"/>&nbsp;&nbsp;&nbsp;&nbsp;年龄单位：<ehr:dic-checkbox
                            name="ageUnit" dicmeta="IDM00003" value="${reportDto.report.ageUnit}" onclick="return false"/>）
                    </td>
                </tr>
                <tr>
                    <td>
                        工作单位：<input type="text" value="${reportDto.report.unitName}" style="width: 280px;"/>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        联系电话*：<input type="text" value="${reportDto.report.phoneNumber}" style="width: 140px;"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        病人属于*：<ehr:dic-checkbox name="infectedpersonBelong" dicmeta="CV0201104"
                                                value="${reportDto.report.infectedpersonBelong}" onclick="return false"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        现住址（详填）*：<input type="text" value="${reportDto.report.paAddress}" style="width: 430px;"/>（门牌号）
                    </td>
                </tr>
                <tr>
                    <td style="width: 80%;">
                        患者职业*：<ehr:dic-checkbox name="occupation" dicmeta="GBT6565" value="${reportDto.report.occupation}"
                                                code="CV020120201,CV020120202,CV020120203,CV020120204,CV020120205,CV020120206,CV020120207,CV020120208,CV020120209,CV020120210,CV020120211,CV020120212,CV020120213,CV020120214,CV020120215,CV020120216,CV020120299,CV020120217"
                                                onclick="return false"/>
                        &nbsp;&nbsp;&nbsp;&nbsp;${reportDto.report.occupationOther}
                    </td>
                </tr>
                <tr>
                    <td>
                        病例分类*(1)：<ehr:dic-checkbox name="caseCategory" dicmeta="CV0501002"
                                                   value="${reportDto.report.caseCategory}" onclick="return false"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        病例分类(2)：<ehr:dic-checkbox name="caseCategoryFlag" dicmeta="FS10062"
                                                  value="${reportDto.report.caseCategoryFlag}" onclick="return false"/>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        (乙型肝炎、血吸虫病填写)
                    </td>
                </tr>
                <tr>
                    <td>
                        发病日期*：<input type="text"
                                     value="<fmt:formatDate value="${reportDto.report.pathogenesisDate}" pattern="yyyy/MM/dd"/>"
                                     style="width: 180px;"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        诊断日期*：<input type="text"
                                     value="<fmt:formatDate value="${reportDto.report.diagnosisDate}" pattern="yyyy/MM/dd HH:mm:ss"/>"
                                     style="width: 180px;"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        死亡日期：<input type="text"
                                    value="<fmt:formatDate value="${reportDto.report.deathDate}" pattern="yyyy/MM/dd"/>"
                                    style="width: 187px;"/>
                    </td>
                </tr>
                </tbody>
            </table>
            <table class="printposttable" style="border: 1px solid black;">
                <tbody>
                <tr>
                    <td>甲类传染病：
                        <br/>
                        <ehr:dic-checkbox name="jia" dicmeta="CV0501017" value="${reportDto.report.infectiousCode}"
                                          code="101,102" onclick="return false"/>
                    </td>
                </tr>
                </tbody>
            </table>
            <table class="printposttable"  style="border: 1px solid black;">
                <tbody>
                <tr>
                    <td>乙类传染病：
                        <br/>
                        <ehr:dic-checkbox name="yi" dicmeta="CV0501017" value="${reportDto.report.infectiousCode}"
                                          code="201,202" onclick="return false"/>
                        病毒性肝炎（<ehr:dic-checkbox name="yi" dicmeta="CV0501017"
                                                value="${reportDto.report.infectiousCode}"
                                                code="2031,2032,2033,2034,2035" onclick="return false"/>）
                        <ehr:dic-checkbox name="yi" dicmeta="CV0501017" value="${reportDto.report.infectiousCode}"
                                          code="204,205,207,208,209,210,211" onclick="return false"/>
                        炭疽（<ehr:dic-checkbox name="yi" dicmeta="CV0501017"
                                             value="${reportDto.report.infectiousCode}" code="2121,2122,2123" onclick="return false"/>）
                        痢疾（<ehr:dic-checkbox name="yi" dicmeta="CV0501017"
                                             value="${reportDto.report.infectiousCode}" code="2131,3232" onclick="return false"/>）
                        结核病（<ehr:dic-checkbox name="yi" dicmeta="CV0501017"
                                              value="${reportDto.report.infectiousCode}"
                                              code="2141,2142,2143,2144" onclick="return false"/>）
                        伤寒（<ehr:dic-checkbox name="yi" dicmeta="CV0501017"
                                             value="${reportDto.report.infectiousCode}" code="2151,2152" onclick="return false"/>）
                        <ehr:dic-checkbox name="yi" dicmeta="CV0501017" value="${reportDto.report.infectiousCode}"
                                          code="216,217,218,219220,221,222" onclick="return false"/>
                        梅毒（<ehr:dic-checkbox name="yi" dicmeta="CV0501017"
                                             value="${reportDto.report.infectiousCode}"
                                             code="2231,2232,2233,2234,2235" onclick="return false"/>）
                        <ehr:dic-checkbox name="yi" dicmeta="CV0501017" value="${reportDto.report.infectiousCode}"
                                          code="224,225" onclick="return false"/>
                        疟疾（<ehr:dic-checkbox name="yi" dicmeta="CV0501017"
                                             value="${reportDto.report.infectiousCode}" code="2261,2262,2263" onclick="return false"/>）
                        <ehr:dic-checkbox name="yi" dicmeta="CV0501017" value="${reportDto.report.infectiousCode}"
                                          code="206" onclick="return false"/>
                    </td>
                </tr>
                </tbody>
            </table>
            <table class="printposttable"  style="border: 1px solid black;">
                <tbody>
                <tr>
                    <td>丙类传染病：
                        <br/>
                        <ehr:dic-checkbox name="yi" dicmeta="CV0501017" value="${reportDto.report.infectiousCode}"
                                          code="301,302,303,304,305,306,307,308,309,311,310" onclick="return false"/>
                    </td>
                </tr>
                </tbody>
            </table>
            <table class="printposttable"  style="border: 1px solid black;">
                <tbody>
                <tr>
                    <td>
                        其他法定管理以及重点监测传染病：
                        <br/>
                        <div style="height: 20px;">${reportDto.report.otherInfectiousName}</div>
                    </td>
                </tr>
                </tbody>
            </table>
            <table class="printposttable"  style="border: 1px solid black;">
                <colgroup>
                    <col style="min-width: 200px; width: 50%;"/>
                    <col style="min-width: 200px; width: 50%;"/>
                </colgroup>
                <tbody>
                <tr>
                    <td>
                        订正病名：<input type="text" value="${reportDto.report.amendName}" style="width: 180px;"/>
                    </td>
                    <td style="text-align: right;">
                        退卡原因：<input type="text" value="${reportDto.report.backCardCause}" style="width: 180px;"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        报告单位：<input type="text" value="${reportDto.report.fillOrganName}" style="width: 180px;"/>
                    </td>
                    <td style="text-align: right;">
                        联系电话：<input type="text" value="${reportDto.report.fillOrganPhone}" style="width: 180px;"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        报告医生：<%--<input type="text" value="${reportDto.report.reportDoctorName}" style="width: 180px;"/>--%>
                        <ehr:user userCode="${reportDto.report.reportDoctorId}"/>
                    </td>
                    <td style="text-align: right;">
                        填卡日期：<input type="text" value="<fmt:formatDate value="${reportDto.report.fillDate}" pattern="yyyy/MM/dd"/>" style="width: 180px;"/>
                    </td>
                </tr>
                </tbody>
            </table>
            <table class="printposttable"  style="border: 1px solid black; table-layout: fixed;">
                <tbody>
                <tr>
                    <td style="word-break: break-all; word-wrap:break-word;">
                        备注：
                        <br/>
                        <div style="height: 80px;">${reportDto.report.comments}</div>
                    </td>
                </tr>
                </tbody>
            </table>
    </div>
</div>
