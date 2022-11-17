<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/views/ehrbrowser/basic/basic.css" />

<div>
	<ul>
		<li style="text-align: center; font-size: 25px;">产后访视</li>
	</ul>
	<br/>
	<div class="table-basic-narrow">
		<table>
			<colgroup>
				<col style="width: 15%;"/>
	            <col style="width: 35%;"/>
				<col style="width: 15%;"/>
	            <col style="width: 35%;"/>
			</colgroup>
			<tr>
				<th width="15%">产妇姓名</th>
				<td><c:out value="${postnatalFollowup.name}"></c:out></td>
				<th width="15%">体温</th>
				<td><c:out value="${postnatalFollowup.temperature}"></c:out></td>
			</tr>
			<tr>
				<th width="15%">收缩压</th>
				<td><c:out value="${postnatalFollowup.sbp}"></c:out></td>
				<th width="15%">舒张压</th>
				<td><c:out value="${postnatalFollowup.dbp}"></c:out></td>
			</tr>
			<tr>
				<th width="15%">健康情况</th>
				<td><c:out value="${postnatalFollowup.healthStatus}"></c:out></td>
				<th width="15%">一般心理状况</th>
				<td><ehr:dic dicmeta="FS10175" code="${postnatalFollowup.psychologicalStatus}"></ehr:dic></td>
			</tr>
			<tr>
				<th width="15%">左侧乳腺检查结果</th>
				<td><ehr:dic dicmeta="CV0410012" code="${postnatalFollowup.lBreastExaminationResult}"></ehr:dic></td>
				<th width="15%">右侧乳腺检查结果</th>
				<td><ehr:dic dicmeta="CV0410012" code="${postnatalFollowup.rBreastCheckResult}"></ehr:dic></td>
			</tr>
			<tr>
				<th>乳房异常</th>
				<td colspan="3">
                    <c:if test="${!empty postnatalFollowup.breastAnomalyFlag}">
                        <c:choose>
                            <c:when test="${postnatalFollowup.breastAnomalyFlag eq '1'}">未见异常</c:when>
                            <c:otherwise>异常 ${postnatalFollowup.breastAnomalyDesc}</c:otherwise>
                        </c:choose>
					    <%--<c:out value='${postnatalFollowup.breastAnomalyFlag eq "1" ? "未见异常" : "异常 ".concat(postnatalFollowup.breastAnomalyDesc)}'></c:out>--%>
                    </c:if>
				</td>
			</tr>
			<tr>
				<th>恶露异常</th>
				<td colspan="3">
                    <c:if test="${!empty postnatalFollowup.lochiaAnomalyFlag}">
                        <c:choose>
                            <c:when test="${postnatalFollowup.lochiaAnomalyFlag eq '1'}">未见异常</c:when>
                            <c:otherwise>异常 ${postnatalFollowup.lochiaCondition}</c:otherwise>
                        </c:choose>
					    <%--<c:out value='${postnatalFollowup.lochiaAnomalyFlag eq "1" ? "未见异常" : "异常 ".concat(postnatalFollowup.lochiaCondition)}'></c:out>--%>
                    </c:if>
				</td>
			</tr>
			<tr>
				<th>宫体异常</th>
				<td colspan="3">
                    <c:if test="${!empty postnatalFollowup.corpusAnomalyFlag}">
                        <c:choose>
                            <c:when test="${postnatalFollowup.corpusAnomalyFlag eq '1'}">未见异常</c:when>
                            <c:otherwise>异常 ${postnatalFollowup.corpusAnomalyDesc}</c:otherwise>
                        </c:choose>
					    <%--<c:out value='${postnatalFollowup.corpusAnomalyFlag eq "1" ? "未见异常" : "异常 ".concat(postnatalFollowup.corpusAnomalyDesc)}'></c:out>--%>
                    </c:if>
				</td>
			</tr>
			<tr>
				<th>伤口异常</th>
				<td colspan="3">
                    <c:if test="${!empty postnatalFollowup.woundAnomalyFlag}">
                        <c:choose>
                            <c:when test="${postnatalFollowup.woundAnomalyFlag eq '1'}">未见异常</c:when>
                            <c:otherwise>异常 ${postnatalFollowup.woundAnomalyDesc}</c:otherwise>
                        </c:choose>
					    <%--<c:out value='${postnatalFollowup.woundAnomalyFlag eq "1" ? "未见异常" : "异常 ".concat(postnatalFollowup.woundAnomalyDesc)}'></c:out>--%>
                    </c:if>
				</td>
			</tr>
			<tr>
				<th>伤口愈合状况</th>
				<td colspan="3">
					<ehr:dic dicmeta="CV0501011" code="${postnatalFollowup.woundHealingStatus}"></ehr:dic>
				</td>
			</tr>
			<tr>
				<th>其它</th>
				<td colspan="3">
					<c:out value="${postnatalFollowup.other}"></c:out>
				</td>
			</tr>
			<tr>
				<th>健康评估</th>
				<td colspan="3">
                    <c:if test="${!empty postnatalFollowup.healthAnomalyFlag}">
                        <c:choose>
                            <c:when test="${postnatalFollowup.healthAnomalyFlag eq '0'}">未见异常</c:when>
                            <c:otherwise>异常 ${postnatalFollowup.healthAnomalyDesc}</c:otherwise>
                        </c:choose>
					    <%--<c:out value='${postnatalFollowup.healthAnomalyFlag eq "0" ? "未见异常" : "异常 ".concat(postnatalFollowup.healthAnomalyDesc)}'></c:out>--%>
                    </c:if>
				</td>
			</tr>
			<tr>
				<th>健康指导</th>
				<td>
					<ehr:dic dicmeta="CV0600219" code="${postnatalFollowup.healthGuidanceClass}"></ehr:dic>
				</td>
				<th>指导详细</th>
				<td>
					<c:out value="${postnatalFollowup.healthGuidanceDesc}"></c:out>
				</td>
			</tr>
			<tr>
				<th>是否转诊</th>
				<td <c:if test='${postnatalFollowup.referralFlag ne "1"}'> colspan="3" </c:if> >
                    <c:if test="${!empty postnatalFollowup.referralFlag}">
					    <c:out value='${postnatalFollowup.referralFlag eq "1" ? "是" : "否"}'></c:out>
                    </c:if>
				</td>
				<c:if test='${postnatalFollowup.referralFlag eq "1"}'>
					<th>机构及科室</th>
					<td>
						<c:out value="${postnatalFollowup.referralHospitalName}"></c:out>
						<c:out value="${postnatalFollowup.referralDeptName}"></c:out>
					</td>
				</c:if>
			</tr>
			<c:if test='${postnatalFollowup.referralFlag eq "1"}'>
				<tr>
					<th>转诊原因</th>
					<td colspan="3">
						<c:out value="${postnatalFollowup.referralReason}"></c:out>
					</td>
				</tr>
			</c:if>
			<tr>
				<th>访视时间</th>
				<td>
					<fmt:formatDate value="${postnatalFollowup.visitDate}" pattern="yyyy/MM/dd"/>
				</td>
				<th>访视医师</th>
				<td><c:out value="${postnatalFollowup.supervisionDoctor}"></c:out></td>
			</tr>
			<tr>
				<th>下次访视日期</th>
				<td colspan="3"><fmt:formatDate value="${postnatalFollowup.nextSupervisionDate}" pattern="yyyy/MM/dd"/></td>
			</tr>
		</table>
	</div>
</div>