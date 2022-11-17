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
        <li style="text-align: center; font-size: 25px;">1-8月龄儿童健康检查记录</li>
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
                <td>${childHealthExaminationOne.name}</td>
                <th>性别</th>
                <td><ehr:dic dicmeta="GBT226112003" code="${childHealthExaminationOne.gender}"/></td>
            </tr>
            <tr>
                <th>出生日期</th>
                <td><fmt:formatDate value="${childHealthExaminationOne.birthday}" pattern="yyyy/MM/dd"/></td>
                <th>儿童健康检查月龄</th>
                <%--儿童健康检查年龄段代码表--%>
                <td>${childHealthExaminationOne.cPhysicalExamAge}</td>
            </tr>
            <%--<tr>
                <th>儿童健康检查流水号</th>
                <td>${childHealthExaminationOne.etjkjclsh}</td>
                <th>健康档案编号</th>
                <td>${childHealthExaminationOne.jkdabh}</td>
            </tr>--%>
            <tr>

                <th>儿童信息编号</th>
                <td colspan="3">${childHealthExaminationOne.babyCardNo}</td>
            </tr>
            <tr>
                <th>随访日期</th>
                <td colspan="3"><fmt:formatDate value="${childHealthExaminationOne.visitDate}"
                                                pattern="yyyy/MM/dd"/></td>
                <%--<th>随访方式</th>
                <td>
                    &lt;%&ndash;随访方式代码表(行标-CV06.00.207)&ndash;%&gt;
                    <c:choose>
                        <c:when test="${childHealthExaminationOne.sffsDm eq '9'}">${childHealthExaminationOne.sffsqtxs}</c:when>
                        <c:otherwise>${childHealthExaminationOne.sffsMc}</c:otherwise>
                    </c:choose>
                </td>--%>
            </tr>
            <%--<tr>
                <th>父亲姓名</th>
                <td>${childHealthExaminationOne.fqxm}</td>
                <th>父亲身份证件号</th>
                <td>${childHealthExaminationOne.fqsfzhm}</td>
            </tr>
            <tr>
                <th>母亲姓名</th>
                <td>${childHealthExaminationOne.mqxm}</td>
                <th>母亲身份证件号</th>
                <td>${childHealthExaminationOne.mqsfzhm}</td>
            </tr>--%>

            <tr>
                <th>体重</th>
                <td>${childHealthExaminationOne.bodyWeight} kg</td>
                <th>体重评价</th>
                <%--上/中/下判断--%>
                <td><ehr:dic code="${childHealthExaminationOne.evaluationresultcode}" dicmeta="CV0510006"/></td>
            </tr>
            <tr>
                <th>身长</th>
                <td>${childHealthExaminationOne.stature} cm</td>
                <th>身长评价</th>
                <%--上/中/下判断--%>
                <td><ehr:dic code="${childHealthExaminationOne.heightEvaluationResult}" dicmeta="CV0510006"/></td>
            </tr>
            <tr>
                <th>头围</th>
                <td>${childHealthExaminationOne.headCircumference} cm</td>
                <th>面色情况</th>
                <td>
                    <%--面色情况代码表(行标-CV04.10.0O8)--%>
                    <c:choose>
                        <c:when test="${childHealthExaminationOne.childrenComplexionCode eq '9'}">${childHealthExaminationOne.complexionOther}</c:when>
                        <c:otherwise><ehr:dic code="${childHealthExaminationOne.childrenComplexionCode}"
                                              dicmeta="CV0410008"/></c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <th>皮肤情况</th>
                <td>
                    <%--皮肤情况代码表(行标-CV04.10.004)--%>
                    <c:choose>
                        <c:when test="${childHealthExaminationOne.skinInspectionAnomalySign eq '2'}">${childHealthExaminationOne.skinInspectionAnomalyDesc}</c:when>
                        <c:otherwise>未见异常</c:otherwise>
                    </c:choose>
                </td>
                <th>前囟是否闭合</th>
                <%--闭合/未闭判断--%>
                <td>
                    <ehr:dic code="${childHealthExaminationOne.afClosureFlag}" dicmeta="CV0410018"/>
                </td>
            </tr>
            <c:if test="${childHealthExaminationOne.afClosureFlag eq '11'}">
                <tr>
                    <th>前囟长</th>
                    <td>${childHealthExaminationOne.afTransverseDiameter} cm</td>
                    <th>前囟宽</th>
                    <td>${childHealthExaminationOne.bregmaDiameter} cm</td>
                </tr>
            </c:if>
            <tr>
                <c:if test="${'8月龄' ne childHealthExaminationOne.cPhysicalExamAge}">
                    <th>颈部包块</th>
                    <td>
                            <%--有/无判断--%>
                        <ehr:dic code="${childHealthExaminationOne.neckLumpSign}" dicmeta="PH00002"/>
                    </td>
                </c:if>
                <th>眼外观</th>
                <td>
                    <%--未见异常/异常判断--%>
                    <c:choose>
                        <c:when test="${childHealthExaminationOne.eyeappearanceSign eq '2'}">${childHealthExaminationOne.eyeAppearanceInspectionDesc}</c:when>
                        <c:otherwise>未见异常</c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <th>耳外观</th>
                <td>
                    <%--未见异常/异常判断--%>
                    <c:choose>
                        <c:when test="${childHealthExaminationOne.earappearanceSign eq '2'}">${childHealthExaminationOne.earappearanceDesc}</c:when>
                        <c:otherwise>未见异常</c:otherwise>
                    </c:choose>
                </td>
                <c:if test="${'6月龄' eq childHealthExaminationOne.cPhysicalExamAge}">
                    <th>听力</th>
                    <%--听力检测结果代码表--%>
                    <td><ehr:dic code="${childHealthExaminationOne.hearingScreeningResults}" dicmeta="MH00055"/></td>
                </c:if>
            </tr>
            <tr>
                <th>口腔情况</th>
                <td colspan="3">
                    <%--未见异常/异常判断--%>
                    <c:if test="${'满月' eq childHealthExaminationOne.cPhysicalExamAge or '3月龄' eq childHealthExaminationOne.cPhysicalExamAge}">
                        <c:choose>
                            <c:when test="${childHealthExaminationOne.oralExamination eq '2'}">${childHealthExaminationOne.oralExaminationDesc}</c:when>
                            <c:otherwise>未见异常</c:otherwise>
                        </c:choose>
                    </c:if>
                    <c:if test="${'6月龄' eq childHealthExaminationOne.cPhysicalExamAge or '8月龄' eq childHealthExaminationOne.cPhysicalExamAge}">
                        出牙数：${childHealthExaminationOne.teethNumber}颗
                    </c:if>
                </td>
            </tr>
            <%-- <tr>
                 <th>口腔龋齿颗数</th>
                 <td>${childHealthExaminationOne.kqqcks}</td>
             </tr>--%>
            <tr>
                <th>胸部情况</th>
                <td>
                    <%--未见异常/异常判断--%>
                    <c:choose>
                        <c:when test="${childHealthExaminationOne.heartLungAnomalySign eq '2'}">${childHealthExaminationOne.heartLungAnomalyDesc}</c:when>
                        <c:otherwise>未见异常</c:otherwise>
                    </c:choose>
                </td>
                <th>腹部情况</th>
                <td>
                    <%--未见异常/异常判断--%>
                    <c:choose>
                        <c:when test="${childHealthExaminationOne.abdominalPalp eq '2'}">${childHealthExaminationOne.abdominalPalpAnomalyDesc}</c:when>
                        <c:otherwise>未见异常</c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <c:if test="${'满月' eq childHealthExaminationOne.cPhysicalExamAge}">
                <tr>
                    <th>脐带情况</th>
                    <td colspan="3">
                            <%--脐带情况代码表(行标- CV04.10.019)--%>
                        <ehr:dic code="${childHealthExaminationOne.umbilicalCordCheck}" dicmeta="CV0410019"/>
                    </td>
                </tr>
            </c:if>
            <c:if test="${'3月龄' eq childHealthExaminationOne.cPhysicalExamAge}">
                <tr>
                    <th>脐带情况</th>
                    <td colspan="3">
                        <c:choose>
                            <c:when test="${childHealthExaminationOne.umbilicalCordCheck eq '2'}">${childHealthExaminationOne.umbilicalCordCheckDesc}</c:when>
                            <c:otherwise>未见异常</c:otherwise>
                        </c:choose>
                    </td>
                </tr>
            </c:if>
            <tr>
                <th>四肢异常情况</th>
                <td colspan="3">
                    <%--未见异常/异常判断--%>
                    <c:choose>
                        <c:when test="${childHealthExaminationOne.limbActivityAnomalySign eq '2'}">${childHealthExaminationOne.limbActivityDesc}</c:when>
                        <c:otherwise>未见异常</c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <c:if test="${'满月' ne childHealthExaminationOne.cPhysicalExamAge}">
                <tr>
                    <th>可疑佝偻病症状</th>
                    <td>
                            <%--可疑佝偻病症状代码表(行标- CV04.10.021)--%>
                        <ehr:dic code="${childHealthExaminationOne.suspiciousRicketsSymptoms}" dicmeta="CV0410021"/>
                    </td>
                    <th>可疑佝偻病体征</th>
                    <td>
                            <%--可疑佝偻病体征代码表(行标- CV04.10.022)--%>
                        <ehr:dic code="${childHealthExaminationOne.suspiciousRicketsSigns}" dicmeta="CV0410022"/>
                    </td>
                </tr>
            </c:if>
            <tr>
                <th>肛门/外生殖器情况</th>
                <td>
                    <%--未见异常/异常判断--%>
                    <c:choose>
                        <c:when test="${childHealthExaminationOne.analGenitaliaCheck eq '2'}">${childHealthExaminationOne.analGenitaliaAnomalyDesc}</c:when>
                        <c:otherwise>未见异常</c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <th>血红蛋白值</th>
                <td>${childHealthExaminationOne.hemoglobinValue} g/L</td>
                <th>户外活动</th>
                <td>${childHealthExaminationOne.outdoorDuration} h/d</td>
            </tr>
            <tr>
                <th>服用维生素D量</th>
                <td>${childHealthExaminationOne.takeVitaminD} IU/日</td>
                <th>服用维生素名称</th>
                <td>${childHealthExaminationOne.takeVitaminDName}</td>
            </tr>
            <c:if test="${'满月' ne childHealthExaminationOne.cPhysicalExamAge}">
                <tr>
                    <th>发育评估</th>
                        <%--发育评估代码表--%>
                    <td colspan="3"><ehr:dic code="${childHealthExaminationOne.childDevelopmentEvaluation}" dicmeta="CV0510110"/> </td>
                </tr>
            </c:if>
            <tr>
                <th>儿童两次随访间情况</th>
                <%--儿童患病情况代码表--%>
                <td colspan="3">
                    <c:choose>
                        <c:when test="${childHealthExaminationOne.followupSick eq '2'}">
                            肺炎：${childHealthExaminationOne.pneumoniaHospitalizations} 次
                            腹泻：${childHealthExaminationOne.diarrheaHospitalizations} 次
                            外伤：${childHealthExaminationOne.traumaHospitalizations} 次
                            其他：${childHealthExaminationOne.otherDiseaseState} 次
                        </c:when>
                        <c:otherwise>无</c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <th>转诊</th>
                <%--有/无判断--%>
                <td <c:if test='${childHealthExaminationOne.referralFlag ne "2"}'>colspan="3"</c:if>>
                    <ehr:dic code="${childHealthExaminationOne.referralFlag}" dicmeta="FS10187" />
                </td>
                <c:if test='${childHealthExaminationOne.referralFlag eq "2"}'>
                    <th>机构及科室</th>
                    <td>${childHealthExaminationOne.referralHospitalName} ${childHealthExaminationOne.referralDeptName}</td>
                </c:if>
            </tr>
            <c:if test='${childHealthExaminationOne.referralFlag eq "2"}'>
                <tr>
                    <%--<th>转诊建议</th>
                    <td >${childHealthExaminationOne.zzjy}</td>--%>
                    <th>转诊原因</th>
                    <td colspan="3">${childHealthExaminationOne.referralReason}</td>
                </tr>
            </c:if>
            <c:if test="${'6月龄' eq childHealthExaminationOne.cPhysicalExamAge}">
                <tr>
                    <th>中医药健康服务</th>
                    <td colspan="3">
                            <%--中医药健康服务类别代码--%>
                        <ehr:dic code="${childHealthExaminationOne.tcmHealthManageService}" dicmeta="FS10307"/>
                    </td>
                </tr>
            </c:if>
            <tr>
                <th>指导</th>
                <td colspan="3">
                    <%--儿童保健指导代码表--%>
                    <ehr:dic code="${childHealthExaminationOne.guidanceCategory}" dicmeta="CV0600310"/> ${childHealthExaminationOne.mgOpinion}
                </td>
            </tr>

           <%-- <tr>
                <th>其他辅助检查</th>
                <td colspan="3">${childHealthExaminationOne.qtfzjcms}</td>
            </tr>--%>


            <tr>
                <th>下次随访日期</th>
                <td><fmt:formatDate value="${childHealthExaminationOne.nextSupervisionDate}" pattern="yyyy/MM/dd"/></td>
                <th>随访医生</th>
                <td>
                    <ehr:staff-name staffCode="${childHealthExaminationOne.visitDoctorCode}"/>
                </td>
            </tr>
        </table>
    </div>
</div>