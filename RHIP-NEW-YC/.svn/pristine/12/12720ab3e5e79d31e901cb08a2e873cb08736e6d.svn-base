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
	      	<td class="crumbs"><div id="location" parentMenu="women-health" childMenu="birthController">当前位置:&gt;&gt;妇女保健&gt;&gt;计划生育服务信息</div>
			</td>
	  	</tr>
	 </table>
<br/>
<div style="background-color: white;">
	<ul>
		<li style="text-align: center; font-size: 25px;">计划生育技术服务</li>
	</ul>
	<br/>
	<div class="table-basic">
		女性：
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
					<c:out value="${birthControlService.name}"></c:out>
				</td>
				<th>出生日期</th>
				<td>
					<fmt:formatDate value="${birthControlService.birthday}" pattern="yyyy/MM/dd"/>
				</td>
			</tr>
			<tr>
				<th>本人电话号码</th>
				<td>
					<c:out value="${birthControlService.phoneNumber}"></c:out>
				</td>
				<th>工作单位名称</th>
				<td>
					<c:out value="${birthControlService.unitName}" />
				</td>
			</tr>
			<tr>
				<th>职业类别</th>
				<td>
					<ehr:dic code="${birthControlService.occupation}" dicmeta="GBT6565"></ehr:dic>
				</td>
				<th>婚姻状况</th>
				<td>
					<ehr:dic code="${birthControlService.marriage}" dicmeta="GBT226122003"></ehr:dic>
				</td>
			</tr>
			<tr>
				<th>户籍地址</th>
				<td colspan="3">
					<c:out value="${birthControlService.hrprovince}"></c:out>
					<c:out value="${birthControlService.hrcity}"></c:out>
					<c:out value="${birthControlService.hrcounty}"></c:out>
					<c:out value="${birthControlService.hrtownShip}"></c:out>
					<c:out value="${birthControlService.hrstreet}"></c:out>
					<c:out value="${birthControlService.hrhouseNumber}"></c:out>
				</td>
			</tr>
			<tr>
				<th>户籍地址邮政编码</th>
				<td colspan="3">
					<c:out value="${birthControlService.hrpostCode}"></c:out>
				</td>
			</tr>
			<tr>
				<th>现住址</th>
				<td colspan="3">
					<c:out value="${birthControlService.paprovince}"></c:out>
					<c:out value="${birthControlService.pacity}"></c:out>
					<c:out value="${birthControlService.pacounty}"></c:out>
					<c:out value="${birthControlService.patownShip}"></c:out>
					<c:out value="${birthControlService.pastreet}"></c:out>
					<c:out value="${birthControlService.pahouseNumber}"></c:out>
				</td>
			</tr>
			<tr>
				<th>既往疾病史</th>
				<td colspan="3">
					<c:out value="${birthControlService.pastMedicalHistory}"></c:out>
				</td>
			</tr>
			<tr>
				<th>过敏史</th>
				<td colspan="3">
					<c:out value="${birthControlService.allergicHistory}"></c:out>
				</td>
			</tr>
			<tr>
				<th>避孕史</th>
				<td colspan="3">
					<c:out value="${birthControlService.contraceptiveHistory}"></c:out>
				</td>
			</tr>
			<tr>
				<th>主诉</th>
				<td colspan="3">
					<c:out value="${birthControlService.chiefComplaint}"></c:out>
				</td>
			</tr>
			<tr>
				<th>初潮年龄(岁)</th>
				<td>
					<c:out value="${birthControlService.menarcheAge}"></c:out>
				</td>
				<th>月经持续时间(d)</th>
				<td>
					<c:out value="${birthControlService.menstrualDuration}"></c:out>
				</td>
			</tr>
			<tr>
				<th>月经周期(d)</th>
				<td>
					<c:out value="${birthControlService.menstrualCycle}"></c:out>
				</td>
				<th>月经出血量</th>
				<td>
					<ehr:dic code="${birthControlService.menstrualBleedingType}" dicmeta="FS10028"></ehr:dic>
				</td>
			</tr>
			<tr>
				<th>痛经程度</th>
				<td>
					<ehr:dic code="${birthControlService.dysmenorrheaDegree}" dicmeta="FS10041"></ehr:dic>
				</td>
				<th>末次月经日期</th>
				<td>
					<fmt:formatDate value="${birthControlService.lastMenstrualDate}" pattern="yyyy/MM/dd"/>
				</td>
			</tr>
			<tr>
				<th>孕次</th>
				<td>
					<c:out value="${birthControlService.gravidityTimes}" ></c:out>
				</td>
				<th>产次</th>
				<td>
					<c:out value="${birthControlService.productionTimes}" ></c:out>
				</td>
			</tr>
			<tr>
				<th>末次妊娠终止日期</th>
				<td>
					<fmt:formatDate value="${birthControlService.lastPregnancyEndDate}" pattern="yyyy/MM/dd"/>
				</td>
				<th>末次妊娠终止方式</th>
				<td>
					<ehr:dic code="${birthControlService.lastPregnancyWay}" dicmeta="CV0210002"></ehr:dic>
				</td>
			</tr>
			<tr>
				<th>流产总次数</th>
				<td colspan="3">
					<c:out value="${birthControlService.abortionTimes}" ></c:out>
				</td>
			</tr>
			<tr>
				<th>舒张压(mmHg)</th>
				<td>
					<c:out value="${birthControlService.dbp}" ></c:out>
				</td>
				<th>收缩压(mmHg)</th>
				<td>
					<c:out value="${birthControlService.sbp}" ></c:out>
				</td>
			</tr>
			<tr>
				<th>体温(℃)</th>
				<td>
					<c:out value="${birthControlService.temperature}" ></c:out>
				</td>
				<th>心率(次/分钟)</th>
				<td>
					<c:out value="${birthControlService.heartRate}" ></c:out>
				</td>
			</tr>
			<tr>
				<th>心脏听诊结果</th>
				<td colspan="3">
					<c:out value="${birthControlService.cardiacAuscuResult}"></c:out>
				</td>
			</tr>
			<tr>
				<th>肺部听诊结果</th>
				<td colspan="3">
					<c:out value="${birthControlService.lungAuscuResult}"></c:out>
				</td>
			</tr>
			<tr>
				<th>外阴检查结果</th>
				<td colspan="3">
					<c:out value="${birthControlService.vulvaCheckResult}"></c:out>
				</td>
			</tr>
			<tr>
				<th>阴道检查结果</th>
				<td colspan="3">
					<c:out value="${birthControlService.vaginaCheckResult}"></c:out>
				</td>
			</tr>
			<tr>
				<th>宫颈检查结果</th>
				<td colspan="3">
					<c:out value="${birthControlService.cervixCheckResult}"></c:out>
				</td>
			</tr>
			<tr>
				<th>子宫检查结果</th>
				<td colspan="3">
					<c:out value="${birthControlService.uterusCheckResult}"></c:out>
				</td>
			</tr>
			<tr>
				<th>子宫位置</th>
				<td>
					<ehr:dic code="${birthControlService.uterinePart}" dicmeta="FS10034"></ehr:dic>
				</td>
				<th>子宫大小</th>
				<td>
					<ehr:dic code="${birthControlService.uterineSize}" dicmeta="CV0410002"></ehr:dic>
				</td>
			</tr>
			<tr>
				<th>左侧输卵管检查结果</th>
				<td colspan="3">
					<c:out value="${birthControlService.lFallopianTubeCheckResult}"></c:out>
				</td>
			</tr>
			<tr>
				<th>右侧输卵管检查结果</th>
				<td colspan="3">
					<c:out value="${birthControlService.rFallopianTubeCheckResult}"></c:out>
				</td>
			</tr>
			<tr>
				<th>左侧卵巢检查结果</th>
				<td colspan="3">
					<c:out value="${birthControlService.lOvaryCheckResult}"></c:out>
				</td>
			</tr>
			<tr>
				<th>右侧卵巢检查结果</th>
				<td colspan="3">
					<c:out value="${birthControlService.rOvaryCheckResult}"></c:out>
				</td>
			</tr>
			<tr>
				<th>左侧附件检查结果</th>
				<td>
					<ehr:dic code="${birthControlService.lAttachmentCheckResult}" dicmeta="CV0410001"></ehr:dic>
				</td>
				<th>右侧附件检查结果</th>
				<td>
					<ehr:dic code="${birthControlService.rAttachmentCheckResult}" dicmeta="CV0410001"></ehr:dic>
				</td>
			</tr>
			<tr>
				<th>红细胞计数值(G/L)</th>
				<td>
					<c:out value="${birthControlService.erythrocyteCount}"></c:out>
				</td>
				<th>血红蛋白值(g/L)</th>
				<td>
					<c:out value="${birthControlService.hemoglobinValue}"></c:out>
				</td>
			</tr>
			<tr>
				<th>血小板计数值(G/L)</th>
				<td>
					<c:out value="${birthControlService.plateletCount}"></c:out>
				</td>
				<th>白细胞计数值(G/L)</th>
				<td>
					<c:out value="${birthControlService.hemoglobinValue}"></c:out>
				</td>
			</tr>
			<tr>
				<th>白细胞分类结果</th>
				<td colspan="3">
					<c:out value="${birthControlService.leukocyteType}"></c:out>
				</td>
			</tr>
			<tr>
				<th>出血时间(s)</th>
				<td>
					<c:out value="${birthControlService.bleedingTime}" ></c:out>
				</td>
				<th>凝血时间(s)</th>
				<td>
					<c:out value="${birthControlService.coagulationTime}" ></c:out>
				</td>
			</tr>
			<tr>
				<th>阴道分泌物性状描述</th>
				<td colspan="3">
					<c:out value="${birthControlService.vaginaSecretionsDesc}"></c:out>
				</td>
			</tr>
			<tr>
				<th>淋球菌检查结果</th>
				<td colspan="3">
					<c:out value="${birthControlService.nGonorrhoeaeCheckResult}"></c:out>
				</td>
			</tr>
			<tr>
				<th>滴虫检测结果</th>
				<td>
					<ehr:dic code="${birthControlService.trichomoDetectResult}" dicmeta="FS10045"></ehr:dic>
				</td>
				<th>念珠菌检测结果</th>
				<td>
					<ehr:dic code="${birthControlService.candidaDetectResult}" dicmeta="FS10044"></ehr:dic>
				</td>
			</tr>
			<tr>
				<th>阴道分泌物清洁度</th>
				<td>
					<ehr:dic code="${birthControlService.vaginaSecretionsCleanliness}" dicmeta="CV0450010"></ehr:dic>
				</td>
				<th>梅毒血清学试验结果</th>
				<td>
					<ehr:dic code="${birthControlService.syphilisSerologyCheckResult}" dicmeta="FS10058"></ehr:dic>
				</td>
			</tr>
			<tr>
				<th>HIV抗体检测结果</th>
				<td>
					<c:out value="${birthControlService.hivlgDetectResult}" ></c:out>
				</td>
				<th>尿妊娠试验结果</th>
				<td>
					<ehr:dic code="${birthControlService.urineTestResult}" dicmeta="FS10043"></ehr:dic>
				</td>
			</tr>
			<tr>
				<th>血β-绒毛膜促性腺激素值(IU/L)</th>
				<td>
					<c:out value="${birthControlService.hivlgDetectResult}" ></c:out>
				</td>
				<th>乙型肝炎病毒表面抗原检测结果</th>
				<td>
					<ehr:dic code="${birthControlService.hbsagDetectResult}" dicmeta="FS10092"></ehr:dic>
				</td>
			</tr>
			<tr>
				<th>B超检查结果</th>
				<td colspan="3">
					<c:out value="${birthControlService.bmodeCheckResult}"></c:out>
				</td>
			</tr>
			<tr>
				<th>疾病诊断</th>
				<td colspan="3">
					<ehr:dic code="${birthControlService.diseaseDiagnosis}" dicmeta="CV550220"></ehr:dic>
				</td>
			</tr>
			<tr>
				<th>宫内节育器放置年限</th>
				<td>
					<c:out value="${birthControlService.iudPlaceLife}" ></c:out>
				</td>
				<th>宫内节育器放置时期</th>
				<td>
					<ehr:dic code="${birthControlService.iudPlaceTime}" dicmeta="CV0600104"></ehr:dic>
				</td>
			</tr>
			<tr>
				<th>宫内节育器种类</th>
				<td>
					<ehr:dic code="${birthControlService.iudTypeCode}" dicmeta="CV0850101"></ehr:dic>
				</td>
				<th>宫内节育器取出情况</th>
				<td>
					<ehr:dic code="${birthControlService.iudRemoveState}" dicmeta="FS10032"></ehr:dic>
				</td>
			</tr>
			<tr>
				<th>宫内节育器取出异常情况描述</th>
				<td colspan="3">
					<c:out value="${birthControlService.iudRemoveAnomaliesDesc}" ></c:out>
				</td>
			</tr>
			<tr>
				<th>皮下埋植剂埋植时期</th>
				<td>
					<ehr:dic code="${birthControlService.norplantImplantsPeriod}" dicmeta="CV0600105"></ehr:dic>
				</td>
				<th>皮下埋植剂埋植年限</th>
				<td>
					<c:out value="${birthControlService.norplantImplantsLife}" ></c:out>
				</td>
			</tr>
			<tr>
				<th>取出皮下埋植剂检查结果</th>
				<td colspan="3">
					<ehr:dic code="${birthControlService.removeimplantsCheckResult}" dicmeta="FS10049"></ehr:dic>
				</td>
			</tr>
			<tr>
				<th>输卵管结扎手术方式</th>
				<td>
					<ehr:dic code="${birthControlService.tubalLigationWay}" dicmeta="CV0600106"></ehr:dic>
				</td>
				<th>输卵管结扎部位</th>
				<td>
					<ehr:dic code="${birthControlService.tubalLigationPart}" dicmeta="CV0600107"></ehr:dic>
				</td>
			</tr>
			<tr>
				<th>宫颈扩张标志</th>
				<td>
                    <c:if test="${!empty birthControlService.cervicalDilatationFlag}">
					    <c:out value='${birthControlService.cervicalDilatationFlag eq "1" ? "是" : "否"}'></c:out>
                    </c:if>
				</td>
				<th>见到绒毛标志</th>
				<td>
                    <c:if test="${!empty birthControlService.seeFluffFlag}">
					    <c:out value='${birthControlService.seeFluffFlag eq "1" ? "是" : "否"}'></c:out>
                    </c:if>
				</td>
			</tr>
			<tr>
				<th>胚囊可见标志</th>
				<td>
                    <c:if test="${!empty birthControlService.sacVisibleFlag}">
					    <c:out value='${birthControlService.sacVisibleFlag eq "1" ? "是" : "否"}'></c:out>
                    </c:if>
				</td>
				<th>胚囊-平均直径(cm)</th>
				<td>
					<c:out value="${birthControlService.sacAverageDiameter}"></c:out>
				</td>
			</tr>
			<tr>
				<th>清宫操作标志</th>
				<td>
                    <c:if test="${!empty birthControlService.palaceOperationFlag}">
					    <c:out value='${birthControlService.palaceOperationFlag eq "1" ? "是" : "否"}'></c:out>
                    </c:if>
				</td>
				<th>流产方法</th>
				<td>
					<ehr:dic code="${birthControlService.abortionMethod}" dicmeta="FS10040"></ehr:dic>
				</td>
			</tr>
			<tr>
				<th>药物流产使用药物类别</th>
				<td>
					<ehr:dic code="${birthControlService.medicaAbortionDrugType}" dicmeta="FS10188"></ehr:dic>
				</td>
				<th>给(服)药时间</th>
				<td>
					<fmt:formatDate value="${birthControlService.medicationTime}" pattern="yyyy/MM/dd"/>
				</td>
			</tr>
			<tr>
				<th>呕吐次数</th>
				<td>
					<c:out value="${birthControlService.vomitingTimes}" ></c:out>
				</td>
				<th>腹泻次数</th>
				<td>
					<c:out value="${birthControlService.diarrheaTimes}" ></c:out>
				</td>
			</tr>
			<tr>
				<th>腹痛程度</th>
				<td>
					<ehr:dic code="${birthControlService.abdominalPain}" dicmeta="FS10142"></ehr:dic>
				</td>
				<th>腹泻次数</th>
				<td>
					<c:out value="${birthControlService.diarrheaTimes}" ></c:out>
				</td>
			</tr>
			<tr>
				<th>病理检查标志</th>
				<td colspan="3">
                    <c:if test="${!empty birthControlService.pathologicalExamFlag}">
					    <c:out value='${birthControlService.pathologicalExamFlag eq "1" ? "是" : "否"}'></c:out>
                    </c:if>
				</td>
			</tr>
			<c:if test='${birthControlService.pathologicalExamFlag eq "1"}'>
				<tr>
					<th>病理检查结果</th>
					<td colspan="3">
						<c:out value="${birthControlService.pathologicalExamResult}" ></c:out>
					</td>
				</tr>
			</c:if>
			<tr>
				<th>药物名称</th>
				<td>
					<c:out value="${birthControlService.drugName}" ></c:out>
				</td>
				<th>药物用法</th>
				<td>
					<c:out value="${birthControlService.drugUsage}" ></c:out>
				</td>
			</tr>
			<tr>
				<th>胚囊排出日期时间</th>
				<td>
					<fmt:formatDate value="${birthControlService.embryoSacDischargeDate}" pattern="yyyy/MM/dd HH:mm:ss"></fmt:formatDate>
				</td>
				<th>清宫日期</th>
				<td>
					<fmt:formatDate value="${birthControlService.qinggongDate}" pattern="yyyy/MM/dd"/>
				</td>
			</tr>
			<tr>
				<th>手术/操作-名称</th>
				<td>
					<c:out value="${birthControlService.operationName}" ></c:out>
				</td>
				<th>手术过程顺利标志</th>
				<td>
					<c:out value="${birthControlService.operationProcessFlag}" ></c:out>
				</td>
			</tr>
			<tr>
				<th>手术出血量(ml)</th>
				<td colspan="3">
					<c:out value="${birthControlService.operationBleeding}" ></c:out>
				</td>
			</tr>
			<tr>
				<th>手术过程描述</th>
				<td colspan="3">
					<c:out value="${birthControlService.operationProcessDesc}" ></c:out>
				</td>
			</tr>
			<tr>
				<th>手术并发症标志</th>
				<td colspan="3">
                    <c:if test="${!empty birthControlService.operationComplicationsFlag}">
					    <c:out value='${birthControlService.operationComplicationsFlag eq "1" ? "是" : "否"}'></c:out>
                    </c:if>
				</td>
			</tr>
			<c:if test='${birthControlService.operationComplicationsFlag eq "1"}'>
				<tr>
					<th>手术并发症详细描述</th>
					<td colspan="3">
						<c:out value="${birthControlService.operationComplicationsDesc}"></c:out>
					</td>
				<tr>
			</c:if>
			<tr>
				<th>特殊情况记录</th>
				<td colspan="3">
					<c:out value="${birthControlService.specialCaseRecord}"></c:out>
				</td>
			</tr>
			<tr>
				<th>处理及指导意见</th>
				<td colspan="3">
					<c:out value="${birthControlService.mgOpinion}"></c:out>
				</td>
			</tr>
			<tr>
				<th>随诊检查结果</th>
				<td colspan="3">
					<c:out value="${birthControlService.followedCheckResult}"></c:out>
				</td>
			</tr>
			<tr>
				<th>手术者姓名</th>
				<td>
					<c:out value="${birthControlService.operatorName}"></c:out>
				</td>
				<th>手术日期</th>
				<td>
					<fmt:formatDate value="${birthControlService.opsDate}" pattern="yyyy/MM/dd"/>
				</td>
			</tr>
			<tr>
				<th>手术机构名称</th>
				<td colspan="3">
					<c:out value="${birthControlService.operationUnitName}"></c:out>
				</td>
			</tr>
			<tr>
				<th>检查(测)人员姓名</th>
				<td>
					<c:out value="${birthControlService.checkName}"></c:out>
				</td>
				<th>检查(测)日期</th>
				<td>
					<fmt:formatDate value="${birthControlService.checkDate}" pattern="yyyy/MM/dd"/>
				</td>
			</tr>
			<tr>
				<th>检查(测)机构名称</th>
				<td colspan="3">
					<c:out value="${birthControlService.checkOrganName}"></c:out>
				</td>
			</tr>
		</table>
		<br/>
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
					<ehr:dic code="${birthControlService.lEpididymisCheckResult}" dicmeta="FS10050"></ehr:dic>
				</td>
				<th>右侧附睾检查结果</th>
				<td>
					<ehr:dic code="${birthControlService.rEpididymisCheckResult}" dicmeta="FS10050"></ehr:dic>
				</td>
			</tr>
			<tr>
				<th>左侧睾丸检查结果</th>
				<td>
					<ehr:dic code="${birthControlService.lTestisCheckResult}" dicmeta="FS10050"></ehr:dic>
				</td>
				<th>右侧睾丸检查结果</th>
				<td>
					<ehr:dic code="${birthControlService.rTestisCheckResult}" dicmeta="FS10050"></ehr:dic>
				</td>
			</tr>
			<tr>
				<th>左侧输精管检查结果</th>
				<td>
					<ehr:dic code="${birthControlService.lVasDeferensCheckResult}" dicmeta="FS10050"></ehr:dic>
				</td>
				<th>右侧输精管检查结果</th>
				<td>
					<ehr:dic code="${birthControlService.rVasDeferensCheckResult}" dicmeta="FS10050"></ehr:dic>
				</td>
			</tr>
			<tr>
				<th>阴囊检查结果</th>
				<td colspan="3">
					<c:out value="${birthControlService.scrotumCheckResult}"></c:out>
				</td>
			</tr>
			<tr>
				<th>精索检查结果</th>
				<td colspan="3">
					<c:out value="${birthControlService.spermaticCheckResult}"></c:out>
				</td>
			</tr>
			<tr>
				<th>输精管结扎手术方式</th>
				<td colspan="3">
					<ehr:dic code="${birthControlService.vasectomyWay}" dicmeta="FS10051"></ehr:dic>
				</td>
			</tr>
			<tr>
				<th>左侧输精管切除长度(cm)</th>
				<td>
					<c:out value="${birthControlService.lVasectomyLength}"></c:out>
				</td>
				<th>右侧输精管切除长度(cm)</th>
				<td>
					<c:out value="${birthControlService.rVasectomyLength}"></c:out>
				</td>
			</tr>
			<tr>
				<th>左侧附睾端包埋操作</th>
				<td>
                    <c:if test="${!empty birthControlService.lEpididymisEmbedFlag}">
					    <c:out value='${birthControlService.lEpididymisEmbedFlag eq "1" ? "是" : "否"}'></c:out>
                    </c:if>
				</td>
				<th>右侧附睾端包埋操作</th>
				<td>
                    <c:if test="${!empty birthControlService.rEpididymisEmbedFlag}">
					    <c:out value='${birthControlService.rEpididymisEmbedFlag eq "1" ? "是" : "否"}'></c:out>
                    </c:if>
				</td>
			</tr>
		</table>
	</div>
</div>
</div>