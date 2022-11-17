<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/views/ehrbrowser/basic/basic.css" />
<script src="${pageContext.request.contextPath}/js/views/woman/PostpartumFTwo/revert.js" type="text/javascript" ></script>
<div style="background-color: white; height: 515px;">
	<ul>
		<li style="text-align: center; font-size: 25px;">产后42天健康检查表</li>
	</ul>
	<br/>
	<div class="table-basic" style="overflow:inherit">
		<table>
			<colgroup>
				<col style="width: 15%;"/>
	            <col style="width: 35%;"/>
				<col style="width: 15%;"/>
	            <col style="width: 35%;"/>
			</colgroup>
			<tr>
				<th width="15%">姓名</th>
				<td><c:out value="${postpartumDaysHealthInfo.name}"></c:out></td>
				<th width="15%">健康档案编号</th>
				<td><c:out value="${postpartumDaysHealthInfo.healthFileNo}"></c:out></td>
			</tr>
			<tr>
				<th width="15%">身份证号</th>
				<td><c:out value="${postpartumDaysHealthInfo.idCard}"></c:out></td>
				<th width="15%">血压</th>
				<td><c:out value="${postpartumDaysHealthInfo.sbp}"></c:out>/<c:out value="${postpartumDaysHealthInfo.dbp}"></c:out>mmHg</td>
			</tr>
			<tr>
				<th width="15%">一般健康情况</th>
				<td><c:out value="${postpartumDaysHealthInfo.healthStatus}"></c:out></td>
				<th width="15%">一般心理状况</th><%--2014-07-15 修改 刘洋，树枢确认常熟改字段传过来的是文字而非字典--%>
				<td><c:out value="${postpartumDaysHealthInfo.psychologicalStatus}"></c:out></td>
			</tr>
			<%--<tr>
				<th width="15%">左侧乳腺检查结果</th>
				<td><ehr:dic dicmeta="CV0410012" code="${postpartumDaysHealthInfo.lBreastExaminationResult}"></ehr:dic></td>
				<th width="15%">右侧乳腺检查结果</th>
				<td><ehr:dic dicmeta="CV0410012" code="${postpartumDaysHealthInfo.rBreastCheckResult}"></ehr:dic></td>
			</tr>--%>
			<tr>
				<th>乳房</th>
				<td>
					<c:choose>
						<c:when test="${postpartumDaysHealthInfo.breastAnomalySign eq '0' || postpartumDaysHealthInfo.breastAnomalySign eq null}">未见异常</c:when>
						<c:when test="${postpartumDaysHealthInfo.breastAnomalySign eq '1' && postpartumDaysHealthInfo.breastAnomalyDesc eq null}"></c:when>
						<c:otherwise>异常 ${postpartumDaysHealthInfo.breastAnomalyDesc}</c:otherwise>
					</c:choose>
				</td>
				<th>分娩日期</th>
				<td>
					<fmt:formatDate value="${postpartumDaysHealthInfo.deliveryDate}" pattern="yyyy/MM/dd"/>
				</td>
			</tr>
			<tr>
				<th>恶露</th>
				<td>
					<c:choose>
						<c:when test="${postpartumDaysHealthInfo.lochiaAnomalySign eq '0' || postpartumDaysHealthInfo.lochiaAnomalySign eq null}">未见异常</c:when>
						<c:when test="${postpartumDaysHealthInfo.lochiaAnomalySign eq '1' && postpartumDaysHealthInfo.lochiaCondition eq null}"></c:when>
						<c:otherwise>异常 ${postpartumDaysHealthInfo.lochiaCondition}</c:otherwise>
					</c:choose>
				</td>
				<th>出院日期</th>
				<td>
					<fmt:formatDate value="${postpartumDaysHealthInfo.leaveHospitalDate}" pattern="yyyy/MM/dd"/>
				</td>
			</tr>
			<tr>
				<th>子宫</th>
				<td colspan="3">
					<c:choose>
						<c:when test="${postpartumDaysHealthInfo.corpusAnomaly eq '0' || postpartumDaysHealthInfo.corpusAnomaly eq null}">未见异常</c:when>
						<c:when test="${postpartumDaysHealthInfo.corpusAnomaly eq '1' && postpartumDaysHealthInfo.corpusAnomalyDesc eq null}"></c:when>
						<c:otherwise>异常 ${postpartumDaysHealthInfo.corpusAnomalyDesc}</c:otherwise>
					</c:choose>
				</td>
			</tr>
			<tr>
				<th>伤口</th>
				<td colspan="3">
					<c:choose>
						<c:when test="${postpartumDaysHealthInfo.woundAnomalySign eq '0' || postpartumDaysHealthInfo.woundAnomalySign eq null}">未见异常</c:when>
						<c:when test="${postpartumDaysHealthInfo.woundAnomalySign eq '1' && postpartumDaysHealthInfo.woundAnomalyDesc eq null}"></c:when>
						<c:otherwise>异常 ${postpartumDaysHealthInfo.woundAnomalyDesc}</c:otherwise>
					</c:choose>
				</td>
			</tr>
			<%--<tr>
				<th>伤口愈合状况</th>
				<td colspan="3">
					<ehr:dic dicmeta="CV0501011" code="${postpartumDaysHealthInfo.woundHealingStatus}"></ehr:dic>
				</td>
			</tr>--%>
			<tr>
				<th>其他</th>
				<td colspan="3">
					<c:out value="${postpartumDaysHealthInfo.other}"></c:out>
				</td>
			</tr>
			<tr>
				<th>分类</th>
				<td colspan="3">
					<c:choose>
						<c:when test="${postpartumDaysHealthInfo.classifyFlag eq '0' || postpartumDaysHealthInfo.classifyFlag eq null}">已恢复</c:when>
						<c:when test="${postpartumDaysHealthInfo.classifyFlag eq '1' && postpartumDaysHealthInfo.classifyDesc eq null}"></c:when>
						<c:otherwise>未恢复 ${postpartumDaysHealthInfo.classifyDesc}</c:otherwise>
					</c:choose>
                    <%--<c:if test="${!empty postpartumDaysHealthInfo.puerperaRestoresMark}">
					    <c:out value='${postpartumDaysHealthInfo.puerperaRestoresMark eq "1" ? "已恢复" : "未恢复"}'></c:out>
                    </c:if>--%>
				</td>
			</tr>
			<%--<tr>
				<th>健康评估</th>
				<td colspan="3">
					<c:out value='${postpartumDaysHealthInfo.healthAssessmentDesc}'></c:out>
				</td>
			</tr>--%>
			<tr>
				<th>指导</th>
				<td colspan="3">
					<ehr:dic dicmeta="CV0600219" code="${postpartumDaysHealthInfo.healthGuidanceClass}"></ehr:dic>
					<c:choose>
						<c:when test="${postpartumDaysHealthInfo.healthGuidanceClass eq '99'}"></c:when>
						<c:otherwise>${postpartumDaysHealthInfo.healthGuidanceDesc}</c:otherwise>
					</c:choose>
				</td>
			</tr>
			<tr>
				<th>中医药健康管理服务</th>
				<td colspan="3">
					<ehr:dic code="${postpartumDaysHealthInfo.cmHealthManage}" dicmeta="FS10307"/>
					<c:if test="${fn:contains(postpartumDaysHealthInfo.cmHealthManage,'99')}">
						${postpartumDaysHealthInfo.cmHealthManageDesc}
					</c:if>
				</td>
			</tr>
			<tr>
				<th>处理</th>
				<td colspan="3">
					<c:if test='${postpartumDaysHealthInfo.finalMark eq "0"}'>
						结案
					</c:if>
					<c:if test='${postpartumDaysHealthInfo.finalMark eq "1"}'>
						转诊&nbsp;&nbsp;&nbsp;机构及科室：
						<c:out value="${postpartumDaysHealthInfo.referralHospitalName}"></c:out>
						<c:out value="${postpartumDaysHealthInfo.referralDeptName}"></c:out>
						&nbsp;&nbsp;
						原因：<c:out value="${postpartumDaysHealthInfo.referralReason}"></c:out>
					</c:if>
				</td>
				<%--<th>机构及科室</th>
				<td>
					<c:out value="${postpartumDaysHealthInfo.referralHospitalName}"></c:out>
					<c:out value="${postpartumDaysHealthInfo.referralDeptName}"></c:out>
				</td>--%>
			</tr>
			<tr>
                <th>随访机构</th>
                <td colspan="3"><c:out value="${postpartumDaysHealthInfo.createOrganName}"></c:out></td>
            </tr>
			<tr>
				<th>随访日期</th>
				<td>
					<fmt:formatDate value="${postpartumDaysHealthInfo.supervisionDate}" pattern="yyyy/MM/dd"/>
				</td>
				<th>随访医生签名</th>
				<td><ehr:staff-name staffCode="${postpartumDaysHealthInfo.supervisionDoctor}"/></td>
			</tr>
		</table>
	</div>
</div>