<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tag" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<script src="${pageContext.request.contextPath}/js/views/idm/case/edit.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/views/idm/case/anthrax.js" type="text/javascript"></script>

<c:if test="${isPrint != 1}">
    <jsp:include page="caseButton.jsp"></jsp:include>
</c:if>
<form id="caseForm">
    <div class="postcontent <c:if test="${isPrint != 1}">contentfixed</c:if>">
		<i class="popno">
		    炭疽个案调查表<br/>
		    <span>（乙类传染病）</span>
		</i>
		<input type="hidden" name="idmId" value="${idmId}" id="idmId"/>
		<table class="posttable">
	        <colgroup>
	            <col style="width: 50%"/>
	            <col style="width: 50%"/>
	        </colgroup>
	        <tr>
	            <td style="text-align: left;">
                         	 国标编码：<input type="text" name="generalCondition.gbcode" value="${caseDto.generalCondition.gbcode}" reg='{"maxlength":"14"}' style="width:120px;"/>
	            </td>
	            <td style="text-align: right;">
                         	 病例编码：<input type="text" name="caseInformation.mediRecordNum" reg='{"maxlength":"14"}' value="${caseDto.caseInformation.mediRecordNum}" style="width:120px;"/>
	            </td>
	        </tr>
	        <tr>       
               <td colspan="4">
				   ${rootDicItem.itemName}<ehr:dic-town-street-village streetId="revillage_address" townId="retown_address" streetName="generalCondition.restreet" townName="generalCondition.retownShip"
																	   streetValue="${caseDto.generalCondition.restreet}" townValue="${caseDto.generalCondition.retownShip}" width="140px;"/>
			   </td>
			</tr>
	    </table>
		<div class="postdiv">
			<fieldset>
			    <legend>1.一般情况</legend>
			    <table class="posttable">
			        <colgroup>
			            <col style="width: 20%"/>
			            <col style="width: 30%"/>
			            <col style="width: 20%"/>
			            <col style="width: 30%"/>
			        </colgroup>
			        <tr>
			            <th>1.1 姓名：</th>
			            <td>
			            	<input type="text" name="generalCondition.name" value="${caseDto.generalCondition.name}" reg='{"maxlength":"100"}'/>
			            </td>
			            <th>1.2 身份证号：</th>
			            <td><input type="text" name="generalCondition.idcard" id="idCard" value="${caseDto.generalCondition.idcard}"
                                   placeholder="输入身份证获取个人信息" reg='{"idCard":"true"}'/>
                        </td>
			        </tr>
			        <tr>
			            <th>1.3 性别：</th>
			            <td>
			            	<ehr:dic-radio name="generalCondition.gender" dicmeta="GBT226112003"
			            	 value="${caseDto.generalCondition.gender}" code="1,2"/>
			            </td>
			            <th>1.4 年龄（岁）：</th>
			            <td>
			            	<input type="text" id="age" name="generalCondition.age" value="${caseDto.generalCondition.age}"
							    maxlength="3" cssClass="width30" style="width: 30%" reg='{"maxlength":"6"}'/>
			            </td>
			        </tr>
			         <tr>
			            <th>1.5 民族：</th>
						<td><ehr:dic-list name="generalCondition.nation" dicmeta="IDM00548" width="180px;"
	                                                         value="${caseDto.generalCondition.nation}"/></td>
			        </tr>
			        <tr>
			            <th>1.6 职业：</th>
			            <td colspan="3">
			            	<ehr:dic-list id="occupationId" dicmeta="GBT6565" name="generalCondition.occupation" width="180px;" value="${caseDto.generalCondition.occupation}"
                                  code="CV020120210,CV020120211,CV020120213,CV020120209,CV020120229,CV020120208,CV020120216,CV020120214,CV020120217"
                                 />
                                 <%--  onchange="toggleOtherSC('generalCondition.occupation','occupationOtherPart','CV020120299');"/> --%>
			            	 <%-- <span  id="occupationOtherPart" style="display: none">
		                         <input type="text" name="generalCondition.occupationOther" value="${caseDto.generalCondition.occupationOther}"
		                                reg='{"maxlength":"30"}' placeholder="若选择其他，请描叙" style="width: 40%;"/>
		                     </span> --%>
			            </td>
			        </tr>
			        <tr>
			            <th>1.7 现居住地：</th>
			            <td colspan="3">
							<ehr:dic-town-street-village streetId="pastreet_address" townId="patown_address" streetName="generalCondition.pastreet" townName="generalCondition.patownShip"
														 streetValue="${caseDto.generalCondition.pastreet}" townValue="${caseDto.generalCondition.patownShip}" width="140px;"
														 villageId="pavillage_address" villageName="generalCondition.paGroup" villageValue="${caseDto.generalCondition.paGroup}"/>
							<input type="text" id="pahouseNumber" name="generalCondition.pahouseNumber" value="${caseDto.generalCondition.pahouseNumber}"
			                        reg='{"maxlength":"50"}'  style="width: 180px;">
			             	<span id="spanPaNumber">(门牌号)</span>
			            </td>
			        </tr>
			        <tr>
			            <th>1.8 联系电话：</th>
			            <td>
			            	<input type="text" name="generalCondition.phoneNumber" value="${caseDto.generalCondition.phoneNumber}"
			            	 reg='{"regex":"phone","maxlength":20}'/>
			            </td>
			            <th>1.9 家长或监护人姓名：</th>
			            <td>
			            	<input type="text" name="generalCondition.parentsName" value="${caseDto.generalCondition.parentsName}" 
							   reg='{"maxlength":"50"}'/>
			            </td>
			        </tr>
			        <tr>
			            <th>1.10 工作或学习单位：</th>
			             <td> <input reg='{"maxlength":"70"}' type="text" name="generalCondition.unitName" value="${caseDto.generalCondition.unitName}"/></td>
			        </tr>
			        
