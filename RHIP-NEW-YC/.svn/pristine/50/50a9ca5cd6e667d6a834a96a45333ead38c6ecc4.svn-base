<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr" %>
<link rel="stylesheet"
      href="${pageContext.request.contextPath}/css/views/ehrbrowser/basic/basic.css"/>

<div style="background-color: white; height: 515px;">
    <ul>
        <li style="text-align: center; font-size: 25px;">3-6岁儿童健康检查记录详细</li>
    </ul>
    <br/>
    <div class="table-basic">
        <table>
            <colgroup>
                <col style="width: 20%;"/>
                <col style="width: 30%;"/>
                <col style="width: 20%;"/>
                <col style="width: 30%;"/>
            </colgroup>
            <tr>
                <th>姓名</th>
                <td>${childHealthExaminationThree.name}</td>
                <th>性别</th>
                <td><ehr:dic dicmeta="GBT226112003" code="${childHealthExaminationThree.gender}"/></td>
            </tr>
            <tr>
                <th>出生日期</th>
                <td><fmt:formatDate value="${childHealthExaminationThree.birthday}" pattern="yyyy/MM/dd"/></td>
                <th>儿童健康检查年龄</th>
                <%--儿童健康检查年龄段代码表--%>
                <td>${childHealthExaminationThree.cPhysicalExamAge}</td>
            </tr>
            <%--<tr>
                <th>儿童健康检查流水号</th>
                <td>${childHealthExaminationThree.etjkjclsh}</td>
                <th>健康档案编号</th>
                <td>${childHealthExaminationThree.jkdabh}</td>
            </tr>--%>
            <tr>

                <th>儿童信息编号</th>
                <td colspan="3">${childHealthExaminationThree.babyCardNo}</td>
            </tr>
            <tr>
                <th>随访日期</th>
                <td colspan="3"><fmt:formatDate value="${childHealthExaminationThree.visitDate}"
                                                pattern="yyyy/MM/dd"/></td>
                <%--<th>随访方式</th>
                <td>
                    &lt;%&ndash;随访方式代码表(行标-CV06.00.207)&ndash;%&gt;
                    <c:choose>
                        <c:when test="${childHealthExaminationThree.sffsDm eq '9'}">${childHealthExaminationThree.sffsqtxs}</c:when>
                        <c:otherwise>${childHealthExaminationThree.sffsMc}</c:otherwise>
                    </c:choose>
                </td>--%>
            </tr>
            <%--<tr>
                <th>父亲姓名</th>
                <td>${childHealthExaminationThree.fqxm}</td>
                <th>父亲身份证件号</th>
                <td>${childHealthExaminationThree.fqsfzhm}</td>
            </tr>
            <tr>
                <th>母亲姓名</th>
                <td>${childHealthExaminationThree.mqxm}</td>
                <th>母亲身份证件号</th>
                <td>${childHealthExaminationThree.mqsfzhm}</td>
            </tr>--%>

            <tr>
                <th>体重</th>
                <td>${childHealthExaminationThree.bodyWeight} kg</td>
                <th>体重评价</th>
                <%--上/中/下判断--%>
                <td><ehr:dic code="${childHealthExaminationThree.evaluationresultcode}" dicmeta="CV0510006"/></td>
            </tr>
            <tr>
                <th>身高</th>
                <td>${childHealthExaminationThree.stature} cm</td>
                <th>身高评价</th>
                <%--上/中/下判断--%>
                <td><ehr:dic code="${childHealthExaminationThree.heightEvaluationResult}" dicmeta="CV0510006"/></td>
            </tr>
            <tr>
                <th>体重/身高</th>
                <td>${childHealthExaminationThree.bodyWeightStature}</td>
                <th>体重/身高</th>
                <%--上/中/下判断--%>
                <td><ehr:dic code="${childHealthExaminationThree.weightHeightResult}" dicmeta="CV0510006"/></td>
            </tr>
            <tr>
                <th>体格发育评价</th>
                <td colspan="3"><ehr:dic code="${childHealthExaminationThree.physiquegrowthCode}"
                                         dicmeta="CV0410020"/></td>
            </tr>
            <c:if test="${'3岁' ne childHealthExaminationThree.cPhysicalExamAge}">
                <tr>
                    <th>视力</th>
                    <td colspan="3">
                        左眼：${childHealthExaminationThree.lNakedEye}
                        右眼：${childHealthExaminationThree.rNakedeye}
                    </td>
                </tr>
            </c:if>
            <c:if test="${'3岁' eq childHealthExaminationThree.cPhysicalExamAge}">
                <tr>
                    <th>听力</th>
                    <td colspan="3">
                        <ehr:dic code="${childHealthExaminationThree.hearingScreeningResults}" dicmeta="MH00055"/>
                    </td>
                </tr>
            </c:if>
            <tr>
                <th>牙数(颗)/龋齿数</th>
                <td colspan="3">
                    ${childHealthExaminationThree.teethNumber}
                    / ${childHealthExaminationThree.decayedToothNumber}
                </td>
            </tr>
            <tr>
                <th>胸部情况</th>
                <td>
                    <%--未见异常/异常判断--%>
                    <c:choose>
                        <c:when test="${childHealthExaminationThree.heartLungAnomalySign eq '2'}">${childHealthExaminationThree.heartLungAnomalyDesc}</c:when>
                        <c:otherwise>未见异常</c:otherwise>
                    </c:choose>
                </td>
                <th>腹部情况</th>
                <td>
                    <%--未见异常/异常判断--%>
                    <c:choose>
                        <c:when test="${childHealthExaminationThree.abdominalPalp eq '2'}">${childHealthExaminationThree.abdominalPalpAnomalyDesc}</c:when>
                        <c:otherwise>未见异常</c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <th>血红蛋白值</th>
                <td colspan="3">${childHealthExaminationThree.hemoglobinValue} g/L</td>
            </tr>
            <tr>
                <th>其他</th>
                <td colspan="3">${childHealthExaminationThree.other}</td>
            </tr>
            <tr>
                <th>发育评估</th>
                <%--发育评估代码表--%>
                <td colspan="3"><ehr:dic code="${childHealthExaminationThree.childDevelopmentEvaluation}"
                                         dicmeta="CV0510110"/></td>
            </tr>
            <tr>
                <th>儿童两次随访间情况</th>
                <%--儿童患病情况代码表--%>
                <td colspan="3">
                    <c:choose>
                        <c:when test="${childHealthExaminationThree.followupSick eq '2'}">
                            肺炎：${childHealthExaminationThree.pneumoniaHospitalizations} 次
                            腹泻：${childHealthExaminationThree.diarrheaHospitalizations} 次
                            外伤：${childHealthExaminationThree.traumaHospitalizations} 次
                            其他：${childHealthExaminationThree.otherDiseaseState} 次
                        </c:when>
                        <c:otherwise>无</c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <th>转诊</th>
                <%--有/无判断--%>
                <td <c:if test='${childHealthExaminationThree.referralFlag ne "2"}'>colspan="3"</c:if>>
                    <ehr:dic code="${childHealthExaminationThree.referralFlag}" dicmeta="FS10187" />
                </td>
                <c:if test='${childHealthExaminationThree.referralFlag eq "2"}'>
                    <th>机构及科室</th>
                    <td>${childHealthExaminationThree.referralHospitalName} ${childHealthExaminationThree.referralDeptName}</td>
                </c:if>
            </tr>
            <c:if test='${childHealthExaminationThree.referralFlag eq "2"}'>
                <tr>
                        <%--<th>转诊建议</th>
                        <td >${childHealthExaminationThree.zzjy}</td>--%>
                    <th>转诊原因</th>
                    <td colspan="3">${childHealthExaminationThree.referralReason}</td>
                </tr>
            </c:if>
            <%-- <c:if test="${'3岁' eq childHealthExaminationThree.cPhysicalExamAge}">
                <tr>
                    <th>中医药健康服务</th>
                    <td colspan="3">
                            中医药健康服务类别代码
                        <ehr:dic code="${childHealthExaminationThree.tcmHealthManageService}"
                                 dicmeta="FS10307"/> ${childHealthExaminationThree.tcmHealthOther}
                    </td>
                </tr>
            </c:if> --%>
            <tr>
                <th>指导</th>
                <td colspan="3">
                    <%--儿童保健指导代码表--%>
                    <ehr:dic code="${childHealthExaminationThree.guidanceCategory}"
                             dicmeta="CV0600310"/> ${childHealthExaminationThree.mgOpinion}
                </td>
            </tr>
            <tr>
                <th>下次随访日期</th>
                <td><fmt:formatDate value="${childHealthExaminationThree.nextSupervisionDate}"
                                    pattern="yyyy/MM/dd"/></td>
                <th>随访医生</th>
                <td>
                    <ehr:staff-name staffCode="${childHealthExaminationThree.visitDoctorCode}"/>
                </td>
            </tr>
        </table>
    </div>
</div>