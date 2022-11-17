<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/views/ehrbrowser/basic/basic.css" />
<script src="${pageContext.request.contextPath}/js/views/life/deathMedicineCertificate/add.js" type="text/javascript"></script>
<div class="toolbar">
	<a href="javascript:void(0)" id="backAdd"><button class="btn-gray layui-btn layui-btn-sm button"><i class="layui-icon">&#xe65c;</i>返回</button></a>
	<a href="javascript:void(0)" id="saveAdd"><button class="layui-btn layui-btn-sm"><i class="layui-icon">&#xe605;</i>保存</button></a>
</div>
<div class="postcontent divFixed105" style="top: 60px;">
	<ul>
		<li style="text-align: center; font-size: 25px;">死亡医学证明</li>
	</ul>
	<br/>
	<form id="reportAddForm">
		<input type="hidden" id="id" name="id" value="${personInfo.id}">
		<input type="hidden" name="cancelStatus" value="${personInfo.cancelStatus}">
		<fieldset class="postcontent layui-elem-field">
			<legend>基本信息</legend>
			<input type="hidden" id="dis-person-id" name="personId" value="${personInfo.id}">
			<table class="posttable">
				<colgroup>
					<col style="width: 25%;min-width:100px;" />
					<col style="width: 25%;min-width:200px;" />
					<col style="width: 20%;min-width:100px;" />
					<col style="width: 30%;min-width:200px;" />
				</colgroup>
				<tr>
					<th><label class="required" for="idcard">证件号码</label></th>
					<td>
						<input  type="text" id="idcard" name="idcard" value="${personInfo.idcard}" reg='{"required":"true","idCard":true}' />
					</td>
					<th>姓名</th>
					<td><input type="text" name="name"  id="name" value="${personInfo.name}"/></td>
				</tr>
				<tr>
					<th>出生日期</th>
					<td><input type="text" class="layui-input x-admin-content-sm-date"  name="birthday" id="birthday" value="${personInfo.birthday}" style="padding-left: 0px;"/> </td>
					<th>健康档案号</th>
					<td><input type="text" name="healthFileNo" id="healthFileNo" value="${personInfo.healthFileNo}"/></td>

				</tr>
				<tr>
					<th>地址</th>
					<td colspan="3">
						<ehr:dic-town-street-village villageId="village_address" streetId="street_address"
													 townId="town_address" villageName="paGroup" streetName="pastreet"
													 townName="patownShip"  villageValue="${personInfo.paGroup}"  streetValue="${personInfo.pastreet}"  townValue="${personInfo.patownShip}"
													 width="122px;"/>
						<input type="text" name="pahouseNumber" id="pahouseNumber" value="${personInfo.pahouseNumber}" />
					</td>
				</tr>
			</table>
		</fieldset>
		<fieldset class="postcontent layui-elem-field">
			<legend>一般信息</legend>
			<table class="posttable">
				<colgroup>
					<col style="width: 25%;min-width:100px;" />
					<col style="width: 25%;min-width:200px;" />
					<col style="width: 20%;min-width:100px;" />
					<col style="width: 30%;min-width:200px;" />
				</colgroup>
				<tr>
					<th>建档人</th>
					<td><input type="text" name="inputName" id="inputName" value="${personInfo.inputName}"/></td>
					<th>建档日期</th>
					<td><input type="text" class="layui-input x-admin-content-sm-date" name="inputDate" id="inputDate" value="<fmt:formatDate value="${personInfo.inputDate}" pattern="yyyy/MM/dd"/>"  style="padding-left: 0px;"/></td>
				</tr>
				<tr>
					<th><label class="required">死亡时间</label></th>
					<td><input type="text" class="layui-input x-admin-content-sm-date"  name="deathDate" id="deathDate" value="<fmt:formatDate value="${personInfo.deathDate}" pattern="yyyy/MM/dd"/>"  style="padding-left: 0px;" reg='{"required":"true"}'/></td>
					<th><label  id="deathPlaceType">死亡地点</label></th>
					<td><ehr:dic-list width="200px;" name="deathPlaceType" dicmeta="CV0201103" value="${personInfo.deathPlaceType}"/></td>
				</tr>
				<tr>
					<th><label>死亡原因</label></th>
					<td><input type="text" name="deathReason" value="${personInfo.deathReason}"/></td>
					<th><label>死亡类别</label></th>
					<td style="text-align:left;"><ehr:dic-list width="200px;" name="personType" dicmeta="FS990023" value="${personInfo.personType}"/></td>
				</tr>
			</table>
		</fieldset>

		<fieldset  class="postcontent layui-elem-field">
			<legend>死亡登记信息</legend>
			<table class="posttable">
				<colgroup>
					<col style="width: 25%;min-width:100px;" />
					<col style="width: 25%;min-width:200px;" />
					<col style="width: 20%;min-width:100px;" />
					<col style="width: 30%;min-width:200px;" />
				</colgroup>
				<tbody>
				<tr>
					<th>编号</th>
					<td><input type="text" name="deathCertificateNo" value="${personInfo.deathCertificateNo}"/></td>
				</tr>
				<tr>
					<th>死亡时是否处于妊娠期或妊娠终止后42天内</th>
					<td><ehr:dic-radio name="pregnancyStatus" dicmeta="PH00001" uninclude="3,4" value="${personInfo.pregnancyStatus}"/></td>
					<th>性别</th>
					<td> <ehr:dic-radio dicmeta="GBT226112003" name="gender" id="gender" value="${personInfo.gender}"/></td>
				</tr>
				<tr>
					<th>民族</th>
					<td>
						<label><input type="radio" onclick="util.clickHideText(this,'otherNationDesc')" name="nation" value="01" ${personInfo.nation eq"01"|| personInfo.nation ==null ?"checked":""} /> 汉族</label>
						<label><input type="radio" onclick="util.clickShowText(this,'otherNationDesc')" name="nation" value="99" ${(personInfo.nation ne"1" && not empty personInfo.nation && personInfo.nation ne"01") ?"checked":""}/> 少数民族</label>
						<input type="text" id="otherNationDesc" class="hidediv" name="otherNationDesc" style="width: 70px;" />
					</td>
					<th>职业工种</th>
					<td><ehr:dic-list name="occupation" id="occupation" dicmeta="GBT6565" code="0,1/2,3,4,5,6/7/8/9,X,Y,CV00031" value="${personInfo.occupation}" width="90%"/></td>
				</tr>
				<tr>
					<th>户籍</th>
					<td><ehr:dic-radio dicmeta="FS10005" id="householdType" name="householdType" code="1,2" value="${personInfo.householdType}"/></td>
				</tr>
				<tr>
					<th>生前工作单位</th>
					<td><input  reg='{"maxlength":"23"}' type="text" name="unitName" id="unitName" value="${personInfo.unitName}"/></td>
				</tr>
				<tr>
					<th>婚姻</th>
					<td><ehr:dic-list name="marriage" id="marriage"  dicmeta="GBT226122003" value="${personInfo.marriage}" code="10,20,30,40,90" width="80%"/> </td>
					<th>文化程度</th>
					<td><ehr:dic-list name="education"  id="education" dicmeta="GBT46582006" code="IDM17,20,IDM18,IDM19,IDM20,IDM21,IDM02,IDM07,IDM22,IDM10" value="${personInfo.education}" width="90%"/></td>
				</tr>
				<tr>
					<th>实足年龄</th>
					<td><tag:numberInput id="age"  name="age" reg="{'min':0,'max':9999}" value="${personInfo.age}"/></td>
					<th>家属姓名</th>
					<td><input type="text" name="guardian" value="${personInfo.guardian}"/></td>
				</tr>
				<tr>
					<th>住址或工作单位</th>
					<td colspan="3"><input type="text" name="guardianUnitName" value="${personInfo.guardianUnitName}"/></td>
				</tr>
				<tr>
					<th rowspan="5">致死的主要疾病诊断</th>
					<td >（请填写具体的病名，勿填症状体征）</td>
				</tr>
				<tr>
					<td colspan="3">（a）直接导致死亡的疾病或情况：<input type="text" name="directCondition" value="${personInfo.directCondition}"/></td>
				</tr>
				<tr>
					<td colspan="3">（b）引起（a）的疾病或情况：<input type="text" name="conditionA" value="${personInfo.conditionA}"/></td>
				</tr>
				<tr>
					<td colspan="3">（c）引起（b）的疾病或情况：<input type="text" name="conditionB" value="${personInfo.conditionB}"/></td>
				</tr>
				<tr>
					<td colspan="3">其他疾病诊断（促进死亡，但与导致死亡无关的其他重要情况）：<input type="text" name="conditionC" value="${personInfo.conditionC}"/></td>
				</tr>
				<tr>

				</tr>
				<tr>
					<th>发病至死亡大概时间间隔</th>
					<td ><input  type="text" name="intervaltime" value="${personInfo.intervaltime}"/></td>
				</tr>
				<tr>
					<th>死者生前上述疾病的最高诊断单位</th>
					<td colspan="3"><ehr:dic-radio  dicmeta="CV0810004" name="deathHighOrganLevel" value="${personInfo.deathHighOrganLevel}"/></td>
				</tr>
				<tr>
					<th>死者生前上述疾病的最高诊断依据</th>
					<td colspan="3"><ehr:dic-radio dicmeta="CV0501037" name="deathHighEvidenceTypeCode" value="${personInfo.deathHighEvidenceTypeCode}"/></td>
				</tr>
				<tr>
					<th>住院号</th>
					<td ><input  type="text" name="admissionNo" value="${personInfo.admissionNo}"/></td>
					<th>医师姓名</th>
					<td><input  type="text" name="doctorName" value="${personInfo.doctorName}"/></td>
				</tr>
				<tr>
					<th>单位名称</th>
					<td ><input  type="text" name="deathHospitalName" value="${personInfo.deathHospitalName}"/></td>
					<th>填报日期</th>
					<td><input type="text" class="layui-input x-admin-content-sm-date" name="fillTime" id="fillTime" value="<fmt:formatDate value="${personInfo.fillTime}" pattern="yyyy/MM/dd"/>" style="padding-left: 0px;"/></td>
				</tr>
				<tr>

					<th>根本死亡原因</th>
					<td><input  type="text" name="deathReasonBasisStr" value="${personInfo.deathReasonBasisStr}"/></td>
					<th>编码</th>
					<td><input  type="text" name="reportNo" value="${personInfo.reportNo}"/></td>

				</tr>
				<tr>
					<th>分类号</th>
					<td colspan="3"><ehr:dic-radio dicmeta="MH00020" name="categoryNo" value="${personInfo.categoryNo}"/></td>
				</tr>
				<tr>

					<th>调查记录生前疾病史及症状体征</th>
					<td colspan="3"><input  type="text" name="diseaseHistory" value="${personInfo.diseaseHistory}"/></td>

				</tr>
				<tr>
					<th>被调查者姓名</th>
					<td><input  type="text" name="contactName" value="${personInfo.contactName}"/></td>
					<th>与死者关系</th>
					<td><input  type="text" name="relation" value="${personInfo.relation}"/></td>
				</tr>
				<tr>
					<th>联系地址或者工作单位</th>
					<td><input  type="text" name="contactUnitName" value="${personInfo.contactUnitName}"/> </td>
					<th>死因推断</th>
					<td><input  type="text" name="deathReasonDeduction" value="${personInfo.deathReasonDeduction}"/></td>
				</tr>
				<tr>
					<th>调查者姓名</th>
					<td><input  type="text" name="fillUserName" value="${personInfo.fillUserName}"/></td>
					<th>调查日期</th>
					<td>
						<input type="text" class="layui-input x-admin-content-sm-date" name="surveyTime" id="surveyTime" value="<fmt:formatDate value="${personInfo.surveyTime}" pattern="yyyy/MM/dd"/>" style="padding-left: 0px;"/>
					</td>
				</tr>
				<tr>
					<th>备注</th>
					<td colspan="3"><input  type="text" name="remarks" value="${personInfo.remarks}"/></td>
				</tr>
				</tbody>
			</table>
		</fieldset>
	</form>
</div>


