<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib  tagdir="/WEB-INF/tags" prefix="tag"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<script src="${pageContext.request.contextPath}/js/views/idm/case/edit.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/views/idm/case/hav.js" type="text/javascript"></script>
<script	src="${pageContext.request.contextPath}/js/views/idm/idmCommon.js"	type="text/javascript"></script>

<c:if test="${isPrint != 1}">
    <jsp:include page="../caseButton.jsp"></jsp:include>
</c:if>
<form id="caseForm">
<div class="postcontent <c:if test="${isPrint != 1}">contentfixed</c:if>">
<i class="popno">
    甲型（戊型）肝炎个案调查表<br />
    <span>（乙类传染病）</span>
</i>
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
					<th>1、患者姓名：</th>
					<td colspan="3"><input type="text" name="generalCondition.name" value="${caseDto.generalCondition.name}"
                                           reg='{"maxlength":"100"}' style="width: 150px;"/>
                        （患儿家长姓名：<input type="text" name="generalCondition.parentsName" value="${caseDto.generalCondition.parentsName}"
                                       reg='{"maxlength":"50"}' style="width: 150px;"/>）</td>
				</tr>
				<tr>
					<th>2、身份证号：</th>
					<td><input type="text" id="idCard" name="generalCondition.idcard" value="${caseDto.generalCondition.idcard}" reg='{"idCard":"true"}'
                               placeholder="输入身份证获取个人信息"/></td>
				</tr>
                <tr>
                    <th>3、性别：</th>
                    <td><ehr:dic-radio dicmeta="GBT226112003" name="generalCondition.gender" code="1,2" value="${caseDto.generalCondition.gender}"/></td>
                </tr>
				<tr>
					<th>4、出生日期：</th>
					<td colspan="3"><tag:dateInput name="generalCondition.birthday" date="${caseDto.generalCondition.birthday}" pattern="yyyy/MM/dd" style="width:90px;"/>
                        （如出生日期不详，实足年龄
						<input type="text" id="age" name="generalCondition.age" style="width: 60px;" value="${caseDto.generalCondition.age}" reg='{"maxlength":"6"}'/>
						年龄单位：<ehr:dic-radio name="generalCondition.ageUnit" dicmeta="IDM00003" value="${caseDto.generalCondition.ageUnit}"/> )
                    </td>
				</tr>
				<tr>
					<th>5、工作单位：</th>
					<td><input type="text" name="generalCondition.unitName" value="${caseDto.generalCondition.unitName}" reg='{"maxlength":"70"}'/></td>
				</tr>
				<tr>
					<th>6、联系电话：</th>
					<td><input type="text" name="generalCondition.phoneNumber" value="${caseDto.generalCondition.phoneNumber}" reg='{"regex":"phone"}'/></td>

				</tr>
                <tr>
                    <th>7、现住址：</th>
                    <td colspan="3"><ehr:dic-radio name="generalCondition.addrType" dicmeta="CV0201104" value="${caseDto.generalCondition.addrType}"
                            /> </td>
                </tr>
				<tr>
					<th>8、现住址（详填）：</th>
                    <%--<td colspan="3">--%>
                        <%--<ehr:dic-town-village villageId="village_address" townId="town_address" villageName="generalCondition.pastreet" townName="generalCondition.patownShip"--%>
                                              <%--villageValue="${caseDto.generalCondition.pastreet}" townValue="${caseDto.generalCondition.patownShip}" width="180px;"/>--%>
                        <%--<input type="text" id="pahouseNumber" name="generalCondition.pahouseNumber" value="${caseDto.generalCondition.pahouseNumber}"--%>
                               <%--placeholder="门牌号" style="width: 180px;" reg='{"maxlength":"30"}'>--%>
                    <%--</td>--%>
                    <td colspan="3">
                        <ehr:dic-town-village villageId="pavillage_address" townId="patown_address" villageName="generalCondition.pastreet" townName="generalCondition.patownShip"
                                              villageValue="${caseDto.generalCondition.pastreet}" townValue="${caseDto.generalCondition.patownShip}" width="180px;"/>
                        <input type="text" id="pahouseNumber" name="generalCondition.pahouseNumber" value="${caseDto.generalCondition.pahouseNumber}"
                               reg='{"maxlength":"50"}'  style="width: 180px;">
                        <span id="spanPaNumber">(门牌号)</span>
                    </td>
				</tr>
				<tr>
					<th>9、户籍：</th>
					<td><ehr:dic-list name="generalCondition.hrprovince" dicmeta="GBT2260A1" value="${caseDto.generalCondition.hrprovince}" width="180px;"/></td>
				</tr>
                <tr>
                    <th>10、患者职业：</th>
                    <td colspan="3">
                        <ehr:dic-list id="occupationId" dicmeta="GBT6565" name="generalCondition.occupation" width="180px;" value="${caseDto.generalCondition.occupation}"
                                      code="CV020120201,CV020120202,CV020120203,CV020120204,CV020120205,CV020120206,CV020120207,CV020120208,CV020120209,CV020120210,CV020120211,CV020120212,CV020120213,CV020120214,CV020120215,CV020120216,CV020120299,CV020120217"
                                />
                        <span  id="occupationOtherPart" style="display: none">
                            <input type="text" name="generalCondition.occupationOther" value="${caseDto.generalCondition.occupationOther}"
                                   reg='{"maxlength":"30"}' placeholder="选择其他，请描叙" style="width: 200px;"/>
                        </span>
                    </td>
                </tr>
				<tr>
					<th>11、文化程度：</th>
					<td colspan="3"><ehr:dic-radio name="generalCondition.education" dicmeta="GBT46582006"
                                                       code="IDM09,IDM06,IDM07,IDM02,IDM03,IDM08,IDM10" value="${caseDto.generalCondition.education}"/>
                    </td>

				</tr>
                <tr>
                    <th>12、病例分类：</th>
                    <td colspan="3">
                        <ehr:dic-radio dicmeta="IDM00040" name="otherCondition.caseType" code="1,2,3,4" value="${caseDto.otherCondition.caseType}"/>
                    </td>
                </tr>
				<tr>
					<th>13、发病日期：</th>
					<td colspan="3">
                        <tag:dateInput id="pathogenesisDateId" name="attackCondition.pathogenesisDate" onlypast="true" date="${caseDto.attackCondition.pathogenesisDate}"
                               pattern="yyyy/MM/dd" reg='{"compare":["firstVisitDateId","le","发病日期不能晚于初诊日期"]}' style="width:120px;" />
                            （病原携带者填就诊时间）</td>
				</tr>
				<tr>
					<th>14、初诊日期：</th>
					<td>
                        <tag:dateInput id="firstVisitDateId" name="attackCondition.firstVisitDate"  date="${caseDto.attackCondition.firstVisitDate}"
                               onlypast="true" pattern="yyyy/MM/dd" reg='{"compare":["pathogenesisDateId","ge","初诊日期不能早于发病日期"]}'/>
                    </td>
					<th>初诊单位：</th>
					<td>
                        <input type="text" name="attackCondition.firstVisitUnit" value="${caseDto.attackCondition.firstVisitUnit}"
                               reg='{"maxlength":"100"}'/>
                    </td>
				</tr>
				<tr>
					<th>15、诊断日期：</th>
					<td><tag:dateInput id="confirmationDateId" name="attackCondition.confirmationDate" date="${caseDto.attackCondition.confirmationDate}" onlypast="true"
                               pattern="yyyy/MM/dd" reg='{"compare":["firstVisitDateId","ge","诊断日期不能早于初诊日期"]}'/></td>
					<th>诊断单位：</th>
					<td><input type="text" name="attackCondition.confirmationHospital" value="${caseDto.attackCondition.confirmationHospital}"
                               reg='{"maxlength":"100"}'/></td>
				</tr>
				<tr>
					<th>16、死亡日期：</th>
					<td><tag:dateInput name="attackCondition.dieDt" date="${caseDto.attackCondition.dieDt}" onlypast="true" pattern="yyyy/MM/dd"
                                       reg='{"compare":["confirmationDateId","ge","死亡日期不能早于诊断日期"]}'/></td>
				</tr>
                <tr>
                    <th>17、甲肝疫苗接种史：</th>
                    <td colspan="3"><ehr:dic-radio dicmeta="PH00002" name="epidemiologicalSurvey.aimmugen" code="1,2,4" value="${caseDto.epidemiologicalSurvey.aimmugen}"
                                                  />
                        &nbsp; &nbsp; &nbsp; &nbsp;
                        <span id="aimmugenDtPart">
                            如有，接种时间：第1针
                            <tag:dateInput id="aimmugenDtF" name="epidemiologicalSurvey.aimmugenDtF" date="${caseDto.epidemiologicalSurvey.aimmugenDtF}" onlypast="true"
                                           pattern="yyyy/MM" style="width:100px;" reg='{"compare":["aimmugenDtS","le","第一针时间不能大于第二针时间"]}'/>
                            第2针
                            <tag:dateInput id="aimmugenDtS" name="epidemiologicalSurvey.aimmugenDtS" date="${caseDto.epidemiologicalSurvey.aimmugenDtS}" onlypast="true"
                                           pattern="yyyy/MM" style="width:100px;" reg='{"compare":["aimmugenDtF","ge","第二针时间不能小于第一针时间"]}'/>
                        </span>
                    </td>
                </tr>
			</table>
		</fieldset>
