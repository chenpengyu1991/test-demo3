<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<fieldset class="layui-elem-field">
	
	<legend>基本信息</legend>
	<input type="hidden" id="dis-person-id" name="personInfo.id" value="${diseaseInfo.personInfo.id}">
	<table class="posttable">
		<colgroup>
			<col style="width: 15%;min-width:100px;" />
			<col style="width: 35%;min-width:200px;" />
			<col style="width: 15%;min-width:100px;" />
			<col style="width: 35%;min-width:200px;" />
		</colgroup>
		<tr>
			<th><label class="required"   for="idcard2">身份证</label></th>
			<td>
			<c:if test="${empty diseaseInfo.personInfo.idcard}">
				<input type="text"  id="idcard2"   name="personInfo.idcard" placeholder="输入身份证获取人员信息" value="${diseaseInfo.personInfo.idcard}" reg='{"required":true,"idCard":true}' />
				<input type="button" id="check-submit-btn1" value="读卡" style="width: 40px;" >
			</c:if>
			<c:if test="${not empty diseaseInfo.personInfo.idcard}">
				<input  type="text" id="idcard2"  readonly="readonly" name="personInfo.idcard" value="${diseaseInfo.personInfo.idcard}" reg='{"idCard":true}' />
			</c:if>
			</td>
			<th><label class="required" class="required" for="name">姓名</label></th>
			<td><input type="text" id="name" name="personInfo.name" value="${diseaseInfo.personInfo.name}" reg="{'required':true,'maxlength':16}" /></td>
		</tr>
		<tr>
			<th><label class="required" class="required" for="birthday">出生日期</label></th>
			<td>
			<%-- <tag:dateInput name="personInfo.birthday" id="birthday" onlypast="true" reg="{'required':true}" date="${personInfo.birthday}" /> --%>
			<input type="text" class="layui-input x-admin-content-sm-date" reg="{'required':true}"  name="personInfo.birthday" id="cdmInputBirthday" value="<fmt:formatDate value='${diseaseInfo.personInfo.birthday}' pattern='yyyy/MM/dd'/>" style="padding-left: 0px;" />
			</td>
			<th><label class="required" class="required">性别</label></th>
			<td><ehr:dic-radio id="gender" dicmeta="GBT226112003" name="personInfo.gender" value="${diseaseInfo.personInfo.gender}" reg="{'required':true}" /></td>
		</tr>
		<tr>
			<th><label class="required" for="marriage">婚姻</label></th>
			<td><ehr:dic-list dicmeta="GBT226122003" id="marriage" width="180px;" name="personInfo.marriage" value="${hy==null?diseaseInfo.personInfo.marriage:hy}" reg="{'required':true}" code="10,20,30,40,90"/></td>
			<th><label class="required" for="occupation">职业</label></th>
			<td><ehr:dic-list dicmeta="GBT6565"  width="180px;" code="0,1/2,3,4,5,6/7/8/9,X,Y,CV00031"  value="${zhiye==null?diseaseInfo.personInfo.occupation:zhiye}" id="occupation" name="personInfo.occupation" reg="{'required':true}" /></td>
		</tr>
		<tr>
			<th><label class="required" for="nation">民族</label></th>
			<%--<td><ehr:dic-list dicmeta="GBT3304" id="nation" width="180px;"   name="personInfo.nation" value="${personInfo.nation}" reg="{'required':true}" /></td>--%>
			<td>
				<input type="hidden" id="nation" value="${diseaseInfo.personInfo.nation}"/>
				<c:if test="${mz == null}">
					<label><input type="radio" reg='{"required":true}' onclick="util.clickHideText(this,'cdmOtherNationDesc')" name="personInfo.nation" ${diseaseInfo.personInfo.nation eq"01" ?"checked":""} value="01" /> 汉族</label>
					<label><input type="radio" reg='{"required":true}' onclick="util.clickShowText(this,'cdmOtherNationDesc')" name="personInfo.nation" ${(diseaseInfo.personInfo.nation ne "1" && not empty diseaseInfo.personInfo.nation && diseaseInfo.personInfo.nation ne"01") ?"checked":""} value="99" /> 少数民族</label>
				</c:if>
				<c:if test="${mz != null}">
					<label><input type="radio" reg='{"required":true}' onclick="util.clickHideText(this,'cdmOtherNationDesc')" name="personInfo.nation" ${mz eq"01" ?"checked":""} value="01" /> 汉族</label>
					<label><input type="radio" reg='{"required":true}' onclick="util.clickShowText(this,'cdmOtherNationDesc')" name="personInfo.nation" ${(mz ne"01" && mz ne "1") ?"checked":""} value="99" /> 少数民族</label>
				</c:if>
				<input type="text" id="cdmOtherNationDesc" ${(diseaseInfo.personInfo.nation ne "1" && not empty diseaseInfo.personInfo.nation && diseaseInfo.personInfo.nation ne"01")
						|| (mz ne '01' && mz ne '1' && not empty mz) ? "" : "class=\"hidediv\""} name="personInfo.otherNationDesc" value="${othermz==null?diseaseInfo.personInfo.otherNationDesc:othermz}" reg='{"required":"true"}' style="width: 70px;" />
			</td>
			<th><label class="required" for="education">文化程度</label></th>
			<td><ehr:dic-list dicmeta="GBT46582006" code="IDM17,20,IDM18,IDM19,IDM20,IDM21,IDM02,IDM07,IDM22,IDM10"   width="180px;"  value="${whcd==null?diseaseInfo.personInfo.education:whcd}" id="education" name="personInfo.education" reg="{'required':true}" /></td>
		</tr>
		<tr>
		<th><label class="required" for="phoneNumber">电话</label></th>
			<td><input id="phoneNumber" type="text" name="personInfo.phoneNumber" value="${diseaseInfo.personInfo.phoneNumber}" reg="{'required':true,'regex':'phone'}" /></td>
		<td></td>
			<td></td>
		</tr>
		<tr>
			<th><label class="required">常住类型</label></th>
			<td><ehr:dic-radio reg="{'required':true}" dicmeta="FS10005" name="personInfo.householdType" value='${diseaseInfo.personInfo.householdType}' /></td>
			<td></td>
			<td></td>
			</tr>
		<tr>
			<th><label class="required">现地址</label></th>
			<td colspan="3">
				<ehr:dic-town-street-village townName="personInfo.patownShip" streetName="personInfo.pastreet" villageName="personInfo.paGroup"
											 townId="pacounty" streetId="patownShip" villageId="pastreet"
											 townValue="${diseaseInfo.personInfo.patownShip}" streetValue="${diseaseInfo.personInfo.pastreet}" villageValue="${diseaseInfo.personInfo.paGroup}"
											 width="180px" reg="{'required':true}" callback="dmManageAdd.displayPaAddress"/>
				<br />
				<span  id="text_pahouseNumber_prefix" >
					<ehr:dic dicmeta="FS990001" code="${diseaseInfo.personInfo.patownShip}"/>
					<ehr:dic dicmeta="FS990001" code="${diseaseInfo.personInfo.pastreet}"/>
					<ehr:dic dicmeta="FS990001" code="${diseaseInfo.personInfo.paGroup}"/>
				</span>
				<input style="width: 300px" type="text" id="text_pahouseNumber" reg='{"required":"true","maxlength":23}'  name="personInfo.pahouseNumber"
					   value="${diseaseInfo.personInfo.pahouseNumber}"
				/>(详细地址)</td>
		</tr>
		<tr>
			<th><label class="required">户籍地址</label></th>
			<td colspan="3">
				<div class="${'1' ne diseaseInfo.personInfo.householdType?'hide':'' }" id="hr-address-select">
					<ehr:dic-town-street-village
							villageId="hrstreet" townId="hrcounty" streetId="hrtownShip"
							villageName="personInfo.hrGroup" streetName="personInfo.hrstreet"
							townName="personInfo.hrtownShip" streetValue="${diseaseInfo.personInfo.hrstreet}"
							villageValue="${diseaseInfo.personInfo.hrGroup}" callback="dmManageAdd.displayHrAddress"
							townValue="${diseaseInfo.personInfo.hrtownShip}" width="180px;" reg="{'dependOn':'personInfo.householdType','dependValue':'1','required':true}"/>
				</div>
				<span  id="text_hrhouseNumber_prefix" >
					<ehr:dic dicmeta="FS990001" code="${diseaseInfo.personInfo.hrtownShip}"/>
					<ehr:dic dicmeta="FS990001" code="${diseaseInfo.personInfo.hrstreet}"/>
					<ehr:dic dicmeta="FS990001" code="${diseaseInfo.personInfo.hrGroup}"/>
				</span> <input style="width: 300px" reg='{"required":"true","maxlength":23}'   type="text" id="text_hrhouseNumber" name="personInfo.hrhouseNumber" reg="{'required':true}"
																																																				value="${diseaseInfo.personInfo.hrhouseNumber}"
			/>(详细地址)</td>
		</tr>
		<tr>
			<th><label class="required" for="unitName">工作单位</label></th>
			<td><input type="text" id="unitName" name="personInfo.unitName" value="${unitName==null?diseaseInfo.personInfo.unitName:unitName}" reg="{'required':true,'maxlength':46}" /></td>
			<th>建档单位</th>
			<td>
				<span id="inputOrganNameTxt"><ehr:org code="${diseaseInfo.personInfo.inputOrganCode}"/></span>
				<input type="hidden" id="inputOrganName" value="{personInfo.inputOrganName}" />
				<%--<input type="text" id="inputOrganName" readonly="readonly" name="personInfo.inputOrganName" value="${personInfo.inputOrganName}" />--%>
				<input type="hidden" id="inputOrganCode" name="personInfo.inputOrganCode" value="${diseaseInfo.personInfo.inputOrganCode}" /></td>
		</tr>
	</table>
</fieldset>

<script type="text/javascript">

layui.use('laydate', function(){
    var laydate = layui.laydate;
    
    //执行一个laydate实例
    laydate.render({
      elem: '#cdmInputBirthday' 
   	   ,format: 'yyyy/MM/dd'
   	   ,max:0
    });

  });
</script>