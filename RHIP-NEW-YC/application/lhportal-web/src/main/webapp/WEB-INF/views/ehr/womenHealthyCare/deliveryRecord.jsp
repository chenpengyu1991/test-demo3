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
	      	<td class="crumbs"><div id="location" parentMenu="women-health" childMenu="deliveryRecord">当前位置:&gt;&gt;妇女保健&gt;&gt;分娩记录</div>
			</td>
	  	</tr>
	 </table>
<div style="background-color: white;">
<br>
	<ul>
		<li style="text-align: center; font-size: 25px;">分娩登记</li>
	</ul>
	<br>
	<div class="table-basic">
		产妇信息：
		<table>
			<colgroup>
				<col style="width: 20%;"/>
	            <col style="width: 30%;"/>
				<col style="width: 20%;"/>
	            <col style="width: 30%;"/>
			</colgroup>
			<tr>
				<th>编号</th>
				<td>
					<c:out value="${deliveryRecordInfo.recordNumber}"></c:out>
				</td>
				<th>妇女保健号</th>
				<td>
					<c:out value="${deliveryRecordInfo.womenHealthNumber}" ></c:out>
				</td>
			</tr>
			<tr>
				<th>分娩日期时间</th>
				<td>
					<fmt:formatDate value="${deliveryRecordInfo.deliveryDate}" pattern="yyyy/MM/dd HH:mm:ss"></fmt:formatDate>
				</td>
				<th>分娩孕周(d)</th>
				<td>
					<c:out value="${deliveryRecordInfo.deliveryWeek}"></c:out>
				</td>
			</tr>
			<tr>
				<th>分娩方式</th>
				<td>
					<ehr:dic code="${deliveryRecordInfo.deliveryWay}" dicmeta="CV0210003"></ehr:dic>
				</td>
				<th>分娩结局</th>
				<td>
					<c:out value="${deliveryRecordInfo.deliveryOutcome}"></c:out>
				</td>
			</tr>
			<tr>
				<th>分娩机构</th>
				<td>
					<c:out value="${deliveryRecordInfo.deliveryHospitalName}"></c:out>
				</td>
				<th>分娩结局</th>
				<td>
					<c:out value="${deliveryRecordInfo.deliveryOutcome}"></c:out>
				</td>
			</tr>
			<tr>
				<th>总产程时长(min)</th>
				<td>
					<c:out value="${deliveryRecordInfo.totalLaborRuntime}"></c:out>
				</td>
				<th>第一产程时长(min)</th>
				<td>
					<c:out value="${deliveryRecordInfo.firstTotalLaborRuntime}"></c:out>
				</td>
			</tr>
			<tr>
				<th>第二产程时长(min)</th>
				<td>
					<c:out value="${deliveryRecordInfo.secondTotalLaborRuntime}"></c:out>
				</td>
				<th>第三产程时长(min)</th>
				<td>
					<c:out value="${deliveryRecordInfo.thirdTotalLaborRuntime}"></c:out>
				</td>
			</tr>
			<tr>
				<th>产后开奶时长(min)</th>
				<td colspan="3">
					<c:out value="${deliveryRecordInfo.postpartumOpenMilkRuntime}"></c:out>
				</td>
			</tr>
			<tr>
				<th>产时出血量(mL)</th>
				<td>
					<c:out value="${deliveryRecordInfo.deliveryBleed}"></c:out>
				</td>
				<th>分娩总出血量(mL)</th>
				<td>
					<c:out value="${deliveryRecordInfo.deliveryTotalBleed}"></c:out>
				</td>
			</tr>
			<tr>
				<th>产后2小时出血量(mL)</th>
				<td colspan="3">
					<c:out value="${deliveryRecordInfo.deliveryBleedAfterTwoHours}"></c:out>
				</td>
			</tr>
			<tr>
				<th>产妇会阴-切开</th>
				<td colspan="3">
                    <c:if test="${!empty deliveryRecordInfo.perineumCutFlag}">
					    <c:out value='${deliveryRecordInfo.perineumCutFlag eq "1" ? "是" : "否"}'></c:out>
                    </c:if>
				</td>
			</tr>
			<c:if test='${deliveryRecordInfo.perineumCutFlag eq "1"}'>
				<tr>
					<th>产妇会阴裂伤程度</th>
					<td>
						<ehr:dic code="${deliveryRecordInfo.perineumTearDegree}" dicmeta="CV0501010"></ehr:dic>
					</td>
					<th>产妇会阴缝合针数</th>
					<td>
						<c:out value="${deliveryRecordInfo.perineumTearNeedleNumber}"></c:out>
					</td>
				</tr>
			</c:if>
			<tr>
				<th>危重孕产妇标志</th>
				<td colspan="3">
                    <c:if test="${!empty deliveryRecordInfo.severeMaternalFlag}">
					    <c:out value='${deliveryRecordInfo.severeMaternalFlag eq "1" ? "是" : "否"}'></c:out>
                    </c:if>
					<c:if test='${deliveryRecordInfo.severeMaternalFlag eq "1"}'>
						<ehr:dic code="${deliveryRecordInfo.perineumTearDegree}" dicmeta="CV0300402"></ehr:dic>
					</c:if>
				</td>
			</tr>
			<tr>
				<th>产时并发症</th>
				<td colspan="3">
					<ehr:dic code="${deliveryRecordInfo.complicationsCode}" dicmeta="CV0501009"></ehr:dic>
				</td>
			</tr>
			<tr>
				<th>产后收缩压(mmHg)</th>
				<td>
					<c:out value="${deliveryRecordInfo.systolicPressure}" ></c:out>
				</td>
				<th>产后舒张压(mmHg)</th>
				<td>
					<c:out value="${deliveryRecordInfo.diastolicPressure}" ></c:out>
				</td>
			</tr>
			<tr>
				<th>胎数</th>
				<td>
					<c:out value="${deliveryRecordInfo.gestationalNumber}"></c:out>
				</td>
				<th>产妇结局</th>
				<td>
					<ehr:dic code="${deliveryRecordInfo.puerperaResult}" dicmeta="FS10035"></ehr:dic>
				</td>
			</tr>
		</table>
		<br/>
		<br/>
		新生儿信息：
		<table>
			<colgroup>
				<col style="width: 20%;"/>
	            <col style="width: 30%;"/>
				<col style="width: 20%;"/>
	            <col style="width: 30%;"/>
			</colgroup>
			<tr>
				<th>新生儿性别</th>
				<td>
					<ehr:dic code="${deliveryRecordInfo.neonatalGender}" dicmeta="GBT226112003"></ehr:dic>
				</td>
				<th>出生日期时间</th>
				<td>
					<fmt:formatDate value="${deliveryRecordInfo.neonatalBirthday}" pattern="yyyy/MM/dd HH:mm:ss"/>
				</td>
			</tr>
			<tr>
				<th>出生体重(g)</th>
				<td>
					<c:out value="${deliveryRecordInfo.birthWeight}"></c:out>
				</td>
				<th>出生身长(cm)</th>
				<td>
					<c:out value="${deliveryRecordInfo.birthStature}"></c:out>
				</td>
			</tr>
			<tr>
				<th>出生头围(cm)</th>
				<td>
					<c:out value="${deliveryRecordInfo.birthheadCircumference}"></c:out>
				</td>
				<th>出生胸围(cm)</th>
				<td>
					<c:out value="${deliveryRecordInfo.birthChestCircumference}"></c:out>
				</td>
			</tr>
			<tr>
				<th>出生缺陷标志</th>
				<td colspan="3">
                    <c:if test="${!empty deliveryRecordInfo.birthDefectFlag}">
					    <c:out value='${deliveryRecordInfo.birthDefectFlag eq "1" ? "是" : "否"}'></c:out>
                    </c:if>
					<c:if test='${deliveryRecordInfo.birthDefectFlag eq "1"}'>
						<ehr:dic code="${deliveryRecordInfo.birthDefectType}" dicmeta="CV0501016"></ehr:dic>
					</c:if>
				</td>
			</tr>
			<tr>
				<th>Apgar评分值(分)，1分钟</th>
				<td>
					<c:out value="${deliveryRecordInfo.apgarValueOne}"></c:out>
				</td>
				<th>Apgar评分值(分)，5分钟</th>
				<td>
					<c:out value="${deliveryRecordInfo.apgarValueFive}"></c:out>
				</td>
			</tr>
			<tr>
				<th>Apgar评分值(分)，10分钟</th>
				<td colspan="3">
					<c:out value="${deliveryRecordInfo.apgarValueTen}"></c:out>
				</td>
			</tr>
			<tr>
				<th>新生儿抢救标志</th>
				<td colspan="3">
                    <c:if test="${!empty deliveryRecordInfo.neonatalRescueFlag}">
					    <c:out value='${deliveryRecordInfo.neonatalRescueFlag eq "1" ? "是" : "否"}'></c:out>
                    </c:if>
					<c:if test='${deliveryRecordInfo.neonatalRescueFlag eq "1"}'>
						<ehr:dic code="${deliveryRecordInfo.neonatalRescueMethod}" dicmeta="CV0600108"></ehr:dic>
					</c:if>
				</td>
			</tr>
			<tr>
				<th>新生儿并发症标志</th>
				<td colspan="3">
                    <c:if test="${!empty deliveryRecordInfo.neonatalComplicationsFlag}">
					    <c:out value='${deliveryRecordInfo.neonatalComplicationsFlag eq "1" ? "是" : "否"}'></c:out>
                    </c:if>
					<c:if test='${deliveryRecordInfo.neonatalComplicationsFlag eq "1"}'>
						<ehr:dic code="${deliveryRecordInfo.neonatalComplicationsCode}" dicmeta="CV0501013"></ehr:dic>
					</c:if>
				</td>
			</tr>
			<tr>
				<th>新生儿处理及指导意见</th>
				<td colspan="3">
					<c:out value="${deliveryRecordInfo.neonatalMgOpinion}"></c:out>
				</td>
			</tr>
			<tr>
				<th>新生儿死亡标志</th>
				<td colspan="3">
                    <c:if test="${!empty deliveryRecordInfo.neonatalDeadFlag}">
					    <c:out value='${deliveryRecordInfo.neonatalDeadFlag eq "1" ? "是" : "否"}'></c:out>
                    </c:if>
				</td>
			</tr>
			<c:if test='${deliveryRecordInfo.neonatalDeadFlag eq "1"}'>
				<tr>
					<th>新生儿死亡原因</th>
					<td>
						<c:out value="${deliveryRecordInfo.neonatalDeadReason}"></c:out>
					</td>
					<th>新生儿死亡日期时间</th>
					<td>
						<fmt:formatDate value="${deliveryRecordInfo.deathDate}" pattern="yyyy/MM/dd HH:mm:ss"/>
					</td>
				</tr>
			</c:if>
			<tr>
				<th>助产机构名称</th>
				<td>
					<c:out value="${deliveryRecordInfo.midwiferyOrganName}"></c:out>
				</td>
				<th>助产人员姓名</th>
				<td>
					<c:out value="${deliveryRecordInfo.midwiferyName}"></c:out>
				</td>
			</tr>
		</table>
	</div>
</div>
</div>