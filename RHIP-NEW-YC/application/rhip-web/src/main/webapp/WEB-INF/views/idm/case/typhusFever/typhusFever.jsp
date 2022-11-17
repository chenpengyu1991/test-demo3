<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tag" %>

<script src="${pageContext.request.contextPath}/js/views/idm/case/edit.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/views/idm/case/typhusFever.js" type="text/javascript"></script>
<script	src="${pageContext.request.contextPath}/js/views/idm/idmCommon.js"	type="text/javascript"></script>
<c:if test="${isPrint != 1}">
    <jsp:include page="../caseButton.jsp"></jsp:include>
</c:if>
<form id="caseForm">
	<input type="hidden" id="idmId" name="idmId" value="${idmId}"/>
	<input type="hidden" name="efcList" id="efcList">
    <div class="postcontent <c:if test="${isPrint != 1}">contentfixed</c:if>">
		<i class="popno">
		    流行性、地方性斑疹伤寒个案调查表<br/><span>（丙类传染病）</span>
		</i>
		<table class="repost_table" style="text-align: right;">
		    <tr>
		         <td>
		              	病例编码<input type="text" name="caseInformation.mediRecordNum" reg='{"length":"11"}' value="${caseDto.caseInformation.mediRecordNum}" style="width: 15%"/>
		          </td>
		    </tr>
		</table>
		<div class="postdiv">
			<fieldset>
			    <legend>1.一般情况</legend>
			    <table class="posttable">
			        <colgroup>
			            <col style="min-width: 185px; width: 20%"/>
			            <col style="min-width: 175px; width: 30%"/>
			            <col style="min-width: 125px; width: 20%"/>
			            <col style="min-width: 235px; width: 30%"/>
			        </colgroup>
			        <tr>
			            <th>1.1姓名：</th>
			            <td>
			            	<input type="text" name="generalCondition.name" value="${caseDto.generalCondition.name}" 
			            	 style="width: 20%" reg='{"maxlength":"100"}'/>
			            </td>
			            <th>1.2身份证号码:</th>
			             <td><input type="text" id="idCard" name="generalCondition.idcard" value="${caseDto.generalCondition.idcard}"  reg='{"idCard":"true"}'
                                    placeholder="输入身份证获取个人信息"/></td>
			        </tr>
			        <tr>
			            <th>1.3性别：</th>
			            <td>
			            	<ehr:dic-radio  dicmeta="GBT226112003" name="generalCondition.gender" code="1,2" value="${caseDto.generalCondition.gender}"/>
			            </td>
			            <th>1.4年龄(岁)：</th>
			            <td><input type="text" id="age" name="generalCondition.age" value="${caseDto.generalCondition.age}" 
	            			reg='{"maxlength":"6"}' cssClass="width30" style="width: 30%"/></td>
			        </tr>
			        <tr>
			            <th>1.5职业：</th>
			            <td colspan="3">
			                <ehr:dic-list id="occupationId" dicmeta="GBT6565" name="generalCondition.occupation" width="180px;" value="${caseDto.generalCondition.occupation}"
                                  code="CV020120201,CV020120202,CV020120203,CV020120204,CV020120208,CV020120206,CV020120207,CV020120209,CV020120210,CV020120211,CV020120212,CV020120213,CV020120214,CV020120205,CV020120215,CV020120216,CV020120299"
                                  onchange="toggleOtherSC('generalCondition.occupation','occupationOtherPart','CV020120299');"/>
			            	 <span  id="occupationOtherPart" style="display: none">
		                         <input type="text" name="generalCondition.occupationOther" value="${caseDto.generalCondition.occupationOther}"
		                                reg='{"maxlength":"30"}' placeholder="若选择其他，请描叙" style="width: 40%;"/>
		                     </span>
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
			            <th>1.6现居住地：</th>
			            <td colspan="3">
                            <ehr:dic-town-village villageId="pavillage_address" townId="patown_address" villageName="generalCondition.pastreet" townName="generalCondition.patownShip"
                                                  villageValue="${caseDto.generalCondition.pastreet}" townValue="${caseDto.generalCondition.patownShip}" width="180px;"/>
                            <input type="text" id="pahouseNumber" name="generalCondition.pahouseNumber" value="${caseDto.generalCondition.pahouseNumber}"
                                   reg='{"maxlength":"50"}'  style="width: 180px;">
                        	<span id="spanPaNumber">(门牌号)</span>
                        </td>
			        </tr>
			        <tr>
			            <th>1.7联系电话：</th>
			            <td>
			            	 <input type="text" name="generalCondition.phoneNumber" value="${caseDto.generalCondition.phoneNumber}" 
			            	 reg='{"regex":"phone","maxlength":20}' style="width: 36%"/>
			           	</td>
			            <th>1.8家长或监护人姓名：</th>
			            <td><input type="text" id="generalCondition.parentsName" name="generalCondition.parentsName" value="${caseDto.generalCondition.parentsName}"
                                   reg='{"maxlength":"50"}' style="width: 36%"/></td>
			        </tr>
			        <tr>
			            <th>1.9工作或学习单位：</th>
			             <td colspan="3">
				            	<input type="text" name="generalCondition.unitName" value="${caseDto.generalCondition.unitName}"
									 reg='{"maxlength":"70"}' style="width: 36%"/>
				            </td>
			        </tr>
			         <tr>
						<th><label class="required">1.10常住类型：</label></th>
						<td>
							<ehr:dic-radio dicmeta="FS10005" name="generalCondition.hrPlace"
								value='${"2" != caseDto.generalCondition.hrPlace? "1" : "2"}' onchange="caseEdit.showHrPlace()"/>
						</td>
					</tr>
					<tr>
						<th>户籍地址：</th>
						<td colspan="3">
							<span id="hr-address-select" class="${'2' eq caseDto.generalCondition.hrPlace?'hide':''}">
								<ehr:dic-town-village 
									villageId="hrstreet" townId="hrtownShip" villageName="generalCondition.hrstreet" townName="generalCondition.hrtownShip"
									villageValue="${caseDto.generalCondition.hrstreet}" townValue="${caseDto.generalCondition.hrtownShip}" width="25%;"/>
							</span> 
							<input type="text" id="hrhouseNumber" name="generalCondition.hrhouseNumber" 
								reg="{'maxlength':50}" value="${caseDto.generalCondition.hrhouseNumber}"
								style="${'2' eq caseDto.generalCondition.hrPlace?'':'width: 20%;'}"/>(详细地址)
						</td>
					</tr>
			        <tr>
			            <th>1.11发病时间：</th>
			           <td>
					    	<tag:dateInput id="pathogenesisDate" nullToToday="true" name="attackCondition.pathogenesisDate" onlypast="true" pattern="yyyy/MM/dd" 
					    	 reg='{"compare":["firstVisitDate","le","发病时间不能大于初诊时间"]}' date="${caseDto.attackCondition.pathogenesisDate}"/>
					    </td>
			            <th>1.12发病地点：</th>
			            <td colspan="3">
		            	 	<input type="text" name="attackCondition.pathogenesisPlace" value="${caseDto.attackCondition.pathogenesisPlace}"
								 reg='{"maxlength":"100"}'/>
			            </td>
			        </tr>
			        <tr>
			            <th>1.13初诊时间：</th>
			            <td><tag:dateInput id="firstVisitDate" nullToToday="true" name="attackCondition.firstVisitDate" onlypast="true" pattern="yyyy/MM/dd"
					     reg='{"compare":["pathogenesisDate","ge","初诊时间不能小于发病时间"]}' date="${caseDto.attackCondition.firstVisitDate}"/></td>
					</tr>
			        <tr>
			            <th>1.14初诊单位：</th>
			            <td><input type="text" name="attackCondition.firstVisitUnit" value="${caseDto.attackCondition.firstVisitUnit}" reg='{"maxlength":"100"}'/></td>
			            <th>1.15初诊病名：</th>
			             <td><input type="text" name="attackCondition.firstVisitName" value="${caseDto.attackCondition.firstVisitName}" reg='{"maxlength":"100"}'/></td>
			        </tr>
			        <tr>
			            <th>1.16确诊时间：</th>
			             <td>
					    	<tag:dateInput id="confirmationDate" nullToToday="true" name="attackCondition.confirmationDate" onlypast="true" pattern="yyyy/MM/dd" 
					    	 	reg='{"compare":["firstVisitDate","ge","确诊时间不能小于初诊时间"]}' date="${caseDto.attackCondition.confirmationDate}" />
					    </td>
			        </tr>
			        <tr>
			            <th>1.17确诊单位：</th>
			            <td>
			                <input reg='{"maxlength":"100"}' type="text" name="attackCondition.confirmationHospital" value="${caseDto.attackCondition.confirmationHospital}"/>
			            </td>
			            <th>1.18确诊病名：</th>
			             <td>
			                <input reg='{"maxlength":"100"}' type="text" name="attackCondition.confirmationName" value="${caseDto.attackCondition.confirmationName}"/>
			            </td>
			        </tr>
			        <tr>
			            <th>1.19入院时间：</th>
			            <td>
				           <tag:dateInput id="inhosTime" nullToToday="true" name="otherCondition.inhosTime" onlypast="true" pattern="yyyy/MM/dd"
				            	reg='{"compare":["pathogenesisDate","ge","住院时间不能小于发病日期"]}' date="${caseDto.otherCondition.inhosTime}"/>
				       </td>
			            <th>1.20所住医院：</th>
			           	<td>
			            	<input reg='{"maxlength":"100"}' type="text" name="attackCondition.admissionHospital" value="${caseDto.attackCondition.admissionHospital}"/>
			            </td>
			        </tr>
			        <tr>
			            <th>1.21出院时间：</th>
			            <td>
			                <tag:dateInput nullToToday="true" name="otherCondition.outhosDate" onlypast="true" pattern="yyyy/MM/dd"
		             			reg='{"compare":["inhosTime","ge","出院时间不能小于 住院时间"]}' date="${caseDto.otherCondition.outhosDate}"/>
		             	</td>
			        </tr>
			    </table>
			</fieldset>
			
			<fieldset>
			    <legend>2.临床表现</legend>
			    <table class="posttable">
			        <colgroup>
			            <col style="min-width: 185px; width: 20%"/>
			            <col style="min-width: 175px; width: 30%"/>
			            <col style="min-width: 125px; width: 20%"/>
			            <col style="min-width: 235px; width: 30%"/>
			        </colgroup>
			        <tr>
			            <th>2.1发热：</th>
			            <td><ehr:dic-radio name="clinicalManifestations.fever" dicmeta="PH00002" code="1,2,4" value="${caseDto.clinicalManifestations.fever}"/></td>
			            <th>2.2.热型：</th>
			            <td><ehr:dic-radio dicmeta="IDM00195" name="clinicalManifestations.hotType" value="${caseDto.clinicalManifestations.hotType}"/></td>
			        </tr>
			        <tr>
			            <th>2.3体温最高：</th>
			            <td>
							<input type="text" name="clinicalManifestations.highestTemperature" value="${caseDto.clinicalManifestations.highestTemperature}" 
			            	 				reg='{"maxlength":"20"}' style="width: 30%;"/>℃
						</td>
			            <th>2.4头痛：</th>
			            <td><ehr:dic-radio name="clinicalManifestations.headache" dicmeta="PH00002" code="1,2,4" value="${caseDto.clinicalManifestations.headache}"/></td>
			        </tr>
			        <tr>
			            <th>2.5全身酸痛：</th>
			            <td><ehr:dic-radio name="clinicalManifestations.muscularStiffness" dicmeta="PH00002" code="1,2,4" value="${caseDto.clinicalManifestations.muscularStiffness}"/></td>
			            <th>2.6眼结膜充血：</th>
			            <td><ehr:dic-radio name="clinicalManifestations.conjunctivalCongestion" dicmeta="PH00002" code="1,2,4" value="${caseDto.clinicalManifestations.conjunctivalCongestion}"/></td>
			        </tr>
			        <tr>
			            <th>2.7咽充血：</th>
			            <td><ehr:dic-radio name="clinicalManifestations.pharyngealCongestion" dicmeta="PH00002" code="1,2,4" value="${caseDto.clinicalManifestations.pharyngealCongestion}"/></td>
			            <th>2.8意识障碍：</th>
			            <td><ehr:dic-radio name="clinicalManifestations.disturbanceConsciousness" dicmeta="PH00002" code="1,2,4" value="${caseDto.clinicalManifestations.disturbanceConsciousness}"/></td>
			        </tr>
			        <tr>
			            <th>2.9烦燥谵妄：</th>
			            <td><ehr:dic-radio name="clinicalManifestations.delirium" dicmeta="PH00002" code="1,2,4" value="${caseDto.clinicalManifestations.delirium}"/></td>
			            <th>2.10昏睡昏迷：</th>
			            <td><ehr:dic-radio name="clinicalManifestations.coma" dicmeta="PH00002" code="1,2,4" value="${caseDto.clinicalManifestations.coma}"/></td>
			        </tr>
			        <tr>
			            <th>2.11血尿：</th>
			            <td><ehr:dic-radio name="clinicalManifestations.hematuresis" dicmeta="PH00002" code="1,2,4" value="${caseDto.clinicalManifestations.hematuresis}"/></td>
			            <th>2.12尿闭：</th>
			            <td><ehr:dic-radio name="clinicalManifestations.anuresis" dicmeta="PH00002" code="1,2,4" value="${caseDto.clinicalManifestations.anuresis}"/></td>
			        </tr>
			        <tr>
			            <th>2.13肝肿大：</th>
			            <td><ehr:dic-radio name="clinicalManifestations.hepatomegaly" dicmeta="PH00002" code="1,2,4" value="${caseDto.clinicalManifestations.hepatomegaly}"/></td>
			            <th>2.14脾肿大：</th>
			            <td><ehr:dic-radio name="clinicalManifestations.splenomegaly" dicmeta="PH00002" code="1,2,4" value="${caseDto.clinicalManifestations.splenomegaly}"/></td>
			        </tr>
			        <tr>
			            <th>2.15皮疹：</th>
			            <td><ehr:dic-radio name="clinicalManifestations.rash" dicmeta="PH00002" code="1,2,4" value="${caseDto.clinicalManifestations.rash}"/></td>
			            <th>2.16出疹日期：</th>
			            <td><tag:dateInput name="clinicalManifestations.rashDate" nullToToday="true" onlypast="true" pattern="yyyy/MM/dd" date="${caseDto.clinicalManifestations.rashDate}"/></td>
			        </tr>
			    </table>
			</fieldset>
			
			<fieldset>
			    <legend>3.流行病学调查</legend>
			    <table class="posttable">
			        <colgroup>
			            <col style="min-width: 185px; width: 20%"/>
			            <col style="min-width: 175px; width: 30%"/>
			            <col style="min-width: 125px; width: 20%"/>
			            <col style="min-width: 235px; width: 30%"/>
			        </colgroup>
			        <tr>
			            <th>3.1家庭或邻居中有无同样病人：</th>
			            <td colspan="3">
			            	<ehr:dic-radio dicmeta="PH00002" code="1,2" name="epidemiologicalSurvey.homeContactPatients" value="${caseDto.epidemiologicalSurvey.homeContactPatients}"
                                           onchange="toggleOther('epidemiologicalSurvey.homeContactPatients','homeContactPatientsForAdd',1)"/>
				            <span id="homeContactPatientsForAdd" style="display: none;" >3.1.1如有，则患病日期：
				            	<tag:dateInput name="epidemiologicalSurvey.homeContactPatientsDt" date="${caseDto.epidemiologicalSurvey.homeContactPatientsDt}"
				            		 pattern="yyyy/MM/dd" nullToToday="true" onlypast="true"  style="width: 30%"/>
				            </span> 
				          </td>
			        </tr>
			        <tr>
			            <th>3.2患者过去斑疹伤寒史：</th>
			            <td><ehr:dic-radio dicmeta="PH00002" code="1,2" name="epidemiologicalSurvey.typhus" value="${caseDto.epidemiologicalSurvey.typhus}"
                                           onchange="toggleOther('epidemiologicalSurvey.typhus','typhusForAdd',1)"/></td>
			        </tr>
                    <tr id="typhusForAdd" style="display: none;" >
                        <th>3.2.1如有，则患病日期：</th>
                        <td>
                            <tag:dateInput name="epidemiologicalSurvey.typhusDt" date="${caseDto.epidemiologicalSurvey.typhusDt}"
                                           pattern="yyyy/MM/dd" nullToToday="true" onlypast="true"/>
                        </td>
                    </tr>
			        <tr>
			            <th>3.3病前5～21天内外出史：</th>
			            <td><ehr:dic-radio dicmeta="PH00002" code="1,2" name="epidemiologicalSurvey.outHistory" value="${caseDto.epidemiologicalSurvey.outHistory}"
                                           onchange="toggleOther('epidemiologicalSurvey.outHistory','outHistoryForAdd',1)"/></td>
			        </tr>
                    <tr style="display: none;" id="outHistoryForAdd">
                        <td colspan="4" style="padding: 0px;">
                            <table>
                                <colgroup>
                                    <col style="min-width: 185px; width: 20%"/>
                                    <col style="min-width: 175px; width: 30%"/>
                                    <col style="min-width: 125px; width: 20%"/>
                                    <col style="min-width: 235px; width: 30%"/>
                                </colgroup>
                                <tr>
                                    <th>3.3.1如有，外出地点：</th>
                                    <td><input type="text" name="epidemiologicalSurvey.outHistoryAddr"
                                               value="${caseDto.epidemiologicalSurvey.outHistoryAddr}"
                                               reg="{'maxlength':'100'}"/></td>
                                    <th>3.3.2外出时间：</th>
                                    <td>
                                        <tag:dateInput id="outHistoryDeginDt"
                                                       name="epidemiologicalSurvey.outHistoryDeginDt"
                                                       style="width: 100px;"
                                                       date="${caseDto.epidemiologicalSurvey.outHistoryDeginDt}"
                                                       pattern="yyyy/MM/dd" nullToToday="true" onlypast="true"
                                                       reg='{"compare":["outHistoryEndDt","le","开始日期不能大于结束日期"]}'/>
                                        ~
                                        <tag:dateInput id="outHistoryEndDt" name="epidemiologicalSurvey.outHistoryEndDt"
                                                       style="width: 100px;"
                                                       date="${caseDto.epidemiologicalSurvey.outHistoryEndDt}"
                                                       pattern="yyyy/MM/dd" nullToToday="true" onlypast="true"
                                                       reg='{"compare":["outHistoryDeginDt","ge","结束日期不能小于开始日期"]}'/>
                                    </td>
                                </tr>
                            </table>
                        </td>
                    </tr>
			        <tr>
			            <th>3.3.3该地虱子：</th>
			            <td><ehr:dic-radio dicmeta="PH00002" code="1,2" name="epidemiologicalSurvey.louse" value="${caseDto.epidemiologicalSurvey.louse}"/></td>
			            <th>3.3.4该地跳蚤：</th>
			            <td><ehr:dic-radio dicmeta="PH00002" code="1,2" name="epidemiologicalSurvey.flea" value="${caseDto.epidemiologicalSurvey.flea}"/></td>
			        </tr>
			        <tr>
			            <th>3.3.5该地老鼠：</th>
			            <td><ehr:dic-radio dicmeta="PH00002" code="1,2" name="epidemiologicalSurvey.mouse" value="${caseDto.epidemiologicalSurvey.mouse}"/></td>
			            <th>3.3.6该地猫：</th>
			            <td><ehr:dic-radio dicmeta="PH00002" code="1,2" name="epidemiologicalSurvey.cat" value="${caseDto.epidemiologicalSurvey.cat}"/></td>
			        </tr>
			        <tr>
			            <th>3.4接触史：</th>
			            <td><ehr:dic-radio dicmeta="PH00002" code="1,2" name="epidemiologicalSurvey.contactHistory" value="${caseDto.epidemiologicalSurvey.contactHistory}"
                                           onchange="toggleOther('epidemiologicalSurvey.contactHistory','contactHistoryFromAdd',1)"/></td>
			        </tr>
			        <tr style="display: none;" id="contactHistoryFromAdd">
			        	<td colspan="4" style="padding: 0px;">
			        		<table>
			        			<colgroup>
						            <col style="width: 20%"/>
						            <col style="width: 30%"/>
						            <col style="width: 20%"/>
						            <col style="width: 30%"/>
						        </colgroup>
			        			<tr>
			        			   <th>3.4.1病人姓名：</th>
						            <td><input type="text" name="epidemiologicalSurvey.contactPatientName" value="${caseDto.epidemiologicalSurvey.contactPatientName}"  reg="{'maxlength':'50'}"/></td>
						            <th>3.4.2关系：</th>
						            <td><input type="text" name="epidemiologicalSurvey.contactRelation" value="${caseDto.epidemiologicalSurvey.contactRelation}"  reg="{'maxlength':'100'}"/></td>
                                </tr>
                                <tr>
                                    <th>3.4.3接触方式：</th>
                                    <td colspan="3">
                                        <ehr:dic-checkbox dicmeta="IDM00033"
                                                          name="epidemiologicalSurvey.contactWayMulti"
                                                          value="${caseDto.epidemiologicalSurvey.contactWayMulti}"/>
                                        <%--<span style="display: none;" id="contactWayFromAdd">--%>
                                        <%--<input name="epidemiologicalSurvey.immuniHistoryFormOther" type="text" value="${caseDto.epidemiologicalSurvey.immuniHistoryFormOther}" reg="{'maxlength':'200'}" style="width: 100px;"/>--%>
                                        <%--</span>--%>
                                    </td>
                                </tr>
                            </table>
                        </td>
                    </tr>
			        <tr>
			            <th>3.5居住条件：</th>
			        </tr>
			        <tr>
			            <th>3.5.1家庭居住面积：</th>
			            <td>
			            	<input type="text" name="epidemiologicalSurvey.livingSpace" value="${caseDto.epidemiologicalSurvey.livingSpace}"
	            						reg='{"maxlength":"20"}' cssClass="width30" style="width: 30%"/>
			            		M<sup>2</sup>，居住人数
			            	<input type="text"  name="epidemiologicalSurvey.livingNum" value="${caseDto.epidemiologicalSurvey.livingNum}"
	            						reg='{"maxlength":"20"}' cssClass="width30" style="width: 30%"/>人
			            </td>
			            <th>3.5.2周围环境卫生：</th>
			            <td><ehr:dic-radio dicmeta="PH00018" name="epidemiologicalSurvey.homeHealth" value="${caseDto.epidemiologicalSurvey.homeHealth}"/></td>
			        </tr>
			        <tr>
			            <th>3.5.3虱子：</th>
			            <td colspan="3">
			            	<ehr:dic-radio dicmeta="PH00002" code="1,2" name="epidemiologicalSurvey.homeLouse" value="${caseDto.epidemiologicalSurvey.homeLouse}"
			            	/>
			            	<span id="louse_num">
			            		每视野:<input type="text"  name="epidemiologicalSurvey.louse_num" value="${caseDto.epidemiologicalSurvey.louse_num}"
	            						reg='{"maxlength":"20"}' cssClass="width30" style="width: 20%"/>只
			            	</span>
			            </td>
			        </tr>
			        <tr>
                        <th>3.5.4该地跳蚤：</th>
                        <td><ehr:dic-radio dicmeta="PH00002" code="1,2" name="epidemiologicalSurvey.homeFlea" value="${caseDto.epidemiologicalSurvey.homeFlea}"/></td>
			            <th>3.5.5老鼠：</th>
			            <td><ehr:dic-radio dicmeta="PH00002" code="1,2" name="epidemiologicalSurvey.homeMouse" value="${caseDto.epidemiologicalSurvey.homeMouse}"/></td>
			        </tr>
			        <tr>
			        	 <th>3.5.6家中养猫：</th>
			            <td><ehr:dic-radio dicmeta="PH00002" code="1,2" name="epidemiologicalSurvey.homeCat" value="${caseDto.epidemiologicalSurvey.homeCat}"/></td>
			            <th>3.5.7家中养狗：</th>
			            <td><ehr:dic-radio dicmeta="PH00002" code="1,2" name="epidemiologicalSurvey.homeDog" value="${caseDto.epidemiologicalSurvey.homeDog}"/></td>
			        </tr>
			        <tr>
			            <th>3.6接种史：</th>
                        <td>
                            <ehr:dic-radio dicmeta="PH00002" code="1,2" name="epidemiologicalSurvey.inoculateHistory" value="${caseDto.epidemiologicalSurvey.inoculateHistory}"
                                           onchange="toggleOther('epidemiologicalSurvey.inoculateHistory','inoculateHistoryForAdd',1)"/>
                        </td>
                    </tr>
                    <tr style="display: none;" id="inoculateHistoryForAdd">
                        <th>接种日期：</th>
			            <td>
			                <tag:dateInput name="epidemiologicalSurvey.inoculateDt" date="${caseDto.epidemiologicalSurvey.inoculateDt}" pattern="yyyy/MM/dd"
			                nullToToday="true" onlypast="true" style="width: 30%"/>
			            </td>
			        </tr>
			    </table>
			</fieldset>
			
			<fieldset>
			    <legend>4.实验室检查结果</legend>
			    <table class="posttable">
			        <colgroup>
			            <col style="min-width: 120px; width: 20%"/>
			            <col style="min-width: 120px; width: 18%"/>
			            <col style="min-width: 120px; width: 14%"/>
			            <col style="min-width: 120px; width: 18%"/>
			            <col style="min-width: 100px; width: 14%"/>
			            <col style="min-width: 140px; width: 15%"/>
			        </colgroup>
			        <tr>
			            <th>4.1血清学：</th>
			        </tr>
			        <tr>
			            <th>4.1.1送检日期：</th>
			            <td><tag:dateInput name="labExamine.serologyDate" pattern="yyyy/MM/dd" nullToToday="true" onlypast="true" date="${caseDto.labExamine.serologyDate}"/></td>
			        </tr>
			        <tr>
			            <th>4.1.2结果：</th>
			        </tr>
			        <tr>
			            <th>4.1.2.1 OX2：</th>
			            <td><input type="text" name="labExamine.ox_2" value="${caseDto.labExamine.ox_2}" reg='{"maxlength":"100"}'/></td>
			            <th>4.1.2.2 OX19：</th>
			            <td><input type="text" name="labExamine.ox_1_9" value="${caseDto.labExamine.ox_1_9}" reg='{"maxlength":"100"}'/></td>
			            <th>4.1.2.3 OXK：</th>
			            <td><input type="text" name="labExamine.oxk" value="${caseDto.labExamine.oxk}" reg='{"maxlength":"100"}'/></td>
			        </tr>
			        <tr>
			            <th>4.2血常规：</th>
			        </tr>
			        <tr>
			            <th>4.2.1送检日期：</th>
			            <td><tag:dateInput name="labExamine.bloodtestsDate" pattern="yyyy/MM/dd" nullToToday="true" onlypast="true" date="${caseDto.labExamine.bloodtestsDate}"/></td>
			        </tr>
			        <tr>
			            <th>4.2.2结果：</th>
			        </tr>
			        <tr>
			            <th>4.2.2.1 白细胞总数：</th>
			            <td>
			            	<input type="text" name="labExamine.leukocyteCount" value="${caseDto.labExamine.leukocyteCount}"
	            						reg='{"maxlength":"20"}' cssClass="width30"/>
			            ×10<sup>9</sup>/L</td>
			            <th>4.2.2.2 中性：</th>
			            <td>
			            	<input type="text"  name="labExamine.neutrophilcell" value="${caseDto.labExamine.neutrophilcell}"
	            						reg='{"maxlength":"20"}' cssClass="width30"/>
			            %</td>
			            <th>4.2.2.3 淋巴细胞：</th>
			            <td>
			            	<input type="text"  name="labExamine.lymphocyte" value="${caseDto.labExamine.lymphocyte}"
	            						reg='{"maxlength":"20"}' cssClass="width30"/>
			            %</td>
			        </tr>
			        <tr>
			            <th>4.2.2.4 嗜酸性：</th>
			            <td>
			            	<input type="text"  name="labExamine.eosinophils" value="${caseDto.labExamine.eosinophils}"
	            						reg='{"maxlength":"20"}' cssClass="width30"/>
			            %</td>
			            <th>4.2.2.5 红细胞总数：</th>
			            <td>
			            	<input  type="text" name="labExamine.rbcCount" value="${caseDto.labExamine.rbcCount}"
	            						reg='{"maxlength":"20"}' cssClass="width30"/>
			            ×10<sup>9</sup>/L</td>
			            <th>4.2.2.6 血色素：</th>
			            <td>
			            	<input type="text" point="point" name="labExamine.hemochrome" value="${caseDto.labExamine.hemochrome}" 
								cssClass="width30" reg='{"maxlength":"20"}'/>
			            </td>
			        </tr>
			    </table>
			</fieldset>
			<fieldset>
			    <legend>5.密切接触者名单 </legend>
			    <table class="posttable">
			        <colgroup>
			            <col style="min-width: 185px; width: 20%"/>
			            <col style="min-width: 175px; width: 80%"/>
			        </colgroup>
			        <tr>
						<td colspan="2">
							<div id="contactedList">
								<jsp:include page="contactedList.jsp"></jsp:include>	
							</div>
						</td>
					</tr>
			    </table>
			</fieldset>
			<fieldset>
			    <legend>6.疫点处理</legend>
			    <table class="posttable">
			        <colgroup>
			            <col style="min-width: 185px; width: 20%"/>
			            <col style="min-width: 175px; width: 30%"/>
			            <col style="min-width: 125px; width: 20%"/>
			            <col style="min-width: 235px; width: 30%"/>
			        </colgroup>
			        <tr>
			            <th>6.1.1接报告（卡）日期：</th>
			            <td>
                            <fmt:formatDate value='${caseDto.caseInformation.reportDate}' pattern="yyyy/MM/dd" />
                            <tag:dateInput name="caseInformation.reportDate" pattern="yyyy/MM/dd" nullToToday="true" onlypast="true" date="${caseDto.caseInformation.reportDate}" style="display: none"/>
                        </td>
			            <th>6.1.2报告单位：</th>
			            <td>
                            <ehr:org code="${caseDto.caseInformation.reportOrg}" />
                            <input type="hidden" name="caseInformation.reportOrg" value="${caseDto.caseInformation.reportOrg}" reg='{"maxlength":"100"}'/>
                        </td>
			        </tr>
			        <tr>
			        	<th>6.1.3报告人：</th>
			            <td>
                            <ehr:user userCode="${caseDto.caseInformation.reportPerson}"/>
                            <input type="hidden" name="caseInformation.reportPerson" value="${caseDto.caseInformation.reportPerson}" reg='{"maxlength":"20"}'/>
                        </td>
			            <th>6.2初访日期：</th>
			            <td><tag:dateInput id="efirstVisitDate" name="epidemicFocusClose.firstVisitDate" pattern="yyyy/MM/dd" nullToToday="true" onlypast="true" 
			            date="${caseDto.epidemicFocusClose.firstVisitDate}" reg='{"compare":["secSupervisionDate","le","初访日期不能晚于第二次访视日期"]}'/></td>
			        </tr>
			        <tr>
			            <th>6.3.1灭虱情况：</th>
			            <td><ehr:dic-radio dicmeta="PH00016" name="epidemicFocusClose.delousingSituation" value="${caseDto.epidemicFocusClose.delousingSituation}" code="1,3,4,5"/></td>
			            <th>6.3.2灭蚤情况：</th>
			            <td><ehr:dic-radio dicmeta="PH00016" name="epidemicFocusClose.fleaSituation" value="${caseDto.epidemicFocusClose.fleaSituation}" code="1,3,4,5"/></td>
			        </tr>
			        <tr>
			            <th>6.3.3灭鼠情况：</th>
			            <td><ehr:dic-radio dicmeta="PH00016" name="epidemicFocusClose.deratizationSituation" value="${caseDto.epidemicFocusClose.deratizationSituation}" code="1,3,4,5"/></td>
			            <th>6.4第二次访视日期：</th>
			            <td><tag:dateInput id="secSupervisionDate" name="epidemicFocusClose.secSupervisionDate" date="${caseDto.epidemicFocusClose.secSupervisionDate}" pattern="yyyy/MM/dd"
			             nullToToday="true" onlypast="true" reg='{"compare":["efirstVisitDate","ge","第二次访视日期不能早于初访日期"]}'/></td>
			        </tr>
			        <tr>
			            <th>6.5有无续发病人：</th>
			            <td><ehr:dic-radio dicmeta="PH00002" code="1,2" name="epidemicFocusClose.isPeopleContinued" value="${caseDto.epidemicFocusClose.isPeopleContinued}"/></td>
			            <th>6.6病人转归：</th>
			            <td><ehr:dic-radio dicmeta="IDM00005" code="1,8,4" name="epidemicFocusClose.patientOutcome" value="${caseDto.epidemicFocusClose.patientOutcome}"/></td>
			        </tr>
			        <tr>
			            <th>6.7结案日期：</th>
			            <td><tag:dateInput name="epidemicFocusClose.dateClosed" pattern="yyyy/MM/dd" nullToToday="true" onlypast="true" date="${caseDto.epidemicFocusClose.dateClosed}"/></td>
			            <th>6.8感染来源：</th>
			            <td><ehr:dic-radio dicmeta="IDM00098" name="epidemicFocusClose.infectionSource" value="${caseDto.epidemicFocusClose.infectionSource}"/></td>
			        </tr>
			    </table>
			</fieldset>
			<fieldset>
			    <table class="posttable">
			        <colgroup>
			            <col style="min-width: 185px; width: 20%"/>
			            <col style="min-width: 175px; width: 30%"/>
			            <col style="min-width: 125px; width: 20%"/>
			            <col style="min-width: 235px; width: 30%"/>
			        </colgroup>
			        <tr>
			            <th>调查者单位：</th>
			            <td><ehr:org code="${caseDto.caseInformation.modifySurveyOrg}"/></td>
			            <th>调查者：</th>
			            <td><ehr:user userCode="${caseDto.caseInformation.modifyRespondents}"/></td>
	        		</tr>	
			        <tr>
			            <th>审查者：</th>
			            <td><ehr:user userCode="${caseDto.caseInformation.modifyRespondents}"/></td>
			            <th>调查时间：</th>
			            <td><tag:dateInput nullToToday="true" name="caseInformation.surveyDate" onlypast="true"
	                               pattern="yyyy/MM/dd"  date="${caseDto.caseInformation.surveyDate}"/></td>
			        </tr>
			        <tr style="display:none;">
			             <td>
			             	<input type="hidden" name="caseInformation.caseFillOrg" value="${caseDto.caseInformation.caseFillOrg}"/>
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
