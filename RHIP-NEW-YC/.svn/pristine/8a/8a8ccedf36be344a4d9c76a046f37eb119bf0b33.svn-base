<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/views/ehrbrowser/basic/basic.css" />
<div>
	<span style="float: left;">姓名: <c:out value="${whPrenatalFollowup.name}"></c:out></span>
	<span style="float: right;padding-right: 25px;">编号: <c:out value="${whPrenatalFollowup.recordNumber}"></c:out></span>
</div>
<div class="table-basic">
	<table class="layui-table x-admin-sm-table-list-small">
		<colgroup>
			<col style="width: 16%">
			<col style="width: 16%">
			<col style="width: 16%">
			<col style="width: 16%">
			<col style="width: 16%">
			<col style="width: 16%">
		</colgroup>
	
		<tr>
			<th>填表日期</th>
			<td colspan="2"><fmt:formatDate value="${whPrenatalFollowup.inputDate}"></fmt:formatDate></td>
			<th>填表孕周</th>
			<td colspan="2"><c:out value="${whPrenatalFollowup.gestationalWeeks}"></c:out>周</td>
		</tr>
		<tr>
			<th>丈夫姓名</th>
			<td><c:out value="${whPrenatalFollowup.husbandName}"></c:out></td>
			<th>丈夫出生日期</th>
			<td><fmt:formatDate value="${whPrenatalFollowup.husbandBirthday}"></fmt:formatDate></td>
			<th>丈夫电话号码</th>
			<td><c:out value="${whPrenatalFollowup.husbandPhone}"></c:out></td>
		</tr>
		<tr>
			<th>孕次</th>
			<td colspan="2"><c:out value="${whPrenatalFollowup.gravidityTimes}"></c:out></td>
			<th>产次</th>
			<td colspan="2"><c:out value="${whPrenatalFollowup.productionTimes}"></c:out></td>
		</tr>
		<tr>
			<th>末次月经日期</th>
			<td><fmt:formatDate value="${whPrenatalFollowup.lastMenstrualDate}"></fmt:formatDate></td>
			<th>预产期</th>
			<td colspan="3"><fmt:formatDate value="${whPrenatalFollowup.estimatedDueDates}"></fmt:formatDate></td>
		</tr>
		<tr>
			<th>既往史</th>
			<td colspan="5"><c:out value="${whPrenatalFollowup.pastMedicalHistory}"></c:out></td>
		</tr>
		<tr>
			<th>妇科手术史</th>
			<td colspan="5">
				<c:if test="${whPrenatalFollowup.surgeryHistoryFlag eq 0}">无&nbsp;&nbsp;&nbsp;</c:if>
				<c:if test="${whPrenatalFollowup.surgeryHistoryFlag eq 1}">有&nbsp;&nbsp;&nbsp;</c:if>
				<c:out value="${whPrenatalFollowup.surgeryHistoryFlag}"></c:out>
			</td>
		</tr>
		<tr>
			<th>孕产史</th>
			<td colspan="5">
				流产例数：<c:out value="${whPrenatalFollowup.abortionTimes}"></c:out> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				死胎例数：<c:out value="${whPrenatalFollowup.stillbirthCasesNumber}"></c:out> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				死产例数：<c:out value="${whPrenatalFollowup.stillbornCasesNumber}"></c:out> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				新生儿死亡例数：<c:out value="${whPrenatalFollowup.neonatalDeathNumber}"></c:out> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			</td>
		</tr>
		<tr>
			<th>身高</th>
			<td colspan="2"><c:out value="${whPrenatalFollowup.height}"></c:out>cm</td>
			<th>体重</th>
			<td colspan="2"><c:out value="${whPrenatalFollowup.bodyWeight}"></c:out>kg</td>
		</tr>
		<tr>
			<th>体质指数</th>
			<td colspan="2"><c:out value="${whPrenatalFollowup.bodyMassIndex}"></c:out></td>
			<th>血压</th>
			<td colspan="2">
				<c:out value="${whPrenatalFollowup.sbp}"></c:out> ~ <c:out value="${whPrenatalFollowup.dbp}"></c:out> mmHg
			</td>
		</tr>
		<tr>
			<th>听诊</th>
			<td colspan="2">
				心脏：
				<c:if test="${whPrenatalFollowup.cardiacAuscAnomalyFLAG eq 0}">无异常&nbsp;&nbsp;&nbsp;</c:if>
				<c:if test="${whPrenatalFollowup.cardiacAuscAnomalyFLAG eq 1}">异常&nbsp;&nbsp;&nbsp;</c:if>
				<c:out value="${whPrenatalFollowup.cardiacAuscAnomalyDESC}"></c:out>
			</td>
			<td colspan="3">
				肺部：
				<c:if test="${whPrenatalFollowup.lungAuscAnomalyDESC eq 0}">无异常&nbsp;&nbsp;&nbsp;</c:if>
				<c:if test="${whPrenatalFollowup.lungAuscAnomalyDESC eq 1}">异常&nbsp;&nbsp;&nbsp;</c:if>
				<c:out value="${whPrenatalFollowup.lungAuscAnomalyDESC}"></c:out>
			</td>
		</tr>
		<tr>
			<th rowspan="3">妇科检查</th>
			<td colspan="2">
				外阴：
				<c:if test="${whPrenatalFollowup.vulvaAnomalyFlag eq 0}">无异常&nbsp;&nbsp;&nbsp;</c:if>
				<c:if test="${whPrenatalFollowup.vulvaAnomalyFlag eq 1}">异常&nbsp;&nbsp;&nbsp;</c:if>
				<c:out value="${whPrenatalFollowup.vulvaAnomalyDesc}"></c:out>
			</td>
			<td colspan="3">
				阴道：
				<c:if test="${whPrenatalFollowup.vaginaAnomalyFlag eq 0}">无异常&nbsp;&nbsp;&nbsp;</c:if>
				<c:if test="${whPrenatalFollowup.vaginaAnomalyFlag eq 1}">异常&nbsp;&nbsp;&nbsp;</c:if>
				<c:out value="${whPrenatalFollowup.vaginaAnomalyDesc}"></c:out>
			</td>
		</tr>
		<tr>
			<td colspan="2">
				宫颈：
				<c:if test="${whPrenatalFollowup.cervicalAnomalyFlag eq 0}">无异常&nbsp;&nbsp;&nbsp;</c:if>
				<c:if test="${whPrenatalFollowup.cervicalAnomalyFlag eq 1}">异常&nbsp;&nbsp;&nbsp;</c:if>
				<c:out value="${whPrenatalFollowup.cervicalAnomalyDesc}"></c:out>
			</td>
			<td colspan="3">
				宫体：
				<c:if test="${whPrenatalFollowup.corpusAnomalyFlag eq 0}">无异常&nbsp;&nbsp;&nbsp;</c:if>
				<c:if test="${whPrenatalFollowup.corpusAnomalyFlag eq 1}">异常&nbsp;&nbsp;&nbsp;</c:if>
				<c:out value="${whPrenatalFollowup.corpusAnomalyDesc}"></c:out>
			</td>
		</tr>
		<tr>
			<td colspan="5">
				附件：
				<c:if test="${whPrenatalFollowup.accessoriesAnomalyFlag eq 0}">无异常&nbsp;&nbsp;&nbsp;</c:if>
				<c:if test="${whPrenatalFollowup.accessoriesAnomalyFlag eq 1}">异常&nbsp;&nbsp;&nbsp;</c:if>
				<c:out value="${whPrenatalFollowup.accessoriesAnomalyDesc}"></c:out>
			</td>
		</tr>
		<tr>
			<th rowspan="7">辅助检查</th>
			<td colspan="1">血常规</td>
			<td colspan="4">
				血红蛋白值<c:out value="${whPrenatalFollowup.hemoglobinValue}"></c:out> g/L &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				白细胞计数值<c:out value="${whPrenatalFollowup.leukocyteCount}"></c:out> /L &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<br/>
				血小板计数值<c:out value="${whPrenatalFollowup.plateletCount}"></c:out> /L &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				其他<c:out value="${whPrenatalFollowup.otherBloodRoutine}"></c:out> /L &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			</td>
		</tr>
		<tr>
			<td colspan="1">尿常规</td>
			<td colspan="4">
				尿蛋白<c:out value="${whPrenatalFollowup.urineProQuantitativeVALUE}"></c:out> g/L &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				尿糖<c:out value="${whPrenatalFollowup.urineSugQuantitativeDETECT}"></c:out> /L &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<br/>
				其他<c:out value="${whPrenatalFollowup.otherUrineRoutines}"></c:out> /L &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			</td>
		</tr>
		<tr>
			<td colspan="1">肝功能</td>
			<td colspan="4">
				血清谷丙转氨酶<c:out value="${whPrenatalFollowup.serumGptValue}"></c:out> U/L &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				血清谷草转氨酶<c:out value="${whPrenatalFollowup.serumAstValue}"></c:out> U/L &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<br/>
				白蛋白<c:out value="${whPrenatalFollowup.albuminConcentration}"></c:out> g/L &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				总胆红素值<c:out value="${whPrenatalFollowup.totalBilirubin}"></c:out> μ mol/L &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<br/>
				总胆红素值<c:out value="${whPrenatalFollowup.conjugatedBilirubiN}"></c:out> μ mol/L
			</td>
		</tr>
		<tr>
			<td colspan="1">肾功能</td>
			<td colspan="4">
				血肌酐值<c:out value="${whPrenatalFollowup.creatinine}"></c:out> μ mol/L &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				血尿素氮<c:out value="${whPrenatalFollowup.bloodUreaNitrogenVALUES}"></c:out> mmol/L &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<br/>
			</td>
		</tr>
		<tr>
			<td colspan="1">阴道分泌物</td>
			<td colspan="4">
				<ehr:dic code="${whPrenatalFollowup.vaginaSecretionsCheckRESULT}" dicmeta="CV0450019"></ehr:dic>
			</td>
		</tr>
		<tr>
			<td colspan="1">梅毒血清学试验</td>
			<td colspan="4">
				<ehr:dic code="${whPrenatalFollowup.syphilisSerologyCheckRESULT}" dicmeta="FS10058"></ehr:dic>
			</td>
		</tr>
		<tr>
			<td colspan="1">HIV抗体检测</td>
			<td colspan="4">
				<ehr:dic code="${whPrenatalFollowup.hivlgDetectResult}" dicmeta="FS10056"></ehr:dic>
			</td>
		</tr>
		<tr>
			<th>总体评价</th>
			<td colspan="5">
				<c:if test="${whPrenatalFollowup.healthAnomalyFlag eq 0}">无异常&nbsp;&nbsp;&nbsp;</c:if>
				<c:if test="${whPrenatalFollowup.healthAnomalyFlag eq 1}">异常&nbsp;&nbsp;&nbsp;</c:if>
				<c:out value="${whPrenatalFollowup.healthAnomalyDesc}"></c:out>
			</td>
		</tr>
		<tr>
			<th>转诊</th>
			<td colspan="6">
				<c:if test="${whPrenatalFollowup.healthAnomalyFlag eq 0}">无&nbsp;&nbsp;&nbsp;</c:if>
				<c:if test="${whPrenatalFollowup.healthAnomalyFlag eq 1}">有&nbsp;&nbsp;&nbsp;</c:if> <br/>
				原因：<c:out value="${whPrenatalFollowup.referralReason}"></c:out> <br/>
				机构及科室：<c:out value="${whPrenatalFollowup.referralDeptName}"></c:out> 
			</td>
		</tr><tr>
			<th>下次随访日期</th>
			<td colspan="2"><fmt:formatDate value="${whPrenatalFollowup.nextSupervisionDate}"></fmt:formatDate></td>
			<th>随访医生签名</th>
			<td colspan="2"><c:out value="${whPrenatalFollowup.supervisionDoctor}"></c:out></td>
		</tr>
	</table>
</div>