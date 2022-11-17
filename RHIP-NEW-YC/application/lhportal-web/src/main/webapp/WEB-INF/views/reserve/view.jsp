<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<%@ page import="com.founder.rhip.portal.common.HospitalCodeForYC" %>
<c:set var="MATERNAL_CHILD_HOSPITAL" value="<%=HospitalCodeForYC.MATERNAL_CHILD_HOSPITAL.getHospitalCode()%>"/>
<c:set var="CHINESE_MEDICINE_HOSPITAL" value="<%=HospitalCodeForYC.CHINESE_MEDICINE_HOSPITAL.getHospitalCode()%>"/>
<c:set var="STOMATOLOGICAL_HOSPITAL" value="<%=HospitalCodeForYC.STOMATOLOGICAL_HOSPITAL.getHospitalCode()%>"/>

<div class="navRight" id="contentDiv">
	<div class="location">
		当前位置:<label>预约挂号</label>&gt;&gt;<label>我的预约</label>
	</div>
	<div style="font-size: 20px;font-family: 微软雅黑;text-align: center;height: 35px;">
		预约单
	</div>
	<div style="border: 1px solid #a9c3d0;width: 860px;margin-bottom:10px">
		<table class="infoListTable" style="width:840px">
			<tr>
				<td colspan="2">
					<br/>
					<div class="sucessInfo" <c:if test="${reserveRegister.reserverStauts!='01'}"> style="display:none" </c:if> >
					 <span class="fontInfo">友情提醒：</span><br/>
						<span>请牢记预约查询码：</span>
						<span class="fontInfo">${reserveRegister.searchCode}</span>
						<span>凭本人身份证和预约查询码到医院就诊</span><br/>
						<span class="fontInfo">请于<fmt:formatDate value="${reserveRegister.requestDate }" pattern="yyyy年MM月dd日"/>
						<c:if test="${reserveRegister.ampm eq 'a'}">上午 </c:if><c:if test="${reserveRegister.ampm eq 'p'}">下午 </c:if>
						<c:if test="${MATERNAL_CHILD_HOSPITAL != reserveRegister.hospitalCode || 
									CHINESE_MEDICINE_HOSPITAL != reserveRegister.hospitalCode || 
									STOMATOLOGICAL_HOSPITAL != reserveRegister.hospitalCode} ">
							${reserveRegister.takeNoTimeStart}~${reserveRegister.takeNoTimeEnd}
						</c:if>
						到医院取号！</span>
					</div>
				</td>
			</tr>
			<tr>
				<td colspan="2">&nbsp;</td>
			</tr>
			<tr>
				<td class="lefttd">
					患者信息
				</td>
				<td>
					<table class="reserveTable">
						<tr>
							<th>身份证：</th>
							<td><c:out value="${fn:replace(reserveRegister.idcard,fn:substring(reserveRegister.idcard,6,14), '********')}" /></td>
							<th>姓名：</th>
							<td>${reserveRegister.name}</td>
						</tr>
						<tr>
							<th>出生日期：</th>
							<td>
								<fmt:formatDate value="${reserveRegister.birthday}" pattern="yyyy年MM月"/>
							</td>
							<th>性别：</th>
							<td><ehr:dic code="${reserveRegister.gender}" dicmeta="GBT226112003"/></td>
						</tr>
						<tr>
							<%-- <th>工作单位：</th>
							<td>${reserveRegister.unitName}</td> --%>
							<th>电话：</th>
							<td colspan="3">${reserveRegister.phoneNumber}</td>
						</tr>
						<%-- <tr>
							<th>医保卡号：</th>
							<td>${reserveRegister.idcardHos}</td>
							<th>新农合号：</th>
							<td>${reserveRegister.idcardFarm}</td>
						</tr> --%>
						<%-- <tr>
							<th>现地址：</th>
							<td colspan="3">
								<ehr:dic dicmeta="FS990001" code="${reserveRegister.patownShip}"></ehr:dic>
			                    <ehr:dic dicmeta="FS990001" code="${reserveRegister.pastreet}"></ehr:dic>
								${reserveRegister.pahouseNumber}
							</td>
						</tr> --%>
					</table>
				</td>
			</tr>
			<tr>
				<td colspan="2">&nbsp;</td>
			</tr>
			<tr>
				<td class="lefttd">
					号源信息
				</td>
				<td>
					<table class="reserveTable">
						<tr>
							<th>医院：</th>
							<td>
								${reserveRegister.hospitalName}
							</td>
							<th>科室：</th>
							<td>
								${reserveRegister.deptName}
							</td>
						</tr>
						<tr>
							<th>医生：</th>
							<td>
								${reserveRegister.doctorName}
							</td>
							<th>
								号别：</th>
							<td>
								<c:if test="${reserveRegister.clinicType == '01'}">
									普通号
								</c:if>
								<c:if test="${reserveRegister.clinicType == '02'}">
									专家号
								</c:if>
							</td>
						</tr>
						<tr>
							<c:choose>
								<c:when test="${MATERNAL_CHILD_HOSPITAL eq reserveRegister.hospitalCode 
								|| STOMATOLOGICAL_HOSPITAL eq reserveRegister.hospitalCode}">
									<th>就诊日期：</th>
									<td colspan="3">
										<fmt:formatDate value="${reserveRegister.requestDate }" pattern="yyyy年MM月dd日"/>
										<c:if test="${reserveRegister.ampm eq 'a'}">上午 </c:if>
										<c:if test="${reserveRegister.ampm eq 'p'}">下午 </c:if>
										${reserveRegister.timeIntervalStart}~${reserveRegister.timeIntervalEnd}
									</td>
								</c:when>
								<c:otherwise>
									<th>挂号费：</th>
									<td>
										${reserveRegister.registerFee}元
									</td>
									<th>预约日期：</th>
									<td>
										<fmt:formatDate value="${reserveRegister.requestDate }" pattern="yyyy年MM月dd日"/>
										<c:if test="${reserveRegister.ampm eq 'a'}">上午 </c:if>
										<c:if test="${reserveRegister.ampm eq 'p'}">下午 </c:if>
										${reserveRegister.timeIntervalStart}~${reserveRegister.timeIntervalEnd}
									</td>
								</c:otherwise>
							</c:choose>
						</tr>
					</table>
				</td>
			</tr>
			<tr>
				<td colspan="2">&nbsp;</td>
			</tr>
			<tr>
				<td class="lefttd">
					操作信息
				</td>
				<td>
					<table class="reserveTable">
						<tr>
							<th>预约者：</th>
							<td>
								${reserveRegister.submitUserName}
							</td>
							<th>提交时间：</th>
							<td colspan="3">
								<fmt:formatDate value="${reserveRegister.submitDate}" pattern="yyyy年MM月dd日 HH:mm:ss"/>
								<%-- <ehr:dic code="${reserveRegister.regFrom}" dicmeta="FS990005"/> --%>
							</td>
						</tr>
						<c:if test="${not empty reserveRegister.cancelUser}">
						<tr>
							<th>取消人：</th>
							<td>
								${reserveRegister.cancelUser}
							</td>
							<th>取消时间：</th>
							<td>
								<fmt:formatDate value="${reserveRegister.cancelTime}" pattern="yyyy年MM月dd日 HH:mm:ss"/>
							</td>
						</tr>
						</c:if>
					</table>
				</td>
			</tr>
			<tr>
				<td colspan="2">&nbsp;</td>
			</tr>
		</table>
	</div>
</div>
<script type="text/javascript">
$("#flowChart").addClass("order-success-node");
</script>