<fieldset>
<legend>二、临床表现</legend>
<table class="posttable">
<colgroup>
    <col style="width: 15%" />
    <col style="width: 32%" />
    <col style="width: 15%" />
    <col style="width: 38%" />
</colgroup>
				<tr>
					<th>1  食欲减退：</th>
					<td><ehr:dic-radio dicmeta="PH00002" name="clinicalManifestations.poorAppetite" code="1,2,4"
                            value="${caseDto.clinicalManifestations.poorAppetite}"/></td>
					<th>2  恶心：</th>
					<td><ehr:dic-radio dicmeta="PH00002" name="clinicalManifestations.nausea" code="1,2,4"
                                       value="${caseDto.clinicalManifestations.nausea}"/></td>
				</tr>
				<tr>
					<th>3  厌油腹胀：</th>
					<td><ehr:dic-radio dicmeta="PH00002" name="clinicalManifestations.disgustOilBellyDistension" code="1,2,4"
                                       value="${caseDto.clinicalManifestations.disgustOilBellyDistension}"/></td>
					<th>4  溏便：</th>
					<td>
                        <ehr:dic-radio dicmeta="PH00002" name="clinicalManifestations.semiliquidStool" code="1,2,4"
                                       value="${caseDto.clinicalManifestations.semiliquidStool}"/></td>
				</tr>
				<tr>
					<th>5  乏力：</th>
					<td><ehr:dic-radio dicmeta="PH00002" name="clinicalManifestations.feeble" code="1,2,4"
                                       value="${caseDto.clinicalManifestations.feeble}"/></td>
					<th>6  茶尿：</th>
					<td><ehr:dic-radio dicmeta="PH00002" name="clinicalManifestations.teaUrine" code="1,2,4"
                                       value="${caseDto.clinicalManifestations.teaUrine}"/></td>
				</tr>
				<tr>
					<th>7  肝区疼痛：</th>
					<td><ehr:dic-radio dicmeta="PH00002" name="clinicalManifestations.liverSore" code="1,2,4"
                                       value="${caseDto.clinicalManifestations.liverSore}"/></td>
					<th>8  发热：</th>
					<td>
                        <ehr:dic-radio dicmeta="PH00002" name="clinicalManifestations.fever" code="1,2,4" value="${caseDto.clinicalManifestations.fever}"
                                      />
                        <span id="highestTemperature">
						    如发热，则最高体温：<input type="text" name="clinicalManifestations.highestTemperature"  value="${caseDto.clinicalManifestations.highestTemperature}"
                                             reg='{"maxlength":"20"}' style="width:60px;"/>℃
                        </span>
					</td>
				</tr>
				<tr>
					<th>9  肝肿大：</th>
					<td><ehr:dic-radio dicmeta="PH00002" name="clinicalManifestations.hepatomegaly" code="1,2,4"
                                       value="${caseDto.clinicalManifestations.hepatomegaly}"/></td>
					<th>10 脾肿大：</th>
					<td><ehr:dic-radio dicmeta="PH00002" name="clinicalManifestations.splenomegaly" code="1,2,4"
                                       value="${caseDto.clinicalManifestations.splenomegaly}"/></td>
				</tr>
				<tr>
					<th>11 巩膜黄染：</th>
					<td><ehr:dic-radio dicmeta="PH00002" name="clinicalManifestations.skinScleraYellow" code="1,2,4"
                                       value="${caseDto.clinicalManifestations.skinScleraYellow}"/></td>
					<th>12 蜘蛛痣：</th>
					<td><ehr:dic-radio dicmeta="PH00002" name="clinicalManifestations.spiderBurst" code="1,2,4"
                                       value="${caseDto.clinicalManifestations.spiderBurst}"/></td>
				</tr>
				<tr>
					<th>13 肝掌：</th>
					<td><ehr:dic-radio dicmeta="PH00002" name="clinicalManifestations.liverPalms" code="1,2,4"
                                       value="${caseDto.clinicalManifestations.liverPalms}"/></td>
					<th>14 其他症状体症：</th>
					<td><input type="text" name="clinicalManifestations.other" value="${caseDto.clinicalManifestations.other}"
                               reg='{"maxlength":"100"}'> </td>
				</tr>
			</table>
		</fieldset>
