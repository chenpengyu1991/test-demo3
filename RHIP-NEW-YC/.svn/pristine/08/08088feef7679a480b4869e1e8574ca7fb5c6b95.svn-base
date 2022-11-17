<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/views/ehrbrowser/basic/basic.css" />

<div>
	<ul>
		<li style="text-align: center; font-size: 25px;">妇女病普查</li>
	</ul>
	<br />
	<div class="table-basic-narrow">
		<table>
			<colgroup>
				<col style="width: 25%;" />
				<col style="width: 25%;" />
				<col style="width: 25%;" />
				<col style="width: 25%;" />
			</colgroup>
			<tr>
				<th>姓名</th>
				<td>${womanDiseaseCensus.name}</td>
				<th>出生日期</th>
				<td><fmt:formatDate value="${womanDiseaseCensus.birthday}" pattern="yyyy/MM/dd" /></td>
			</tr>
			<tr>
				<th>民族</th>
				<td><ehr:dic code="${womanDiseaseCensus.nation}" dicmeta="GBT3304"></ehr:dic></td>
				<th>本人电话号码</th>
				<td>${womanDiseaseCensus.phoneNumber}</td>
			</tr>
			<tr>
				<th>职业类别</th>
				<td><ehr:dic code="${womanDiseaseCensus.occupation}" dicmeta="GBT6565"></ehr:dic></td>
				<th>工作单位名称</th>
				<td>${womanDiseaseCensus.unitName}</td>
			</tr>
			<tr>
				<th>文化程度</th>
				<td><ehr:dic code="${womanDiseaseCensus.education}" dicmeta="GBT46582006"></ehr:dic></td>
				<th>婚姻状况类别</th>
				<td><ehr:dic code="${womanDiseaseCensus.marriage}" dicmeta="GBT226122003"></ehr:dic></td>
			</tr>
			<tr>
				<th>身份证件类别</th>
				<td><ehr:dic code="${womanDiseaseCensus.idcardType}" dicmeta="CV0201101"></ehr:dic></td>
				<th>身份证件号码</th>
				<td>${womanDiseaseCensus.idCard}</td>
			</tr>
			<tr>
				<th>户籍地址</th>
				<td colspan="3"><c:out value="${womanDiseaseCensus.hrprovince}"></c:out>
					<c:out value="${womanDiseaseCensus.hrcity}"></c:out> 
					<c:out value="${womanDiseaseCensus.hrcounty}"></c:out> 
					<c:out value="${womanDiseaseCensus.hrtownShip}"></c:out> 
					<c:out value="${womanDiseaseCensus.hrstreet}"></c:out> 
					<c:out value="${womanDiseaseCensus.hrhouseNumber}"></c:out>
				</td>
			</tr>
			<tr>
				<th>户籍地址邮政编码</th>
				<td colspan="3"><c:out value="${womanDiseaseCensus.hrpostCode}"></c:out>
				</td>
			</tr>
			<tr>
				<th>居住住址</th>
				<td colspan="3"><c:out value="${womanDiseaseCensus.paprovince}"></c:out>
					<c:out value="${womanDiseaseCensus.pacity}"></c:out> 
					<c:out value="${womanDiseaseCensus.pacounty}"></c:out> 
					<c:out value="${womanDiseaseCensus.patownShip}"></c:out> 
					<c:out value="${womanDiseaseCensus.pastreet}"></c:out> 
					<c:out value="${womanDiseaseCensus.pahouseNumber}"></c:out>
				</td>
			</tr>
			<tr>
				<th>现住址邮政编码</th>
				<td colspan="3"><c:out value="${womanDiseaseCensus.papostCode}"></c:out></td>
			</tr>
			<tr>
				<th>性交出血史</th>
				<td colspan="3">${womanDiseaseCensus.coitalBleedingHistory}</td>
			</tr>
			<tr>
				<th>妊娠合并症/并发症史</th>
				<td colspan="3">${womanDiseaseCensus.complicationHistory}</td>
			</tr>
			<tr>
				<th>既往疾病史</th>
				<td colspan="3">${womanDiseaseCensus.pastMedicalHistory}</td>
			</tr>
			<tr>
				<th>家族肿瘤史
				<td colspan="3">${womanDiseaseCensus.familyCancerHistory}</td>
			</tr>
			<tr>
				<th>妇科及乳腺不适症状</th>
				<td colspan="3"><ehr:dic code="${womanDiseaseCensus.gBdiscomfortCode}" dicmeta="CV0401001"></ehr:dic>
				</td>
			</tr>
			<tr>
				<th>心率(次/分钟)</th>
				<td colspan="3">
					<c:out value="${womanDiseaseCensus.heartRate}"></c:out>
				</td>
			</tr>
			<tr>
				<th>舒张压(mmHg)</th>
				<td><c:out value="${womanDiseaseCensus.dbp}"></c:out></td>
				<th>收缩压(mmHg)</th>
				<td><c:out value="${womanDiseaseCensus.sbp}"></c:out></td>
			</tr>
			<tr>
				<th>初潮年龄(岁)</th>
				<td><c:out value="${womanDiseaseCensus.menarcheAge}"></c:out></td>
				<th>月经持续时间(d)</th>
				<td><c:out value="${womanDiseaseCensus.menstrualDuration}"></c:out>
				</td>
			</tr>
			<tr>
				<th>月经周期(d)</th>
				<td><c:out value="${womanDiseaseCensus.menstrualCycle}"></c:out>
				</td>
				<th>月经出血量</th>
				<td><ehr:dic code="${womanDiseaseCensus.menstrualBleedingType}"
						dicmeta="FS10028"></ehr:dic></td>
			</tr>
			<tr>
				<th>末次月经日期</th>
				<td colspan="3"><fmt:formatDate value="${womanDiseaseCensus.lastMenstrualDate}" pattern="yyyy/MM/dd" /></td>
			</tr>
			<tr>
				<th>绝经标志</th>
				<td
					<c:if test='${womanDiseaseCensus.menopauseFlag ne "1"}'>  colspan="3" </c:if>>
                    <c:if test="${!empty womanDiseaseCensus.menopauseFlag}">
					    <c:out value='${womanDiseaseCensus.menopauseFlag eq "1" ? "是" : "否"}'></c:out>
                    </c:if>
				</td>
				<c:if test='${womanDiseaseCensus.menopauseFlag eq "1"}'>
					<th>手术绝经标志</th>
					<td>
                        <c:if test="${!empty womanDiseaseCensus.operationMenopauseFlag}">
                            <c:out value='${womanDiseaseCensus.operationMenopauseFlag eq "1" ? "是" : "否"}'></c:out>
                        </c:if>
                    </td>
				</c:if>
			</tr>
			<tr>
				<th>绝经年龄(岁)</th>
				<td colspan="3"><c:out value="${womanDiseaseCensus.menopauseAge}"></c:out></td>
			</tr>
			<tr>
				<th>孕次</th>
				<td><c:out value="${womanDiseaseCensus.gravidityTimes}"></c:out>
				</td>
				<th>产次</th>
				<td><c:out value="${womanDiseaseCensus.productionTimes}"></c:out>
				</td>
			</tr>
			<tr>
				<th>人工流产次数</th>
				<td><c:out value="${womanDiseaseCensus.artificialAbortionTimes}"></c:out></td>
				<th>自然流产次数</th>
				<td><c:out value="${womanDiseaseCensus.spontaneousAbortionTimes}"></c:out></td>
			</tr>
			<tr>
				<th>剖宫产次数</th>
				<td><c:out value="${womanDiseaseCensus.cesareanSectionTimes}"></c:out>
				</td>
				<th>阴道助产次数</th>
				<td><c:out value="${womanDiseaseCensus.vaginaDeliveryTimes}"></c:out>
				</td>
			</tr>
			<tr>
				<th>死胎例数</th>
				<td><c:out value="${womanDiseaseCensus.stillbirthCasesNumber}"></c:out>
				</td>
				<th>死产例数</th>
				<td><c:out value="${womanDiseaseCensus.stillbornCasesNumber}"></c:out>
				</td>
			</tr>
			<tr>
				<th>出生缺陷儿例数</th>
				<td colspan="3"><c:out value="${womanDiseaseCensus.birthDefectsNumber}"></c:out></td>
			</tr>
			<tr>
				<th>末次妊娠终止日期</th>
				<td><fmt:formatDate value="${womanDiseaseCensus.lastPregnancyEndDate}" pattern="yyyy/MM/dd" /></td>
				<th>末次妊娠终止方式</th>
				<td><ehr:dic code="${womanDiseaseCensus.lastPregnancyWay}"
						dicmeta="CV0210002"></ehr:dic></td>
			</tr>
			<tr>
				<th>末次分娩日期</th>
				<td><fmt:formatDate value="${womanDiseaseCensus.lastDeliveryDate}"  pattern="yyyy/MM/dd" /></td>
				<th>末次分娩方式</th>
				<td><ehr:dic code="${womanDiseaseCensus.lastPregnancyWay}"
						dicmeta="CV0210003"></ehr:dic></td>
			</tr>
			<tr>
				<th>避孕方式</th>
				<td colspan="3"><ehr:dic
						code="${womanDiseaseCensus.contraceptiveWay}" dicmeta="CV0600211"></ehr:dic>
				</td>
			</tr>
			<tr>
				<th>左侧附件检查结果</th>
				<td><ehr:dic code="${womanDiseaseCensus.lAttachmentCheckResult}" dicmeta="CV0410001"></ehr:dic></td>
				<th>右侧附件检查结果</th>
				<td><ehr:dic code="${womanDiseaseCensus.rAttachmentCheckResult}" dicmeta="CV0410001"></ehr:dic></td>
			</tr>
			<tr>
				<th>外阴检查结果</th>
				<td colspan="3"><c:out
						value="${womanDiseaseCensus.vulvaCheckResult}"></c:out></td>
			</tr>
			<tr>
				<th>阴道检查结果</th>
				<td colspan="3"><c:out
						value="${womanDiseaseCensus.vaginaCheckResult}"></c:out></td>
			</tr>
			<tr>
				<th>宫颈检查结果</th>
				<td colspan="3"><c:out
						value="${womanDiseaseCensus.cervixCheckResult}"></c:out></td>
			</tr>
			<tr>
				<th>子宫检查结果</th>
				<td colspan="3"><c:out
						value="${womanDiseaseCensus.uterusCheckResult}"></c:out></td>
			</tr>
			<tr>
				<th>左侧乳腺检查结果</th>
				<td><ehr:dic code="${womanDiseaseCensus.lBreastCheckResult}"
						dicmeta="CV0410012"></ehr:dic></td>
				<th>右侧乳腺检查结果</th>
				<td><ehr:dic code="${womanDiseaseCensus.rBreastCheckResult}"
						dicmeta="CV0410012"></ehr:dic></td>
			</tr>
			<tr>
				<th>阴道细胞学诊断结果</th>
				<td><ehr:dic code="${womanDiseaseCensus.vaginaDiagnosisResult}"
						dicmeta="CV0450011"></ehr:dic></td>
				<th>阴道分泌物清洁度</th>
				<td><ehr:dic
						code="${womanDiseaseCensus.vaginaSecretionsCleanliness}"
						dicmeta="CV0450010"></ehr:dic></td>
			</tr>
			<tr>
				<th>念珠菌检测结果</th>
				<td><ehr:dic code="${womanDiseaseCensus.candidaDetectResult}"
						dicmeta="FS10044"></ehr:dic></td>
				<th>梅毒血清学试验结果</th>
				<td><ehr:dic code="${womanDiseaseCensus.syphilisSerologyCheckResult}"
						dicmeta="FS10058"></ehr:dic>
				</td>
			</tr>
			<tr>
				<th>乳腺X线检查结果</th>
				<td colspan="3">${womanDiseaseCensus.breastXCheckResult}</td>
			</tr>
			<tr>
				<th>乳腺B超检查结果</th>
				<td colspan="3">${womanDiseaseCensus.breastBCheckResult}</td>
			</tr>
			<tr>
				<th>阴道镜检查结果</th>
				<td colspan="3">${womanDiseaseCensus.colposcopyCheckResult}</td>
			</tr>
			<tr>
				<th>滴虫检测结果</th>
				<td colspan="3">${womanDiseaseCensus.trichomoDetectResult}</td>
			</tr>
			<tr>
				<th>淋球菌检查结果</th>
				<td colspan="3">${womanDiseaseCensus.nGonorrhoeaeCheckResult}</td>
			</tr>
			<tr>
				<th>体检结果</th>
				<td colspan="3">${womanDiseaseCensus.examinationResult}</td>
			</tr>
			<tr>
				<th>处理及指导意见</th>
				<td colspan="3">${womanDiseaseCensus.mgOpinion}</td>
			</tr>
			<tr>
				<th>主检医师姓名</th>
				<td colspan="3">${womanDiseaseCensus.masterDoctorName}</td>
			</tr>
			<tr>
				<th>检查(测)日期</th>
				<td><fmt:formatDate value="${womanDiseaseCensus.checkDate}" pattern="yyyy/MM/dd"/> </td>
				<th>检查(测)人员姓名</th>
				<td>${womanDiseaseCensus.checkName}</td>
			</tr>
			<tr>
				<th>检查(测)机构名称</th>
				<td colspan="3">${womanDiseaseCensus.checkOrganName}</td>
			</tr>
		</table>
	</div>
</div>