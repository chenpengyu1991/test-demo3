<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<script src="${pageContext.request.contextPath}/js/views/idm/schistosome/surveyEdit.js" type="text/javascript"></script>
<form id="surveyForm">
<input type="hidden" name="singleId" id="singleId" value="${schDto.singleId}">
<input type="hidden" name="idmId" value="${schDto.idmId}">
<input type="hidden" name="specialStatus" id="specialStatusId" value="${schDto.specialStatus}">
<input type="hidden" name="generalCondition.id" value="${schDto.generalCondition.id}">
<input type="hidden" name="clinicalManifestations.id" value="${schDto.clinicalManifestations.id}">
<input type="hidden" name="pastHistory.id" value="${schDto.pastHistory.id}">
<input type="hidden" name="otherCondition.id" value="${schDto.otherCondition.id}">
<input type="hidden" name="caseInformation.id" value="${schDto.caseInformation.id}">
<input type="hidden" name="labExamine.id" value="${schDto.labExamine.id}">
<input type="hidden" name="diagnosis.id" value="${schDto.diagnosis.id}">

<input type="hidden" name="caseInformation.respondents" value="${schDto.caseInformation.respondents}">
<input type="hidden" name="caseInformation.reportOrg" value="${schDto.caseInformation.reportOrg}">
<input type="hidden" name="caseInformation.surveyDate" value="<fmt:formatDate value="${schDto.caseInformation.surveyDate}" pattern="yyyy/MM/dd"/>">
<input type="hidden" name="labExamine.checkUnit" value="${schDto.labExamine.checkUnit}">
<input type="hidden" name="labExamine.checkDt" value="<fmt:formatDate value="${schDto.labExamine.checkDt}" pattern="yyyy/MM/dd"/>">
<input type="hidden" name="caseInformation.modifyRespondents" value="${schDto.caseInformation.modifyRespondents}">
<input type="hidden" name="caseInformation.modifySurveyDate" value="<fmt:formatDate value="${schDto.caseInformation.modifySurveyDate}" pattern="yyyy/MM/dd"/>">
<input type="hidden" id="logoff" name="logoff" value="${schDto.logoff}">
<div class="postcontent postdiv">
<i class="popno">晚期血吸虫病人调查表</i>
<fieldset class="layui-elem-field">
	<legend>一、病人一般情况</legend>
       <table class="posttable">
       	<colgroup>
           <col style="min-width: 110px; width: 20%;"/>
           <col style="min-width: 260px; width: 30%;"/>
           <col style="min-width: 110px; width: 15%;"/>
           <col style="min-width: 260px; width: 35%;"/>
      		</colgroup>
      		<tbody>
       		<tr>
	        	<th>姓名:</th>
           		<td>
           			<input type="text" id="patientName" name="generalCondition.name" value="${schDto.generalCondition.name}" 
           				style="width: 100px;" reg='{"maxlength":"50"}'/>
           		</td>
                <th>性别:</th>
                <td>
                	<ehr:dic-radio name="generalCondition.gender" dicmeta="GBT226112003" value="${schDto.generalCondition.gender}"  code="1,2"/>
           		</td>
			</tr>
            <tr>
                <th>出生年月日:</th>
                <td>
					<%-- <tag:dateInput id="surveyBirthday" name="generalCondition.birthday" style="width: 80px;"
                    	pattern="yyyy/MM/dd" date="${schDto.generalCondition.birthday}" onlypast="true"></tag:dateInput> --%>  
                    	<input type="text" class="layui-input x-admin-content-sm-date"  name="generalCondition.birthday" id="surveyBirthday" value="<fmt:formatDate value='${schDto.generalCondition.birthday}' pattern='yyyy/MM/dd'/>" style="padding-left: 0px;width: 80px;" />                  
                </td>
                <th>身份证号:</th>
                <td>
                    <input type="text" id="surveyidCard" name="generalCondition.idcard" value="${schDto.generalCondition.idcard}"
                           placeholder="输入身份证获取个人信息" reg='{"idCard":"true"}'/>
                </td>
            </tr>
            <tr>
                <th>家庭固定电话:</th>
                <td>            
                    <input type="text" id="phoneNumberId" name="generalCondition.familyPhone" value="${schDto.generalCondition.familyPhone}"
                           style="width: 100px;" reg='{"phone":"true"}'/>
                </td>
                <th>手机:</th>
                <td>
                    <input type="text" id="mobile" name="generalCondition.mobile" value="${schDto.generalCondition.mobile}"
                           reg='{"mobile":"true"}'/>
                </td>
            </tr>
            <tr>
                <th>文化程度:</th>
                <td>
					<ehr:dic-list id="surveryEducation" name="generalCondition.education" dicmeta="GBT46582006" 
		           		value="${schDto.generalCondition.education}" code="IDM09,IDM07,IDM02,IDM03,IDM16" />                    
                </td>
                <th>正规受教育年限:</th>
                <td>
                	<input type="text" name="generalCondition.educationYear" value="${schDto.generalCondition.educationYear}"
                    	style="width: 100px;" reg='{"number":"true","max":"100"}'/>年
                </td>
            </tr>
            <tr>
                <th>职业:</th>
                <td colspan="3">
                    <ehr:dic-list id="surveryOccupation" name="generalCondition.occupation" dicmeta="GBT6565"  value="${schDto.generalCondition.occupation}"
                                  code="CV020120201,CV020120202,CV020120203,CV020120204,CV020120205,CV020120206,CV020120207,CV020120208,CV020120209
	               		,CV020120210,CV020120211,CV020120212,CV020120213,CV020120214,CV020120215,CV020120216,CV020120217,CV020120218,CV020120219"  width="200px"/>
					<%--<ehr:dic-list id="surveryOccupation" name="generalCondition.occupation" dicmeta="GBT6565"
		           		value="${schDto.generalCondition.occupation}" onchange="toggleOtherSC('generalCondition.occupation','spanOccupationOther','CV020120299');"
		           		code="CV020120211,CV020120213,CV020120207,CV020120210,CV020120216,CV020120233,CV020120203,CV020120204,CV020120234,CV020120209,CV020120299" />   --%>
  					<span id="spanOccupationOther">
                    	<input type="text" style="width: 150px;" name="generalCondition.occupationOther" value="${schDto.generalCondition.occupationOther}" reg='{"maxlength":"10"}' />
                    </span>                  
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
            	<th ><label class="required">地址：</label></th>
	            <td colspan="3">
                    <ehr:dic-town-street-village villageId="pavillage_address" streetId="pastreet_address" callback="idmCommon.displayPaAddress"
                                                 townId="patown_address" streetName="generalCondition.pastreet"
                                                 townName="generalCondition.patownShip" streetValue="${schDto.generalCondition.pastreet}"
                                                 townValue="${schDto.generalCondition.patownShip}" width="180px;" reg='{"required":"true"}'/>
                    <div>
	                    <label id="tempPaValue">
	                        <ehr:dic code="${schDto.generalCondition.patownShip}" dicmeta="FS990001"/><ehr:dic code="${schDto.generalCondition.pastreet}" dicmeta="FS990001"/>
	                    </label>
	                    <input type="text" id="pahouseNumber" name="generalCondition.pahouseNumber" value="${schDto.generalCondition.pahouseNumber}" reg='{"required":"true"}'
			                	reg='{"maxlength":"50"}'  style="width: 180px;">
			         	<span id="spanPaNumber">(门牌号)</span>
		         	</div>
		        </td>
	     	</tr>

            <tr>
                <th>居住地为:</th>
                <td colspan="3">
					<ehr:dic-radio name="generalCondition.epidemic" dicmeta="IDM00347"
		           		value="${schDto.generalCondition.epidemic}"/>                    
                </td>
            </tr>
            <tr>
                <th>户口性质:</th>
                <td colspan="3">
					<ehr:dic-radio name="generalCondition.hrType" dicmeta="IDM00348"
		           		value="${schDto.generalCondition.hrType}" onchange="toggleOther('generalCondition.hrType','spanHrType','2');"/> 
		           	<span id="spanHrType">
		           			<label>如填"非农业户口"，则是：</label><ehr:dic-radio name="generalCondition.loseJob" dicmeta="IDM00349"
		           			value="${schDto.generalCondition.loseJob}" onchange="toggleOther('generalCondition.loseJob','divLoseJob','2');"/> 
                        <div id="divLoseJob">
                            对于非农业户口的失业人员，是否享受低保:<ehr:dic-radio name="generalCondition.lowObject" dicmeta="IDM00350"
                                value="${schDto.generalCondition.lowObject}"/>
                        </div>
                    </span>
                </td>
            </tr>
            <tr>
                <th>参加何种医保:</th>
                <td colspan="3">
					<ehr:dic-radio name="generalCondition.hiType" dicmeta="IDM00351"
		           		value="${schDto.generalCondition.hiType}" />                 
                </td>
            </tr>
       </tbody>
  </table>
  </fieldset>
