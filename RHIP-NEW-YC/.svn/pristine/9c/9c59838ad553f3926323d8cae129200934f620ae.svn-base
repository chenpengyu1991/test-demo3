<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<script src="${pageContext.request.contextPath}/js/views/mhm/patient/move/transfer.js" type="text/javascript"></script>

<div class="postcontent" style="padding-top: 10px;">
	<form id="transferForm">
		<input type="hidden" id="typeId" value="${type}">
        <input type="hidden" id="moveId" name="move.id" value="${moveDto.move.id}">
        <input type="hidden" id="statusId" name="statusId" value="${moveDto.statusId}">
        <input type="hidden" id="eventId" name="eventId" value="${moveDto.eventId}">
        <input type="hidden" id="moveStatusId" name="moveStatus" value="${moveDto.moveStatus}">
        <input type="hidden" id="currentOrganCode" value="${currentLoginInfo.organization.organCode}">

        <div class="postdiv">
			<div class="toolbarsublist">
				<table class="formtable">
					<colgroup>
						<col style="width:18%;"/>
						<col style="width:32%;"/>
						<col style="width:15%;"/>
						<col style="width:35%;"/>
					</colgroup>
                    <%--<th><label class="required">变更常住类型：</label></th>--%>
                    <%--<td colspan="3">--%>
                        <%--<ehr:dic-radio name="mhmBasicsInfo.floatPopulation" dicmeta="FS10005"--%>
                                       <%--value="${moveDto.mhmBasicsInfo.floatPopulation}"--%>
                                       <%--reg='{"required":"true"}' onchange="clueEdit.toggerAddress()"/>--%>
                    <%--</td>--%>
                    <%--<tr>--%>
                        <%--<th><label class="required">变更现居住地：</label></th>--%>
                        <%--<td colspan="3">--%>
                            <%--<ehr:dic-town-village villageId="pavillage_address" townId="patown_address"--%>
                                                  <%--villageName="mhmBasicsInfo.pastreet" townName="mhmBasicsInfo.patownShip"--%>
                                                  <%--villageValue="${moveDto.mhmBasicsInfo.pastreet}"--%>
                                                  <%--townValue="${moveDto.mhmBasicsInfo.patownShip}" width="180px;"--%>
                                                  <%--reg='{"required":"true"}'/>--%>
                            <%--<label id="tempPaValue">--%>
                                <%--<br/>--%>
                                <%--<ehr:dic code="${moveDto.mhmBasicsInfo.patownShip}" dicmeta="FS990001"/><ehr:dic code="${moveDto.mhmBasicsInfo.pastreet}" dicmeta="FS990001"/>--%>
                            <%--</label>--%>
                            <%--<input type="text" id="pahouseNumber" name="mhmBasicsInfo.pahouseNumber" value="${moveDto.mhmBasicsInfo.pahouseNumber}"--%>
                                   <%--reg='{"required":"true","maxlength":"70"}' style="width: 180px;"/>--%>
                            <%--<span id="spanPaNumber">(门牌号)</span>--%>
                        <%--</td>--%>
                    <%--</tr>--%>
                    <tr id="moveId1">
                        <th><label class="required"><span id="transferNameId">迁往服务站：</span></label></th>
                        <td colspan="3">
                            <ehr:dic-town-centre-station isShow="true" isAuthorize="false" townName="mhmOtherInfo.managementTown" centreName="mhmOtherInfo.managementCenter" stationName="mhmOtherInfo.managementStation"
                                                         townValue="${moveDto.mhmOtherInfo.managementTown}" centreValue="${moveDto.mhmOtherInfo.managementCenter}" stationValue="${moveDto.mhmOtherInfo.managementStation}"
                                                         width="150px"/>
                        </td>
                    </tr>
                    <tr id="moveId2">
                        <th>迁出机构：</th>
                        <td colspan="3">
                            <ehr:org code="${moveDto.move.moveOutOrgan}"/>
                            <input type="hidden" name="move.moveInOrgan" value="${moveDto.move.moveInOrgan}">
                        </td>
                    </tr>
                    <tr id="moveId3">
                        <th>迁入机构：</th>
                        <td colspan="3">
                            <ehr:org code="${moveDto.move.moveInOrgan}"/>
                        </td>
                    </tr>
                    <tr>
						<th>姓名：</th>
						<td>${moveDto.mhmBasicsInfo.name}</td>
						<th>性别：</th>
						<td><ehr:dic code="${moveDto.mhmBasicsInfo.gender}" dicmeta="GBT226112003" /></td>
					</tr>
					<tr>
						<th>身份证号码：</th>
						<td>${moveDto.mhmBasicsInfo.idcard}</td>
						<th>婚姻状况：</th>
						<td><ehr:dic code="${moveDto.mhmBasicsInfo.marriage}" dicmeta="GBT226122003" /></td>
					</tr>
					<tr>
						<th>监护人电话：</th>
						<td>${moveDto.mhmBasicsInfo.guarderPhone}</td>
						<th>民族：</th>
						<td><ehr:dic code="${moveDto.mhmBasicsInfo.nation}" dicmeta="GBT3304" /></td>
					</tr>
					<tr>
						<th>监护人姓名：</th>
						<td>${moveDto.mhmBasicsInfo.parentsName}</td>
						<th>经济状况：</th>
						<td><ehr:dic code="${moveDto.mhmOtherInfo.stateEconomy}" dicmeta="MH00042" /></td>
					</tr>
					<tr>
						<th>原家庭地址：</th>
						<td colspan="3">${moveDto.mhmBasicsInfo.paAddress}</td>
					</tr>
					<tr>
						<th>户籍地址：</th>
						<td colspan="3">${moveDto.mhmBasicsInfo.hrAddress}</td>
					</tr>
                    <tr style="${type==1?'display:display':'display:none'}">
						<th><label class="required">迁出时间：</label></th>
						<td colspan="3">
                            <tag:dateInput name="move.moveOutDt" reg='{"required":"true","regex":"date"}'  pattern="yyyy/MM/dd" date="${moveDto.move.moveOutDt}" onlypast="true" style="width:120px;" />
                        </td>
					</tr>
                    <tr style="${type!=1?'display:display':'display:none'}">
                        <th>迁出时间：</th>
                        <td colspan="3">
                            <fmt:formatDate value="${moveDto.move.moveOutDt}" pattern="yyyy/MM/dd"/>
                        </td>
                    </tr>
                    <tr style="${type==1?'display:display':'display:none'}">
                        <th><label class="required">迁移原因：</label></th>
                        <td colspan="3"><input type="text" name="move.moveReason" value="${moveDto.move.moveReason}" reg='{"required":"true","maxlength":"100"}'/></td>
                    </tr>
                    <tr style="${type!=1?'display:display':'display:none'}">
                        <th>迁移原因：</th>
                        <td colspan="3"><input type="text" value="${moveDto.move.moveReason}" readonly="true"/></td>
                    </tr>
                    <tr>
						<th>备注：</th>
						<td colspan="3">
							<textarea name="move.comments" style="width: 98%" rows=4  reg='{"maxlength":"400"}'>${moveDto.move.comments}</textarea>
						</td>
					</tr>
				</table>
			</div>
		</div>
	</form>
	<br>
	<div class="toolbarpop">
		<c:choose>
			<c:when test="${type == '1'}">
				<input type="button" id="transferOutBtn" value="迁出" onclick="transferMove.save(1)">
			</c:when>
			<c:when test="${type == '2'}">
				<input type="button" id="transferInBtn" value="迁入" onclick="transferMove.save(2)">
                <input type="button" id="transferBackBtn" value="退回" onclick="transferMove.save(3)">
            </c:when>
            <c:when test="${type == '3'}">
                <input type="button" id="transferReoutBtn" value="重新迁出" onclick="transferMove.save(5)">
            </c:when>
            <c:when test="${type == '4'}">
                <input type="button" id="transferNoBtn" value="取消迁出" onclick="transferMove.save(4)">
            </c:when>
		</c:choose>
		<input type="button" id="cancelTransferBtn" value="关闭" onclick="mhmCommon.closePopUp('transferDialog')">
	</div>
</div>