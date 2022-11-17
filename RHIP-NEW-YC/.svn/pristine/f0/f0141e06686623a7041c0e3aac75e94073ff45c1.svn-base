<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tag" %>

<script src="${pageContext.request.contextPath}/js/views/idm/case/edit.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/views/idm/case/h7n9.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/views/idm/idmCommon.js" type="text/javascript"></script>
<c:if test="${isPrint != 1}">
    <jsp:include page="../caseButton.jsp"></jsp:include>
</c:if>
<form id="caseForm">
	<div class="postcontent <c:if test="${isPrint != 1}">contentfixed</c:if>">
		<i class="popno">
			人感染H7N9禽流感病例个案调查表<br />
			<span>（甲类传染病）</span>
		</i>
		<input type="hidden" name="idmId" value="${idmId}" id="idmId"/>
		<input type="hidden" name="exposureHistory.id" value="${caseDto.exposureHistory.id}"/>
        <input type="hidden" name="ehList" id="ehList"/>
        <input type="hidden" name="efcList" id="efcList"/>
		<div class="postdiv">
            <table  class="posttable">
                <colgroup>
                    <col style="width: 30%;" />
                    <col style="width: 40%;" />
                    <col style="width: 300px;" />
                </colgroup>
                <tr>
                    <td style="text-align: left;">编号:<input type="text" name="caseInformation.mediRecordNum"
                        value="${caseDto.caseInformation.mediRecordNum}" reg='{"maxlength":"14"}'
                        style="width: 150px;" />
                    </td>
                    <td style="text-align: left;">患者类型:<ehr:dic-list dicmeta="IDM00530" name="otherCondition.caseType"  value="${caseDto.otherCondition.caseType}" />
                    </td>
                    <td style="text-align: right;">调查单位: <ehr:org code="${caseDto.caseInformation.modifySurveyOrg}"/>
                    </td>
                </tr>
                <tr>
                    <td colspan="2" style="text-align: left;"><span>（按照国家标准编码：省编码＋市编码＋县编码＋病例序号）</span></td>
                </tr>
            </table>

			<fieldset>
				<legend>一、基本信息</legend>
				<table class="posttable">
					<colgroup>
                        <col style="width: 30%" />
                        <col style="width: 30%" />
                        <col style="width: 20%" />
                        <col style="width: 20%" />
					</colgroup>
                    <tr>
                        <th>1.性别：</th>
                        <td>
                            <ehr:dic-radio name="generalCondition.gender"
                                           dicmeta="GBT226112003" value="${caseDto.generalCondition.gender}" code="1,2" />
                        </td>
                    </tr>
					<tr>
						<th>2.出生日期：</th>
						<td colspan="3">
			           		<span>
			           		<tag:dateInput name="generalCondition.birthday" pattern="yyyy/MM/dd" date="${caseDto.generalCondition.birthday}" style="width:150px;"/>
			            	 <ehr:dic-radio name="generalCondition.birthdateType" dicmeta="IDM00002" value="${caseDto.generalCondition.birthdateType}"/>
			            	 <tag:numberInput id="age" name="generalCondition.age" value="${caseDto.generalCondition.age}" 
			            		maxlength="3" cssClass="width30" style="width: 6%"/>
			            	 <ehr:dic-radio id="ageUnit" name="generalCondition.ageUnit"  dicmeta="IDM00003" value="${caseDto.generalCondition.ageUnit}"/>(如果不知道其生日，请填写年龄 )</span>
                        </td>
					</tr>
					<tr>
						<th>3.国籍：</th>
						<td colspan="3">
						<ehr:dic-list name="generalCondition.nationality" dicmeta="GBT26592000" width="180px;"
	                                                        value="${caseDto.generalCondition.nationality}"/>
	                    </td>
	
					</tr>
					<tr>
						<th>4.民族：</th>
						<td colspan="3">
						<ehr:dic-list name="generalCondition.nation" dicmeta="GBT330491" width="180px;"
	                                                        value="${caseDto.generalCondition.nation}"/>
	                    </td>
					</tr>
					<tr>
						<th>5.身高：</th>
						<td colspan="3">
							<tag:numberInput id="fatherName" name="generalCondition.fatherName" value="${caseDto.generalCondition.fatherName}" 
			            		maxlength="4" cssClass="width30" style="width: 6%" point="true"/>
						<%-- <input type="text" id="fatherName" name="generalCondition.fatherName" style="width: 100px;" value="${caseDto.generalCondition.fatherName}" reg="{'max':9999.9}" /> --%>cm</td>
					</tr>
					<tr>
						<th>6.体重：</th>
						<td colspan="3"><tag:numberInput id="motherName" name="generalCondition.motherName" value="${caseDto.generalCondition.motherName}" 
			            		maxlength="4" cssClass="width30" style="width: 6%" point="true"/>kg</td>
					</tr>
					<tr>
						<th>7.户籍住址：</th>
                        <td colspan="3">
	                            <input type="text" id="hrAddress" name="generalCondition.hrAddress" value="${caseDto.generalCondition.hrAddress}"
	                           			reg='{"maxlength":"100"}'  style="width: 180px;">
                         </td>
                    </tr>
                    <tr>
                        <th>8.现在地区类型：</th>
                        <td>
                            <ehr:dic-radio name="generalCondition.residenceType"
                                           dicmeta="IDM00515" value="${caseDto.generalCondition.residenceType}"  />
                        </td>
                    </tr>
                    <tr>
                        <th>9.联系方式：</th>
                        <td>
                        	<input type="text" name="generalCondition.phoneNumber" value="${caseDto.generalCondition.phoneNumber}" style="width: 150px;" 
                            	reg='{"regex":"phone"}'/></td>
                    </tr>
				</table>
			</fieldset>

			<fieldset>
				<legend>二、既往健康信息</legend>
				<table class="posttable">
					<colgroup>
                        <col style="width: 30%" />
                        <col style="width: 30%" />
                        <col style="width: 20%" />
                        <col style="width: 20%" />
					</colgroup>
					<tr>
						<td colspan="4" style="text-align: left;">1.慢性基础疾病</td>
					</tr>
					
					<tr>
		                <th>1.1 慢性肺部疾病：</th>
		                <td colspan="3">
		                    <ehr:dic-radio dicmeta="PH00001" code="1,2,4" name="pastHistory.lungs" value="${caseDto.pastHistory.lungs}"
		                        onchange="toggleOther('pastHistory.lungs','lungsCkDiv',1)"/>
		                    <span id="lungsCkDiv" style="display: none">
		                        <br/><ehr:dic-checkbox dicmeta="IDM00516" name="pastHistory.lungsCk"
                                                value="${caseDto.pastHistory.lungsCk}" onchange="toggleOtherCK('pastHistory.lungsCk','lungsCkOtherDiv',9)"/>(可多选)
				                    <span id="lungsCkOtherDiv" style="display: none">
		                                <input type="text" name="pastHistory.lungsCkOther" value="${caseDto.pastHistory.lungsCkOther}"
		                                       reg='{"maxlength":"100"}' style="width: 100px;"/>
		                            </span>
		                    </span>
		                </td>
		            </tr>
		            <tr>
		                <th>1.2  心脑血管疾病：</th>
		                <td colspan="3">
		                    <ehr:dic-radio dicmeta="PH00001" code="1,2,4" name="pastHistory.cardiovascular" value="${caseDto.pastHistory.cardiovascular}"
		                         onchange="toggleOther('pastHistory.cardiovascular','cardiovascularCkDiv',1)"/>
		                    <span id="cardiovascularCkDiv" style="display: none">
		                       <br/> <ehr:dic-checkbox dicmeta="IDM00517" name="pastHistory.cardiovascularCk"
                                          onchange="toggleOtherCK('pastHistory.cardiovascularCk','cardiovascularCkOtherDiv',8)"   value="${caseDto.pastHistory.cardiovascularCk}"/>(可多选)
				                    <span id="cardiovascularCkOtherDiv" style="display: none">
		                                <input type="text" name="pastHistory.cardiovascularCkOther" value="${caseDto.pastHistory.cardiovascularCkOther}"
		                                       reg='{"maxlength":"100"}' style="width: 150px;"/>
		                            </span>
		                    </span>
		                </td>
		            </tr>
		           
		            <tr>
		                <th>1.3  代谢性疾病：</th>
		                <td colspan="3">
		                    <ehr:dic-radio dicmeta="PH00001" code="1,2,4" name="pastHistory.metabolize" value="${caseDto.pastHistory.metabolize}"
		                         onchange="toggleOther('pastHistory.metabolize','metabolizeCkDiv',1)" />
		                    <span id="metabolizeCkDiv" style="display: none">
		                        <br/><ehr:dic-checkbox dicmeta="HE00017" name="pastHistory.metabolizeCk" code="2,3,99" 
                                           onchange="toggleOtherCK('pastHistory.metabolizeCk','metabolizeCkOtherDiv',99)"     value="${caseDto.pastHistory.metabolizeCk}"/>
				                    <span id="metabolizeCkOtherDiv" style="display: none">
		                                <input type="text" name="pastHistory.metabolizeCkOther" value="${caseDto.pastHistory.metabolizeCkOther}"
		                                       reg='{"maxlength":"100"}' style="width: 150px;"/>
		                            </span>
		                    </span>
		                </td>
		            </tr>
		             <tr>
		                <th>1.4  慢性肾脏疾病：</th>
		                <td colspan="3">
		                    <ehr:dic-radio dicmeta="PH00001" code="1,2,4" name="pastHistory.nephropathy" value="${caseDto.pastHistory.nephropathy}"
		                        onchange="toggleOther('pastHistory.nephropathy','nephropathyCkDiv',1)"/>
		                    <span id="nephropathyCkDiv" style="display: none">
		                        <br/> <ehr:dic-checkbox dicmeta="IDM00518" name="pastHistory.nephropathyCk"
                                         onchange="toggleOtherCK('pastHistory.nephropathyCk','nephropathyCkOtherDiv',5); toggleOther('pastHistory.nephropathyCk','medicationHistoryDiv',1)"         value="${caseDto.pastHistory.nephropathyCk}"/>
				                    <span id="nephropathyCkOtherDiv" style="display: none">
		                                <input type="text" name="pastHistory.nephropathyCkOther" value="${caseDto.pastHistory.nephropathyCkOther}"
		                                       reg='{"maxlength":"100"}' style="width: 150px;"/>
		                            </span>
		                            <br/>（如有上述任一选项，必须同时填写是否有肾功能不全）
									 <br/>肾功能不全
									<ehr:dic-radio dicmeta="PH00001" code="1,2,4" name="pastHistory.nephropathyInsufficiency" value="${caseDto.pastHistory.nephropathyInsufficiency}"
					                        />
		                    </span>
		                </td>
		            </tr>     
		            <tr>
		                <th>1.5  慢性肝脏疾病：</th>
		                <td colspan="3">
		                    <ehr:dic-radio dicmeta="PH00001" code="1,2,4" name="pastHistory.liver" value="${caseDto.pastHistory.liver}"
		                        onchange="toggleOther('pastHistory.liver','liverCkDiv',1)"/>
		                    <span id="liverCkDiv" style="display: none">
		                        <br/><ehr:dic-checkbox dicmeta="IDM00519" name="pastHistory.liverCk"
                                      onchange="toggleOtherCK('pastHistory.liverCk','liverCkOtherDiv',4)" value="${caseDto.pastHistory.liverCk}"/>
				                    <span id="liverCkOtherDiv" style="display: none">
		                                <input type="text" name="pastHistory.liverCkOther" value="${caseDto.pastHistory.liverCkOther}"
		                                       reg='{"maxlength":"100"}' style="width: 150px;"/>
		                            </span>
		                    </span>
		                </td>
		            </tr>
		            <tr>
		                <th>1.6  风湿免疫性疾病：</th>
		                <td colspan="3">
		                    <ehr:dic-radio dicmeta="PH00001" code="1,2,4" name="pastHistory.rheumatism" value="${caseDto.pastHistory.rheumatism}"
		                        onchange="toggleOther('pastHistory.rheumatism','rheumatismCkDiv',1)"/>
		                    <span id="rheumatismCkDiv" style="display: none">
		                        <br/><ehr:dic-checkbox dicmeta="IDM00520" name="pastHistory.rheumatismCk"
                                           onchange="toggleOtherCK('pastHistory.rheumatismCk','rheumatismCkOtherDiv',5)"      value="${caseDto.pastHistory.rheumatismCk}"/>
				                    <span id="rheumatismCkOtherDiv" style="display: none">
		                                <input type="text" name="pastHistory.rheumatismCkOther" value="${caseDto.pastHistory.rheumatismCkOther}"
		                                       reg='{"maxlength":"100"}' style="width: 150px;"/>
		                            </span>
		                    </span>
		                </td>
		            </tr>
		           
		            <tr>
		                <th>1.7  血液系统疾病：</th>
		                <td colspan="3">
		                    <ehr:dic-radio dicmeta="PH00001" code="1,2,4" name="pastHistory.blood" value="${caseDto.pastHistory.blood}"
		                        onchange="toggleOther('pastHistory.blood','bloodCkDiv',1)"/>
		                    <span id="bloodCkDiv" style="display: none">
		                         <br/><ehr:dic-checkbox dicmeta="IDM00521" name="pastHistory.bloodCk"  
                                      onchange="toggleOtherCK('pastHistory.bloodCk','bloodCkOtherDiv',3)"   value="${caseDto.pastHistory.bloodCk}"/>
				                    <span id="bloodCkOtherDiv" style="display: none">
		                                <input type="text" name="pastHistory.bloodCkOther" value="${caseDto.pastHistory.bloodCkOther}"
		                                       reg='{"maxlength":"100"}' style="width: 150px;"/>
		                            </span>
		                    </span>
		                </td>
		            </tr>
		             <tr>
		                <th>1.8  血液和/或器官的癌症/肿瘤：</th>
		                <td colspan="3">
		                    <ehr:dic-radio dicmeta="PH00001" code="1,2,4" name="pastHistory.cancer" value="${caseDto.pastHistory.cancer}"
		                        onchange="toggleOther('pastHistory.cancer','cancerCkDiv',1)"/>	                               
			                    <span id="cancerCkDiv" style="display: none">
	                                <input type="text" name="pastHistory.cancerCk" value="${caseDto.pastHistory.cancerCk}"
	                                       reg='{"maxlength":"100"}' style="width: 150px;"/>
	                            </span>
		                </td>
		            </tr>
		            <tr>
		                <th>1.9  发病时处于免疫抑制状态（HIV/AIDS、 糖皮质激素或免疫抑制药物治疗、或器官移植后、造血干细胞移植后） ：</th>
		                <td colspan="3">
		                    <ehr:dic-radio dicmeta="PH00001" code="1,2,4" name="pastHistory.hiv" value="${caseDto.pastHistory.hiv}"
		                        onchange="toggleOther('pastHistory.hiv','hivCkDiv',1)"/>
		                    <span id="hivCkDiv" style="display: none"> 
                                <input type="text" name="pastHistory.hivCk" value="${caseDto.pastHistory.hivCk}"
                                       reg='{"maxlength":"100"}' style="width: 150px;"/>
		                    </span>
		                </td>
		            </tr>
		           
		            <tr>
		                <th>1.10  神经系统或神经肌肉功能障碍：</th>
		                <td colspan="3">
		                    <ehr:dic-radio dicmeta="PH00001" code="1,2,4" name="pastHistory.nerve" value="${caseDto.pastHistory.nerve}"
		                        onchange="toggleOther('pastHistory.nerve','nerveCkDiv',1)"/>
		                    <span id="nerveCkDiv" style="display: none">
		                        <ehr:dic-checkbox dicmeta="IDM00522" name="pastHistory.nerveCk"  
                                     onchange="toggleOtherCK('pastHistory.nerveCk','nerveCkOtherDiv',5)"            value="${caseDto.pastHistory.nerveCk}"/>
				                    <span id="nerveCkOtherDiv" style="display: none">
		                                <input type="text" name="pastHistory.nerveCkOther" value="${caseDto.pastHistory.nerveCkOther}"
		                                       reg='{"maxlength":"100"}' style="width: 150px;"/>
		                            </span>
		                    </span>
		                </td>
		            </tr>
		             <tr>
		                <th>1.11其他疾病1 ：</th>
		                <td colspan="3">
                            <input type="text" name="pastHistory.diseaseOtherFirst" value="${caseDto.pastHistory.diseaseOtherFirst}"
                                   reg='{"maxlength":"100"}' style="width: 150px;"/>
		                </td>
		            </tr>
		              <tr>
		                <th>1.12其他疾病2 ：</th>
		                <td colspan="3">
                            <input type="text" name="pastHistory.diseaseOtherSecond" value="${caseDto.pastHistory.diseaseOtherSecond}"
                                   reg='{"maxlength":"100"}' style="width: 150px;"/>
		                </td>
		            </tr>
		             <tr>
		                <th>1.13其他疾病3 ：</th>
		                <td colspan="3">
                            <input type="text" name="pastHistory.diseaseOtherThird" value="${caseDto.pastHistory.diseaseOtherThird}"
                                   reg='{"maxlength":"100"}' style="width: 150px;"/>
		                </td>
		            </tr>
		            <tr>
						<td colspan="4" style="text-align: left;">2.怀孕</td>
					</tr>
					
					<tr>
		                <th>是否怀孕：</th>
		                <td colspan="3">
		                    <ehr:dic-radio dicmeta="PH00001" code="1,2,4" name="pastHistory.pregnant" value="${caseDto.pastHistory.pregnant}"
		                        onchange="toggleOther('pastHistory.pregnant','pregnantWeekDiv',1)"/> 
			                    <span id="pregnantWeekDiv" style="display: none">
	                              		  孕期<tag:numberInput id="pregnantWeek" name="pastHistory.pregnantWeek" value="${caseDto.pastHistory.pregnantWeek}" maxlength="4" cssClass="width30" style="width: 6%" point="true"/>周，
	                              		  第<tag:numberInput id="pregnantNum" name="pastHistory.pregnantNum" value="${caseDto.pastHistory.pregnantNum}" maxlength="4" cssClass="width30" style="width: 6%" point="true"/>次
	                            </span>
		                </td>
		            </tr> 
		            <tr>
						<td colspan="4" style="text-align: left;">3.疫苗接种史</td>
					</tr>
					<tr>
		                <th>发病前1年是否接种过季节性流感疫苗：</th>
		                <td colspan="3">
		                    <ehr:dic-radio dicmeta="PH00001" code="1,2,4" name="pastHistory.seasonInfluenzaVaccine" value="${caseDto.pastHistory.seasonInfluenzaVaccine}"
		                        /> 
		                </td>
		            </tr> 
		            <tr>
						<td colspan="4" style="text-align: left;">4.生活习惯</td>
					</tr>
					
					<tr>
		                <th>现在是否吸烟情况：</th>
		                <td colspan="3">
		                    <ehr:dic-radio dicmeta="PH00001" code="1,2,4" name="pastHistory.smoke" value="${caseDto.pastHistory.smoke}"
		                         onchange="toggleOther('pastHistory.smoke','smokeDayDiv',1);toggleOther('pastHistory.smoke','smokeAllTimeDiv',2)"/> 
		                      <span id="smokeDayDiv" style="display: none">
		                     	 <br/>  
		                            	 吸烟量：<input type="text" name="pastHistory.smokeDay" value="${caseDto.pastHistory.smokeDay}"
	                                       reg='{"maxlength":"100"}' style="width: 50px;"/>  支/天，吸烟<input type="text" name="pastHistory.smokeYear" value="${caseDto.pastHistory.smokeYear}"
	                                       reg='{"maxlength":"100"}' style="width: 50px;"/> 年，吸烟指数SI:<input type="text" id="si" name="pastHistory.smokeSi" value="${caseDto.pastHistory.smokeSi}"  style="width: 50px; disable: disable"/>
