<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<fieldset class="layui-elem-field">

	<legend>基本信息</legend>
	<input type="hidden" name="personInfo.id" value="${personInfo.id}">
	<table class="posttable">
		<colgroup>
			<col style="width: 15%;min-width:100px;" />
			<col style="width: 35%;min-width:200px;" />
			<col style="width: 15%;min-width:100px;" />
			<col style="width: 35%;min-width:200px;" />

		</colgroup>
		<c:if test="${allowPersonEditable==true}">
			<tr>
				<th><label class="required" class="required" for="cdm_report_name">姓名</label></th>
				<td><input type="text" id="cdm_report_name" name="personInfo.name" value="${personInfo.name}" reg="{'required':true,'maxlength':16}" /></td>
				<th><label  for="cdm_report_idcard">身份证</label></th>
				<td>
					<c:if test="${empty personInfo.idcard}">
						<input type="text" id="cdm_report_idcard" name="personInfo.idcard" value="${personInfo.idcard}" reg='{"idCard":true}' />
					</c:if>
					<c:if test="${not empty personInfo.idcard}">
						<input type="text" id="cdm_report_idcard" readonly="readonly" name="personInfo.idcard" value="${personInfo.idcard}" reg='{"idCard":true}' />
					</c:if>
				</td>
			</tr>
			<tr>
				<th><label class="required" class="required" for="birthday">出生日期</label></th>
				<td>
				<%-- <tag:dateInput name="personInfo.birthday" id="birthday" onlypast="true" reg="{'required':true}" date="${personInfo.birthday}" /> --%>
				<input class="layui-input x-admin-content-sm-date" reg="{'required':true}" placeholder="选择日期" name="personInfo.birthday" id="reportCardAppBirthdayId" value="<fmt:formatDate value='${personInfo.birthday}' pattern='yyyy/MM/dd'/>" style="padding-left: 0px;" />
				</td>
				<th><label class="required" class="required">性别</label></th>
				<td><ehr:dic-radio id="gender" dicmeta="GBT226112003" name="personInfo.gender" value="${personInfo.gender}" reg="{'required':true}" /></td>
			</tr>
			<tr>
				<th><label class="required" for="marriage">婚姻</label></th>
				<td><ehr:dic-list dicmeta="GBT226122003" id="marriage" width="180px;"   name="personInfo.marriage" value="${personInfo.marriage}" reg="{'required':true}" /></td>
				<th><label class="required" for="occupation">职业</label></th>
				<td><ehr:dic-list dicmeta="GBT6565" code="0,1/2,3,4,5,6/7/8/9,X,Y,CV00031"  width="180px;"  value="${personInfo.occupation}" id="occupation" name="personInfo.occupation" reg="{'required':true}" /></td>
			</tr>
			<tr>
				<th><label class="required" for="nation">民族</label></th>
				<td>
					<%--<ehr:dic-list dicmeta="GBT3304" id="nation" width="180px;" name="personInfo.nation" value="${personInfo.nation}" reg="{'required':true}" />--%>
					<input type="hidden" id="nation" value="${personInfo.nation}"/>
					<c:if test="${mz == null}">
						<label><input type="radio" reg='{"required":true}' onclick="util.clickHideText(this,'otherNationDesc')" name="personInfo.nation" ${personInfo.nation eq"01" ?"checked":""} value="01" /> 汉族</label>
						<label><input type="radio" reg='{"required":true}' onclick="util.clickShowText(this,'otherNationDesc')" name="personInfo.nation" ${(personInfo.nation ne "1" && not empty personInfo.nation && personInfo.nation ne"01") ?"checked":""} value="99" /> 少数民族</label>
					</c:if>
					<c:if test="${mz != null}">
						<label><input type="radio" reg='{"required":true}' onclick="util.clickHideText(this,'otherNationDesc')" name="personInfo.nation" ${mz eq"01" ?"checked":""} value="01" /> 汉族</label>
						<label><input type="radio" reg='{"required":true}' onclick="util.clickShowText(this,'otherNationDesc')" name="personInfo.nation" ${(mz ne"01" && mz ne "1") ?"checked":""} value="99" /> 少数民族</label>
					</c:if>
					<input type="text" id="otherNationDesc"
						${(personInfo.nation ne "1" && not empty personInfo.nation && personInfo.nation ne"01")
								|| (mz ne '01' && mz ne '1' && not empty mz) ? "" : "class=\"hidediv\""}
						   name="personInfo.otherNationDesc" value="${othermz==null?personInfo.otherNationDesc:othermz}" reg='{"required":"true"}' style="width: 70px;" />
				</td>
				<th><label class="required" for="education">文化程度</label></th>
				<td><ehr:dic-list dicmeta="GBT46582006" code="IDM17,20,IDM18,IDM19,IDM20,IDM21,IDM02,IDM07,IDM22,IDM10"  width="180px;"  value="${personInfo.education}" id="education" name="personInfo.education" reg="{'required':true}" /></td>
			</tr>
			<tr>
				<th><label class="required">常住类型</label></th>
				<td><ehr:dic-radio reg="{'required':true}" dicmeta="FS10005" name="personInfo.householdType" value='${personInfo.householdType}'/></td>
				<th><label class="required" for="phoneNumber">电话</label></th>
				<td><input id="phoneNumber" type="text" name="personInfo.phoneNumber" value="${personInfo.phoneNumber}" reg="{'required':true,'regex':'phone'}" /></td>
			</tr>
			<tr>
				<th><label class="required">现地址</label></th>
				<td colspan="3">
					<ehr:dic-town-street-village townName="personInfo.patownShip" streetName="personInfo.pastreet" villageName="personInfo.paGroup"
												 townId="patownShip" streetId="pastreet" villageId="paGroup"
												 townValue="${personInfo.patownShip}" streetValue="${personInfo.pastreet}" villageValue="${personInfo.paGroup}"
												 width="180px" reg="{'required':true}"/>
					<br />
					<span  id="text_pahouseNumber_prefix" >
						<ehr:dic dicmeta="FS990001" code="${personInfo.patownShip}"/>
						<ehr:dic dicmeta="FS990001" code="${personInfo.pastreet}"/>
						<ehr:dic dicmeta="FS990001" code="${personInfo.paGroup}"/>
					</span>
					<input style="width: 300px" type="text" id="text_pahouseNumber" reg='{"required":"true","maxlength":23}'  name="personInfo.pahouseNumber"
						   value="${personInfo.pahouseNumber}"
					/>(详细地址)</td>
			</tr>
			<tr>
				<th><label class="required">户籍地址</label></th>
				<td colspan="3">
					<div class="${'1' ne personInfo.householdType?'hide':'' }" id="hr-address-select">
						<ehr:dic-town-street-village
								villageId="hrstreet" townId="hrcounty" streetId="hrtownShip"
								villageName="personInfo.hrGroup" streetName="personInfo.hrstreet"
								townName="personInfo.hrtownShip" streetValue="${personInfo.hrstreet}"
								villageValue="${personInfo.hrGroup}"
								townValue="${personInfo.hrtownShip}" width="180px;" reg="{'dependOn':'personInfo.householdType','dependValue':'1','required':true}"/>
					</div>
					<span  id="text_hrhouseNumber_prefix"  class="${'1' ne personInfo.householdType?'hide':'' }">
						<ehr:dic dicmeta="FS990001" code="${personInfo.hrtownShip}"/>
						<ehr:dic dicmeta="FS990001" code="${personInfo.hrstreet}"/>
						<ehr:dic dicmeta="FS990001" code="${personInfo.hrGroup}"/>
					</span> 
					<input style="width: 300px" reg='{"required":"true","maxlength":23}'   type="text" id="text_hrhouseNumber" name="personInfo.hrhouseNumber" reg="{'required':true}"
																																																					value="${personInfo.hrhouseNumber}"
				/>(详细地址)</td>
			</tr>
			<tr>
				<th><label  for="unitName">工作单位</label></th>
				<td><input type="text" id="unitName" name="personInfo.unitName" value="${personInfo.unitName}" reg="{'maxlength':46}" /></td>
				<th>健康档案管理单位</th>
				<td><input type="text" id="text_inputOrganName" readonly="readonly" name="personInfo.inputOrganName" value="${personInfo.inputOrganName}" />
					<input type="hidden" id="text_inputOrganCode" name="personInfo.inputOrganCode" value="${personInfo.inputOrganCode}" /></td>
			</tr>
		</c:if>
		<c:if test="${allowPersonEditable==false}">
			<tr>
				<th><label   >姓名</label></th>
				<td><input  readonly="readonly"  type="text" id="cdm_report_name" name="personInfo.name" value="${personInfo.name}"  /></td>
				<th><label  for="cdm_report_idcard">身份证</label></th>
				<td>
					<input type="text" id="cdm_report_idcard" readonly="readonly" name="personInfo.idcard" value="${personInfo.idcard}"  />
				</td>
			</tr>
			<tr>
				<th><label   for="birthday">出生日期</label></th>
				<td>
					<input type="text" readonly="readonly"   id="birthday"  name="personInfo.birthday"   value='<fmt:formatDate value="${personInfo.birthday}" pattern="yyyy/MM/dd" />' />
				</td>
				<th><label >性别</label></th>

				<td>
					<input type="hidden" name="personInfo.gender" value="${personInfo.gender}" />
					<input type="text"  readonly="readonly"      value='<ehr:dic dicmeta="GBT226112003"   code="${personInfo.gender}" />' /></td>
			</tr>
			<tr>
				<th><label  for="marriage">婚姻</label></th>
				<td>
					<input type="hidden" name="personInfo.marriage" value="${personInfo.marriage}" />
					<input type="text" readonly="readonly"     value='<ehr:dic dicmeta="GBT226122003"   code="${personInfo.marriage}" />' /></td>
				<th><label  for="occupation">职业</label></th>
				<td>
					<input type="hidden" name="personInfo.occupation" value="${personInfo.occupation}" />
					<input type="text" readonly="readonly"    value='<ehr:dic dicmeta="GBT6565"   code="${personInfo.occupation}" />' /></td>
			</tr>
			<tr>
				<th><label  for="nation">民族</label></th>
				<td>
					<input type="hidden" id="nation" value="${personInfo.nation}"/>
					<c:if test="${mz == null}">
						<label><input type="radio" reg='{"required":true}' onclick="util.clickHideText(this,'otherNationDesc')" name="personInfo.nation" ${personInfo.nation eq"01" ?"checked":""} value="01" /> 汉族</label>
						<label><input type="radio" reg='{"required":true}' onclick="util.clickShowText(this,'otherNationDesc')" name="personInfo.nation" ${(personInfo.nation ne "1" && not empty personInfo.nation && personInfo.nation ne"01") ?"checked":""} value="99" /> 少数民族</label>
					</c:if>
					<c:if test="${mz != null}">
						<label><input type="radio" reg='{"required":true}' onclick="util.clickHideText(this,'otherNationDesc')" name="personInfo.nation" ${mz eq"01" ?"checked":""} value="01" /> 汉族</label>
						<label><input type="radio" reg='{"required":true}' onclick="util.clickShowText(this,'otherNationDesc')" name="personInfo.nation" ${(mz ne"01" && mz ne "1") ?"checked":""} value="99" /> 少数民族</label>
					</c:if>
					<input type="text" id="otherNationDesc"
						${(personInfo.nation ne "1" && not empty personInfo.nation && personInfo.nation ne"01")
								|| (mz ne '01' && mz ne '1' && not empty mz) ? "" : "class=\"hidediv\""}
						   name="personInfo.otherNationDesc" value="${othermz==null?personInfo.otherNationDesc:othermz}" reg='{"required":"true"}' style="width: 70px;" />
				</td>
				<th><label  for="education">文化程度</label></th>
				<td>
					<input type="hidden" name="personInfo.education" value="${personInfo.education}" />
					<input type="text" readonly="readonly"      value='<ehr:dic dicmeta="GBT46582006"   code="${personInfo.education}" />' /></td>
			</tr>
			<tr>
				<th><label >常住类型</label></th>
				<td>
					<input type="hidden" name="personInfo.householdType"   value="${personInfo.householdType}" />
					<input type="text"  readonly="readonly"  value='<ehr:dic dicmeta="FS10005"   code="${personInfo.householdType}" />' /></td>
				<th><label  for="phoneNumber">电话</label></th>

				<td><input type="text"  readonly="readonly"   id="phoneNumber" type="text" name="personInfo.phoneNumber" value="${personInfo.phoneNumber}" reg="{'required':true,'regex':'phone'}" /></td>
			</tr>
			<tr>
				<th><label >现地址</label></th>
				<td colspan="3">
					<input type="hidden" name="personInfo.patownShip" value="${personInfo.patownShip}">
					<input type="hidden" name="personInfo.pastreet" value="${personInfo.pastreet}">
					<input type="hidden"  name="personInfo.paGroup" value="${personInfo.paGroup}">
					<input type="hidden"   name="personInfo.pahouseNumber" value="${personInfo.pahouseNumber}">
					<ehr:dic dicmeta="FS990001" code="${personInfo.pacounty }"></ehr:dic>
					<ehr:dic dicmeta="FS990001" code="${personInfo.patownShip }"></ehr:dic>
					<ehr:dic dicmeta="FS990001" code="${personInfo.pastreet }"></ehr:dic>
					<ehr:dic dicmeta="FS990001" code="${personInfo.paGroup }"></ehr:dic>
						${personInfo.pahouseNumber }
				</td>
			</tr>
			<tr>
				<th><label>户籍地址</label></th>
				<td colspan="3">
					<input type="hidden" name="personInfo.hrtownShip" value="${personInfo.hrtownShip}">
					<input type="hidden"  name="personInfo.hrstreet" value="${personInfo.hrstreet}">
					<input type="hidden"  name="personInfo.hrGroup" value="${personInfo.hrGroup}">
					<input type="hidden"  name="personInfo.hrhouseNumber" value="${personInfo.hrhouseNumber}">
					<span class="${'1' ne personInfo.householdType?'hide':'' }" id="hr-address-select">
						<ehr:dic dicmeta="FS990001" code="${personInfo.hrtownShip }"></ehr:dic>
						<ehr:dic dicmeta="FS990001" code="${personInfo.hrstreet }"></ehr:dic>
						<ehr:dic dicmeta="FS990001" code="${personInfo.hrGroup }"></ehr:dic>
					</span>
						${personInfo.hrhouseNumber }

				</td>
			</tr>
			<tr>
				<th><label  for="unitName">工作单位</label></th>
				<td><input  readonly="readonly"   type="text" id="unitName" name="personInfo.unitName" value="${personInfo.unitName}"  /></td>
				<th>健康档案管理单位</th>
				<td>
					<input type="text" id="text_inputOrganName" readonly="readonly" name="personInfo.inputOrganName" value="${personInfo.inputOrganName}" />
					<input type="hidden" id="text_inputOrganCode" name="personInfo.inputOrganCode" value="${personInfo.inputOrganCode}" /></td>
			</tr>

		</c:if>
	</table>
</fieldset>

<script type="text/javascript">

layui.use('laydate', function(){
    var laydate = layui.laydate;
    
    laydate.render({
      elem: '#reportCardAppBirthdayId' 
   	   ,format: 'yyyy/MM/dd'
   	   ,max:0
    });

  });
</script>