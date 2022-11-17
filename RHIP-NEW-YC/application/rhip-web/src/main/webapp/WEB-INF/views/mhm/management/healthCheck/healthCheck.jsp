<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<script src="${pageContext.request.contextPath}/js/views/mhm/management/healthCheck/edit.js" type="text/javascript"></script>
<form id="healthCheckForm">
<input name="statusId" value="${statusId}" type="hidden"/>
<input id="eventId"  name="eventId" value="${healthCheck.eventId}" type="hidden"/>
<input name="id" value="${healthCheck.id}" type="hidden"/>
<input type="hidden" name="fillOrganCode" value="${healthCheck.fillOrganCode}">
<input type="hidden" name="fillDoctorId" value="${healthCheck.fillDoctorId}">
<tag:dateInput name="fillDate" style="display:none;" date="${healthCheck.fillDate}"></tag:dateInput>
<div class="postcontent ">
	<div class="postdiv" style="margin-top: 10px;">
	<fieldset class="layui-elem-field">
		<%--<legend>应急处置</legend>--%>
	    <table class="posttable">
       		<colgroup>
	           <col style="min-width: 80px; width: 19%;"/>
	           <col style="min-width: 180px; width: 31%;"/>
	           <col style="min-width: 80px; width: 19%;"/>
	           <col style="min-width: 180px;"/>
   			</colgroup>
	      	<tbody>
                <tr>
                    <td colspan="4"><i class="popno" style="width: auto;height: auto">健 康 体 检 表</i></td>
                </tr>
                <tr>
                    <th>健康档案编号:</th>
                    <td><input type="text" name="healthFileNo" value="${healthCheck.healthFileNo}" reg='{"length":"17"}'></td>
                    <th><label class="required">体检日期：</label></th>
                    <td><%-- <tag:dateInput name="physicalDt" date="${healthCheck.physicalDt}" reg="{'required':'true'}"></tag:dateInput> --%>
                    <input type="text" reg="{'required':'true'}" class="layui-input x-admin-content-sm-date"  name="physicalDt" id="physicalDtId" value="<fmt:formatDate value='${healthCheck.physicalDt}' pattern='yyyy/MM/dd'/>"  style="padding-left: 0px;" />
                    </td>
                </tr>
	       		<tr>
	       			<th><label class="required">姓名:</label></th>
	           		<td>
	           			<input type="text" id="healthCheckName" name="name" value="${healthCheck.name}" reg='{"maxlength":"50","required":"true"}' />
	           		</td>
	       			<th>性别:</th>
	           		<td>
	           			<ehr:dic-radio  name="gender" value="${healthCheck.gender}" dicmeta="GBT226112003" code="1,2"/>
	           		</td>	           		
				</tr>
	       		<tr>
	       			<th>出生日期:</th>
	           		<td>
                        <%-- <tag:dateInput id="birthdate" name="birthdate" date="${healthCheck.birthdate}"></tag:dateInput> --%>
                        <input type="text" reg="{'required':'true'}" class="layui-input x-admin-content-sm-date"  name="birthdate" id="birthdate" value="<fmt:formatDate value='${healthCheck.birthdate}' pattern='yyyy/MM/dd'/>"  style="padding-left: 0px;" />
	           		</td>
	       			<th>身份证号:</th>
	           		<td>
	           			<input id="idCard" type="text" name="idcard" value="${healthCheck.idcard}" onblur="healthCheckEdit.queryPerson()"
               placeholder="输入身份证获取个人信息" reg='{"idCard":"idCard"}'/>
	           		</td>	           		
				</tr>				
				<tr>   
					<th>婚否:</th>
	           		<td>
			           	<ehr:dic-radio name="marriage" dicmeta="PH00001" code="1,2" value="${healthCheck.marriage}"></ehr:dic-radio>
	                </td>
                    <th>联系电话:</th>
                    <td>
                        <input type="text" id="familyPhone" name="contactPhone" value="${healthCheck.contactPhone}" reg='{"regex":"phone"}' />
                    </td>
				</tr>
				<tr>                 
	       			<th>家庭住址:</th>
                    <td colspan="3">
                    <ehr:dic-town-street-village villageId="pavillage_address" streetId="pastreet_address" 
														 townId="patown_addresss" villageName="paGroup" streetName="pastreet"
														 townName="patownShip" villageValue="${healthCheck.paGroup}" streetValue="${healthCheck.pastreet}"
														 townValue="${healthCheck.patownShip}" callback="healthCheckEdit.displayPaAddress" width="180px;"/>
                       <%--  <ehr:dic-town-village villageId="pavillage_address" townId="patown_address" villageName="pastreet" townName="patownShip"
                                              villageValue="${healthCheck.pastreet}" townValue="${healthCheck.patownShip}" width="180px;"/> --%>
                        <br>
                        <input type="text" id="pahouseNumber" name="pahouseNumber" value="${healthCheck.pahouseNumber}"
                               reg='{"maxlength":"50"}'  style="width: 150px;">
                        <span id="spanPaNumber">(门牌号)</span>
                    </td>
				</tr>
				<tr>
	            	<th>内科：</th>
                    <td colspan="3">
                        <span>血压&nbsp;&nbsp;<input type="text" name="rightSbp" style="width: 80px;text-align: center"
                                                   value="${healthCheck.rightSbp}" reg="{'min':0,'max':9999}"> /
                            <input type="text" name="rightDbp" style="width: 80px;text-align: center" value="${healthCheck.rightDbp}"
                                   reg="{'min':0,'max':9999}">mmHg</span>
                        <span style="text-align: center; padding-left: 80px;">两肺&nbsp;&nbsp;
                            <input type="text" name="lung" style="width: 80px;" value="${healthCheck.lung}" reg='{"maxlength":"100"}'></span><br>
                        心脏&nbsp;&nbsp;<input name="heart" type="text" value="${healthCheck.heart}" reg='{"maxlength":"100"}'><br>
                        <span>体重&nbsp;&nbsp;<input type="text" style="width: 80px;text-align: center;" name="bodyWeight" value="${healthCheck.bodyWeight}"
                                                   reg="{'min':0,'max':9999.99}">kg</span>
                        <span style="padding-left: 80px;">身高&nbsp;&nbsp;<input type="text" style="width: 80px;text-align: center;" name="height"
                                   value="${healthCheck.height}" reg="{'min':0,'max':999.99}">cm</span><br>
                        过敏史&nbsp;&nbsp;<input type="text" name="irritability" value="${healthCheck.irritability}" reg='{"maxlength":"100"}'><br>
                        医生签字&nbsp;&nbsp;<input type="text" style="width: 100px;" name="medicineDoctor" value="${healthCheck.medicineDoctor}" reg='{"maxlength":"50"}'>
                    </td>
	       		</tr>

	       		<tr>
	       			<th>慢性病患病情况:</th>
	           		<td colspan="3">
	           			<ehr:dic-checkbox name="diseaseType" dicmeta="MH00056" value="${healthCheck.diseaseType}" onchange="toggleOtherCK('diseaseType','diseaseOtherId','99');"></ehr:dic-checkbox>
                        <span id="diseaseOtherId"><input type="text" name="diseaseOther" style="width: 100px;" value="${healthCheck.diseaseOther}"
                                                         reg='{"maxlength":"100"}'></span>
	           		</td> 
		     	</tr>
	       		<tr>
	            	<th>血液检验：</th>
		            <td>
                        血糖&nbsp;&nbsp;<input type="text" name="fpgMmol" value="${healthCheck.fpgMmol}" reg='{"number":"true", "scale":1, "max":99.9}' style="width: 50px;text-align: center">mmol／L
                        &nbsp;或&nbsp;<input type="text" name="fpgMg" value="${healthCheck.fpgMg}" reg='{"number":"true", "scale":1, "max":99.9}' style="width: 50px;text-align: center">mg／dL<br>
                        转氨酶&nbsp;&nbsp;<input type="text" name="aminopherase" value="${healthCheck.aminopherase}" reg='{"maxlength":"100"}'><br>
                        血常规&nbsp;<input type="text" name="bloodRoutineOtherDesc" value="${healthCheck.bloodRoutineOtherDesc}" reg='{"maxlength":"100"}'><br>
                        ABO血型&nbsp;<ehr:dic-list name="aboBloodType" dicmeta="MH00057" value="${healthCheck.aboBloodType}"></ehr:dic-list><br>
                        RH血型&nbsp;<ehr:dic-list name="rhBloodType" dicmeta="MH00058" value="${healthCheck.rhBloodType}"></ehr:dic-list>
			        </td>
		     	</tr> 	
	       		<tr>
	            	<th>心电图检查:</th>
                    <td colspan="3">
                        <textarea style="width: 90%" name="ecg" reg='{"maxlength":"100"}'>${healthCheck.ecg}</textarea><br>
                        医生签字&nbsp;&nbsp;<input type="text" name="ecgDoctor" value="${healthCheck.ecgDoctor}" style="width: 100px;" reg='{"maxlength":"50"}'>
                    </td>
		     	</tr>	
		     	<tr>
	            	<th>超声检查：</th>
		            <td>
                        肝&nbsp;&nbsp;<input type="text" name="liver" value="${healthCheck.liver}" reg='{"maxlength":"100"}'><br>
                        脾&nbsp;&nbsp;<input type="text" name="spleen" value="${healthCheck.spleen}" reg='{"maxlength":"100"}'><br>
                        双肾&nbsp;&nbsp;<input type="text" name="kidney" value="${healthCheck.kidney}" reg='{"maxlength":"100"}'><br>
                        医生签字&nbsp;&nbsp;<input type="text" style="width: 100px;" name="ultrasonographyDoctor" value="${healthCheck.ultrasonographyDoctor}" reg='{"maxlength":"50"}'>
			        </td>
		     	</tr>
                <tr>
                    <th>检验项目：</th>
                    <td>
                        尿常规&nbsp;&nbsp;<input type="text" name="urineRoutineOtherDesc" value="${healthCheck.urineRoutineOtherDesc}" reg='{"maxlength":"100"}'><br>
                        医生签字&nbsp;&nbsp;<input type="text" style="width: 100px;" name="examineDoctor" value="${healthCheck.examineDoctor}" reg='{"maxlength":"50"}'>
                    </td>
                </tr>
		     	<tr>
	            	<th>体检结论：</th>
			        <td colspan="3">
			 			<textarea style="width: 90%" name="conclusionDesc" reg='{"maxlength":"400"}'>${healthCheck.conclusionDesc}</textarea>
			        </td>
		     	</tr>
	       		<tr>
	            	<th>医学建议：</th>
                    <td colspan="3">
                        <textarea style="width: 90%" name="suggestion" reg='{"maxlength":"400"}'>${healthCheck.suggestion}</textarea>
                    </td>
		     	</tr>
		     	<tr>
		     		<th><label class="required">检查机构：</label></th>
		            <td>
				 		<input type="text" name="examinationOrganCode" value="${healthCheck.examinationOrganCode}" reg='{"maxlength":"100","required":"true"}'/>
					</td>
					<th>主检医师签名：</th>
					<td><input type="text" name="mainDoctor" value="${healthCheck.mainDoctor}" reg='{"maxlength":"50"}'/></td>
		     	</tr>
                <tr>
                    <th>签发日期：</th>
                    <td>
                        <%-- <tag:dateInput name="issueDt" date="${healthCheck.issueDt}"></tag:dateInput> --%>
                        <input type="text" class="layui-input x-admin-content-sm-date"  name="issueDt" id="issueDtId" value="<fmt:formatDate value='${healthCheck.issueDt}' pattern='yyyy/MM/dd'/>"  style="padding-left: 0px;" />
                    </td>
                </tr>
		     	<tr>
		     		<th>心理咨询：</th>
                    <td colspan="3">
                        <textarea style="width: 90%" name="consultationQuestion" reg='{"maxlength":"400"}'>${healthCheck.consultationQuestion}</textarea>
                    </td>
		     	</tr>
		     	<tr>
					<th>医生签字：</th>
					<td><input type="text" name="summaryDoctor" value="${healthCheck.summaryDoctor}" reg='{"maxlength":"50"}'></td>
		     	</tr>
	       </tbody>
	  </table>
	</fieldset>
	</div>
</div>
</form>

<script type="text/javascript">

layui.use('laydate', function(){
    var laydate = layui.laydate;
    
    laydate.render({
      elem: '#physicalDtId' 
   	   ,format: 'yyyy/MM/dd'
   	   ,max:0
	   ,done:function (value) {
			if (!$.isEmpty(value)) {
				$("#physicalDtId").removeClass("lose");
			} else {
				$("#physicalDtId").addClass("lose");
			}
		}
    });
    
    laydate.render({
        elem: '#birthdate' 
     	   ,format: 'yyyy/MM/dd'
     	   ,max:0
      });
    
    laydate.render({
        elem: '#issueDtId' 
     	   ,format: 'yyyy/MM/dd'
     	   ,max:0
     	  , trigger: 'click' 
      });

    
  });
</script>