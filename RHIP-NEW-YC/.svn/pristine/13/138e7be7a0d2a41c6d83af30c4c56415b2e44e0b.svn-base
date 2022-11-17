<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/ehr-tag" prefix="ehr"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%> 
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<script src="${pageContext.request.contextPath}/js/views/ehr/ehrbrowser/service/inpatient/summary.js" type="text/javascript"></script>

<div class="table-01">
	<c:set var="inpatientInfo" value="${inpatientSummary.inpatientInfo}" scope="request">
	</c:set>
	<table>
		<tr>
			<td rowspan="2"><span>患者信息</span>
				<table class="formtable">
					<tr>
						<th style="width:130px">姓名</th>
						<td style="width:170px" ><c:out value="${inpatientInfo.name}"></c:out></td>
						<th style="width:145px" >性别</th>
						<td style="width:155px">
						<ehr:dic dicmeta="GBT226112003" code="${inpatientInfo.gender}"></ehr:dic>
						</td>
					</tr>
					<tr>
						<th>年龄</th>
						<td colspan="3"><c:out value="${inpatientInfo.age}"></c:out></td>
					</tr>
				</table> <span>住院信息</span>
				<table class="formtable">

					<tr >
						<th  style="width:130px">病案号</th>
						<td  style="width:170px"><c:out value="${inpatientInfo.medicalRecordNo}"></c:out></td>
						<th  style="width:145px" >入院日期</th>
						<td  style="width:155px"><fmt:formatDate value="${inpatientInfo.inhosDate}" pattern="yyyy/MM/dd" /></td>
					</tr>
					<tr>
						<th>住院机构</th>
						<td><c:out value="${inpatientInfo.referralHospitalName}"></c:out></td>
						<th>入院科室</th>
						<td><c:out value="${inpatientInfo.referralDeptName}"></c:out></td>
					</tr>
					<tr>
						<th>病情危重程度</th>
						<td><ehr:dic dicmeta="CV550112" code="${inpatientInfo.inhosCondition}"/></td>
						<th>病床号</th>
						<td><c:out value="${inpatientInfo.sickbedNo}"></c:out></td>
					</tr>
					<tr>
						<th>主治医师</th>
						<td><c:out value="${inpatientInfo.relatedPhysicianName}"></c:out></td>
						<th>住院天数</th>
						<td><c:out value="${inpatientInfo.inhosDays}"></c:out></td>
					</tr>
					<tr>
						<th>被抢救的次数</th>
						<td><c:out value="${inpatientInfo.inhosRescueTimes}"></c:out></td>
						<th>被抢救成功的次数</th>
						<td><c:out value="${inpatientInfo.inhosRescueSuccessTimes}"></c:out></td>
					</tr>
					
<!-- 					<tr> -->
<!-- 						<td>HbsAg结果</td> -->
<%-- 						<td><c:out value="${inpatientInfo.inhosDate}"></c:out></td> --%>
<!-- 						<td>HIV-Ab结果</td> -->
<!-- 					</tr> -->
<!-- 					<tr> -->
<!-- 						<td>HCV-vb结果</td> -->
<%-- 						<td><c:out value="${inpatientInfo.inhosDate}"></c:out></td> --%>
<!-- 					</tr> -->
				
					<tr>
						<th>诊断信息</th>
						<!-- TODO -->
						<td colspan="3">
								<c:forEach items="${inpatientSummary.diseaseDiagnosisInfos}" var="diseaseDiagnosisInfo">
									<fmt:formatDate value="${diseaseDiagnosisInfo.diagnoseDate}" pattern="yyyy/MM/dd" ></fmt:formatDate>:<c:out value="${diseaseDiagnosisInfo.diagnosisDesc}"></c:out>;<br />
								</c:forEach>
						</td>
						
					</tr>
				</table> <span>出院信息</span>
				<table class="formtable">
					<tr>
						<th style="width:130px">出院日期</th>
						<td style="width:170px"><fmt:formatDate value="${inpatientInfo.outHospitalDate}" pattern="yyyy/MM/dd" /></td>
						<th style="width:145px">总费用</th>
						<td style="width:155px"><fmt:formatNumber value="${inpatientInfo.inhosCostSum}" type="currency"/></td>
					</tr>
					<tr>
						<th>出院科室</th>
						<td><c:out value="${inpatientInfo.destRoomName}"></c:out></td>
						<th>自费</th>
						<td><fmt:formatNumber value="${inpatientInfo.personalExpenses}" type="currency"/></td>
					</tr>
					<tr>
						<th>治疗结果</th>
						<td><ehr:dic dicmeta="CV550111" code="${inpatientInfo.treatmentResultsCode}"/></td>
						<th>报销</th>
						<td><fmt:formatNumber value="${inpatientInfo.medicalInsuranceCostSum}" type="currency"/></td>
					</tr>
					<tr>
						<th>是否需要随诊</th>
						<!-- TODO 住院患者随诊标志-->
						<td>
                            <c:if test="${!empty inpatientInfo.inhosCostVisitFlag}">
                                <c:out value="${inpatientInfo.inhosCostVisitFlag eq '2' ?'是':'否'}"></c:out>
                            </c:if>
                        </td>
						<th>其它</th>
						<td><fmt:formatNumber value="${inpatientInfo.otherSubsidiesCostSum}" type="currency"/></td>
					</tr>
					<tr>
						<th>教学示范病例</th>
						<!-- TODO 住院患者示教病例标志-->
						<td>
                            <c:if test="${!empty inpatientInfo.inhosTeachCaseFlag}">
                                <c:out value="${inpatientInfo.inhosTeachCaseFlag eq '2' ?'是':'否'}"></c:out>
                            </c:if>
                        </td>
						<th>保险类型</th>
						
						<td><ehr:dic dicmeta="CV0710003" code="${inpatientInfo.inhosCostPayCode}"/></td>
					</tr>
				</table></td>
			<td  style="vertical-align: top">
				
				
				<ul id=tags>
			        <li class=selectTag>
			            <a id="summary_exam_btn"  href="javascript:void(0)">检验</a>
			        </li>
			        <li>
			            <a id="summary_study_btn"  href="javascript:void(0)">检查</a>
			        </li>
   				 </ul>
   				 
   				<div id="tagContent" style="width: 400px ;height: 220px;overflow: auto"	>	
					<div id="tagContent0" class="selectTag" >
						<jsp:include page="../exam/eventDetaillist.jsp"></jsp:include>
					</div>
					<div id="tagContent1" style="display:none;">
						<jsp:include page="../study/datagrid_summary.jsp"></jsp:include>
					</div>
				</div>
			</td>
		</tr>
		<tr>
			<td valign="top"  style="vertical-align: top"><a>医嘱</a>
				<div style="width: 400px;height: 220px;overflow: auto">
					<table class="repeattable" >
							<thead>
								<tr>
								
									<th>药名</th>
									<th>规格</th>
									<th>计量</th>
									<th>单位</th>
									<th>下达日期</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${inpatientSummary.drugUsages}" var="drugUsage">
									<tr>
										<td><tags:textWithTip value="${drugUsage.drugGenericName}"></tags:textWithTip></td>
										<td><c:out value="${drugUsage.drugSpecifications}"></c:out></td>
                                        <td> <c:out value="${drugUsage.quantity }"></c:out></td>
                                        <td> <c:out value="${drugUsage.quantityUnit }"></c:out></td>
										<td><fmt:formatDate value="${drugUsage.odrisuDt}" pattern="yyyy/MM/dd" /></td>
									</tr>
								</c:forEach>
							</tbody>
					</table>
				</div>
			</td>
		</tr>
	</table>

</div>
