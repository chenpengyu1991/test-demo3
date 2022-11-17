<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<script src="${pageContext.request.contextPath}/js/views/idm/schistosome/acographyEdit.js" type="text/javascript"></script>
<form id="acographyForm">
<input type="hidden" name="generalCondition.id" value="${schDto.generalCondition.id}">
<input type="hidden" name="clinicalManifestations.id" value="${schDto.clinicalManifestations.id}">
<input type="hidden" name="pastHistory.id" value="${schDto.pastHistory.id}">
<input type="hidden" name="listRr.id" value="${schDto.listRr.id}">
<input type="hidden" name="singleId" value="${schDto.listRr.idmId}">
<input type="hidden" name="listRr.createUnit" value="${schDto.listRr.createUnit}">
<input type="hidden" name="listRr.createDt" value="<fmt:formatDate pattern="yyyy/MM/dd" value="${schDto.listRr.createDt}"/>">
<input type="hidden" name="listRr.createUser" value="${schDto.listRr.createUser}">
<input type="hidden" name="listRr.diagnosisUnit" value="${schDto.listRr.diagnosisUnit}">
<input type="hidden" name="listRr.treatmentDoctor" value="${schDto.listRr.treatmentDoctor}">
<input type="hidden" name="idmId" value="${schDto.idmId}">
<div class="postcontent">
<script type="text/javascript">
	layui.use('laydate', function () {
		var laydate = layui.laydate;

		laydate.render({
			elem: '#treatEndDt'
			, format: 'yyyy/MM/dd'
			, max: 0
		});

		laydate.render({
			elem: '#treatmentDt'
			, format: 'yyyy/MM/dd'
			, max: 0
		});



	});

</script>
<i class="popno">血吸虫病治疗记录表</i>
<fieldset>
	<legend>一般情况</legend>
       <table class="posttable">
       	<colgroup>
           <col style="min-width: 110px; width: 15%;"/>
           <col style="min-width: 260px; width: 35%;"/>
           <col style="min-width: 110px; width: 15%;"/>
           <col style="min-width: 260px; width: 35%;"/>
      		</colgroup>
      		<tbody>
       		<tr>
	        	<th>姓名:</th>
           		<td>
           			<input type="text" id="name" name="generalCondition.name" value="${schDto.generalCondition.name}" 
           				style="width: 100px;" reg='{"maxlength":"50"}'/>
           		</td>
          		<th>身份证号:</th>
           		<td>
           			<input type="text" id="idCard" name="generalCondition.idcard" value="${schDto.generalCondition.idcard}"
                    	placeholder="输入身份证获取个人信息" reg='{"idCard":"true"}'/>
                </td> 
			</tr>
			<tr>                    
                <th>性别:</th>
                <td>
                	<ehr:dic-radio name="generalCondition.gender" dicmeta="GBT226112003" value="${schDto.generalCondition.gender}"  code="1,2"/>
           		</td>	
          	 	<th>年龄:</th>
           		<td>
		           	<input type="text" id="age" name="generalCondition.age" value="${schDto.generalCondition.age}" 
		           		style="width: 100px;" reg='{"digits":"true","maxlength":"20"}'/>
                </td>
			</tr>
			<tr>                 
                <th>职业:</th>
                <td>
	               	<ehr:dic-list name="generalCondition.occupation" dicmeta="GBT6565"  value="${schDto.generalCondition.occupation}"  
	               		code="CV020120201,CV020120202,CV020120203,CV020120204,CV020120205,CV020120206,CV020120207,CV020120208,CV020120209
	               		,CV020120210,CV020120211,CV020120212,CV020120213,CV020120214,CV020120215,CV020120216,CV020120217,CV020120218,CV020120219"  width="200px"/>
                </td>
				<th>婚姻:</th>
				<td>
					<ehr:dic-list name="generalCondition.marriage" dicmeta="GBT226122003" value="${schDto.generalCondition.marriage}"/>
                </td>
			</tr>
			<tr>                  
				<th>劳动力:</th>
				<td>
					<ehr:dic-list name="generalCondition.laborForce" dicmeta="PH00027" 
                    	value="${schDto.generalCondition.laborForce}"/>
                </td> 
          	 	<th>体重:</th>
           		<td>
		           	<input type="text" name="clinicalManifestations.weight" value="${schDto.clinicalManifestations.weight}"
		           		style="width: 100px;" reg='{"digits":"true","maxlength":"20"}'/>&nbsp;公斤
                </td>                                          		                                  
			</tr>
			<tr>                  
				<th>籍贯:</th>
				<td>
		           	<input type="text" name="generalCondition.nativePlace" value="${schDto.generalCondition.nativePlace}"
		           		style="width: 100px;" reg='{"maxlength":"100"}'/>
                </td> 
          	 	<th>工作单位:</th>
           		<td>
		           	<input type="text" name="generalCondition.unitName" value="${schDto.generalCondition.unitName}"
		           		style="width: 98%;" reg='{"maxlength":"70"}'/>
                </td>                                          		                                  
			</tr>
			<tr>
		       	<th><label class="required">常住类型:</label></th>
		       	<td colspan="3">
		 			<ehr:dic-radio name="generalCondition.floatPopulation" dicmeta="FS10005" reg='{"required":"true"}'
		           		value="${schDto.generalCondition.floatPopulation}" onchange="idmCommon.toggerAddress()"/>
		       	</td>
       		</tr>			
       		<tr>
            	<th>现住址：</th>
	            <td colspan="3">
		        	<ehr:dic-town-village villageId="pavillage_address" townId="patown_address" villageName="generalCondition.pastreet" townName="generalCondition.patownShip"
		            	villageValue="${schDto.generalCondition.pastreet}" townValue="${schDto.generalCondition.patownShip}" width="160px;"/>
		            <div>
	                    <label id="tempPaValue">
	                        <ehr:dic code="${schDto.generalCondition.patownShip}" dicmeta="FS990001"/><ehr:dic code="${schDto.generalCondition.pastreet}" dicmeta="FS990001"/>
	                    </label>
	                    <input type="text" id="pahouseNumber" name="generalCondition.pahouseNumber" value="${schDto.generalCondition.pahouseNumber}"
			                	reg='{"maxlength":"50"}'  style="width: 180px;">
			         	<span id="spanPaNumber">(门牌号)</span>
		         	</div>
		        </td>
	     	</tr>  						
       </tbody>
  </table>
  </fieldset>
