<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<div class="postdiv" style="margin-top: 10px;">
<fieldset class="layui-elem-field">
	<legend>失访信息</legend>
	    <table class="posttable" id="lostFollowUpTable">
       		<colgroup>
	           <col style="min-width: 120px; width: 20%;"/>
	           <col style="min-width: 180px; width: 30%;"/>
	           <col style="min-width: 80px; width: 20%;"/>
	           <col style="min-width: 250px; width: 30%;"/>
   			</colgroup>
	      	<tbody>
	       		<tr>
	       			<th><label class="required">失访原因:</label></th>
	           		<td colspan="3">
	           			<ehr:dic-list  id="loseReason" name="mhmFollowup.loseReason" dicmeta="MH00018" value="${managementDto.mhmFollowup.loseReason}"  reg='{"required":"true"}'
	           				code="1,2,3,4,5,6" onchange="followUpEdit.toggleLostReason()"/>
			           	<span id="divLoseReason">
			           		<input type="text" name="mhmFollowup.loseReasonOther" value="${managementDto.mhmFollowup.loseReasonOther}"
			           		style="width: 100px;" reg='{"maxlength":"100"}'/>
			           	</span>	           			
	           		</td>
				</tr>
	       		<tr>
	       			<th>性别:</th>
	           		<td>
	           			<ehr:dic-radio  name="mhmFollowup.gender" dicmeta="GBT226112003" value="${managementDto.mhmFollowup.gender}" code="1,2"/>
	           		</td>	           		
				</tr>				
	       		<tr>
	       			<th>年龄:</th>
	           		<td>
	           			<input type="text" style="width: 50px;" name="mhmFollowup.age" value="${managementDto.mhmFollowup.age}" reg='{"digits":"true","min":"1","max":"200"}'/>岁
	           		</td>	           		
				</tr>
				<tr>                 
	       			<th>关锁情况:</th>
	           		<td colspan="3">
                        <ehr:dic-list id="lockStateLost" name="lockState" value="${managementDto.mhmFollowup.lockState}" dicmeta="MH00007"/>
	           		</td>
				</tr>
				<tr>
			       	<th>住院情况:</th>
			       	<td colspan="3">
                           <ehr:dic-list id="hospitalCourseLost" name="flHospitalCourse" value="${managementDto.mhmFollowup.hospitalCourse}" 
                            	onchange="followUpEdit.toggleFHospitalCourse();" dicmeta="MH00019"/>
			       		<span id="spanFHospitalCourse">
			       			末次出院时间
                            <tag:dateInput id="lastleaveHospitalDateLost" name="lastleaveHospitalDate" date="${managementDto.mhmFollowup.lastleaveHospitalDate}" style="width:100px;"/>
			       		</span>
			       	</td>
	       		</tr>			
	       		<tr>
	       			<th>住院患者有否获得经费补助:</th>
	           		<td colspan="3">
	           			<ehr:dic-radio  id="economicGrantDeptLost" name="economicGrantDeptLost" dicmeta="PH00002" value="${managementDto.mhmFollowup.economicGrantDept}"   code="2,1"/>
	           		</td> 
		     	</tr> 
	       		<tr>
	            	<th>失访原因说明:</th>
		            <td colspan="3">
                        <input type="text" name="mhmFollowup.loseReasonDetail" value="${managementDto.mhmFollowup.loseReasonDetail}" reg='{"maxlength":"100"}'/>
			        </td>
		     	</tr> 	
	       		<tr>
	            	<th>报告时间:</th>
		            <td colspan="3">
		            	<tag:dateInput name="mhmFollowup.reportDt" date="${managementDto.mhmFollowup.reportDt}"
                            	style="width: 100px;" reg='{"regex":"date"}'  pattern="yyyy/MM/dd"  onlypast="true"></tag:dateInput>		 			
			        </td>
		     	</tr>	
	       		<tr id="deathId1">
	            	<th>如为死亡，死亡日期:</th>
		            <td colspan="3">
						<tag:dateInput name="mhmFollowup.dieDt" date="${managementDto.mhmFollowup.dieDt}"
                            	style="width: 100px;" reg='{"regex":"date"}'  pattern="yyyy/MM/dd"  onlypast="true"></tag:dateInput>
					</td>
		     	</tr>
	       		<tr id="deathId2">
		            <th>死亡原因:</th>
		            <td colspan="3">
		            	<ehr:dic-list  name="mhmFollowup.dieReason" id="dieReason" value="${managementDto.mhmFollowup.dieReason}" dicmeta="MH00020"
		            		code="1,2,3,4,5,6" onchange="toggleOtherSC('mhmFollowup.dieReason','divDieReason','6');"/>
			           	<span id="divDieReason">
			           		<input type="text" name="mhmFollowup.dieReasonOther" value="${managementDto.mhmFollowup.dieReasonOther}"
			           		style="width: 100px;" reg='{"maxlength":"100"}'/>
			           	</span>
			           	<!-- <tr id="deathId4" >
	       			<th></th>
	           		<td colspan="3"> -->
	           			<br/>
	           			<span id="divDieReasonPathogeny" style="display: none;">
	           				<ehr:dic-radio  id="dieReasonPathogeny" name="mhmFollowup.dieReasonPathogeny" dicmeta="FS10403" value="${managementDto.mhmFollowup.dieReasonPathogeny}"/>
	           			</span>
	           	<!-- 	</td> 
		     	</tr>	 -->              				
		            </td>
		     	</tr>
	       		<tr id="deathId3">
		            <th>死亡原因说明:</th>
		            <td colspan="3">
			 			<input type="text" name="mhmFollowup.dieReasonDetail" value="${managementDto.mhmFollowup.dieReasonDetail}" reg='{"maxlength":"100"}' style="width: 95%;" />
		            </td>
		     	</tr>
	       </tbody>
	  </table>
	</fieldset>
	</div>