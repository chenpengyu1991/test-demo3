<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>

<div>
	<ul>
		<li style="text-align: center; font-size: 25px;">孕产期保健服务与高危管理随访</li>
	</ul>
	<br>
	<div class="table-basic-narrow">
		女性：
		<table>
			<colgroup>
				<col style="width: 22%;"/>
	            <col style="width: 28%;"/>
				<col style="width: 22%;"/>
	            <col style="width: 28%;"/>
			</colgroup>
			<tr>
				<th>姓名</th>
				<td>
					<c:out value="${motherhoodPeriodFollowup.motherName}"></c:out>
				</td>
				<th>出生日期</th>
				<td>
					<fmt:formatDate value="${motherhoodPeriodFollowup.birthday}" pattern="yyyy/MM/dd"/>
				</td>
			</tr>
			<tr>
				<th>民族</th>
				<td>
					<ehr:dic code="${motherhoodPeriodFollowup.nation}" dicmeta="GBT3304"></ehr:dic>
				</td>
				<th>学历</th>
				<td>
					<ehr:dic code="${motherhoodPeriodFollowup.education}" dicmeta="GBT46582006"></ehr:dic>
				</td>
			</tr>
			<tr>
				<th>本人电话号码</th>
				<td>
					<c:out value="${motherhoodPeriodFollowup.phoneNumber}"></c:out>
				</td>
				<th>身份证件号码</th>
				<td>
					<c:out value="${motherhoodPeriodFollowup.idcard}" />
				</td>
			</tr>
			<%--
			<tr>
				<th>身份证件类别</th>
				<td>
					<ehr:dic code="${motherhoodPeriodFollowup.IdcardType}" dicmeta="CV0201101"></ehr:dic>
				</td>
			</tr>
			--%>
			<tr>
				<th>职业类别</th>
				<td>
					<ehr:dic code="${motherhoodPeriodFollowup.occupationType}" dicmeta="GBT6565"></ehr:dic>
				</td>
				<th>工作单位名称</th>
				<td>
					<c:out value="${motherhoodPeriodFollowup.unitName}" />
				</td>
			</tr>
			<tr>
				<th>配偶姓名</th>
				<td>
					<c:out value="${motherhoodPeriodFollowup.spouseName}"></c:out>
				</td>
				<th>配偶出生日期</th>
				<td>
					<fmt:formatDate value="${motherhoodPeriodFollowup.spouseBirthday}" pattern="yyyy/MM/dd"/>
				</td>
			</tr>
			<tr>
				<th>配偶民族</th>
				<td>
					<ehr:dic code="${motherhoodPeriodFollowup.spouseNation}" dicmeta="GBT3304"></ehr:dic>
				</td>
				<th>配偶学历</th>
				<td>
					<ehr:dic code="${motherhoodPeriodFollowup.spouseEducation}" dicmeta="GBT46582006"></ehr:dic>
				</td>
			</tr>
			
			<tr>
				<th>配偶职业类别</th>
				<td>
					<ehr:dic code="${motherhoodPeriodFollowup.spouseOccupation}" dicmeta="GBT6565"></ehr:dic>
				</td>
				<th>配偶工作单位名称</th>
				<td>
					<c:out value="${motherhoodPeriodFollowup.spouseUnitName}" />
				</td>
			</tr>
			
			<tr>
				<%-- 
				<th>配偶身份证件类别</th>
				<td>
					<ehr:dic code="${motherhoodPeriodFollowup.spouseIdcardType}" dicmeta="CV0201101"></ehr:dic>
				</td>
				--%> 
				<th>配偶身份证件号码</th>
				<td colspan="3">
					<c:out value="${motherhoodPeriodFollowup.spouseIdcard}" />
				</td>
			</tr>
			<tr>
				<th>新生儿姓名</th>
				<td>
					<c:out value="${motherhoodPeriodFollowup.neonatalName}" />
				</td>
				<th>新生儿性别</th>
				<td>
					<ehr:dic code="${motherhoodPeriodFollowup.neonatalGender}" dicmeta="GBT226112003"></ehr:dic>
				</td>
			</tr>
			<tr>
				<th>户籍地址</th>
				<td colspan="3">
					<c:out value="${motherhoodPeriodFollowup.hrprovince}"></c:out>
					<c:out value="${motherhoodPeriodFollowup.hrcity}"></c:out>
					<c:out value="${motherhoodPeriodFollowup.hrcounty}"></c:out>
					<c:out value="${motherhoodPeriodFollowup.hrtownShip}"></c:out>
					<c:out value="${motherhoodPeriodFollowup.hrstreet}"></c:out>
					<c:out value="${motherhoodPeriodFollowup.hrhouseNumber}"></c:out>
				</td>
			</tr>
			<tr>
				<th>户籍地址邮政编码</th>
				<td colspan="3">
					<c:out value="${motherhoodPeriodFollowup.hrpostCode}"></c:out>
				</td>
			</tr>
			<tr>
				<th>现住址</th>
				<td colspan="3">
					<c:out value="${motherhoodPeriodFollowup.paprovince}"></c:out>
					<c:out value="${motherhoodPeriodFollowup.pacity}"></c:out>
					<c:out value="${motherhoodPeriodFollowup.pacounty}"></c:out>
					<c:out value="${motherhoodPeriodFollowup.patownShip}"></c:out>
					<c:out value="${motherhoodPeriodFollowup.pastreet}"></c:out>
					<c:out value="${motherhoodPeriodFollowup.pahouseNumber}"></c:out>
				</td>
			</tr>
			<tr>
				<th>现住址邮政编码</th>
				<td colspan="3">
					<c:out value="${motherhoodPeriodFollowup.papostCode}"></c:out>
				</td>
			</tr>
			<tr>
				<th>现病史</th>
				<td colspan="3">
					<c:out value="${motherhoodPeriodFollowup.presentHistory}"></c:out>
				</td>
			</tr>
			<tr>
				<th>既往疾病史</th>
				<td colspan="3">
					<c:out value="${motherhoodPeriodFollowup.pastMedicalHistory}"></c:out>
				</td>
			</tr>
			<tr>
				<th>手术史</th>
				<td colspan="3">
					<c:out value="${motherhoodPeriodFollowup.operationHistory}"></c:out>
				</td>
			</tr>
			<tr>
				<th>过敏史</th>
				<td colspan="3">
					<c:out value="${motherhoodPeriodFollowup.allergicHistory}"></c:out>
				</td>
			</tr>
			<tr>
				<th>家族遗传性疾病史</th>
				<td colspan="3">
					<c:out value="${motherhoodPeriodFollowup.familyGeneDiseaseHistory}"></c:out>
				</td>
			</tr>
			<tr>
				<th>初潮年龄(岁)</th>
				<td>
					<c:out value="${motherhoodPeriodFollowup.menarcheAge}"></c:out>
				</td>
				<th>月经持续时间(d)</th>
				<td>
					<c:out value="${motherhoodPeriodFollowup.menstrualDuration}"></c:out>
				</td>
			</tr>
			<tr>
				<th>月经周期(d)</th>
				<td>
					<c:out value="${motherhoodPeriodFollowup.menstrualCycle}"></c:out>
				</td>
				<th>月经出血量</th>
				<td>
					<ehr:dic code="${motherhoodPeriodFollowup.menstrualBleedingType}" dicmeta="FS10028"></ehr:dic>
				</td>
			</tr>
			<tr>
				<th>痛经程度</th>
				<td>
					<ehr:dic code="${motherhoodPeriodFollowup.dysmenorrheaDegree}" dicmeta="FS10041"></ehr:dic>
				</td>
				<th>末次月经日期</th>
				<td>
					<fmt:formatDate value="${motherhoodPeriodFollowup.lastMenstrualDate}" pattern="yyyy/MM/dd"/>
				</td>
			</tr>
			<tr>
				<th>孕次</th>
				<td>
					<c:out value="${motherhoodPeriodFollowup.gravidityTimes}" ></c:out>
				</td>
				<th>产次</th>
				<td>
					<c:out value="${motherhoodPeriodFollowup.productionTimes}" ></c:out>
				</td>
			</tr>
			<tr>
				<th>早产次数</th>
				<td colspan="3">
					<c:out value="${motherhoodPeriodFollowup.prematureDeliveryTimes}" ></c:out>
				</td>
				<%--
				<th>流产总次数</th>
				<td>
					<c:out value="${motherhoodPeriodFollowup.abortionTimes}" ></c:out>
				</td>
				 --%>
			</tr>
			<tr>
				<th>人工流产次数</th>
				<td>
					<c:out value="${motherhoodPeriodFollowup.artificialAbortionTimes}" ></c:out>
				</td>
				<th>自然流产次数</th>
				<td>
					<c:out value="${motherhoodPeriodFollowup.spontaneousAbortionTimes}" ></c:out>
				</td>
			</tr>
			<tr>
				<th>剖宫产次数</th>
				<td>
					<c:out value="${motherhoodPeriodFollowup.cesareanSectionTimes}" ></c:out>
				</td>
				<th>阴道助产次数</th>
				<td>
					<c:out value="${motherhoodPeriodFollowup.vaginaDeliveryTimes}" ></c:out>
				</td>
			</tr>
			<tr>
				<th>死胎例数</th>
				<td>
					<c:out value="${motherhoodPeriodFollowup.stillbirthCasesNumber}" ></c:out>
				</td>
				<th>死产例数</th>
				<td>
					<c:out value="${motherhoodPeriodFollowup.stillbornCasesNumber}" ></c:out>
				</td>
			</tr>
			<tr>
				<th>前次分娩方式</th>
				<td>
					<ehr:dic code="${motherhoodPeriodFollowup.previousChildbirthWay}" dicmeta="CV0210003"></ehr:dic>
				</td>
				<th>前次分娩日期</th>
				<td>
					<fmt:formatDate value="${motherhoodPeriodFollowup.previousChildbirthDate}" pattern="yyyy/MM/dd"/>
				</td>
			</tr>
			<tr>
				<th>前次妊娠终止日期</th>
				<td>
					<fmt:formatDate value="${motherhoodPeriodFollowup.previousPregnancyEndDate}" pattern="yyyy/MM/dd"/>
				</td>
				<th>前次妊娠终止方式</th>
				<td>
					<ehr:dic code="${motherhoodPeriodFollowup.previousPregnancyEndWay}" dicmeta="CV0210002"></ehr:dic>
				</td>
			</tr>
			<%-- 
			<tr>
				<th>末次妊娠终止日期</th>
				<td>
					<fmt:formatDate value="${motherhoodPeriodFollowup.lastPregnancyEndDate}" pattern="yyyy/MM/dd"/>
				</td>
				<th>末次妊娠终止方式</th>
				<td>
					<ehr:dic code="${motherhoodPeriodFollowup.lastPregnancyEndWay}" dicmeta="CV0210002"></ehr:dic>
				</td>
			</tr>
			
			<tr>
				<th>主诉</th>
				<td colspan="3">
					<c:out value="${motherhoodPeriodFollowup.chiefComplaint}"></c:out>
				</td>
			</tr>
			--%>
			<tr>
				<th>体温(℃)</th>
				<td>
					<c:out value="${motherhoodPeriodFollowup.temperature}" ></c:out>
				</td>
				<th>心率(次/分钟)</th>
				<td>
					<c:out value="${motherhoodPeriodFollowup.heartRate}" ></c:out>
				</td>
			</tr>
			<tr>
				<th>舒张压(mmHg)</th>
				<td>
					<c:out value="${motherhoodPeriodFollowup.dbp}" ></c:out>
				</td>
				<th>收缩压(mmHg)</th>
				<td>
					<c:out value="${motherhoodPeriodFollowup.sbp}" ></c:out>
				</td>
			</tr>
			<tr>
				<th>心脏听诊结果</th>
				<td colspan="3">
					<c:out value="${motherhoodPeriodFollowup.cardiacAuscuResult}"></c:out>
				</td>
			</tr>
			<tr>
				<th>肺部听诊结果</th>
				<td colspan="3">
					<c:out value="${motherhoodPeriodFollowup.lungAuscuResult}"></c:out>
				</td>
			</tr>
			<tr>
				<th>外阴检查结果</th>
				<td colspan="3">
					<c:out value="${motherhoodPeriodFollowup.vulvaCheckResult}"></c:out>
				</td>
			</tr>
			<tr>
				<th>阴道检查结果</th>
				<td colspan="3">
					<c:out value="${motherhoodPeriodFollowup.vaginaCheckResult}"></c:out>
				</td>
			</tr>
			<tr>
				<th>宫颈检查结果</th>
				<td colspan="3">
					<c:out value="${motherhoodPeriodFollowup.cervixCheckResult}"></c:out>
				</td>
			</tr>
			<tr>
				<th>子宫检查结果</th>
				<td colspan="3">
					<c:out value="${motherhoodPeriodFollowup.uterusCheckResult}"></c:out>
				</td>
			</tr>
			
			<%-- 
			<tr>
				<th>子宫位置</th>
				<td>
					<ehr:dic code="${motherhoodPeriodFollowup.uterinePart}" dicmeta="FS10034"></ehr:dic>
				</td>
				<th>子宫大小</th>
				<td>
					<ehr:dic code="${motherhoodPeriodFollowup.uterineSize}" dicmeta="CV0410002"></ehr:dic>
				</td>
			</tr>
			
			<tr>
				<th>左侧输卵管检查结果</th>
				<td colspan="3">
					<c:out value="${motherhoodPeriodFollowup.lFallopianTubeCheckResult}"></c:out>
				</td>
			</tr>
			<tr>
				<th>右侧输卵管检查结果</th>
				<td colspan="3">
					<c:out value="${motherhoodPeriodFollowup.rFallopianTubCheckResult}"></c:out>
				</td>
			</tr>
			<tr>
				<th>左侧卵巢检查结果</th>
				<td colspan="3">
					<c:out value="${motherhoodPeriodFollowup.lOvaryCheckResult}"></c:out>
				</td>
			</tr>
			<tr>
				<th>右侧卵巢检查结果</th>
				<td colspan="3">
					<c:out value="${motherhoodPeriodFollowup.rOvaryCheckResult}"></c:out>
				</td>
			</tr>
			--%>
			<tr>
			
				<th>左侧附件检查结果</th>
				<td>
					<ehr:dic code="${motherhoodPeriodFollowup.lAttachmentCheckResult}" dicmeta="CV0410001"></ehr:dic>
				</td>
				<th>右侧附件检查结果</th>
				<td>
					<ehr:dic code="${motherhoodPeriodFollowup.rAttachmentCheckResult}" dicmeta="CV0410001"></ehr:dic>
				</td>
			</tr>
			<tr>
				<th>红细胞计数值(G/L)</th>
				<td>
					<c:out value="${motherhoodPeriodFollowup.erythrocyteCount}"></c:out>
				</td>
				<th>血红蛋白值(g/L)</th>
				<td>
					<c:out value="${motherhoodPeriodFollowup.hemoglobinValue}"></c:out>
				</td>
			</tr>
			<tr>
				<th>血小板计数值(G/L)</th>
				<td>
					<c:out value="${motherhoodPeriodFollowup.plateletCount}"></c:out>
				</td>
				<th>白细胞计数值(G/L)</th>
				<td>
					<c:out value="${motherhoodPeriodFollowup.hemoglobinValue}"></c:out>
				</td>
			</tr>
			<%-- 
			<tr>
				<th>白细胞分类结果</th>
				<td colspan="3">
					<c:out value="${motherhoodPeriodFollowup.leukocyteCount}"></c:out>
				</td>
			</tr>
			--%>
			<tr>
				<th>出血时间(s)</th>
				<td>
					<c:out value="${motherhoodPeriodFollowup.bleedingTime}" ></c:out>
				</td>
				<th>凝血时间(s)</th>
				<td>
					<c:out value="${motherhoodPeriodFollowup.coagulationTime}" ></c:out>
				</td>
			</tr>
			<tr>
				<th>阴道分泌物性状描述</th>
				<td colspan="3">
					<c:out value="${motherhoodPeriodFollowup.vaginaSecretionsDesc}"></c:out>
				</td>
			</tr>
			<tr>
				<th>淋球菌检查结果</th>
				<td colspan="3">
					<c:out value="${motherhoodPeriodFollowup.NGonorrhoeaeCheckResult}"></c:out>
				</td>
			</tr>
			<tr>
				<th>滴虫检测结果</th>
				<td>
					<ehr:dic code="${motherhoodPeriodFollowup.trichomoDetectResult}" dicmeta="FS10045"></ehr:dic>
				</td>
				<th>念珠菌检测结果</th>
				<td>
					<ehr:dic code="${motherhoodPeriodFollowup.candidaDetectResult}" dicmeta="FS10044"></ehr:dic>
				</td>
			</tr>
			<tr>
				<th>阴道分泌物清洁度</th>
				<td>
					<ehr:dic code="${motherhoodPeriodFollowup.vaginaSecretionsCleanliness}" dicmeta="CV0450010"></ehr:dic>
				</td>
				<th>梅毒血清学试验结果</th>
				<td>
					<ehr:dic code="${motherhoodPeriodFollowup.syphilisSerologyCheckResult}" dicmeta="FS10058"></ehr:dic>
				</td>
			</tr>
			 
			<tr>
				<th>HIV抗体检测结果</th>
				<td>
					<c:out value="${motherhoodPeriodFollowup.hivlgDetectResult}" ></c:out>
				</td>
				<%--
				<th>尿妊娠试验结果</th>
				<td>
					<ehr:dic code="${motherhoodPeriodFollowup.urineTestResult}" dicmeta="FS10043"></ehr:dic>
				</td>
				--%>
				<th>B超检查结果</th>
				<td colspan="3">
					<c:out value="${motherhoodPeriodFollowup.bmodeCheckResult}"></c:out>
				</td>
			</tr>
			<tr>
				<th>血β-绒毛膜促性腺激素值(IU/L)</th>
				<td>
					<c:out value="${motherhoodPeriodFollowup.hivlgDetectResult}" ></c:out>
				</td>
				<th>乙型肝炎病毒表面抗原检测结果</th>
				<td>
					<ehr:dic code="${motherhoodPeriodFollowup.hbsagDetectResult}" dicmeta="FS10092"></ehr:dic>
				</td>
			</tr>
			<tr>
				
			</tr>
			<%-- 
			<tr>
				<th>疾病诊断</th>
				<td colspan="3">
					<ehr:dic code="${motherhoodPeriodFollowup.diseaseDiagnosis}" dicmeta="CV550220"></ehr:dic>
				</td>
			</tr>
			
			<tr>
				<th>宫内节育器放置年限</th>
				<td>
					<c:out value="${motherhoodPeriodFollowup.iudPlaceLife}" ></c:out>
				</td>
				<th>宫内节育器放置时期</th>
				<td>
					<ehr:dic code="${motherhoodPeriodFollowup.iudPlaceTime}" dicmeta="CV0600104"></ehr:dic>
				</td>
			</tr>
			<tr>
				<th>宫内节育器种类</th>
				<td>
					<ehr:dic code="${motherhoodPeriodFollowup.iudType}" dicmeta="CV0850101"></ehr:dic>
				</td>
				<th>宫内节育器取出情况</th>
				<td>
					<ehr:dic code="${motherhoodPeriodFollowup.iudRemoveState}" dicmeta="FS10032"></ehr:dic>
				</td>
			</tr>
			
			<tr>
				<th>宫内节育器取出异常情况描述</th>
				<td colspan="3">
					<c:out value="${motherhoodPeriodFollowup.iudRemoveAnomaliesDesc}" ></c:out>
				</td>
			</tr>
			<tr>
				<th>皮下埋植剂埋植时期</th>
				<td>
					<ehr:dic code="${motherhoodPeriodFollowup.norplantImplantsPeriod}" dicmeta="CV0600105"></ehr:dic>
				</td>
				<th>皮下埋植剂埋植年限</th>
				<td>
					<c:out value="${motherhoodPeriodFollowup.norplantImplantsLife}" ></c:out>
				</td>
			</tr>
			<tr>
				<th>取出皮下埋植剂检查结果</th>
				<td colspan="3">
					<ehr:dic code="${motherhoodPeriodFollowup.removeimplantsCheckResult}" dicmeta="FS10049"></ehr:dic>
				</td>
			</tr>
			
			<tr>
				<th>输卵管结扎手术方式</th>
				<td>
					<ehr:dic code="${motherhoodPeriodFollowup.tubalLigationWay}" dicmeta="CV0600106"></ehr:dic>
				</td>
				<th>输卵管结扎部位</th>
				<td>
					<ehr:dic code="${motherhoodPeriodFollowup.tubalLigationPart}" dicmeta="CV0600107"></ehr:dic>
				</td>
			</tr>
			<tr>
				<th>宫颈扩张标志</th>
				<td>
                    <c:if test="${!empty motherhoodPeriodFollowup.cervicalDilatationFlag}">
					    <c:out value='${motherhoodPeriodFollowup.cervicalDilatationFlag eq "1" ? "是" : "否"}'></c:out>
                    </c:if>
				</td>
				<th>见到绒毛标志</th>
				<td>
                    <c:if test="${!empty motherhoodPeriodFollowup.seeFluffFlag}">
					    <c:out value='${motherhoodPeriodFollowup.seeFluffFlag eq "1" ? "是" : "否"}'></c:out>
                    </c:if>
				</td>
			</tr>
			
			<tr>
				<th>胚囊可见标志</th>
				<td>
                    <c:if test="${!empty motherhoodPeriodFollowup.sacVisibleFlag}">
					    <c:out value='${motherhoodPeriodFollowup.sacVisibleFlag eq "1" ? "是" : "否"}'></c:out>
                    </c:if>
				</td>
				<th>胚囊-平均直径(cm)</th>
				<td>
					<c:out value="${motherhoodPeriodFollowup.sacAverageDiameter}"></c:out>
				</td>
			</tr>
			<tr>
				<th>清宫操作标志</th>
				<td>
                    <c:if test="${!empty motherhoodPeriodFollowup.palaceOperationFlag}">
					    <c:out value='${motherhoodPeriodFollowup.palaceOperationFlag eq "1" ? "是" : "否"}'></c:out>
                    </c:if>
				</td>
				<th>流产方法</th>
				<td>
					<ehr:dic code="${motherhoodPeriodFollowup.abortionMethod}" dicmeta="FS10040"></ehr:dic>
				</td>
			</tr>
			<tr>
				<th>药物流产使用药物类别</th>
				<td>
					<ehr:dic code="${motherhoodPeriodFollowup.medicaAbortionDrugType}" dicmeta="FS10188"></ehr:dic>
				</td>
				<th>给(服)药时间</th>
				<td>
					<fmt:formatDate value="${motherhoodPeriodFollowup.medicationTime}" pattern="yyyy/MM/dd"/>
				</td>
			</tr>
			
			<tr>
				<th>呕吐次数</th>
				<td>
					<c:out value="${motherhoodPeriodFollowup.vomitingTimes}" ></c:out>
				</td>
				<th>腹泻次数</th>
				<td>
					<c:out value="${motherhoodPeriodFollowup.diarrheaTimes}" ></c:out>
				</td>
			</tr>
			<tr>
				<th>腹痛程度</th>
				<td>
					<ehr:dic code="${motherhoodPeriodFollowup.abdominalPain}" dicmeta="FS10142"></ehr:dic>
				</td>
				<th>腹泻次数</th>
				<td>
					<c:out value="${motherhoodPeriodFollowup.diarrheaTimes}" ></c:out>
				</td>
			</tr>
			<tr>
				<th>病理检查标志</th>
				<td colspan="3">
                    <c:if test="${!empty motherhoodPeriodFollowup.pathologicalExamFlag}">
					    <c:out value='${motherhoodPeriodFollowup.pathologicalExamFlag eq "1" ? "是" : "否"}'></c:out>
                    </c:if>
				</td>
			</tr>
			<c:if test='${motherhoodPeriodFollowup.pathologicalExamFlag eq "1"}'>
				<tr>
					<th>病理检查结果</th>
					<td colspan="3">
						<c:out value="${motherhoodPeriodFollowup.pathologicalExamResult}" ></c:out>
					</td>
				</tr>
			</c:if>
			<tr>
				<th>药物名称</th>
				<td>
					<c:out value="${motherhoodPeriodFollowup.drugName}" ></c:out>
				</td>
				<th>药物用法</th>
				<td>
					<c:out value="${motherhoodPeriodFollowup.drugUsage}" ></c:out>
				</td>
			</tr>
			
			<tr>
				<th>胚囊排出日期时间</th>
				<td>
					<fmt:formatDate value="${motherhoodPeriodFollowup.embryoSacDischargeDate}" pattern="yyyy/MM/dd HH:mm:ss"></fmt:formatDate>
				</td>
				<th>清宫日期</th>
				<td>
					<fmt:formatDate value="${motherhoodPeriodFollowup.qinggongDate}" pattern="yyyy/MM/dd"/>
				</td>
			</tr>
			<tr>
				<th>手术/操作-名称</th>
				<td>
					<c:out value="${motherhoodPeriodFollowup.operationName}" ></c:out>
				</td>
				<th>手术过程顺利标志</th>
				<td>
					<c:out value="${motherhoodPeriodFollowup.operationProcessFlag}" ></c:out>
				</td>
			</tr>
			<tr>
				<th>手术出血量(ml)</th>
				<td colspan="3">
					<c:out value="${motherhoodPeriodFollowup.operationBleeding}" ></c:out>
				</td>
			</tr>
			<tr>
				<th>手术过程描述</th>
				<td colspan="3">
					<c:out value="${motherhoodPeriodFollowup.operationProcessDesc}" ></c:out>
				</td>
			</tr>
			<tr>
				<th>手术并发症标志</th>
				<td colspan="3">
                    <c:if test="${!empty motherhoodPeriodFollowup.operationComplicationsFlag}">
					    <c:out value='${motherhoodPeriodFollowup.operationComplicationsFlag eq "1" ? "是" : "否"}'></c:out>
                    </c:if>
				</td>
			</tr>
			<c:if test='${motherhoodPeriodFollowup.operationComplicationsFlag eq "1"}'>
				<tr>
					<th>手术并发症详细描述</th>
					<td colspan="3">
						<c:out value="${motherhoodPeriodFollowup.operationComplicationsDesc}"></c:out>
					</td>
				<tr>
			</c:if>
			<tr>
				<th>特殊情况记录</th>
				<td colspan="3">
					<c:out value="${motherhoodPeriodFollowup.specialCaseRecord}"></c:out>
				</td>
			</tr>
			<tr>
				<th>处理及指导意见</th>
				<td colspan="3">
					<c:out value="${motherhoodPeriodFollowup.mgOpinion}"></c:out>
				</td>
			</tr>
			<tr>
				<th>随诊检查结果</th>
				<td colspan="3">
					<c:out value="${motherhoodPeriodFollowup.followedCheckResult}"></c:out>
				</td>
			</tr>
			<tr>
				<th>手术者姓名</th>
				<td>
					<c:out value="${motherhoodPeriodFollowup.operatorName}"></c:out>
				</td>
				<th>手术日期</th>
				<td>
					<fmt:formatDate value="${motherhoodPeriodFollowup.opsDate}" pattern="yyyy/MM/dd"/>
				</td>
			</tr>
			<tr>
				<th>手术机构名称</th>
				<td colspan="3">
					<c:out value="${motherhoodPeriodFollowup.operationUnitName}"></c:out>
				</td>
			</tr>
			--%>
			<tr>
				<th>检查(测)人员姓名</th>
				<td>
					<c:out value="${motherhoodPeriodFollowup.checkName}"></c:out>
				</td>
				<th>检查(测)日期</th>
				<td>
					<fmt:formatDate value="${motherhoodPeriodFollowup.checkDate}" pattern="yyyy/MM/dd"/>
				</td>
			</tr>
			<tr>
				<th>检查(测)机构名称</th>
				<td colspan="3">
					<c:out value="${motherhoodPeriodFollowup.checkOrganName}"></c:out>
				</td>
			</tr>
		</table>
		<br/>
		<%-- 
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
				<th>左侧附睾检查结果</th>
				<td>
					<ehr:dic code="${motherhoodPeriodFollowup.lEpididymisCheckResult}" dicmeta="FS10050"></ehr:dic>
				</td>
				<th>右侧附睾检查结果</th>
				<td>
					<ehr:dic code="${motherhoodPeriodFollowup.rEpididymisCheckResult}" dicmeta="FS10050"></ehr:dic>
				</td>
			</tr>
			
			<tr>
				<th>左侧睾丸检查结果</th>
				<td>
					<ehr:dic code="${motherhoodPeriodFollowup.lTestisCheckResult}" dicmeta="FS10050"></ehr:dic>
				</td>
				<th>右侧睾丸检查结果</th>
				<td>
					<ehr:dic code="${motherhoodPeriodFollowup.rTestisCheckResult}" dicmeta="FS10050"></ehr:dic>
				</td>
			</tr>
			
			<tr>
				<th>左侧输精管检查结果</th>
				<td>
					<ehr:dic code="${motherhoodPeriodFollowup.lVasDeferensCheckResult}" dicmeta="FS10050"></ehr:dic>
				</td>
				<th>右侧输精管检查结果</th>
				<td>
					<ehr:dic code="${motherhoodPeriodFollowup.rVasDeferensCheckResult}" dicmeta="FS10050"></ehr:dic>
				</td>
			</tr>
			
			<tr>
				<th>阴囊检查结果</th>
				<td colspan="3">
					<c:out value="${motherhoodPeriodFollowup.scrotumCheckResult}"></c:out>
				</td>
			</tr>
			<tr>
				<th>精索检查结果</th>
				<td colspan="3">
					<c:out value="${motherhoodPeriodFollowup.spermaticCheckResult}"></c:out>
				</td>
			</tr>
			<tr>
				<th>输精管结扎手术方式</th>
				<td colspan="3">
					<ehr:dic code="${motherhoodPeriodFollowup.vasectomyWay}" dicmeta="FS10051"></ehr:dic>
				</td>
			</tr>
			<tr>
				<th>左侧输精管切除长度(cm)</th>
				<td>
					<c:out value="${motherhoodPeriodFollowup.lVasectomyLength}"></c:out>
				</td>
				<th>右侧输精管切除长度(cm)</th>
				<td>
					<c:out value="${motherhoodPeriodFollowup.rVasectomyLength}"></c:out>
				</td>
			</tr>
			
			<tr>
				<th>左侧附睾端包埋操作</th>
				<td>
                    <c:if test="${!empty motherhoodPeriodFollowup.lEpididymisEmbedFlag}">
					    <c:out value='${motherhoodPeriodFollowup.lEpididymisEmbedFlag eq "1" ? "是" : "否"}'></c:out>
                    </c:if>
				</td>
				<th>右侧附睾端包埋操作</th>
				<td>
                    <c:if test="${!empty motherhoodPeriodFollowup.rEpididymisEmbedFlag}">
					    <c:out value='${motherhoodPeriodFollowup.rEpididymisEmbedFlag eq "1" ? "是" : "否"}'></c:out>
                    </c:if>
				</td>
			</tr>
			--%>
		</table>
	</div>
</div>