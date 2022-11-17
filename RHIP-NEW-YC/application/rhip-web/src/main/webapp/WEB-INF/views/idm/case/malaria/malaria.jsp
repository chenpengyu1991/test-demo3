<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib  tagdir="/WEB-INF/tags" prefix="tag"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<script src="${pageContext.request.contextPath}/js/views/idm/case/edit.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/views/idm/case/malaria.js" type="text/javascript"></script>
<script	src="${pageContext.request.contextPath}/js/views/idm/idmCommon.js"	type="text/javascript"></script>

<c:if test="${isPrint != 1}">
    <jsp:include page="../caseButton.jsp"></jsp:include>
</c:if>
<form id="caseForm">
<div class="postcontent <c:if test="${isPrint != 1}">contentfixed</c:if>">
<i class="popno">
    疟疾个案调查表<br />
    <span>（乙类传染病）</span>
</i>
	<table class="posttable">
		<tr style="text-align: right;">
			<td>
				顺序编号：
				<input type="text" name="generalCondition.gbcode" style="width: 120px;"
					   value="${caseDto.generalCondition.gbcode}" reg='{"maxlength":"14"}' />
			</td>
			<td>
				卡片编号：
				<input type="text" name="caseInformation.mediRecordNum" style="width: 120px;"
					   value="${caseDto.caseInformation.mediRecordNum}"  reg='{"maxlength":"14"}'/>
			</td>
		</tr>
	</table>
<input type="hidden" name="idmId" value="${idmId}" id="idmId"/>
<input type="hidden" name="efcList" id="efcList"></td>
<div class="postdiv">
<fieldset>
<legend>一、一般情况</legend>
<table class="posttable">
<colgroup>
    <col style="width: 20%" />
    <col style="width: 30%" />
    <col style="width: 20%" />
    <col style="width: 30%" />
</colgroup>
	<tr>
		<th>1、户籍所在地：</th>
		<td>
			<input type="text" name="generalCondition.hrAddress" value="${caseDto.generalCondition.hrAddress}"
				   reg='{"maxlength":"100"}' />
	</tr>
	<tr>
		<th>2、现住址（详填）：</th>
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
		<th>3、户主姓名：</th>
		<td><input type="text" name="generalCondition.headHouseholdName" value="${caseDto.generalCondition.headHouseholdName}" reg='{"maxlength":"70"}' style="width: 150px;"/></td>
	</tr>
	<tr>
		<th>4、患者姓名：</th>
		<td colspan="3"><input type="text" name="generalCondition.name" value="${caseDto.generalCondition.name}"
                                        reg='{"maxlength":"100"}' style="width: 150px;"/>

	</tr>
	<tr>
		<th>5、联系电话：</th>
		<td><input type="text" name="generalCondition.phoneNumber" value="${caseDto.generalCondition.phoneNumber}" reg='{"regex":"phone"}' style="width: 150px;"/></td>

	</tr>
                <tr>
                    <th>6、性别：</th>
                    <td><ehr:dic-radio dicmeta="GBT226112003" name="generalCondition.gender" code="1,2" value="${caseDto.generalCondition.gender}"/></td>
                </tr>
				<tr>
					<th>7、出生日期：</th>
					<td colspan="3"><tag:dateInput name="generalCondition.birthday" date="${caseDto.generalCondition.birthday}" pattern="yyyy/MM/dd" style="width:90px;"/>
                        （如出生日期不详，实足年龄
						<input type="text" id="age" name="generalCondition.age" style="width: 60px;" value="${caseDto.generalCondition.age}" reg='{"maxlength":"6"}'/>
						年龄单位：<ehr:dic-radio name="generalCondition.ageUnit" dicmeta="IDM00003" value="${caseDto.generalCondition.ageUnit}"/> )
                    </td>
				</tr>
                <tr>
                    <th>8、职业：</th>
                    <td colspan="3">
                        <ehr:dic-list id="occupationId" dicmeta="GBT6565" name="generalCondition.occupation" width="180px;" value="${caseDto.generalCondition.occupation}"
                                      code="CV020120233,CV020120203,CV020120235,CV020120213,CV020120234,CV020120217"
                                />
                        <span  id="occupationOtherPart" style="display: none">
                            <input type="text" name="generalCondition.occupationOther" value="${caseDto.generalCondition.occupationOther}"
                                   reg='{"maxlength":"30"}' placeholder="选择其他，请描叙" style="width: 200px;"/>
                        </span>
                    </td>
                </tr>
				<tr>
					<th>9、文化程度：</th>
					<td colspan="3"><ehr:dic-radio name="generalCondition.education" dicmeta="GBT46582006"
												   code="IDM09,IDM06,IDM07,IDM02,IDM03,IDM08,IDM10" value="${caseDto.generalCondition.education}"/>
					</td>
				</tr>
	<tr>
		<th>10、患者家中有无防蚊设施：</th>
		<td colspan="3"><ehr:dic-radio name="epidemiologicalSurvey.mosquitoFacilities" dicmeta="IDM00556"
									    value="${caseDto.epidemiologicalSurvey.mosquitoFacilities}"/>
		</td>

	</tr>
	<tr>
		<th>11、患者是否有使用蚊帐习惯：</th>
		<td colspan="3"><ehr:dic-radio name="epidemiologicalSurvey.usingMosquitiNets" dicmeta="IDM00411"
									   value="${caseDto.epidemiologicalSurvey.usingMosquitiNets}"/>
		</td>

	</tr>
	<tr>
		<th>12、患者是否有露宿习惯：</th>
		<td colspan="3"><ehr:dic-radio name="epidemiologicalSurvey.brivouac" dicmeta="IDM00411"
									   value="${caseDto.epidemiologicalSurvey.brivouac}"/>
		</td>

	</tr>
			</table>
		</fieldset>
