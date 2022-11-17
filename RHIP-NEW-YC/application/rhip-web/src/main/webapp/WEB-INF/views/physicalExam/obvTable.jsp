<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<table width="100%" border="0" cellpadding="0" cellspacing="0" style="clear:both;">
<tr>
    <td class="h_top">内容</td>
    <td colspan="5" class="h_top">检查项目</td>
</tr>
<tr>
    <th <c:if test="${isElder}"> rowspan="9" </c:if> <c:if test="${not isElder}"> rowspan="5" </c:if> >一般状况</th>
    <th width="10%">体温</th>
    <td colspan="2">${physiqueExamination.temperature}℃</td>
    <th width="10%">脉率</th>
    <td width="30%">${physiqueExamination.pulseRate}次/分钟</td>
</tr>
<tr>
    <th>呼吸频率</th>
    <td colspan="2">${physiqueExamination.respiratoryRate}次/分钟</td>
    <th>血压</th>
    <td>
        <table>
            <tr>
                <td>左侧</td>
                <td>
                    ${physiqueExamination.leftSbp}/
                    ${physiqueExamination.leftDbp}mmHg
                </td>
                <td>右侧</td>
                <td>
                    ${physiqueExamination.rightSbp}/
                    ${physiqueExamination.rightDbp}mmHg
                </td>
            </tr>
        </table>
    </td>
</tr>
<tr>
    <th>身高</th>
    <td colspan="2">${physiqueExamination.height}cm</td>
    <th>体重</th>
    <td width="16%">${physiqueExamination.bodyWeight}kg</td>
</tr>
<tr>
    <th>腰围</th>
    <td colspan="2">${physiqueExamination.waostline}cm</td>
    <th>体质指数（BMI）</th>
    <td width="16%">${physiqueExamination.indexOfBodyCharacteristics}kg/㎡</td>
</tr>
<tr>
    <th>臀围</th>
    <td colspan="2">${physiqueExamination.hip}</td>
    <th>腰臀围比值</th>
    <td width="16%">${physiqueExamination.whr}</td>
</tr>
<c:if test="${isElder}">
	<tr>
	    <th>老年人健康状况自我评估</th>
	    <td colspan="4">
	        <ehr:dic dicmeta="CV0401013" code="${physiqueExamination.healthSelfAssessment}"/>
	    </td>
	</tr>
	<tr>
	    <th>老年人生活自理能力自我评估</th>
	    <td colspan="4">
	        <ehr:dic dicmeta="CV0401014" code="${physiqueExamination.lifeAbilitySelfAssessment}"/>
	    </td>
	</tr>
	<tr>
	    <th>老年人认知功能</th>
	    <td colspan="4">
	        ${physiqueExamination.cognitionScreenResult eq"1" ?"粗筛阴性" :""}
	
	        ${physiqueExamination.cognitionScreenResult eq"0" ?"粗筛阳性" :""}
	        <c:if test="${physiqueExamination.cognitionScreenResult eq '0'}">
	                <span id="cognitionScreenScore" >
	                   ，简易智力状态检查，总分${physiqueExamination.cognitionScreenScore}
	                </span>
	        </c:if>
	    </td>
	</tr>
	<tr>
	    <th>老年人情感状态</th>
	    <td colspan="4">
	        ${physiqueExamination.emotionScreenResult eq"1" ?"粗筛阴性" :""}
	
	        ${physiqueExamination.emotionScreenResult eq "0" ?"粗筛阳性" :""}
	        <c:if test="${physiqueExamination.emotionScreenResult eq '0'}">
	                <span id="depressionScore">
	                    ，老年人抑郁评分检查，总分${physiqueExamination.depressionScore}
	                </span>
	        </c:if>
	    </td>
	</tr>
