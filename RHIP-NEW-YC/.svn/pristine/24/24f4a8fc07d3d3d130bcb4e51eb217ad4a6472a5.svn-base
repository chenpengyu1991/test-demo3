<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<script src="${pageContext.request.contextPath}/js/views/idm/schistosome/medicalEdit.js" type="text/javascript"></script>
<script type="text/javascript">

layui.use('laydate', function(){
    var laydate = layui.laydate;
    
    laydate.render({
      elem: '#reportDate' 
   	   ,format: 'yyyy/MM/dd'
   	   ,max:0
   	,trigger: 'click' 
    });
    laydate.render({
        elem: '#firstDiagnosisDt' 
        ,type:'year'
      	  , trigger: 'click' 
      });
    laydate.render({
        elem: '#cureDate' 
        ,type:'year'
      	  , trigger: 'click' 
      });
    laydate.render({
        elem: '#firstWxdiagnosisDt' 
        ,type:'year'
      	  , trigger: 'click' 
      });
    laydate.render({
        elem: '#ehfDiagnoseTime' 
     	   ,format: 'yyyy/MM/dd'
     	  ,trigger: 'click' 
      });
    laydate.render({
        elem: '#followupDt' 
     	   ,format: 'yyyy/MM/dd'
     	  ,trigger: 'click' 
      });
    
    laydate.render({
        elem: '#lastAlimentaryCanalDt' 
     	   ,format: 'yyyy/MM/dd'
     	  ,trigger: 'click' 
      });
    laydate.render({
        elem: '#lastAscitesDt' 
     	   ,format: 'yyyy/MM/dd'
     	  ,trigger: 'click' 
      });
});    


</script>
<form id="medicalForm">
<input type="hidden" name="singleId" id="singleId" value="${schDto.singleId}">
<input type="hidden" name="idmId" value="${schDto.idmId}">
<input type="hidden" name="specialStatus" id="specialStatusId" value="${schDto.specialStatus}">
<input type="hidden" name="generalCondition.id" value="${schDto.generalCondition.id}">
<input type="hidden" name="otherCondition.id" value="${schDto.otherCondition.id}">
<input type="hidden" name="caseInformation.id" value="${schDto.caseInformation.id}">
<input type="hidden" name="labExamine.id" value="${schDto.labExamine.id}">
<input type="hidden" name="clinicalManifestations.id" value="${schDto.clinicalManifestations.id}">
<input type="hidden" name="pastHistory.id" value="${schDto.pastHistory.id}">
<input type="hidden" name="generalCondition.healthFileNo" value="${schDto.generalCondition.healthFileNo}">



<input type="hidden" id="firstDiagnosisDtHidden" name="pastHistory.firstDiagnosisDt">
<input type="hidden" id="firstWxdiagnosisDtHidden" name="pastHistory.firstWxdiagnosisDt">
<input type="hidden" id="cureDateHidden" name="otherCondition.cureDate">

<input type="hidden" name="caseInformation.surveyOrg" value="${schDto.caseInformation.surveyOrg}">
<input type="hidden" name="caseInformation.respondents" value="${schDto.caseInformation.respondents}">
<div class="postcontent">
<i class="popno">晚期血吸虫病病人体检表</i>
<table class="posttable">
	<colgroup>
     <col style="min-width: 150px; width: 20%;"/>
     <col style="min-width: 220px; width: 30%;"/>
     <col style="min-width: 150px; width: 15%;"/>
     <col style="min-width: 220px; width: 35%;"/>	           
	</colgroup>
	<tbody>
     <tr>
         <td></td>
         <td></td>
         <th><label class="required">体检日期：</label></th>
         <td>
         	<input type="text" class="layui-input x-admin-content-sm-date"  name="caseInformation.reportDate" reg='{"required":"true"}' id="reportDate" value="<fmt:formatDate value='${schDto.caseInformation.reportDate}' pattern='yyyy/MM/dd'/>" style="padding-left: 0px;width: 80px;" />
             <%-- <tag:dateInput nullToToday="false" id="reportDate" name="caseInformation.reportDate" style="width: 80px;"
             	pattern="yyyy/MM/dd" date="${schDto.caseInformation.reportDate}" onlypast="true" reg='{"required":"true"}'></tag:dateInput> --%>
            </td>
        </tr>
        </tbody>