<fieldset>
<legend>二、本次发病情况</legend>
<table class="posttable">
<colgroup>
    <col style="width: 20%" />
    <col style="width: 30%" />
    <col style="width: 20%" />
    <col style="width: 30%" />
</colgroup>
	<tr>
		<th>13、发病地点是否是国外：</th>
		<td colspan="3"><ehr:dic-radio name="attackCondition.isOverseas" dicmeta="IDM00411"
									   value="${caseDto.attackCondition.isOverseas}"
		onchange=" toggleOther('attackCondition.isOverseas','foreignAddr1',1);toggleOther('attackCondition.isOverseas','pathogenesisPlace1',2);"    />
		</td>
	</tr>
	<tr id="foreignAddr1">
		<th>如果选“是”，外国发病地点：</th>
		<td colspan="3"><input type="text" name="attackCondition.foreignAddr" style="width: 120px;"
							   value="${caseDto.attackCondition.foreignAddr}"  />
		</td>
	</tr>
	<tr id="pathogenesisPlace1">
		<th>如果选“否”，国内发病地点：</th>
		<td colspan="3">
			<input type="text" name="attackCondition.pathogenesisPlace" style="width: 120px;"
				   value="${caseDto.attackCondition.pathogenesisPlace}"  />
		</td>
	</tr>
	<tr>
		<th>14、发病日期：</th>
		<td>
			<tag:dateInput name="attackCondition.pathogenesisDate" style="width: 120px;" pattern="yyyy/MM/dd" date="${caseDto.attackCondition.pathogenesisDate}"/>
		</td>
	</tr>
	<tr>
		<th>15、初诊日期：</th>
		<td>
			<tag:dateInput name="attackCondition.firstVisitDate" style="width: 120px;" pattern="yyyy/MM/dd" date="${caseDto.attackCondition.firstVisitDate}"/>
		</td>
	</tr>
	<tr>
		<th>16、初诊单位：</th>
		<td colspan="3"><ehr:dic-radio name="attackCondition.firstVisitUnit" dicmeta="IDM00261"
									   value="${caseDto.attackCondition.firstVisitUnit}"/>
		</td>
	</tr>
	<tr>
		<th>17、主要临床表现：</th>
		<td colspan="3"><ehr:dic-radio name="attackCondition.clinicalManifestation" dicmeta="IDM00262"
									   value="${caseDto.attackCondition.clinicalManifestation}"/>
		</td>
	</tr>
	<tr>
		<th>18、本次发病诊断方式：</th>
		<td colspan="3"><ehr:dic-radio name="attackCondition.thisDiagnosisType" dicmeta="IDM00581"
									   value="${caseDto.attackCondition.thisDiagnosisType}"/>
		</td>
	</tr>
	<tr>
		<th>19、血检虐原虫日期：</th>
		<td>
			<tag:dateInput name="attackCondition.bloodTestDate" style="width: 120px;" pattern="yyyy/MM/dd" date="${caseDto.attackCondition.bloodTestDate}"/>
		</td>
	</tr>
	<tr>
		<th>20、镜检结果：</th>
		<td colspan="3"><ehr:dic-radio name="attackCondition.microscopicExamination" dicmeta="IDM00557"
									   value="${caseDto.attackCondition.microscopicExamination}"/>
		</td>
	</tr>
	<tr>
		<th>21、本次发病是：</th>
		<td colspan="3"><ehr:dic-radio name="attackCondition.isPrimary" dicmeta="IDM00264"
									   value="${caseDto.attackCondition.isPrimary}"/>
		</td>
	</tr>
	<tr>
		<th>22、病情程度：</th>
		<td colspan="3"><ehr:dic-radio name="attackCondition.illnesDegree" dicmeta="IDM00558"
									   value="${caseDto.attackCondition.illnesDegree}"/>
		</td>
	</tr>
	<tr>
		<th>23、并发症：</th>
		<td colspan="3"><ehr:dic-radio name="attackCondition.complication" dicmeta="IDM00411"
									   value="${caseDto.attackCondition.complication}"
		onchange="toggleOther('attackCondition.complication','complicationName1',1);"/>
			<span id="complicationName1">
				如果“是”，并发症名称：<input type="text" name="attackCondition.complicationName" style="width: 120px;"
					   value="${caseDto.attackCondition.complicationName}"  />
			</span>
		</td>
	</tr>

	<tr>
		<th>24、病例是否死亡：</th>
		<td colspan="3"><ehr:dic-radio name="attackCondition.isDeath" dicmeta="IDM00411"
									   value="${caseDto.attackCondition.isDeath}"/>
		</td>

	</tr>

			</table>
		</fieldset>
