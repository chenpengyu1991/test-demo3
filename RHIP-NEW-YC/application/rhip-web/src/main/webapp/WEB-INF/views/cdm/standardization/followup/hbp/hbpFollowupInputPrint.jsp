<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>

<style>
	#hbpPrintFollowUp .table-01{width:100%;height:100%; overflow:auto;clear:both;vertical-align:middle;}
	#hbpPrintFollowUp .table-01{background:#FFF}
	#hbpPrintFollowUp .table-01 table{width:100%; border-left:#C8BAAE solid 1px;border-top:#C8BAAE solid 1px;border-collapse:collapse;}
	#hbpPrintFollowUp .table-01 td{text-align:left;height:24px;line-height:24px;border:1px solid #ccc;padding:2px;}
	#hbpPrintFollowUp .table-01 th{border:1px solid #CCC;background:#EFF7FF;font-weight:normal;}
	#hbpPrintFollowUp .table-01 td.td_gray{background:#EEE;}
	#hbpPrintFollowUp .table-01 td.h_top{background:#66B9DB; font-weight:bold;text-align:center;color:#FFF;}
</style>

<div id="hbpPrintFollowUp" style="display: none">
	<h3 align="center">高血压患者随访服务记录表</h3>
	<span style="float:left;margin-top: 5px;"><b>姓名:</b>${personInfo.name}</span>
	<span style="float:right;margin-top: 5px"><b>身份证号:</b>${personInfo.idcard}</span>
	<table border="1" cellpadding="0" cellspacing="0" style="clear:both; width: 100%" class="table-01">
		<colgroup>
			<col style="width: 25%;" />
			<col style="width: 25%;" />



			<col style="width: 25%;" />
			<col style="width: 25%;" />
		</colgroup>
		<tr>
			<th colspan="2">随访日期</th>
			<td colspan="2"><fmt:formatDate value="${hbp.visitDate}" pattern="yyyy年MM月dd日"/></td>
		</tr>
		<tr>
			<th colspan="2">随访方式</th>
			<td colspan="2"><ehr:dic dicmeta="DMD00026" code="${hbp.visitWayCode}" /></td>
		</tr>
		<tr>
			<th colspan="2">症状</th>
			<td colspan="2">
				<c:choose>
					<c:when test="${hbp.curSymptomFlag ne '2'}">
						无症状
					</c:when>
					<c:otherwise>
						<c:forEach items="${ fn:split(hbp.curSymptom, ',') }" var="curSymptom" varStatus="stats">
							<c:choose>
								<c:when test="${curSymptom eq '10'}">
									${hbp.otherSymptom}
								</c:when>
								<c:otherwise>
									<ehr:dic dicmeta="DMD00038" code="${curSymptom}"/>
								</c:otherwise>
							</c:choose>
							<c:if test="${!stats.last}">,</c:if>
						</c:forEach>
					</c:otherwise>
				</c:choose>
			</td>
		</tr>
		<tr>
			<th rowspan="6">体征</th>
			<th>血压（mmHg）</th>
			<td colspan="2">${hbp.sbp} / ${hbp.dbp} mmHg</td>
		</tr>
		<tr>
			<th>身高（cm）</th>
			<td colspan="2">${hbp.height} cm</td>
		</tr>
		<tr>
			<th>体重（kg）</th>
			<td colspan="2">${hbp.bodyWeight} / ${hbp.nextFollowupBodyWeight} kg</td>
		</tr>
		<tr>
			<th>体质指数<br/>（BMI）kg/㎡）</th>
			<td colspan="2">${hbp.indexOfBodyCharacteristics} / ${hbp.nextFollowupBmi} kg/㎡</td>
		</tr>
		<tr>
			<th>心率（次/分钟）</th>
			<td colspan="2">${hbp.heartRate}</td>
		</tr>
		<tr>
			<th>其他</th>
			<td colspan="2">${hbp.signOther}</td>
		</tr>
		<tr>
			<th rowspan="6">生活方式指导</th>
			<th>日吸烟量（支）</th>
			<td colspan="2">${hbp.dailyDailySmokeber} / ${hbp.smokeberTarget}</td>
		</tr>
		<tr>
			<th>日饮酒量（两）</th>
			<td colspan="2">${hbp.dailyDrink} / ${hbp.nextFollowupDailyDrink}</td>
		</tr>
		<tr>
			<th>运动</th>
			<td colspan="2">
				<u>${hbp.trainFrequency} 次/周&nbsp;&nbsp;&nbsp;&nbsp;${hbp.trainingMin} 分钟/次</u><br/>
				${hbp.nextExerciseFrequency} 次/周&nbsp;&nbsp;&nbsp;&nbsp;${hbp.nextExerciseTime} 分钟/次
			</td>
		</tr>
		<tr>
			<th>摄盐情况（咸淡）</th>
			<td colspan="2">
				<ehr:dic dicmeta="DMD00063" code="${hbp.salinity}"/> / <ehr:dic dicmeta="DMD00063" code="${hbp.nextSalinityTarget}"/>
			</td>
		</tr>
		<tr>
			<th>心理调整</th>
			<td colspan="2"><ehr:dic dicmeta="DMD00039" code="${hbp.mentality}"/></td>
		</tr>
		<tr>
			<th>遵医行为</th>
			<td colspan="2"><ehr:dic dicmeta="DMD00040" code="${hbp.compiance}"/></td>
		</tr>
		<tr>
			<th colspan="2">辅助检查*</th>
			<td colspan="2">${hbp.aeResultDesc}</td>
		</tr>
		<tr>
			<th colspan="2">服药依从性</th>
			<td colspan="2"><ehr:dic dicmeta="DMD00041" code="${hbp.medicationCompliance}"/></td>
		</tr>
		<tr>
			<th colspan="2">药物不良反应</th>
			<td colspan="2">
				<c:choose>
					<c:when test="${hbp.sideEffects ne '2'}">
						无
					</c:when>
					<c:otherwise>
						${hbp.effectsState}
					</c:otherwise>
				</c:choose>
			</td>
		</tr>
		<tr>
			<th colspan="2">此次随访分类</th>
			<td colspan="2"><ehr:dic dicmeta="DMD00042" code="${hbp.visitType}"/></td>
		</tr>
		<c:choose>
			<c:when test="${hbp.medicateHbpFlag ne '1'}">
				<tr>
					<th colspan="2">用药情况</th>
					<td colspan="2">无</td>
				</tr>
			</c:when>
			<c:otherwise>
				<tr>
					<th rowspan="6">用药情况</th>
					<th>药物名称1</th>
					<td colspan="2">${drug.drugNameFirst}</td>
				</tr>
				<tr>
					<th>用法用量</th>
					<td>每日&nbsp;${drug.drugPerdayFirst}&nbsp;次</td>
					<td>每次&nbsp;${drug.drugPertimeFirst}&nbsp;<ehr:dic dicmeta="DMD00067" code="${drug.firstMedicateUnit}"/></td>
				</tr>
				<tr>
					<th>药物名称2</th>
					<td colspan="2">${drug.drugNameSecond}</td>
				</tr>
				<tr>
					<th>用法用量</th>
					<td>每日&nbsp;${drug.drugPerdaySecond}&nbsp;次</td>
					<td>每次&nbsp;${drug.drugPertimeSecond}&nbsp;<ehr:dic dicmeta="DMD00067" code="${drug.secondMedicateUnit}"/></td>
				</tr>
				<tr>
					<th>药物名称3</th>
					<td colspan="2">${drug.drugNameThird}</td>
				</tr>
				<tr>
					<th>用法用量</th>
					<td>每日&nbsp;${drug.drugPerdayThird}&nbsp;次</td>
					<td>每次&nbsp;${drug.drugPertimeThird}&nbsp;<ehr:dic dicmeta="DMD00067" code="${drug.thirdMedicateUnit}"/></td>
				</tr>
				<%--<tr>
					<th>其他药物</th>
					<td colspan="2"></td>
				</tr>
				<tr>
					<th>用法用量</th>
					<td></td>
					<td></td>
				</tr>--%>
			</c:otherwise>
		</c:choose>
		<c:choose>
			<c:when test="${hbp.referralHbpFlag ne '1'}">
				<tr>
					<th colspan="2">转诊</th>
					<td colspan="2">无</td>
				</tr>
			</c:when>
			<c:otherwise>
				<tr>
					<th rowspan="4">转诊</th>
					<th>原因</th>
					<td colspan="2">${hbp.referralReasons}</td>
				</tr>
				<tr>
					<th>接诊医生</th>
					<td colspan="2">${hbp.referralDoctor}</td>
				</tr>
				<tr>
					<th>转诊日期</th>
					<td colspan="2"><fmt:formatDate value="${hbp.referralDate}" pattern="yyyy年MM月dd日"/></td>
				</tr>
				<tr>
					<th>机构及科别</th>
					<td colspan="2"><ehr:org code="${hbp.referralOrganCode}"/> ${hbp.referralDepartment}</td>
				</tr>
			</c:otherwise>
		</c:choose>
		<tr>
			<th colspan="2">随访医生签名</th>
			<td colspan="2">${hbp.createDoctorName}</td>
		</tr>
		<tr>
			<th colspan="2">随访机构</th>
			<td colspan="2"><ehr:org code="${hbp.createOrganCode}"/></td>
		</tr>
		<tr>
			<th colspan="2">备注</th>
			<td colspan="2">${hbp.comments}</td>
		</tr>
	</table>
</div>