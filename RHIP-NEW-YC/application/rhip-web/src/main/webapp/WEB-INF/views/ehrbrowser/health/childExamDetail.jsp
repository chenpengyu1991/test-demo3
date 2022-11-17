<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/views/ehrbrowser/basic/basic.css" />

<div style="background-color: white; height: 515px;">
	<ul>
		<li style="text-align: center; font-size: 25px;">${childHealthExamination.cPhysicalExamAge}健康体检</li>
	</ul>
	<br/>
	<table class="layui-table x-admin-sm-table-list-small">
		<colgroup>
			<col style="width: 10%;"/>
            <col style="width: 15%;"/>
			<col style="width: 5%;"/>
            <col style="width: 10%;"/>
			<col style="width: 5%;"/>
            <col style="width: 5%;"/>
			<col style="width: 10%;"/>
            <col style="width: 15%;"/>
		</colgroup>
		<tr>
			<th>体检编号：</th>
			<td><c:out value="${childHealthExamination.recordNumber}"></c:out><td>
			<th>姓名：</th>
			<td><c:out value="${childHealthExamination.name}"></c:out><td>
			<th>性别：</th>
			<td><ehr:dic code="${childHealthExamination.gender}" dicmeta="GBT226112003"></ehr:dic><td>
			<th>体检时间：</th>
			<td>
				<fmt:formatDate value="${childHealthExamination.checkDate}" pattern="yyyy/MM/dd"/>
			</td>
		</tr>
	</table>
	<div class="table-basic">
		<table>
			<colgroup>
				<col style="width: 20%;"/>
	            <col style="width: 30%;"/>
				<col style="width: 20%;"/>
	            <col style="width: 30%;"/>
			</colgroup>
			<tr>
				<th>出生日期</th>
				<td><fmt:formatDate value="${childHealthExamination.birthday}" pattern="yyyy/MM/dd"/></td>
				<th>身份证件号码</th>
				<td><c:out value="${childHealthExamination.idCard}"></c:out></td>
			</tr>
			<tr>
				<th >血型</th>
				<td><ehr:dic code="${childHealthExamination.aboBloodType}" dicmeta="CV0450005"></ehr:dic></td>
				<th>Rh血型</th>
				<td><ehr:dic code="${childHealthExamination.rhBloodType}" dicmeta="FS10010"></ehr:dic></td>
			</tr>
			<tr>
				<th>出生孕周</th>
				<td><c:out value="${childHealthExamination.gestationalWeek}"></c:out></td>
				<th>儿童体检年龄</th>
				<td><c:out value="${childHealthExamination.cPhysicalExamAge}"></c:out></td>
			</tr>
			<tr>
				<th>体弱儿童标志</th>
				<td>
                    <c:if test="${!empty childHealthExamination.debilityChildrenFlag}">
                        <c:out value='${childHealthExamination.debilityChildrenFlag eq "1" ? "是" : "否"}'></c:out>
                    </c:if>
                </td>
				<th>分娩方式</th>
				<td><ehr:dic code="${childHealthExamination.deliveryWay}" dicmeta="CV0210003"></ehr:dic></td>
			</tr>
			<tr>
				<th>抬头月龄</th>
				<td><c:out value="${childHealthExamination.lookUpMonth}"></c:out></td>
				<th>独坐月龄</th>
				<td><c:out value="${childHealthExamination.sitAloneMonth}" ></c:out></td>
			</tr>
			<tr>
				<th>翻身月龄</th>
				<td><c:out value="${childHealthExamination.turnOverMonth}"></c:out></td>
				<th>爬行月龄</th>
				<td><c:out value="${childHealthExamination.crawlMonth}" ></c:out></td>
			</tr>
			<tr>
				<th >体重(kg)</th>
				<td><c:out value="${childHealthExamination.bodyWeight}"></c:out></td>
				<th>年龄别体重评价结果</th>
				<td><ehr:dic code="${childHealthExamination.evaluationresultcode}" dicmeta="CV0510006"></ehr:dic></td>
			</tr>
			<tr>
				<th>身长(cm)</th>
				<td><c:out value="${childHealthExamination.stature}"></c:out></td>
				<th>年龄别身高评价结果</th>
				<td><ehr:dic code="${childHealthExamination.heightEvaluationResult}" dicmeta="CV0510006"></ehr:dic></td>
			</tr>
			<tr>
				<th>身高(cm)</th>
				<td><c:out value="${childHealthExamination.height}"></c:out></td>
				<th>身高别体重评价结果</th>
				<td><ehr:dic code="${childHealthExamination.hwEvaluationResult}" dicmeta="CV0510006"></ehr:dic></td>
			</tr>
			<tr>
				<th>胸围(cm)</th>
				<td>
					<c:out value="${childHealthExamination.bust}"></c:out>
				</td>
				<th>头围(cm)</th>
				<td>
					<c:out value="${childHealthExamination.headCircumference}" />
				</td>
			</tr>
			<tr>
				<th>体格发育评价</th>
				<td>
					<ehr:dic code="${childHealthExamination.physiquegrowthCode}" dicmeta="CV0410020"></ehr:dic>
				</td>
				<th>血红蛋白值(g/L)</th>
				<td>
					<c:out value="${childHealthExamination.hemoglobinValue}"></c:out>
				</td>
			</tr>
			<tr>
				<th>儿童面色</th>
				<td >
					<ehr:dic code="${childHealthExamination.childrenComplexionCode}" dicmeta="CV0410008"></ehr:dic>
				</td>
				<th>皮肤检查异常</th>
				<td >
                    <c:if test="${!empty childHealthExamination.skinInspectionAnomalySign}">
					    <c:out value='${childHealthExamination.skinInspectionAnomalySign eq "1" ? "未见异常" : "有异常"}'></c:out>
                    </c:if>
				</td>
			</tr>
			<tr>
				<th>前囟闭合</th>
				<td colspan="3">
                    <c:if test="${!empty childHealthExamination.afClosureFlag}">
					    <c:out value='${childHealthExamination.afClosureFlag eq "0" ? "未闭合" : "闭合"}'></c:out>
                    </c:if>
				</td>
			</tr>
			<tr>
				<th>前囟横径(cm)</th>
				<td>
					<c:out value="${childHealthExamination.afTransverseDiameter}"></c:out>
				</td>
				<th>前囟纵径(cm)</th>
				<td>
					<c:out value="${childHealthExamination.bregmaDiameter}"></c:out>
				</td>
			</tr>
			<tr>
				<th>颈部包块</th>
				<td>
                    <c:if test="${!empty childHealthExamination.neckLumpSign}">
					    <c:out value='${childHealthExamination.neckLumpSign eq "1" ? "未见异常" : "有异常"}'></c:out>
                    </c:if>
				</td>
				<th>眼外观检查异常</th>
				<td>
                    <c:if test="${!empty childHealthExamination.eyeappearanceSign}">
					    <c:out value='${childHealthExamination.eyeappearanceSign eq "1" ? "未见异常" : "有异常"}'></c:out>
                    </c:if>
				</td>
			</tr>
			<tr>
				<th>左眼矫正远视力值</th>
				<td>
					<c:out value='${childHealthExamination.lEyecorrection}'></c:out>
				</td>
				<th>右眼矫正远视力值</th>
				<td>
					<c:out value='${childHealthExamination.rEyecorrection}'></c:out>
				</td>
			</tr>
			<tr>
				<th>左眼裸眼远视力值</th>
				<td>
					<c:out value='${childHealthExamination.lNakedEye}'></c:out>
				</td>
				<th>右眼裸眼远视力值</th>
				<td>
					<c:out value='${childHealthExamination.rNakedeye}'></c:out>
				</td>
			</tr>
			<tr>
				<th>耳外观检查异常</th>
				<td>
                    <c:if test="${!empty childHealthExamination.earappearanceSign}">
					    <c:out value='${childHealthExamination.earappearanceSign eq "1" ? "未见异常" : "有异常"}'></c:out>
                    </c:if>
				</td>
				<th>新生儿听力筛查结果</th>
				<td>
					<ehr:dic code="${childHealthExamination.hearingScreeningResults}" dicmeta="FS10025"></ehr:dic>
				</td>
			</tr>
			<tr>
				<th>左侧听力检测结果</th>
				<td>
					<c:out value="${childHealthExamination.lHearDetectResult}"></c:out>
				</td>
				<th>右侧听力检测结果</th>
				<td>
					<c:out value="${childHealthExamination.rHearDetectResult}"></c:out>
				</td>
			</tr>
			<tr>
				<th>口腔检查异常</th>
				<td colspan="3">
                    <c:if test="${!empty childHealthExamination.oralExamination}">
					    <c:out value='${childHealthExamination.oralExamination eq "1" ? "未见异常" : "有异常"}'></c:out>
                    </c:if>
				</td>
			</tr>
			<tr>
				<th>出牙数(颗)</th>
				<td>
					<c:out value="${childHealthExamination.teethNumber}"></c:out>
				</td>
				<th>龋齿数(颗)</th>
				<td>
					<c:out value="${childHealthExamination.decayedToothNumber}"></c:out>
				</td>
			</tr>
			<tr>
				<th>肺部听诊异常</th>
				<td colspan="3">
                    <c:if test="${!empty childHealthExamination.lungauscu}">
					    <c:out value='${childHealthExamination.lungauscu eq "1" ? "未见异常" : "有异常"}'></c:out>
                    </c:if>
				</td>
			</tr>
			<tr>
				<th>肺部听诊结果</th>
				<td>
					<c:out value="${childHealthExamination.lungAuscuResult}"></c:out>
				</td>
				<th>腹部触诊异常</th>
				<td>
                    <c:if test="${!empty childHealthExamination.abdominalPalp}">
					    <c:out value='${childHealthExamination.abdominalPalp eq "1" ? "未见异常" : "有异常"}'></c:out>
                    </c:if>
				</td>
			</tr>
			<tr>
				<th>脐带脱落</th>
				<td>
                    <c:if test="${!empty childHealthExamination.umbilicalCordSeparation}">
					    <c:out value='${childHealthExamination.umbilicalCordSeparation eq "0" ? "否" : "是" }'></c:out>
                    </c:if>
				</td>
				<th>脐带检查结果</th>
				<td>
					<%--<c:out value="${childHealthExamination.umbilicalCordCheck}" ></c:out>--%>
                    <ehr:dic code="${childHealthExamination.umbilicalCordCheck}" dicmeta="CV0410019"></ehr:dic>
				</td>
			</tr>
			<tr>
				<th>四肢活动度异常</th>
				<td>
                    <c:if test="${!empty childHealthExamination.limbActivityAnomalySign}">
					    <c:out value='${childHealthExamination.limbActivityAnomalySign eq "1" ? "未见异常" : "有异常"}'></c:out>
                    </c:if>
				</td>
				<th>四肢检查结果</th>
				<td>
					<c:out value="${childHealthExamination.limbsCheckResult}" ></c:out>
				</td>
			</tr>
			<tr>
				<th>步态异常</th>
				<td colspan="3">
                    <c:if test="${!empty childHealthExamination.abnormalGait}">
					    <c:out value='${childHealthExamination.abnormalGait eq "1" ? "未见异常" : "有异常"}'></c:out>
                    </c:if>
				</td>
			</tr>
			<tr>
				<th>可疑佝偻病体征</th>
				<td>
					<ehr:dic code="${childHealthExamination.suspiciousRicketsSigns}" dicmeta="CV0410022"></ehr:dic>
				</td>
				<th>可疑佝偻病症状</th>
				<td>
					<ehr:dic code="${childHealthExamination.suspiciousRicketsSymptoms}" dicmeta="CV0410021"></ehr:dic>
				</td>
			</tr>
			<tr>
				<th>肛门检查异常</th>
				<td colspan="3">
                    <c:if test="${!empty childHealthExamination.analExamination}">
					    <c:out value='${childHealthExamination.analExamination eq "1" ? "未见异常" : "有异常"}'></c:out>
                    </c:if>
				</td>
			</tr>
			<tr>
				<th>外生殖器检查异常</th>
				<td>
                    <c:if test="${!empty childHealthExamination.genitaliaCheck}">
					    <c:out value='${childHealthExamination.genitaliaCheck eq "1" ? "未见异常" : "有异常"}'></c:out>
                    </c:if>
				</td>
				<th>外生殖器检查结果</th>
				<td>
					<c:out value="${childHealthExamination.extGenitaliaCheckResult}"></c:out>
				</td>
			</tr>
			<tr>
				<th>户外活动时长(h)</th>
				<td colspan="3">
					<c:out value="${childHealthExamination.outdoorDuration}"></c:out>
				</td>
			</tr>
			<tr>
				<th>服用维生素D剂量(IU/d)</th>
				<td>
					<c:out value="${childHealthExamination.takeVitaminD}"></c:out>
				</td>
				<th>服用维生素D名称</th>
				<td>
					<c:out value="${childHealthExamination.takeVitaminDName}"></c:out>
				</td>
			</tr>
			<tr>
				<th>儿童发育评估</th>
				<td>
                    <c:if test="${!empty childHealthExamination.childDevelopmentEvaluation}">
					    <c:out value='${childHealthExamination.childDevelopmentEvaluation eq "0" ? "未通过" : "通过"}'></c:out>
                    </c:if>
				</td>
				<th>体格发育评价</th>
				<td>
					<ehr:dic dicmeta="CV0410020" code="${childHealthExamination.physiqueGrowthEvaluation}"></ehr:dic>
				</td>
			</tr>
			<tr>
				<th>两次随访间患病标志</th>
				<td>
                    <c:if test="${!empty childHealthExamination.followupSick}">
					    <c:out value='${childHealthExamination.followupSick eq "0" ? "否" : "是"}'></c:out>
                    </c:if>
				</td>
				<th>两次随访间患肺炎住院次数</th>
				<td>
					<c:out value="${childHealthExamination.pneumoniaHospitalizations}"></c:out>
				</td>
			</tr>
			<tr>
				<th>两次随访间患腹泻住院次数</th>
				<td>
					<c:out value="${childHealthExamination.diarrheaHospitalizations}"></c:out>
				</td>
				<th>两次随访间因外伤住院次数</th>
				<td>
					<c:out value="${childHealthExamination.traumaHospitalizations}"></c:out>
				</td>
			</tr>
			<tr>
				<th>两次随访间患其他疾病情况</th>
				<td colspan="3">
					<c:out value="${childHealthExamination.otherDiseaseState}"></c:out>
				</td>
			</tr>
			<tr>
				<th>是否转诊</th>
				<td <c:if test='${childHealthExamination.referralFlag eq "0"}'> colspan="3" </c:if>>
                    <c:if test="${!empty childHealthExamination.referralFlag}">
					    <c:out value='${childHealthExamination.referralFlag eq "1" ? "是" : "否"}'></c:out>
                    </c:if>
				</td>
				<c:if test='${childHealthExamination.referralFlag eq "1"}'>
					<th>转入机构科室名称</th>
					<td>
						<c:out value="${childHealthExamination.referralDeptName}"></c:out>
						<c:out value="${childHealthExamination.referralHospitalName}"></c:out>
					</td>
				</c:if>
			</tr>
			<c:if test='${childHealthExamination.referralFlag eq "1"}'>
				<tr>
					<th>转诊原因</th>
					<td colspan="3">
						<c:out value="${childHealthExamination.referralReason}"></c:out>
					</td>
				</tr>
			</c:if>
			<tr>
				<th>儿童健康指导类别</th>
				<td colspan="3">
					<ehr:dic code="${childHealthExamination.guidanceCategory}" dicmeta="CV0600217"></ehr:dic>
				</td>
			</tr>
			<tr>
				<th>处理及指导意见</th>
				<td colspan="3">
					<c:out value="${childHealthExamination.mgOpinion}"></c:out>
				</td>
			</tr>
			<tr>
				<th>脐疝标志</th>
				<td>
                    <c:if test="${!empty childHealthExamination.exomphalosSign}">
					    <c:out value='${childHealthExamination.exomphalosSign eq "1" ? "是" : "否"}'></c:out>
                    </c:if>
				</td>
				<th>Apgar评分值(分)</th>
				<td>
					<c:out value="${childHealthExamination.apgarValue}"></c:out>
				</td>
			</tr>
			<tr>
				<th>鼻部检查结果</th>
				<td>
					<c:out value="${childHealthExamination.nasalCheckResult}"></c:out>
				</td>
				<th>扁桃体检查结果</th>
				<td>
					<c:out value="${childHealthExamination.tonsilCheckResult}"></c:out>
				</td>
			</tr>
			<tr>
				<th>儿童神经精神发育筛查结果</th>
				<td colspan="3">
					<c:out value="${childHealthExamination.neuropsychiatricScreenResult}"></c:out>
				</td>
			</tr>
			<tr>
				<th>婴幼儿添加辅食种类</th>
				<td colspan="3">
					<ehr:dic code="${childHealthExamination.complementaryType}" dicmeta="CV0600216"></ehr:dic>
				</td>
			</tr>
			<tr>
				<th>肝脏触诊结果</th>
				<td>
					<c:out value="${childHealthExamination.liverPalpResult}"></c:out>
				</td>
				<th>脊柱检查结果</th>
				<td>
					<c:out value="${childHealthExamination.spineCheckResult}"></c:out>
				</td>
			</tr>
			<tr>
				<th>皮肤毛发检查结果</th>
				<td>
					<c:out value="${childHealthExamination.skinHairCheckResult}"></c:out>
				</td>
				<th>脾脏触诊结果</th>
				<td>
					<c:out value="${childHealthExamination.spleenPalpResult}"></c:out>
				</td>
			</tr>
			<tr>
				<th>浅表淋巴结检查结果</th>
				<td>
					<c:out value="${childHealthExamination.slymphNodeCheckResult}"></c:out>
				</td>
				<th>沙眼标志</th>
				<td>
                    <c:if test="${!empty childHealthExamination.chlamydiaFlag}">
					    <c:out value='${childHealthExamination.chlamydiaFlag eq "1" ? "是" : "否"}'></c:out>
                    </c:if>
				</td>
			</tr>
			<tr>
				<th>体检结果</th>
				<td colspan="3">
					<c:out value="${childHealthExamination.examinationResult}"></c:out>
				</td>
			</tr>
			<tr>
				<th>体征</th>
				<td colspan="3">
					<c:out value="${childHealthExamination.signs}"></c:out>
				</td>
			</tr>
			<tr>
				<th>维生素D/钙剂添加标志</th>
				<td>
                    <c:if test="${!empty childHealthExamination.vdCaAddFlag}">
					    <c:out value='${childHealthExamination.vdCaAddFlag eq "1" ? "是" : "否"}'></c:out>
                    </c:if>
				</td>
				<th>喂养方式类别</th>
				<td>
					<ehr:dic code="${childHealthExamination.feedingType}" dicmeta="FS10026"></ehr:dic>
				</td>
			</tr>
			<tr>
                <th>心脏听诊异常</th>
                <td>
                    <c:if test="${!empty childHealthExamination.cardiacAuscuAnomaly}">
                        <c:out value='${childHealthExamination.cardiacAuscuAnomaly eq "1" ? "未见异常" : "有异常"}'></c:out>
                    </c:if>
                </td>
				<th>心脏听诊结果</th>
				<td>
					<c:out value="${childHealthExamination.cardiacAuscuResult}"></c:out>
				</td>

			</tr>
			<tr>
                <th>咽部检查结果</th>
                <td>
                    <c:out value="${childHealthExamination.pharynxCheckResult}"></c:out>
                </td>
				<th>新生儿疾病筛查结果</th>
				<td>
					<c:out value="${childHealthExamination.neonatalDiseaseScreenResult}"></c:out>
				</td>
			</tr>
			<tr>
				<th>体检机构</th>
				<td>
					<c:out value="${childHealthExamination.checkOrganName}"></c:out>
				</td>
				<th>体检医生</th>
				<td>
					<c:out value="${childHealthExamination.checkName}"></c:out>
				</td>
			</tr>
		</table>
	</div>
</div>