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
        <li style="text-align: center; font-size: 25px;">新生儿访视表</li>
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
                <td>${newBornInterview.neonatusName}</td>
                <th>性别</th>
                <td><ehr:dic code="${newBornInterview.neonatalGender}" dicmeta="GBT226112003"/></td>
            </tr>
            <tr>
                <th>出生日期</th>
                <td><fmt:formatDate value="${newBornInterview.neonatusBirthday}" pattern="yyyy/MM/dd"/></td>
                <th>身份证件号码</th>
                <td>${newBornInterview.neonatusIdcard}</td>
            </tr>
            <tr>
                <th>家庭住址</th>
                <td colspan="3">
                    <ehr:dic code="${newBornInterview.patownShip}" dicmeta="FS990001"/>
                    <ehr:dic code="${newBornInterview.pastreet}" dicmeta="FS990001"/>
                    ${newBornInterview.pahouseNumber}
                </td>
            </tr>
            <%--<tr>
                <th>新生儿访视流水号</th>
                <td>${newBornInterview.xsefslsh}</td>
                <th>健康档案编号</th>
                <td>${newBornInterview.jkdabh}</td>
            </tr>
            <tr>
                <th>新生儿登记编号</th>
                <td>${newBornInterview.xsedjbh}</td>
                <th>儿童信息编号</th>
                <td>${newBornInterview.etxxbh}</td>
            </tr>--%>
            <tr>
                <th>本次访视日期</th>
                <td><fmt:formatDate value="${newBornInterview.visitDate}" pattern="yyyy/MM/dd"/></td>
                <%--<th>随访方式</th>
                <td>
                    &lt;%&ndash;随访方式代码表(行标-CV06.00.207)&ndash;%&gt;
                    <c:choose>
                        <c:when test="${newBornInterview.sffsDm eq '9'}">${newBornInterview.sffsqtxs}</c:when>
                        <c:otherwise>${newBornInterview.sffsMc}</c:otherwise>
                    </c:choose>
                </td>--%>
            </tr>
            <tr>
                <th>父亲姓名</th>
                <td>${newBornInterview.fatherName}</td>
                <th>父亲职业</th>
                <td><ehr:dic code="${newBornInterview.fatherOccupation}" dicmeta="GBT6565"/></td>
            </tr>
            <tr>
                <th>父亲联系电话</th>
                <td>${newBornInterview.fatherPhone}</td>
                <th>父亲出生日期</th>
                <td><fmt:formatDate value="${newBornInterview.fatherBirthday}" pattern="yyyy/MM/dd"/></td>
            </tr>
            <%--<tr>
                <th>父亲身份证件号</th>
                <td colspan="3">${newBornInterview.fqsfzjh}</td>
            </tr>--%>
            <tr>
                <th>母亲姓名</th>
                <td>${newBornInterview.motherName}</td>
                <th>母亲职业</th>
                <td><ehr:dic code="${newBornInterview.motherOccupation}" dicmeta="GBT6565"/></td>
            </tr>
            <tr>
                <th>母亲联系电话</th>
                <td>${newBornInterview.matherPhone}</td>
                <th>母亲出生日期</th>
                <td><fmt:formatDate value="${newBornInterview.motherBirthday}" pattern="yyyy/MM/dd"/></td>
            </tr>
            <%--<tr>
                <th>母亲身份证件号</th>
                <td colspan="3">${newBornInterview.fqsfzjh2}</td>
            </tr>--%>
            <tr>
                <th>孕周</th>
                <td>${newBornInterview.gestationalWeek}</td>
                <th>母亲妊娠期患病情况</th>
                <td>
                    <%--母亲妊娠期患病情况代码表--%>
                    <ehr:dic code="${newBornInterview.complicationHistory}" dicmeta="T19911105"/>
                </td>
            </tr>
            <tr>
                <th>助产机构</th>
                <td>${newBornInterview.obstetricInstitutionsName}</td>
                <th>出生情况</th>
                <td>
                    <%--出生情况代码表--%>
                    <ehr:dic code="${newBornInterview.lastdeliveryCode}" dicmeta="CV0210003"/>
                </td>
            </tr>
            <tr>
                <th>有无新生儿窒息</th>
                <%--有/无判断--%>
                <td><ehr:dic code="${newBornInterview.asphyxiaSign}" dicmeta="FS10111"/></td>
                <c:if test="${newBornInterview.asphyxiaSign eq '2'}">
                    <th>Apgar评分</th>
                    <td>
                        <c:if test="${newBornInterview.apgarValue eq '01'}">1min：${newBornInterview.apgarValueOneMin}分</c:if>
                        <c:if test="${newBornInterview.apgarValue eq '02'}">5min：${newBornInterview.apgarValueFiveMin}分</c:if>
                        <c:if test="${newBornInterview.apgarValue eq '03'}">不详</c:if>
                    </td>
                </c:if>
            </tr>
            <%--<tr>
                <th>Apgar5分钟评分</th>
                <td>${newBornInterview.apgar5fzpf}</td>
                <th>Apgar10分钟评分</th>
                <td>${newBornInterview.apgar10fzpf}</td>
            </tr>--%>
            <tr>
                <th>有无畸形</th>
                <td>
                    <%--有/无判断--%>

                    <c:choose>
                        <c:when test="${newBornInterview.deformitySign eq '2'}">${newBornInterview.deformityDesc}</c:when>
                        <c:otherwise>${newBornInterview.deformitySign}</c:otherwise>
                    </c:choose>
                </td>
                <th>新生儿听力筛查</th>
                <%--新生儿听力筛查代码表--%>
                <td><ehr:dic code="${newBornInterview.hearingScreeningState}" dicmeta="FS10025"/></td>
            </tr>
            <tr>
                <th>新生儿疾病筛查</th>
                <%--新生儿疾病筛查项目代码表(行标-CV04.50.008)--%>
                <td colspan="3">
                    <ehr:dic code="${newBornInterview.diseaseScreeningProject}"
                             dicmeta="CV0450008"/> ${newBornInterview.diseaseScreeningDesc}
                </td>
            </tr>
            <%--<tr>
                <th>新生儿疾病筛查结果</th>
                <td colspan="3">
                    &lt;%&ndash;新生儿疾病筛查结果代码表&ndash;%&gt;
                    <c:choose>
                        <c:when test="${newBornInterview.xsejbscjgDm eq '5'}">${newBornInterview.xsejbscjgxs}</c:when>
                        <c:otherwise>${newBornInterview.xsejbscjgMc}</c:otherwise>
                    </c:choose>
                </td>
            </tr>--%>
            <tr>
                <th>出生身高</th>
                <td>${newBornInterview.birthStature} cm</td>
                <th>出生体重</th>
                <td>${newBornInterview.birthWeight} kg</td>
            </tr>
            <tr>
                <%--<th>目前身高</th>
                <td>${newBornInterview.mqsg} cm</td>--%>
                <th>目前体重</th>
                <td>${newBornInterview.bodyWeight} kg</td>
            </tr>
            <tr>
                <th>喂养方式</th>
                <%--喂养方式代码表--%>
                <td><ehr:dic code="${newBornInterview.feedingType}" dicmeta="FS10026"/></td>
                <th>吃奶量</th>
                <td>${newBornInterview.eatMilkSupply} ml/次</td>
            </tr>
            <tr>
                <th>吃奶次数</th>
                <td>${newBornInterview.eatMilkNumber} 次/日</td>
                <th>有无呕吐情况</th>
                <%--有/无判断--%>
                <td><ehr:dic code="${newBornInterview.vomitingMark}" dicmeta="FS10111"/></td>
            </tr>
            <tr>
                <th>大便形状</th>
                <td>
                    <ehr:dic code="${newBornInterview.stoolProperty}" dicmeta="CV0401012"/>
                    <%--大便情况代码表(行标-CV04.01.012)--%>
                    <%-- <c:choose>
                         <c:when test="${newBornInterview.dbqkDm eq '9'}">${newBornInterview.dbqkqtms}</c:when>
                         <c:otherwise>${newBornInterview.dbqkMc}</c:otherwise>
                     </c:choose>--%>

                </td>
                <th>大便次数</th>
                <td>${newBornInterview.stoolNumber} 次/日</td>
            </tr>
            <tr>
                <th>体温</th>
                <td>${newBornInterview.temperature}℃</td>
                <th>心率</th>
                <td>${newBornInterview.pulseRate} 次/分钟</td>
            </tr>
            <tr>
                <th>呼吸频率</th>
                <td>${newBornInterview.respiratoryRate} 次/分钟</td>
                <th>面色情况</th>
                <td>
                    <%--面色情况代码表(行标-CV04.10.0O8)--%>
                    <c:choose>
                        <c:when test="${newBornInterview.complexionCode eq '9'}">${newBornInterview.complexionCodesDesc}</c:when>
                        <c:otherwise><ehr:dic code="${newBornInterview.complexionCode}" dicmeta="CV0410008"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <th>黄疸部位</th>
                <%--黄疸部位代码表(行标- CV04.10.009)--%>
                <td colspan="3"><ehr:dic code="${newBornInterview.jaundicePartsCode}" dicmeta="CV0410009"/></td>
            </tr>
            <tr>
                <th>前囟横径</th>
                <td>${newBornInterview.afTransverseDiameter} cm</td>
                <th>前囟纵径</th>
                <td>${newBornInterview.bregmaDiameter} cm</td>
            </tr>
            <tr>
                <th>前囟张力</th>
                <td colspan="3">
                    <%--前囟评价代码表(行标-CV04.10.018)--%>
                    <c:choose>
                        <c:when test="${newBornInterview.bregmaTension eq '9'}">${newBornInterview.bregmaTensionsDesc}</c:when>
                        <c:otherwise><ehr:dic code="${newBornInterview.bregmaTension}" dicmeta="CV0410018"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <th>眼外观</th>
                <td>
                    <%--未见异常/异常判断--%>
                    <c:choose>
                        <c:when test="${newBornInterview.eyeappearanceSign eq '1'}">${newBornInterview.eyeAppearanceInspectionDesc}</c:when>
                        <c:otherwise>未见异常</c:otherwise>
                    </c:choose>
                </td>
                <th>四肢活动度</th>
                <td>
                    <%--未见异常/异常判断--%>
                    <c:choose>
                        <c:when test="${newBornInterview.limbActivityAnomalySign eq '1'}">${newBornInterview.limbActivityDesc}</c:when>
                        <c:otherwise>未见异常</c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <th>耳外观</th>
                <td>
                    <%--未见异常/异常判断--%>
                    <c:choose>
                        <c:when test="${newBornInterview.earAppearanceInspection eq '1'}">${newBornInterview.earAppearanceInspectionDesc}</c:when>
                        <c:otherwise>未见异常</c:otherwise>
                    </c:choose>
                </td>
                <th>颈部包块</th>
                <td>
                    <%--有/无判断--%>
                    <c:choose>
                        <c:when test="${newBornInterview.neckLumpSign eq '2'}">${newBornInterview.neckLumpDesc}</c:when>
                        <c:otherwise>无</c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <th>鼻部情况</th>
                <td>
                    <%--未见异常/异常判断--%>
                    <c:choose>
                        <c:when test="${newBornInterview.nasalCheckAnomaly eq '1'}">${newBornInterview.nasalCheckAnomalyDesc}</c:when>
                        <c:otherwise>未见异常</c:otherwise>
                    </c:choose>
                </td>
                <th>口腔情况</th>
                <td>
                    <%--未见异常/异常判断--%>
                    <c:choose>
                        <c:when test="${newBornInterview.oralExaminationAnomaly eq '1'}">${newBornInterview.oralExaminationAnomalyDesc}</c:when>
                        <c:otherwise>未见异常</c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <th>皮肤情况</th>
                <td colspan="3">
                    <%--皮肤情况代码表(行标-CV04.10.004)--%>
                    <c:choose>
                        <c:when test="${newBornInterview.skinVisionInspection eq '99'}">${newBornInterview.skinVisionInspectionDesc}</c:when>
                        <c:otherwise>
                            <ehr:dic code="${newBornInterview.skinVisionInspection}" dicmeta="CV0410004"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <th>肛门情况</th>
                <td>
                    <%--未见异常/异常判断--%>
                    <c:choose>
                        <c:when test="${newBornInterview.analExaminationAnomaly eq '1'}">${newBornInterview.analExaminationAnomalyDesc}</c:when>
                        <c:otherwise>未见异常</c:otherwise>
                    </c:choose>
                </td>
                <th>心肺听诊情况</th>
                <td>
                    <%--未见异常/异常判断--%>
                    <c:choose>
                        <c:when test="${newBornInterview.cardiacAuscuAnomaly eq '1'}">${newBornInterview.cardiacAuscuAnomalyDesc}</c:when>
                        <c:otherwise>未见异常</c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <th>胸部情况</th>
                <td>
                    <%--未见异常/异常判断--%>
                    <c:choose>
                        <c:when test="${newBornInterview.abnormalChestAnomaly eq '1'}">${newBornInterview.abnormalChestAnomalyDesc}</c:when>
                        <c:otherwise>未见异常</c:otherwise>
                    </c:choose>
                </td>
                <th>腹部情况</th>
                <td>
                    <%--未见异常/异常判断--%>
                    <c:choose>
                        <c:when test="${newBornInterview.abdominalPalpAnomaly eq '1'}">${newBornInterview.abdominalPalpAnomalyDesc}</c:when>
                        <c:otherwise>未见异常</c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <th>脊柱情况</th>
                <td>
                    <%--未见异常/异常判断--%>
                    <c:choose>
                        <c:when test="${newBornInterview.spinalCheckAnomaly eq '1'}">${newBornInterview.spinalCheckAnomalyDesc}</c:when>
                        <c:otherwise>未见异常</c:otherwise>
                    </c:choose>
                </td>
                <th>外生殖器情况</th>
                <td>
                    <%--未见异常/异常判断--%>
                    <c:choose>
                        <c:when test="${newBornInterview.extGenitalCheckAnomaly eq '1'}">${newBornInterview.extGenitalCheckAnomalyDesc}</c:when>
                        <c:otherwise>未见异常</c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <th>脐带情况</th>
                <td colspan="3">
                    <%--脐带情况代码表(行标- CV04.10.019)--%>
                    <c:if test="${newBornInterview.umbilicalCordCheck eq '1'}">未脱</c:if>
                    <c:if test="${newBornInterview.umbilicalCordCheck eq '2'}">脱落</c:if>
                    <c:if test="${newBornInterview.umbilicalCordCheck eq '3'}">脐部有渗出</c:if>
                    <c:if test="${newBornInterview.umbilicalCordCheck eq '4'}">
                        ${newBornInterview.umbilicalCordCheckDesc}
                    </c:if>
                </td>
            </tr>
            <%--<tr>
                <th>体弱儿</th>
                &lt;%&ndash;是/否判断&ndash;%&gt;
                <td colspan="3">${newBornInterview.sftreMc}</td>
            </tr>--%>
            <%--<c:if test='${newBornInterview.sftreDm eq "2"}'>
                <tr>
                    <th>体弱儿管理</th>
                    <td colspan="3">
                            ${newBornInterview.treglxs}
                    </td>
                </tr>
            </c:if>--%>
            <tr>
                <th>转诊</th>
                <%--有/无判断--%>
                <td <c:if test='${newBornInterview.referralFlag ne "2"}'>colspan="3"</c:if>>
                    <ehr:dic code="${newBornInterview.referralFlag}" dicmeta="FS10187"/>
                </td>
                <c:if test='${newBornInterview.referralFlag eq "2"}'>
                    <th>机构及科室</th>
                    <td>${newBornInterview.referralHospitalName} ${newBornInterview.referralDeptName}</td>
                </c:if>
            </tr>
            <c:if test='${newBornInterview.referralFlag eq "2"}'>
                <tr>
                    <th>转诊原因</th>
                    <td colspan="3">
                        <c:out value="${newBornInterview.referralReason}"></c:out>
                    </td>
                </tr>
            </c:if>
            <tr>
                <th>新生儿访视健康指导</th>
                <%--新生儿保健指导代码表--%>
                <td colspan="3">
                    <ehr:dic code="${newBornInterview.healthGuidanceCategory}" dicmeta="CV0600217"/>
                </td>
            </tr>
            <%--其他保健指导和新生儿保健指导是否有关--%>
            <%--<tr>
                <th>其他保健指导</th>
                <td colspan="3">${newBornInterview.qtbjzdMc} ${newBornInterview.qtbjzdxs}</td>
            </tr>--%>
            <tr>
                <th>下次随访日期</th>
                <td><fmt:formatDate value="${newBornInterview.nextSupervisionDate}" pattern="yyyy/MM/dd"/></td>
                <th>下次随访地点</th>
                <td>${newBornInterview.nextSupervisionPlace}</td>
            </tr>
            <tr>
                <th>随访医生</th>
                <td colspan="3">
                    <ehr:staff-name staffCode="${newBornInterview.supervisionDoctorCode}"/>
                </td>
            </tr>
        </table>
    </div>
</div>