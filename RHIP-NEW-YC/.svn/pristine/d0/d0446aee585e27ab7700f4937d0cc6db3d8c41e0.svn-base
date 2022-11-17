<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/views/ehrbrowser/basic/basic.css" />
<div class="rightnav">
	<table>
		<tr>
	      	<td class="crumbs"><div id="location" parentMenu="women-health" childMenu="postpartumDaysHealthInfo">当前位置:&gt;&gt;妇女保健&gt;&gt;产后42天随访</div>
			</td>
	  	</tr>
	 </table>
<div style="background-color: white;">
<br/>
	<ul>
		<li style="text-align: center; font-size: 25px;">产后42天健康检查登记表</li>
	</ul>
	<br/>
	<div class="table-basic">
		<table>
			<colgroup>
				<col style="width: 15%;"/>
	            <col style="width: 35%;"/>
				<col style="width: 15%;"/>
	            <col style="width: 35%;"/>
			</colgroup>
			<tr>
				<th width="15%">保健号</th>
				<td><c:out value="${postpartumDaysHealthInfo.recordNumber}"></c:out></td>
				<th width="15%">产妇姓名</th>
				<td><c:out value="${postpartumDaysHealthInfo.name}"></c:out></td>
			</tr>
			<tr>
				<th width="15%">收缩压</th>
				<td><c:out value="${postpartumDaysHealthInfo.sbp}"></c:out></td>
				<th width="15%">舒张压</th>
				<td><c:out value="${postpartumDaysHealthInfo.dbp}"></c:out></td>
			</tr>
			<tr>
				<th width="15%">健康情况</th>
				<td><c:out value="${postpartumDaysHealthInfo.healthStatus}"></c:out></td>
				<th width="15%">一般心理状况</th><%--2014-07-15 修改 刘洋，树枢确认常熟改字段传过来的是文字而非字典--%>
				<td><c:out value="${postpartumDaysHealthInfo.psychologicalStatus}"></c:out></td>
			</tr>
			<tr>
				<th width="15%">左侧乳腺检查结果</th>
				<td><ehr:dic dicmeta="CV0410012" code="${postpartumDaysHealthInfo.lBreastExaminationResult}"></ehr:dic></td>
				<th width="15%">右侧乳腺检查结果</th>
				<td><ehr:dic dicmeta="CV0410012" code="${postpartumDaysHealthInfo.rBreastCheckResult}"></ehr:dic></td>
			</tr>
			<tr>
				<th>乳房异常</th>
				<td colspan="3">
                    <c:if test="${!empty postpartumDaysHealthInfo.breastAnomalySign}">
                        <c:choose>
                            <c:when test="${postpartumDaysHealthInfo.breastAnomalySign eq '1'}">未见异常</c:when>
                            <c:otherwise>异常 ${postpartumDaysHealthInfo.breastAnomalyDesc}</c:otherwise>
                        </c:choose>
					    <%--<c:out value='${postpartumDaysHealthInfo.breastAnomalySign eq "1" ? "未见异常" : "异常 ".concat(postpartumDaysHealthInfo.breastAnomalyDesc)}'></c:out>--%>
                    </c:if>
				</td>
			</tr>
			<tr>
				<th>恶露异常</th>
				<td colspan="3">
                    <c:if test="${!empty postpartumDaysHealthInfo.lochiaAnomalySign}">
                        <c:choose>
                            <c:when test="${postpartumDaysHealthInfo.lochiaAnomalySign eq '1'}">未见异常</c:when>
                            <c:otherwise>异常 ${postpartumDaysHealthInfo.lochiaCondition}</c:otherwise>
                        </c:choose>
					    <%--<c:out value='${postpartumDaysHealthInfo.lochiaAnomalySign eq "1" ? "未见异常" : "异常 ".concat(postpartumDaysHealthInfo.lochiaCondition)}'></c:out>--%>
                    </c:if>
				</td>
			</tr>
			<tr>
				<th>宫体异常</th>
				<td colspan="3">
                    <c:if test="${!empty postpartumDaysHealthInfo.corpusAnomaly}">
                        <c:choose>
                            <c:when test="${postpartumDaysHealthInfo.corpusAnomaly eq '0'}">未见异常</c:when>
                            <c:otherwise>异常 ${postpartumDaysHealthInfo.corpusAnomalyDesc}</c:otherwise>
                        </c:choose>
					    <%--<c:out value='${postpartumDaysHealthInfo.corpusAnomaly eq "1" ? "未见异常" : "异常 ".concat(postpartumDaysHealthInfo.corpusAnomalyDesc)}'></c:out>--%>
                    </c:if>
				</td>
			</tr>
			<tr>
				<th>伤口异常</th>
				<td colspan="3">
                    <c:if test="${!empty postpartumDaysHealthInfo.woundAnomalySign}">
                        <c:choose>
                            <c:when test="${postpartumDaysHealthInfo.woundAnomalySign eq '0'}">未见异常</c:when>
                            <c:otherwise>异常 ${postpartumDaysHealthInfo.woundAnomalyDesc}</c:otherwise>
                        </c:choose>
					    <%--<c:out value='${postpartumDaysHealthInfo.woundAnomalySign eq "1" ? "未见异常" : "异常 ".concat(postpartumDaysHealthInfo.woundAnomalyDesc)}'></c:out>--%>
                    </c:if>
				</td>
			</tr>
			<tr>
				<th>伤口愈合状况</th>
				<td colspan="3">
					<ehr:dic dicmeta="CV0501011" code="${postpartumDaysHealthInfo.woundHealingStatus}"></ehr:dic>
				</td>
			</tr>
			<tr>
				<th>其它</th>
				<td colspan="3">
					<c:out value="${postpartumDaysHealthInfo.other}"></c:out>
				</td>
			</tr>
			<tr>
				<th>产妇恢复</th>
				<td colspan="3">
                    <c:if test="${!empty postpartumDaysHealthInfo.puerperaRestoresMark}">
					    <c:out value='${postpartumDaysHealthInfo.puerperaRestoresMark eq "1" ? "已恢复" : "未恢复"}'></c:out>
                    </c:if>
				</td>
			</tr>
			<tr>
				<th>健康评估</th>
				<td colspan="3">
					<c:out value='${postpartumDaysHealthInfo.healthAssessmentDesc}'></c:out>
				</td>
			</tr>
			<tr>
				<th>健康指导</th>
				<td>
					<ehr:dic dicmeta="CV0600219" code="${postpartumDaysHealthInfo.healthGuidanceClass}"></ehr:dic>
				</td>
				<th>指导详细</th>
				<td>
					<c:out value="${postpartumDaysHealthInfo.healthGuidanceDesc}"></c:out>
				</td>
			</tr>
			<tr>
				<th>处理</th>
				<td>
					<c:if test='${postpartumDaysHealthInfo.finalMark eq "1"}'>
						结案
					</c:if>
					<c:if test='${postpartumDaysHealthInfo.referralFlag eq "1"}'>
						转诊
					</c:if>
				</td>
				<th>机构及科室</th>
				<td>
					<c:out value="${postpartumDaysHealthInfo.referralHospitalName}"></c:out>
					<c:out value="${postpartumDaysHealthInfo.referralDeptName}"></c:out>
				</td>
			</tr>
			<tr>
				<th>原因</th>
				<td colspan="3">
					<c:out value="${postpartumDaysHealthInfo.referralReason}"></c:out>
				</td>
			</tr>
			<tr>
				<th>访视时间</th>
				<td>
					<fmt:formatDate value="${postpartumDaysHealthInfo.supervisionDate}" pattern="yyyy/MM/dd"/>
				</td>
				<th>访视医师</th>
				<td><c:out value="${postpartumDaysHealthInfo.supervisionDoctor}"></c:out></td>
			</tr>
		</table>
	</div>
</div>
</div>