</table>
<fieldset style="margin:10px 0px 10px 0px">
	<legend>一、基础信息</legend>
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
           			<input type="text" id="generalCondition.name" name="generalCondition.name" value="${schDto.generalCondition.name}" 
           				style="width: 100px;" reg='{"maxlength":"50"}'/>
           		</td>
                <th>性别:</th>
                <td>
                	<ehr:dic-radio name="generalCondition.gender" dicmeta="GBT226112003" value="${schDto.generalCondition.gender}"  code="1,2"/>
           		</td>  
			</tr>
			<tr>
	        	<th>信息卡编号:</th>
           		<td>
           			<input type="text"  name="caseInformation.mediRecordNum" value="${schDto.caseInformation.mediRecordNum}" 
           				style="width: 100px;" reg='{"maxlength":"10"}'/>
           		</td>			
          		<th>身份证号:</th>
           		<td>
           			<input type="text" id="idCard" name="generalCondition.idcard" value="${schDto.generalCondition.idcard}"
                    	reg='{"idCard":"true"}'/>
                </td>			
			</tr>
          	<tr>
            	<th>常住类型：</th>
               	<td>
                   <ehr:dic-radio name="generalCondition.floatPopulation" dicmeta="FS10005"
                                  value="${schDto.generalCondition.floatPopulation}" onchange="idmCommon.toggerAddress()"/>
               	</td>
           	</tr>			
       		<tr>
            	<th class="required">现住址：</th>
	            <td colspan="3">
		        	<ehr:dic-town-village villageId="pavillage_address" townId="patown_address" villageName="generalCondition.pastreet" townName="generalCondition.patownShip"
		            	villageValue="${schDto.generalCondition.pastreet}" townValue="${schDto.generalCondition.patownShip}" width="160px;" reg='{"required":"true"}'/>
                    <div>
	                    <label id="tempPaValue">
	                        <ehr:dic code="${schDto.generalCondition.patownShip}" dicmeta="FS990001"/><ehr:dic code="${schDto.generalCondition.pastreet}" dicmeta="FS990001"/>
	                    </label>
	                    <input type="text" id="pahouseNumber" name="generalCondition.pahouseNumber" value="${schDto.generalCondition.pahouseNumber}"
			                	reg='{"maxlength":"50","required":"true"}'  style="width: 180px;">
			         	<span id="spanPaNumber">(门牌号)</span>
		         	</div>
		        </td>
	     	</tr>
	     	<tr>
	        	<th>联系电话:</th>
           		<td>
           			<input type="text" id="phoneNumber" name="generalCondition.phoneNumber" value="${schDto.generalCondition.phoneNumber}" 
           				style="width: 150px;" reg='{"maxlength":"20","phone":"true"}'/>
           		</td>
	        	<th>居民健康档案编码:</th>
           		<td>${schDto.generalCondition.healthFileNo}</td>           			     	
	     	</tr> 			
       		<tr>
				<th>晚血分型:</th>
				<td colspan="3">
	           		<ehr:dic-radio name="otherCondition.classifyAccording" dicmeta="CV0501025" 
                   		code="1,2,3,4" value="${schDto.otherCondition.classifyAccording}" />
                </td> 
       		</tr>
       		<tr>
				<th>病情分类:</th>
				<td colspan="3">
	           		<ehr:dic-radio name="otherCondition.caseType" dicmeta="IDM00328" 
                   		code="1,2,3,4" value="${schDto.otherCondition.caseType}" />
                </td> 	
       		</tr>       		
       		<tr>
	            <th>并发症：</th>
	            <td colspan="3">
	                <ehr:dic-radio name="clinicalManifestations.isComplications" dicmeta="PH00002" code="2,1" value="${schDto.clinicalManifestations.isComplications}"
	                        onchange="toggleOther('clinicalManifestations.isComplications','complications',1);"/>
	                <span id="complications" style="display: none">
	                    <input type="text" name="clinicalManifestations.complications" value="${schDto.clinicalManifestations.complications}"
	                           reg='{"maxlength":"100"}' style="width: 70%;">
	                </span>
	            </td>    			
       		</tr>
       	</tbody>
    </table> 
	<table class="posttable">
       	<colgroup>
           <col style="min-width: 200px; width: 30%;"/>
           <col style="min-width: 100px; width: 20%;"/>
           <col style="min-width: 100px; width: 15%;"/>
           <col style="min-width: 200px; width: 35%;"/>
      	</colgroup>
      	<tbody>       		 
       		<tr>
       			<td colspan="4">
       				<div style="overflow:hidden;margin:10px 5px 10px 5px">
       					<div style="margin:10px 0px 0px 0px;width:33%;border-top:1px dashed #000000;height: 1px;overflow:hidden;float:left;"></div>
       					<div style="float:left;">虚线以下的“基础信息”部分在随访时可省略</div>
       					<div style="margin:10px 0px 0px 0px;border-top:1px dashed #000000;height: 1px;overflow:hidden;"></div>
       				</div>
       			</td>
       		</tr>
			<tr>
				<th>首次确诊血吸虫病年份:</th>
				<td colspan="3">
					<input type="text"  readonly  class="layui-input x-admin-content-sm-date" placeholder="选择年份" name="firstDiagnosisDt" id="firstDiagnosisDt" value="<fmt:formatDate value="${schDto.pastHistory.firstDiagnosisDt}" pattern="yyyy"/>"  style="padding-left: 0px;width: 80px;"/>
		           	<%-- <tag:dateInput nullToToday="false" id="firstDiagnosisDt" name="firstDiagnosisDt" style="width: 80px;"
                    	pattern="yyyy" date="${schDto.pastHistory.firstDiagnosisDt}" onlypast="true"></tag:dateInput> --%>
                </td>			
			</tr>
       		<tr>
	            <th>诊断依据：</th>
	            <td colspan="3">
	                <ehr:dic-checkbox name="pastHistory.firstDiagnosisReason" dicmeta="IDM00380" code="1,2,3,99" value="${schDto.pastHistory.firstDiagnosisReason}"
	                        onchange="toggleOtherCK('pastHistory.firstDiagnosisReason','firstDiagnosisReason',99);"/>
	                <span id="firstDiagnosisReason" style="display: none">
	                    <input type="text" name="pastHistory.firstDiagnosisReasonOther" value="${schDto.pastHistory.firstDiagnosisReasonOther}"
	                           reg='{"maxlength":"100"}' style="width: 30%;">
	                </span>
	            </td>    			
       		</tr>
			<tr>
				<th>首次确诊晚期血吸虫病年份:</th>
				<td  colspan="3">
					<input type="text" readonly  class="layui-input x-admin-content-sm-date" placeholder="选择年份" name="firstWxdiagnosisDt" id="firstWxdiagnosisDt" value="<fmt:formatDate value="${schDto.pastHistory.firstWxdiagnosisDt}" pattern="yyyy"/>"  style="padding-left: 0px;width: 80px;"/>
		           	<%-- <tag:dateInput nullToToday="false" id="firstWxdiagnosisDt" name="firstWxdiagnosisDt" style="width: 80px;"
                    	pattern="yyyy" date="${schDto.pastHistory.firstWxdiagnosisDt}" onlypast="true"></tag:dateInput> --%>
                </td>			
			</tr>
       		<tr>
	        	<th>建卡时间:</th>
           		<td>
           			<input type="text" class="layui-input x-admin-content-sm-date"  name="pastHistory.ehfDiagnoseTime" id="ehfDiagnoseTime" value="<fmt:formatDate value='${schDto.pastHistory.ehfDiagnoseTime}' pattern='yyyy/MM/dd'/>" style="padding-left: 0px;width: 80px;" />
           		
  					<%-- <tag:dateInput nullToToday="false" id="ehfDiagnoseTime" name="pastHistory.ehfDiagnoseTime" style="width: 80px;"
                    	pattern="yyyy/MM/dd" date="${schDto.pastHistory.ehfDiagnoseTime}" onlypast="true"></tag:dateInput> --%>
           		</td>
                <th>建卡单位:</th>
                <td>
                	<input type="text" id="phoneNumber" name="pastHistory.ehfDiagnoseUnit" value="${schDto.pastHistory.ehfDiagnoseUnit}" 
           				style="width: 80%;" reg='{"maxlength":"50"}'/>
           		</td>  
			</tr>			       		 			       		     			       			     	
       </tbody>
  	</table>
  </fieldset>
