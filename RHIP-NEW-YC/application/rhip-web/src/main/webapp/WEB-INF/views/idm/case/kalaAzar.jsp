<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tag" %>

<script src="${pageContext.request.contextPath}/js/views/idm/case/edit.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/views/idm/case/kalaAzar.js" type="text/javascript"></script>

<c:if test="${isPrint != 1}">
    <jsp:include page="caseButton.jsp"></jsp:include>
</c:if>
<form id="caseForm">
	<input type="hidden" id="idmId" name="idmId" value="${idmId}"/>
    <div class="postcontent <c:if test="${isPrint != 1}">contentfixed</c:if>">
		<i class="popno">
		    黑热病个案调查表<br/>
		    <span>（丙类传染病）</span>
		</i>
		<table class="repost_table" style="text-align: right;">
		    <tr>
		        <td>
	                病例编码<input type="text" name="caseInformation.mediRecordNum" reg='{"maxlength":"14"}' value="${caseDto.caseInformation.mediRecordNum}" style="width: 20%"/>
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
			            <th>1.1姓名：</th>
			            <td>
			            	<input type="text" name="generalCondition.name" value="${caseDto.generalCondition.name}" 
			            	 	reg='{"maxlength":"100"}'/>
			            </td>
			            <th>1.2身份证号码:</th>
			            <td><input type="text" id="idCard" name="generalCondition.idcard" value="${caseDto.generalCondition.idcard}"  reg='{"idCard":"true"}'
                                   placeholder="输入身份证获取个人信息"/></td>
			        </tr>
			        <tr>
			            <th>1.3性别：</th>
			            <td>
			               <ehr:dic-radio dicmeta="GBT226112003" name="generalCondition.gender" code="1,2" value="${caseDto.generalCondition.gender}"/>
			            </td>
			            <th>1.4年龄(岁)：</th>
			            <td>
			            	<input type="text" id="age" name="generalCondition.age" value="${caseDto.generalCondition.age}"
				            	reg='{"maxlength":"6"}' cssClass="width30"/>
						</td>
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
						   <ehr:dic-town-street-village streetId="pastreet_address" townId="patown_address" streetName="generalCondition.pastreet" townName="generalCondition.patownShip"
														streetValue="${caseDto.generalCondition.pastreet}" townValue="${caseDto.generalCondition.patownShip}" width="140px;"
														villageId="pavillage_address" villageName="generalCondition.paGroup" villageValue="${caseDto.generalCondition.paGroup}"/>
						   <input type="text" id="pahouseNumber" name="generalCondition.pahouseNumber" value="${caseDto.generalCondition.pahouseNumber}"
                                   reg='{"maxlength":"50"}'  style="width: 180px;">
                        	<span id="spanPaNumber">(门牌号)</span>
                        </td>
			        </tr>
			        <tr>
			            <th>1.7联系电话：</th>
			            <td><input type="text" name="generalCondition.mobile" value="${caseDto.generalCondition.mobile}" reg='{"regex":"phone","maxlength":20}' style="width: 36%"/></td>
			            <th>1.8家长或监护人姓名：</th>
			            <td>
			            	<input type="text" name="generalCondition.parentsName" value="${caseDto.generalCondition.parentsName}" 
				             reg='{"maxlength":"50"}'/>
			            </td>
			        </tr>
			        <tr>
			           <th>1.7 工作（学习）单位</th>
			            <td colspan="3">
			                <input reg='{"maxlength":"70"}' type="text" name="generalCondition.unitName" value="${caseDto.generalCondition.unitName}"/>
			            </td>
			        </tr>
