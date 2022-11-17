<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<script src="${pageContext.request.contextPath}/js/views/portal/reserve/add.js" type="text/javascript"></script>

<div class="toolbar">
	<a href="javascript:void(0)" id="health-card-back-btn" onclick="reserveAdd.backToSearch()"><b class="fanhui">返回</b></a>
	<a href="javascript:void(0);" id="health-card-save-btn" onclick="reserveAdd.save()"><b class="tijiao" >提交</b></a>
</div>
	
<div class="postcontent">
	<form method="post" id="reserveFrom">
	<div class="postdiv">
	<fieldset>
		<legend>基本信息</legend>
		<input type="hidden" name="personId" id="personId">
		<table class="posttable">
			<colgroup>
				<col style="width: 15%;min-width:100px;" />
				<col style="width: 35%;min-width:200px;" />
				<col style="width: 15%;min-width:100px;" />
				<col style="width: 35%;min-width:200px;" />
			</colgroup>
			<tr>
				<th><label class="required">身份证</label></th>
				<td>
					<input type="text" id="idCard" name="idcard" placeholder="输入身份证获取个人信息！" reg='{"idCard":true}' />
				</td>
				<th><label class="required">姓名</label></th>
				<td><input type="text" id="name" name="name" reg="{'required':true,'maxlength':16}" /></td>
			</tr>
			<tr>
				<th><label class="required">出生日期</label></th>
				<td><tag:dateInput name="birthday" id="birthday" onlypast="true" reg="{'required':true}" /></td>
				<th><label class="required">性别</label></th>
				<td><ehr:dic-list id="gender" dicmeta="GBT226112003" name="gender" reg="{'required':true}" /></td>
			</tr>
			<tr>
				<th>工作单位</th>
				<td><input type="text" id="unitName" name="unitName" reg="{'maxlength':46}" /></td>
				<th><label class="required">电话</label></th>
				<td><input id="phoneNumber" type="text" name="phoneNumber" reg="{'required':true,'regex':'phone'}" /></td>
			</tr>
			<!-- <tr>
				<th><label>医保卡号</label></th>
				<td><input type="text" id="idcardHos" name="idcardHos" reg="{'maxlength':10}" /></td>
				<th><label>新农合号</label></th>
				<td><input type="text" id="idcardFarm" name="idcardFarm" reg="{'maxlength':10}"/></td>
			</tr> -->
			<%-- <tr>
				<th><label class="required">现地址</label></th>
				<td colspan="3">
					<input type="hidden" id="paAddressDetail"  name="paAddressDetail" />
					<ehr:dic-town-village width="250px;" townId="patownShip" villageId="pastreet" villageName="pastreet"
						townName="patownShip" reg="{'required':true}"  callback="reserveAdd.displayPaAddress"/>
					<br/>
					<span id="cccc"></span>
					<input type="text" style="width: 300px;" id="pahouseNumber"
						reg='{"required":"true","maxlength":23}' name="pahouseNumber" />(详细地址)
				</td>
			</tr> --%>
		</table>
	</fieldset>
	</div>
	<div class="postdiv">
	<fieldset>
	<legend>挂号资源</legend>
		<input type="hidden" id="scheduleId" name="scheduleId"/>
		<input type="hidden" id="scheduleTimeId" name="scheduleTimeId"/>
		<input type="hidden" id="success" name="success" value="${success }"/>
		<input type="hidden" id="startTime" name="startTime" value="${startTime }"/>
		<input type="hidden" id="endTime" name="endTime" value="${endTime }"/>
		<table style="width:99%" class="posttable">
	    	<colgroup>
				<col style="width: 15%;min-width:100px;" />
				<col style="width: 35%;min-width:200px;" />
				<col style="width: 15%;min-width:100px;" />
				<col style="width: 35%;min-width:200px;" />
			</colgroup>
			<tbody>
				<tr>
					<td colspan="4">
						<a href="javascript:void(0)" onclick="reserveAdd.select()">选择排班资源</a>
					</td>
				</tr>
				<tr>
					<th>医院：</th>
					<td>
						<input type="text" id="hospitalName" readonly="readonly"/>
					</td>
					<th>科室：</th>
					<td>
						<input type="text" id="outClinicName" readonly="readonly"/>
					</td>
				</tr>
				<tr>
					<th>医生：</th>
					<td>
						<input type="text" id="outDoctorName" readonly="readonly"/>
					</td>
					<th>
						号别：</th>
					<td>
						<input type="text" id="clinicType" readonly="readonly"/>
					</td>
				</tr>
				<tr>
					<th>挂号费：</th>
					<td>
						<input type="text" id="registerFee" readonly="readonly"/>
					</td>
					<th>预约日期：</th>
					<td>
						<input type="text" id="requestDate" readonly="readonly"/>
					</td>
				</tr>
				<tr>
					<th>取号时间</th>
					<td>
						<input type="text" id="takeNoTimeId" readonly="readonly"/>
					</td>
				</tr>
			</tbody>
		</table>
	</fieldset>
	</div>
	</form>
</div>