<fieldset style="margin:10px 0px 10px 0px">
	<legend>二、病人现况</legend>
       <table class="posttable">
       	<colgroup>
           <col style="min-width: 110px; width: 20%;"/>
           <col style="min-width: 260px; width: 30%;"/>
           <col style="min-width: 80px; width: 15%;"/>
           <col style="min-width: 260px; width: 35%;"/>
      	</colgroup>
      	<tbody>
       		<tr>
	            <th>近期上消化道出血史：</th>
	            <td colspan="3">
	                <ehr:dic-radio name="pastHistory.alimentaryCanal" dicmeta="PH00002" code="2,1" value="${schDto.pastHistory.alimentaryCanal}"
	                        onchange="toggleOther('pastHistory.alimentaryCanal','alimentaryCanal',1);"/>
	                <span id="alimentaryCanal" style="display: none">
	                    <input type="text" name="pastHistory.alimentaryCanalNum" value="${schDto.pastHistory.alimentaryCanalNum}"
	                           reg='{"maxlength":"100"}' style="width: 100px;">
	                    <span style="margin:0px 10px 0px 5px">次</span>
	                    <span style="margin:0px 0px 0px 5px">出血时间：</span>
	                    <input type="text" class="layui-input x-admin-content-sm-date"  name="pastHistory.lastAlimentaryCanalDt" id="lastAlimentaryCanalDt" value="<fmt:formatDate value='${schDto.pastHistory.lastAlimentaryCanalDt}' pattern='yyyy/MM/dd'/>" style="padding-left: 0px;width: 80px;" />
	                    <%-- <tag:dateInput nullToToday="true" id="lastAlimentaryCanalDt" name="pastHistory.lastAlimentaryCanalDt" style="width: 80px;" 
                    		pattern="yyyy/MM/dd" date="${schDto.pastHistory.lastAlimentaryCanalDt}" onlypast="true"></tag:dateInput> --%>
	                </span>
	            </td>  
			</tr>
       		<tr>
	            <th>腹水史：</th>
	            <td colspan="3">
	                <ehr:dic-radio name="pastHistory.ascites" dicmeta="PH00002" code="2,1" value="${schDto.pastHistory.ascites}"
	                        onchange="toggleOther('pastHistory.ascites','ascites',1);"/>
	                <span id="ascites" style="display: none">
	                    	腹水出现时间：
	                    	<input type="text" class="layui-input x-admin-content-sm-date"  name="pastHistory.lastAscitesDt" id="lastAscitesDt" value="<fmt:formatDate value='${schDto.pastHistory.lastAscitesDt}' pattern='yyyy/MM/dd'/>" style="padding-left: 0px;width: 80px;" />
	                    <%-- <tag:dateInput nullToToday="true" id="lastAscitesDt" name="pastHistory.lastAscitesDt" style="width: 80px;" 
                    		pattern="yyyy/MM/dd" date="${schDto.pastHistory.lastAscitesDt}" onlypast="true"></tag:dateInput> --%>
	                </span>
	            </td>  
			</tr>
       		<tr>
	            <th>症状：</th>
	            <td colspan="3">
					<input type="checkbox" id="stomachache" name="clinicalManifestations.stomachache" value="1" class="checkboxGroup"
                   		<c:if test="${schDto.clinicalManifestations.stomachache=='1'}"> 
                   			checked="checked" 
                   		</c:if>>
                    <label for="stomachache">腹痛</label>
					<input type="checkbox" id="diarrhea" name="clinicalManifestations.diarrhea" value="1" class="checkboxGroup"
                   		<c:if test="${schDto.clinicalManifestations.diarrhea=='1'}"> 
                   			checked="checked" 
                   		</c:if>>
                    <label for="diarrhea">腹泻</label>
					<input type="checkbox" id="constipation" name="clinicalManifestations.constipation" value="1" class="checkboxGroup"
                   		<c:if test="${schDto.clinicalManifestations.constipation=='1'}"> 
                   			checked="checked" 
                   		</c:if>>
                    <label for="constipation">便秘</label>
					<input type="checkbox" id="diarrheaVariable" name="clinicalManifestations.diarrheaVariable" value="1" class="checkboxGroup"
                   		<c:if test="${schDto.clinicalManifestations.diarrheaVariable=='1'}"> 
                   			checked="checked" 
                   		</c:if>>
                    <label for="diarrheaVariable">腹泻、便秘交替</label>  
					<input type="checkbox" id="otherSelect"  name="clinicalManifestations.otherSelect" value="1"
                		<c:if test="${schDto.clinicalManifestations.otherSelect=='1'}"> 
                			checked="checked" 
                		</c:if>                            	
                		onchange="toggleOtherCK('clinicalManifestations.otherSelect','clinicalOtherId',1)">                     
					<label for="otherSelect">其他</label>
                	<input type="text" id = "clinicalOtherId" name="clinicalManifestations.other" reg='{"maxlength":"200"}' value="${schDto.clinicalManifestations.other}" style="width: 160px;display: none"/>                                                                             
	            </td>    			
       		</tr>
       		<tr>
	            <th>劳动能力：</th>
	            <td colspan="3">
	                <ehr:dic-radio name="clinicalManifestations.laborForce" dicmeta="PH00026" code="1,2,3" value="${schDto.clinicalManifestations.laborForce}"/>
	            </td> 
       		</tr>
       		<tr>
	            <th>精神状态：</th>
	            <td>
	                <ehr:dic-radio name="clinicalManifestations.psychosis" dicmeta="PH00032" code="1,2,3" value="${schDto.clinicalManifestations.psychosis}"/>
	            </td>  
	            <th>营养状况：</th>
	            <td>
	                <ehr:dic-radio name="clinicalManifestations.nutriture" dicmeta="PH00032" code="1,2,3" value="${schDto.clinicalManifestations.nutriture}"/>
	            </td> 	            
			</tr>  
       		<tr>
	            <th>腹壁静脉曲张：</th>
	            <td>
	                <ehr:dic-radio name="clinicalManifestations.venaEpigastrica" dicmeta="PH00002" code="2,1" value="${schDto.clinicalManifestations.venaEpigastrica}"/>
	            </td>  
	            <th>下肢浮肿：</th>
	            <td>
	                <ehr:dic-radio name="clinicalManifestations.edema" dicmeta="PH00002" code="2,1" value="${schDto.clinicalManifestations.edema}"/>
	            </td> 	            
			</tr> 
       		<tr>
	            <td colspan="2"></td>  
	            <td  colspan="2">
	            	医生：<input type="text" id="dutyDoctor" name="caseInformation.dutyDoctor" value="${schDto.caseInformation.dutyDoctor}" 
           				style="width: 100px;" reg='{"maxlength":"50"}'/>
	        		建卡时间:
	        		<input type="text" class="layui-input x-admin-content-sm-date"  name="caseInformation.followupDt" id="followupDt" value="<fmt:formatDate value='${schDto.caseInformation.followupDt}' pattern='yyyy/MM/dd'/>" style="padding-left: 0px;width: 80px;" />
           		
  					<%-- <tag:dateInput nullToToday="false" id="followupDt" name="caseInformation.followupDt" style="width: 80px;"
                    	pattern="yyyy/MM/dd" date="${schDto.caseInformation.followupDt}" onlypast="true"></tag:dateInput> --%>
           		</td>	            
			</tr> 						     			       					
       	</tbody>
    </table> 
  </fieldset>  
