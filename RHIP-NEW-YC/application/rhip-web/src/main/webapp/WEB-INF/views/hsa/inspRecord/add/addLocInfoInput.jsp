<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<form method="post" id="hsa-add-location-form">
	<input type="hidden" name="id" value="${locationInfo.id}">
	<div class="postcontent">
		<div class="postdiv">
			<fieldset>
				<legend>巡查地点信息</legend>
				<table class="posttable">
					<colgroup>
						<col style="width: 12%;" />
						<col style="width: 21%;" />
						<col style="width: 12%;" />
						<col style="width: 21%;" />
					</colgroup>
					<tr>
						<th><label class="required" for="unitName">单位名称</label></th>
						<td><input type="text" id="unitName" name="unitName" value="${locationInfo.unitName}" reg="{'required':true,'maxlength':200}"></input></td>
						<th><label for="selfCode" class="required">本体代码</label></th>
						<td><input type="text" id="selfCode" name="selfCode" value="${locationInfo.selfCode}" reg="{'maxlength':10,'required':true}"></input></td>
					</tr>
					<tr>
						<th><label for="scale">单位规模</label></th>
						<td><ehr:dic-list name="scale" dicmeta="FS10287" value="${locationInfo.scale}"></ehr:dic-list></td>
						<th><label for="unitTypeCode">单位类型</label></th>
						<td><ehr:dic-list name="unitTypeCode" dicmeta="FS10288" value="${locationInfo.unitTypeCode}"></ehr:dic-list></td>
					</tr>
					<tr>
						<th><label for="registerOrgnName">注册地点</label></th>
						<td><input type="text" id="registerOrgnName" name="registerOrgnName" value="${locationInfo.registerOrgnName}" reg="{'maxlength':200}"></input>
						</td>
						<th><label for="businessAddressName">经营地址名称</label></th>
						<td><input type="text" id="businessAddressName" name="businessAddressName" value="${locationInfo.businessAddressName}"
							reg="{'maxlength':200}"
						></input></td>
					</tr>
					<tr>
						<th><label for="zipCode">邮政编码</label></th>
						<td><tag:numberInput name="zipCode" value="${locationInfo.zipCode}" reg="{'maxlength':6,'postCode':true}"></tag:numberInput></td>
						<th><label for="economicNatureCode">经济性质</label></th>
						<td><ehr:dic-list dicmeta='GBT124022000' type="text" id="economicNatureCode" name="economicNatureCode"
								value="${locationInfo.economicNatureCode}" reg="{'maxlength':200}"
							/></td>
					</tr>
					<tr>
						<th><label for="contact">联系人</label></th>
						<td><input type="text" id="contact" name="contact" value="${locationInfo.contact}" reg="{'maxlength':50}"></input></td>
						<th><label  for="personInCharge">负责人</label></th>
						<td><input type="text" id="personInCharge" name="personInCharge" value="${locationInfo.personInCharge}"
							reg="{'maxlength':50}"
						></input></td>
					</tr>
					<tr>
						<th><label  for="legal">法人</label></th>
						<td><input type="text" id="legal" name="legal" value="${locationInfo.legal}" reg="{'maxlength':50}"></input></td>
						<th><label for="qualityControlStaff">质管员</label></th>
						<td><input type="text" id="qualityControlStaff" name="qualityControlStaff" value="${locationInfo.qualityControlStaff}"
							reg="{'maxlength':50}"
						></input></td>
					</tr>
					<tr>
						<th><label for="contactPhone">联系电话</label></th>
						<td><input type="text" id="contactPhone" name="contactPhone" value="${locationInfo.contactPhone}" reg="{'maxlength':20}"></input></td>
						<th><label for="agencyPhone">代理电话</label></th>
						<td><input id="agencyPhone" type="text" name="agencyPhone" value="${locationInfo.agencyPhone}" reg="{'maxlength':20}" /></td>
					</tr>
					<tr>
						<th><label for="contactTelephone">联系手机</label></th>
						<td><input id="contactTelephone" type="text" name="contactTelephone" value="${locationInfo.contactTelephone}" reg="{'maxlength':20}" /></td>
						<th><label for="agencyTelephone">代理手机</label></th>
						<td><input id="agencyTelephone" type="text" name="agencyTelephone" value="${locationInfo.agencyTelephone}" reg="{'maxlength':20}" /></td>
					</tr>
					<tr>
						<th><label for="documentTypeCode">证件类别</label></th>
						<td><ehr:dic-list dicmeta='CV0201101' id="documentTypeCode" name="documentTypeCode" value="${locationInfo.documentTypeCode}"
								reg="{'maxlength':200}"
							/></td>
						<th><label for="idcard">身份证号</label></th>
						<td><tag:idcardInput name="idcard" value="${locationInfo.idcard}" reg="{'idCard':true}">></tag:idcardInput></td>
					</tr>
					<tr>
						<th><label class="required">乡镇地段</label></th>
						<td><%-- <ehr:dic-list reg="{'required':true}" name="townshipLotCode" dicmeta="HSA00005" width="120px;" value="${locationInfo.townshipLotCode}" /> --%>
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
						<td><input type="text" id="healthProfessionsName" name="healthProfessionsName" value="${locationInfo.healthProfessionsName}"
							reg="{'maxlength':200}"
						></input></td>
					</tr>
					<tr>
						<th><label for="categoryCode">行业分类</label></th>
						<td><ehr:dic-list dicmeta="HE00004" id="categoryCode" name="categoryCode" value="${locationInfo.categoryCode}" reg="{'maxlength':2}" /></td>
						<th><label for="employeesCount">职工总数</label></th>
						<td><tag:numberInput name="employeesCount" value="${locationInfo.employeesCount}" reg="{'max':9999999}"></tag:numberInput></td>
					</tr>
					<tr>
						<th><label for="operatingItem">经营项目</label></th>
						<td><input type="text" id="operatingItem" name="operatingItem" value="${locationInfo.operatingItem}" reg="{'maxlength':200}"></input></td>
						<th><label for="email">电子邮件</label></th>
						<td><input type="text" id="email" name="email" value="${locationInfo.email}" reg="{'maxlength':30,'email':true}"></input></td>
					</tr>
					<tr>
						<th><label for="site">单位网址</label></th>
						<td><input type="text" id="site" name="site" value="${locationInfo.site}" reg="{'maxlength':100,'url':true}"></input></td>
					</tr>
				</table>
			</fieldset>
		</div>
	</div>
</form>
