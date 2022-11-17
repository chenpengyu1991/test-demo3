<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/ehr-tag" prefix="ehr"%>

<script src="${pageContext.request.contextPath}/js/views/ehr/family/add.js" type="text/javascript"></script>
<div id="msgError" class="msgError" style="display: none;">   </div>
<div class="postcontent">
	<form id="familyRecordForm" name="familyRecordForm" method="post">
	<input id="familyStatus" type="hidden" name="status" value="${familyDTO.familyInfo.status}">
	<div class="postdiv">
		<fieldset class="layui-elem-field">
			<legend>家庭基本信息:</legend>
			<table style="width:99%" class="posttable">
				<colgroup>
					<col style="width:95px;"></col>
					<col style="width:305px;"></col>
					<col style="width:90px;"></col>
					<col style="width:370px;"></col>
				</colgroup>
				<tr>
					<th><label class="required">饮用水类型:</label></th>
					<td valign="top">
						<ehr:dic-list dicmeta="CV0300115"  name="water" id="water" value="${familyDTO.water}"
							reg='{"required":"true"}' type="true" width="300px;"/>
					</td>
					<th><label class="required">户厕类型:</label></th>
					<td  valign="top">
						<ehr:dic-list dicmeta="CV0300304" id="hastoilet" name="hastoilet" value="${familyDTO.hostoilet}" 
							reg='{"required":"true"}' type="true" width="370px;"/>
					</td>
				</tr>
                <tr style="line-height: 40px;">
                	<th><label class="required">户口号:</label></th>
					<td>
						<input type="text" id="accountNumber" name="accountNumber" tip="户口号只能是大小写字母和数字的组合" reg='{"required":"true","regex":"^[A-Za-z0-9]+$","maxlength":12}'
						 	value="${familyDTO.familyInfo.accountNumber}" class="x-layui-input"/>
                        <input type="hidden" id="familyUpdateId" name="familyId" value="${familyDTO.familyInfo.id}"/>
					</td>
               		<th><label class="required">现住地址:</label></th>
					<td>
						<%-- <ehr:dic-town-village reg='{"required":"true"}'  villageName="pastreet" townName="patownShip" townId="townId"
						 villageId="villageId"
 						 villageValue="${familyDTO.familyInfo.pastreet}" 
 						 townValue="${familyDTO.familyInfo.patownShip}" callback="addFamily.displayValue"/>  --%>
							<%--<ehr:dic-town-village
									villageId="villageId" townId="townId"
									villageName="familyDTO.familyInfo.pastreet"
									townName="familyDTO.familyInfo.patownShip"
									villageValue="${familyDTO.familyInfo.pastreet}"
									townValue="${familyDTO.familyInfo.patownShip}" width="118px;" reg="{'required':true}"  callback="addFamily.displayHrAddress"/>--%>
                            <ehr:dic-town-street-village villageId="village_address" streetId="street_address"
                                                         townId="town_address" villageName="FamilyRecordDTO.familyInfo.paGroup"
                                                         streetName="FamilyRecordDTO.familyInfo.pastreet"
                                                         townName="FamilyRecordDTO.familyInfo.patownShip" villageValue="${familyDTO.familyInfo.paGroup}"
                                                         streetValue="${familyDTO.familyInfo.pastreet}"
                                                         townValue="${familyDTO.familyInfo.patownShip}" width="118px;" reg="{'required':true}"
                                                         callback="addFamily.displayValue"/>
                    </td>
				</tr>
                <tr style="line-height: 40px;">
					<th><label class="">住址详情:</label></th>
					<td colspan="3">
						<label id="tempValue">${orgName}${orgNamePastreet}<ehr:dic code="${familyDTO.familyInfo.paGroup}" dicmeta="FS990001"/></label>
						<input type="hidden" name="orgName" id="orgName" value="${orgName}"/>
						<input reg='{"maxlength":32}' type="text" style="width: 250px;" name="pahouseNumber"
							   title="如无门牌号等详细信息此空则不用填写任何文字，如有门牌号码等详细信息请在此处手动填写，不再重复上方地址信息"
							id="pahouseNumber" class="input_btm x-layui-input" value="${familyDTO.familyInfo.pahouseNumber}" maxlength="32" />
					</td>
				</tr>
			</table>
		</fieldset>
	</div>
    </form>
	<div id="memberDiv" style="position: relative;"></div>
	<div style="margin-top:380px;width:860px; height:10px;text-align: center;"> 
		<input type="hidden" id="familyInputDate" value="${familyDTO.familyInfo.inputDate}">
		<input type="hidden" id="familyInputOrganCode" value="${familyDTO.familyInfo.inputOrganCode }">
		<input type="hidden" id="familyInputOrganName" value="${familyDTO.familyInfo.inputOrganName }">
		<input type="hidden" id="familyInputName" value="${familyDTO.familyInfo.inputName }">
		<input type="hidden" id="familyInputIdcard" value="${familyDTO.familyInfo.inputIdcard }">
		<%-- <input type="button" id="saveButtonId" name="save" value="保 存"	class="btnopr" /> --%>
		<button class="layui-btn layui-btn-sm"  id="saveButtonId">保存</button>
	</div>
</div>