<!-- 			        <tr> -->
<!-- 						<th>常住类型：</th> -->
<!-- 						<td colspan="3"> -->
<%-- 							<ehr:dic-radio dicmeta="FS10005" name="generalCondition.hrPlace"  --%>
<%-- 								value="${'2' != caseDto.generalCondition.hrPlace? '1' : '2'}" onchange="caseEdit.showHrPlace()"/> --%>
<!-- 						</td> -->
<!-- 					</tr> -->
					<tr>
                    	<th>1.11 常住类型：</th>
                    	<td>
		            		<ehr:dic-radio name="generalCondition.floatPopulation" dicmeta="FS10005"
                        		value="${caseDto.generalCondition.floatPopulation}" onchange="caseEdit.toggerAddress()"/>
                    	</td>
                    </tr>
			        <tr>
						<th>1.12 户口所在地：</th>
						<td >
							<input type="text" id="hrAddress" name="generalCondition.hrAddress" value="${caseDto.generalCondition.hrAddress}"
	                           			reg='{"maxlength":"100"}'>
						</td>
					</tr>
					
			        <tr>
			            <th>1.13 初诊时间：</th>
			            <td>
			                <%-- <tag:dateInput id="firstVisitDate"  name="attackCondition.firstVisitDate"  onlypast="true"
			                    reg='{"compare":["pathogenesisDate","ge","首诊时间不能小于发病日期"]}' pattern="yyyy/MM/dd" date="${caseDto.attackCondition.firstVisitDate }"/> --%>
			                    
			                    <input type="text"  class="layui-input x-admin-content-sm-date" id="attackConditionFirstVisitDateId" name="attackCondition.firstVisitDate" style="padding-left: 0px;" value="<fmt:formatDate value='${caseDto.attackCondition.firstVisitDate}' pattern='yyyy/MM/dd'/>" />
			            </td>
			        </tr>
			        <tr>
			            <th>1.14 初诊单位：</th>
			            <td>
			                <input reg='{"maxlength":"100"}' type="text" name="attackCondition.firstVisitUnit" value="${caseDto.attackCondition.firstVisitUnit}"/>
			            </td>
			            <th>1.15 初诊病名：</th>
			             <td>
			                <input reg='{"maxlength":"100"}' type="text" name="attackCondition.firstVisitName" value="${caseDto.attackCondition.firstVisitName}"/>
			            </td>
			        </tr>
			        <tr>
			            <th>1.16 确诊时间：</th>
			            <td>
			            	<%-- <tag:dateInput id="confirmationDate" name="attackCondition.confirmationDate" onlypast="true" pattern="yyyy/MM/dd HH" date="${caseDto.attackCondition.confirmationDate}" reg='{"compare":["firstVisitDate","ge","确诊时间不能小于初诊时间"]}'/> --%>
	                		<input type="text" reg='{"compare":["firstVisitDate","ge","确诊时间不能小于初诊时间"]}'  class="layui-input x-admin-content-sm-date" id="confirmationDate" name="attackCondition.confirmationDate" style="padding-left: 0px;" value="<fmt:formatDate value='${caseDto.attackCondition.confirmationDate}' pattern='yyyy/MM/dd HH'/>" />
			            	时
	                		<input type="hidden" id="confirmationHour" name="attackCondition.confirmationHour"/>
	               		 </td>
			            <th>1.17 确诊单位：</th>
			            <td>
			            	<input reg='{"maxlength":"100"}' type="text" name="attackCondition.confirmationHospital" value="${caseDto.attackCondition.confirmationHospital}"/>
			            </td>
			        </tr>
			        <tr>
			            <th>1.18 入院时间：</th>
			            <td>
			            	<%-- <tag:dateInput id="inhosDate"  name="attackCondition.inhosDate" onlypast="true" pattern="yyyy/MM/dd"
							     reg='{"compare":["outHospitalDate","le","入院时间不能大于出院时间"]}' date="${caseDto.attackCondition.inhosDate}"/> --%>
							     
							  <input type="text" reg='{"compare":["outHospitalDate","le","入院时间不能大于出院时间"]}' class="layui-input x-admin-content-sm-date" id="inhosDate" name="attackCondition.inhosDate" style="padding-left: 0px;" value="<fmt:formatDate value='${caseDto.attackCondition.inhosDate}' pattern='yyyy/MM/dd'/>" />   
			            </td>
			            <th>1.19 所住医院：</th>
			           <td>
			            	<input reg='{"maxlength":"100"}' type="text" name="attackCondition.admissionHospital" value="${caseDto.attackCondition.admissionHospital}"/>
			            </td>
			        </tr>
			        <tr>
			            <th>1.20 出院时间：</th>
			            <td>
			            	<%-- <tag:dateInput id="outHospitalDate"  name="attackCondition.outHospitalDate" onlypast="true" pattern="yyyy/MM/dd"
							     reg='{"compare":["inhosDate","ge","出院时间不能小于入院时间"]}' date="${caseDto.attackCondition.outHospitalDate}"/> --%>
							     
							  <input type="text" reg='{"compare":["inhosDate","ge","出院时间不能小于入院时间"]}' class="layui-input x-admin-content-sm-date" id="outHospitalDate" name="attackCondition.outHospitalDate" style="padding-left: 0px;" value="<fmt:formatDate value='${caseDto.attackCondition.outHospitalDate}' pattern='yyyy/MM/dd'/>" />   
			            </td>
			        </tr>
			         <tr>
			            <th>1.21 发病时间：</th>
			              <td>
			            	<%-- <tag:dateInput id="pathogenesisDate"  name="attackCondition.pathogenesisDate" onlypast="true"
			                    reg='{"compare":["firstVisitDate","le","发病日期不能大于首诊时间"]}' pattern="yyyy/MM/dd" date="${caseDto.attackCondition.pathogenesisDate }"/> --%>
			                  <input type="text" reg='{"compare":["firstVisitDate","le","发病日期不能大于首诊时间"]}' class="layui-input x-admin-content-sm-date" id="pathogenesisDate" name="attackCondition.pathogenesisDate" style="padding-left: 0px;" value="<fmt:formatDate value='${caseDto.attackCondition.pathogenesisDate}' pattern='yyyy/MM/dd'/>" />  
			                    
			            </td>
			            <th>1.22 发病地点：</th>
			             <td>
			            	<input reg='{"maxlength":"100"}' type="text" name="attackCondition.pathogenesisPlace" value="${caseDto.attackCondition.pathogenesisPlace}"/>
			            </td>
			        </tr>
			         <tr>
			            <th>1.23 报告日期：</th>
			           <td>
		                    <%-- <tag:dateInput id="reportDate" name="caseInformation.reportDate" pattern="yyyy/MM/dd" onlypast="true" date="${caseDto.caseInformation.reportDate}"
		                                   reg='{"required":"true"}' style="display:none"/> --%>
		                     <input type="text" reg='{"required":"true"}' class="layui-input x-admin-content-sm-date" id="reportDate" name="caseInformation.reportDate" style="padding-left: 0px;display:none;" value="<fmt:formatDate value='${caseDto.caseInformation.reportDate}' pattern='yyyy/MM/dd'/>" />
		                    <fmt:formatDate pattern="yyyy/MM/dd" value="${caseDto.caseInformation.reportDate}"/>
		                </td>
			            <th>1.24 报告单位：</th>
			           <td>
		                    <ehr:org code="${caseDto.caseInformation.reportOrg}"/>
		                    <%--<input type="text" name="caseInformation.reportOrg" value="${caseDto.caseInformation.reportOrg}" reg='{"maxlength":"200"}'/>--%>
		                    <input type="hidden" name="caseInformation.reportOrg" value="${caseDto.caseInformation.reportOrg}"/>
		                </td>
			        </tr>
			        <tr>
			            <th>1.25 死亡日期：</th>
			            <td><%-- <tag:dateInput name="attackCondition.dieDt" pattern="yyyy/MM/dd" onlypast="true" date="${caseDto.attackCondition.dieDt}"
                              /> --%>
                              <input type="text" class="layui-input x-admin-content-sm-date" id="attackConditionDieDtId" name="attackCondition.dieDt" style="padding-left: 0px;" value="<fmt:formatDate value='${caseDto.attackCondition.dieDt}' pattern='yyyy/MM/dd'/>" />
                              </td>
			        </tr>
			    </table>
			</fieldset>
			<fieldset>
			    <legend>2.临床表现</legend>
			    <table class="posttable">
			        <colgroup>
			            <col style="width: 20%"/>
			            <col style="width: 30%"/>
			            <col style="width: 20%"/>
			            <col style="width: 30%"/>
			        </colgroup>
			        <tr>
			            <th>2.1 表现：</th>
			            <td>
			            	<ehr:dic-radio dicmeta="IDM00174" name="clinicalManifestations.anthraxClinManifOne" value="${caseDto.clinicalManifestations.anthraxClinManifOne}"/>
			            </td>
			            <th>2.2 炭疽痈：</th>
			            <td>
			            	<ehr:dic-radio dicmeta="PH00002" name="clinicalManifestations.anthraxCarb" code="1,2" value="${caseDto.clinicalManifestations.anthraxCarb}"
			            	onchange="toggleOther('clinicalManifestations.anthraxCarb','anthraxCarbNum',1)"/>
			            	<span id="anthraxCarbNum">
			            		个数:<input type="text" name="clinicalManifestations.anthraxCarbNum" value="${caseDto.clinicalManifestations.anthraxCarbNum}"
							    reg='{"maxlength":"20"}' cssClass="width30" style="width: 30%"/>
			            	</span>
			            </td>
			        </tr>
			        <tr>
			            <th>2.3 炭疽痈部位：</th>
			            <td>
			            	<ehr:dic-radio dicmeta="IDM00175" name="clinicalManifestations.anthraxCarbParts" value="${caseDto.clinicalManifestations.anthraxCarbParts}"/>
			            </td>
			            <th>2.4 炭疽痈属于：</th>
			            <td>
			            	<ehr:dic-radio dicmeta="IDM00176" name="clinicalManifestations.anthraxCarbBel" value="${caseDto.clinicalManifestations.anthraxCarbBel}"/>
			            </td>
			        </tr>
			        <tr>
			            <th>2.5 恶性水肿：</th>
			            <td>
			            	<ehr:dic-radio dicmeta="PH00002" code="1,2" name="clinicalManifestations.malEdema" value="${caseDto.clinicalManifestations.malEdema}"
			            	onchange="toggleOther('clinicalManifestations.malEdema','malEdemaParts',1)"/>
			            	<span id="malEdemaParts">
			            		部位：<input reg='{"maxlength":"200"}' type="text" name="clinicalManifestations.malEdemaParts"
			            		 value="${caseDto.clinicalManifestations.malEdemaParts}" style="width: 30%"/>
			            	</span>
			            </td>
			            <th>2.6 胃肠道症状：</th>
			            <td>
			            	<ehr:dic-radio dicmeta="IDM00177" name="clinicalManifestations.anthraxClinManifTwo" value="${caseDto.clinicalManifestations.anthraxClinManifTwo}"/>
			            </td>
			        </tr>
			         <tr>
			            <th>2.7 呼吸道症状：</th>
			            <td colspan="3">
			            	<ehr:dic-radio dicmeta="IDM00178" name="clinicalManifestations.anthraxClinManifThr" value="${caseDto.clinicalManifestations.anthraxClinManifThr}"
			            	onchange="toggleOther('clinicalManifestations.anthraxClinManifThr','bleedingVolume',4)"/>
			            	<span id="bleedingVolume" style="display: none;">
			            		出血量：<input type="text" name="clinicalManifestations.bleedingVolume" value="${caseDto.clinicalManifestations.bleedingVolume}"
							    reg='{"maxlength":"20"}' cssClass="width30" style="width: 80px;"/>ml
			            	</span>
			            </td>
			        </tr>
			        <tr>
			            <th>2.8 呼吸困难：</th>
			            <td><ehr:dic-radio dicmeta="PH00002" code="1,2" name="clinicalManifestations.dyspnea" value="${caseDto.clinicalManifestations.dyspnea}"/></td>
			            <th>2.9 皮肤粘膜发绀：</th>
			            <td><ehr:dic-radio dicmeta="PH00002" code="1,2"  name="clinicalManifestations.skinMucCy" value="${caseDto.clinicalManifestations.skinMucCy}"/></td>
			        </tr>
			        <tr>
			            <th>2.10 最高体温（ ℃）：
		                <td>
		                	<input type="text" name="clinicalManifestations.highestTemperature" value="${caseDto.clinicalManifestations.highestTemperature}" 
			            	 				reg='{"maxlength":"20"}' style="width: 30%;"/>
		                </td>
			            <th>2.11 感染性休克：</th>
			            <td><ehr:dic-radio dicmeta="PH00002" code="1,2"  name="clinicalManifestations.septicStock" value="${caseDto.clinicalManifestations.septicStock}"/></td>
			        </tr>
			        <tr>
			            <th>2.12 临床类型：</th>
			            <td><ehr:dic-radio dicmeta="IDM00179" name="clinicalManifestations.clinicalType" value="${caseDto.clinicalManifestations.clinicalType}"/></td>
			            <th>2.13 转归：</th>
			            <td>
			            	<ehr:dic-radio name="otherCondition.outcomeCode" dicmeta="CV550102" code="1,4" 
			            	value="${caseDto.otherCondition.outcomeCode}"/>
			            </td>
			        </tr>
			    </table>
			</fieldset>
			<fieldset>
			    <legend>3.流行病学调查和处理</legend>
			    <table class="posttable">
			        <colgroup>
			            <col style="width: 20%"/>
			            <col style="width: 30%"/>
			            <col style="width: 20%"/>
			            <col style="width: 30%"/>
			        </colgroup>
			        <tr>
			            <th>3.1 外出史：</th>
			            <td colspan="3"><input reg='{"maxlength":"200"}' type="text" name="epidemiologicalSurvey.outHistoryAddr" value="${caseDto.epidemiologicalSurvey.outHistoryAddr}"/></td>
			        </tr>
			        <tr>
			            <th>3.2 可疑接触史：</th>
			            <td colspan="3"><input reg='{"maxlength":"50"}' type="text" name="epidemiologicalSurvey.contactPatientName" value="${caseDto.epidemiologicalSurvey.contactPatientName}"/></td>
			        </tr>
			        <tr>
			            <th>3.3 消毒和处理情况：</th>
			            <td><ehr:dic-radio dicmeta="IDM00180" name="epidemiologicalSurvey.disinfectTreatment" value="${caseDto.epidemiologicalSurvey.disinfectTreatment}"/></td>
			            <th>3.4 死尸处理：</th>
			            <td><ehr:dic-radio dicmeta="IDM00181" name="epidemiologicalSurvey.corpseTreatment" value="${caseDto.epidemiologicalSurvey.corpseTreatment}"/></td>
			        </tr>
			        <tr>
			            <th>3.5在本疫点病例发病时间顺序：</th>
			            <td>
			            	第<input type="text" name="epidemiologicalSurvey.dysenteryDtOrder" value="${caseDto.epidemiologicalSurvey.dysenteryDtOrder}" 
							    reg='{"maxlength":"20"}' cssClass="width30" style="width: 30%"/>例
			            </td>
			            <th>3.6 既往炭疽病史：</th>
			            <td>
			            	<ehr:dic-radio dicmeta="PH00002" code="1,2" name="epidemiologicalSurvey.anthrax" value="${caseDto.epidemiologicalSurvey.anthrax}"
			            	onchange="toggleOther('epidemiologicalSurvey.anthrax','anthraxDt',1)"/>
			            	<span id="anthraxDt" style="display:none;">
			            		<tag:dateInput  name="epidemiologicalSurvey.anthraxDt" onlypast="true"
	                               pattern="yyyy/MM/dd" date="${caseDto.epidemiologicalSurvey.anthraxDt}" style="width:50%;"/>
			            	</span>
			             </td>
			        </tr>
			        <tr>
			             <th>3.7 炭疽菌苗接种史：</th>
			            <td colspan="3">
			            	<ehr:dic-radio dicmeta="PH00002" code="1,2" name="epidemiologicalSurvey.anthraxVaccination" value="${caseDto.epidemiologicalSurvey.anthraxVaccination}"
			            	onchange="toggleOther('epidemiologicalSurvey.anthraxVaccination','anthraxVaccinationDt',1)"/>
			            	<span id="anthraxVaccinationDt" style="display:none;">
			            		<tag:dateInput  name="epidemiologicalSurvey.anthraxVaccinationDt" onlypast="true"
	                               pattern="yyyy/MM/dd" date="${caseDto.epidemiologicalSurvey.anthraxVaccinationDt}" style="width:20%;"/>
			            	</span>
			            </td>
			        </tr>
			    </table>
			</fieldset>
			<fieldset>
			    <legend>4.判断</legend>
			    <table class="posttable">
			        <colgroup>
			            <col style="width: 20%"/>
			            <col style="width: 80%"/>
			        </colgroup>
			        <tr>
			            <th>4.1 可能感染来源：</th>
			            <td><ehr:dic-radio dicmeta="IDM00182" name="otherCondition.sourceInfection" value="${caseDto.otherCondition.sourceInfection}"/></td>
			        </tr>
			        <tr>
			            <th>4.2 可能感染方式：</th>
			            <td><ehr:dic-radio dicmeta="IDM00183" name="otherCondition.modeInfection" value="${caseDto.otherCondition.modeInfection}"/></td>
			        </tr>
			    </table>
			</fieldset>
			<fieldset>
			    <legend>5.其它处理措施</legend>
			    <table class="posttable">
			        <tr>
			            <td>
			                <textarea name="otherCondition.treatmentMeasures" style="width: 100%"  reg='{"maxlength":"50"}'>${caseDto.otherCondition.treatmentMeasures}</textarea>
			            </td>
			        </tr>
			    </table>
			</fieldset>
			<fieldset>
			    <legend>6.小结</legend>
			    <table class="posttable">
			        <tr>
			            <td>
                            <textarea name="otherCondition.surveySummary" style="width: 100%" rows="5"  reg='{"maxlength":"800"}'>${caseDto.otherCondition.surveySummary}</textarea>
                         </td>
			        </tr>
			    </table>
			</fieldset>
			 <fieldset>
                <table class="posttable">
                   <colgroup>
			            <col style="width: 20%"/>
			            <col style="width: 30%"/>
			            <col style="width: 20%"/>
			            <col style="width: 30%"/>
			        </colgroup>
                    <tr>
                        <th>调查者单位：</th>
                        <td>
                        	<ehr:org code="${caseDto.caseInformation.modifySurveyOrg}"/>
                        	<input type="hidden" name="caseInformation.modifySurveyOrg" value="${caseDto.caseInformation.modifySurveyOrg}"/>
                        </td>
                        <th>调查者：</th>
                        <td><ehr:user userCode="${caseDto.caseInformation.modifyRespondents}"/>
                        	<input type="hidden" name="caseInformation.modifyRespondents" value="${caseDto.caseInformation.modifyRespondents}"/>
                        </td>
                    </tr>
                    <tr>
                        <th>审查者：</th>
                        <td><ehr:user userCode="${caseDto.caseInformation.auditor}"/>
                        	<input type="hidden" name="caseInformation.auditor" value="${caseDto.caseInformation.auditor}"/>
                        </td>
                        <th>调查时间：</th>
                        <td>
                        <tag:dateInput nullToToday="true" name="caseInformation.modifySurveyDate" onlypast="true"
	                               pattern="yyyy/MM/dd" date="${caseDto.caseInformation.modifySurveyDate}"/>
	                    </td>
                    </tr>
                </table>
            </fieldset>
		</div>
	</div>
