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
		<li style="text-align: center; font-size: 25px;">产后42天健康检查记录</li>
	</ul>
	<br />
	<div class="table-basic" style="overflow: inherit">
		<table class="layui-table x-admin-sm-table-list-small">
			<colgroup>
				<col style="width: 20%;"/>
				<col style="width: 30%;"/>
				<col style="width: 20%;"/>
				<col style="width: 30%;"/>
			</colgroup>
			<tr>
				<th>健康档案编号</th>
				<td colspan="3">
					<c:out value="${whYcfbjChjc.healthFileNo}"></c:out>
				</td>
<%--				<th>孕产妇编号</th>--%>
<%--				<td>--%>
<%--					<c:out value="${whYcfbjChjc.recordNumber}" ></c:out>--%>
<%--				</td>--%>
			</tr>
			<tr>
				<th>姓名</th>
				<td>
					<c:out value="${whYcfbjChjc.name}"></c:out>
				</td>
				<th>随访日期</th>
				<td>
					<fmt:formatDate value="${whYcfbjChjc.supervisionDate}" pattern="yyyy/MM/dd"></fmt:formatDate>
				</td>
			</tr>
			<tr>
				<th>分娩日期</th>
				<td colspan="3">
					<fmt:formatDate value="${whYcfbjChjc.deliveryDate}" pattern="yyyy/MM/dd"></fmt:formatDate>
				</td>
			</tr>
			<tr>
				<th>出院日期</th>
				<td colspan="3">
					<fmt:formatDate value="${whYcfbjChjc.leaveHospitalDate}" pattern="yyyy/MM/dd"></fmt:formatDate>
				</td>
			</tr>
			<tr>
				<th>一般健康情况</th>
				<td colspan="3">
					<c:out value="${whYcfbjChjc.healthStatus}"></c:out>
				</td>
			</tr>
			<tr>
				<th>一般心理情况</th>
				<td colspan="3">
					<c:out value="${whYcfbjChjc.psychologicalStatus}"></c:out>
				</td>
			</tr>
			<tr>
				<th>舒张压</th>
				<td>
					${whYcfbjChjc.dbp}mmHg
				</td>
				<th>收缩压</th>
				<td>
					${whYcfbjChjc.sbp}mmHg
				</td>
			</tr>
			<tr>
				<th>乳房情况</th>
				<%--未见异常/异常判断--%>
				<c:if test="${whYcfbjChjc.breastAnomalySign eq '0'}">
					<td colspan="3">
						未见异常
					</td>
				</c:if>
				<c:if test="${whYcfbjChjc.breastAnomalySign eq '1'}">
					<td>异常</td>
					<th>乳房异常详述</th>
					<td><c:out value="${whYcfbjChjc.breastAnomalyDesc}"></c:out></td>
				</c:if>
			</tr>
			<tr>
				<th>恶露情况</th>
				<%--未见异常/异常判断--%>
				<c:if test="${whYcfbjChjc.lochiaAnomalySign eq '0'}">
					<td colspan="3">
						未见异常
					</td>
				</c:if>
				<c:if test="${whYcfbjChjc.lochiaAnomalySign eq '1'}">
					<td>异常</td>
					<th>恶露异常详述</th>
					<td><c:out value="${whYcfbjChjc.lochiaCondition}"></c:out></td>
				</c:if>
			</tr>
			<tr>
				<th>子宫情况</th>
				<%--未见异常/异常判断--%>
				<c:if test="${whYcfbjChjc.corpusAnomaly eq '0'}">
					<td colspan="3">
						未见异常
					</td>
				</c:if>
				<c:if test="${whYcfbjChjc.corpusAnomaly eq '1'}">
					<td>异常</td>
					<th>子宫异常详述</th>
					<td><c:out value="${whYcfbjChjc.corpusAnomalyDesc}"></c:out></td>
				</c:if>
			</tr>
			<tr>
				<th>伤口情况</th>
				<%--未见异常/异常判断--%>
				<c:if test="${whYcfbjChjc.woundAnomalySign eq '0'}">
					<td colspan="3">
						未见异常
					</td>
				</c:if>
				<c:if test="${whYcfbjChjc.woundAnomalySign eq '1'}">
					<td>异常</td>
					<th>伤口异常详述</th>
					<td><c:out value="${whYcfbjChjc.woundAnomalyDesc}"></c:out></td>
				</c:if>
			</tr>
			<tr>
				<th>其他异常详述</th>
				<td colspan="3"><c:out value="${whYcfbjChjc.other}"></c:out></td>
			</tr>
			<tr>
				<th>本次访视分类</th>
				<%--已恢复/未恢复判断--%>
				<c:if test="${whYcfbjChjc.classifyFlag eq '0'}">
					<td colspan="3">
						已恢复
					</td>
				</c:if>
				<c:if test="${whYcfbjChjc.classifyFlag eq '1'}">
					<td>未恢复</td>
					<th>本次分类异常详述</th>
					<td><c:out value="${whYcfbjChjc.classifyDesc}"></c:out></td>
				</c:if>
			</tr>
			<tr>
				<%--孕产妇产后指导代码表--%>
					<th>产后健康指导</th>
					<td colspan="3">
						<ehr:dic code="${whYcfbjChjc.healthGuidanceClass}" dicmeta="CV0600219"/>
						<c:if test="${whYcfbjChjc.healthGuidanceClass eq '99'}">
							<c:out value="${whYcfbjChjc.healthGuidanceDesc}"></c:out>
						</c:if>
					</td>
			</tr>
			<tr>
				<th>处理</th>
				<%--产后42天健康健康处理代码表--%>
				<td colspan="3">
					<c:if test="${whYcfbjChjc.finalMark eq '1'}">转诊</c:if>
                    <c:if test="${whYcfbjChjc.finalMark eq '0'}">结案</c:if>
				</td>
			</tr>
			<c:if test="${whYcfbjChjc.finalMark eq '1'}">
				<tr>
					<th>转诊原因</th>
					<td colspan="3">
						<c:out value="${whYcfbjChjc.referralReason}"></c:out>
					</td>
				</tr>
				<tr>
					<th>转诊机构</th>
					<td>
						<c:out value="${whYcfbjChjc.referralHospitalName}"></c:out>
					</td>
					<th>转诊机构科室</th>
					<td>
						<c:out value="${whYcfbjChjc.referralDeptName}"></c:out>
					</td>
				</tr>
			</c:if>
			<tr>
				<th>随访机构</th>
				<td>
					<c:out value="${whYcfbjChjc.createOrganName}"></c:out>
				</td>
				<th>随访医生</th>
				<td>
					<ehr:staff-name staffCode="${whYcfbjChjc.supervisionDoctor}"/>
				</td>
			</tr>
		</table>
	</div>
</div>