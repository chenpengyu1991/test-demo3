<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>

<table>
	<tr>
		<td >
			<div class="postdiv">
				<fieldset class="layui-elem-field" style="margin-top: 10px;">
					<input type="hidden" name="id" value="${hbp.id}" /> <input type="hidden" name="planId" value="${hbp.planId}">
						<div class="postcontent">
							<div class="postdiv">
								<fieldset class="layui-elem-field">
									<legend>随访填写</legend>
									<table class="posttable">
										<colgroup>
											<col style="min-width: 100px; width: 30%" />
											<col style="min-width: 150px; width: 70%" />
										</colgroup>
										<tr>
											<th><label>随访日期</label></th>
											<td><fmt:formatDate value="${hbp.visitDate}" pattern="yyyy/MM/dd" /></td>
										</tr>
										<tr>
											<th><label  >随访方式</label></th>
											<td><ehr:dic dicmeta="DMD00026" code="${hbp.visitWayCode}" ></ehr:dic></td>
										</tr>
										<tr>
											<th><label >症状</label></th>
											<td>
												<ehr:tip><ehr:dic dicmeta="DMD00038" code="${hbp.curSymptom }"/><c:out value="${hbp.otherSymptom}"/></ehr:tip>
											</td>
										</tr>
									</table>
									<fieldset class="layui-elem-field">
										<legend>体征</legend>
										<table class="posttable">
											<colgroup>
												<col style="min-width: 100px; width: 30%" />
												<col style="min-width: 150px; width: 70%" />
											</colgroup>
											<tr>
												<th><label  for="hbpDiagnosedOrganCode">血压</label></th>
												<td><c:out value="${hbp.sbp}" />/<c:out value="${hbp.dbp}" /> mmHg</td>
											</tr>
											<tr>
												<th><label  for="height">身高</label></th>
												<td><c:out value="${hbp.height}" /> cm</td>
											</tr>
											<tr>
												<th><label class="" for="bodyWeight">体重</label></th>
												<td>
													<c:out value="${hbp.bodyWeight}" />/
												    <c:out value="${hbp.nextFollowupBodyWeight}" />kg</td>
											</tr>
											<tr>
												<th><label class="" for="indexOfBodyCharacteristics">体质指数(BMI)</label></th>
												<td>
													<c:out value="${hbp.indexOfBodyCharacteristics}" /> /
												    <c:out value="${hbp.nextFollowupBmi}" />kg/㎡
												</td>
											</tr>
											<tr>
												<th><label  for="heartRate">心率</label></th>
												<td><c:out value="${hbp.heartRate}" /></td>
											</tr>
											<tr>
												<th><label>其他</label></th>
												<td><c:out value="${hbp.signOther}" /></td>
											</tr>
										</table>
									</fieldset>
									<fieldset class="layui-elem-field">
										<legend>生活方式指导</legend>
										<table class="posttable">
											<colgroup>
												<col style="min-width: 100px; width: 30%" />
												<col style="min-width: 150px; width: 70%" />
											</colgroup>
											<tr>
												<th><label  for="dailyDailySmokeber">日吸烟量（支）</label></th>
												<td>
													<c:out value="${hbp.dailyDailySmokeber}"/> / <c:out value="${hbp.smokeberTarget}" />
												</td>
											</tr>
											<tr>
												<th><label  for=dailyDrink>日饮酒量（两）</label></th>
												<td>
													<c:out value="${hbp.dailyDrink}" /> / <c:out value="${hbp.nextFollowupDailyDrink}" />
												</td>
											</tr>
											<tr>
												<th><label  for="trainFrequency">运动</label></th>
												<td>
													<c:out value="${hbp.trainFrequency}" />次/周
													<c:out value="${hbp.trainingMin}" />分钟/次
												</td>								
											</tr>
											<tr>
												<th></th>
												<td>
													<c:out value="${hbp.nextExerciseFrequency}" />次/周
													<c:out value="${hbp.nextExerciseTime}" />分钟/次
												</td>
											</tr>
											<tr>	
												<th><label  for="salinity">摄盐情况（克/天）</label></th>
												<td>
													目前值：<ehr:dic dicmeta="DMD00063" code="${hbp.salinity}"></ehr:dic> /
													期望值：<ehr:dic dicmeta="DMD00063" code="${hbp.nextSalinityTarget}"></ehr:dic>
												</td>
											</tr>
											<tr>
												<th><label  for="mentality">心理调整</label></th>
												<td><ehr:dic dicmeta="DMD00039" code="${hbp.mentality }" ></ehr:dic></td>
											</tr>
											<tr>
												<th><label  for="compiance">遵医行为</label></th>
												<td><ehr:dic dicmeta="DMD00040" code="${hbp.compiance }" ></ehr:dic>
											</tr>
										</table>
									</fieldset>
									
									<table class="posttable">
										<colgroup>
											<col style="min-width: 100px; width: 30%" />
											<col style="min-width: 150px; width: 70%" />
										</colgroup>
										<tr>
											<th><label for="aeResultDesc">辅助检查</label></th>
											<td><c:out value="${hbp.aeResultDesc }" /></td>
										</tr>
										<tr>
											<th><label for="medicationCompliance">服药依从性</label></th>
											<td><ehr:dic dicmeta="DMD00041" code="${hbp.medicationCompliance }"></ehr:dic></td>
										</tr>
										<tr>
											<th><label for="sideEffects">药物不良反应</label></th>
											<td>
												<ehr:dic dicmeta="FS10238" code="${hbp.sideEffects }"></ehr:dic>
												&nbsp;${hbp.effectsState}
											</td>
										</tr>
										<tr>
											<th><label for="visitType">此次随访分类</label></th>
											<td><ehr:dic dicmeta="DMD00042" code="${hbp.visitType }"></ehr:dic></td>
										</tr>
										
									</table>
									<span id="drug_info"  <c:if test='${hbp.medicateHbpFlag eq "2" }'> style="display: none" </c:if>>
										<c:set var="drug" value="${hbp}" scope="request"></c:set>
										<fieldset class="layui-elem-field">
											<legend>用药情况</legend>
											<table class="posttable">
												<colgroup>
													<col style="min-width: 100px; width: 30%" />
													<col style="min-width: 150px; width: 70%" />
												</colgroup>
												<tr>
													<th><label  for="">用药</label></th>
													<td><ehr:dic dicmeta="FS10246" code="${hbp.medicateHbpFlag}"/></td>
												</tr>
											<jsp:include page="../hbpdicommon/druguse.jsp"></jsp:include>
											</table>
										</fieldset>
									</span>
								</fieldset>
								<fieldset class="layui-elem-field">
									<legend>转诊</legend>
									<table class="posttable">
										<colgroup>
											<col style="min-width: 100px; width: 30%" />
											<col style="min-width: 150px; width: 70%" />
										</colgroup>
										<tr>
											<th><label  for="referralHbpFlag">转诊</label></th>
											<td><ehr:dic dicmeta="FS10246" code="${hbp.referralHbpFlag}"/></td>
										</tr>
									</table>
									<table class="posttable" <c:if test='${hbp.referralHbpFlag eq "2" }'> style="display: none" </c:if>>
										<colgroup>
											<col style="min-width: 100px; width: 30%" />
											<col style="min-width: 150px; width: 70%" />
										</colgroup>
										<tr>
											<th>机构</th>
											<td><ehr:org code="${hbp.referralOrganCode}"/></td>
										</tr>
										<tr>
											<th>科别</th>
											<td><c:out value="${hbp.referralDepartment}"/></td>
										</tr>
										<tr>
											<th>接诊医生</th>
											<td><c:out value="${hbp.referralDoctor}"/></td>
										</tr>
										<tr>
											<th>转诊日期</th>
											<td><fmt:formatDate value="${hbp.referralDate }" pattern="yyyy/MM/dd"/> </td>
										</tr>
										<tr>
											<th>原因</th>
											<td><c:out value="${hbp.referralReasons}"/></td>
										</tr>
									 </table>
								</fieldset>
								<c:set var="input" value="${hbp}" scope="request"></c:set>
								<jsp:include page="../common/inputInfo.jsp"></jsp:include>
							</div>
						</div>
				</fieldset>
			</div>
		</td>
		<td>
			<div id="hbpFollowupInputDiv">
				<%-- 显示随机记录表单 --%>
			</div>
		</td>
	</tr>
</table>