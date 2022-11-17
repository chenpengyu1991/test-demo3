<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<script src="${pageContext.request.contextPath}/js/views/mhm/management/emergency/edit.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/views/mhm/mhmCommon.js" type="text/javascript"></script>
<form id="emergencyForm">
<input name="statusId" value="${statusId}" type="hidden"/>
<input id="eventId"  name="eventId" value="${mhmEmergency.eventId}" type="hidden"/>
<input name="mhmEmergency.id" value="${mhmEmergency.id}" type="hidden"/>
<div class="postcontent ">
	<div class="postdiv" style="margin-top: 10px;">
    	<table class="posttable" style="text-align: left;">
        	<tr>
            	<td>
					应急医疗处置单位：<input type="text" name="mhmEmergency.emergemcyOrgan" value="${mhmEmergency.emergemcyOrgan}" reg='{"maxlength":"30"}' style="width: 40%;" />
                </td>
            </tr>
        </table>
    </div>
	<div class="postdiv" style="margin-top: 10px;">
	<fieldset class="layui-elem-field">
		<legend>应急处置</legend>
	    <table class="posttable">
       		<colgroup>
	           <col style="min-width: 120px; width: 25%;"/>
	           <col style="min-width: 180px; width: 20%;"/>
	           <col style="min-width: 80px; width: 20%;"/>
	           <col style="min-width: 250px; width: 35%;"/>
   			</colgroup>
	      	<tbody>
	       		<tr>
	       			<th><label class="required">患者姓名:</label></th>
	           		<td>
	           			<input type="text" name="mhmEmergency.name" value="${mhmEmergency.name}" reg='{"maxlength":"50","required":"true"}' style="width: 95%;" />
	           		</td>
	       			<th>性别:</th>
	           		<td>
	           			<ehr:dic-radio  name="mhmEmergency.gender" value="${mhmEmergency.gender}" dicmeta="GBT226112003" code="1,2"/>
	           		</td>	           		
				</tr>
	       		<tr>
	       			<th>年龄:</th>
	           		<td>
	           			<input type="text" name="mhmEmergency.age" value="${mhmEmergency.age}" reg='{"digits":"true","min":"0","max":"200"}' style="width: 80%;" />岁
	           		</td>
	       			<th>患者编号:</th>
	           		<td>
	           			<input type="text" name="mhmEmergency.patientCode" value="${mhmEmergency.patientCode}" reg='{"maxlength":"100"}' style="width: 40%;" />(非本地患者填身份证号)
	           		</td>	           		
				</tr>				
				<tr>   
					<th>第一处置地点:</th>                 
	           		<td colspan="3">
			           	<input type="text" name="mhmEmergency.emergemcyAddress" value="${mhmEmergency.emergemcyAddress}" reg='{"maxlength":"100"}' style="width: 95%;" />
	                </td>
				</tr>
				<tr>                 
	       			<th>报告人:</th>
	           		<td>
	           			<input type="text" name="mhmEmergency.reportUser" value="${mhmEmergency.reportUser}" reg='{"maxlength":"50"}' style="width: 95%;" />
	           		</td>
	       			<th>本次报告时间:</th>
	           		<td>
	           			<%-- <tag:dateInput name="mhmEmergency.reportDt" style="width: 100px;" date="${mhmEmergency.reportDt}"
                    		reg='{"regex":"date"}'  pattern="yyyy/MM/dd"  onlypast="true"></tag:dateInput> --%>
                    		<input type="text" reg='{"regex":"date"}' class="layui-input x-admin-content-sm-date"  name="mhmEmergency.reportDt" id="mhmEmergencyReportDtId" value="<fmt:formatDate value='${mhmEmergency.reportDt}' pattern='yyyy/MM/dd'/>"  style="padding-left: 0px;width: 100px;" />
	           		</td>                
				</tr>
				<tr>
			       	<th>报告途径:</th>
			       	<td>
			 			<input type="text" name="mhmEmergency.reportWay" value="${mhmEmergency.reportWay}" reg='{"maxlength":"100"}' style="width: 95%;" />
			       	</td>
	            	<th>报告人身份：</th>
		            <td>
			 			<ehr:dic-list name="mhmEmergency.reportIdentity" dicmeta="MH00029"
			           		code="1,2,3,4,5,99" onchange="toggleOtherSC('mhmEmergency.reportIdentity','MH00029Id','99')"
                            value="${mhmEmergency.reportIdentity}"/>
			           	<span id="MH00029Id">
			           		<input type="text" name="mhmEmergency.reportIdentityOther"
			           		style="width: 100px;" reg='{"digits":"true","maxlength":"20"}'
                            value="${mhmEmergency.reportIdentityOther}"/>
			           	</span>			           		
			        </td>			       	
	       		</tr>			
	       		<tr>
	       			<th>处置开始时间:</th>
	           		<td>
	           			<%-- <tag:dateInput name="mhmEmergency.startDt" id="startDt" style="width: 100px;"
                    		reg='{"regex":"date","compare":["endDt","le","处置开始时间不能晚于处置结束时间"]}'  pattern="yyyy/MM/dd"  onlypast="true"
                            date="${mhmEmergency.startDt}"></tag:dateInput> --%>
                         <input type="text" reg='{"regex":"date","compare":["endDt","le","处置开始时间不能晚于处置结束时间"]}' class="layui-input x-admin-content-sm-date"  name="mhmEmergency.startDt" id="startDt" value="<fmt:formatDate value='${mhmEmergency.startDt}' pattern='yyyy/MM/dd'/>"  style="padding-left: 0px;width: 100px;" />
	           		</td> 
	       			<th>处置结束时间:</th>
	           		<td>
	           			<%-- <tag:dateInput name="mhmEmergency.endDt" id="endDt" style="width: 100px;"
                    		reg='{"regex":"date","compare":["startDt","ge","处置结束时间不能早于处置开始时间"]}'  pattern="yyyy/MM/dd"  onlypast="true"
                            date="${mhmEmergency.endDt}"></tag:dateInput> --%>
                        <input type="text" reg='{"regex":"date","compare":["startDt","ge","处置结束时间不能早于处置开始时间"]}' class="layui-input x-admin-content-sm-date"  name="mhmEmergency.endDt" id="endDt" value="<fmt:formatDate value='${mhmEmergency.endDt}' pattern='yyyy/MM/dd'/>"  style="padding-left: 0px;width: 100px;" />
	           		</td> 	           		
		     	</tr> 
	       		<tr>
	            	<th>现场情况简要描述(包括患者当时的表现、人员财产损失、大致处置过程等情况)：</th>
		            <td colspan="3">
			 			<textarea name="mhmEmergency.comments" rows="5" reg='{"maxlength":"400"}' style="width: 80%;">${mhmEmergency.comments}</textarea>
			        </td>
		     	</tr> 	
	       		<tr>
	            	<th>人员损伤(若为自杀自伤需标注)</th>
		     	</tr>	
		     	<tr>
	            	<th>受伤人数：</th>
		            <td>
			 			<input type="text" name="mhmEmergency.hurtNum" value="${mhmEmergency.hurtNum}" reg='{"maxlength":"20"}' style="width: 80px;" />人
			        </td>
			        <th>死亡人数：</th>
			        <td>
			 			<input type="text" name="mhmEmergency.dieNum" value="${mhmEmergency.dieNum}" reg='{"maxlength":"20"}' style="width: 80px;" />
			 			<span>人</span>			        
			        </td>
		     	</tr>
		     	<tr>
	            	<th>财物损失估计：</th>
			        <td>
			 			<input type="text" name="mhmEmergency.loss" value="${mhmEmergency.loss}" reg='{"maxlength":"100"}' style="width: 80px;" />
			 			<span>元</span>			        
			        </td>
		     	</tr>
	       		<tr>
	            	<th>执行人员</th>
		     	</tr>
		     	<tr>
		     		<th>精神科医生1：</th>
		            <td>
				 		<input type="text" name="mhmEmergency.doctor_1" value="${mhmEmergency.doctor_1}" reg='{"maxlength":"50"}' style="width: 80px;" />
					</td>
					<th>精神科护士1：</th>
					<td><input type="text" name="mhmEmergency.nurse_1" value="${mhmEmergency.nurse_1}" reg='{"maxlength":"50"}' style="width: 80px;" /></td>
		     	</tr>
		     	<tr>
		     		<th>精神科医生2：</th>
		            <td>
				 		<input type="text" name="mhmEmergency.doctor_2" value="${mhmEmergency.doctor_2}" reg='{"maxlength":"50"}' style="width: 80px;" />
					</td>
					<th>精神科护士2：</th>
					<td><input type="text" name="mhmEmergency.nurse_2" value="${mhmEmergency.nurse_2}" reg='{"maxlength":"50"}' style="width: 80px;" /></td>
		     	</tr>
		     	<tr>
		     		<th>报送处置人员(单位)：</th>
		            <td>
				 		<input type="text" name="mhmEmergency.reportDisposeOrgan" value="${mhmEmergency.reportDisposeOrgan}" reg='{"maxlength":"50"}' style="width: 80px;" />
					</td>
					<th>签字人：</th>
					<td><input type="text" name="mhmEmergency.reportDisposePeople" value="${mhmEmergency.reportDisposePeople}" reg='{"maxlength":"50"}' style="width: 80px;" /></td>
		     	</tr>
	       		<tr>
		            <th>处置缘由:</th>
		            <td colspan="3">
		            	<ehr:dic-checkbox name="mhmEmergency.disposerReason" dicmeta="MH00030"
		            		onchange="toggleOtherCK('mhmEmergency.disposerReason','MH00030Id','99')"
                            value="${mhmEmergency.disposerReason}"/>
			           	<span id="MH00030Id">
			           		<input type="text" name="mhmEmergency.disposerReasonOther"
                                style="width: 100px;" reg='{"maxlength":"100"}'
                                value="${mhmEmergency.disposerReasonOther}"/>
			           	</span>			
		            </td>
		     	</tr>	
	       		<tr>
		            <th>主要处置措施:</th>
		     	</tr>
		     	<tr>
		     		<th>现场临时性处置：</th>
		            <td>
				 		<input type="text" name="mhmEmergency.temporarily" value="${mhmEmergency.temporarily}" reg='{"maxlength":"20"}' style="width: 80px;" />次
					</td>
					<th>精神科门诊/急诊留观：</th>
					<td><input type="text" name="mhmEmergency.stretcherAfterward" value="${mhmEmergency.stretcherAfterward}" reg='{"maxlength":"20"}' style="width: 80px;" />次</td>
		     	</tr>
		     	<tr>
		     		<th>精神科紧急住院：</th>
		            <td>
				 		<input type="text" name="mhmEmergency.inHospital" value="${mhmEmergency.inHospital}" reg='{"maxlength":"20"}' style="width: 80px;" />次
					</td>
					<th>会诊：</th>
					<td><input type="text" name="mhmEmergency.consultation" value="${mhmEmergency.consultation}" reg='{"maxlength":"20"}' style="width: 80px;" />次</td>
		     	</tr>
		     	<tr>
		     		<th>其他：</th>
		            <td colspan="3">
				 		<input type="text" name="mhmEmergency.disposerMeasureOther" value="${mhmEmergency.disposerMeasureOther}" reg='{"maxlength":"100"}' style="width: 90%;" />
					</td>
		     	</tr>
	       		<tr>
		            <th>诊断:</th>
		     	</tr>
		     	<tr>
		     		<th>①确定诊断:</th>
		            <td>
				 		<input type="text" name="mhmEmergency.diagnosis"
			           			style="width: 100px;" reg='{"maxlength":"100"}'
                                value="${mhmEmergency.diagnosis}"/>
					</td>
					<th>②疑似诊断:</th>
					<td>
						<input type="text" name="mhmEmergency.suspected"
			           			style="width: 100px;" reg='{"maxlength":"100"}'
                                value="${mhmEmergency.suspected}"/>
					</td>
		     	</tr>
	       		<tr>
		            <th>处置性质:</th>
		            <td colspan="3">
		            	<ehr:dic-radio  name="mhmEmergency.disposerNature" value="${mhmEmergency.disposerNature}" dicmeta="MH00031" />
		            </td>
		     	</tr>
	       		<tr>
		            <th>资料移交:</th>
		            <td colspan="3">
		            	<ehr:dic-radio  name="mhmEmergency.transfer" value="${mhmEmergency.transfer}" dicmeta="MH00032" />
		            </td>
		     	</tr>	
	       		<tr>
		            <th>处置效果:</th>
		            <td colspan="3">
		            	<ehr:dic-radio  name="mhmEmergency.effect" value="${mhmEmergency.effect}" dicmeta="MH00033" />
		            </td>
		     	</tr>	
	       		<tr>
		            <th>处置对象来源:</th>
		            <td colspan="3">
		            	<ehr:dic-list  name="mhmEmergency.resources" value="${mhmEmergency.resources}" dicmeta="MH00034" />
		            </td>
		     	</tr>	
	       		<tr>
		            <th>费用支付方式:</th>
		            <td colspan="3">
		            	<ehr:dic-radio  name="mhmEmergency.payWay" value="${mhmEmergency.payWay}" dicmeta="MH00035" />
		            </td>
		     	</tr>		     			     	     	     		     		     		     	     		     		     	     		     	     	     	
	       </tbody>
	  </table>
	</fieldset>
	</div>
	<fieldset class="layui-elem-field">
	<div class="postdiv">
    	<table class="posttable">
    		<colgroup>
	           <col style="min-width: 120px; width: 25%;"/>
	           <col style="min-width: 180px; width: 20%;"/>
	           <col style="min-width: 80px; width: 20%;"/>
	           <col style="min-width: 250px; width: 35%;"/>
   			</colgroup>
        	<tr>
        		<th>填报人：</th>
            	<td>
            		<ehr:user userCode="${mhmEmergency.modifyDoctorId == null ? currentUser.id : mhmEmergency.modifyDoctorId}"/>
					<input type="hidden" name="mhmEmergency.modifyDoctorId" value="${mhmEmergency.modifyDoctorId == null ? currentUser.id : mhmEmergency.modifyDoctorId}"/>
                </td>
                <th>填报时间：</th>
            	<td>
					<%-- <tag:dateInput name="mhmEmergency.fillDate" style="width: 100px;"
                    		reg='{"regex":"date"}' pattern="yyyy/MM/dd"  onlypast="true"
                            date="${mhmEmergency.fillDate == null ? nowDate : mhmEmergency.fillDate}"></tag:dateInput> --%>
                            
                    <input type="text" reg='{"regex":"date"}'  class="layui-input x-admin-content-sm-date"  name="mhmEmergency.fillDate" id="mhmEmergencyFillDateId" value="<fmt:formatDate value='${mhmEmergency.fillDate == null ? nowDate : mhmEmergency.fillDate}' pattern='yyyy/MM/dd'/>"  style="padding-left: 0px;width: 100px;" />
                </td>                
            </tr>
        </table>
    </div>	
    </fieldset>
</div>
</form>
<script type="text/javascript">

layui.use('laydate', function(){
    var laydate = layui.laydate;
    
    laydate.render({
      elem: '#mhmEmergencyReportDtId' 
   	   ,format: 'yyyy/MM/dd'
   	   ,max:0
    });
    
    laydate.render({
        elem: '#startDt' 
     	   ,format: 'yyyy/MM/dd'
     	   ,max:0
      });
    
    laydate.render({
        elem: '#endDt' 
     	   ,format: 'yyyy/MM/dd'
     	   ,max:0
      });

    laydate.render({
        elem: '#mhmEmergencyFillDateId' 
     	   ,format: 'yyyy/MM/dd'
     	   ,max:0
      });
    
  });
</script>