<!-- 			        <tr> -->
<!-- 						<th>1.10常住类型</th> -->
<!-- 						<td> -->
<%-- 							<ehr:dic-radio dicmeta="FS10005" name="generalCondition.hrPlace" --%>
<%-- 								value='${"2" != caseDto.generalCondition.hrPlace? "1" : "2"}' onchange="caseEdit.showHrPlace()"/>  --%>
<!-- 						</td> -->
<!-- 					</tr> -->
					<tr>
						<th>户籍地址</th>
						<td colspan="3">
							<ehr:dic-town-street-village villageId="hrvillage_address" townId="hrtown_address" villageName="generalCondition.paGroup" townName="generalCondition.hrtownShip"
														 villageValue="${caseDto.generalCondition.paGroup}" townValue="${caseDto.generalCondition.hrtownShip}" width="140px;"
														 streetId="hrstreet_address" streetName="generalCondition.hrstreet" streetValue="${caseDto.generalCondition.hrstreet}"/>

							<input type="text" name="generalCondition.hrhouseNumber" id="hrhouseNumber" value="${caseDto.generalCondition.hrhouseNumber}"
                                    style="width: 300px;" reg='{"maxlength":"50"}'>
                            <span id="spanHrNumber">(门牌号)</span>
                        </td>
					</tr>
			        <tr>
			        	<th>1.11发病时间：</th>
			        	<td>
			            	<tag:dateInput id="pathogenesisDate" nullToToday="true" name="attackCondition.pathogenesisDate" onlypast="true"
			                    reg='{"compare":["firstVisitDate","le","发病日期不能大于初诊时间"]}' pattern="yyyy/MM/dd" date="${caseDto.attackCondition.pathogenesisDate }"/>
			            </td>
			             <th>1.12发病地点：</th>
			            <td>
			                <input reg='{"maxlength":"100"}' type="text" name="attackCondition.pathogenesisPlace" value="${caseDto.attackCondition.pathogenesisPlace}"/>
			            </td>
			        </tr>
			        <tr>
			            <th>1.13初诊时间：</th>
			           <td>
			                <tag:dateInput id="firstVisitDate" nullToToday="true" name="attackCondition.firstVisitDate"  onlypast="true"
			                    reg='{"compare":["pathogenesisDate","ge","首诊时间不能小于发病日期"]}' pattern="yyyy/MM/dd" date="${caseDto.attackCondition.firstVisitDate }"/>
			            </td>
			            <th>1.14初诊单位：</th>
						<td>
			                <input reg='{"maxlength":"100"}' type="text" name="attackCondition.firstVisitUnit" value="${caseDto.attackCondition.firstVisitUnit}"/>
			            </td>
			        </tr>
			        <tr>
			            <th>1.15初诊病名：</th>
			            <td><input type="text" name="attackCondition.firstVisitName" value="${caseDto.attackCondition.firstVisitName}" reg='{"maxlength":"100"}'/></td>
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
			            <th>1.18入院时间：</th>
			            <td>
				           <tag:dateInput id="inhosTime" nullToToday="true" name="otherCondition.inhosTime" onlypast="true" pattern="yyyy/MM/dd"
				            	reg='{"compare":["pathogenesisDate","ge","住院时间不能小于发病日期"]}' date="${caseDto.otherCondition.inhosTime}"/>
				       </td>
			        </tr>
			        <tr>
			            <th>1.19所住医院：</th>
			            <td>
			            	<input reg='{"maxlength":"100"}' type="text" name="attackCondition.admissionHospital" value="${caseDto.attackCondition.admissionHospital}"/>
			            </td>
			            <th>1.20出院时间：</th>
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
			            <col style="width: 20%"/>
			            <col style="width: 30%"/>
			            <col style="width: 20%"/>
			            <col style="width: 30%"/>
			        </colgroup>
			        <tr>
			            <th>2.1 主要症状：</th>
			        <tr>
			        <tr>
			            <th>2.1.1 发热：</th>
			            <td><ehr:dic-radio dicmeta="PH00002" code="1,2" value="${caseDto.clinicalManifestations.fever}" name="clinicalManifestations.fever"/></td>
			            <th>2.1.2 寒战：</th>
			            <td><ehr:dic-radio dicmeta="PH00002" code="1,2" value="${caseDto.clinicalManifestations.chill}" name="clinicalManifestations.chill"/></td>
			        </tr>
			        <tr>
			            <th>2.1.3 出汗：</th>
			            <td><ehr:dic-radio dicmeta="PH00002" code="1,2" value="${caseDto.clinicalManifestations.sweat}" name="clinicalManifestations.sweat"/></td>
			            <th>2.1.4 脾肿发现日期：</th>
			            <td>
			            	<input type="text" name="clinicalManifestations.spleenSwollenDate" value="${caseDto.clinicalManifestations.spleenSwollenDate}" 
	            			reg='{"maxlength":"20"}' cssClass="width30" style="width: 30%"/>天
	            		</td>
			        </tr>
			        <tr>
			            <th>2.1.5 体重减轻：</th>
			            <td><ehr:dic-radio dicmeta="PH00002" code="1,2" value="${caseDto.clinicalManifestations.loseWeight}" name="clinicalManifestations.loseWeight"/></td>
			            <th>2.1.6 体力衰退：</th>
			            <td><ehr:dic-radio dicmeta="PH00002" code="1,2" value="${caseDto.clinicalManifestations.weightRecession}" name="clinicalManifestations.weightRecession"/></td>
			        </tr>
			        <tr>
			            <th>2.1.7 头痛：</th>
			            <td><ehr:dic-radio dicmeta="PH00002" code="1,2" value="${caseDto.clinicalManifestations.headache}" name="clinicalManifestations.headache"/></td>
			            <th>2.1.8 夜盲：</th>
			            <td><ehr:dic-radio dicmeta="PH00002" code="1,2" value="${caseDto.clinicalManifestations.nyctalopia}" name="clinicalManifestations.nyctalopia"/></td>
			        </tr>
			        <tr>
			            <th>2.1.9 鼻血：</th>
			            <td><ehr:dic-radio dicmeta="PH00002" code="1,2" value="${caseDto.clinicalManifestations.nosebleed}" name="clinicalManifestations.nosebleed"/></td>
			            <th>2.1.10 齿龈出血：</th>
			            <td><ehr:dic-radio dicmeta="PH00002" code="1,2" value="${caseDto.clinicalManifestations.gingivalBleeding}" name="clinicalManifestations.gingivalBleeding"/></td>
			        </tr>
			        <tr>
			            <th>2.1.11 气喘：</th>
			            <td><ehr:dic-radio dicmeta="PH00002" code="1,2" value="${caseDto.clinicalManifestations.asthma}" name="clinicalManifestations.asthma"/></td>
			            <th>2.1.12 咳嗽：</th>
			            <td><ehr:dic-radio dicmeta="PH00002" code="1,2" value="${caseDto.clinicalManifestations.cough}" name="clinicalManifestations.cough"/></td>
			        </tr>
			        <tr>
			            <th>2.1.13 血痰：</th>
			            <td><ehr:dic-radio dicmeta="PH00002" code="1,2" value="${caseDto.clinicalManifestations.hemosputum}" name="clinicalManifestations.hemosputum"/></td>
			            <th>2.1.14 嘶哑：</th>
			            <td><ehr:dic-radio dicmeta="PH00002" code="1,2" value="${caseDto.clinicalManifestations.hoarseness}" name="clinicalManifestations.hoarseness"/></td>
			        </tr>
			        <tr>
			            <th>2.1.15 心悸：</th>
			            <td><ehr:dic-radio dicmeta="PH00002" code="1,2" value="${caseDto.clinicalManifestations.palpitation}" name="clinicalManifestations.palpitation"/></td>
			            <th>2.1.16 腹痛：</th>
			            <td><ehr:dic-radio dicmeta="PH00002" code="1,2" value="${caseDto.clinicalManifestations.stomachache}" name="clinicalManifestations.stomachache"/></td>
			        </tr>
			        <tr>
			            <th>2.1.17 食欲不振：</th>
			            <td><ehr:dic-radio dicmeta="PH00002" code="1,2" value="${caseDto.clinicalManifestations.poorAppetite}" name="clinicalManifestations.poorAppetite"/></td>
			            <th>2.1.18 痢疾：</th>
			            <td><ehr:dic-radio dicmeta="PH00002" code="1,2" value="${caseDto.clinicalManifestations.dysentery}" name="clinicalManifestations.dysentery"/></td>
			        </tr>
			        <tr>
			            <th>2.2 主要体征：</th>
			        <tr>
			        <tr>
			            <th>2.2.1 体温：</th>
			            <td>
			            	<input type="text" name="clinicalManifestations.temperature" value="${caseDto.clinicalManifestations.temperature}" 
			            	 				reg='{"maxlength":"20"}' style="width: 30%;"/>℃
						</td>
			            <th>2.2.2 消瘦：</th>
			            <td><ehr:dic-radio dicmeta="PH00002" code="1,2" value="${caseDto.clinicalManifestations.emaciation}" name="clinicalManifestations.emaciation"/></td>
			        </tr>
			        <tr>
			            <th>2.2.3 贫血：</th>
			            <td><ehr:dic-radio dicmeta="PH00002" code="1,2" value="${caseDto.clinicalManifestations.anemia}" name="clinicalManifestations.anemia"/></td>
			            <th>2.2.4 发育迟缓：</th>
			            <td><ehr:dic-radio dicmeta="PH00002" code="1,2" value="${caseDto.clinicalManifestations.bradygenesis}" name="clinicalManifestations.bradygenesis"/></td>
			        </tr>
			        <tr>
			            <th>2.2.5 瘀斑：</th>
			            <td><ehr:dic-radio dicmeta="PH00002" code="1,2" value="${caseDto.clinicalManifestations.ecchymosis}" name="clinicalManifestations.ecchymosis"/></td>
			            <th>2.2.6 皮肤病：</th>
			            <td><ehr:dic-radio dicmeta="PH00002" code="1,2" value="${caseDto.clinicalManifestations.skinDisease}" name="clinicalManifestations.skinDisease"/></td>
			        </tr>
			        <tr>
			            <th>2.2.7 黄疸：</th>
			            <td><ehr:dic-radio dicmeta="PH00002" code="1,2" value="${caseDto.clinicalManifestations.jaundice}" name="clinicalManifestations.jaundice"/></td>
			            <th>2.2.8 浮肿：</th>
			            <td><ehr:dic-radio dicmeta="PH00002" code="1,2" value="${caseDto.clinicalManifestations.edema}" name="clinicalManifestations.edema"/></td>
			        </tr>
			        <tr>
			            <th>2.2.9 淋巴结肿大：</th>
			            <td><ehr:dic-radio dicmeta="PH00002" code="1,2" value="${caseDto.clinicalManifestations.lymphadenectasis}" name="clinicalManifestations.lymphadenectasis"/></td>
			            <th>2.2.10 扁桃腺肿大：</th>
			            <td><ehr:dic-radio dicmeta="PH00002" code="1,2" value="${caseDto.clinicalManifestations.tonsilSwollen}" name="clinicalManifestations.tonsilSwollen"/></td>
			        </tr>
			        <tr>
			            <th>2.2.11 舌苔：</th>
			            <td><ehr:dic-radio dicmeta="PH00002" code="1,2" value="${caseDto.clinicalManifestations.tongueCoating}" name="clinicalManifestations.tongueCoating"/></td>
			            <th>2.2.12 口腔溃疡：</th>
			            <td><ehr:dic-radio dicmeta="PH00002" code="1,2" value="${caseDto.clinicalManifestations.oralUlcer}" name="clinicalManifestations.oralUlcer"/></td>
			        </tr>
			        <tr>
			            <th>2.2.13 走马疳：</th>
			            <td><ehr:dic-radio dicmeta="PH00002" code="1,2" value="${caseDto.clinicalManifestations.noma}" name="clinicalManifestations.noma"/></td>
			            <th>2.2.14 心率：</th>
			            <td>
			            	<input type="text" name="clinicalManifestations.heartRate" value="${caseDto.clinicalManifestations.heartRate}" 
	            			reg='{"maxlength":"20"}' cssClass="width30" style="width: 30%"/>/分钟
			            </td>
			        </tr>
			        <tr>
			            <th>2.2.15 心律：</th>
			            <td><ehr:dic-radio dicmeta="IDM00197" name="clinicalManifestations.heartRhythm" value="${caseDto.clinicalManifestations.heartRhythm}"/></td>
			            <th>2.2.16 心脏杂音：</th>
			            <td><ehr:dic-radio dicmeta="PH00002" code="1,2" value="${caseDto.clinicalManifestations.cardiacMurmur}" name="clinicalManifestations.cardiacMurmur"/></td>
			        </tr>
			        <tr>
			            <th>2.2.17 肺：</th>
			            <td><ehr:dic-radio dicmeta="IDM00198" name="clinicalManifestations.lungs" value="${caseDto.clinicalManifestations.lungs}"/></td>
			            <th>2.2.18 腹围：</th>
			            <td>
			            	<input type="text" point="point" name="clinicalManifestations.abdominalCircumference" value="${caseDto.clinicalManifestations.abdominalCircumference}" 
								cssClass="width30" reg='{"maxlength":"20"}' style="width: 20%" />cm
						</td>
			        </tr>
			        <tr>
			            <th>2.2.19 腹水：</th>
			            <td><ehr:dic-radio dicmeta="PH00002" code="1,2" value="${caseDto.clinicalManifestations.ascites}" name="clinicalManifestations.ascites"/></td>
			            <th>2.2.20 脾肋下：</th>
			            <td>
			            	<input type="text" point="point" name="clinicalManifestations.spleenRibUnder" value="${caseDto.clinicalManifestations.spleenRibUnder}" 
								cssClass="width30" reg='{"maxlength":"20"}' style="width: 20%" />cm
						</td>
			        </tr>
			        <tr>
			            <th>2.2.21 肝肋下：</th>
			            <td>
			            	<input type="text" point="point" name="clinicalManifestations.liverRibUnder" value="${caseDto.clinicalManifestations.liverRibUnder}" 
								cssClass="width30" reg='{"maxlength":"20"}' style="width: 20%" />cm
						</td>
			        </tr>
			    </table>
			</fieldset>
			<fieldset>
			    <legend>3.实验室检查</legend>
			    <table class="posttable">
			        <colgroup>
			            <col style="width: 20%"/>
			            <col style="width: 30%"/>
			            <col style="width: 20%"/>
			            <col style="width: 30%"/>
			        </colgroup>
			        <tr>
			            <th>3.1 红细胞计数：</th>
			            <td><input type="text" name="labExamine.rbcCount" value="${caseDto.labExamine.rbcCount}" reg='{"maxlength":"20"}'/></td>
			            <th>3.2 白细胞计数：</th>
			            <td><input type="text" name="labExamine.leukocyteCountFlg" value="${caseDto.labExamine.leukocyteCountFlg}" reg='{"maxlength":"20"}'/></td>
			        </tr>
			        <tr>
			            <th>3.3 血百分：</th>
			        </tr>
			        <tr>
			            <th>3.3.1中性：</th>
			            <td><input type="text" name="labExamine.neutrophilcell" value="${caseDto.labExamine.neutrophilcell}" reg='{"maxlength":"20"}'/></td>
			            <th>3.3.2嗜酸：</th>
			            <td><input type="text" name="labExamine.eosinophils" value="${caseDto.labExamine.eosinophils}" reg='{"maxlength":"20"}'/></td>
			        </tr>
			        <tr>
			            <th>3.3.3嗜碱：</th>
			            <td><input type="text" name="labExamine.basophil" value="${caseDto.labExamine.basophil}" reg='{"maxlength":"20"}'/></td>
			            <th>3.3.4淋巴：</th>
			            <td><input type="text" name="labExamine.lymphocyte" value="${caseDto.labExamine.lymphocyte}" reg='{"maxlength":"20"}'/></td>
			        </tr>
			        <tr>
			            <th>3.4 血红蛋白：</th>
			            <td><input type="text" name="labExamine.hemochrome" value="${caseDto.labExamine.hemochrome}" reg='{"maxlength":"20"}'/></td>
			            <th>3.5 白蛋白/球蛋白：</th>
			            <td><ehr:dic-radio dicmeta="IDM00199" name="labExamine.albumin" value="${caseDto.labExamine.albumin}" reg='{"maxlength":"20"}'/></td>
			        </tr>
			        <tr>
			            <th>3.6 球蛋白沉淀试验：</th>
			            <td><ehr:dic-radio dicmeta="PH00004" code="1,2" name="labExamine.globulinPrecipitationTest" value="${caseDto.labExamine.globulinPrecipitationTest}"/></td>
			            <th>3.7 醛凝试验：</th>
			            <td><ehr:dic-radio dicmeta="PH00004" code="1,2" name="labExamine.formolgetTest" value="${caseDto.labExamine.formolgetTest}"/></td>
			        </tr>
			        <tr>
			            <th>3.8 间接血凝试验：</th>
			            <td><input type="text" name="labExamine.iha" value="${caseDto.labExamine.iha}" reg='{"maxlength":"100"}'/></td>
			            <th>3.9 IFAT：</th>
			            <td><input type="text" name="labExamine.ifat" value="${caseDto.labExamine.ifat}" reg='{"maxlength":"100"}'/></td>
			        </tr>
			        <tr>
			            <th>3.10 ELISA：</th>
			            <td><input type="text" name="labExamine.elisa" value="${caseDto.labExamine.elisa}" reg='{"maxlength":"100"}'/></td>
			            <th>3.11骨髓穿刺：</th>
			            <td><ehr:dic-radio dicmeta="PH00004" code="1,2,3" name="labExamine.bonemarrowAspiration" value="${caseDto.labExamine.bonemarrowAspiration}"/></td>
			        </tr>
			        <tr>
			            <th>3.12淋巴结穿刺：</th>
			            <td><ehr:dic-radio dicmeta="PH00004" code="1,2,3" name="labExamine.lymphnodePuncture" value="${caseDto.labExamine.lymphnodePuncture}"/></td>
			            <th>3.13脾穿刺：</th>
			            <td><ehr:dic-radio dicmeta="PH00004" code="1,2,3" name="labExamine.splenicPuncture" value="${caseDto.labExamine.splenicPuncture}"/></td>
			        </tr>
			        <tr>
			            <th>3.14肝穿刺：</th>
			            <td><ehr:dic-radio dicmeta="PH00004" code="1,2,3" name="labExamine.liverPuncture" value="${caseDto.labExamine.liverPuncture}"/></td>
			            <th>3.15培养阳性：</th>
			            <td>
			            	<ehr:dic-radio dicmeta="IDM00200" code="" name="labExamine.culturePositive"  value="${caseDto.labExamine.culturePositive}"
			            		onchange="toggleOther('labExamine.culturePositive','otherCulturePositive',99)"/>
			            	<span id="otherCulturePositive" style="display: none;">
			            		<input type="text" name="labExamine.otherCulturePositive" value="${caseDto.labExamine.otherCulturePositive}"
			            		 reg='{"maxlength":"100"}' style="width: 30%"/>
			            	</span>
			            </td>
			        </tr>
			        <tr>
			            <th>3.16治疗药物：</th>
			            <td><ehr:dic-radio dicmeta="IDM00201" name="labExamine.drug" value="${caseDto.labExamine.drug}"/></td>
			        </tr>
			    </table>
			</fieldset>
			
			<fieldset>
			    <legend>4.流行病学调查</legend>
			    <table class="posttable">
			        <colgroup>
			            <col style="width: 20%"/>
			            <col style="width: 30%"/>
			            <col style="width: 20%"/>
			            <col style="width: 30%"/>
			        </colgroup>
			        <tr>
			            <th>4.1外出史：</th>
			            <td colspan="3">
			            	<ehr:dic-radio dicmeta="PH00002" name="epidemiologicalSurvey.outHistory" code="1,2" value="${caseDto.epidemiologicalSurvey.outHistory}"
			            		onchange="toggleOther('epidemiologicalSurvey.outHistory','outHistoryTd',1)"/>
			            </td>
			        </tr>
			        <tr id="outHistoryTd" style="display: none;">
			        	<td colspan="4" style="padding: 0px;">
			        		<table>
			        			<colgroup>
						            <col style="width: 20%"/>
						            <col style="width: 30%"/>
						            <col style="width: 20%"/>
						            <col style="width: 30%"/>
						        </colgroup>
			        			<tr>
			        				<th>去过何地：</th>
			        				<td><input reg='{"maxlength":"200"}' type="text" name="epidemiologicalSurvey.outHistoryAddr" value="${caseDto.epidemiologicalSurvey.outHistoryAddr}"/></td>
			        			</tr>
			        			<tr>
						            <th>在该地有无下列活动：</th>
						        </tr>
						        <tr>
						            <th>（1）野外作业：</th>
						            <td><ehr:dic-radio dicmeta="PH00002" code="1,2" value="${caseDto.epidemiologicalSurvey.fieldWork}" name="epidemiologicalSurvey.fieldWork"/></td>
						            <th>（2）野外捕猎：</th>
						            <td><ehr:dic-radio dicmeta="PH00002" code="1,2" value="${caseDto.epidemiologicalSurvey.fieldHunt}" name="epidemiologicalSurvey.fieldHunt"/></td>
						        </tr>
						        <tr>
						            <th>到该地时间：</th>
						            <td><ehr:dic-radio dicmeta="IDM00202" name="epidemiologicalSurvey.fieldTime" value="${caseDto.epidemiologicalSurvey.fieldTime}"/></td>
						        </tr>
			        		</table>
			        	</td>
			        </tr>
			        
			        <tr>
			            <th>4.2野生动物接触史：</th>
			            <td>
			            	<ehr:dic-radio dicmeta="PH00002" code="1,2" value="${caseDto.epidemiologicalSurvey.wildlifeContactHistory}" name="epidemiologicalSurvey.wildlifeContactHistory"
			            		onchange="toggleOther('epidemiologicalSurvey.wildlifeContactHistory','contactWildlife','1')"/>
			            </td>
			        </tr>
			        <tr id="contactWildlife" style="display: none;">
			            <th>接触过何种动物：</th>
			            <td><input type="text" name="epidemiologicalSurvey.contactWildlife" value="${caseDto.epidemiologicalSurvey.contactWildlife}" reg='{"maxlength":"100"}'/></td>
			            <th>接触方式：</th>
			            <td><input type="text" name="epidemiologicalSurvey.wildlifeContactWay" value="${caseDto.epidemiologicalSurvey.wildlifeContactWay}" reg='{"maxlength":"100"}'/></td>
			        </tr>
			        <tr>
			            <th>4.3是否输过血：</th>
			            <td><ehr:dic-radio dicmeta="PH00002" code="1,2" value="${caseDto.epidemiologicalSurvey.transfusion}" name="epidemiologicalSurvey.transfusion"/></td>
			            <th>4.4家中狗数：</th>
			            <td>
			            	<input type="text" name="epidemiologicalSurvey.homeDogNum" value="${caseDto.epidemiologicalSurvey.homeDogNum}"
			            		reg='{"maxlength":"20"}' cssClass="width30" style="width: 16%"/>只
			            </td>
			        </tr>
			        <tr>
			            <th>4.4.1患病狗数：</th>
			            <td>
			            	<input type="text" name="epidemiologicalSurvey.diseaseDogNum" value="${caseDto.epidemiologicalSurvey.diseaseDogNum}" 
			            		reg='{"maxlength":"20"}' cssClass="width30" style="width: 16%"/>只
			            </td>
			        </tr>
			        <tr>
			            <th>4.4.2死亡狗数：</th>
			            <td>
			            	<input type="text" name="epidemiologicalSurvey.dieDogNum" value="${caseDto.epidemiologicalSurvey.dieDogNum}" 
			            		reg='{"maxlength":"20"}' cssClass="width30" style="width: 16%"/>只
			            </td>
			        </tr>
			    </table>
			</fieldset>
			<fieldset>
			    <legend>5.小结</legend>
			    <table class="posttable">
			        <tr>
			             <td>
                            <textarea name="otherCondition.surveySummary" style="width: 100%" rows="5" reg='{"maxlength":"800"}'>${caseDto.otherCondition.surveySummary}</textarea>
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
			            <td><ehr:org code="${caseDto.caseInformation.modifySurveyOrg}"/>
			            <input type="hidden" name="caseInformation.modifySurveyOrg" value="${caseDto.caseInformation.modifySurveyOrg}"/></td>
			            <th>调查者：</th>
			            <td><ehr:user userCode="${caseDto.caseInformation.modifyRespondents}"/>
			            <input type="hidden" name="caseInformation.modifyRespondents" value="${caseDto.caseInformation.modifyRespondents}"/>
			            </td>
			        </tr>
			        <tr>
			            <th>审查者：</th>
			            <td><ehr:user userCode="${caseDto.caseInformation.modifyRespondents}"/>
			            <input type="hidden" name="caseInformation.auditor" value="${caseDto.caseInformation.auditor}"/></td>
			            <th>调查时间：</th>
			            <td><tag:dateInput nullToToday="true" name="caseInformation.modifySurveyDate" onlypast="true"
	                               pattern="yyyy/MM/dd"  date="${caseDto.caseInformation.modifySurveyDate}"/></td>
			        </tr>
			    </table>
			</fieldset>
		</div>
	</div>
</form>