</form>

<script type="text/javascript">
    layui.use('laydate', function() {
        var laydate = layui.laydate;
        
        laydate.render({
            elem: '#attackConditionFirstVisitDateId'
            	,format:'yyyy/MM/dd'
         	   ,max:0
         	  , trigger: 'click'
          });
        
        
        laydate.render({
            elem: '#caseInformationReportDateId'
            	,type:'datetime'
            	,format:'yyyy/MM/dd HH'
            		, trigger: 'click'
          });
        
        
        laydate.render({
            elem: '#pathogenesisDate'
            	,format:'yyyy/MM/dd'
         	   ,max:0
         	  , trigger: 'click'
          });
        
        laydate.render({
            elem: '#firstVisitDate'
            	,format:'yyyy/MM/dd'
         	   ,max:0
         	  , trigger: 'click'
          });
        
        laydate.render({
            elem: '#pastHistoryInfluenzaVaccineDateId'
            	,format:'yyyy/MM/dd'
         	  , max:0
         	 , trigger: 'click'
          });
        
        laydate.render({
            elem: '#pastHistoryPnuImuneDateId'
            	,format:'yyyy/MM/dd'
         	  , max:0
         	 , trigger: 'click'
          });
        
        laydate.render({
            elem: '#attackConditionTakeTamifluStartId'
            	,format:'yyyy/MM/dd'
         	  , max:0
         	 , trigger: 'click'
          });
        
        laydate.render({
            elem: '#takeTamifluLast'
            	,format:'yyyy/MM/dd'
         	  , max:0
         	 , trigger: 'click'
          });
        
        laydate.render({
            elem: '#exposureDtFirst'
            	,format:'yyyy/MM/dd'
         	  , max:0
          });
        
        laydate.render({
            elem: '#exposureDtLast'
            	,format:'yyyy/MM/dd'
         	  , max:0
         	 , trigger: 'click'
          });
        
        laydate.render({
            elem: '#diagnosisDoubtfulDtId'
            	,format:'yyyy/MM/dd'
         	  , max:0
         	 , trigger: 'click'
          });
        
        laydate.render({
            elem: '#diagnosisDiagnosisDtId'
            	,format:'yyyy/MM/dd'
         	  , max:0
         	 , trigger: 'click'
          });
        
        laydate.render({
            elem: '#excludeDtT'
            	,format:'yyyy/MM/dd'
         	  , max:0
         	 , trigger: 'click'
          });
        
        laydate.render({
            elem: '#otherConditionDeathTimeId'
            	,format:'yyyy/MM/dd'
         	  , max:0
         	 , trigger: 'click'
          });
        
        laydate.render({
            elem: '#inhosTime'
            	,format:'yyyy/MM/dd'
         	  , max:0
         	 , trigger: 'click'
          });
        
        laydate.render({
            elem: '#outhosDate'
            	,format:'yyyy/MM/dd'
         	  , max:0
         	 , trigger: 'click'
          });
        
        laydate.render({
            elem: '#caseInformationModifySurveyDateId'
            	,format:'yyyy/MM/dd'
         	  , max:0
         	 , trigger: 'click'
          });
        
        laydate.render({
            elem: '#otherConditionCureDateId'
            	,format:'yyyy/MM/dd'
         	  , max:0
         	 , trigger: 'click'
          });
        
        
      });

    </script>