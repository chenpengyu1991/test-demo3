<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<table>
	<tr>
		<td>
			<div class="postdiv">
				<fieldset class="layui-elem-field" style="margin-top: 10px;">
					<div class="postcontent">
						<div class="postdiv">
							<fieldset class="layui-elem-field">
								<legend>随访填写</legend>
								<table class="posttable">
									<colgroup>
										<col style="min-width: 100px; width: 35%" />
										<col style="min-width: 150px; width: 65%" />
									</colgroup>
									<tr>
										<th><label for="visitDate">随访日期</label></th>
										<td><fmt:formatDate value="${di.visitDate}"
												pattern="yyyy/MM/dd" /></td>
									</tr>
									<tr>
										<th><label>随访方式</label></th>
										<td><ehr:dic dicmeta="DMD00026" code="${di.visitWayCode}"></ehr:dic></td>
									</tr>
									<tr>
										<th>症状</th>
										<td>
										<ehr:dic dicmeta="FS10238" code="${di.curSymptomFlag }"/>
										<ehr:tip>
												<ehr:dic dicmeta="DMD00043" code="${di.curSymptom }"></ehr:dic>
												<c:out value="${di.otherSymptom }" />
											</ehr:tip></td>
									</tr>
								</table>
								<fieldset class="layui-elem-field">
									<legend>体征</legend>
									<table class="posttable">
										<colgroup>
											<col style="min-width: 100px; width: 35%" />
											<col style="min-width: 150px; width: 65%" />
										</colgroup>
										<tr>
											<th><label for="hbpDiagnosedOrganCode">血压</label></th>
											<td><c:out value="${di.sbp}" /> / <c:out
													value="${di.dbp}" /> mmHg</td>
										</tr>
										<tr>
											<th><label for="height">身高</label></th>
											<td><c:out value="${di.height}"/> cm</td>
										</tr>
										<tr>
											<th><label>体重</label></th>
											<td><c:out value="${di.bodyWeight}" /> / <c:out
													value="${di.nextFollowupBodyWeight}" /> kg</td>
										</tr>
										<tr>
											<th><label>体质指数(BMI)</label></th>
											<td><c:out value="${di.indexOfBodyCharacteristics}" /> /
												<c:out value="${di.nextFollowupBmi}" /> kg/㎡</td>
										</tr>
										<tr>
											<th><label for="heartRate">足背动脉搏动</label></th>
											<td><ehr:dic dicmeta="DMD00044" code="${di.heartRate }"></ehr:dic>
												<span style="display:${ di.heartRate !='2' ?'none':'inline' }" id="heartRateDiSpan">
													（<ehr:dic dicmeta="IDM00280" code="${di.heartRatePart }" />）
												</span>
											</td>
										</tr>
										<tr>
											<th>慢性咳嗽、咳痰≥2周</th>
											<td>
												<ehr:dic dicmeta="FS10238" code="${di.isSymptomChronicCough == null ? '1' : di.isSymptomChronicCough}"/>
											</td>
										</tr>
										<tr>
											<th>咯血、血痰</th>
											<td>
												<ehr:dic dicmeta="FS10238" code="${di.isHemosputum == null ? '1' : di.isHemosputum}"/>
											</td>
										</tr>
										<tr>
											<th>发热、盗汗、胸痛或不明原因消瘦≥2周</th>
											<td>
												<ehr:dic dicmeta="FS10238" code="${di.isSymptomChestPain == null ? '1' : di.isSymptomChestPain}"/>
											</td>
										</tr>
										<tr>
											<th>其他</th>
											<td><c:out value="${di.signOther}" /></td>
										</tr>
									</table>
								</fieldset>
								<fieldset class="layui-elem-field">
									<legend>生活方式指导</legend>
									<table class="posttable">
										<colgroup>
											<col style="min-width: 100px; width: 35%" />
											<col style="min-width: 150px; width: 65%" />
										</colgroup>
										<tr>
											<th><label  for="dailySmoke">日吸烟量（支）</label></th>
											<td>
												<c:out value="${di.dailySmoke}" /> / 
												<c:out value="${di.smokeberTarget}" />
											</td>
										</tr>
										<tr>
											<th><label  for="dailySmoke">日饮酒量（两）</label></th>
											<td>
												<c:out value="${di.dailyDrink}" /> / 
												<c:out value="${di.nextFollowupDailyDrink}" />
											</td>
										</tr>
										<tr>
											<th><label  for="trainFrequencyType">运动</label></th>
											<td>
												<c:out value="${di.trainFrequencyType}" />次/周 
												<c:out value="${di.trainingMin}" />分钟/次
											</td>
										</tr>
										<tr>
											<th></th>
											<td>
												<c:out value="${di.nextExerciseFrequency}" />次/周
												<c:out value="${di.nextExerciseTime}" />分钟/次
											</td>
										</tr>
										<tr>
											<th><label  for="dailyRice">主食（克/天）</label></th>
											<td>
												<c:out value="${di.dailyRice}" /> / 
												<c:out value="${di.staple}" />
											</td>
										</tr>
										<tr>
											<th>自我血糖监测</th>
											<td><ehr:dic dicmeta="DMD00053" code="${di.selfBsMonitoring }"></ehr:dic></td>
										</tr>
										<tr>
											<th>心理调整</th>
											<td><ehr:dic dicmeta="DMD00039" code="${di.mentality }"></ehr:dic></td>
										</tr>
										<tr>
											<th>遵医行为</th>
											<td><ehr:dic dicmeta="DMD00040" code="${di.compiance }"></ehr:dic></td>
										</tr>
									</table>
								</fieldset>
								<fieldset class="layui-elem-field">
									<legend>辅助检查</legend>
									<table class="posttable">
										<colgroup>
										<col style="min-width: 100px; width: 35%" />
										<col style="min-width: 150px; width: 65%" />
										</colgroup>
										<tr>
											<th>空腹血糖值</th>
											<td><c:out value="${di.fpg}" /> mmol/L</td>
										</tr>
										<tr>
											<th>餐后2小时血糖值</th>
											<td><c:out value="${di.gluValue}" /> mmol/L</td>
										</tr>
										<tr>
											<th><label class="" for="hgb">糖化血红蛋白值</label></th>
											<td><c:out value="${di.hgb}" /> %
										</tr>
										<tr>
											<th>检查日期</th>
											<td>
												<fmt:formatDate value="${di.checkDate}" pattern="yyyy/MM/dd" />
											</td>
										</tr>
										<tr>
											<th>其他检查</th>
											<td>
												<c:out value="${di.otherCheck}" />
											</td>
										</tr>
									</table>
								</fieldset>
								<table class="posttable">
									<colgroup>
									<col style="min-width: 100px; width: 35%" />
										<col style="min-width: 150px; width: 65%" />
									</colgroup>
									<tr>
										<th>服药依从性</th>
										<td><ehr:dic dicmeta="DMD00041"
												code="${di.medicationCompliance }"></ehr:dic></td>
									</tr>
									<tr>
										<th>药物不良反应</th>
										<td><ehr:dic dicmeta="FS10238" code="${di.drugReaction }"></ehr:dic>&emsp;
											<c:if test="${di.drugReaction==2 }">${di.effectsState }</c:if> 
										</td>
									</tr>
									<tr>
										<th>低血糖反应</th>
										<td><ehr:dic dicmeta="DMD00045"
												code="${di.hypoglycemiaReaction }"></ehr:dic></td>
									</tr>
									<tr>
										<th>糖尿病并发症</th>
										<td><ehr:tip>
												<ehr:dic dicmeta="DMD00046" code="${di.diComplication }"></ehr:dic>
											</ehr:tip></td>
									</tr>
									<tr>
										<th><label  for="visitType">此次随访分类</label></th>
										<td><ehr:dic dicmeta="DMD00042" code="${di.visitType }" ></ehr:dic></td>
									</tr>
									
								</table>
								<div>
									<c:set var="drug" value="${di}" scope="request"></c:set>
									<fieldset class="layui-elem-field">
										<legend>用药情况</legend>
										<table class="posttable">
											<colgroup>
												<col style="min-width: 100px; width: 30%" />
												<col style="min-width: 150px; width: 70%" />
											</colgroup>
											<tr>
												<th><label  for="">用药</label></th>
												<td><ehr:dic dicmeta="FS10246" code="${drug.medicateDiFlag}"/></td>
											</tr>
											<c:if test='${di.medicateDiFlag ne "2"}'>
												<jsp:include page="../hbpdicommon/druguse.jsp"></jsp:include>
											</c:if>
											<tr>
												<th><label  for="">胰岛素</label></th>
												<td><ehr:dic dicmeta="FS10246" code="${drug.insulinFlag}"/></td>
											</tr>
											<c:if test='${di.insulinFlag ne "2"}'>
												<tr>
													<th>种类</th>
													<td><c:out value="${drug.insulinSort}" /></td>
												</tr>
												<tr>
													<th>用法及用量</th>
													<td>
														每日<c:out value="${drug.insulinUsage}"/>次 , 
														每次 <c:out value="${drug.dosage}" />
														<ehr:dic dicmeta="DMD00067" code="${drug.insulinDosageUnit}" />
														备注:<c:out value="${drug.insulinUsageRemark}"  />
													</td>
												</tr>
											</c:if>
										</table>
									</fieldset>
									<fieldset class="layui-elem-field">
									<legend>转诊</legend>
									<table class="posttable">
										<colgroup>
											<col style="min-width: 100px; width: 30%" />
											<col style="min-width: 150px; width: 70%" />
										</colgroup>
										<tr>
											<th><label  for="referralDiFlag">转诊</label></th>
											<td><ehr:dic dicmeta="FS10246" code="${di.referralDiFlag}"/></td>
										</tr>
									</table>
									<table class="posttable" <c:if test='${di.referralDiFlag eq "2" }'> style="display: none" </c:if>>
										<colgroup>
											<col style="min-width: 100px; width: 30%" />
											<col style="min-width: 150px; width: 70%" />
										</colgroup>
										<tr>
											<th>机构</th>
											<td><ehr:org code="${di.referralOrganCode}"/></td>
										</tr>
										<tr>
											<th>科别</th>
											<td><c:out value="${di.referralDepartment}"/></td>
										</tr>
										<tr>
											<th>接诊医生</th>
											<td><c:out value="${di.referralDoctor}"/></td>
										</tr>
										<tr>
											<th>转诊日期</th>
											<td><fmt:formatDate value="${di.referralDate }" pattern="yyyy/MM/dd"/> </td>
										</tr>
										<tr>
											<th>原因</th>
											<td><c:out value="${di.referralReasons}"/></td>
										</tr>
									 </table>
								</fieldset>
								</div>
							</fieldset>
							<c:set var="input" value="${di}" scope="request"></c:set>
							<jsp:include page="../common/inputInfo.jsp"></jsp:include>
						</div>
					</div>
				</fieldset>
			</div>
		</td>
		<td>
			<div id="diFollowupInputDiv"></div>
		</td>
	</tr>
</table>