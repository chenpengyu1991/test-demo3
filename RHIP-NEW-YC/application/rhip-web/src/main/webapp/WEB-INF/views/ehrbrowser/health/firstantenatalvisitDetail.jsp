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
        <li style="text-align: center; font-size: 25px;">第1次产前随访</li>
    </ul>
    <br/>
    <div class="table-basic" style="overflow: inherit">
        <table class="layui-table x-admin-sm-table-list-small">
            <colgroup>
                <col style="width: 20%;"/>
                <col style="width: 30%;"/>
                <col style="width: 20%;"/>
                <col style="width: 30%;"/>
            </colgroup>
            <tr>
                <th>姓名</th>
                <td colspan="3">${whYcfbjDycsf.name}</td>
<%--                <th>出生日期</th>--%>
<%--                <td><fmt:formatDate value="${whYcfbjDycsf.birthday}" pattern="yyyy/MM/dd"/></td>--%>
            </tr>
            <tr>
                <th>健康档案编号</th>
                <td colspan="3">${whYcfbjDycsf.healthFileNo}</td>
<%--                <th>孕产妇编号</th>--%>
<%--                <td>${whYcfbjDycsf.recordNumber}</td>--%>
            </tr>
            <tr>
                <th>年龄</th>
                <td>${whYcfbjDycsf.age}</td>
                <th>身份证件号码</th>
                <td colspan="3">${whYcfbjDycsf.idCard}</td>
            </tr>

            <tr>
                <th>丈夫姓名</th>
                <td colspan="3">${whYcfbjDycsf.husbandName}</td>