（吸烟指数=每日吸烟支数×吸烟年数）
		                      </span> 		                      
		                </td>
		            </tr>
		            <tr style="display: none;" id="smokeAllTimeDiv">
                        <td colspan="4" style="padding: 0px;">
                            <table>
                                <colgroup>
                                    <col style="width: 30%"/>
                                    <col style="width: 70%"/>
                                </colgroup>
                                <tr>
                                    <th>是否一直不吸烟: </th>
                                    <td><ehr:dic-radio dicmeta="PH00001" code="1,2,4" name="pastHistory.smokeAllTime" value="${caseDto.pastHistory.smokeAllTime}"
		                        			/></td>
                                </tr>
                                 <tr>
                                    <th>是否戒烟: </th>
                                    <td><ehr:dic-radio dicmeta="PH00001" code="1,2,4" name="pastHistory.smokeQuit" value="${caseDto.pastHistory.smokeQuit}"
		                        			 onchange="toggleOther('pastHistory.smokeQuit','influenzaVaccineDiv',1)"/>
		                        		<span id="smokeQuitYearDiv" style="display: none">  
			                        		已戒烟 <input type="text" name="pastHistory.smokeQuitYear" value="${caseDto.pastHistory.smokeQuitYear}"
		                                       reg='{"maxlength":"100"}' style="width: 50px;"/>年
			                       		 </span>
		                        	</td>
                                </tr>
                            </table>
                        </td>
                    </tr> 
		            <tr>
		                <th>平时是否喝酒情况：</th>
		                <td colspan="3">
		                    <ehr:dic-radio dicmeta="PH00001" code="1,2,4" name="pastHistory.alcohol" value="${caseDto.pastHistory.alcohol}"
		                        onchange="toggleOther('pastHistory.alcohol','alcoholDayDiv',1);toggleOther('pastHistory.alcohol','alcoholAllTimeDiv',2)"/> 
		                      <span id="alcoholDayDiv" style="display: none">
		                      		<br/>酒量:<input type="text" name="pastHistory.alcoholDay" value="${caseDto.pastHistory.alcoholDay}"
	                                       reg='{"maxlength":"100"}' style="width: 50px;"/>两/天，
		                      		一般喝的酒精度数<input type="text" name="pastHistory.alcoholDegree" value="${caseDto.pastHistory.alcoholDegree}"
	                                       reg='{"maxlength":"100"}' style="width: 50px;"/>
	                                 ,喝酒<input type="text" name="pastHistory.alcoholYear" value="${caseDto.pastHistory.alcoholYear}"
	                                       reg='{"maxlength":"100"}' style="width: 50px;"/>   年  
		                      </span> 
		                </td>
		            </tr> 
		             <tr style="display: none;" id="alcoholAllTimeDiv">
                        <td colspan="4" style="padding: 0px;">
                            <table>
                                <colgroup>
                                    <col style="width: 30%"/>
                                    <col style="width: 70%"/>
                                </colgroup>
                                <tr>
                                    <th>是否一直不喝酒: </th>
                                    <td><ehr:dic-radio dicmeta="PH00001" code="1,2,4" name="pastHistory.alcoholAllTime" value="${caseDto.pastHistory.alcoholAllTime}"
		                        			/></td>
                                </tr>
                                 <tr>
                                    <th>是否戒酒:</th>
                                    <td> <ehr:dic-radio dicmeta="PH00001" code="1,2,4" name="pastHistory.alcoholQuit" value="${caseDto.pastHistory.alcoholQuit}"
		                        			onchange="toggleOther('pastHistory.alcoholQuit','alcoholQuitYearDiv',1)"/>
					                        <span id="alcoholQuitYearDiv" style="display: none">  
					                        		已戒酒 <input type="text" name="pastHistory.alcoholQuitYear" value="${caseDto.pastHistory.alcoholQuitYear}"
				                                       reg='{"maxlength":"100"}' style="width: 50px;"/>年
					                        </span> 
		                        	</td>
                                </tr>
                            </table>
                        </td>
                    </tr> 
		         </table>
			</fieldset>

			<fieldset>
				<legend>三、流行病学调查信息</legend>
				<table class="posttable">
					<colgroup>
                        <col style="width: 30%" />
                        <col style="width: 30%" />
                        <col style="width: 20%" />
                        <col style="width: 20%" />
					</colgroup>
					<tr>
						<td colspan="4" style="text-align: left;">第一部分  职业情况</td>
					</tr>
					<tr>
						<th>1. 是否是职业涉禽人员：</th>
						<td colspan="3"><ehr:dic-radio dicmeta="PH00001" name="exposureHistory.birdOccupation" code="1,2" value="${caseDto.exposureHistory.birdOccupation}"
                                           onchange="toggleOther('exposureHistory.birdOccupation','birdSpeciesOcDiv',1)"/>
						</td>
					</tr>  
					 <tr style="display: none;" id="birdSpeciesOcDiv">
                        <td colspan="4" style="padding: 0px;">
                            <table>
                                <colgroup>
                                    <col style="width: 30%"/>
                                    <col style="width: 70%"/>
                                </colgroup>
                                <tr>
                                    <th>1.1 经常接触的禽类动物种类为（可多选）：</th>
                                    <td><ehr:dic-checkbox name="exposureHistory.birdSpeciesOc" dicmeta="IDM00523" code="1,2,3,4,6" value="${caseDto.exposureHistory.birdSpeciesOc}"
		                                    onchange="toggleOtherCK('exposureHistory.birdSpeciesOc','birdSpeciesOtherOcDiv',6)"/>
		                                   <span id="birdSpeciesOtherOcDiv" style="display: none">
		                                   		 <input type="text" name="exposureHistory.birdSpeciesOtherOc" value="${caseDto.exposureHistory.birdSpeciesOtherOc}"
				                                       reg='{"maxlength":"100"}' style="width: 50px;"/>
		                                   </span></td>
                                </tr>
                                 <tr>
                                    <th>1.2 接触环节是（可多选）：</th>
                                    <td> <ehr:dic-checkbox name="exposureHistory.contactWayOc" dicmeta="IDM00524" value="${caseDto.exposureHistory.contactWayOc}"
		                                    	onchange="toggleOtherCK('exposureHistory.contactWayOc','contactWayOtherOcDiv',8)"/>
			                                    <span id="contactWayOtherOcDiv" style="display: none">
			                                   		 <input type="text" name="exposureHistory.contactWayOtherOc" value="${caseDto.exposureHistory.contactWayOtherOc}"
					                                       reg='{"maxlength":"100"}' style="width: 50px;"/>
			                                   </span>
		                        	</td>
                                </tr>
                            </table>
                        </td>
                    </tr> 
		 			<tr>
						<td colspan="4" style="text-align: left;">第二部分  暴露史</td>
					</tr>
					<tr>
						<td colspan="4" style="text-align: left;">(一)禽类暴露情况</td>
					</tr>
					<tr>
		                <th>1. 自（病例）发病起前10天内是否接触过禽类：</th>
		                <td colspan="3">
		                    <ehr:dic-radio dicmeta="PH00001" code="1,2,4" name="exposureHistory.contactBi" value="${caseDto.exposureHistory.contactBi}"
		                        onchange="toggleOther('exposureHistory.contactBi','contactHealthBiDiv',1)"/> 
		                </td>
		            </tr> 
		            <tr style="display: none;" id="contactHealthBiDiv">
                        <td colspan="4" style="padding: 0px;">
                            <table>
                                <colgroup>
                                    <col style="width: 30%"/>
                                    <col style="width: 70%"/>
                                </colgroup>
                             
	       						<tr >
                                    <th>2. 自（病例）发病起前10天内是否接触过外表健康的禽类：</th>
                                    <td><ehr:dic-radio code="1,2,4" onchange="toggleOther('exposureHistory.contactHealthBi','contactFreHealthBiDiv',1)" dicmeta="PH00001"  name="exposureHistory.contactHealthBi" value="${caseDto.exposureHistory.contactHealthBi}"/>
		                                  </td>
                                </tr>
                                 <tr style="display: none;" id="contactFreHealthBiDiv">
			                        <td colspan="4" style="padding: 0px;">
			                            <table>
			                                <colgroup>
			                                    <col style="width: 30%"/>
			                                    <col style="width: 70%"/>
			                                </colgroup>
			                                 <tr>
			                                    <th>此期间接触频率是：</th>
			                                    <td><ehr:dic-radio onchange="toggleOther('exposureHistory.contactFreHealthBi','contactDayHealthBiDiv',1)" dicmeta="IDM00525"  name="exposureHistory.contactFreHealthBi" value="${caseDto.exposureHistory.contactFreHealthBi}"/>
					                                  </td>
			                                </tr>
			                                <tr style="display: none;" id="contactDayHealthBiDiv">
						                        <td colspan="4" style="padding: 0px;">
						                            <table>
						                                <colgroup>
						                                    <col style="width: 30%"/>
						                                    <col style="width: 70%"/>
						                                </colgroup>
						                                 <tr>
						                                    <th>每天的接触和防护等方式都基本类似：</th>
						                                    <td><ehr:dic-radio dicmeta="PH00001" code="1,2" name="exposureHistory.contactDayHealthBi" value="${caseDto.exposureHistory.contactDayHealthBi}"
						                                     onchange="toggleOther('exposureHistory.contactDayHealthBi','birdSpeciesHealthBiDiv',1);toggleOther('exposureHistory.contactDayHealthBi','tableFirstIndexesDiv',2)" />
								                                  <span id="tableFirstIndexesDiv" style="display: none">
											                      		(按表1收集有接触的当天的如下信息)
										                           </span> 
								                             </td>
						                                </tr>
						                                <tr style="display: none;" id="birdSpeciesHealthBiDiv">
									                        <td colspan="4" style="padding: 0px;">
									                            <table>
									                                <colgroup>
									                                    <col style="width: 30%"/>
									                                    <col style="width: 70%"/>
									                                </colgroup>
									                                <tr>
									                                    <th>2.1 接触禽的种类（可多选）：</th>
									                                    <td><ehr:dic-checkbox name="exposureHistory.birdSpeciesHealthBi" dicmeta="IDM00523" value="${caseDto.exposureHistory.birdSpeciesHealthBi}"
				                                    										/>
											                                   </td>
									                                </tr>
									                                <tr>
									                                    <th>2.2 接触方式（可多选）：</th>
									                                    <td><ehr:dic-checkbox name="exposureHistory.contactWayHealthBi" dicmeta="IDM00526" value="${caseDto.exposureHistory.contactWayHealthBi}"
				                                    										/>
											                                   </td>
									                                </tr>
									                                 <tr>
									                                    <th>2.3 接触禽类时，手部伤口情况：</th>
									                                    <td><ehr:dic-checkbox dicmeta="IDM00527"  name="exposureHistory.handHealthBi" value="${caseDto.exposureHistory.handHealthBi}"
						                       										 	/> </td>
									                                </tr>
									                                 <tr>
									                                    <th>2.4 接触禽类时是否采取防护措施：</th>
									                                    <td><ehr:dic-radio dicmeta="IDM00528"  name="exposureHistory.protectHealthBi" value="${caseDto.exposureHistory.protectHealthBi}"
						                        								onchange="hnCase.toggleOnes('exposureHistory.protectHealthBi','protectWayHealthBiDiv','1,2')"/></td>
									                                </tr>
									                                 <tr style="display: none;" id="protectWayHealthBiDiv">
									                                    <th>2.4.1 措施是（可多选）：</th>
									                                    <td><ehr:dic-checkbox dicmeta="IDM00529"  name="exposureHistory.protectWayHealthBi" value="${caseDto.exposureHistory.protectWayHealthBi}"
						                        								code="1,2,3,4,5,6,7" onchange="toggleOtherCK('exposureHistory.protectWayHealthBi','contactWayOtherHealthBiDiv',7)"/>
						                        								<span id="contactWayOtherHealthBiDiv" style="display: none">
					                                  						 	<input type="text" name="exposureHistory.contactWayOtherHealthBi" value="${caseDto.exposureHistory.contactWayOtherHealthBi}"
					                                   									reg='{"maxlength":"100"}' style="width: 150px;"/>
					                                  						 </span>
					                                  						 </td>
									                                </tr>
								                                </table>
								                            </td>
								                        </tr>
						                                

						                            </table>
						                        </td>
						                    </tr> 
			                            </table>
			                        </td>
			                    </tr> 
			                    <tr >
                                    <th>3. 自（病例）发病起前10天内是否接触病、死的禽类：</th>
                                    <td><ehr:dic-radio dicmeta="PH00001" code="1,2,4" name="exposureHistory.contactDeathBi" value="${caseDto.exposureHistory.contactDeathBi}"
		                        						onchange="toggleOther('exposureHistory.contactDeathBi','contactFreDeathBiDiv',1)"/></td>
                                </tr>
                               
                                 <tr style="display: none;" id="contactFreDeathBiDiv">
			                        <td colspan="4" style="padding: 0px;">
			                            <table>
			                                <colgroup>
			                                    <col style="width: 30%"/>
			                                    <col style="width: 70%"/>
			                                </colgroup>
			                                 <tr>
			                                    <th>此期间接触频率是：</th>
			                                    <td><ehr:dic-radio onchange="toggleOther('exposureHistory.contactFreDeathBi','contactDayDeathBiDiv',1)" dicmeta="IDM00525"  name="exposureHistory.contactFreDeathBi" value="${caseDto.exposureHistory.contactFreDeathBi}"/>
					                                </td>
			                                </tr>
			                                <tr style="display: none;" id="contactDayDeathBiDiv">
						                        <td colspan="4" style="padding: 0px;">
						                            <table>
						                                <colgroup>
						                                    <col style="width: 30%"/>
						                                    <col style="width: 70%"/>
						                                </colgroup>
						                                 <tr>
						                                    <th>每天的接触和防护等方式都基本类似 ：</th>
						                                    <td>
						                                    	<ehr:dic-radio  onchange="toggleOther('exposureHistory.contactDayDeathBi','birdSpeciesDeathBiDiv',1);toggleOther('exposureHistory.contactDayDeathBi','tableFirstIndexesDiv2',2)"  dicmeta="PH00001" code="1,2" name="exposureHistory.contactDayDeathBi" value="${caseDto.exposureHistory.contactDayDeathBi}"/> 
								                                    <span id="tableFirstIndexesDiv2" style="display: none">
											                      		(按表1收集有接触的当天的如下信息)
										                           </span>  
								                            </td>
						                                </tr>
						                                <tr style="display: none;" id="birdSpeciesDeathBiDiv">
									                        <td colspan="4" style="padding: 0px;">
									                            <table>
									                                <colgroup>
									                                    <col style="width: 30%"/>
									                                    <col style="width: 70%"/>
									                                </colgroup>
									                                <tr>
									                                    <th>3.1 接触禽的种类（可多选）：</th>
									                                    <td><ehr:dic-checkbox name="exposureHistory.birdSpeciesDeathBi" dicmeta="IDM00523" value="${caseDto.exposureHistory.birdSpeciesDeathBi}"
	                                    										/>
											                            </td>
									                                </tr>
									                                <tr>
									                                    <th>3.2 接触方式（可多选）：</th>
									                                    <td><ehr:dic-checkbox name="exposureHistory.contactWayDeathBi" dicmeta="IDM00526" value="${caseDto.exposureHistory.contactWayDeathBi}"
	                                    									/>
											                             </td>
									                                </tr>
									                                 <tr>
									                                    <th>3.3 接触病死禽类时，手部伤口情况：</th>
									                                    <td><ehr:dic-checkbox dicmeta="IDM00527"  name="exposureHistory.handDeathBi" value="${caseDto.exposureHistory.handDeathBi}"
			                       										 	/></td>
									                                </tr>
									                                 <tr>
									                                    <th>3.4 接触禽类时是否采取防护措施：</th>
									                                    <td><ehr:dic-radio dicmeta="IDM00528"  name="exposureHistory.protectDeathBi" value="${caseDto.exposureHistory.protectDeathBi}"
						                        								onchange="hnCase.toggleOnes('exposureHistory.protectDeathBi','protectWayDeathBiDiv','1,2')"/></td>
									                                </tr>
									                                 <tr style="display: none;" id="protectWayDeathBiDiv">
									                                    <th>3.4.1 措施是（可多选）：</th>
									                                    <td><ehr:dic-checkbox dicmeta="IDM00529"  name="exposureHistory.protectWayDeathBi" value="${caseDto.exposureHistory.protectWayHealthBi}"
						                        								onchange="toggleOtherCK('exposureHistory.protectWayDeathBi','protectWayOtherDeathBiDiv',7)"		/>
					
						                        								<span id="protectWayOtherDeathBiDiv" style="display: none">
					                                  						 	<input type="text" name="exposureHistory.protectWayOtherDeathBi" value="${caseDto.exposureHistory.protectWayOtherDeathBi}"
		                                   												reg='{"maxlength":"100"}' style="width: 150px;"/>
					                                  						 </span>
					                                  						 </td>
									                                </tr>
								                                </table>
								                            </td>
								                        </tr>
						                            </table>
						                        </td>
						                    </tr> 
			                            </table>
			                        </td>
			                    </tr> 
                            </table>
                        </td>
                    </tr> 
		          
		            <tbody id="exposureHistoryPart1">
                        <tr>
                            <td colspan="4">
                                <div id="exposureList1">
									<jsp:include page="exposureList1.jsp"></jsp:include>
                                </div>
                            </td>
                        </tr>
                        <tr>
                            <td colspan="4"><br/>备注：
															<br/>接触禽的状态：（1）外表健康的禽类  （2）病、死禽
															<br/>接触禽的种类：（1）鸡  （2）鸭  （3）鹅  （4）鸽子  （5）野禽  （6）其它       
															<br/>接触方式：（1）饲养  （2）触摸、投食  （3）拣拾  （4）清洁圈舍 （5）销售  （6）运输  （7）销售生禽肉
															（8）购买  （9）宰杀  （10）捕杀  （11）清理摊档  （12）洗切禽肉  （13）未熟透食用  
															（14）其它           
															<br/>接触时手部伤口情况：（1）无伤口 （2）未愈合旧伤口 （3）接触过程造成新伤口
															<br/>防护措施：（1）一直有防护措施   （2）部分时间有防护措施   （3）无防护措施
															<br/>防护措施选项：（1）戴口罩    （2）戴手套    （3）戴面罩   （4）穿防护服  （5）护目镜
																（6）接触后立即洗手    （7）其它____________
                            </td>
                        </tr>
                    </tbody>	
					<tr>
						<td colspan="4" style="text-align: left;">(二) 环境暴露情况</td>
					</tr>
					<tr>
                               <th>1. 自（病例）发病起前10天内是否到过禽类养殖场所：</th>
                               <td><ehr:dic-radio onchange="toggleOther('exposureHistory.toBreedEn','contactFreBreedEnDiv',1)" dicmeta="PH00001" code="1,2,4" name="exposureHistory.toBreedEn" value="${caseDto.exposureHistory.toBreedEn}" /> 
                     				 </td>
                             </tr>
                              <tr style="display: none;" id="contactFreBreedEnDiv">
                        <td colspan="4" style="padding: 0px;">
                            <table>
                                <colgroup>
                                    <col style="width: 30%"/>
                                    <col style="width: 70%"/>
                                </colgroup>
                                 <tr>
                                    <th>此期间接触频率是：</th>
                                    <td>
                                    	<ehr:dic-radio onchange="toggleOther('exposureHistory.contactFreBreedEn','contactDayBreedEnDiv',1);hnCase.toggleOnes('exposureHistory.contactFreBreedEn','tableSecondIndexesDiv1','2,3')" dicmeta="IDM00525"  name="exposureHistory.contactFreBreedEn" value="${caseDto.exposureHistory.contactFreBreedEn}"/> 
                        						<span id="tableSecondIndexesDiv1" style="display: none">
						                      		(按表2收集有接触的当天的如下信息)
					                           </span>   
                        			</td>
                                </tr>
                                <tr style="display: none;" id="contactDayBreedEnDiv">
			                        <td colspan="4" style="padding: 0px;">
			                            <table>
			                                <colgroup>
			                                    <col style="width: 30%"/>
			                                    <col style="width: 70%"/>
			                                </colgroup>
			                                 <tr>
			                                    <th>每天的情况基本类似：</th>
			                                    <td><ehr:dic-radio onchange="toggleOther('exposureHistory.contactDayBreedEn','birdSpeciesBreedEnDiv',1);toggleOther('exposureHistory.contactDayBreedEn','tableSecondIndexesDiv2',2)" dicmeta="PH00001" code="1,2" name="exposureHistory.contactDayBreedEn" value="${caseDto.exposureHistory.contactDayBreedEn}"/> 
                         								<span id="tableSecondIndexesDiv2" style="display: none">
									                      		(按表2收集有接触的当天的如下信息)
								                         </span> 
                         						</td>
			                                </tr>
			                                <tr style="display: none;" id="birdSpeciesBreedEnDiv">
						                        <td colspan="4" style="padding: 0px;">
						                            <table>
						                                <colgroup>
						                                    <col style="width: 30%"/>
						                                    <col style="width: 70%"/>
						                                </colgroup>
						                                <tr>
						                                    <th>1.1 此养殖场所养殖的禽类种类：</th>
						                                    <td><ehr:dic-checkbox  name="exposureHistory.birdSpeciesBreedEn" dicmeta="IDM00523" value="${caseDto.exposureHistory.birdSpeciesBreedEn}"
                                 										/>
								                                   </td>
						                                </tr>
						                                <tr>
						                                    <th>1.2 访问时此场所有无禽类病死现象：</th>
						                                    <td><ehr:dic-radio dicmeta="PH00001"  code="1,2,4" name="exposureHistory.birdDeathBreedEn" value="${caseDto.exposureHistory.birdDeathBreedEn}"
                       										/>
								                                   </td>
						                                </tr>
						                                 <tr>
						                                    <th>1.3 是否到过养殖场所中饲养禽类的房间或车间：</th>
						                                    <td><ehr:dic-radio dicmeta="PH00001"  code="1,2,4" name="exposureHistory.workshopBreedEn" value="${caseDto.exposureHistory.workshopBreedEn}"
                      										 	/> </td>
						                                </tr>
						                                 <tr>
						                                    <th>1.4 是否直接接触过养殖场所内的禽类：</th>
						                                    <td><ehr:dic-radio dicmeta="PH00001"  code="1,2,4" name="exposureHistory.contactBreedEn" value="${caseDto.exposureHistory.contactBreedEn}"
                      										 	/></td>
						                                </tr>				                                
					                                </table>
					                            </td>
					                        </tr>						                               
			                            </table>
			                        </td>
			                    </tr> 
                            </table>
                        </td>
                    </tr> 
        
					<tbody id="exposureHistoryPart2">
                        <tr>
                            <td colspan="4">
                                <div id="exposureList2">
									<jsp:include page="exposureList2.jsp"></jsp:include>
                                </div>
                            </td>
                        </tr>  
                        <tr>
                            <td colspan="4">备注：
											<br/>接触禽的种类：（1）鸡  （2）鸭  （3）鹅  （4）鸽子  （5）野禽  （6）其它       
															
                      		</td>
                      </tr>          
                    </tbody>
                  
					<tr>
                       <th>2. 自（病例）发病起前10天内是否到过有活禽摊位的菜市场：</th>
                       <td>
             			   <ehr:dic-radio onchange="toggleOther('exposureHistory.toMarketEn','contactFreMarketEnDiv',1)" dicmeta="PH00001" code="1,2,4" name="exposureHistory.toMarketEn" value="${caseDto.exposureHistory.toMarketEn}" /> 
                        </td>
                     </tr>
                      <tr style="display: none;" id="contactFreMarketEnDiv">
			                <td colspan="4" style="padding: 0px;">
			                    <table>
			                        <colgroup>
			                            <col style="width: 30%"/>
			                            <col style="width: 70%"/>
			                        </colgroup>
			                         <tr>
			                            <th>此期间接触频率是：</th>
			                            <td><ehr:dic-radio onchange="toggleOther('exposureHistory.contactFreMarketEn','contactDayMarketEnDiv',1);hnCase.toggleOnes('exposureHistory.contactFreMarketEn','tableThirdIndexesDiv1','2,3')" dicmeta="IDM00525"  name="exposureHistory.contactFreMarketEn" value="${caseDto.exposureHistory.contactFreMarketEn}"/> 
                           				 		<span id="tableThirdIndexesDiv1" style="display: none">
							                      		(按表3收集有接触的当天的如下信息)
						                         </span> 
                           				 </td>
			                        </tr>
			                        <tr style="display: none;" id="contactDayMarketEnDiv">
			                   <td colspan="4" style="padding: 0px;">
			                       <table>
			                           <colgroup>
			                               <col style="width: 30%"/>
			                               <col style="width: 70%"/>
			                           </colgroup>
			                            <tr>
			                               <th>每天的情况基本类似：</th>
			                               <td><ehr:dic-radio onchange="toggleOther('exposureHistory.contactDayMarketEn','passagewayMarketEnDiv',1);toggleOther('exposureHistory.contactDayMarketEn','tableThirdIndexesDiv2',2)" dicmeta="PH00001" code="1,2" name="exposureHistory.contactDayMarketEn" value="${caseDto.exposureHistory.contactDayMarketEn}"/> 
	                           					<span id="tableThirdIndexesDiv2" style="display: none">
							                      		(按表3收集有接触的当天的如下信息)
						                         </span> 			
	                           				</td>
			                           </tr>
			                           <tr style="display: none;" id="passagewayMarketEnDiv">
					                      <td colspan="4" style="padding: 0px;">
					                          <table>
					                              <colgroup>
					                                  <col style="width: 30%"/>
					                                  <col style="width: 70%"/>
					                              </colgroup>
					                              <tr>
					                                  <th>2.1 是否经过有活禽摊位的通道：</th>
					                                  <td><ehr:dic-radio dicmeta="PH00001" code="1,2,4" name="exposureHistory.passagewayMarketEn" value="${caseDto.exposureHistory.passagewayMarketEn}"
		                        										/>
					                                   </td>
					                              </tr>
					                              <tr>
					                                  <th>2.2 是否到过活禽摊位1米之内的范围：</th>
					                                  <td><ehr:dic-radio dicmeta="PH00001" code="1,2,4" name="exposureHistory.nearMarketEn" value="${caseDto.exposureHistory.nearMarketEn}"
		                        										/> 
					                                   </td>
					                              </tr>
					                               <tr>
					                                  <th>2.3 是否直接接触活禽摊位的活禽：</th>
					                                  <td><ehr:dic-radio dicmeta="PH00001" code="1,2,4" name="exposureHistory.contactMarketEn" value="${caseDto.exposureHistory.contactMarketEn}"
		                       										 	/> </td>
					                              </tr>
					                               <tr>
					                                  <th>2.4 自（病例）发病起前10天内共访问次数：</th>
					                                  <td><input type="text" name="exposureHistory.visitNumMarketEn" value="${caseDto.exposureHistory.visitNumMarketEn}"
	                                      						 reg='{"maxlength":"100"}' style="width: 50px;"/> 次</td>
					                              </tr>				                                
					                             </table>
					                         </td>
			                     		</tr>						                               
			                       </table>
			                   </td>
			               </tr> 
                    </table>
                </td>
            </tr> 
	
					 <tbody id="exposureHistoryPart3">
                        <tr>
                            <td colspan="4">
                                <div id="exposureList3">
									<jsp:include page="exposureList3.jsp"></jsp:include>
                                </div>
                            </td>
                        </tr>            
                    </tbody>	
					<tr>
						<td colspan="4" style="text-align: left;">(三) 病例/发热病人暴露史</td>
					</tr>
					<tr>						
		                <th>1.是否与H7N9禽流感确诊病例为三代以内血亲：</th>
		                <td colspan="3">
							<ehr:dic-radio dicmeta="PH00001" code="1,2" name="exposureHistory.relativesCa" value="${caseDto.exposureHistory.relativesCa}" /> 
							（具体为<input type="text" name="exposureHistory.relationshipCa" value="${caseDto.exposureHistory.relationshipCa}"
	                                       reg='{"maxlength":"100"}' style="width: 50px;"/> 关系）
	                     </td>
					</tr>
					<tr>						
		                <th>2. 自（病例）发病起前10天内至（病例）出现结局事件前，是否与人感染H7N9禽流感疑似或确诊病例接触过:</th>
		                <td colspan="3">							
							<ehr:dic-radio onchange="toggleOther('exposureHistory.contactCa','contactFreCaDiv',1)" dicmeta="PH00001" code="1,2,4" name="exposureHistory.contactCa" value="${caseDto.exposureHistory.contactCa}" />   		
	                     </td>
					</tr>
                    <tr style="display: none;" id="contactFreCaDiv">
		                  <td colspan="4" style="padding: 0px;">
		                      <table>
		                          <colgroup>
		                              <col style="width: 30%"/>
		                              <col style="width: 70%"/>
		                          </colgroup>
		                           <tr>
		                              <th>此期间接触频率是: </th>
		                              <td>
		                  				  <ehr:dic-radio onchange="toggleOther('exposureHistory.contactFreCa','contactDayCaDiv',1);hnCase.toggleOnes('exposureHistory.contactFreCa','tableForthIndexesDiv1','2,3')" dicmeta="IDM00525"  name="exposureHistory.contactFreCa" value="${caseDto.exposureHistory.contactFreCa}"/> 
		                  				  <span id="tableForthIndexesDiv1" style="display: none">
							                      		(按表4收集有接触的当天的如下信息)
						                   </span> 
						                 </td>
		                          </tr>
                          		  <tr style="display: none;" id="contactDayCaDiv">
				                     <td colspan="4" style="padding: 0px;">
				                         <table>
				                             <colgroup>
				                                 <col style="width: 30%"/>
				                                 <col style="width: 70%"/>
				                             </colgroup>
				                              <tr>
				                                 <th>每天的接触和防护等方式都基本类似：</th>
				                                 <td><ehr:dic-radio onchange="toggleOther('exposureHistory.contactDayCa','contactWayCaDiv',1);toggleOther('exposureHistory.contactDayCa','tableForthIndexesDiv2',2)" dicmeta="PH00001" code="1,2" name="exposureHistory.contactDayCa" value="${caseDto.exposureHistory.contactDayCa}"/> 
		                           					 <span id="tableForthIndexesDiv2" style="display: none">
								                      		(按表4收集有接触的当天的如下信息)
							                         </span> 
	                           					 </td>
				                             </tr>
				                             <tr style="display: none;" id="contactWayCaDiv">
							                        <td colspan="4" style="padding: 0px;">
							                            <table>
							                                <colgroup>
							                                    <col style="width: 30%"/>
							                                    <col style="width: 70%"/>
							                                </colgroup>
							                                <tr>
							                                    <th>2.1 如果接触过人感染H7N9禽流感疑似或确诊病例，接触方式为：</th>
							                                    <td><ehr:dic-checkbox onchange="toggleOtherCK('exposureHistory.contactWayCa','diagnosisCaDiv',6)" dicmeta="IDM00534"  name="exposureHistory.contactWayCa" value="${caseDto.exposureHistory.contactWayCa}"
		                        										/>
									                                   </td>
							                                </tr>
							                                <tr style="display: none;" id="diagnosisCaDiv">
							                                    <th>2.1.1 如为“诊治病人”，具体操作为（可多选）：</th>
							                                    <td><ehr:dic-checkbox dicmeta="IDM00533"  name="exposureHistory.diagnosisCa" value="${caseDto.exposureHistory.diagnosisCa}"
		                        										/>
									                                   </td>
							                                </tr>
							                                
							                                <tr>
							                                    <th>2.2 接触人感染H7N9禽流感疑似或确诊病例时是否有防护措施：</th>
							                                    <td><ehr:dic-radio onchange="toggleOther('exposureHistory.protectCa','protectWayCaDiv',1)" dicmeta="PH00001" code="1,2,4" name="exposureHistory.protectCa" value="${caseDto.exposureHistory.protectCa}"
		                        										/>
									                                   </td>
							                                </tr>
							                                 <tr style="display: none;" id="protectWayCaDiv">
								                                 <th>2.2.1  采取的措施有（可多选）：</th>
							                                    <td><ehr:dic-checkbox dicmeta="IDM00529"  name="exposureHistory.protectWayCa" value="${caseDto.exposureHistory.protectWayCa}"/>
									                                   </td>
							                                </tr>
							                                 <tr>
							                                    <th>2.3 接触人感染H7N9禽流感疑似或确诊病例的持续时间：</th>
							                                    <td><input type="text" name="exposureHistory.contactTimeCa" value="${caseDto.exposureHistory.contactTimeCa}"
	                                       													reg='{"maxlength":"100"}' style="width: 50px;"/> 小时</td>
							                                </tr>					                                			                                
							                       </table>
							               	  </td>
		                      			 </tr>						                               
		                         </table>
		                     </td>
		                 </tr> 
                      </table>
                  </td>
              </tr> 
         		
				<tr>						
		               <th>3. 自（病例）发病起前10天内，是否接触过除上述病例外的其它发热呼吸道病人：</th>
		               <td colspan="3">							
						<ehr:dic-radio onchange="toggleOther('exposureHistory.contactFe','contactFreFeDiv',1)" dicmeta="PH00001" code="1,2,4" name="exposureHistory.contactFe" value="${caseDto.exposureHistory.contactFe}" /> 
						
					</td>
				</tr>
                 <tr style="display: none;" id="contactFreFeDiv">
                 <td colspan="4" style="padding: 0px;">
                     <table>
                         <colgroup>
                             <col style="width: 30%"/>
                             <col style="width: 70%"/>
                         </colgroup>
                          <tr>
                             <th>此期间接触频率是：</th>
                             <td>
                 				  <ehr:dic-radio onchange="toggleOther('exposureHistory.contactFreFe','contactDayFeDiv',1);hnCase.toggleOnes('exposureHistory.contactFreFe','tableForthIndexesDiv3','2,3')" dicmeta="IDM00525"  name="exposureHistory.contactFreFe" value="${caseDto.exposureHistory.contactFreFe}"/> 
                 				   <span id="tableForthIndexesDiv3" style="display: none">
				                      		(按表4收集有接触的当天的如下信息)
			                   </span> 
                 			  </td>
                         </tr>
                       		  <tr style="display: none;" id="contactDayFeDiv">
	                     <td colspan="4" style="padding: 0px;">
	                         <table>
	                             <colgroup>
	                                 <col style="width: 30%"/>
	                                 <col style="width: 70%"/>
	                             </colgroup>
	                              <tr>
	                                 <th>每天的接触和防护等方式都基本类似：</th>
	                                 <td><ehr:dic-radio onchange="toggleOther('exposureHistory.contactDayFe','contactWayFeDiv',1);toggleOther('exposureHistory.contactDayFe','tableForthIndexesDiv4',2)" dicmeta="PH00001" code="1,2" name="exposureHistory.contactDayFe" value="${caseDto.exposureHistory.contactDayFe}"/> 
                         					  <span id="tableForthIndexesDiv4" style="display: none">
						                      		(按表4收集有接触的当天的如下信息)
					                   </span> 
                         				 </td>
	                             </tr>
	                             <tr style="display: none;" id="contactWayFeDiv">
				                        <td colspan="4" style="padding: 0px;">
				                            <table>
				                                <colgroup>
				                                    <col style="width: 30%"/>
				                                    <col style="width: 70%"/>
				                                </colgroup>
				                                <tr>
				                                    <th>3.1 接触方式为：</th>
				                                    <td><ehr:dic-checkbox onchange="toggleOtherCK('exposureHistory.contactWayFe','diagnosisFeDiv',6)" dicmeta="IDM00534"  name="exposureHistory.contactWayFe" value="${caseDto.exposureHistory.contactWayFe}"
                       										/>
						                                   </td>
				                                </tr>
				                                <tr style="display: none;" id="diagnosisFeDiv">
				                                    <th>3.1.1 如为“诊治病人”，具体操作为（可多选）：</th>
				                                    <td><ehr:dic-checkbox dicmeta="IDM00533"  name="exposureHistory.diagnosisFe" value="${caseDto.exposureHistory.diagnosisFe}"
                       										/>
						                                   </td>
				                                </tr>
				                                
				                                <tr>
				                                    <th>3.2 接触发热病人时是否有防护措施：</th>
				                                    <td><ehr:dic-radio onchange="toggleOther('exposureHistory.protectFe','protectWayFeDiv',1)"  dicmeta="PH00001" code="1,2,4" name="exposureHistory.protectFe" value="${caseDto.exposureHistory.protectFe}"
                       										/>
						                                   </td>
				                                </tr>
				                                 <tr style="display: none;" id="protectWayFeDiv">
				                                    <th>3.2.1  采取的措施有（可多选）：</th>
				                                    <td><ehr:dic-checkbox dicmeta="IDM00529"  name="exposureHistory.protectWayFe" value="${caseDto.exposureHistory.protectWayFe}"
                       										/>
						                                   </td>
				                                </tr>
				                                 <tr>
				                                    <th>3.3 接触发热病人的持续时间：</th>
				                                    <td><input type="text" name="exposureHistory.contactTimeFe" value="${caseDto.exposureHistory.contactTimeFe}"
                                     													reg='{"maxlength":"100"}' style="width: 50px;"/> 小时</td>
				                                </tr>					                                			                                
				                       </table>
				               	  </td>
                     		</tr>						                               
                         </table>
                     </td>
                 </tr> 
                    </table>
                </td>
            </tr> 
 
					<tbody id="exposureHistoryPart4">
                        <tr>
                            <td colspan="4">
                                <div id="exposureList4">
									<jsp:include page="exposureList4.jsp"></jsp:include>
                                </div>
                            </td>
                        </tr>  
                        <tr>
                            <td colspan="4">备注：
													<br/>	接触病例/发热病人类型：（1）H7N9禽流感疑似或确诊病例 （2）发热病人
													<br/>	接触方式：（1）共同生活   （2）共同学习和工作  （3）同病房病友  （4）探视病人
															          （5）诊治病人   （6）陪护病人   （7）其他____________
													<br/>	诊治病人的具体操作：（1）查体  （2）输液  （3）气管插管  （4）抽吸分泌物
															（5）抽血  （6）拍片  （7）其他             
													<br/>	防护措施：（1）戴口罩（若有，则口罩类型为：N95口罩、一次性外科口罩、棉纱口罩、其它类型口罩） 
															（2）戴面罩  （3）穿防护服（规范、不规范）  （4）护目镜   （5）手套（布、纱手套，橡胶手套） 
															（6）帽子    （7）白大褂   （8）其他              
													<br/>	接触禽的种类：（1）鸡  （2）鸭  （3）鹅  （4）鸽子  （5）野禽  （6）其它       	
															
                      		</td>
                      </tr>          
                    </tbody>
					<tr>
						<td colspan="4" style="text-align: left;">第四部分  旅行史</td>
					</tr>
					<tr>
						<th>自（病例）发病起前10天内是否去过外省或本省其他地市（区）旅行：</th>
						<td colspan="3"><ehr:dic-radio dicmeta="PH00001" name="otherCondition.travel" code="1,2" value="${caseDto.otherCondition.travel}"
                                           onchange="toggleOther('otherCondition.travel','addressDiv',1)"/>
                          
						</td>
					</tr>
					<tr style="display: none;" id="addressDiv">
                        <td colspan="4" style="padding: 0px;">
                            <table>
                                <colgroup>
                                    <col style="width: 30%"/>
                                    <col style="width: 70%"/>
                                </colgroup>
                                <tr>
									<th>旅行地点1：</th>
									<td colspan="3">
										<input type="text" id ="trcategoryFirst" name="otherCondition.trcategoryFirst" reg='{"maxlength":"50"}'
	                                           value="${caseDto.otherCondition.trcategoryFirst}" style="width: 180px;">
										<%--<ehr:dic-town-village villageId="pavillage_address" townId="patown_address" villageName="exposureHistory.pastreet" townName="exposureHistory.patownShip"
					                                              villageValue="${caseDto.exposureHistory.pastreet}" townValue="${caseDto.exposureHistory.patownShip}" width="180px;"/>
						                         <input type="text" id="pahouseNumber" name="generalCondition.pahouseNumber" value="${caseDto.generalCondition.pahouseNumber}"
						                               reg='{"maxlength":"50"}'  style="width: 180px;"> --%>
			                            
									</td>
								</tr>
								<tr>
									<th>旅行地点2：</th>
									<td colspan="3">
						                     
			                            <input type="text" id ="trcategorySecond" name="otherCondition.trcategorySecond" reg='{"maxlength":"50"}'
	                                   		   value="${caseDto.otherCondition.trcategorySecond}" style="width: 180px;">
									</td>
								</tr>
								<tr>
									<th>旅行地点3：</th>
									<td colspan="3">
						                 <input type="text" id ="trcategoryThird" name="otherCondition.trcategoryThird" reg='{"maxlength":"50"}'
	                                  			value="${caseDto.otherCondition.trcategoryThird}" style="width: 180px;">    
			                            
									</td>
								</tr>
                            </table>
                        </td>
                    </tr>
				</table>
			</fieldset>

			<fieldset>
				<table class="posttable">
					<colgroup>
                        <col style="width: 30%" />
                        <col style="width: 30%" />
                        <col style="width: 20%" />
                        <col style="width: 20%" />
					</colgroup>
					<tr>
						<th>调查人：</th>
						<td>
                            <ehr:user userCode="${caseDto.caseInformation.modifyRespondents}"/>
                        </td>
						<th>调查日期：</th>
						<td><tag:dateInput name="caseInformation.modifySurveyDate"
								pattern="yyyy/MM/dd" nullToToday="true" onlypast="true" date="${caseDto.caseInformation.modifySurveyDate}"/></td>
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