<fieldset style="margin:10px 0px 10px 0px">
	<legend>三、基本检查</legend>
       <table class="posttable">
       	<colgroup>
           <col style="min-width: 110px; width: 20%;"/>
           <col style="min-width: 260px; width: 80%;"/>
      	</colgroup>
      	<tbody>
       		<tr>
	            <th>血常规：</th>
	            <td>
					<div>
						<span style="margin:0px 20px 0px 0px">红细胞&nbsp;<input  type="text" name="labExamine.rbcCount" value="${schDto.labExamine.rbcCount}"
	            						reg='{"maxlength":"20"}' style="width:80px;"/>
			            ×10<sup>12</sup>/L</span>
						<span>血红蛋白&nbsp;<input  type="text" name="labExamine.hgb" value="${schDto.labExamine.hgb}"
	            						reg='{"maxlength":"20"}' style="width:80px;"/>
			            g/L</span>			            
					</div>
					<div>
						<span style="margin:0px 20px 0px 0px">白细胞&nbsp;<input  type="text" name="labExamine.leukocyteCount" value="${schDto.labExamine.leukocyteCount}"
	            						reg='{"maxlength":"20"}' style="width:80px;"/>
			            ×10<sup>9</sup>/L</span>
						<span>血小板&nbsp;<input  type="text" name="labExamine.plateletReduce" value="${schDto.labExamine.plateletReduce}"
	            						reg='{"maxlength":"20"}' style="width:80px;"/>
			            ×10<sup>9</sup>/L</span>						
					</div>
	            </td>  
			</tr>
      		<tr>
	            <th>肝功能：</th>
	            <td>
					<div>
						<span style="margin:0px 20px 0px 0px">总胆红素&nbsp;<input  type="text" name="labExamine.tbil" value="${schDto.labExamine.tbil}"
	            						reg='{"maxlength":"20"}' style="width:80px;"/>
			            μmol/L</span>
						<span style="margin:0px 20px 0px 0px">谷丙转氨酶&nbsp;<input  type="text" name="labExamine.alt" value="${schDto.labExamine.alt}"
	            						reg='{"maxlength":"20"}' style="width:80px;"/>
			            U/L</span>
						<span>谷草转氨酶&nbsp;<input  type="text" name="labExamine.ast" value="${schDto.labExamine.ast}"
	            						reg='{"maxlength":"20"}' style="width:80px;"/>
			            U/L</span>				            			            
					</div>
					<div>
						<span style="margin:0px 20px 0px 0px">总蛋白&nbsp;<input  type="text" name="labExamine.tp" value="${schDto.labExamine.tp}"
	            						reg='{"maxlength":"20"}' style="width:80px;"/>
			            g/L</span>
						<span style="margin:0px 20px 0px 0px">白蛋白&nbsp;<input  type="text" name="labExamine.albumin" value="${schDto.labExamine.albumin}"
	            						reg='{"maxlength":"20"}' style="width:80px;"/>
			            g/L</span>	
						<span>GGT&nbsp;<input  type="text" name="labExamine.ggt" value="${schDto.labExamine.ggt}"
	            						reg='{"maxlength":"20"}' style="width:80px;"/>
			            U/L</span>			            					
					</div>
	            </td>  
			</tr>
      		<tr>
	            <th>肾功能：</th>
	            <td>
					<span style="margin:0px 20px 0px 0px">肌酐&nbsp;<input  type="text" name="labExamine.cr" value="${schDto.labExamine.cr}"
            						reg='{"maxlength":"20"}' style="width:80px;"/>
		            μmol/L</span>
					<span>血尿素氮&nbsp;<input  type="text" name="labExamine.bun" value="${schDto.labExamine.bun}"
            						reg='{"maxlength":"20"}' style="width:80px;"/>
		            mmol/L</span>
	            </td>  
			</tr>	
      		<tr>
	            <th>空腹血糖：</th>
	            <td>
					<span><input  type="text" name="labExamine.fbg" value="${schDto.labExamine.fbg}"
            						reg='{"maxlength":"20"}' style="width:80px;"/>
		            mmol/L</span>
	            </td>  
			</tr>	
       		<tr>
       			<td colspan="2">
       				<div style="overflow:hidden;margin:10px 5px 10px 5px">
       					<div style="margin:10px 0px 0px 0px;width:33%;border-top:1px dashed #000000;height: 1px;overflow:hidden;float:left;"></div>
       					<div style="float:left;">虚线以下的“基本检查”部分为选查项目</div>
       					<div style="margin:10px 0px 0px 0px;border-top:1px dashed #000000;height: 1px;overflow:hidden;"></div>
       				</div>
       			</td>
       		</tr>
      		<tr>
	            <th>血脂：</th>
	            <td>
					<span style="margin:0px 20px 0px 0px">总胆固醇&nbsp;<input  type="text" name="labExamine.chol" value="${schDto.labExamine.chol}"
            						reg='{"maxlength":"20"}' style="width:80px;"/>
		            mmol/L</span>
					<span>甘油三脂&nbsp;<input  type="text" name="labExamine.tg" value="${schDto.labExamine.tg}"
            						reg='{"maxlength":"20"}' style="width:80px;"/>
		            mmol/L</span>
	            </td>  
			</tr>
      		<tr>
	            <th>心电图检测：</th>
	            <td>
					<input  type="text" name="labExamine.heartCheck" value="${schDto.labExamine.heartCheck}"
            						reg='{"maxlength":"100"}' style="width:80%;"/>
	            </td>  
			</tr>	
      		<tr>
	            <th>尿常规：</th>
	            <td>
					<input  type="text" name="labExamine.urineRoutine" value="${schDto.labExamine.urineRoutine}"
            						reg='{"maxlength":"100"}' style="width:80%;"/>
	            </td>  
			</tr>							       												
       	</tbody>
    </table> 
  </fieldset>  