</c:if>
<tr>
    <th rowspan="4">脏器功能</th>
    <th>口腔</th>
    <td colspan="4">
        <table>
            <tr><td colspan="2">口唇&nbsp;
                <ehr:dic dicmeta="CV0410007" code="${physiqueExamination.lipAppearanceCehckResult}"/>
            </td></tr>
            <tr>
                <td>齿列&nbsp;
                   ${physiqueExamination.dentitionAnomalyFlag eq "0" ?"正常" :""}
                   ${physiqueExamination.dentitionAnomalyFlag eq "1" ?"异常" :""}
                </td>
                <td id="ttb7" style="width: 60%;">
                    ${physiqueExamination.missingToothFlg eq "1" ? "缺齿" : ""}
                    <c:if test="${not empty physiqueExamination.missingToothFlg}">
                    <table style="width: 20%;">
                        <tr >
                            <td>${physiqueExamination.missingToothNumberUpl}</td>
                            <td>${physiqueExamination.missingToothNumberUpr}</td>
                        </tr>
                        <tr>
                            <td>${physiqueExamination.missingToothNumberDownl}</td>
                            <td>${physiqueExamination.missingToothNumberDownr}</td>
                        </tr>
                    </table>
                    </c:if>
                    ${physiqueExamination.decayedToothFlg eq "1"?"龋齿":""}
                    <c:if test="${not empty physiqueExamination.decayedToothFlg}">
                    <table style="width: 20%;">
                        <tr >
                            <td>${physiqueExamination.decayedToothNumberUpl}</td>
                            <td>${physiqueExamination.decayedToothNumberUpr}</td>
                        </tr>
                        <tr>
                            <td>${physiqueExamination.decayedToothNumberDownl}</td>
                            <td>${physiqueExamination.decayedToothNumberDownr}</td>
                        </tr>
                    </table>
                    </c:if>
                    ${physiqueExamination.dentureToothFlg eq "1"?"义齿":""}
                    <c:if test="${not empty physiqueExamination.dentureToothFlg}">
                    <table style="width: 20%;">
                        <tr >
                            <td>${physiqueExamination.dentureToothNumberUpl}</td>
                            <td>${physiqueExamination.dentureToothNumberUpr}</td>
                        </tr>
                        <tr>
                            <td>${physiqueExamination.dentureToothNumberDownl}</td>
                            <td>${physiqueExamination.dentureToothNumberDownr}</td>
                        </tr>
                    </table>
                    </c:if>
                </td>
            </tr>
            <tr>
                <td colspan="2">咽部&nbsp;
                      <ehr:dic dicmeta="FS10183" code="${physiqueExamination.pharynxCheckResult}"/>
                </td>
            </tr>
        </table>
    </td>
</tr>
<tr>
    <th>视力</th>
    <td colspan="4">
        左眼${physiqueExamination.lNakedEye}
        右眼${physiqueExamination.rNakedEye}
        （矫正视力：左眼${physiqueExamination.lEyecorrection}
        右眼${physiqueExamination.rEyecorrection})
    </td>
</tr>
<tr>
    <th>听力</th>
    <td colspan="4">
        <ehr:dic dicmeta="FS10170" code="${physiqueExamination.hearDetectResult}"/>
    </td>
</tr>
<tr>
    <th>运动功能</th>
    <td colspan="4">
        <ehr:dic dicmeta="FS10212" code="${physiqueExamination.motorFuncState}"/>
    </td>
</tr>
<tr>
    <th <c:if test="${isWoman}"> rowspan="23" </c:if> <c:if test="${not isWoman}"> rowspan="18" </c:if>>查体</th>
    <th>眼底</th>
    <td colspan="4">
        ${physiqueExamination.fundusOculiAnomalyFlag eq"0" ?"正常":""}
        ${physiqueExamination.fundusOculiAnomalyFlag eq"1" ?"异常":""}
        ${physiqueExamination.fundusOculiAnomalyDesc}
    </td>
</tr>
<tr>
    <th>皮肤</th>
    <td colspan="4">
        ${physiqueExamination.skinCheckResult eq"1" ?"正常":""}
        ${physiqueExamination.skinCheckResult eq"2" ?"潮红":""}
        ${physiqueExamination.skinCheckResult eq"3" ?"苍白":""}
        ${physiqueExamination.skinCheckResult eq"4" ?"发绀":""}
        ${physiqueExamination.skinCheckResult eq"5" ?"黄染":""}
        ${physiqueExamination.skinCheckResult eq"6" ?"色素沉着":""}
        ${physiqueExamination.skinCheckResult eq"7" ?"其他":""}
        ${physiqueExamination.skinCheckDesc}
    </td>
