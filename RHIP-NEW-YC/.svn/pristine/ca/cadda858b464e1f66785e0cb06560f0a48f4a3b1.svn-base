<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ page import="com.founder.rhip.ehr.common.EHRConstants" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr" %>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<c:set var="JK_CODE" value="<%=EHRConstants.JK_CODE%>"/>

<script src="${pageContext.request.contextPath}/js/views/idm/schistosome/schcase.js" type="text/javascript"></script>
<div class="toolbar">
    <%-- <a href="javascript:void(0)" onclick="javascript:schcase.returnSearch()"><b class="fanhui">返回</b></a> --%>
    <a href="javascript:void(0)" id="addCaseReturn" ><button class="btn-gray layui-btn layui-btn-sm button"><i class="layui-icon">&#xe65c;</i>返回</button></a>
    <c:if test="${logoff != '1'}">
   		<%-- <a href="javascript:void(0)" onclick="javascript:schcase.caseSubmit()"><b class="baocun">保存</b></a> --%>
   		<a href="javascript:void(0)"  id="addCaseSubmit"><button class="layui-btn layui-btn-sm"><i class="layui-icon">&#xe605;</i>保存</button></a>
   	</c:if>
   	<%-- <a href="javascript:void(0)" onclick="javascript:schcase.viewLog(${schDto.idmId})"><b class="jilu">操作记录</b></a> --%>
   	<a href="javascript:void(0)" id="addCaseOperateLog"><button class="layui-btn layui-btn-sm"><i class="layui-icon">&#xe60e;</i>操作记录</button></a>
