<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<script
	src="${pageContext.request.contextPath}/js/views/ism/reportCard/report.js"
	type="text/javascript"></script>
<div class="toolbar">
	<c:choose>
		<c:when test="${reportFlag!=1}">
			<a href="javascript:void(0)" onclick="ismReportCard.back()"><b
				class="fanhui">返回</b></a>
		</c:when>
	</c:choose>
	<c:choose>
		<c:when test="${reportFlag==3}">
			<a href="javascript:void(0)" onclick="ismReportCard.approval(3)"><b
				class="tongguo">通过</b></a>
			<a href="javascript:void(0)" onclick="ismReportCard.approval(2)"><b
				class="zuofei">退回</b></a>
			<a href="javascript:void(0)"
				onclick="ismReportCard.approvalDialog(${reportInfo.id})"><b
				class="jilu">审核记录</b></a>
		</c:when>
		<c:when test="${reportFlag!='2'}">
			<a href="javascript:void(0)" id="ism-report-input-save-btn"><b
				class="tijiao">提交</b></a>
		</c:when>
	</c:choose>

</div>
<form id="ism-report-input-form">
	<input type="hidden" name="id" value="${reportInfo.id}" />
	<input type="hidden" id="reportFlag" value="${reportFlag}" />
	<div class="postcontent">
		<i class="popno">全国伤害监测报告卡</i>
		<div class="postdiv">
			<table class="posttable">
				<colgroup>
					<col style="width: 15%; min-width: 100px;" />
					<col style="width: 35%; min-width: 200px;" />
					<col style="width: 15%; min-width: 100px;" />
					<col style="width: 35%; min-width: 200px;" />
				</colgroup>
				<tr>
					<th><label for="hospitalCode">监测医院编号</label></th>
					<td><input type="text" id="hospitalCode" name="hospitalCode"
						value="${reportInfo.hospitalCode}" readonly="readonly"></input></td>
					<th><label for="reportNo">卡片编号</label></th>
					<td><c:choose>
							<c:when test="${empty (reportInfo.reportNo)}">
								<span>自动生成</span>
							</c:when>
							<c:otherwise>
								<input type="text" value="${reportInfo.reportNo}"
									readonly="readonly" />
							</c:otherwise>
						</c:choose></td>
				</tr>
			</table>
			<fieldset>
				<legend>基本信息</legend>
				<table class="posttable">
					<colgroup>
						<col style="width: 15%; min-width: 100px;" />
						<col style="width: 35%; min-width: 200px;" />
						<col style="width: 15%; min-width: 100px;" />
						<col style="width: 35%; min-width: 200px;" />
					</colgroup>
					<tr>
						<th><label for="ism_report_idcard">身份证</label></th>
						<td><input type="text" id="ism_report_idcard" name="idcard"
							value="${reportInfo.idcard}" placeholder="输入身份证获取人员信息"
							reg='{"idCard":true}' ${reportFlag=='2'? "readonly='true'" :" " }></input></td>
						<th><label for="ism_report_name"
							${reportFlag=='2'? "" :"class='required'" }>姓名</label></th>
						<td><input type="text" id="ism_report_name" name="name"
							value="${reportInfo.name}" reg="{'required':true,'maxlength':16}"
							${reportFlag=='2'? "readonly='true'" :" " }></input></td>
					</tr>
					<tr>
						<th><label for="age"
							${reportFlag=='2'? "" :"class='required'" }>年龄</label></th>
						<td><input type="text" id="age" name="age"
							value="${reportInfo.age}" reg="{'required':true,'maxlength':3,'regex':'digits'}"
							${reportFlag=='2'? "readonly='true'" :" " }></input></td>
						<th><label for="gender"
							${reportFlag=='2'? "" :"class='required'" }>性别</label></th>
						<c:choose>
							<c:when test="${reportFlag!=2}">
								<td><ehr:dic-list dicmeta="GBT226112003" id="gender"
										name="gender" value="${reportInfo.gender}"
										reg="{'required':true}"></ehr:dic-list></td>
							</c:when>
							<c:when test="${reportFlag==2}">
								<td><input type="text"
									value=" <ehr:dic dicmeta="GBT226112003" code="${reportInfo.gender}"/>"
									readonly="readonly"></input></td>
							</c:when>
						</c:choose>
					</tr>
					<tr>
						<th><label for="registration"
							${reportFlag=='2'? "" :"class='required'" }>户籍</label></th>
						<c:choose>
							<c:when test="${reportFlag!=2}">
								<td><ehr:dic-list id="registration" dicmeta="CV0201104"
										name="registration" value="${reportInfo.registration}"
										reg="{'required':true}" /></td>
							</c:when>
							<c:when test="${reportFlag==2}">
								<td><input type="text"
									value=" <ehr:dic dicmeta="CV0201104" code="${reportInfo.registration}"/>"
									readonly="readonly"></input></td>
							</c:when>
						</c:choose>
						<th><label for="education"
							${reportFlag=='2'? "" :"class='required'" }>文化程度</label></th>
						<c:choose>
							<c:when test="${reportFlag!=2}">
								<td><ehr:dic-list id="education" dicmeta="GBT46582006"
										name="education" value="${reportInfo.education}"
										reg="{'required':true}" /></td>
							</c:when>
							<c:when test="${reportFlag==2}">
								<td><input type="text"
									value=" <ehr:dic dicmeta="GBT46582006" code="${reportInfo.education}"/>"
									readonly="readonly"></input></td>
							</c:when>
						</c:choose>
					</tr>
					<tr>
						<th><label for="occupation"
							${reportFlag=='2'? "" :"class='required'" }>职业</label></th>
						<c:choose>
							<c:when test="${reportFlag!=2}">
								<td><ehr:dic-list dicmeta="GBT6565" width="180px;"
										id="occupation" name="occupation"
										value="${reportInfo.occupation}" reg="{'required':true}" /></td>
							</c:when>
							<c:when test="${reportFlag==2}">
								<td><input type="text"
									value=" <ehr:dic dicmeta="GBT6565" code="${reportInfo.occupation}"/>"
									readonly="readonly"></input></td>
							</c:when>
						</c:choose>
					</tr>
				</table>
			</fieldset>
			<fieldset>
				<legend>基本情况</legend>
				<table class="posttable">
					<colgroup>
						<col style="width: 20%; min-width: 100px;" />
						<col style="width: 80%; min-width: 200px;" />
					</colgroup>
					<tr>
						<th><label ${reportFlag=='2'? "" :"class='required'" }
							for="inhosDate">就诊日期</label></th>
						<c:choose>
							<c:when test="${reportFlag!=2}">
								<td><tag:dateInput name="inhosDateToString" id="inhosDate"
										onlypast="true" date="${reportInfo.inhosDate}"
										reg="{'required':true}" pattern="yyyy-MM-dd HH:mm:ss"
										style="width:300px" /></td>
							</c:when>
							<c:when test="${reportFlag==2}">
								<td><input type="text" value='<fmt:formatDate value="${reportInfo.inhosDate}" pattern="yyyy-MM-dd HH:mm:ss"/>'
									readonly="readonly" style="width: 300px"></input></td>
							</c:when>
						</c:choose>
					</tr>
					<tr>
						<th><label ${reportFlag=='2'? "" :"class='required'" }
							for="occurTime">伤害发生日期时间</label></th>
						<c:choose>
							<c:when test="${reportFlag!=2}">
								<td><tag:dateInput name="occurTimeToString" id="occurTime"
										onlypast="true" date="${reportInfo.occurTime}"
										reg="{'required':true}" pattern="yyyy-MM-dd HH:mm:ss"
										style="width:300px" /></td>
							</c:when>
							<c:when test="${reportFlag==2}">
								<td><input type="text" value='<fmt:formatDate value="${reportInfo.occurTime}" pattern="yyyy-MM-dd HH:mm:ss"/>'
									readonly="readonly" style="width: 300px"></input></td>
							</c:when>
						</c:choose>
					</tr>
					<tr>
						<th><label for="occurReasonCode" ${reportFlag=='2'? "" :"class='required'" }>伤害发生原因</label></th>
						<c:choose>
							<c:when test="${reportFlag!=2}">
								<td><ehr:dic-radio dicmeta="DMD00055" 
										name="occurReasonCode" value="${reportInfo.occurReasonCode}"
										reg="{'required':true}" /> 
									<input id="occurReasonOther"
										style="width: 150px" reg="{'maxlength':100,'required':true}"
										type="text" value="${reportInfo.occurReasonOther}" 
										name="occurReasonOther">
									</td>
							</c:when>
							
							<c:when test="${reportFlag==2}">
								<td><input type="text"
									value=" <ehr:dic dicmeta="DMD00055" code="${reportInfo.occurReasonCode}"/>"
									readonly="readonly" ${empty (reportInfo.occurReasonOther)==true?"style='width: 300px'":"style='width: 150px'"} />
									<c:if test="${not empty (reportInfo.occurReasonOther)}">
										<input type="text" value="${reportInfo.occurReasonOther}" readonly="readonly" style="width: 150px">
									</c:if>
								</td>
							</c:when>
						</c:choose>
					</tr>
					<tr>
						<th><label for="occurPalceCode" ${reportFlag=='2'? "" :"class='required'" }>伤害发生地点</label></th>
						<c:choose>
							<c:when test="${reportFlag!=2}">
								<td><ehr:dic-radio dicmeta="DMD00056" name="occurPalceCode"
										value="${reportInfo.occurPalceCode}" reg="{'required':true}" />
									<input id="occurPalceOther" style="width: 150px"
									reg="{'maxlength':100,'required':true}" type="text"
									value="${reportInfo.occurPlaceOther}" name="occurPlaceOther" />
								</td>
							</c:when>
							<c:when test="${reportFlag==2}">
								<td><input type="text"
									value=" <ehr:dic dicmeta="DMD00056" code="${reportInfo.occurPalceCode}"/>"
									readonly="readonly" ${empty (reportInfo.occurPlaceOther)==true?"style='width: 300px'":"style='width: 150px'"}></input>
										<c:if test="${not empty (reportInfo.occurPlaceOther)}">
											<input type="text" value="${reportInfo.occurPlaceOther}" readonly="readonly" style="width: 150px">
										</c:if>
									</td>
							</c:when>
						</c:choose>
					</tr>
					<tr>
						<th><label for="occurBehaviorCode" ${reportFlag=='2'? "" :"class='required'" }>伤害发生时活动类别</label></th>
						<c:choose>
							<c:when test="${reportFlag!=2}">
								<td><ehr:dic-radio dicmeta="DMD00057"
										name="occurBehaviorCode"
										value="${reportInfo.occurBehaviorCode}" reg="{'required':true}" />
									<input id="occurBehaviorOther" style="width: 150px"
									reg="{'maxlength':100,'required':true}" type="text"
									value="${reportInfo.occurBehaviorOther}"
									name="occurBehaviorOther" /></td>
							</c:when>
							<c:when test="${reportFlag==2}">
								<td><input type="text"
									value=" <ehr:dic dicmeta="DMD00057" code="${reportInfo.occurBehaviorCode}"/>"
									readonly="readonly" ${empty (reportInfo.occurBehaviorOther)==true?"style='width: 300px'":"style='width: 150px'"}></input>
									<c:if test="${not empty (reportInfo.occurBehaviorOther)}">
										<input type="text" value="${reportInfo.occurBehaviorOther}" readonly="readonly" style="width: 150px">
									</c:if>
									</td>
							</c:when>
						</c:choose>
					</tr>
					<tr>
						<th><label for="intendsCode" ${reportFlag=='2'? "" :"class='required'" }>伤害意图类别</label></th>
						<c:choose>
							<c:when test="${reportFlag!=2}">
								<td><ehr:dic-radio dicmeta="DMD00058" id="intendsCode"
										name="intendsCode" value="${reportInfo.intendsCode}"
										reg="{'required':true}" /></td>
							</c:when>
							<c:when test="${reportFlag==2}">
								<td><input type="text"
									value=" <ehr:dic dicmeta="DMD00058" code="${reportInfo.intendsCode}"/>"
									readonly="readonly" style="width: 300px"></input></td>
							</c:when>
						</c:choose>
					</tr>
					<tr>
						<th><label for="natureCode" ${reportFlag=='2'? "" :"class='required'" }>伤害性质</label></th>
						<c:choose>
							<c:when test="${reportFlag!=2}">
								<td><ehr:dic-radio dicmeta="DMD00059" name="natureCode"
										value="${reportInfo.natureCode}" reg="{'required':true}" /> <input
									id="natureOther" style="width: 150px"
									reg="{'maxlength':100,'required':true}" type="text"
									value="${reportInfo.natureOther}" name="natureOther" /></td>
							</c:when>
							<c:when test="${reportFlag==2}">
								<td><input type="text"
									value=" <ehr:dic dicmeta="DMD00059" code="${reportInfo.natureCode}"/>"
									readonly="readonly" ${empty (reportInfo.natureOther)==true?"style='width: 300px'":"style='width: 150px'"}></input>
									<c:if test="${not empty (reportInfo.natureOther)}">
										<input type="text" value="${reportInfo.natureOther}" readonly="readonly" style="width: 150px">
									</c:if>
									</td>
							</c:when>
						</c:choose>
					</tr>
					<tr>
						<th><label for="partCode" ${reportFlag=='2'? "" :"class='required'" }>伤害部位</label></th>
						<c:choose>
							<c:when test="${reportFlag!=2}">
								<td><ehr:dic-radio dicmeta="DMD00060" name="partCode"
										value="${reportInfo.partCode}" reg="{'required':true}" /> <input
									id="partOther" style="width: 150px"
									reg="{'maxlength':100,'required':true}" type="text"
									value="${reportInfo.partOther}" name="partOther" /></td>
							</c:when>
							<c:when test="${reportFlag==2}">
								<td><input type="text"
									value=" <ehr:dic dicmeta="DMD00060" code="${reportInfo.partCode}"/>"
									readonly="readonly" ${empty (reportInfo.partOther)==true?"style='width: 300px'":"style='width: 150px'"}></input>
									<c:if test="${not empty (reportInfo.partOther)}">
										<input type="text" value="${reportInfo.partOther}" readonly="readonly" style="width: 150px">
									</c:if>
									</td>
							</c:when>
						</c:choose>
					</tr>
					<tr>
						<th><label for="severityCode" ${reportFlag=='2'? "" :"class='required'" }>伤害严重程度</label></th>
						<c:choose>
							<c:when test="${reportFlag!=2}">
								<td><ehr:dic-radio dicmeta="DMD00061" name="severityCode"
										value="${reportInfo.severityCode}" reg="{'required':true}" /></td>
							</c:when>
							<c:when test="${reportFlag==2}">
								<td><input type="text"
									value=" <ehr:dic dicmeta="DMD00061" code="${reportInfo.severityCode}"/>" style="width: 300px"
									readonly="readonly"></input></td>
							</c:when>
						</c:choose>
					</tr>
					<tr>
						<th><label for="clinicalDiagnosis">临床诊断</label></th>
						<td><input type="text" id="clinicalDiagnosis"
							name="clinicalDiagnosis" value="${reportInfo.clinicalDiagnosis}"
							reg="{'maxlength':200}" style="width: 300px"
							${reportFlag=='2'? "readonly='true'" :" " }></input></td>
					</tr>
					<tr>
						<th><label for="result" ${reportFlag=='2'? "" :"class='required'" }>伤害结局</label></th>
						<c:choose>
							<c:when test="${reportFlag!=2}">
								<td><ehr:dic-radio dicmeta="DMD00062" name="result"
										value="${reportInfo.result}" reg="{'required':true}" /> <input
									id="resultOther" style="width: 150px"
									reg="{'maxlength':100,'required':true}" type="text"
									value="${reportInfo.resultOther}" name="resultOther" /></td>
							</c:when>
							<c:when test="${reportFlag==2}">
								<td><input type="text"
									value=" <ehr:dic dicmeta="DMD00062" code="${reportInfo.result}"/>"
									readonly="readonly" ${empty (reportInfo.resultOther)==true?"style='width: 300px'":"style='width: 150px'"}></input>
									<c:if test="${not empty (reportInfo.resultOther)}">
										<input type="text" value="${reportInfo.resultOther}" readonly="readonly" style="width: 150px">
									</c:if>
									</td>
							</c:when>
						</c:choose>
					</tr>
					<tr>
						<th><label for="createOrganName"
							${reportFlag=='2'? "" :"class='required'" }>填报机构名称</label></th>
						<td><input type="text" id="createOrganName"
							name="createOrganName" style="width: 300px"
							value="${reportInfo.createOrganName}" readonly="readonly"></input>
						<td><input type="hidden" id="createOrganCode"
							name="createOrganCode" style="width: 300px"
							value="${reportInfo.createOrganCode}" ></input>
					</tr>
					<tr>
						<th><label for="createDoctorName"
							${reportFlag=='2'? "" :"class='required'" }>填报人姓名</label></th>
						<td><input type="text" id="createDoctorName"
							name="createDoctorName" style="width: 300px"
							value="${reportInfo.createDoctorName}" readonly="readonly"></input></td>
						<td><input type="hidden" id="createDoctorCode"
							name="createDoctorCode" style="width: 300px"
							value="${reportInfo.createDoctorCode}" ></input></td>
					</tr>
					<tr>
						<th><label for="createDate"
							${reportFlag=='2'? "" :"class='required'" }>填报时间</label></th>
						<c:choose>
							<c:when test="${reportFlag!=2}">
								<td><tag:dateInput id="createDate" name="createDate"
										style="width:300px" date="${reportInfo.createDate}" 
										pattern="yyyy/MM/dd" reg="{'required':true}" /></td>
							</c:when>
							<c:when test="${reportFlag==2}">
								<td><input type="text" value='<fmt:formatDate value="${reportInfo.createDate}" pattern="yyyy-MM-dd"/>'
									readonly="readonly" style="width: 300px"></input></td>
							</c:when>
						</c:choose>
					</tr>
					<c:choose>
						<c:when test="${reportFlag!=1}">
							<tr>
								<th>备注</th>
								<td colspan="3"><textarea name="comments" ${reportFlag=='2'? "readonly='true'" :" " }
									style="width: 60%" rows=5 reg='{"maxlength":"100"}'>${reportInfo.comments}</textarea>
								</td>
							</tr>
						</c:when>
					</c:choose>
				</table>
			</fieldset>
		</div>
	</div>
</form>