</tr>
<tr>
    <th>巩膜</th>
    <td colspan="4">
        ${physiqueExamination.scleraCheckResult eq"1" ?"正常":""}
        ${physiqueExamination.scleraCheckResult eq"2" ?"黄染":""}
        ${physiqueExamination.scleraCheckResult eq"3" ?"充血":""}
        ${physiqueExamination.scleraCheckResult eq"4" ?"其他":""}
        ${physiqueExamination.scleraCheckDesc}
    </td>
</tr>
<tr>
    <th>淋巴结</th>
    <td colspan="4">
    ${physiqueExamination.lymphNodeCheckResult eq"1" ?"未触及 ":""}
    ${physiqueExamination.lymphNodeCheckResult eq"2" ?"锁骨上 ":""}
    ${physiqueExamination.lymphNodeCheckResult eq"3" ?"腋窝  ":""}
    ${physiqueExamination.lymphNodeCheckResult eq"4" ?"其他  ":""}
    ${physiqueExamination.lymphNodeCheckDesc}
    </td>
</tr>
<tr>
    <th rowspan="3">肺</th>
    <td colspan="4">桶状胸：
        ${physiqueExamination.barrelChest eq"1" ?"是":""}
        ${physiqueExamination.barrelChest eq"0" ?"否":""}
<tr>
    <td colspan="4" >呼吸音：
        ${physiqueExamination.lungsAnomalySound eq"1" ?"正常":""}
        ${physiqueExamination.lungsAnomalySound eq"0" ?"异常":""}
        ${physiqueExamination.lungsAnomalyDesc}
    </td>
</tr>
<tr>
    <td colspan="4"> 啰音：
        ${physiqueExamination.lungsRaleFlag eq"1" ?"无   ":""}
        ${physiqueExamination.lungsRaleFlag eq"2" ?"干啰音 ":""}
        ${physiqueExamination.lungsRaleFlag eq"3" ?"湿啰音 ":""}
        ${physiqueExamination.lungsRaleFlag eq"4" ?"其它  ":""}
        ${physiqueExamination.lungsRaleDesc}
    </td>
</tr>
<tr>
    <th>心脏</th>
    <td colspan="4">
        心率： ${physiqueExamination.heartRate}次/分钟
        <br>
          	心律 ：<ehr:dic dicmeta="FS10176" code="${physiqueExamination.cardioverter}"/>
        <br>
        杂音：
        ${physiqueExamination.heartMurmurFlag eq"0" || physiqueExamination.heartMurmurFlag eq null ?"无":""}
        ${physiqueExamination.heartMurmurFlag eq"1" ?"有":""}
        <c:if test="${physiqueExamination.heartMurmurFlag eq '1'}">
            <span id="heartMurmurDesc"> ${physiqueExamination.heartMurmurDesc}次/分钟</span>
        </c:if>
    </td>
</tr>
<tr>
    <th rowspan="5">腹部</th>
    <td colspan="4">
        压痛：
        ${physiqueExamination.abdominalTendernessFlag eq"0" ||physiqueExamination.abdominalTendernessFlag eq null ?"无":""}
        ${physiqueExamination.abdominalTendernessFlag eq"1" ?"有":""}
        ${physiqueExamination.abdominalTendernessDesc}

    </td>
</tr>
<tr>
    <td colspan="4">包块：
        ${physiqueExamination.abdominalMassFlag eq "0" || physiqueExamination.abdominalMassFlag eq null ?"无":""}
        ${physiqueExamination.abdominalMassFlag eq"1" ?"有":""}
        ${physiqueExamination.abdominalMassDesc}
    </td>
</tr>
<tr>
    <td colspan="4">肝大：
        ${physiqueExamination.liverFlag eq "0" || physiqueExamination.liverFlag eq null ?"无":""}
        ${physiqueExamination.liverFlag eq"1" ?"有":""}
        ${physiqueExamination.liverDesc}
    </td>