<fieldset class="layui-elem-field">
	<legend>二、相关病史</legend>
       <table class="posttable">
       		<colgroup>
	           <col style="min-width: 150px; width: 20%;"/>
	           <col style="min-width: 250px; width: 20%;"/>
	           <col style="min-width: 110px; width: 15%;"/>
	           <col style="min-width: 250px; width: 35%;"/>
      		</colgroup>
      		<tbody>
       		<tr>
				<th>首次确诊血吸虫病时间:</th>
				<td>
		           	<%-- <tag:dateInput name="pastHistory.firstDiagnosisDt" style="width: 80px;"
                    	pattern="yyyy/MM/dd" date="${schDto.pastHistory.firstDiagnosisDt}" onlypast="true"></tag:dateInput> --%>
                    	<input type="text" class="layui-input x-admin-content-sm-date"  name="pastHistory.firstDiagnosisDt" id="pastHistoryFirstDiagnosisDt" value="<fmt:formatDate value='${schDto.pastHistory.firstDiagnosisDt}' pattern='yyyy/MM/dd'/>" style="padding-left: 0px;width: 80px;" />
                </td> 
				<th>诊断依据:</th>
				<td>
                    <ehr:dic-list name="pastHistory.firstDiagnosisReason" dicmeta="IDM00352" value="${schDto.pastHistory.firstDiagnosisReason}"/>
                </td>
       		</tr>
            <tr>
                <th>首次确诊为晚血时间:</th>
                <td>
                    <%-- <tag:dateInput id="firstWxdiagnosisDtDisplay" name="firstWxdiagnosisDtDisplay" style="width: 80px;"
                                   pattern="yyyy/MM" date="${schDto.pastHistory.firstWxdiagnosisDt}" onlypast="true"></tag:dateInput> --%>
                     <input type="text" class="layui-input x-admin-content-sm-date"  name="firstWxdiagnosisDtDisplay" id="firstWxdiagnosisDtDisplay" value="<fmt:formatDate value='${schDto.pastHistory.firstWxdiagnosisDt}' pattern='yyyy/MM/dd'/>" style="padding-left: 0px;width: 80px;" />
					<input type="hidden" id="firstWxdiagnosisDtId" name="pastHistory.firstWxdiagnosisDt" value="">                                   
                </td>
                <th>类型:</th>
                <td>
                    <ehr:dic-list name="pastHistory.firstDiagnosisType" dicmeta="CV0501025" code="1,2,3,4" value="${schDto.pastHistory.firstDiagnosisType}"/>
                </td>
            </tr>
       		<tr>
				<th title="血吸虫病病原学治疗史">病原学治疗史:</th>
				<td colspan="3">
                    <ehr:dic-radio name="pastHistory.etiology" dicmeta="PH00002" code="1,2" value="${schDto.pastHistory.etiology}"
                                  onchange="toggleOther('pastHistory.etiology','spanEtiologyId','1')"/>
                    <span id="spanEtiologyId">
                    	<label>&nbsp;&nbsp;治疗次数：</label>
                        <input type="text"  name="pastHistory.etiologyNum" value="${schDto.pastHistory.etiologyNum}"
                            style="width: 40px;" reg='{"maxlength":"2"}'/>
                        <span>&nbsp;次&nbsp;&nbsp;末次治疗时间:</span>
                        <%-- <tag:dateInput id="lastEtiologyDtDisplay" name="lastEtiologyDtDisplay" style="width: 80px;"
                            pattern="yyyy/MM" date="${schDto.pastHistory.lastEtiologyDt}" onlypast="true"></tag:dateInput> --%>
                            <input type="text" class="layui-input x-admin-content-sm-date"  name="lastEtiologyDtDisplay" id="lastEtiologyDtDisplay" value="<fmt:formatDate value='${schDto.pastHistory.lastEtiologyDt}' pattern='yyyy/MM/dd'/>" style="padding-left: 0px;width: 80px;" />
                        <input type="hidden" id="lastEtiologyDtId" name="pastHistory.lastEtiologyDt" value="">      
                    </span>
                </td>        			
       		</tr>
            <tr>
                <th >脾切史:</th>
                <td colspan="3">
                    <ehr:dic-radio name="pastHistory.spleen" dicmeta="PH00002" code="1,2" value="${schDto.pastHistory.spleen}"
                                  onchange="toggleOther('pastHistory.spleen','spanSpleenId','1');"/>
                    	<span id="spanSpleenId">
                    		<span>&nbsp;&nbsp;脾切时间:</span>
				           	<%-- <tag:dateInput id="spleenDtId" name="pastHistory.spleenDt" style="width: 80px;"
                                           pattern="yyyy/MM/dd" date="${schDto.pastHistory.spleenDt}" onlypast="true"></tag:dateInput> --%>
                                           <input type="text" class="layui-input x-admin-content-sm-date" name="pastHistory.spleenDt" id="spleenDtId" value="<fmt:formatDate value='${schDto.pastHistory.spleenDt}' pattern='yyyy/MM/dd'/>" style="padding-left: 0px;width: 80px;" />
	                    </span>
                </td>
            </tr>
            <tr>
                <th >腹水史:</th>
                <td colspan="3">
                    <ehr:dic-radio name="pastHistory.ascites" dicmeta="PH00002" code="1,2" value="${schDto.pastHistory.ascites}"
                                  onchange="toggleOther('pastHistory.ascites','spanAscitesId','1')"/>
		           	<span id="spanAscitesId">
		           		<span>&nbsp;&nbsp;末次腹水时间:</span>
			           	<%-- <tag:dateInput id="lastAscitesDtId" name="pastHistory.lastAscitesDt" style="width: 80px;"
                                       pattern="yyyy/MM/dd" date="${schDto.pastHistory.lastAscitesDt}" onlypast="true"></tag:dateInput> --%>
                                       <input type="text" class="layui-input x-admin-content-sm-date"  name="pastHistory.lastAscitesDt" id="lastAscitesDtId" value="<fmt:formatDate value='${schDto.pastHistory.lastAscitesDt}' pattern='yyyy/MM/dd'/>" style="padding-left: 0px;width: 80px;" />
		           	</span>
                </td>
            </tr>
            <tr>
				<th title="上消化道出血史">上消化道出血史:</th>
				<td colspan="3">
					<ehr:dic-radio name="pastHistory.alimentaryCanal" dicmeta="PH00002"  code="1,2" value="${schDto.pastHistory.alimentaryCanal}"
                    	 onchange="toggleOther('pastHistory.alimentaryCanal','spanAlimentaryCanalId','1')"/>
		           	<span id="spanAlimentaryCanalId">
		           		<span>&nbsp;&nbsp;末次出血时间:</span>
			           	<%-- <tag:dateInput id="lastAlimentaryCanalDtId" name="pastHistory.lastAlimentaryCanalDt" style="width: 80px;" 
	                    	pattern="yyyy/MM/dd" date="${schDto.pastHistory.lastAlimentaryCanalDt}" onlypast="true"></tag:dateInput> --%>
	                    	<input type="text" class="layui-input x-admin-content-sm-date"  name="pastHistory.lastAlimentaryCanalDt" id="lastAlimentaryCanalDtId" value="<fmt:formatDate value='${schDto.pastHistory.lastAlimentaryCanalDt}' pattern='yyyy/MM/dd'/>" style="padding-left: 0px;width: 80px;" />
		           	</span>	           	
                </td>        			
       		</tr>
            <tr>
                <th title="肝昏迷史">肝昏迷史:</th>
                <td colspan="3">
                    <ehr:dic-radio name="pastHistory.hepaticComa" dicmeta="PH00002"  code="1,2" value="${schDto.pastHistory.hepaticComa}"
                                  onchange="toggleOther('pastHistory.hepaticComa','spanHepaticComaId','1')"/>
		           	<span id="spanHepaticComaId">
		           		<span>&nbsp;&nbsp;末次发生时间:</span>
			           	<%-- <tag:dateInput id="hepaticComaDttId" name="pastHistory.hepaticComaDt" style="width: 80px;"
                                       pattern="yyyy/MM/dd" date="${schDto.pastHistory.hepaticComaDt}" onlypast="true"></tag:dateInput> --%>
                        <input type="text" class="layui-input x-admin-content-sm-date"  name="pastHistory.hepaticComaDt" id="hepaticComaDttId" value="<fmt:formatDate value='${schDto.pastHistory.hepaticComaDt}' pattern='yyyy/MM/dd'/>" style="padding-left: 0px;width: 80px;" />
		           	</span>
                </td>
            </tr>
            <tr>
                <th title="肝炎史">肝炎史:</th>
                <td colspan="3">
                    <ehr:dic-radio name="pastHistory.cldFlg" dicmeta="PH00002"  code="1,2" value="${schDto.pastHistory.cldFlg}"
                                  onchange="toggleOther('pastHistory.cldFlg','spanCldFlgId','1')"/>
		           	<span id="spanCldFlgId">
		           		<span>&nbsp;&nbsp;肝炎类型:</span>
			           	<ehr:dic-radio name="pastHistory.hepatitisType" dicmeta="IDM00016" code="2,3,4" value="${schDto.pastHistory.hepatitisType}"/>
		           	</span>
                </td>
            </tr>
            <tr>
                <th>是否有以下疾病:</th>
            </tr>
            <tr>
                <th title="糖尿病">糖尿病:</th>
                <td colspan="3">
                    <ehr:dic-radio name="pastHistory.dmFlg" dicmeta="PH00002"  code="1,2" value="${schDto.pastHistory.dmFlg}"/>
                </td>
            </tr>
            <tr>
                <th title="高血压">高血压:</th>
                <td colspan="3">
                    <ehr:dic-radio name="pastHistory.hypertension" dicmeta="PH00002"  code="1,2" value="${schDto.pastHistory.hypertension}"/>
                </td>
            </tr>
            <tr>
                <th title="冠心病">冠心病:</th>
                <td colspan="3">
                    <ehr:dic-radio name="pastHistory.chd" dicmeta="PH00002"  code="1,2" value="${schDto.pastHistory.chd}"/>
                </td>
            </tr>
       	</tbody>
	</table> 