<fieldset>
	<legend>疾病信息</legend>
       <table class="posttable">
       		<colgroup>
	           <col style="min-width: 110px; width: 15%;"/>
	           <col style="min-width: 260px; width: 35%;"/>
	           <col style="min-width: 110px; width: 15%;"/>
	           <col style="min-width: 260px; width: 35%;"/>
      		</colgroup>
      		<tbody>
       		<tr>
				<th>既往史:</th>
				<td colspan="3">
		           	<input type="text" name="pastHistory.pastHistory" value="${schDto.pastHistory.pastHistory}"
		           		style="width: 98%;" reg='{"maxlength":"100"}'/>
                </td>        			
       		</tr>
       		<tr>
				<th title="血吸虫病治疗史">治疗史:</th>
				<td colspan="3">
					<span>过去治疗&nbsp;</span>
		           	<input type="text"  name="pastHistory.treatNum" value="${schDto.pastHistory.treatNum}" 
		           		style="width: 40px;" reg='{"maxlength":"2"}'/>
		           	<span>&nbsp;次,末次治疗时间&nbsp;</span>
					<input type="text" reg='{"required":"true"}' class="layui-input x-admin-content-sm-date"
						   name="pastHistory.treatEndDt" id="treatEndDt"
						   value="<fmt:formatDate value='${schDto.pastHistory.treatEndDt}' pattern='yyyy/MM/dd'/>"
						   style="padding-left: 0px;width: 80px;"/>
		            <span>&nbsp;，药物&nbsp;</span>
		           	<input type="text"  name="pastHistory.bloodFlukesDrug" value="${schDto.pastHistory.bloodFlukesDrug}" 
		           		style="width: 120px;" reg='{"maxlength":"100"}'/>		           	
                </td>        			
       		</tr>
       		<tr>
				<th></th>
				<td colspan="3">
					<span>是否完成&nbsp;</span>
                   	<ehr:dic-radio name="pastHistory.isFinished" dicmeta="PH00001" value="${schDto.pastHistory.isFinished}"
                      	code="1,2" />		
		           	<span>&nbsp;有何副反应&nbsp;</span>
		           	<input type="text"  name="pastHistory.sideReaction" value="${schDto.pastHistory.sideReaction}" 
		           		style="width: 120px;" reg='{"maxlength":"100"}'/>                
		    	</td>        			
       		</tr>  
       		<tr>
				<th>一般情况:</th>
				<td colspan="3">
					<span>发育&nbsp;</span>
					<ehr:dic-list name="listRr.development" dicmeta="PH00016" 
                    	code="2,4,5" value="${schDto.listRr.development}"/>
		           	<span>&nbsp;营养&nbsp;</span>
					<ehr:dic-list name="listRr.nutrition" dicmeta="PH00009" 
                    	code="1,2,3" value="${schDto.listRr.nutrition}"/>
                    <span>&nbsp;贫血&nbsp;</span>
					<ehr:dic-list name="listRr.anemia" dicmeta="IDM00031" 
                    	code="3,2,1" value="${schDto.listRr.anemia}"/>
		    	</td>
       		</tr>
       		<tr>
				<th></th> 
				<td colspan="3">	                    	
                    <span>&nbsp;血压&nbsp;</span>
		           	<input type="text"  name="listRr.systolicPressure" value="${schDto.listRr.systolicPressure}" 
		           		style="width: 80px;" reg='{"maxlength":"20"}'/>                       
                    <span>&nbsp;毫米汞柱&nbsp;</span>                  		           	
                </td>        			
       		</tr>
       		<tr>
				<th>心脏:</th>
				<td colspan="3">
					<span>心浊音界&nbsp;</span>
					<ehr:dic-list name="listRr.cardiacDullness" dicmeta="PH00002" 
                    	code="1,2" value="${schDto.listRr.cardiacDullness}" onchange=""/>
		           	<span>&nbsp;扩大&nbsp;
			           	<input type="text"  name="listRr.expansion" value="${schDto.listRr.expansion}" 
			           		style="width: 80px;" reg='{"maxlength":"20"}'/>
			           	&nbsp;厘米
		           	</span>
                    <span>&nbsp;心率:&nbsp;</span>
		           	<input type="text"  name="listRr.cardiacRhythm" value="${schDto.listRr.cardiacRhythm}" 
		           		style="width: 60px;" reg='{"maxlength":"20"}'/>次／分
		    	</td>
       		</tr>
       		<tr>
				<th></th> 
				<td colspan="3">				      				           		
                    <span>&nbsp;心律&nbsp;</span>
		           	<input type="text"  name="listRr.heartRate" value="${schDto.listRr.heartRate}" 
		           		style="width: 80px;" reg='{"maxlength":"20"}'/>                       
                    <span>&nbsp;杂音&nbsp;</span>   
		           	<input type="text"  name="listRr.souffle" value="${schDto.listRr.souffle}" 
		           		style="width: 80px;" reg='{"maxlength":"20"}'/>                                     		           	
                </td>        			
       		</tr>
       		<tr>
				<th>肺脏:</th>
				<td colspan="3">
		           	<input type="text"  name="listRr.lungs" value="${schDto.listRr.lungs}" 
			        	style="width: 98%;" reg='{"maxlength":"200"}'/>
		    	</td>
       		</tr> 
       		<tr>
				<th>腹部:</th>
				<td colspan="3">
					<span>外形&nbsp;</span>
					<ehr:dic-list name="listRr.external" dicmeta="IDM00323" 
                    	code="1,2" value="${schDto.listRr.external}" onchange=""/>
		           	<span>&nbsp;移动性浊音&nbsp;</span>
					<ehr:dic-list name="listRr.shiftingDullness" dicmeta="PH00002" 
                    	code="1,2" value="${schDto.listRr.shiftingDullness}" />		           	
                    <span>&nbsp;腹壁静脉&nbsp;</span>
					<ehr:dic-list name="listRr.venaEpigastrica" dicmeta="IDM00324" 
                    	code="1,2,3" value="${schDto.listRr.venaEpigastrica}" />	
		    	</td>
       		</tr> 
       		<tr>
				<th></th> 
				<td colspan="3">				      				           		
                    <span>&nbsp;其他&nbsp;</span>
		           	<input type="text"  name="listRr.other" value="${schDto.listRr.other}" 
		           		style="width: 90%;" reg='{"maxlength":"200"}'/>                       
                </td>        			
       		</tr> 
       		<tr>
				<th>实验室检查：</th> 
				<td colspan="3">				      				           		
		           	<input type="text"  name="listRr.labExamine" value="${schDto.listRr.labExamine}" 
		           		style="width: 98%;" reg='{"maxlength":"200"}'/>                       
                </td>        			
       		</tr> 
       		<tr>
				<th>诊断：</th> 
				<td colspan="3">				      				           		
		           	<input type="text"  name="listRr.diagnosis" value="${schDto.listRr.diagnosis}" 
		           		style="width: 98%;" reg='{"maxlength":"200"}'/>                       
                </td>        			
       		</tr>
       		<tr>
				<th>治疗意见：</th> 
				<td colspan="3">				      				           		
		           	<input type="text"  name="listRr.comments" value="${schDto.listRr.comments}" 
		           		style="width: 98%;" reg='{"maxlength":"200"}'/>                       
                </td>        			
       		</tr>
       		<tr>
				<th>治疗药物:</th>
				<td colspan="3">
		           	<input type="text"  name="listRr.drugs" value="${schDto.listRr.drugs}" 
		           		style="width: 100px;" reg='{"maxlength":"100"}'/>  
		           	<span>&nbsp;按&nbsp;</span>
		           	<input type="text"  name="listRr.measure" value="${schDto.listRr.measure}" 
		           		style="width: 80px;" reg='{"maxlength":"20"}'/> 	           	
                    <span>&nbsp;毫克／公斤&nbsp;</span>
		    	</td>
       		</tr> 
       		<tr>
				<th></th> 
				<td colspan="3">				      				           		
                    <span>总量&nbsp;</span>
		           	<input type="text"  name="listRr.totalMeasure" value="${schDto.listRr.totalMeasure}" 
		           		style="width: 100px;" reg='{"maxlength":"20"}'/>  
		           	<span>&nbsp;疗程&nbsp;</span>
		           	<input type="text"  name="listRr.treatmentCourse" value="${schDto.listRr.treatmentCourse}" 
		           		style="width: 100px;" reg='{"maxlength":"20"}'/> 		           	 
		           	<span>&nbsp;天&nbsp;</span>                    
                </td>        			
       		</tr>
       		<tr>
				<th><label class="required">治疗时间:</label></th>
				<td colspan="3">
					<input type="text" reg='{"required":"true"}' class="layui-input x-admin-content-sm-date"
						   name="listRr.treatmentDt" id="treatmentDt"
						   value="<fmt:formatDate value='${schDto.listRr.treatmentDt}' pattern='yyyy/MM/dd'/>"
						   style="padding-left: 0px;width: 80px;"/>
		           	<span>&nbsp;实用&nbsp;</span>
		           	<input type="text"  name="listRr.realityDays" value="${schDto.listRr.realityDays}" 
		           		style="width: 60px;" reg='{"maxlength":"20"}'/> 	           	
                    <span>&nbsp;天,实用剂&nbsp;</span>
		           	<input type="text"  name="listRr.realityMeasure" value="${schDto.listRr.realityMeasure}" 
		           		style="width: 60px;" reg='{"maxlength":"20"}'/> 
                    <span>&nbsp;占总剂量的&nbsp;</span>
		           	<input type="text"  name="listRr.measureRate" value="${schDto.listRr.measureRate}" 
		           		style="width: 60px;" reg='{"maxlength":"20"}'/>		           		                    
		    	</td>
       		</tr> 
       		<tr>
				<th>药物副反应：</th> 
				<td colspan="3">				      				           		
		           	<input type="text"  name="listRr.sideReaction" value="${schDto.listRr.sideReaction}" 
		           		style="width: 98%;" reg='{"maxlength":"200"}'/>                       
                </td>        			
       		</tr>       		       		        		       		         		       		       		      		      		      		       		
			<tr>                  
 	            <th>诊断单位：</th>
	            <td><ehr:org code="${schDto.listRr.diagnosisUnit}"/></td>
	            <th>治疗医生：</th>
	            <td><ehr:user userCode="${schDto.listRr.treatmentDoctor}"/></td>                                          		                                  
			</tr>       		       		      		       		
       	</tbody>
	</table> 
</fieldset> 
</div>
</form>
