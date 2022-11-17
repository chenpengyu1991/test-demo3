<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<table>
	<tr>
		<td>
			<div class="postdiv">
				<fieldset>
					<div class="postcontent">
						<div class="postdiv">
							<fieldset>
								<legend>随访填写</legend>
								<table class="posttable">
									<colgroup>
										<col style="min-width: 100px; width: 30%" />
										<col style="min-width: 150px; width: 70%" />
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
										<td><ehr:tip>
												<ehr:dic dicmeta="DMD00043" code="${di.curSymptom }"></ehr:dic>
												<c:out value="${di.otherSymptom }" />
											</ehr:tip></td>
									</tr>
								</table>
								<fieldset>
									<legend>体征</legend>
									<table class="posttable">
										<colgroup>
											<col style="min-width: 100px; width: 30%" />
											<col style="min-width: 150px; width: 70%" />
										</colgroup>
										<tr>
											<th><label for="hbpDiagnosedOrganCode">血压</label></th>
											<td><c:out value="${di.sbp}" /> / <c:out
													value="${di.dbp}" /></td>
										</tr>
										<tr>
											<th><label>体重</label></th>
											<td><c:out value="${di.bodyWeight}" /> / <c:out
													value="${di.nextFollowupBodyWeight}" />kg</td>
										</tr>
										<tr>
											<th><label>体质指数(BMI)</label></th>
											<td><c:out value="${di.indexOfBodyCharacteristics}" /> /
												<c:out value="${di.nextFollowupBmi}" />kg/㎡</td>
										</tr>
										<tr>
											<th><label for="heartRate">足背动脉搏动</label></th>
											<td><ehr:dic dicmeta="DMD00044" code="${di.heartRate }"></ehr:dic></td>
										</tr>
										<tr>
											<th>其他</th>
											<td><c:out value="${di.signOther}" /></td>
										</tr>
									</table>
								</fieldset>
								<fieldset>
									<legend>生活方式指导</legend>
									<table class="posttable">
										<colgroup>
											<col style="min-width: 100px; width: 30%" />
											<col style="min-width: 150px; width: 70%" />
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
								<fieldset>
									<legend>辅助检查</legend>
									<table class="posttable">
										<colgroup>
											<col style="min-width: 100px; width: 30%" />
											<col style="min-width: 150px; width: 70%" />
										</colgroup>
										<tr>
											<th>空腹血糖值</th>
											<td><c:out value="${di.fpg}" />mmol/L</td>
										</tr>
										<tr>
											<th><label class="" for="hgb">糖化血红蛋白值</label></th>
											<td><c:out value="${di.hgb}" />%
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
								<fieldset>
									<legend>血脂</legend>
									<table class="posttable">
										<colgroup>
											<col style="min-width: 100px; width: 30%" />
											<col style="min-width: 150px; width: 70%" />
										</colgroup>
										<tr>
											<th>总胆固醇</th>
											<td><c:out value="${di.tc}" />mmol/L</td>
										</tr>
										<tr>
											<th>甘油三酯</th>
											<td><c:out value="${di.triglycerideValue}" />mmol/L</td>
										</tr>
										<tr>
											<th>血清低密度脂蛋白胆固醇</th>
											<td><c:out value="${di.ldlcDetectValue}" />mmol/L</td>
										</tr>
										<tr>
											<th>血清高密度脂蛋白胆固醇</th>
											<td><c:out value="${di.hdlcDetectValue}" />mmol/L</td>
										</tr>
									</table>
								</fieldset>
								<table class="posttable">
									<colgroup>
										<col style="min-width: 100px; width: 30%" />
										<col style="min-width: 150px; width: 70%" />
									</colgroup>
									<tr>
										<th>服药依从性</th>
										<td><ehr:dic dicmeta="DMD00041"
												code="${di.medicationCompliance }"></ehr:dic></td>
									</tr>
									<tr>
										<th>药物不良反应</th>
										<td><ehr:dic dicmeta="FS10238" code="${di.drugReaction }"></ehr:dic></td>
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
									<tr>
										<th><label  for="">用药</label></th>
										<td><ehr:dic dicmeta="FS10246" code="${di.medicateDiFlag}"/></td>
									</tr>
								</table>
								<div <c:if test='${di.medicateDiFlag eq "2"}'> style="display: none" </c:if>>
									<c:set var="drug" value="${di}" scope="request"></c:set>
									<jsp:include page="../hbpdicommon/druguse.jsp"></jsp:include>
									<fieldset>
										<legend>胰岛素</legend>
										<table class="posttable">
											<colgroup>
												<col style="min-width: 100px; width: 30%" />
												<col style="min-width: 150px; width: 70%" />
											</colgroup>
											<tr>
												<th>种类</th>
												<td><c:out value="${drug.insulinSort}" /></td>
											</tr>
											<tr>
												<th>用法及用量</th>
												<td>
													每日<c:out value="${drug.insulinUsage}" />次 , 每次<c:out value="${drug.dosage}"/>mg
												</td>
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