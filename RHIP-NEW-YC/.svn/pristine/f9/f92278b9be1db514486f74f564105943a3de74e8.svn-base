﻿<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tag" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<script src="${pageContext.request.contextPath}/js/views/idm/case/edit.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/views/idm/case/cholera.js" type="text/javascript"></script>

<c:if test="${isPrint != 1}">
    <jsp:include page="../caseButton.jsp"></jsp:include>
</c:if>
<form id="caseForm">
    <div class="postcontent <c:if test="${isPrint != 1}">contentfixed</c:if>">
		<i class="popno">
		    霍乱个案调查表<br/>
		    <span>（甲类传染病）</span>
		</i>
		<input type="hidden" id="idmId" name="idmId" value="${idmId}"/>
		<input type="hidden" name="caseInformation.reportDiseases" value="cholera" id="reportDiseasesId"/>
		<input type="hidden" name="efcList" id="efcList">
		<input type="hidden" name="bddList" id="bddList">
		<div class="postdiv">
			    <table class="posttable">
			        <colgroup>
			            <col style="width: 50%"/>
			            <col style="width: 50%"/>
			        </colgroup>
			        <tr>
			            <td style="text-align: left;">
                            地区国标编码：<input type="text" name="generalCondition.gbcode" value="${caseDto.generalCondition.gbcode}" reg='{"maxlength":"14"}' style="width:180px;"/>
			            </td>
			            <td style="text-align: right;">
                            病例编码：<input type="text" name="caseInformation.mediRecordNum" reg='{"maxlength":"14"}' value="${caseDto.caseInformation.mediRecordNum}" style="width:180px;"/>
			            </td>
			        </tr>
			    </table>
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
			            <td colspan="3">
			            	<input type="text" name="generalCondition.name" value="${caseDto.generalCondition.name}" 
			            	 style="width: 20%" reg='{"maxlength":"100"}'/>
				                                           若为14岁以下儿童，家长姓名
				            <input type="text" name="generalCondition.parentsName" value="${caseDto.generalCondition.parentsName}" 
				             style="width: 20%" reg='{"maxlength":"50"}'/>
			            </td>
			        </tr>
			        <tr>
			            <th>1.2 性别：</th>
			            <td>
			               <ehr:dic-radio dicmeta="GBT226112003" name="generalCondition.gender" code="1,2" value="${caseDto.generalCondition.gender}"/>
			            </td>
			            <th>1.3 年龄：</th>
			            <td>
                            <tag:numberInput id="age" name="generalCondition.age" value="${caseDto.generalCondition.age}"
                                             maxlength="3" cssClass="width30" style="width: 10%"/>
				                <ehr:dic-radio dicmeta="IDM00003" name="generalCondition.ageUnit" code="1,2" value="${caseDto.generalCondition.ageUnit}"/>
			        </tr>
			        <tr>
			            <th>1.4 职业：</th>
			            <td>
			            	<ehr:dic-list dicmeta="GBT6565" name="generalCondition.occupation" width="180px;" value="${caseDto.generalCondition.occupation}"
                                  code="CV020120201,CV020120202,CV020120203,CV020120204,CV020120205,4-3,CV020120226,2-15,CV020120208,CV020120209,CV020120210,CV020120212,CV020120213,CV020120207,CV020120227,CV020120214,CV020120215,CV020120216,CV020120299,CV020120217"
                                  onchange="toggleOtherSC('generalCondition.occupation','occupationPart','CV020120299');"/>
			            	 <span  id="occupationPart" style="display: none">
		                         <input type="text" name="generalCondition.occupationOther" value="${caseDto.generalCondition.occupationOther}"
		                                reg='{"maxlength":"30"}' placeholder="若选择其他，请描叙" style="width: 30%;"/>
		                     </span>
			            </td>
			            <th>1.5 文化程度：</th>
			            <td>
			                <ehr:dic-list dicmeta="GBT46582006" code="IDM06,IDM09,IDM07,IDM02,IDM03,IDM08,IDM10" name="generalCondition.education" value="${caseDto.generalCondition.education}"/>
			            </td>
			        </tr>
			        <tr>
				       	<th>常住类型：</th>
				       	<td>
				 		<ehr:dic-radio name="generalCondition.floatPopulation" dicmeta="FS10005"
				           		value="${caseDto.generalCondition.floatPopulation}" onchange="caseEdit.toggerAddress()"/>
				       	</td>
			       </tr>
			        <tr>
			            <th>1.6 现住址：</th>
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
						<th>户籍地址：</th>
						<td colspan="2">
							<input type="text" id="hrAddress" name="generalCondition.hrAddress" value="${caseDto.generalCondition.hrAddress}"
                           			reg='{"maxlength":"100"}'  >
			             </td>
					</tr>
			        <tr>
			            <th>1.7 工作（学习）单位：</th>
			            <td colspan="2">
			                <input reg='{"maxlength":"70"}' type="text" name="generalCondition.unitName" value="${caseDto.generalCondition.unitName}"/>
			            </td>
			        </tr>
			        <tr>
			            <th>1.8 联系人：</th>
			            <td colspan="3">
			                 <input type="text" name="generalCondition.contactName" value="${caseDto.generalCondition.contactName}" reg='{"maxlength":50}' style="width: 20%"/>
			                     联系电话（办）<input type="text" name="generalCondition.unitPhone" value="${caseDto.generalCondition.unitPhone}" reg='{"regex":"phone","maxlength":20}' style="width: 15%"/>
			               	（宅）<input type="text" name="generalCondition.familyPhone" value="${caseDto.generalCondition.familyPhone}" reg='{"regex":"phone","maxlength":20}' style="width: 15%"/>
			                （手机）<input type="text" name="generalCondition.mobile" value="${caseDto.generalCondition.mobile}" reg='{"regex":"mobile","maxlength":20}' style="width: 15%"/>
			            </td>
			        </tr>
			    </table>
			</fieldset>
			<fieldset>
			    <legend>2.发病情况</legend>
			    <table class="posttable">
			        <colgroup>
			            <col style="width: 20%"/>
			            <col style="width: 30%"/>
			            <col style="width: 20%"/>
			            <col style="width: 30%"/>
			        </colgroup>
			        <tr>
			            <th>2.1 发病日期：</th>
			            <td>
			            	<tag:dateInput id="pathogenesisDate" nullToToday="true" name="attackCondition.pathogenesisDate" onlypast="true"
			                    reg='{"compare":["firstVisitDate","le","发病日期不能大于首诊时间"]}' pattern="yyyy/MM/dd" date="${caseDto.attackCondition.pathogenesisDate }"/>
			            </td>
			             <th>2.2 发病地点：</th>
			            <td>
			                <input reg='{"maxlength":"100"}' type="text" name="attackCondition.pathogenesisPlace" value="${caseDto.attackCondition.pathogenesisPlace}"/>
			            </td>
			        </tr>
			        <tr>
			            <th>2.3 首诊时间：</th>
			            <td>
			                <tag:dateInput id="firstVisitDate" nullToToday="true" name="attackCondition.firstVisitDate"  onlypast="true"
			                    reg='{"compare":["pathogenesisDate","ge","首诊时间不能小于发病日期"]}' pattern="yyyy/MM/dd" date="${caseDto.attackCondition.firstVisitDate }"/>
			            </td>
			            <th>2.4 首诊单位：</th>
			            <td>
			                <input reg='{"maxlength":"100"}' type="text" name="attackCondition.firstVisitUnit" value="${caseDto.attackCondition.firstVisitUnit}"/>
			            </td>
			        </tr>
			        <tr>
			            <th>2.5 诊断医院：</th>
			            <td>
			                <input reg='{"maxlength":"100"}' type="text" name="attackCondition.confirmationHospital" value="${caseDto.attackCondition.confirmationHospital}"/>
			            </td>
			            <th>2.6 报告时间：</th>
			            <td>
			            	<ehr:tip><fmt:formatDate pattern="yyyy/MM/dd" value="${caseDto.caseInformation.reportDate }"/></ehr:tip>
                            <tag:dateInput nullToToday="true" name="caseInformation.reportDate" onlypast="true" pattern="yyyy/MM/dd"
                                           date="${caseDto.caseInformation.reportDate}" style="display: none" />
			            </td>
			        </tr>
			        <tr>
			            <th>2.7 是否住院：</th>
			            <td>
			            	<ehr:dic-radio dicmeta="PH00001" name="otherCondition.inpatientFlg" code="1,2" value="${caseDto.otherCondition.inpatientFlg}"
				            	onchange="toggleOther('otherCondition.inpatientFlg','inpatientFlgTd',1)"/>
			            </td>
			        </tr>
			        <tr style="display: none;" id="inpatientFlgTd">
			        	<td colspan="4" style="padding: 0px;">
			        		<table>
			        			<colgroup>
						            <col style="width: 20%"/>
						            <col style="width: 30%"/>
						            <col style="width: 20%"/>
						            <col style="width: 30%"/>
						        </colgroup>
			        			<tr>
			        			   <th>2.7.1 住院时间：</th>
						           <td>
							           <tag:dateInput id="inhosTime" name="otherCondition.inhosTime" onlypast="true" pattern="yyyy/MM/dd"
							            	reg='{"compare":["pathogenesisDate","ge","住院时间不能小于发病日期"]}' date="${caseDto.otherCondition.inhosTime}"/>
							       </td>
						           
						           <th>2.7.2 出院时间：</th>
						           <td>
						                <tag:dateInput name="otherCondition.outhosDate" onlypast="true" pattern="yyyy/MM/dd"
					             			reg='{"compare":["inhosTime","ge","出院时间不能小于 住院时间"]}' date="${caseDto.otherCondition.outhosDate}"/>
					             </td>
					             </tr>
			        		</table>
			        	</td>
				    </tr>
				    <tr>
			            <th>2.8 出院依据：</th>
			            <td>
			            	<ehr:dic-radio dicmeta="IDM00614" name="otherCondition.outhosBasis" value="${caseDto.otherCondition.outhosBasis}"
				            	onchange="toggleOther('otherCondition.outhosBasis','outhosBasis',99)"/>
				            	<span style="display: none;" id="outhosBasis">
				            		<input reg='{"maxlength":"100"}' type="text" name="otherCondition.outhosBasisOther" value="${caseDto.otherCondition.outhosBasisOther}"/>			          
				            	</span>
			            </td>
			        </tr>
			    </table>
			</fieldset>
			<fieldset>
			    <legend>3.临床资料</legend>
			    <table class="posttable">
			        <colgroup>
			            <col style="width: 20%"/>
			            <col style="width: 30%"/>
			            <col style="width: 20%"/>
			            <col style="width: 30%"/>
			        </colgroup>
			         <tr>
			            <th>3.1临床症状</th>
			        </tr>
			        <tr>
			            <th>3.1.1 腹泻：</th>
			            <td>
							<ehr:dic-radio dicmeta="PH00002" code="1,2"  name="clinicalManifestations.diarrhea" value="${caseDto.clinicalManifestations.diarrhea}"
                                           onchange="toggleOther('clinicalManifestations.diarrhea','diarrheaForAdd',1)"/>
			            </td>
			        </tr>
                    <tr style="display: none;" id="diarrheaForAdd">
                        <td colspan="4" style="padding: 0px;">
                            <table>
                                <colgroup>
                                    <col style="width: 20%"/>
                                    <col style="width: 30%"/>
                                    <col style="width: 20%"/>
                                    <col style="width: 30%"/>
                                </colgroup>
                                <tr>
                                    <th>3.1.2 腹泻持续：</th>
                                    <td>
                                        <input type="text" id="diarrhoeaDays"
                                               name="clinicalManifestations.diarrhoeaDays"
                                               value="${caseDto.clinicalManifestations.diarrhoeaDays}"
                                               reg='{"maxlength":"20"}' cssClass="width30" style="width: 10%"/> 天
                                    </td>
                                </tr>
                                <tr>
                                    <th>3.1.3 每天最多泻：</th>
                                    <td>
                                        <input type="text" name="clinicalManifestations.diarrheaDailyTimes"
                                               value="${caseDto.clinicalManifestations.diarrheaDailyTimes}"
                                               reg='{"maxlength":"20"}' cssClass="width30" style="width: 10%"/>次
                                    </td>
                                    <th>3.1.4 腹泻方式：</th>
                                    <td>
                                        <ehr:dic-list dicmeta="IDM00026"
                                                      name="clinicalManifestations.conditionDefecation"
                                                      value="${caseDto.clinicalManifestations.conditionDefecation}" code="2,3,4,5"/>
                                    </td>
                                </tr>
                                <tr>
                                    <th>3.1.5 粪便性状：</th>
                                    <td>
                                        <ehr:dic-list dicmeta="IDM00025" uninclude="5,6,9"
                                                      name="clinicalManifestations.stoolProperty"
                                                      value="${caseDto.clinicalManifestations.stoolProperty}"/>
                                    </td>
                                    <th>3.1.6 粪便量：</th>
                                    <td>
                                        <ehr:dic-radio dicmeta="PH00011" name="clinicalManifestations.diarrheaVariable"
                                                       value="${caseDto.clinicalManifestations.diarrheaVariable}"/>
                                    </td>
                                </tr>
                            </table>
                        </td>
                    </tr>
			        <tr>
			            <th>3.1.7 呕吐：</th>
			            <td>
			            	<ehr:dic-radio dicmeta="PH00002" name="clinicalManifestations.vomit"
			            	 code="1,2" value="${caseDto.clinicalManifestations.vomit}"
                             onchange="toggleOther('clinicalManifestations.vomit','vomitForAdd',1)"/>
			            </td>
                    </tr>
                    <tr style="display: none;" id="vomitForAdd">
                        <td colspan="4" style="padding: 0px;">
                            <table>
                                <colgroup>
                                    <col style="width: 20%"/>
                                    <col style="width: 30%"/>
                                    <col style="width: 20%"/>
                                    <col style="width: 30%"/>
                                </colgroup>
                                <tr>
                                    <th>3.1.8 呕吐持续：</th>
                                    <td>
                                        <input type="text" name="clinicalManifestations.vomitDays"
                                               value="${caseDto.clinicalManifestations.vomitDays}"
                                               reg='{"maxlength":"20"}' cssClass="width30" style="width: 10%"/> 天
                                    </td>
                                </tr>
                                <tr>
                                    <th>3.1.9 每天最多吐：</th>
                                    <td>
                                        <input type="text" name="clinicalManifestations.vomitTimes"
                                               value="${caseDto.clinicalManifestations.vomitTimes}"
                                               reg='{"maxlength":"20"}' cssClass="width30" style="width: 10%"/>次
                                    </td>
                                   <%--  <th>3.10 呕吐物性状：</th>
                                    <td>
                                        <ehr:dic-radio dicmeta="IDM00027" name="clinicalManifestations.vomitCharacter"
                                                       value="${caseDto.clinicalManifestations.vomitCharacter}"/>
                                    </td> --%>
                                    <th>3.1.10 呕吐方式：</th>
                                    <td>
                                        <ehr:dic-radio name="clinicalManifestations.vomitWay" dicmeta="IDM00616" value="${caseDto.clinicalManifestations.vomitWay}"/>
                                    </td> 
                                </tr>

                                <tr>
                                    <th>3.1.11 呕吐量：</th>
                                    <td>
                                        <ehr:dic-radio dicmeta="PH00011" name="clinicalManifestations.vomitingQuantity"
                                                       value="${caseDto.clinicalManifestations.vomitingQuantity}"/>
                                    </td>
                                </tr>
                            </table>
                        </td>
                    </tr>
                    <tr>
			            <th>3.1.12 其他：</th>
			            <td>
							<ehr:dic-radio dicmeta="IDM00107" name="clinicalManifestations.otherSelect" value="${caseDto.clinicalManifestations.otherSelect}"/>
			            </td>
			        </tr>
			        <tr>
			            <th>3.1.13 失水情况：</th>
			            <td>
							<ehr:dic-radio dicmeta="IDM00031" uninclude="4" name="clinicalManifestations.waterLossSituation" value="${caseDto.clinicalManifestations.waterLossSituation}"/>
			            </td>
			            <th>3.1.14 临床类型：</th>
			            <td>
			            	<ehr:dic-radio dicmeta="IDM00032" name="clinicalManifestations.clinicalTypeLevel" value="${caseDto.clinicalManifestations.clinicalTypeLevel}" code="1,2,3"/>
			            </td>
			        </tr>
			        <tr>
			            <th>3.1.15 感染类型：</th>
			            <td>
							<ehr:dic-radio dicmeta="IDM00615"  name="otherCondition.infectionType" value="${caseDto.otherCondition.infectionType}"/>
			            </td>	          
			        </tr>
			        <tr>
                        <th>3.1.16 发热：</th>
                        <td colspan="3">
                            <ehr:dic-radio name="clinicalManifestations.fever" dicmeta="PH00002" code="1,2" value="${caseDto.clinicalManifestations.fever}"
                                    onchange="toggleOther('clinicalManifestations.fever','feverPart',1);"/>
                            <br>
                            <div id="feverPart" style="display: none">
                                最高体温<input type="text" name="clinicalManifestations.highestTemperature" style="width: 80px;"
                                       value="${caseDto.clinicalManifestations.highestTemperature}" reg='{"maxlength":"20"}'/>℃
                            </div>
                        </td>
                    </tr>
                    <tr>
						<th>3.1.17 腓肠肌疼痛 ：</th>
						<td><ehr:dic-radio dicmeta="PH00002"
								name="clinicalManifestations.gastrocnemiusPain"
								value="${caseDto.clinicalManifestations.gastrocnemiusPain }"
								code="1,2"></ehr:dic-radio></td>		
					</tr>
					 <tr>
			            <th>3.2诊断依据状</th>
			        </tr>
					<tr>
                        <th>3.2.1感染者发现方式：</th>
                        <td colspan="3">
                            <ehr:dic-radio name="clinicalManifestations.fxFounder" dicmeta="IDM00573"
                                           value="${caseDto.clinicalManifestations.fxFounder}"  onchange="toggleOther('clinicalManifestations.fxFounder','fxFounder','99')"/>
						     <span id="fxFounder" style="display: none;">
                            <input type="text" name="clinicalManifestations.fxOther"
                                   value="${caseDto.clinicalManifestations.fxOther}" style="width: 80px;" reg='{"maxlength":"100"}'/></span>
                        </td>
                    </tr>
                    <tr>
                        <th>3.2.2确诊依据：</th>
                        <td>
                            <ehr:dic-radio name="clinicalManifestations.fxBasis" dicmeta="IDM00106"
                                           value="${caseDto.clinicalManifestations.fxBasis}" />
                        </td>
                    </tr>
                    <tr>
                        <th>3.2.3采样时间：</th>
                        <td>
                            <tag:dateInput name="clinicalManifestations.fxSampleDate" onlypast="true" pattern="yyyy/MM/dd" date="${caseDto.clinicalManifestations.fxSampleDate}" style="width:100px;" />
                        </td>
                         <th>3.2.4送检时间：</th>
                        <td>
                            <tag:dateInput name="labExamine.firstSerumRecentDate" onlypast="true" pattern="yyyy/MM/dd" date="${caseDto.labExamine.firstSerumRecentDate}" style="width:100px;" />
                        </td>
                    </tr> 
			        <tr>
                       
                        <th>3.2.5送样单位：</th>
                        <td colspan="3">
                              <ehr:dic-radio name="labExamine.testUser" dicmeta="IDM00617"
                                           value="${caseDto.labExamine.testUser}" />
                        </td>
                    </tr>
			        <tr>
						<th>3.2.6检验结果报告日期：</th>
						<td><tag:dateInput name="labExamine.seconedSerumResultDate"
								date="${caseDto.labExamine.seconedSerumResultDate }"
								pattern="yyyy/MM/dd" /></td>
						<th>3.2.7检验结果：</th>
						<td><ehr:dic-list dicmeta="IDM00108" code="1,2,4" name="diagnosis.etiologyCategory" value="${caseDto.diagnosis.etiologyCategory}"/>
						</td>
					</tr>					 
					<tr>
                        <th>3.3病人转归</th>
                        <td>
                           <ehr:dic-radio name="otherCondition.outcomeCode" dicmeta="IDM00005" code="1,4,5"
            								value="${caseDto.otherCondition.outcomeCode}"/>
                        </td>
                    </tr>
					
			    </table>
			</fieldset>
			<fieldset>
			    <legend>4．流行病学调查</legend>
			    <table class="posttable">
			        <colgroup>
			            <col style="width: 27%"/>
			            <col style="width: 23%"/>
			            <col style="width: 25%"/>
			            <col style="width: 25%"/>
			        </colgroup>
			        <tr>
			            <th>4.1 传染源和传播途径的追溯（病前1 个月）：</th>
			        </tr>
			        <tr>
			            <th>4.1.1 外出史：</th>
			            <td>
			            	<ehr:dic-radio dicmeta="PH00002" name="epidemiologicalSurvey.outHistory" code="1,2" value="${caseDto.epidemiologicalSurvey.outHistory}"
			            		onchange="toggleOther('epidemiologicalSurvey.outHistory','outHistoryTd',1)"/>
			            </td>
			        </tr>
			         <tr style="display: none;" id="outHistoryTd">
			         	 <td colspan="4" style="padding: 0px;">
				        	<table>
			        			<colgroup>
						            <col style="width: 27%"/>
						            <col style="width: 23%"/>
						            <col style="width: 25%"/>
						            <col style="width: 25%"/>
						        </colgroup>
			        			<tr>
			        			    <th>4.1.1.1 去过何地：</th>
		             				<td colspan="3"><input reg='{"maxlength":"200"}' type="text" name="epidemiologicalSurvey.outHistoryAddr" value="${caseDto.epidemiologicalSurvey.outHistoryAddr}"/></td>
					             </tr>
					             <tr>
						            <th>4.1.1.2 在该地有无下列活动：</th>
						        </tr>
						        <tr>
						            <th>住宿：</th>
						            <td><ehr:dic-radio dicmeta="PH00002" name="infectionSourceRoute.live" code="1,2" value="${caseDto.infectionSourceRoute.live}"/></td>
						       		<th>用餐：</th>
			            			<td><ehr:dic-radio dicmeta="PH00002" name="infectionSourceRoute.diner" code="1,2" value="${caseDto.infectionSourceRoute.diner}"/></td>
						        </tr>
						        <tr>
						            <th>带回食品：</th>
						            <td colspan="3">
						            	<ehr:dic-radio dicmeta="PH00002" name="infectionSourceRoute.outBackFood" code="1,2"
						            		value="${caseDto.infectionSourceRoute.outBackFood}" onchange="toggleOther('infectionSourceRoute.outBackFood','outBackFoodName','1');"/>
						            		<span id="outBackFoodName" style="${caseDto.infectionSourceRoute.strangerBackFood == '1' ? '' : 'display: none;'}">
						            			食品名称:<input type="text" name="infectionSourceRoute.outBackFoodName" value="${caseDto.infectionSourceRoute.outBackFoodName}" reg='{"maxlength":"100"}' style="width:180px;"/>
						            		</span>
						            </td>
						        </tr>
						        <tr>
						            <th> 该地同样疾病：</th>
						            <td><ehr:dic-radio dicmeta="PH00002" name="infectionSourceRoute.outSameDisease" code="1,2" value="${caseDto.infectionSourceRoute.outSameDisease}"/></td>
						        </tr>
			        		</table>
			        	</td>
				    </tr>
				     <tr>
			            <th>4.1.2 外人来家：</th>
			            <td>
			            	<ehr:dic-radio dicmeta="PH00002" name="infectionSourceRoute.stranger" code="1,2" value="${caseDto.infectionSourceRoute.stranger}"
			            		onchange="toggleOther('infectionSourceRoute.stranger','strangerFromAddrd',1);"/>
			            </td>
			        </tr>
					<tbody id="strangerFromAddrd">
			        <tr >
			            <th>4.1.2.1 来自何地：</th>
			            <td><input type="text" name="infectionSourceRoute.strangerFromAddr" value="${caseDto.infectionSourceRoute.strangerFromAddr}" reg='{"maxlength":"100"}'/></td>
			            <th>4.1.2.2 该地同样疾病：</th>
			            <td><ehr:dic-radio dicmeta="PH00002" name="infectionSourceRoute.strangerSameDisease" code="1,2" value="${caseDto.infectionSourceRoute.strangerSameDisease}"/></td>
			        </tr>
					<tr >
						<th>4.1.2.3 在家住宿：</th>
						<td><ehr:dic-radio dicmeta="PH00002" name="infectionSourceRoute.strangerLive" code="1,2" value="${caseDto.infectionSourceRoute.strangerLive}"/></td>
						<th>4.1.2.4 在家用餐：</th>
						<td><ehr:dic-radio dicmeta="PH00002" name="infectionSourceRoute.strangerDiner" code="1,2" value="${caseDto.infectionSourceRoute.strangerDiner}"/></td>
					</tr>
					<tr >
						<th>4.1.2.5 带来了食物：</th>
						<td colspan="3"> <ehr:dic-radio dicmeta="PH00002" name="infectionSourceRoute.strangerBackFood" code="1,2" value="${caseDto.infectionSourceRoute.strangerBackFood}"
														onchange="toggleOther('infectionSourceRoute.strangerBackFood','strangerFoodName1',1);"/>
						<span id="strangerFoodName1">食物名称:<input type="text" name="infectionSourceRoute.strangerFoodName" value="${caseDto.infectionSourceRoute.strangerFoodName}" reg='{"maxlength":"100"}' style="width:180px;"/></span>
						</td>
					</tr>
					</tbody>
					<tr>
			            <th>4.1.3 接触过同样病人：</th>
			            <td>
			            	<ehr:dic-radio dicmeta="PH00002" name="infectionSourceRoute.contactSimilerPatient" code="1,2" value="${caseDto.infectionSourceRoute.contactSimilerPatient}"
			            		onchange="toggleOther('infectionSourceRoute.contactSimilerPatient','contactSimilerPatientDt',1)"/>
			            </td>
			        </tr>
			        <tr id="contactSimilerPatientDt" style="${caseDto.infectionSourceRoute.contactSimilerPatient == '1' ? '' : 'display: none;'}">
			         	 <td colspan="4" style="padding: 0px;">
				        	<table>
			        			<colgroup>
						            <col style="width: 27%"/>
						            <col style="width: 23%"/>
						            <col style="width: 25%"/>
						            <col style="width: 25%"/>
						        </colgroup>
						         <tr>
						            <th>4.1.3.1 接触时间：</th>
						            <td><tag:dateInput id="contactSimilerPatient_Dt" name="infectionSourceRoute.contactSimilerPatientDt" nullToToday="true" onlypast="true" pattern="yyyy/MM/dd HH" date="${caseDto.infectionSourceRoute.contactSimilerPatientDt}"/>时
						            	<input type="hidden" id="contactSimilerPatientHour" name="infectionSourceRoute.contactSimilerPatientHour">
						            </td>
						            <th>4.1.3.2 接触地点：</th>
						            <td><input type="text" name="infectionSourceRoute.contactSimilerPatientAddr" value="${caseDto.infectionSourceRoute.contactSimilerPatientAddr}" reg='{"maxlength":"100"}'/></td>
						        </tr>
						        <tr>
						            <th>4.1.3.3 接触方式：</th>
						        </tr>
						        <tr>
						            <th>（1）同吃：</th>
						            <td><ehr:dic-radio dicmeta="PH00002" name="infectionSourceRoute.shareDiner" code="1,2" value="${caseDto.infectionSourceRoute.shareDiner}"/></td>
						            <th>（2）同住：</th>
						            <td><ehr:dic-radio dicmeta="PH00002" name="infectionSourceRoute.shareLiver" code="1,2" value="${caseDto.infectionSourceRoute.shareLiver}"/></td>
						        </tr>
						        <tr>
						            <th>（3）护理：</th>
						            <td><ehr:dic-radio dicmeta="PH00002" name="infectionSourceRoute.shareNurse" code="1,2" value="${caseDto.infectionSourceRoute.shareNurse}"/></td>
						            <th>（4）其他：</th>
						            <td><ehr:dic-radio dicmeta="PH00002" name="infectionSourceRoute.shareOther" code="1,2" value="${caseDto.infectionSourceRoute.shareOther}"/></td>
						        </tr>
						     </table>
						   </td>
					</tr>
			        <tr>
			            <th>4.2 饮食情况（病前5天）：</th>
			        </tr>
			        <tr>
			            <th>4.2.1 饮生水：</th>
			            <td>
			            	<ehr:dic-radio dicmeta="PH00002" name="beforeDiseaseDiet.drinkingHistory" code="1,2" value="${caseDto.beforeDiseaseDiet.drinkingHistory}"
			            		onchange="toggleOther('beforeDiseaseDiet.drinkingHistory','waterType',1)"/>
			            </td>
			            <td colspan="2" style="padding: 0px;" id="waterType">
				        	<table>
			        			<colgroup>
						            <col style="width: 25%"/>
						            <col style="width: 25%"/>
						        </colgroup>
						        <tr>
							         <th>4.2.1.1 水源类型：</th>
				           			 <td><ehr:dic-radio name="beforeDiseaseDiet.waterType" dicmeta="IDM00034" code="3,4,6,8,99" value="${caseDto.beforeDiseaseDiet.waterType}"/></td>
						    	</tr>
						    </table>
						 </td>
			        </tr>
			        <tr>
			            <th>4.2.2 吃生冷食品：</th>
			            <td>
			            	<ehr:dic-radio dicmeta="PH00002" name="beforeDiseaseDiet.coldFood" code="1,2" value="${caseDto.beforeDiseaseDiet.coldFood}"
			            		onchange="toggleOther('beforeDiseaseDiet.coldFood','coldFoodName',1)"/>
			            </td>
			        </tr>
			        <tr id="coldFoodName">
			            <th>4.2.2.1 生冷食品名称：</th>
			            <td><input type="text" name="beforeDiseaseDiet.coldFoodName" value="${caseDto.beforeDiseaseDiet.coldFoodName}" reg='{"maxlength":"100"}'/></td>
			            <th>购买地点：</th>
			            <td><input type="text" name="beforeDiseaseDiet.coldFoodBuyPlace" value="${caseDto.beforeDiseaseDiet.coldFoodBuyPlace}" reg='{"maxlength":"100"}'/></td>
			        </tr>
			        <tr>
			            <th>4.2.3 熟食冷吃：</th>
			            <td>
			            	<ehr:dic-radio dicmeta="PH00002" name="beforeDiseaseDiet.cookedFoodColdEat" code="1,2" value="${caseDto.beforeDiseaseDiet.cookedFoodColdEat}"
			            		onchange="toggleOther('beforeDiseaseDiet.cookedFoodColdEat','cookedFoodName',1)"/>
			            </td>
			            <td></td>
			            <td></td>
			        </tr>
			        <tr id="cookedFoodName">
			            <th>4.2.3.1 熟食品名称 ：</th>
			            <td>
			            	<input type="text" name="beforeDiseaseDiet.cookedFoodName" value="${caseDto.beforeDiseaseDiet.cookedFoodName}" reg='{"maxlength":"50"}'/>
			            </td>
			             <th>购买地点：</th>
			              <td>
			            	<input type="text" name="beforeDiseaseDiet.cookedFoodBuyPlace" value="${caseDto.beforeDiseaseDiet.cookedFoodBuyPlace}" reg='{"maxlength":"200"}'/>
			            </td>
			        </tr>
			        <tr>
			            <th>4.2.4 其他可疑食品名称：</th>
			            <td>
			            	<input type="text" name="beforeDiseaseDiet.suspiciousFood" value="${caseDto.beforeDiseaseDiet.suspiciousFood}"  reg='{"maxlength":"100"}'/>
			            </td>
				         <th>购买地点：</th>
			            <td>
			            	<input type="text" name="beforeDiseaseDiet.susSalesPlaces" value="${caseDto.beforeDiseaseDiet.susSalesPlaces}"  reg='{"maxlength":"100"}'/>
			        	</td>
			        </tr>
			        <tr>
			            <th>4.2.5 在外就餐史：</th>
			            <td>
			            	<ehr:dic-radio dicmeta="PH00002" name="beforeDiseaseDiet.outsideDiningHistory" code="1,2" value="${caseDto.beforeDiseaseDiet.outsideDiningHistory}"
			            		onchange="toggleOther('beforeDiseaseDiet.outsideDiningHistory','eatPlace',1)"/>
			            </td>
			        </tr>
			        <tr id="eatPlace">
			            <th>4.2.5.1 就餐地点：</th>
			            <td><ehr:dic-list name="beforeDiseaseDiet.eatPlace" dicmeta="IDM00037" value="${caseDto.beforeDiseaseDiet.eatPlace}"/></td>
			            <th>4.2.5.2 就餐地点名称：</th>
			            <td><input type="text" name="beforeDiseaseDiet.cookedFoodEatPlace" value="${caseDto.beforeDiseaseDiet.cookedFoodEatPlace}" reg='{"maxlength":"50"}'/></td>
			        </tr>
			        <tr>
			            <th>4.2.6 同餐者：</th>
			            <td>
			            	<ehr:dic-radio dicmeta="PH00002" name="beforeDiseaseDiet.meals" code="1,2" value="${caseDto.beforeDiseaseDiet.meals}"
			            		onchange="toggleOther('beforeDiseaseDiet.meals','mealPNum',1);"/>
			            </td>
			        </tr>
			        <tr id="mealPNum">
			            <th>4.2.6.1 同餐人数：</th>
			            <td><input type="text" name="beforeDiseaseDiet.mealPNum" value="${caseDto.beforeDiseaseDiet.mealPNum}" reg='{"maxlength":"20"}'/></td>
			        	<th>4.2.6.2 同餐日期：</th>
			            <td><tag:dateInput id="dinnerDate" name="beforeDiseaseDiet.dinnerDate" date="${caseDto.beforeDiseaseDiet.dinnerDate}" nullToToday="true" onlypast="true" pattern="yyyy/MM/dd HH" />时
			            	<input type="hidden" id="dinnerHour" name="beforeDiseaseDiet.dinnerHour">
			            </td>
			        </tr>
			    </table>
			</fieldset>
			<fieldset>
			    <legend>5．疫点疫区处理</legend>
			    <table class="posttable">
			        <colgroup>
			            <col style="width: 25%"/>
			            <col style="width: 25%"/>
			            <col style="width: 25%"/>
			            <col style="width: 25%"/>
			        </colgroup>
			        <tr>
			            <th>5.1 防疫站接到报告时间 ：</th>
			            <td><tag:dateInput id="diseaseReportDate" name="epidemicFocusClose.diseaseReportDate" date="${caseDto.epidemicFocusClose.diseaseReportDate}" nullToToday="true" onlypast="true" pattern="yyyy/MM/dd HH" />时
			            	<input type="hidden" id="diseaseReportHour" name="epidemicFocusClose.diseaseReportHour">
			            </td>
			            <th>5.2 防疫站到达现场时间：</th>
			            <td><tag:dateInput id="diseaseSceneDate" name="epidemicFocusClose.diseaseSceneDate" date="${caseDto.epidemicFocusClose.diseaseSceneDate}" nullToToday="true" onlypast="true" pattern="yyyy/MM/dd HH" />时
			            	<input type="hidden" id="diseaseSceneHour" name="epidemicFocusClose.diseaseSceneHour">
			            </td>
			        </tr>
			        <tr>
			            <th>5.3 疫点：</th>
			            <td>
			            	<input type="text" name="epidemicFocusClose.farmNum" value="${caseDto.epidemicFocusClose.farmNum}"
													cssClass="width30" reg='{"maxlength":"20"}' style="width:30%;"/>个
					   </td>
			            <th>5.4 范围：</th>
			            <td>
			            	<input type="text" name="epidemicFocusClose.rangeFamily" value="${caseDto.epidemicFocusClose.rangeFamily}"
													cssClass="width30" reg='{"maxlength":"20"}' style="width:30%;"/>户
			            	<input type="text" name="epidemicFocusClose.rangeNum" value="${caseDto.epidemicFocusClose.rangeNum}"
													cssClass="width30" reg='{"maxlength":"20"}' style="width:30%;"/> 个
			            </td>
			        </tr>
			        <tr>
			            <th>5.5 解除时间：</th>
			            <td><tag:dateInput id="removeDate" name="epidemicFocusClose.removeDate" date="${caseDto.epidemicFocusClose.removeDate}" nullToToday="true" onlypast="true" pattern="yyyy/MM/dd HH" />时
			            	<input type="hidden" id="removeHour" name="epidemicFocusClose.removeHour">
			            </td>
			            <th>5.6 终末消毒时间：</th>
			            <td><tag:dateInput id="termSterTime" name="epidemicFocusClose.termSterTime" date="${caseDto.epidemicFocusClose.termSterTime}" nullToToday="true" onlypast="true" pattern="yyyy/MM/dd HH" />时
			            	<input type="hidden" id="termSterHour" name="epidemicFocusClose.termSterHour">
			            </td>
			        </tr>
			        <tr>
						<th>5.7病人隔离：</th>
						<td>
                            <ehr:dic-radio name="epidemicFocusClose.isPatientIsolation" value="${caseDto.epidemicFocusClose.isPatientIsolation}"  dicmeta="PH00002" code="1,2"
								onchange="toggleOther('epidemicFocusClose.isPatientIsolation','isPatientIsolationDiv',1);"/>
                        </td>
					</tr>
					<tr id="isPatientIsolationDiv" style="display: none">
						<th>5.8隔离地点：</th>
						<td>
				             <ehr:dic-radio name="epidemicFocusClose.isolationPlace" value="${caseDto.epidemicFocusClose.isolationPlace}"  dicmeta="IDM00543" />
				       </td>
				       <th>5.9隔离解除时间：</th>
						<td>
			            	 <tag:dateInput name="epidemicFocusClose.quarantineEndDate" onlypast="true" pattern="yyyy/MM/dd"
		             			 date="${caseDto.epidemicFocusClose.quarantineEndDate}" style="width: 200px;"/>
			            </td>
			         </tr>
			         <tr>
			            <th>5.10 病人粪检情况：</th>
			        </tr>
			         <tr>
			            <th>第一次时间：</th>
			            <td><tag:dateInput id="stoolCollecttimeOne" name="labExamine.stoolCollecttimeOne" date="${caseDto.labExamine.stoolCollecttimeOne}"  onlypast="true" pattern="yyyy/MM/dd HH" />时
			            	<input type="hidden" id="stoolCollectHourOne" name="labExamine.stoolCollectHourOne">
			            </td>
			            <th>结果：</th>
			            <td><input type="text" name="labExamine.stoolResultOne"
                                   value="${caseDto.labExamine.stoolResultOne}" style="width: 80px;" reg='{"maxlength":"50"}'/></td>
			        </tr>
			          <tr>
			            <th>第二次时间：</th>
			            <td><tag:dateInput id="stoolCollecttimeTwo" name="labExamine.stoolCollecttimeTwo" date="${caseDto.labExamine.stoolCollecttimeTwo}"  onlypast="true" pattern="yyyy/MM/dd HH" />时
			            	<input type="hidden" id="stoolCollectHourTwo" name="labExamine.stoolCollectHourTwo">
			            </td>
			            <th>结果：</th>
			            <td><input type="text" name="labExamine.stoolResultTwo"
                                   value="${caseDto.labExamine.stoolResultTwo}" style="width: 80px;" reg='{"maxlength":"50"}'/></td>
			        </tr>
			          <tr>
			            <th>第三次时间：</th>
			            <td><tag:dateInput id="stoolCollecttimeThree" name="labExamine.stoolCollecttimeThree" date="${caseDto.labExamine.stoolCollecttimeThree}"  onlypast="true" pattern="yyyy/MM/dd HH" />时
			            	<input type="hidden" id="stoolCollectHourThree" name="labExamine.stoolCollectHourThree">
			            </td>
			            <th>结果：</th>
			            <td><input type="text" name="labExamine.stoolResultThree"
                                   value="${caseDto.labExamine.stoolResultThree}" style="width: 80px;" reg='{"maxlength":"50"}'/></td>
			        </tr>
			          <tr>
			            <th>第四次时间：</th>
			            <td><tag:dateInput id="stoolCollecttimeFour" name="labExamine.stoolCollecttimeFour" date="${caseDto.labExamine.stoolCollecttimeFour}"  onlypast="true" pattern="yyyy/MM/dd HH" />时
			            	<input type="hidden" id="stoolCollectHourFour" name="labExamine.stoolCollectHourFour">
			            </td>
			            <th>结果：</th>
			            <td><input type="text" name="labExamine.stoolResultFour"
                                   value="${caseDto.labExamine.stoolResultFour}" style="width: 80px;" reg='{"maxlength":"50"}'/></td>
			        </tr>
			          <tr>
			            <th>第五次时间：</th>
			            <td><tag:dateInput id="stoolCollecttimeFive" name="labExamine.stoolCollecttimeFive" date="${caseDto.labExamine.stoolCollecttimeFive}"  onlypast="true" pattern="yyyy/MM/dd HH" />时
			            	<input type="hidden" id="stoolCollectHourFive" name="labExamine.stoolCollectHourFive">
			            </td>
			            <th>结果：</th>
			            <td><input type="text" name="labExamine.stoolResultFive"
                                   value="${caseDto.labExamine.stoolResultFive}" style="width: 80px;" reg='{"maxlength":"50"}'/></td>
			        </tr>
			
			    </table>
			</fieldset>
		<%-- 	 <fieldset>
			    <legend>4.诊断依据</legend>
			    <table class="posttable">
			        <colgroup>
			            <col style="width: 20%"/>
			            <col style="width: 30%"/>
			            <col style="width: 20%"/>
			            <col style="width: 30%"/>
			        </colgroup>
			       
			       
			        
			        
			        
			        <tr>
			            <th>4.1 可疑流行病学史：</th>
			            <td>
			            	<ehr:dic-radio dicmeta="PH00002" name="diagnosis.epidemiologyHistory"
			            	 code="1,2" value="${caseDto.diagnosis.epidemiologyHistory}"/>
			            </td>
			            <th>4.2 临床表现典型：</th>
			            <td>
			            	<ehr:dic-radio dicmeta="PH00002" name="diagnosis.clinicalFeature"
			            	 code="1,2" value="${caseDto.diagnosis.clinicalFeature}"/>
			            </td>
			        </tr>
			        <tr>
			            <th>4.3 霍乱弧菌检验阳性：</th>
			            <td>
			            	<ehr:dic-radio dicmeta="PH00002" name="diagnosis.bacillusCommaPositive"
			            	 code="1,2" value="${caseDto.diagnosis.bacillusCommaPositive}"/>
			            </td>
			            <th>4.4 病原分型：</th>
			            <td>
			            	<ehr:dic-list dicmeta="IDM00108" name="diagnosis.etiologyCategory" value="${caseDto.diagnosis.etiologyCategory}"/>
			            </td>
			        </tr>
			        <tr>
			            <th>4.5 噬菌体-生物型：</th>
			            <td><input type="text" name="diagnosis.bacteriophage" value="${caseDto.diagnosis.bacteriophage}" reg='{"maxlength":"200"}' ></td>
			        </tr> 
			    
				</table>
			</fieldset>
			<fieldset>
			    <legend>5.小结</legend>
			    <table class="posttable">
			        <tr>
			            <td>
			            	<ehr:dic-radio dicmeta="IDM00040" code="2,3,7" name="diagnosis.choleraConclusion" value="${caseDto.diagnosis.choleraConclusion}"/>
			            </td>
			        </tr>
			    </table>
			</fieldset> 
		
		  <fieldset>
			    <legend>6.疫点情况</legend>
			    <table class="posttable">
			    	<colgroup>
			            <col style="width: 34%"/>
			            <col style="width: 14%"/>
			            <col style="width: 38%"/>
			            <col style="width: 14%"/>
			        </colgroup>
			        <tr>
			            <td colspan="4">
			                <div class="repeattable">
			                   	<div class="toolbarsublist">
			                         6.1 病人发病前五天和发病后的主要活动情况：<a href="javascript:void(0)" id="addActiveList" ><b class="xinz">添加</b></a>
			                    </div>
			                    <table id="efcTable">
			                        <thead>
			                            <tr>
			                                <th class="centerth" style="width: 10%">时间</th>
			                                <th class="centerth" style="width: 20%">地点</th>
			                                <th class="centerth" style="width: 20%">解大便处</th>
			                                <th class="centerth" style="width: 20%">呕吐处</th>
			                                <th class="centerth" style="width: 20%">交通工具污染</th>
			                                <th class="centerth" style="width: 10%;">操作</th>
			                            </tr>
			                        </thead>
			                       <c:forEach var="active" items="${caseDto.idmListEfcList}" varStatus="status">
				                         <tr>
				                             <td field="activityDt"><ehr:tip><fmt:formatDate pattern="yyyy/MM/dd" value="${active.activityDt}"/></ehr:tip></td>
				                             <td field="activityAddr"><ehr:tip>${active.activityAddr}</ehr:tip></td>
				                             <td field="dungAddr"><ehr:tip>${active.dungAddr}</ehr:tip></td>
				                             <td field="vomitAddr"><ehr:tip>${active.vomitAddr}</ehr:tip></td>
				                             <td field="vehiclePollute"><ehr:tip>${active.vehiclePollute}</ehr:tip></td>
				                             <td class="btnsublist" field="btn">
				                             	 <a href="javascript:void(0)" onclick="choleraCase.editTr(this, 'efcList')">修改</a>
				                             	 <a href="javascript:void(0)" onclick="caseEdit.removeTr(this)">删除</a>
				                             </td>
				                         </tr>
			                         </c:forEach>
			                    </table>
			                </div>
			            </td>
			        </tr>
			        <tr>
			            <th>6.2 污染衣、被、席等地点：</th>
			            <td colspan="3">
			                <input reg='{"maxlength":"200"}' type="text" name="epidemicFocusClose.place" value="${caseDto.epidemicFocusClose.place }"/>
			            </td>
			        </tr>
			        <tr>
			            <th>6.3 污物清洗时间：</th>
			            <td colspan="3">
			                <tag:dateInput name="epidemicFocusClose.dirtCleaningDate" onlypast="true" pattern="yyyy/MM/dd" date="${caseDto.epidemicFocusClose.dirtCleaningDate }"/>
			            </td>
			        </tr>
			        <tr>
			            <th>6.4 污物清洗地点：</th>
			            <td colspan="3"><input reg='{"maxlength":"200"}' type="text" name="epidemicFocusClose.dirtCleaningPlace" value="${caseDto.epidemicFocusClose.dirtCleaningPlace}"/></td>
			        </tr>
			        <tr>
			            <th>6.5 疫点：</th>
			            <td>
			            	<input type="text"  name="epidemicFocusClose.farmNum" value="${caseDto.epidemicFocusClose.farmNum}"
				            	reg='{"maxlength":"20"}' cssClass="width30"/> 个
			            </td>
			            <th>6.6 疫点范围：</th>
			            <td>
			            	<input type="text"  name="epidemicFocusClose.rangeFamily" value="${caseDto.epidemicFocusClose.rangeFamily}"
				            	reg='{"maxlength":"20"}' cssClass="width30"/>户
			            </td>
			        </tr>
			        <tr>
			            <th>6.7 疫点人数：</th>
			            <td>
			            	<input type="text"  name="epidemicFocusClose.farmPeopleNum" value="${caseDto.epidemicFocusClose.farmPeopleNum}"
				            	reg='{"maxlength":"20"}' cssClass="width30"/>
			            </td>
			            <th>6.8 终末消毒时间：</th>
			            <td>
			                <tag:dateInput name="epidemicFocusClose.terSterDate"  onlypast="true"
			                               pattern="yyyy/MM/dd" date="${caseDto.epidemicFocusClose.terSterDate }"/>
			            </td>
			        </tr>
			        <tr>
			            <th>6.9 疫点内人群服药时间：</th>
			            <td>
			                <tag:dateInput  name="epidemicFocusClose.farmMedTime"  onlypast="true"
			                               pattern="yyyy/MM/dd" date="${caseDto.epidemicFocusClose.farmMedTime }"/>
			            </td>
			            <th>6.10 疫点内服药人数：</th>
			            <td>
			            	<input type="text"  name="epidemicFocusClose.farmMedNum" value="${caseDto.epidemicFocusClose.farmMedNum}"
				            	reg='{"maxlength":"20"}' cssClass="width30"/>
			            </td>
			        </tr>
			    </table>
			</fieldset>
			<fieldset>
			    <legend>7.传染源和传播途径的追溯</legend>
			    <table class="posttable">
			        <colgroup>
			            <col style="width: 32%"/>
			            <col style="width: 15%"/>
			            <col style="width: 38%"/>
			            <col style="width: 15%"/>
			        </colgroup>
			        <tr>
			            <th>7.1 病前本地乡、村、街道同样疾病的发生：</th>
			            <td>
			            	<ehr:dic-radio dicmeta="PH00002" name="infectionSourceRoute.sameDisease"
			            	 code="1,2" value="${caseDto.infectionSourceRoute.sameDisease}"
                             onchange="toggleOther('infectionSourceRoute.sameDisease','sameDiseaseForAdd',1)"/>
			            </td>
                            <td colspan="2" style="display: none;" id="sameDiseaseForAdd">
                                <table>
                                    <colgroup>
                                        <col style="width: 20.14%"/>
                                        <col style="width: 7.95%"/>
                                    </colgroup>
                                    <tr>
                                        <th>
                                            7.2 同样疾病的发生时间：
                                        </th>
                                        <td>
                                            <tag:dateInput name="infectionSourceRoute.outSameDiseaseDt"  onlypast="true"
                                            pattern="yyyy/MM/dd" date="${caseDto.infectionSourceRoute.outSameDiseaseDt}"/>
                                         </td>
                                     </tr>
                                 </table>
                             </td>
			        </tr>
			        <tr>
			            <th>7.3 病前五天内外出：</th>
			            <td colspan="3">
			            	<ehr:dic-radio dicmeta="PH00002" name="infectionSourceRoute.outHistory"
			            	 code="1,2" value="${caseDto.infectionSourceRoute.outHistory}"
                             onchange="toggleOther('infectionSourceRoute.outHistory','outHistoryForAdd',1)"/>
			            </td>
			        </tr>
                    <tr style="display: none;" id="outHistoryForAdd">
                        <td colspan="4"  style="padding: 0px;">
                        <table>
                            <colgroup>
                                <col style="width: 32%"/>
                                <col style="width: 68%"/>
                            </colgroup>
                            <tr>
                                <th>7.4 去何地：</th>
                                <td>
                                    <input reg='{"maxlength":"100"}' type="text" name="infectionSourceRoute.outAddr" value="${caseDto.infectionSourceRoute.outAddr}"/>
                                </td>
                            </tr>
                            <tr>
                                <th>7.5 该地有无同样疾病：</th>
                                <td>
                                    <ehr:dic-radio dicmeta="PH00002" name="infectionSourceRoute.outSameDisease"
                                                   code="1,2" value="${caseDto.infectionSourceRoute.outSameDisease}"/>
                                </td>
                            </tr>
                            <tr>
                                <th>7.6 有无在该地住宿用膳、带回水产品、其它食物：</th>
                                <td>
                                    <ehr:dic-radio dicmeta="PH00002" name="infectionSourceRoute.outBackFood"
                                                   code="1,2" value="${caseDto.infectionSourceRoute.outBackFood}"
                                                   onchange="toggleOther('infectionSourceRoute.outBackFood','outBackFoodForAdd',1)"/>
                                </td>
                            </tr>
                            <tr style="display: none;" id="outBackFoodForAdd">
                                <td colspan="4" style="padding: 0px;">
                                    <table>
                                        <colgroup>
                                            <col style="width: 32%"/>
                                            <col style="width: 68%"/>
                                        </colgroup>
                                        <tr>
                                            <th>7.7 若有，带回食物名称：</th>
                                            <td>
                                                <input reg='{"maxlength":"100"}' type="text"
                                                       name="infectionSourceRoute.outBackFoodName"
                                                       value="${caseDto.infectionSourceRoute.outBackFoodName}"/>
                                            </td>
                                        </tr>
                                    </table>
                                </td>
                            </tr>
                        </table>
                        </td>
                    </tr>
                    <tr>
                        <th>7.8 病前五天内有无接触过同样病人：</th>
                        <td>
                            <ehr:dic-radio dicmeta="PH00002" name="infectionSourceRoute.contactSimilerPatient"
                                           code="1,2" value="${caseDto.infectionSourceRoute.contactSimilerPatient}"
                                           onchange="toggleOther('infectionSourceRoute.contactSimilerPatient','contactSimilerPatientForAdd',1)"/>
                        </td>
                    </tr>
                    <tr style="display: none;" id="contactSimilerPatientForAdd">
                        <td colspan="4" style="padding: 0px;">
                            <table>
                                <colgroup>
                                    <col style="width: 32%"/>
                                    <col style="width: 68%"/>
                                </colgroup>
                                <tr>
                                    <th>7.9 接触时间：</th>
                                    <td>
                                        <tag:dateInput
                                                       name="infectionSourceRoute.contactSimilerPatientDt"
                                                       onlypast="true"
                                                       pattern="yyyy/MM/dd"
                                                       date="${caseDto.infectionSourceRoute.contactSimilerPatientDt }"/>
                                    </td>
                                </tr>
                                <tr>
                                    <th>7.10接触地点：</th>
                                    <td colspan="3">
                                        <input reg='{"maxlength":"100"}' type="text"
                                               name="infectionSourceRoute.contactSimilerPatientAddr"
                                               value="${caseDto.infectionSourceRoute.contactSimilerPatientAddr}"/>
                                    </td>
                                </tr>
                                <tr>
                                    <th>7.11 接触方式：</th>
                                    <td colspan="3">
                                        <input reg='{"maxlength":"100"}' type="text"
                                               name="infectionSourceRoute.contactSimilerPatientWay"
                                               value="${caseDto.infectionSourceRoute.contactSimilerPatientWay}"/>
                                    </td>
                                </tr>
                            </table>
                        </td>
                    </tr>
			        <tr>
			            <th>7.12 病前五天内有无外人来家：</th>
			            <td>
			            	<ehr:dic-radio dicmeta="PH00002" name="infectionSourceRoute.stranger"
			            	 code="1,2" value="${caseDto.infectionSourceRoute.stranger}"
                             onchange="toggleOther('infectionSourceRoute.stranger','strangerForAdd',1)"/>
			            </td>
			        </tr>
                    <tr style="display: none;" id="strangerForAdd">
                        <td colspan="4" style="padding: 0px;">
                            <table>
                                <colgroup>
                                    <col style="width: 32%"/>
                                    <col style="width: 15%"/>
                                    <col style="width: 38%"/>
                                    <col style="width: 15%"/>
                                </colgroup>
                                <tr>
                                    <th>7.13 来自何地：</th>
                                    <td colspan="3">
                                        <input reg='{"maxlength":"100"}' type="text"
                                               name="infectionSourceRoute.strangerFromAddr"
                                               value="${caseDto.infectionSourceRoute.strangerFromAddr}"/>
                                    </td>
                                </tr>
                                <tr>
                                    <th>7.14 该地有无本病：</th>
                                    <td>
                                        <ehr:dic-radio dicmeta="PH00002"
                                                       name="infectionSourceRoute.strangerAddrSameDisease"
                                                       code="1,2"
                                                       value="${caseDto.infectionSourceRoute.strangerAddrSameDisease}"/>
                                    </td>
                                    <th>7.15 有无在家住宿、用膳、带回水产品、其他食物：</th>
                                    <td>
                                        <ehr:dic-radio dicmeta="PH00002" name="infectionSourceRoute.homeActivity"
                                                       code="1,2" value="${caseDto.infectionSourceRoute.homeActivity}"/>
                                    </td>
                                </tr>
                            </table>
                        </td>
                    </tr>
			    </table>
			</fieldset>
			<fieldset>
				<legend>8.病前五天内饮食情况</legend>
				<table class="posttable">
				<colgroup>
				    <col style="width: 30%"/>
				    <col style="width: 70%"/>
				</colgroup>
				<tr>
				    <th>8.1 有无饮生水：</th>
				    <td>
				    	<ehr:dic-radio dicmeta="PH00002" name="beforeDiseaseDiet.drinkingHistory"
				            	 code="1,2" value="${caseDto.beforeDiseaseDiet.drinkingHistory}"
                                 onchange="toggleOther('beforeDiseaseDiet.drinkingHistory','drinkingHistoryForAdd',1)"/>
				    </td>
                </tr>
                    <tr style="display: none;" id="drinkingHistoryForAdd">
                        <td colspan="4" style="padding: 0px;">
                            <table>
                                <colgroup>
                                    <col style="width: 30%"/>
                                    <col style="width: 70%"/>
                                </colgroup>
                                <tr>
                                    <th>8.2 地点：</th>
                                    <td>
                                        <input reg='{"maxlength":"200"}' type="text"
                                               name="beforeDiseaseDiet.drinkingPlace"
                                               value="${caseDto.beforeDiseaseDiet.drinkingPlace}"/>
                                    </td>
                                </tr>
                                <tr>
                                    <th>8.3 水源类型：</th>
                                    <td>
                                        <input reg='{"maxlength":"100"}' type="text" name="beforeDiseaseDiet.waterType"
                                               value="${caseDto.beforeDiseaseDiet.waterType}"/>
                                    </td>
                                </tr>
                                <tr>
                                    <th>8.4 日期：</th>
                                    <td>
                                        <tag:dateInput name="beforeDiseaseDiet.drinkingTime"
                                                       onlypast="true"
                                                       pattern="yyyy/MM/dd"
                                                       date="${caseDto.beforeDiseaseDiet.drinkingTime}"
                                                       style="width:15%"/>
                                    </td>
                                </tr>
                            </table>
                        </td>
                    </tr>
                    <tr>
				    <td colspan="2">
				    	<div class="repeattable">
					       	<div class="toolbarsublist">
					             8.5 病前5天食谱：<a href="javascript:void(0)" id="addBddList" ><b class="xinz">添加</b></a>
					        </div>
					        <table id="bddTable">
					            <thead>
					                <tr>
					                	<th class="centerth" style="width: 10%">餐饮日期</th>
					                    <th class="centerth" style="width: 10%">餐次</th>
					                    <th class="centerth" style="width: 20%">地点</th>
					                    <th class="centerth" style="width: 20%">食物名称</th>
					                    <th class="centerth" style="width: 20%">同餐对象</th>
					                    <th class="centerth" style="width: 10%;">操作</th>
					                </tr>
					            </thead>
					           <c:forEach var="listBdd" items="${caseDto.idmListBddList}" varStatus="status">
					              <tr>
					                  <td field="dietDate"><ehr:tip><fmt:formatDate pattern="yyyy/MM/dd" value="${listBdd.dietDate}"/></ehr:tip></td>
					                  <td field="mealNum"><ehr:tip>${listBdd.mealNum}</ehr:tip></td>
					                  <td field="addr"><ehr:tip>${listBdd.addr}</ehr:tip></td>
					                  <td field="foodName"><ehr:tip>${listBdd.foodName}</ehr:tip></td>
					                  <td field="mealPeople"><ehr:tip>${listBdd.mealPeople}</ehr:tip></td>
					                  <td class="btnsublist" field="btn">
					                  	   <a href="javascript:void(0)" onclick="choleraCase.editTr(this, 'bddList')">修改</a>
					                       <a href="javascript:void(0)" onclick="caseEdit.removeTr(this)">删除</a>
					                  </td>
					              </tr>
				             </c:forEach>
					        </table>
					    </div>
				    </td>
				</tr>
				<tr>
				    <th>8.6 有无其他可疑食品：</th>
				    <td>
				    	<ehr:dic-radio dicmeta="PH00002" name="beforeDiseaseDiet.suspiciousFood"
				            	 code="1,2" value="${caseDto.beforeDiseaseDiet.suspiciousFood}"
                                 onchange="toggleOther('beforeDiseaseDiet.suspiciousFood','suspiciousFoodForAdd',1)"/>
				    </td>
				</tr>
                    <tr style="display: none;" id="suspiciousFoodForAdd">
                        <td colspan="4" style="padding: 0px;">
                            <table>
                                <colgroup>
                                    <col style="width: 30%"/>
                                    <col style="width: 70%"/>
                                </colgroup>
                                <tr>
                                    <th>8.7 名称、来源：</th>
                                    <td>
                                        <input reg='{"maxlength":"200"}' type="text"
                                               name="beforeDiseaseDiet.susFoodName"
                                               value="${caseDto.beforeDiseaseDiet.susFoodName}"/>
                                    </td>
                                </tr>
                            </table>
                        </td>
                    </tr>
				<tr>
				    <th>8.8 生、熟饮具是否分开：</th>
				    <td>
				    	<ehr:dic-radio dicmeta="PH00002" name="beforeDiseaseDiet.separate"
				            	 code="1,2" value="${caseDto.beforeDiseaseDiet.separate}"/>
				    </td>
				</tr>
				<tr>
				    <th>8.9 有无聚餐史：</th>
				    <td>
				    	<ehr:dic-radio dicmeta="PH00002" name="beforeDiseaseDiet.dinnerHistory"
				            	 code="1,2" value="${caseDto.beforeDiseaseDiet.dinnerHistory}"
                                 onchange="toggleOther('beforeDiseaseDiet.dinnerHistory','dinnerHistoryForAdd',1)"/>
				    </td>
				</tr>
                    <tr style="display: none;" id="dinnerHistoryForAdd">
                        <td colspan="4" style="padding: 0px;">
                            <table>
                                <colgroup>
                                    <col style="width: 30%"/>
                                    <col style="width: 70%"/>
                                </colgroup>
                                <tr>
                                    <th>8.10如有聚餐，则聚餐时间：</th>
                                    <td><tag:dateInput nullToToday="true" name="beforeDiseaseDiet.dinnerDate"
                                                       onlypast="true"
                                                       pattern="yyyy/MM/dd"
                                                       date="${caseDto.beforeDiseaseDiet.dinnerDate}"
                                                       style="width: 15%"/></td>
                                </tr>
                                <tr>
                                    <th>8.11 同餐人数：</th>
                                    <td>
                                        <input type="text" name="beforeDiseaseDiet.dinnerPNum"
                                               value="${caseDto.beforeDiseaseDiet.dinnerPNum}"
                                               reg='{"maxlength":"20"}' cssClass="width30" style="width: 15%"/>
                                    </td>
                                </tr>
                                <tr>
                                    <th>8.12 发病人数：</th>
                                    <td>
                                        <input type="text" name="beforeDiseaseDiet.infectedNum"
                                               value="${caseDto.beforeDiseaseDiet.infectedNum}"
                                               reg='{"maxlength":"20"}' cssClass="width30" style="width: 15%"/>
                                    </td>
                                </tr>
                                <tr>
                                    <th>8.13 发病日期：</th>
                                    <td>
                                        <tag:dateInput nullToToday="true" name="beforeDiseaseDiet.accidentDate"
                                                       onlypast="true"
                                                       pattern="yyyy/MM/dd"
                                                       date="${caseDto.beforeDiseaseDiet.accidentDate }"
                                                       style="width:15%"/>
                                    </td>
                                </tr>
                            </table>
                        </td>
                    </tr>
				<tr>
				    <th>8.14 病前五天内有无接触阳性水源：</th>
				    <td>
				    	<ehr:dic-radio dicmeta="PH00002" name="beforeDiseaseDiet.touchPosiWater"
				            	 code="1,2" value="${caseDto.beforeDiseaseDiet.touchPosiWater}"
                                 onchange="toggleOther('beforeDiseaseDiet.touchPosiWater','touchPosiWaterForAdd',1)"/>
				    </td>
				</tr>
                <tr style="display: none;" id="touchPosiWaterForAdd">
                    <td colspan="4" style="padding: 0px;">
                        <table>
                            <colgroup>
                                <col style="width: 30%"/>
                                <col style="width: 70%"/>
                            </colgroup>
                            <tr>
                                <th>8.15 接触阳性水源方式：</th>
                                <td>
                                    <ehr:dic-radio dicmeta="IDM00109" name="beforeDiseaseDiet.posiWaterMethod"
                                                   value="${caseDto.beforeDiseaseDiet.posiWaterMethod}"/>
                                </td>
                            </tr>
                            <tr>
                                <th>8.16 接触阳性水源地点：</th>
                                <td>
                                    <input reg='{"maxlength":"200"}' type="text" name="beforeDiseaseDiet.posiWaterPlace"
                                           value="${caseDto.beforeDiseaseDiet.posiWaterPlace}"
                                           style="width:40%"/>
                                    ，水源类型
                                    <input reg='{"maxlength":"50"}' type="text" name="beforeDiseaseDiet.posiWaterType"
                                           value="${caseDto.beforeDiseaseDiet.posiWaterType}"
                                           style="width:20%"/>
                                </td>
                            </tr>
                            <tr>
                                <th>8.17 接触阳性水源日期：</th>
                                <td>
                                    <tag:dateInput nullToToday="true" name="beforeDiseaseDiet.posiWaterDate"
                                                   onlypast="true"
                                                   pattern="yyyy/MM/dd"
                                                   date="${caseDto.beforeDiseaseDiet.posiWaterDate }"
                                                   style="width:15%"/>
                                </td>
                            </tr>
                        </table>
                    </td>
                </tr> 
				</table>
			</fieldset>
			<fieldset>
			    <legend>9.病家卫生状况</legend>
			    <table class="posttable">
			        <colgroup>
			            <col style="width: 30%"/>
			            <col style="width: 70%"/>
			        </colgroup>
			        <tr>
			            <th>9.1 饮水类型：</th>
			            <td>
			            	<ehr:dic-radio dicmeta="IDM00034" name="hygienicCondition.drinkingType"
			            	 uninclude="3,5,10,11,12,99" value="${caseDto.hygienicCondition.drinkingType}"/>
			            </td>
			        </tr>
			        <tr>
			            <th>9.2 用水类型：</th>
			            <td>
			            	<ehr:dic-radio dicmeta="IDM00034" name="hygienicCondition.waterType"
			            	 uninclude="3,5,9,10,11,12,99" value="${caseDto.hygienicCondition.waterType}"/>
			            </td>
			        </tr>
			        <tr>
			            <th>9.3 饮水是否消毒：</th>
			            <td>
			            	<ehr:dic-radio dicmeta="PH00001" name="hygienicCondition.drinkingDisinfection"
			            	 code="1,2" value="${caseDto.hygienicCondition.drinkingDisinfection}"/>
			            </td>
			        </tr>
			        <tr>
			            <th>9.4 用水是否消毒：</th>
			            <td>
			            	<ehr:dic-radio dicmeta="PH00001" name="hygienicCondition.waterDisinfection"
			            	 code="1,2" value="${caseDto.hygienicCondition.waterDisinfection}"/>
			            </td>
			        </tr>
			        <tr>
			            <th>9.5 厕所类型：</th>
			            <td>
			            	<ehr:dic-radio dicmeta="IDM00110" name="hygienicCondition.toiletType" value="${caseDto.hygienicCondition.toiletType}"/>
			            </td>
			        </tr>
			    </table>
			</fieldset> 
			<fieldset>
			    <legend>10.疫点示意图（可另附）</legend>
			    <table class="posttable">
			        <tr>
			            <td>
			                <textarea name="epidemicFocusClose.farmSketches" style="width: 100%; height: 150px;" reg='{"maxlength":"200"}'> ${caseDto.epidemicFocusClose.farmSketches}</textarea>
			            </td>
			        </tr>
			    </table>
			</fieldset>
			<fieldset>
			    <legend>6.小结</legend>
			    <table class="posttable">
			        <tr>
			            <td>
			                <textarea name="epidemicFocusClose.farmSummary" style="width: 100%; height: 150px;" reg='{"maxlength":"200"}'>${caseDto.epidemicFocusClose.farmSketches}</textarea>
			            </td>
			        </tr>
			    </table>
			</fieldset> --%>
			<fieldset>
				<table class="posttable">
                    <colgroup>
                        <col style="min-width: 80px; width: 15%" />
                        <col style="min-width: 280px; width: 35%" />
                        <col style="min-width: 80px; width: 15%" />
                        <col style="min-width: 280px; width: 35%" />
                    </colgroup>
					<tr>
						<th>调查单位：</th>
						<td>
                            <ehr:org code="${caseDto.caseInformation.modifySurveyOrg}"/>
                        </td>
						<th>调查者：</th>
						<td>
                            <ehr:user userCode="${caseDto.caseInformation.modifyRespondents}"/>
                        </td>
					</tr>
					<tr>
						<th>调查时间：</th>
						<td><tag:dateInput name="caseInformation.modifySurveyDate" onlypast="true" pattern="yyyy/MM/dd" date="${caseDto.caseInformation.modifySurveyDate}"/></td>
						<th>审核者：</th>
						<td>
                            <ehr:user userCode="${caseDto.caseInformation.modifyRespondents}"/>
                        </td>
					</tr>
					 <tr style="display:none;">
		                 <td>
		                 	<input type="hidden" name="caseInformation.modifySurveyOrg" value="${caseDto.caseInformation.modifySurveyOrg}"/>
		                 	<input type="hidden" name="caseInformation.modifyRespondents" value="${caseDto.caseInformation.modifyRespondents}"/>
		                 	<input type="hidden" name="caseInformation.auditor" value="${caseDto.caseInformation.auditor}"/>
		                 </td> 
		             </tr>
				</table>
			</fieldset>
	</div>
</div>
</form>

