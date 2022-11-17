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
        <li style="text-align: center; font-size: 25px;">12-30月龄儿童健康检查记录</li>
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
                <td>${childHealthExaminationTwo.name}</td>
                <th>性别</th>
                <td><ehr:dic dicmeta="GBT226112003" code="${childHealthExaminationTwo.gender}"/></td>
            </tr>
            <tr>
                <th>出生日期</th>
                <td><fmt:formatDate value="${childHealthExaminationTwo.birthday}" pattern="yyyy/MM/dd"/></td>
                <th>儿童健康检查月龄</th>
                <%--儿童健康检查年龄段代码表--%>
                <td>${childHealthExaminationTwo.cPhysicalExamAge}</td>
            </tr>
            <%--<tr>
                <th>儿童健康检查流水号</th>
                <td>${childHealthExaminationTwo.etjkjclsh}</td>
                <th>健康档案编号</th>
                <td>${childHealthExaminationTwo.jkdabh}</td>
            </tr>--%>
            <tr>

                <th>儿童信息编号</th>
                <td colspan="3">${childHealthExaminationTwo.babyCardNo}</td>
            </tr>
            <tr>
                <th>随访日期</th>
                <td colspan="3"><fmt:formatDate value="${childHealthExaminationTwo.visitDate}"
                                                pattern="yyyy/MM/dd"/></td>
                <%--<th>随访方式</th>
                <td>
                    &lt;%&ndash;随访方式代码表(行标-CV06.00.207)&ndash;%&gt;
                    <c:choose>
                        <c:when test="${childHealthExaminationTwo.sffsDm eq '9'}">${childHealthExaminationTwo.sffsqtxs}</c:when>
                        <c:otherwise>${childHealthExaminationTwo.sffsMc}</c:otherwise>
                    </c:choose>
                </td>--%>
            </tr>
            <%--<tr>
                <th>父亲姓名</th>
                <td>${childHealthExaminationTwo.fqxm}</td>
                <th>父亲身份证件号</th>
                <td>${childHealthExaminationTwo.fqsfzhm}</td>
            </tr>
            <tr>
                <th>母亲姓名</th>
                <td>${childHealthExaminationTwo.mqxm}</td>
                <th>母亲身份证件号</th>
                <td>${childHealthExaminationTwo.mqsfzhm}</td>
            </tr>--%>

            <tr>
                <th>体重</th>
                <td>${childHealthExaminationTwo.bodyWeight} kg</td>
                <th>体重评价</th>
                <%--上/中/下判断--%>
                <td><ehr:dic code="${childHealthExaminationTwo.evaluationresultcode}" dicmeta="CV0510006"/></td>
            </tr>
            <tr>
                <th>身长</th>
                <td>${childHealthExaminationTwo.stature} cm</td>
                <th>身长评价</th>
                <%--上/中/下判断--%>
                <td><ehr:dic code="${childHealthExaminationTwo.heightEvaluationResult}" dicmeta="CV0510006"/></td>
            </tr>
            <tr>
                <th>面色情况</th>
                <td>
                    <%--面色情况代码表(行标-CV04.10.0O8)--%>
                    <c:choose>
                        <c:when test="${childHealthExaminationTwo.childrenComplexionCode eq '9'}">${childHealthExaminationTwo.complexionOther}</c:when>
                        <c:otherwise><ehr:dic code="${childHealthExaminationTwo.childrenComplexionCode}"
                                              dicmeta="CV0410008"/></c:otherwise>
                    </c:choose>
                </td>
                <th>皮肤情况</th>
                <td>
                    <%--皮肤情况代码表(行标-CV04.10.004)--%>
                    <c:choose>
                        <c:when test="${childHealthExaminationTwo.skinInspectionAnomalySign eq '2'}">${childHealthExaminationTwo.skinInspectionAnomalyDesc}</c:when>
                        <c:otherwise>未见异常</c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <c:if test="${'30月龄' ne childHealthExaminationTwo.cPhysicalExamAge}">
                <tr>
                    <th>前囟是否闭合</th>
                        <%--闭合/未闭判断--%>
                    <td>
                        <ehr:dic code="${childHealthExaminationTwo.afClosureFlag}" dicmeta="CV0410018"/>
                    </td>
                </tr>
                <c:if test="${childHealthExaminationTwo.afClosureFlag eq '11'}">
                    <tr>
                        <th>前囟长</th>
                        <td>${childHealthExaminationTwo.afTransverseDiameter} cm</td>
                        <th>前囟宽</th>
                        <td>${childHealthExaminationTwo.bregmaDiameter} cm</td>
                    </tr>
                </c:if>
            </c:if>
            <tr>
                <th>眼外观</th>
                <td>
                    <%--未见异常/异常判断--%>
                    <c:choose>
                        <c:when test="${childHealthExaminationTwo.eyeappearanceSign eq '2'}">${childHealthExaminationTwo.eyeAppearanceInspectionDesc}</c:when>
                        <c:otherwise>未见异常</c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <th>耳外观</th>
                <td>
                    <%--未见异常/异常判断--%>
                    <c:choose>
                        <c:when test="${childHealthExaminationTwo.earappearanceSign eq '2'}">${childHealthExaminationTwo.earappearanceDesc}</c:when>
                        <c:otherwise>未见异常</c:otherwise>
                    </c:choose>
                </td>
                <c:if test="${'12月龄' eq childHealthExaminationTwo.cPhysicalExamAge or '24月龄' eq childHealthExaminationTwo.cPhysicalExamAge}">
                    <th>听力</th>
                    <%--听力检测结果代码表--%>
                    <td><ehr:dic code="${childHealthExaminationTwo.hearingScreeningResults}" dicmeta="MH00055"/></td>
                </c:if>
            </tr>
            <tr>
                <th>口腔情况</th>
                <td colspan="3">
                    出牙/龋齿数（颗）：${childHealthExaminationTwo.teethNumber} / ${childHealthExaminationTwo.decayedToothNumber}
                </td>
            </tr>
            <tr>
                <th>胸部情况</th>
                <td>
                    <%--未见异常/异常判断--%>
                    <c:choose>
                        <c:when test="${childHealthExaminationTwo.heartLungAnomalySign eq '2'}">${childHealthExaminationTwo.heartLungAnomalyDesc}</c:when>
                        <c:otherwise>未见异常</c:otherwise>
                    </c:choose>
                </td>
                <th>腹部情况</th>
                <td>
                    <%--未见异常/异常判断--%>
                    <c:choose>
                        <c:when test="${childHealthExaminationTwo.abdominalPalp eq '2'}">${childHealthExaminationTwo.abdominalPalpAnomalyDesc}</c:when>
                        <c:otherwise>未见异常</c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <th>四肢情况</th>
                <td colspan="3">
                    <%--未见异常/异常判断--%>
                    <c:choose>
                        <c:when test="${childHealthExaminationTwo.limbActivityAnomalySign eq '2'}">${childHealthExaminationTwo.limbActivityDesc}</c:when>
                        <c:otherwise>未见异常</c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <c:if test="${'12月龄' ne childHealthExaminationTwo.cPhysicalExamAge}">
                <th>左脚步态</th>
                <td>
                    <c:choose>
                        <c:when test="${childHealthExaminationTwo.leftAbnormalGait eq '2'}">${childHealthExaminationTwo.leftAbnormalGaitDesc}</c:when>
                        <c:otherwise>未见异常</c:otherwise>
                    </c:choose>
                </td>
                <th>右脚步态</th>
                <td>
                    <c:choose>
                        <c:when test="${childHealthExaminationTwo.rightAbnormalGait eq '2'}">${childHealthExaminationTwo.rightAbnormalGaitDesc}</c:when>
                        <c:otherwise>未见异常</c:otherwise>
                    </c:choose>
                </td>
            </c:if>
            <c:if test="${'30月龄' ne childHealthExaminationTwo.cPhysicalExamAge}">
                <tr>
                    <th>可疑佝偻病体征</th>
                    <td colspan="3">
                            <%--可疑佝偻病体征代码表(行标- CV04.10.022)--%>
                        <ehr:dic code="${childHealthExaminationTwo.suspiciousRicketsSigns}" dicmeta="CV0410022"/>
                    </td>
                </tr>
            </c:if>
            <c:if test="${'18月龄' eq childHealthExaminationTwo.cPhysicalExamAge or '30月龄' eq childHealthExaminationTwo.cPhysicalExamAge}">
                <th>血红蛋白值</th>
                <td colspan="3">${childHealthExaminationTwo.hemoglobinValue} g/L</td>
            </c:if>
            <tr>
                <th>户外活动</th>
                <td colspan="3">${childHealthExaminationTwo.outdoorDuration} h/d</td>
            </tr>
            <c:if test="${'30月龄' ne childHealthExaminationTwo.cPhysicalExamAge}">
                <tr>
                    <th>服用维生素D量</th>
                    <td>${childHealthExaminationTwo.takeVitaminD} IU/日</td>
                    <th>服用维生素名称</th>
                    <td>${childHealthExaminationTwo.takeVitaminDName}</td>
                </tr>
            </c:if>
            <tr>
                <th>发育评估</th>
                <%--发育评估代码表--%>
                <td colspan="3"><ehr:dic code="${childHealthExaminationTwo.childDevelopmentEvaluation}"
                                         dicmeta="CV0510110"/></td>
            </tr>
            <tr>
                <th>儿童两次随访间情况</th>
                <%--儿童患病情况代码表--%>
                <td colspan="3">
                    <c:choose>
                        <c:when test="${childHealthExaminationTwo.followupSick eq '2'}">
                            肺炎：${childHealthExaminationTwo.pneumoniaHospitalizations} 次
                            腹泻：${childHealthExaminationTwo.diarrheaHospitalizations} 次
                            外伤：${childHealthExaminationTwo.traumaHospitalizations} 次
                            其他：${childHealthExaminationTwo.otherDiseaseState} 次
                        </c:when>
                        <c:otherwise>无</c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <th>转诊</th>
                <%--有/无判断--%>
                <td <c:if test='${childHealthExaminationTwo.referralFlag ne "2"}'>colspan="3"</c:if>>
                    <ehr:dic code="${childHealthExaminationTwo.referralFlag}" dicmeta="FS10187" />
                </td>
                <c:if test='${childHealthExaminationTwo.referralFlag eq "2"}'>
                    <th>机构及科室</th>
                    <td>${childHealthExaminationTwo.referralHospitalName} ${childHealthExaminationTwo.referralDeptName}</td>
                </c:if>
            </tr>
            <c:if test='${childHealthExaminationTwo.referralFlag eq "2"}'>
                <tr>
                        <%--<th>转诊建议</th>
                        <td >${childHealthExaminationTwo.zzjy}</td>--%>
                    <th>转诊原因</th>
                    <td colspan="3">${childHealthExaminationTwo.referralReason}</td>
                </tr>
            </c:if>
            <tr>
                <th>中医药健康服务</th>
                <td colspan="3">
                    <%--中医药健康服务类别代码--%>
                    <ehr:dic code="${childHealthExaminationTwo.tcmHealthManageService}"
                             dicmeta="FS10307"/> ${childHealthExaminationTwo.tcmHealthOther}
                </td>
            </tr>
            <tr>
                <th>指导</th>
                <td colspan="3">
                    <%--儿童保健指导代码表--%>
                    <ehr:dic code="${childHealthExaminationTwo.guidanceCategory}"
                             dicmeta="CV0600310"/> ${childHealthExaminationTwo.mgOpinion}
                </td>
            </tr>
            <tr>
                <th>下次随访日期</th>
                <td><fmt:formatDate value="${childHealthExaminationTwo.nextSupervisionDate}" pattern="yyyy/MM/dd"/></td>
                <th>随访医生</th>
                <td>
                    <ehr:staff-name staffCode="${childHealthExaminationTwo.visitDoctorCode}"/>
                </td>
            </tr>
        </table>
    </div>
</div>