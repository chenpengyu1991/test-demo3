<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tag" %>

<script src="${pageContext.request.contextPath}/js/views/idm/case/edit.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/views/idm/case/hiv.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/views/idm/idmCommon.js" type="text/javascript"></script>
<c:if test="${isPrint != 1}">
    <jsp:include page="../caseButton.jsp"></jsp:include>
</c:if>
<form id="caseForm">
	<div class="postcontent <c:if test="${isPrint != 1}">contentfixed</c:if>">
		<i class="popno">
			HIV/AIDS流行病学个案调查表<br />
<!-- 			<span>（丙类传染病）</span> -->
		</i>
		<input type="hidden" name="idmId" value="${idmId}" id="idmId"/>
		<div class="postdiv">
            <table  class="posttable">
                <colgroup>
                    <col style="width: 100%;" />
                    <col style="width: 200px;" />
                </colgroup>
                <tr>
                    <td style="text-align: left;">报表编号:<input type="text" name="caseInformation.mediRecordNum"
                        value="${caseDto.caseInformation.mediRecordNum}" reg='{"maxlength":"14"}'
                        style="width: 150px;" /></td>
                  <%--   <td style="text-align: right;">调查单位: <ehr:org code="${caseDto.caseInformation.modifySurveyOrg}"/>
                    </td> --%>
                </tr>
               <!--  <tr>
                    <td colspan="2" style="text-align: left;"><span>（按照国家标准编码：省编码＋市编码＋县编码＋病例序号）</span></td>
                </tr> -->
            </table>

			<fieldset>
				<legend>一、基本信息</legend>
				<table class="posttable">
					<colgroup>
                        <col style="width: 25%" />
                        <col style="width: 25%" />
                        <col style="width: 20%" />
                        <col style="width: 30%" />
					</colgroup>
					<tr>
						<th><label class="required">患者姓名:</label></th>
						<td colspan="3"><input type="text" name="generalCondition.name" value="${caseDto.generalCondition.name}"
	                                           reg='{"maxlength":"100","required":"true"}' style="width: 150px;"/>
	                        （患儿家长姓名：<input type="text" name="generalCondition.parentsName" value="${caseDto.generalCondition.parentsName}"
	                                       reg='{"maxlength":"50"}' style="width: 150px;"/>）</td>
					</tr>
					<tr>
						<th>身份证号:</th>
						<td><input type="text" id="idCard" name="generalCondition.idcard" value="${caseDto.generalCondition.idcard}" reg='{"idCard":"true"}'
	                               placeholder="输入身份证获取个人信息"/></td>
					</tr>
	                <tr>
	                    <th>性别:</th>
	                    <td><ehr:dic-radio dicmeta="GBT226112003" name="generalCondition.gender" code="1,2" value="${caseDto.generalCondition.gender}"/></td>
	                </tr>
					<tr>
						<th>出生日期:</th>
						<td colspan="3"><%-- <tag:dateInput name="generalCondition.birthday" date="${caseDto.generalCondition.birthday}" pattern="yyyy/MM/dd" style="width:90px;"/> --%>
						<input type="text" class="layui-input x-admin-content-sm-date" id="generalConditionBirthday" name="generalCondition.birthday" style="width: 90px;padding-left: 0px;" value="<fmt:formatDate value='${caseDto.generalCondition.birthday}' pattern='yyyy/MM/dd'/>" />
	                        （如出生日期不详，实足年龄
							<input type="text" id="age" name="generalCondition.age" style="width: 60px;" value="${caseDto.generalCondition.age}" reg='{"maxlength":"6"}'/>
							年龄单位:<ehr:dic-radio name="generalCondition.ageUnit" dicmeta="IDM00003" value="${caseDto.generalCondition.ageUnit}"/> )
	                    </td>
					</tr>
					<tr>
						<th>工作单位:</th>
						<td><input type="text" name="generalCondition.unitName" value="${caseDto.generalCondition.unitName}" reg='{"maxlength":"70"}'/></td>
					</tr>
					<tr>
						<th>联系电话:</th>
						<td><input type="text" name="generalCondition.phoneNumber" value="${caseDto.generalCondition.phoneNumber}" reg='{"regex":"phone"}'/></td>
	
					</tr>
	                <tr>
	                    <th><label class="required">病人属于:</label></th>
	                    <td colspan="3"><ehr:dic-radio name="generalCondition.patientAttribute" dicmeta="CV0201104" value="${caseDto.generalCondition.patientAttribute}"
	                            reg='{"required":"true"}'/> </td>
	                </tr>
					<tr>
						<th><label class="required">现住址(详填):</label></th>
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
	                    <th><label class="required">患者职业:</label></th>
	                    <td colspan="3">
	                        <ehr:dic-list id="occupationId" dicmeta="GBT6565" name="generalCondition.occupation" width="180px;" value="${caseDto.generalCondition.occupation}" reg='{"required":"true"}'
	                                      code="CV020120201,CV020120202,CV020120203,CV020120204,CV020120205,CV020120206,CV020120207,CV020120208,CV020120209,CV020120210,CV020120211,CV020120212,CV020120213,CV020120214,CV020120215,CV020120216,CV020120299,CV020120217"
	                                />
	                        <span  id="occupationOtherPart" style="display: none">
	                            <input type="text" name="generalCondition.occupationOther" value="${caseDto.generalCondition.occupationOther}"
	                                   reg='{"maxlength":"30"}' placeholder="请注明" style="width: 200px;"/>
	                        </span>
	                    </td>
	                </tr>
	                <tr>
	                    <th><label class="required">疾病名称:</label></th>
	                    <td colspan="3">
	                        <ehr:dic-radio reg='{"required":"true"}' dicmeta="IDM00500" name="attackCondition.diseaseName" code="1,2,3,4" value="${caseDto.attackCondition.diseaseName}"/>
	                    </td>
	                </tr>
					<tr>
						<th><label class="required">发病日期:</label></th>
						<td colspan="3">
	                        <%-- <tag:dateInput id="pathogenesisDateId" name="attackCondition.pathogenesisDate" onlypast="true" date="${caseDto.attackCondition.pathogenesisDate}"
	                               pattern="yyyy/MM/dd" reg='{"required":"true"}' style="width:120px;" /> --%>
	                               <input type="text" reg='{"required":"true"}' class="layui-input x-admin-content-sm-date" id="pathogenesisDateId" name="attackCondition.pathogenesisDate" style="width: 120px;padding-left: 0px;" value="<fmt:formatDate value='${caseDto.attackCondition.pathogenesisDate}' pattern='yyyy/MM/dd'/>" />
	                            (病原携带者填初检日期或就诊时间)</td>
					</tr>
					
					<tr>
						<th><label class="required">诊断日期:</label></th>
						<td><%-- <tag:dateInput id="confirmationDateId" name="attackCondition.confirmationDate" date="${caseDto.attackCondition.confirmationDate}" onlypast="true"
	                               pattern="yyyy/MM/dd" reg='{"required":"true"}'/> --%>
	                               <input type="text" reg='{"required":"true"}' class="layui-input x-admin-content-sm-date" id="confirmationDateId" name="attackCondition.confirmationDate" style="width: 120px;padding-left: 0px;" value="<fmt:formatDate value='${caseDto.attackCondition.confirmationDate}' pattern='yyyy/MM/dd'/>" />
	                               </td>
					</tr>
					<tr>
						<th>死亡日期:</th>
						<td><%-- <tag:dateInput name="attackCondition.dieDt" date="${caseDto.attackCondition.dieDt}" onlypast="true" pattern="yyyy/MM/dd"
	                                       /> --%>
	                             <input type="text" reg='{"required":"true"}' class="layui-input x-admin-content-sm-date" id="attackConditionDieDtId" name="attackCondition.dieDt" style="width: 120px;padding-left: 0px;" value="<fmt:formatDate value='${caseDto.attackCondition.dieDt}' pattern='yyyy/MM/dd'/>" />          
	                                       </td>
					</tr>  
				</table>
			</fieldset>

			<fieldset>
				<legend>二、扩展基本信息</legend>
				<table class="posttable">
					<colgroup>
                        <col style="width: 25%" />
                        <col style="width: 25%" />
                        <col style="width: 20%" />
                        <col style="width: 30%" />
					</colgroup>
					<tr>
						<th>婚姻:</th>
						<td colspan="3"><ehr:dic-radio name="generalCondition.marriage" dicmeta="IDM00345"
	                                                        value="${caseDto.generalCondition.marriage}"/>
	                    </td>
	
					</tr>
					<tr>
						<th>民族:</th>
						<td colspan="3">
						<ehr:dic-list name="generalCondition.nation" dicmeta="GBT3304" width="180px;"
	                                                        value="${caseDto.generalCondition.nation}"/>
	                    </td>
	
					</tr>
					<tr>
						<th>文化程度:</th>
						<td colspan="3">
						 <%-- <ehr:dic-list id="educationId" name="report.education" dicmeta="GBT46582006" value="${reportDto.report.education}"
                                               code="IDM11,IDM12,IDM04,IDM13,IDM03,IDM02,IDM07,90" /> --%>
						<ehr:dic-radio name="generalCondition.education" dicmeta="GBT46582006"
	                                                       code="IDM11,IDM12,IDM04,IDM13,IDM03,IDM02,IDM07,90" value="${caseDto.generalCondition.education}"/>
	                    </td>
					</tr>
					<tr>
						<th>配偶/固定性伴HIV感染状况:</th>
						<td colspan="3"><ehr:dic-radio name="attackCondition.partnerInfected" dicmeta="IDM00501" value="${caseDto.attackCondition.partnerInfected}"/>
	                    </td>
					</tr>			
					<tr>
						<th>子女HIV感染情况:</th>
						<td colspan="3"><ehr:dic-radio name="attackCondition.childrenInfected" dicmeta="IDM00502"
	                                                       value="${caseDto.attackCondition.childrenInfected}"/>
	                    </td>
					</tr>
					<tr>
						<th>户籍地址:</th>
						<td colspan="3">
							<ehr:dic-town-street-village streetId="hrstreet_address" townId="hrtown_address" streetName="generalCondition.hrstreet" townName="generalCondition.hrtownShip"
														 streetValue="${caseDto.generalCondition.hrstreet}" townValue="${caseDto.generalCondition.hrtownShip}" width="140px;"
														 villageId="hrvillage_address" villageName="generalCondition.hrGroup" villageValue="${caseDto.generalCondition.hrGroup}"/>
							<input type="text" name="generalCondition.hrhouseNumber" id="hrhouseNumber" value="${caseDto.generalCondition.hrhouseNumber}"
								   style="width: 180px;" reg='{"maxlength":"50"}'>
							<span id="spanHrNumber">(门牌号)</span>
						</td>
					</tr>	
					<tr>
		                <th>是否接受CD<sup>4</sup>检测:</th>
		                <td colspan="3">
		                    <ehr:dic-radio dicmeta="PH00001" code="1,2" name="labExamine.cdExamine" value="${caseDto.labExamine.cdExamine}"
		                        />
		                    <span id="hepatitisDtPart" style="display: none">
		                    
		                      CD<sup>4</sup>检测结果：
		              					<input type="text" name="labExamine.cdExamineResult"  value="${caseDto.labExamine.cdExamineResult}"
                                             reg='{"maxlength":"20"}' style="width:60px;"/>个/ul
		                    
		                        CD<sup>4</sup>检测日期：
		                        <%-- <tag:dateInput name="labExamine.cdExamineDate" date="${caseDto.labExamine.cdExamineDate}"
		                                               pattern="yyyy/MM/dd" style="width:100px;"/> --%>
                                <input type="text" class="layui-input x-admin-content-sm-date" id="labExamineCdExamineDate" name="labExamine.cdExamineDate" style="width: 100px;padding-left: 0px;" value="<fmt:formatDate value='${caseDto.labExamine.cdExamineDate}' pattern='yyyy/MM/dd'/>" /> 
		                    </span>
		                </td>
		            </tr>
		            <tr>
		                <th>目前是否接受抗病毒治疗：</th>
		                <td colspan="3">
		                    <ehr:dic-radio dicmeta="PH00001" code="1,2" name="attackCondition.takeOtherAntiviralDrug" value="${caseDto.attackCondition.takeOtherAntiviralDrug}"
		                        />
		                </td>
		            </tr>
		            <tr>
		                <th>死亡时病程阶段：</th>
		                <td colspan="3">
		                    <ehr:dic-radio dicmeta="IDM00503" code="1,2" name="attackCondition.deathCourse" value="${caseDto.attackCondition.deathCourse}"
		                        />
		                </td>
		            </tr>
		            <tr>
		                <th>主要死因：</th>
		                <td colspan="3">
		                    <ehr:dic-radio dicmeta="IDM00504" name="attackCondition.deathCause" value="${caseDto.attackCondition.deathCause}"
		                        onchange="toggleOther('attackCondition.deathCause','deathCauseOtherDiv',4);"/>
		                    <span id="deathCauseOtherDiv" style="display: none">
		                        <input type="text" name="attackCondition.deathCauseOther" style="width:150px;" placeholder="若选择其他，请描叙"
		                               reg='{"maxlength":"100"}' value="${caseDto.attackCondition.deathCauseOther}"/>
		                    </span>
		                </td>
		            </tr>
				</table>
			</fieldset>

			<fieldset>
				<legend>三、诊断状态</legend>
				<table class="posttable">
					<colgroup>
                        <col style="width: 25%" />
                        <col style="width: 25%" />
                        <col style="width: 20%" />
                        <col style="width: 30%" />
					</colgroup>	
					 <tr>
	                    <th>WB确认结果：</th>
	                    <td colspan="3">
	                        <ehr:dic-radio dicmeta="IDM00505" name="diagnosis.wbExamineResult"  value="${caseDto.diagnosis.wbExamineResult}"/>
	                    </td>
	                </tr>
					<tr>
						<th>WB检测日期：</th>
						<td colspan="3">
	                        <%-- <tag:dateInput id="wbExamineDate" name="diagnosis.wbExamineDate" onlypast="true" date="${caseDto.diagnosis.wbExamineDate}"
	                               pattern="yyyy/MM/dd"  style="width:120px;" /> --%>
	                    <input type="text" class="layui-input x-admin-content-sm-date" id="wbExamineDate" name="diagnosis.wbExamineDate" style="width: 120px;padding-left: 0px;" value="<fmt:formatDate value='${caseDto.diagnosis.wbExamineDate}' pattern='yyyy/MM/dd'/>" />
	                            （病原携带者填就诊时间）</td>
					</tr>
					
					<tr>
						<th>艾滋病确诊日期：</th>
						<td><%-- <tag:dateInput id="confirmationDateId" name="diagnosis.hivConfirmationDate" date="${caseDto.diagnosis.hivConfirmationDate}" onlypast="true"
	                               pattern="yyyy/MM/dd" /> --%>
	                       <input type="text" class="layui-input x-admin-content-sm-date" id="diagnosisHivConfirmationDateId" name="diagnosis.hivConfirmationDate" style="padding-left: 0px;" value="<fmt:formatDate value='${caseDto.diagnosis.hivConfirmationDate}' pattern='yyyy/MM/dd'/>" />
	                               </td>
	                               
					</tr>
		</table>
	</fieldset>
	<fieldset>
			<legend>四、高危行为和危险因素</legend>
			<table class="posttable">
				<colgroup>
                       <col style="width: 25%" />
                       <col style="width: 25%" />
                       <col style="width: 20%" />
                       <col style="width: 30%" />
				</colgroup>			
				<tr>
					<td colspan="4" style="text-align: left;">(一)吸毒史:</td>
				</tr>
				<tr>
	                <th>吸毒史：</th>
	                <td colspan="3">
	                    <ehr:dic-radio dicmeta="PH00002" code="1,2" name="exposureHistory.takeDrugHis" value="${caseDto.exposureHistory.takeDrugHis}"
	                        onchange="toggleOther('exposureHistory.takeDrugHis','takeDrugDiv',1)"/>
	                </td>
		         </tr>
	             <tr style="display: none;" id="takeDrugDiv">
                     <td colspan="4" style="padding: 0px;">
                         <table>
                             <colgroup>
                                 <col style="width: 25%"/>
                                 <col style="width: 75%"/>
                             </colgroup>                        
                             <tr>
                                 <th>首次吸毒时间： </th>
                                 <td>
                                 	 <%-- <tag:dateInput name="exposureHistory.firstTakeDrugDate" date="${caseDto.exposureHistory.firstTakeDrugDate}"
	                                               pattern="yyyy/MM/dd" style="width:100px;"/> --%>
	                                 <input type="text" class="layui-input x-admin-content-sm-date" id="exposureHistoryFirstTakeDrugDateId" name="exposureHistory.firstTakeDrugDate" style="width: 100px;padding-left: 0px;" value="<fmt:formatDate value='${caseDto.exposureHistory.firstTakeDrugDate}' pattern='yyyy/MM/dd'/>" />
                          		 </td>
                             </tr>
                              <tr>
                                 <th>目前吸毒方式： </th>
                                 <td>
                                 	 <ehr:dic-radio dicmeta="IDM00506"  name="exposureHistory.takeDrugWay" value="${caseDto.exposureHistory.takeDrugWay}"/>
                          		 </td>
                             </tr>
                              <tr>
                                 <th>注射毒品史： </th>
                                 <td>
                                 	 <ehr:dic-radio dicmeta="PH00002" code="1,2" name="exposureHistory.drugInjectionHis" value="${caseDto.exposureHistory.drugInjectionHis}"/>
                          		 </td>
                             </tr>
                              <tr>
                                 <th>首次注射毒品时间： </th>
                                 <td>
                                 	 <%-- <tag:dateInput id="firstDrugInjectionDateId" name="exposureHistory.firstDrugInjectionDate" date="${caseDto.exposureHistory.firstDrugInjectionDate}" pattern="yyyy/MM/dd" style="width:100px;"/> --%>
                          		 	<input type="text" class="layui-input x-admin-content-sm-date" id="firstDrugInjectionDateId" name="exposureHistory.firstDrugInjectionDate" style="width: 100px;padding-left: 0px;" value="<fmt:formatDate value='${caseDto.exposureHistory.firstDrugInjectionDate}' pattern='yyyy/MM/dd'/>" />
                          		 </td>
                             </tr>
                              <tr>
                                 <th>共用注射器史： </th>
                                 <td>
                                 	 <ehr:dic-radio dicmeta="PH00002" code="1,2" name="exposureHistory.sharedInjectorHis" value="${caseDto.exposureHistory.sharedInjectorHis}"/>
                          		 </td>
                             </tr>
                              <tr>
                                 <th>配偶或固定性伴侣是否吸毒： </th>
                                 <td>
                                 	 <ehr:dic-radio dicmeta="IDM00507" name="exposureHistory.takeDrugPartner" value="${caseDto.exposureHistory.takeDrugPartner}"/>
                          		 </td>
                             </tr>
                          </table>
                     </td>
                </tr>
		        <tr>
					<td colspan="4" style="text-align: left;">(二)性接触史:</td>
				</tr>
		         	<tr>
	                <th>性接触史：</th>
	                <td colspan="3">
	                    <ehr:dic-radio dicmeta="PH00002" code="1,2" name="exposureHistory.sexBehaviorHis" value="${caseDto.exposureHistory.sexBehaviorHis}"
	                        onchange="toggleOther('exposureHistory.sexBehaviorHis','sexBehaviorHisDiv',1);"/>
	                </td>
		        </tr>
		        <tr style="display: none;" id="sexBehaviorHisDiv">
                     <td colspan="4" style="padding: 0px;">
                         <table>
                             <colgroup>
                                 <col style="width: 25%"/>
                                 <col style="width: 75%"/>
                             </colgroup>                        
                             <tr>
                                 <th>1.异性性行为： </th>
                                 <td>
                                 	 <ehr:dic-radio dicmeta="PH00002" code="1,2" name="exposureHistory.oppositeSexBehavior" value="${caseDto.exposureHistory.oppositeSexBehavior}"
                                 	  onchange="toggleOther('exposureHistory.oppositeSexBehavior','oppositeSexBehaviorDiv',1);"/>
                          		 </td>
                             </tr>
                             <tr style="display: none;" id="oppositeSexBehaviorDiv">
			                     <td colspan="4" style="padding: 0px;">
			                         <table>
			                             <colgroup>
			                                 <col style="width: 25%"/>
			                                 <col style="width: 75%"/>
			                             </colgroup>                        
			                             <tr>
			                                 <th>(1)商业性行为： </th>
			                                 <td>
			                                 	 <ehr:dic-radio dicmeta="PH00002" code="1,2" name="exposureHistory.commercialSexBehavior" value="${caseDto.exposureHistory.commercialSexBehavior}"
			                                 	                onchange="toggleOther('exposureHistory.commercialSexBehavior','commercialSexBehaviorDiv',1);"/>
					                     	 </td>
			                             </tr>
			                             <tr style="display: none;" id="commercialSexBehaviorDiv">
						                     <td colspan="4" style="padding: 0px;">
						                         <table>
						                             <colgroup>
						                                 <col style="width: 25%"/>
						                                 <col style="width: 75%"/>
						                             </colgroup>                        
						                             <tr>
						                                 <th>最近一次商业性行为时是否使用安全套： </th>
						                                 <td>
						                                 	 <ehr:dic-radio dicmeta="PH00001" code="1,2" name="exposureHistory.lastComBehCondom" value="${caseDto.exposureHistory.lastComBehCondom}"/>
								                     	</td> 
						                             </tr>
						                              <tr>
						                                 <th>过去一个月商业性行为时是否使用安全套： </th>
						                                 <td>
						                                 	 <ehr:dic-radio dicmeta="IDM00508"  name="exposureHistory.lastMonthComBehCondom" value="${caseDto.exposureHistory.lastMonthComBehCondom}"/>
								                     	 </td>
						                             </tr>
						                         </table>
						                     </td>
						                  </tr>						   
			                              <tr>
			                                 <th>(2)婚内性行为： </th>
			                                 <td>
			                                 	 <ehr:dic-radio dicmeta="PH00002" code="1,2" name="exposureHistory.marriageSexBehavior" value="${caseDto.exposureHistory.marriageSexBehavior}"
			                                 	                onchange="toggleOther('exposureHistory.marriageSexBehavior','marriageSexBehaviorDiv',1);"/>
					                     	 </td>
			                             </tr>
			                             <tr style="display: none;" id="marriageSexBehaviorDiv">
						                     <td colspan="4" style="padding: 0px;">
						                         <table>
						                             <colgroup>
						                                 <col style="width: 25%"/>
						                                 <col style="width: 75%"/>
						                             </colgroup>                        
						                             <tr>
						                                 <th>最近一次夫妻性生活时是否使用安全套： </th>
						                                 <td>
						                                 	 <ehr:dic-radio dicmeta="PH00001" code="1,2" name="exposureHistory.lastMarBehCondom" value="${caseDto.exposureHistory.lastMarBehCondom}"/>
					                     			   	 </td> 
						                             </tr>
						                              <tr>
						                                 <th>过去一个月夫妻性生活时是否使用安全套： </th>
						                                 <td>
						                                 	 <ehr:dic-radio dicmeta="IDM00508" name="exposureHistory.lastMonthMarBehCondom" value="${caseDto.exposureHistory.lastMonthMarBehCondom}"/>
					                     				 </td>
						                             </tr>
						                         </table>
						                     </td>
						                  </tr>
						                  <tr>
			                                 <th>(3)婚外非商业性行为： </th>
			                                 <td>
			                                 	 <ehr:dic-radio dicmeta="PH00002" code="1,2" name="exposureHistory.noComMarSexBeh" value="${caseDto.exposureHistory.noComMarSexBeh}"
			                                 	      onchange="toggleOther('exposureHistory.noComMarSexBeh','noComMarSexBehDiv',1);"/>
				                  
					                     	 </td>
			                             </tr>
			                             <tr style="display: none;" id="noComMarSexBehDiv">
						                     <td colspan="4" style="padding: 0px;">
						                         <table>
						                             <colgroup>
						                                 <col style="width: 25%"/>
						                                 <col style="width: 75%"/>
						                             </colgroup>                        
						                             <tr>
						                                 <th>最近一次婚外非商业性行为时是否使用安全套： </th>
						                                 <td>
						                                 	<ehr:dic-radio dicmeta="PH00001" code="1,2" name="exposureHistory.lastNoComMarBehCondom" value="${caseDto.exposureHistory.lastNoComMarBehCondom}"/>
					                     			 </td> 
						                             </tr>
						                              <tr>
						                                 <th>过去一个月婚外非商业性行为时是否使用安全套： </th>
						                                 <td>
						                                 	 <ehr:dic-radio dicmeta="IDM00508" name="exposureHistory.lastMonNoComMarBehCondom" value="${caseDto.exposureHistory.lastMonNoComMarBehCondom}"/>
					                     	
					                     				 </td>
						                             </tr>
						                         </table>
						                     </td>
						                  </tr>
			                         </table>
			                     </td>
			                  </tr>
                              <tr>
                                 <th>2.同性性行为： </th>
                                 <td>
                                 	 <ehr:dic-radio dicmeta="PH00002" code="1,2" name="exposureHistory.gaySexBehavior" value="${caseDto.exposureHistory.gaySexBehavior}"
                                 	   onchange="toggleOther('exposureHistory.gaySexBehavior','gaySexBehaviorDiv',1);"/>
                          		 </td>
                             </tr>
                             <tr style="display: none;" id="gaySexBehaviorDiv">
			                     <td colspan="4" style="padding: 0px;">
			                         <table>
			                             <colgroup>
			                                 <col style="width: 25%"/>
			                                 <col style="width: 75%"/>
			                             </colgroup>                        
			                             <tr>
			                                 <th>最近六个月内是否有肛交性行为： </th>
			                                 <td>
			                                 	 <ehr:dic-radio dicmeta="PH00001" code="1,2" name="exposureHistory.analSex" value="${caseDto.exposureHistory.analSex}"/>
				                     		</td> 
			                             </tr>
			                              <tr>
			                                 <th>最近六个月内肛交性行为时是否使用过安全套： </th>
			                                 <td>
			                                 	 <ehr:dic-radio dicmeta="IDM00508"  name="exposureHistory.sixMonthAnalSexCondom" value="${caseDto.exposureHistory.sixMonthAnalSexCondom}"/>
				                     		 </td>
			                             </tr>
			                             <tr>
			                                 <th>最近一次肛交性行为时是否使用过安全套： </th>
			                                 <td>
			                                 	 <ehr:dic-radio dicmeta="PH00001" code="1,2" name="exposureHistory.lastAnalSexCondom" value="${caseDto.exposureHistory.lastAnalSexCondom}"/>
                              				 </td>
			                             </tr>
			                         </table>
			                     </td>
			                  </tr>	
                         </table>
                     </td>
                 </tr>
		         <tr>
					<td colspan="4" style="text-align: left;">(三)受血/血制品史:</td>
				</tr>
	         	<tr>
	                <th>受血、血浆或血液制品史:</th>
	                <td colspan="3">
	                    <ehr:dic-radio dicmeta="PH00002" code="1,2" name="exposureHistory.receptionBloodHistory" value="${caseDto.exposureHistory.receptionBloodHistory}"
	                         onchange="toggleOther('exposureHistory.receptionBloodHistory','receptionBloodHistoryDiv',1);"/>
		        	</td>
		          </tr>
		          <tr style="display: none;" id="receptionBloodHistoryDiv">
                     <td colspan="4" style="padding: 0px;">
                         <table>
                             <colgroup>
                                 <col style="width: 25%"/>
                                 <col style="width: 75%"/>
                             </colgroup>                        
                             <tr>
                                 <th>受血类别： </th>
                                 <td>
                                 	 <ehr:dic-radio dicmeta="IDM00509" name="exposureHistory.bloodReceptionType" value="${caseDto.exposureHistory.bloodReceptionType}" />   	
		                     	</td> 
                             </tr>
                              <tr>
                                 <th>首次受血、血浆或血液制品时间： </th>
                                 <td>
                                 	 <%-- <tag:dateInput id="firstBloodReceDateId" name="exposureHistory.firstBloodReceDate" date="${caseDto.exposureHistory.firstBloodReceDate}" onlypast="true"
		                               pattern="yyyy/MM/dd" style="width:100px;"/>  --%>
		                               
		                              <input type="text" class="layui-input x-admin-content-sm-date" id="firstBloodReceDateId" name="exposureHistory.firstBloodReceDate" style="width: 100px;padding-left: 0px;" value="<fmt:formatDate value='${caseDto.exposureHistory.firstBloodReceDate}' pattern='yyyy/MM/dd'/>" />  
		                         </td>
                             </tr>
                             <tr>
                                 <th>首次受血、血浆或血液制品地点： </th>
                                 <td>
                                 	<%-- <input type="text" name="exposureHistory.firstBloodReceAddress"  value="${caseDto.exposureHistory.firstBloodReceAddress}"
                                             reg='{"maxlength":"20"}' /> --%>
                                    <input type="text" class="layui-input x-admin-content-sm-date" id="exposureHistoryFirstBloodReceAddress" name="exposureHistory.firstBloodReceAddress" style="width: 100px;padding-left: 0px;" value="<fmt:formatDate value='${caseDto.exposureHistory.firstBloodReceAddress}' pattern='yyyy/MM/dd'/>" />
                                 </td>
                             </tr>
                             <tr>
                                 <th>末次受血、血浆或血液制品时间： </th>
                                 <td>
                                 	 <%-- <tag:dateInput id="lastBloodReceDateId" name="exposureHistory.lastBloodReceDate" date="${caseDto.exposureHistory.lastBloodReceDate}" onlypast="true"
		                               pattern="yyyy/MM/dd" style="width:100px;"/>  --%>  
		                             <input type="text" class="layui-input x-admin-content-sm-date" id="lastBloodReceDateId" name="exposureHistory.lastBloodReceDate" style="width: 100px;padding-left: 0px;" value="<fmt:formatDate value='${caseDto.exposureHistory.lastBloodReceDate}' pattern='yyyy/MM/dd'/>" />
		                         </td>
                             </tr>
                             <tr>
                                 <th>末次受血、血浆或血液制品地点： </th>
                                 <td>
                                 	<input type="text" name="exposureHistory.lastBloodReceAddress"  value="${caseDto.exposureHistory.lastBloodReceAddress}"
                                             reg='{"maxlength":"20"}'/>
                                 </td>
                             </tr>
                         </table>
                     </td>
                 </tr>	
		         <tr>
					<td colspan="4" style="text-align: left;">(四)供血(浆)史:</td>
				</tr>
	         	<tr>
	                <th>供全血或血浆史:</th>
	                <td colspan="3">
	                    <ehr:dic-radio dicmeta="PH00002" code="1,2" name="exposureHistory.donateBloodHistory" value="${caseDto.exposureHistory.donateBloodHistory}"
	                         onchange="toggleOther('exposureHistory.donateBloodHistory','donateBloodHistoryDiv',1);"/>
		        	</td>
		         </tr>
		          <tr style="display: none;" id="donateBloodHistoryDiv">
                     <td colspan="4" style="padding: 0px;">
                         <table>
                             <colgroup>
                                 <col style="width: 25%"/>
                                 <col style="width: 75%"/>
                             </colgroup>                        
                             <tr>
                                 <th>首次供全血时间： </th>
                                 <td>
                                 	 <%-- <tag:dateInput id="confirmationDateId" name="exposureHistory.firstBloodSupplyDate" date="${caseDto.exposureHistory.firstBloodSupplyDate}" onlypast="true"
		                               pattern="yyyy/MM/dd" style="width:100px;"/> --%> 
		                               
		                               <input type="text" class="layui-input x-admin-content-sm-date" id="exposureHistoryFirstBloodSupplyDateId" name="exposureHistory.firstBloodSupplyDate" style="width: 100px;padding-left: 0px;" value="<fmt:formatDate value='${caseDto.exposureHistory.firstBloodSupplyDate}' pattern='yyyy/MM/dd'/>" />
		                         </td> 
                             </tr>                                                                             
                              <tr>
                                 <th>地点： </th>
                                 <td>
                                 	 <input type="text" name="exposureHistory.firstBloodSupplyAddress"  value="${caseDto.exposureHistory.firstBloodSupplyAddress}"
                                             reg='{"maxlength":"50"}' /> 
		                         </td>
                             </tr>
                             <tr>
                                 <th>采血单位： </th>
                                 <td>
                                 	<input type="text" name="exposureHistory.firstBloodSupplyUnit"  value="${caseDto.exposureHistory.firstBloodSupplyUnit}"
                                             reg='{"maxlength":"50"}'/>
                                 </td>
                             </tr>
                             <tr>
                                 <th>末次供全血时间： </th>
                                 <td>
                                 	 <%-- <tag:dateInput id="lastBloodSupplyDateId" name="exposureHistory.lastBloodSupplyDate" date="${caseDto.exposureHistory.lastBloodSupplyDate}" onlypast="true"
		                               pattern="yyyy/MM/dd"  style="width:100px;"/> --%>
		                           <input type="text" class="layui-input x-admin-content-sm-date" id="lastBloodSupplyDateId" name="exposureHistory.lastBloodSupplyDate" style="width: 100px;padding-left: 0px;" value="<fmt:formatDate value='${caseDto.exposureHistory.lastBloodSupplyDate}' pattern='yyyy/MM/dd'/>" />
		                         </td> 
                             </tr>                                                                             
                              <tr>
                                 <th>地点： </th>
                                 <td>
                                 	 <input type="text" name="exposureHistory.lastBloodSupplyAddress"  value="${caseDto.exposureHistory.lastBloodSupplyAddress}"
                                             reg='{"maxlength":"50"}' />
		                         </td>
                             </tr>
                             <tr>
                                 <th>采血单位： </th>
                                 <td>
                                 	<input type="text" name="exposureHistory.lastBloodSupplyUnit"  value="${caseDto.exposureHistory.lastBloodSupplyUnit}"
                                             reg='{"maxlength":"50"}' />
                                 </td>
                             </tr>                             
                              <tr>
                                 <th>首次供血浆时间： </th>
                                 <td>
                                 	 <%-- <tag:dateInput name="exposureHistory.firstPlasmaSupplyDate" date="${caseDto.exposureHistory.firstPlasmaSupplyDate}" onlypast="true"
		                               pattern="yyyy/MM/dd" style="width:100px;"/>  --%>
		                               
		                             <input type="text" class="layui-input x-admin-content-sm-date" id="exposureHistoryFirstPlasmaSupplyDateId" name="exposureHistory.firstPlasmaSupplyDate" style="width: 100px;padding-left: 0px;" value="<fmt:formatDate value='${caseDto.exposureHistory.firstPlasmaSupplyDate}' pattern='yyyy/MM/dd'/>" />
		                         </td> 
                             </tr>                                                                             
                              <tr>
                                 <th>地点： </th>
                                 <td>
                                 	 <input type="text" name="exposureHistory.firstPlasmaSupplyAddress"  value="${caseDto.exposureHistory.firstPlasmaSupplyAddress}"
                                             reg='{"maxlength":"50"}'/>
		                         </td>
                             </tr>
                             <tr>
                                 <th>采血单位： </th>
                                 <td>
                                 	<input type="text" name="exposureHistory.firstPlasmaSupplyUnit"  value="${caseDto.exposureHistory.firstPlasmaSupplyUnit}"
                                             reg='{"maxlength":"50"}' />
                                 </td>
                             </tr>
                              <tr>
                                 <th>末次供血浆时间： </th>
                                 <td>
                                 	 <%-- <tag:dateInput id="confirmationDateId" name="exposureHistory.lastPlasmaSupplyDate" date="${caseDto.exposureHistory.lastPlasmaSupplyDate}" onlypast="true"
		                               pattern="yyyy/MM/dd" reg='{"compare":["firstVisitDateId","ge","诊断日期不能早于初诊日期"]}' style="width:100px;"/> --%>
		                              <input type="text"  class="layui-input x-admin-content-sm-date" id="exposureHistoryLastPlasmaSupplyDateId" name="exposureHistory.lastPlasmaSupplyDate" style="width: 100px;padding-left: 0px;" value="<fmt:formatDate value='${caseDto.exposureHistory.lastPlasmaSupplyDate}' pattern='yyyy/MM/dd'/>" />
		                         </td> 
                             </tr>                                                                             
                              <tr>
                                 <th>地点： </th>
                                 <td>
                                 	 <input type="text" name="exposureHistory.lastPlasmaSupplyAddress"  value="${caseDto.exposureHistory.lastPlasmaSupplyAddress}"
                                             reg='{"maxlength":"50"}' />
		                         </td>
                             </tr>
                             <tr>
                                 <th>采血单位： </th>
                                 <td>
                                 	<input type="text" name="exposureHistory.lastPlasmaSupplyUnit"  value="${caseDto.exposureHistory.lastPlasmaSupplyUnit}"
                                             reg='{"maxlength":"50"}'/>
                                 </td>
                             </tr>                    
                         </table>
                     </td>
                 </tr>	
		         <tr>
					<td colspan="4" style="text-align: left;">(五)生育史:</td>
				</tr>
		         <tr>
	                <th>目前有无子女:</th>
	                <td colspan="3">
	                    <ehr:dic-checkbox dicmeta="IDM00510" name="exposureHistory.havingChildren" value="${caseDto.exposureHistory.havingChildren}"
                              onchange="hivCase.toggleOnes('exposureHistory.havingChildren','havingChildrenDiv','1,3');" />(可多选)
		        	</td>
		         </tr>
		         <tr style="display: none;" id="havingChildrenDiv">
	                <th>是否子女HIV阳性:</th>
	                <td colspan="3">
	                   <ehr:dic-radio dicmeta="IDM00502" code="1,2,3" name="exposureHistory.childrenHivPositive" value="${caseDto.exposureHistory.childrenHivPositive}"/>  
		        	</td>
		         </tr>
		        <tr>
					<td colspan="4" style="text-align: left;">(六)手术史:</td>
				</tr>
		          <tr>
		          	  <th></th>
		              <td colspan="3">
				           <ehr:dic-radio dicmeta="PH00002" code="1,2" name="exposureHistory.operation" value="${caseDto.exposureHistory.operation}"
			                        />
			          </td>
		          </tr>
		         <tr>
					<td colspan="4" style="text-align: left;">(七)职业暴露:</td>
				</tr>
		        <tr>
		        	<th></th>
		         	<td colspan="3">
				           <ehr:dic-radio dicmeta="PH00002" code="1,2" name="exposureHistory.immunizationHistory" value="${caseDto.exposureHistory.immunizationHistory}"
			                     onchange="toggleOther('exposureHistory.immunizationHistory','immunizationHistoryDiv',1);"   />
			         </td>
				 </tr>
				 <tr style="display: none;" id="immunizationHistoryDiv">
                     <td colspan="4" style="padding: 0px;">
                         <table>
                             <colgroup>
                                 <col style="width: 25%"/>
                                 <col style="width: 75%"/>
                             </colgroup>                        
                             <tr>
                                 <th>暴露发生于： </th>
                                 <td>
                                 	 <ehr:dic-radio dicmeta="IDM00511" name="exposureHistory.exposureWay" value="${caseDto.exposureHistory.exposureWay}"
                                 	 	 onchange="toggleOther('exposureHistory.exposureWay','exposureWayDiv',5);"/>
	                     			 <span id="exposureWayDiv" style="display: none">
			                            <input type="text" name="exposureHistory.exposureWayOther" value="${caseDto.exposureHistory.exposureWayOther}"
			                                   style="width: 150px;" reg='{"maxlength":"20"}'/>
			                         </span>
	                     		</td> 
                             </tr>
                              <tr>
                                 <th>暴露级别： </th>
                                 <td>
                                 	<ehr:dic-radio dicmeta="CV0510013" code="2,3,4" name="exposureHistory.exposureLevel" value="${caseDto.exposureHistory.exposureLevel}"/>
		                    	 </td>
                             </tr>
                             <tr>
                                 <th>是否加抗病毒药物紧急阻断： </th>
                                 <td>
                                 	 <ehr:dic-radio dicmeta="PH00002" code="1,2"  name="exposureHistory.conservatoryMeasure" value="${caseDto.exposureHistory.conservatoryMeasure}"/>
		                         </td>
                             </tr>
                         </table>
                     </td>
                 </tr>	
				 <tr>
					<td colspan="4" style="text-align: left;">(八)患儿填写项:</td>
				 </tr>	
		         <tr>
	                <th>患儿是否接受母婴阻断药物治疗:</th>
	                <td colspan="3">
	                    <ehr:dic-radio dicmeta="PH00001" code="1,2" name="exposureHistory.blockDrugTherapy" value="${caseDto.exposureHistory.blockDrugTherapy}"/>  
		        	</td>
		         </tr>
		         <tr>
	                <th>母亲HIV抗体:</th>
	                <td colspan="3">
	                    <ehr:dic-radio dicmeta="IDM00502" code="1,2,3" name="exposureHistory.motherHivAntibody" value="${caseDto.exposureHistory.motherHivAntibody}"/>
		        	</td>
		         </tr>
		         <tr>
	                <th>母亲是否接受过抗病毒药物治疗:</th>
	                <td colspan="3">
	                    <ehr:dic-radio dicmeta="PH00001" code="1,2" name="exposureHistory.motherAntiviralTherapy" value="${caseDto.exposureHistory.motherAntiviralTherapy}"/>  
		        	</td>
		         </tr>
		         <tr>
	                <th>喂养方式:</th>
	                <td colspan="3">
	                    <ehr:dic-radio dicmeta="FS10026"  name="exposureHistory.feedingWay" value="${caseDto.exposureHistory.feedingWay}"/>
		                    
		        	</td>
		         </tr>    
			</table>
		</fieldset>
		<fieldset>
			<legend>五、目前临床表现(可多选):</legend>
			<table class="posttable">					
					<tr>
						
						<td> <ehr:dic-checkbox dicmeta="IDM00513" name="attackCondition.clinicalManifestation"  value="${caseDto.attackCondition.clinicalManifestation}"
											   code="1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18"
                                               onchange="toggleOtherCK('attackCondition.clinicalManifestation','clinicalOtherDiv',18)" />
		        	 			<span id="clinicalOtherDiv" style="display: none">
			                            <input type="text" name="attackCondition.clinicalOther" value="${caseDto.attackCondition.clinicalOther}"
			                                   style="width: 150px;" reg='{"maxlength":"20"}'/>
			                        </span>
						</td>
					</tr>
				</table>
			</fieldset>
			<fieldset>
				<legend><label class="required">六、最可能的感染途径*:</label></legend>
				<table class="posttable">
					<colgroup>
                        <col style="width: 28%" />
                        <col style="width: 72%" />
					</colgroup>
					<tr>
						
						<td style="width: 15%; text-align: left;" colspan="2">
							 <ehr:dic-radio reg='{"required":"true"}' name="attackCondition.infectionRoute" dicmeta="IDM00339" code="1,2,3,4,5,6,7,9,99" value="${caseDto.attackCondition.infectionRoute}"
                                    onchange="toggleOther('attackCondition.infectionRoute','infectionRouteOtherDiv',99);"/>
                        		<span id="infectionRouteOtherDiv" style="display: none">
		                            <input type="text" name="attackCondition.infectionRouteOther" value="${caseDto.attackCondition.infectionRouteOther}"
		                                   style="width: 150px;" reg='{"maxlength":"20"}'/>
		                        </span>
                        </td>
					</tr>
				</table>
			</fieldset>
			<fieldset>
				<legend><label class="required">七、人群类别*</label></legend>
				<table class="posttable">
					<colgroup>
                        <col style="width: 28%" />
                        <col style="width: 72%" />
					</colgroup>
					<tr>
						
						<td style="width: 15%; text-align: left;" colspan="2">
							 <ehr:dic-list reg='{"required":"true"}' name="attackCondition.crowdCategory" dicmeta="IDM00514"  value="${caseDto.attackCondition.crowdCategory}"
                                    onchange="toggleOtherSC('attackCondition.crowdCategory','crowdCategoryOtherDiv',28);"/>
                        		<span id="crowdCategoryOtherDiv" style="display: none">
		                            <input type="text" name="attackCondition.crowdCategoryOther" value="${caseDto.attackCondition.crowdCategoryOther}"
		                                   style="width: 150px;" reg='{"maxlength":"50"}'/>
		                        </span>
                        </td>
					</tr>
				</table>
			</fieldset>
			<fieldset>
				<legend><label class="required">八、样本来源:</label></legend>			
				<table class="posttable">
					<colgroup>
                        <col style="width: 28%" />
                        <col style="width: 72%" />
					</colgroup>
					<tr>
						<td style="width: 15%; text-align: left;" colspan="2">
							 <ehr:dic-list name="attackCondition.sampleSource" dicmeta="IDM00340" value="${caseDto.attackCondition.sampleSource}" reg='{"required":"true"}'
                                    onchange="toggleOtherSC('attackCondition.sampleSource','sampleSourceOtherDiv',99);"/>
                                <span id="sampleSourceOtherDiv" style="display: none">
		                           <input type="text" name="attackCondition.sampleSourceOther" value="${caseDto.attackCondition.sampleSourceOther}"
		                                   style="width: 150px;" reg='{"maxlength":"50"}'/>
		                        </span>                        		
                        </td>
					</tr>
				</table>
			</fieldset>	
			<fieldset>
				<legend></legend>
				<table class="posttable">
					<colgroup>
	                       <col style="width: 20%" />
	                       <col style="width: 30%" />
	                       <col style="width: 20%" />
	                       <col style="width: 30%" />
					</colgroup>					
					<tr>
		                <th>调查地点:</th>
		                <td colspan="3">
							<ehr:dic-town-street-village villageId="revillage_address" streetId="restreet_address" townId="retown_address" 
														 villageName="generalCondition.reGroup"	streetName="generalCondition.restreet" townName="generalCondition.retownShip"
														 villageValue="${caseDto.generalCondition.reGroup}" streetValue="${caseDto.generalCondition.restreet}" townValue="${caseDto.generalCondition.retownShip}" width="140px;"
														 />
							<input type="text" id="rehouseNumber" name="generalCondition.rehouseNumber" value="${caseDto.generalCondition.rehouseNumber}"
	                               reg='{"maxlength":"50"}'  style="width: 180px;">
	                        <span id="spanReNumber">(门牌号)</span>
			         </tr>
			         <tr>
			         	<th><label class="required">调查日期：</label></th>
						<td><%-- <tag:dateInput reg='{"required":"true"}' name="caseInformation.surveyDate"
								pattern="yyyy/MM/dd" nullToToday="true" onlypast="true" date="${caseDto.caseInformation.surveyDate}"/> --%>
								<input type="text" reg='{"required":"true"}' class="layui-input x-admin-content-sm-date" id="caseInformationSurveyDateId" name="caseInformation.surveyDate" style="padding-left: 0px;" value="<fmt:formatDate value='${caseDto.caseInformation.surveyDate}' pattern='yyyy/MM/dd'/>" />
								</td>
						<th>调查单位：</th>
						<td>
                            <ehr:org  code="${caseDto.caseInformation.modifySurveyOrg}"></ehr:org>
                        </td>
					</tr>
					<tr>
		                <th>调查人：</th>
						<td  colspan="3">
                            <ehr:user userCode="${caseDto.caseInformation.respondents}"/>
                        </td>
			         </tr>
			          <tr>
			         	<th>填表日期：</th>
						<td><%-- <tag:dateInput name="caseInformation.caseFillDate"
								pattern="yyyy/MM/dd" nullToToday="true" onlypast="true" date="${caseDto.caseInformation.caseFillDate}"/> --%>
						<input type="text"  class="layui-input x-admin-content-sm-date" id="caseInformationCaseFillDateId" name="caseInformation.caseFillDate" style="padding-left: 0px;" value="<fmt:formatDate value='${caseDto.caseInformation.caseFillDate}' pattern='yyyy/MM/dd'/>" />
								</td>
						<th>填表单位：</th>
						<td>
                            <ehr:org code="${caseDto.caseInformation.caseFillOrg}"/>
                        </td>
					</tr>
					<tr>
		                <th>填表人：</th>
						<td  colspan="3">
                            <ehr:user userCode="${caseDto.caseInformation.caseFillPerson}"/>
                        </td>
			         </tr>
			          <tr style="display:none;">
		                 <td>
		                 	<input type="hidden" name="caseInformation.caseFillPerson" value="${caseDto.caseInformation.caseFillPerson}"/>
		                 	<input type="hidden" name="caseInformation.caseFillOrg" value="${caseDto.caseInformation.caseFillOrg}"/>
		                 	<input type="hidden" name="caseInformation.modifySurveyOrg" value="${caseDto.caseInformation.modifySurveyOrg}"/>
		                 	<input type="hidden" name="caseInformation.modifyRespondents" value="${caseDto.caseInformation.modifyRespondents}"/>
		                 	<input type="hidden" name="caseInformation.auditor" value="${caseDto.caseInformation.auditor}"/>
		                 </td> 
		             </tr>
				</table>
			</fieldset>



			<fieldset>
				<legend>备注</legend>
				 <table class="posttable">
			        <tr>
			            <td>
			                <textarea name="otherCondition.surveySummary" style="width: 100%; height: 150px;" reg='{"maxlength":"200"}'>${caseDto.otherCondition.surveySummary}</textarea>
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
            elem: '#generalConditionBirthday'
            	,format:'yyyy/MM/dd'
         	   ,max:0
         	  , trigger: 'click'
          });
        
        
        laydate.render({
            elem: '#pathogenesisDateId'
            	,format:'yyyy/MM/dd'
         	   ,max:0
         	  , trigger: 'click'
          });
        
        laydate.render({
            elem: '#confirmationDateId'
            	,format:'yyyy/MM/dd'
         	   ,max:0
         	  , trigger: 'click'
          });
        
        laydate.render({
            elem: '#attackConditionDieDtId'
            	,format:'yyyy/MM/dd'
         	  , max:0
         	 , trigger: 'click'
          });
        
        laydate.render({
            elem: '#wbExamineDate'
            	,format:'yyyy/MM/dd'
         	  , max:0
         	 , trigger: 'click'
          });
        
        laydate.render({
            elem: '#diagnosisHivConfirmationDateId'
            	,format:'yyyy/MM/dd'
         	  , max:0
         	 , trigger: 'click'
          });
        
        laydate.render({
            elem: '#exposureHistoryFirstTakeDrugDateId'
            	,format:'yyyy/MM/dd'
         	  , max:0
         	 , trigger: 'click'
          });
        
        laydate.render({
            elem: '#firstDrugInjectionDateId'
            	,format:'yyyy/MM/dd'
         	  , max:0
          });
        
        laydate.render({
            elem: '#firstBloodReceDateId'
            	,format:'yyyy/MM/dd'
         	  , max:0
         	 , trigger: 'click'
          });
        
        laydate.render({
            elem: '#lastBloodReceDateId'
            	,format:'yyyy/MM/dd'
         	  , max:0
         	 , trigger: 'click'
          });
        
        laydate.render({
            elem: '#exposureHistoryFirstBloodSupplyDateId'
            	,format:'yyyy/MM/dd'
         	  , max:0
         	 , trigger: 'click'
          });
        
        laydate.render({
            elem: '#lastBloodSupplyDateId'
            	,format:'yyyy/MM/dd'
         	  , max:0
         	 , trigger: 'click'
          });
        
        laydate.render({
            elem: '#exposureHistoryFirstPlasmaSupplyDateId'
            	,format:'yyyy/MM/dd'
         	  , max:0
         	 , trigger: 'click'
          });
        
        laydate.render({
            elem: '#exposureHistoryLastPlasmaSupplyDateId'
            	,format:'yyyy/MM/dd'
         	  , max:0
         	 , trigger: 'click'
          });
        
        laydate.render({
            elem: '#caseInformationSurveyDateId'
            	,format:'yyyy/MM/dd'
         	  , max:0
         	 , trigger: 'click'
          });
        
        laydate.render({
            elem: '#caseInformationCaseFillDateId'
            	,format:'yyyy/MM/dd'
         	  , max:0
         	 , trigger: 'click'
          });
        
        
        
      });

    </script>