</tr>
<tr>
    <td colspan="4">脾大：
        ${physiqueExamination.splenomegalyFlag eq"0" || physiqueExamination.splenomegalyFlag eq null ?"无":""}
        ${physiqueExamination.splenomegalyFlag eq"1" ?"有":""}
        ${physiqueExamination.splenomegalyDesc}
    </td>
</tr>
<tr>
    <td colspan="4">移动性浊音：
        ${physiqueExamination.abdominalVoicedFlag eq"0" || physiqueExamination.abdominalVoicedFlag eq null ?"无":""}
        ${physiqueExamination.abdominalVoicedFlag eq"1" ?"有":""}
        ${physiqueExamination.abdominalVoicedDesc}
    </td>
</tr>
<tr>
    <th>下肢水肿</th>
    <td colspan="4">
       <ehr:dic dicmeta="CV0410014" code="${physiqueExamination.legsEdemaCheckResult}"/>
    </td>
</tr>
<tr>
    <th>足背动脉搏动</th>
    <td colspan="4">
       <ehr:dic dicmeta="CV0410015" code="${physiqueExamination.arteriopalmus}"/>
    </td>
</tr>
<tr>
    <th>肛门指诊</th>
    <td colspan="4">
        <ehr:dic dicmeta="CV0410013" code="${physiqueExamination.dreCheckResultType}"/>
        ${physiqueExamination.dreCheckResultDesc}
    </td>
</tr>
<tr>
    <th>乳腺</th>
    <td colspan="4">
        ${physiqueExamination.breastAnomalyFlag eq"0" ?"未见异常 ":""}
        ${physiqueExamination.breastAnomalyFlag eq"1" ?"有异常  ":""}

         <c:if test="${physiqueExamination.breastAnomalyFlag eq '1'}">
        <span id="ttb8">
            ${physiqueExamination.breastResection eq"1" ?        "乳房切除  ": ""}
            ${physiqueExamination.breastAnomalyLactation eq"1" ? "异常泌乳  ": ""}
            ${physiqueExamination.breastMass eq"1" ?             "乳腺包块  ": ""}
            ${physiqueExamination.breastOther eq"1" ?            "其它     " : ""}
            ${physiqueExamination.breastOtherDesc}
        </span>
        </c:if>
    </td>
</tr>
<c:if test="${isWoman}">
	<tr>
	    <th rowspan="5">妇科</th>
	    <td class="td_gray">外阴</td>
	    <td colspan="3">
	        ${physiqueExamination.vulvaAnomalyFlag eq"0" ?"未见异常 ":""}
	        ${physiqueExamination.vulvaAnomalyFlag eq"1" ?"有异常  ":""}
	        ${physiqueExamination.vulvaAnomalyDesc}
	    </td>
	</tr>
	<tr>
	    <td class="td_gray">阴道</td>
	    <td colspan="3">
	        ${physiqueExamination.vaginaAnomalyFlag eq"0" ?"未见异常   ":""}
	        ${physiqueExamination.vaginaAnomalyFlag eq"1" ?"有异常    ":""}
	        ${physiqueExamination.vaginaAnomalyDesc}
	    </td>
	</tr>
	<tr>
	    <td class="td_gray">宫颈</td>
	    <td colspan="3">
	        ${physiqueExamination.cervicalAnomalyFlag eq"0" ?"未见异常  ":""}
	        ${physiqueExamination.cervicalAnomalyFlag eq"1" ?"有异常   ":""}
	        ${physiqueExamination.cervicalAnomalyDesc}
	    </td>
	</tr>
	<tr>
	    <td class="td_gray">宫体</td>
	    <td colspan="3">
	        ${physiqueExamination.corpusAnomalyFlag eq"0" ?"未见异常 ":""}
	        ${physiqueExamination.corpusAnomalyFlag eq"1" ?"有异常  ":""}
	        ${physiqueExamination.corpusAnomalyDesc}
	    </td>
	</tr>
	<tr>
	    <td class="td_gray">附件</td>
	    <td colspan="3">
	        ${physiqueExamination.accessoriesAnomalyFlag eq"0" ?"未见异常   ":""}
	        ${physiqueExamination.accessoriesAnomalyFlag eq"1" ?"有异常    ":""}
	        ${physiqueExamination.accessoriesAnomalyDesc}
	    </td>
	</tr>