</div>
<div class="postcontent divFixed125" >
<form id="caseForm">
	<input type="hidden" id="pageIndex" name="pageIndex" value="${pageIndex}">
	<input type="hidden" name="singleId" value="${schDto.singleId}"/>
	<input type="hidden" name="idmId" id="idmId" value="${schDto.idmId}"/>

    <input type="hidden" name="generalCondition.id" value="${schDto.generalCondition.id}">
    <input type="hidden" name="labExamine.id" value="${schDto.labExamine.id}">
    <input type="hidden" name="caseInformation.id" value="${schDto.caseInformation.id}"/>	
    <input type="hidden" name="clinicalManifestations.id" value="${schDto.clinicalManifestations.id}"/>
    <input type="hidden" name="epidemicFocusClose.id" value="${schDto.epidemicFocusClose.id}"/>
    <input type="hidden" name="diagnosis.id" value="${schDto.diagnosis.id}"/>
    <input type="hidden" name="pastHistory.id" value="${schDto.pastHistory.id}"/>
    
    <input type="hidden"  name="caseInformation.respondents" value="${schDto.caseInformation.respondents}"/><%--需求变更要求填写人可以修改，所以要保存原始的填写人，2014-02-07--%>
    <input type="hidden"  name="caseInformation.surveyOrg" value="${schDto.caseInformation.surveyOrg}"/><%--需求变更要求填写机构可以修改，所以要保存原始的填写机构，2014-02-07--%>
    <input type="hidden"  name="caseInformation.reportOrg" value="${schDto.caseInformation.reportOrg}"/>
    <input type="hidden" name="type" id="type" value="${type}"/>
    <input type="hidden" id="logoff" name="logoff" value="${schDto.logoff}">
    <div class="postcontent">
        <i class="popno">永城市血吸虫病病人个案调查表</i>
		<table class="posttable">
		    <tr style="text-align: right;">
		        <td>
		        	编号：<input type="text" name="caseInformation.mediRecordNum" reg='{"length":"9"}' value="${schDto.caseInformation.mediRecordNum}" style="width: 20%"/>
		        </td>
		    </tr>
		</table>        
        <div class="postdiv">
        	<fieldset class="layui-elem-field">
        		<legend>一般情况</legend>
                <table class="posttable">
                    <colgroup>
                        <col style="min-width: 100px; width: 15%;"/>
                        <col style="min-width: 180px; width: 35%;"/>
                        <col style="min-width: 100px; width: 15%;"/>
                        <col style="min-width: 180px; width: 35%;"/>
                    </colgroup>
                    <tbody>
                    <tr>
                        <th>姓名：</th>
                        <td>
                        	<input type="text" id="nameId" name="generalCondition.name" value="${schDto.generalCondition.name}" 
                        		style="width: 100px;" reg='{"maxlength":"50"}'/>
                        </td>
                       <th>身份证号：</th>
                        <td>
                        	<input type="text" id="idCard" name="generalCondition.idcard" value="${schDto.generalCondition.idcard}"
                                   placeholder="输入身份证获取个人信息" reg='{"idCard":"true"}'/>
                        </td>                     
                    </tr>
					<tr>
                        <th><label class="required">性别：</label></th>
                        <td>
                        	<ehr:dic-radio name="generalCondition.gender" dicmeta="GBT226112003" value="${schDto.generalCondition.gender}"  reg='{"required":"true"}' code="1,2"/>
                        </td>					
                        <th>年龄：</th>
                        <td>
                        	<input type="text" id="age" name="generalCondition.age" value="${schDto.generalCondition.age}" 
                        		style="width: 100px;" reg='{"digits":"true","maxlength":"20"}'/>
                        </td>
		       		</tr>
					<tr>
				       	<th><label class="required">常住类型:</label></th>
				       	<td colspan="3">
				 			<ehr:dic-radio name="generalCondition.floatPopulation" dicmeta="FS10005"  reg='{"required":"true"}'
				           		value="${schDto.generalCondition.floatPopulation}" onchange="idmCommon.toggerAddress();"/>
				       	</td>
		       		</tr>
	        		<tr>
		            	<th><label class="required">户口所在地:</label></th>
		            	<td colspan="3">
			                <ehr:dic-town-street-village villageId="hrvillage_address" townId="hrtown_address" villageName="generalCondition.hrGroup" townName="generalCondition.hrtownShip"
			                	villageValue="${schDto.generalCondition.hrGroup}" townValue="${schDto.generalCondition.hrtownShip}" width="180px;" reg='{"required":"true"}'
								streetId="hrstreet_address" streetName="generalCondition.hrstreet" streetValue="${schDto.generalCondition.hrstreet}"
							/>
                            <div>
	                            <label id="tempHrValue">
	                                <ehr:dic code="${schDto.generalCondition.hrtownShip}" dicmeta="FS990001"/>
									<ehr:dic code="${schDto.generalCondition.hrstreet}" dicmeta="FS990001"/>
									<ehr:dic code="${schDto.generalCondition.hrGroup}" dicmeta="FS990001"/>
								</label>
	                            <input type="text" name="generalCondition.hrhouseNumber" id="hrhouseNumber" value="${schDto.generalCondition.hrhouseNumber}"
				                         style="width: 180px;" reg='{"maxlength":"50","required":"true"}'>
				                 <span id="spanHrNumber">(门牌号)</span>
			                 </div>
			             </td>
			     	</tr>     		       		
	        		<tr>
		            	<th>现住址：</th>
			            <td colspan="3">
							<ehr:dic-town-street-village villageId="pavillage_address" streetId="pastreet_address" callback="idmCommon.displayPaAddress"
														 townId="patown_address" villageName="generalCondition.paGroup" streetName="generalCondition.pastreet"
														 townName="generalCondition.patownShip" villageValue="${schDto.generalCondition.paGroup}" streetValue="${schDto.generalCondition.pastreet}"
														 townValue="${schDto.generalCondition.patownShip}" width="180px;" reg='{"required":"true"}'/>
							<div>
								<label id="tempPaValue">
									<ehr:dic code="${schDto.generalCondition.patownShip}" dicmeta="FS990001"/>
									<ehr:dic code="${schDto.generalCondition.pastreet}" dicmeta="FS990001"/>
									<ehr:dic code="${schDto.generalCondition.paGroup}" dicmeta="FS990001"/>
								</label>
								<input type="text" id="text_pahouseNumber" name="generalCondition.pahouseNumber" value="${schDto.generalCondition.pahouseNumber}"
									   reg='{"maxlength":"50","required":"true"}'  style="width: 180px;">
								<span id="spanPaNumber">(门牌号)</span>
							</div>
				        </td>
			     	</tr>                    
                    </tbody>
                </table>
            </fieldset>
        	<fieldset class="layui-elem-field">
        		<legend>现病史</legend>
                <table class="posttable">
                    <colgroup>
                        <col style="min-width: 100px; width: 15%;"/>
                        <col style="min-width: 140px; width: 16%;"/>
                        <col style="min-width: 130px; width: 16%;"/>
                        <col style="min-width: 130px; width: 16%;"/>
                        <col style="min-width: 130px; width: 16%;"/>
                        <col style="min-width: 130px; width: 21%;"/>
                    </colgroup>
                    <tbody>
                    <tr>
                        <td colspan="6">1.症状：(下列症状如有，请打√)</td>
                    </tr>
					<tr>
                        <td>
                        	<input type="checkbox" id="feverId" name="clinicalManifestations.fever" value="1" class="checkboxGroup"
                        		<c:if test="${schDto.clinicalManifestations.fever=='1'}"> 
                        			checked="checked" 
                        		</c:if>
                        	>
                        	<label for="feverId">发热</label>
                        </td>
                        <td>
                        	<input type="checkbox" id="cercarialDermatitisId" name="clinicalManifestations.cercarialDermatitis" value="1" class="checkboxGroup"
                        		<c:if test="${schDto.clinicalManifestations.cercarialDermatitis=='1'}"> 
                        			checked="checked" 
                        		</c:if>                        	
                        	>
                        	<label for="cercarialDermatitisId">尾蚴性皮炎</label>
                        </td>
                        <td>
                        	<input type="checkbox" id="coughId" name="clinicalManifestations.cough" value="1" class="checkboxGroup"
                        		<c:if test="${schDto.clinicalManifestations.cough=='1'}"> 
                        			checked="checked" 
                        		</c:if>                               	
                        	>
                        	<label for="coughId">咳嗽</label>
                        </td>
                        <td>
                        	<input type="checkbox" id="chestPainId"  name="clinicalManifestations.chestPain" value="1" class="checkboxGroup"
                        		<c:if test="${schDto.clinicalManifestations.chestPain=='1'}"> 
                        			checked="checked" 
                        		</c:if>                         	
                        	>
                        	<label for="chestPainId">胸痛</label>
                        </td>
                        <td>
                        	<input type="checkbox" id="hemosputumId"  name="clinicalManifestations.hemosputum" value="1" class="checkboxGroup"
                        		<c:if test="${schDto.clinicalManifestations.hemosputum=='1'}"> 
                        			checked="checked" 
                        		</c:if>                         	
                        	>
                        	<label for="hemosputumId">血痰</label>
                        </td>
                        <td>
                        	<input type="checkbox" id="stomachacheId"  name="clinicalManifestations.stomachache" value="1" class="checkboxGroup"
                        		<c:if test="${schDto.clinicalManifestations.stomachache=='1'}"> 
                        			checked="checked" 
                        		</c:if>                          	
                        	>
                        	<label for="stomachacheId">腹痛</label>
                        </td>                                                                                                                        					
		       		</tr>
					<tr>
                        <td>
                        	<input type="checkbox" id="abdominalDistensionId" name="clinicalManifestations.abdominalDistension" value="1" class="checkboxGroup"
                        		<c:if test="${schDto.clinicalManifestations.abdominalDistension=='1'}"> 
                        			checked="checked" 
                        		</c:if>                           	
                        	>
                        	<label for="abdominalDistensionId">腹胀</label>
                        </td>
                        <td>
                        	<input type="checkbox" id="diarrheaId" name="clinicalManifestations.diarrhea" value="1" class="checkboxGroup"
                        		<c:if test="${schDto.clinicalManifestations.diarrhea=='1'}"> 
                        			checked="checked" 
                        		</c:if>                           	
                        	>
                        	<label for="diarrheaId">腹泻</label>
                        </td>
                        <td>
                        	<input type="checkbox" id="poorAppetiteId" name="clinicalManifestations.poorAppetite" value="1" class="checkboxGroup"
                        		<c:if test="${schDto.clinicalManifestations.poorAppetite=='1'}"> 
                        			checked="checked" 
                        		</c:if>                            	
                        	>
                        	<label for="poorAppetiteId">食减</label>
                        </td>
                        <td  colspan="3">
                        	<input type="checkbox" id="otherSelectId"  name="clinicalManifestations.otherSelect" value="1"
                        		<c:if test="${schDto.clinicalManifestations.otherSelect=='1'}"> 
                        			checked="checked" 
                        		</c:if>                            	
                        		onchange="toggleOtherCK('clinicalManifestations.otherSelect','clinicalOtherId',1)">
                        	<label for="otherSelectId">其他</label>
                        	<input type="text" id = "clinicalOtherId" name="clinicalManifestations.other" reg='{"maxlength":"200"}' value="${schDto.clinicalManifestations.other}" style="width: 120px;"/>
                        </td>
		       		</tr> 
                    <tr>
                        <td colspan="6">2.体征:</td>
                    </tr>
					<tr>
						<th>肝脏:</th>
                        <td>
                        	剑突下<input type="text" name="clinicalManifestations.liverXiphoidBelow" reg='{"maxlength":"10"}' 
                        		value="${schDto.clinicalManifestations.liverXiphoidBelow}" style="width: 60px;"/>
                        </td>
                        <td>
                        	肋下<input type="text" name="clinicalManifestations.liverRidBelow" reg='{"maxlength":"10"}' 
                        		value="${schDto.clinicalManifestations.liverRidBelow}" style="width: 60px;"/>
                        </td> 
                        <td>
                        	质地<input type="text" name="clinicalManifestations.liverGrain" reg='{"maxlength":"10"}' 
                        		value="${schDto.clinicalManifestations.liverGrain}" style="width: 60px;"/>
                        </td>
                        <td>
                        	结节<input type="text" name="clinicalManifestations.liverNode" reg='{"maxlength":"10"}' 
                        		value="${schDto.clinicalManifestations.liverNode}" style="width: 60px;"/>
                        </td>  
                        <td>
                        	压痛<input type="text" name="clinicalManifestations.liverTenderness" reg='{"maxlength":"10"}' 
                        		value="${schDto.clinicalManifestations.liverTenderness}" style="width: 60px;"/>
                        </td>                                                                                                
		       		</tr>
					<tr>
						<th>脾脏:</th>
                        <td>
                        	上界<input type="text" name="clinicalManifestations.spleenScopeUp" reg='{"maxlength":"10"}' 
                        		value="${schDto.clinicalManifestations.spleenScopeUp}" style="width: 60px;"/>
                        </td>
                        <td>
                        	肋下<input type="text" name="clinicalManifestations.spleenRidBelow" reg='{"maxlength":"10"}' 
                        		value="${schDto.clinicalManifestations.spleenRidBelow}" style="width: 60px;"/>
                        </td> 
                        <td colspan="3">
                        	压痛<input type="text" name="clinicalManifestations.spleenTenderness" reg='{"maxlength":"10"}' 
                        		value="${schDto.clinicalManifestations.spleenTenderness}" style="width: 60px;"/>
                        </td>
		       		</tr>	
                    <tr>
                        <td colspan="6">3.实验室检查:</td>
                    </tr>	
					<tr>
						<th>皮内试验:</th>
                        <td>
                        	<ehr:dic-list name="labExamine.intradermalTest"  dicmeta="PH00004" 
                        		code="2,1" value="${schDto.labExamine.intradermalTest}" />
                        </td>
						<th>一血三检:</th>                        
                        <td>
                        	<ehr:dic-list name="labExamine.oneThree"  dicmeta="PH00004" 
                        		code="2,1" value="${schDto.labExamine.oneThree}" />
                        </td> 
						<th>IHA:</th>                        
                        <td>
                        	<ehr:dic-list name="labExamine.ihaCheck"  dicmeta="IDM00320" 
                        		code="1,2" value="${schDto.labExamine.ihaCheck}" />
                        </td>
		       		</tr> 
					<tr>
						<th><label class="required">DDIA:</label></th>
                        <td>
                        	<ehr:dic-list name="labExamine.ddia"  dicmeta="PH00004" 
                        		code="2,1" value="${schDto.labExamine.ddia}" reg='{"required":"true"}'/>
                        </td>
						<th>COPT:</th>                        
                        <td>
                        	<ehr:dic-list name="labExamine.copt"  dicmeta="IDM00321" 
                        		code="1,2" value="${schDto.labExamine.copt}" />
                        </td> 
						<th>粪便(或活组织)检查:</th>                        
                        <td>
                        	<ehr:dic-list name="labExamine.stool"  dicmeta="PH00004" 
                        		code="2,1" value="${schDto.labExamine.stool}" />
                        </td>
		       		</tr>
					<tr>
						<th>血象:</th>
                        <td colspan="5">
                        	<span>白细胞总数</span>
                        	<input type="text" name="labExamine.leukocyteCount" reg='{"maxlength":"20"}' 
                        		value="${schDto.labExamine.leukocyteCount}" style="width: 120px;"/>
                        	<span>/L</span>
                        	<span>&nbsp;&nbsp;&nbsp;&nbsp;其中嗜酸性细胞占</span>
							<input type="text" name="labExamine.eosinophils" reg='{"maxlength":"20"}' 
                        		value="${schDto.labExamine.eosinophils}" style="width: 120px;"/>   
                        	<span>%</span>                     	
                        </td>
		       		</tr>  
                    <tr>
                        <td colspan="6">4.疫水接触史:</td>
                    </tr>	
					<tr>
						<th>疫水接触地点:</th>
                        <td>
							<input type="text" name="epidemicFocusClose.farmAddr" reg='{"maxlength":"200"}' 
                        		value="${schDto.epidemicFocusClose.farmAddr}" style="width: 150px;"/>   
                        </td>
						<th>时间:</th>                        
                        <td>
                        	<%-- <tag:dateInput nullToToday="false" name="epidemicFocusClose.farmDt" style="width: 100px;"
                        		reg='{"regex":"date"}'  pattern="yyyy/MM/dd" date="${schDto.epidemicFocusClose.farmDt}" onlypast="true"></tag:dateInput> --%>
                        		 <input type="text" reg='{"regex":"date"}' class="layui-input x-admin-content-sm-date"  name="epidemicFocusClose.farmDt" id="epidemicFocusCloseFarmDt" value="<fmt:formatDate value='${schDto.epidemicFocusClose.farmDt}' pattern='yyyy/MM/dd'/>" style="padding-left: 0px;width: 100px;" />
                        </td> 
						<th>次数:</th>                        
                        <td>
							<input type="text" name="epidemicFocusClose.farmTimes" reg='{"maxlength":"20"}' 
                        		value="${schDto.epidemicFocusClose.farmTimes}" style="width: 100px;"/>  
                        </td>
		       		</tr> 
                    <tr>
                        <td colspan="6">
                        	<span>5.B超检查:</span>
							<input type="text" name="labExamine.b" reg='{"maxlength":"100"}' 
                        		value="${schDto.labExamine.b}" style="width: 350px;"/>                         
                        </td>
                    </tr>		       		                   		       				       		  		       		                   	       			       		
                    </tbody>
                </table>
            </fieldset>     
        	<fieldset class="layui-elem-field">
        		<legend>既往史</legend>
                <table class="posttable">
                    <colgroup>
                        <col style="min-width: 100px; width: 16%;"/>
                        <col style="min-width: 140px; width: 16%;"/>
                        <col style="min-width: 130px; width: 16%;"/>
                        <col style="min-width: 130px; width: 16%;"/>
                        <col style="min-width: 130px; width: 16%;"/>
                        <col style="min-width: 130px; width: 20%;"/>
                    </colgroup>
                    <tbody>
                    <tr>
						<td colspan="6">
							<span>以往是否患过血吸虫病:</span>
                        	<ehr:dic-radio name="pastHistory.previousHistory" dicmeta="PH00002" value="${schDto.pastHistory.previousHistory}"
                            	code="2,1" onchange="schcase.toggleHistory()"/>							
						</td>                    
                    </tr>
					<tr id="trPreviousHistory1">
                        <th>发病年份：</th>
                        <td>
                        	<fmt:parseDate value="${schDto.pastHistory.attackYear}" pattern="yyyy" var="date"/>
                        	<%-- <tag:dateInput nullToToday="true" name="pastHistory.attackYear" style="width: 100px;" 
                        		 pattern="yyyy" date='${date}' onlypast="true"></tag:dateInput> --%>
                        	<input type="text"  class="layui-input x-admin-content-sm-date"  name="pastHistory.attackYear" id="pastHistoryAttackYear" value="<fmt:formatDate value='${date}' pattern='yyyy'/>" style="padding-left: 0px;width: 100px;" />
                        </td>					
                        <th>诊断依据：</th>
                        <td colspan="3">
							<input type="checkbox" id="coptCheckId" value="1" name="pastHistory.diagnosisBasis"
                        		<c:if test="${fn:indexOf(schDto.pastHistory.diagnosisBasis, '1') > -1}"> 
                        			checked="checked" 
                        		</c:if> 							
							>
							<label for="coptCheckId">COPT</label>
							<input type="checkbox" id="ihaCheckId" value="2" name="pastHistory.diagnosisBasis"
                        		<c:if test="${fn:indexOf(schDto.pastHistory.diagnosisBasis, '2') > -1}"> 
                        			checked="checked" 
                        		</c:if> 							
							>
							<label for="ihaCheckId">IHA</label>
							<input type="checkbox" id="stoolCheckId" value="3" name="pastHistory.diagnosisBasis"
                        		<c:if test="${fn:indexOf(schDto.pastHistory.diagnosisBasis, '3') > -1}"> 
                        			checked="checked" 
                        		</c:if> 								
							>
							<label for="stoolCheckId">粪便(或活组织)检查</label>
                        </td>
		       		</tr>
					<tr id="trPreviousHistory2">
                        <th>治疗情况:治疗次数</th>
                        <td>
 							<input type="text" name="pastHistory.treatNum" reg='{"maxlength":"2"}' 
                        		value="${schDto.pastHistory.treatNum}" style="width: 100px;"/>  
                        </td>					
                        <th>治疗药物：</th>
                        <td colspan="3">
 							<input type="text" name="pastHistory.bloodFlukesDrug" reg='{"maxlength":"100"}' 
                        		value="${schDto.pastHistory.bloodFlukesDrug}" style="width: 200px;"/>  
						</td>
		       		</tr>
					<tr id="trPreviousHistory3">
                        <th>治疗时间:首次治疗时间</th>
                        <td>
                        	<%-- <tag:dateInput nullToToday="false" name="pastHistory.treatStartDt" style="width: 100px;"
                        		reg='{"regex":"date"}'  pattern="yyyy/MM/dd" date="${schDto.pastHistory.treatStartDt}" onlypast="true"></tag:dateInput> --%>
                        <input type="text" reg='{"regex":"date"}'  class="layui-input x-admin-content-sm-date"  name="pastHistory.treatStartDt" id="pastHistoryTreatStartDt" value="<fmt:formatDate value='${schDto.pastHistory.treatStartDt}' pattern='yyyy/MM/dd'/>" style="padding-left: 0px;width: 100px;" />
                        </td>					
                        <th>末次治疗时间</th>
                        <td colspan="3">
                        	<%-- <tag:dateInput nullToToday="false" name="pastHistory.treatEndDt" style="width: 100px;"
                        		reg='{"regex":"date"}'  pattern="yyyy/MM/dd" date="${schDto.pastHistory.treatEndDt}" onlypast="true"></tag:dateInput> --%>
                        		
                            <input type="text" reg='{"regex":"date"}'  class="layui-input x-admin-content-sm-date"  name="pastHistory.treatEndDt" id="pastHistoryTreatEndDt" value="<fmt:formatDate value='${schDto.pastHistory.treatEndDt}' pattern='yyyy/MM/dd'/>" style="padding-left: 0px;width: 100px;" />
						</td>
		       		</tr>
					<tr id="trPreviousHistory4">
                        <th>治疗单位：</th>
                        <td colspan="5">
							<ehr:org-type-list name="pastHistory.treatUnit" type="hospital,centre"  
								value="${schDto.pastHistory.treatUnit}" width="300px"/>
						</td>					
		       		</tr>			       					       							                   
                    </tbody>
                </table>
            </fieldset> 
        	<fieldset class="layui-elem-field">
        		<legend>居留史</legend>
                <table class="posttable">
                    <colgroup>
                        <col style="min-width: 100px; width: 15%;"/>
                        <col style="min-width: 150px; width: 25%;"/>
                        <col style="min-width: 100px; width: 15%;"/>
                        <col style="min-width: 150px; width: 20%;"/>
                        <col style="min-width: 100px; width: 10%;"/>
                        <col style="min-width: 150px; width: 15%;"/>
                    </colgroup>
                    <tbody>
             			<tr>
             				<th>人员类型：</th>
             				<td>
                        		<ehr:dic-list name="diagnosis.personType" dicmeta="IDM00319" value="${schDto.diagnosis.personType}"
                            		code="1,2,3,4" defaultval="1" />	             				
                            </td>
           					<th>诊断分期：</th>
             				<td colspan="3">
                        		<ehr:dic-list name="diagnosis.transferTreatmentAccording" dicmeta="IDM00275" value="${schDto.diagnosis.transferTreatmentAccording}"
                            		defaultval="4" code="1,2,3,4,5" onchange=""/>	             				
                            </td>                            
                    	</tr>
       					<tr>
             				<th>诊断单位：</th>
             				<td>
								<ehr:org-type-list name="diagnosis.diagnosisUnit" type="other,centre,hospital" value="${schDto.diagnosis.diagnosisUnit}" width="200px" codeOther="${JK_CODE}"/>
                            </td>
           					<th>诊断日期：</th>
             				<td colspan="3">
                       			<%-- <tag:dateInput nullToToday="false" name="diagnosis.diagnosisDt" style="width: 100px;"
                        			reg='{"regex":"date"}'  pattern="yyyy/MM/dd" date="${schDto.diagnosis.diagnosisDt}" onlypast="true"></tag:dateInput> --%>
                        	<input type="text" reg='{"regex":"date"}'  class="layui-input x-admin-content-sm-date"  name="diagnosis.diagnosisDt" id="diagnosisDiagnosisDt" value="<fmt:formatDate value='${schDto.diagnosis.diagnosisDt}' pattern='yyyy/MM/dd'/>" style="padding-left: 0px;width: 100px;" />
                            </td>                            
                    	</tr> 
       					<tr>
			 	            <th><label class="required">填表单位：</label></th><%--需求变更要求可以修改，2014-02-07--%>
				            <td><ehr:org-type-list name="caseInformation.modifySurveyOrg" type="hospital,centre,other"
                                                   value="${schDto.caseInformation.modifySurveyOrg}" reg='{"required":"true"}'/></td>
				        	<th>调查日期：</th>
				            <td>
								<%-- <tag:dateInput nullToToday="false" name="diagnosis.diagnosisDt" style="width: 100px;"
											   reg='{"regex":"date"}'  pattern="yyyy/MM/dd" date="${schDto.diagnosis.diagnosisDt}" onlypast="true"></tag:dateInput> --%>
								<input type="text" reg='{"regex":"date"}'  class="layui-input x-admin-content-sm-date"  name="caseInformation.caseFillDate" id="caseInformationCaseFillDate" value="<fmt:formatDate value='${schDto.caseInformation.caseFillDate}' pattern='yyyy/MM/dd'/>" style="padding-left: 0px;width: 100px;" />
			                </td>
				            <th><label class="required">调查人：</label></th><%--需求变更要求可以修改，2014-02-07--%>
				            <td><input type="text" name="caseInformation.modifyRespondents" reg='{"required":"true","maxlength":"50"}'
                                                                                                 value="${schDto.caseInformation.modifyRespondents}" />  </td>
                    	</tr>                      	                   	
                    </tbody>
            	</table>
            </fieldset>
        </div>
    </div>
</form>
</div>

<script type="text/javascript">

layui.use('laydate', function(){
    var laydate = layui.laydate;
    
    laydate.render({
      elem: '#epidemicFocusCloseFarmDt' 
   	   ,format: 'yyyy/MM/dd'
   	   ,max:0
   	, trigger: 'click' 
    });

    laydate.render({
        elem: '#pastHistoryAttackYear' 
     	   ,type: 'year'
     	   ,max:0,
     	   trigger: 'click' 
      });
    laydate.render({
        elem: '#pastHistoryTreatStartDt' 
        	 ,format: 'yyyy/MM/dd'
     	   ,max:0
     	, trigger: 'click' 
      });
    
    laydate.render({
        elem: '#pastHistoryTreatEndDt' 
        	 ,format: 'yyyy/MM/dd'
     	   ,max:0
     	, trigger: 'click' 
      });
    
    laydate.render({
        elem: '#diagnosisDiagnosisDt' 
        	 ,format: 'yyyy/MM/dd'
     	   ,max:0
     	, trigger: 'click' 
      });
    
    laydate.render({
        elem: '#caseInformationCaseFillDate' 
        	 ,format: 'yyyy/MM/dd'
     	   ,max:0
     	, trigger: 'click' 
      });
    
    
  });
</script>