<fieldset style="margin:10px 0px 10px 0px">
	<legend>四、B超检查</legend>
       <table class="posttable">
       	<colgroup>
           <col style="min-width: 110px; width: 20%;"/>
           <col style="min-width: 260px; width: 80%;"/>
      	</colgroup>
      	<tbody>
       		<tr>
	            <th>肝脏：</th>
	            <td>
					<div>
						<span style="margin:0px 20px 0px 0px">右叶最大斜径&nbsp;<input  type="text" name="labExamine.rightObliqueDiameter" value="${schDto.labExamine.rightObliqueDiameter}"
	            						reg='{"maxlength":"20"}' style="width:80px;"/>
			            mm，</span>
						<span>左叶长径&nbsp;<input  type="text" name="labExamine.leftLongDiameter" value="${schDto.labExamine.leftLongDiameter}"
	            						reg='{"maxlength":"20"}' style="width:80px;"/>
			            mm，</span>
						<span>左叶厚径&nbsp;<input  type="text" name="labExamine.leftPachyDiameter" value="${schDto.labExamine.leftPachyDiameter}"
	            						reg='{"maxlength":"20"}' style="width:80px;"/>
			            mm,</span>				            			            
					</div>
					<div>
						<span style="margin:0px 20px 0px 0px">肝实质&nbsp;<input  type="text" name="labExamine.liverParenchyma" value="${schDto.labExamine.liverParenchyma}"
	            						reg='{"maxlength":"20"}' style="width:80px;"/>
			            </span>
						<span>门静脉内径&nbsp;<input  type="text" name="labExamine.portalVeinInnerDiameter" value="${schDto.labExamine.portalVeinInnerDiameter}"
	            						reg='{"maxlength":"20"}' style="width:80px;"/>
			            mm;</span>						
					</div>
	            </td>  
			</tr>
       		<tr>
	            <th>脾脏：</th>
	            <td>
					<span style="margin:0px 20px 0px 0px">长径&nbsp;<input  type="text" name="labExamine.spleenLongDiameter" value="${schDto.labExamine.spleenLongDiameter}"
            						reg='{"maxlength":"20"}' style="width:80px;"/>
		            mm，</span>
					<span>厚径&nbsp;<input  type="text" name="labExamine.spleenPachyDiamater" value="${schDto.labExamine.spleenPachyDiamater}"
            						reg='{"maxlength":"20"}' style="width:80px;"/>
		            mm，</span>
					<span>肋下&nbsp;<input  type="text" name="labExamine.spleenRib" value="${schDto.labExamine.spleenRib}"
            						reg='{"maxlength":"20"}' style="width:80px;"/>
		            mm,</span>
					<span>脾静脉内径&nbsp;<input  type="text" name="labExamine.spleenInnerDiameter" value="${schDto.labExamine.spleenInnerDiameter}"
            						reg='{"maxlength":"20"}' style="width:80px;"/>
		            mm;</span>			            				            			            
	            </td>  
			</tr>
			<tr>
	            <th>腹水：</th>
	            <td>
					<input  type="text" name="labExamine.ascites" value="${schDto.labExamine.ascites}"
            						reg='{"maxlength":"50"}' style="width:80%;"/>；
	            </td>  			
			</tr>			
		</tbody>
	</table>