</c:if>
<tr>
    <th>其他</th>
    <td colspan="4">
       ${physiqueExamination.otherCheckResult}
    </td>
</tr>
<tr>
    <th <c:if test="${isWoman}"> rowspan="15" </c:if> <c:if test="${not isWoman}"> rowspan="14" </c:if>>辅助检查</th>
    <th>血常规</th>
    <td colspan="4">
        血红蛋白${physiqueExamination.hemoglobinValue}g/L
        &nbsp;&nbsp;&nbsp;&nbsp;
        白细胞${physiqueExamination.leukocyteCount}×10<sup>9</sup>/L
        &nbsp;&nbsp;&nbsp;&nbsp;
        血小板${physiqueExamination.plateletCount}×10<sup>9</sup>/L
        <br>
        其它${physiqueExamination.bloodRoutineOtherDesc}
    </td>
</tr>
<tr>
    <th rowspan="2">尿常规</th>
    <td colspan="4">
        尿蛋白${physiqueExamination.urineProQuantitativeValue}
        &nbsp;&nbsp;&nbsp;&nbsp;
        尿糖${physiqueExamination.urineSugQuantitativeValue}
        &nbsp;&nbsp;&nbsp;&nbsp;
        血酮体${physiqueExamination.ketQuantitativeValue}
        &nbsp;&nbsp;&nbsp;&nbsp;
        尿潜血${physiqueExamination.eryQuantitativeValue}
        <br>
        其它${physiqueExamination.urineRoutinesOtherDesc}
    </td>
</tr>
<tr>
    <td class="td_gray">空腹血糖</td>
    <td colspan="4">
        ${physiqueExamination.fpgMmol}mmol/L
        或
        ${physiqueExamination.fpgMg}mg/dL
    </td>
</tr>
<tr>
    <th>心电图</th>
    <td colspan="4">
        ${physiqueExamination.ecgAnomalyFlag eq"0" ?"正常":""}
        ${physiqueExamination.ecgAnomalyFlag eq"1" ?"异常":""}
        ${physiqueExamination.ecgAnomalyDesc}
    </td>
</tr>
<tr>
    <th>尿微量白蛋白</th>
    <td colspan="4">
        ${physiqueExamination.urineMicroTongAlbumin}mg/dL
    </td>
</tr>
<tr>
    <th>大便潜血</th>
    <td colspan="4">
       <ehr:dic dicmeta="FS10058" code="${physiqueExamination.fecalOccultBlood}"/>
    </td>
</tr>
<tr>
    <th>糖化血红蛋白</th>
    <td colspan="4">
        ${physiqueExamination.hgb}%
    </td>
</tr>
<tr>
    <th>乙型肝炎表面抗原</th>
    <td colspan="4">
        <ehr:dic dicmeta="FS10058" code="${physiqueExamination.hbsagDetectResult}"/>
    </td>
</tr>
<tr>
    <th>肝功能</th>
    <td colspan="4">
        血清谷丙转氨酶 ${physiqueExamination.serumGptValue}U/L
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        血清谷草转氨酶 ${physiqueExamination.serumAstValue}U/L
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        白蛋白浓度  ${physiqueExamination.albuminConcentration}g/L
        <br>
        总胆红素  ${physiqueExamination.totalBilirubin}μmol/L
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        结合胆红素  ${physiqueExamination.conjugatedBilirubin}μmol/L
    </td>
</tr>
<tr>
    <th>肾功能</th>
    <td colspan="4">
        血清肌酐 ${physiqueExamination.creatinine} μmol/L
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        血尿素氮${physiqueExamination.bloodUreaNitrogenValue}μmol/L
        <br>
        血钾浓度${physiqueExamination.potassiumConcentration}μmol/L
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        血钠浓度${physiqueExamination.sodiumConcentration}μmol/L
    </td>
