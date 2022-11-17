<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<fieldset class="layui-elem-field">
				<legend>基本信息</legend>
				<table class="posttable">
					<colgroup>
						<col style="width: 15%;min-width:100px;" />
						<col style="width: 35%;min-width:200px;" />
						<col style="width: 15%;min-width:100px;" />
						<col style="width: 35%;min-width:200px;" />
					</colgroup>
					<tr>
						<th><label for="cdm_report_idcard">身份证</label></th>
						<td>
							<c:choose>
								<c:when test="${hospitalaReport ==true}">
									<input ${personInfo.idcard !=null and personInfo.idcard !='' ? 'readonly="readonly"' :'' } type="text"  id="idcard2" name="personInfo.idcard" value="${personInfo.idcard}" reg='{"idCard":true}' class="x-layui-input"  />
								</c:when>
								<c:otherwise>
									<input type="text" id="idcard2" name="personInfo.idcard" value="${personInfo.idcard}" reg='{"idCard":true}' placeholder="输入身份证获取人员信息"  class="x-layui-input"/>
								</c:otherwise>
							</c:choose>
							<input type="button" id="button_read" value="读卡" onclick="new Device().startFun()">
						</td>
						<th><label class="required" for="cdm_report_name">姓名</label></th>
						<td><input type="text" id="cdm_report_name" name="personInfo.name" value="${personInfo.name}" reg="{'required':true,'maxlength':16}" class="x-layui-input" /></td>
					</tr>
					<tr>
						<th><label class="required" class="required" for="birthday">出生日期</label></th>
						<td>
						<%-- <tag:dateInput name="personInfo.birthday" id="birthday" onlypast="true" reg="{'required':true}" date="${personInfo.birthday}" /> --%>
						<input type="text" reg="{'required':true}" class="layui-input x-admin-content-sm-date"  name="personInfo.birthday" id="birthday" style="padding-left: 0px;" value="<fmt:formatDate value='${personInfo.birthday}' pattern='yyyy/MM/dd'/>"/>
						</td>
						<th><label class="required" class="required">性别</label></th>
						<td><ehr:dic-radio id="gender" uninclude="0,9" dicmeta="GBT226112003" name="personInfo.gender" value="${personInfo.gender}" reg="{'required':true}" /></td>
					</tr>
					<tr>
					<th><label class="required" for="nation">民族</label></th>
						<td>
							<label><input type="radio" reg='{"required":true}' onclick="util.clickHideText(this,'otherNationDesc')" name="personInfo.nation" ${personInfo.nation eq"01" ?"checked":""} value="01" /> 汉族</label>
							<label><input type="radio" reg='{"required":true}' onclick="util.clickShowText(this,'otherNationDesc')" name="personInfo.nation" ${(personInfo.nation ne "1" && not empty personInfo.nation && personInfo.nation ne"01") ?"checked":""} value="99" /> 少数民族</label>
							<input type="text" id="otherNationDesc" class="hidediv" name="personInfo.otherNationDesc" value="${othermz==null?personInfo.otherNationDesc:othermz}" reg='{"required":"true"}' style="width: 70px;" class="x-layui-input"/>
                            <input type="hidden" id="nationText" value="<ehr:dic code="${personInfo.nation}" dicmeta="GBT3304"/>"/>
						</td>
						<th><label class="required" for="occupation">职业</label></th>
						<td><ehr:dic-list dicmeta="GBT6565" width="180px;" code="0,1/2,3,4,5,6/7/8/9,X,Y,CV00031"  value="${personInfo.occupation}" id="occupation" name="personInfo.occupation" reg="{'required':true}"  cssClass="x-layui-input"/></td>
					</tr>

					<tr>
						<th><label class="required" for="phoneNumber">电话</label></th>
						<td><input id="phoneNumber" type="text" name="personInfo.phoneNumber" value="${personInfo.phoneNumber}" reg="{'required':true,'regex':'phone'}" class="x-layui-input" /></td>
						<td></td>
						<td></td>
					</tr>
					<tr>
						<th><label class="required">常住类型</label></th>
						<td><ehr:dic-radio reg="{'required':true}" dicmeta="FS10005" name="personInfo.householdType"
										   value='${personInfo.householdType}' 
						/></td>
						<td></td>
						<td></td>
					</tr>
					<tr>
						<th><label class="required">现地址</label></th>
						<td colspan="3">
							<ehr:dic-town-street-village townName="personInfo.patownShip" streetName="personInfo.pastreet" villageName="personInfo.paGroup"
														 townId="pacounty" streetId="patownShip" villageId="pastreet"
														 width="180px" reg="{'required':true}" streetValue="${personInfo.pastreet}"
										villageValue="${personInfo.paGroup}" 
										townValue="${personInfo.patownShip}" cssClass="x-layui-input"/>
							<br/>
						</td>
					</tr>
					<tr>
						<th>现住址补充信息：</th>
						<td colspan="3">
							<label id="text_pahouseNumber_prefix">${orgPaName}${orgPaNamePastreet}<ehr:dic code="${personInfo.paGroup}" dicmeta="FS990001"/></label><br/>
							<textarea id="pahouseNumber"  name="personInfo.pahouseNumber" rows="1" placeholder="如无门牌号等详细信息此空则不用填写任何文字，如有门牌号码等详细信息请在此处手动填写，不再重复上方地址信息" class="x-layui-input">${personInfo.pahouseNumber}</textarea>
							<%--<input type="text" placeholder="如无门牌号等详细信息，此空则不用填写任何文字，如有门牌号码等详细信息请在此处手动填写，不再重复上方地址信息" id="text_pahouseNumber" reg='{"required":true,"maxlength":50}'   name="PersonInfoDTO.personInfo.pahouseNumber" value="${personInfo.pahouseNumber}"/>--%>
						</td>
					</tr>
					<tr class="${'1' eq personInfo.householdType || empty personInfo.householdType ? '':'hide' }" id="hr-address-select">
						<th><label class="required">户籍地址</label></th>
						<td colspan="3">
							<div >
								<ehr:dic-town-street-village
										villageId="hrstreet" townId="hrcounty" streetId="hrtownShip"
										villageName="personInfo.hrGroup" streetName="personInfo.hrstreet"
										townName="personInfo.hrtownShip" streetValue="${personInfo.hrstreet}"
										villageValue="${personInfo.hrGroup}" 
										townValue="${personInfo.hrtownShip}" width="180px;" reg="{'dependOn':'personInfo.householdType','dependValue':'1','required':true}" cssClass="x-layui-input"/>
							</div>
						</td>
					</tr>
					<tr>
						<th>户籍地址补充信息：</th>
						<td colspan="3">
							<span id="text_hrhouseNumber_prefix"></span><br/>
							<textarea id="hrhouseNumber" name="personInfo.hrhouseNumber" rows="1" placeholder="如无门牌号等详细信息此空则不用填写任何文字，如有门牌号码等详细信息请在此处手动填写，不再重复上方地址信息" class="x-layui-input">${personInfo.hrhouseNumber}</textarea>
						</td>
					</tr>
					<tr>
						<th><label  for="unitName">工作单位</label></th>
						<td><input type="text" id="unitName" name="personInfo.unitName" value="${personInfo.unitName}" reg="{'maxlength':46}" class="x-layui-input" /></td>
						<th>健康档案管理单位</th>
						<td>
							<input type="text" id="inputOrganName" readonly="readonly" name="personInfo.inputOrganName" value="${personInfo.inputOrganName}" class="x-layui-input"/>
							<input type="hidden" id="inputOrganCode" name="personInfo.inputOrganCode" value="${personInfo.inputOrganCode}" /></td>
					</tr>
				</table>
			</fieldset>
