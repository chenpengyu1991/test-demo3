<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>

<link rel="stylesheet" href="${pageContext.request.contextPath}/css/views/ehrbrowser/basic/basic.css" />
<script src="${pageContext.request.contextPath}/js/views/woman/prenatalFollowupFirst/add.js" type="text/javascript"></script>
<script type="text/javascript">
    layui.use('laydate', function(){
        var laydate = layui.laydate;
        laydate.render({
          elem: '#estimatedDueDates'
           ,format: 'yyyy/MM/dd'
        });
        
        laydate.render({
          elem: '#text_inputDate'
        	  ,format: 'yyyy/MM/dd'
        });
      
        laydate.render({
            elem: '#next_inputDate'
             ,format: 'yyyy/MM/dd'
             ,trigger: 'click'
          });
        laydate.render({
            elem: '#lastMenstrualDate'
             ,format: 'yyyy/MM/dd'
             ,trigger: 'click'
          });
        
      });

    </script>
<div class="toolbar">
	<a href="javascript:void(0)" id="pFPBackId"><button class="btn-gray layui-btn layui-btn-sm button"><i class="layui-icon"></i>返回</button></a>
	<a href="javascript:void(0);" id="pFPSaveId"><button class="layui-btn layui-btn-sm button"><i class="layui-icon"></i>保存</button></a>