<fieldset>
    <legend>三、流行病学调查</legend>
    <table class="posttable">
        <colgroup>
            <col style="width: 15%" />
            <col style="width: 35%" />
            <col style="width: 15%" />
            <col style="width: 35%" />
        </colgroup>
            <tr>
                <th>1  既往肝炎史：</th>
                <td colspan="3">
                    <ehr:dic-radio dicmeta="PH00002" code="1,2" name="epidemiologicalSurvey.hepatitis" value="${caseDto.epidemiologicalSurvey.hepatitis}"
                        />
                    <span id="hepatitisDtPart" style="display: none">
                        如有，则发病时间
                        <tag:dateInput name="epidemiologicalSurvey.hepatitisDt" date="${caseDto.epidemiologicalSurvey.hepatitisDt}"
                                               pattern="yyyy/MM/dd" style="width:100px;"/>
                        <br>肝炎型别&nbsp;&nbsp;&nbsp;
                        <ehr:dic-radio dicmeta="IDM00016" code="2,3,4,5,6,7,99" name="epidemiologicalSurvey.hepatitisCategory" value="${caseDto.epidemiologicalSurvey.hepatitisCategory}"
                                />

                    <span id="hepatitisOther" style="display: none">
                        <input type="text" name="epidemiologicalSurvey.hepatitisOther" style="width:150px;" placeholder="若选择其他，请描叙"
                               reg='{"maxlength":"100"}' value="${caseDto.epidemiologicalSurvey.hepatitisOther}"/>
                    </span>
                    </span>
                </td>
            </tr>
            <tr>
                <th>2  近2个月内喝生水史：</th>
                <td><ehr:dic-radio dicmeta="PH00002" code="1,2" name="epidemiologicalSurvey.rawWater"
                                   value="${caseDto.epidemiologicalSurvey.rawWater}"/></td>
                <td></td>
                <td></td>
            </tr>
            <%--<tr>--%>
                <%--<th>3  不洁饮食史：</th>--%>
            <%--</tr>--%>
            <tr>
                <th>3  不洁饮食史：</th>
                <td colspan="3">
                    3.1  毛蚶、牡蛎或其它生食海产品：<ehr:dic-radio dicmeta="PH00002" code="1,2" name="beforeDiseaseDiet.eatSeaProducts"
                        value="${caseDto.beforeDiseaseDiet.eatSeaProducts}"/><br>
                    3.2  市售熟食：<ehr:dic-radio dicmeta="PH00002" code="1,2" name="beforeDiseaseDiet.merCookedFood"
                                             value="${caseDto.beforeDiseaseDiet.merCookedFood}"/><br>
                    3.3  奶制品：<ehr:dic-radio dicmeta="PH00002" code="1,2" name="beforeDiseaseDiet.milchigs"
                                            value="${caseDto.beforeDiseaseDiet.milchigs}"/><br>
                    3.4  冷饮：<ehr:dic-radio dicmeta="PH00002" code="1,2" name="beforeDiseaseDiet.cooler"
                                           value="${caseDto.beforeDiseaseDiet.cooler}"/><br>
                    3.5  其它：<input type="text" name="beforeDiseaseDiet.other" value="${caseDto.beforeDiseaseDiet.other}"
                                   reg='{"maxlength":"200"}'/></td>
            </tr>
            <tr>
                <th>4  饮用水源：</th>
                <td colspan="3"><ehr:dic-radio name="epidemiologicalSurvey.drinkingWater" dicmeta="IDM00034" code="8,11,2,1,12,4,6,10"
                        value="${caseDto.epidemiologicalSurvey.drinkingWater}"/> </td>
            </tr>
            <tr>
                <th>5  洗漱用水：</th>
                <td colspan="3"><ehr:dic-radio name="epidemiologicalSurvey.washWater" dicmeta="IDM00034" code="8,11,2,1,12,4,6,10"
                                              value="${caseDto.epidemiologicalSurvey.washWater}"/></td>
            </tr>
            <tr>
                <th>6  病前2至6月内与确诊肝炎病人接触史：</th>
                <td colspan="3"><ehr:dic-radio dicmeta="PH00002" name="epidemiologicalSurvey.hepatitisContactHistory" code="1,2" value="${caseDto.epidemiologicalSurvey.hepatitisContactHistory}"
                                  /><br>
                    <span id="hepatitisContactHistoryPart">
                        如有，肝炎型别：<ehr:dic-radio dicmeta="IDM00016" code="2,3,4,5,6,7,99" name="epidemiologicalSurvey.chHepatitisCategory"
                                               value="${caseDto.epidemiologicalSurvey.chHepatitisCategory}"/>
                        <span id="chHepatitisOther" style="display: none">
                            <input type="text" name="epidemiologicalSurvey.chHepatitisOther" value="${caseDto.epidemiologicalSurvey.chHepatitisOther}"
                                   style="width: 150px;" reg='{"maxlength":"20"}'/>
                        </span>
                        <br>与病人关系：<input type="text" name="epidemiologicalSurvey.relationPatient" style="width: 200px;"
                                     value="${caseDto.epidemiologicalSurvey.relationPatient}" reg='{"maxlength":"20"}'/>
                        <br>接触方式： <ehr:dic-checkbox dicmeta="IDM00033" name="epidemiologicalSurvey.contactWayMulti"
                                                value="${caseDto.epidemiologicalSurvey.contactWayMulti}"/>
                    </span>
                </td>
            </tr>
            <tr>
                <th>7  密切接触者登记：</th>
                <td colspan="3" class="repeattable">
                	<div id="contactedList">
						<jsp:include page="contactedList.jsp"></jsp:include>
                    </div>
                </td>
            </tr>
        </table>
    </fieldset>