</fieldset> 
<fieldset class="layui-elem-field">
	<legend>三、现况</legend>
       <table class="posttable">
       		<colgroup>
                <col style="min-width: 150px; width: 20%;"/>
                <col style="min-width: 250px; width: 30%;"/>
                <col style="min-width: 110px; width: 15%;"/>
                <col style="min-width: 250px; width: 35%;"/>
      		</colgroup>
      		<tbody>
	       		<tr>
					<th>病情目前状况:</th>
					<td colspan="3">
                        <ehr:dic-list name="otherCondition.outcomeCode" dicmeta="IDM00353" value="${schDto.otherCondition.outcomeCode}"
                        	code="1,2,3,4" onchange="surveyEdit.toggerOutCome();"/>
                    </td>
	       		</tr>
	       		<tr id="trCureDate">
					<th>痊愈时间</th>
					<td colspan="3">
                        <%-- <tag:dateInput name="otherCondition.cureDate" style="width: 80px;"
                                       pattern="yyyy/MM/dd" date="${schDto.otherCondition.cureDate}" onlypast="true"></tag:dateInput> --%>
                        <input type="text" class="layui-input x-admin-content-sm-date"  name="otherCondition.cureDate" id="otherConditionCureDate" value="<fmt:formatDate value='${schDto.otherCondition.cureDate}' pattern='yyyy/MM/dd'/>" style="padding-left: 0px;width: 80px;" />
	                </td>        			
	       		</tr>	
	       		<tr id="trDeathTime">
					<th>死亡时间:</th>
					<td>
                        <%-- <tag:dateInput name="otherCondition.deathTime" style="width: 80px;"
                                       pattern="yyyy/MM/dd" date="${schDto.otherCondition.deathTime}" onlypast="true"></tag:dateInput> --%>
                        <input type="text" class="layui-input x-admin-content-sm-date"  name="otherCondition.deathTime" id="otherConditionDeathTime" value="<fmt:formatDate value='${schDto.otherCondition.deathTime}' pattern='yyyy/MM/dd'/>" style="padding-left: 0px;width: 80px;" />
			    	</td>
                    <th>死亡原因:</th>
                    <td>
                        <input type="text" name="otherCondition.deathCause" value="${schDto.otherCondition.deathCause}" reg='{"maxlength":"100"}'/>
                    </td>
			   	</tr>
	       	</tbody>
	    </table>
