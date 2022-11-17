<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/views/ehrbrowser/basic/basic.css" />
<script src="${pageContext.request.contextPath}/js/views/woman/PostpartumVisit/revert.js" type="text/javascript" ></script>
<div class="toolbar" id="womenhide">
	<a href="javascript:void(0)" id="revert"><button class="btn-gray layui-btn layui-btn-sm button"><i class="layui-icon"></i>返回</button></a>
</div>
<div style="background-color: white;" class="divFixed65">
	<br/>
	<br/>
	<ul>
		<li style="text-align: center; font-size: 25px;">产后访视记录表</li>
	</ul>
	<br/>
	<div class="table-basic">
		<table class="layui-table x-admin-sm-table-list-small">
			<colgroup>
				<col style="width: 15%;"/>
	            <col style="width: 35%;"/>
				<col style="width: 15%;"/>
	            <col style="width: 35%;"/>
			</colgroup>
			<tr>
				<th width="15%">姓名</th>
				<td><c:out value="${postnatalFollowup.name}"></c:out></td>
				<th width="15%">健康档案编号</th>
				<td><c:out value="${postnatalFollowup.healthFileNo}"></c:out></td>
			</tr>
			<tr>
				<th width="15%">身份证号</th>
				<td><c:out value="${postnatalFollowup.idCard}"></c:out></td>
				<th width="15%">体温</th>
				<td><c:out value="${postnatalFollowup.temperature}"></c:out>℃</td>
			</tr>
			<%--<tr>
				<th width="15%">收缩压</th>
				<td><c:out value="${postnatalFollowup.sbp}"></c:out></td>
				<th width="15%">舒张压</th>
				<td><c:out value="${postnatalFollowup.dbp}"></c:out></td>
			</tr>--%>
			<tr>
				<th width="15%">一般健康情况</th>
				<td><c:out value="${postnatalFollowup.healthStatus}"></c:out></td>
				<th width="15%">一般心理状况</th>
				<td>
                    ${postnatalFollowup.psychologicalStatus}
                </td>
			</tr>
			<tr>
				<th width="15%">血压</th>
				<td><c:out value="${postnatalFollowup.sbp}"></c:out>/
				<c:out value="${postnatalFollowup.dbp}"></c:out>mmHg</td>
                <th width="15%">随访机构</th>
                <td><c:out value="${postnatalFollowup.createOrganName}"></c:out></td>
			</tr>
			<tr>
				<th>乳房</th>
				<td>
                        <c:choose>
                            <c:when test="${postnatalFollowup.breastAnomalyFlag eq '0' || postnatalFollowup.breastAnomalyFlag eq null}">未见异常</c:when>
                            <c:when test="${postnatalFollowup.breastAnomalyFlag eq '1'}">异常 ${postnatalFollowup.breastAnomalyDesc}</c:when>
                            <c:otherwise></c:otherwise>
                        </c:choose>
				</td>
				<th>分娩日期</th>
				<td><fmt:formatDate value="${postnatalFollowup.deliveryDate}" pattern="yyyy/MM/dd"/></td>
			</tr>
			<tr>
				<th>恶露</th>
				<td>
                        <c:choose>
                            <c:when test="${postnatalFollowup.lochiaAnomalyFlag eq '0' || postnatalFollowup.lochiaAnomalyFlag eq null}">未见异常</c:when>
                            <c:when test="${postnatalFollowup.lochiaAnomalyFlag eq '1'}">异常 ${postnatalFollowup.lochiaCondition}</c:when>
                            <c:otherwise></c:otherwise>
                        </c:choose>
				</td>
				<th>出院日期</th>
				<td><fmt:formatDate value="${postnatalFollowup.leaveHospitalDate}" pattern="yyyy/MM/dd"/></td>
			</tr>
			<tr>
				<th>子宫</th>
				<td colspan="3">
                        <c:choose>
                            <c:when test="${postnatalFollowup.corpusAnomalyFlag eq '0' || postnatalFollowup.corpusAnomalyFlag eq null}">未见异常</c:when>
                            <c:when test="${postnatalFollowup.corpusAnomalyFlag eq '1'}">异常 ${postnatalFollowup.corpusAnomalyDesc}</c:when>
                            <c:otherwise></c:otherwise>
                        </c:choose>
				</td>
			</tr>
			<tr>
				<th>伤口</th>
				<td colspan="3">
                        <c:choose>
                            <c:when test="${postnatalFollowup.woundAnomalyFlag eq '0' || postnatalFollowup.woundAnomalyFlag eq null}">未见异常</c:when>
                            <c:when test="${postnatalFollowup.woundAnomalyFlag eq '1'}">异常 ${postnatalFollowup.woundAnomalyDesc}</c:when>
                            <c:otherwise></c:otherwise>
                        </c:choose>
				</td>
			</tr>
			<%--<tr>
				<th>伤口愈合状况</th>
				<td colspan="3">
					<ehr:dic dicmeta="CV0501011" code="${postnatalFollowup.woundHealingStatus}"></ehr:dic>
				</td>
			</tr>--%>
			<tr>
				<th>其他</th>
				<td colspan="3">
					<c:out value="${postnatalFollowup.other}"></c:out>
				</td>
			</tr>
			<tr>
				<th>分类</th>
				<td colspan="3">
					<c:choose>
						<c:when test="${postnatalFollowup.classifyFlag eq '0' || postnatalFollowup.classifyFlag eq null}">未见异常</c:when>
						<c:when test="${postnatalFollowup.classifyFlag eq '1'}">异常 ${postnatalFollowup.classifyDesc}</c:when>
						<c:otherwise></c:otherwise>
					</c:choose>
				</td>
			</tr>
			<%--<tr>
				<th>健康评估</th>
				<td colspan="3">
                    <c:if test="${!empty postnatalFollowup.healthAnomalyFlag}">
                        <c:choose>
                            <c:when test="${postnatalFollowup.healthAnomalyFlag eq '0'}">未见异常</c:when>
                            <c:otherwise>异常 ${postnatalFollowup.healthAnomalyDesc}</c:otherwise>
                        </c:choose>
					    &lt;%&ndash;<c:out value='${postnatalFollowup.healthAnomalyFlag eq "0" ? "未见异常" : "异常".concat(postnatalFollowup.healthAnomalyDesc)}'></c:out>&ndash;%&gt;
                    </c:if>
				</td>
			</tr>--%>
			<tr>
				<th>指导</th>
				<td colspan="3">
					<ehr:dic dicmeta="CV0600219" code="${postnatalFollowup.healthGuidanceClass}"></ehr:dic>
				    <c:choose>
					<c:when test="${postnatalFollowup.healthGuidanceClass eq '99'}"></c:when>
					<c:otherwise>${postnatalFollowup.otherHealthGuidanceDesc}</c:otherwise>
				     </c:choose>
				</td>
			</tr>
			<tr>
				<th>转诊</th>
				<td <c:if test='${postnatalFollowup.referralFlag ne "1"}'> colspan="3" </c:if> >
                    <c:if test="${!empty postnatalFollowup.referralFlag}">
					    <c:out value='${postnatalFollowup.referralFlag eq "1" ? "有" : "无"}'></c:out>
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
				<th>中医药健康管理服务</th>
				<td colspan="3">
					<ehr:dic dicmeta="FS10307" code="${postnatalFollowup.cmediciManageFlag}"></ehr:dic>
					<c:choose>
						<c:when test="${postnatalFollowup.cmediciManageFlag eq '99'}"></c:when>
						<c:otherwise>${postnatalFollowup.otherCmediciManage}</c:otherwise>
					</c:choose>
				</td>
			</tr>
			<tr>
				<th>随访医师签名</th>
				<td>
					<ehr:staff-name staffCode="${postnatalFollowup.supervisionDoctor}"></ehr:staff-name>
				</td>
				<th>产妇签名</th>
				<td><c:out value="${postnatalFollowup.name}"></c:out></td>
			</tr>
			<tr>
				<th>随访时间</th>
				<td>
					<fmt:formatDate value="${postnatalFollowup.visitDate}" pattern="yyyy/MM/dd"/>
				</td>
				<th>下次随访日期</th>
				<td><fmt:formatDate value="${postnatalFollowup.nextSupervisionDate}" pattern="yyyy/MM/dd"/></td>
			</tr>
		</table>
	</div>
</div>