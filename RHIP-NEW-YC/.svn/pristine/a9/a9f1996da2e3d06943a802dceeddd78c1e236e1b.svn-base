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
		<li style="text-align: center; font-size: 25px;">产前随访</li>
	</ul>
	<br/>
	<div class="table-basic">
		<table class="layui-table x-admin-sm-table-list-small">
			<colgroup>
				<col style="width: 20%;"/>
	            <col style="width: 30%;"/>
				<col style="width: 20%;"/>
	            <col style="width: 30%;"/>
			</colgroup>
			<tr>
				<th width="15%">产妇姓名</th>
				<td><c:out value="${prenatalFollowup.name}"></c:out></td>
				<th width="15%">填写日期</th>
				<td><fmt:formatDate value="${prenatalFollowup.inputDate}" pattern="yyyy/MM/dd"/></td>
			</tr>
			<tr>
				<th width="15%">孕周</th>
				<td><c:out value="${prenatalFollowup.gestationalWeeks}"></c:out></td>
				<th width="15%">孕次</th>
				<td><c:out value="${prenatalFollowup.gravidityTimes}"></c:out></td>
			</tr>
			<tr>
				<th width="15%">产次</th>
				<td><c:out value="${prenatalFollowup.productionTimes}"></c:out></td>
				<th width="15%">阴道分娩次数</th>
				<td><c:out value="${prenatalFollowup.vaginaDeliveryTimes}"></c:out></td>
			</tr>
			<tr>
				<th width="15%">剖宫产次数</th>
				<td><c:out value="${prenatalFollowup.cesareanSectionTimes}"></c:out></td>
				<th width="15%">末次月经日期明确标志</th>
				<td>
                    <c:if test="${!empty prenatalFollowup.lastMenstrualDateMark}">
                        <c:out value='${prenatalFollowup.lastMenstrualDateMark eq "1" ? "是" : "否"}'></c:out>
                    </c:if>
                </td>
			</tr>
			<tr>
				<th>末次月经日期</th>
				<td>
					<fmt:formatDate value="${prenatalFollowup.lastMenstrualDate}" pattern="yyyy/MM/dd"/>
				</td>
				<th>预产期</th>
				<td>
					<fmt:formatDate value="${prenatalFollowup.estimatedDueDates}" pattern="yyyy/MM/dd"/>
				</td>
			</tr>
			<tr>
				<th>身高(cm)</th>
				<td >
					<c:out value="${prenatalFollowup.height}"></c:out>
				</td>
				<th>体重(kg)</th>
				<td >
					<c:out value="${prenatalFollowup.bodyWeight}"></c:out>
				</td>
			</tr>
			<tr>
				<th>体质指数</th>
				<td colspan="3">
					<c:out value="${prenatalFollowup.bodyMassIndex}"></c:out>
				</td>
			</tr>
			<tr>
				<th>收缩压(mmHg)</th>
				<td>
					<c:out value="${prenatalFollowup.sbp}"></c:out>
				</td>
				<th>舒张压(mmHg)</th>
				<td>
					<c:out value="${prenatalFollowup.dbp}"></c:out>
				</td>
			</tr>
			<tr>
				<th>主诉</th>
				<td colspan="3">
					<c:out value="${prenatalFollowup.chiefComplaint}"></c:out>
				</td>
			</tr>
			<tr>
				<th>心脏听诊异常</th>
				<td colspan="3">
                    <c:if test="${!empty prenatalFollowup.cardiacAuscuAnomaly}">
                        <c:choose>
                            <c:when test="${prenatalFollowup.cardiacAuscuAnomaly eq '0'}">未见异常</c:when>
                            <c:otherwise>异常 ${prenatalFollowup.cardiacAuscuAnomalyDesc}</c:otherwise>
                        </c:choose>
					    <%--<c:out value='${prenatalFollowup.cardiacAuscuAnomaly eq "0" ? "未见异常" : "异常 ".concat(prenatalFollowup.cardiacAuscuAnomalyDesc)}'></c:out>--%>
                    </c:if>
				</td>
			</tr>
			<tr>
				<th>肺部听诊异常</th>
				<td colspan="3">
                    <c:if test="${!empty prenatalFollowup.lungAuscuAnomaly}">
                        <c:choose>
                            <c:when test="${prenatalFollowup.lungAuscuAnomaly eq '0'}">未见异常</c:when>
                            <c:otherwise>异常 ${prenatalFollowup.lungAuscuAnomalyDesc}</c:otherwise>
                        </c:choose>
					    <%--<c:out value='${prenatalFollowup.lungAuscuAnomaly eq "0" ? "未见异常" : "异常 ".concat(prenatalFollowup.lungAuscuAnomalyDesc)}'></c:out>--%>
                    </c:if>
				</td>
			</tr>
			<tr>
				<th>外阴异常</th>
				<td colspan="3">
                    <c:if test="${!empty prenatalFollowup.vulvaAnomaly}">
                        <c:choose>
                            <c:when test="${prenatalFollowup.vulvaAnomaly eq '0'}">未见异常</c:when>
                            <c:otherwise>异常 ${prenatalFollowup.vulvaAnomalyDesc}</c:otherwise>
                        </c:choose>
					    <%--<c:out value='${prenatalFollowup.vulvaAnomaly eq "0" ? "未见异常" : "异常 ".concat(prenatalFollowup.vulvaAnomalyDesc)}'></c:out>--%>
                    </c:if>
				</td>
			</tr>
			<tr>
				<th>阴道异常</th>
				<td colspan="3">
                    <c:if test="${!empty prenatalFollowup.vaginaAbnormal}">
                        <c:choose>
                            <c:when test="${prenatalFollowup.vaginaAbnormal eq '0'}">未见异常</c:when>
                            <c:otherwise>异常 ${prenatalFollowup.vaginaAbnormalDesc}</c:otherwise>
                        </c:choose>
					    <%--<c:out value='${prenatalFollowup.vaginaAbnormal eq "0" ? "未见异常" : "异常 ".concat(prenatalFollowup.vaginaAbnormalDesc)}'></c:out>--%>
                    </c:if>
				</td>
			</tr>
			<tr>
				<th>宫颈异常</th>
				<td colspan="3">
                    <c:if test="${!empty prenatalFollowup.abnormalCervical}">
                        <c:choose>
                            <c:when test="${prenatalFollowup.abnormalCervical eq '0'}">未见异常</c:when>
                            <c:otherwise>异常 ${prenatalFollowup.abnormalCervicalDesc}</c:otherwise>
                        </c:choose>
					    <%--<c:out value='${prenatalFollowup.abnormalCervical eq "0" ? "未见异常" : "异常 ".concat(prenatalFollowup.abnormalCervicalDesc)}'></c:out>--%>
                    </c:if>
				</td>
			</tr>
			<tr>
				<th>宫体异常</th>
				<td colspan="3">
                    <c:if test="${!empty prenatalFollowup.corpusAnomaly}">
                        <c:choose>
                            <c:when test="${prenatalFollowup.corpusAnomaly eq '0'}">未见异常</c:when>
                            <c:otherwise>异常 ${prenatalFollowup.corpusAnomalyDesc}</c:otherwise>
                        </c:choose>
					    <%--<c:out value='${prenatalFollowup.corpusAnomaly eq "0" ? "未见异常" : "异常 ".concat(prenatalFollowup.corpusAnomalyDesc)}'></c:out>--%>
                    </c:if>
				</td>
			</tr>
			<tr>
				<th>附件异常</th>
				<td colspan="3">
                    <c:if test="${!empty prenatalFollowup.accessoriesAnomaly}">
                        <c:choose>
                            <c:when test="${prenatalFollowup.accessoriesAnomaly eq '0'}">未见异常</c:when>
                            <c:otherwise>异常 ${prenatalFollowup.accessoriesAnomalyDesc}</c:otherwise>
                        </c:choose>
					    <%--<c:out value='${prenatalFollowup.accessoriesAnomaly eq "0" ? "未见异常" : "异常 ".concat(prenatalFollowup.accessoriesAnomalyDesc)}'></c:out>--%>
                    </c:if>
				</td>
			</tr>
			<tr>
				<th>宫底高度(cm)</th>
				<td>
					<c:out value="${prenatalFollowup.uterineBottomHeight}"></c:out>
				</td>
				<th>腹围(cm)</th>
				<td>
					<c:out value="${prenatalFollowup.abdominalGirth}"></c:out>
				</td>
			</tr>
			<tr>
				<th>胎方位</th>
				<td>
					<ehr:dic dicmeta="CV0501007" code="${prenatalFollowup.fetalPosition}"></ehr:dic>
				</td>
				<th>胎心率(次/min)</th>
				<td>
					<c:out value="${prenatalFollowup.fetalHeartRate}"></c:out>
				</td>
			</tr>
			<tr>
				<th>血红蛋白值(g/L)</th>
				<td>
					<c:out value="${prenatalFollowup.hemoglobinValue}"></c:out>
				</td>
				<th>白细胞计数值(G/L)</th>
				<td>
					<c:out value="${prenatalFollowup.leukocyteCount}"></c:out>
				</td>
			</tr>
			<tr>
				<th>血小板计数值(G/L)</th>
				<td>
					<c:out value="${prenatalFollowup.plateletCount}"></c:out>
				</td>
				<th>血常规其他</th>
				<td>
					<c:out value="${prenatalFollowup.otherBloodRoutine}"></c:out>
				</td>
			</tr>
			<tr>
				<th>尿蛋白定量检测值(mg/24h)</th>
				<td>
					<c:out value="${prenatalFollowup.urineProQuantitativeValue}"></c:out>
				</td>
				<th>尿蛋白定性检测结果</th>
				<td>
					<c:out value="${prenatalFollowup.urineProQualitativeResult}"></c:out>
				</td>
			</tr>
			<tr>
				<th>尿糖定性检测结果</th>
				<td>
					<c:out value="${prenatalFollowup.urineSugQualitativeResult}"></c:out>
				</td>
				<th>尿糖定量检测(mmol/L)</th>
				<td>
					<c:out value="${prenatalFollowup.urineSugQuantitativeDetect}"></c:out>
				</td>
			</tr>
			<tr>
				<th>尿酮体定性检测结果</th>
				<td>
					<c:out value="${prenatalFollowup.ketQualitativeDetection}"></c:out>
				</td>
				<th>尿潜血检测结果</th>
				<td>
					<c:out value="${prenatalFollowup.eryDetection}"></c:out>
				</td>
			</tr>
			<tr>
				<th>尿常规其他</th>
				<td>
					<c:out value="${prenatalFollowup.otherUrineRoutines}"></c:out>
				</td>
				<th>其他辅助检查</th>
				<td>
					<c:out value="${prenatalFollowup.otherAuxiliaryExamination}"></c:out>
				</td>
			</tr>
			<tr>
				<th>血型</th>
				<td>
					<ehr:dic dicmeta="CV0450005" code="${prenatalFollowup.aboBloodType}"></ehr:dic>
				</td>
				<th>Rh血型</th>
				<td>
					<ehr:dic dicmeta="FS10010" code="${prenatalFollowup.rhBloodType}"></ehr:dic>
				</td>
			</tr>
			<tr>
				<th>丈夫血型</th>
				<td>
					<ehr:dic dicmeta="CV0450005" code="${prenatalFollowup.husbandABOBloodType}"></ehr:dic>
				</td>
				<th>丈夫Rh血型</th>
				<td>
					<ehr:dic dicmeta="FS10010" code="${prenatalFollowup.husbandRhBloodType}"></ehr:dic>
				</td>
			</tr>
			<tr>
				<th>血糖检测值(mmol/L)</th>
				<td>
					<c:out value="${prenatalFollowup.bloodGlucoseValues}"></c:out>
				</td>
				<th>血清谷丙转氨酶值(U/L)</th>
				<td>
					<c:out value="${prenatalFollowup.serumGptValue}"></c:out>
				</td>
			</tr>
			<tr>
				<th>血清谷草转氨酶值(U/L)</th>
				<td>
					<c:out value="${prenatalFollowup.serumAstValue}"></c:out>
				</td>
				<th>白蛋白浓度(g/L)</th>
				<td>
					<c:out value="${prenatalFollowup.albuminConcentration}"></c:out>
				</td>
			</tr>
			<tr>
				<th>总胆红素值(umol/L)</th>
				<td>
					<c:out value="${prenatalFollowup.totalBilirubin}"></c:out>
				</td>
				<th>结合胆红素值(μmol/L)</th>
				<td>
					<c:out value="${prenatalFollowup.conjugatedBilirubin}"></c:out>
				</td>
			</tr>
			<tr>
				<th>血尿素氮检测值(mmol/L)</th>
				<td>
					<c:out value="${prenatalFollowup.bloodUreaNitrogenValues}"></c:out>
				</td>
				<th>血肌酐值(μmol/L)</th>
				<td>
					<c:out value="${prenatalFollowup.creatinine}"></c:out>
				</td>
			</tr>
			<tr>
				<th>阴道分泌物检查结果</th>
				<td>
					<ehr:dic code="${prenatalFollowup.vaginaSecretionsCheckResult}" dicmeta="CV0450019"></ehr:dic>
				</td>
				<th>阴道分泌物清洁度</th>
				<td>
					<ehr:dic code="${prenatalFollowup.vaginaSecretionsCleanliness}" dicmeta="CV0450010"></ehr:dic>
				</td>
			</tr>
			<tr>
				<th>乙型肝炎病毒e抗体检测结果</th>
				<td>
					<ehr:dic code="${prenatalFollowup.hbeDetectResult}" dicmeta="FS10089"></ehr:dic>
				</td>
				<th>乙型肝炎病毒e抗原检测结果</th>
				<td>
					<ehr:dic code="${prenatalFollowup.hbeagDetectResult}" dicmeta="FS10090"></ehr:dic>
				</td>
			</tr>
			<tr>
				<th>乙型肝炎病毒表面抗体检测结果</th>
				<td>
					<ehr:dic code="${prenatalFollowup.hbsDetectResult}" dicmeta="FS10091"></ehr:dic>
				</td>
				<th>乙型肝炎病毒表面抗原检测结果</th>
				<td>
					<ehr:dic code="${prenatalFollowup.hbsagDetectResult}" dicmeta="FS10092"></ehr:dic>
				</td>
			</tr>
			<tr>
				<th>乙型肝炎病毒核心抗体检测结果</th>
				<td>
					<ehr:dic code="${prenatalFollowup.hbcabDetectResult}" dicmeta="FS10093"></ehr:dic>
				</td>
				<th>梅毒血清学试验结果</th>
				<td>
					<ehr:dic code="${prenatalFollowup.syphilisSerologyCheckResult}" dicmeta="FS10058"></ehr:dic>	
				</td>
			</tr>
			<tr>
				<th>HIV抗体检测结果</th>
				<td>
					<c:out value="${prenatalFollowup.hivlgDetectResult}"></c:out>
				</td>
				<th>B超检查结果</th>
				<td>
					<ehr:dic code="${prenatalFollowup.bmodeCheckResult}" dicmeta="FS10133"></ehr:dic>	
				</td>
			</tr>
			<tr>
				<th>孕产妇健康评估异常${prenatalFollowup.assessmentAnomalySign}</th>
				<td>
                    <c:if test="${!empty prenatalFollowup.assessmentAnomalySign}">
                        <c:choose>
                            <c:when test="${prenatalFollowup.assessmentAnomalySign eq '0'}">未见异常</c:when>
                            <c:otherwise>异常 ${prenatalFollowup.healthAbnormalDesc}</c:otherwise>
                        </c:choose>
					    <%--<c:out value='${prenatalFollowup.assessmentAnomalySign eq "0" ? "未见异常" : "异常 ".concat(prenatalFollowup.healthAbnormalDesc)}'></c:out>--%>
                    </c:if>
				</td>
				<th>是否转诊</th>
				<td>
                    <c:if test="${!empty prenatalFollowup.referralFlag}">
					    <c:out value='${prenatalFollowup.referralFlag eq "1" ? "是" : "否"}'></c:out>
                    </c:if>
				</td>
			</tr>
			<c:if test='${prenatalFollowup.referralFlag eq "1"}'>
				<tr>
					<th>机构及科室</th>
					<td>
						<c:out value="${prenatalFollowup.referralHospitalName}"></c:out>
						<c:out value="${prenatalFollowup.referralDeptName}"></c:out>					
					</td>
					<th>转诊原因</th>
					<td>
						<c:out value="${prenatalFollowup.referralReason}"></c:out>
					</td>
				</tr>
			</c:if>
			<tr>
				<th>孕产妇健康指导</th>
				<td colspan="3">
					<ehr:dic dicmeta="CV0600219" code="${prenatalFollowup.healthGuidanceClass}"></ehr:dic>
				</td>
			</tr>
			<tr>
				<th width="15%">访视医师</th>
				<td><c:out value="${prenatalFollowup.supervisionDoctor}"></c:out></td>
				<th width="15%">访视日期</th>
				<td><fmt:formatDate value="${prenatalFollowup.visitDate}" pattern="yyyy/MM/dd"/></td>
			</tr>
			<tr>
				<th width="15%">下次访视日期</th>
				<td><fmt:formatDate value="${prenatalFollowup.nextSupervisionDate}" pattern="yyyy/MM/dd"/></td>
				<th width="15%">下次访视地点</th>
				<td><c:out value="${prenatalFollowup.nextSupervisionPlace}"></c:out></td>
			</tr>
		</table>
	</div>
</div>