<fieldset>
    <legend>四、实验室检查结果</legend>
    <table class="posttable">
        <colgroup>
            <col style="width: 15%" />
            <col style="width: 35%" />
            <col style="width: 15%" />
            <col style="width: 35%" />
        </colgroup>
				<tr>
					<th>1 ALT：</th>
					<td><input type="text" name="labExamine.alt" value="${caseDto.labExamine.alt}"
                               reg='{"maxlength":"20"}' style="width: 100px;"/>U/L</td>
					<th>2 AST：</th>
					<td><input type="text" name="labExamine.ast" value="${caseDto.labExamine.ast}"
                               reg='{"maxlength":"20"}' style="width: 100px;"/>U/L</td>
				</tr>
				<tr>
					<th>3 总胆红素：</th>
					<td><input type="text" name="labExamine.tbil" value="${caseDto.labExamine.tbil}"
                               reg='{"maxlength":"20"}' style="width: 100px;"/>umol/L</td>
					<th>4 抗HAV-IgM：</th>
					<td><ehr:dic-radio dicmeta="PH00005" name="labExamine.havIgm" value="${caseDto.labExamine.havIgm}"/></td>
				</tr>
				<tr>
					<th>5 HBsAg：</th>
					<td><ehr:dic-radio dicmeta="PH00005" name="labExamine.hbsag" value="${caseDto.labExamine.hbsag}"/></td>
					<th>6 抗HBs：</th>
					<td><ehr:dic-radio dicmeta="PH00005" name="labExamine.antiHbs" value="${caseDto.labExamine.antiHbs}"/></td>
				</tr>
				<tr>
					<th>7 HBeAg：</th>
					<td><ehr:dic-radio dicmeta="PH00005" name="labExamine.hbeag" value="${caseDto.labExamine.hbeag}"/></td>
					<th>8 抗HBe：</th>
					<td><ehr:dic-radio dicmeta="PH00005" name="labExamine.antiHbe" value="${caseDto.labExamine.antiHbe}"/></td>
				</tr>
				<tr>
					<th>9 抗HBc-IgM：</th>
					<td><ehr:dic-radio dicmeta="PH00005" name="labExamine.antiHbcIgm" value="${caseDto.labExamine.antiHbcIgm}"/></td>
					<th>10 抗HCV-IgM：</th>
					<td><ehr:dic-radio dicmeta="PH00005" name="labExamine.antiHcvIgm" value="${caseDto.labExamine.antiHcvIgm}"/></td>
				</tr>
				<tr>
					<th>11 抗HDV-IgM：</th>
					<td><ehr:dic-radio dicmeta="PH00005" name="labExamine.antiHdvIgm" value="${caseDto.labExamine.antiHdvIgm}"/></td>
					<th>12 抗HEV-IgM：</th>
					<td><ehr:dic-radio dicmeta="PH00005" name="labExamine.antiHevIgm" value="${caseDto.labExamine.antiHevIgm}"/> </td>
				</tr>
				<tr>
					<th>13 其他：</th>
					<td><input type="text" name="labExamine.otherResult" value="${caseDto.labExamine.otherResult}"
                               reg='{"maxlength":"100"}'/></td>
				</tr>
			</table>
		</fieldset>
