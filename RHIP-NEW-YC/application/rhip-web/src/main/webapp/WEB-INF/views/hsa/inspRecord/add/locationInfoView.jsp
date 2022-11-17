<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<fieldset>
	<legend>地点信息</legend>
	<table class="posttable" id="has-view-loaction-info-table">
		<colgroup>
			<col style="width: 12%;" />
			<col style="width: 21%;" />
			<col style="width: 12%;" />
			<col style="width: 21%;" />
			<col style="width: 12%;" />
			<col style="width: 21%;" />
		</colgroup>
		<tr>
			<th><label for="unitName">单位名称</label></th>
			<td><input type="text" readonly id="unitName" value="${locationInfo.unitName}"></input></td>
			<th><label for="unitTypeCode">单位类型</label></th>
			<td><ehr:dic dicmeta="FS10288" code="${locationInfo.unitTypeCode}" /></td>
			<th><label for="scale">单位规模</label></th>
			<td><ehr:dic dicmeta="FS10287" code="${locationInfo.scale}"></ehr:dic></td>
		</tr>
		<tr>
			<th><label for="businessAddressName">经营地址名称</label></th>
			<td><input type="text" readonly id="businessAddressName" value="${locationInfo.businessAddressName}"></input></td>
			<th><label for="zipCode">邮政编码</label></th>
			<td><input type="text" readonly id="zipCode" value="${locationInfo.zipCode}"></input></td>
			<th><label for="economicNatureCode">经济性质</label></th>
			<td><ehr:dic dicmeta='GBT124022000' code="${locationInfo.economicNatureCode}" /></td>
		</tr>
		<tr>
			<th><label for="contact">联系人</label></th>
			<td><input type="text" readonly id="contact" value="${locationInfo.contact}"></input></td>
			<th><label for="personInCharge">负责人</label></th>
			<td><input type="text" readonly id="personInCharge" value="${locationInfo.personInCharge}"></input></td>
			<th><label for="legal">法人</label></th>
			<td><input type="text" readonly id="legal" value="${locationInfo.legal}"></input></td>
		</tr>
		<tr>
			<th><label for="qualityControlStaff">质管员</label></th>
			<td><input type="text" readonly id="qualityControlStaff" value="${locationInfo.qualityControlStaff}"></input></td>
			<th><label for="contactPhone">联系电话</label></th>
			<td><input type="text" readonly id="contactPhone" value="${locationInfo.contactPhone}"></input></td>
			<th><label for="agencyPhone">代理电话</label></th>
			<td><input type="text" readonly id="agencyPhone" value="${locationInfo.agencyPhone}"></input></td>
		</tr>
		<tr>
			<th><label for="contactTelephone">联系手机</label></th>
			<td><input type="text" readonly id="contactTelephone" value="${locationInfo.contactTelephone}"></input></td>
			<th><label for="agencyTelephone">代理手机</label></th>
			<td><input type="text" readonly id="agencyTelephone" value="${locationInfo.agencyTelephone}"></input></td>
			<th><label for="documentTypeCode">证件类别</label></th>
			<td><ehr:dic dicmeta='CV0201101' code="${locationInfo.documentTypeCode}" /></td>
		</tr>
		<tr>
			<th><label for="idcard">身份证号</label></th>
			<td><input type="text" readonly id="idcard" value="${locationInfo.idcard}"></input></td>
			<th><label>乡镇地段</label></th>
			<td><%-- <ehr:dic dicmeta="HSA00005" code="${locationInfo.townshipLotCode}" /> --%>
					<ehr:authorize ifAnyGranted="0122">
                    		<ehr:dic-town-village  townName="townshipLotCode" reg="{'required':true}" townValue="${locationInfo.townshipLotCode }"/>
                    </ehr:authorize>
                    <ehr:authorize ifNotGranted="0122">
                              <select reg="{'required':true}" title="<ehr:dic dicmeta="FS990001" code="${townValue}"/>" name="townshipLotCode">
                                     <option title="<ehr:dic dicmeta="FS990001" code="${townValue}"/>" value="${townValue}"><ehr:dic dicmeta="FS990001" code="${townValue}"/></option>
                               </select>
                     </ehr:authorize>
			</td>
			<th><label for="healthProfessionsName">卫生专业</label></th>
			<td><input type="text" readonly id="healthProfessionsName" value="${locationInfo.healthProfessionsName}"></input></td>
		</tr>
		<tr>
			<th><label for="categoryCode">行业分类</label></th>
			<td><ehr:dic dicmeta="HE00004"  code="${locationInfo.categoryCode}" /></td>
			<th><label for="employeesCount">职工总数</label></th>
			<td><input type="text" readonly id="employeesCount" value="${locationInfo.employeesCount}"></input></td>
			<th><label for="operatingItem">经营项目</label></th>
			<td><input type="text" readonly id="operatingItem" value="${locationInfo.operatingItem}"></input></td>
		</tr>
		<tr>
			<th><label for="registerOrgnName">注册地点名称</label></th>
			<td><input type="text" readonly id="registerOrgnName" value="${locationInfo.registerOrgnName}"></input></td>
			<th><label for="email">电子邮件</label></th>
			<td><input type="text" id="email" name="email" value="${locationInfo.email}" reg="{'maxlength':30,'email':true}"></input></td>
			<th><label for="site">单位网址</label></th>
			<td><input type="text" id="site" name="site" value="${locationInfo.site}" reg="{'maxlength':30,'url':true}"></input></td>
		</tr>
	</table>
</fieldset>