<fieldset>
    <legend>三、本次治疗情况</legend>
    <table class="posttable">
        <colgroup>
           <col style="width: 20%" />
		    <col style="width: 30%" />
		    <col style="width: 20%" />
		    <col style="width: 30%" />
        </colgroup>
		<tr>

		<th>25、抗疟药试治：</th>
		<td colspan="3"><ehr:dic-radio name="otherCondition.resistenceAgue" dicmeta="IDM00411"
									   value="${caseDto.otherCondition.resistenceAgue}"
									   onchange="toggleOther('otherCondition.resistenceAgue','agueIdea',1);"/>
		</td>
	    </tr>
		<tbody id="agueIdea">
		<tr >
			<th>治疗方法：</th>
			<td colspan="3"><input type="text" name="otherCondition.agueIdea" style="width: 120px;"
								   value="${caseDto.otherCondition.agueIdea}"  />
			</td>
		</tr>
		<tr>
			<th>26、治疗药物名称：</th>
			<td colspan="3"><input type="text" name="otherCondition.agueDrugs" style="width: 120px;"
								   value="${caseDto.otherCondition.agueDrugs}" />
			</td>
		</tr>
		</tbody>
		<tr>
			<th>27、全程是否足量（正规）治疗：</th>
			<td colspan="3"><ehr:dic-radio name="otherCondition.agueEnough" dicmeta="IDM00411"
										   value="${caseDto.otherCondition.agueEnough}"/>
			</td>
		</tr>
		<tr>
			<th>28、住院治疗：</th>
			<td colspan="3"><ehr:dic-radio name="otherCondition.inHospital" dicmeta="IDM00411"
										   value="${caseDto.otherCondition.inHospital}"/>
			</td>
		</tr>



        </table>
    </fieldset>

