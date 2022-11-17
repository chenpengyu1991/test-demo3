<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/views/ehrbrowser/basic/basic.css" />

<div>
	<ul>
		<li style="text-align: center; font-size: 25px;">新生儿家庭访视</li>
	</ul>
	<br/>
	<div class="table-basic-narrow">
		<p style="font-size: 14px;">新生儿家庭访视记录表单编号:<c:out value="${neonatalFamilyVisit.recordNumber}"></c:out></p>
		<table>
			<colgroup>
				<col style="width: 20%;"/>
	            <col style="width: 30%;"/>
				<col style="width: 20%;"/>
	            <col style="width: 30%;"/>
			</colgroup>
			<tr>
				<th>姓名</th>
				<td>
					<c:out value="${neonatalFamilyVisit.neonatusName}"></c:out>
				</td>
				<th>性别</th>
				<td>
					<ehr:dic code="${neonatalFamilyVisit.neonatalGender}" dicmeta="GBT226112003"></ehr:dic>
				</td>
			</tr>
			<tr>
				<th>出生日期</th>
				<td>
					<fmt:formatDate value="${neonatalFamilyVisit.neonatusBirthday}" pattern="yyyy/MM/dd"/>
				</td>
				<th>身份证件号码</th>
				<td>
					<c:out value="${neonatalFamilyVisit.neonatusIdcard}"/>
				</td>
			</tr>
			<tr>
				<th>父亲姓名</th>
				<td>
					<c:out value="${neonatalFamilyVisit.fatherName}"/>
				</td>
				<th>父亲出生日期</th>
				<td>
					<fmt:formatDate value="${neonatalFamilyVisit.fatherBirthday}" pattern="yyyy/MM/dd"/>
				</td>
			</tr>
			<tr>
				<th>父亲电话号码</th>
				<td>
					<c:out value="${neonatalFamilyVisit.fatherPhone}"/>
				</td>
				<th>父亲职业</th>
				<td>
					<ehr:dic code="${neonatalFamilyVisit.fatherOccupationalGroupCode}" dicmeta="GBT6565"></ehr:dic>
				</td>
			</tr>
			<tr>
				<th>母亲姓名</th>
				<td>
					<c:out value="${neonatalFamilyVisit.motherName}"/>
				</td>
				<th>母亲出生日期</th>
				<td>
					<fmt:formatDate value="${neonatalFamilyVisit.motherBirthday}" pattern="yyyy/MM/dd"/>
				</td>
			</tr>
			<tr>
				<th>母亲电话号码</th>
				<td>
					<c:out value="${neonatalFamilyVisit.matherPhone}"/>
				</td>
				<th>母亲职业</th>
				<td>
					<ehr:dic code="${neonatalFamilyVisit.motherOccupationalGroupCode}" dicmeta="GBT6565"></ehr:dic>
				</td>
			</tr>
			<tr>
				<th>现住址</th>
				<td colspan="3">
					<c:out value="${neonatalFamilyVisit.paprovince}"/>
					<c:out value="${neonatalFamilyVisit.pacity}"/>
					<c:out value="${neonatalFamilyVisit.pacounty}"/>
					<c:out value="${neonatalFamilyVisit.patownShip}"/>
					<c:out value="${neonatalFamilyVisit.pastreet}"/>
					<c:out value="${neonatalFamilyVisit.pahouseNumber}"/>
				</td>
			</tr>
			<tr>
				<th>出生孕周</th>
				<td>
					<c:out value="${neonatalFamilyVisit.gestationalWeek}"/>
				</td>
				<th>助产机构名称</th>
				<td>
					<c:out value="${neonatalFamilyVisit.obstetricInstitutionsName}"/>
				</td>
			</tr>
			<tr>
				<th>母亲妊娠合并症/并发症史</th>
				<td colspan="3">
					<c:out value="${neonatalFamilyVisit.complicationHistory}"/>
				</td>
			</tr>
			<tr>
				<th>末次分娩方式</th>
				<td colspan="3">
					<ehr:dic code="${neonatalFamilyVisit.lastdeliverycode}" dicmeta="CV0210003"></ehr:dic>
				</td>
			</tr>
			<tr>
				<th>出生体重(g)</th>
				<td>
					<c:out value="${neonatalFamilyVisit.birthWeight}"/>
				</td>
				<th>出生身长(cm)</th>
				<td>
					<c:out value="${neonatalFamilyVisit.birthStature}"/>
				</td>
			</tr>
			<tr>
				<th>双多胎标志</th>
				<td>
                    <c:if test="${!empty neonatalFamilyVisit.polyembryonySign}">
					    <c:out value='${neonatalFamilyVisit.polyembryonySign eq "1" ? "是" : "否"}'/>
                    </c:if>
				</td>
				<th>新生儿窒息标志</th>
				<td>
                    <c:if test="${!empty neonatalFamilyVisit.asphyxiaSign}">
					    <c:out value='${neonatalFamilyVisit.asphyxiaSign eq "1" ? "是" : "否"}'/>
                    </c:if>
				</td>
			</tr>
			<tr>
				<th>Apgar评分值(分)</th>
				<td colspan="3">
					<c:out value="${neonatalFamilyVisit.apgarValue}"/>
				</td>
			</tr>
			<tr>
				<th>新生儿畸形标志</th>
				<td colspan="3">
                    <c:if test="${!empty neonatalFamilyVisit.deformitySign}">
					    <c:out value='${neonatalFamilyVisit.deformitySign eq "1" ? "是" : "否"}'/>
                    </c:if>
				</td>
			</tr>
			<c:if test='${neonatalFamilyVisit.deformitySign eq "1"}'>
				<th>新生儿畸形描述</th>
				<td colspan="3">
					<c:out value="${neonatalFamilyVisit.deformityDesc}"/>
				</td>
			</c:if>
			<tr>
				<th>新生儿听力筛查情况</th>
				<td>
					<ehr:dic code="${neonatalFamilyVisit.hearingScreeningState}" dicmeta="FS10025"></ehr:dic>
				</td>
				<th>新生儿听力筛查结果</th>
				<td>
					<ehr:dic code="${neonatalFamilyVisit.hearingScreeningResults}" dicmeta="FS10170"></ehr:dic>
				</td>
			</tr>
			<tr>
				<th>新生儿疾病筛查项目</th>
				<td colspan="3">
					<ehr:dic code="${neonatalFamilyVisit.diseaseScreeningProject}" dicmeta="CV0450008"></ehr:dic>
				</td>
			</tr>
			<tr>
				<th>体重(kg)</th>
				<td>
					<c:out value="${neonatalFamilyVisit.bodyWeight}"></c:out>
				</td>
				<th>喂养方式</th>
				<td>
					<ehr:dic code="${neonatalFamilyVisit.feedingType}" dicmeta="FS10026"></ehr:dic>
				</td>
			</tr>
			<tr>
				<th>每天吃奶次数</th>
				<td>
					<c:out value="${neonatalFamilyVisit.eatMilkNumber}"></c:out>
				</td>
				<th>每天吃奶量(mL)</th>
				<td>
					<c:out value="${neonatalFamilyVisit.eatMilkSupply}" ></c:out>
				</td>
			</tr>
			<tr>
				<th>呕吐标志</th>
				<td>
					<c:out value='${neonatalFamilyVisit.vomitingMark eq "1" ? "是" : "否"}'></c:out>
				</td>
				<th>新生儿大便性状</th>
				<td>
					<ehr:dic code="${neonatalFamilyVisit.stoolProperty}" dicmeta="CV0401012"></ehr:dic>
				</td>
			</tr>
			<tr>
				<th>体温(℃)</th>
				<td>
					<c:out value="${neonatalFamilyVisit.temperature}"></c:out>
				</td>
				<th>脉率(次/血n)</th>
				<td>
					<c:out value="${neonatalFamilyVisit.pulseRate}"></c:out>
				</td>
			</tr>
			<tr>
				<th>呼吸频率(次/min)</th>
				<td>
					<c:out value="${neonatalFamilyVisit.respiratoryRate}"></c:out>
				</td>
				<th>新生儿面色</th>
				<td>
					<ehr:dic code="${neonatalFamilyVisit.complexionCode}" dicmeta="CV0410008"></ehr:dic>
				</td>
			</tr>
			<tr>
				<th>黄疸部位</th>
				<td colspan="3">
					<ehr:dic code="${neonatalFamilyVisit.jaundicePartsCode}" dicmeta="CV0410009"></ehr:dic>
				</td>
			</tr>
			<tr>
				<th>前囟横径(cm)</th>
				<td>
					<c:out value="${neonatalFamilyVisit.afTransverseDiameter}"></c:out>
				</td>
				<th>前囟纵径(cm)</th>
				<td>
					<c:out value="${neonatalFamilyVisit.bregmaDiameter}"></c:out>
				</td>
			</tr>
			<tr>
				<th>前囟张力</th>
				<td colspan="3">
					<ehr:dic code="${neonatalFamilyVisit.bregmaTension}" dicmeta="CV0410018"></ehr:dic>
				</td>
			</tr>
			<tr>
				<th>眼外观检查异常</th>
				<td colspan="3">
                    <c:if test="${!empty neonatalFamilyVisit.eyeappearanceSign}">
                        <c:choose>
                            <c:when test="${neonatalFamilyVisit.eyeappearanceSign eq '0'}">未见异常</c:when>
                            <c:otherwise>异常 ${neonatalFamilyVisit.eyeAppearanceInspectionDesc}</c:otherwise>
                        </c:choose>
					    <%--<c:out value='${neonatalFamilyVisit.eyeappearanceSign eq "0" ? "未见异常" : "异常 ".concat(neonatalFamilyVisit.eyeAppearanceInspectionDesc)}'></c:out>--%>
                    </c:if>
				</td>
			</tr>
			<tr>
				<th>四肢活动度异常</th>
				<td colspan="3">
                    <c:if test="${!empty neonatalFamilyVisit.limbActivityAnomalySign}">
                        <c:choose>
                            <c:when test="${neonatalFamilyVisit.limbActivityAnomalySign eq '0'}">未见异常</c:when>
                            <c:otherwise>异常 ${neonatalFamilyVisit.limbActivityDesc}</c:otherwise>
                        </c:choose>
					    <%--<c:out value='${neonatalFamilyVisit.limbActivityAnomalySign eq "0" ? "未见异常" : "异常 ".concat(neonatalFamilyVisit.limbActivityDesc)}'></c:out>--%>
                    </c:if>
				</td>
			</tr>
			<tr>
				<th>耳外观检查异常</th>
				<td colspan="3">
                    <c:if test="${!empty neonatalFamilyVisit.earAppearanceInspection}">
                        <c:choose>
                            <c:when test="${neonatalFamilyVisit.earAppearanceInspection eq '0'}">未见异常</c:when>
                            <c:otherwise>异常 ${neonatalFamilyVisit.earAppearanceInspectionDesc}</c:otherwise>
                        </c:choose>
					    <%--<c:out value='${neonatalFamilyVisit.earAppearanceInspection eq "0" ? "未见异常" : "异常 ".concat(neonatalFamilyVisit.earAppearanceInspectionDesc)}'></c:out>--%>
                    </c:if>
				</td>
			</tr>
			<tr>
				<th>颈部包块标志</th>
				<td colspan="3">
                    <c:if test="${!empty neonatalFamilyVisit.neckLumpSign}">
                        <c:choose>
                            <c:when test="${neonatalFamilyVisit.earAppearanceInspection eq '0'}">未见异常</c:when>
                            <c:otherwise>异常 ${neonatalFamilyVisit.neckLumpDesc}</c:otherwise>
                        </c:choose>
					    <%--<c:out value='${neonatalFamilyVisit.neckLumpSign eq "0" ? "未见异常" : "异常 ".concat(neonatalFamilyVisit.neckLumpDesc)}'></c:out>--%>
                    </c:if>
				</td>
			</tr>
			<tr>
				<th>鼻检查异常</th>
				<td colspan="3">
                    <c:if test="${!empty neonatalFamilyVisit.nasalCheckAnomaly}">
                        <c:choose>
                            <c:when test="${neonatalFamilyVisit.nasalCheckAnomaly eq '0'}">未见异常</c:when>
                            <c:otherwise>异常 ${neonatalFamilyVisit.nasalCheckAnomalyDesc}</c:otherwise>
                        </c:choose>
					    <%--<c:out value='${neonatalFamilyVisit.nasalCheckAnomaly eq "0" ? "未见异常" : "异常 ".concat(neonatalFamilyVisit.nasalCheckAnomalyDesc)}'></c:out>--%>
                    </c:if>
				</td>
			</tr>
			<tr>
				<th>皮肤检查异常</th>
				<td colspan="3">
                    <c:if test="${!empty neonatalFamilyVisit.skinVisionInspection}">
                        <c:choose>
                            <c:when test="${neonatalFamilyVisit.skinVisionInspection eq '0'}">未见异常</c:when>
                            <c:otherwise>异常 ${neonatalFamilyVisit.skinVisionInspectionDesc}</c:otherwise>
                        </c:choose>
					    <%--<c:out value='${neonatalFamilyVisit.skinVisionInspection eq "0" ? "未见异常" : "异常 ".concat(neonatalFamilyVisit.skinVisionInspectionDesc)}'></c:out>--%>
                    </c:if>
				</td>
			</tr>
			<tr>
				<th>口腔检查异常</th>
				<td colspan="3">
                    <c:if test="${!empty neonatalFamilyVisit.oralExaminationAnomaly}">
                        <c:choose>
                            <c:when test="${neonatalFamilyVisit.oralExaminationAnomaly eq '0'}">未见异常</c:when>
                            <c:otherwise>异常 ${neonatalFamilyVisit.oralExaminationAnomalyDesc}</c:otherwise>
                        </c:choose>
					    <%--<c:out value='${neonatalFamilyVisit.oralExaminationAnomaly eq "0" ? "未见异常" : "异常 ".concat(neonatalFamilyVisit.oralExaminationAnomalyDesc)}'></c:out>--%>
                    </c:if>
				</td>
			</tr>
			<tr>
				<th>肛门检查异常</th>
				<td colspan="3">
                    <c:if test="${!empty neonatalFamilyVisit.analExaminationAnomaly}">
                        <c:choose>
                            <c:when test="${neonatalFamilyVisit.analExaminationAnomaly eq '0'}">未见异常</c:when>
                            <c:otherwise>异常 ${neonatalFamilyVisit.analExaminationAnomalyDesc}</c:otherwise>
                        </c:choose>
					    <%--<c:out value='${neonatalFamilyVisit.analExaminationAnomaly eq "0" ? "未见异常" : "异常 ".concat(neonatalFamilyVisit.analExaminationAnomalyDesc)}'></c:out>--%>
                    </c:if>
				</td>
			</tr>
			<tr>
				<th>心脏听诊异常</th>
				<td colspan="3">
                    <c:if test="${!empty neonatalFamilyVisit.cardiacAuscuAnomaly}">
                        <c:choose>
                            <c:when test="${neonatalFamilyVisit.cardiacAuscuAnomaly eq '0'}">未见异常</c:when>
                            <c:otherwise>异常 ${neonatalFamilyVisit.cardiacAuscuAnomalyDesc}</c:otherwise>
                        </c:choose>
					    <%--<c:out value='${neonatalFamilyVisit.cardiacAuscuAnomaly eq "0" ? "未见异常" : "异常 ".concat(neonatalFamilyVisit.cardiacAuscuAnomalyDesc)}'></c:out>--%>
                    </c:if>
				</td>
			</tr>
			<tr>
				<th>肺部听诊异常</th>
				<td colspan="3">
                    <c:if test="${!empty neonatalFamilyVisit.lungAuscuAnomaly}">
                        <c:choose>
                            <c:when test="${neonatalFamilyVisit.lungAuscuAnomaly eq '0'}">未见异常</c:when>
                            <c:otherwise>异常 ${neonatalFamilyVisit.lungAuscuAnomalyDesc}</c:otherwise>
                        </c:choose>
					    <%--<c:out value='${neonatalFamilyVisit.lungAuscuAnomaly eq "0" ? "未见异常" : "异常 ".concat(neonatalFamilyVisit.lungAuscuAnomalyDesc)}'></c:out>--%>
                    </c:if>
				</td>
			</tr>
			<tr>
				<th>外生殖器检查异常</th>
				<td colspan="3">
                    <c:if test="${!empty neonatalFamilyVisit.extGenitalCheckAnomaly}">
                        <c:choose>
                            <c:when test="${neonatalFamilyVisit.extGenitalCheckAnomaly eq '0'}">未见异常</c:when>
                            <c:otherwise>异常 ${neonatalFamilyVisit.extGenitalCheckAnomalyDesc}</c:otherwise>
                        </c:choose>
					    <%--<c:out value='${neonatalFamilyVisit.extGenitalCheckAnomaly eq "0" ? "未见异常" : "异常 ".concat(neonatalFamilyVisit.extGenitalCheckAnomalyDesc)}'></c:out>--%>
                    </c:if>
				</td>
			</tr>
			<tr>
				<th>腹部触诊异常</th>
				<td colspan="3">
                    <c:if test="${!empty neonatalFamilyVisit.abdominalPalpAnomaly}">
                        <c:choose>
                            <c:when test="${neonatalFamilyVisit.abdominalPalpAnomaly eq '0'}">未见异常</c:when>
                            <c:otherwise>异常 ${neonatalFamilyVisit.abdominalPalpAnomalyDesc}</c:otherwise>
                        </c:choose>
					    <%--<c:out value='${neonatalFamilyVisit.abdominalPalpAnomaly eq "0" ? "未见异常" : "异常 ".concat(neonatalFamilyVisit.abdominalPalpAnomalyDesc)}'></c:out>--%>
                    </c:if>
				</td>
			</tr>
			<tr>
				<th>脊柱检查异常</th>
				<td colspan="3">
                    <c:if test="${!empty neonatalFamilyVisit.spinalCheckAnomaly}">
                        <c:choose>
                            <c:when test="${neonatalFamilyVisit.spinalCheckAnomaly eq '0'}">未见异常</c:when>
                            <c:otherwise>异常 ${neonatalFamilyVisit.spinalCheckAnomalyDesc}</c:otherwise>
                        </c:choose>
					    <%--<c:out value='${neonatalFamilyVisit.spinalCheckAnomaly eq "0" ? "未见异常" : "异常 ".concat(neonatalFamilyVisit.spinalCheckAnomalyDesc)}'></c:out>--%>
                    </c:if>
				</td>
			</tr>
			<tr>
				<th>脐带检查结果</th>
				<td colspan="3">
					<c:if test="${!empty neonatalFamilyVisit.umbilicalCordSeparation}">
						<c:choose>
							<c:when test="${neonatalFamilyVisit.umbilicalCordSeparation eq '0'}">未见异常</c:when>
							<c:otherwise>异常 ${neonatalFamilyVisit.umbilicalCordCheckDesc}</c:otherwise>
						</c:choose>
					</c:if>
				</td>
			</tr>
			<tr>
				<th>转诊标志</th>
				<td <c:if test='${neonatalFamilyVisit.referralFlag eq "0" }'> colspan="3" </c:if> >
                    <c:if test="${!empty neonatalFamilyVisit.referralFlag}">
					    <c:out value='${neonatalFamilyVisit.referralFlag eq "1" ? "是" : "否"}'></c:out>
                    </c:if>
				</td>
				<c:if test='${neonatalFamilyVisit.referralFlag eq "1" }'>
					<th>转诊机构及科室</th>
					<td>
						<c:out value="${neonatalFamilyVisit.referralHospitalName}"></c:out>
						<c:out value="${neonatalFamilyVisit.referralDeptName}"></c:out>
					</td>
				</c:if>
			</tr>
			<c:if test='${neonatalFamilyVisit.referralFlag eq "1" }'>
				<tr>
					<th>转诊原因</th>
					<td colspan="3">
						<c:out value="${neonatalFamilyVisit.referralReason}"></c:out>
					</td>
				</tr>
			</c:if>
			<tr>
				<th>新生儿访视健康指导</th>
				<td colspan="3">
					<ehr:dic code="${neonatalFamilyVisit.healthGuidanceCategory}" dicmeta="CV0600217"></ehr:dic>
				</td>
			</tr>
			<tr>
				<th>本次访视日期</th>
				<td>
					<fmt:formatDate value="${neonatalFamilyVisit.visitDate}" pattern="yyyy/MM/dd"/>
				</td>
				<th>访视医师姓名</th>
				<td>
					<c:out value="${neonatalFamilyVisit.supervisionDoctor}"></c:out>
				</td>
			</tr>
			<tr>
				<th>下次访视地点</th>
				<td>
					<c:out value="${neonatalFamilyVisit.nextSupervisionPlace}"></c:out>
				</td>
				<th>下次访视日期</th>
				<td>
					<fmt:formatDate value="${neonatalFamilyVisit.nextSupervisionDate}" pattern="yyyy/MM/dd"/>
				</td>
			</tr>
		</table>
	</div>
</div>