</tr>
<tr>
    <th>血脂</th>
    <td colspan="4">
        总胆固醇 ${physiqueExamination.tc}mmol/L
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        甘油三酯 ${physiqueExamination.triglycerideValue}mmol/L
        <br>
        血清低密度脂蛋白胆固醇  ${physiqueExamination.ldlcDetectValue}mmol/L
        <br>
        血清高密度脂蛋白胆固醇  ${physiqueExamination.hdlcDetectValue}mmol/L
    </td>
</tr>
<tr>
    <th>胸部X线片</th>
    <td colspan="4">
        ${physiqueExamination.chestXAnomalyfFlag eq"0" ?"正常":""}
        ${physiqueExamination.chestXAnomalyfFlag eq"1" ?"异常":""}
        ${physiqueExamination.chestXAnomalyfDesc}
    </td>
</tr>
<tr>
    <th>B超</th>
    <td colspan="4">
        ${physiqueExamination.bmodeAnomalyfFlag eq"0" ?"正常":""}
        ${physiqueExamination.bmodeAnomalyfFlag eq"1" ?"异常":""}
        ${physiqueExamination.bmodeAnomalyfDesc}
    </td>
</tr>
<c:if test="${isWoman}">
	<tr>
	    <th>宫颈涂片</th>
	    <td colspan="4">
	        ${physiqueExamination.cervicalSmearAnomalyfFlag eq"0" ?"正常":""}
	        ${physiqueExamination.cervicalSmearAnomalyfFlag eq"1" ?"异常":""}
	        ${physiqueExamination.cervicalSmearAnomalyfDesc}
	    </td>
	</tr>
</c:if>
<tr>
    <th>其他</th>
    <td colspan="4">
        ${physiqueExamination.otherAuxiliaryExamination}
    </td>
</tr>
<tr>
    <th colspan="2">健康指导</th>
    <td colspan="2">

        <label>
            ${physiqueExamination.guideRegularFollowup eq"1" ?"<span>定期随访</span>":""}
        </label>
        <br>
        <label>
            ${physiqueExamination.guideIntoChronicDisease eq"1" ?"<span>纳入慢性病患者健康管理</span>":""}
        </label>
        <br>
        <label>
            ${physiqueExamination.guideSuggestionReview eq"1" ?"<span>建议复查</span>":""}
        </label>
        <br>
        <label>
            ${physiqueExamination.guideSuggestionReferral eq"1" ?"<span>建议转诊</span>":""}
        </label>
    </td>
    <td colspan="2">
        危险因素控制
        <br>
        <label>
            ${physiqueExamination.riskQuitSmoking eq '1' ? '<span>戒烟</span>' : ''}

        </label>
        <br>
        <label>
            ${physiqueExamination.riskHealthDrink eq '1' ? '<span>健康饮酒</span>' : ''}

        </label>
        <br>
        <label>
            ${physiqueExamination.riskDiet eq '1' ? '<span>饮食</span>' : ''}

        </label>
        <br>
        <label>
            ${physiqueExamination.riskExercise eq '1' ? '<span>锻炼</span>' : ''}

        </label>
        <br>
        <label>
            ${physiqueExamination.riskWeightReduction eq '1' ? '<span>减体重</span>' : ''}
        </label>
        <c:if test="${physiqueExamination.riskWeightReduction eq '1'}">
            <span id="riskWeightTarget"> ${physiqueExamination.riskWeightTarget}</span>
        </c:if>
        <br>
        <label>${physiqueExamination.guideVaccination eq '1' ? '<span>建议接种疫苗</span>' : ''}</label>
        <c:if test="${physiqueExamination.guideVaccination eq '1'}">
            <span id="guideVaccinationDesc"> ${physiqueExamination.guideVaccinationDesc} </span>
        </c:if>
        <br>
        <label>
            ${physiqueExamination.riskOther eq '1' ? '<span>其他</span>' : ''}
            </label>
            <c:if test="${physiqueExamination.riskOther eq '1'}">
                <span id="riskOtherDesc"> ${physiqueExamination.riskOtherDesc}</span>
            </c:if>
    </td>
</tr>
</table>