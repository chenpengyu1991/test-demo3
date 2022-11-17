<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/views/hsa/sodp/addressStatus.js"></script>
<div class="toolbar">
	<a href="javascript:void(0)" id="return-sus-occ-di-button"><b class="fanhui">返回</b></a> <a href="javascript:void(0)" id="save-sus-occ-di-button"><b
		class="baocun"
	>保存</b></a>
</div>
<form id="sus-occ-dis-form">
	<div class="postcontent">
		<i class="popno">门诊职业健康教育、咨询、指导记录表</i>
		<div class="postdiv">
			<input type="hidden" id="id" name="id" value="${susOccDiInfo.id}" />
			<fieldset>
				<legend>接诊情况</legend>
				<table class="posttable">
					<colgroup>
						<col style="width: 10%; min-width: 100px;" />
						<col style="width: 18%; min-width: 200px;" />
						<col style="width: 10%; min-width: 100px;" />
						<col style="width: 18%; min-width: 200px;" />
					</colgroup>
					<tr>
						<th><label for="admissionOrganName">接诊单位名称</label></th>
						<td><input type="text" id="admissionOrganName" name="admissionOrganName" value="${susOccDiInfo.admissionOrganName}" reg="{'maxlength':70}"></input></td>
						<th><label for="admissionDeptName">接诊部门名称</label></th>
						<td><input type="text" id="admissionDeptName" name="admissionDeptName" value="${susOccDiInfo.admissionDeptName}" reg="{'maxlength':70}"></input></td>
					</tr>
					<tr>
						<th><label for="admissionDoctorName">接诊人姓名</label></th>
						<td><input type="text" id="admissionDoctorName" name="admissionDoctorName" value="${susOccDiInfo.admissionDoctorName}"
							reg="{'maxlength':50}"
						></input></td>
						<th><label for="admissionDate">接诊时间</label></th>
						<td><tag:dateInput reg="{}" name="admissionDate" id="admissionDate" onlypast="true" date="${susOccDiInfo.admissionDate}" /></td>
					</tr>
					<tr>
						<th><label class="required" for="ehrNo">门诊号</label></th>
						<td><input type="text" id="ehrNo" name="ehrNo" value="${susOccDiInfo.ehrNo}" reg="{'required':true,'maxlength':20}"></input></td>
					</tr>
				</table>
			</fieldset>
			<fieldset>
				<legend>就诊者情况</legend>
				<table class="posttable">
					<colgroup>
						<col style="width: 10%; min-width: 100px;" />
						<col style="width: 18%; min-width: 200px;" />
						<col style="width: 10%; min-width: 100px;" />
						<col style="width: 18%; min-width: 200px;" />
					</colgroup>
					<tr>
						<th><label for="idcard" class="required">居民身份证</label></th>
						<td><input type="text" id="idcard" name="idcard" placeholder="输入身份证获取人员信息" value="${susOccDiInfo.idcard}"
							reg="{'required':true,'idCard':true}"
						></input></td>
						<th><label for="name" class="required">姓名</label></th>
						<td><input type="text" id="name" name="name" value="${susOccDiInfo.name}" reg="{'maxlength':50,'required':true}"></input></td>
					</tr>
					<tr>
						<th><label for="gender" class="required">性别</label></th>
						<td><ehr:dic-radio dicmeta="GBT226112003" name="gender" id="gender" reg="{'required':true}" value="${susOccDiInfo.gender}" /></td>
						<th><label for="age" class="required">年龄</label></th>
						<td><input type="text" id="age" name="age" value="${susOccDiInfo.age}" reg="{'maxlength':10,'required':true}"></input></td>
					</tr>
					<tr>
						<th><label for="unitName">工作单位</label></th>
						<td><input type="text" id="unitName" name="unitName" value="${susOccDiInfo.unitName}" reg="{'maxlength':70}"></input></td>
						<th><label for="unitAddress">工作单位地址</label></th>
						<td><input type="text" id="unitAddress" name="unitAddress" value="${susOccDiInfo.unitAddress}" reg="{'maxlength':100}"></input></td>
					</tr>
					<tr>
						<th><label class="required">常住类型</label></th>
						<td><ehr:dic-radio reg="{'required':true}" dicmeta="FS10005" name="domicileType" value='${susOccDiInfo.domicileType}' /></td>
						<th><label for="phoneNumber">联系电话</label></th>
						<td><input type="text" id="phoneNumber" name="phoneNumber" value="${susOccDiInfo.phoneNumber}" reg="{'maxlength':20}"></input></td>
					</tr>
					<tr>
						<th><label class="required">现地址</label></th>
						<td colspan="3">
							<ehr:dic-town-street-village width="180px;" villageId="village_address" streetId="street_address"
							 townId="town_address" villageName="pastreet" streetName="patownShip"
							townName="pacounty" villageValue="${susOccDiInfo.pastreet}" streetValue="${susOccDiInfo.patownShip}"
							townValue="${susOccDiInfo.pacounty}" reg="{'required':true}"/><br />
							<%--<ehr:dic-town-village villageId="village_address" width="180px;" townId="town_address" villageName="pastreet"
								townName="patownShip" villageValue="${susOccDiInfo.pastreet}" townValue="${susOccDiInfo.patownShip}" reg="{'required':true}"
							/> <br /> --%>
							<span id="text_pahouseNumber_prefix"><ehr:dic dicmeta="FS990001" code="${susOccDiInfo.pacounty}"></ehr:dic>
								<ehr:dic dicmeta="FS990001" code="${susOccDiInfo.patownShip}"></ehr:dic>
							    <ehr:dic dicmeta="FS990001" code="${susOccDiInfo.pastreet}"></ehr:dic></span>
							<input style="width: 300px" type="text" id="text_pahouseNumber" reg='{"required":"true","maxlength":23}' name="pahouseNumber"
							value="${susOccDiInfo.pahouseNumber}"
						/>(详细地址)</td>
					</tr>
					<tr>
						<th><label class="required">户籍地址</label></th>
						<td colspan="3"><div class="${'1' ne susOccDiInfo.domicileType?'hide':'' }" id="hr-address-select">
							<ehr:dic-town-street-village width="180px;" villageId="homeVillage_address" streetId="homeStreet_address"
								townId="homeTown_address" villageName="hrstreet" streetName="hrtownShip"
								townName="hrcounty" villageValue="${susOccDiInfo.hrstreet}" streetValue="${susOccDiInfo.hrtownShip}"
								townValue="${susOccDiInfo.hrcounty}" reg="{'dependOn':'domicileType','dependValue':'1','required':true}"/><br />

								<%--<ehr:dic-town-village villageId="homeVillage_address" townId="homeTown_address" villageName="hrstreet" townName="hrtownShip"
									villageValue="${susOccDiInfo.hrstreet}" townValue="${susOccDiInfo.hrtownShip}" width="180px;"
									reg="{'dependOn':'domicileType','dependValue':'1','required':true}"
								/>--%>
							</div> <span id="text_hrhouseNumber_prefix"><ehr:dic dicmeta="FS990001" code="${susOccDiInfo.hrcounty}"></ehr:dic> <ehr:dic
									dicmeta="FS990001" code="${susOccDiInfo.hrtownShip}"
								></ehr:dic><ehr:dic dicmeta="FS990001" code="${susOccDiInfo.hrstreet}"></ehr:dic></span>
							<input style="width: 300px" reg='{"required":"true","maxlength":23}' type="text" id="text_hrhouseNumber" name="hrhouseNumber"
							reg="{'required':true}" value="${susOccDiInfo.hrhouseNumber}"
						/>(详细地址)</td>
					</tr>
					<tr>
						<th><label for="chiefComplaintSymptoms">主要自诉症状</label></th>
						<td colspan="3"><input type="text" id="chiefComplaintSymptoms" name="chiefComplaintSymptoms" value="${susOccDiInfo.chiefComplaintSymptoms}"
							reg="{'maxlength':200}"
						></input></td>
					</tr>
				</table>
			</fieldset>
			<fieldset>
				<legend>询问内容</legend>
				<table class="posttable">
					<colgroup>
						<col style="width: 10%; min-width: 100px;" />
						<col style="width: 18%; min-width: 200px;" />
						<col style="width: 10%; min-width: 100px;" />
						<col style="width: 18%; min-width: 200px;" />
					</colgroup>
					<tr>
						<th><label for="occupation" class="required">工种</label></th>
						<td><input width="237px;" reg="{'required':true,'maxlength':100}" type="text" value="${susOccDiInfo.occupation}" name="occupation" id="occupation" /> <span class="hide"><ehr:dic-list
									dicmeta="GBT6565"
									code="CV020120201,CV020120202,CV020120203,CV020120204,CV020120205,CV020120206,CV020120207,CV020120224,CV020120209,CV020120210,CV020120211,CV020120212,CV020120213,CV020120214,CV020120215,CV020120216,CV020120217,CV020120299"
									value="${susOccDiInfo.occupation}" id="occupation_fordisplay" name="occupation_fordisplay"
								/></span></td>
						<th><label for="workPalce" class="required">工作场所</label></th>
						<td><input type="text" id="workPalce" name="workPalce" value="${susOccDiInfo.workPalce}" reg="{'maxlength':100,'required':true}"></input></td>
					</tr>
					<tr>
						<th><label for="riskFactorsMayContact">可能接触的危险因素</label></th>
						<td><input type="text" id="riskFactorsMayContact" name="riskFactorsMayContact" value="${susOccDiInfo.riskFactorsMayContact}"
							reg="{'maxlength':100}"
						></input></td>
						<th><label for="contactRiskWorkingTime">接害工作时间</label></th>
						<td><tag:dateInput reg="{}" name="contactRiskWorkingTime" id="contactRiskWorkingTime" onlypast="true"
								date="${susOccDiInfo.contactRiskWorkingTime}"
							/></td>
					</tr>
					<tr>
						<th><label for="incidenceProcess">发病过程</label></th>
						<td colspan="3"><input type="text" id="incidenceProcess" name="incidenceProcess" value="${susOccDiInfo.incidenceProcess}"
							reg="{'maxlength':200}"
						></input></td>
					</tr>
					<tr>
						<th><label for="otherCases">其它情况</label></th>
						<td colspan="3"><input type="text" id="otherCases" name="otherCases" value="${susOccDiInfo.otherCases}" reg="{'maxlength':200}"></input></td>
					</tr>
				</table>
			</fieldset>
			<fieldset>
				<legend>健康教育、咨询、指导</legend>
				<table class="posttable">
					<colgroup>
						<col style="width: 18%; min-width: 100px;" />
						<col style="width: 82%; min-width: 200px;" />
					</colgroup>
					<tr>
						<th><label for="guidanceTime" >指导时间(分钟)</label></th>
						<td><tag:numberInput style="width: 155px;" id="guidanceTime" name="guidanceTime" value="${susOccDiInfo.guidanceTime}"
								reg="{'min':'5','max':'60','digits':true}"
							/></td>
					</tr>
					<tr>
						<th><label for="mainContent">主要内容</label></th>
						<td><textarea style="min-width: 500px; height: 120px" id="mainContent" name="mainContent" reg="{'maxlength':500}">${susOccDiInfo.mainContent}</textarea></td>
					</tr>
				</table>
			</fieldset>
			<fieldset>
				<legend>告知情况</legend>
				<table class="posttable">
					<colgroup>
						<col style="width: 10%; min-width: 100px;" />
						<col style="width: 18%; min-width: 200px;" />
						<col style="width: 10%; min-width: 100px;" />
						<col style="width: 18%; min-width: 200px;" />
					</colgroup>
					<tr>
						<th></th>
						<td colspan="3">告知就诊者、患者，若怀疑职业病可到有职业健康检查资质或职业病诊断管理的医疗卫生机构<br />（如，疾病预防控制中心）进行规范体检，以确定是否为疑似职业病。 <ehr:dic-radio
								dicmeta="FS10238" name="informeFlag" value="${susOccDiInfo.informeFlag }"
							/>
						</td>
					</tr>
					<tr>
						<c:choose>
							<c:when test="${not empty susOccDiInfo.reporterName}">
								<th><label class="required" for="reporterName">门诊医生</label></th>
								<td><input readonly="readonly" type="text" id="reporterName" name="reporterName" value="${susOccDiInfo.reporterName}"
									reg="{'maxlength':50}"
								></input></td>
							</c:when>
							<c:otherwise>
								<th><label class="required" for="reporterName">门诊医生</label></th>
								<td><input readonly="readonly" type="text" id="reporterName" name="reporterName" value="${currentUserName}"></input></td>
							</c:otherwise>
						</c:choose>
						<c:choose>
							<c:when test="${not empty susOccDiInfo.reportDate}">
								<th><label class="required" for="reportDate">报告日期</label></th>
								<td><tag:dateInput reg="{'required':true}" name="reportDate" id="reportDate" onlypast="true" date="${susOccDiInfo.reportDate}" /></td>
							</c:when>
							<c:otherwise>
								<th><label class="required" for="reportDate">报告日期</label></th>
								<td><tag:dateInput reg="{'required':true}" name="reportDate" id="reportDate" onlypast="true" date="${currentDate}" /></td>
							</c:otherwise>
						</c:choose>
					</tr>
				</table>
			</fieldset>
		</div>
	</div>
</form>
