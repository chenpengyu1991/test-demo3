<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
		<div class="postdiv">
		<fieldset class="layui-elem-field">
			<table class="posttable">
				<colgroup>
					<col style="width: 15%;" />
					<col style="width: 35%;" />
					<col style="width: 15%;" />
					<col style="width: 35%;" />
				</colgroup>
				<tr>
					
					<th><label class="required" for="healthProfessional">卫生专业</label></th>
					<td><ehr:dic-list  reg="{'required':true}" dicmeta="HSA00006" uninclude="1,4,99" parentCode="0" id="hsa-inspection-location-add-healthProfessional" name="healthProfessional" value="${locationInfo.healthProfessional}"  /></td>
		
					<th><label for="mainBusinessCode" class="required">行业分类</label></th>
					<td><select  reg="{'required':true}"  id="hsa-inspection-location-add-mainBusinessCode" name="mainBusinessCode" data-value="${locationInfo.mainBusinessCode}"  >
					<option value="">请选择</option>
					</select></td>
				
				</tr>
				<tr>
					<th><label class="required" for="unitName">单位名称</label></th>
					<td><input type="text" id="unitName" name="unitName" value="${locationInfo.unitName}" reg="{'required':true,'maxlength':200}"></input></td>
					<th><label for="organizationCode" >机构代码</label></th>
					<td><input type="text" id="organizationCode" name="organizationCode" value="${locationInfo.organizationCode}" reg="{'maxlength':50}"></input></td>
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
					<th><label for="personInCharge">负责人</label></th>
					<td><input type="text" id="personInCharge" name="personInCharge" value="${locationInfo.personInCharge}" reg="{'maxlength':50}"></input></td>
				</tr>
				<tr>
					<th><label for="legal">法人</label></th>
					<td><input type="text" id="legal" name="legal" value="${locationInfo.legal}" reg="{'maxlength':50}"></input></td>
					<th><label for="qualityControlStaff">质管员</label></th>
					<td><input type="text" id="qualityControlStaff" name="qualityControlStaff" value="${locationInfo.qualityControlStaff}"
						reg="{'maxlength':50}"
					></input></td>
				</tr>
				<tr>
					<th><label for="contactPhone">联系电话</label></th>
					<td><input type="text" id="contactPhone" name="contactPhone" value="${locationInfo.contactPhone}" reg="{'maxlength':20,'regex':'phone'}" /></td>
					<th><label for="agencyPhone">代理电话</label></th>
					<td><input id="agencyPhone" type="text" name="agencyPhone" value="${locationInfo.agencyPhone}" reg="{'maxlength':20,'regex':'phone'}" /></td>
				</tr>
				<tr>
					<th><label for="contactTelephone">联系手机</label></th>
					<td><input id="contactTelephone" type="text" name="contactTelephone" value="${locationInfo.contactTelephone}" reg="{'maxlength':20,'regex':'phone'}" /></td>
					<th><label for="agencyTelephone">代理手机</label></th>
					<td><input id="agencyTelephone" type="text" name="agencyTelephone" value="${locationInfo.agencyTelephone}" reg="{'maxlength':20,'regex':'phone'}" /></td>
				</tr>
				<tr>
					<th><label for="documentTypeCode">证件类别</label></th>
					<td><ehr:dic-list dicmeta='CV0201101' id="documentTypeCode" name="documentTypeCode" value="${locationInfo.documentTypeCode}"
							reg="{'maxlength':200}"
						/></td>
					<th><label for="idcard">身份证号</label></th>
					<td><tag:idcardInput name="idcard" value="${locationInfo.idcard}" reg="{'dependOn':'documentTypeCode','dependValue':'01','idCard':true}">></tag:idcardInput></td>
				</tr>
				<tr>
					<%-- <th><label class="required">乡镇地段</label></th>
					<td>
					 <ehr:dic-list code="${areaCodes}" reg="{'required':true}" name="townshipLotCode" dicmeta="HSA00005" width="120px;" value="${locationInfo.townshipLotCode}" /> </td>
					 --%>
					<th><label for="createOrganCode">录入机构</label></th>
					<td><ehr:org-type-list name="createOrganCode" code="${locationInfo.createOrganCode}" value="${locationInfo.createOrganCode}" width="170px;" defaultval="Y"/> </td>
					<th><label for="employeesCount">职工总数</label></th>
					<td><tag:numberInput name="employeesCount" value="${locationInfo.employeesCount}" reg="{'max':9999999}"></tag:numberInput></td>
	
				</tr>
				
				<tr>
					<th><label for="owner">业主</label></th>
					<td><input type="text" id="owner" name="owner" value="${locationInfo.owner}" reg="{'maxlength':50}"></input></td>
					<th><label>许可到期日期</label></th>
					<td><%-- <tag:dateInput name="dueDate" date="${dueDate}"></tag:dateInput> --%>
					<input type="text" class="layui-input x-admin-content-sm-date"  name="dueDate" id="dueDateId" value="<fmt:formatDate value='${locationInfo.dueDate}' pattern='yyyy/MM/dd'/>"  style="padding-left: 0px;" />
					</td>
				</tr>
				
				<tr>
					<th><label for="supervisorCode">责任监督员编号</label></th>
					<td><input type="text" id="supervisorCode" name="supervisorCode" value="${locationInfo.supervisorCode}" reg="{'maxlength':50}"></input></td>
						<th><label for="supervisorName">责任监督员姓名</label></th>
					<td><input type="text" id="supervisorName" name="supervisorName" value="${locationInfo.supervisorName}" reg="{'maxlength':50}"></input></td>
				</tr>
				<tr>
					<th><label for="email">电子邮件</label></th>
					<td><input type="text" id="email" name="email" value="${locationInfo.email}" reg="{'maxlength':30,'email':true}"></input></td>
					<th><label for="site">单位网址</label></th>
					<td><input type="text" id="site" name="site" value="${locationInfo.site}" reg="{'maxlength':100,'url':true}"></input></td>
				</tr>
				
			</table>
			</fieldset>

			<table id="hsaAddressTable" style="display: none">
				<colgroup>
					<col style="width: 30px;" />
					<col style="width: 60px;" />
					<col style="width: 30px;" />
					<col style="width: 60px;" />
				</colgroup>
				<thead>
				<tr>
					<th>卫生专业</th>
					<th><ehr:tip><ehr:dic code="${locationInfo.healthProfessional}" dicmeta="HSA00006"/></ehr:tip></th>
					<th>行业分类</th>
					<th><ehr:tip><ehr:dic code="${locationInfo.mainBusinessCode}" dicmeta="HSA00006"/></ehr:tip></th>
				</tr>
				<tr>
					<th>单位名称</th>
					<td>${locationInfo.unitName}</td>
					<th>机构代码</th>
					<td>${locationInfo.organizationCode}</td>
				</tr>
				<tr>
					<th>单位规模</th>
					<td><ehr:tip><ehr:dic code="${locationInfo.scale}" dicmeta="FS10287"/></ehr:tip></td>
					<th>单位类型</th>
					<td><ehr:tip><ehr:dic code="${locationInfo.unitTypeCode}" dicmeta="FS10288"/></ehr:tip></td>
				</tr>
				<tr>
					<th>注册地点</th>
					<td>${locationInfo.registerOrgnName}</td>
					<th>经营地址名称</th>
					<td>${locationInfo.businessAddressName}</td>
				</tr>
				<tr>
					<th>邮政编码</th>
					<td>${locationInfo.zipCode}</td>
					<th><label for="economicNatureCode">经济性质</label></th>
					<td><ehr:tip><ehr:dic code="${locationInfo.economicNatureCode}" dicmeta="GBT124022000"/></ehr:tip></td>
				</tr>
				<tr>
					<th>联系人</th>
					<td>${locationInfo.contact}</td>
					<th>负责人</th>
					<td>${locationInfo.personInCharge}</td>
				</tr>
				<tr>
					<th>法人</th>
					<td>${locationInfo.legal}</td>
					<th>质管员</th>
					<td>${locationInfo.qualityControlStaff}</td>
				</tr>
				<tr>
					<th>联系电话</th>
					<td>${locationInfo.contactPhone}</td>
					<th>代理电话</th>
					<td>${locationInfo.agencyPhone}</td>
				</tr>
				<tr>
					<th>联系手机</th>
					<td>${locationInfo.contactTelephone}</td>
					<th>代理手机</th>
					<td>${locationInfo.agencyTelephone}</td>
				</tr>
				<tr>
					<th>证件类别</th>
					<td><ehr:tip><ehr:dic code="${locationInfo.documentTypeCode}" dicmeta="CV0201101"/></ehr:tip></td>
					<th>身份证号</th>
					<td>${locationInfo.idcard}</td>
				</tr>
				<tr>
					<th>录入机构</th>
					<td><ehr:org-type-list name="createOrganCode" code="${locationInfo.createOrganCode}" value="${locationInfo.createOrganCode}" width="170px;" defaultval="Y"/> </td>
					<th>职工总数</th>
					<td>${locationInfo.employeesCount}</td>
				</tr>
				<tr>
					<th>业主</th>
					<td>${locationInfo.owner}</td>
					<th>许可到期日期</th>
					<td><fmt:formatDate value="${locationInfo.dueDate}" pattern="yyyy/MM/dd"/></td>
				</tr>
				<tr>
					<th>责任监督员编号</th>
					<td>${locationInfo.supervisorCode}</td>
					<th>责任监督员姓名</th>
					<td>${locationInfo.supervisorName}</td>
				</tr>
				<tr>
					<th>电子邮件</th>
					<td>${locationInfo.email}</td>
					<th>单位网址</th>
					<td>${locationInfo.site}</td>
				</tr>
				</thead>
				<tbody>
				</tbody>
			</table>

		</div>

		<script type="text/javascript">

layui.use('laydate', function(){
    var laydate = layui.laydate;
    
    laydate.render({
      elem: '#dueDateId' 
   	   ,format: 'yyyy/MM/dd'
   	, trigger: 'click' 
    });

  });
</script>