<%--                <th>丈夫出生日期</th>--%>
<%--                <td>--%>
<%--                    <fmt:formatDate value="${whYcfbjDycsf.husbandBirthday}" pattern="yyyy/MM/dd"/>--%>
<%--                </td>--%>
            </tr>
            <%--			<tr>
                            <th>丈夫单位</th>
                            <td colspan="3">${whYcfbjDycsf.zfdw}</td>
                        </tr>--%>
            <tr>
                <th>丈夫联系电话</th>
                <td>${whYcfbjDycsf.husbandPhone}
                </td>
                <th>丈夫年龄</th>
                <td>${whYcfbjDycsf.husbandAge}</td>
            </tr>
            <tr>
                <th>当前孕周</th>
                <td>${whYcfbjDycsf.gestationalWeeks}周</td>
                <th>孕次</th>
                <td>${whYcfbjDycsf.gravidityTimes}</td>
            </tr>
            <tr>
                <th>产次</th>
                <td colspan="3">
                    阴道分娩&nbsp;&nbsp;${whYcfbjDycsf.vaginaDeliveryTimes}&nbsp;&nbsp;次&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;剖宫产&nbsp;&nbsp;${whYcfbjDycsf.cesareanSectionTimes}&nbsp;&nbsp;次
                </td>
            </tr>
            <tr>
                <th>末次月经日期</th>
                <td colspan="3">
                    <c:if test="${whYcfbjDycsf.lastMenstrualDateMark eq '3'}">
                        不详
                    </c:if>
                    <c:if test="${whYcfbjDycsf.lastMenstrualDateMark eq '2'}">
                        <fmt:formatDate value="${whYcfbjDycsf.lastMenstrualDate}" pattern="yyyy/MM/dd"/>
                    </c:if>
                </td>
            </tr>
            <tr>
                <th>预产期</th>
                <td colspan="3"><fmt:formatDate value="${whYcfbjDycsf.estimatedDueDates}" pattern="yyyy/MM/dd"/></td>
            </tr>
            <tr>
                <%--孕产妇既往史代码表--%>
                <th>孕产妇既往史</th>
                <td colspan="3">
                    <c:if test="${whYcfbjDycsf.pastMedicalHistorySign eq '1'}">
                        无
                    </c:if>
                    <c:if test="${whYcfbjDycsf.pastMedicalHistorySign eq '2'}">
                    <ehr:dic code="${whYcfbjDycsf.pastMedicalHistory}"
                                         dicmeta="CV0210005"/> ${whYcfbjDycsf.pastMedicalHistoryDesc}
                    </c:if>
                </td>
            </tr>
            <%--孕产妇家族史代码表--%>
            <tr>
                <th>孕产妇家族史</th>
                <td colspan="3">
                    <c:if test="${whYcfbjDycsf.familyDiseaseHistorySign eq '1'}">
                        无
                    </c:if>
                    <c:if test="${whYcfbjDycsf.familyDiseaseHistorySign eq '2'}">
                        <ehr:dic code="${whYcfbjDycsf.familyDiseaseHistory}" dicmeta="FS10019"/>
                        ${whYcfbjDycsf.familyDiseaseHistoryDesc}
                    </c:if>
                </td>
            </tr>
            <%--孕产妇个人史代码表--%>
            <tr>
                <th>孕产妇个人史</th>
                <td colspan="3">
                    <c:if test="${whYcfbjDycsf.personalHistorySign eq '1'}">
                        无特殊
                    </c:if>
                    <c:if test="${whYcfbjDycsf.personalHistorySign eq '2'}">
                        <ehr:dic code="${whYcfbjDycsf.personalHistory}" dicmeta="FS10019"/>
                        ${whYcfbjDycsf.personalHistoryDesc}
                    </c:if>
                </td>
            </tr>
            <tr>
                <%--手术史-有无妇科手术引用《有/无判断》--%>
                <th>有无妇科手术</th>
                <c:if test="${whYcfbjDycsf.womanSurgeryHistorySign eq '2'}">
                    <td>有</td>
                    <th>妇科手术</th>
                    <td>${whYcfbjDycsf.womanSurgeryHistory}</td>
                </c:if>
                <c:if test="${whYcfbjDycsf.womanSurgeryHistorySign ne '2'}">
                    <td colspan="3">无</td>
                </c:if>
            </tr>
            <%--<c:if test="${whYcfbjDycsf.sssywfkssDm eq '2'}">
                <tr>
                    <th>妇科手术详述</th>
                    <td colspan="3">${whYcfbjDycsf.sssfkssxs}</td>
                </tr>
            </c:if>--%>
            <tr>
                <%--<th>孕产史流产次数</th>
                <td>${whYcfbjDycsf.ycslccs}</td>--%>
                <th>孕产史自然流产次数</th>
                <td colspan="3">${whYcfbjDycsf.abortionTimes}</td>
            </tr>
            <tr>
                <th>孕产史人工流产次数</th>
                <td>${whYcfbjDycsf.artificialAbortionNum}</td>
                <th>孕产史死胎次数</th>
                <td>${whYcfbjDycsf.stillbornCasesNumber}</td>
            </tr>
            <tr>
                <th>孕产史死产次数</th>
                <td>${whYcfbjDycsf.stillbirthCasesNumber}
                </td>
                <th>孕产史新生儿死亡次数</th>
                <td>${whYcfbjDycsf.neonatalDeathNumber}</td>
            </tr>
            <tr>
                <th>孕产史出生缺陷儿次数</th>
                <td>${whYcfbjDycsf.birthDefectsNumber}</td>
                <th>身高</th>
                <td>${whYcfbjDycsf.height}cm</td>
            </tr>
            <tr>
                <th>体重</th>
                <td>${whYcfbjDycsf.bodyWeight}kg</td>
                <th>体质指数</th>
                <td>${whYcfbjDycsf.bodyMassIndex}kg/㎡</td>
            </tr>
            <tr>
                <th>舒张压</th>
                <td>${whYcfbjDycsf.dbp}mmHg</td>
                <th>收缩压</th>
                <td>${whYcfbjDycsf.sbp}mmHg</td>
            </tr>
            <tr>
                <%-- 未见异常/异常判断--%>
                <c:if test="${whYcfbjDycsf.cardiacAuscuAnomaly ne '2'}">
                    <th>听诊心脏情况</th>
                    <td colspan="3">未见异常</td>
                </c:if>
                <c:if test="${whYcfbjDycsf.cardiacAuscuAnomaly eq '2'}">
                    <th>听诊心脏情况</th>
                    <td>异常</td>
                    <th>听诊心脏异常描述</th>
                    <td>${whYcfbjDycsf.cardiacAuscuAnomalyDesc}</td>
                </c:if>
            </tr>
            <tr>
                <c:if test="${whYcfbjDycsf.lungAuscuAnomaly ne '2'}">
                    <th>听诊肺部情况</th>
                    <td colspan="3">未见异常</td>
                </c:if>
                <c:if test="${whYcfbjDycsf.lungAuscuAnomaly eq '2'}">
                    <th>听诊肺部情况</th>
                    <td>异常</td>
                    <th>听诊肺部异常描述</th>
                    <td>${whYcfbjDycsf.lungAuscuAnomalyDesc}</td>
                </c:if>
            </tr>
            <tr>
                <c:if test="${whYcfbjDycsf.vulvaAnomaly ne '2'}">
                    <th>妇科外阴情况</th>
                    <td colspan="3">未见异常</td>
                </c:if>
                <c:if test="${whYcfbjDycsf.vulvaAnomaly eq '2'}">
                    <th>妇科外阴情况</th>
                    <td>异常</td>
                    <th>妇科外阴异常描述</th>
                    <td>${whYcfbjDycsf.vulvaAnomalyDesc}</td>
                </c:if>
            </tr>
            <tr>
                <c:if test="${whYcfbjDycsf.vaginaAbnormal ne '2'}">
                    <th>妇科阴道情况</th>
                    <td colspan="3">未见异常</td>
                </c:if>
                <c:if test="${whYcfbjDycsf.vaginaAbnormal eq '2'}">
                    <th>妇科阴道情况</th>
                    <td>异常</td>
                    <th>妇科阴道异常描述</th>
                    <td>${whYcfbjDycsf.vaginaAbnormalDesc}</td>
                </c:if>
            </tr>
            <tr>
                <c:if test="${whYcfbjDycsf.abnormalCervical ne '2'}">
                    <th>妇科宫颈情况</th>
                    <td colspan="3">未见异常</td>
                </c:if>
                <c:if test="${whYcfbjDycsf.abnormalCervical eq '2'}">
                    <th>妇科宫颈情况</th>
                    <td>异常</td>
                    <th>妇科宫颈异常描述</th>
                    <td>${whYcfbjDycsf.abnormalCervicalDesc}</td>
                </c:if>
            </tr>
            <tr>
                <c:if test="${whYcfbjDycsf.corpusAnomaly ne '2'}">
                    <th>妇科子宫情况</th>
                    <td colspan="3">未见异常</td>
                </c:if>
                <c:if test="${whYcfbjDycsf.corpusAnomaly eq '2'}">
                    <th>妇科子宫情况</th>
                    <td>异常</td>
                    <th>妇科子宫异常描述</th>
                    <td>${whYcfbjDycsf.corpusAnomalyDesc}</td>
                </c:if>
            </tr>
            <tr>
                <c:if test="${whYcfbjDycsf.accessoriesAnomaly ne '2'}">
                    <th>妇科附件情况</th>
                    <td colspan="3">未见异常</td>
                </c:if>
                <c:if test="${whYcfbjDycsf.accessoriesAnomaly eq '2'}">
                    <th>妇科附件情况</th>
                    <td>异常</td>
                    <th>妇科附件异常描述</th>
                    <td>${whYcfbjDycsf.accessoriesAnomalyDesc}</td>
                </c:if>
            </tr>
            <%--<tr>
                <th>妇科其他描述</th>
                <td colspan="3">${whYcfbjDycsf.fkqtms}</td>
            </tr>--%>
            <tr>
                <th>血常规血红蛋白值</th>
                <td>${whYcfbjDycsf.hemoglobinValue}g/L</td>
                <th>血常规白细胞值</th>
                <td>${whYcfbjDycsf.leukocyteCount}/L</td>
            </tr>
            <tr>
                <th>血常规血小板值</th>
                <td>${whYcfbjDycsf.plateletCount}/L</td>
                <th>血常规其他描述</th>
                <td>${whYcfbjDycsf.otherBloodRoutine}</td>
            </tr>
            <tr>
                <th>尿常规尿蛋白</th>
                <td><ehr:dic code="${whYcfbjDycsf.urineProQualitativeResult}" dicmeta="CV0450015"/></td>
                <th>尿常规尿糖</th>
                <td><ehr:dic code="${whYcfbjDycsf.urineSugQualitativeResult}" dicmeta="CV0450015"/></td>
                </td>
            </tr>
            <tr>
                <th>尿常规尿酮体</th>
                <td><ehr:dic code="${whYcfbjDycsf.ketQualitativeDetection}" dicmeta="CV0450015"/></td>
                <th>尿常规尿潜血</th>
                <td><ehr:dic code="${whYcfbjDycsf.eryDetection}" dicmeta="CV0450015"/></td>
            </tr>
            <tr>
                <th>尿常规其他描述</th>
                <td colspan="3">${whYcfbjDycsf.otherUrineRoutines}</td>
            </tr>
            <tr>
                <%--ABO血型代码表--%>
                <th>ABO血型</th>
                <td><ehr:dic code="${whYcfbjDycsf.aboBloodType}" dicmeta="CV0450005"/></td>
                <%--引用《是/否判断》--%>
                <th>RH阴性</th>
                <td><ehr:dic code="${whYcfbjDycsf.rhBloodType}" dicmeta="FS10010"/></td>
            </tr>
            <tr>
                <th>空腹血糖（mmol/L）</th>
                <td>${whYcfbjDycsf.bloodGlucoseValues}
                </td>
                <th>肝功能血清谷丙转氨酶</th>
                <td>${whYcfbjDycsf.serumGptValue}U/L
                </td>
            </tr>
            <tr>
                <th>肝功能血清谷草转氨酶</th>
                <td>${whYcfbjDycsf.serumAstValue}U/L
                </td>
                <th>肝功能白蛋白</th>
                <td>${whYcfbjDycsf.albuminConcentration}g/L
                </td>
            </tr>
            <tr>
                <th>肝功能总胆红素</th>
                <td>${whYcfbjDycsf.totalBilirubin}umol/L
                </td>
                <th>肝功能结合胆红素</th>
                <td>${whYcfbjDycsf.conjugatedBilirubin}umol/L
                </td>
            </tr>
            <tr>
                <th>肾功能血清肌酐</th>
                <td>${whYcfbjDycsf.creatinine}umol/L
                </td>
                <th>肾功能血尿素氮</th>
                <td>${whYcfbjDycsf.bloodUreaNitrogenValues}mmol/L
                </td>
            </tr>
            <tr><%--阴道分泌物检查结果代码表--%>
                <th>阴道分泌物检查结果</th>
                <td colspan="3">
                    <c:if test="${whYcfbjDycsf.vaginaSecretionsCheckResult eq '1'}">
                        未见异常
                    </c:if>
                    <c:if test="${whYcfbjDycsf.vaginaSecretionsCheckResult ne '1'}">
                        <ehr:dic code="${whYcfbjDycsf.vaginaSecretionsCheckResult}" dicmeta="CV0450019"/>
                        ${whYcfbjDycsf.vaginaSecretionsCheckDesc}
                    </c:if>
                </td>
            </tr>
            <tr>
                <%--阴道清分泌物洁度代码表--%>
                <th>阴道清分泌物洁度</th>
                <td><ehr:dic code="${whYcfbjDycsf.vaginaSecretionsCleanliness}" dicmeta="CV0450010"/> </td>
                <%--阴性/阳性判断--%>
                <th>乙型肝炎表面抗原</th>
                <td><ehr:dic code="${whYcfbjDycsf.hbsagDetectResult}" dicmeta="FS10058"/></td>
            </tr>
            <tr>
                <%--阴性/阳性判断--%>
                <th>乙型肝炎表面抗体</th>
                <td><ehr:dic code="${whYcfbjDycsf.hbsDetectResult}" dicmeta="FS10058"/></td>
                <%--阴性/阳性判断--%>
                <th>乙型肝炎E抗原</th>
                <td><ehr:dic code="${whYcfbjDycsf.hbeagDetectResult}" dicmeta="FS10058"/></td>
            </tr>
            <tr>
                <%--阴性/阳性判断--%>
                <th>乙型肝炎E抗体</th>
                <td><ehr:dic code="${whYcfbjDycsf.hbeDetectResult}" dicmeta="FS10058"/></td>
                <%--阴性/阳性判断--%>
                <th>乙型肝炎核心抗体</th>
                <td><ehr:dic code="${whYcfbjDycsf.hbcabDetectResult}" dicmeta="FS10058"/></td>
            </tr>
            <tr>
                <%--阴性/阳性判断--%>
                <th>梅毒血清学试验</th>
                <td><ehr:dic code="${whYcfbjDycsf.syphilisSerologyCheckResult}" dicmeta="FS10058"/></td>
                <%--阴性/阳性判断--%>
                <th>HIV抗体检测</th>
                <td><ehr:dic code="${whYcfbjDycsf.hivlgDetectResult}" dicmeta="FS10058"/></td>
            </tr>

            <tr>
                <th>B超详述</th>
                <td colspan="3">${whYcfbjDycsf.bmodeCheckResult}</td>
            </tr>
            <%--<tr>
                <th>辅助检查其他描述</th>
                <td colspan="3">${whYcfbjDycsf.fzjcqtms}</td>
            </tr>--%>
            <c:if test="${whYcfbjDycsf.assessmentAnomalySign ne '2'}">
                <tr>
                        <%--未见异常/异常判断--%>
                    <th>总结评估</th>
                    <td colspan="3">未见异常</td>
                </tr>
            </c:if>
            <c:if test="${whYcfbjDycsf.assessmentAnomalySign eq '2'}">
                <tr>
                    <th>总结评估</th>
                    <td>异常</td>
                    <th>总结评估异常描述</th>
                    <td>${whYcfbjDycsf.healthAbnormalDesc}</td>
                </tr>
            </c:if>
            <%--<c:if test="${whYcfbjDycsf.jkzdDm ne '99'}">
                <tr>
                        &lt;%&ndash;孕产妇健康指导代码表&ndash;%&gt;
                    <th>健康指导</th>
                    <td colspan="3">${whYcfbjDycsf.jkzdMc}</td>
                </tr>
            </c:if>
            <c:if test="${whYcfbjDycsf.jkzdDm eq '99'}">
                <tr>
                    <th>其他孕产妇健康指导</th>
                    <td colspan="3">${whYcfbjDycsf.qtycfjkzdxs}</td>
                </tr>
                <tr>
                    <th>其他孕产妇健康指导详述</th>
                    <td colspan="3">${whYcfbjDycsf.qtycfjkzdMc}</td>
                </tr>
            </c:if>--%>
            <tr>
                <%--是/否判断--%>
                <th>是否转诊</th>
                <c:if test='${whYcfbjDycsf.referralFlag eq "0"}'>
                    <td colspan="3">否</td>
                </c:if>
                <c:if test='${whYcfbjDycsf.referralFlag eq "1"}'>
                    <td>是</td>
                </c:if>
                <c:if test='${whYcfbjDycsf.referralFlag eq "1"}'>
                    <th>转诊原因</th>
                    <td>${whYcfbjDycsf.referralReason}</td>
                </c:if>
            </tr>
            <c:if test='${whYcfbjDycsf.referralFlag eq "1"}'>
                <tr>
                    <th>转诊机构</th>
                    <td>${whYcfbjDycsf.referralHospitalName}</td>
                    <th>转诊机构科室</th>
                    <td>${whYcfbjDycsf.referralDeptName}</td>
                </tr>
            </c:if>
            <tr>
                <th>下次随访日期</th>
                <td><fmt:formatDate value="${whYcfbjDycsf.nextSupervisionDate}" pattern="yyyy/MM/dd"/></td>
                <th>随访医生姓名</th>
                <td><ehr:staff-name staffCode="${whYcfbjDycsf.supervisionDoctor}"/></td>
            </tr>
            <%--<tr>
                <th></th>
                <td colspan="3"></td>
            </tr>

            <tr>
                <th>就诊机构</th>
                <td colspan="3">${whYcfbjDycsf.clinicOrganName}</td>
            </tr>--%>
        </table>
    </div>
</div>