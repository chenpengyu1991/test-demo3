<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<script>
    $(function(){
        enableChangeConfirm();
        <c:if test="${msg == true}">
			contentChanged = false;
			layer.alert("保存成功！", {icon:0,title:'提示'});
        </c:if>
        <c:if test="${msg == false}">
			layer.alert("保存失败！", {icon:0,title:'提示'});
    	</c:if>
    	// 其它诊断单位 切换
		 $("#otherFlag").on("click", function(event){	
			diagnosisOrgChange("diagnosisOrg","otherOrg",$(this));}); 
		 $("#firstOtherFlag").on("click", function(event){	
				diagnosisOrgChange("firstOrg","firstOtherOrg",$(this));});
		 $("#secOtherFlag").on("click", function(event){	
				diagnosisOrgChange("secOrg","secOtherOrg",$(this));}); 
		 $("#thOtherFlag").on("click", function(event){	
				diagnosisOrgChange("thOrg","thOtherOrg",$(this));}); 
		
		diagnosisOrgChange("diagnosisOrg","otherOrg",$("#otherFlag"));
		diagnosisOrgChange("firstOrg","firstOtherOrg",$("#firstOtherFlag"));
		diagnosisOrgChange("secOrg","secOtherOrg",$("#secOtherFlag"));
		diagnosisOrgChange("thOrg","thOtherOrg",$("#thOtherFlag"));
    });

	//诊断机构切换实现
	function diagnosisOrgChange(selId,inputId,obj)
	{
		if (obj.attr("checked"))
		{
			$("#"+inputId).show();
			$("#"+selId).hide();
			$("#"+selId).val("");
		} else
		{
			$("#"+inputId).hide();
			$("#"+selId).show();
		}
	}
</script>
<input type="hidden" id="type" value="${type}">
<div class="toolbar">
	<a href="javascript:void(0)" onclick="javascript:occPatientAdd.returnSearch()"><button class="btn-gray layui-btn layui-btn-sm button"><i class="layui-icon">&#xe65c;</i>返回</button></a>
    <c:if test="${type == 'add'||type == 'edit'}">
		<a href="javascript:occPatientAdd.saveEmployeeInfo()" ><button class="layui-btn layui-btn-sm"><i class="layui-icon">&#xe605;</i>保存</button></a>
	</c:if>
