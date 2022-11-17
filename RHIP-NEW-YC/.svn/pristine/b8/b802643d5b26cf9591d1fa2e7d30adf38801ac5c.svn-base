<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tag" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<script src="${pageContext.request.contextPath}/js/views/idm/case/edit.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/views/idm/case/hemorrhagicFever.js" type="text/javascript"></script>

<c:if test="${isPrint != 1}">
    <jsp:include page="caseButton.jsp"></jsp:include>
</c:if>
<form id="caseForm">
    <div class="postcontent <c:if test="${isPrint != 1}">contentfixed</c:if>">
		<i class="popno">
		    流行性出血热个案调查表<br/>
		    <span>（乙类传染病）</span>
		</i>
		<input type="hidden" name="idmId" value="${idmId}" id="idmId"/>
		<div class="postdiv">
			<fieldset>
			    <table class="posttable">
			        <colgroup>
			            <col style="width: 20%"/>
			            <col style="width: 27%"/>
			            <col style="width: 25%"/>
			            <col style="width: 28%"/>
			        </colgroup>
			        <tr>
			            <th>县（市）名称：</th>
			            <td>
			            	<label>${rootDicItem.itemName}</label>
			            </td>
			            <th>国标码：</th>
			            <td>
			            	<input type="text" name="generalCondition.gbcode" value="${caseDto.generalCondition.gbcode}" reg='{"maxlength":"14"}'/>
			            </td>
			        </tr>
			        <tr>
			            <th>病例编号：</th>
			            <td colspan="3">
			            	<input type="text" name="caseInformation.mediRecordNum" reg='{"maxlength":"14"}' value="${caseDto.caseInformation.mediRecordNum}"
			            	style="width: 20%"/>（病例编号填写说明：年号（两位数）、流水号（后边三位））
			            </td>
			        </tr>
			    </table>
			</fieldset>
			<fieldset>
			    <legend>一、基本情况</legend>
			    <table class="posttable">
			        <colgroup>
			            <col style="width: 20%"/>
			            <col style="width: 27%"/>
			            <col style="width: 25%"/>
			            <col style="width: 28%"/>
			        </colgroup>
			        <tr>
			            <th>1. 患者姓名：</th>
			            <td>
			            	<input type="text" name="generalCondition.name" value="${caseDto.generalCondition.name}" 
						        reg='{"maxlength":"100"}'/>
			            </td>
			            <th>如患者年龄<14岁，则家长姓名：</th>
			            <td>
			            	 <input type="text" name="generalCondition.parentsName" value="${caseDto.generalCondition.parentsName}" 
							   reg='{"maxlength":"50"}'/>
			            </td>
			        </tr>
			        <tr>
			            <th>2. 性别：</th>
			            <td><ehr:dic-radio name="generalCondition.gender" dicmeta="GBT226112003" value="${caseDto.generalCondition.gender}" code="1,2"/></td>
			            <th>3. 年龄：</th>
			            <td>
			            	<input type="text" id="age" name="generalCondition.age" value="${caseDto.generalCondition.age}" 
							   reg='{"maxlength":"6"}'cssClass="width30" style="width: 30%"/>岁
			            </td>
			        </tr>
			        <tr>
			            <th>4. 民族：</th>
			            <td>
							<ehr:dic-list name="generalCondition.nation" dicmeta="GBT3304" value="${caseDto.generalCondition.nation}"
							 width="70%" onchange="toggleOtherSC('generalCondition.nation','nationOtherDiv','99');" code="01,08,05,99"/>
							  <span id="nationOtherDiv" style="display: none">
		                         <input type="text" name="generalCondition.nationOther" value="${caseDto.generalCondition.nationOther}"
		                                reg='{"maxlength":"30"}' style="width: 20%;"/>
		                     </span>
						</td>
			            <th>5. 职业：</th>
			            <td>
			                <ehr:dic-list dicmeta="GBT6565" name="generalCondition.occupation" width="180px;" value="${caseDto.generalCondition.occupation}"
                                  code="CV020120201,CV020120202,CV020120203,CV020120204,CV020120205,4-3,CV020120207,CV020120226,2-15,CV020120208,CV020120209,CV020120210,CV020120211,CV020120212,CV020120213,CV020120227,CV020120214,CV020120215,CV020120216,CV020120227,2-15,4-3,CV020120299"
                                  onchange="toggleOtherSC('generalCondition.occupation','occupationPartd','CV020120299');"/>
			            	 <span id="occupationPartd" style="display: none">
		                         <input type="text" name="generalCondition.occupationOther" value="${caseDto.generalCondition.occupationOther}"
		                                reg='{"maxlength":"30"}' placeholder="" style="width: 20%;"/>
		                     </span>
			            </td>
			        </tr>
			        <tr>
			            <th>6．所在单位：</th>
			            <td> <input reg='{"maxlength":"70"}' type="text" name="generalCondition.unitName" value="${caseDto.generalCondition.unitName}"/></td>
			            <th>联系电话：</th>
			            <td>
			            	<input type="text" name="generalCondition.phoneNumber" value="${caseDto.generalCondition.phoneNumber}"
			            	 reg='{"regex":"phone","maxlength":20}'/>
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
						<th>7．家庭住址：</th>
                        <td colspan="3">
							<ehr:dic-town-street-village streetId="pastreet_address" townId="patown_address" streetName="generalCondition.pastreet" townName="generalCondition.patownShip"
														 streetValue="${caseDto.generalCondition.pastreet}" townValue="${caseDto.generalCondition.patownShip}" width="140px;"
														 villageId="pavillage_address" villageName="generalCondition.paGroup" villageValue="${caseDto.generalCondition.paGroup}"/>
							<input type="text" id="pahouseNumber" name="generalCondition.pahouseNumber" value="${caseDto.generalCondition.pahouseNumber}"
								   reg='{"maxlength":"50"}'  style="width: 180px;">
							<span id="spanPaNumber">(门牌号)</span>
                        </td>
					</tr>
			    </table>
			</fieldset>
			<fieldset>
			    <legend>二、发病情况</legend>
			    <table class="posttable">
			         <colgroup>
			            <col style="width: 20%"/>
			            <col style="width: 27%"/>
			            <col style="width: 25%"/>
			            <col style="width: 28%"/>
			        </colgroup>
			        <tr>
			            <th>1. 发病日期：</th>
			            <td>
			            	<tag:dateInput id="pathogenesisDate" name="attackCondition.pathogenesisDate" onlypast="true"
						         reg='{"compare":["clinicDate","le","发病日期不能大于就诊日期"]}' pattern="yyyy/MM/dd" date="${caseDto.attackCondition.pathogenesisDate }"/>
						 </td>
			            <th>2. 就诊日期：</th>
			            <td>
			            	<tag:dateInput id="clinicDate" name="attackCondition.clinicDate" onlypast="true"
						         reg='{"compare":["pathogenesisDate","ge","就诊日期不能小于发病日期"]}' pattern="yyyy/MM/dd" date="${caseDto.attackCondition.clinicDate }"/>
			            </td>
			        </tr>
			        <tr>
			            <th>3. 发病地点：</th>
			            <td>
			            	<input reg='{"maxlength":"100"}' type="text" name="attackCondition.pathogenesisPlace" value="${caseDto.attackCondition.pathogenesisPlace}"/>
			            </td>
			        </tr>
			        <tr>
			            <th>4. 住院医院：</th>
			            <td>
			            	<input reg='{"maxlength":"100"}' type="text" name="attackCondition.admissionHospital" value="${caseDto.attackCondition.admissionHospital}"/>
			            </td>
			            <th>5. 住院号：</th>
			            <td>
			            	<input reg='{"maxlength":"100"}' type="text" name="attackCondition.admissionNo" value="${caseDto.attackCondition.admissionNo}"/>
			            </td>
			        </tr>
			        <tr>
			            <th>6. 住院日期：</th>
			            <td>
			            	<tag:dateInput id="inhosDate" name="attackCondition.inhosDate" onlypast="true" pattern="yyyy/MM/dd"
							     reg='{"compare":["outHospitalDate","le","入院时间不能大于出院时间"]}' date="${caseDto.attackCondition.inhosDate}"/>
							             
			            </td>
			            <th>7. 出院日期：</th>
			            <td>
			            	<tag:dateInput id="outHospitalDate" name="attackCondition.outHospitalDate" onlypast="true" pattern="yyyy/MM/dd"
							     reg='{"compare":["inhosDate","ge","出院时间不能小于入院时间"]}' date="${caseDto.attackCondition.outHospitalDate}"/>
			            </td>
			        </tr>
			        <tr>
			            <th>8. 入院诊断：</th>
			            <td>
			            	<ehr:dic-list name="attackCondition.inhosDiagnosis"  dicmeta="IDM00040" code="1,2,3,99" value="${caseDto.attackCondition.inhosDiagnosis }"
			            		onchange="toggleOtherSC('attackCondition.inhosDiagnosis','inhosDiagnosisOther','99')" width="70%"/>
			            	<span style="display: none;" id="inhosDiagnosisOther">
			            		<input type="text" name="attackCondition.inhosDiagnosisOther" value="${caseDto.attackCondition.inhosDiagnosisOther}" reg='{"maxlength":"100"}'/>
			            	</span>
			            </td>
			            <th>9. 临床诊断日期：</th>
			            <td>
			            	<tag:dateInput id="inhosDiagnosisDate" name="attackCondition.inhosDiagnosisDate" onlypast="true" pattern="yyyy/MM/dd"
							     reg='{"compare":["inhosDate","ge","临床诊断不能小于入院时间"]}' date="${caseDto.attackCondition.inhosDiagnosisDate}"/>
			            </td>
			        </tr>
			        <tr>
			            <th>10. 出院诊断：</th>
			            <td>
			            	<ehr:dic-list name="attackCondition.outDiagnosis" dicmeta="IDM00040" code="1,2,3,99" value="${caseDto.attackCondition.outDiagnosis }"
			            		onchange="toggleOtherSC('attackCondition.outDiagnosis','outDiagnosisOther','99')" width="70%"/>
			            	<span style="display: none;" id="outDiagnosisOther">
			            		<input type="text" name="attackCondition.outDiagnosisOther" value="${caseDto.attackCondition.outDiagnosisOther}" reg='{"maxlength":"100"}'/>
			            	</span>
			            </td>
			            <th>11．临床分型：</th>
			            <td>
			            	<ehr:dic-list name="attackCondition.clinicalClassification" dicmeta="IDM00081" uninclude="1,5,99"
			            	value="${caseDto.attackCondition.clinicalClassification }" width="70%"/>
			            </td>
			        </tr>
			        <tr>
			            <th>12. 转归：</th>
			            <td colspan="3">
			            	<ehr:dic-radio name="otherCondition.outcomeCode" dicmeta="CV550102" code="1,2,4" 
			            	value="${caseDto.otherCondition.outcomeCode}" onchange="toggleOther('otherCondition.outcomeCode','deathTime','4')"/>
			            	<span id="deathTime" style="display: none;">
			            		日期<tag:dateInput id="deathTime" nullToToday="true" name="otherCondition.deathTime" onlypast="true" pattern="yyyy/MM/dd"
							     reg='{"compare":["inhosDate","ge","死亡日期不能小于入院时间"]}' date="${caseDto.otherCondition.deathTime}" style="width:30%"/>
			            	</span>
			            </td>
			        </tr>
			
			    </table>
			</fieldset>
			<fieldset>
			    <legend>三、症状和体征及一般实验室检查</legend>
			    <table class="posttable">
			         <colgroup>
			            <col style="width: 28%"/>
			            <col style="width: 27%"/>
			            <col style="width: 25%"/>
			            <col style="width: 20%"/>
			        </colgroup>
			        <tr>
			            <th>1. 起病急：</th>
			            <td><ehr:dic-radio name="clinicalManifestations.onset" dicmeta="PH00001" code="1,2" value="${caseDto.clinicalManifestations.onset}"/></td>
			            <th>2. 乏力：</th>
			            <td><ehr:dic-radio name="clinicalManifestations.feeble" dicmeta="PH00002" code="1,2" value="${caseDto.clinicalManifestations.feeble}"/></td>
			        </tr>
			        <tr>
			            <th>3. 发热：</th>
			            <td><ehr:dic-radio name="clinicalManifestations.fever" dicmeta="PH00002" code="1,2" value="${caseDto.clinicalManifestations.fever}"/></td>
			            <th>4. 头痛：</th>
			            <td><ehr:dic-radio name="clinicalManifestations.headache" dicmeta="PH00002" code="1,2" value="${caseDto.clinicalManifestations.headache}"/></td>
			        </tr>
			        <tr>
			            <th>5. 腰痛：</th>
			            <td><ehr:dic-radio name="clinicalManifestations.abdominalPainParts" dicmeta="PH00002" code="1,2" value="${caseDto.clinicalManifestations.abdominalPainParts}"/></td>
			            <th>6. 眼眶痛：</th>
			            <td><ehr:dic-radio name="clinicalManifestations.orbitalPain" dicmeta="PH00002" code="1,2" value="${caseDto.clinicalManifestations.orbitalPain}"/></td>
			        </tr>
			        <tr>
			            <th>7. 脸红：</th>
			            <td><ehr:dic-radio name="clinicalManifestations.blush" dicmeta="PH00002" code="1,2" value="${caseDto.clinicalManifestations.blush}"/></td>
			            <th>8. 颈红：</th>
			            <td><ehr:dic-radio name="clinicalManifestations.neckReds" dicmeta="PH00002" code="1,2" value="${caseDto.clinicalManifestations.neckReds}"/></td>
			        </tr>
			        <tr>
			            <th>9. 胸红：</th>
			            <td><ehr:dic-radio name="clinicalManifestations.brightBreasted" dicmeta="PH00002" code="1,2" value="${caseDto.clinicalManifestations.brightBreasted}"/></td>
			            <th>10. 关节痛：</th>
			            <td><ehr:dic-radio name="clinicalManifestations.limbAche" dicmeta="PH00002" code="1,2" value="${caseDto.clinicalManifestations.limbAche}"/></td>
			        </tr>
			        <tr>
			            <th>11. 全身痛：</th>
			            <td><ehr:dic-radio name="clinicalManifestations.muscularStiffness" dicmeta="PH00002" code="1,2" value="${caseDto.clinicalManifestations.muscularStiffness}"/></td>
			            <th>12. 腹痛：</th>
			            <td><ehr:dic-radio name="clinicalManifestations.stomachache" dicmeta="PH00002" code="1,2" value="${caseDto.clinicalManifestations.stomachache}"/></td>
			        </tr>
			        <tr>
			            <th>13. 腹泻：</th>
			            <td><ehr:dic-radio name="clinicalManifestations.diarrhea" dicmeta="PH00002" code="1,2" value="${caseDto.clinicalManifestations.diarrhea}"/></td>
			            <th>14. 便秘：</th>
			            <td><ehr:dic-radio name="clinicalManifestations.constipation" dicmeta="PH00002" code="1,2" value="${caseDto.clinicalManifestations.constipation}"/></td>
			        </tr>
			        <tr>
			            <th>15.恶心：</th>
			            <td><ehr:dic-radio name="clinicalManifestations.nausea" dicmeta="PH00002" code="1,2" value="${caseDto.clinicalManifestations.nausea}"/></td>
			            <th>16.呕吐：</th>
			            <td><ehr:dic-radio name="clinicalManifestations.vomit" dicmeta="PH00002" code="1,2" value="${caseDto.clinicalManifestations.vomit}"/></td>
			        </tr>
			        <tr>
			            <th>17.结膜充血：</th>
			            <td><ehr:dic-radio name="clinicalManifestations.conjunctivalCongestion" dicmeta="PH00002" code="1,2" value="${caseDto.clinicalManifestations.conjunctivalCongestion}"/></td>
			            <th>18.眼睑浮肿：</th>
			            <td><ehr:dic-radio name="clinicalManifestations.eyelidsSwelling" dicmeta="PH00002" code="1,2" value="${caseDto.clinicalManifestations.eyelidsSwelling}"/></td>
			        </tr>
			        <tr>
			            <th>19.黄疸：</th>
			            <td><ehr:dic-radio name="clinicalManifestations.jaundice" dicmeta="PH00002" code="1,2" value="${caseDto.clinicalManifestations.jaundice}"/></td>
			        </tr>
			        <tr>
			            <th>20. 腋下/上臂/胸部或其它部位有无皮肤出血点：</th>
			            <td colspan="3">
			            	<ehr:dic-radio name="clinicalManifestations.isPetechiaeAlarArmChest" dicmeta="PH00002" code="1,2" 
			            	value="${caseDto.clinicalManifestations.isPetechiaeAlarArmChest}"
			            	onchange="toggleOther('clinicalManifestations.isPetechiaeAlarArmChest','alarArmChestValue',1)"/>
			            	<span id="alarArmChestValue" style="display: none;">
			            	出血点为：<ehr:dic-radio name="clinicalManifestations.alarArmChestValue" dicmeta="IDM00095"
				            	value="${caseDto.clinicalManifestations.alarArmChestValue}"
				            	onchange="toggleOther('clinicalManifestations.alarArmChestValue','alarArmChestOther',99)"/>
			            	<span id="alarArmChestOther" style="display: none;">
				            	<input style="width: 40%" type="text" name="clinicalManifestations.alarArmChestOther"
				            	 value="${caseDto.clinicalManifestations.alarArmChestOther}" reg='{"maxlength":"100"}'/>
			            	</span>
			            	</span>
			            </td>
			        </tr>
			        <tr>
			            <th>21. 口腔、鼻腔等处粘膜有无出血点：</th>
			            <td><ehr:dic-radio name="clinicalManifestations.isPetechiaeOralNasal" dicmeta="PH00002" code="1,2" value="${caseDto.clinicalManifestations.isPetechiaeOralNasal}"/></td>
			            <th>22. 少尿或无尿：</th>
			            <td><ehr:dic-radio name="clinicalManifestations.oliguria" dicmeta="PH00002" code="1,2" value="${caseDto.clinicalManifestations.oliguria}"/></td>
			        </tr>
			        <tr>
			            <th>23. 低血压：</th>
			            <td><ehr:dic-radio name="clinicalManifestations.hypotension" dicmeta="PH00002" code="1,2" value="${caseDto.clinicalManifestations.hypotension}"/></td>
			            <th>24. 休克：</th>
			            <td><ehr:dic-radio name="clinicalManifestations.septicStock" dicmeta="PH00002" code="1,2" value="${caseDto.clinicalManifestations.septicStock}"/></td>
			        </tr>
			        <tr>
			            <th>25. 白细胞计数：</th>
			            <td><ehr:dic-radio name="labExamine.leukocyteCountFlg" dicmeta="PH00013" uninclude="3" value="${caseDto.labExamine.leukocyteCountFlg}"/></td>
			            <th>26. 血小板减少：</th>
			            <td><ehr:dic-radio name="labExamine.plateletReduce" dicmeta="PH00002" code="1,2,3" value="${caseDto.labExamine.plateletReduce}"/></td>
			        </tr>
			        <tr>
			            <th>27. 尿蛋白：</th>
			            <td><ehr:dic-radio name="labExamine.urineProtein" dicmeta="PH00004" uninclude="4,7,6,99" value="${caseDto.labExamine.urineProtein}"/></td>
			            <th>28. 有无尿膜状物/管型尿/血尿：</th>
			            <td><ehr:dic-radio name="labExamine.cylinderuriaFlg" dicmeta="PH00002" code="1,2" value="${caseDto.labExamine.cylinderuriaFlg}"/></td>
			        </tr>
			        <tr>
			            <th>29. 束臂试验：</th>
			            <td colspan="3"><ehr:dic-radio name="labExamine.cuffButter" dicmeta="PH00004" uninclude="4,7,6,99" value="${caseDto.labExamine.cuffButter}"/></td>
			        </tr>
			         <tr>
			             <th>30. 出血时间：</th>
			            <td colspan="3"><ehr:dic-radio id="haemorrhageTime" name="labExamine.haemorrhageTime" dicmeta="PH00014" value="${caseDto.labExamine.haemorrhageTime}"/></td>
			        </tr>
			        <tr>
			            <th>31. 凝血时间：</th>
			            <td colspan="3"><ehr:dic-radio id="cruorTime" name="labExamine.cruorTime" dicmeta="PH00014" value="${caseDto.labExamine.cruorTime}"/></td>
			        </tr>
			    </table>
			</fieldset>
			<fieldset>
			    <legend>四、血清学及病原学检测结果（未做者请注明为"未做"）</legend>
			    <table class="posttable">
			        <colgroup>
			           <col style="width: 28%"/>
			            <col style="width: 25%"/>
			            <col style="width: 22%"/>
			            <col style="width: 25%"/>
			        </colgroup>
			        <tr>
			        	<th>4.1 出血热抗体IgG标本采集时间：</th>
			            <td>
			            	<tag:dateInput name="labExamine.ehfIggCollecttime" onlypast="true" pattern="yyyy/MM/dd"
							     date="${caseDto.labExamine.ehfIggCollecttime}"/>
			            </td>
			        	<th>出血热抗体IgG检测方法：</th>
			        	 <td>
			            	<input type="text" name="labExamine.ehfIggTestMethod" value="${caseDto.labExamine.ehfIggTestMethod}" reg='{"maxlength":"100"}'/>
			            </td>
			        </tr>
			        <tr>
			        	<th>出血热抗体IgG检测结果：</th>
			        	<td colspan="3">
			        		<input type="text" name="labExamine.ehfIggTestResult" value="${caseDto.labExamine.ehfIggTestResult}"  reg='{"maxlength":"100"}'/>
			        	</td>
			        </tr>
			        <tr>
			        	<th>4.2 出血热抗体IgM标本采集时间：</th>
			        	 <td>
			            	<tag:dateInput name="labExamine.ehfIgmCollecttime" onlypast="true" pattern="yyyy/MM/dd"
							     date="${caseDto.labExamine.ehfIgmCollecttime}"/>
			            </td>
			        	<th>出血热抗体IgM检测方法：</th>
			        	<td>
			            	<input type="text" name="labExamine.ehfIgmTestMethod" value="${caseDto.labExamine.ehfIgmTestMethod}" reg='{"maxlength":"100"}'/>
			            </td>
			        </tr>
			         <tr>
			        	<th>出血热抗体IgM检测结果：</th>
			        	<td colspan="3">
			            	<input type="text" name="labExamine.ehfIgmTestResult" value="${caseDto.labExamine.ehfIgmTestResult}" reg='{"maxlength":"100"}'/>
			        	</td>
			        </tr>
			        <tr>
			        	<th>4.3 汉坦病毒分离标本采集时间：</th>
			        	<td>
			            	<tag:dateInput name="labExamine.hantavirusCollectime" onlypast="true" pattern="yyyy/MM/dd"
							     date="${caseDto.labExamine.hantavirusCollectime}"/>
			            </td>
			        	<th>汉坦病毒分离检测方法：</th>
			        	<td>
			            	<input type="text" name="labExamine.hantavirusTestMethod" value="${caseDto.labExamine.hantavirusTestMethod}" reg='{"maxlength":"100"}'/>
			            </td>
			        </tr>
			         <tr>
			        	<th>汉坦病毒分离检测结果：</th>
			        	<td colspan="3">
			            	<input type="text" name="labExamine.hantavirusTestResult" value="${caseDto.labExamine.hantavirusTestResult}" reg='{"maxlength":"100"}'/>
			        	</td>
			        </tr>
			    </table>
			</fieldset>
			<fieldset>
			    <legend>五、既往史及家庭情况</legend>
			    <table class="posttable">
			        <colgroup>
			            <col style="width: 28%"/>
			            <col style="width: 72%"/>
			        </colgroup>
			        <tr>
			            <th>1. 既往是否患过此病：</th>
			            <td>
			            	<ehr:dic-radio name="pastHistory.pastEhfFlg" dicmeta="PH00001" uninclude="3" value="${caseDto.pastHistory.pastEhfFlg}"
			            	onchange="toggleOther('pastHistory.pastEhfFlg','ehfDiagnoseUnit',1)"/>
			            	<span id="ehfDiagnoseUnit" style="display: none;">
			            	诊断单位:<input type="text" name="pastHistory.ehfDiagnoseUnit" value="${caseDto.pastHistory.ehfDiagnoseUnit}"
			            	 reg='{"maxlength":"200"}' style="width: 36%"/>
			          		  时间:<tag:dateInput nullToToday="true" name="pastHistory.ehfDiagnoseTime" onlypast="true" pattern="yyyy/MM/dd"
							     date="${caseDto.pastHistory.ehfDiagnoseTime}" style="width: 15%"/>
			            	</span>
			            </td>
			        </tr>
			        <tr>
			            <th>2．食物、粮食有无防鼠设备：</th>
			            <td><ehr:dic-radio name="pastHistory.ratproofFlg" dicmeta="PH00002" uninclude="3,5" value="${caseDto.pastHistory.ratproofFlg}"/></td>
			        </tr>
			        <tr>
			            <th>3. 流行性出血热疫苗预防接种史：</th>
			            <td>
			            	<ehr:dic-radio name="pastHistory.ehfVaccineFlg" dicmeta="PH00002" uninclude="3,5" value="${caseDto.pastHistory.ehfVaccineFlg}"
			            	onchange="toggleOther('pastHistory.ehfVaccineFlg','lastTimeVaccinate',1);"/>
			            	<span id="lastTimeVaccinate">
			            		最近一次接种时间:
			            		<tag:dateInput nullToToday="true" onlypast="true" name="pastHistory.lastTimeVaccinate" 
			            			pattern="yyyy/MM/dd" date="${caseDto.pastHistory.lastTimeVaccinate }" style="width: 15%"/>
			            	</span>
			            </td>
			        </tr>
			        <tr>
			            <th>4. 有无家庭其他成员出现过类似症状：</th>
			            <td>
			            	<ehr:dic-radio name="pastHistory.familyEhfSymptoms" dicmeta="PH00002" uninclude="3,5" value="${caseDto.pastHistory.familyEhfSymptoms}"
			            	onchange="toggleOther('pastHistory.familyEhfSymptoms','familyEhfTime',1);"/>
			            	<span id="familyEhfTime" >
				            	最近一例发病时间（患者除外）:
				            	<tag:dateInput nullToToday="true" onlypast="true" name="pastHistory.familyEhfTime" 
				            		pattern="yyyy/MM/dd" date="${caseDto.pastHistory.familyEhfTime }" style="width: 15%"/>
			            	</span>
			            </td>
			        </tr>
			        <tr>
			            <th>5. 房内有无鼠：</th>
			            <td><ehr:dic-radio name="pastHistory.ratsFlg" dicmeta="PH00002" code="1,2" value="${caseDto.pastHistory.ratsFlg}"/></td>
			        </tr>
			        <tr>
			           <th>6. 院内有无杂物、草堆等：</th>
			            <td><ehr:dic-radio name="pastHistory.variaFlg" dicmeta="PH00002" code="1,2" value="${caseDto.pastHistory.variaFlg}"/></td>
			         </tr>
			    </table>
			</fieldset>
			<fieldset>
			    <legend>六、接触史及有关因素调查</legend>
			    <table class="posttable">
			        <colgroup>
			            <col style="width: 35%"/>
			            <col style="width: 65%"/>
			        </colgroup>
			        <tr>
			            <th>1. 发病前2个月内是否有外出（或旅游）史：</th>
			            <td>
			            	<ehr:dic-radio name="epidemicFocusClose.isTourismHistory" dicmeta="PH00001" code="1,2" value="${caseDto.epidemicFocusClose.isTourismHistory}"
			            	onchange="toggleOther('epidemicFocusClose.isTourismHistory','goWhere',1)"/>
			            </td>
			        </tr>
			        <tr id="goWhere" style="display: none;">
			         <th></th>
			         <td> 到何地:
			         	<input type="text" name="epidemicFocusClose.goWhere" value="${caseDto.epidemicFocusClose.goWhere}"
			         	 style="width:30%" reg='{"maxlength":"200"}'/>
			         	外出时间:<input type="text" name="epidemicFocusClose.absenceDwellTime" value="${caseDto.epidemicFocusClose.absenceDwellTime}" 
													cssClass="width30" reg='{"maxlength":"20"}' style="width: 5%" /> 天
						返回时间:<tag:dateInput nullToToday="true" onlypast="true" name="epidemicFocusClose.returnTime" pattern="yyyy/MM/dd"
			            	 date="${caseDto.epidemicFocusClose.returnTime}" style="width:15%"/>
			         </td>
			        </tr>
			        <tr>
			            <th>2. 发病前1月内是否接触鼠类：</th>
			            <td colspan="3">
			            	<ehr:dic-radio name="epidemicFocusClose.contactRat" dicmeta="PH00001" value="${caseDto.epidemicFocusClose.contactRat}"
			            		onchange="toggleOther('epidemicFocusClose.contactRat','contactForm',1)" uninclude="3"/>
			            	<span id="contactForm" style="display: none;">
			            	接触方式:<ehr:dic-list name="epidemicFocusClose.contactForm" dicmeta="IDM00155" value="${caseDto.epidemicFocusClose.contactForm}"
			            		onchange="toggleOtherSC('epidemicFocusClose.contactForm','contactFormOther',99)" defaultval="Y"/>
			            	<span id="contactFormOther" style="display: none;">
			            		<input style="width: 15%;" type="text" name="epidemicFocusClose.contactFormOther" 
			            		value="${caseDto.epidemicFocusClose.contactFormOther}" reg='{"maxlength":"200"}'/>
			            	</span>
			            	
			            	</span>
			            </td>
			        </tr>
			        <tr>
			            <th>3. 发病前1月内是否有昆虫叮咬史：</th>
			            <td>
			            	<ehr:dic-radio name="epidemicFocusClose.isInsectBitesHistory" dicmeta="PH00001" 
			            	value="${caseDto.epidemicFocusClose.isInsectBitesHistory}" uninclude="3"/>
			            </td>
			        </tr>
			        <tr>
			         	<th>4. 发病前1月内是否吃过被鼠排泄物污染的食物：</th>
			            <td>
			            	<ehr:dic-radio name="epidemicFocusClose.isRatFecesPollution" dicmeta="PH00001" 
			            	value="${caseDto.epidemicFocusClose.isRatFecesPollution}" uninclude="3"/>
			            </td>
			        </tr>
			        <tr>
			            <th>5. 发病前1月内是否在野外喝过沟（塘）水：</th>
			            <td>
			            	<ehr:dic-radio name="epidemicFocusClose.isDrankFieldWater" dicmeta="PH00001" 
			            	value="${caseDto.epidemicFocusClose.isDrankFieldWater}" uninclude="3"/>
			            </td>
			        </tr>
			        <tr>
			        	 <th>6. 发病前1月内是否在鼠洞附近坐卧：</th>
			            <td>
			            	<ehr:dic-radio name="epidemicFocusClose.isSitRat" dicmeta="PH00001" 
			            	value="${caseDto.epidemicFocusClose.isSitRat}" uninclude="3"/>
			            </td>
			        </tr>
			        <tr>
			            <th>7. 发病前1月内是否在场院禾草上坐卧：</th>
			            <td>
			            	<ehr:dic-radio name="epidemicFocusClose.isSitGrass" dicmeta="PH00001" 
			            	value="${caseDto.epidemicFocusClose.isSitGrass}" uninclude="3"/>
			            </td>
			        </tr>
			        <tr>
			        	<th>8. 发病前1月内是否在野外住宿：</th>
			            <td>
			            	<ehr:dic-radio name="epidemicFocusClose.isStayaccom" dicmeta="PH00001" value="${caseDto.epidemicFocusClose.isStayaccom}"
			            	onchange="toggleOther('epidemicFocusClose.isStayaccom','isSitGrassTr',1)" uninclude="3"/>
			            </td>
			        </tr>
			        <tr id="isSitGrassTr"style="display: none;" >
			            <th></th>
			            <td>具体地点:<input type="text" name="epidemicFocusClose.placeDetail" value="${caseDto.epidemicFocusClose.placeDetail}"
			             reg='{"maxlength":"200"}'/><br/>
				           其附近有无鼠、鼠洞或鼠排泄物:<ehr:dic-radio name="epidemicFocusClose.isRatNearby" dicmeta="PH00001"
				            value="${caseDto.epidemicFocusClose.isRatNearby}" uninclude="3"/><br/>
				        	铺的类型:<ehr:dic-radio name="epidemicFocusClose.shopType" dicmeta="IDM00156" value="${caseDto.epidemicFocusClose.shopType}"
			            	onchange="toggleOther('epidemicFocusClose.shopType','otherShopType',99)"/>
			            	<span id="otherShopType" style="display: none;">
			            		<input style="width:15%;" type="text" name="epidemicFocusClose.otherShopType" 
			            	value="${caseDto.epidemicFocusClose.otherShopType}" reg='{"maxlength":"200"}'/>
			            	</span>
				        </td>
			        </tr>
			        <tr>
			            <th>9． 工作场所有无鼠或鼠排泄物：</th>
			            <td>
			            	<ehr:dic-radio name="epidemicFocusClose.isRatWorkplace" dicmeta="PH00002" uninclude="3,5"
			            	value="${caseDto.epidemicFocusClose.isRatWorkplace}"/>
			            </td>
			        </tr>
			        <tr>
			            <th>10．发病前1月内是否接触过出血热病人血/尿：</th>
			            <td>
			            	<ehr:dic-radio name="epidemicFocusClose.isHemBloodUrine" dicmeta="PH00002" uninclude="3,5" 
			            	value="${caseDto.epidemicFocusClose.isHemBloodUrine}"/>
			            </td>
			        </tr>
			    </table>
			</fieldset>
			<fieldset>
		    	<table class="posttable">
			        <colgroup>
			            <col style="width: 10%"/>
			            <col style="width: 15%"/>
			            <col style="width: 10%"/>
			            <col style="width: 25%"/>
			            <col style="width: 10%"/>
			            <col style="width: 25%"/>
			        </colgroup>
			        <tr>
			            <th>调查日期：</th>
			            <td><tag:dateInput nullToToday="true" name="caseInformation.modifySurveyDate" onlypast="true"
				                               pattern="yyyy/MM/dd" reg='{"required":"true"}' date="${caseDto.caseInformation.modifySurveyDate}"/></td>
		                <th>调查地点：</th>
		                <td><input type="text" name="caseInformation.wayResearchCode" value="${caseDto.caseInformation.wayResearchCode}" reg='{"maxlength":"100"}'/></td>
			        	<%-- <th>调查单位：</th>
			             <td><ehr:org code="${caseDto.caseInformation.modifySurveyOrg}"/></td> --%>
			        	<th>调查者：</th>
			             <td><ehr:user userCode="${caseDto.caseInformation.modifyRespondents}"/></td>
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