</fieldset>
<fieldset class="layui-elem-field" class="layui-table x-admin-sm-table-list-small">
       <table class="posttable">
       		<colgroup>
	           <col style="min-width: 150px; width: 20%;"/>
	           <col style="min-width: 220px; width: 30%;"/>
	           <col style="min-width: 150px; width: 15%;"/>
	           <col style="min-width: 220px; width: 35%;"/>	           
      		</colgroup>
      		<tbody>
            <tr>
                <th>登记人：</th>
                <td><ehr:user userCode="${schDto.caseInformation.modifyRespondents}"/></td>
                <th>登记日期：</th>
                <td>
                    <fmt:formatDate value="${schDto.caseInformation.modifySurveyDate}" pattern="yyyy/MM/dd"/>
                </td>
            </tr>
            </tbody>
	   </table>
</fieldset>
</div>
</form>
<script type="text/javascript">

layui.use('laydate', function(){
    var laydate = layui.laydate;
    
    laydate.render({
      elem: '#surveyBirthday' 
   	   ,format: 'yyyy/MM/dd'
   	   ,max:0
    });

    laydate.render({
      elem: '#pastHistoryFirstDiagnosisDt' 
   	   ,format: 'yyyy/MM/dd'
   	   ,max:0
   	, trigger: 'click' 
    });
    
    
    laydate.render({
        elem: '#firstWxdiagnosisDtDisplay' 
     	   ,format: 'yyyy/MM/dd'
     	   ,max:0
     	, trigger: 'click' 
      });
    
    laydate.render({
        elem: '#lastEtiologyDtDisplay' 
     	   ,format: 'yyyy/MM/dd'
     	   ,max:0
     	, trigger: 'click' 
      });
    
    laydate.render({
        elem: '#spleenDtId' 
     	   ,format: 'yyyy/MM/dd'
     	   ,max:0
     	, trigger: 'click' 
      });
    
    laydate.render({
        elem: '#lastAscitesDtId' 
     	   ,format: 'yyyy/MM/dd'
     	   ,max:0
     	, trigger: 'click' 
      });
    
    laydate.render({
        elem: '#lastAlimentaryCanalDtId' 
     	   ,format: 'yyyy/MM/dd'
     	   ,max:0
     	, trigger: 'click' 
      });
    
    laydate.render({
        elem: '#hepaticComaDttId' 
     	   ,format: 'yyyy/MM/dd'
     	   ,max:0
     	, trigger: 'click' 
      });
    
    laydate.render({
        elem: '#otherConditionCureDate' 
     	   ,format: 'yyyy/MM/dd'
     	   ,max:0
     	, trigger: 'click' 
      });
    
    laydate.render({
        elem: '#otherConditionDeathTime' 
     	   ,format: 'yyyy/MM/dd'
     	   ,max:0
     	, trigger: 'click' 
      });
    
    
  });
</script>