</div>
<div class="postcontent" >
	<form id="employeeInfoForm">
			<input type="hidden" name="createTime" value="<fmt:formatDate value='${employeeInfo.createTime}' pattern='yyyy/MM/dd HH:mm:ss' />"/>
			<input type="hidden" name="createBy" value="${employeeInfo.createBy}"/>
			<input type="hidden" name="createOrganCode" value="${employeeInfo.createOrganCode}"/>
			<fieldset class="layui-elem-field">
				<legend>劳动者信息</legend>
				<input type="hidden" id="isDelete" name="isDelete" value="0">
				<input type="hidden" id="employeeId" name="id" value="${employeeInfo.id}">
				<table class="posttable">
					<colgroup>
						<col style="width: 15%;min-width:100px;" />
						<col style="width: 25%;min-width:200px;" />
						<col style="width: 15%;min-width:100px;" />
						<col style="width: 45%;min-width:200px;" />
					</colgroup>
					<tr>
						<th  align="right"><label >请选择档案类型</label></th>
						<td >
							<%-- <ehr:dic-list dicmeta="OH00001" name="docType" id="docType" defaultval="Y" value="${employeeInfo.docType}"/> --%>
							<ehr:dic-radio dicmeta="OH00001" name="docType" onchange="occPatientAdd.initDocType()" value="${employeeInfo.docType}"  />
						</td>
					</tr>
					<tr>
						<th><label 
							<c:if test="${type != 'view'}">class="required" </c:if> >
							姓名</label>
						</th>
						<td>
							<input type="text" class="x-layui-input" name="name" id="name" value="${employeeInfo.name}" reg="{'required':'true','maxlength':'20','tip':'请填写名称'}"
							<c:if test="${type == 'view'}">readonly="readonly"</c:if>
							/>
						</td>
						<th><label <c:if test="${type != 'view'}">class="required"</c:if> >身份证号</label></th>
						<td>
							<input type="text" class="x-layui-input" id="idCard" name="idcard" value="${employeeInfo.idcard}"
							placeholder="输入身份证获取个人信息" reg='{"idCard":"true"}'
							<c:if test="${type == 'view'}">readonly="readonly"</c:if>
							/>
						</td>
						
					</tr>
					
					<tr>
						<th><label <c:if test="${type != 'view'}">class="required" </c:if>>性别</label></th>
						<td>
							<ehr:dic-radio name="gender" id="gender" dicmeta="FS10006" value="${employeeInfo.gender==null ? 1 : employeeInfo.gender}" />
						</td>
						<th><label >出生日期</label></th>
						<td>
							<c:if test="${type == 'view'}">
								<input type="text" class="layui-input x-admin-content-sm-date" reg='{"required":"true"}' name="birthdate" id="birthdate" style="width: 100px;padding-left: 0px;"
									   value="<fmt:formatDate value='${employeeInfo.birthdate}' pattern='yyyy/MM/dd'/>" />
							</c:if>
							<c:if test="${type != 'view'}">
								<input type="text" class="layui-input x-admin-content-sm-date" reg='{"required":"true","regex":"date"}'  name="birthdate" id="birthdate" style="width: 100px;padding-left: 0px;"
									   value="<fmt:formatDate value='${employeeInfo.birthdate}' pattern='yyyy/MM/dd'/>"/>
							</c:if>
						</td>
					</tr>
					<tr>
						<th><label <c:if test="${type != 'view'}">class="required"</c:if>>劳动者地址</label></th>
						<td colspan="3" nowrap="nowrap">
							<ehr:dic-radio dicmeta="FS10005" name="householdType" value='${employeeInfo.householdType}'
										   onchange="occPatientAdd.toggerAddress()"/>
							<ehr:dic-town-street-village villageId="pavillage_address" streetId="street_address"
														 townId="patown_address" villageName="paGroup" streetName="pastreet"
														 townName="patownShip" villageValue="${employeeInfo.paGroup}" streetValue="${employeeInfo.pastreet}"
														 townValue="${employeeInfo.patownShip}" width="118px;" reg="{'required':true}" />
							<input type="text" class="x-layui-input" id="pahouseNumber" name="pahouseNumber" value="${employeeInfo.pahouseNumber}"
								   reg='{"required":"true","maxlength":"50"}' style="width: 180px;"/>
							<span id="spanPaNumber">(门牌号)</span>

						</td>
					</tr>
					<tr>
						<th><label >文化程度</label></th>
						<td>
							<ehr:dic-list name="education" dicmeta="GBT46582006" code="IDM09,IDM07,IDM02,IDM03,IDM08" value="${employeeInfo.education}" />
						</td>
						<th><label >工种</label></th>
						<td><input type="text" class="x-layui-input" name="jobType" value="${employeeInfo.jobType}"
							reg='{"maxlength":"20"}'
							<c:if test="${type == 'view'}">readonly="readonly"</c:if>
							/>
						</td>
					</tr>
					
					<tr>
						<th><label >开始接触日期</label></th>
						<td>
							<c:if test="${type == 'view'}">
								<input type="text" class="layui-input x-admin-content-sm-date" reg='{"required":"true"}' name="startDate" id="startDate" style="width: 100px;padding-left: 0px;"
									   value="<fmt:formatDate value='${employeeInfo.startDate}' pattern='yyyy/MM/dd'/>" />
							</c:if>
							<c:if test="${type != 'view'}">
								<input type="text" class="layui-input x-admin-content-sm-date" reg='{"required":"true","regex":"date"}'  name="startDate" id="startDate" style="width: 100px;padding-left: 0px;"
									   value="<fmt:formatDate value='${employeeInfo.startDate}' pattern='yyyy/MM/dd'/>"/>
							</c:if>	
						</td>
						<th><label >实际接触工龄</label></th>
						<td >
							<input type="text" class="x-layui-input" name="totalYear" value="${employeeInfo.totalYear}" style="width:30px"
							reg='{"maxlength":"3","digits":"true"}'
							<c:if test="${type == 'view'}">readonly="readonly"</c:if>
							/>年
							<input type="text" class="x-layui-input" name="totalMonth" value="${employeeInfo.totalMonth}" style="width:30px"
							reg='{"maxlength":"2","digits":"true","max":"12"}'  
							<c:if test="${type == 'view'}">readonly="readonly"</c:if>
							/>月
							<span class="unpneumoconiosis">或
							<input type="text" class="x-layui-input" name="totalDays" value="${employeeInfo.totalDays}" style="width:30px"
							reg='{"maxlength":"2","digits":"true","max":"31"}'  
							<c:if test="${type == 'view'}">readonly="readonly"</c:if>
							/>天
							<input type="text" class="x-layui-input" name="totalHours" value="${employeeInfo.totalHours}" style="width:20px"
							reg='{"maxlength":"2","digits":"true","max":"24"}' 
							<c:if test="${type == 'view'}">readonly="readonly"</c:if>
							/>小时
							<input type="text" class="x-layui-input" name="totalMinutes" value="${employeeInfo.totalMinutes}" style="width:20px"
							reg='{"maxlength":"2","digits":"true","max":"60" }' 
							<c:if test="${type == 'view'}">readonly="readonly"</c:if>
							/>分
							</span>
						</td>
					</tr>
					<tr class="pneumoconiosis">
						<th ><label >尘肺种类</label></th>
						<td class="pneumoconiosis"><input type="text" class="x-layui-input" name="pneumoconiosisType" value="${employeeInfo.pneumoconiosisType}"
							reg='{"maxlength":"20"}'
							<c:if test="${type == 'view'}">readonly="readonly"</c:if>
							/>
						</td>
					</tr>
					<tr class="pneumoconiosis">
						<th><label >诊断一期时间</label></th>
						<td>
							<c:if test="${type == 'view'}">
								<input type="text" class="layui-input x-admin-content-sm-date" reg='{"required":"true"}' name="firstDiagnosisDt" id="firstDiagnosisDt" style="width: 100px;padding-left: 0px;"
									   value="<fmt:formatDate value='${employeeInfo.firstDiagnosisDt}' pattern='yyyy/MM/dd'/>" />
							</c:if>
							<c:if test="${type != 'view'}">
								<input type="text" class="layui-input x-admin-content-sm-date" reg='{"required":"true","regex":"date"}'  name="firstDiagnosisDt" id="firstDiagnosisDt" style="width: 100px;padding-left: 0px;"
									   value="<fmt:formatDate value='${employeeInfo.firstDiagnosisDt}' pattern='yyyy/MM/dd'/>"/>
							</c:if>	
						</td>
						<th><label >合并肺结核</label></th>
						<td>
							<ehr:dic-list name="firstResult" dicmeta="PH00001" code="1,2" value="${employeeInfo.firstResult}" width="80px"/>
						</td>     
							
					</tr>
					<tr class="pneumoconiosis">
						<th><label >诊断机构</label></th>
						<td><nobr>
						<ehr:org-type-list id="firstOrg"  width="180px" name="firstOrg" type="hospital"  value="${employeeInfo.firstOrg}"
							/>
							外地诊断:<input id="firstOtherFlag" type="checkbox" value="1" name="firstOtherFlag" ${employeeInfo.firstOtherFlag eq '1' ? 'checked' : ''}>
							<input id="firstOtherOrg" class="x-layui-input" name="firstOtherOrg" style="width:150px " reg="{'maxlength':23,'dependOn':'firstOtherFlag','required':true}"
							<c:if test="${type == 'view'}">readonly="readonly"</c:if> type="text" value="${employeeInfo.firstOtherOrg}" >
							</nobr>
						</td>
					</tr>
					<tr class="pneumoconiosis">
						<th><label >诊断二期时间</label></th>
						<td>
							<c:if test="${type == 'view'}">
								<input type="text" class="layui-input x-admin-content-sm-date" reg='{"required":"true"}' name="secDiagnosisDt" id="secDiagnosisDt" style="width: 100px;padding-left: 0px;"
									   value="<fmt:formatDate value='${employeeInfo.secDiagnosisDt}' pattern='yyyy/MM/dd'/>" />
							</c:if>
							<c:if test="${type != 'view'}">
								<input type="text" class="layui-input x-admin-content-sm-date" reg='{"required":"true","regex":"date"}'  name="secDiagnosisDt" id="secDiagnosisDt" style="width: 100px;padding-left: 0px;"
									   value="<fmt:formatDate value='${employeeInfo.secDiagnosisDt}' pattern='yyyy/MM/dd'/>"/>
							</c:if>	
						</td>
						<th><label >合并肺结核</label></th>
						<td>
							<ehr:dic-list name="secResult" dicmeta="PH00001" code="1,2" value="${employeeInfo.secResult}" width="80px"/>
						</td>		
					</tr>
					<tr class="pneumoconiosis">
						<th><label >诊断机构</label></th>
						<td><nobr>
						<ehr:org-type-list id="secOrg"  width="180px" name="secOrg" type="hospital"  value="${employeeInfo.secOrg}"
							/>
							外地诊断:<input id="secOtherFlag" type="checkbox" value="1" name="secOtherFlag" ${employeeInfo.secOtherFlag eq '1' ?'checked' : ''}>
							<input id="secOtherOrg" class="x-layui-input" name="secOtherOrg" style="width:150px " reg="{'maxlength':23,'dependOn':'secOtherFlag','required':true}"
							<c:if test="${type == 'view'}">readonly="readonly"</c:if> type="text" value="${employeeInfo.secOtherOrg}" >
							</nobr>
						</td>
					</tr>
					<tr class="pneumoconiosis">
						<th><label >诊断三期时间</label></th>
						<td>
							<c:if test="${type == 'view'}">
								<input type="text" class="layui-input x-admin-content-sm-date" reg='{"required":"true"}' name="thDiagnosisDt" id="thDiagnosisDt" style="width: 100px;padding-left: 0px;"
									   value="<fmt:formatDate value='${employeeInfo.thDiagnosisDt}' pattern='yyyy/MM/dd'/>" />
							</c:if>
							<c:if test="${type != 'view'}">
								<input type="text" class="layui-input x-admin-content-sm-date" reg='{"required":"true","regex":"date"}'  name="thDiagnosisDt" id="thDiagnosisDt" style="width: 100px;padding-left: 0px;"
									   value="<fmt:formatDate value='${employeeInfo.thDiagnosisDt}' pattern='yyyy/MM/dd'/>"/>
							</c:if>	
						</td>
						<th><label >合并肺结核</label></th>
						<td>
							<ehr:dic-list name="thResult" dicmeta="PH00001" code="1,2" value="${employeeInfo.thResult}" width="80px"/>
						
						</td>	
					</tr>
					<tr class="pneumoconiosis">
						<th><label >诊断机构</label></th>
						<td><nobr>
						<ehr:org-type-list id="thOrg"  width="180px" name="thOrg" type="hospital"  value="${employeeInfo.thOrg}"
							/>
							外地诊断:<input id="thOtherFlag" type="checkbox" value="1" name="thOtherFlag" ${employeeInfo.thOtherFlag eq '1' ?'checked' : ''}>
							<input id="thOtherOrg" class="x-layui-input" name="thOtherOrg" style="width:150px " reg="{'maxlength':23,'dependOn':'thOtherFlag','required':true}"
							<c:if test="${type == 'view'}">readonly="readonly"</c:if> type="text" value="${employeeInfo.thOtherOrg}" >
							</nobr>
						</td>
					</tr>
					<tr class="unpneumoconiosis">
						<th><label >诊断时间</label></th>
						<td>
							<c:if test="${type == 'view'}">
								<input type="text" class="layui-input x-admin-content-sm-date" reg='{"required":"true"}' name="diagnosisDt" id="diagnosisDt" style="width: 100px;padding-left: 0px;"
									   value="<fmt:formatDate value='${employeeInfo.diagnosisDt}' pattern='yyyy/MM/dd'/>" />
							</c:if>
							<c:if test="${type != 'view'}">
								<input type="text" class="layui-input x-admin-content-sm-date" reg='{"required":"true","regex":"date"}'  name="diagnosisDt" id="diagnosisDt" style="width: 100px;padding-left: 0px;"
									   value="<fmt:formatDate value='${employeeInfo.diagnosisDt}' pattern='yyyy/MM/dd'/>"/>
							</c:if>	
						</td>
						<th><label >诊断机构</label></th>
						<td>
							<ehr:org-type-list id="diagnosisOrg"  width="180px" name="diagnosisOrg" type="hospital"  value="${employeeInfo.diagnosisOrg}"
							/>
							外地诊断:<input id="otherFlag" type="checkbox" value="1" name="otherFlag" ${employeeInfo.otherFlag eq '1' ? 'checked' : ''}>
							<input id="otherOrg" class="x-layui-input" style="width:150px " reg="{'maxlength':23,'dependOn':'otherFlag','required':true}" type="text"
							<c:if test="${type == 'view'}">readonly="readonly"</c:if> value="${employeeInfo.otherOrg}" name="otherOrg">
						</td>
					</tr>
					<tr class="unpneumoconiosis">
						<th><label >职业病种类</label></th>
						<td>
							<input type="text" class="x-layui-input" name="occuDiseaseType" value="${employeeInfo.occuDiseaseType}"
							reg="{'maxlength':20}" 
							<c:if test="${type == 'view'}">readonly="readonly"</c:if>
							/>
						</td>
						<th><label >具体病名</label></th>
						<td>
							<input type="text" class="x-layui-input" name="occuDiseasName" value="${employeeInfo.occuDiseasName}"
							reg="{'maxlength':20}"
							<c:if test="${type == 'view'}">readonly="readonly"</c:if>
							/>
						</td>
					</tr>
					<tr>
						<th><label >死亡日期</label></th>
						<td>
							<c:if test="${type == 'view'}">
								<input type="text" class="layui-input x-admin-content-sm-date"  name="deathDate" id="deathDate" style="width: 100px;padding-left: 0px;"
									   value="<fmt:formatDate value='${employeeInfo.deathDate}' pattern='yyyy/MM/dd'/>" />
							</c:if>
							<c:if test="${type != 'view'}">
								<input type="text" class="layui-input x-admin-content-sm-date" reg='{"regex":"date"}'  name="deathDate" id="deathDate" style="width: 100px;padding-left: 0px;"
									   value="<fmt:formatDate value='${employeeInfo.deathDate}' pattern='yyyy/MM/dd'/>"/>
							</c:if>
						</td>
						<th><label >其他信息</label></th>
						<td>
							<input type="text" class="x-layui-input" name="otherInfo" value="${employeeInfo.otherInfo}"
							 reg="{'maxlength':30}"
							<c:if test="${type == 'view'}">readonly="readonly"</c:if>
							/>
						</td>
					</tr>
					<tr class="pneumoconiosis">
						<th ><label >死因</label></th>
						<td >
							<input type="text" class="x-layui-input" name="diedReason" value="${employeeInfo.diedReason}"
							 reg="{'maxlength':30}"
							<c:if test="${type == 'view'}">readonly="readonly"</c:if>
							/>
						</td>
						<th><label >X射线胸片号</label></th>
						<td>
							<input type="text" class="x-layui-input" name="xlineNo" value="${employeeInfo.xlineNo}"
							 reg="{'maxlength':20}"
							<c:if test="${type == 'view'}">readonly="readonly"</c:if>
							/>
						</td>
					</tr>
					<tr>
						<th><label >联系电话(固话)</label></th>
						<td>
							<input type="text" class="x-layui-input" name="phone" value="${employeeInfo.phone}"
							 reg="{'maxlength':20,'regex':'phone'}"
							<c:if test="${type == 'view'}">readonly="readonly"</c:if>
							/>
						</td>
						<th><label >手机</label></th>
						<td>
							<input type="text" class="x-layui-input" name="mobile" value="${employeeInfo.mobile}"
							 reg="{'maxlength':20,'regex':'phone'}"
							<c:if test="${type == 'view'}">readonly="readonly"</c:if>
							/>
						</td>
						
					</tr>
					<tr>
						<th><label >其他联系方式</label></th>
						<td>
							<input type="text" class="x-layui-input" name="otherContacts" value="${employeeInfo.otherContacts}"
							 reg="{'maxlength':30}"
							<c:if test="${type == 'view'}">readonly="readonly"</c:if>
							/>
						</td>
						<th><label >联系人姓名</label></th>
						<td>
							<input type="text" class="x-layui-input" name="contactName" value="${employeeInfo.contactName}"
							 reg="{'maxlength':20}"
							<c:if test="${type == 'view'}">readonly="readonly"</c:if>
							/>
						</td>
					</tr>
					<tr>
						<th><label >联系电话(固话)</label></th>
						<td>
							<input type="text" class="x-layui-input" name="contactPhone" value="${employeeInfo.contactPhone}"
							 reg="{'maxlength':20,'regex':'phone'}"
							<c:if test="${type == 'view'}">readonly="readonly"</c:if>
							/>
						</td>
						<th><label >手机</label></th>
						<td>
							<input type="text" class="x-layui-input" name="contactMobilephone" value="${employeeInfo.contactMobilephone}"
							 reg="{'maxlength':20,'regex':'mobile'}"
							<c:if test="${type == 'view'}">readonly="readonly"</c:if>
							/>
						</td>
					</tr>
					<tr>
						<th><label >住址</label></th>
						<td colspan="3">
							<input type="text" class="x-layui-input" name="contactAddr" value="${employeeInfo.contactAddr}"
							 reg="{'maxlength':50}"
							<c:if test="${type == 'view'}">readonly="readonly"</c:if>
							/>
						</td>
					</tr>
				</table>
			</fieldset>
	</form>
</div>

<script type="text/javascript">
	layui.use('laydate', function() {
		var laydate = layui.laydate;

		laydate.render({
			elem: '#birthdate'
			,format:'yyyy/MM/dd'
			,max:0
		});

		laydate.render({
			elem: '#startDate'
			,format:'yyyy/MM/dd'
			,max:0
		});

		laydate.render({
			elem: '#firstDiagnosisDt'
			,format:'yyyy/MM/dd'
			,max:0
		});

		laydate.render({
			elem: '#secDiagnosisDt'
			,format:'yyyy/MM/dd'
			,max:0
		});

		laydate.render({
			elem: '#thDiagnosisDt'
			,format:'yyyy/MM/dd'
			,max:0
		});

		laydate.render({
			elem: '#diagnosisDt'
			,format:'yyyy/MM/dd'
			,max:0
		});

		laydate.render({
			elem: '#deathDate'
			,format:'yyyy/MM/dd'
			,max:0
		});
	});
</script>
