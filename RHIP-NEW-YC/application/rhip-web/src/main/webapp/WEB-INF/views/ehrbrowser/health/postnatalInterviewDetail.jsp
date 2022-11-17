<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/views/ehrbrowser/basic/basic.css" />
<script src="${pageContext.request.contextPath}/js/views/woman/PostpartumVisit/revert.js" type="text/javascript" ></script>
<div style="background-color: white; height: 515px;">
	<br/>
	<br/>
	<ul>
		<li style="text-align: center; font-size: 25px;">产后产妇访视</li>
	</ul>
	<br/>
	<div class="table-basic" style="overflow: inherit">
		<table class="layui-table x-admin-sm-table-list-small">
			<colgroup>
				<col style="width: 17%;"/>
	            <col style="width: 33%;"/>
				<col style="width: 17%;"/>
	            <col style="width: 33%;"/>
			</colgroup>
			<tr>
				<th width="15%">姓名</th>
				<td><c:out value="${postnatalInterview.name}"></c:out></td>
				<th width="15%">健康档案编号</th>
				<td><c:out value="${postnatalInterview.healthFileNo}"></c:out></td>
			</tr>
			<tr>
				<th>随访日期</th>
				<td colspan="3"><fmt:formatDate value="${postnatalInterview.visitDate}" pattern="yyyy/MM/dd"/></td>
			</tr>
			<tr>
				<th>出院日期</th>
				<td colspan="3"><fmt:formatDate value="${postnatalInterview.leaveHospitalDate}" pattern="yyyy/MM/dd"/></td>
			</tr>
			<tr>
				<th width="15%">一般健康情况</th>
				<td><c:out value="${postnatalInterview.healthStatus}"></c:out></td>
				<th width="15%">一般心理状况</th>
				<td>
                    ${postnatalInterview.psychologicalStatus}
                </td>
			</tr>
			<tr>
				<th width="15%">血压</th>
				<td><c:out value="${postnatalInterview.sbp}"></c:out>/<c:out value="${postnatalInterview.dbp}"></c:out> mmHg</td>
				<th width="15%">体温</th>
				<td><c:out value="${postnatalInterview.temperature}"></c:out>℃</td>
			</tr>
			<tr>
				<th>乳房</th>
				<td>
                    <%--未见异常/异常判断--%>
                    <c:choose>
                        <c:when test="${postnatalInterview.breastAnomalyFlag eq '0'}">未见异常</c:when>
                        <c:otherwise>${postnatalInterview.breastAnomalyDesc}</c:otherwise>
                    </c:choose>
				</td>
				<th>分娩日期</th>
				<td><fmt:formatDate value="${postnatalInterview.deliveryDate}" pattern="yyyy/MM/dd"/></td>
			</tr>
			<tr>
				<th>恶露</th>
				<td colspan="3">
                    <%--未见异常/异常判断--%>
					<c:choose>
						<c:when test="${postnatalInterview.lochiaAnomalyFlag eq '0'}">未见异常</c:when>
						<c:otherwise>${postnatalInterview.lochiaCondition}</c:otherwise>
					</c:choose>
				</td>
			</tr>
			<tr>
				<th>子宫</th>
				<td colspan="3">
                    <%--未见异常/异常判断--%>
                    <c:choose>
                        <c:when test="${postnatalInterview.corpusAnomalyFlag eq '0'}">未见异常</c:when>
                        <c:otherwise>${postnatalInterview.corpusAnomalyDesc}</c:otherwise>
                    </c:choose>
				</td>
			</tr>
			<tr>
				<th>伤口</th>
				<td colspan="3">
                    <%--未见异常/异常判断--%>
                    <c:choose>
                        <c:when test="${postnatalInterview.woundAnomalyFlag eq '0'}">未见异常</c:when>
                        <c:otherwise>${postnatalInterview.woundAnomalyDesc}</c:otherwise>
                    </c:choose>
				</td>
			</tr>
            <c:if test="${not empty postnatalInterview.other}">
                <tr>
                    <th>其他</th>
                    <td colspan="3">
                        <c:out value="${postnatalInterview.other}"></c:out>
                    </td>
                </tr>
            </c:if>
			<tr>
				<th>分类</th>
				<td colspan="3">
                    <%--未见异常/异常判断--%>
                    <c:choose>
                        <c:when test="${postnatalInterview.classifyFlag eq '0'}">未见异常</c:when>
                        <c:otherwise>${postnatalInterview.classifyDesc}</c:otherwise>
                    </c:choose>
				</td>
			</tr>
			<tr>
				<th>指导</th>
				<td colspan="3">
					<ehr:dic code="${postnatalInterview.healthGuidanceClass}" dicmeta="CV0600219"/>
					<c:if test="${fn:contains(postnatalInterview.healthGuidanceClass,'99')}">
						${postnatalInterview.otherHealthGuidanceDesc}
					</c:if>
				</td>
			</tr>
			<tr>
				<th>转诊</th>
				<td <c:if test='${postnatalInterview.referralFlag eq "0"}'> colspan="3" </c:if> >
                    <c:if test="${!empty postnatalInterview.referralFlag}">
						<c:if test="${postnatalInterview.referralFlag eq '1'}">有</c:if>
                        <c:if test="${postnatalInterview.referralFlag eq '0'}">无</c:if>
					</c:if>
				</td>
				<c:if test='${postnatalInterview.referralFlag eq "1"}'>
					<th>机构及科室</th>
					<td>
						${postnatalInterview.referralHospitalName} ${postnatalInterview.referralDeptName}
					</td>
				</c:if>
			</tr>
			<c:if test='${postnatalInterview.referralFlag eq "1"}'>
				<tr>
					<th>转诊原因</th>
					<td colspan="3">
						<c:out value="${postnatalInterview.referralReason}"></c:out>
					</td>
				</tr>
			</c:if>

			<tr>
				<th>下次随访日期</th>
				<td><fmt:formatDate value="${postnatalInterview.nextSupervisionDate}" pattern="yyyy/MM/dd"/></td>
				<th>随访医师签名</th>
				<%--<td><ehr:staff-list name="supervisionDoctor" value="${postnatalInterview.supervisionDoctor}" defaultval="Y" style="width:75%"/></td>--%>
				<td><ehr:staff-name staffCode="${postnatalInterview.supervisionDoctor}"/></td>
			</tr>
			<tr>
				<th>随访机构</th>
				<td colspan="3">
					<c:out value="${postnatalInterview.createOrganName}"/>
				</td>
			</tr>
		</table>
	</div>
</div>