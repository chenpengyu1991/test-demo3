<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<link rel="stylesheet"
	  href="${pageContext.request.contextPath}/css/views/ehrbrowser/basic/basic.css" />

<div style="background-color: white; height: 515px;">
	<ul>
		<li style="text-align: center; font-size: 25px;">分娩信息记录</li>
	</ul>
	<br />
		<div class="table-basic" style="overflow: inherit">
			<div>
				<h3 ><i></i> 产妇信息</h3>
			</div>
			<table class="layui-table x-admin-sm-table-list-small">
				<colgroup>
					<col style="width: 15%;"/>
					<col style="width: 35%;"/>
					<col style="width: 15%;"/>
					<col style="width: 35%;"/>
				</colgroup>
				<tr>
					<th>住院日期</th>
					<td><fmt:formatDate value="${deliveryRecordInfo.inpatientdate}" pattern="yyyy/MM/dd"/></td>
					<th>分娩日期</th>
					<td><fmt:formatDate value="${deliveryRecordInfo.deliveryDate}" pattern="yyyy/MM/dd HH:mm"/></td>
				</tr>
				<tr>
					<th>分娩孕周</th>
					<td colspan="3">
						<c:out value="${deliveryRecordInfo.deliveryWeek}"/> 周
					</td>
				</tr>
				<tr>
					<th>分娩方式</th>
					<td colspan="3">
						<ehr:dic code="${deliveryRecordInfo.deliveryWay}" dicmeta="FS10308"/>
						<c:if test="${fn:contains(deliveryRecordInfo.deliveryWay,'4')}">
							${deliveryRecordInfo.deliveryOther}
						</c:if>
					</td>
				</tr>
				<tr>
					<th>会阴情况</th>
					<td colspan="3">
						<c:if test="${deliveryRecordInfo.perineumCutFlag eq 0}"><span>完整</span></c:if>
						<c:if test="${deliveryRecordInfo.perineumCutFlag eq 1}"><span>切开,裂伤</span></c:if>
					</td>
				</tr>
				<tr>
					<th>产妇会阴裂伤程度</th>
					<td><ehr:dic code="${deliveryRecordInfo.perineumTearDegree}" dicmeta="CV0501010"/></td>
					<th>产妇会阴缝合针数	</th>
					<td><c:out value="${deliveryRecordInfo.perineumTearNeedleNumber}"/></td>
				</tr>
				<tr>
					<th>产科合并症及并发症</th>
					<td colspan="3">
						<ehr:dic code="${deliveryRecordInfo.complicationsCode}" dicmeta="FS10309"/>
						<c:if test="${fn:contains(deliveryRecordInfo.complicationsCode,'6')}">
							${deliveryRecordInfo.complicationsDesc}
						</c:if>
					</td>
				</tr>
				<tr>
					<th>胎盘</th>
					<td colspan="3">
						<c:if test="${deliveryRecordInfo.placenta eq 0}">自然娩出</c:if>
						<c:if test="${deliveryRecordInfo.placenta eq 1}">人工剥离</c:if>
						<c:if test="${deliveryRecordInfo.peelStatus eq 0}">完整</c:if>
						<c:if test="${deliveryRecordInfo.peelStatus eq 1}">不完整</c:if>
					</td>
				</tr>
				<tr>
					<th>产后出血</th>
					<td colspan="3">
						<c:if test="${not empty deliveryRecordInfo.deliveryBleedAfterTwoHours}">
							<span>是</span>&emsp;
							<c:out value="${deliveryRecordInfo.deliveryBleedAfterTwoHours}"></c:out>ml/24小时
						</c:if>
						<c:if test="${empty deliveryRecordInfo.deliveryBleedAfterTwoHours}"><span>否</span></c:if>
					</td>
				</tr>
				<tr>
					<th>本次胎数</th>
					<td colspan="3"><c:out value="${deliveryRecordInfo.gestationalNumber}"/>胎</td>
				</tr>
				<tr>
					<th>产后休养地址</th>
					<td colspan="3"><c:out value="${deliveryRecordInfo.postpartumAdress}"/></td>
				</tr>
				<tr>
					<th>出院日期</th>
					<td colspan="3"><fmt:formatDate value="${deliveryRecordInfo.outpatientdate}" pattern="yyyy/MM/dd"/></td>
				</tr>
				<tr>
					<th>医院名称</th>
					<td colspan="3"><c:out value="${deliveryRecordInfo.deliveryHospitalName}"/></td>
				</tr>
			</table>
			<c:forEach var="neonatal" items="${deliveryRecordInfo.neonatalList}" varStatus="neonatalStatus">
				<div>
					<h3 ><i></i> 新生儿信息&nbsp;${neonatalStatus.count }</h3>
				</div>
				<table>
					<colgroup>
						<col style="width: 15%;"/>
						<col style="width: 35%;"/>
						<col style="width: 15%;"/>
						<col style="width: 35%;"/>
					</colgroup>
					<tr>
						<th>新生儿情况</th>
						<td colspan="3">
							性别：<ehr:dic code="${neonatal.neonatalGender}" dicmeta="GBT226112003"/>
							&emsp;&emsp;
							出生体重(g)：<c:out value="${neonatal.birthWeight}"/>g&emsp;&emsp;
							出生身长(cm)：<c:out value="${neonatal.birthStature}"/>cm
						</td>
					</tr>
					<tr>
						<th>妊娠结局</th>
						<td colspan="3">
							<c:if test="${neonatal.puerperaResult eq '1'}">
								<span><ehr:dic code="${neonatal.puerperaResult}" dicmeta="FS10310"/></span>
							</c:if>
							<c:if test="${neonatal.puerperaResult ne '1'}">
								<span><ehr:dic code="${neonatal.puerperaResult}" dicmeta="FS10310"/></span>
								&emsp;&emsp;
								<c:if test="${not empty neonatal.deathDay}">
									<label>出生后</label>
									<c:out value="${neonatal.deathDay}"/><label>天</label>
									<c:out value="${neonatal.deathHour}"/><label>小时</label>
									<c:out value="${neonatal.deathMin}"/><label>分</label>&emsp;
									<label>死亡诊断:</label><c:out value="${neonatal.deathDiagnose}"/>
								</c:if>
							</c:if>
						</td>
					</tr>
					<tr>
						<th>阿氏评分，1分钟</th>
						<td><c:out value="${neonatal.apgarValueOne}"/></td>
						<th>阿氏评分值，5分钟</th>
						<td><c:out value="${neonatal.apgarValueFive}"/></td>
					</tr>
					<tr>
						<th>出生缺陷</th>
						<td colspan="3">
							<c:if test="${!empty neonatal.birthDefectFlag}">
							<c:choose>
							<c:when test="${neonatal.birthDefectFlag eq '2'}">
								<span>有</span>&emsp;
								<c:out value="${neonatal.birthDefectDesc}"/>
							</c:when>
							<c:otherwise><span>无</c:otherwise>
					                        </c:choose>
				                        </c:if>
						</td>
					</tr>
					<tr>
						<th>新生儿并发症</th>
						<td colspan="3">
							<c:if test="${!empty neonatal.neonatalComplicationsFlag}">
							<c:choose>
							<c:when test="${neonatal.neonatalComplicationsFlag eq '2'}">
								<span>有</span>&emsp;
								<c:out value="${neonatal.neonatalComplicationsDesc}"/>
							</c:when>
							<c:otherwise><span>无</c:otherwise>
					                        </c:choose>
				                        </c:if>
						</td>
					</tr>
					<tr>
						<th>卡介疫苗接种</th>
						<td colspan="3">
								<ehr:dic code="${neonatal.bcgStates}" dicmeta="FS10187"/>&emsp;
							<c:out value="${neonatal.bcgResult}"/>
						</td>
					</tr>
					<tr>
						<th>乙肝疫苗接种</th>
						<td colspan="3">
								<ehr:dic code="${neonatal.hepatitisBvaccine}" dicmeta="FS10187"/>&emsp;
							<c:out value="${neonatal.bvaccineResult}"/>
						</td>
					</tr>
					<tr>
						<th>新生儿听力筛查</th>
						<td colspan="3">
								<ehr:dic code="${neonatal.hearingScreeningState}" dicmeta="FS10025"/>&emsp;
							<c:out value="${neonatal.hearingScreeningResults}"/>
						</td>
					</tr>
					<tr>
						<th>新生儿疾病筛查</th>
						<td colspan="3">
								<ehr:dic code="${neonatal.diseaseScreeningProject}" dicmeta="CV0450008"/>&emsp;
							<c:out value="${neonatal.diseaseScreeningResults}"/>
						</td>
					</tr>
				</table>
			</c:forEach>
		</div>
</div>