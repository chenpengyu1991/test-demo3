<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<script src="${pageContext.request.contextPath}/js/views/idm/case/edit.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/views/idm/case/notHbv.js" type="text/javascript"></script>

<c:if test="${isPrint != 1}">
    <jsp:include page="caseButton.jsp"></jsp:include>
</c:if>
<form id="caseForm">
    <div class="postcontent <c:if test="${isPrint != 1}">contentfixed</c:if>">
		<i class="popno"> 病毒性肝炎病例（除乙肝外）个案调查表<br /> <span>（乙类传染病）</span>
		</i>
		<input type="hidden" name="idmId" value="${idmId}"/>
		<div class="postdiv">
            <table  class="posttable" >
                <colgroup>
                    <col style="width: 10%;"/>
                    <col style="width: 20%;"/>
                    <col style="width: 20%;"/>
                    <col style="width: 30%;"/>
                </colgroup>
                <tr>
	                <th>调查地区:</th>
	                <td colspan="3">
                        ${rootDicItem.itemName}
                        <ehr:dic-town-street-village streetId="revillage_address" townId="retown_address" streetName="generalCondition.restreet" townName="generalCondition.retownShip"
                           streetValue="${caseDto.generalCondition.restreet}" townValue="${caseDto.generalCondition.retownShip}" width="140px;"/>
                    </td>
                       
		         </tr>
		         <tr>
						<th>联系电话：</th>
						<td><input type="text" name="generalCondition.phoneNumber" value="${caseDto.generalCondition.phoneNumber}"
								   reg='{"regex":"phone"}'></td>
						<th>宅电：</th>
						<td><input type="text" name="generalCondition.familyPhone" value="${caseDto.generalCondition.familyPhone}"
								   reg='{"regex":"phone"}'></td>
				</tr>
				
               <%--  <tr>
                    <td>病例编号：<input type="text" name="caseInformation.mediRecordNum" style="width: 120px;"
                                   value="${caseDto.caseInformation.mediRecordNum}" reg='{"maxlength":"14"}'/></td>
                    </tr>
                    <tr>
                    <td colspan="4">（此项为“病例所在县区编码＋患者出生日期”，共14位，如北京市通州区编码110112患者出生日期为2003年1月8日，则病例编码为11011220030108）
                    </td>
                </tr>
                <tr>
                    <td style="text-align: left;">所在县区编码:<input type="text" name="caseInformation.wayResearchCode" style="width: 120px;"
                               value="${caseDto.caseInformation.wayResearchCode}" reg='{"length":"6"}'/></td>
                               <td style="text-align: right;">调查单位类别:<ehr:dic-radio name="caseInformation.surveyOrgGrade" dicmeta="IDM00208" value="${caseDto.caseInformation.surveyOrgGrade}"/></td>
                    <td style="text-align: right;">调查单位级别:<ehr:dic-radio name="caseInformation.surveyOrgType" dicmeta="IDM00372" value="${caseDto.caseInformation.surveyOrgType}" code="1,2,3,4"/></td>
                </tr> --%>
            </table>
			<fieldset>
				<legend>一、基本情况：</legend>
				<table class="posttable">
                    <colgroup>
                        <col style="width: 35%" />
                        <col style="width: 65%" />
                    </colgroup>
					<tr>
						<th>1.1 患者姓名：</th>
						<td colspan="3">
                            <input type="text" name="generalCondition.name" value="${caseDto.generalCondition.name}"
                                   reg='{"maxlength":"100"}' style="width: 150px;"/>                           
                        </td>
					</tr>
					 <tr>
	                    <th>1.2 性别：</th>
	                    <td><ehr:dic-radio dicmeta="GBT226112003" name="generalCondition.gender" code="1,2" value="${caseDto.generalCondition.gender}"/></td>
	                </tr>
	                <tr>
						<th>1.3 年龄：</th>
						<td colspan="3">
						<input type="text" id="age" name="generalCondition.age" style="width: 60px;" value="${caseDto.generalCondition.age}" reg='{"maxlength":"6"}'/>岁（周岁） 或
						 出生日期：<tag:dateInput name="generalCondition.birthday" date="${caseDto.generalCondition.birthday}" pattern="yyyy/MM/dd" style="width:90px;"/>
	                        	（阳历）
	                    </td>
					</tr>
					<tr>
	                    <th>1.4 职业：</th>
			            <td>
			            	<ehr:dic-list dicmeta="GBT6565" name="generalCondition.occupation" width="180px;" value="${caseDto.generalCondition.occupation}"
                                  code="CV020120214,CV020120209,CV020120211,CV020120203,4,CV020120215,CV020120299"
                                  onchange="toggleOtherSC('generalCondition.occupation','occupationPart','CV020120299');"/>
			            	 <span  id="occupationPart" style="display: none">
		                         <input type="text" name="generalCondition.occupationOther" value="${caseDto.generalCondition.occupationOther}"
		                                reg='{"maxlength":"30"}' placeholder="若选择其他，请描叙" style="width: 30%;"/>
		                     </span>
			            </td>
	                </tr> 
	                <tr>
						<th>1.5 常住类型：</th>
						<td>
							<ehr:dic-radio name="generalCondition.floatPopulation" dicmeta="FS10005"
										   value="${caseDto.generalCondition.floatPopulation}" onchange="caseEdit.toggerAddress()"/>
						</td>
					</tr>
					<tr>
						<th>1.6 现住地址：</th>
						<td >
                            <ehr:dic-town-street-village streetId="pastreet_address" townId="patown_address" streetName="generalCondition.pastreet" townName="generalCondition.patownShip"
                                                         streetValue="${caseDto.generalCondition.pastreet}" townValue="${caseDto.generalCondition.patownShip}" width="140px;"
                                                         villageId="pavillage_address" villageName="generalCondition.paGroup" villageValue="${caseDto.generalCondition.paGroup}"/>
                            <input type="text" id="pahouseNumber" name="generalCondition.pahouseNumber" value="${caseDto.generalCondition.pahouseNumber}"
								   style="width: 180px;" reg='{"maxlength":"50"}'>
							<span id="spanPaNumber">(门牌号)</span>
						</td>
					</tr>
					<tr>
						<th>1.7 工作单位：</th>
						<td><input type="text" name="generalCondition.unitName" value="${caseDto.generalCondition.unitName}" reg='{"maxlength":"70"}' style="width: 250px;"/></td>
					</tr>
					<tr>
						<th>1.8 户籍地址:</th>                    
	                    <td >
                             <input type="text" id="hrAddress" name="generalCondition.hrAddress" value="${caseDto.generalCondition.hrAddress}"
                           			reg='{"maxlength":"100"}'  style="width: 250px;">
	                    </td>
					</tr>	
				</table>
			</fieldset>
		</div>
		<div class="postdiv">
			<fieldset>
				<legend>二、发病情况</legend>
				<table class="posttable">
                    <colgroup>
                        <col style="width: 35%" />
                        <col style="width: 65%" />
                    </colgroup>
					<tr>
						<th>2.1 本病首次发病时间：</th>
						<td>
                       		<tag:dateInput id="pathogenesisDateId" name="attackCondition.pathogenesisDate" onlypast="true" date="${caseDto.attackCondition.pathogenesisDate}"
                               pattern="yyyy/MM/dd" reg='{"compare":["firstVisitDateId","le","发病日期不能晚于初诊日期"]}' style="width:120px;" />
                        </td>
					</tr>
                    <tr>
                        <th>2.2 本次发病就诊日期：</th>
                        <td> <tag:dateInput id="firstVisitDateId" name="attackCondition.firstVisitDate"  date="${caseDto.attackCondition.firstVisitDate}" style="width:120px;"
                               onlypast="true" pattern="yyyy/MM/dd"/></td>
                    </tr>
                    <tr>
                        <th>2.3 本次就诊医院名称:</th>
                        <td><input reg='{"maxlength":"100"}' type="text" name="attackCondition.confirmationHospital" value="${caseDto.attackCondition.confirmationHospital}" style="width:120px;"/></td>
                    </tr>
                    
				</table>
			</fieldset>
		</div>
		<div class="postdiv">
			<fieldset>
				<legend>三、临床资料（填写入院首次检查结果）</legend>
				<table class="posttable">
                    <colgroup>
                        <col style="width: 35%" />
                        <col style="width: 65%" />
                    </colgroup>
					<tr>
						<th>3.1临床表现</th>
                     	<td><ehr:dic-radio dicmeta="PH00002" name="diagnosis.clinicalFeature"
			            	 code="1,2" value="${caseDto.diagnosis.clinicalFeature}" onchange="toggleOther('diagnosis.clinicalFeature','clinicalFeature','1');"/> 
			            	 <br><span  id="clinicalFeature" style="display: none">
		                         <ehr:dic-checkbox dicmeta="IDM00620" name="clinicalManifestations.diseaseClinicalSymptoms"  value="${caseDto.clinicalManifestations.diseaseClinicalSymptoms}"/>
		                     </span>
						</td>
					</tr>
					<tr>
						<th style="font-weight: bold;">3.2 实验室资料</th>
					</tr>
                    <tr>
                        <th>3.2.1肝功能：填写“检测值/（正常值范围)”</th>
                        <td>ALT<input type="text" name="labExamine.alt" value="${caseDto.labExamine.alt}"
								   style="width: 100px;" reg='{"maxlength":"20"}'>/ <input type="text" name="labExamine.altScope" value="${caseDto.labExamine.altScope}"
								   style="width: 100px;" reg='{"maxlength":"20"}'>
							AST<input type="text" name="labExamine.ast" value="${caseDto.labExamine.ast}"
								   style="width: 100px;" reg='{"maxlength":"20"}'> / <input type="text" name="labExamine.astScope" value="${caseDto.labExamine.astScope}"
								   style="width: 100px;" reg='{"maxlength":"20"}'> 
								   
						</td>
                    </tr>
                    <tr>
                        <th>3.2．2血清学诊断结果：</th>
                        <td><ehr:dic-radio dicmeta="PH00004" name="labExamine.serologically"
			            	 code="1,2,3" value="${caseDto.labExamine.serologically}" /> </td>
                    </tr>
                     <tr  id="serologically">
                        <th></th>
                        <td><ehr:dic-checkbox dicmeta="IDM00621" name="labExamine.otherDiagnosed"  value="${caseDto.labExamine.otherDiagnosed}"/>
		                 </td>
                    </tr>
                    <tr>
                        <th>3.2.3 核酸检测结果：填写病毒载量定量结果或“+” “-”</th>
                        <td>HBVDNA<input type="text" name="labExamine.hbvdna" value="${caseDto.labExamine.hbvdna}"
	                                   reg='{"maxlength":"30"}' placeholder="" style="width: 50px;"/>HCVRNA<input type="text" name="labExamine.hcvrna" value="${caseDto.labExamine.hcvrna}"
	                                   reg='{"maxlength":"30"}' placeholder="" style="width: 50px;"/></td>
                       <%--  <td>HBVDNA <ehr:dic-list name="labExamine.hbvdna" dicmeta="IDM00329" code="3,2"></ehr:dic-list>HCVRNA <ehr:dic-list name="labExamine.hcvrna" dicmeta="IDM00329" code="3,2"></ehr:dic-list></td> --%>
                    </tr>
                    <tr>
                        <th>3.3临床分型</th>
                        <td><ehr:dic-radio name="attackCondition.clinicalClassification" dicmeta="IDM00622"
                        	value="${caseDto.attackCondition.clinicalClassification}" /></td>
                    </tr>
                    <tr>
                        <th>3.4影像学（包括B超、CT、MRI等）或病理诊断</th>
                        <td> <ehr:dic-list dicmeta="IDM00623" name="diagnosis.lastDiagnosis" width="180px;" value="${caseDto.diagnosis.lastDiagnosis}"
	                             onchange="toggleOtherSC('diagnosis.lastDiagnosis','lastDiagnosis','5');"/>
	                        <span  id="lastDiagnosis" style="display: none">
	                            <input type="text" name="diagnosis.diagnosisOther" value="${caseDto.diagnosis.diagnosisOther}"
	                                   reg='{"maxlength":"30"}' placeholder="描述" style="width: 200px;"/>
	                        </span>
	                    </td>
                    </tr> 
				</table>
			</fieldset>
		</div>
			<div class="postdiv">
			<fieldset>
				<legend>四、流行病学资料：（未分型肝炎以下项目均调查）</legend>
				<table class="posttable">
                    <colgroup>
                        <col style="width: 35%" />
                        <col style="width: 65%" />
                    </colgroup>
					<tr>
						<th>4.1近半年是否接触过肝炎病人</th>
						<td><ehr:dic-radio dicmeta="PH00002" name="epidemiologicalSurvey.hepatitisContactHistory" code="1,2" value="${caseDto.epidemiologicalSurvey.hepatitisContactHistory}"
                                  />
						</td>
					</tr>
                    <tr>
                        <th>4.1.1如有，则其临床诊断（可多选）：</th>
                        <td><ehr:dic-checkbox dicmeta="IDM00624"  name="epidemiologicalSurvey.chHepatitisCategory"
                                               value="${caseDto.epidemiologicalSurvey.chHepatitisCategory}"/></td>
                    </tr>
                    <tr>
                        <th>4.1.2接触方式（可多选）：</th>
                        <td><ehr:dic-checkbox dicmeta="IDM00033" name="epidemiologicalSurvey.contactWayMulti" code="1,2,4,5,99"
                                                value="${caseDto.epidemiologicalSurvey.contactWayMulti}" onchange="toggleOtherCK('epidemiologicalSurvey.contactWayMulti','contactWayMulti',99);"/>
                               <span id="contactWayMulti" style="display: none">
		                            <input type="text" name="epidemiologicalSurvey.contactRelationOther" value="${caseDto.epidemiologicalSurvey.contactRelationOther}"
		                                   style="width: 150px;" reg='{"maxlength":"20"}'/>
		                        </span>                
                          </td>
                    </tr>
                    <tr>
						<th style="font-weight: bold;">粪-口途径传播的肝炎（甲、戊肝）调查4.2-4.6 </th>
					</tr>
                    <tr>
                        <th>4.2近两个月至15天里不洁或可疑饮食史 </th>
                        <td><ehr:dic-radio dicmeta="PH00002" name="infectionSourceRoute.outBackFood" code="1,2"
						            		value="${caseDto.infectionSourceRoute.outBackFood}" onchange="toggleOther('infectionSourceRoute.outBackFood','outBackFoodName','1');"/></td>
                    </tr>
               
                    <tr>
                        <th>4.2.1如有，食物名称</th>
                        <td><input type="text" style="width: 150px;" name="infectionSourceRoute.outBackFoodName" value="${caseDto.infectionSourceRoute.outBackFoodName}" reg='{"maxlength":"100"}'/>
						            		</td>
                    </tr> 
                    <tr>
                        <th>4.2.2食用日期：</th>
                        <td> <tag:dateInput style="width: 150px;" id="haveFoodDt" name="infectionSourceRoute.haveFoodDt"  date="${caseDto.infectionSourceRoute.haveFoodDt}"
                               onlypast="true" pattern="yyyy/MM/dd"/></td>
                    </tr> 
                    <tr>
                        <th>4.2.3食物来源（或食用地点）</th>
                        <td><input type="text"  style="width: 150px;" name="infectionSourceRoute.haveFoodAddr" value="${caseDto.infectionSourceRoute.haveFoodAddr}" reg='{"maxlength":"50"}'/>
						            		</td>
                    </tr> 
                    <tr>
                        <th>4.3近两个月有无食用生水</th>
                        <td> <ehr:dic-radio dicmeta="PH00002" name="beforeDiseaseDiet.drinkingHistory" code="1,2" value="${caseDto.beforeDiseaseDiet.drinkingHistory}"
                       			/></td>
			            		<%-- onchange="toggleOther('beforeDiseaseDiet.drinkingHistory','waterType',1)"/></td> --%>
                    </tr> 
                    <tr>
                        <th>4.3.1如有，水质为 </th>
                        <td> <ehr:dic-radio dicmeta="IDM00625" name="hygienicCondition.drinkingType"
            	 				 value="${caseDto.hygienicCondition.drinkingType}"
            	 				  onchange="toggleOther('hygienicCondition.drinkingType','drinkingType','4');"/>
				            	 <span  id="drinkingType" style="display: none">
			                         <input type="text" name="hygienicCondition.drinkingTypeOther" value="${caseDto.hygienicCondition.drinkingTypeOther}"
			                                reg='{"maxlength":"30"}' placeholder="" style="width: 30%;"/>
			                     </span> 			 
            	 	     </td>
                    </tr> 
                    <tr>
                        <th>4.3.2饮用日期为</th>
                        <td> <tag:dateInput id="drinkingDate" name="hygienicCondition.drinkingDate"  date="${caseDto.hygienicCondition.drinkingDate}"
                               onlypast="true" pattern="yyyy/MM/dd" style="width: 150px;"/></td>
                    </tr> 
                    <tr>
                        <th>4.3.3 饮水地点</th>
                        <td><input type="text" name="hygienicCondition.drinkingAddr" value="${caseDto.hygienicCondition.drinkingAddr}"
			                                reg='{"maxlength":"30"}' placeholder="" style="width: 150px;"/></td>
                    </tr> 
                    
                    <tr>
                        <th>4.4近两个月有无食用未煮熟的海鲜</th>
                        <td> <ehr:dic-radio dicmeta="PH00002" name="beforeDiseaseDiet.coldFood" code="1,2" value="${caseDto.beforeDiseaseDiet.coldFood}"
			            		onchange="toggleOther('beforeDiseaseDiet.coldFood','waterType',1)"/></td>
                    </tr> 
                    <tr>
                        <th>4.4.1如有，海鲜的名称</th>
                        <td><input type="text" name="beforeDiseaseDiet.coldFoodName" value="${caseDto.beforeDiseaseDiet.coldFoodName}"
						                                reg='{"maxlength":"30"}' placeholder="" style="width: 150px;"/> </td>
                    </tr> 
                    <tr>
                        <th>4.4.2食用日期：</th>
                        <td> <tag:dateInput id="eatTime" name="beforeDiseaseDiet.eatTime"  date="${caseDto.beforeDiseaseDiet.eatTime}"
                               onlypast="true" pattern="yyyy/MM/dd" style="width: 150px;"/></td>
                    </tr> 
                    <tr>
                        <th>4.4.3食用地点</th>
                        <td><input type="text" name="beforeDiseaseDiet.coldFoodBuyPlace" value="${caseDto.beforeDiseaseDiet.coldFoodBuyPlace}"
						                                reg='{"maxlength":"30"}' placeholder="" style="width: 150px;"/> </td>
                    </tr> 
                    <tr>
                        <th>4.5近两个月有无宰杀生畜</th>
                        <td><ehr:dic-radio dicmeta="PH00002" name="beforeDiseaseDiet.killingAnimals" code="1,2" value="${caseDto.beforeDiseaseDiet.killingAnimals}"
			            		/></td>
                    </tr> 
                    <tr>
                        <th>4.6近两个月有无食用未煮熟的动物内脏</th>
                        <td> <ehr:dic-radio dicmeta="PH00002" name="beforeDiseaseDiet.haveVisceral" code="1,2" value="${caseDto.beforeDiseaseDiet.haveVisceral}"
			            		/></td>
                    </tr> 
                    <tr>
                        <th>4.6.1如有，内脏的名称</th>
                        <td><input type="text" name="beforeDiseaseDiet.visceralName" value="${caseDto.beforeDiseaseDiet.visceralName}"
						                                reg='{"maxlength":"30"}' placeholder="" style="width: 150px;"/> </td>
                    </tr> 
                    <tr>
                        <th>4.6.2食用日期：</th>
                        <td> <tag:dateInput id="eatTime" name="beforeDiseaseDiet.visceralDate"  date="${caseDto.beforeDiseaseDiet.visceralDate}"
                               onlypast="true" pattern="yyyy/MM/dd" style="width: 150px;"/></td>
                    </tr> 
                    <tr>
                        <th>4.6.3食用地点</th>
                        <td><input type="text" name="beforeDiseaseDiet.visceralAddr" value="${caseDto.beforeDiseaseDiet.visceralAddr}"
						                                reg='{"maxlength":"30"}' placeholder="" style="width: 150px;"/> </td>
                    </tr>  
                    <tr>
						<th style="font-weight: bold;">血源途径传播肝炎（丙、丁、庚）调查4.7-4.13</th>
					</tr>
                    <tr>
                        <th>4.7有无手术史</th>
                        <td><ehr:dic-radio name="exposureHistory.operation" dicmeta="PH00002" code="1,2" value="${caseDto.exposureHistory.operation}"/></td>					
                    </tr> 
                    <tr>
                        <th>4.7.1如有，手术时间</th>
                        <td> <tag:dateInput style="width: 150px;" id="operationDt" name="exposureHistory.operationDt"  date="${caseDto.exposureHistory.operationDt}"
                               onlypast="true" pattern="yyyy/MM"/></td>
                    </tr>
                    <tr>
                        <th>4.7.2手术医院</th>
                        <td><input style="width: 150px;" type="text" name="exposureHistory.operationUnit" value="${caseDto.exposureHistory.operationUnit}"
						                                reg='{"maxlength":"30"}' placeholder="" /> </td>
                    </tr> 
                    <tr>
                        <th>4.8有无受输血史</th>
                        <td><ehr:dic-radio name="exposureHistory.receptionBloodHistory" dicmeta="PH00002" code="1,2"
                                           value="${caseDto.exposureHistory.receptionBloodHistory}"/></td>

                    </tr> 
                    <tr>
                        <th> 4.8.1 如有，则输血次数：</th>
                        <td><input type="text" name="exposureHistory.receptionBloodNum" value="${caseDto.exposureHistory.receptionBloodNum}"
						                                reg='{"maxlength":"30"}' placeholder="" style="width: 150px;"/>次 </td>
                    </tr> 
                    
                    <tr>
                        <th>4.8.2输血时间：</th>
                        <td><tag:dateInput id="receptionBloodEndDt" name="exposureHistory.receptionBloodEndDt"  date="${caseDto.exposureHistory.receptionBloodEndDt}"
                               onlypast="true" pattern="yyyy/MM" style="width: 150px;"/></td>
                    </tr> 
                    <tr>
                        <th>4.8.3输血医院</th>
                        <td><input type="text" name="exposureHistory.receptionBloodUnit" value="${caseDto.exposureHistory.receptionBloodUnit}"
						                                reg='{"maxlength":"30"}' placeholder="" style="width: 150px;"/> </td>
                    </tr> 
                    
                    <tr>
                        <th>4.9有无拔牙、补牙、洗牙等口腔诊疗史</th>
                        <td> <ehr:dic-radio name="exposureHistory.tooth" dicmeta="PH00002" code="1,2" value="${caseDto.exposureHistory.tooth}"/></td>					
                    </tr> 
                    <tr>
                        <th>4.9.1治疗时间</th>
                        <td> <tag:dateInput id="toothDt" name="exposureHistory.toothDt"  date="${caseDto.exposureHistory.toothDt}"
                               onlypast="true" pattern="yyyy/MM" style="width: 150px;"/></td>
                    </tr> 
                    <tr>
                        <th>4.9.2治疗医院</th>
                        <td><input type="text" name="exposureHistory.toothUnit" value="${caseDto.exposureHistory.toothUnit}"
						                                reg='{"maxlength":"30"}' placeholder="" style="width: 150px;"/> </td>
                    </tr> 
                    <tr>
                        <th>4.10有无针灸治疗史</th>
                        <td><ehr:dic-radio name="exposureHistory.acupuncture" dicmeta="PH00002" code="1,2"
                                           value="${caseDto.exposureHistory.acupuncture}"/></td>
                    </tr> 
                    <tr>
                        <th>4.10.1治疗时间</th>
                        <td> <tag:dateInput id="acupunctureDate" name="exposureHistory.acupunctureDate"  date="${caseDto.exposureHistory.acupunctureDate}"
                               onlypast="true" pattern="yyyy/MM" style="width: 150px;"/></td>
                    </tr> 
                    <tr>
                        <th>4.10.2治疗医院</th>
                        <td><input type="text" name="exposureHistory.acupunctureUnit" value="${caseDto.exposureHistory.acupunctureUnit}"
						                                reg='{"maxlength":"30"}' placeholder="" style="width: 150px;"/> </td>
                    </tr> 
                    <tr>
                        <th>4.11是否经常去修面、修体毛或刮胡须、修脚</th>
                        <td> <ehr:dic-radio name="exposureHistory.pedicureFrequency" dicmeta="IDM00007" code="4,3,2" value="${caseDto.exposureHistory.pedicureFrequency}"/></td>
					
                    </tr> 
                    <tr>
                        <th>4.12有无创伤性美容史（纹眉、绣眉、眼线、唇线、纹身、打耳洞等）</th>
                        <td><ehr:dic-radio name="exposureHistory.traumaticTreatment" dicmeta="PH00002" code="1,2"
                                           value="${caseDto.exposureHistory.traumaticTreatment}"/></td>			
                    </tr> 
                    <tr>
						<th>4.13据您所知，与您一起居住满3个月的人有无肝炎病毒感染者</th>
						<td><ehr:dic-radio name="exposureHistory.hepatitisBPatientContact" dicmeta="PH00002" code="1,2" value="${caseDto.exposureHistory.hepatitisBPatientContact}"
                                          onchange="toggleOther('exposureHistory.hepatitisBPatientContact','hepatitisBPatientCategory',1);"/></td>
					</tr>
					<tr id="hepatitisBPatientCategory" style="display: none">
						<th>4.13.1如有，则关系为</th>
						<td>
                            <ehr:dic-checkbox name="exposureHistory.hepatitisBPatientCategory" dicmeta="IDM00626" value="${caseDto.exposureHistory.hepatitisBPatientCategory}"
                                               onchange="toggleOtherCK('exposureHistory.hepatitisBPatientCategory','hepatitisBPatientOther',99);" />
                        </td>
					</tr> 
				</table>
			</fieldset>
		</div>

		<div class="postdiv">
			<fieldset>
				<legend>五、 免疫史</legend>
				<table class="posttable">
                    <colgroup>
                        <col style="width: 35%" />
                        <col style="width: 65%" />
                    </colgroup>                 
					<tr>
						<th>5.1是否接种过甲肝疫苗</th>
						<td><ehr:dic-radio name="epidemiologicalSurvey.aimmugen" dicmeta="PH00002" code="1,2" value="${caseDto.epidemiologicalSurvey.aimmugen}"
                                onchange="toggleOther('epidemiologicalSurvey.aimmugen','aimmugenPart',1)"/></td>
					</tr>
                    <tr id="aimmugenPart" style="display: none;">
                        <th>5.1.1如有，则接种日期</th>
                        <td>
                            <tag:dateInput name="epidemiologicalSurvey.aimmugenDtF" pattern="yyyy/MM" id="aimmugenDtF" onlypast="true"
                                           date="${caseDto.epidemiologicalSurvey.aimmugenDtF}" style="width:100px;" reg='{"compare":["aimmugenDtS","le","第一针时间不能晚于第二针时间"]}'/>
                            <tag:dateInput name="epidemiologicalSurvey.aimmugenDtS" pattern="yyyy/MM" id="aimmugenDtS" onlypast="true"
                                           date="${caseDto.epidemiologicalSurvey.aimmugenDtS}" style="width:100px;" reg='{"compare":["aimmugenDtF","ge","第二针时间不能早于第一针时间"]}'/>
                        </td>
                    </tr>
                    <tr>
						<th>5.2是否接种过乙肝疫苗</th>
						<td><ehr:dic-radio name="epidemiologicalSurvey.hepatitisBVaccine" dicmeta="PH00002" code="1,2"  value="${caseDto.epidemiologicalSurvey.hepatitisBVaccine}"
                                           onchange="toggleOther('epidemiologicalSurvey.hepatitisBVaccine','hepatitisBVaccine',1);"/></td>
					</tr>
                    <tr id="hepatitisBVaccine" style="display: none;">
                        <th> 5.2.1如有，则接种日期</th>
                        <td>
                            <tag:dateInput id="hepatitisBVaccineDtF" name="epidemiologicalSurvey.hepatitisBVaccineDtF" pattern="yyyy/MM" onlypast="true"
                                           date="${caseDto.epidemiologicalSurvey.hepatitisBVaccineDtF}" style="width:100px;" reg='{"compare":["hepatitisBVaccineDtS","le","第一针时间不能晚于第二针时间"]}'/>
                            <tag:dateInput id="hepatitisBVaccineDtS" name="epidemiologicalSurvey.hepatitisBVaccineDtS" pattern="yyyy/MM" onlypast="true"
                                           date="${caseDto.epidemiologicalSurvey.hepatitisBVaccineDtS}" style="width:100px;" reg='{"compare":["hepatitisBVaccineDtF","ge","第二针时间不能早于第一针时间"]}'/>
                            <tag:dateInput id="hepatitisBVaccineDtT" name="epidemiologicalSurvey.hepatitisBVaccineDtT" pattern="yyyy/MM" onlypast="true"
                                           date="${caseDto.epidemiologicalSurvey.hepatitisBVaccineDtT}" style="width:100px;" reg='{"compare":["hepatitisBVaccineDtS","ge","第三针时间不能早于第二针时间"]}'/>
                        </td>
                    </tr>
				</table>
			</fieldset>
		</div>
		
		<div class="postdiv">
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
					</tr>
					<tr style="display:none;">
			             <td>
			             	<input type="hidden" name="caseInformation.caseFillOrg" value="${caseDto.caseInformation.caseFillOrg}"/>
			             	<input type="hidden" name="caseInformation.modifySurveyOrg" value="${caseDto.caseInformation.modifySurveyOrg}"/>
			             	<input type="hidden" name="caseInformation.modifyRespondents" value="${caseDto.caseInformation.modifyRespondents}"/>
			             	<%-- <input type="hidden" name="caseInformation.auditor" value="${caseDto.caseInformation.auditor}"/> --%>
			             </td> 
			         </tr>
				</table>
			</fieldset>
		</div>
	</div>
</form>