</div>
<div style="background-color: white;top: 65px;" class="divFixed105">
	<ul>
		<li style="text-align: center; font-size: 25px;">第1次产前随访服务记录表</li>
	</ul>
	<br/>
	<form id="pFPAddFromId">
		<%-- <input type="hidden" name="inputDate"  value="${prenatalFollowup.inputDate}"/> --%>
		<input type="hidden" name="personId" id="text_personId" value="${prenatalFollowup.personId}"/>
		<input type="hidden" name="id" id="prenatalId" value="${prenatalFollowup.id}"/>
		<input type="hidden" name="healthFileNo" value="${prenatalFollowup.healthFileNo}" id="healthFileNoIdd"/>
		<input type="hidden" name="createGbcode" value="${prenatalFollowup.createGbcode}"/>
		<input type="hidden" name="createOrganCode" value="${prenatalFollowup.createOrganCode}"/>
		<input type="hidden" name="createSuperOrganCode" value="${prenatalFollowup.createSuperOrganCode}"/>
		<div class="posttable">
		<table>
			<colgroup>
				<col style="width: 15%;"/>
	            <col style="width: 30%;"/>
				<col style="width: 15%;"/>
	            <col style="width: 30%;"/>
			</colgroup>
			<tr>
				<td colspan="3" align="right">健康档案编号：</td>
				<td>
					<input type="text" name="healthFileNo" value="${prenatalFollowup.healthFileNo}" disabled="disabled" id="healthFileNoId"/>
				</td>
				<td></td>
			</tr>
			<tr>
				<th>填表日期</th>
				<td>
					<input type="text" reg='{"required":"true"}'  class="layui-input x-admin-content-sm-date"  name="visitDate" id="text_inputDate" value="<fmt:formatDate value='${prenatalFollowup.visitDate}' pattern='yyyy/MM/dd'/>" style="padding-left: 0px;" />
				</td>
				<th><label class="required">孕周</label></th>
				<td>
					<tag:numberInput name="gestationalWeeks" value="${prenatalFollowup.gestationalWeeks}" maxlength="2" reg='{"required":"true"}' style="width: 10%"/>周
				</td>
			</tr>
			<tr>
				<th>孕妇姓名</th>
				<td><input reg='{"maxlength":16}'  type="text"
						   id="text_name" name="name"
						   value="${prenatalFollowup.name}" />
				</td>
				<th>孕妇年龄</th>
				<td>
					<input type="text" id="ageId" name="age" value="${prenatalFollowup.age}" reg='{"maxlength":"6"}' style="width: 10%"/>岁
				</td>
			</tr>
			<tr>
				<th><label class="required">身份证号</label></th>
				<td >
					<c:if test="${empty prenatalFollowup.id }">
						<tag:idcardInput name="idCard" id="text_idcard" reg='{"required":"true","idCard":true}' value="${prenatalFollowup.idCard}" ></tag:idcardInput>
					</c:if>
					<c:if test="${not empty prenatalFollowup.id }">
						${prenatalFollowup.idCard} <input type="hidden" name="idCard" maxlength="18" value="${prenatalFollowup.idCard}" />
					</c:if>
				</td>
				<th>丈夫姓名</th>
				<td>
					<input reg='{"maxlength":16}' type="text" name="husbandName" value="${prenatalFollowup.husbandName}" />
				</td>
			</tr>
			<tr>
				<th>丈夫年龄</th>
				<td>
					<input type="text" id="husbandAgeId" name="husbandAge" value="${prenatalFollowup.husbandAge}" reg='{"maxlength":"6"}' style="width: 10%"/>岁
				</td>
				<th>丈夫电话</th>
				<td><input type="text" id="text_phoneNumber"
					   name="husbandPhone"  reg='{"maxlength":20}'  value="${prenatalFollowup.husbandPhone}"/>
				</td>
			</tr>
			<tr>
				<th>孕次</th>
				<td>
					<tag:numberInput name="gravidityTimes" value="${prenatalFollowup.gravidityTimes}" maxlength="2" style="width: 10%" />
				</td>
				<th>产次</th>
				<td>
					<tag:numberInput name="productionTimes" value="${prenatalFollowup.productionTimes}" maxlength="2" style="width: 10%"/>
				</td>
			</tr>
			<tr>
				<th>阴道分娩次数</th>
				<td>
					<tag:numberInput name="vaginaDeliveryTimes" value="${prenatalFollowup.vaginaDeliveryTimes}" maxlength="2" style="width: 10%"/>
				</td>
				<th>剖宫产次数</th>
				<td>
					<tag:numberInput name="cesareanSectionTimes" value="${prenatalFollowup.cesareanSectionTimes}" maxlength="2" style="width: 10%"/>
				</td>
			</tr>
			<tr>
				<th>末次月经日期明确标志</th>
				<td>
					<ehr:dic-radio name="lastMenstrualDateMark" dicmeta="FS10281" code="2,3" value="${prenatalFollowup.lastMenstrualDateMark}"
								   onchange="toggleOther('lastMenstrualDateMark','lastMenstrualDateSpanID',2);"/>
					<span id="lastMenstrualDateSpanID">
						<input type="text" reg='{"required":"true"}'  class="layui-input x-admin-content-sm-date"  name="lastMenstrualDate" id="lastMenstrualDate" value="<fmt:formatDate value='${prenatalFollowup.lastMenstrualDate}' pattern='yyyy/MM/dd'/>" style="padding-left: 0px;" />
					</span>
				</td>
				<th><label class="required">预产期</label></th>
				<td>
					<input type="text" reg='{"required":"true"}'  class="layui-input x-admin-content-sm-date"  name="estimatedDueDates" id="estimatedDueDates" value="<fmt:formatDate value='${prenatalFollowup.estimatedDueDates}' pattern='yyyy/MM/dd'/>" style="padding-left: 0px;" />
				</td>
			</tr>
			<tr>
				<th>既往史</th>
				<td colspan="3">
					<ehr:dic-radio name="pastMedicalHistorySign" dicmeta="FS10111" value="${prenatalFollowup.pastMedicalHistorySign}"
								   onchange="toggleOther('pastMedicalHistorySign','pastMedicalHistorySignId',2);" code="1,2"/>
					<span id="pastMedicalHistorySignId">
						<ehr:dic-checkbox name="pastMedicalHistory" dicmeta="CV0210005" value="${prenatalFollowup.pastMedicalHistory}"
										  code="15,13,10,02,14,03,99" onchange="toggleOtherCK('pastMedicalHistory','pastMedicalHistoryDescId',99);"/>
						<span id="pastMedicalHistoryDescId">
							<input reg='{"required":"true","maxlength":100}' style="width: 10%" type="text" name="pastMedicalHistoryDesc" value="${prenatalFollowup.pastMedicalHistoryDesc}"/>
						</span>
					</span>
				</td>
			</tr>
			<tr>
				<th>家族史</th>
				<td colspan="3">
					<ehr:dic-radio name="familyDiseaseHistorySign" dicmeta="FS10111" value="${prenatalFollowup.familyDiseaseHistorySign}"
								   onchange="toggleOther('familyDiseaseHistorySign','familyDiseaseHistorySignId',2);" code="1,2"/>
					<span id="familyDiseaseHistorySignId">
						<ehr:dic-checkbox name="familyDiseaseHistory" dicmeta="FS10019" value="${prenatalFollowup.familyDiseaseHistory}"
										  onchange="toggleOtherCK('familyDiseaseHistory','familyDiseaseHistoryDescId',9);" reg='{"required":"true"}'/>
						<span id="familyDiseaseHistoryDescId">
							<input reg='{"required":"true","maxlength":100}' style="width: 10%" type="text" name="familyDiseaseHistoryDesc" value="${prenatalFollowup.familyDiseaseHistoryDesc}"/>
						</span>
					</span>
				</td>
			</tr>
			<tr>
				<th>个人史</th>
				<td colspan="3">
					<ehr:dic-radio name="personalHistorySign" dicmeta="FN10000" value="${prenatalFollowup.personalHistorySign}"
								   onchange="toggleOther('personalHistorySign','personalHistorySignSpanId',2);" code="1,2"/>
					<span id="personalHistorySignSpanId">
						 <ehr:dic-checkbox reg='{"required":"true"}' name="personalHistory" dicmeta="CV0300116" value="${prenatalFollowup.personalHistory}"
										   onchange="toggleOtherCK('personalHistory','personalHistoryDescId',9);" code="1,2,4,5,6,9"/>
						<span id="personalHistoryDescId">
							<input  reg='{"required":"true","maxlength":100}' style="width: 10%" type="text" name="personalHistoryDesc" value="${prenatalFollowup.personalHistoryDesc}"/>
						</span>
					</span>
				</td>
			</tr>
			<tr>
				<th>妇科手术史</th>
				<td colspan="3">
					<ehr:dic-radio name="womanSurgeryHistorySign" dicmeta="FS10111" value="${prenatalFollowup.womanSurgeryHistorySign}"
								   onchange="toggleOther('womanSurgeryHistorySign','gynecologicalSurgeryHistoryId',2);"/>
					<span id="gynecologicalSurgeryHistoryId">
						<input style="width: 10%" reg='{"required":"true","maxlength":100}' type="text" name="womanSurgeryHistory" value="${prenatalFollowup.womanSurgeryHistory}"/>
					</span>
				</td>
			</tr>
			<tr>
				<th>孕产史</th>
				<td colspan="3">
					1.自然流产<tag:numberInput name="abortionTimes" value="${prenatalFollowup.abortionTimes}" maxlength="2" style="width: 5%"/>
					2.人工流产<tag:numberInput name="artificialAbortionNum" value="${prenatalFollowup.artificialAbortionNum}" maxlength="2" style="width: 5%"/>
					3.死胎<tag:numberInput name="stillbornCasesNumber" value="${prenatalFollowup.stillbornCasesNumber}" maxlength="2" style="width: 5%"/>
					4.死产<tag:numberInput name="stillbirthCasesNumber" value="${prenatalFollowup.stillbirthCasesNumber}" maxlength="2" style="width: 5%"/>
					5.新生儿死亡<tag:numberInput name="neonatalDeathNumber" value="${prenatalFollowup.neonatalDeathNumber}" maxlength="2" style="width: 5%"/>
					6.出生缺陷儿<tag:numberInput name="birthDefectsNumber" value="${prenatalFollowup.birthDefectsNumber}" maxlength="2" style="width: 5%"/>
				</td>
			</tr>
			<tr>
				<th>身高</th>
				<td >
					<tag:numberInput id="personHeightId" name="height" value="${prenatalFollowup.height}" maxlength="5" style="width: 10%" point="1"/>cm
				</td>
				<th>体重</th>
				<td >
					<tag:numberInput id="personWeightId" name="bodyWeight" value="${prenatalFollowup.bodyWeight}" maxlength="5" style="width: 10%" point="1"/>kg
				</td>
			</tr>
			<tr>
				<th>体质指数</th>
				<td>
					<input reg="{'min':0,'max':999.99}" type="text" id="personBMIId" name="bodyMassIndex" value="${prenatalFollowup.bodyMassIndex}" readonly="readonly" style="width: 80px;"/>kg/㎡
				</td>
				<th>血压</th>
				<td>
					<tag:numberInput name="sbp" value="${prenatalFollowup.sbp}"  style="width: 40px" reg="{'min':0,'max':9999}"/>/
					<tag:numberInput name="dbp" value="${prenatalFollowup.dbp}"  style="width: 40px" reg="{'min':0,'max':9999}"/>mmHg
				</td>
			</tr>
			<tr>
				<th>心脏听诊异常</th>
				<td>
					<ehr:dic-radio name="cardiacAuscuAnomaly" dicmeta="FS10046" value="${prenatalFollowup.cardiacAuscuAnomaly}"
								   onchange="toggleOther('cardiacAuscuAnomaly','cardiacAuscuAnomalyDescId',2);"/>
					<span id="cardiacAuscuAnomalyDescId">
						<input reg='{"required":"true","maxlength":80}' type="text" name="cardiacAuscuAnomalyDesc" value="${prenatalFollowup.cardiacAuscuAnomalyDesc}" style="width: 40%"/>
					</span>
				</td>
				<th>肺部听诊异常</th>
				<td>
					<ehr:dic-radio name="lungAuscuAnomaly" dicmeta="FS10046" value="${prenatalFollowup.lungAuscuAnomaly}"
								   onchange="toggleOther('lungAuscuAnomaly','lungAuscuAnomalyDescId',2);"/>
					<span id="lungAuscuAnomalyDescId">
						<input reg='{"required":"true","maxlength":80}' type="text" name="lungAuscuAnomalyDesc" value="${prenatalFollowup.lungAuscuAnomalyDesc}" style="width: 40%"/>
					</span>
				</td>
			</tr>
			<tr>
				<%--<th rowspan="3">妇科检查</th>--%>
				<th>外阴</th>
				<td>
					<ehr:dic-radio name="vulvaAnomaly" dicmeta="FS10046" value="${prenatalFollowup.vulvaAnomaly}"
								   onchange="toggleOther('vulvaAnomaly','vulvaAnomalyDescId',2);"/>
					<span id="vulvaAnomalyDescId">
						<input reg='{"required":"true","maxlength":80}' type="text" name="vulvaAnomalyDesc" value="${prenatalFollowup.vulvaAnomalyDesc}" style="width: 40%"/>
					</span>
				</td>
				<th>阴道</th>
				<td>
					<ehr:dic-radio name="vaginaAbnormal" dicmeta="FS10046" value="${prenatalFollowup.vaginaAbnormal}"
								   onchange="toggleOtherCK('vaginaAbnormal','vaginaAbnormalDescId',2);"/>
					<span id="vaginaAbnormalDescId">
						<input reg='{"required":"true","maxlength":80}' type="text" name="vaginaAbnormalDesc" value="${prenatalFollowup.vaginaAbnormalDesc}" style="width: 40%"/>
					</span>
				</td>
			</tr>
			<tr>
				<th>宫颈</th>
				<td>
					<ehr:dic-radio name="abnormalCervical" dicmeta="FS10046" value="${prenatalFollowup.abnormalCervical}"
								   onchange="toggleOther('abnormalCervical','abnormalCervicalDescId',2);"/>
					<span id="abnormalCervicalDescId">
						<input reg='{"required":"true","maxlength":80}' type="text" name="abnormalCervicalDesc" value="${prenatalFollowup.abnormalCervicalDesc}" style="width: 40%"/>
					</span>
				</td>
				<th>宫体</th>
				<td>
					<ehr:dic-radio name="corpusAnomaly" dicmeta="FS10046" value="${prenatalFollowup.corpusAnomaly}"
								   onchange="toggleOther('corpusAnomaly','corpusAnomalyDescId',2);"/>
					<span id="corpusAnomalyDescId">
						<input reg='{"required":"true","maxlength":80}' type="text" name="corpusAnomalyDesc" value="${prenatalFollowup.corpusAnomalyDesc}" style="width: 40%"/>
					</span>
				</td>
			</tr>
			<tr>
				<th>附件</th>
				<td>
					<ehr:dic-radio name="accessoriesAnomaly" dicmeta="FS10046" value="${prenatalFollowup.accessoriesAnomaly}"
								   onchange="toggleOther('accessoriesAnomaly','accessoriesAnomalyDescSpanId',2);"/>
					<span id="accessoriesAnomalyDescSpanId">
						<input reg='{"required":"true","maxlength":80}' type="text" name="accessoriesAnomalyDesc" value="${prenatalFollowup.accessoriesAnomalyDesc}" style="width: 40%"/>
					</span>
				</td>
				<td></td>
				<td></td>
			</tr>
			<tr>
				<%--<th rowspan="10">辅助检查</th>--%>
				<th><label class="required">血常规</label></th>
				<td colspan="3">
					血红蛋白值<tag:numberInput name="hemoglobinValue" value="${prenatalFollowup.hemoglobinValue}" point="1" style="width: 10%" reg="{'required':true,'min':0,'max':999.9}"/>g/L
					&nbsp;&nbsp;&nbsp;&nbsp;
					白细胞计数值<tag:numberInput name="leukocyteCount" value="${prenatalFollowup.leukocyteCount}" point="1" style="width: 10%" reg="{'required':true,'min':0,'max':999.9}"/>×10<sup>9</sup>/L
					&nbsp;&nbsp;&nbsp;&nbsp;
					血小板计数值<tag:numberInput name="plateletCount" value="${prenatalFollowup.plateletCount}" point="1" style="width: 10%" reg="{'required':true,'min':0,'max':999.9}"/>×10<sup>9</sup>/L
					<br>
					其它
					<input reg='{"maxlength":16}' type="text" name="otherBloodRoutine" value="${prenatalFollowup.otherBloodRoutine}" style="width: 10%"/>
				</td>
			</tr>
			<tr>
				<th><label class="required">尿常规</label></th>
				<td colspan="3">
					尿蛋白<ehr:dic-radio dicmeta="CV0450015" code="01,03" name="urineProQualitativeResult" value="${prenatalFollowup.urineProQualitativeResult}" reg='{"required":true}'/>
					&nbsp;&nbsp;&nbsp;&nbsp;
					尿糖<ehr:dic-radio dicmeta="CV0450015" code="01,03" name="urineSugQualitativeResult" value="${prenatalFollowup.urineSugQualitativeResult}" reg='{"required":true}'/>
					&nbsp;&nbsp;&nbsp;&nbsp;
					尿酮体<ehr:dic-radio dicmeta="CV0450015" code="01,03" name="ketQualitativeDetection" value="${prenatalFollowup.ketQualitativeDetection}" reg='{"required":true}'/>
					&nbsp;&nbsp;&nbsp;&nbsp;
					尿潜血<ehr:dic-radio dicmeta="CV0450015" code="01,03" name="eryDetection" value="${prenatalFollowup.eryDetection}" reg='{"required":true}'/>
					&nbsp;&nbsp;&nbsp;&nbsp;
					其它
					<input type="text" name="otherUrineRoutines" value="${prenatalFollowup.otherUrineRoutines}" style="width: 20%" reg='{"required":true}'/>
				</td>
			</tr>
			<tr>
				<th><label class="required">血型</label></th>
				<td>
					<ehr:dic-radio dicmeta="CV0450005" value="${prenatalFollowup.aboBloodType}" name="aboBloodType" reg='{"required":true}'/>
				</td>
				<th><label class="required">Rh血型</label></th>
				<td>
					<ehr:dic-radio dicmeta="FS10010" value="${prenatalFollowup.rhBloodType}" name="rhBloodType" reg='{"required":true}'/>
				</td>
			</tr>
			<tr>
				<th><label class="required">空腹血糖</label></th>
				<td colspan="3">
					<tag:numberInput name="bloodGlucoseValues" value="${prenatalFollowup.bloodGlucoseValues}" point="1" style="width: 10%" reg='{"required":true}'/>mmol/L
				</td>
			</tr>
			<tr>
				<th><label class="required">肝功能</label></th>
				<td colspan="3">
					血清谷丙转氨酶<tag:numberInput name="serumGptValue" value="${prenatalFollowup.serumGptValue}" point="1" style="width: 10%" reg="{'required':true,'min':0,'max':999.9}"/>U/L
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					血清谷草转氨酶<tag:numberInput name="serumAstValue" value="${prenatalFollowup.serumAstValue}" point="1" style="width: 10%" reg="{'required':true,'min':0,'max':999.9}"/>U/L
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					白蛋白<tag:numberInput name="albuminConcentration" value="${prenatalFollowup.albuminConcentration}" point="1" style="width: 10%" reg="{'required':true,'min':0,'max':999.9}"/> g/L
					<br>
					总胆红素<tag:numberInput name="totalBilirubin" value="${prenatalFollowup.totalBilirubin}" point="1" style="width: 10%" reg='{"required":true}'/>μmol/L
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					结合胆红素<%--<tag:numberInput name="conjugatedBilirubin" value="${prenatalFollowup.conjugatedBilirubin}" point="1" style="width: 10%" reg='{"required":true}'/>--%>
					<input name="conjugatedBilirubin" value="${prenatalFollowup.conjugatedBilirubin}" type="text" style="width: 10%" reg='{"required":true}'/>μmol/L
				</td>
			</tr>
			<tr>
				<th><label class="required">肾功能</label></th>
				<td colspan="3">
					血清肌酐 <tag:numberInput name="creatinine" value="${prenatalFollowup.creatinine}" point="1" style="width: 10%" reg='{"required":true}'/>μmol/L
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					血尿素氮
					<tag:numberInput name="bloodUreaNitrogenValues" value="${prenatalFollowup.bloodUreaNitrogenValues}" point="1" style="width: 10%" reg='{"required":true}'/>mmol/L
				</td>
			</tr>
			<tr>
				<th><label class="required">阴道分泌物</label></th>
				<td>
					<ehr:dic-radio name="vaginaSecretionsCheckResult" value="${prenatalFollowup.vaginaSecretionsCheckResult}" dicmeta="CV0450019"
								   onchange="toggleOther('vaginaSecretionsCheckResult','vaginaSecretionsCheckDescId',9);" reg='{"required":true}'/>
					<span id="vaginaSecretionsCheckDescId">
						<input reg='{"required":"true","maxlength":80}' type="text" name="vaginaSecretionsCheckDesc" value="${prenatalFollowup.vaginaSecretionsCheckDesc}"/>
					</span>
				</td>
				<th><label class="required">阴道分泌物清洁度</label></th>
				<td>
					<ehr:dic-radio name="vaginaSecretionsCleanliness" value="${prenatalFollowup.vaginaSecretionsCleanliness}" dicmeta="CV0450010" reg='{"required":true}'/>
				</td>
			</tr>
			<tr>
				<th><label class="required">乙型肝炎表面抗原</label></th>
				<td>
					<ehr:dic-radio dicmeta="FS10058" value="${prenatalFollowup.hbsagDetectResult}" name="hbsagDetectResult" reg='{"required":true}'/>
				</td>
				<th><label class="required">乙型肝炎表面抗体</label></th>
				<td>
					<ehr:dic-radio dicmeta="FS10058"  value="${prenatalFollowup.hbsDetectResult}" name="hbsDetectResult" reg='{"required":true}'/>
				</td>
			</tr>
			<tr>
				<th><label class="required">乙型肝炎e抗原</label></th>
				<td>
					<ehr:dic-radio dicmeta="FS10058" value="${prenatalFollowup.hbeagDetectResult}" name="hbeagDetectResult" reg='{"required":true}'/>
				</td>
				<th><label class="required">乙型肝炎e抗体</label></th>
				<td>
					<ehr:dic-radio dicmeta="FS10058" value="${prenatalFollowup.hbeDetectResult}" name="hbeDetectResult" reg='{"required":true}'/>
				</td>
			</tr>
			<tr>
				<th><label class="required">乙型肝炎核心抗体</label></th>
				<td>
					<ehr:dic-radio dicmeta="FS10058" value="${prenatalFollowup.hbcabDetectResult}" name="hbcabDetectResult" reg='{"required":true}'/>
				</td>
			</tr>
			<tr>
				<th><label class="required">梅毒血清学试验结果</label></th>
				<td>
					<ehr:dic-radio dicmeta="FS10058" name="syphilisSerologyCheckResult" value="${prenatalFollowup.syphilisSerologyCheckResult}" reg='{"required":true}'/>
				</td>
				<th><label class="required">HIV抗体检测</label></th>
				<td>
					<ehr:dic-radio dicmeta="FS10058" name="hivlgDetectResult" value="${prenatalFollowup.hivlgDetectResult}" reg='{"required":true}'/>
				</td>
			</tr>
			<tr>
				<th><label class="required">B超</label></th>
				<td colspan="3">
					<input reg='{"required":"true","maxlength":16}' type="text" name="bmodeCheckResult" value="${prenatalFollowup.bmodeCheckResult}" style="width: 30%"/>
				</td>
			</tr>
			<tr>
				<th>总体评估</th>
				<td>
					<ehr:dic-radio name="assessmentAnomalySign" dicmeta="FS10046" value="${prenatalFollowup.assessmentAnomalySign}"
						onchange="toggleOther('assessmentAnomalySign','healthAbnormalDescId',2);"/>
					<span id="healthAbnormalDescId">
					   	<input reg='{"required":"true","maxlength":80}' type="text" name="healthAbnormalDesc" value="${prenatalFollowup.healthAbnormalDesc}" style="width: 60%"/>
                   </span>
					<th>是否转诊</th>
					<td>
						<ehr:dic-radio name="referralFlag" dicmeta="FY0001" value="${prenatalFollowup.referralFlag}" code="1,0"
									   onchange="toggleOther('referralFlag','referralFlagIdSpan',1);"/>
					</td>
				</td>
			</tr>
			<tr id="referralFlagIdSpan">
				<th>机构及科室</th>
				<td>
					<input reg='{"required":"true","maxlength":80}' type="text" name="referralHospitalName" value="${prenatalFollowup.referralHospitalName}" style="width: 40%"/>
					<input reg='{"required":"true","maxlength":80}' type="text" name="referralDeptName" value="${prenatalFollowup.referralDeptName}" style="width: 40%"/>
				</td>
				<th>转诊原因</th>
				<td>
					<input reg='{"required":"true","maxlength":80}' type="text" name="referralReason" value="${prenatalFollowup.referralReason}" style="width: 30%"/>
				</td>
			</tr>
			<tr>
				<th>保健指导</th>
				<td colspan="3">
					<ehr:dic-checkbox dicmeta="CV0600219" code="01,02,15,04,05,99" name="healthGuidanceClass" value="${prenatalFollowup.healthGuidanceClass}"
									  onchange="toggleOtherCK('healthGuidanceClass','healthGuidanceClassDescSpanId',99);"/>
					<span id="healthGuidanceClassDescSpanId">
					   	<input reg='{"required":"true","maxlength":80}' type="text" name="healthGuidanceClassDesc" value="${prenatalFollowup.healthGuidanceClassDesc}" style="width: 10%"/>
                   </span>
				</td>
			</tr>
			<tr>
				<th>中医药健康管理服务</th>
				<td colspan="3">
					<ehr:dic-checkbox dicmeta="FS10307" code="6,9,10,7,99" name="cmHealthManage" value="${prenatalFollowup.cmHealthManage}"
									  onchange="toggleOtherCK('cmHealthManage','cmHealthManageDescSpan',99);"/>
					<span id="cmHealthManageDescSpan">
					   	<input reg='{"required":"true","maxlength":100}' type="text" name="cmHealthManageDesc" value="${prenatalFollowup.cmHealthManageDesc}" style="width: 10%"/>
                   </span>
				</td>
			</tr>
			<tr>
				<th><label class="required">下次随访日期</label></th>
				<td>
					<input type="text" reg='{"required":"true"}'  class="layui-input x-admin-content-sm-date"  name="nextSupervisionDate" id="next_inputDate" value="<fmt:formatDate value='${prenatalFollowup.nextSupervisionDate}' pattern='yyyy/MM/dd'/>" style="padding-left: 0px;" />
				</td>
				<th><label class="required">随访医生</label></th>
				<td>
					<ehr:staff-list reg='{"required":true}' name="supervisionDoctor" value="${prenatalFollowup.supervisionDoctor}" defaultval="Y" style="width:30%"/>
				</td>
			</tr>
		</table>
	</div>
	</form>
</div>