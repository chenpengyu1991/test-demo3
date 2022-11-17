<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr" %>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/views/ehrbrowser/basic/basic.css"/>
<script src="${pageContext.request.contextPath}/js/views/woman/delivery/view.js" type="text/javascript"></script>



<div style="background-color: white; height: 515px;">
	<ul>
		<li style="text-align: center; font-size: 25px;">分娩信息记录</li>
	</ul>
	<br/>
	<div class="table-basic" style="overflow:inherit">
		<table>
			<colgroup>
				<col style="width: 15%;"/>
				<col style="width: 30%;"/>
				<col style="width: 15%;"/>
				<col style="width: 30%;"/>
			</colgroup>
			<tr>
				<th>健康档案编号</th>
				<td colspan="3">
					<c:out value="${deliveryRecordInfo.healthFileNo}"/>
				</td>
			</tr>

			<tr>
				<th>产妇身份证号</th>
				<td>
					<c:out value="${deliveryRecordInfo.idCard}"/>
				</td>
				<th>产妇姓名</th>
				<td>
					<c:out value="${deliveryRecordInfo.name}"/>
				</td>
			</tr>
			<tr>
				<th>住院日期</th>
				<td><fmt:formatDate value="${deliveryRecordInfo.inpatientdate}" pattern="yyyy/MM/dd"/>
				</td>
				<th>分娩日期</th>
				<td><fmt:formatDate value="${deliveryRecordInfo.deliveryDate}" pattern="yyyy/MM/dd HH:mm"/></td>
			</tr>
			<tr>
				<th>分娩孕周</th>
				<td colspan="3"><c:out value="${deliveryRecordInfo.deliveryWeek}"/>
				</td>
			</tr>
			<tr>
				<th>分娩方式</th>
				<td colspan="3">
					<ehr:dic dicmeta="FS10308" code="${deliveryRecordInfo.deliveryWay}"/>
					<c:if test="${not empty deliveryRecordInfo.deliveryOther}">
						<c:out value="${deliveryRecordInfo.deliveryOther}"></c:out>
					</c:if>
				</td>
			</tr>
			<tr>
				<th>会阴情况</th>
				<td colspan="3">
					<c:if test="${deliveryRecordInfo.perineumCutFlag eq 0}">
						完整
					</c:if>
					<c:if test="${deliveryRecordInfo.perineumCutFlag eq 1}">
						切开,裂伤
					</c:if>
				</td>
			</tr>
			<tr id="perineumTearId" style="display: ${deliveryRecordInfo.perineumCutFlag eq 1?"" : "none"}">
				<th>产妇会阴裂伤程度</th>
				<td>
					<ehr:dic dicmeta="CV0501010" code="${deliveryRecordInfo.perineumTearDegree}"/>
				</td>
				<th>产妇会阴缝合针数</th>
				<td>
					<c:out value="${deliveryRecordInfo.perineumTearNeedleNumber}"></c:out>
				</td>
			</tr>
			<tr>
				<th>产科合并症和并发症</th>
				<td colspan="3">
					<ehr:dic dicmeta="FS10309" code="${deliveryRecordInfo.complicationsCode}"></ehr:dic>
					<c:if test="${not empty deliveryRecordInfo.complicationsDesc}">
						<c:out value="${deliveryRecordInfo.complicationsDesc}"></c:out>
					</c:if>
				</td>
			</tr>
			<tr>
				<th>胎盘</th>
				<td colspan="3">
					<c:if test="${deliveryRecordInfo.placenta eq 0}">
						自然娩出
					</c:if>
					<c:if test="${deliveryRecordInfo.placenta eq 1}">
						人工剥离&nbsp;
						<c:if test="${deliveryRecordInfo.peelStatus eq 0}">
							完整
						</c:if>
						<c:if test="${deliveryRecordInfo.peelStatus eq 1}">
							不完整
						</c:if>
					</c:if>
				</td>
			</tr>
			<tr>
				<th>产后出血</th>
				<td colspan="3">
					<c:if test="${deliveryRecordInfo.deliveryBleed eq '0'}">
						是
					</c:if>
					<c:if test="${deliveryRecordInfo.deliveryBleed eq '1'}">
						否
					</c:if>
					<c:if test="${not empty deliveryRecordInfo.deliveryBleedAfterTwoHours}">
						<c:out value="${deliveryRecordInfo.deliveryBleedAfterTwoHours}"></c:out>ml/24小时
					</c:if>
				</td>
			</tr>
			<tr>
				<th>本次胎数</th>
				<td colspan="3">
					<c:out value="${deliveryRecordInfo.gestationalNumber}"/>胎
				</td>
			</tr>
			<tr>
				<th>产后休养地址</th>
				<td colspan="3">
					<c:out value="${deliveryRecordInfo.postpartumAdress}"></c:out>
				</td>
			</tr>

			<tr>

				<th>出院日期</th>
				<td colspan="3">
					<c:if test="${not empty deliveryRecordInfo.outpatientdate}">
						<fmt:formatDate value="${deliveryRecordInfo.outpatientdate}"
										pattern="yyyy/MM/dd"></fmt:formatDate>
					</c:if>
				</td>
			</tr>
			<tr>
				<th>医院名称</th>
				<td colspan="3">
					<c:out value="${deliveryRecordInfo.deliveryHospitalName}"></c:out>
				</td>
			</tr>
		</table>
		<c:if test="${not empty deliveryRecordInfo.neonatalList}">
			<c:forEach items="${deliveryRecordInfo.neonatalList}" var="neonatal" varStatus="status">
				新生儿信息${status.index+1}
				<table>
					<col style="width: 15%;"/>
					<col style="width: 30%;"/>
					<col style="width: 15%;"/>
					<col style="width: 30%;"/>
					<tr>
						<th> 新生儿情况</th>
						<td colspan="3">
							性别： <ehr:dic dicmeta="GBT226112003" code="${neonatal.neonatalGender}"></ehr:dic>&nbsp;&nbsp;&nbsp;
							出生体重(g):<c:out value="${neonatal.birthWeight}"/>g&nbsp;&nbsp;&nbsp;&nbsp;
							出生身长(cm):<c:out value="${neonatal.birthStature}"/>cm
						</td>
					</tr>
					<tr>
						<th>妊娠结局</th>
						<td colspan="3">
							<ehr:dic dicmeta="FS10310" code="${neonatal.puerperaResult}"></ehr:dic>
							<c:if test="${not empty neonatal.deathDay}">
								<label>出生后</label><input type="text" value="${neonatal.deathDay}"
														 style="width: 20px"/>
								<label>天</label><input type="text" value="${neonatal.deathHour}"
													   style="width: 20px"/>
								<label>小时</label><input type="text" value="${neonatal.deathMin}"
														style="width: 20px"/><label>分</label>
								<label>死亡诊断</label><input type="text" value="${neonatal.deathDiagnose}"
														  style="width: 70px"/>
							</c:if>
						</td>
					</tr>
					<tr>
						<th>阿氏评分，1分钟</th>
						<td><c:out value="${neonatal.apgarValueOne}"/>
						</td>
						<th>阿氏评分值，5分钟</th>
						<td><c:out value="${neonatal.apgarValueFive}"/>
						</td>
					</tr>
					<tr>
						<th>出生缺陷</th>
						<td colspan="3">
							<ehr:dic dicmeta="FS10187" code="${neonatal.birthDefectFlag}"></ehr:dic>
							<c:if test="${not empty neonatal.birthDefectDesc}">
								<c:out value="${neonatal.birthDefectDesc}"/>
							</c:if>
						</td>
					</tr>

					<tr>
						<th>新生儿并发症</th>
						<td colspan="3">
							<ehr:dic dicmeta="FS10187" code="${neonatal.neonatalComplicationsFlag}"></ehr:dic>
							<c:if test="${not empty neonatal.neonatalComplicationsDesc}">
								<c:out value="${neonatal.neonatalComplicationsDesc}"/>
							</c:if>
						</td>
					</tr>

					<tr>
						<th>卡介疫苗接种</th>
						<td colspan="3">
							<ehr:dic dicmeta="FS10187" code="${neonatal.bcgStates}"></ehr:dic>
							<c:if test="${not empty neonatal.bcgResult}">
								<c:out value="${neonatal.bcgResult}"></c:out>
							</c:if>
						</td>
					</tr>

					<tr>
						<th>乙肝疫苗接种</th>
						<td colspan="3">
							<ehr:dic dicmeta="FS10187" code="${neonatal.hepatitisBvaccine}"></ehr:dic>
							<c:if test="${not empty neonatal.bvaccineResult}">
								<c:out value="${neonatal.bvaccineResult}"></c:out>
							</c:if>
						</td>

					</tr>


					<tr>
						<th>新生儿听力筛查</th>
						<td colspan="3">
							<ehr:dic dicmeta="FS10025" code="${neonatal.hearingScreeningState}"></ehr:dic>
							<c:if test="${not empty neonatal.hearingScreeningResults}">
								<c:out value="${neonatal.hearingScreeningResults}"></c:out>
							</c:if>
						</td>

					</tr>
					<tr>
						<th>新生儿疾病筛查</th>
						<td colspan="3">
							<ehr:dic dicmeta="CV0450008" code="${neonatal.diseaseScreeningProject}"></ehr:dic>
							<c:if test="${ not empty neonatal.diseaseScreeningResults}">
								<c:out value="${neonatal.diseaseScreeningResults}"></c:out>
							</c:if>
						</td>
					</tr>
				</table>
			</c:forEach>
		</c:if>
	</div>
</div>