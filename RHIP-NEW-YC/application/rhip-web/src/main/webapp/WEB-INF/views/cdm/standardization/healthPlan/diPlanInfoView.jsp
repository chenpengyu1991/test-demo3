<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<script
	src="${pageContext.request.contextPath}/js/views/cdm/standardization/healthPlan/diPlanInfoView.js"
	type="text/javascript"></script>
<div class="toolbar">
	<a href="javascript:void(0)" id="cdm-plan-list-di-back-btn"><b class="fanhui" >返回</b></a> 
</div>
<fieldset>
	<div class="postcontent">
		<i class="popno">糖尿病患者 <input id="diYear" 
			 value="${planInfo.conclusionsOfYear}" type="text"
			readonly="readonly" style="width: 35px; font-weight: bold"
			 /> 年保健计划
		</i>
		<div class="postdivs">
			<fieldset>
				<legend>诊断结论</legend>
				<table class="posttable" id="diHealthPlan">
					<colgroup>
						<col style="width: 35%;" />
						<col style="width: 60%;" />
					</colgroup>
					<tr>
						<th><label>确诊日期</label></th>
						<td><fmt:formatDate value="${planInfo.diDiagnosedDate}"></fmt:formatDate></td>
					</tr>
					<tr>
						<th><label>诊断医院</label></th>
						<td><ehr:org code="${planInfo.diDiagnosedOrganCode}"/></td>
					</tr>
					<tr>
						<th><label>分型</label></th>
						<td><ehr:dic dicmeta="DMD00007" code="${planInfo.diType}" />
						</td>
					</tr>

					<tr>
						<th id="rbgId">糖尿病症状+随机血浆葡萄糖</th>

						<td><input type="text" style="width: 50%" 
							value="${planInfo.rbg}" readonly="readonly"
							>（单位：mmol/L）
						</td>
					</tr>

					<tr>
						<th id="fpgId">空腹血糖（FPG）</th>
						<td><input type="text" style="width: 50%" 
							value="${planInfo.fpg}" readonly="readonly"
							>（单位：mmol/L）
						</td>
					</tr>

					<tr>
						<th id="gluValueId">糖耐量（OGTT2HPG）</th>
						<td><input type="text" style="width: 50%" 
							value="${planInfo.gluValue}" readonly="readonly"
							>（单位：mmol/L）
						</td>
					</tr>

					<tr>
						<th>复查血糖值未达到诊断标准</th>
						<td colspan="1"><input type="text" readonly="readonly" style="width: 50%" 
						value='${planInfo.doubleCheck=="1"?"是":"否"}'></td>
					</tr>
				</table>
			</fieldset>



			<fieldset>
				<legend>处理</legend>
				<table class="posttable">
					<colgroup>
						<col style="width: 20%;" />
						<col style="width: 30%;" />
						<col style="width: 20%;" />
						<col style="width: 30%;" />
					</colgroup>
					<tr>
						<th><label>糖尿病</label></th>
						 <td ><input type="text"
							value=" <ehr:dic dicmeta="DMD00037" code="${planInfo.manageLevel}"/>"
							readonly="readonly" ></input>
							</td>
					</tr>

					<tr>
						<th><label>处理方案</label></th>
						<td ><input type="text"
							value=" <ehr:dic dicmeta="DMD00065" code="${planInfo.process}"/>"
							readonly="readonly" 
							 ></input>
						</td>
					</tr>

					<tr>
						<th><label>制定日期</label></th>
						<td><input type="text" value='<fmt:formatDate value="${planInfo.createDate}" pattern="yyyy-MM-dd"/>'
									readonly="readonly" style="width: 100px"></input></td>
						<th><label>医生签名</label></th>
						<td>
							<c:choose>
								<c:when test="${planInfo.createDoctorName eq null}">
									<ehr:user userCode='${planInfo.createDoctorCode}'></ehr:user>
								</c:when>
								<c:otherwise>
									${planInfo.createDoctorName}
								</c:otherwise>
							</c:choose>
						</td>
						
					</tr>
				</table>
			</fieldset>
		</div>
	</div>
</fieldset>