<fieldset>
    <legend>四、既往病史情况</legend>
    <table class="posttable">
        <colgroup>
            <col style="width: 20%" />
		    <col style="width: 30%" />
		    <col style="width: 20%" />
		    <col style="width: 30%" />
        </colgroup>
		<tr>
			<th>29、曾患疟疾次数：</th>
			<td colspan="3"><input type="text" name="pastHistory.agueNum" style="width: 120px;"
								   value="${caseDto.pastHistory.agueNum}" />（如果为0请直接调至第31项）
			</td>
		</tr>
		<tr >
			<th>30、最近一次患疟疾时间：</th>
			<td colspan="3"><tag:dateInput name="pastHistory.recentAgueTime" style="width: 120px" pattern="yyyy/MM/dd" date="${caseDto.pastHistory.recentAgueTime}"/>
			</td>
		</tr>
		<tr >
			<th>发病地点是否国外：</th>
			<td colspan="3"><ehr:dic-radio name="pastHistory.isOut" dicmeta="IDM00411"
										   value="${caseDto.pastHistory.isOut}"
										   onchange="toggleOther('pastHistory.isOut','inAguePlace',2);
										   toggleOther('pastHistory.isOut','outAguePlace',1);"/>
			</td>
		</tr>
		<tr id="outAguePlace">
			<th>如果选“是”，外国发病地点：</th>
			<td colspan="3"><input type="text" name="pastHistory.outAguePlace" style="width: 120px;"
								   value="${caseDto.pastHistory.outAguePlace}"  />
			</td>
		</tr>
		<tr id="inAguePlace">
			<th>如果选“否”，国内发病地点：</th>
			<td colspan="3">
				<input type="text" name="pastHistory.inAguePlace" style="width: 120px;"
					   value="${caseDto.pastHistory.inAguePlace}"/>
			</td>
		</tr>
		<tr >
			<th>当时抗疟疾药品：</th>
			<td colspan="3"><ehr:dic-radio name="pastHistory.agueDrugs" dicmeta="IDM00559"
										   value="${caseDto.pastHistory.agueDrugs}"/>
			</td>
		</tr>
		<tr >
			<th>治疗时间：</th>
			<td colspan="3"><tag:dateInput name="pastHistory.agueTime" pattern="yyyy/MM/dd" style="width: 120px;" date="${caseDto.pastHistory.agueTime}"/>
			</td>
		</tr>
		<tr >
			<th>治疗地点：</th>
			<td colspan="3">
				<input type="text" name="pastHistory.aguePlace" style="width: 120px;"
					   value="${caseDto.pastHistory.aguePlace}"  />
			</td>
		</tr>
		<tr >
			<th>全程是否足量（正规）治疗：</th>
			<td colspan="3"><ehr:dic-radio name="pastHistory.agueEnough" dicmeta="IDM00411"
										   value="${caseDto.pastHistory.agueEnough}"/>
			</td>
		</tr>
		<tr >
			<th>是否进行清理治疗：</th>
			<td colspan="3"><ehr:dic-radio name="pastHistory.agueClean" dicmeta="IDM00411"
										   value="${caseDto.pastHistory.agueClean}"/>
			</td>
		</tr>
		<tr >
		<th>是否进行休根治疗：</th>
		<td colspan="3"><ehr:dic-radio name="pastHistory.agueRoot" dicmeta="IDM00411"
									   value="${caseDto.pastHistory.agueRoot}"/>
		</td>
	</tr>


			</table>
		</fieldset>
