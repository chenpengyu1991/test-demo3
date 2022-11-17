<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/views/ehrbrowser/basic/basic.css" />

<div style="background-color: white; height: 515px;">
	<ul>
		<li style="text-align: center; font-size: 25px;">婚前保健服务</li>
	</ul>
	<br/>
	<div class="table-basic">
		<table class="layui-table x-admin-sm-table-list-small">
			<colgroup>
				<col style="width: 20%;"/>
				<col style="width: 30%;"/>
				<col style="width: 20%;"/>
				<col style="width: 30%;"/>
			</colgroup>
			<tr>
				<th>姓名</th>
				<td>
					<c:out value="${detailInfo.name}"></c:out>
				</td>
				<th>出生日期</th>
				<td>
					<fmt:formatDate value="${detailInfo.birthday}" pattern="yyyy/MM/dd"/>
				</td>
			</tr>
			<tr>
				<th>身份证件类别</th>
				<td>
					<span><ehr:dic code="${detailInfo.nation}" dicmeta="CV0201101"></ehr:dic></span>
				</td>
				<th>身份证件号码</th>
				<td>
					<c:out value="${detailInfo.idCard}"></c:out>
				</td>
			</tr>
			<tr>
				<th>本人电话号码</th>
				<td>
					<c:out value="${detailInfo.phoneNumber}" />
				</td>
				<th>文化程度</th>
				<td>
					<span><ehr:dic code="${detailInfo.education}" dicmeta="GBT46582006"></ehr:dic></span>
				</td>
			</tr>
			<tr>
				<th>职业类别</th>
				<td>
					<span><ehr:dic code="${detailInfo.occupation}" dicmeta="GBT6565"></ehr:dic></span>
				</td>
				<th>工作单位名称</th>
				<td>
					<c:out value="${detailInfo.unitName}" />
				</td>
			</tr>
			<tr>
				<th>户籍地址</th>
				<td colspan="3">
					<c:out value="${detailInfo.hrprovince}"></c:out>
					<c:out value="${detailInfo.hrcity}"></c:out>
					<c:out value="${detailInfo.hrcounty}"></c:out>
					<c:out value="${detailInfo.hrtownShip}"></c:out>
					<c:out value="${detailInfo.hrstreet}"></c:out>
					<c:out value="${detailInfo.hrhouseNumber}"></c:out>
				</td>
			</tr>
			<tr>
				<th>户籍地址邮政编码</th>
				<td colspan="3">
					<c:out value="${detailInfo.hrpostCode}"></c:out>
				</td>
			</tr>
			<tr>
				<th>现住址</th>
				<td colspan="3">
					<c:out value="${detailInfo.paprovince}"></c:out>
					<c:out value="${detailInfo.pacity}"></c:out>
					<c:out value="${detailInfo.pacounty}"></c:out>
					<c:out value="${detailInfo.patownShip}"></c:out>
					<c:out value="${detailInfo.pastreet}"></c:out>
					<c:out value="${detailInfo.pahouseNumber}"></c:out>
				</td>
			</tr>
			<tr>
				<th>现住址邮政编码</th>
				<td colspan="3">
					<c:out value="${detailInfo.papostCode}"></c:out>
				</td>
			</tr>
			<tr>
				<th>身高(cm)</th>
				<td><c:out value="${detailInfo.height}"></c:out></td>
				<th>体重(kg)</th>
				<td><c:out value="${detailInfo.bodyWeight}"></c:out></td>
			</tr>
			<tr>
				<th>血型</th>
				<td><span><ehr:dic code="${detailInfo.aboBloodType}" dicmeta="CV0450005"></ehr:dic></span></td>
				<th>Rh血型</th>
				<td><span><ehr:dic code="${detailInfo.rhBloodType}" dicmeta="FS10010"></ehr:dic></span></td>
			</tr>
			<tr>
				<th>血缘关系</th>
				<td colspan="3">
					<span><ehr:dic code="${detailInfo.bloodRelation}" dicmeta="CV0201201"></ehr:dic></span>
				</td>
			</tr>
			<tr>
				<th>现病史</th>
				<td colspan="3">
					<c:out value="${detailInfo.presentHistory}"></c:out>
				</td>
			</tr>
			<tr>
				<th>既往疾病史</th>
				<td colspan="3">
					<c:out value="${detailInfo.pastMedicalHistory}"></c:out>
				</td>
			</tr>
			<tr>
				<th>手术史</th>
				<td colspan="3">
					<c:out value="${detailInfo.operationHistory}"></c:out>
				</td>
			</tr>
			<tr>
				<th>家族遗传性疾病史</th>
				<td colspan="3">
					<c:out value="${detailInfo.familyGeneDiseaseHistory}"></c:out>
				</td>
			</tr>
			<tr>
				<th>患者与本人关系</th>
				<td colspan="3">
					<span><ehr:dic code="${detailInfo.patientRelation}" dicmeta="GBT4761"/></span>
				</td>
			</tr>
			<tr>
				<th>初潮年龄(岁)</th>
				<td>
					<c:out value="${detailInfo.menarcheAge}"></c:out>
				</td>
				<th>月经持续时间(d)</th>
				<td>
					<c:out value="${detailInfo.menstrualDuration}"></c:out>
				</td>
			</tr>
			<tr>
				<th>月经周期(d)</th>
				<td>
					<c:out value="${detailInfo.menstrualCycle}"></c:out>
				</td>
				<th>月经出血量</th>
				<td>
					<span><ehr:dic code="${detailInfo.menstrualBleedingType}" dicmeta="FS10028"></ehr:dic></span>
				</td>
			</tr>
			<tr>
				<th>痛经程度</th>
				<td>
					<span><ehr:dic code="${detailInfo.dysmenorrheaDegree}" dicmeta="FS10041"></ehr:dic></span>
				</td>
				<th>末次月经日期</th>
				<td>
					<fmt:formatDate value="${detailInfo.lastMenstrualDate}" pattern="yyyy/MM/dd"/>
				</td>
			</tr>
			<tr>
				<th>足月产次数</th>
				<td>
					<c:out value="${detailInfo.fullTermTimes}"></c:out>
				</td>
				<th>早产次数</th>
				<td>
					<c:out value="${detailInfo.prematureDeliveryTimes}"></c:out>
				</td>
			</tr>
			<tr>
				<th>流产总次数</th>
				<td>
					<c:out value="${detailInfo.abortionTimes}"></c:out>
				</td>
				<th>婚姻状况</th>
				<td>
					<span><ehr:dic code="${detailInfo.marriage}" dicmeta="GBT226122003"></ehr:dic></span>
				</td>
			</tr>
			<tr>
				<th>生育女数</th>
				<td>
					<c:out value="${detailInfo.birthWomenNumber}"></c:out>
				</td>
				<th>生育子数</th>
				<td>
					<c:out value="${detailInfo.birthFertilityNumber}"></c:out>
				</td>
			</tr>
			<tr>
				<th>子女患遗传性疾病情况</th>
				<td colspan="3">
					<c:out value="${detailInfo.geneticDiseaseState}"></c:out>
				</td>
			</tr>
			<tr>
				<th>家族近亲婚配标志</th>
				<td>
					<c:if test="${!empty detailInfo.familyMarriageFlag}">
						<c:out value='${detailInfo.familyMarriageFlag eq "1" ? "是" : "否"}'></c:out>
					</c:if>
				</td>
				<th>家族近亲婚配者与本人关系</th>
				<td>
					<span><ehr:dic code="${detailInfo.familyKinMarriageRelation}" dicmeta="CV0210001"></ehr:dic></span>
				</td>
			</tr>
			<tr>
				<th>舒张压(mmHg)</th>
				<td>
					<c:out value="${detailInfo.dbp}" ></c:out>
				</td>
				<th>收缩压(mmHg)</th>
				<td>
					<c:out value="${detailInfo.sbp}" ></c:out>
				</td>
			</tr>
			<tr>
				<th>特殊体态检查结果</th>
				<td colspan="3">
					<c:out value="${detailInfo.specialBodyCheckResult}" ></c:out>
				</td>
			</tr>
			<tr>
				<th>精神状态</th>
				<td colspan="3">
					<span><ehr:dic code="${detailInfo.mentalStateCode}" dicmeta="FS10210"></ehr:dic></span>
				</td>
			</tr>
			<tr>
				<th>智力发育</th>
				<td colspan="3">
					<c:out value="${detailInfo.mentalDevelopment}"/>
				</td>
			</tr>
			<tr>
				<th>特殊面容检查结果</th>
				<td colspan="3">
					<c:out value="${detailInfo.specialFaceCheckResult}"/>
				</td>
			</tr>
			<tr>
				<th>五官检查结果</th>
				<td colspan="3">
					<c:out value="${detailInfo.facialFeaturesCheckResult}"/>
				</td>
			</tr>
			<tr>
				<th>心律</th>
				<td>
					<c:out value="${detailInfo.cardioverter}" ></c:out>
				</td>
				<th>心率(次/分钟)</th>
				<td>
					<c:out value="${detailInfo.heartRate}" ></c:out>
				</td>
			</tr>
			<tr>
				<th>心脏听诊结果</th>
				<td colspan="3">
					<c:out value="${detailInfo.cardiacAuscuResult}"></c:out>
				</td>
			</tr>
			<tr>
				<th>肺部听诊结果</th>
				<td colspan="3">
					<c:out value="${detailInfo.lungAuscuResult}"></c:out>
				</td>
			</tr>
			<tr>
				<th>肝脏触诊结果</th>
				<td colspan="3">
					<c:out value="${detailInfo.liverPalpResult}"></c:out>
				</td>
			</tr>
			<tr>
				<th>四肢检查结果</th>
				<td colspan="3">
					<c:out value="${detailInfo.limbsCheckResult}"></c:out>
				</td>
			</tr>
			<tr>
				<th>脊柱检查结果</th>
				<td colspan="3">
					<c:out value="${detailInfo.spineCheckResult}"></c:out>
				</td>
			</tr>
			<tr>
				<th>皮肤毛发检查结果</th>
				<td colspan="3">
					<c:out value="${detailInfo.skinHairCheckResult}"></c:out>
				</td>
			</tr>
			<tr>
				<th>甲状腺检查结果</th>
				<td colspan="3">
					<c:out value="${detailInfo.thyroidCheckResult}"></c:out>
				</td>
			</tr>
			<tr>
				<th>精索静脉曲张标志</th>
				<td <c:if test='${detailInfo.varicoceleFlag ne "1"}'> colspan="3" </c:if> >
					<c:if test="${!empty detailInfo.varicoceleFlag}">
						<c:out value='${detailInfo.varicoceleFlag eq "1" ? "是" : "否"}'></c:out>
					</c:if>
				</td>
				<c:if test='${detailInfo.varicoceleFlag eq "1"}'>
					<th>精索静脉曲张程度</th>
					<td>
						<span><ehr:dic code="${detailInfo.varicoceleDegree}" dicmeta="CV510201"></ehr:dic></span>
					</td>
				</c:if>
			</tr>
			<c:if test='${detailInfo.varicoceleFlag eq "1"}'>
				<tr>
					<th>精索静脉曲张部位</th>
					<td colspan="3">
						<c:out value="${detailInfo.varicocelePart}"></c:out>
					</td>
				</tr>
			</c:if>
			<tr>
				<th>妇科检查方式</th>
				<td>
					<span><ehr:dic code="${detailInfo.gynaecologyExamWay}" dicmeta="CV0410003"/></span>
				</td>
				<th>知情同意标志</th>
				<td>
					<c:if test="${!empty detailInfo.informedConsentFlag}">
						<c:out value='${detailInfo.informedConsentFlag eq "1" ? "是" : "否"}'></c:out>
					</c:if>
				</td>
			</tr>
			<tr>
				<th>阴毛检查结果</th>
				<td colspan="3">
					<c:out value="${detailInfo.pubesCheckResult}"></c:out>
				</td>
			</tr>
			<tr>
				<th>外阴检查结果</th>
				<td colspan="3">
					<c:out value="${detailInfo.vulvaCheckResult}"></c:out>
				</td>
			</tr>
			<tr>
				<th>阴道检查结果</th>
				<td colspan="3">
					<c:out value="${detailInfo.vaginaCheckResult}"></c:out>
				</td>
			</tr>
			<tr>
				<th>阴道分泌物性状描述</th>
				<td colspan="3">
					<c:out value="${detailInfo.vaginaSecretionsDesc}"></c:out>
				</td>
			</tr>
			<tr>
				<th>子宫检查结果</th>
				<td colspan="3">
					<c:out value="${detailInfo.uterusCheckResult}"></c:out>
				</td>
			</tr>
			<tr>
				<th>宫颈检查结果</th>
				<td colspan="3">
					<c:out value="${detailInfo.cervixCheckResult}"></c:out>
				</td>
			</tr>
			<tr>
				<th>胸部X线检查结果</th>
				<td colspan="3">
					<c:out value="${detailInfo.chestXCheckResult}"></c:out>
				</td>
			</tr>
			<tr>
				<th>白细胞分类结果</th>
				<td colspan="3">
					<c:out value="${detailInfo.leukocyteType}"></c:out>
				</td>
			</tr>
			<tr>
				<th>左侧乳腺检查结果</th>
				<td>
					<span><ehr:dic code="${detailInfo.lBreastCheckResult}" dicmeta="CV0410012"/></span>
				</td>
				<th>右侧乳腺检查结果</th>
				<td>
					<span><ehr:dic code="${detailInfo.rBreastCheckResult}" dicmeta="CV0410012"/></span>
				</td>
			</tr>
			<tr>
				<th>白细胞计数值(G/L)</th>
				<td>
					<c:out value="${detailInfo.leukocyteCount}" ></c:out>
				</td>
				<th>红细胞计数值(G/L)</th>
				<td>
					<c:out value="${detailInfo.erythrocyteCount}" ></c:out>
				</td>
			</tr>
			<tr>
				<th>血红蛋白值(g/L)</th>
				<td>
					<c:out value="${detailInfo.hemoglobinValue}" ></c:out>
				</td>
				<th>血小板计数值(G/L)</th>
				<td>
					<c:out value="${detailInfo.plateletCount}" ></c:out>
				</td>
			</tr>
			<tr>
				<th>尿比重</th>
				<td>
					<c:out value="${detailInfo.urineProportion}" ></c:out>
				</td>
				<th>尿蛋白定量检测值(mg/24h)</th>
				<td>
					<c:out value="${detailInfo.urineProQuantitativeValue}" ></c:out>
				</td>
			</tr>
			<tr>
				<th>尿糖定量检测(mmol/L)</th>
				<td>
					<c:out value="${detailInfo.urineSugQuantitativeDetect}" ></c:out>
				</td>
				<th>尿液酸碱度</th>
				<td>
					<c:out value="${detailInfo.urinePh}" ></c:out>
				</td>
			</tr>
			<tr>
				<th>血清谷丙转氨酶值(U/L)</th>
				<td>
					<c:out value="${detailInfo.serumGptValue}" ></c:out>
				</td>
				<th>乙型肝炎病毒表面抗原检测结果</th>
				<td>
					<span>${detailInfo.urinePh}<ehr:dic code="${detailInfo.hbsagDetectResult}" dicmeta="FS10092"></ehr:dic></span>
				</td>
			</tr>
			<tr>
				<th>淋球菌检查结果</th>
				<td colspan="3">
					<c:out value="${detailInfo.nGonorrhoeaeCheckResult}"></c:out>
				</td>
			</tr>
			<tr>
				<th>梅毒血清学试验结果</th>
				<td>
					<span><ehr:dic code="${detailInfo.syphilisSerologyCheckResult}" dicmeta="FS10058"/></span>
				</td>
				<th>HIV抗体检测结果</th>
				<td>
					<span><ehr:dic code="${detailInfo.hivlgDetectResult}" dicmeta="FS10056"/></span>
				</td>
			</tr>
			<tr>
				<th>滴虫检测结果</th>
				<td>
					<span><ehr:dic code="${detailInfo.trichomoDetectResult}" dicmeta="FS10045"/></span>
				</td>
				<th>念珠菌检测结果</th>
				<td>
					<span><ehr:dic code="${detailInfo.candidaDetectResult}" dicmeta="FS10044"/></span>
				</td>
			</tr>
			<tr>
				<th>阴道分泌物清洁度</th>
				<td>
					<span><ehr:dic code="${detailInfo.vaginaSecretionsCleanliness}" dicmeta="CV0450010"/></span>
				</td>
				<th>疾病诊断</th>
				<td>
					<ehr:dic code="${detailInfo.diseaseDiagnosisCode}" dicmeta="CV550219"></ehr:dic>
				</td>
			</tr>
			<tr>
				<th>婚前医学检查结果</th>
				<td>
					<span><ehr:dic code="${detailInfo.preMedicalCheckResult}" dicmeta="CV0510005"/></span>
				</td>
				<th>婚检医学意见</th>
				<td>
					<span><ehr:dic code="${detailInfo.preMedicalOpinion}" dicmeta="CV0600210"/></span>
				</td>
			</tr>
			<tr>
				<th>婚前卫生指导</th>
				<td colspan="3">
					<c:out value="${detailInfo.preHealthGuidance}"></c:out>
				</td>
			</tr>
			<tr>
				<th>婚前卫生咨询</th>
				<td colspan="3">
					<c:out value="${detailInfo.preHealthAdvisory}"></c:out>
				</td>
			</tr>
			<tr>
				<th>婚检咨询指导结果</th>
				<td colspan="3">
					<span><ehr:dic code="${detailInfo.preConsultationGuidResult}" dicmeta="FS10027"/></span>
				</td>
			</tr>
			<tr>
				<th>检查(测)日期</th>
				<td>
					<fmt:formatDate value="${detailInfo.checkDate}" pattern="yyyy/MM/dd" />
				</td>
				<th>检查(测)人员姓名</th>
				<td>
					<c:out value="${detailInfo.checkName}"></c:out>
				</td>
			</tr>
			<tr>
				<th>检查(测)机构名称</th>
				<td colspan="3">
					<c:out value="${detailInfo.checkOrganName}" />
				</td>
			</tr>
			<tr>
				<th>填报日期</th>
				<td colspan="3">
					<fmt:formatDate value="${detailInfo.fillDate}" pattern="yyyy/MM/dd" />
				</td>
			</tr>
			<tr>
				<th>首诊医师姓名</th>
				<td>
					<c:out value="${detailInfo.firstVisitDoctorName}" />
				</td>
				<th>主检医师姓名</th>
				<td>
					<c:out value="${detailInfo.masterDoctorName}"></c:out>
				</td>
			</tr>
			<tr>
				<th>转诊日期</th>
				<td>
					<fmt:formatDate value="${detailInfo.referralDate}" pattern="yyyy/MM/dd" />
				</td>
				<th>转入医院名称</th>
				<td>
					<c:out value="${detailInfo.referralHospitalName}"></c:out>
				</td>
			</tr>
			<tr>
				<th>预约日期</th>
				<td>
					<fmt:formatDate value="${detailInfo.reserveDate}" pattern="yyyy/MM/dd" />
				</td>
				<th>出具《婚前医学检查证明》日期</th>
				<td>
					<fmt:formatDate value="${detailInfo.issuedDate}" pattern="yyyy/MM/dd" />
				</td>
			</tr>
		</table>
		<br/>
		男性：
		<table>
			<colgroup>
				<col style="width: 20%;"/>
				<col style="width: 30%;"/>
				<col style="width: 20%;"/>
				<col style="width: 30%;"/>
			</colgroup>
			<tr>
				<th>阴茎检查结果</th>
				<td colspan="3">
					<c:out value="${detailInfo.penisCheckResult}"></c:out>
				</td>
			</tr>
			<tr>
				<th>包皮检查结果</th>
				<td colspan="3">
					<span><ehr:dic code="${detailInfo.prepuceCheckResult}" dicmeta="FS10047"/></span>
				</td>
			</tr>
			<tr>
				<th>左侧睾丸检查结果</th>
				<td>
					<span><ehr:dic code="${detailInfo.lTestisCheckResult}" dicmeta="FS10047"/></span>
				</td>
				<th>右侧睾丸检查结果</th>
				<td>
					<span><ehr:dic code="${detailInfo.rTestisCheckResult}" dicmeta="FS10047"/></span>
				</td>
			</tr>
			<tr>
				<th>左侧附睾检查结果</th>
				<td>
					<span><ehr:dic code="${detailInfo.lEpididymisCheckResult}" dicmeta="FS10047"/></span>
				</td>
				<th>右侧附睾检查结果</th>
				<td>
					<span><ehr:dic code="${detailInfo.rEpididymisCheckResult}" dicmeta="FS10047"/></span>
				</td>
			</tr>
			<tr>
				<th>附睾异常情况</th>
				<td colspan="3">
					<c:out value="${detailInfo.epididymalAbnormalities}" />
				</td>
			</tr>
			<tr>
				<th>喉结检查结果</th>
				<td colspan="3">
					<c:out value="${detailInfo.adamAppleCheckResult}" />
				</td>
			</tr>
		</table>
	</div>
</div>