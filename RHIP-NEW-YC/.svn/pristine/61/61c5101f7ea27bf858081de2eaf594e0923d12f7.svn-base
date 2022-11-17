<%@page pageEncoding="UTF-8"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/ehr-tag" prefix="ehr"%>
<script src="${pageContext.request.contextPath}/js/views/vaccine/hospital/add_influenza.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/card/readCard.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/views/vaccine/hospital/vaccine_common.js" type="text/javascript"></script>

<div class="toolbar">
	<!-- 	<a href="javascript:void(0)" id="healthEducationActiveBackButton"><b class="fanhui">返回</b></a> -->
	<!-- <a href="javascript:void(0)"
       id="healthEducationActiveSaveButton"
   ><b class="baocun">保存</b></a> -->
	<a href="javascript:void(0)" id="influenzaBack"><button class="btn-gray layui-btn layui-btn-sm button"><i class="layui-icon"></i>返回</button></a>
	<a href="javascript:void(0)"
	   id="influenzaSave">
		<button class="layui-btn layui-btn-sm"><i class="layui-icon">&#xe605;</i>保存</button>
	</a>
</div>

<form method="post" id="vaccine_influenza_save">

<!-- 更新时用到 -->
<input type="hidden" name="ehrId" value="${ehrId}"/>
<input type="hidden" name="VaccinationDetailsDTO.vaccineType" id="vaccineType" value="3"/>

<!-- 患者基本情况 -->
<div class="postcontent">
	<div style="text-align: center; font-size: 16px; font-weight: bold;">
		永城市流感疫苗接种登记表
	</div>
	<label id="check-card-message" style="color: red"> ${checkMessage}</label>
	<div class="postdiv">
        <fieldset class="layui-elem-field">
        <legend>患者基本情况</legend>
		<table style="width:99%" class="posttable">
            <colgroup >
                <col width="18%" />
                <col width="30%" />
                <col width="18%" />
                <col width="30%" />
            <colgroup>
			<tbody>
			<tr>
				<th><label>身份证号：</label></th>
				<td>
					<input type="text" id="idCardTxt" name="VaccinationDetailsDTO.vaccinationMgmt.idCard" placeholder="输入身份证获取个人信息！"
						reg='{"idCard":true,"maxlength":"18"}' value="${vaccinationMgmt.idCard }"/>
					<a class="readCard" id="button_read" title="请将市民卡或身份证放置读卡器上,点击这里" style="display: none;" ><img src="${pageContext.request.contextPath}/images/btn/readcard.ico" >读卡</a>
				</td>
				<th><label class="required">姓名：</label></th>
				<td>
					<input type="text" id="nameTxt" name="VaccinationDetailsDTO.vaccinationMgmt.name"
					 reg='{"required":"true","maxlength":"16"}'  value="${vaccinationMgmt.name }"/>
				</td>
            </tr>
            <tr>
				<th><label class="required">性别：</label></th>
				<td>
					<ehr:dic-list id="genderTxt" dicmeta="GBT226112003" reg='{"required":"true"}'
						name="VaccinationDetailsDTO.vaccinationMgmt.gender" value="${vaccinationMgmt.gender}" width="75%" />
				</td>
				<th><label class="required">年龄：</label></th>
				<td>
					<input type="text" id="ageTxt" name="VaccinationDetailsDTO.vaccinationMgmt.age" 
						reg='{"required":"true","regex":"digits"}' value="${vaccinationMgmt.age }" maxlength="3"/>&nbsp;岁
				</td>
            </tr>
            <tr>
				<th>是否流动人口：</th>
				<td>
					<ehr:dic-radio name="VaccinationDetailsDTO.vaccinationMgmt.householdType" dicmeta="PH00001"
								   value="${vaccinationMgmt.householdType}" code="1,2" onchange="mainPageH.toggerAddress()"/>
				</td>
				<th><label class="required">联系电话：</label></th>
				<td >
					<input type="text" id="phoneNumberTxt" name="VaccinationDetailsDTO.vaccinationMgmt.phoneNumber"
						   reg='{"required":"true","maxlength":"18","regex":"phone"}' value="${vaccinationMgmt.phoneNumber }" maxlength="18"/>
				</td>
			</tr>

			<tr>
				<th>居住地址：</th>
				<td colspan="5">
					<ehr:dic-town-street-village townId="town_address" streetId="village_address"
												 townName="VaccinationDetailsDTO.vaccinationMgmt.patownShip" streetName="VaccinationDetailsDTO.vaccinationMgmt.pastreet"
												 townValue="${vaccinationMgmt.patownShip}" streetValue="${vaccinationMgmt.pastreet}"
												 width="120px;"
					/>
					<input type="text" id="text_pahouseNumber" name="VaccinationDetailsDTO.vaccinationMgmt.pahouseNumber"  reg='{"maxlength":"50"}'
						value="${vaccinationMgmt.pahouseNumber}" style="width: 200px;"/>
				</td>
			</tr>		
		</tbody>
		</table>
		</fieldset>
    </div>
	
	<!-- 备注 -->
    <div class="postdiv">
    <fieldset class="layui-elem-field">
        <legend>备注</legend>
        		<table class="posttable" style="width: 98%;">
		<tr>
		<td>
        <textarea class="vacnte" rows="5" cols="40" style="width: 100%;" reg='{"maxlength":"500"}' name="comment">${vaccinationEvent.comments}</textarea>
        		</td>
		</tr>
		</table>
    </fieldset>
    </div>

</div>
</form>
