<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>

<link rel="stylesheet" href="${pageContext.request.contextPath}/css/views/ehrbrowser/basic/basic.css" />
<script src="${pageContext.request.contextPath}/js/views/woman/prenatalFollowupFirst/view.js" type="text/javascript"></script>

<c:if test="${isShowBackBtn}">
	<div class="toolbar">
		<a href="javascript:void(0)" id="pFPBackViewId"><button class="btn-gray layui-btn layui-btn-sm button"><i class="layui-icon"></i>返回</button></a>
	</div>
</c:if>
<div >
	<ul>
		<li style="text-align: center; font-size: 25px;">第1次产前随访服务记录表</li>
	</ul>
	<br/>
	<form id="pFPAddFromId">
	<div class="table-basic" style="overflow:inherit">
		<table style="border-bottom: solid 1px;">
			<colgroup>
				<col style="width: 15%;"/>
	            <col style="width: 30%;"/>
				<col style="width: 15%;"/>
	            <col style="width: 30%;"/>
			</colgroup>
			<tr>
				<th colspan="3" align="right">健康档案编号：</th>
				<td>
					${prenatalFollowup.healthFileNo}
				</td>
			</tr>
			<tr>
				<th>随访日期</th>
				<td><fmt:formatDate value="${prenatalFollowup.visitDate}" pattern="yyyy/MM/dd"/></td>
				<th>填表孕周</th>
				<td>
					${prenatalFollowup.gestationalWeeks}周
				</td>
			</tr>
			<tr>
				<th>孕妇姓名</th>
				<td>${prenatalFollowup.name}</td>
				<th>孕妇年龄</th>
				<td>
					${prenatalFollowup.age}岁
				</td>
			</tr>
			<tr>
				<th>身份证号</th>
				<td>
					${prenatalFollowup.idCard}
				</td>
				<th>丈夫姓名</th>
				<td>${prenatalFollowup.husbandName}</td>
			</tr>
			<tr>
				<th>丈夫年龄</th>
				<td>${prenatalFollowup.husbandAge}岁</td>
				<th>丈夫电话</th>
				<td>${prenatalFollowup.husbandPhone}</td>
			</tr>
			<tr>
				<th>孕次</th>
				<td>${prenatalFollowup.gravidityTimes}</td>
				<th>产次</th>
				<td>${prenatalFollowup.productionTimes}</td>
			</tr>
			<tr>
				<th>阴道分娩次数</th>
				<td>${prenatalFollowup.vaginaDeliveryTimes}</td>
				<th>剖宫产次数</th>
				<td>${prenatalFollowup.cesareanSectionTimes}</td>
			</tr>
			<tr>
				<th>末次月经日期明确标志</th>
				<td>
					<ehr:dic code="${prenatalFollowup.lastMenstrualDateMark}" dicmeta="FS10281"/>
					<c:if test="${prenatalFollowup.lastMenstrualDateMark eq '2'}">
						<fmt:formatDate value="${prenatalFollowup.lastMenstrualDate}" pattern="yyyy/MM/dd"/>
					</c:if>
				</td>
				<th>预产期</th>
				<td>
					<fmt:formatDate value="${prenatalFollowup.estimatedDueDates}" pattern="yyyy/MM/dd"/>
				</td>
			</tr>
			<tr>
				<th>既往史</th>
				<td colspan="3">
					<c:if test="${prenatalFollowup.pastMedicalHistorySign eq '1'}">
						无
					</c:if>
					<c:if test="${prenatalFollowup.pastMedicalHistorySign eq '2'}">
						<ehr:dic code="${prenatalFollowup.pastMedicalHistory}" dicmeta="CV0210005"/>
						<c:if test="${fn:contains(prenatalFollowup.pastMedicalHistory,'99')}">
							${prenatalFollowup.pastMedicalHistoryDesc}
						</c:if>
					</c:if>
				</td>
			</tr>
			<tr>
				<th>家族史</th>
				<td colspan="3">
					<ehr:dic code="${prenatalFollowup.familyDiseaseHistorySign}" dicmeta="FS10111"/>
					<c:if test="${prenatalFollowup.familyDiseaseHistorySign eq '2'}">
						<ehr:dic code="${prenatalFollowup.familyDiseaseHistory}" dicmeta="FS10019"/>
						<c:if test="${fn:contains(prenatalFollowup.pastMedicalHistory,'9')}">
							${prenatalFollowup.familyDiseaseHistoryDesc}
						</c:if>
					</c:if>
				</td>
			</tr>
			<tr>
				<th>个人史</th>
				<td colspan="3">
					<ehr:dic code="${prenatalFollowup.personalHistorySign}" dicmeta="FN10000"/>
					<c:if test="${prenatalFollowup.personalHistorySign eq '2'}">
						：<ehr:dic code="${prenatalFollowup.personalHistory}" dicmeta="CV0300116"/>
						<c:if test="${fn:contains(prenatalFollowup.personalHistory,'9')}">
							${prenatalFollowup.personalHistoryDesc}
						</c:if>
					</c:if>
				</td>
			</tr>
			<tr>
				<th>妇科手术史</th>
				<td colspan="3">
					<ehr:dic code="${prenatalFollowup.womanSurgeryHistorySign}" dicmeta="FS10111"/>
					<c:if test="${prenatalFollowup.womanSurgeryHistorySign eq '2'}">
						${prenatalFollowup.womanSurgeryHistory}
					</c:if>
				</td>
			</tr>
			<tr>
				<th>孕产史</th>
				<td colspan="3">
					1.自然流产${prenatalFollowup.abortionTimes}
					2.人工流产${prenatalFollowup.artificialAbortionNum}
					3.死胎${prenatalFollowup.stillbornCasesNumber}
					4.死产${prenatalFollowup.stillbirthCasesNumber}
					5.新生儿死亡${prenatalFollowup.neonatalDeathNumber}
					6.出生缺陷儿${prenatalFollowup.birthDefectsNumber}
				</td>
			</tr>
			<tr>
				<th>身高</th>
				<td >
					${prenatalFollowup.height}cm
				</td>
				<th>体重</th>
				<td >${prenatalFollowup.bodyWeight}kg
				</td>
			</tr>
			<tr>
				<th>体质指数</th>
				<td>
					${prenatalFollowup.bodyMassIndex}
				</td>
				<th>血压</th>
				<td>
					${prenatalFollowup.sbp}/${prenatalFollowup.dbp}mmHg
				</td>
			</tr>
			<tr>
				<th>心脏听诊异常</th>
				<td>
					<ehr:dic code="${prenatalFollowup.cardiacAuscuAnomaly}" dicmeta="FS10046"/>
					<c:if test="${prenatalFollowup.cardiacAuscuAnomaly eq '2'}">
						${prenatalFollowup.cardiacAuscuAnomalyDesc}
					</c:if>
				</td>
				<th>肺部听诊异常</th>
				<td>
					<ehr:dic code="${prenatalFollowup.lungAuscuAnomaly}" dicmeta="FS10046"/>
					<c:if test="${prenatalFollowup.lungAuscuAnomaly eq '2'}">
						${prenatalFollowup.lungAuscuAnomalyDesc}
					</c:if>
				</td>
			</tr>
			<tr>
				<th>外阴</th>
				<td>
					<ehr:dic code="${prenatalFollowup.vulvaAnomaly}" dicmeta="FS10046"/>
					<c:if test="${prenatalFollowup.vulvaAnomaly eq '2'}">
						${prenatalFollowup.vulvaAnomalyDesc}
					</c:if>
				</td>
				<th>阴道</th>
				<td>
					<ehr:dic code="${prenatalFollowup.vaginaAbnormal}" dicmeta="FS10046"/>
					<c:if test="${prenatalFollowup.vaginaAbnormal eq '2'}">
						${prenatalFollowup.vaginaAbnormalDesc}
					</c:if>
				</td>
			</tr>
			<tr>
				<th>宫颈</th>
				<td>
					<ehr:dic code="${prenatalFollowup.abnormalCervical}" dicmeta="FS10046"/>
					<c:if test="${prenatalFollowup.abnormalCervical eq '2'}">
						${prenatalFollowup.abnormalCervicalDesc}
					</c:if>
				</td>
				<th>宫体</th>
				<td>
					<ehr:dic code="${prenatalFollowup.corpusAnomaly}" dicmeta="FS10046"/>
					<c:if test="${prenatalFollowup.corpusAnomaly eq '2'}">
						${prenatalFollowup.corpusAnomalyDesc}
					</c:if>
				</td>
			</tr>
			<tr>
				<th>附件</th>
				<td colspan="3">
					<ehr:dic code="${prenatalFollowup.accessoriesAnomaly}" dicmeta="FS10046"/>
					<c:if test="${prenatalFollowup.accessoriesAnomaly eq '2'}">
						${prenatalFollowup.accessoriesAnomalyDesc}
					</c:if>
				</td>
			</tr>
			<tr>
				<%--<th rowspan="10">辅助检查</th>--%>
				<th>血常规</th>
				<td colspan="3">
					血红蛋白值:${prenatalFollowup.hemoglobinValue}g/L
					&nbsp;&nbsp;&nbsp;&nbsp;
					白细胞计数值:${prenatalFollowup.leukocyteCount}×10<sup>9</sup>/L
					&nbsp;&nbsp;&nbsp;&nbsp;
					血小板计数值:${prenatalFollowup.plateletCount}×10<sup>9</sup>/L
					<br>
					其它:
					${prenatalFollowup.otherBloodRoutine}
				</td>
			</tr>
			<tr>
				<th>尿常规</th>
				<td colspan="3">
					尿蛋白:<ehr:dic code="${prenatalFollowup.urineProQualitativeResult}" dicmeta="CV0450015"/>
					&nbsp;&nbsp;&nbsp;&nbsp;
					尿糖:<ehr:dic code="${prenatalFollowup.urineSugQualitativeResult}" dicmeta="CV0450015"/>
					&nbsp;&nbsp;&nbsp;&nbsp;
					尿酮体:<ehr:dic code="${prenatalFollowup.ketQualitativeDetection}" dicmeta="CV0450015"/>
					&nbsp;&nbsp;&nbsp;&nbsp;
					尿潜血:<ehr:dic code="${prenatalFollowup.eryDetection}" dicmeta="CV0450015"/>
					&nbsp;&nbsp;&nbsp;&nbsp;
					其它:${prenatalFollowup.otherUrineRoutines}
				</td>
			</tr>
			<tr>
				<th>血型</th>
				<td>
					<ehr:dic code="${prenatalFollowup.aboBloodType}" dicmeta="CV0450005"/>
				</td>
				<td>Rh血型</td>
				<td>
					<ehr:dic code="${prenatalFollowup.rhBloodType}" dicmeta="FS10010"/>
				</td>
			</tr>
			<tr>
				<th>空腹血糖</th>
				<td colspan="3">${prenatalFollowup.bloodGlucoseValues}mmol/L</td>
			</tr>
			<tr>
				<th>肝功能</th>
				<td colspan="3">
					血清谷丙转氨酶:${prenatalFollowup.serumGptValue}U/L
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					血清谷草转氨酶:${prenatalFollowup.serumAstValue}U/L
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					白蛋白:${prenatalFollowup.albuminConcentration}g/L
					<br>
					总胆红素:${prenatalFollowup.totalBilirubin}μmol/L
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					结合胆红素:${prenatalFollowup.conjugatedBilirubin}μmol/L
				</td>
			</tr>
			<tr>
				<th>肾功能</th>
				<td colspan="3">
					血清肌酐:${prenatalFollowup.creatinine}μmol/L
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					血尿素氮:${prenatalFollowup.bloodUreaNitrogenValues}mmol/L
				</td>
			</tr>
			<tr>
				<th>阴道分泌物</th>
				<td>
					<ehr:dic code="${prenatalFollowup.vaginaSecretionsCheckResult}" dicmeta="CV0450019"/>
					<c:if test="${prenatalFollowup.vaginaSecretionsCheckResult eq '9'}">
						${prenatalFollowup.accessoriesAnomalyDesc}
					</c:if>
				</td>
				<th>阴道分泌物清洁度</th>
				<td>
					<ehr:dic code="${prenatalFollowup.vaginaSecretionsCleanliness}" dicmeta="CV0450010"/>
				</td>
			</tr>
			<tr>
				<th>乙型肝炎表面抗原</th>
				<td>
					<ehr:dic code="${prenatalFollowup.hbsagDetectResult}" dicmeta="FS10058"/>
				</td>
				<th>乙型肝炎表面抗体</th>
				<td>
					<ehr:dic code="${prenatalFollowup.hbsDetectResult}" dicmeta="FS10058"/>
				</td>
			</tr>
			<tr>
				<th>乙型肝炎e抗原</th>
				<td>
					<ehr:dic code="${prenatalFollowup.hbeagDetectResult}" dicmeta="FS10058"/>
				</td>
				<th>乙型肝炎e抗体</th>
				<td>
					<ehr:dic code="${prenatalFollowup.hbeDetectResult}" dicmeta="FS10058"/>
				</td>
			</tr>
			<tr>
				<th>梅毒血清学试验结果</th>
				<td>
					<ehr:dic code="${prenatalFollowup.syphilisSerologyCheckResult}" dicmeta="FS10058"/>
				</td>
				<th>HIV抗体检测</th>
				<td>
					<ehr:dic code="${prenatalFollowup.hivlgDetectResult}" dicmeta="FS10058"/>
				</td>
			</tr>
			<tr>
				<th>B超</th>
				<td colspan="3">${prenatalFollowup.bmodeCheckResult}</td>
			</tr>
			<tr>
				<th>总体评估</th>
				<td>
					<ehr:dic code="${prenatalFollowup.assessmentAnomalySign}" dicmeta="FS10046"/>
					<c:if test="${prenatalFollowup.assessmentAnomalySign eq '2'}">
						${prenatalFollowup.healthAbnormalDesc}
					</c:if>
				</td>
				<th>是否转诊</th>
				<td>
					<ehr:dic code="${prenatalFollowup.referralFlag}" dicmeta="FY0001"/>
				</td>
			</tr>
			<c:if test="${prenatalFollowup.referralFlag eq '1'}">
				<tr id="referralFlagId">
					<th>机构及科室</th>
					<td>
						${prenatalFollowup.referralHospitalName}
						${prenatalFollowup.referralDeptName}
					</td>
					<th>转诊原因</th>
					<td>
						${prenatalFollowup.referralReason}
					</td>
				</tr>
			</c:if>
			<tr>
				<th>保健指导</th>
				<td colspan="3">
					<ehr:dic code="${prenatalFollowup.healthGuidanceClass}" dicmeta="CV0600219"/>
					<c:if test="${fn:contains(prenatalFollowup.healthGuidanceClass,'99')}">
						${prenatalFollowup.healthGuidanceClassDesc}
					</c:if>
				</td>
			</tr>
			<tr>
				<th>中医药健康管理服务</th>
				<td colspan="3">
					<ehr:dic code="${prenatalFollowup.cmHealthManage}" dicmeta="FS10307"/>
					<c:if test="${fn:contains(prenatalFollowup.cmHealthManage,'99')}">
						${prenatalFollowup.cmHealthManageDesc}
					</c:if>
				</td>
			</tr>
			<tr>
				<th>下次随访日期</th>
				<td><fmt:formatDate value="${prenatalFollowup.nextSupervisionDate}" pattern="yyyy/MM/dd"/></td>
				<th>随访医生</th>
				<td>
					<ehr:staff-name staffCode="${prenatalFollowup.supervisionDoctor}"/>
				</td>
			</tr>
		</table>
	</div>
	</form>
</div>