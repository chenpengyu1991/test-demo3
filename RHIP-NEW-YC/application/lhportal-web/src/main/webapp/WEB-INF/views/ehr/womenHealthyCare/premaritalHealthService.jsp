<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/views/ehrbrowser/basic/basic.css" />
<div class="rightnav">
	<table>
		<tr>
	      	<td class="crumbs"><div id="location" parentMenu="women-health" childMenu="premaritalHealthService">当前位置:&gt;&gt;妇女保健&gt;&gt;婚前保健服务</div>
			</td>
	  	</tr>
	 </table>
<div style="background-color: white;">
	<ul>
		<li style="text-align: center; font-size: 25px;">婚前保健服务</li>
	</ul>
	<br/>
	<div class="table-basic">
		<table>
			<colgroup>
				<col style="width: 20%;"/>
	            <col style="width: 30%;"/>
				<col style="width: 20%;"/>
	            <col style="width: 30%;"/>
			</colgroup>
			<tr>
				<th>姓名</th>
				<td>
					<c:out value="${premaritalHealthService.name}"></c:out>
				</td>
				<th>出生日期</th>
				<td>
					<fmt:formatDate value="${premaritalHealthService.birthday}" pattern="yyyy/MM/dd"/>
				</td>
			</tr>
			<tr>
				<th>身份证件类别</th>
				<td>
					<ehr:dic code="${premaritalHealthService.nation}" dicmeta="CV0201101"></ehr:dic>
				</td>
				<th>身份证件号码</th>
				<td>
					<c:out value="${premaritalHealthService.idCard}"></c:out>
				</td>
			</tr>
			<tr>
				<th>本人电话号码</th>
				<td>
					<c:out value="${premaritalHealthService.phoneNumber}" />
				</td>
				<th>文化程度</th>
				<td>
					<ehr:dic code="${premaritalHealthService.education}" dicmeta="GBT46582006"></ehr:dic>
				</td>
			</tr>
			<tr>
				<th>职业类别</th>
				<td>
					<ehr:dic code="${premaritalHealthService.occupation}" dicmeta="GBT6565"></ehr:dic>
				</td>
				<th>工作单位名称</th>
				<td>
					<c:out value="${premaritalHealthService.unitName}" />
				</td>
			</tr>
			<tr>
				<th>户籍地址</th>
				<td colspan="3">
					<c:out value="${premaritalHealthService.hrprovince}"></c:out>
					<c:out value="${premaritalHealthService.hrcity}"></c:out>
					<c:out value="${premaritalHealthService.hrcounty}"></c:out>
					<c:out value="${premaritalHealthService.hrtownShip}"></c:out>
					<c:out value="${premaritalHealthService.hrstreet}"></c:out>
					<c:out value="${premaritalHealthService.hrhouseNumber}"></c:out>
				</td>
			</tr>
			<tr>
				<th>户籍地址邮政编码</th>
				<td colspan="3">
					<c:out value="${premaritalHealthService.hrpostCode}"></c:out>
				</td>
			</tr>
			<tr>
				<th>现住址</th>
				<td colspan="3">
					<c:out value="${premaritalHealthService.paprovince}"></c:out>
					<c:out value="${premaritalHealthService.pacity}"></c:out>
					<c:out value="${premaritalHealthService.pacounty}"></c:out>
					<c:out value="${premaritalHealthService.patownShip}"></c:out>
					<c:out value="${premaritalHealthService.pastreet}"></c:out>
					<c:out value="${premaritalHealthService.pahouseNumber}"></c:out>
				</td>
			</tr>
			<tr>
				<th>现住址邮政编码</th>
				<td colspan="3">
					<c:out value="${premaritalHealthService.papostCode}"></c:out>
				</td>
			</tr>
			<tr>
				<th>身高(cm)</th>
				<td><c:out value="${premaritalHealthService.height}"></c:out></td>
				<th>体重(kg)</th>
				<td><c:out value="${premaritalHealthService.bodyWeight}"></c:out></td>
			</tr>
			<tr>
				<th >血型</th>
				<td><ehr:dic code="${premaritalHealthService.aboBloodType}" dicmeta="CV0450005"></ehr:dic></td>
				<th>Rh血型</th>
				<td><ehr:dic code="${premaritalHealthService.rhBloodType}" dicmeta="FS10010"></ehr:dic></td>
			</tr>
			<tr>
				<th>血缘关系</th>
				<td colspan="3">
					<ehr:dic code="${premaritalHealthService.bloodRelation}" dicmeta="CV0201201"></ehr:dic>
				</td>
			</tr>
			<tr>
				<th>现病史</th>
				<td colspan="3">
					<c:out value="${premaritalHealthService.presentHistory}"></c:out>
				</td>
			</tr>
			<tr>
				<th>既往疾病史</th>
				<td colspan="3">
					<c:out value="${premaritalHealthService.pastMedicalHistory}"></c:out>
				</td>
			</tr>
			<tr>
				<th>手术史</th>
				<td colspan="3">
					<c:out value="${premaritalHealthService.operationHistory}"></c:out>
				</td>
			</tr>
			<tr>
				<th>家族遗传性疾病史</th>
				<td colspan="3">
					<c:out value="${premaritalHealthService.familyGeneDiseaseHistory}"></c:out>
				</td>
			</tr>
			<tr>
				<th>患者与本人关系</th>
				<td colspan="3">
					<ehr:dic code="${premaritalHealthService.patientRelation}" dicmeta="GBT4761"/>
				</td>
			</tr>
			<tr>
				<th>初潮年龄(岁)</th>
				<td>
					<c:out value="${premaritalHealthService.menarcheAge}"></c:out>
				</td>
				<th>月经持续时间(d)</th>
				<td>
					<c:out value="${premaritalHealthService.menstrualDuration}"></c:out>
				</td>
			</tr>
			<tr>
				<th>月经周期(d)</th>
				<td>
					<c:out value="${premaritalHealthService.menstrualCycle}"></c:out>
				</td>
				<th>月经出血量</th>
				<td>
					<ehr:dic code="${premaritalHealthService.menstrualBleedingType}" dicmeta="FS10028"></ehr:dic>
				</td>
			</tr>
			<tr>
				<th>痛经程度</th>
				<td>
					<ehr:dic code="${premaritalHealthService.dysmenorrheaDegree}" dicmeta="FS10041"></ehr:dic>
				</td>
				<th>末次月经日期</th>
				<td>
					<fmt:formatDate value="${premaritalHealthService.lastMenstrualDate}" pattern="yyyy/MM/dd"/>
				</td>
			</tr>
			<tr>
				<th>足月产次数</th>
				<td>
					<c:out value="${premaritalHealthService.fullTermTimes}"></c:out>
				</td>
				<th>早产次数</th>
				<td>
					<c:out value="${premaritalHealthService.prematureDeliveryTimes}"></c:out>
				</td>
			</tr>
			<tr>
				<th>流产总次数</th>
				<td>
					<c:out value="${premaritalHealthService.abortionTimes}"></c:out>
				</td>
				<th>婚姻状况</th>
				<td>
					<ehr:dic code="${premaritalHealthService.marriage}" dicmeta="GBT226122003"></ehr:dic>
				</td>
			</tr>
			<tr>
				<th>生育女数</th>
				<td>
					<c:out value="${premaritalHealthService.birthWomenNumber}"></c:out>
				</td>
				<th>生育子数</th>
				<td>
					<c:out value="${premaritalHealthService.birthFertilityNumber}"></c:out>
				</td>
			</tr>
			<tr>
				<th>子女患遗传性疾病情况</th>
				<td colspan="3">
					<c:out value="${premaritalHealthService.geneticDiseaseState}"></c:out>
				</td>
			</tr>
			<tr>
				<th>家族近亲婚配标志|</th>
				<td>
                    <c:if test="${!empty premaritalHealthService.familyMarriageFlag}">
					    <c:out value='${premaritalHealthService.familyMarriageFlag eq "1" ? "是" : "否"}'></c:out>
                    </c:if>
				</td>
				<th>家族近亲婚配者与本人关系</th>
				<td>
					<ehr:dic code="${premaritalHealthService.familyKinMarriageRelation}" dicmeta="CV0210001"></ehr:dic>
				</td>
			</tr>
			<tr>
				<th>舒张压(mmHg)</th>
				<td>
					<c:out value="${premaritalHealthService.dbp}" ></c:out>
				</td>
				<th>收缩压(mmHg)</th>
				<td>
					<c:out value="${premaritalHealthService.sbp}" ></c:out>
				</td>
			</tr>
			<tr>
				<th>特殊体态检查结果</th>
				<td colspan="3">
					<c:out value="${premaritalHealthService.specialBodyCheckResult}" ></c:out>
				</td>
			</tr>
			<tr>
				<th>精神状态</th>
				<td colspan="3">
					<ehr:dic code="${premaritalHealthService.mentalStateCode}" dicmeta="FS10210"></ehr:dic>
				</td>
			</tr>
			<tr>
				<th>智力发育</th>
				<td colspan="3">
					<c:out value="${premaritalHealthService.mentalDevelopment}"/>
				</td>
			</tr>
			<tr>
				<th>特殊面容检查结果</th>
				<td colspan="3">
					<c:out value="${premaritalHealthService.specialFaceCheckResult}"/>
				</td>
			</tr>
			<tr>
				<th>五官检查结果</th>
				<td colspan="3">
					<c:out value="${premaritalHealthService.facialFeaturesCheckResult}"/>
				</td>
			</tr>
			<tr>
				<th>心律</th>
				<td>
					<c:out value="${premaritalHealthService.cardioverter}" ></c:out>
				</td>
				<th>心率(次/分钟)</th>
				<td>
					<c:out value="${premaritalHealthService.heartRate}" ></c:out>
				</td>
			</tr>
			<tr>
				<th>心脏听诊结果</th>
				<td colspan="3">
					<c:out value="${premaritalHealthService.cardiacAuscuResult}"></c:out>
				</td>
			</tr>
			<tr>
				<th>肺部听诊结果</th>
				<td colspan="3">
					<c:out value="${premaritalHealthService.lungAuscuResult}"></c:out>
				</td>
			</tr>
			<tr>
				<th>肝脏触诊结果</th>
				<td colspan="3">
					<c:out value="${premaritalHealthService.liverPalpResult}"></c:out>
				</td>
			</tr>
			<tr>
				<th>四肢检查结果</th>
				<td colspan="3">
					<c:out value="${premaritalHealthService.limbsCheckResult}"></c:out>
				</td>
			</tr>
			<tr>
				<th>脊柱检查结果</th>
				<td colspan="3">
					<c:out value="${premaritalHealthService.spineCheckResult}"></c:out>
				</td>
			</tr>
			<tr>
				<th>皮肤毛发检查结果</th>
				<td colspan="3">
					<c:out value="${premaritalHealthService.skinHairCheckResult}"></c:out>
				</td>
			</tr>
			<tr>
				<th>甲状腺检查结果</th>
				<td colspan="3">
					<c:out value="${premaritalHealthService.thyroidCheckResult}"></c:out>
				</td>
			</tr>
			<tr>
				<th>精索静脉曲张标志</th>
				<td <c:if test='${premaritalHealthService.varicoceleFlag ne "1"}'> colspan="3" </c:if> >
                    <c:if test="${!empty premaritalHealthService.varicoceleFlag}">
					    <c:out value='${premaritalHealthService.varicoceleFlag eq "1" ? "是" : "否"}'></c:out>
                    </c:if>
				</td>
				<c:if test='${premaritalHealthService.varicoceleFlag eq "1"}'>
					<th>精索静脉曲张程度</th>
					<td>
						<ehr:dic code="${premaritalHealthService.varicoceleDegree}" dicmeta="CV510201"></ehr:dic>
					</td>
				</c:if>
			</tr>
			<c:if test='${premaritalHealthService.varicoceleFlag eq "1"}'>
				<tr>
					<th>精索静脉曲张部位</th>
					<td colspan="3">
						<c:out value="${premaritalHealthService.varicocelePart}"></c:out>
					</td>
				</tr>
			</c:if>
			<tr>
				<th>妇科检查方式</th>
				<td>
					<ehr:dic code="${premaritalHealthService.gynaecologyExamWay}" dicmeta="CV0410003"/>
				</td>
				<th>知情同意标志</th>
				<td>
                    <c:if test="${!empty premaritalHealthService.informedConsentFlag}">
					    <c:out value='${premaritalHealthService.informedConsentFlag eq "1" ? "是" : "否"}'></c:out>
                    </c:if>
				</td>
			</tr>
			<tr>
				<th>阴毛检查结果</th>
				<td colspan="3">
					<c:out value="${premaritalHealthService.pubesCheckResult}"></c:out>
				</td>
			</tr>
			<tr>
				<th>外阴检查结果</th>
				<td colspan="3">
					<c:out value="${premaritalHealthService.vulvaCheckResult}"></c:out>
				</td>
			</tr>
			<tr>
				<th>阴道检查结果</th>
				<td colspan="3">
					<c:out value="${premaritalHealthService.vaginaCheckResult}"></c:out>
				</td>
			</tr>
			<tr>
				<th>阴道分泌物性状描述</th>
				<td colspan="3">
					<c:out value="${premaritalHealthService.vaginaSecretionsDesc}"></c:out>
				</td>
			</tr>
			<tr>
				<th>子宫检查结果</th>
				<td colspan="3">
					<c:out value="${premaritalHealthService.uterusCheckResult}"></c:out>
				</td>
			</tr>
			<tr>
				<th>宫颈检查结果</th>
				<td colspan="3">
					<c:out value="${premaritalHealthService.cervixCheckResult}"></c:out>
				</td>
			</tr>
			<tr>
				<th>胸部X线检查结果</th>
				<td colspan="3">
					<c:out value="${premaritalHealthService.chestXCheckResult}"></c:out>
				</td>
			</tr>
			<tr>
				<th>白细胞分类结果</th>
				<td colspan="3">
					<c:out value="${premaritalHealthService.leukocyteType}"></c:out>
				</td>
			</tr>
			<tr>
				<th>左侧乳腺检查结果</th>
				<td>
					<ehr:dic code="${premaritalHealthService.lBreastCheckResult}" dicmeta="CV0410012"/>
				</td>
				<th>右侧乳腺检查结果</th>
				<td>
					<ehr:dic code="${premaritalHealthService.rBreastCheckResult}" dicmeta="CV0410012"/>
				</td>
			</tr>
			<tr>
				<th>白细胞计数值(G/L)</th>
				<td>
					<c:out value="${premaritalHealthService.leukocyteCount}" ></c:out>
				</td>
				<th>红细胞计数值(G/L)</th>
				<td>
					<c:out value="${premaritalHealthService.erythrocyteCount}" ></c:out>
				</td>
			</tr>
			<tr>
				<th>血红蛋白值(g/L)</th>
				<td>
					<c:out value="${premaritalHealthService.hemoglobinValue}" ></c:out>
				</td>
				<th>血小板计数值(G/L)</th>
				<td>
					<c:out value="${premaritalHealthService.plateletCount}" ></c:out>
				</td>
			</tr>
			<tr>
				<th>尿比重</th>
				<td>
					<c:out value="${premaritalHealthService.urineProportion}" ></c:out>
				</td>
				<th>尿蛋白定量检测值(mg/24h)</th>
				<td>
					<c:out value="${premaritalHealthService.urineProQuantitativeValue}" ></c:out>
				</td>
			</tr>
			<tr>
				<th>尿糖定量检测(mmol/L)</th>
				<td>
					<c:out value="${premaritalHealthService.urineSugQuantitativeDetect}" ></c:out>
				</td>
				<th>尿液酸碱度</th>
				<td>
					<c:out value="${premaritalHealthService.urinePh}" ></c:out>
				</td>
			</tr>
			<tr>
				<th>血清谷丙转氨酶值(U/L)</th>
				<td>
					<c:out value="${premaritalHealthService.serumGptValue}" ></c:out>
				</td>
				<th>乙型肝炎病毒表面抗原检测结果</th>
				<td>
					<ehr:dic code="${premaritalHealthService.urinePh}" dicmeta="FS10092"></ehr:dic>
				</td>
			</tr>
			<tr>
				<th>淋球菌检查结果</th>
				<td colspan="3">
					<c:out value="${premaritalHealthService.nGonorrhoeaeCheckResult}"></c:out>
				</td>
			</tr>
			<tr>
				<th>梅毒血清学试验结果</th>
				<td>
					<ehr:dic code="${premaritalHealthService.syphilisSerologyCheckResult}" dicmeta="FS10058"/>
				</td>
				<th>HIV抗体检测结果</th>
				<td>
					<c:out value="${premaritalHealthService.hivlgDetectResult}"></c:out>
				</td>
			</tr>
			<tr>
				<th>滴虫检测结果</th>
				<td>
					<ehr:dic code="${premaritalHealthService.trichomoDetectResult}" dicmeta="FS10045"/>
				</td>
				<th>念珠菌检测结果</th>
				<td>
					<ehr:dic code="${premaritalHealthService.candidaDetectResult}" dicmeta="FS10044"/>
				</td>
			</tr>
			<tr>
				<th>阴道分泌物清洁度</th>
				<td>
					<ehr:dic code="${premaritalHealthService.vaginaSecretionsCleanliness}" dicmeta="CV0450010"/>
				</td>
				<th>疾病诊断</th>
				<td>
					<ehr:dic code="${premaritalHealthService.diseaseDiagnosisCode}" dicmeta="CV550220"/>
				</td>
			</tr>
			<tr>
				<th>婚前医学检查结果</th>
				<td>
					<ehr:dic code="${premaritalHealthService.preMedicalCheckResult}" dicmeta="CV0510005"/>
				</td>
				<th>婚检医学意见</th>
				<td>
					<ehr:dic code="${premaritalHealthService.preMedicalOpinion}" dicmeta="CV0600210"/>
				</td>
			</tr>
			<tr>
				<th>婚前卫生指导</th>
				<td colspan="3">
					<c:out value="${premaritalHealthService.preHealthGuidance}"></c:out>
				</td>
			</tr>
			<tr>
				<th>婚前卫生咨询</th>
				<td colspan="3">
					<c:out value="${premaritalHealthService.preHealthAdvisory}"></c:out>
				</td>
			</tr>
			<tr>
				<th>婚检咨询指导结果</th>
				<td colspan="3">
					<ehr:dic code="${premaritalHealthService.preConsultationGuidResult}" dicmeta="FS10027"/>
				</td>
			</tr>
			<tr>
				<th>检查(测)日期</th>
				<td>
					<fmt:formatDate value="${premaritalHealthService.checkDate}" pattern="yyyy/MM/dd" />
				</td>
				<th>检查(测)人员姓名</th>
				<td>
					<c:out value="${premaritalHealthService.checkName}"></c:out>
				</td>
			</tr>
			<tr>
				<th>检查(测)机构名称</th>
				<td colspan="3">
					<c:out value="${premaritalHealthService.checkOrganName}" />
				</td>
			</tr>
			<tr>
				<th>填报日期</th>
				<td colspan="3">
					<fmt:formatDate value="${premaritalHealthService.fillDate}" pattern="yyyy/MM/dd" />
				</td>
			</tr>
			<tr>
				<th>首诊医师姓名</th>
				<td>
					<c:out value="${premaritalHealthService.firstVisitDoctorName}" />
				</td>
				<th>主检医师姓名</th>
				<td>
					<c:out value="${premaritalHealthService.masterDoctorName}"></c:out>
				</td>
			</tr>
			<tr>
				<th>转诊日期</th>
				<td>
					<fmt:formatDate value="${premaritalHealthService.referralDate}" pattern="yyyy/MM/dd" />
				</td>
				<th>转入医院名称</th>
				<td>
					<c:out value="${premaritalHealthService.referralHospitalName}"></c:out>
				</td>
			</tr>
			<tr>
				<th>预约日期</th>
				<td>
					<fmt:formatDate value="${premaritalHealthService.reserveDate}" pattern="yyyy/MM/dd" />
				</td>
				<th>出具《婚前医学检查证明》日期</th>
				<td>
					<fmt:formatDate value="${premaritalHealthService.issuedDate}" pattern="yyyy/MM/dd" />
				</td>
			</tr>
		</table>
		<br/>
		<br/>
		男性：
		<table>
			<tr>
				<th>阴茎检查结果</th>
				<td colspan="3">
					<c:out value="${premaritalHealthService.penisCheckResult}"></c:out>
				</td>
			</tr>
			<tr>
				<th>包皮检查结果</th>
				<td colspan="3">
					<ehr:dic code="${premaritalHealthService.prepuceCheckResult}" dicmeta="FS10047"/>
				</td>
			</tr>
			<tr>
				<th>左侧睾丸检查结果</th>
				<td>
					<ehr:dic code="${premaritalHealthService.lTestisCheckResult}" dicmeta="FS10047"/>
				</td>
				<th>右侧睾丸检查结果</th>
				<td>
					<ehr:dic code="${premaritalHealthService.rTestisCheckResult}" dicmeta="FS10047"/>
				</td>
			</tr>
			<tr>
				<th>左侧附睾检查结果</th>
				<td>
					<ehr:dic code="${premaritalHealthService.lEpididymisCheckResult}" dicmeta="FS10047"/>
				</td>
				<th>右侧附睾检查结果</th>
				<td>
					<ehr:dic code="${premaritalHealthService.rEpididymisCheckResult}" dicmeta="FS10047"/>
				</td>
			</tr>
			<tr>
				<th>附睾异常情况</th>
				<td colspan="3">
					<c:out value="${premaritalHealthService.lEpididymisCheckResult}" />
				</td>
			</tr>
			<tr>
				<th>喉结检查结果</th>
				<td colspan="3">
					<c:out value="${premaritalHealthService.adamAppleCheckResult}" />
				</td>
			</tr>
		</table>
	</div>
</div>
</div>