</fieldset> 
<fieldset style="margin:10px 0px 10px 0px">
	<legend>五、免疫学检查</legend>
       <table class="posttable">
       	<colgroup>
           <col style="min-width: 110px; width: 20%;"/>
           <col style="min-width: 260px; width: 80%;"/>
      	</colgroup>
      	<tbody>
       		<tr>
	            <th>DDIA：</th>
	            <td>
					<input  type="text" name="labExamine.ddia" value="${schDto.labExamine.ddia}"
            						reg='{"maxlength":"20"}' style="width:80%;"/>。	            
	            </td>
	        </tr>
	     </tbody>
	 </table>
</fieldset>
<fieldset style="margin:10px 0px 10px 0px">
	<legend>六、体检结论</legend>
       <table class="posttable">
       	<colgroup>
           <col style="min-width: 110px; width: 20%;"/>
           <col style="min-width: 260px; width: 80%;"/>
      	</colgroup>
      	<tbody>
       		<tr>
				<th>晚血分型:</th>
				<td colspan="3">
	           		<ehr:dic-radio name="otherCondition.classifyAccordingLast" dicmeta="CV0501025" 
                   		code="1,2,3,4" value="${schDto.otherCondition.classifyAccordingLast}" />
                </td> 
       		</tr>
       		<tr>
				<th>病情分类:</th>
				<td colspan="3">
	           		<ehr:dic-radio name="otherCondition.caseTypeLast" dicmeta="IDM00328" 
                   		code="2,3,4,1" value="${schDto.otherCondition.caseTypeLast}" onchange="toggleOther('otherCondition.caseTypeLast','caseTypeLast',1);"/>
	                <span id="caseTypeLast" style="display: none">
	                    	<%-- <tag:dateInput nullToToday="true" id="cureDate" name="cureDate" style="width: 80px;" 
                    	pattern="yyyy" date="${schDto.otherCondition.cureDate}" onlypast="true"></tag:dateInput> --%>
                    	<input type="text" class="layui-input x-admin-content-sm-date"  name="cureDate" id="cureDate" value="<fmt:formatDate value="${schDto.otherCondition.cureDate}" pattern="yyyy"/>" style="padding-left: 0px;width: 80px;" />
           		年
	                </span>
                </td> 	
       		</tr>  
	     </tbody>
	 </table>
</fieldset>
</div>
</form>