<fieldset>
    <legend>五、疫点处理</legend>
    <table class="posttable">
        <colgroup>
            <col style="width: 15%" />
            <col style="width: 35%" />
            <col style="width: 15%" />
            <col style="width: 35%" />
        </colgroup>
				<tr>
					<th>1  病人隔离：</th>
					<td><ehr:dic-radio dicmeta="PH00002" code="1,2" name="epidemicFocusClose.patientIsolationCond"
                            value="${caseDto.epidemicFocusClose.patientIsolationCond}"/> </td>
					<th>2  隔离地点：</th>
					<td><ehr:dic-radio dicmeta="IDM00044" name="epidemicFocusClose.isolationPlace" code="1,2,3"
                                       value="${caseDto.epidemicFocusClose.isolationPlace}"/></td>
				</tr>
				<tr>
					<th>3  病人住室消毒：</th>
					<td><ehr:dic-radio dicmeta="PH00002" name="epidemicFocusClose.patAccomDisin" code="1,2"
                                       value="${caseDto.epidemicFocusClose.patAccomDisin}"/></td>
					<th>4  病人分泌物消毒：</th>
					<td><ehr:dic-radio dicmeta="PH00002" name="epidemicFocusClose.patDischargeDisin" code="1,2"
                                       value="${caseDto.epidemicFocusClose.patDischargeDisin}"/></td>
				</tr>
				<tr>
					<th>5  消毒药物及浓度：</th>
					<td><input type="text" name="epidemicFocusClose.disinfDrugsConc" value="${caseDto.epidemicFocusClose.disinfDrugsConc}"
                               reg='{"maxlength":"20"}'/></td>
				</tr>
			</table>
		</fieldset>
<fieldset>
    <legend>六、调查小结</legend>
    <table class="posttable">
        <tr>
            <td>
                <textarea rows="7" cols="128" name="otherCondition.surveySummary" style="width: 100%" reg='{"maxlength":"1000"}'>
                ${caseDto.otherCondition.surveySummary}</textarea>
            </td>
        </tr>
        </table>
    </fieldset>

<fieldset>
                    <table class="posttable">
                        <colgroup>
                            <col style="width: 15%" />
                            <col style="width: 35%" />
                            <col style="width: 15%" />
                            <col style="width: 35%" />
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
                        <tag:dateInput name="caseInformation.modifySurveyDate" pattern="yyyy/MM/dd" date="${caseDto.caseInformation.modifySurveyDate}"/>
					</td>
					<th>审查（录入）者：</th>
					<td>
                        <ehr:user userCode="${caseDto.caseInformation.modifyRespondents}"/>
					</td>
				</tr>
				<tr>
					<th>审查（录入）时间：</th>
					<td>
                        <tag:dateInput name="caseInformation.modifySurveyDate" pattern="yyyy/MM/dd" date="${caseDto.caseInformation.modifySurveyDate}"/>
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
