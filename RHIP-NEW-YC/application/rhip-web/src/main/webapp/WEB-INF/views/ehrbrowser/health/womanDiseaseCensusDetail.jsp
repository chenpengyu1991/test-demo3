<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/views/ehrbrowser/basic/basic.css" />

<div style="background-color: white; height: 515px;">
	<ul>
		<li style="text-align: center; font-size: 25px;">妇女病普查</li>
	</ul>
	<br />
	<div class="table-basic">
		<table class="layui-table x-admin-sm-table-list-small">
			<colgroup>
				<col style="width: 20%;" />
				<col style="width: 30%;" />
				<col style="width: 20%;" />
				<col style="width: 30%;" />
			</colgroup>
			<tr>
				<th>姓名</th>
				<td>${detailInfo.name}</td>
				<th>出生日期</th>
				<td><fmt:formatDate value="${detailInfo.birthday}" pattern="yyyy/MM/dd" /></td>
			</tr>
			<tr>
				<th>民族</th>
				<td><span><ehr:dic code="${detailInfo.nation}" dicmeta="GBT3304"></ehr:dic></span></td>
				<th>本人电话号码</th>
				<td>${detailInfo.phoneNumber}</td>
			</tr>
			<tr>
				<th>职业类别</th>
				<td><span><ehr:dic code="${detailInfo.occupation}" dicmeta="GBT6565"></ehr:dic></span></td>
				<th>工作单位名称</th>
				<td>${detailInfo.unitName}</td>
			</tr>
			<tr>
				<th>文化程度</th>
				<td><span><ehr:dic code="${detailInfo.education}" dicmeta="GBT46582006"></ehr:dic></span></td>
				<th>婚姻状况类别</th>
				<td><span><ehr:dic code="${detailInfo.marriage}" dicmeta="GBT226122003"></ehr:dic></span></td>
			</tr>
			<tr>
				<th>身份证件类别</th>
				<td><span><ehr:dic code="${detailInfo.idcardType}" dicmeta="CV0201101"></ehr:dic></span></td>
				<th>身份证件号码</th>
				<td>${detailInfo.idCard}</td>
			</tr>
			<tr>
				<th>户籍地址</th>
				<td colspan="3"><c:out value="${detailInfo.hrprovince}"></c:out>
					<c:out value="${detailInfo.hrcity}"></c:out>
					<c:out value="${detailInfo.hrcounty}"></c:out>
					<c:out value="${detailInfo.hrtownShip}"></c:out>
					<c:out value="${detailInfo.hrstreet}"></c:out>
					<c:out value="${detailInfo.hrhouseNumber}"></c:out>
				</td>
			</tr>
			<tr>
				<th>户籍地址邮政编码</th>
				<td colspan="3"><c:out value="${detailInfo.hrpostCode}"></c:out>
				</td>
			</tr>
			<tr>
				<th>居住住址</th>
				<td colspan="3"><c:out value="${detailInfo.paprovince}"></c:out>
					<c:out value="${detailInfo.pacity}"></c:out>
					<c:out value="${detailInfo.pacounty}"></c:out>
					<c:out value="${detailInfo.patownShip}"></c:out>
					<c:out value="${detailInfo.pastreet}"></c:out>
					<c:out value="${detailInfo.pahouseNumber}"></c:out>
				</td>
			</tr>
			<tr>
				<th>现住址邮政编码</th>
				<td colspan="3"><c:out value="${detailInfo.papostCode}"></c:out></td>
			</tr>
			<tr>
				<th>性交出血史</th>
				<td colspan="3">${detailInfo.coitalBleedingHistory}</td>
			</tr>
			<tr>
				<th>妊娠合并症/并发症史</th>
				<td colspan="3">${detailInfo.complicationHistory}</td>
			</tr>
			<tr>
				<th>既往疾病史</th>
				<td colspan="3">${detailInfo.pastMedicalHistory}</td>
			</tr>
			<tr>
				<th>家族肿瘤史
				<td colspan="3">${detailInfo.familyCancerHistory}</td>
			</tr>
			<tr>
				<th>妇科及乳腺不适症状</th>
				<td colspan="3"><span><ehr:dic code="${detailInfo.gBdiscomfortCode}" dicmeta="CV0401001"></ehr:dic></span>
				</td>
			</tr>
			<tr>
				<th>心率(次/分钟)</th>
				<td colspan="3">
					<c:out value="${detailInfo.heartRate}"></c:out>
				</td>
			</tr>
			<tr>
				<th>舒张压(mmHg)</th>
				<td><c:out value="${detailInfo.dbp}"></c:out></td>
				<th>收缩压(mmHg)</th>
				<td><c:out value="${detailInfo.sbp}"></c:out></td>
			</tr>
			<tr>
				<th>初潮年龄(岁)</th>
				<td><c:out value="${detailInfo.menarcheAge}"></c:out></td>
				<th>月经持续时间(d)</th>
				<td><c:out value="${detailInfo.menstrualDuration}"></c:out>
				</td>
			</tr>
			<tr>
				<th>月经周期(d)</th>
				<td><c:out value="${detailInfo.menstrualCycle}"></c:out>
				</td>
				<th>月经出血量</th>
				<td><span><ehr:dic code="${detailInfo.menstrualBleedingType}" dicmeta="FS10028"></ehr:dic></span></td>
			</tr>
			<tr>
				<th>末次月经日期</th>
				<td colspan="3"><fmt:formatDate value="${detailInfo.lastMenstrualDate}" pattern="yyyy/MM/dd" /></td>
			</tr>
			<tr>
				<th>绝经标志</th>
				<td<c:if test='${detailInfo.menopauseFlag ne "1"}'>  colspan="3" </c:if>>
					<c:if test="${!empty detailInfo.menopauseFlag}">
						<c:out value='${detailInfo.menopauseFlag eq "1" ? "是" : "否"}'></c:out>
					</c:if>
				</td>
				<c:if test='${detailInfo.menopauseFlag eq "1"}'>
					<th>手术绝经标志</th>
					<td>
						<c:if test="${!empty detailInfo.operationMenopauseFlag}">
							<c:out value='${detailInfo.operationMenopauseFlag eq "1" ? "是" : "否"}'></c:out>
						</c:if>
					</td>
				</c:if>
			</tr>
			<tr>
				<th>绝经年龄(岁)</th>
				<td colspan="3"><c:out value="${detailInfo.menopauseAge}"></c:out></td>
			</tr>
			<tr>
				<th>孕次</th>
				<td><c:out value="${detailInfo.gravidityTimes}"></c:out>
				</td>
				<th>产次</th>
				<td><c:out value="${detailInfo.productionTimes}"></c:out>
				</td>
			</tr>
			<tr>
				<th>人工流产次数</th>
				<td><c:out value="${detailInfo.artificialAbortionTimes}"></c:out></td>
				<th>自然流产次数</th>
				<td><c:out value="${detailInfo.spontaneousAbortionTimes}"></c:out></td>
			</tr>
			<tr>
				<th>剖宫产次数</th>
				<td><c:out value="${detailInfo.cesareanSectionTimes}"></c:out>
				</td>
				<th>阴道助产次数</th>
				<td><c:out value="${detailInfo.vaginaDeliveryTimes}"></c:out>
				</td>
			</tr>
			<tr>
				<th>死胎例数</th>
				<td><c:out value="${detailInfo.stillbirthCasesNumber}"></c:out>
				</td>
				<th>死产例数</th>
				<td><c:out value="${detailInfo.stillbornCasesNumber}"></c:out>
				</td>
			</tr>
			<tr>
				<th>出生缺陷儿例数</th>
				<td colspan="3"><c:out value="${detailInfo.birthDefectsNumber}"></c:out></td>
			</tr>
			<tr>
				<th>末次妊娠终止日期</th>
				<td><fmt:formatDate value="${detailInfo.lastPregnancyEndDate}" pattern="yyyy/MM/dd" /></td>
				<th>末次妊娠终止方式</th>
				<td><span><ehr:dic code="${detailInfo.lastPregnancyWay}" dicmeta="CV0210002"></ehr:dic></span></td>
			</tr>
			<tr>
				<th>末次分娩日期</th>
				<td><fmt:formatDate value="${detailInfo.lastDeliveryDate}"  pattern="yyyy/MM/dd" /></td>
				<th>末次分娩方式</th>
				<td><span><ehr:dic code="${detailInfo.lastDeliveryWay}" dicmeta="CV0210003"></ehr:dic></span></td>
			</tr>
			<tr>
				<th>避孕方式</th>
				<td colspan="3"><span><ehr:dic code="${detailInfo.contraceptiveWay}" dicmeta="CV0600211"></ehr:dic></span>
				</td>
			</tr>
			<tr>
				<th>左侧附件检查结果</th>
				<td><span><ehr:dic code="${detailInfo.lAttachmentCheckResult}" dicmeta="CV0410001"></ehr:dic></span></td>
				<th>右侧附件检查结果</th>
				<td><span><ehr:dic code="${detailInfo.rAttachmentCheckResult}" dicmeta="CV0410001"></ehr:dic></span></td>
			</tr>
			<tr>
				<th>外阴检查结果</th>
				<td colspan="3"><c:out value="${detailInfo.vulvaCheckResult}"></c:out></td>
			</tr>
			<tr>
				<th>阴道检查结果</th>
				<td colspan="3"><c:out value="${detailInfo.vaginaCheckResult}"></c:out></td>
			</tr>
			<tr>
				<th>宫颈检查结果</th>
				<td colspan="3"><c:out value="${detailInfo.cervixCheckResult}"></c:out></td>
			</tr>
			<tr>
				<th>子宫检查结果</th>
				<td colspan="3"><c:out value="${detailInfo.uterusCheckResult}"></c:out></td>
			</tr>
			<tr>
				<th>左侧乳腺检查结果</th>
				<td><span><ehr:dic code="${detailInfo.lBreastCheckResult}" dicmeta="CV0410012"></ehr:dic></span></td>
				<th>右侧乳腺检查结果</th>
				<td><span><ehr:dic code="${detailInfo.rBreastCheckResult}" dicmeta="CV0410012"></ehr:dic></span></td>
			</tr>
			<tr>
				<th>阴道细胞学诊断结果</th>
				<td><span><ehr:dic code="${detailInfo.vaginaDiagnosisResult}" dicmeta="CV0450011"></ehr:dic></span></td>
				<th>阴道分泌物清洁度</th>
				<td><span><ehr:dic code="${detailInfo.vaginaSecretionsCleanliness}" dicmeta="CV0450010"></ehr:dic></span></td>
			</tr>
			<tr>
				<th>念珠菌检测结果</th>
				<td><span><ehr:dic code="${detailInfo.candidaDetectResult}" dicmeta="FS10044"></ehr:dic></span></td>
				<th>梅毒血清学试验结果</th>
				<td><span><ehr:dic code="${detailInfo.syphilisSerologyCheckResult}" dicmeta="FS10058"></ehr:dic></span>
				</td>
			</tr>
			<tr>
				<th>乳腺X线检查结果</th>
				<td colspan="3">${detailInfo.breastXCheckResult}</td>
			</tr>
			<tr>
				<th>乳腺B超检查结果</th>
				<td colspan="3">${detailInfo.breastBCheckResult}</td>
			</tr>
			<tr>
				<th>阴道镜检查结果</th>
				<td colspan="3">${detailInfo.colposcopyCheckResult}</td>
			</tr>
			<tr>
				<th>滴虫检测结果</th>
				<td colspan="3"><span><ehr:dic code="${detailInfo.trichomoDetectResult}" dicmeta="FS10045"></ehr:dic></span></td>
			</tr>
			<tr>
				<th>淋球菌检查结果</th>
				<td colspan="3">${detailInfo.nGonorrhoeaeCheckResult}</td>
			</tr>
			<tr>
				<th>体检结果</th>
				<td colspan="3">${detailInfo.examinationResult}</td>
			</tr>
			<tr>
				<th>处理及指导意见</th>
				<td colspan="3">${detailInfo.mgOpinion}</td>
			</tr>
			<tr>
				<th>主检医师姓名</th>
				<td colspan="3">${detailInfo.masterDoctorName}</td>
			</tr>
			<tr>
				<th>检查(测)日期</th>
				<td><fmt:formatDate value="${detailInfo.checkDate}" pattern="yyyy/MM/dd"/> </td>
				<th>检查(测)人员姓名</th>
				<td>${detailInfo.checkName}</td>
			</tr>
			<tr>
				<th>检查(测)机构名称</th>
				<td colspan="3">${detailInfo.checkOrganName}</td>
			</tr>
		</table>
	</div>
</div>