<fieldset class="layui-elem-field">
	
	<legend>疾病信息</legend>
	<input type="hidden" id="dis-person-id" name="personInfo.id" value="${personInfo.id}">
	<input type="hidden"  name="createOrg" value="${ncpPatient.createOrg}">
	<table class="posttable">
		<colgroup>
			<col style="width: 15%;min-width:100px;" />
			<col style="width: 35%;min-width:200px;" />
			<col style="width: 15%;min-width:100px;" />
			<col style="width: 35%;min-width:200px;" />
		</colgroup>
		<tr>
			<th><label class="required" >新冠肺炎类型</label></th>
			<td>
				<ehr:dic-radio id="gender" dicmeta="NCP00003" name="patientType" reg="{'required':true}" value="${ncpPatient.patientType}" code="1,3,2" onchange="toggleOther('patientType','xwzl','2');"/>
				<span id ="xwzl" style="display: none">（<ehr:dic-radio dicmeta="NCP00011" name="zlType" reg="{'required':true}" value="${ncpPatient.zlType}"/>）</span>
			</td>
			<th><label class="required" >新冠肺炎临床分型</label></th>
			<td><ehr:dic-list dicmeta="NCP00001"  width="180px;"  id="clinicalClass" name="clinicalClass" value="${ncpPatient.clinicalClass}" reg="{'required':true}" /></td>
		</tr>
		<tr>
			<th><label class="required" class="required">确诊时间</label></th>
			<td><%-- <tag:dateInput name="diagnosticDate" id="diagnosticDate" onlypast="true" date="${ncpPatient.diagnosticDate}" reg="{'required':true}" /> --%>
			<input type="text" reg="{'required':true}" class="layui-input x-admin-content-sm-date"  name="diagnosticDate" id="diagnosticDate" style="padding-left: 0px;" value="<fmt:formatDate value='${ncpPatient.diagnosticDate}' pattern='yyyy/MM/dd'/>"/>
			</td>
			<th><label class="required" class="required">出院时间</label></th>
			<td><%-- <tag:dateInput name="dischargeDate" id="dischargeDate" onlypast="true" date="${ncpPatient.dischargeDate}" reg="{'required':true}" /> --%>
			<input type="text" reg="{'required':true}" class="layui-input x-admin-content-sm-date"  name="dischargeDate" id="dischargeDate" style="padding-left: 0px;" value="<fmt:formatDate value='${ncpPatient.dischargeDate}' pattern='yyyy/MM/dd'/>"/>
			</td>
		</tr>
		<tr>
			<th><label class="required" class="required">确诊医院</label></th>
			<td><input type="text" id="diagnosticHospital" name="diagnosticHospital"  value="${ncpPatient.diagnosticHospital}" reg="{'required':true}" /></td>
			<td colspan="2"></td>
		</tr>
		
		<tr>
			<th><label class="required" class="required">集中隔离起始时间</label></th>
			<td><%-- <tag:dateInput name="segregationBegin" id="segregationBegin" onlypast="true" date="${ncpPatient.segregationBegin}" reg="{'required':true}" /> --%>
			<input type="text" reg="{'required':true}" class="layui-input x-admin-content-sm-date"  name="segregationBegin" id="segregationBegin" style="padding-left: 0px;" value="<fmt:formatDate value='${ncpPatient.segregationBegin}' pattern='yyyy/MM/dd'/>"/>
			</td>
			<th><label class="required" class="required">集中隔离解除时间</label></th>
			<td><%-- <tag:dateInput name="segregationEnd" id="segregationEnd" onlypast="true" date="${ncpPatient.segregationEnd}" reg="{'required':true}" /> --%>
			<input type="text" reg="{'required':true}" class="layui-input x-admin-content-sm-date"  name="segregationEnd" id="segregationEnd" style="padding-left: 0px;" value="<fmt:formatDate value='${ncpPatient.segregationEnd}' pattern='yyyy/MM/dd'/>"/>
			</td>
		</tr>
		<tr>
			<th><label class="required" class="required">集中隔离地点</label></th>
			<td><input type="text" id="segregationLocation" name="segregationLocation" value="${ncpPatient.segregationLocation}"  reg="{'required':true}" /></td>
			<td colspan="2"></td>
		</tr>
		
		<tr>
			<th><label class="required" class="required">健康管理卡管理时间</label></th>
			<td><%-- <tag:dateInput name="managementTime" id="managementTime" onlypast="true" date="${ncpPatient.managementTime}" reg="{'required':true}"  /> --%>
			<input type="text" reg="{'required':true}" class="layui-input x-admin-content-sm-date"  name="managementTime" id="managementTime" style="padding-left: 0px;" value="<fmt:formatDate value='${ncpPatient.managementTime}' pattern='yyyy/MM/dd'/>"/>
			</td>
			<th><label class="required" class="required">管理机构</label></th>
			<td><input type="hidden" name="managementOrg" value="${ncpPatient.managementOrg}" />
 				<input type="text" readonly="readonly" value="<ehr:org code="${ncpPatient.managementOrg}"  />"/></td>
			
		</tr>
		<tr>
			<th><label class="required" class="required">建卡医生</label></th>
			<td><input type="hidden" name="createDoctorCode" value="${ncpPatient.createDoctorCode}" />
									<c:if test="${not empty ncpPatient.createDoctorCode }">
										<input type="text" readonly="readonly" name="createDoctorName" value="<%-- <ehr:user userCode="${ncpPatient.createDoctorCode}"></ehr:user> --%><ehr:staff-name staffCode="${ncpPatient.createDoctorCode}"></ehr:staff-name>" />
									</c:if>
									<c:if test="${ empty ncpPatient.createDoctorCode }">
										<input type="text" readonly="readonly" name="createDoctorName" value="${ncpPatient.createDoctorName}" />
									</c:if>
								</td>
			
			<td colspan="2"></td>
		</tr>
	</table>
</fieldset>

 <script type="text/javascript">
    layui.use('laydate', function(){
        var laydate = layui.laydate;
        
        laydate.render({
          elem: '#birthday' 
       	   ,format: 'yyyy/MM/dd'
       	   ,max:0
       	, trigger: 'click'
        });

        laydate.render({
          elem: '#diagnosticDate'
           ,format: 'yyyy/MM/dd'
        	   ,max:0
        	   , trigger: 'click'
        });
        
        laydate.render({
          elem: '#dischargeDate'
        	  ,format: 'yyyy/MM/dd'
        		  ,max:0
        		  , trigger: 'click'
        });
      
        laydate.render({
          elem: '#segregationBegin'
        	  ,format: 'yyyy/MM/dd'
        		  ,max:0
        		  , trigger: 'click'
        });
        
        laydate.render({
            elem: '#segregationEnd'
          	  ,format: 'yyyy/MM/dd'
          		  ,max:0
          		, trigger: 'click'
          });
        
        laydate.render({
            elem: '#managementTime'
          	  ,format: 'yyyy/MM/dd'
          		  ,max:0
          		, trigger: 'click'
          });
        
      });

    </script>