<fieldset>
    <legend>五、传染源及传播途径调查</legend>
    <table class="posttable">
        <colgroup>
             <col style="width: 20%" />
			    <col style="width: 30%" />
			    <col style="width: 20%" />
			    <col style="width: 30%" />
        </colgroup>
		<tr>
			<th>31、发病前10-30天是否外出：</th>
		<td colspan="3"><ehr:dic-radio name="infectionSourceRoute.outHistory" dicmeta="IDM00411"
									   value="${caseDto.infectionSourceRoute.outHistory}"
			onchange="toggleOther('infectionSourceRoute.outHistory','outHistory',1);"/>（如果选择否请直接跳转到第32项）
		</td>
		</tr>
		<tbody id="outHistory">
		<tr>
			<th >外出地点：</th>
			<td colspan="3" ><input type="text" name="infectionSourceRoute.outAddr" style="width: 120px;"
								   value="${caseDto.infectionSourceRoute.outAddr}"  />
			</td>
		</tr>
		<tr>
			<th >外出地是否是疟疾区：</th>
			<td colspan="3" ><ehr:dic-radio name="infectionSourceRoute.outInfectedArea" dicmeta="IDM00411"
										   value="${caseDto.infectionSourceRoute.outInfectedArea}"/>
			</td>
		</tr>
		<tr>
			<th >外出天数：</th>
			<td colspan="3" ><input type="text" name="infectionSourceRoute.outDays" style="width: 120px;"
								   value="${caseDto.infectionSourceRoute.outDays}" />
			</td>
		</tr>
		<tr>
		<th>住地是否有防蚊措施：</th>
		<td ><ehr:dic-radio name="infectionSourceRoute.outPreventFacility" dicmeta="IDM00411"
									   value="${caseDto.infectionSourceRoute.outPreventFacility}"/>
		</td>
		</tr>
		</tbody>
		<tr>
		<th>32、一个月内家中是否有亲友来访：</th>
		<td ><ehr:dic-radio name="infectionSourceRoute.strangerLive" dicmeta="IDM00411"
									   value="${caseDto.infectionSourceRoute.strangerLive}"
		 onchange="toggleOther('infectionSourceRoute.strangerLive','strangerLive1',1);"/>（如果选择否请直接跳转到第33项）
		</td>
		</tr>
		<tbody id="strangerLive1">
		<tr>
			<th>来访亲友地址：</th>
			<td ><input type="text" name="infectionSourceRoute.strangerFromProvince" style="width: 120px;"
								   value="${caseDto.infectionSourceRoute.strangerFromProvince}" />
			</td>
		</tr>

		<tr>
			<th>该地是否是疟疾区：</th>
			<td ><ehr:dic-radio name="infectionSourceRoute.strangerFromInfectedArea" dicmeta="IDM00411"
										   value="${caseDto.infectionSourceRoute.strangerFromInfectedArea}"/>
			</td>
		</tr>
		<tr>
			<th>来访亲友留宿天数：</th>
			<td ><input type="text" name="infectionSourceRoute.strangerFromDays" style="width: 120px;"
								   value="${caseDto.infectionSourceRoute.strangerFromDays}"  />
			</td>
		</tr>
		<tr>
		<th>来访者一个月内发热史：</th>
		<td ><ehr:dic-radio name="infectionSourceRoute.strangerFromFever" dicmeta="IDM00411"
									   value="${caseDto.infectionSourceRoute.strangerFromFever}"/>
		</td>
		</tr>
		<tr>
			<th>来访者是否血检疟原虫：</th>
			<td ><ehr:dic-radio name="infectionSourceRoute.strangerFromPlasmodium" dicmeta="IDM00560"
										   value="${caseDto.infectionSourceRoute.strangerFromPlasmodium}"/>
			</td>
		</tr>
		</tbody>
		<tr>
			<th>33、患者家庭成员有无发热病人：</th>
			<td ><ehr:dic-radio name="infectionSourceRoute.familyFever" dicmeta="IDM00411"
										   value="${caseDto.infectionSourceRoute.familyFever}"
								onchange="toggleOther('infectionSourceRoute.familyFever','feverPlasmodium',1);"/>
			</td>
		</tr>
		<tr id="feverPlasmodium">
			<th>发病人是否血检疟原虫：</th>
			<td colspan="3"><ehr:dic-radio name="infectionSourceRoute.feverPlasmodium" dicmeta="IDM00411"
										   value="${caseDto.infectionSourceRoute.feverPlasmodium}"/>
			</td>
		</tr>
		<tr>
			<th>34、患者发病前15日内是否有输血史：</th>
			<td ><ehr:dic-radio name="infectionSourceRoute.transFusionHistory" dicmeta="IDM00411"
										   value="${caseDto.infectionSourceRoute.transFusionHistory}"/>
			</td>
		</tr>
		<tr>
			<th>35、本次发病的感染分类：</th>
			<td colspan="3"><ehr:dic-radio name="infectionSourceRoute.thisType" dicmeta="IDM00267"
										   value="${caseDto.infectionSourceRoute.thisType}"/>
			</td>
		</tr>


			</table>
		</fieldset>

<fieldset>
                    <table class="posttable">
                        <colgroup>
						 	<col style="width: 20%" />
						    <col style="width: 30%" />
						    <col style="width: 20%" />
						    <col style="width: 30%" />
                        </colgroup>
				<tr>
					<th>调查者单位：</th>
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
					<td>
                        <tag:dateInput name="caseInformation.modifySurveyDate" pattern="yyyy/MM/dd" style="width: 120px;" date="${caseDto.caseInformation.modifySurveyDate}"/>
					</td>
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
