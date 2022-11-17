<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<script src="${pageContext.request.contextPath}/js/views/cdm/standardization/input/view.js" type="text/javascript"></script>
<div class="toolbar">
	<a href="javascript:void(0)" id="life-card-back-btn"><b class="fanhui">返回</b></a>
</div>
<div id="persondeath-card-main">
	<form id="persondeath-card-form">
		<input type="hidden" id="disPersonId" name="personId" value="">
		<input type="hidden" id="disid" name="id" value="">

		<div class="postcontent">
			<i class="popno">详细信息</i>

			<div class="postdiv">
				<div id="person-info">
						<table class="posttable">
							<colgroup>
								<col style="width: 15%;min-width:100px;" />
								<col style="width: 35%;min-width:200px;" />
								<col style="width: 15%;min-width:100px;" />
								<col style="width: 35%;min-width:200px;" />

							</colgroup>

							<tr>
								<th><label    for="name">姓名</label></th>
								<td><input type="text" id="name" name="personDeathRecord.name" value="${personDeathRecord.name}" reg="{'required':true,'maxlength':16}" /></td>
								<th><label   for="idcard">身份证</label></th>
								<td>
									<c:if test="${empty personDeathRecord.idcard}">
										<input type="text" id="idcard" name="personDeathRecord.idcard" placeholder="输入身份证获取人员信息" value="${personDeathRecord.idcard}" reg='{"required":true,"idCard":true}' />
									</c:if>
									<c:if test="${not empty personDeathRecord.idcard}">
										<input type="text" id="idcard" readonly="readonly" name="personDeathRecord.idcard" value="${personDeathRecord.idcard}" reg='{"idCard":true}' />
									</c:if>
								</td>
							</tr>

							<tr>
								<th><label>出生日期</label></th>
								<td><fmt:formatDate value="${personDeathRecord.birthday}" pattern="yyyy/MM/dd"></fmt:formatDate></td>
								<th><label  >性别</label></th>
								<td><ehr:dic code="${personDeathRecord.gender}" dicmeta="GBT226112003"/></td>
							</tr>
							<tr>
								<th><label  for="marriage">婚姻</label></th>
								<td><ehr:dic dicmeta="GBT226122003" code="${personDeathRecord.marriage}"/></td>
								<th><label  for="occupation">职业</label></th>
								<td><ehr:dic dicmeta="GBT6565" code="${personDeathRecord.occupation}"/></td>
							</tr>
							<tr>
								<th><label  for="nation">民族</label></th>
								<td><ehr:dic dicmeta="GBT3304" code="${personDeathRecord.nation}"/></td>
								<th><label  for="education">学历</label></th>
								<td><ehr:dic dicmeta="GBT46582006" code="${personDeathRecord.education}"/></td>
							</tr>
							<tr>
								<th><label    for="age">实足年龄</label></th>
								<td><input type="text" id="age" name="personDeathRecord.age" value="${personDeathRecord.age}" reg="{'required':true,'maxlength':16}" /></td>
								<th><label   for="admissionNo">住院号</label></th>
								<td><input type="text" id="admissionNo" name="personDeathRecord.admissionNo" value="${personDeathRecord.admissionNo}" reg="{'required':true,'maxlength':16}" /></td>
							</tr>
							<tr>
								<th><label   for="contactName">联系人姓名</label></th>
								<td><input type="text" id="contactName" name="personDeathRecord.contactName" value="${personDeathRecord.contactName}" reg="{'required':true,'maxlength':16}" /></td>
								<th><label  for="familyPhone">家人电话号码</label></th>
								<td><input id="familyPhone" type="text" name="personDeathRecord.familyPhone" value="${personDeathRecord.familyPhone}" reg="{'required':true,'regex':'phone'}" /></td>

							</tr>
							<tr>
								<th><label  for="reportDate">报告日期</label></th>
								<td><fmt:formatDate value="${personDeathRecord.reportDate}" pattern="yyyy/MM/dd"></fmt:formatDate></td>
								<th><label  for="deathDate">死亡日期</label></th>
								<td><fmt:formatDate value="${personDeathRecord.deathDate}" pattern="yyyy/MM/dd"></fmt:formatDate></td>
							</tr>
							<tr>
								<th><label   for="inputIdcard">录入人身份证号</label></th>
								<td><c:if test="">
									<input type="text" id="inputIdcard" name="personDeathRecord.inputIdcard" placeholder="输入身份证获取人员信息" value="${personDeathRecord.inputIdcard}" reg='{"required":true,"idCard":true}' />
								</c:if>
									<c:if test="">
										<input type="text" id="inputIdcard" readonly="readonly" name="personDeathRecord.inputIdcard" value="${personDeathRecord.inputIdcard}" reg='{"idCard":true}' />
									</c:if></td>
								<th><label   for="input_date">录入日期和时间</label></th>
								<td><fmt:formatDate value="${personDeathRecord.inputDate}" pattern="yyyy/MM/dd hh:mm:ss"></fmt:formatDate></td>
							</tr>
							<tr>
								<th><label  for="personType">人群分类</label></th>
								<td><ehr:dic dicmeta="FS990023" code="${personDeathRecord.personType}"/></td>
								<th><label  for="deathClass">死因分类</label></th>
								<td><ehr:dic dicmeta="MH00020" code="${personDeathRecord.deathClass}"/></td>
							</tr>
							<tr>
								<th><label   for="inputUser">创建记录用户</label></th>
								<td><input type="text" id="inputUser" name="personDeathRecord.inputUser" value="${personDeathRecord.inputUser}" reg="{'required':true,'maxlength':16}" /></td>
								<th><label  for="updateUser">更新记录用户</label></th>
								<td><input type="text" id="updateUser" name="personDeathRecord.updateUser" value="${personDeathRecord.updateUser}" reg="{'required':true,'maxlength':16}" /></td>
							</tr>
							<tr>
								<th><label  for="updateOrgancode">更新记录机构编码</label></th>
								<td><input type="text" id="updateOrgancode" name="personDeathRecord.updateOrgancode" value="${personDeathRecord.updateOrgancode}" reg="{'required':true,'maxlength':16}" /></td>
								<th><label   for="updateDate">更新时间</label></th>
								<td><fmt:formatDate value="${personDeathRecord.updateDate}" pattern="yyyy/MM/dd"></fmt:formatDate></td>
							</tr>
							<tr>
								<th><label  for="inputOrgancode">录入机构编码</label></th>
								<td><input type="text" id="inputOrgancode" name="personDeathRecord.inputOrgancode" value="${personDeathRecord.inputOrgancode}" reg="{'required':true,'maxlength':16}" /></td>
								<th><label  for="cancelStatus">注销状态</label></th>
								<td> <ehr:dic dicmeta="PH00035" code="${personDeathRecord.cancelStatus}"/></td>
							</tr>
							<tr>
								<th><label  for="deathIcd">根本死因编码</label></th>
								<td><input type="text" id="deathIcd" name="personDeathRecord.deathIcd" value="${personDeathRecord.deathIcd}" reg="{'required':true,'maxlength':16}" /></td>
								<th><label  for="deathReason">根本死亡原因名称</label></th>
								<td><input type="text" id="deathReason" name="personDeathRecord.deathReason" value="${personDeathRecord.deathReason}" reg="{'required':true,'maxlength':16}" /></td>
							</tr>
							<tr>
								<th><label  for="otherDiagnose">其他疾病诊断</label></th>
								<td><input type="text" id="otherDiagnose" name="personDeathRecord.otherDiagnose" value="${personDeathRecord.otherDiagnose}" reg="{'required':true,'maxlength':16}" /></td>
								<th><label  for="organLevel">最高诊断机构级别</label></th>
								<td><ehr:dic dicmeta="CV850003" code="${personDeathRecord.organLevel}"/></td>
							</tr>
							<tr>
								<th><label  for="placeType">死亡地点类别</label></th>
								<td><ehr:dic dicmeta="CV0201103" code="${personDeathRecord.placeType}"/></td>
								<th><label  for="deathBasis">死亡诊断依据</label></th>
								<td><ehr:dic dicmeta="CV0501037" code="${personDeathRecord.deathBasis}"/></td>
							</tr>
							<tr>
								<th><label   for="duration">（A）发病至死亡大概时间间隔</label></th>
								<td><fmt:formatDate value="${personDeathRecord.duration}" pattern="hh:mm:ss"></fmt:formatDate></td>
								<th><label  for="dCause">（A）直接导致死亡的疾病名称</label></th>
								<td><input type="text" id="dCause" name="dCause" value="${personDeathRecord.dCause}" reg="{'required':true,'maxlength':16}" /></td>
							</tr>
							<tr>
								<th><label   for="causeAName">（B）引起（A）的疾病名称</label></th>
								<td><input type="text" id="causeAName" name="personDeathRecord.causeAName" value="${personDeathRecord.causeAName}" reg="{'required':true,'maxlength':16}" /></td>
								<th><label for="causeADur">（B）引起（A）大概时间间隔</label></th>
								<td><fmt:formatDate value="${personDeathRecord.causeADur}" pattern="hh:mm:ss"></fmt:formatDate></td>
							</tr>
							<tr>
								<th><label   for="causeBName">（c）引起（B）的疾病名称</label></th>
								<td><input type="text" id="causeBName" name="personDeathRecord.causeBName" value="${personDeathRecord.causeBName}" reg="{'required':true,'maxlength':16}" /></td>
								<th><label >（c）引起（B）大概时间间隔</label></th>
								<td><fmt:formatDate value="${personDeathRecord.causeBDur}" pattern="hh:mm:ss"></fmt:formatDate></td>
							</tr>
							<tr>
								<th><label   for="causeCName">直接死亡原因c名称</label></th>
								<td><input type="text" id="causeCName" name="personDeathRecord.causeCName" value="${personDeathRecord.causeCName}" reg="{'required':true,'maxlength':16}" /></td>
								<th><label  for="causeCDur">引起（C）大概时间间隔</label></th>
								<td><fmt:formatDate value="${personDeathRecord.causeCDur}" pattern="hh:mm:ss"></fmt:formatDate></td>
							</tr>
							<tr>
								<th><label   for="causeDName">直接死亡原因D名称</label></th>
								<td><input type="text" id="causeDName" name="personDeathRecord.causeDName" value="${personDeathRecord.causeDName}" reg="{'required':true,'maxlength':16}" /></td>
								<th><label  for="causeDDur">引起（D）大概时间间隔</label></th>
								<td><fmt:formatDate value="${personDeathRecord.causeDDur}" pattern="hh:mm:ss"></fmt:formatDate></td>
							</tr>
						</table>

				</div>

			</div>

		</div>
	</form>
</div>





